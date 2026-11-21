package com.example.measuringmod.client.command;

import com.example.measuringmod.client.measurement.MeasuringClientManager;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;

public class MeasureClientCommands {
    public static int ToggleMeasureMode(CommandContext<CommandSourceStack> context){
        if (MeasuringClientManager.GetMeasuringMode()){


            context.getSource().sendSuccess(() -> Component.literal("[MeasuringMod] Measuring mode deactivated!"), false);
        }
        else{

            context.getSource().sendSuccess(() -> Component.literal("[MeasuringMod] Measuring mode activated!"), false);
        }
        return 0;
    }
}
