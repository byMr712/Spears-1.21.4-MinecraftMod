package com.notunanancyowen.spears.mixin;

import net.minecraft.client.render.entity.model.AbstractZombieModel;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractZombieModel.class)
public abstract class ZombieEntityModelMixin {
    @Inject(method = "setAngles(Lnet/minecraft/client/render/entity/state/ZombieEntityRenderState;)V", at = @At("HEAD"), cancellable = true)
    private void isUsingASpear(ZombieEntityRenderState state, CallbackInfo ci) {
        if(state.handSwingProgress > 0F) {
            // Handled by BipedEntityModelMixin
        }
    }
}
