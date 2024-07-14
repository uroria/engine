package com.uroria.engine.player;

import com.uroria.core.localization.Translation;
import com.uroria.core.option.Option;
import lombok.NonNull;

import java.util.Collection;
import java.util.UUID;

public interface PlayerSpace {

    void kickPlayer(@NonNull Player player, Translation message);

    Option<Player> getPlayer(String username);

    Option<Player> getPlayer(UUID uuid);

    Collection<Player> getPlayers();

}
