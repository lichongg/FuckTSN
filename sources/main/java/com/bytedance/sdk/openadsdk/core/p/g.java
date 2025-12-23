package com.bytedance.sdk.openadsdk.core.p;

import a1.a;
import a1.b;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g {
    private static PluginValueSet cw;

    /* renamed from: j, reason: collision with root package name */
    private static final AtomicInteger f29791j = new AtomicInteger(com.bytedance.sdk.openadsdk.api.plugin.xt.xt(v.getContext(), "sync_switch", 0).getInt(NotificationCompat.CATEGORY_STATUS, 1));
    private static com.bytedance.sdk.openadsdk.core.cw xt;

    public static boolean j() {
        return f29791j.get() == 1;
    }

    protected static void j(int i6) {
        com.bytedance.sdk.openadsdk.core.cw cwVar;
        if (i6 == 1 || i6 == 2) {
            com.bytedance.sdk.openadsdk.api.plugin.xt.xt(v.getContext(), "sync_switch", 0).edit().putInt(NotificationCompat.CATEGORY_STATUS, i6).apply();
            AtomicInteger atomicInteger = f29791j;
            int i7 = atomicInteger.get();
            atomicInteger.set(i6);
            if (i7 != 2 || i6 != 1 || (cwVar = xt) == null || cwVar.j()) {
                return;
            }
            try {
                xt.j(v.getContext(), cw, new com.bytedance.sdk.openadsdk.core.wq.cw(b.a(cw.objectValue(15, a.a()))));
                xt = null;
                cw = null;
            } catch (Throwable th) {
                vl.cw("SdkSwitch", "init sdk error", th);
            }
        }
    }
}
