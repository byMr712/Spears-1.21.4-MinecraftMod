package com.notunanancyowen.spears.mixin;

import com.notunanancyowen.spears.Spears;
import com.notunanancyowen.spears.components.SwingAnimation;
import com.notunanancyowen.spears.dataholders.SpearEntityRenderState;
import net.minecraft.client.render.entity.model.AbstractZombieModel;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractZombieModel.class)
public abstract class ZombieEntityModelMixin {
    @Inject(method = "setAngles(Lnet/minecraft/client/render/entity/state/ZombieEntityRenderState;)V", at = @At("HEAD"), cancellable = true)
    private void isUsingASpear(ZombieEntityRenderState state, CallbackInfo ci) {
        if(state instanceof SpearEntityRenderState access) {
            ItemStack stack = access.spears$getMainHandStack();
            if(stack != null && stack.get(Spears.SWING_ANIMATION) instanceof SwingAnimation s && s.swingType().equals("stab")) {
                ci.cancel();
            }
        }
    }
}
