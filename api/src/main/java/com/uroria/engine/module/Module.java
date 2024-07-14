package com.uroria.engine.module;

import java.util.Collection;

public interface Module {

    String getName();

    String getLicense();

    Collection<String> getAuthors();

    String getUrl();

    Collection<Dependency> getDependencies();
}
