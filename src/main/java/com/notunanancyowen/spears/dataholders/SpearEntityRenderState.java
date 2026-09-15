package com.notunanancyowen.spears.dataholders;

import net.minecraft.item.ItemStack;

public interface SpearEntityRenderState {
    ItemStack spears$getMainHandStack();
    void spears$setMainHandStack(ItemStack stack);

    ItemStack spears$getOffHandStack();
    void spears$setOffHandStack(ItemStack stack);

    int spears$getItemUseTimeLeft();
    void spears$setItemUseTimeLeft(int ticks);

    float spears$getLastKineticAttackTime();
    void spears$setLastKineticAttackTime(float time);
}
