package net.demo.simple_coordinates_mod;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MaceItem;
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
            String playerXString = x+"";
            String playerYString = y+"";
            String playerZString = z+"";
            String coords = String.format("%s %s %s",playerXString,playerYString,playerZString);
            player.displayClientMessage(Component.literal(coords),true);
        }
    }
}
