package cn.jpush.android.j;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import cn.jpush.android.i.b;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f3688a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f3689b = "";

    /* renamed from: c, reason: collision with root package name */
    private static final String f3690c = "".toLowerCase();

    public static ComponentInfo a(Context context, String str, Class<?> cls) {
        int i6;
        ComponentInfo[] componentInfoArr;
        if (context == null || TextUtils.isEmpty(str)) {
            b.d("AndroidUtils", "Action - hasComponent, invalide param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            int i7 = Service.class.isAssignableFrom(cls) ? 4 : BroadcastReceiver.class.isAssignableFrom(cls) ? 2 : Activity.class.isAssignableFrom(cls) ? 1 : ContentProvider.class.isAssignableFrom(cls) ? 8 : 0;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, i7);
            componentInfoArr = i7 != 1 ? i7 != 2 ? i7 != 4 ? i7 != 8 ? null : packageInfo.providers : packageInfo.services : packageInfo.receivers : packageInfo.activities;
        } catch (Throwable th) {
            b.e("AndroidUtils", "hasComponent error:" + th);
        }
        if (componentInfoArr == null) {
            return null;
        }
        for (ComponentInfo componentInfo : componentInfoArr) {
            try {
            } catch (Throwable th2) {
                b.d("AndroidUtils", "check component e:" + th2);
            }
            if (cls.isAssignableFrom(Class.forName(componentInfo.name))) {
                return componentInfo;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r5) {
        /*
            r0 = 0
            java.lang.String r1 = "AndroidUtils"
            if (r5 != 0) goto Lb
            java.lang.String r5 = "context was null"
        L7:
            cn.jpush.android.i.b.e(r1, r5)
            return r0
        Lb:
            java.lang.String r5 = android.os.Build.MANUFACTURER     // Catch: java.lang.Throwable -> L21
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1f
            java.lang.String r3 = "MANUFACTURER:"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L1f
            r2.append(r5)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L1f
            cn.jpush.android.i.b.a(r1, r2)     // Catch: java.lang.Throwable -> L1f
            goto L34
        L1f:
            r2 = move-exception
            goto L23
        L21:
            r2 = move-exception
            r5 = 0
        L23:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "get MANUFACTURER failed - error:"
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            cn.jpush.android.i.b.e(r1, r2)
        L34:
            boolean r2 = android.text.TextUtils.isEmpty(r5)
            if (r2 == 0) goto L3d
            java.lang.String r5 = "MANUFACTURER was empty"
            goto L7
        L3d:
            java.lang.String r1 = cn.jpush.android.j.a.f3690c
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r3 = 1
            if (r2 == 0) goto L47
            return r3
        L47:
            java.lang.String r5 = r5.toLowerCase()
            boolean r5 = android.text.TextUtils.equals(r1, r5)
            if (r5 == 0) goto L52
            return r3
        L52:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.j.a.a(android.content.Context):boolean");
    }
}
