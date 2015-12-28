package com.sickfar.faccad.core;

import com.sickfar.faccad.module.AbstractModule;
import com.sickfar.faccad.module.ModuleException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author sickfar
 */
public class ModuleManager {
    private Map<Class<? extends AbstractModule>, AbstractModule> moduleInstances = new HashMap<>();

    public ModuleManager() {
    }

    public <T extends AbstractModule> T getModuleInstance(final Class<T> moduleClass) throws ModuleException {
        if (moduleClass == null) throw new ModuleException("null class", ModuleException.ACCESS);
        try {
            if (!moduleInstances.containsKey(moduleClass)) {
                moduleInstances.put(moduleClass, moduleClass.newInstance());
            }
            return (T) moduleInstances.get(moduleClass);
        } catch (Exception e) {
            throw new ModuleException(e, ModuleException.INSTANTIATION);
        }
    }
}
