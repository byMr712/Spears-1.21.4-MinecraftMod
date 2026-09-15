package com.notunanancyowen.spears.mixin;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.util.Arm;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BipedEntityModel.class)
public abstract class BipedEntityModelMixin<T extends BipedEntityRenderState> extends EntityModel<T> {
    public BipedEntityModelMixin(ModelPart root) {
        super(root);
    }

    @Shadow @Final public ModelPart rightArm;
    @Shadow @Final public ModelPart body;
    @Shadow @Final public ModelPart leftArm;
    @Shadow @Final public ModelPart head;
    @Shadow protected abstract ModelPart getArm(Arm arm);

    @Inject(method = "positionRightArm", at = @At("HEAD"), cancellable = true)
    private void rightArmSpear(T state, BipedEntityModel.ArmPose armPose, CallbackInfo ci) {
        if(!armPose.isTwoHanded() || state.handSwingProgress > 0F) {
            if(spears$handleSpearAnimationPerArm(state, Arm.RIGHT) && !state.isUsingItem && state.handSwingProgress > 0F) ci.cancel();
        }
    }

    @Inject(method = "positionLeftArm", at = @At("HEAD"), cancellable = true)
    private void leftArmSpear(T state, BipedEntityModel.ArmPose armPose, CallbackInfo ci) {
        if(!armPose.isTwoHanded() || state.handSwingProgress > 0F) {
            if(spears$handleSpearAnimationPerArm(state, Arm.LEFT) && !state.isUsingItem && state.handSwingProgress > 0F) ci.cancel();
        }
    }

    @Unique private boolean spears$handleSpearAnimationPerArm(T state, Arm arm) {
        var usedArm = getArm(arm);
        usedArm.yaw = -0.1F * head.yaw;
        usedArm.pitch = (-(float)Math.PI / 2F) + head.pitch + 0.8F;
        if(state.isGliding || state.leaningPitch > 0.0F) usedArm.pitch -= 0.9599311F;
        return true;
    }

    @Inject(method = "animateArms", at = @At("HEAD"), cancellable = true)
    private void addSpearAnimation(T state, float animationProgress, CallbackInfo ci) {
        if(state.handSwingProgress > 0.0F) {
            float f = state.handSwingProgress;
            Arm arm = state.mainArm;
            rightArm.yaw -= body.yaw;
            leftArm.yaw -= body.yaw;
            leftArm.pitch -= body.yaw;
            float g = -(MathHelper.cos(((float)Math.PI * MathHelper.clamp(MathHelper.getLerpProgress(f, 0.0F, 0.05F), 0.0F, 1.0F))) - 1.0F) / 2.0F;
            float h = MathHelper.clamp(MathHelper.getLerpProgress(f, 0.05F, 0.2F), 0.0F, 1.0F);
            h *= h;
            float i = MathHelper.clamp(MathHelper.getLerpProgress(f, 0.4F, 1.0F), 0.0F, 1.0F);
            if(i < 0.5F) i = i == 0.0F ? 0.0F : (float)(Math.pow(2.0F, (double)20.0F * (double)i - (double)10.0F) / (double)2.0F);
            else i = i == 1.0F ? 1.0F : (float)(((double)2.0F - Math.pow(2.0F, (double)-20.0F * (double)i + (double)10.0F)) / (double)2.0F);
            getArm(arm).pitch += (90.0F * g - 120.0F * h + 30.0F * i) * ((float)Math.PI / 180F);
        }
    }
}
