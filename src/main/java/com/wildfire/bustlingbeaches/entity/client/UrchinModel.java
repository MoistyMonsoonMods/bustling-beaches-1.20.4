package com.wildfire.bustlingbeaches.entity.client;


import com.wildfire.bustlingbeaches.entity.custom.UrchinEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class UrchinModel<T extends UrchinEntity> extends SinglePartEntityModel<T> {
	private final ModelPart Body;


	public UrchinModel(ModelPart root) {
		this.Body = root.getChild("Body");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Body = modelPartData.addChild("Body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, -6.0F, -3.5F, 7.0F, 6.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 21.5F, 0.0F));

		ModelPartData Bottom_Spines04_r1 = Body.addChild("Bottom_Spines04_r1", ModelPartBuilder.create().uv(14, 0).mirrored().cuboid(-5.0F, 0.0F, -3.5F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		ModelPartData Bottom_Spines03_r1 = Body.addChild("Bottom_Spines03_r1", ModelPartBuilder.create().uv(24, 0).cuboid(0.0F, 0.0F, -3.5F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		ModelPartData Bottom_Spines02_r1 = Body.addChild("Bottom_Spines02_r1", ModelPartBuilder.create().uv(9, 19).cuboid(-3.5F, 0.0F, 0.0F, 7.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 3.5F, -0.5236F, 0.0F, 0.0F));

		ModelPartData Bottom_Spines01_r1 = Body.addChild("Bottom_Spines01_r1", ModelPartBuilder.create().uv(-5, 19).cuboid(-3.5F, 0.0F, -5.0F, 7.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -3.5F, 0.5236F, 0.0F, 0.0F));

		ModelPartData Middle_Spines04_r1 = Body.addChild("Middle_Spines04_r1", ModelPartBuilder.create().uv(28, 13).cuboid(-6.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-3.5F, -3.0F, 3.5F, 0.0F, 0.7854F, 0.0F));

		ModelPartData Middle_Spines03_r1 = Body.addChild("Middle_Spines03_r1", ModelPartBuilder.create().uv(28, 7).cuboid(0.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, -3.0F, -3.5F, 0.0F, 0.7854F, 0.0F));

		ModelPartData Middle_Spines02_r1 = Body.addChild("Middle_Spines02_r1", ModelPartBuilder.create().uv(28, 7).mirrored().cuboid(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.5F, -3.0F, 3.5F, 0.0F, 0.7854F, 0.0F));

		ModelPartData Middle_Spines01_r1 = Body.addChild("Middle_Spines01_r1", ModelPartBuilder.create().uv(28, 1).cuboid(0.0F, -3.0F, -6.0F, 0.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.5F, -3.0F, -3.5F, 0.0F, 0.7854F, 0.0F));

		ModelPartData Top_Spines04_r1 = Body.addChild("Top_Spines04_r1", ModelPartBuilder.create().uv(5, 24).mirrored().cuboid(-6.0F, 0.0F, -3.5F, 6.0F, 0.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.5F, -6.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		ModelPartData Top_Spines03_r1 = Body.addChild("Top_Spines03_r1", ModelPartBuilder.create().uv(-7, 24).cuboid(0.0F, 0.0F, -3.5F, 6.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, -6.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData Top_Spines02_r1 = Body.addChild("Top_Spines02_r1", ModelPartBuilder.create().uv(8, 13).mirrored().cuboid(-3.5F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -6.0F, 3.5F, 0.7854F, 0.0F, 0.0F));

		ModelPartData Top_Spines01_r1 = Body.addChild("Top_Spines01_r1", ModelPartBuilder.create().uv(-6, 13).mirrored().cuboid(-3.5F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -6.0F, -3.5F, -0.7854F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 32);
	}
	@Override
	public void setAngles(UrchinEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return Body;
	}
}