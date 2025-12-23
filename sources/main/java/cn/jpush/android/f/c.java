package cn.jpush.android.f;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.text.TextUtils;
import cn.jiguang.push.asus.PushMessageReceiver;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static Context f3645a;

    /* renamed from: b, reason: collision with root package name */
    public static String f3646b;

    /* renamed from: g, reason: collision with root package name */
    private static cn.jpush.android.g.a f3651g;

    /* renamed from: h, reason: collision with root package name */
    private static String f3652h;

    /* renamed from: i, reason: collision with root package name */
    private static Boolean f3653i;

    /* renamed from: f, reason: collision with root package name */
    private static AtomicLong f3650f = new AtomicLong(0);

    /* renamed from: c, reason: collision with root package name */
    public static String f3647c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f3648d = false;

    /* renamed from: e, reason: collision with root package name */
    public static String f3649e = "com.asus.as";

    /* renamed from: j, reason: collision with root package name */
    private static ExecutorService f3654j = Executors.newSingleThreadExecutor();

    public static long a() {
        long incrementAndGet = f3650f.incrementAndGet();
        if (incrementAndGet == Long.MAX_VALUE) {
            f3650f.set(0L);
        }
        return incrementAndGet;
    }

    public static void a(Context context, String str, long j6, JSONObject jSONObject) {
        if (c(context)) {
            f3654j.execute(new d(str, j6, jSONObject));
        }
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty(f3652h)) {
            return f3652h;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("com.ups.push.PUSH_RESPONSE");
            intent.setPackage(context.getPackageName());
            ComponentInfo a6 = cn.jpush.android.j.a.a(context, context.getPackageName(), PushMessageReceiver.class);
            if (a6 != null) {
                f3652h = a6.name;
                cn.jpush.android.i.a.a("ASUS_PUSH", "Gobal", false, 4, "found userServiceClass :" + f3652h + " by getComponentInfo");
            }
        } catch (Throwable th) {
            cn.jpush.android.i.b.e("Gobal", "not found PushMessageReceiver :" + th.getMessage());
        }
        return f3652h;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean c(android.content.Context r6) {
        /*
            java.lang.String r0 = "asus_default_channel_id"
            java.lang.Boolean r1 = cn.jpush.android.f.c.f3653i
            if (r1 == 0) goto Lb
            boolean r6 = r1.booleanValue()
            return r6
        Lb:
            r1 = 0
            java.lang.String r2 = "Gobal"
            if (r6 != 0) goto L16
            java.lang.String r6 = "context is null"
            cn.jpush.android.i.b.g(r2, r6)
            return r1
        L16:
            boolean r3 = cn.jpush.android.j.a.a(r6)
            r4 = 0
            java.lang.String r5 = "ConnectionFactory"
            if (r3 != 0) goto L25
            java.lang.String r3 = "Manufacturer not match, give up create connection."
        L21:
            cn.jpush.android.i.b.f(r5, r3)
            goto L35
        L25:
            java.lang.String r3 = cn.jpush.android.f.c.f3649e
            boolean r3 = cn.jpush.android.g.c.a(r6, r3)
            if (r3 != 0) goto L30
            java.lang.String r3 = "cn.jpush.android.service.PushManagerService not exist in system, give up create connection."
            goto L21
        L30:
            cn.jpush.android.g.d r4 = new cn.jpush.android.g.d
            r4.<init>()
        L35:
            cn.jpush.android.f.c.f3651g = r4
            if (r4 != 0) goto L43
            java.lang.String r6 = "unsupport this device."
            cn.jpush.android.i.b.g(r2, r6)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            cn.jpush.android.f.c.f3653i = r6
            return r1
        L43:
            android.content.Context r1 = r6.getApplicationContext()
            android.content.Context r1 = com.stub.StubApp.getOrigApplicationContext(r1)
            cn.jpush.android.f.c.f3645a = r1
            java.lang.String r1 = r1.getPackageName()
            cn.jpush.android.f.c.f3647c = r1
            cn.jpush.android.a.a.a(r6)
            java.lang.String r1 = "notification"
            java.lang.Object r6 = r6.getSystemService(r1)     // Catch: java.lang.Throwable -> L7e
            android.app.NotificationManager r6 = (android.app.NotificationManager) r6     // Catch: java.lang.Throwable -> L7e
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L7e
            r3 = 26
            if (r1 < r3) goto L94
            android.app.NotificationChannel r1 = cn.jiguang.bz.z.a(r6, r0)     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L94
            java.lang.String r1 = "create default channel:默认"
            cn.jpush.android.i.b.b(r2, r1)     // Catch: java.lang.Throwable -> L7e
            cn.jpush.android.f.g.a()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r1 = "默认"
            r3 = 3
            android.app.NotificationChannel r0 = cn.jiguang.bz.c0.a(r0, r1, r3)     // Catch: java.lang.Throwable -> L7e
            cn.jiguang.bz.a0.a(r6, r0)     // Catch: java.lang.Throwable -> L7e
            goto L94
        L7e:
            r6 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "[initNotificationChannel] failed:"
            r0.<init>(r1)
            java.lang.String r6 = r6.getMessage()
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            cn.jpush.android.i.b.e(r2, r6)
        L94:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            cn.jpush.android.f.c.f3653i = r6
            r6 = 1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.f.c.c(android.content.Context):boolean");
    }

    static /* synthetic */ void a(String str, long j6, JSONObject jSONObject) {
        cn.jpush.android.g.a aVar = f3651g;
        if (!(aVar != null ? aVar.b() : false)) {
            cn.jpush.android.i.b.a("Gobal", "connect has disconnect, will reconnect.");
            cn.jpush.android.g.a aVar2 = f3651g;
            if (aVar2 != null) {
                aVar2.a();
            }
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("JPUSH_PACKAGE", f3647c);
            if (j6 <= 0) {
                j6 = a();
            }
            jSONObject.put("JPUSH_RID", j6);
            String jSONObject2 = jSONObject.toString();
            cn.jpush.android.i.b.c("Gobal", "cmd:" + str + ",data:" + jSONObject2);
            cn.jpush.android.g.a aVar3 = f3651g;
            if (aVar3 != null) {
                aVar3.a(str, jSONObject2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean a(Context context) {
        return cn.jpush.android.g.c.a(context, f3649e);
    }
}
