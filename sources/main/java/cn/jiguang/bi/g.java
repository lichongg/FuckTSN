package cn.jiguang.bi;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import cn.jiguang.bg.c;
import cn.jiguang.bz.o;
import cn.jiguang.internal.JConstants;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static int f2237a = 290;

    /* renamed from: b, reason: collision with root package name */
    public static int f2238b = 30;

    /* renamed from: h, reason: collision with root package name */
    private volatile AtomicReference<cn.jiguang.bg.h> f2244h;

    /* renamed from: i, reason: collision with root package name */
    private int f2245i;

    /* renamed from: j, reason: collision with root package name */
    private int f2246j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2247k;

    /* renamed from: l, reason: collision with root package name */
    private int f2248l;

    /* renamed from: m, reason: collision with root package name */
    private int f2249m;

    /* renamed from: n, reason: collision with root package name */
    private long f2250n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f2251o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f2252p;

    /* renamed from: q, reason: collision with root package name */
    private Context f2253q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f2254r;

    /* renamed from: s, reason: collision with root package name */
    private final AtomicBoolean f2255s;

    /* renamed from: t, reason: collision with root package name */
    private cn.jiguang.bm.a f2256t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f2257u;

    /* renamed from: v, reason: collision with root package name */
    private int f2258v;

    /* renamed from: w, reason: collision with root package name */
    private int f2259w;

    /* renamed from: d, reason: collision with root package name */
    public static long f2240d = 10000;

    /* renamed from: f, reason: collision with root package name */
    private static AtomicReference<Long> f2242f = new AtomicReference<>(Long.valueOf(f2240d));

    /* renamed from: c, reason: collision with root package name */
    public static int f2239c = 2;

    /* renamed from: g, reason: collision with root package name */
    private static AtomicReference<Integer> f2243g = new AtomicReference<>(Integer.valueOf(f2239c));

    /* renamed from: e, reason: collision with root package name */
    public static boolean f2241e = false;

    class a extends cn.jiguang.by.b {

        /* renamed from: b, reason: collision with root package name */
        private Context f2262b;

        /* renamed from: c, reason: collision with root package name */
        private String f2263c;

        /* renamed from: d, reason: collision with root package name */
        private Bundle f2264d;

        public a(Context context, String str, Bundle bundle) {
            this.f2262b = context;
            this.f2263c = str;
            this.f2264d = bundle;
            this.f2653h = "TcpManager";
        }

        /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void b() {
            /*
                r6 = this;
                java.lang.String r0 = "JPUSH"
                boolean r1 = cn.jiguang.d.a.a(r0)
                r2 = 1
                java.lang.String r3 = "JCoreTCPManager"
                if (r1 == 0) goto L20
                android.content.Context r1 = r6.f2262b
                java.lang.Integer r1 = cn.jiguang.d.a.n(r1)
                if (r1 == 0) goto L1b
                int r1 = r1.intValue()
                r4 = 590(0x24e, float:8.27E-43)
                if (r1 >= r4) goto L25
            L1b:
                cn.jiguang.bi.g.f2241e = r2
                java.lang.String r1 = "isJPushCallUp: JPush version < 590, set isPushInit true"
                goto L22
            L20:
                java.lang.String r1 = "isJPushCallUp: No JDispatchActionSdkType branch"
            L22:
                cn.jiguang.bb.f.c(r3, r1)
            L25:
                android.os.Bundle r1 = r6.f2264d
                if (r1 == 0) goto L4d
                java.lang.String r4 = "jg_init_sdk_type"
                java.lang.String r5 = ""
                java.lang.String r1 = r1.getString(r4, r5)
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "isJPushCallUp: sdkType:"
                r4.append(r5)
                r4.append(r1)
                java.lang.String r4 = r4.toString()
                cn.jiguang.bb.f.c(r3, r4)
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L4d
                cn.jiguang.bi.g.f2241e = r2
            L4d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bi.g.a.b():void");
        }

        @Override // cn.jiguang.by.b
        public void a() {
            long j6;
            long j7;
            try {
                if (this.f2263c.equals("tcp_a1")) {
                    cn.jiguang.bv.e.a();
                    cn.jiguang.v.a.a(this.f2262b, "tcp_a1", null);
                }
                if (!this.f2263c.equals("tcp_a1") && !this.f2263c.equals("tcp_a28")) {
                    if (this.f2263c.equals("tcp_a3")) {
                        j6 = 0;
                    } else {
                        j6 = 0;
                        if (!this.f2263c.equals("tcp_a4") && !this.f2263c.equals("tcp_a20")) {
                            if (this.f2263c.equals("tcp_a5")) {
                                Bundle bundle = this.f2264d;
                                if (bundle != null) {
                                    byte[] byteArray = bundle.getByteArray("body");
                                    int i6 = this.f2264d.getInt("cmd", -1);
                                    int i7 = this.f2264d.getInt("ver", -1);
                                    long j8 = this.f2264d.getLong("rid", -1L);
                                    String string = this.f2264d.getString("sdk_type");
                                    long j9 = this.f2264d.getLong("timeout");
                                    cn.jiguang.bb.f.c("JCoreTCPManager", "send quest,cmd:" + i6 + ",ver:" + i7 + ",rid:" + j8 + ",body size:" + byteArray.length);
                                    if (i6 >= 0 && i7 >= 0 && j8 >= 0 && !TextUtils.isEmpty(string)) {
                                        i.a().a(this.f2262b, j8, i6, i7, byteArray, string, j9);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            int i8 = 0;
                            if (this.f2263c.equals("tcp_a19")) {
                                Bundle bundle2 = this.f2264d;
                                if (bundle2 != null) {
                                    g.this.f2247k = bundle2.getBoolean("connect_state", false);
                                    i8 = this.f2264d.getInt("connect_instance_id", 0);
                                }
                                g.this.b(i8);
                                return;
                            }
                            if (this.f2263c.equals("tcp_a11")) {
                                cn.jiguang.bb.f.d("JCoreTCPManager", "resgiter success:" + cn.jiguang.d.a.b(this.f2262b));
                                cn.jiguang.bz.a.f(this.f2262b);
                                cn.jiguang.bi.b a6 = cn.jiguang.bi.b.a();
                                Context context = this.f2262b;
                                a6.a(context, 0, 0, cn.jiguang.d.a.b(context));
                                cn.jiguang.v.a.a(this.f2262b, "on_register", null);
                                return;
                            }
                            if (this.f2263c.equals("tcp_a10")) {
                                g.this.j();
                                return;
                            }
                            if (this.f2263c.equals("tcp_a9")) {
                                g.this.d(this.f2262b);
                                return;
                            }
                            if (this.f2263c.equals("tcp_a8")) {
                                g.this.b(this.f2262b);
                                return;
                            }
                            if (this.f2263c.equals("tcp_a23")) {
                                g.this.l();
                                return;
                            }
                            if (this.f2263c.equals("tcp_a2")) {
                                f.a().a(this.f2262b, false);
                                g.this.a(this.f2264d);
                                return;
                            }
                            if (this.f2263c.equals("tcp_a13")) {
                                cn.jiguang.bb.f.d("JCoreTCPManager", "resgiter failed");
                                Bundle bundle3 = this.f2264d;
                                if (bundle3 != null) {
                                    int i9 = bundle3.getInt("resCode", 0);
                                    g.this.f2246j = i9;
                                    cn.jiguang.bg.c.a(this.f2262b, i9);
                                    return;
                                }
                                return;
                            }
                            if (this.f2263c.equals("tcp_a12")) {
                                cn.jiguang.bb.f.d("JCoreTCPManager", "login failed");
                                Bundle bundle4 = this.f2264d;
                                if (bundle4 != null) {
                                    g.this.a(bundle4.getInt("resCode", 0));
                                    return;
                                }
                                return;
                            }
                            if (!this.f2263c.equals("tcp_a14")) {
                                if (this.f2263c.equals("tcp_a15")) {
                                    g.this.b(this.f2264d);
                                    return;
                                }
                                if (this.f2263c.equals("tcp_a16")) {
                                    g.this.c(this.f2264d);
                                    return;
                                }
                                if (!this.f2263c.equals("tcp_a17")) {
                                    if (this.f2263c.equals("tcp_a26")) {
                                        cn.jiguang.bb.f.c("JCoreTCPManager", "check heartbeat status");
                                    } else {
                                        if (this.f2263c.equals("tcp_a18")) {
                                            g.this.s();
                                            return;
                                        }
                                        if (this.f2263c.equals("tcp_a6")) {
                                            Bundle bundle5 = this.f2264d;
                                            if (bundle5 != null) {
                                                long j10 = bundle5.getLong("rid", -1L);
                                                if (j10 > 0) {
                                                    i.a().b(this.f2262b, j10);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        if (this.f2263c.equals("tcp_a7")) {
                                            Bundle bundle6 = this.f2264d;
                                            if (bundle6 != null) {
                                                long j11 = bundle6.getLong("rid", -1L);
                                                if (j11 > 0) {
                                                    i.a().a(this.f2262b, j11);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        if (this.f2263c.equals("tcp_a21")) {
                                            g.this.k();
                                            return;
                                        }
                                        if (this.f2263c.equals("tcp_a22")) {
                                            g.this.b();
                                            return;
                                        }
                                        if (this.f2263c.equals("tcp_a23")) {
                                            g.this.c(this.f2262b);
                                            return;
                                        } else {
                                            if (!this.f2263c.equals("tcp_a24") && !this.f2263c.equals("tcp_a25")) {
                                                return;
                                            }
                                            b();
                                            g.this.l();
                                            g.this.f2246j = 0;
                                            g.this.f2245i = 0;
                                        }
                                    }
                                }
                                g.this.q();
                                return;
                            }
                            g.this.n();
                        }
                    }
                    if (g.this.o()) {
                        cn.jiguang.bb.f.c("JCoreTCPManager", "send data failed:tcp breaked,will restart");
                        g.this.n();
                    }
                    byte[] byteArray2 = this.f2264d.getByteArray("body");
                    int i10 = this.f2264d.getInt("cmd", -1);
                    int i11 = this.f2264d.getInt("ver", -1);
                    long j12 = this.f2264d.getLong("rid", -1L);
                    String string2 = this.f2264d.getString("sdk_type");
                    cn.jiguang.bb.f.c("JCoreTCPManager", "send data,cmd:" + i10 + ",ver:" + i11 + ",rid:" + j12 + ",body size:" + byteArray2.length);
                    if (i10 >= 0 && i11 >= 0 && j12 >= j6) {
                        if (this.f2263c.equals("tcp_a3")) {
                            i.a().a(this.f2262b, j12, i10, i11, byteArray2, string2);
                            return;
                        }
                        if (this.f2263c.equals("tcp_a20")) {
                            long j13 = j6;
                            long j14 = this.f2264d.getLong("uid", j13);
                            if (j14 == j13) {
                                cn.jiguang.bb.f.i("JCoreTCPManager", "share response uid is 0");
                                return;
                            }
                            j7 = j14;
                        } else {
                            j7 = j6;
                        }
                        int a7 = g.a().c().e().a(cn.jiguang.bk.b.a(this.f2262b, i10, i11, j12, byteArray2, j7));
                        if (a7 != 0) {
                            c.a.a(this.f2262b, 1500, "code:" + a7);
                            return;
                        }
                        return;
                    }
                    return;
                }
                boolean z5 = g.f2241e;
                b();
                if (g.this.o()) {
                    g.this.n();
                } else {
                    if (z5 == g.f2241e || !g.this.f2251o) {
                        return;
                    }
                    g.this.r();
                }
            } catch (Throwable th) {
                cn.jiguang.bb.f.j("JCoreTCPManager", "tcp action failed:" + th.getMessage());
            }
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final g f2265a = new g();
    }

    private g() {
        this.f2244h = new AtomicReference<>();
        this.f2247k = false;
        this.f2248l = 0;
        this.f2249m = 0;
        this.f2254r = false;
        this.f2255s = new AtomicBoolean(false);
        this.f2256t = new cn.jiguang.bm.a() { // from class: cn.jiguang.bi.g.1
            @Override // cn.jiguang.bm.a
            public void a(Message message) {
                if (message != null) {
                    int i6 = message.what;
                    if (i6 == 1011) {
                        g gVar = g.this;
                        gVar.a(gVar.f2253q, "tcp_a14", null);
                        return;
                    }
                    if (i6 == 1022) {
                        g gVar2 = g.this;
                        gVar2.a(gVar2.f2253q, "tcp_a17", null);
                        return;
                    }
                    if (i6 == 2000) {
                        j.a().a(g.this.f2253q);
                        return;
                    }
                    if (i6 == 2001) {
                        boolean o5 = g.this.o();
                        StringBuilder sb = new StringBuilder();
                        sb.append("check socket connected=");
                        sb.append(!o5);
                        cn.jiguang.bb.f.c("JCoreTCPManager", sb.toString());
                        if (o5) {
                            cn.jiguang.bb.f.c("JCoreTCPManager", "socket disconnect,need to restart");
                            g gVar3 = g.this;
                            gVar3.a(gVar3.f2253q, "tcp_a25", null);
                            return;
                        }
                        return;
                    }
                    switch (i6) {
                        case 1004:
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("force", true);
                            g gVar4 = g.this;
                            gVar4.a(gVar4.f2253q, "tcp_a16", bundle);
                            break;
                        case 1005:
                            Bundle bundle2 = new Bundle();
                            bundle2.putBoolean("force", false);
                            g gVar5 = g.this;
                            gVar5.a(gVar5.f2253q, "tcp_a16", bundle2);
                            break;
                        case 1006:
                        case 1007:
                            g gVar6 = g.this;
                            gVar6.a(gVar6.f2253q, "tcp_a2", null);
                            break;
                    }
                }
            }
        };
        this.f2257u = false;
        this.f2258v = 0;
        this.f2259w = 0;
        this.f2252p = true;
        this.f2253q = cn.jiguang.bz.d.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        cn.jiguang.bb.f.d("JCoreTCPManager", "Action - onLoggedIn");
        if (!this.f2251o) {
            this.f2251o = true;
            cn.jiguang.bi.b.a().a(this.f2253q, 1, 0, "success");
        }
        b();
        this.f2248l = 0;
        this.f2249m = 0;
        cn.jiguang.a.a.b(this.f2253q);
        cn.jiguang.bb.f.c("JCoreTCPManager", "Force to send 12s heartbeat after login");
        cn.jiguang.a.a.a(this.f2253q, true, 5000L);
        cn.jiguang.v.a.a(this.f2253q, "on_logged", null);
        Bundle bundle = new Bundle();
        bundle.putBoolean("login", true);
        cn.jiguang.v.a.a(this.f2253q, "periodtask", bundle);
        if (k()) {
            cn.jiguang.bm.b.a().b(2000, 2000L, this.f2256t);
            i.a().a(this.f2253q);
            f.a().a(this.f2253q, true);
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("state", true);
            cn.jiguang.ba.g.a().a("isTcpLoggedIn", bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l() {
        try {
            cn.jiguang.bg.h c6 = c();
            if (c6 != null) {
                c6.c();
                this.f2244h.set(null);
            } else {
                cn.jiguang.bb.f.c("JCoreTCPManager", "tcp has stopeed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n() {
        cn.jiguang.bb.f.d("JCoreTCPManager", "Action - restartNetworkingClient, pid:" + Process.myPid());
        if (!this.f2252p) {
            cn.jiguang.bb.f.h("JCoreTCPManager", "need not keep tcp,next start app will re login");
            return;
        }
        if (!o.c()) {
            cn.jiguang.bb.f.h("JCoreTCPManager", "No network connection. Give up to start connection thread.");
            return;
        }
        if (((Boolean) cn.jiguang.e.b.a(this.f2253q, cn.jiguang.e.a.af())).booleanValue()) {
            cn.jiguang.bb.f.e("JCoreTCPManager", "[restartNetworkingClient] tcp has close by active");
            return;
        }
        if (!cn.jiguang.bq.b.a().b(this.f2253q)) {
            cn.jiguang.bb.f.e("JCoreTCPManager", "[restartNetworkingClient] sdk limit");
            return;
        }
        if (!((Boolean) cn.jiguang.e.b.a(this.f2253q, cn.jiguang.e.a.Q())).booleanValue()) {
            cn.jiguang.bb.f.e("JCoreTCPManager", "[restartNetworkingClient] tcp has close by ups.unregister");
            return;
        }
        int i6 = this.f2246j;
        if (i6 != 1005 && i6 != 1006 && i6 != 1008 && i6 != 1009) {
            if (this.f2245i == 102) {
                cn.jiguang.bb.f.k("JCoreTCPManager", "login failed:102,give up start connection thread.reset from next app start");
                return;
            }
            if (!o()) {
                cn.jiguang.bb.f.d("JCoreTCPManager", "NetworkingClient is running");
                return;
            }
            cn.jiguang.bg.h hVar = this.f2244h.get();
            if (hVar != null && hVar.d()) {
                cn.jiguang.bb.f.d("JCoreTCPManager", "socket is  connecting");
                return;
            }
            if (hVar != null) {
                try {
                    hVar.c();
                    this.f2244h.set(null);
                } catch (Throwable th) {
                    cn.jiguang.bb.f.c("JCoreTCPManager", "start throwable =" + th);
                }
            }
            cn.jiguang.bb.f.c("JCoreTCPManager", "start to new NetworkingClient");
            cn.jiguang.bg.h hVar2 = new cn.jiguang.bg.h(StubApp.getOrigApplicationContext(this.f2253q.getApplicationContext()));
            cn.jiguang.bb.f.c("JCoreTCPManager", "start to connect =" + hVar2);
            hVar2.b();
            this.f2244h.set(hVar2);
            cn.jiguang.bm.b.a().b(2001, 90000L, this.f2256t);
            return;
        }
        cn.jiguang.bb.f.c("JCoreTCPManager", "[restartNetworkingClient] registerErrCode >0,registerErrCode:" + this.f2246j);
        cn.jiguang.bi.b.a().a(this.f2253q, 2002, this.f2246j, "");
    }

    public cn.jiguang.bg.h c() {
        return this.f2244h.get();
    }

    public void e() {
        cn.jiguang.bb.f.c("JCoreTCPManager", "updateHeartBeatInterval  -- current HeartBeatInterval = " + this.f2259w);
        int i6 = this.f2258v;
        if (i6 > 0) {
            int i7 = this.f2259w;
            if (i7 == 0) {
                this.f2259w = i6 * 2;
                return;
            }
            int i8 = i7 * 2;
            int i9 = JConstants.DEFAULT_HEARTBEAT_INTERVAL;
            if (i8 < i9 / 2) {
                this.f2259w = i7 * 2;
            } else {
                this.f2259w = i9;
            }
        }
    }

    public int f() {
        cn.jiguang.bb.f.c("JCoreTCPManager", "getHeartBeatInterval  -- current HeartBeatInterval = " + this.f2259w);
        int i6 = this.f2258v;
        if (i6 <= 0) {
            return JConstants.DEFAULT_HEARTBEAT_INTERVAL;
        }
        int i7 = this.f2259w;
        return i7 == 0 ? i6 : i7;
    }

    public int g() {
        cn.jiguang.bb.f.c("JCoreTCPManager", "getNextHbIntervalForLog  -- current HeartBeatInterval = " + this.f2259w);
        int i6 = this.f2258v;
        if (i6 <= 0) {
            return JConstants.DEFAULT_HEARTBEAT_INTERVAL;
        }
        int i7 = this.f2259w;
        if (i7 == 0) {
            int i8 = i6 * 2;
            int i9 = JConstants.DEFAULT_HEARTBEAT_INTERVAL;
            return i8 < i9 / 2 ? i6 * 2 : i9;
        }
        int i10 = i7 * 2;
        int i11 = JConstants.DEFAULT_HEARTBEAT_INTERVAL;
        return i10 < i11 / 2 ? i7 * 2 : i11;
    }

    public int h() {
        cn.jiguang.bb.f.c("JCoreTCPManager", "getAlarmDelay  -- current HeartBeatInterval = " + this.f2259w);
        int i6 = this.f2258v;
        if (i6 <= 0) {
            return JConstants.DEFAULT_ALARM_DELAY;
        }
        int i7 = this.f2259w;
        return i7 == 0 ? i6 + 5 : i7 + 5;
    }

    public void i() {
        this.f2259w = 0;
        f.a().b();
    }

    public static g a() {
        return b.f2265a;
    }

    private synchronized void c(int i6) {
        cn.jiguang.bg.h c6;
        try {
            cn.jiguang.bb.f.c("JCoreTCPManager", "closeTcp instanceId:" + i6);
            if (i6 <= 0 || ((c6 = c()) != null && c6.f() == i6)) {
                l();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("closeTcp instanceId not match, current:");
                sb.append(c6 != null ? Integer.valueOf(c6.f()) : "null");
                cn.jiguang.bb.f.c("JCoreTCPManager", sb.toString());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context) {
        cn.jiguang.bb.f.c("JCoreTCPManager", "handleResume...");
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.af().a((cn.jiguang.e.a<Boolean>) Boolean.FALSE)});
        a(false);
        if (this.f2251o) {
            cn.jiguang.bb.f.c("JCoreTCPManager", "[handleResume] is loggedin");
        } else {
            n();
        }
    }

    private void m() {
        int i6;
        String str;
        cn.jiguang.bb.f.d("JCoreTCPManager", "Action - retryConnect - disconnectedTimes:" + this.f2248l);
        if (!o.c()) {
            str = "[retryConnect] network is not connect";
        } else {
            if (this.f2246j <= 0) {
                cn.jiguang.bb.f.c("JCoreTCPManager", "[retryConnect] mDisconnectedTimes:" + this.f2248l);
                if (this.f2248l == 0) {
                    n();
                    return;
                }
                try {
                    i6 = cn.jiguang.bz.a.c(StubApp.getOrigApplicationContext(this.f2253q.getApplicationContext()));
                } catch (Throwable unused) {
                    i6 = -1;
                }
                int pow = (int) (Math.pow(2.0d, this.f2248l) * 3.0d * 1000.0d);
                int f6 = f();
                int i7 = (f6 * 1000) / 2;
                if (pow > i7) {
                    pow = i7;
                }
                cn.jiguang.bb.f.c("JCoreTCPManager", "[retryConnect] mDisconnectedTimes:" + this.f2248l + ",chargedLever:" + i6 + ",heartbeatInterval:" + f6 + ",delayTime:" + pow);
                if (cn.jiguang.bg.c.d(StubApp.getOrigApplicationContext(this.f2253q.getApplicationContext())) && this.f2247k) {
                    cn.jiguang.bb.f.c("JCoreTCPManager", "tcp ssl retry connect times use up, use no ssl retry again.");
                    cn.jiguang.bg.c.a(false);
                    this.f2248l = 0;
                }
                if (i6 == 1) {
                    if (this.f2248l >= 30) {
                        return;
                    }
                } else if (this.f2248l >= 5) {
                    return;
                }
                if (cn.jiguang.bm.b.a().a(1011)) {
                    cn.jiguang.bb.f.c("JCoreTCPManager", "Already has MSG_RESTART_CONN");
                    return;
                } else {
                    cn.jiguang.bb.f.c("JCoreTCPManager", "send MSG_RESTART_CONN");
                    cn.jiguang.bm.b.a().b(1011, pow, this.f2256t);
                    return;
                }
            }
            str = "[retryConnect] registerErrCode >0,registerErrCode:" + this.f2246j;
        }
        cn.jiguang.bb.f.c("JCoreTCPManager", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        cn.jiguang.bg.h hVar = this.f2244h.get();
        return hVar == null || hVar.e() == null || !hVar.e().b();
    }

    private boolean p() {
        int i6 = this.f2258v;
        long currentTimeMillis = System.currentTimeMillis() - this.f2250n;
        return i6 > 0 ? currentTimeMillis < ((long) (this.f2258v + (-4))) * 1000 : currentTimeMillis < 18000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        boolean z5 = this.f2255s.get();
        cn.jiguang.bb.f.c("JCoreTCPManager", "check isBeating status=" + z5);
        if (z5) {
            this.f2255s.set(false);
            this.f2249m++;
            cn.jiguang.bb.f.d("JCoreTCPManager", "Action - onHeartbeatTimeout - timeoutTimes:" + this.f2249m);
            cn.jiguang.bb.f.b("JCoreTCPManager", "============================================================");
            if (c() != null && !this.f2251o) {
                cn.jiguang.bb.f.d("JCoreTCPManager", "Is connecting now. Give up to retry.");
                return;
            }
            if (!this.f2251o || this.f2249m > 1) {
                l();
                m();
            } else {
                cn.jiguang.bb.f.d("JCoreTCPManager", "Already logged in. Give up to retry.");
                cn.jiguang.bm.b.a().b(1005, 5000L, this.f2256t);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.f2255s.set(true);
        cn.jiguang.bm.b.a().b(1022);
        long c6 = cn.jiguang.bg.c.c(this.f2253q);
        long f6 = cn.jiguang.d.a.f(this.f2253q);
        int i6 = cn.jiguang.be.b.f2035a;
        boolean z5 = f2241e;
        cn.jiguang.bb.f.e("JCoreTCPManager", "heartbeat initPushSdk:" + (z5 ? 1 : 0));
        cn.jiguang.bb.f.c("JCoreTCPManager", "heartbeat - juid:" + f6 + ", flag:1 ,userType:" + i6 + " ,initPushSdk:" + (z5 ? 1 : 0));
        byte[] a6 = cn.jiguang.bk.b.a(this.f2253q, cn.jiguang.bk.b.a(c6, JConstants.tcpSessionId, f6, (short) 1, i6, JConstants.DEFAULT_HEARTBEAT_INTERVAL, z5 ? 1 : 0));
        if (a6 != null) {
            c().e().a(a6);
        } else {
            cn.jiguang.bb.f.j("JCoreTCPManager", "send hb failed:sendData is null");
        }
        cn.jiguang.bm.b.a().b(1022, 10000L, this.f2256t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        cn.jiguang.bb.f.d("JCoreTCPManager", "Action - onHeartbeatSucceed");
        cn.jiguang.bi.b.a().a(this.f2253q, 19, 0, "ack success");
    }

    public void b() {
        cn.jiguang.bm.b.a().b(1022);
        this.f2250n = System.currentTimeMillis();
        this.f2249m = 0;
        this.f2255s.set(false);
        cn.jiguang.bb.f.f("JCoreTCPManager", "update rtc state");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i6) {
        this.f2245i = i6;
        if (i6 == 1012) {
            cn.jiguang.bg.c.a(this.f2253q);
        }
        l();
        Bundle bundle = new Bundle();
        bundle.putBoolean("state", false);
        cn.jiguang.ba.g.a().a("isTcpLoggedIn", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i6) {
        cn.jiguang.bb.f.d("JCoreTCPManager", "Action - onDisconnected");
        if (this.f2251o) {
            this.f2251o = false;
            cn.jiguang.bi.b.a().a(this.f2253q, -1, -1, "push connect break");
        }
        if (c() == null && ((Boolean) cn.jiguang.e.b.a(this.f2253q, cn.jiguang.e.a.af())).booleanValue()) {
            cn.jiguang.bb.f.c("JCoreTCPManager", "push already stopped!!!");
            return;
        }
        this.f2249m = 0;
        c(i6);
        m();
        this.f2248l++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        cn.jiguang.bb.f.c("JCoreTCPManager", "handleUnRegister...");
        if (!((Boolean) cn.jiguang.e.b.a(context, cn.jiguang.e.a.Q())).booleanValue()) {
            cn.jiguang.bb.f.d("JCoreTCPManager", "tcp already stoped");
        } else if (!cn.jiguang.bi.b.a().a(0)) {
            cn.jiguang.bb.f.c("JCoreTCPManager", "Action: handleUnRegister - can't stop tcp");
        } else {
            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.Q().a((cn.jiguang.e.a<Boolean>) Boolean.FALSE)});
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        if (!cn.jiguang.ba.c.a().a(this.f2253q) && !j.a().b(this.f2253q)) {
            cn.jiguang.bb.f.c("JCoreTCPManager", "not keep tcp");
            this.f2252p = false;
            l();
            return false;
        }
        return true;
    }

    public boolean d() {
        return this.f2251o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        cn.jiguang.bb.f.c("JCoreTCPManager", "handleStop...");
        if (((Boolean) cn.jiguang.e.b.a(context, cn.jiguang.e.a.af())).booleanValue()) {
            cn.jiguang.bb.f.d("JCoreTCPManager", "tcp already stoped");
        } else {
            if (!cn.jiguang.bi.b.a().a(0)) {
                cn.jiguang.bb.f.c("JCoreTCPManager", "Action: handleStopPush - can't stop tcp");
                return;
            }
            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.af().a((cn.jiguang.e.a<Boolean>) Boolean.TRUE)});
            a(true);
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Bundle bundle) {
        String str;
        if (this.f2255s.get()) {
            str = "isBeating, skip this time";
        } else {
            if ((bundle != null ? bundle.getBoolean("force", false) : false) || !p()) {
                cn.jiguang.bb.f.d("JCoreTCPManager", "Send heart beat");
                cn.jiguang.bm.b.a().b(1005);
                if (this.f2251o) {
                    r();
                    return;
                }
                str = "socket is closed or push isn't login";
            } else {
                str = "No need to rtc, Because it have succeed recently";
            }
        }
        cn.jiguang.bb.f.c("JCoreTCPManager", str);
    }

    public synchronized void a(Context context) {
        if (this.f2254r) {
            return;
        }
        cn.jiguang.bb.f.c("JCoreTCPManager", "hb:" + f() + ",google:false,google pure : false,internal:false");
        cn.jiguang.bb.f.c("JCoreTCPManager", "init tcp manager...");
        this.f2253q = cn.jiguang.bz.d.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        cn.jiguang.bm.b.a().a(this.f2253q);
        f.a().a(context, true);
        a(((Boolean) cn.jiguang.e.b.a(cn.jiguang.bz.d.a(), cn.jiguang.e.a.af())).booleanValue());
        this.f2254r = true;
    }

    public void a(Context context, String str, Bundle bundle) {
        a(context);
        cn.jiguang.be.b.d(new a(context, str, bundle));
    }

    public void b(Bundle bundle) {
        if (((Boolean) cn.jiguang.e.b.a(this.f2253q, cn.jiguang.e.a.af())).booleanValue()) {
            cn.jiguang.bb.f.i("JCoreTCPManager", "[netWorkChanged] tcp has close by active");
            return;
        }
        cn.jiguang.bm.b.a().b(1006);
        cn.jiguang.bm.b.a().b(1007);
        if (!bundle.getBoolean("connected", false)) {
            cn.jiguang.bb.f.c("JCoreTCPManager", "Handle disconnected state.");
            cn.jiguang.bm.b.a().b(1007, 3000L, this.f2256t);
            return;
        }
        cn.jiguang.bb.f.c("JCoreTCPManager", "Handle connected state.");
        if (o()) {
            n();
        } else {
            cn.jiguang.bm.b.a().b(1006, 3000L, this.f2256t);
        }
    }

    public void a(Bundle bundle) {
        long j6;
        if (((Boolean) cn.jiguang.e.b.a(this.f2253q, cn.jiguang.e.a.af())).booleanValue()) {
            cn.jiguang.bb.f.d("JCoreTCPManager", "[rtc] tcp has close by active");
            return;
        }
        boolean z5 = true;
        if (bundle != null) {
            z5 = bundle.getBoolean("force", true);
            j6 = bundle.getLong("delay_time", 0L);
            if (bundle.containsKey("heartbeat_time_out") || bundle.containsKey("heartbeat_time_out_count")) {
                f2242f.set(Long.valueOf(bundle.getLong("heartbeat_time_out", f2240d)));
                f2243g.set(Integer.valueOf(bundle.getInt("heartbeat_time_out_count", f2239c)));
                cn.jiguang.bb.f.d("JCoreTCPManager", " update heartbeatTimeOutCount=" + f2243g.get());
                cn.jiguang.bb.f.d("JCoreTCPManager", " update mHeartbeatTimeOut=" + f2242f.get());
            }
        } else {
            j6 = 0;
        }
        cn.jiguang.bb.f.d("JCoreTCPManager", " current use heartbeatTimeOutCount=" + f2243g.get());
        cn.jiguang.bb.f.d("JCoreTCPManager", " current use  mHeartbeatTimeOut=" + f2242f.get());
        if (o()) {
            cn.jiguang.bb.f.d("JCoreTCPManager", "[rtc] rtc restartNetworkingClient");
            n();
            return;
        }
        if (j6 <= 0) {
            c(bundle);
        } else {
            if (z5) {
                cn.jiguang.bm.b.a().b(1005);
                cn.jiguang.bm.b.a().b(1004);
            }
            cn.jiguang.bm.b.a().b(z5 ? 1004 : 1005, j6, this.f2256t);
        }
        cn.jiguang.bb.f.f("JCoreTCPManager", "send rtc force=" + z5 + " delay=" + j6);
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                boolean optBoolean = jSONObject.optBoolean("use_ssp");
                this.f2257u = optBoolean;
                if (optBoolean) {
                    int optInt = jSONObject.optInt("hb_interval");
                    if (optInt <= 0) {
                        cn.jiguang.bb.f.i("JCoreTCPManager", "hb_interval is less than 0, will use 15s");
                        this.f2258v = 15;
                    } else {
                        if (optInt >= JConstants.DEFAULT_HEARTBEAT_INTERVAL / 2) {
                            cn.jiguang.bb.f.i("JCoreTCPManager", "hb_interval is more than " + JConstants.DEFAULT_HEARTBEAT_INTERVAL + ", will use " + JConstants.DEFAULT_HEARTBEAT_INTERVAL + "s");
                            optInt = JConstants.DEFAULT_HEARTBEAT_INTERVAL;
                        } else {
                            cn.jiguang.bb.f.i("JCoreTCPManager", "set ssp heartbeat interval:" + optInt);
                        }
                        this.f2258v = optInt;
                    }
                    if (this.f2258v > 0) {
                        i();
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.bb.f.i("JCoreTCPManager", "[TcpManager] handleCtrlHeartBeatCmd error:" + th);
            }
        }
    }

    private void a(boolean z5) {
        cn.jiguang.bi.b.a().a(cn.jiguang.bz.d.a(), GLMapStaticValue.MAP_PARAMETERNAME_SATELLITE, !z5 ? 1 : 0, "");
    }
}
