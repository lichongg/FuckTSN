package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.stub.StubApp;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c0 {

    /* renamed from: o, reason: collision with root package name */
    public static String f5771o = "";

    /* renamed from: p, reason: collision with root package name */
    public static boolean f5772p = false;

    /* renamed from: q, reason: collision with root package name */
    private static volatile c0 f5773q = null;

    /* renamed from: r, reason: collision with root package name */
    public static String f5774r = "";

    /* renamed from: a, reason: collision with root package name */
    private Context f5775a;

    /* renamed from: d, reason: collision with root package name */
    private d f5778d;

    /* renamed from: e, reason: collision with root package name */
    private m0 f5779e;

    /* renamed from: f, reason: collision with root package name */
    private s0 f5780f;

    /* renamed from: k, reason: collision with root package name */
    public h0 f5785k;

    /* renamed from: l, reason: collision with root package name */
    j0 f5786l;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5776b = true;

    /* renamed from: c, reason: collision with root package name */
    List<ax> f5777c = new Vector();

    /* renamed from: g, reason: collision with root package name */
    private a8 f5781g = null;

    /* renamed from: h, reason: collision with root package name */
    private a8 f5782h = null;

    /* renamed from: i, reason: collision with root package name */
    private a8 f5783i = null;

    /* renamed from: j, reason: collision with root package name */
    e f5784j = null;

    /* renamed from: m, reason: collision with root package name */
    g0 f5787m = null;

    /* renamed from: n, reason: collision with root package name */
    private boolean f5788n = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends b8 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f5789d;

        a(String str) {
            this.f5789d = str;
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            ax I = c0.this.I(this.f5789d);
            if (I != null) {
                try {
                    if (!I.s().equals(I.f5641h) && !I.s().equals(I.f5643j)) {
                        String pinyin = I.getPinyin();
                        if (pinyin.length() > 0) {
                            String n6 = c0.this.f5780f.n(pinyin);
                            if (n6 == null) {
                                n6 = I.getVersion();
                            }
                            if (c0.f5774r.length() > 0 && n6 != null && c0.n(c0.f5774r, n6)) {
                                I.C();
                            }
                        }
                    }
                    if (c0.this.f5778d != null) {
                        synchronized (c0.this) {
                            try {
                                c0.this.f5778d.b(I);
                            } finally {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    if (c0.this.f5778d != null) {
                        synchronized (c0.this) {
                            try {
                                c0.this.f5778d.b(I);
                            } finally {
                                return;
                            }
                            return;
                        }
                    }
                    return;
                } catch (Throwable th) {
                    if (c0.this.f5778d != null) {
                        synchronized (c0.this) {
                            try {
                                c0.this.f5778d.b(I);
                            } finally {
                                throw th;
                            }
                        }
                    }
                    throw th;
                }
            }
            c0.this.L();
            d0 f6 = new f0(c0.this.f5775a, c0.f5774r).f();
            if (c0.this.f5778d != null) {
                if (f6 == null) {
                    if (c0.this.f5778d != null) {
                        synchronized (c0.this) {
                            try {
                                c0.this.f5778d.b(I);
                            } finally {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (f6.c()) {
                    c0.this.p();
                }
            }
            if (c0.this.f5778d != null) {
                synchronized (c0.this) {
                    try {
                        c0.this.f5778d.b(I);
                    } finally {
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b extends b8 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ax f5791d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f5792e;

        b(ax axVar, boolean z5) {
            this.f5791d = axVar;
            this.f5792e = z5;
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            try {
                if (this.f5791d.s().equals(this.f5791d.f5639f)) {
                    if (c0.this.f5778d != null) {
                        c0.this.f5778d.c(this.f5791d);
                        return;
                    }
                    return;
                }
                if (this.f5791d.getState() != 7 && this.f5791d.getState() != -1) {
                    c0.this.f5786l.a(this.f5791d);
                    if (c0.this.f5778d != null) {
                        c0.this.f5778d.c(this.f5791d);
                        return;
                    }
                    return;
                }
                c0.this.f5786l.a(this.f5791d);
                if (!this.f5792e || c0.this.f5778d == null) {
                    return;
                }
                c0.this.f5778d.c(this.f5791d);
            } catch (Throwable th) {
                v5.p(th, "requestDelete", "removeExcecRunnable");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class c extends b8 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ax f5794d;

        c(ax axVar) {
            this.f5794d = axVar;
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            try {
                if (c0.this.f5776b) {
                    c0.this.L();
                    d0 f6 = new f0(c0.this.f5775a, c0.f5774r).f();
                    if (f6 != null) {
                        c0.D(c0.this);
                        if (f6.c()) {
                            c0.this.p();
                        }
                    }
                }
                this.f5794d.setVersion(c0.f5774r);
                this.f5794d.y();
            } catch (AMapException e6) {
                e6.printStackTrace();
            } catch (Throwable th) {
                v5.p(th, "OfflineDownloadManager", "startDownloadRunnable");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        void a();

        void a(ax axVar);

        void b(ax axVar);

        void c(ax axVar);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                message.getData();
                Object obj = message.obj;
                if (obj instanceof ax) {
                    ax axVar = (ax) obj;
                    axVar.getCity();
                    axVar.getcompleteCode();
                    axVar.getState();
                    if (c0.this.f5778d != null) {
                        c0.this.f5778d.a(axVar);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    static /* synthetic */ boolean D(c0 c0Var) {
        c0Var.f5776b = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ax I(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        synchronized (this.f5777c) {
            try {
                for (ax axVar : this.f5777c) {
                    if (!str.equals(axVar.getCity()) && !str.equals(axVar.getPinyin())) {
                    }
                    return axVar;
                }
                return null;
            } finally {
            }
        }
    }

    private ax K(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        synchronized (this.f5777c) {
            try {
                for (ax axVar : this.f5777c) {
                    if (str.equals(axVar.getCode())) {
                        return axVar;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void M() {
        f5773q = null;
        f5772p = true;
    }

    private void O() {
        synchronized (this) {
            this.f5778d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n(String str, String str2) {
        for (int i6 = 0; i6 < str2.length(); i6++) {
            try {
                if (str.charAt(i6) > str2.charAt(i6)) {
                    return true;
                }
                if (str.charAt(i6) < str2.charAt(i6)) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public final void e(ax axVar) {
        f(axVar, false);
    }

    private void F() {
        try {
            n0 a6 = this.f5780f.a("000001");
            if (a6 != null) {
                this.f5780f.m("000001");
                a6.b("100000");
                this.f5780f.e(a6);
            }
        } catch (Throwable th) {
            v5.p(th, "OfflineDownloadManager", "changeBadCase");
        }
    }

    private void G() {
        if ("".equals(b3.f0(this.f5775a))) {
            return;
        }
        File file = new File(b3.f0(this.f5775a) + "offlinemapv4.png");
        String d6 = !file.exists() ? a1.d(this.f5775a, "offlinemapv4.png") : a1.n(file);
        if (d6 != null) {
            try {
                H(d6);
            } catch (JSONException e6) {
                if (file.exists()) {
                    file.delete();
                }
                v5.p(e6, "MapDownloadManager", "paseJson io");
                e6.printStackTrace();
            }
        }
    }

    private void H(String str) throws JSONException {
        h0 h0Var;
        List<OfflineMapProvince> f6 = a1.f(str, StubApp.getOrigApplicationContext(this.f5775a.getApplicationContext()));
        if (f6 == null || f6.size() == 0 || (h0Var = this.f5785k) == null) {
            return;
        }
        h0Var.i(f6);
    }

    private void J() {
        Iterator<n0> it = this.f5780f.c().iterator();
        while (it.hasNext()) {
            n0 next = it.next();
            if (next != null && next.a() != null && next.e().length() > 0) {
                int i6 = next.f6947l;
                if (i6 != 4 && i6 != 7 && i6 >= 0) {
                    next.f6947l = 3;
                }
                ax I = I(next.a());
                if (I != null) {
                    String c6 = next.c();
                    if (c6 == null || !n(f5774r, c6)) {
                        I.m(next.f6947l);
                        I.setCompleteCode(next.i());
                    } else {
                        I.m(7);
                    }
                    if (next.c().length() > 0) {
                        I.setVersion(next.c());
                    }
                    List<String> j6 = this.f5780f.j(next.e());
                    StringBuffer stringBuffer = new StringBuffer();
                    Iterator<String> it2 = j6.iterator();
                    while (it2.hasNext()) {
                        stringBuffer.append(it2.next());
                        stringBuffer.append(";");
                    }
                    I.p(stringBuffer.toString());
                    h0 h0Var = this.f5785k;
                    if (h0Var != null) {
                        h0Var.c(I);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() throws AMapException {
        if (!b3.h0(this.f5775a)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
    }

    private static void N(String str) {
        f5771o = str;
    }

    public static c0 b(Context context) {
        if (f5773q == null) {
            synchronized (c0.class) {
                try {
                    if (f5773q == null && !f5772p) {
                        f5773q = new c0(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                    }
                } finally {
                }
            }
        }
        return f5773q;
    }

    private void f(ax axVar, boolean z5) {
        if (this.f5786l == null) {
            this.f5786l = new j0(this.f5775a);
        }
        if (this.f5782h == null) {
            this.f5782h = a3.b("AMapOfflineRemove");
        }
        try {
            this.f5782h.b(new b(axVar, z5));
        } catch (Throwable th) {
            v5.p(th, "requestDelete", "removeExcecRunnable");
        }
    }

    public final void A() {
        a8 a8Var = this.f5781g;
        if (a8Var != null) {
            a8Var.g();
        }
        a8 a8Var2 = this.f5783i;
        if (a8Var2 != null) {
            a8Var2.g();
            this.f5783i = null;
        }
        g0 g0Var = this.f5787m;
        if (g0Var != null) {
            if (g0Var.isAlive()) {
                this.f5787m.interrupt();
            }
            this.f5787m = null;
        }
        e eVar = this.f5784j;
        if (eVar != null) {
            eVar.removeCallbacksAndMessages(null);
            this.f5784j = null;
        }
        m0 m0Var = this.f5779e;
        if (m0Var != null) {
            m0Var.d();
            this.f5779e = null;
        }
        h0 h0Var = this.f5785k;
        if (h0Var != null) {
            h0Var.w();
        }
        M();
        this.f5776b = true;
        O();
    }

    public final String E(String str) {
        ax I;
        return (str == null || (I = I(str)) == null) ? "" : I.getAdcode();
    }

    public final void d() {
        this.f5780f = s0.b(StubApp.getOrigApplicationContext(this.f5775a.getApplicationContext()));
        F();
        this.f5784j = new e(this.f5775a.getMainLooper());
        this.f5785k = new h0(this.f5775a);
        this.f5779e = m0.a();
        N(b3.f0(this.f5775a));
        try {
            G();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this.f5777c) {
            try {
                Iterator<OfflineMapProvince> it = this.f5785k.b().iterator();
                while (it.hasNext()) {
                    Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                    while (it2.hasNext()) {
                        OfflineMapCity next = it2.next();
                        if (next != null) {
                            this.f5777c.add(new ax(this.f5775a, next));
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        g0 g0Var = new g0(this.f5775a);
        this.f5787m = g0Var;
        g0Var.start();
    }

    public final void g(d dVar) {
        this.f5778d = dVar;
    }

    public final void h(String str) {
        try {
            if (str != null) {
                if (this.f5781g == null) {
                    this.f5781g = a3.b("AMapOfflineCheckUpdate");
                }
                this.f5781g.b(new a(str));
            } else {
                d dVar = this.f5778d;
                if (dVar != null) {
                    dVar.b(null);
                }
            }
        } catch (Throwable th) {
            v5.p(th, "OfflineDownloadManager", "checkUpdate");
        }
    }

    public final void k(ax axVar) {
        try {
            m0 m0Var = this.f5779e;
            if (m0Var != null) {
                m0Var.c(axVar, this.f5775a);
            }
        } catch (fk e6) {
            e6.printStackTrace();
        }
    }

    protected final void p() throws AMapException {
        if (this.f5785k == null) {
            return;
        }
        k0 k0Var = new k0(this.f5775a, "");
        k0Var.h(this.f5775a);
        List<OfflineMapProvince> f6 = k0Var.f();
        if (this.f5777c != null) {
            this.f5785k.i(f6);
        }
        List<ax> list = this.f5777c;
        if (list != null) {
            synchronized (list) {
                try {
                    Iterator<OfflineMapProvince> it = this.f5785k.b().iterator();
                    while (it.hasNext()) {
                        Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                        while (it2.hasNext()) {
                            OfflineMapCity next = it2.next();
                            for (ax axVar : this.f5777c) {
                                if (next.getPinyin().equals(axVar.getPinyin())) {
                                    String version = axVar.getVersion();
                                    if (axVar.getState() == 4 && f5774r.length() > 0 && n(f5774r, version)) {
                                        axVar.C();
                                        axVar.setUrl(next.getUrl());
                                        axVar.F();
                                    } else {
                                        axVar.setCity(next.getCity());
                                        axVar.setUrl(next.getUrl());
                                        axVar.F();
                                        axVar.setAdcode(next.getAdcode());
                                        axVar.setVersion(next.getVersion());
                                        axVar.setSize(next.getSize());
                                        axVar.setCode(next.getCode());
                                        axVar.setJianpin(next.getJianpin());
                                        axVar.setPinyin(next.getPinyin());
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void q(ax axVar) {
        h0 h0Var = this.f5785k;
        if (h0Var != null) {
            h0Var.c(axVar);
        }
        e eVar = this.f5784j;
        if (eVar != null) {
            Message obtainMessage = eVar.obtainMessage();
            obtainMessage.obj = axVar;
            this.f5784j.sendMessage(obtainMessage);
        }
    }

    public final void t() {
        synchronized (this.f5777c) {
            try {
                for (ax axVar : this.f5777c) {
                    if (!axVar.s().equals(axVar.f5641h) && !axVar.s().equals(axVar.f5640g)) {
                    }
                    u(axVar);
                    axVar.z();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void u(ax axVar) {
        m0 m0Var = this.f5779e;
        if (m0Var != null) {
            m0Var.b(axVar);
        }
    }

    public final void w() {
        synchronized (this.f5777c) {
            try {
                Iterator<ax> it = this.f5777c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ax next = it.next();
                    if (next.s().equals(next.f5641h)) {
                        next.z();
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void x(ax axVar) {
        m0 m0Var = this.f5779e;
        if (m0Var != null) {
            m0Var.e(axVar);
        }
    }

    private c0(Context context) {
        this.f5775a = context;
    }

    private void B(ax axVar) throws AMapException {
        L();
        if (axVar != null) {
            if (this.f5783i == null) {
                this.f5783i = a3.b("AMapOfflineDownload");
            }
            try {
                this.f5783i.b(new c(axVar));
                return;
            } catch (Throwable th) {
                v5.p(th, "startDownload", "downloadExcecRunnable");
                return;
            }
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    public final void C(String str) throws AMapException {
        ax K = K(str);
        if (K != null) {
            B(K);
            return;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    public final void j() {
        J();
        d dVar = this.f5778d;
        if (dVar != null) {
            try {
                dVar.a();
            } catch (Throwable th) {
                v5.p(th, "OfflineDownloadManager", "verifyCallBack");
            }
        }
    }

    public final boolean m(String str) {
        if (I(str) == null) {
            return false;
        }
        return true;
    }

    public final void r(String str) {
        ax I = I(str);
        if (I == null) {
            d dVar = this.f5778d;
            if (dVar != null) {
                try {
                    dVar.c(I);
                    return;
                } catch (Throwable th) {
                    v5.p(th, "OfflineDownloadManager", "remove");
                    return;
                }
            }
            return;
        }
        u(I);
        f(I, true);
    }

    public final void v(String str) {
        ax I = I(str);
        if (I != null) {
            I.y();
        }
    }

    public final void y(String str) throws AMapException {
        ax I = I(str);
        if (str != null && str.length() > 0 && I != null) {
            B(I);
            return;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }
}
