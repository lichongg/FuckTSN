package com.beizi.ad.internal.d;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.beizi.ad.internal.h.o;
import com.beizi.ad.internal.k;
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.concurrent.RejectedExecutionException;
import xyz.adscope.amps.common.AMPSConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class b {

    /* renamed from: j, reason: collision with root package name */
    static HashMap<String, String> f11729j = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    protected k f11730a;

    /* renamed from: b, reason: collision with root package name */
    protected com.beizi.ad.b.b f11731b;

    /* renamed from: c, reason: collision with root package name */
    protected com.beizi.ad.internal.d.a f11732c;

    /* renamed from: d, reason: collision with root package name */
    protected com.beizi.ad.internal.c f11733d;

    /* renamed from: f, reason: collision with root package name */
    protected com.beizi.ad.internal.f.c f11735f;

    /* renamed from: l, reason: collision with root package name */
    private SoftReference<com.beizi.ad.internal.f> f11740l;

    /* renamed from: e, reason: collision with root package name */
    protected e f11734e = new e(this);

    /* renamed from: g, reason: collision with root package name */
    protected boolean f11736g = false;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f11737h = false;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f11738i = false;

    /* renamed from: m, reason: collision with root package name */
    private final Handler f11741m = new HandlerC0104b(this);

    /* renamed from: n, reason: collision with root package name */
    private long f11742n = -1;

    /* renamed from: o, reason: collision with root package name */
    private long f11743o = -1;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f11739k = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.d.b$1, reason: invalid class name */
    class AnonymousClass1 implements com.beizi.ad.internal.f.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f11748a;

        @Override // com.beizi.ad.internal.f.b
        public boolean b() {
            return true;
        }

        @Override // com.beizi.ad.internal.f.b
        public com.beizi.ad.i d() {
            return null;
        }

        @Override // com.beizi.ad.internal.f.b
        public String f() {
            return null;
        }

        @Override // com.beizi.ad.internal.f.b
        public String g() {
            return null;
        }

        @Override // com.beizi.ad.internal.f.b
        public boolean i() {
            return false;
        }

        @Override // com.beizi.ad.internal.f.b
        public com.beizi.ad.internal.f.c j() {
            return null;
        }

        @Override // com.beizi.ad.internal.f.b
        public String k() {
            return null;
        }

        @Override // com.beizi.ad.internal.f.b
        public k a() {
            return this.f11748a.f11730a;
        }

        @Override // com.beizi.ad.internal.f.b
        public com.beizi.ad.internal.view.c c() {
            return this.f11748a.f11734e;
        }

        @Override // com.beizi.ad.internal.f.b
        public String e() {
            return "";
        }

        @Override // com.beizi.ad.internal.f.b
        public void h() {
            this.f11748a.f11734e.destroy();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a extends com.beizi.ad.internal.h.d {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<com.beizi.ad.internal.f> f11749a;

        /* renamed from: b, reason: collision with root package name */
        final int f11750b;

        /* renamed from: d, reason: collision with root package name */
        private final String f11752d;

        /* renamed from: e, reason: collision with root package name */
        private final HashMap<String, Object> f11753e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f11754f;

        /* renamed from: g, reason: collision with root package name */
        private final long f11755g;

        /* renamed from: h, reason: collision with root package name */
        private final long f11756h;

        /* synthetic */ a(b bVar, com.beizi.ad.internal.f fVar, String str, int i6, HashMap hashMap, boolean z5, long j6, long j7, AnonymousClass1 anonymousClass1) {
            this(fVar, str, i6, hashMap, z5, j6, j7);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.beizi.ad.internal.h.d, android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(com.beizi.ad.internal.h.e eVar) {
            com.beizi.ad.internal.f fVar;
            com.beizi.ad.internal.f.c cVar;
            if (this.f11754f || (fVar = this.f11749a.get()) == null) {
                return;
            }
            if (eVar == null || !eVar.a()) {
                cVar = null;
            } else {
                cVar = new com.beizi.ad.internal.f.c(eVar, b.this.f11730a);
                if (this.f11753e.containsKey("ORIENTATION")) {
                    cVar.a(this.f11753e.get("ORIENTATION").equals("h") ? 1 : 2);
                }
            }
            fVar.a(cVar);
        }

        private a(com.beizi.ad.internal.f fVar, String str, int i6, HashMap<String, Object> hashMap, boolean z5, long j6, long j7) {
            super(true, true);
            this.f11749a = new WeakReference<>(fVar);
            this.f11752d = str;
            this.f11750b = i6;
            this.f11753e = hashMap;
            this.f11754f = z5;
            this.f11755g = j6;
            this.f11756h = j7;
        }

        @Override // com.beizi.ad.internal.h.d
        protected String a() {
            StringBuilder sb = new StringBuilder(this.f11752d);
            sb.append("&errorCode=");
            sb.append(this.f11750b);
            com.beizi.ad.internal.h.a a6 = com.beizi.ad.internal.h.a.a();
            if (!o.a(a6.d())) {
                sb.append("&sdkuid=");
                sb.append(Uri.encode(a6.d()));
            }
            if (this.f11755g > 0) {
                sb.append("&latency=");
                sb.append(Uri.encode(String.valueOf(this.f11755g)));
            }
            if (this.f11756h > 0) {
                sb.append("&total_latency=");
                sb.append(Uri.encode(String.valueOf(this.f11756h)));
            }
            return sb.toString();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.d.b$b, reason: collision with other inner class name */
    static class HandlerC0104b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<b> f11757a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.f11757a.get();
            if (bVar == null || bVar.f11736g) {
                return;
            }
            try {
                bVar.a(0);
            } catch (IllegalArgumentException unused) {
            } catch (Throwable th) {
                bVar.f11733d = null;
                bVar.f11731b = null;
                bVar.f11732c = null;
                throw th;
            }
            bVar.f11733d = null;
            bVar.f11731b = null;
            bVar.f11732c = null;
        }

        public HandlerC0104b(b bVar) {
            this.f11757a = new WeakReference<>(bVar);
        }
    }

    void a(String str, String str2) {
        f11729j.put(str + ".SPLASH", str2 + ExploreConstants.SCENE_SPLASH);
        f11729j.put(str + ".BANNER", str2 + "Banner");
        f11729j.put(str + ".INTERSTITIAL", str2 + ExploreConstants.SCENE_INTERSTITIAL);
        f11729j.put(str + ".NATIVE", str2 + "Native");
        f11729j.put(str + ".REWARDEDVIDEO", str2 + ExploreConstants.SCENE_INTERSTITIAL);
    }

    protected void b() {
        com.beizi.ad.b.b bVar = this.f11731b;
        if (bVar != null) {
            bVar.b();
        }
        this.f11738i = true;
        this.f11731b = null;
        this.f11732c = null;
    }

    public abstract void c();

    public abstract void i();

    public abstract void j();

    public abstract void k();

    private boolean l() {
        String str;
        try {
            String str2 = this.f11732c.a() + "." + this.f11730a.toString();
            String str3 = f11729j.get(str2);
            String str4 = com.beizi.ad.internal.h.a().f12001f.get(str2);
            if (o.a(str4)) {
                if (o.a(str3)) {
                    str = getClass().getPackage().getName() + "." + str2;
                } else {
                    str = getClass().getPackage().getName() + "." + str3;
                }
                this.f11731b = (com.beizi.ad.b.b) Class.forName(str).newInstance();
            } else {
                this.f11731b = (com.beizi.ad.b.b) Class.forName(getClass().getPackage().getName() + "." + str4).getConstructor(String.class).newInstance(str2);
            }
            return true;
        } catch (ClassCastException e6) {
            a(e6, this.f11732c.a());
            return false;
        } catch (ClassNotFoundException e7) {
            a(e7, this.f11732c.a());
            return false;
        } catch (IllegalAccessException e8) {
            a(e8, this.f11732c.a());
            return false;
        } catch (InstantiationException e9) {
            a(e9, this.f11732c.a());
            return false;
        } catch (LinkageError e10) {
            a(e10, this.f11732c.a());
            return false;
        } catch (NoSuchMethodException e11) {
            a(e11, this.f11732c.a());
            return false;
        } catch (InvocationTargetException e12) {
            a(e12, this.f11732c.a());
            return false;
        }
    }

    private long m() {
        long j6 = this.f11742n;
        if (j6 <= 0) {
            return -1L;
        }
        long j7 = this.f11743o;
        if (j7 > 0) {
            return j7 - j6;
        }
        return -1L;
    }

    public boolean d() {
        return this.f11738i;
    }

    void e() {
        if (this.f11737h || this.f11736g) {
            return;
        }
        this.f11741m.sendEmptyMessageDelayed(0, 15000L);
    }

    void f() {
        this.f11741m.removeMessages(0);
    }

    b(com.beizi.ad.internal.f fVar, com.beizi.ad.internal.d.a aVar, com.beizi.ad.internal.c cVar, k kVar, com.beizi.ad.internal.f.c cVar2) {
        int i6;
        if (f11729j.isEmpty()) {
            a("1", "Baidu");
            a("4", AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GDT);
            a("43", "AFP");
        }
        this.f11735f = cVar2;
        this.f11740l = new SoftReference<>(fVar);
        this.f11732c = aVar;
        this.f11733d = cVar;
        this.f11730a = kVar;
        if (aVar == null) {
            i6 = 3;
        } else if (!l()) {
            i6 = 2;
        } else {
            i6 = -1;
        }
        if (i6 != -1) {
            a(i6);
        }
    }

    protected void g() {
        this.f11742n = System.currentTimeMillis();
    }

    protected void h() {
        this.f11743o = System.currentTimeMillis();
    }

    @SuppressLint({"InlinedApi", "NewApi"})
    private void b(int i6) {
        if (this.f11736g) {
            return;
        }
        com.beizi.ad.internal.f fVar = this.f11740l.get();
        com.beizi.ad.internal.d.a aVar = this.f11732c;
        if (aVar == null || o.a(aVar.f())) {
            if (i6 == -1 || fVar == null) {
                return;
            }
            fVar.a((com.beizi.ad.internal.f.c) null);
            return;
        }
        boolean z5 = i6 == -1 ? true : (fVar == null || fVar.b() == null || fVar.b().size() <= 0) ? false : true;
        try {
            new a(this, fVar, this.f11732c.f(), i6, this.f11732c.g(), z5, m(), a(fVar), null).execute(new Void[0]);
        } catch (RejectedExecutionException | Exception unused) {
        }
        if (!z5 || i6 == -1 || fVar == null) {
            return;
        }
        fVar.a((com.beizi.ad.internal.f.c) null);
    }

    boolean a(Class cls) {
        if (this.f11736g) {
            return false;
        }
        com.beizi.ad.b.b bVar = this.f11731b;
        if (bVar != null && cls != null && cls.isInstance(bVar)) {
            return true;
        }
        a(3);
        return false;
    }

    protected com.beizi.ad.b.a a() {
        com.beizi.ad.internal.f fVar = this.f11740l.get();
        if (fVar != null) {
            return fVar.d();
        }
        return null;
    }

    private void a(Throwable th, String str) {
        if (o.a(str)) {
            return;
        }
        com.beizi.ad.internal.h.a().a(this.f11730a, str);
    }

    public void a(int i6) {
        if (this.f11737h || this.f11736g || this.f11738i) {
            return;
        }
        h();
        f();
        b(i6);
        this.f11736g = true;
        b();
    }

    private long a(com.beizi.ad.internal.f fVar) {
        if (fVar == null) {
            return -1L;
        }
        long j6 = this.f11743o;
        if (j6 > 0) {
            return fVar.a(j6);
        }
        return -1L;
    }

    public void a(boolean z5) {
        this.f11739k = z5;
        if (z5) {
            b();
        }
    }
}
