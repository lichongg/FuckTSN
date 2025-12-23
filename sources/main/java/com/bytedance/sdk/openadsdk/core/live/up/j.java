package com.bytedance.sdk.openadsdk.core.live.up;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.i;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static boolean j(n nVar) {
        if (nVar == null) {
            return false;
        }
        return j(nVar.m111if());
    }

    public static boolean j(i iVar) {
        if (iVar == null) {
            return false;
        }
        String xt = iVar.xt();
        if (TextUtils.isEmpty(xt)) {
            return false;
        }
        return xt.startsWith("snssdk2329") || xt.startsWith("snssdk1128");
    }

    public static boolean j(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith("snssdk1128")) {
            return uf.j("com.ss.android.ugc.aweme");
        }
        if (str.startsWith("snssdk2329")) {
            return uf.j("com.ss.android.ugc.aweme.lite");
        }
        return false;
    }
}
