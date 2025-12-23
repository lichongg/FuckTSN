package com.bytedance.sdk.openadsdk.core.r;

import com.bytedance.sdk.component.adexpress.up.up;
import com.bytedance.sdk.component.panglearmor.m;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.openadsdk.core.rn.oq;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    public static void j() {
        tl.j().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.r.cw.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.g.xt.j().xt(0.0d);
                    cw.unregisterReceiver();
                    up.j().xt();
                } catch (Throwable unused) {
                }
            }
        }, 20000L);
        m.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void unregisterReceiver() {
        oq.up();
        oq.jy();
    }
}
