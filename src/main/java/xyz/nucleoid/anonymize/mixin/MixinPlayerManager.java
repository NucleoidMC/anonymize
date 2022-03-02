package xyz.nucleoid.anonymize.mixin;

import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.server.PlayerManager;

@Mixin(PlayerManager.class)
public class MixinPlayerManager {

	@Redirect(method = "onPlayerConnect", at = @At(target = "Lorg/slf4j/Logger;info(Ljava/lang/String;[Ljava/lang/Object;)V", value = "INVOKE"))
	private void hideIP(Logger logger, String message, Object[] arguments) {
		arguments[1] = "hidden ip";
		logger.info(message, arguments);
	}
}
