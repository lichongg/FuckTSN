package com.bytedance.sdk.component.g.r;

import android.content.Context;
import com.bytedance.sdk.component.g.cw.ae;
import java.util.LinkedHashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    public static void j(Context context, int i6, String str, int i7) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i6 == 1) {
                linkedHashMap.put(j(i7), str);
            }
            cw.xt("MultiProcessFileUtils", "saveData = ".concat(String.valueOf(str)));
            if (ae.j().j(i7).r() != null) {
                ae.j().j(i7).r().j(context, linkedHashMap);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String j(android.content.Context r2, int r3, int r4) {
        /*
            r0 = 1
            java.lang.String r1 = ""
            if (r3 == r0) goto L6
            goto L2a
        L6:
            com.bytedance.sdk.component.g.cw.ae r3 = com.bytedance.sdk.component.g.cw.ae.j()     // Catch: java.lang.Exception -> L29
            com.bytedance.sdk.component.g.cw.up r3 = r3.j(r4)     // Catch: java.lang.Exception -> L29
            com.bytedance.sdk.component.g.cw.xt r3 = r3.r()     // Catch: java.lang.Exception -> L29
            if (r3 == 0) goto L2a
            com.bytedance.sdk.component.g.cw.ae r3 = com.bytedance.sdk.component.g.cw.ae.j()     // Catch: java.lang.Exception -> L29
            com.bytedance.sdk.component.g.cw.up r3 = r3.j(r4)     // Catch: java.lang.Exception -> L29
            com.bytedance.sdk.component.g.cw.xt r3 = r3.r()     // Catch: java.lang.Exception -> L29
            java.lang.String r4 = j(r4)     // Catch: java.lang.Exception -> L29
            java.lang.String r2 = r3.j(r2, r4, r1)     // Catch: java.lang.Exception -> L29
            goto L2b
        L29:
        L2a:
            r2 = r1
        L2b:
            boolean r3 = androidx.activity.k.a(r2)
            if (r3 == 0) goto L32
            r1 = r2
        L32:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.g.r.r.j(android.content.Context, int, int):java.lang.String");
    }

    private static String j(int i6) {
        return "tnc_config".concat(String.valueOf(i6));
    }
}
