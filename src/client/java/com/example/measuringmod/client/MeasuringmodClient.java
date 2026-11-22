package com.example.measuringmod.client;

import com.example.measuringmod.client.command.MeasureClientCommands;
import com.example.measuringmod.client.measurement.MeasuringClientManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.ClientCommands;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.client.player.ClientPreAttackCallback;
import net.minecraft.commands.Commands;
import net.minecraft.world.phys.BlockHitResult;

public class MeasuringmodClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientPreAttackCallback.EVENT.register((client, player, clickCount) -> {

			if (!MeasuringClientManager.GetMeasuringMode()) return false;

			if (clickCount > 0 && client.hitResult instanceof BlockHitResult hit) {
				MeasuringClientManager.handleMeasurement(hit.getBlockPos(),client);
			}

			return true;
		});
		ClientCommandRegistrationCallback.EVENT.register((dispatcher, buildContext) -> {
			dispatcher.register(ClientCommands.literal("measure")
					.executes(MeasureClientCommands::ToggleMeasureMode)
			);
		});
	}
}