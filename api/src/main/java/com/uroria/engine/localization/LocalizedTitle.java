package com.uroria.engine.localization;

import com.uroria.core.localization.Translation;
import lombok.NonNull;
import net.kyori.adventure.title.Title;
import org.jetbrains.annotations.NotNull;

public interface LocalizedTitle {

    static @NotNull LocalizedTitle title(@NonNull Translation title, @NonNull Translation subtitle) {
        return title(title, subtitle, Title.DEFAULT_TIMES);
    }

    static @NotNull LocalizedTitle title(@NonNull Translation title, @NonNull Translation subtitle, @NonNull Title.Times times) {
        return new LocalizedTitleImpl(title, subtitle, times);
    }

    @NotNull
    Translation title();

    @NotNull
    Translation subtitle();

    Title.Times times();

}
