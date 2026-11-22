package com.example.measuringmod.client.measurement;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;

public class MeasuringClientManager {
    private static BlockPos first;
    private static BlockPos second;
    private static byte counter = 0;
    private static boolean measuringMode = false;

    public static boolean GetMeasuringMode() {return measuringMode;}
    public static void SetMeasuringMode(boolean mode) {measuringMode = mode;}

    public static void handleMeasurement(BlockPos pos, Minecraft client){
        switch (counter){
            case 0:{
                first = pos;
                counter++;
            };break;
            case 1:{
                if (!first.equals(pos)) {
                    second = pos;
                    calc(client);
                    clear();
                }
            };break;
        }
    }

    private static void calc(Minecraft client) {
        int x = Math.abs(second.getX() - first.getX()) + 1;
        int z = Math.abs(second.getZ() - first.getZ()) + 1;
        int y = Math.abs(second.getY() - first.getY()) + 1;

        int distance = Math.max(x, z);

        if (distance != 1) {
            client.player.sendSystemMessage(
                    Component.literal("[MeasuringMod] Distance: " + distance + " blocks horizontally")
            );
        }
        else{
            client.player.sendSystemMessage(
                    Component.literal("[MeasuringMod] Distance: " + y + " blocks vertically")
            );
        }
    }
    public static void clear(){
        first = null;
        second = null;
        counter = 0;
    }
}
