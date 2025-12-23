package com.bytedance.j.xt.tl;

import com.bytedance.sdk.component.oq.r.cw;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class b {
    public static Thread a(Runnable runnable) {
        return b(runnable, null);
    }

    public static Thread b(Runnable runnable, String str) {
        if (runnable == null) {
            return null;
        }
        cw cwVar = str == null ? new cw(runnable, "hreadExecutor") : new cw(runnable, str);
        cwVar.start();
        return cwVar;
    }
}
