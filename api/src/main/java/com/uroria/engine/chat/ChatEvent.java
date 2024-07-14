package com.uroria.engine.chat;

import com.uroria.engine.events.DeniableEvent;
import com.uroria.engine.events.DeniableResult;
import com.uroria.engine.player.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import net.kyori.adventure.text.Component;

@Getter
@AllArgsConstructor
public final class ChatEvent implements DeniableEvent {
    private final Player sender;
    private final Chat chat;
    @NonNull @Setter
    private Component message;
    private DeniableResult result;

    @Override
    public void setResult(@NonNull DeniableResult result) {
        this.result = result;
    }

    @Override
    public DeniableResult getResult() {
        return this.result;
    }
}
