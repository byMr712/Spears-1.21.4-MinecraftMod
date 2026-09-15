package com.notunanancyowen.spears.mixin;

import net.minecraft.client.render.entity.model.PiglinEntityModel;
import net.minecraft.client.render.entity.state.PiglinEntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PiglinEntityModel.class)
public abstract class PiglinEntityModelMixin {
    @Inject(method = "rotateMainArm", at = @At("HEAD"), cancellable = true)
    private void stabWithSpear(PiglinEntityRenderState state, CallbackInfo ci) {
        if(state.handSwingProgress > 0F) ci.cancel();
    }
}
