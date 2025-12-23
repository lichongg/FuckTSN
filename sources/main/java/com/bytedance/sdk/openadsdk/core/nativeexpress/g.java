package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g {
    public static void j(final String str, final String str2, final n nVar) {
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        com.bytedance.sdk.openadsdk.core.kt.ws.j().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.g.1
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.core.kt.j.xt j6 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j(g.j(str)).cw(str2).m(uf.jy(nVar)).j("dynamic_backup_render_new");
                j6.j(currentTimeMillis);
                return j6;
            }
        }, "dynamic_backup_render_new");
    }

    public static void j(final int i6, final String str, final String str2, final n nVar) {
        com.bytedance.sdk.openadsdk.core.kt.ws.j().up(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.g.2
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j(g.j(str)).cw(str2).m(uf.jy(nVar)).xt(i6).ae(com.bytedance.sdk.openadsdk.core.g.j(i6));
            }
        });
    }

    public static int j(String str) {
        if (TextUtils.isEmpty(str)) {
            return 5;
        }
        str.getClass();
        switch (str) {
        }
        return 5;
    }
}
