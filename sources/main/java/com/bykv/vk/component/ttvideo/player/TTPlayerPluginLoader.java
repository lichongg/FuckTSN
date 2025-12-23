package com.bykv.vk.component.ttvideo.player;

/* loaded from: D:\Downloads\app\classes3.dex */
public class TTPlayerPluginLoader {
    public static final int PLUGIN_INTERTRUST_DRM = 100;
    private static IPluginLoader mPluginLoader;

    public static ClassLoader loadPlugin(int i6) {
        IPluginLoader iPluginLoader = mPluginLoader;
        if (iPluginLoader != null) {
            return iPluginLoader.loadPlugin(i6);
        }
        return null;
    }

    public static void setPluginLoader(IPluginLoader iPluginLoader) {
        mPluginLoader = iPluginLoader;
    }
}
