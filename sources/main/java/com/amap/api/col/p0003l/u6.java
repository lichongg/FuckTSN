package com.amap.api.col.p0003l;

import com.amap.api.col.p0003l.Cif;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class u6 {

    /* renamed from: a, reason: collision with root package name */
    private w6 f7395a;

    /* renamed from: b, reason: collision with root package name */
    private Cif f7396b;

    /* renamed from: c, reason: collision with root package name */
    private long f7397c;

    /* renamed from: d, reason: collision with root package name */
    private long f7398d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void onDownload(byte[] bArr, long j6);

        void onException(Throwable th);

        void onFinish();

        void onStop();
    }

    public u6(Cif cif) {
        this(cif, (byte) 0);
    }

    private u6(Cif cif, byte b6) {
        this(cif, 0L, -1L, false);
    }

    public final void a() {
        w6 w6Var = this.f7395a;
        if (w6Var != null) {
            w6Var.k();
        }
    }

    public final void b(a aVar) {
        try {
            w6 w6Var = new w6();
            this.f7395a = w6Var;
            w6Var.t(this.f7398d);
            this.f7395a.l(this.f7397c);
            r6.b();
            if (r6.g(this.f7396b)) {
                this.f7396b.setDegradeType(Cif.b.NEVER_GRADE);
                this.f7395a.m(this.f7396b, aVar);
            } else {
                this.f7396b.setDegradeType(Cif.b.DEGRADE_ONLY);
                this.f7395a.m(this.f7396b, aVar);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public u6(Cif cif, long j6, long j7, boolean z5) {
        this.f7396b = cif;
        this.f7397c = j6;
        this.f7398d = j7;
        cif.setHttpProtocol(z5 ? Cif.c.HTTPS : Cif.c.HTTP);
        this.f7396b.setDegradeAbility(Cif.a.SINGLE);
    }
}
