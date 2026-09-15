package com.notunanancyowen.spears.mixin;

import com.notunanancyowen.spears.dataholders.SpearEntityRenderState;
import com.notunanancyowen.spears.dataholders.SpearUser;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityRenderer.class)
public class PlayerEntityRendererMixin {
    @Inject(method = "updateRenderState(Lnet/minecraft/client/network/AbstractClientPlayerEntity;Lnet/minecraft/client/render/entity/state/PlayerEntityRenderState;F)V", at = @At("TAIL"))
    private void updateSpearPlayerRenderState(AbstractClientPlayerEntity player, PlayerEntityRenderState state, float tickDelta, CallbackInfo ci) {
        if (state instanceof SpearEntityRenderState access) {
            access.spears$setMainHandStack(player.getMainHandStack());
            access.spears$setOffHandStack(player.getOffHandStack());
            access.spears$setItemUseTimeLeft(player.getItemUseTimeLeft());
            if (player instanceof SpearUser user) {
                access.spears$setLastKineticAttackTime(user.getTimeSinceLastKineticAttack(tickDelta));
            }
        }
    }
}
