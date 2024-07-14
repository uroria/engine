package com.uroria.engine.localization;

import com.uroria.core.option.Option;

import java.util.Locale;

@FunctionalInterface
public interface Function {

    Locale getLocale(Option<Locale> effectiveLocale);
}
