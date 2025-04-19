package net.demo.simple_coordinates_mod;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.jarjar.nio.util.Lazy;
import org.lwjgl.glfw.GLFW;

public class KeyBind {
    public static final KeyBind INSTANCE = new KeyBind();
    private KeyBind() {}
    public static final KeyMapping EnableOrDisableCoordsKey = new KeyMapping("key.simple-coordinates-mod", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_H, "key.categories.gameplay");
}
