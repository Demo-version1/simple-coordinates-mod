package net.demo.simple_coordinates_mod;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Simple_coordinates_mod.MODID,bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.CLIENT)
public class ForgeClientHandler {
    @SubscribeEvent
    public static void onTick(TickEvent.ClientTickEvent event){
        if(KeyBind.INSTANCE.EnableOrDisableCoordsKey.isDown()){
            Player player = Minecraft.getInstance().player;
            double playerX = player.getX();
            double playerY = player.getY();
            double playerZ = player.getZ();

            int x = (int)playerX;
            int y = (int)playerY;
            int z = (int)playerZ;

            Component space = Component.literal("X:");
            Component xCord = Component.literal(String.valueOf(x)).withStyle(ChatFormatting.RED);
            Component space1 = Component.literal(" Y:");
            Component yCord = Component.literal(String.valueOf(y)).withStyle(ChatFormatting.GREEN);
            Component space2 = Component.literal(" Z:");
            Component zCord = Component.literal(String.valueOf(z)).withStyle(ChatFormatting.BLUE);

            Component coordinates = space.copy().append(xCord).append(space1).append(yCord).append(space2).append(zCord);

            player.displayClientMessage(coordinates,true);
        }
    }
}
