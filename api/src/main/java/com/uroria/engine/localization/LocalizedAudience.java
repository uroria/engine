package com.uroria.engine.localization;

import com.uroria.core.localization.Translation;
import lombok.NonNull;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import net.kyori.adventure.title.Title;

public interface LocalizedAudience extends Audience {

    default void sendMessage(@NonNull String message) {
        sendMessage(MiniMessage.miniMessage().deserialize(message));
    }

    default void sendMessage(@NonNull String message, TagResolver... resolvers) {
        sendMessage(MiniMessage.miniMessage().deserialize(message, resolvers));
    }

    default void sendPlainMessage(@NonNull String message) {
        sendMessage(Component.text(message));
    }

    void sendMessage(@NonNull Translation translation);

    void sendMessage(@NonNull Translation translation, TagResolver... resolvers);

    void sendActionBar(@NonNull Translation translation);

    void sendActionBar(@NonNull Translation translation, TagResolver... resolvers);

    void sendPlayerListHeader(@NonNull Translation translation, TagResolver... resolvers);

    void sendPlayerListFooter(@NonNull Translation translation, TagResolver... resolvers);

    void sendPlayerList(@NonNull Translation headerTranslation, @NonNull Translation footerTranslation, TagResolver... resolvers);

    void showTitle(@NonNull LocalizedTitle title);

    void showBossBar(@NonNull LocalizedBossBar bossBar);

    void hideBossBar(@NonNull LocalizedBossBar bossBar);




}
