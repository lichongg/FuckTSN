package com.bytedance.sdk.openadsdk.core.m;

import com.bytedance.sdk.openadsdk.core.v;
import java.util.Random;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static volatile Random f29516j;
    private static volatile boolean xt;

    public static boolean j() {
        return xt;
    }

    private static Random cw() {
        if (f29516j != null) {
            return f29516j;
        }
        Random cw = com.bytedance.sdk.component.utils.j.cw();
        f29516j = cw;
        return cw;
    }

    public static boolean j(float f6, boolean z5) {
        if (f6 <= 0.0f) {
            if (z5) {
                xt = false;
            }
            return false;
        }
        int nextInt = cw().nextInt(100);
        int i6 = (int) (f6 * 100.0f);
        if (z5) {
            xt = nextInt < i6;
        }
        return nextInt < i6;
    }

    public static void xt() {
        j(v.xt().n(), true);
    }
}
