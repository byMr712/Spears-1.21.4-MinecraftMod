package com.notunanancyowen.spears.mixin;

import com.notunanancyowen.spears.dataholders.SpearEntityRenderState;
import com.notunanancyowen.spears.dataholders.SpearUser;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BipedEntityRenderer.class)
public class BipedEntityRendererMixin<T extends MobEntity, S extends BipedEntityRenderState> {
    @Inject(method = "updateRenderState(Lnet/minecraft/entity/mob/MobEntity;Lnet/minecraft/client/render/entity/state/BipedEntityRenderState;F)V", at = @At("TAIL"))
    private void updateSpearRenderState(T entity, S state, float tickDelta, CallbackInfo ci) {
        if (state instanceof SpearEntityRenderState access) {
            access.spears$setMainHandStack(entity.getMainHandStack());
            access.spears$setOffHandStack(entity.getOffHandStack());
            access.spears$setItemUseTimeLeft(entity.getItemUseTimeLeft());
            if (entity instanceof SpearUser user) {
                access.spears$setLastKineticAttackTime(user.getTimeSinceLastKineticAttack(tickDelta));
            }
        }
    }
}
