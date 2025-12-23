package com.bytedance.sdk.openadsdk.core.rn;

import com.bytedance.sdk.openadsdk.core.tj.q;
import com.bytedance.sdk.openadsdk.core.tj.z;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tj {
    public static boolean cw(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar == null || z.j(nVar) || tl(nVar) != 3) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.core.tj.kt.j(nVar);
    }

    public static boolean r(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        return nVar != null && tl(nVar) == 4;
    }

    public static int up(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar != null && tl(nVar) == 3) {
            return com.bytedance.sdk.openadsdk.core.tj.kt.g(nVar);
        }
        return 0;
    }

    public static boolean xt(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        return (nVar == null || tl(nVar) == 0) ? false : true;
    }

    public static String j(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar == null) {
            return "";
        }
        int tl = tl(nVar);
        return tl != 3 ? tl != 4 ? "" : q.up(nVar) : com.bytedance.sdk.openadsdk.core.tj.kt.m(nVar);
    }

    public static int m(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar == null) {
            return -1;
        }
        if (tl(nVar) != 3) {
            return 0;
        }
        return com.bytedance.sdk.openadsdk.core.tj.kt.oq(nVar);
    }

    public static boolean ae(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (tl(nVar) == 3) {
            return true;
        }
        return false;
    }

    private static int tl(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (com.bytedance.sdk.openadsdk.core.tj.kt.j(nVar)) {
            return 3;
        }
        if (q.j(nVar)) {
            return 4;
        }
        return 0;
    }
}
