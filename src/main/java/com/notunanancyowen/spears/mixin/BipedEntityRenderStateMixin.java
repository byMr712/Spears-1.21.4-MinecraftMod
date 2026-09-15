package com.notunanancyowen.spears.mixin;

import com.notunanancyowen.spears.dataholders.SpearEntityRenderState;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(BipedEntityRenderState.class)
public class BipedEntityRenderStateMixin implements SpearEntityRenderState {
    @Unique private ItemStack spears$mainHandStack = ItemStack.EMPTY;
    @Unique private ItemStack spears$offHandStack = ItemStack.EMPTY;
    @Unique private int spears$itemUseTimeLeft = 0;
    @Unique private float spears$lastKineticAttackTime = 0.0F;

    @Override public ItemStack spears$getMainHandStack() { return spears$mainHandStack; }
    @Override public void spears$setMainHandStack(ItemStack stack) { this.spears$mainHandStack = stack != null ? stack : ItemStack.EMPTY; }

    @Override public ItemStack spears$getOffHandStack() { return spears$offHandStack; }
    @Override public void spears$setOffHandStack(ItemStack stack) { this.spears$offHandStack = stack != null ? stack : ItemStack.EMPTY; }

    @Override public int spears$getItemUseTimeLeft() { return spears$itemUseTimeLeft; }
    @Override public void spears$setItemUseTimeLeft(int ticks) { this.spears$itemUseTimeLeft = ticks; }

    @Override public float spears$getLastKineticAttackTime() { return spears$lastKineticAttackTime; }
    @Override public void spears$setLastKineticAttackTime(float time) { this.spears$lastKineticAttackTime = time; }
}
