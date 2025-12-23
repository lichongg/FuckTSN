package com.bytedance.sdk.openadsdk.ae;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f27521j;

    public static j j() {
        if (f27521j == null) {
            synchronized (j.class) {
                try {
                    if (f27521j == null) {
                        f27521j = new j();
                    }
                } finally {
                }
            }
        }
        return f27521j;
    }

    private void xt(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Intent intent = new Intent("com.bytedance.minigame.preload.action");
            r j6 = xt.j().j(context);
            intent.putExtra("key_preload_info", cw.j(j6.xt, j6.f27522j, str));
            intent.putExtra("key_preload_code", j6.cw);
            context.sendBroadcast(intent);
            vl.r("onPreloadFinish", "tryPreload finish1");
        } catch (Exception unused) {
        }
    }

    private j() {
    }

    public void j(Context context, String str) {
        if (!v.xt().ae() || TextUtils.isEmpty(str)) {
            return;
        }
        j().xt(context, str);
    }
}
