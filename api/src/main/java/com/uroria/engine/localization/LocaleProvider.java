package com.uroria.engine.localization;

import com.uroria.engine.player.Player;
import lombok.NonNull;

@FunctionalInterface
public interface LocaleProvider {

    Function createFunction(@NonNull Player player);

}
