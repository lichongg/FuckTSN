package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.n;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
import master.flame.danmaku.danmaku.model.r;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class d {

    /* renamed from: l, reason: collision with root package name */
    public static final float f49997l = 539.0f;

    /* renamed from: m, reason: collision with root package name */
    public static final float f49998m = 682.0f;

    /* renamed from: n, reason: collision with root package name */
    public static final float f49999n = 385.0f;

    /* renamed from: o, reason: collision with root package name */
    public static final float f50000o = 438.0f;

    /* renamed from: p, reason: collision with root package name */
    public static final long f50001p = 3800;

    /* renamed from: q, reason: collision with root package name */
    public static final int f50002q = 25;

    /* renamed from: r, reason: collision with root package name */
    public static final long f50003r = 4000;

    /* renamed from: s, reason: collision with root package name */
    public static final long f50004s = 9000;

    /* renamed from: f, reason: collision with root package name */
    public master.flame.danmaku.danmaku.model.g f50010f;

    /* renamed from: g, reason: collision with root package name */
    public master.flame.danmaku.danmaku.model.g f50011g;

    /* renamed from: h, reason: collision with root package name */
    public master.flame.danmaku.danmaku.model.g f50012h;

    /* renamed from: j, reason: collision with root package name */
    public n f50014j;

    /* renamed from: k, reason: collision with root package name */
    private DanmakuContext f50015k;

    /* renamed from: a, reason: collision with root package name */
    public int f50005a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f50006b = 0;

    /* renamed from: c, reason: collision with root package name */
    private float f50007c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    public long f50008d = f50001p;

    /* renamed from: e, reason: collision with root package name */
    public long f50009e = f50003r;

    /* renamed from: i, reason: collision with root package name */
    private m f50013i = new e();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends m.c<master.flame.danmaku.danmaku.model.d> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f50016e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f50017f;

        @Override // master.flame.danmaku.danmaku.model.m.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public int a(master.flame.danmaku.danmaku.model.d dVar) {
            r rVar = (r) dVar;
            d.this.i(rVar, rVar.W, rVar.X, rVar.Y, rVar.Z, rVar.f50120c0, rVar.f50121d0, this.f50016e, this.f50017f);
            r.a[] aVarArr = rVar.f50132o0;
            if (aVarArr != null && aVarArr.length > 0) {
                int length = aVarArr.length;
                float[][] fArr = (float[][]) Array.newInstance((Class<?>) Float.TYPE, length + 1, 2);
                int i6 = 0;
                while (i6 < length) {
                    fArr[i6] = aVarArr[i6].a();
                    int i7 = i6 + 1;
                    fArr[i7] = aVarArr[i6].c();
                    i6 = i7;
                }
                d.h(rVar, fArr, this.f50016e, this.f50017f);
            }
            return 0;
        }

        a(float f6, float f7) {
            this.f50016e = f6;
            this.f50017f = f7;
        }
    }

    private synchronized void n(float f6, float f7) {
        this.f50013i.a(new a(f6, f7));
    }

    public master.flame.danmaku.danmaku.model.d d(int i6, int i7, int i8, float f6, float f7) {
        return c(i6, i7, i8, f6, f7);
    }

    public void k() {
        this.f50014j = null;
        this.f50006b = 0;
        this.f50005a = 0;
        this.f50013i.clear();
        this.f50010f = null;
        this.f50011g = null;
        this.f50012h = null;
        this.f50009e = f50003r;
    }

    static d a() {
        return new d();
    }

    private void o(master.flame.danmaku.danmaku.model.d dVar) {
        master.flame.danmaku.danmaku.model.g gVar;
        master.flame.danmaku.danmaku.model.g gVar2 = this.f50012h;
        if (gVar2 == null || ((gVar = dVar.f50071r) != null && gVar.f50084c > gVar2.f50084c)) {
            this.f50012h = dVar.f50071r;
            m();
        }
    }

    public master.flame.danmaku.danmaku.model.d b(int i6) {
        return f(i6, this.f50015k);
    }

    public master.flame.danmaku.danmaku.model.d c(int i6, float f6, float f7, float f8, float f9) {
        float f10;
        float f11;
        int i7 = this.f50005a;
        int i8 = this.f50006b;
        boolean p5 = p(f6, f7, f8);
        master.flame.danmaku.danmaku.model.g gVar = this.f50010f;
        if (gVar == null) {
            master.flame.danmaku.danmaku.model.g gVar2 = new master.flame.danmaku.danmaku.model.g(this.f50008d);
            this.f50010f = gVar2;
            gVar2.a(f9);
        } else if (p5) {
            gVar.b(this.f50008d);
        }
        if (this.f50011g == null) {
            this.f50011g = new master.flame.danmaku.danmaku.model.g(f50001p);
        }
        if (p5 && f6 > 0.0f) {
            m();
            if (i7 <= 0 || i8 <= 0) {
                f10 = 1.0f;
                f11 = 1.0f;
            } else {
                f10 = f6 / i7;
                f11 = f7 / i8;
            }
            if (f7 > 0.0f) {
                n(f10, f11);
            }
        }
        if (i6 == 1) {
            return new q(this.f50010f);
        }
        if (i6 == 4) {
            return new master.flame.danmaku.danmaku.model.h(this.f50011g);
        }
        if (i6 == 5) {
            return new master.flame.danmaku.danmaku.model.i(this.f50011g);
        }
        if (i6 == 6) {
            return new p(this.f50010f);
        }
        if (i6 != 7) {
            return null;
        }
        r rVar = new r();
        this.f50013i.j(rVar);
        return rVar;
    }

    public master.flame.danmaku.danmaku.model.d e(int i6, n nVar, float f6, float f7) {
        if (nVar == null) {
            return null;
        }
        this.f50014j = nVar;
        return d(i6, nVar.getWidth(), nVar.getHeight(), f6, f7);
    }

    public master.flame.danmaku.danmaku.model.d f(int i6, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.f50015k = danmakuContext;
        master.flame.danmaku.danmaku.model.b g6 = danmakuContext.g();
        this.f50014j = g6;
        return d(i6, g6.getWidth(), this.f50014j.getHeight(), this.f50007c, danmakuContext.f49926l);
    }

    public void j(DanmakuContext danmakuContext) {
        this.f50015k = danmakuContext;
        this.f50014j = danmakuContext.g();
        f(1, danmakuContext);
    }

    public void l(float f6) {
        master.flame.danmaku.danmaku.model.g gVar = this.f50010f;
        if (gVar == null || this.f50011g == null) {
            return;
        }
        gVar.a(f6);
        m();
    }

    public void m() {
        master.flame.danmaku.danmaku.model.g gVar = this.f50010f;
        long j6 = gVar == null ? 0L : gVar.f50084c;
        master.flame.danmaku.danmaku.model.g gVar2 = this.f50011g;
        long j7 = gVar2 == null ? 0L : gVar2.f50084c;
        master.flame.danmaku.danmaku.model.g gVar3 = this.f50012h;
        long j8 = gVar3 != null ? gVar3.f50084c : 0L;
        long max = Math.max(j6, j7);
        this.f50009e = max;
        long max2 = Math.max(max, j8);
        this.f50009e = max2;
        long max3 = Math.max(f50001p, max2);
        this.f50009e = max3;
        this.f50009e = Math.max(this.f50008d, max3);
    }

    public boolean p(float f6, float f7, float f8) {
        int i6 = (int) f6;
        if (this.f50005a == i6 && this.f50006b == ((int) f7) && this.f50007c == f8) {
            return false;
        }
        long j6 = (long) (((f6 * f8) / 682.0f) * 3800.0f);
        this.f50008d = j6;
        long min = Math.min(f50004s, j6);
        this.f50008d = min;
        this.f50008d = Math.max(f50003r, min);
        this.f50005a = i6;
        this.f50006b = (int) f7;
        this.f50007c = f8;
        return true;
    }

    protected d() {
    }

    public static void h(master.flame.danmaku.danmaku.model.d dVar, float[][] fArr, float f6, float f7) {
        if (dVar.getType() == 7 && fArr.length != 0 && fArr[0].length == 2) {
            for (float[] fArr2 : fArr) {
                fArr2[0] = fArr2[0] * f6;
                fArr2[1] = fArr2[1] * f7;
            }
            ((r) dVar).J(fArr);
        }
    }

    public void g(master.flame.danmaku.danmaku.model.d dVar, int i6, int i7, long j6) {
        if (dVar.getType() != 7) {
            return;
        }
        ((r) dVar).I(i6, i7, j6);
        o(dVar);
    }

    public void i(master.flame.danmaku.danmaku.model.d dVar, float f6, float f7, float f8, float f9, long j6, long j7, float f10, float f11) {
        if (dVar.getType() != 7) {
            return;
        }
        ((r) dVar).K(f6 * f10, f7 * f11, f8 * f10, f9 * f11, j6, j7);
        o(dVar);
    }
}
