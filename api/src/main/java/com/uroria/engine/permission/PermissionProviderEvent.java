package com.uroria.engine.permission;

import com.uroria.engine.events.DeniableEvent;
import com.uroria.engine.events.DeniableResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@AllArgsConstructor
public final class PermissionProviderEvent implements DeniableEvent {
    private final PermissionSubject subject;
    @NonNull @Setter
    private PermissionProvider provider;
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
