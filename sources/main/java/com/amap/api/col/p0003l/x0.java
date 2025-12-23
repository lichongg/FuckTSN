package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.by;
import com.amap.api.col.p0003l.ft;
import com.amap.api.col.p0003l.u6;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.MapsInitializer;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.stub.StubApp;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class x0 implements u6.a {

    /* renamed from: a, reason: collision with root package name */
    y0 f7617a;

    /* renamed from: d, reason: collision with root package name */
    long f7620d;

    /* renamed from: f, reason: collision with root package name */
    private Context f7622f;

    /* renamed from: g, reason: collision with root package name */
    s0 f7623g;

    /* renamed from: h, reason: collision with root package name */
    private by f7624h;

    /* renamed from: i, reason: collision with root package name */
    private String f7625i;

    /* renamed from: j, reason: collision with root package name */
    private a7 f7626j;

    /* renamed from: k, reason: collision with root package name */
    private t0 f7627k;

    /* renamed from: n, reason: collision with root package name */
    a f7630n;

    /* renamed from: b, reason: collision with root package name */
    long f7618b = 0;

    /* renamed from: c, reason: collision with root package name */
    long f7619c = 0;

    /* renamed from: e, reason: collision with root package name */
    boolean f7621e = true;

    /* renamed from: l, reason: collision with root package name */
    long f7628l = 0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f7629m = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void c();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b extends g2 {

        /* renamed from: r, reason: collision with root package name */
        private final String f7631r;

        @Override // com.amap.api.col.p0003l.Cif
        public final Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final boolean isSupportIPV6() {
            return false;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getURL() {
            return this.f7631r;
        }

        public b(String str) {
            this.f7631r = str;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getIPV6URL() {
            return getURL();
        }
    }

    @Override // com.amap.api.col.3l.u6.a
    public final void onException(Throwable th) {
        t0 t0Var;
        this.f7629m = true;
        d();
        by byVar = this.f7624h;
        if (byVar != null) {
            byVar.b(by.a.network_exception);
        }
        if ((th instanceof IOException) || (t0Var = this.f7627k) == null) {
            return;
        }
        t0Var.b();
    }

    private void b(long j6) {
        by byVar;
        long j7 = this.f7620d;
        if (j7 <= 0 || (byVar = this.f7624h) == null) {
            return;
        }
        byVar.a(j7, j6);
        this.f7628l = System.currentTimeMillis();
    }

    private void e() throws IOException {
        d1 d1Var = new d1(this.f7625i);
        d1Var.setConnectionTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
        d1Var.setSoTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
        this.f7626j = new a7(d1Var, this.f7618b, this.f7619c, MapsInitializer.getProtocol() == 2);
        this.f7627k = new t0(this.f7617a.b() + File.separator + this.f7617a.c(), this.f7618b);
    }

    private void f() {
        File file = new File(this.f7617a.b() + this.f7617a.c());
        if (!file.exists()) {
            this.f7618b = 0L;
            this.f7619c = 0L;
            return;
        }
        this.f7621e = false;
        this.f7618b = file.length();
        try {
            long i6 = i();
            this.f7620d = i6;
            this.f7619c = i6;
        } catch (IOException unused) {
            by byVar = this.f7624h;
            if (byVar != null) {
                byVar.b(by.a.file_io_exception);
            }
        }
    }

    private boolean g() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7617a.b());
        sb.append(File.separator);
        sb.append(this.f7617a.c());
        return new File(sb.toString()).length() >= 10;
    }

    private void h() throws AMapException {
        if (g4.f6287a != 1) {
            for (int i6 = 0; i6 < 3; i6++) {
                try {
                    g4.c(this.f7622f, b3.s(), "", null);
                } catch (Throwable th) {
                    v5.p(th, "SiteFileFetch", "authOffLineDownLoad");
                    th.printStackTrace();
                }
                if (g4.f6287a == 1) {
                    return;
                }
            }
        }
    }

    private long i() throws IOException {
        Map<String, String> map;
        if (ft.a(this.f7622f, b3.s()).f6803a != ft.c.SuccessCode) {
            return -1L;
        }
        String a6 = this.f7617a.a();
        try {
            y6.n();
            map = y6.q(new b(a6), MapsInitializer.getProtocol() == 2);
        } catch (fk e6) {
            e6.printStackTrace();
            map = null;
        }
        int i6 = -1;
        if (map != null) {
            for (String str : map.keySet()) {
                if ("Content-Length".equalsIgnoreCase(str)) {
                    i6 = Integer.parseInt(map.get(str));
                }
            }
        }
        return i6;
    }

    private void k() {
        this.f7623g.f(this.f7617a.e(), this.f7617a.d(), this.f7620d, this.f7618b, this.f7619c);
    }

    public final void a() {
        try {
            if (!b3.h0(this.f7622f)) {
                by byVar = this.f7624h;
                if (byVar != null) {
                    byVar.b(by.a.network_exception);
                    return;
                }
                return;
            }
            h();
            if (g4.f6287a != 1) {
                by byVar2 = this.f7624h;
                if (byVar2 != null) {
                    byVar2.b(by.a.amap_exception);
                    return;
                }
                return;
            }
            if (!g()) {
                this.f7621e = true;
            }
            if (this.f7621e) {
                long i6 = i();
                this.f7620d = i6;
                if (i6 != -1 && i6 != -2) {
                    this.f7619c = i6;
                }
                this.f7618b = 0L;
            }
            by byVar3 = this.f7624h;
            if (byVar3 != null) {
                byVar3.m();
            }
            if (this.f7618b >= this.f7619c) {
                onFinish();
            } else {
                e();
                this.f7626j.b(this);
            }
        } catch (AMapException e6) {
            v5.p(e6, "SiteFileFetch", "download");
            by byVar4 = this.f7624h;
            if (byVar4 != null) {
                byVar4.b(by.a.amap_exception);
            }
        } catch (IOException unused) {
            by byVar5 = this.f7624h;
            if (byVar5 != null) {
                byVar5.b(by.a.file_io_exception);
            }
        }
    }

    public final void c(a aVar) {
        this.f7630n = aVar;
    }

    public final void d() {
        a7 a7Var = this.f7626j;
        if (a7Var != null) {
            a7Var.a();
        }
    }

    @Override // com.amap.api.col.3l.u6.a
    public final void onDownload(byte[] bArr, long j6) {
        try {
            this.f7627k.a(bArr);
            this.f7618b = j6;
            j();
        } catch (IOException e6) {
            e6.printStackTrace();
            v5.p(e6, "fileAccessI", "fileAccessI.write(byte[] data)");
            by byVar = this.f7624h;
            if (byVar != null) {
                byVar.b(by.a.file_io_exception);
            }
            a7 a7Var = this.f7626j;
            if (a7Var != null) {
                a7Var.a();
            }
        }
    }

    @Override // com.amap.api.col.3l.u6.a
    public final void onStop() {
        if (this.f7629m) {
            return;
        }
        by byVar = this.f7624h;
        if (byVar != null) {
            byVar.a();
        }
        k();
    }

    public x0(y0 y0Var, String str, Context context, by byVar) throws IOException {
        this.f7617a = null;
        this.f7623g = s0.b(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.f7617a = y0Var;
        this.f7622f = context;
        this.f7625i = str;
        this.f7624h = byVar;
        f();
    }

    private void j() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f7617a != null && currentTimeMillis - this.f7628l > 500) {
            k();
            this.f7628l = currentTimeMillis;
            b(this.f7618b);
        }
    }

    @Override // com.amap.api.col.3l.u6.a
    public final void onFinish() {
        j();
        by byVar = this.f7624h;
        if (byVar != null) {
            byVar.n();
        }
        t0 t0Var = this.f7627k;
        if (t0Var != null) {
            t0Var.b();
        }
        a aVar = this.f7630n;
        if (aVar != null) {
            aVar.c();
        }
    }
}
