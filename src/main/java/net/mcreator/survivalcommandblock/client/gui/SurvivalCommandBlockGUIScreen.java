package net.mcreator.survivalcommandblock.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;

import net.mcreator.survivalcommandblock.world.inventory.SurvivalCommandBlockGUIMenu;
import net.mcreator.survivalcommandblock.network.SurvivalCommandBlockGUIButtonMessage;
import net.mcreator.survivalcommandblock.SurvivalCommandBlockMod;

import java.util.HashMap;

import com.mojang.brigadier.Command;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class SurvivalCommandBlockGUIScreen extends AbstractContainerScreen<SurvivalCommandBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = SurvivalCommandBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox Command;
	Button button_execute;

	public SurvivalCommandBlockGUIScreen(SurvivalCommandBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 211;
		this.imageHeight = 38;
	}

	private static final ResourceLocation texture = new ResourceLocation("survival_command_block:textures/screens/survival_command_block_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		Command.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (Command.isFocused())
			return Command.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		Command.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.survival_command_block.survival_command_block_gui.label_empty"), 12, 14, -16777216);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		Command = new EditBox(this.font, this.leftPos + 20, this.topPos + 8, 120, 20, Component.translatable("gui.survival_command_block.survival_command_block_gui.Command"));
		Command.setMaxLength(32767);
		guistate.put("text:Command", Command);
		this.addWidget(this.Command);
		button_execute = Button.builder(Component.translatable("gui.survival_command_block.survival_command_block_gui.button_execute"), e -> {
			if (true) {
				SurvivalCommandBlockMod.PACKET_HANDLER.sendToServer(new SurvivalCommandBlockGUIButtonMessage(0, x, y, z));
				SurvivalCommandBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 141, this.topPos + 8, 62, 20).build();
		guistate.put("button:button_execute", button_execute);
		this.addRenderableWidget(button_execute);
	}
}
