package com.uroria.engine.localization;

import com.uroria.core.localization.Translation;
import net.kyori.adventure.title.Title;
import org.jetbrains.annotations.NotNull;

record LocalizedTitleImpl(Translation title, Translation subtitle, Title.Times times) implements LocalizedTitle {

    @Override
    public @NotNull Translation title() {
        return this.title;
    }

    @Override
    public @NotNull Translation subtitle() {
        return this.subtitle;
    }

    @Override
    public Title.Times times() {
        return this.times;
    }
}
