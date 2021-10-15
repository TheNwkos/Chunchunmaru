
package com.github.thenwkos.chunchunmaru.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import com.github.thenwkos.chunchunmaru.item.ObessedWithYouItem;
import com.github.thenwkos.chunchunmaru.ChunchunmaruModElements;

@ChunchunmaruModElements.ModElement.Tag
public class ChunItemGroup extends ChunchunmaruModElements.ModElement {
	public ChunItemGroup(ChunchunmaruModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabchun") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ObessedWithYouItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
