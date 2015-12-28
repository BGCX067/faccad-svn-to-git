package com.sickfar.faccad.project;

import com.sickfar.faccad.core.CoreDelegate;
import com.sickfar.faccad.core.DocumentationFactory;
import com.sickfar.faccad.documentation.AbstractProjectDocumentation;
import com.sickfar.faccad.logging.Log;
import com.sickfar.faccad.module.AbstractModule;
import com.sickfar.faccad.module.ModuleException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public final class Project<T extends AbstractProjectDocumentation> {

    private Map<Class<? extends AbstractModule>, ProjectDataItem> projectData = new HashMap<Class<? extends AbstractModule>, ProjectDataItem>();
    private File projectDirectory;
    File projectFile = new File(projectDirectory, ".faccad");
    private Class<T> documentationClass;
    private T documentation;
    private Properties projectProperties = new Properties();
    private Map<String, Class<? extends AbstractModule>> stepMapping;
    private String name;

    public String getName() {
        return name;
    }

    private void createProperties() throws IOException {
        projectProperties.setProperty("project.documentation.class", documentationClass.getName());
        for (String step : stepMapping.keySet()) {
            projectProperties.setProperty("project.documentation.step." + step, stepMapping.get(step).getName());
        }
        //TODO: add more properties
        projectProperties.storeToXML(new FileOutputStream(projectFile), "FacCAD Project File");
    }

    private void applyPropertires() throws Exception {
        documentationClass = (Class<T>) Class.forName(projectProperties.getProperty("project.documentation.class"));
        documentation = DocumentationFactory.getInstance().getDocumentation(documentationClass);
        projectProperties.stringPropertyNames();
        stepMapping = new LinkedHashMap<>();
        for (String step : documentation.getSteps()) {
            try {
                stepMapping.put(step, (Class<? extends AbstractModule>) Class.forName(projectProperties.getProperty("project.documentation.step." + step)));
            } catch (Exception e) {
                Log.error(e);
            }
        }
    }

    public Project(File projectDirectory) {
        this.projectDirectory = projectDirectory;
    }

    public Project(File projectDirectory, String name) {
        this.projectDirectory = projectDirectory;
        this.name = name;
    }

    public Project<T> create(Class<T> documentationClass, Map<String, Class<? extends AbstractModule>> stepMapping) throws IOException {
        this.documentationClass = documentationClass;
        documentation = DocumentationFactory.getInstance().getDocumentation(documentationClass);
        this.stepMapping = stepMapping;
        if (projectDirectory.exists() && projectDirectory.isDirectory())
            throw new IOException("Directory already exists");
        projectDirectory.mkdirs();
        projectFile = new File(projectDirectory, ".faccad");
        projectFile.createNewFile();
        createProperties();

        return this;
    }

    public Project open() throws Exception {
        if (!projectDirectory.exists() && !projectDirectory.isDirectory())
            throw new IOException("Project directory not found");
        if (!projectFile.exists() && !projectFile.isFile()) throw new IOException("Project file not found");
        projectProperties.load(new FileInputStream(projectFile));
        applyPropertires();

        return this;
    }

    public ProjectDataItem getDataItem(Class<? extends AbstractModule> moduleClass) {
        return projectData.get(moduleClass);
    }

    public String[] getDocumentationSteps() {
        return documentation.getSteps();
    }

    public String getDocumentationStep(int i) {
        return documentation.getSteps()[i];
    }

    public Class<? extends AbstractModule> getModuleForStep(String step) {
        return stepMapping.get(step);
    }

    public void activated() {
        for (Class<? extends AbstractModule> module : stepMapping.values()) {
            try {
                CoreDelegate.getInstance().getModuleInstance(module).switchProject(this);
            } catch (ModuleException e) {
                Log.error("Something was wrong during updating modules", e);
            }
        }
    }

}
