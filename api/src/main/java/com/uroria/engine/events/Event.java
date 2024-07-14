package com.uroria.engine.events;

import lombok.NonNull;

public interface Event<R extends Result> {

    void setResult(@NonNull R result);

    R getResult();

}
