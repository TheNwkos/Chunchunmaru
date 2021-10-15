
package com.github.thenwkos.chunchunmaru.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;

import java.util.List;

import com.github.thenwkos.chunchunmaru.itemgroup.ChunItemGroup;
import com.github.thenwkos.chunchunmaru.ChunchunmaruModElements;

@ChunchunmaruModElements.ModElement.Tag
public class ObessedWithYouItem extends ChunchunmaruModElements.ModElement {
	@ObjectHolder("chunchunmaru:obessed_with_you")
	public static final Item block = null;
	public ObessedWithYouItem(ChunchunmaruModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, ChunchunmaruModElements.sounds.get(new ResourceLocation("chunchunmaru:obsessed-with-you")),
					new Item.Properties().group(ChunItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("obessed_with_you");
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Obessed With You By BlackShadow441"));
		}
	}
}
