package com.bytedance.sdk.openadsdk.core.ugeno.express.j;

import com.bytedance.adsdk.ugeno.up.m;
import com.bytedance.sdk.openadsdk.core.i.j.w;
import com.bytedance.sdk.openadsdk.core.nativeexpress.qv;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    public static final HashSet<String> f30695j = new HashSet<>(Arrays.asList("interactiveFinish"));

    public static void j(qv qvVar, n nVar, String str, m.j jVar) {
        if (jVar == null || qvVar == null) {
            return;
        }
        Map<String, String> cw = jVar.cw();
        str.getClass();
        if (str.equals("interactiveFinish")) {
            int i6 = 0;
            if (cw != null) {
                try {
                    i6 = w.j(nVar, Integer.parseInt(cw.get("reduce_duration")));
                } catch (NumberFormatException unused) {
                }
            }
            qvVar.xt(i6);
        }
    }
}
