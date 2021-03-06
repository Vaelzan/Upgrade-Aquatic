package com.teamabnormals.upgrade_aquatic.client.render;

import com.teamabnormals.upgrade_aquatic.client.model.ModelGoose;
import com.teamabnormals.upgrade_aquatic.common.entities.EntityGoose;
import com.teamabnormals.upgrade_aquatic.core.util.Reference;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GooseRenderer extends MobRenderer<EntityGoose, ModelGoose<EntityGoose>> {

	public GooseRenderer(EntityRendererManager manager) {
		super(manager, new ModelGoose<>(), 0.45F);
	}
	
	@Override
	public ResourceLocation getEntityTexture(EntityGoose entity) {
		return new ResourceLocation(Reference.MODID, "textures/entity/goose.png");
	}
	
	@Override
	protected float handleRotationFloat(EntityGoose livingBase, float partialTicks) {
		float f = MathHelper.lerp(partialTicks, livingBase.oFlap, livingBase.wingRotation);
		float f1 = MathHelper.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.destPos);
		return (MathHelper.sin(f) + 1.0F) * f1;
	}
}