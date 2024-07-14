package com.uroria.engine.player;

import com.uroria.engine.command.CommandSource;
import net.kyori.adventure.identity.Identified;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.event.HoverEventSource;

import java.util.Locale;

public interface Player extends CommandSource, Identified, HoverEventSource<HoverEvent.ShowEntity> {

    String getUsername();

    Locale getLocale();

    default void test() {

    }

}
