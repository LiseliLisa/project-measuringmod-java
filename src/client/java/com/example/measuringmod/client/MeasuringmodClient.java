package com.example.measuringmod.client;

import com.example.measuringmod.client.command.MeasureClientCommands;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.Commands;

public class MeasuringmodClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		CommandRegistrationCallback.EVENT.register((dispatcher, buildContext, selection) -> {
			dispatcher.register(Commands.literal("measure")
					.executes(MeasureClientCommands::ToggleMeasureMode)
			);
		});
	}
}