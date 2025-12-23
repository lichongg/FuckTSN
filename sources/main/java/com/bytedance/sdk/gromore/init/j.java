package com.bytedance.sdk.gromore.init;

import android.os.Bundle;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.la;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static int j() {
        return h.xt;
    }

    public static String cw() {
        return h.cw;
    }

    public static void j(int i6) {
        la xt = xt();
        if (xt != null) {
            xt.j(i6);
        }
    }

    public static String r() {
        return "7.0.1.2";
    }

    public static boolean up() {
        return DispatchAdSdkInitializerHolder.isInitSuccess();
    }

    public static la xt() {
        return DispatchAdSdkInitializerHolder.getCsjManger();
    }

    public static void j(boolean z5) {
        la xt = xt();
        if (xt == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z5);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        xt.j(SparseArray.class, bundle);
    }
}
