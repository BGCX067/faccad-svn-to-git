package com.sickfar.faccad.module;

import com.sickfar.faccad.annotation.AnnotationHelper;
import com.sickfar.faccad.annotation.NoPossibleUpdateMethodsAnnotatedException;
import com.sickfar.faccad.annotation.Update;
import com.sickfar.faccad.project.Project;
import com.sickfar.faccad.project.ProjectDataItem;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

public abstract class AbstractModule {

    protected AbstractModule() throws IllegalAccessException {
        boolean signatureIsOk = false;
        for (StackTraceElement e : Thread.getAllStackTraces().get(Thread.currentThread())) {
            if (e.getMethodName().equals("getModuleInstance") && e.getClassName().equals("com.sickfar.faccad.core.Core")) {
                signatureIsOk = true;
                break;
            }
        }
        if (!signatureIsOk)
            throw new IllegalAccessException("AbstractModule can be instantiated only form Core.getModuleInstance()");
    }

    public abstract String getModuleID();

    public abstract Object request(Map<String, String> request);

    private final Collection watchers = new HashSet();

    private Project project;

    protected <T extends ProjectDataItem> T data() {
        return (T) project.getDataItem(this.getClass());
    }

    public final void switchProject(Project project) {
        this.project = project;
        updateData();
    }

    public final void updateData() {
        for (Object watcher : watchers) {
            for (Method updateMethod : AnnotationHelper.getAnnotatedMethods(watcher, Update.class)) {
                try {
                    updateMethod.invoke(watcher);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void registerWatcher(Object watcher) throws NoPossibleUpdateMethodsAnnotatedException {
        if (AnnotationHelper.getAnnotatedMethods(watcher, Update.class).length == 0)
            throw new NoPossibleUpdateMethodsAnnotatedException();
        watchers.add(watcher);
    }
}
