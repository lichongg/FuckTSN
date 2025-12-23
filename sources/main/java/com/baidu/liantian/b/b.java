package com.baidu.liantian.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.baidu.liantian.LiantianService;
import com.baidu.liantian.ac.U;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.tencent.connect.common.Constants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class b {
    /* JADX WARN: Can't wrap try/catch for region: R(11:1|2|(9:4|(1:6)|8|9|10|11|12|13|15)(1:23)|7|8|9|10|11|12|13|15) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0093, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0094, code lost:
    
        r9.getMessage();
        com.baidu.liantian.b.b();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r8, boolean r9) {
        /*
            com.baidu.liantian.e r0 = new com.baidu.liantian.e     // Catch: java.lang.Throwable -> La7
            r0.<init>(r8)     // Catch: java.lang.Throwable -> La7
            java.lang.String r1 = "alarm"
            java.lang.Object r1 = r8.getSystemService(r1)     // Catch: java.lang.Throwable -> La7
            android.app.AlarmManager r1 = (android.app.AlarmManager) r1     // Catch: java.lang.Throwable -> La7
            android.content.Intent r2 = new android.content.Intent     // Catch: java.lang.Throwable -> La7
            java.lang.String r3 = "com.baidu.action.Liantian.VIEW"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> La7
            java.lang.Class<com.baidu.liantian.LiantianService> r3 = com.baidu.liantian.LiantianService.class
            r2.setClass(r8, r3)     // Catch: java.lang.Throwable -> La7
            java.lang.String r3 = r8.getPackageName()     // Catch: java.lang.Throwable -> La7
            r2.setPackage(r3)     // Catch: java.lang.Throwable -> La7
            java.lang.String r3 = "com.baidu.category.liantian"
            r2.addCategory(r3)     // Catch: java.lang.Throwable -> La7
            java.lang.String r3 = "android.intent.category.DEFAULT"
            r2.addCategory(r3)     // Catch: java.lang.Throwable -> La7
            java.lang.String r3 = "from_plugin_package"
            java.lang.String r4 = r8.getPackageName()     // Catch: java.lang.Throwable -> La7
            r2.putExtra(r3, r4)     // Catch: java.lang.Throwable -> La7
            java.lang.String r3 = "target_class"
            java.lang.Class<com.baidu.liantian.ac.U> r4 = com.baidu.liantian.ac.U.class
            java.lang.String r4 = r4.getCanonicalName()     // Catch: java.lang.Throwable -> La7
            r2.putExtra(r3, r4)     // Catch: java.lang.Throwable -> La7
            java.lang.String r3 = "target_method"
            java.lang.String r4 = "handleWork"
            r2.putExtra(r3, r4)     // Catch: java.lang.Throwable -> La7
            java.lang.String r3 = "from"
            r4 = 6
            r2.putExtra(r3, r4)     // Catch: java.lang.Throwable -> La7
            r3 = 1000(0x3e8, float:1.401E-42)
            r4 = 134217728(0x8000000, float:3.85186E-34)
            android.app.PendingIntent r8 = android.app.PendingIntent.getService(r8, r3, r2, r4)     // Catch: java.lang.Throwable -> La7
            if (r9 == 0) goto L70
            android.content.SharedPreferences r9 = r0.f10457a     // Catch: java.lang.Throwable -> La7
            java.lang.String r2 = "npuct"
            r3 = 0
            long r5 = r9.getLong(r2, r3)     // Catch: java.lang.Throwable -> La7
            int r9 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r9 > 0) goto L89
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> La7
            r4 = 86400000(0x5265c00, double:4.2687272E-316)
            long r2 = r2 + r4
            r0.a(r2)     // Catch: java.lang.Throwable -> La7
        L6e:
            r5 = r2
            goto L89
        L70:
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> La7
            r4 = 85800000(0x51d3440, double:4.23908324E-316)
            long r2 = r2 + r4
            double r4 = java.lang.Math.random()     // Catch: java.lang.Throwable -> La7
            r6 = 4697904772475256832(0x41324f8000000000, double:1200000.0)
            double r4 = r4 * r6
            long r4 = (long) r4     // Catch: java.lang.Throwable -> La7
            long r2 = r2 + r4
            r0.a(r2)     // Catch: java.lang.Throwable -> La7
            goto L6e
        L89:
            java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> La7
            com.baidu.liantian.b.a()     // Catch: java.lang.Throwable -> La7
            r1.cancel(r8)     // Catch: java.lang.Throwable -> L93
            goto L9a
        L93:
            r9 = move-exception
            r9.getMessage()     // Catch: java.lang.Throwable -> La7
            com.baidu.liantian.b.b()     // Catch: java.lang.Throwable -> La7
        L9a:
            r9 = 0
            r1.set(r9, r5, r8)     // Catch: java.lang.Throwable -> L9f
            goto La6
        L9f:
            r8 = move-exception
            r8.getMessage()     // Catch: java.lang.Throwable -> La7
            com.baidu.liantian.b.b()     // Catch: java.lang.Throwable -> La7
        La6:
            return
        La7:
            com.baidu.liantian.b.e.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.b.b.a(android.content.Context, boolean):void");
    }

    public static void a(Context context, int i6, boolean z5) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent("com.baidu.action.Liantian.VIEW");
            intent.setClass(context, LiantianService.class);
            intent.setPackage(context.getPackageName());
            intent.addCategory("com.baidu.category.liantian");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("from_plugin_package", context.getPackageName());
            intent.putExtra("target_class", U.class.getCanonicalName());
            intent.putExtra("target_method", "handleWork");
            intent.putExtra(Constants.FROM, 2);
            PendingIntent service = PendingIntent.getService(context, 1001, intent, AMapEngineUtils.HALF_MAX_P20_WIDTH);
            long currentTimeMillis = System.currentTimeMillis() + (i6 != 0 ? i6 != 1 ? i6 != 2 ? TTAdConstant.AD_MAX_EVENT_TIME : PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS : 180000L : WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
            System.currentTimeMillis();
            com.baidu.liantian.b.a();
            try {
                alarmManager.cancel(service);
            } catch (Throwable th) {
                th.getMessage();
                com.baidu.liantian.b.b();
            }
            if (z5) {
                return;
            }
            try {
                alarmManager.set(0, currentTimeMillis, service);
            } catch (Throwable th2) {
                th2.getMessage();
                com.baidu.liantian.b.b();
            }
        } catch (Throwable unused) {
            e.a();
        }
    }

    public static void a(Context context) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent("com.baidu.action.Liantian.VIEW");
            intent.setClass(context, LiantianService.class);
            intent.setPackage(context.getPackageName());
            intent.addCategory("com.baidu.category.liantian");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("from_plugin_package", context.getPackageName());
            intent.putExtra("target_class", U.class.getCanonicalName());
            intent.putExtra("target_method", "handleUploadPidChange");
            PendingIntent service = PendingIntent.getService(context, 1002, intent, AMapEngineUtils.HALF_MAX_P20_WIDTH);
            long currentTimeMillis = System.currentTimeMillis() + 86400000;
            try {
                alarmManager.cancel(service);
            } catch (Throwable th) {
                th.getMessage();
                com.baidu.liantian.b.b();
            }
            try {
                alarmManager.set(0, currentTimeMillis, service);
            } catch (Throwable th2) {
                th2.getMessage();
                com.baidu.liantian.b.b();
            }
        } catch (Throwable unused) {
            e.a();
        }
    }
}
