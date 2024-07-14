package com.uroria.engine.module;

import com.uroria.core.option.Option;

import java.util.Collection;

public interface ModuleManager {

    Option<Module> getModule(String id);

    Collection<Module> getModules();

}
