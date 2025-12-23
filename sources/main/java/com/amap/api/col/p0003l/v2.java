package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class v2 {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f7462a = new File("/system/framework/amap.jar").exists();

    public static AssetManager b(Context context) {
        if (context == null) {
            return null;
        }
        AssetManager assets = context.getAssets();
        if (f7462a) {
            try {
                assets.getClass().getDeclaredMethod("addAssetPath", String.class).invoke(assets, "/system/framework/amap.jar");
                return assets;
            } catch (Throwable th) {
                v5.p(th, "ResourcesUtil", "getSelfAssets");
            }
        }
        return assets;
    }

    public static int a(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
