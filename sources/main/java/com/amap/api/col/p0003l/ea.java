package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.ft;
import com.amap.api.col.p0003l.u6;
import com.stub.StubApp;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class ea implements u6.a {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6019a;

    /* renamed from: b, reason: collision with root package name */
    private RandomAccessFile f6020b;

    /* renamed from: c, reason: collision with root package name */
    private a7 f6021c;

    /* renamed from: d, reason: collision with root package name */
    private String f6022d;

    /* renamed from: e, reason: collision with root package name */
    a f6023e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        protected String f6024a;

        /* renamed from: b, reason: collision with root package name */
        protected String f6025b;

        /* renamed from: c, reason: collision with root package name */
        protected String f6026c;

        /* renamed from: d, reason: collision with root package name */
        protected String f6027d;

        /* renamed from: e, reason: collision with root package name */
        protected String f6028e;

        /* renamed from: f, reason: collision with root package name */
        protected c f6029f;

        public final String a() {
            return this.f6024a;
        }

        public final void b(c cVar) {
            this.f6029f = cVar;
        }

        public final String c() {
            return this.f6025b;
        }

        public final String d() {
            return this.f6027d;
        }

        public final String e() {
            return this.f6028e;
        }

        public final c f() {
            return this.f6029f;
        }

        public a(String str, String str2, String str3, String str4) {
            this.f6024a = str;
            this.f6025b = str2;
            this.f6026c = str3;
            this.f6027d = str4 + ".tmp";
            this.f6028e = str4;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b extends g2 {

        /* renamed from: r, reason: collision with root package name */
        private final a f6030r;

        @Override // com.amap.api.col.p0003l.g2, com.amap.api.col.p0003l.Cif
        public final Map<String, String> getParams() {
            return null;
        }

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
            a aVar = this.f6030r;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        }

        b(a aVar) {
            this.f6030r = aVar;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getIPV6URL() {
            return getURL();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c {

        /* renamed from: a, reason: collision with root package name */
        protected String f6031a;

        /* renamed from: b, reason: collision with root package name */
        protected String f6032b;

        public final String a() {
            return this.f6031a;
        }

        public final String b() {
            return this.f6032b;
        }

        public final boolean c() {
            return (TextUtils.isEmpty(this.f6031a) || TextUtils.isEmpty(this.f6032b)) ? false : true;
        }

        public c(String str, String str2) {
            this.f6031a = str;
            this.f6032b = str2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d extends a {
        public final void g(String str, String str2) {
            b(new c(str, str2));
        }

        public d(String str, String str2, String str3, String str4) {
            super(str, str2, str3, str4);
        }
    }

    private boolean b() {
        c f6 = this.f6023e.f();
        return (f6 != null && f6.c() && r2.b(this.f6019a, f6.a(), f6.b(), "").equalsIgnoreCase(this.f6023e.c())) ? false : true;
    }

    public final void a() {
        a7 a7Var;
        if (com.amap.api.col.p0003l.d.f5883f == null || ft.a(com.amap.api.col.p0003l.d.f5883f, b3.s()).f6803a == ft.c.SuccessCode) {
            try {
                if (!b() || (a7Var = this.f6021c) == null) {
                    return;
                }
                a7Var.b(this);
            } catch (Throwable th) {
                v5.p(th, "AuthTaskDownload", "startDownload()");
            }
        }
    }

    @Override // com.amap.api.col.3l.u6.a
    public final void onDownload(byte[] bArr, long j6) {
        try {
            if (this.f6020b == null) {
                File file = new File(this.f6022d);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.f6020b = new RandomAccessFile(file, "rw");
            }
            this.f6020b.seek(j6);
            this.f6020b.write(bArr);
        } catch (Throwable th) {
            v5.p(th, "AuthTaskDownload", "onDownload()");
        }
    }

    @Override // com.amap.api.col.3l.u6.a
    public final void onException(Throwable th) {
        try {
            RandomAccessFile randomAccessFile = this.f6020b;
            if (randomAccessFile == null) {
                return;
            }
            randomAccessFile.close();
        } catch (Throwable th2) {
            v5.p(th2, "AuthTaskDownload", "onException()");
        }
    }

    @Override // com.amap.api.col.3l.u6.a
    public final void onFinish() {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = this.f6020b;
        } catch (Throwable th) {
            v5.p(th, "AuthTaskDownload", "onFinish()");
        }
        if (randomAccessFile == null) {
            return;
        }
        try {
            randomAccessFile.close();
        } catch (Throwable th2) {
            v5.p(th2, "AuthTaskDownload", "onFinish3");
        }
        String c6 = this.f6023e.c();
        String a6 = m4.a(this.f6022d);
        if (a6 == null || !c6.equalsIgnoreCase(a6)) {
            try {
                new File(this.f6022d).delete();
                return;
            } catch (Throwable th3) {
                v5.p(th3, "AuthTaskDownload", "onFinish");
                return;
            }
        }
        String e6 = this.f6023e.e();
        try {
            u0 u0Var = new u0();
            File file = new File(this.f6022d);
            u0Var.b(file, new File(e6), -1L, a1.b(file), null);
            c f6 = this.f6023e.f();
            if (f6 != null && f6.c()) {
                r2.c(this.f6019a, f6.a(), f6.b(), a6);
            }
            new File(this.f6022d).delete();
            return;
        } catch (Throwable th4) {
            v5.p(th4, "AuthTaskDownload", "onFinish1");
            return;
        }
        v5.p(th, "AuthTaskDownload", "onFinish()");
    }

    public ea(Context context, a aVar) {
        this.f6019a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f6023e = aVar;
        this.f6021c = new a7(new b(aVar));
        this.f6022d = aVar.d();
    }

    @Override // com.amap.api.col.3l.u6.a
    public final void onStop() {
    }
}
