
package com.github.thenwkos.chunchunmaru.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import com.github.thenwkos.chunchunmaru.procedures.MaruFoodEatenProcedure;
import com.github.thenwkos.chunchunmaru.itemgroup.ChunItemGroup;
import com.github.thenwkos.chunchunmaru.ChunchunmaruModElements;

@ChunchunmaruModElements.ModElement.Tag
public class MaruItem extends ChunchunmaruModElements.ModElement {
	@ObjectHolder("chunchunmaru:maru")
	public static final Item block = null;
	public MaruItem(ChunchunmaruModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ChunItemGroup.tab).maxStackSize(64).rarity(Rarity.EPIC)
					.food((new Food.Builder()).hunger(666).saturation(666f).meat().build()));
			setRegistryName("maru");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 37;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("It taste's like a cat?"));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				MaruFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
