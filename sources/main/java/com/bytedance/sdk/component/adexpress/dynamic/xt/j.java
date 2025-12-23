package com.bytedance.sdk.component.adexpress.dynamic.xt;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.cw.ae;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static int j(ae aeVar) {
        if (aeVar == null) {
            return 0;
        }
        String ed = aeVar.ed();
        String x5 = aeVar.x();
        if (TextUtils.isEmpty(x5) || TextUtils.isEmpty(ed) || !x5.equals("creative")) {
            return 0;
        }
        if (ed.equals("shake")) {
            return 2;
        }
        if (ed.equals("twist")) {
            return 3;
        }
        return ed.equals("slide") ? 1 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean xt(android.view.View r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            r1 = 2097610707(0x7d06ffd3, float:1.1215304E37)
            java.lang.Object r7 = r7.getTag(r1)     // Catch: java.lang.Exception -> L2a
            android.util.Pair r7 = (android.util.Pair) r7     // Catch: java.lang.Exception -> L2a
            if (r7 != 0) goto L10
            return r0
        L10:
            java.lang.Object r1 = r7.first     // Catch: java.lang.Exception -> L2a
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch: java.lang.Exception -> L2a
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L2a
            r2 = 1
            if (r1 != 0) goto L2c
            java.lang.String r1 = "0"
            java.lang.Object r3 = r7.first     // Catch: java.lang.Exception -> L2a
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Exception -> L2a
            boolean r1 = android.text.TextUtils.equals(r1, r3)     // Catch: java.lang.Exception -> L2a
            if (r1 == 0) goto L28
            goto L2c
        L28:
            r1 = 0
            goto L2d
        L2a:
            r7 = move-exception
            goto L44
        L2c:
            r1 = 1
        L2d:
            java.lang.Object r7 = r7.second     // Catch: java.lang.Exception -> L2a
            java.lang.Long r7 = (java.lang.Long) r7     // Catch: java.lang.Exception -> L2a
            long r3 = r7.longValue()     // Catch: java.lang.Exception -> L2a
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L3d
            r7 = 1
            goto L3e
        L3d:
            r7 = 0
        L3e:
            if (r1 == 0) goto L43
            if (r7 == 0) goto L43
            return r2
        L43:
            return r0
        L44:
            r7.getMessage()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.xt.j.xt(android.view.View):boolean");
    }

    public static boolean j(View view) {
        Object tag;
        if (view == null) {
            return false;
        }
        try {
            tag = view.getTag(2097610708);
        } catch (Exception unused) {
        }
        if (tag == null) {
            return false;
        }
        return ((Integer) tag).intValue() == 1;
    }

    public static boolean j(View view, float f6, float f7, float f8, float f9) {
        if (view == null) {
            return false;
        }
        try {
            Pair pair = (Pair) view.getTag(2097610707);
            if (pair != null && !TextUtils.isEmpty((CharSequence) pair.first) && ((Long) pair.second).longValue() > 0) {
                String str = (String) pair.first;
                long longValue = ((Long) pair.second).longValue();
                if (str.equals("0")) {
                    return ((float) Math.sqrt(Math.pow((double) (f6 - f8), 2.0d) + Math.pow((double) (f7 - f9), 2.0d))) >= ((float) longValue);
                }
                if (str.equals("1")) {
                    float f10 = f7 - f9;
                    return f10 < 0.0f && Math.abs(f10) >= ((float) longValue);
                }
                if (str.equals("2")) {
                    float f11 = f6 - f8;
                    return f11 > 0.0f && Math.abs(f11) >= ((float) longValue);
                }
                if (str.equals("3")) {
                    float f12 = f6 - f8;
                    return f12 < 0.0f && Math.abs(f12) >= ((float) longValue);
                }
                if (str.equals("4")) {
                    float f13 = f7 - f9;
                    if (f13 > 0.0f && Math.abs(f13) >= longValue) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
