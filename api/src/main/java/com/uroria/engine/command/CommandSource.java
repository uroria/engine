package com.uroria.engine.command;

import com.uroria.engine.localization.LocalizedAudience;
import com.uroria.engine.permission.PermissionSubject;
import net.kyori.adventure.audience.Audience;

public interface CommandSource extends LocalizedAudience, PermissionSubject, Audience {

}
