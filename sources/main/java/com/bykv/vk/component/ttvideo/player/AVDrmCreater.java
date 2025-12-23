package com.bykv.vk.component.ttvideo.player;

import com.bytedance.sdk.component.utils.vl;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public class AVDrmCreater {
    public static final int DrmTypeIntertrust = 1;
    public static final int DrmTypeNone = 0;

    @CalledByNative
    public static synchronized long createDrm(int i6) {
        synchronized (AVDrmCreater.class) {
            if (i6 != 1) {
                return 0L;
            }
            return createDrm(100, "com.bykv.vk.component.ttvideo.drm.intertrust.IntertrustDrm");
        }
    }

    private static long createDrm(int i6, String str) {
        try {
            ClassLoader loadPlugin = TTPlayerPluginLoader.loadPlugin(i6);
            return Long.parseLong(String.valueOf((loadPlugin != null ? Class.forName(str, true, loadPlugin) : Class.forName(str)).getMethod("createDrm", null).invoke(null, null)));
        } catch (Exception e6) {
            vl.j(e6);
            return 0L;
        }
    }
}
