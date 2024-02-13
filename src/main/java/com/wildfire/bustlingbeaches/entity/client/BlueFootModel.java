package com.wildfire.bustlingbeaches.entity.client;


import com.wildfire.bustlingbeaches.entity.custom.BlueFootEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class BlueFootModel<T extends BlueFootEntity> extends SinglePartEntityModel<T> {
	private final ModelPart BlueFoot;
	private final ModelPart Head;

	public BlueFootModel(ModelPart root) {
		this.BlueFoot = root.getChild("BlueFoot");
		this.Head = BlueFoot.getChild("Body").getChild("Neck").getChild("Head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData BlueFoot = modelPartData.addChild("BlueFoot", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Body = BlueFoot.addChild("Body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -3.0F, 0.0F));

		ModelPartData Body_r1 = Body.addChild("Body_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -5.0F, -5.0F, 6.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		ModelPartData Neck = Body.addChild("Neck", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -5.0F, -3.25F));

		ModelPartData Neck_r1 = Neck.addChild("Neck_r1", ModelPartBuilder.create().uv(0, 20).cuboid(-1.5F, -6.0F, 0.0F, 3.0F, 6.0F, 3.0F, new Dilation(-0.001F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		ModelPartData Head = Neck.addChild("Head", ModelPartBuilder.create().uv(0, 13).cuboid(-1.5F, -3.0F, -4.0F, 3.0F, 3.0F, 4.0F, new Dilation(0.0F))
		.uv(8, 25).cuboid(-0.5F, -2.0F, -8.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, 4.5F));

		ModelPartData Tail = Body.addChild("Tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -3.25F, 4.8F));

		ModelPartData Tail_r1 = Tail.addChild("Tail_r1", ModelPartBuilder.create().uv(16, 13).cuboid(-2.0F, 0.0F, 0.0F, 4.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		ModelPartData Wing_Right = Body.addChild("Wing_Right", ModelPartBuilder.create().uv(12, 13).cuboid(-1.0F, -2.5F, 0.0F, 1.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -3.25F, -1.85F, -0.4363F, 0.0F, 0.0F));

		ModelPartData Wing_Right_Tip = Wing_Right.addChild("Wing_Right_Tip", ModelPartBuilder.create().uv(18, 18).cuboid(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 2.5F, 7.0F, 1.1345F, 0.0F, 0.0F));

		ModelPartData Wing_Left = Body.addChild("Wing_Left", ModelPartBuilder.create().uv(12, 13).mirrored().cuboid(0.0F, -2.5F, 0.0F, 1.0F, 5.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.0F, -3.25F, -1.85F, -0.4363F, 0.0F, 0.0F));

		ModelPartData Wing_Left_Tip = Wing_Left.addChild("Wing_Left_Tip", ModelPartBuilder.create().uv(18, 18).mirrored().cuboid(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.5F, 2.5F, 7.0F, 1.1345F, 0.0F, 0.0F));

		ModelPartData Right_Leg = BlueFoot.addChild("Right_Leg", ModelPartBuilder.create().uv(20, 0).cuboid(-2.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, -3.0F, 0.0F));

		ModelPartData Left_Leg = BlueFoot.addChild("Left_Leg", ModelPartBuilder.create().uv(20, 0).mirrored().cuboid(-0.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(1.5F, -3.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(BlueFootEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		BlueFoot.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return BlueFoot;
	}
}