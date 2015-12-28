package com.sickfar.faccad.core;

import com.sickfar.faccad.project.Project;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: sickfar
 * Date: 03.03.13
 * Time: 21:53
 * To change this template use File | Settings | File Templates.
 */
public class ProjectManager {
    private Map<String, Project> openedProjects = new LinkedHashMap<>();

    private Project activeProject;

    public void setActiveProject(Project activeProject) {
        this.activeProject = activeProject;
        this.activeProject.activated();
    }

    public Project getActiveProject() {
        return activeProject;
    }

    public void addProject(Project project) {
        openedProjects.put(project.getName(), project);
        setActiveProject(project);
    }

}
