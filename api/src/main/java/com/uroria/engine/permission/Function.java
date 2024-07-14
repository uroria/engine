package com.uroria.engine.permission;

import lombok.NonNull;

@FunctionalInterface
public interface Function {

    Function ALWAYS_TRUE = ignored -> State.TRUE;

    Function ALWAYS_FALSE = ignored -> State.FALSE;

    Function ALWAYS_UNSET = ignored -> State.UNSET;

    State getPermission(@NonNull String node);
}
