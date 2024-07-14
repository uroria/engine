package com.uroria.engine.localization;

import com.uroria.core.localization.Translation;
import lombok.NonNull;
import net.kyori.adventure.bossbar.BossBar;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

//TODO impl

public class LocalizedBossBarImpl implements LocalizedBossBar {
    private Translation translation;


    @Override
    public @NotNull Translation translation() {
        return this.translation;
    }

    @Override
    public @NotNull LocalizedBossBar translation(@NonNull Translation translation) {
        this.translation = translation;
        return this;
    }

    @Override
    public float progress() {
        return 0;
    }

    @Override
    public LocalizedBossBar progress(float progress) {
        return null;
    }

    @Override
    public BossBar.Color color() {
        return null;
    }

    @Override
    public LocalizedBossBar color(BossBar.@NonNull Color color) {
        return null;
    }

    @Override
    public BossBar.Overlay overlay() {
        return null;
    }

    @Override
    public LocalizedBossBar overlay(BossBar.@NonNull Overlay overlay) {
        return null;
    }

    @Override
    public Set<BossBar.Flag> flags() {
        return Set.of();
    }

    @Override
    public LocalizedBossBar flags(@NonNull Set<BossBar.Flag> flags) {
        return null;
    }

    @Override
    public LocalizedBossBar addFlag(BossBar.@NonNull Flag flag) {
        return null;
    }

    @Override
    public LocalizedBossBar removeFlag(BossBar.@NonNull Flag flag) {
        return null;
    }

    @Override
    public LocalizedBossBar addFlags(@NotNull BossBar.@NonNull Flag... flags) {
        return null;
    }

    @Override
    public LocalizedBossBar removeFlags(@NotNull BossBar.@NonNull Flag... flags) {
        return null;
    }

    @Override
    public LocalizedBossBar addListener(BossBar.@NonNull Listener listener) {
        return null;
    }

    @Override
    public LocalizedBossBar removeListener(BossBar.@NonNull Listener listener) {
        return null;
    }
}
