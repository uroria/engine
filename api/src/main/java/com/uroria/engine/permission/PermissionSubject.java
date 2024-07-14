package com.uroria.engine.permission;

import net.kyori.adventure.permission.PermissionChecker;
import org.jetbrains.annotations.Nullable;

public interface PermissionSubject {

    default boolean hasPermission(@Nullable String node) {
        return getPermission(node).asBoolean();
    }

    State getPermission(@Nullable String node);

    default PermissionChecker getPermissionChecker() {
        return permission -> getPermission(permission).toAdventureTriState();
    }
}
