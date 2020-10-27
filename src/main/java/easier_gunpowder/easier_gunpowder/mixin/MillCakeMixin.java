package easier_gunpowder.easier_gunpowder.mixin;


import easier_gunpowder.easier_gunpowder.EasierGunpowder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tag.FluidTags;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class MillCakeMixin extends Entity {

    public MillCakeMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow public abstract ItemStack getStack();

    @Shadow public abstract void setStack(ItemStack stack);

    @Shadow public abstract int getAge();

    @Inject(at = @At("TAIL"), method = "tick")
    private void tick(CallbackInfo info) {
        if (!world.isClient) {
            if (this.getStack().getItem() == EasierGunpowder.CRUSHED_CHARCOAL && this.isSubmergedIn(FluidTags.WATER)) {
                ItemStack NewMillCake = new ItemStack(EasierGunpowder.MILL_CAKE, this.getStack().getCount());
                this.setStack(new ItemStack(Items.GUNPOWDER, 0));
                this.dropStack(NewMillCake);
            }

            if (this.getAge() > 200 & this.getStack().getItem() == EasierGunpowder.MILL_CAKE & !this.isSubmergedIn(FluidTags.WATER)) {
                ItemStack gunStack = new ItemStack(Items.GUNPOWDER, this.getStack().getCount()*2);

                this.dropStack(gunStack);
                this.setStack(new ItemStack(Items.GUNPOWDER, 0));
            }
        }
    }
}
