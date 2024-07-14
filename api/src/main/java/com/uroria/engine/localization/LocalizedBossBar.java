package com.uroria.engine.localization;

import com.uroria.core.localization.Translation;
import lombok.NonNull;
import net.kyori.adventure.bossbar.BossBar;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public interface LocalizedBossBar {

    @NotNull
    Translation translation();

    @NotNull
    LocalizedBossBar translation(@NonNull Translation translation);

    float progress();

    LocalizedBossBar progress(float progress);

    BossBar.Color color();

    LocalizedBossBar color(@NonNull BossBar.Color color);

    BossBar.Overlay overlay();

    LocalizedBossBar overlay(@NonNull BossBar.Overlay overlay);

    Set<BossBar.Flag> flags();

    LocalizedBossBar flags(@NonNull Set<BossBar.Flag> flags);

    LocalizedBossBar addFlag(@NonNull BossBar.Flag flag);

    LocalizedBossBar removeFlag(@NonNull BossBar.Flag flag);

    LocalizedBossBar addFlags(@NonNull BossBar.Flag... flags);

    LocalizedBossBar removeFlags(@NonNull BossBar.Flag... flags);

    LocalizedBossBar addListener(@NonNull BossBar.Listener listener);

    LocalizedBossBar removeListener(@NonNull BossBar.Listener listener);
}
