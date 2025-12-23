package cn.jiguang.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import cn.jiguang.android.IDataShare;
import cn.jiguang.ba.d;
import cn.jiguang.ba.f;
import cn.jiguang.ba.h;
import cn.jiguang.bi.c;
import cn.jiguang.bi.g;
import cn.jiguang.bo.i;
import cn.jiguang.by.b;
import cn.jiguang.bz.f;
import cn.jiguang.bz.l;
import cn.jiguang.bz.s;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.service.DataShare;
import cn.jpush.android.service.JCommonService;
import cn.jpush.android.service.PushReceiver;
import com.stub.StubApp;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f1443a = ".permission.JPUSH_MESSAGE";

    /* renamed from: b, reason: collision with root package name */
    public static String f1444b = "5.2.2";

    /* renamed from: c, reason: collision with root package name */
    public static int f1445c = 522;

    /* renamed from: d, reason: collision with root package name */
    public static String f1446d = "";

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f1447e;

    /* renamed from: f, reason: collision with root package name */
    public static Integer f1448f;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f1449g;

    /* renamed from: h, reason: collision with root package name */
    public static final Date f1450h = f.c();

    /* renamed from: i, reason: collision with root package name */
    public static final String f1451i = l.b(new byte[]{85, 118, 97, BinaryMemcacheOpcodes.SASL_AUTH, 60, 84, 32, 0, 98, 46, 73, 85, 85, 116, 18, HttpConstants.COMMA});

    /* renamed from: j, reason: collision with root package name */
    public static List<String> f1452j;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f1453k;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f1454l;

    /* renamed from: m, reason: collision with root package name */
    private static ServiceConnection f1455m;

    /* renamed from: cn.jiguang.a.a$a, reason: collision with other inner class name */
    static class C0022a extends b {

        /* renamed from: a, reason: collision with root package name */
        Context f1458a;

        /* renamed from: b, reason: collision with root package name */
        boolean f1459b;

        /* renamed from: c, reason: collision with root package name */
        String f1460c;

        /* renamed from: d, reason: collision with root package name */
        Bundle f1461d;

        @Override // cn.jiguang.by.b
        public void a() {
            Bundle bundle;
            String str;
            cn.jiguang.bi.b a6;
            Context context;
            int i6;
            String a7;
            try {
                a(this.f1461d);
                if (!cn.jiguang.bz.b.a() && !a.f1452j.contains(this.f1460c)) {
                    cn.jiguang.bb.f.l("JCoreGobal", "user don't auth, so return init");
                    return;
                }
                if (!this.f1459b) {
                    if (a.a(this.f1458a, this.f1461d)) {
                        this.f1461d = b(this.f1461d);
                        this.f1461d = f.c.a(this.f1458a).a(this.f1461d);
                        cn.jiguang.bb.f.c("JCoreGobal", "do action: " + this.f1460c + ", " + cn.jiguang.ba.f.a(this.f1461d) + ", bundle=" + this.f1461d);
                        d.a().a(this.f1458a, this.f1460c, this.f1461d);
                        return;
                    }
                    return;
                }
                cn.jiguang.bb.f.c("JCoreGobal", "inService do action: " + this.f1460c + ", " + cn.jiguang.ba.f.a(this.f1461d) + ", bundle=" + this.f1461d);
                if (this.f1460c.equals("a5")) {
                    cn.jiguang.bi.b.a().a(this.f1458a, 2001, 1, "");
                    cn.jiguang.e.b.a(this.f1458a, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.Q().a((cn.jiguang.e.a<Boolean>) Boolean.TRUE)});
                    String string = this.f1461d.getString("appkey");
                    if (TextUtils.isEmpty(string)) {
                        a6 = cn.jiguang.bi.b.a();
                        context = this.f1458a;
                        i6 = 10003;
                        a7 = cn.jiguang.bn.d.a(10003);
                    } else {
                        String b6 = cn.jiguang.ba.a.b(this.f1458a);
                        if (TextUtils.isEmpty(b6) || b6.equals(string)) {
                            cn.jiguang.bz.a.f(this.f1458a);
                            JConstants.APP_KEY = string;
                            if (c.a(this.f1458a)) {
                                str = "tcp_a24";
                            } else {
                                String b7 = cn.jiguang.d.a.b(this.f1458a);
                                if (!TextUtils.isEmpty(b7)) {
                                    cn.jiguang.bi.b.a().a(this.f1458a, 2001, 0, b7);
                                }
                                str = "tcp_a1";
                            }
                            this.f1460c = str;
                        } else {
                            a6 = cn.jiguang.bi.b.a();
                            context = this.f1458a;
                            i6 = 10002;
                            a7 = cn.jiguang.bn.d.a(10002);
                        }
                    }
                    a6.a(context, 0, i6, a7);
                    return;
                }
                if (this.f1460c.equals("tcp_a23")) {
                    cn.jiguang.bi.b.a().a(this.f1458a, 2000, 0, "success");
                } else if (this.f1460c.equals("a6")) {
                    h.a(this.f1458a);
                } else if (TextUtils.equals(this.f1460c, "a8")) {
                    Bundle bundle2 = this.f1461d;
                    if (bundle2 != null) {
                        cn.jiguang.bz.b.d(this.f1458a, bundle2.getBoolean("enable_auto_wakeup"));
                    }
                } else if (TextUtils.equals(this.f1460c, "a11")) {
                    Bundle bundle3 = this.f1461d;
                    if (bundle3 != null) {
                        cn.jiguang.bz.b.f(this.f1458a, bundle3.getBoolean("enable_ci_priority"));
                    }
                } else if (TextUtils.equals(this.f1460c, "a9")) {
                    Bundle bundle4 = this.f1461d;
                    if (bundle4 != null) {
                        cn.jiguang.bz.b.e(this.f1458a, bundle4.getBoolean("enable_dy"));
                    }
                } else if (this.f1460c.equals("a7")) {
                    cn.jiguang.g.c.a().a(this.f1461d);
                } else if (this.f1460c.equals("a10")) {
                    cn.jiguang.v.a.a(this.f1458a, "GET_ANDROID_ID", this.f1461d);
                } else if (this.f1460c.equals("tcp_set_country")) {
                    a.d(this.f1458a, this.f1461d);
                } else if (TextUtils.equals(this.f1460c, "a13") && (bundle = this.f1461d) != null) {
                    cn.jiguang.bb.a.a(this.f1458a, bundle);
                }
                int a8 = a.a(this.f1458a);
                if (a8 == 0) {
                    d.a().b(this.f1458a, this.f1460c, this.f1461d);
                } else if (a8 > 0) {
                    cn.jiguang.bi.b.a().a(this.f1458a, 2002, a8, cn.jiguang.bn.d.a(a8));
                }
            } catch (Throwable th) {
                cn.jiguang.bb.f.l("JCoreGobal", "do action error: action: " + this.f1460c + " bundle=" + this.f1461d);
                StringBuilder sb = new StringBuilder();
                sb.append("do action error:");
                sb.append(th.getMessage());
                cn.jiguang.bb.f.l("JCoreGobal", sb.toString());
            }
        }

        private void a(Bundle bundle) {
            if (bundle != null) {
                if (bundle.containsKey("is_auth")) {
                    boolean z5 = bundle.getBoolean("is_auth", true);
                    boolean z6 = bundle.getBoolean("had_auth", true);
                    cn.jiguang.bb.f.c("JCoreGobal", "setAuthFormBundle：auth=" + z5 + " hadAuth=" + z6);
                    cn.jiguang.bz.b.a(z5, z6);
                }
                if (bundle.containsKey("had_init")) {
                    boolean z7 = bundle.getBoolean("had_init");
                    cn.jiguang.bb.f.c("JCoreGobal", "setAuthFormBundle hadInit =" + z7);
                    JConstants.isCallInit.set(z7);
                }
                if (bundle.containsKey("foreground")) {
                    boolean z8 = bundle.getBoolean("foreground");
                    cn.jiguang.bb.f.c("JCoreGobal", "isForeGround  =" + z8);
                    cn.jiguang.be.b.f2036b.set(z8);
                }
            }
        }

        private Bundle b(Bundle bundle) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("is_auth", cn.jiguang.bz.b.a());
            bundle.putBoolean("had_auth", cn.jiguang.bz.b.b());
            bundle.putBoolean("had_init", JConstants.isCallInit.get());
            bundle.putBoolean("foreground", cn.jiguang.be.b.f2036b.get());
            cn.jiguang.bb.f.c("JCoreGobal", "addAuthToBundle hadAuth=" + cn.jiguang.bz.b.b() + " auth=" + cn.jiguang.bz.b.a() + "  isCallInit=" + JConstants.isCallInit.get() + " isForeGround=" + cn.jiguang.be.b.f2036b.get());
            return bundle;
        }

        C0022a(Context context, boolean z5, String str, Bundle bundle) {
            this.f1458a = context;
            this.f1459b = z5;
            this.f1460c = str;
            this.f1461d = bundle;
            this.f2653h = "JCoreGlobal";
        }
    }

    public static synchronized int a(Context context) {
        synchronized (a.class) {
            Integer num = f1448f;
            if (num != null) {
                return num.intValue();
            }
            if (context == null) {
                cn.jiguang.bb.f.m("JCoreGobal", "init failed, context is null");
                return 1000;
            }
            d(context);
            if (cn.jiguang.bz.a.b(context)) {
                d();
            }
            cn.jiguang.bb.f.h("JCoreGobal", "service process init - jcore, SdkVersion:" + f1444b + ", build id:173 build type:release");
            cn.jiguang.bz.d.a(context);
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            int e6 = cn.jiguang.ba.a.e(origApplicationContext);
            if (e6 != 0) {
                return e6;
            }
            int f6 = cn.jiguang.ba.a.f(origApplicationContext);
            if (f6 != 0) {
                f1448f = -1;
                return f6;
            }
            cn.jiguang.ba.c.a();
            e(origApplicationContext);
            f1448f = 0;
            cn.jiguang.bj.a.a().a(origApplicationContext);
            return f1448f.intValue();
        }
    }

    public static void b(Context context) {
        if (f1454l) {
            return;
        }
        f1454l = true;
        cn.jiguang.be.a.a(context);
        if (b()) {
            try {
                cn.jiguang.dy.b.a().a(cn.jiguang.bz.d.a(), 1, "");
            } catch (Throwable unused) {
                cn.jiguang.bb.f.i("JCoreGobal", "u p call failed");
            }
        }
        i.a(context);
        cn.jiguang.bo.h.a().b(context);
        cn.jiguang.b.a.a().e(context);
        if (!((Boolean) cn.jiguang.e.b.a(context, cn.jiguang.e.a.an())).booleanValue()) {
            cn.jiguang.bb.b.b(context);
        }
        cn.jiguang.bz.b.a(context);
        cn.jiguang.bq.b.a().b();
        cn.jiguang.bq.c.a().b();
        cn.jiguang.bq.a.a().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() {
        f1453k = true;
        cn.jiguang.d.a.a().sendCurrentState();
    }

    private static void e(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            PushReceiver pushReceiver = new PushReceiver();
            if (Build.VERSION.SDK_INT < 28) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            s.a(context, pushReceiver, intentFilter, context.getPackageName() + f1443a, null, false);
        } catch (Throwable th) {
            cn.jiguang.bb.f.l("JCoreGobal", "registerPushReceiver fail:" + th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x007a A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:3:0x0004, B:5:0x002a, B:8:0x005e, B:10:0x007a, B:12:0x0084, B:16:0x0088, B:18:0x00ac, B:20:0x00b6, B:22:0x00c2, B:24:0x00c8, B:28:0x0038, B:30:0x003e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0088 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:3:0x0004, B:5:0x002a, B:8:0x005e, B:10:0x007a, B:12:0x0084, B:16:0x0088, B:18:0x00ac, B:20:0x00b6, B:22:0x00c2, B:24:0x00c8, B:28:0x0038, B:30:0x003e), top: B:2:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r6, java.lang.String r7, android.os.Bundle r8) {
        /*
            java.lang.String r0 = "curProcessName is "
            java.lang.String r1 = "JCoreGobal"
            android.content.Context r6 = cn.jiguang.bz.d.a(r6)     // Catch: java.lang.Throwable -> L35
            java.lang.String r2 = cn.jiguang.ba.d.b(r6)     // Catch: java.lang.Throwable -> L35
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            r3.<init>()     // Catch: java.lang.Throwable -> L35
            java.lang.String r4 = "serviceName is "
            r3.append(r4)     // Catch: java.lang.Throwable -> L35
            r3.append(r2)     // Catch: java.lang.Throwable -> L35
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L35
            cn.jiguang.bb.f.c(r1, r3)     // Catch: java.lang.Throwable -> L35
            cn.jiguang.ba.c r3 = cn.jiguang.ba.c.a()     // Catch: java.lang.Throwable -> L35
            boolean r3 = r3.g()     // Catch: java.lang.Throwable -> L35
            if (r3 != 0) goto L38
            cn.jiguang.ba.c r3 = cn.jiguang.ba.c.a()     // Catch: java.lang.Throwable -> L35
            boolean r3 = r3.f()     // Catch: java.lang.Throwable -> L35
            if (r3 == 0) goto L5e
            goto L38
        L35:
            r6 = move-exception
            goto Ld0
        L38:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L35
            if (r3 == 0) goto L5e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            r6.<init>()     // Catch: java.lang.Throwable -> L35
            java.lang.String r7 = "AndroidManifest.xml missing required service:"
            r6.append(r7)     // Catch: java.lang.Throwable -> L35
            java.lang.Class<cn.jpush.android.service.JCommonService> r7 = cn.jpush.android.service.JCommonService.class
            java.lang.String r7 = r7.getCanonicalName()     // Catch: java.lang.Throwable -> L35
            r6.append(r7)     // Catch: java.lang.Throwable -> L35
            java.lang.String r7 = ",please custom one service and extends JCommonService. Otherwise no service"
            r6.append(r7)     // Catch: java.lang.Throwable -> L35
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L35
            cn.jiguang.bb.f.n(r1, r6)     // Catch: java.lang.Throwable -> L35
            return
        L5e:
            java.lang.String r3 = cn.jiguang.bz.a.a(r6)     // Catch: java.lang.Throwable -> L35
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            r4.<init>()     // Catch: java.lang.Throwable -> L35
            r4.append(r0)     // Catch: java.lang.Throwable -> L35
            r4.append(r3)     // Catch: java.lang.Throwable -> L35
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L35
            cn.jiguang.bb.f.c(r1, r4)     // Catch: java.lang.Throwable -> L35
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L35
            if (r4 == 0) goto L88
            java.lang.String r0 = r6.getPackageName()     // Catch: java.lang.Throwable -> L35
            boolean r0 = r0.equals(r3)     // Catch: java.lang.Throwable -> L35
            if (r0 == 0) goto Lcf
        L84:
            b(r6, r7, r8)     // Catch: java.lang.Throwable -> L35
            return
        L88:
            java.lang.String r4 = cn.jiguang.ba.d.a(r6)     // Catch: java.lang.Throwable -> L35
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            r5.<init>()     // Catch: java.lang.Throwable -> L35
            r5.append(r0)     // Catch: java.lang.Throwable -> L35
            r5.append(r3)     // Catch: java.lang.Throwable -> L35
            java.lang.String r0 = ", remoteProcessName is "
            r5.append(r0)     // Catch: java.lang.Throwable -> L35
            r5.append(r4)     // Catch: java.lang.Throwable -> L35
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L35
            cn.jiguang.bb.f.c(r1, r0)     // Catch: java.lang.Throwable -> L35
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L35
            if (r0 != 0) goto Lc2
            java.lang.String r0 = r6.getPackageName()     // Catch: java.lang.Throwable -> L35
            boolean r0 = r0.equals(r3)     // Catch: java.lang.Throwable -> L35
            if (r0 == 0) goto Lc2
            java.lang.String r0 = "MAIN_IPC_ACTION_TASK"
            cn.jiguang.a.a$a r2 = new cn.jiguang.a.a$a     // Catch: java.lang.Throwable -> L35
            r3 = 0
            r2.<init>(r6, r3, r7, r8)     // Catch: java.lang.Throwable -> L35
            cn.jiguang.by.d.a(r0, r2)     // Catch: java.lang.Throwable -> L35
            return
        Lc2:
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L35
            if (r0 != 0) goto Lcf
            boolean r0 = r3.equals(r4)     // Catch: java.lang.Throwable -> L35
            if (r0 == 0) goto Lcf
            goto L84
        Lcf:
            return
        Ld0:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "sendToServiceAction failed, "
            r7.append(r8)
            java.lang.String r6 = r6.getMessage()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            cn.jiguang.bb.f.i(r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.a(android.content.Context, java.lang.String, android.os.Bundle):void");
    }

    public static void c(Context context) {
        String str;
        try {
            cn.jiguang.bb.f.f("JCoreGobal", "unRegisterCommonService start");
            context.unbindService(f1455m);
            String b6 = d.b(context);
            if (TextUtils.isEmpty(b6)) {
                str = "not found commonServiceClass（JCommonService）";
            } else {
                Intent intent = new Intent(JConstants.USER_SERVICE_ACTION);
                intent.setClassName(context, b6);
                intent.setPackage(context.getPackageName());
                context.stopService(intent);
                str = "unRegisterCommonService end";
            }
            cn.jiguang.bb.f.f("JCoreGobal", str);
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JCoreGobal", "unregister service failed, " + th.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007d A[Catch: all -> 0x00b0, TryCatch #0 {all -> 0x00b0, blocks: (B:5:0x0010, B:8:0x0028, B:10:0x003e, B:11:0x0058, B:12:0x006d, B:14:0x007d, B:16:0x0093, B:19:0x00ab, B:22:0x005c, B:23:0x0062), top: B:4:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(android.content.Context r13) {
        /*
            r0 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            if (r13 != 0) goto L9
            goto Lb0
        L9:
            java.lang.String r2 = "setInternalDebug"
            java.lang.String r3 = "JCoreGobal"
            cn.jiguang.bb.f.c(r3, r2)
            cn.jiguang.e.a r2 = cn.jiguang.e.a.aA()     // Catch: java.lang.Throwable -> Lb0
            java.lang.Object r2 = cn.jiguang.e.b.a(r13, r2)     // Catch: java.lang.Throwable -> Lb0
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> Lb0
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r4 = "setInternalDebug open"
            java.lang.String r5 = "FUTURE_TASK"
            java.lang.String r6 = "setInternalDebug is expire!"
            r7 = 2
            r8 = 1
            if (r2 != r8) goto L62
            long r9 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lb0
            cn.jiguang.e.a r2 = cn.jiguang.e.a.aC()     // Catch: java.lang.Throwable -> Lb0
            java.lang.Object r2 = cn.jiguang.e.b.a(r13, r2)     // Catch: java.lang.Throwable -> Lb0
            java.lang.Long r2 = (java.lang.Long) r2     // Catch: java.lang.Throwable -> Lb0
            long r11 = r2.longValue()     // Catch: java.lang.Throwable -> Lb0
            int r2 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r2 <= 0) goto L5c
            cn.jiguang.e.a r2 = cn.jiguang.e.a.aA()     // Catch: java.lang.Throwable -> Lb0
            cn.jiguang.e.a r2 = r2.a(r1)     // Catch: java.lang.Throwable -> Lb0
            cn.jiguang.e.a[] r9 = new cn.jiguang.e.a[r8]     // Catch: java.lang.Throwable -> Lb0
            r9[r0] = r2     // Catch: java.lang.Throwable -> Lb0
            cn.jiguang.e.b.a(r13, r9)     // Catch: java.lang.Throwable -> Lb0
            cn.jiguang.e.c.b(r13, r7)     // Catch: java.lang.Throwable -> Lb0
            cn.jiguang.bb.f.c(r3, r6)     // Catch: java.lang.Throwable -> Lb0
            cn.jiguang.a.a$2 r2 = new cn.jiguang.a.a$2     // Catch: java.lang.Throwable -> Lb0
            r2.<init>()     // Catch: java.lang.Throwable -> Lb0
        L58:
            cn.jiguang.by.d.a(r5, r2)     // Catch: java.lang.Throwable -> Lb0
            goto L6d
        L5c:
            cn.jiguang.bb.f.c(r3, r4)     // Catch: java.lang.Throwable -> Lb0
            cn.jiguang.a.a.f1449g = r8     // Catch: java.lang.Throwable -> Lb0
            goto L6d
        L62:
            java.lang.String r2 = "setInternalDebug close and delete log file"
            cn.jiguang.bb.f.c(r3, r2)     // Catch: java.lang.Throwable -> Lb0
            cn.jiguang.a.a$3 r2 = new cn.jiguang.a.a$3     // Catch: java.lang.Throwable -> Lb0
            r2.<init>()     // Catch: java.lang.Throwable -> Lb0
            goto L58
        L6d:
            cn.jiguang.e.a r2 = cn.jiguang.e.a.aB()     // Catch: java.lang.Throwable -> Lb0
            java.lang.Object r2 = cn.jiguang.e.b.a(r13, r2)     // Catch: java.lang.Throwable -> Lb0
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> Lb0
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> Lb0
            if (r2 != r8) goto Lb0
            long r9 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lb0
            cn.jiguang.e.a r2 = cn.jiguang.e.a.aC()     // Catch: java.lang.Throwable -> Lb0
            java.lang.Object r2 = cn.jiguang.e.b.a(r13, r2)     // Catch: java.lang.Throwable -> Lb0
            java.lang.Long r2 = (java.lang.Long) r2     // Catch: java.lang.Throwable -> Lb0
            long r11 = r2.longValue()     // Catch: java.lang.Throwable -> Lb0
            int r2 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r2 <= 0) goto Lab
            cn.jiguang.e.a r2 = cn.jiguang.e.a.aB()     // Catch: java.lang.Throwable -> Lb0
            cn.jiguang.e.a r1 = r2.a(r1)     // Catch: java.lang.Throwable -> Lb0
            cn.jiguang.e.a[] r2 = new cn.jiguang.e.a[r8]     // Catch: java.lang.Throwable -> Lb0
            r2[r0] = r1     // Catch: java.lang.Throwable -> Lb0
            cn.jiguang.e.b.a(r13, r2)     // Catch: java.lang.Throwable -> Lb0
            cn.jiguang.e.c.b(r13, r7)     // Catch: java.lang.Throwable -> Lb0
            cn.jiguang.internal.JConstants.CMD_TO_PRINT_ALL_LOG = r0     // Catch: java.lang.Throwable -> Lb0
            cn.jiguang.bb.f.c(r3, r6)     // Catch: java.lang.Throwable -> Lb0
            return
        Lab:
            cn.jiguang.bb.f.c(r3, r4)     // Catch: java.lang.Throwable -> Lb0
            cn.jiguang.internal.JConstants.CMD_TO_PRINT_ALL_LOG = r8     // Catch: java.lang.Throwable -> Lb0
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.d(android.content.Context):void");
    }

    private static void e(Context context, Bundle bundle) {
        String str;
        String b6 = d.b(context);
        if (TextUtils.isEmpty(b6)) {
            cn.jiguang.bb.f.f("JCoreGobal", "not found commonServiceClass（JCommonService）");
            return;
        }
        if (DataShare.isBinding()) {
            cn.jiguang.bb.f.c("JCoreGobal", "is binding service");
            return;
        }
        try {
            Intent intent = new Intent();
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            intent.setClass(context, Class.forName(b6));
            if (!context.bindService(intent, f1455m, 1)) {
                cn.jiguang.bb.f.a("JCoreGobal", "Remote Service bind failed");
            } else {
                cn.jiguang.bb.f.a("JCoreGobal", "Remote Service on binding...");
                DataShare.setBinding();
            }
        } catch (SecurityException unused) {
            str = "Remote Service bind failed caused by SecurityException!";
            cn.jiguang.bb.f.j("JCoreGobal", str);
        } catch (Throwable th) {
            str = "Remote Service bind failed :" + th;
            cn.jiguang.bb.f.j("JCoreGobal", str);
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f1452j = arrayList;
        arrayList.add("a7");
        f1452j.add("a8");
        f1452j.add("set_auth");
        f1452j.add("set_wake_enable");
        f1452j.add("a4");
        f1455m = new ServiceConnection() { // from class: cn.jiguang.a.a.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
                cn.jiguang.bb.f.c("JCoreGobal", "action - onServiceConnected, ComponentName:" + componentName);
                try {
                    cn.jiguang.be.b.e(new b("onServiceConnected-" + componentName) { // from class: cn.jiguang.a.a.1.1
                        @Override // cn.jiguang.by.b
                        public void a() {
                            try {
                                cn.jiguang.bb.f.f("JCoreGobal", "Remote Service bind success.");
                                DataShare.init(IDataShare.Stub.asInterface(iBinder), d.a(cn.jiguang.bz.d.a(null)));
                                a.d();
                            } catch (Throwable th) {
                                cn.jiguang.bb.f.l("JCoreGobal", "onServiceConnected run e:" + th);
                            }
                        }
                    });
                } catch (Throwable th) {
                    cn.jiguang.bb.f.l("JCoreGobal", "onServiceConnected e:" + th);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                cn.jiguang.bb.f.c("JCoreGobal", "action - onServiceDisconnected, ComponentName:" + componentName);
                a.f1453k = false;
            }
        };
    }

    public static void a(Context context, boolean z5, long j6) {
        a(context, z5, j6, 0L, 0, false);
    }

    public static void b(Context context, String str, Bundle bundle) {
        cn.jiguang.by.d.a("IPC_ACTION_TASK", new C0022a(context, true, str, bundle));
    }

    private static void c(Context context, Bundle bundle) {
        String b6 = d.b(context);
        if (TextUtils.isEmpty(b6)) {
            cn.jiguang.bb.f.f("JCoreGobal", "not found commonServiceClass（JCommonService）");
            return;
        }
        try {
            Intent intent = new Intent(StubApp.getOrigApplicationContext(context.getApplicationContext()), Class.forName(b6));
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            context.startService(intent);
            cn.jiguang.bb.f.c("JCoreGobal", "start common service");
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, Bundle bundle) {
        cn.jiguang.bb.f.c("JCoreGobal", "setCountry...bundle=" + bundle);
        long c6 = cn.jiguang.bg.c.c(context);
        String string = bundle.getString("sdk_type");
        if (TextUtils.isEmpty(string)) {
            string = JConstants.SDK_TYPE;
        }
        String str = string;
        String string2 = bundle.getString("set_country");
        if (TextUtils.isEmpty(string2)) {
            cn.jiguang.bb.f.m("JCoreGobal", "setCountry is empty");
            return;
        }
        cn.jiguang.bb.f.d("JCoreGobal", "setCountry - action:" + string2);
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.K().a((cn.jiguang.e.a<String>) string2)});
        cn.jiguang.bn.b bVar = new cn.jiguang.bn.b(8192);
        bVar.a(string2);
        cn.jiguang.bi.i.a().a(context, c6, 41, 1, bVar.b(), str, 10000L);
    }

    public static void a(Context context, boolean z5, long j6, long j7, int i6, boolean z6) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("force", z5);
            bundle.putLong("delay_time", j6);
            if (z6) {
                if (j7 > g.f2240d || j7 < 3000) {
                    cn.jiguang.bb.f.c("JCoreGobal", "set  heartbeatTimeOut=" + j7 + " need force change to default value=" + g.f2240d);
                    j7 = g.f2240d;
                }
                if (i6 > g.f2239c || i6 < 1) {
                    cn.jiguang.bb.f.c("JCoreGobal", "set  heartbeatTimeOutCount=" + i6 + " need force change to default value=" + g.f2239c);
                    i6 = g.f2239c;
                }
                bundle.putInt("heartbeat_time_out_count", i6);
                bundle.putLong("heartbeat_time_out", j7);
            }
            cn.jiguang.bb.f.d("JCoreGobal", " sendRtcToTcp  bundle=" + bundle);
            a(context, "tcp_a2", bundle);
        } catch (Throwable th) {
            cn.jiguang.bb.f.j("JCoreGobal", "sendHeartBeat error:" + th);
        }
    }

    public static boolean b() {
        try {
            Class.forName("cn.jiguang.dy.b");
        } catch (Throwable unused) {
        }
        return true;
    }

    public static boolean a() {
        Boolean bool = f1447e;
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        Integer num = f1448f;
        return num != null && num.intValue() == 0;
    }

    public static synchronized boolean a(Context context, Bundle bundle) {
        synchronized (a.class) {
            Boolean bool = f1447e;
            if (bool != null) {
                return bool.booleanValue();
            }
            if (context == null) {
                cn.jiguang.bb.f.m("JCoreGobal", "init failed,context is null");
                return false;
            }
            d(context);
            cn.jiguang.bz.d.a(context);
            cn.jiguang.bb.f.h("JCoreGobal", "main process init - jcore, SdkVersion:" + f1444b + ", build id:173 build type:release");
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            cn.jiguang.ba.c.a();
            String b6 = d.b(origApplicationContext);
            if ((cn.jiguang.ba.c.a().g() || cn.jiguang.ba.c.a().f()) && TextUtils.isEmpty(b6)) {
                f1447e = Boolean.FALSE;
                cn.jiguang.bb.f.n("JCoreGobal", "AndroidManifest.xml missing required service:" + JCommonService.class.getCanonicalName() + ",please custom one service and extends JCommonService. Otherwise no service");
                return false;
            }
            try {
                cn.jiguang.b.a.a().b();
            } catch (Throwable unused) {
            }
            i.a(origApplicationContext);
            c(origApplicationContext, bundle);
            e(origApplicationContext, bundle);
            Boolean bool2 = Boolean.TRUE;
            f1447e = bool2;
            return bool2.booleanValue();
        }
    }
}
