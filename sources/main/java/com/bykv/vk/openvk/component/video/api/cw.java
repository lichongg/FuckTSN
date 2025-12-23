package com.bykv.vk.openvk.component.video.api;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.xt.j.vl;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    private static String cw = null;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f22944j = false;

    /* renamed from: m, reason: collision with root package name */
    private static int f22945m = 1;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f22946r;
    private static vl up;
    private static Context xt;

    public static String j() {
        if (TextUtils.isEmpty(cw)) {
            try {
                File file = new File(com.bytedance.sdk.openadsdk.api.plugin.xt.j(getContext()), "ttad_dir");
                if (!file.exists()) {
                    file.mkdirs();
                }
                cw = file.getAbsolutePath();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.j(th);
            }
        }
        return cw;
    }

    public static vl cw() {
        if (up == null) {
            vl.j jVar = new vl.j("v_config");
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            up = jVar.j(10000L, timeUnit).xt(10000L, timeUnit).cw(10000L, timeUnit).j();
        }
        return up;
    }

    public static Context getContext() {
        return xt;
    }

    public static boolean r() {
        return f22944j;
    }

    public static int up() {
        return f22945m;
    }

    public static boolean xt() {
        return f22946r;
    }

    public static void j(Context context, String str) {
        xt = context;
        cw = str;
    }

    public static void j(boolean z5) {
        f22946r = z5;
    }

    public static void j(vl vlVar) {
        up = vlVar;
    }
}
