package com.bykv.vk.openvk.component.video.j;

import android.content.Context;
import android.os.Build;
import com.baidu.mobads.sdk.internal.bn;
import com.bykv.vk.openvk.component.video.api.j.xt;
import com.bykv.vk.openvk.component.video.api.m.cw;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    public static int cw = 10;

    /* renamed from: j, reason: collision with root package name */
    public static int f22980j = 10;

    /* renamed from: r, reason: collision with root package name */
    public static int f22981r = 10;
    private static xt up = null;
    public static int xt = 10;

    public static void j(Context context) {
        com.bykv.vk.openvk.component.video.api.m.j.j(context);
        if (Build.VERSION.SDK_INT < 23) {
            com.bykv.vk.openvk.component.video.j.xt.m.j.j();
        }
    }

    public static int cw() {
        return xt;
    }

    public static int r() {
        return cw;
    }

    public static int up() {
        return f22981r;
    }

    public static int xt() {
        return f22980j;
    }

    public static void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            f22980j = jSONObject.optInt("splash", 10);
            xt = jSONObject.optInt("reward", 10);
            cw = jSONObject.optInt(bn.f10754j, 10);
            int optInt = jSONObject.optInt("other", 10);
            f22981r = optInt;
            if (f22980j < 0) {
                f22980j = 10;
            }
            if (xt < 0) {
                xt = 10;
            }
            if (cw < 0) {
                cw = 10;
            }
            if (optInt < 0) {
                f22981r = 10;
            }
            cw.j("MediaConfig", "splash=", Integer.valueOf(f22980j), ",reward=", Integer.valueOf(xt), ",brand=", Integer.valueOf(cw), ",other=", Integer.valueOf(f22981r));
        } catch (Throwable th) {
            cw.cw("MediaConfig", th.getMessage());
        }
    }

    public static void j(xt xtVar) {
        up = xtVar;
    }

    public static void j() {
        xt xtVar = up;
        if (xtVar != null) {
            xtVar.up();
        }
    }
}
