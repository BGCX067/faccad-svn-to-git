package com.sickfar.faccad.core;

import com.sickfar.faccad.module.AbstractModule;
import com.sickfar.faccad.module.ModuleException;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author sickfar
 */
public final class CoreDelegate implements ICore {
    ICore coreInstance = null;

    private static CoreDelegate ourInstance = new CoreDelegate();

    public static CoreDelegate getInstance() {
        return ourInstance;
    }

    private CoreDelegate() {
    }

    @Override
    public <T extends AbstractModule> T getModuleInstance(Class<T> moduleClass) throws ModuleException {
        return coreInstance.getModuleInstance(moduleClass);
    }

    @Override
    public Object request(String step, Map<String, String> requestParameters) throws ModuleException {
        return coreInstance.request(step, requestParameters);
    }

    protected void initCoreInstance(ICore coreInstance) {
        this.coreInstance = coreInstance;
    }
}
