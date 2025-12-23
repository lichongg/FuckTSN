package com.bytedance.sdk.openadsdk.l;

import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae {
    public static boolean j() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void r(Runnable runnable) {
        j(runnable, (ScheduledExecutorService) null);
    }

    public static void xt(com.bytedance.sdk.component.oq.g gVar) {
        com.bytedance.sdk.component.oq.ae.cw(gVar);
    }

    public static void j(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            tj.m().post(runnable);
        }
    }

    public static void xt(Runnable runnable) {
        if (v.xt().so() || Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            tj.m().post(runnable);
        }
    }

    public static void cw(Runnable runnable) {
        if (v.xt().ot()) {
            com.bytedance.sdk.component.utils.tl.cw().post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void j(Runnable runnable, long j6) {
        tj.m().postDelayed(runnable, j6);
    }

    public static void j(com.bytedance.sdk.component.oq.g gVar) {
        com.bytedance.sdk.component.oq.ae.xt(gVar);
    }

    public static Looper xt() {
        return v.xt().ot() ? com.bytedance.sdk.component.utils.tl.cw().getLooper() : Looper.getMainLooper();
    }

    public static void j(final Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        if (!j()) {
            if (runnable != null) {
                runnable.run();
            }
        } else if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(runnable);
        } else {
            com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("") { // from class: com.bytedance.sdk.openadsdk.l.ae.1
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            });
        }
    }
}
