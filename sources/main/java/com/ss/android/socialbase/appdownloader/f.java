package com.ss.android.socialbase.appdownloader;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.utils.vl;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.ss.android.socialbase.appdownloader.view.DownloadHandleNotificationActivity;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.ae.r;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.ss.android.socialbase.downloader.downloader.mi;
import com.ss.android.socialbase.downloader.downloader.ws;
import com.ss.android.socialbase.downloader.impls.w;
import com.ss.android.socialbase.downloader.notification.xt;
import com.ss.android.socialbase.downloader.r.az;
import com.ss.android.socialbase.downloader.r.gq;
import com.ss.android.socialbase.downloader.r.uf;
import com.ss.android.socialbase.downloader.xt.up;
import com.stub.StubApp;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import x2.k;
import x2.l;
import x2.m;
import x2.n;
import x2.o;
import x2.p;

/* loaded from: D:\Downloads\app\classes6.dex */
public class f {

    /* renamed from: s, reason: collision with root package name */
    private static final String f38397s = "f";

    /* renamed from: t, reason: collision with root package name */
    private static volatile f f38398t;

    /* renamed from: u, reason: collision with root package name */
    private static boolean f38399u;

    /* renamed from: v, reason: collision with root package name */
    private static boolean f38400v;

    /* renamed from: w, reason: collision with root package name */
    private static boolean f38401w;

    /* renamed from: a, reason: collision with root package name */
    private String f38402a;

    /* renamed from: b, reason: collision with root package name */
    private String f38403b;

    /* renamed from: d, reason: collision with root package name */
    private Future f38405d;

    /* renamed from: e, reason: collision with root package name */
    private int f38406e;

    /* renamed from: h, reason: collision with root package name */
    private k f38409h;

    /* renamed from: i, reason: collision with root package name */
    private m f38410i;

    /* renamed from: j, reason: collision with root package name */
    private x2.e f38411j;

    /* renamed from: k, reason: collision with root package name */
    private l f38412k;

    /* renamed from: l, reason: collision with root package name */
    private o f38413l;

    /* renamed from: m, reason: collision with root package name */
    private x2.a f38414m;

    /* renamed from: n, reason: collision with root package name */
    private x2.j f38415n;

    /* renamed from: o, reason: collision with root package name */
    private gq f38416o;

    /* renamed from: p, reason: collision with root package name */
    private uf f38417p;

    /* renamed from: q, reason: collision with root package name */
    private x2.b f38418q;

    /* renamed from: r, reason: collision with root package name */
    private x2.d f38419r;

    /* renamed from: c, reason: collision with root package name */
    private DownloadReceiver f38404c = new DownloadReceiver();

    /* renamed from: f, reason: collision with root package name */
    private boolean f38407f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f38408g = false;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.H();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.m.j.xt(f.f38397s, "registerDownloadReceiver tryUnRegisterTempAppInstallDownloadReceiver run inner");
            f.this.G();
            f.this.H();
        }
    }

    class c implements w.xt {
        c() {
        }

        @Override // com.ss.android.socialbase.downloader.impls.w.xt
        public void j(cw cwVar, long j6, boolean z5, int i6) {
            RetryJobSchedulerService.a(cwVar, j6, z5, i6);
        }
    }

    class d implements az {
        d() {
        }

        @Override // com.ss.android.socialbase.downloader.r.az
        public void j(cw cwVar, com.ss.android.socialbase.downloader.up.j jVar, int i6) {
            if (f.this.f38411j != null) {
                f.this.f38411j.j(cwVar, jVar, i6);
            }
        }
    }

    class e implements x2.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f38424a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ r f38425b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f38426c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f38427d;

        e(String str, r rVar, int i6, boolean z5) {
            this.f38424a = str;
            this.f38425b = rVar;
            this.f38426c = i6;
            this.f38427d = z5;
        }

        @Override // x2.c
        public void j() {
            com.ss.android.socialbase.downloader.m.j.xt(f.f38397s, "notification permission granted, start download :" + this.f38424a);
            f.this.v(this.f38425b, this.f38426c, this.f38427d);
        }

        @Override // x2.c
        public void xt() {
            com.ss.android.socialbase.downloader.m.j.xt(f.f38397s, "notification permission denied, start download :" + this.f38424a);
            f.this.v(this.f38425b, this.f38426c, this.f38427d);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.f$f, reason: collision with other inner class name */
    class C0772f implements com.ss.android.socialbase.downloader.r.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ x2.h f38429a;

        @Override // com.ss.android.socialbase.downloader.r.h
        public void j(int i6, cw cwVar, String str, String str2) {
            if (i6 != 1 && i6 != 3) {
                if (i6 == 9) {
                    com.ss.android.socialbase.downloader.downloader.cw.nd();
                    return;
                } else if (i6 != 5 && i6 != 6 && i6 != 7) {
                    return;
                }
            }
            cwVar.i();
        }

        C0772f(x2.h hVar) {
            this.f38429a = hVar;
        }

        @Override // com.ss.android.socialbase.downloader.r.h
        public boolean j(boolean z5) {
            return this.f38429a.j(z5);
        }

        @Override // com.ss.android.socialbase.downloader.r.h
        public String j() {
            return this.f38429a.j();
        }
    }

    public class g extends p {

        /* renamed from: a, reason: collision with root package name */
        private AlertDialog.Builder f38431a;

        private static class a implements n {

            /* renamed from: a, reason: collision with root package name */
            private AlertDialog f38432a;

            @Override // x2.n
            public void j() {
                AlertDialog alertDialog = this.f38432a;
                if (alertDialog != null) {
                    alertDialog.show();
                }
            }

            @Override // x2.n
            public boolean xt() {
                AlertDialog alertDialog = this.f38432a;
                if (alertDialog != null) {
                    return alertDialog.isShowing();
                }
                return false;
            }

            public a(AlertDialog.Builder builder) {
                if (builder != null) {
                    this.f38432a = builder.show();
                }
            }
        }

        @Override // x2.g
        public x2.g j(int i6) {
            AlertDialog.Builder builder = this.f38431a;
            if (builder != null) {
                builder.setTitle(i6);
            }
            return this;
        }

        @Override // x2.g
        public x2.g a(int i6, DialogInterface.OnClickListener onClickListener) {
            AlertDialog.Builder builder = this.f38431a;
            if (builder != null) {
                builder.setNegativeButton(i6, onClickListener);
            }
            return this;
        }

        @Override // x2.g
        public x2.g b(int i6, DialogInterface.OnClickListener onClickListener) {
            AlertDialog.Builder builder = this.f38431a;
            if (builder != null) {
                builder.setPositiveButton(i6, onClickListener);
            }
            return this;
        }

        @Override // x2.g
        public x2.g c(DialogInterface.OnCancelListener onCancelListener) {
            AlertDialog.Builder builder = this.f38431a;
            if (builder != null) {
                builder.setOnCancelListener(onCancelListener);
            }
            return this;
        }

        public g(Context context) {
            this.f38431a = new AlertDialog.Builder(context);
        }

        @Override // x2.g
        public x2.g j(String str) {
            AlertDialog.Builder builder = this.f38431a;
            if (builder != null) {
                builder.setMessage(str);
            }
            return this;
        }

        @Override // x2.g
        public n j() {
            return new a(this.f38431a);
        }
    }

    public class h implements ws {

        /* renamed from: a, reason: collision with root package name */
        private List<Integer> f38433a;

        /* renamed from: b, reason: collision with root package name */
        private BroadcastReceiver f38434b;

        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ List f38435a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f38436b;

            a(List list, int i6) {
                this.f38435a = list;
                this.f38436b = i6;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    h.this.i(this.f38435a, this.f38436b);
                } catch (Exception e6) {
                    vl.j(e6);
                }
            }
        }

        class b extends BroadcastReceiver {

            class a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Context f38439a;

                a(Context context) {
                    this.f38439a = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (h.this.f38433a != null && !h.this.f38433a.isEmpty()) {
                            int size = h.this.f38433a.size();
                            Integer[] numArr = new Integer[size];
                            h.this.f38433a.toArray(numArr);
                            h.this.f38433a.clear();
                            for (int i6 = 0; i6 < size; i6++) {
                                cw tl = ae.xt(this.f38439a).tl(numArr[i6].intValue());
                                if (tl != null) {
                                    if (tl.v() != -5) {
                                        if (tl.v() == -2 && tl.qb()) {
                                        }
                                    }
                                    h.this.c(this.f38439a, tl, true, 2);
                                }
                            }
                        }
                    } catch (Exception e6) {
                        vl.j(e6);
                    }
                }
            }

            b() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                if (!com.ss.android.socialbase.downloader.az.m.xt(origApplicationContext)) {
                    return;
                }
                com.ss.android.socialbase.downloader.m.j.xt("LaunchResume", "onReceive : wifi connected !!!");
                com.ss.android.socialbase.downloader.downloader.cw.qv().execute(new a(origApplicationContext));
                try {
                    origApplicationContext.unregisterReceiver(h.this.f38434b);
                } catch (Throwable th) {
                    vl.j(th);
                }
                h.this.f38434b = null;
            }
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ws
        public List<String> j() {
            return com.ss.android.socialbase.appdownloader.b.b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:97:0x012d  */
        /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void c(android.content.Context r22, com.ss.android.socialbase.downloader.ae.cw r23, boolean r24, int r25) {
            /*
                Method dump skipped, instructions count: 612
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.f.h.c(android.content.Context, com.ss.android.socialbase.downloader.ae.cw, boolean, int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(List<cw> list, int i6) {
            if (list == null || list.isEmpty()) {
                return;
            }
            f.L();
            Context nd = com.ss.android.socialbase.downloader.downloader.cw.nd();
            if (nd == null) {
                return;
            }
            boolean xt = com.ss.android.socialbase.downloader.az.m.xt(nd);
            Iterator<cw> it = list.iterator();
            while (it.hasNext()) {
                c(nd, it.next(), xt, i6);
            }
            List<Integer> list2 = this.f38433a;
            if (list2 == null || list2.isEmpty() || this.f38434b != null) {
                return;
            }
            this.f38434b = new b();
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                nd.registerReceiver(this.f38434b, intentFilter);
            } catch (Throwable th) {
                vl.j(th);
                this.f38434b = null;
            }
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ws
        public void j(List<cw> list, int i6) {
            if (com.ss.android.socialbase.downloader.az.m.r()) {
                com.ss.android.socialbase.downloader.downloader.cw.qv().execute(new a(list, i6));
            } else {
                i(list, i6);
            }
        }

        private void f(cw cwVar, Context context) {
            com.ss.android.socialbase.downloader.jy.j j6 = com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae());
            int j7 = j6.j("paused_resume_max_count", 0);
            double j8 = j6.j("paused_resume_max_hours", 72.0d);
            int uh = cwVar.uh();
            if (uh < j7 && System.currentTimeMillis() - cwVar.lg() < j8 * 3600000.0d) {
                com.ss.android.socialbase.downloader.notification.j up = xt.j().up(cwVar.ae());
                if (up == null) {
                    com.ss.android.socialbase.appdownloader.up.b bVar = new com.ss.android.socialbase.appdownloader.up.b(context, cwVar.ae(), cwVar.g(), cwVar.qv(), cwVar.tl(), cwVar.h());
                    xt.j().j(bVar);
                    up = bVar;
                } else {
                    up.j(cwVar);
                }
                up.xt(cwVar.ka());
                up.j(cwVar.uq());
                up.j(cwVar.i(), null, false, false);
                cwVar.i(uh + 1);
                cwVar.ay();
            }
        }

        private boolean g(cw cwVar) {
            if (com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).xt("uninstall_can_not_resume_for_force_task", false)) {
                return com.ss.android.socialbase.downloader.az.m.j(cwVar, false, cwVar.rn());
            }
            return cwVar.m126if();
        }
    }

    public static boolean F(Context context, int i6) {
        return com.ss.android.socialbase.appdownloader.b.h(context, i6, true) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        synchronized (this.f38404c) {
            if (f38400v) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter2.addDataScheme(master.flame.danmaku.danmaku.parser.b.f50156c);
                com.ss.android.socialbase.downloader.downloader.cw.nd().registerReceiver(this.f38404c, intentFilter);
                com.ss.android.socialbase.downloader.downloader.cw.nd().registerReceiver(this.f38404c, intentFilter2);
                f38400v = true;
            } catch (Exception e6) {
                vl.j(e6);
            }
            com.ss.android.socialbase.downloader.m.j.xt(f38397s, "registerDownloadReceiver mIsRegistered:" + f38400v);
        }
    }

    public static f L() {
        if (f38398t == null) {
            synchronized (f.class) {
                try {
                    if (f38398t == null) {
                        f38398t = new f();
                    }
                } finally {
                }
            }
        }
        return f38398t;
    }

    private void N() {
        w.j(new c());
    }

    public static Pair<Intent, Boolean> T(Context context, int i6) {
        return (Build.VERSION.SDK_INT < 31 || com.ss.android.socialbase.downloader.jy.j.j(i6).xt("enable_target_34") <= 0) ? new Pair<>(new Intent(context, (Class<?>) DownloadHandlerService.class), Boolean.FALSE) : new Pair<>(new Intent(context, (Class<?>) DownloadHandleNotificationActivity.class), Boolean.TRUE);
    }

    private void e(Context context) {
        if (context == null || f38399u) {
            return;
        }
        up.j("application/vnd.android.package-archive");
        com.ss.android.socialbase.downloader.downloader.cw.j(context);
        com.ss.android.socialbase.downloader.downloader.cw.j(new h());
        if (this.f38408g) {
            com.ss.android.socialbase.downloader.downloader.cw.j(new a(), 5L, TimeUnit.SECONDS);
        } else {
            H();
        }
        N();
        f38399u = true;
    }

    public static PendingIntent i(Context context, Pair<Intent, Boolean> pair, int i6) {
        return ((Boolean) pair.second).booleanValue() ? PendingIntent.getActivity(context, i6, (Intent) pair.first, 201326592) : PendingIntent.getService(context, i6, (Intent) pair.first, 201326592);
    }

    private cw k(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return ae.xt(context).xt(str, file.getAbsolutePath());
    }

    private com.ss.android.socialbase.downloader.r.h l(x2.h hVar) {
        if (hVar == null) {
            return null;
        }
        return new C0772f(hVar);
    }

    private List<com.ss.android.socialbase.downloader.ae.up> o(List<com.ss.android.socialbase.downloader.ae.up> list) {
        ArrayList arrayList = new ArrayList();
        boolean z5 = false;
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.ae.up upVar : list) {
                if (upVar != null && !TextUtils.isEmpty(upVar.j()) && !TextUtils.isEmpty(upVar.xt())) {
                    if (upVar.j().equals("User-Agent")) {
                        z5 = true;
                    }
                    arrayList.add(new com.ss.android.socialbase.downloader.ae.up(upVar.j(), upVar.xt()));
                }
            }
        }
        if (!z5) {
            arrayList.add(new com.ss.android.socialbase.downloader.ae.up("User-Agent", y2.a.f56784a));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(r rVar, int i6, boolean z5) {
        if (rVar == null) {
            return;
        }
        rVar.av();
        cw j6 = rVar.j();
        if (j6 != null) {
            j6.ws(i6);
        }
        if (j6 == null || !z5) {
            return;
        }
        j6.az(z5);
    }

    public void A(x2.a aVar) {
        this.f38414m = aVar;
    }

    public void B(x2.b bVar) {
        this.f38418q = bVar;
    }

    public void C(x2.d dVar) {
        this.f38419r = dVar;
    }

    public void D(x2.j jVar) {
        this.f38415n = jVar;
    }

    public void E(l lVar) {
        this.f38412k = lVar;
    }

    public void G() {
        x2.b bVar;
        synchronized (this.f38404c) {
            try {
                if (f38400v) {
                    com.ss.android.socialbase.downloader.downloader.cw.nd().unregisterReceiver(this.f38404c);
                    if (f38401w && (bVar = this.f38418q) != null) {
                        bVar.xt();
                    }
                }
            } catch (Exception e6) {
                vl.j(e6);
            }
            f38400v = false;
            f38401w = false;
        }
        com.ss.android.socialbase.downloader.m.j.xt(f38397s, "registerDownloadReceiver unRegisterDownloadReceiver");
    }

    public x2.a I() {
        return this.f38414m;
    }

    public String K() {
        return this.f38402a;
    }

    public x2.e M() {
        return this.f38411j;
    }

    public x2.j O() {
        return this.f38415n;
    }

    public String P() {
        return this.f38403b;
    }

    public uf R() {
        return this.f38417p;
    }

    public o S() {
        return this.f38413l;
    }

    public k X() {
        return this.f38409h;
    }

    public l c() {
        return this.f38412k;
    }

    public m d() {
        return this.f38410i;
    }

    public gq g() {
        return this.f38416o;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(30:35|(1:37)|38|(2:42|43)|46|(1:53)|54|(2:60|(1:62)(22:63|64|(1:66)|67|(3:69|(5:72|73|74|75|70)|80)|82|83|84|(1:86)(1:123)|87|88|89|90|91|92|(6:97|(1:101)|102|(1:106)|(1:(1:118)(1:117))|119)|120|(2:99|101)|102|(2:104|106)|(0)|119))|126|64|(0)|67|(0)|82|83|84|(0)(0)|87|88|89|90|91|92|(7:94|97|(0)|102|(0)|(0)|119)|120|(0)|102|(0)|(0)|119) */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0182, code lost:
    
        r16 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0184, code lost:
    
        r18 = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0348 A[Catch: all -> 0x016b, TryCatch #4 {all -> 0x016b, blocks: (B:75:0x0162, B:82:0x016e, B:92:0x01a5, B:94:0x01ab, B:99:0x01b7, B:101:0x01c3, B:102:0x01ce, B:104:0x0348, B:106:0x0352, B:109:0x035d, B:111:0x0363, B:113:0x0369, B:115:0x0373, B:117:0x0379, B:118:0x038b), top: B:74:0x0162 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0187 A[Catch: all -> 0x0182, TRY_LEAVE, TryCatch #0 {all -> 0x0182, blocks: (B:84:0x0174, B:86:0x017a, B:123:0x0187), top: B:83:0x0174 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0143 A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:7:0x0011, B:11:0x0024, B:14:0x002d, B:16:0x003b, B:17:0x0049, B:19:0x0051, B:20:0x005a, B:23:0x0064, B:25:0x0070, B:28:0x007c, B:30:0x008a, B:31:0x008e, B:33:0x0095, B:35:0x009f, B:38:0x00aa, B:40:0x00be, B:46:0x00d8, B:49:0x00f1, B:51:0x00f7, B:54:0x0106, B:56:0x010c, B:58:0x0112, B:60:0x0118, B:62:0x011e, B:63:0x0129, B:64:0x013d, B:66:0x0143, B:67:0x0148, B:69:0x0152, B:70:0x0156, B:72:0x015c), top: B:6:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0152 A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:7:0x0011, B:11:0x0024, B:14:0x002d, B:16:0x003b, B:17:0x0049, B:19:0x0051, B:20:0x005a, B:23:0x0064, B:25:0x0070, B:28:0x007c, B:30:0x008a, B:31:0x008e, B:33:0x0095, B:35:0x009f, B:38:0x00aa, B:40:0x00be, B:46:0x00d8, B:49:0x00f1, B:51:0x00f7, B:54:0x0106, B:56:0x010c, B:58:0x0112, B:60:0x0118, B:62:0x011e, B:63:0x0129, B:64:0x013d, B:66:0x0143, B:67:0x0148, B:69:0x0152, B:70:0x0156, B:72:0x015c), top: B:6:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x017a A[Catch: all -> 0x0182, TryCatch #0 {all -> 0x0182, blocks: (B:84:0x0174, B:86:0x017a, B:123:0x0187), top: B:83:0x0174 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01b7 A[Catch: all -> 0x016b, TryCatch #4 {all -> 0x016b, blocks: (B:75:0x0162, B:82:0x016e, B:92:0x01a5, B:94:0x01ab, B:99:0x01b7, B:101:0x01c3, B:102:0x01ce, B:104:0x0348, B:106:0x0352, B:109:0x035d, B:111:0x0363, B:113:0x0369, B:115:0x0373, B:117:0x0379, B:118:0x038b), top: B:74:0x0162 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int h(com.ss.android.socialbase.appdownloader.e r20) {
        /*
            Method dump skipped, instructions count: 976
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.f.h(com.ss.android.socialbase.appdownloader.e):int");
    }

    public x2.d p() {
        return this.f38419r;
    }

    @Deprecated
    public void s(Context context, String str, k kVar, m mVar, x2.e eVar) {
        if (kVar != null) {
            this.f38409h = kVar;
        }
        if (mVar != null) {
            this.f38410i = mVar;
        }
        if (eVar != null) {
            this.f38411j = eVar;
        }
        e(context);
    }

    public void x(gq gqVar) {
        this.f38416o = gqVar;
    }

    public void y(uf ufVar) {
        this.f38417p = ufVar;
    }

    private f() {
    }

    private cw U(Context context, String str) {
        List<cw> j6 = ae.xt(context).j(str);
        if (j6 != null) {
            for (cw cwVar : j6) {
                if (cwVar != null && cwVar.ag()) {
                    return cwVar;
                }
            }
            return null;
        }
        return null;
    }

    private void Y(int i6) {
        this.f38406e = com.ss.android.socialbase.downloader.jy.j.cw().j("app_install_keep_receiver_time_s", 60);
        com.ss.android.socialbase.downloader.m.j.xt(f38397s, "tryUnRegisterTempAppInstallDownloadReceiver mAppInstallReceiverKeepTime:" + this.f38406e);
        if (this.f38406e <= 0) {
            return;
        }
        if (i6 > 0) {
            this.f38406e = i6;
        }
        Future future = this.f38405d;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
                vl.j(th);
            }
        }
        this.f38405d = com.ss.android.socialbase.downloader.downloader.cw.j(new b(), this.f38406e, TimeUnit.SECONDS);
    }

    public void Q() {
        if (com.ss.android.socialbase.downloader.jy.j.cw().j("enable_app_install_receiver", 1) <= 0) {
            com.ss.android.socialbase.downloader.m.j.xt(f38397s, "disable app install receiver");
            return;
        }
        synchronized (this.f38404c) {
            try {
                if (f38401w) {
                    return;
                }
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                    intentFilter.addDataScheme(WiseOpenHianalyticsData.UNION_PACKAGE);
                    com.ss.android.socialbase.downloader.downloader.cw.nd().registerReceiver(this.f38404c, intentFilter);
                    f38401w = true;
                    x2.b bVar = this.f38418q;
                    if (bVar != null) {
                        bVar.j();
                    }
                } catch (Throwable th) {
                    vl.j(th);
                }
                com.ss.android.socialbase.downloader.m.j.xt(f38397s, "tryRegisterTempAppInstallDownloadReceiver mIsAppInstallRegistered:" + f38400v);
            } finally {
                Y(0);
            }
        }
    }

    public List<cw> V(Context context) {
        return ae.xt(context).r("application/vnd.android.package-archive");
    }

    public void Z(String str) {
        ae.xt(com.ss.android.socialbase.downloader.downloader.cw.nd()).up(str);
    }

    public boolean a() {
        if (com.ss.android.socialbase.downloader.jy.j.xt().optInt("package_flag_config", 1) == 1) {
            return true;
        }
        return false;
    }

    public mi b() {
        return ae.xt(com.ss.android.socialbase.downloader.downloader.cw.nd()).xt();
    }

    public File f() {
        return ae.xt(com.ss.android.socialbase.downloader.downloader.cw.nd()).cw();
    }

    public cw j(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                cw k6 = k(context, str, f());
                if (k6 == null) {
                    k6 = k(context, str, com.bytedance.sdk.openadsdk.api.plugin.xt.j(context, Environment.DIRECTORY_DOWNLOADS));
                }
                if (k6 == null) {
                    k6 = k(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (k6 == null) {
                    k6 = k(context, str, com.bytedance.sdk.openadsdk.api.plugin.xt.j(context));
                }
                boolean j6 = com.ss.android.socialbase.downloader.jy.j.cw().j("get_download_info_by_list");
                if (k6 == null && j6) {
                    return U(context, str);
                }
                return k6;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.m.j.xt(f38397s, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    public String m(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.endsWith(".apk") && !com.ss.android.socialbase.appdownloader.b.d(str2)) {
            return "application/vnd.android.package-archive";
        }
        return str2;
    }

    public List<cw> n(Context context) {
        return ae.xt(context).cw("application/vnd.android.package-archive");
    }

    public void q(int i6) {
        if (com.ss.android.socialbase.downloader.jy.j.cw().j("enable_app_install_receiver", 1) <= 0) {
            return;
        }
        Q();
        Y(i6);
    }

    public void r(Context context, int i6, int i7) {
        try {
            switch (i7) {
                case -4:
                case -1:
                    ae.xt(context).up(i6);
                    break;
                case -3:
                    com.ss.android.socialbase.appdownloader.b.h(context, i6, true);
                    break;
                case -2:
                    ae.xt(context).cw(i6);
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    ae.xt(context).j(i6);
                    break;
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public void w(mi miVar) {
        ae.xt(com.ss.android.socialbase.downloader.downloader.cw.nd()).j(miVar);
    }

    public void z(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f38403b = str;
    }
}
