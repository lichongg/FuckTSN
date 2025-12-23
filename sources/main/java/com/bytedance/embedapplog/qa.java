package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes3.dex */
public class qa {

    /* renamed from: j, reason: collision with root package name */
    private static volatile String f24034j;

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038 A[Catch: all -> 0x0017, TryCatch #1 {, blocks: (B:6:0x000b, B:8:0x0013, B:9:0x0015, B:17:0x0032, B:19:0x0038, B:20:0x0056, B:21:0x0058, B:23:0x0043, B:25:0x0053, B:29:0x0026, B:31:0x002a, B:33:0x002e, B:14:0x001a, B:16:0x0020), top: B:5:0x000b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043 A[Catch: all -> 0x0017, TryCatch #1 {, blocks: (B:6:0x000b, B:8:0x0013, B:9:0x0015, B:17:0x0032, B:19:0x0038, B:20:0x0056, B:21:0x0058, B:23:0x0043, B:25:0x0053, B:29:0x0026, B:31:0x002a, B:33:0x002e, B:14:0x001a, B:16:0x0020), top: B:5:0x000b, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String j(android.content.Context r5, com.bytedance.embedapplog.rn r6) {
        /*
            java.lang.String r0 = com.bytedance.embedapplog.qa.f24034j
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L5c
            java.lang.Class<com.bytedance.embedapplog.qa> r0 = com.bytedance.embedapplog.qa.class
            monitor-enter(r0)
            java.lang.String r1 = com.bytedance.embedapplog.qa.f24034j     // Catch: java.lang.Throwable -> L17
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L17
            if (r1 != 0) goto L19
            java.lang.String r5 = com.bytedance.embedapplog.qa.f24034j     // Catch: java.lang.Throwable -> L17
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L17
            return r5
        L17:
            r5 = move-exception
            goto L5a
        L19:
            r1 = 0
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r2 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r5)     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L31
            java.lang.String r2 = r2.getId()     // Catch: java.lang.Throwable -> L25
            goto L32
        L25:
            r2 = move-exception
            boolean r3 = r2 instanceof java.lang.ClassNotFoundException     // Catch: java.lang.Throwable -> L17
            if (r3 != 0) goto L31
            boolean r3 = r2 instanceof java.lang.NoClassDefFoundError     // Catch: java.lang.Throwable -> L17
            if (r3 != 0) goto L31
            com.bytedance.sdk.component.utils.vl.j(r2)     // Catch: java.lang.Throwable -> L17
        L31:
            r2 = r1
        L32:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L17
            if (r3 == 0) goto L43
            android.content.SharedPreferences r5 = r6.r()     // Catch: java.lang.Throwable -> L17
            java.lang.String r6 = "google_aid"
            java.lang.String r2 = r5.getString(r6, r1)     // Catch: java.lang.Throwable -> L17
            goto L56
        L43:
            android.content.SharedPreferences r3 = r6.r()     // Catch: java.lang.Throwable -> L17
            java.lang.String r4 = "google_aid"
            java.lang.String r1 = r3.getString(r4, r1)     // Catch: java.lang.Throwable -> L17
            boolean r1 = android.text.TextUtils.equals(r1, r2)     // Catch: java.lang.Throwable -> L17
            if (r1 != 0) goto L56
            j(r5, r2, r6)     // Catch: java.lang.Throwable -> L17
        L56:
            com.bytedance.embedapplog.qa.f24034j = r2     // Catch: java.lang.Throwable -> L17
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L17
            goto L5c
        L5a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L17
            throw r5
        L5c:
            java.lang.String r5 = com.bytedance.embedapplog.qa.f24034j
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.qa.j(android.content.Context, com.bytedance.embedapplog.rn):java.lang.String");
    }

    private static void j(Context context, String str, rn rnVar) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        rnVar.r().edit().putString("google_aid", str).apply();
    }
}
