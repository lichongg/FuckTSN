package com.bytedance.msdk.core.vl;

import android.content.Context;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static final String f24776j = "xt";

    /* JADX WARN: Removed duplicated region for block: B:13:0x0082 A[Catch: Exception -> 0x002f, TRY_LEAVE, TryCatch #0 {Exception -> 0x002f, blocks: (B:3:0x0010, B:10:0x0047, B:11:0x0053, B:13:0x0082, B:18:0x0024, B:21:0x0031, B:24:0x003c), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.RequiresApi(api = 19)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean xt(android.content.Context r4, java.lang.String r5) {
        /*
            java.lang.String r0 = com.bytedance.msdk.core.vl.xt.f24776j
            java.lang.String r1 = "checkPermissinKITKATNew，permission："
            java.lang.String r2 = java.lang.String.valueOf(r5)
            java.lang.String r1 = r1.concat(r2)
            com.bytedance.msdk.j.up.cw.r(r0, r1)
            r1 = 1
            int r2 = r5.hashCode()     // Catch: java.lang.Exception -> L2f
            r3 = -1888586689(0xffffffff8f6e743f, float:-1.1756694E-29)
            if (r2 == r3) goto L3c
            r3 = -63024214(0xfffffffffc3e53aa, float:-3.9529332E36)
            if (r2 == r3) goto L31
            r3 = -5573545(0xffffffffffaaf457, float:NaN)
            if (r2 == r3) goto L24
            goto L47
        L24:
            java.lang.String r2 = "android.permission.READ_PHONE_STATE"
            boolean r2 = r5.equals(r2)     // Catch: java.lang.Exception -> L2f
            if (r2 == 0) goto L47
            java.lang.String r5 = "android:read_phone_state"
            goto L53
        L2f:
            r4 = move-exception
            goto L91
        L31:
            java.lang.String r2 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r2 = r5.equals(r2)     // Catch: java.lang.Exception -> L2f
            if (r2 == 0) goto L47
            java.lang.String r5 = "android:coarse_location"
            goto L53
        L3c:
            java.lang.String r2 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r2 = r5.equals(r2)     // Catch: java.lang.Exception -> L2f
            if (r2 == 0) goto L47
            java.lang.String r5 = "android:fine_location"
            goto L53
        L47:
            java.lang.String r2 = "android.permission."
            java.lang.String r3 = "android:"
            java.lang.String r5 = r5.replaceFirst(r2, r3)     // Catch: java.lang.Exception -> L2f
            java.lang.String r5 = r5.toLowerCase()     // Catch: java.lang.Exception -> L2f
        L53:
            java.lang.String r2 = "appops"
            java.lang.Object r2 = r4.getSystemService(r2)     // Catch: java.lang.Exception -> L2f
            android.app.AppOpsManager r2 = (android.app.AppOpsManager) r2     // Catch: java.lang.Exception -> L2f
            int r3 = android.os.Binder.getCallingUid()     // Catch: java.lang.Exception -> L2f
            java.lang.String r4 = r4.getPackageName()     // Catch: java.lang.Exception -> L2f
            int r4 = r2.checkOp(r5, r3, r4)     // Catch: java.lang.Exception -> L2f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2f
            java.lang.String r3 = "checkPermissinKITKATNew，locationOp,permission："
            r2.<init>(r3)     // Catch: java.lang.Exception -> L2f
            r2.append(r4)     // Catch: java.lang.Exception -> L2f
            java.lang.String r3 = ","
            r2.append(r3)     // Catch: java.lang.Exception -> L2f
            r2.append(r5)     // Catch: java.lang.Exception -> L2f
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L2f
            com.bytedance.msdk.j.up.cw.r(r0, r2)     // Catch: java.lang.Exception -> L2f
            if (r4 == 0) goto L90
            r1 = 0
            java.lang.String r4 = "checkPermissinKITKATNew，false,permission："
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Exception -> L2f
            java.lang.String r4 = r4.concat(r5)     // Catch: java.lang.Exception -> L2f
            com.bytedance.msdk.j.up.cw.r(r0, r4)     // Catch: java.lang.Exception -> L2f
        L90:
            return r1
        L91:
            java.lang.String r5 = com.bytedance.msdk.core.vl.xt.f24776j
            java.lang.String r0 = "权限检查出错时默认返回有权限，异常代码："
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r4 = r0.concat(r4)
            com.bytedance.msdk.j.up.cw.r(r5, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.vl.xt.xt(android.content.Context, java.lang.String):boolean");
    }

    private static boolean cw(Context context, String str) {
        if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
            return true;
        }
        return false;
    }

    public static boolean j(Context context, String str) {
        return xt(context, str);
    }
}
