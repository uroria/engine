package com.uroria.engine.chat;

import com.uroria.engine.player.PlayerSpace;
import net.kyori.adventure.audience.Audience;


public interface Chat extends Audience, PlayerSpace {

    void close();

    String getId();

}
