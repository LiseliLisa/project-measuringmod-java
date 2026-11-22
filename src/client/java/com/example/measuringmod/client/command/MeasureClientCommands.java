package com.example.measuringmod.client.command;

import com.example.measuringmod.client.measurement.MeasuringClientManager;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;

public class MeasureClientCommands {
    public static int ToggleMeasureMode(CommandContext<FabricClientCommandSource> context){
        if (MeasuringClientManager.GetMeasuringMode()){
            MeasuringClientManager.SetMeasuringMode(false);
            MeasuringClientManager.clear();
            context.getSource().sendFeedback(Component.literal("[MeasuringMod] Measuring mode deactivated!"));
        }
        else{
            MeasuringClientManager.SetMeasuringMode(true);
            context.getSource().sendFeedback(Component.literal("[MeasuringMod] Measuring mode activated!"));
        }
        return 0;
    }
}
