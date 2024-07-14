package com.uroria.engine;

import com.uroria.core.localization.Translation;
import com.uroria.core.option.Option;
import com.uroria.engine.chat.Chat;
import com.uroria.engine.events.EventManager;
import com.uroria.engine.player.PlayerSpace;

import java.util.Collection;

public interface Engine extends PlayerSpace {

    Chat openChat();

    Option<Chat> getChat(String id);

    Collection<Chat> getChats();
    
    default void shutdown() {
        shutdown(null);
    }
    
    void shutdown(Translation reason);
    
    EventManager getEventManager();
}
