package xyz.nucleoid.anonymize.mixin;

import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.server.PlayerManager;

@Mixin(PlayerManager.class)
public class MixinPlayerManager {

	@Redirect(method = "onPlayerConnect", at = @At(target = "Lorg/apache/logging/log4j/Logger;info(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", value = "INVOKE"))
	private void hideIP(Logger logger, String message, Object name, Object ip, Object id, Object x, Object y, Object z) {
		logger.info(message, name, "hidden ip", id, x, y, z);
	}
}
