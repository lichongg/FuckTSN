package com.bytedance.sdk.gromore.init;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.core.gq;
import com.bytedance.sdk.openadsdk.core.la;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DispatchAdSdkInitializerHolder {

    /* renamed from: j, reason: collision with root package name */
    private static volatile Object f27329j;
    private static com.bytedance.sdk.openadsdk.core.cw xt;

    public static la getCsjManger() {
        com.bytedance.sdk.openadsdk.core.cw cwVar = xt;
        if (cwVar != null) {
            return cwVar.xt();
        }
        return null;
    }

    public static Object getInstance(Bundle bundle, com.bytedance.sdk.openadsdk.core.cw cwVar) {
        xt = cwVar;
        if (f27329j == null) {
            synchronized (DispatchAdSdkInitializerHolder.class) {
                try {
                    if (f27329j == null) {
                        f27329j = new qv(bundle, cwVar);
                    }
                } finally {
                }
            }
        }
        return f27329j;
    }

    public static boolean isInitSuccess() {
        com.bytedance.sdk.openadsdk.core.cw cwVar = xt;
        return cwVar != null && cwVar.j();
    }

    public static gq getCsjLoader(Context context) {
        if (getCsjManger() != null) {
            return getCsjManger().j(context);
        }
        return null;
    }
}
