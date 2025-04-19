package net.demo.simple_coordinates_mod;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid =Simple_coordinates_mod.MODID,bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.CLIENT)
public class EventHandler {
    public void registerKeyBind(RegisterKeyMappingsEvent event){
        event.register(KeyBind.INSTANCE.EnableOrDisableCoordsKey);
    }
    public static void onTick(TickEvent.ClientTickEvent event){
            Player player = Minecraft.getInstance().player;
            double playerX = player.getX();
            double playerY = player.getY();
            double playerZ = player.getZ();
            int x = (int)playerX;
            int y = (int)playerY;                       //Сука чё пишет этот даун?
            int z = (int)playerZ;
            String playerXString = x+"";
            String playerYString = y+"";
            String playerZString = z+"";
            String coords = String.format("%s %s #s",playerXString,playerZString,playerYString);
            player.displayClientMessage(Component.literal(coords),true);
    }
}
