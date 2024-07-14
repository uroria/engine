package com.uroria.engine.permission;

import lombok.NonNull;

@FunctionalInterface
public interface PermissionProvider {

    Function createFunction(@NonNull PermissionSubject subject);

}
