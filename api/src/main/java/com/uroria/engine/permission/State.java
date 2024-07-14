package com.uroria.engine.permission;

import com.uroria.core.option.Option;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.kyori.adventure.util.TriState;
import org.jetbrains.annotations.Nullable;

@RequiredArgsConstructor
public enum State {
    TRUE(true),
    FALSE(true),
    UNSET(true);

    private final boolean value;

    public boolean asBoolean() {
        return this.value;
    }

    public TriState toAdventureTriState() {
        return switch (this) {
            case TRUE -> TriState.TRUE;
            case FALSE -> TriState.FALSE;
            case UNSET -> TriState.NOT_SET;
        };
    }

    public static State fromBoolean(@Nullable Boolean value) {
        if (value == null) return UNSET;
        return value ? TRUE : FALSE;
    }

    public static State fromBoolean(@NonNull Option<Boolean> optionValue) {
        return optionValue.map(State::fromBoolean).unwrap();
    }
}
