package com.sickfar.faccad.core;

import com.sickfar.faccad.module.AbstractModule;
import com.sickfar.faccad.module.ModuleException;

import java.util.Map;

public class Core implements ICore {

    private ModuleManager moduleManager = new ModuleManager();
    private ProjectManager projectManager = new ProjectManager();

    private static Core instance = new Core();

    public static Core getInstance() {
        return instance;
    }

    private Core() {
        CoreDelegate.getInstance().initCoreInstance(this);
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }

    public ProjectManager getProjectManager() {
        return projectManager;
    }

    @Override
    public <T extends AbstractModule> T getModuleInstance(Class<T> moduleClass) throws ModuleException {
        return moduleManager.getModuleInstance(moduleClass);
    }

    @Override
    public Object request(String step, Map<String, String> requestParameters) throws ModuleException {
        return getModuleInstance(projectManager.getActiveProject().getModuleForStep(step)).request(requestParameters);
    }
}
