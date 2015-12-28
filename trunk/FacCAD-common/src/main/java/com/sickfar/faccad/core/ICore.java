package com.sickfar.faccad.core;

import com.sickfar.faccad.module.AbstractModule;
import com.sickfar.faccad.module.ModuleException;

import java.util.Map;

public interface ICore {

    public <T extends AbstractModule> T getModuleInstance(Class<T> moduleClass) throws ModuleException;

    public Object request(String step, Map<String, String> requestParameters) throws ModuleException;

}
