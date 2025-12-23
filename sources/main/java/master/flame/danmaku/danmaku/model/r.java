package master.flame.danmaku.danmaku.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class r extends d {
    public float W;
    public float X;
    public float Y;
    public float Z;

    /* renamed from: a0, reason: collision with root package name */
    public float f50118a0;

    /* renamed from: b0, reason: collision with root package name */
    public float f50119b0;

    /* renamed from: c0, reason: collision with root package name */
    public long f50120c0;

    /* renamed from: d0, reason: collision with root package name */
    public long f50121d0;

    /* renamed from: f0, reason: collision with root package name */
    public int f50123f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f50124g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f50125h0;

    /* renamed from: i0, reason: collision with root package name */
    public long f50126i0;

    /* renamed from: j0, reason: collision with root package name */
    public float f50127j0;

    /* renamed from: k0, reason: collision with root package name */
    public float f50128k0;

    /* renamed from: l0, reason: collision with root package name */
    public float f50129l0;

    /* renamed from: m0, reason: collision with root package name */
    public float f50130m0;

    /* renamed from: o0, reason: collision with root package name */
    public a[] f50132o0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f50122e0 = false;

    /* renamed from: n0, reason: collision with root package name */
    private float[] f50131n0 = new float[4];

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        b f50133a;

        /* renamed from: b, reason: collision with root package name */
        b f50134b;

        /* renamed from: c, reason: collision with root package name */
        public long f50135c;

        /* renamed from: d, reason: collision with root package name */
        public long f50136d;

        /* renamed from: e, reason: collision with root package name */
        public long f50137e;

        /* renamed from: f, reason: collision with root package name */
        float f50138f;

        /* renamed from: g, reason: collision with root package name */
        float f50139g;

        public a() {
        }

        public float[] a() {
            b bVar = this.f50133a;
            return new float[]{bVar.f50141a, bVar.f50142b};
        }

        public float b() {
            return this.f50134b.a(this.f50133a);
        }

        public float[] c() {
            b bVar = this.f50134b;
            return new float[]{bVar.f50141a, bVar.f50142b};
        }

        public void d(b bVar, b bVar2) {
            this.f50133a = bVar;
            this.f50134b = bVar2;
            this.f50138f = bVar2.f50141a - bVar.f50141a;
            this.f50139g = bVar2.f50142b - bVar.f50142b;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b {

        /* renamed from: a, reason: collision with root package name */
        float f50141a;

        /* renamed from: b, reason: collision with root package name */
        float f50142b;

        public b(float f6, float f7) {
            this.f50141a = f6;
            this.f50142b = f7;
        }

        public float a(b bVar) {
            float abs = Math.abs(this.f50141a - bVar.f50141a);
            float abs2 = Math.abs(this.f50142b - bVar.f50142b);
            return (float) Math.sqrt((abs * abs) + (abs2 * abs2));
        }
    }

    private static final float H(long j6, long j7) {
        float f6 = j6 / j7;
        return (-1.0f) * f6 * (f6 - 2.0f);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void I(int i6, int i7, long j6) {
        this.f50123f0 = i6;
        this.f50124g0 = i7;
        this.f50125h0 = i7 - i6;
        this.f50126i0 = j6;
        if (i6 != c.f50052a) {
            this.F = i6;
        }
    }

    public void J(float[][] fArr) {
        a[] aVarArr;
        if (fArr != null) {
            int length = fArr.length;
            int i6 = 0;
            float[] fArr2 = fArr[0];
            this.W = fArr2[0];
            this.X = fArr2[1];
            float[] fArr3 = fArr[length - 1];
            this.Y = fArr3[0];
            this.Z = fArr3[1];
            if (fArr.length > 1) {
                this.f50132o0 = new a[fArr.length - 1];
                int i7 = 0;
                while (true) {
                    aVarArr = this.f50132o0;
                    if (i7 >= aVarArr.length) {
                        break;
                    }
                    aVarArr[i7] = new a();
                    a aVar = this.f50132o0[i7];
                    float[] fArr4 = fArr[i7];
                    b bVar = new b(fArr4[0], fArr4[1]);
                    i7++;
                    float[] fArr5 = fArr[i7];
                    aVar.d(bVar, new b(fArr5[0], fArr5[1]));
                }
                float f6 = 0.0f;
                for (a aVar2 : aVarArr) {
                    f6 += aVar2.b();
                }
                a[] aVarArr2 = this.f50132o0;
                int length2 = aVarArr2.length;
                a aVar3 = null;
                while (i6 < length2) {
                    a aVar4 = aVarArr2[i6];
                    long b6 = (long) ((aVar4.b() / f6) * this.f50120c0);
                    aVar4.f50135c = b6;
                    long j6 = aVar3 == null ? 0L : aVar3.f50137e;
                    aVar4.f50136d = j6;
                    aVar4.f50137e = j6 + b6;
                    i6++;
                    aVar3 = aVar4;
                }
            }
        }
    }

    public void K(float f6, float f7, float f8, float f9, long j6, long j7) {
        this.W = f6;
        this.X = f7;
        this.Y = f8;
        this.Z = f9;
        this.f50118a0 = f8 - f6;
        this.f50119b0 = f9 - f7;
        this.f50120c0 = j6;
        this.f50121d0 = j7;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float d() {
        return this.f50131n0[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float g() {
        return this.f50131n0[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] h(n nVar, long j6) {
        int i6;
        a aVar = null;
        if (!q()) {
            return null;
        }
        long b6 = j6 - b();
        long j7 = this.f50126i0;
        if (j7 > 0 && (i6 = this.f50125h0) != 0) {
            if (b6 >= j7) {
                this.F = this.f50124g0;
            } else {
                this.F = this.f50123f0 + ((int) (i6 * (b6 / j7)));
            }
        }
        float f6 = this.W;
        float f7 = this.X;
        long j8 = b6 - this.f50121d0;
        long j9 = this.f50120c0;
        if (j9 > 0 && j8 >= 0 && j8 <= j9) {
            a[] aVarArr = this.f50132o0;
            if (aVarArr != null) {
                int length = aVarArr.length;
                int i7 = 0;
                while (true) {
                    if (i7 >= length) {
                        break;
                    }
                    a aVar2 = aVarArr[i7];
                    if (j8 >= aVar2.f50136d && j8 < aVar2.f50137e) {
                        aVar = aVar2;
                        break;
                    }
                    b bVar = aVar2.f50134b;
                    float f8 = bVar.f50141a;
                    i7++;
                    f7 = bVar.f50142b;
                    f6 = f8;
                }
                if (aVar != null) {
                    float f9 = aVar.f50138f;
                    float f10 = aVar.f50139g;
                    float f11 = (b6 - aVar.f50136d) / aVar.f50135c;
                    b bVar2 = aVar.f50133a;
                    float f12 = bVar2.f50141a;
                    float f13 = bVar2.f50142b;
                    if (f9 != 0.0f) {
                        f6 = f12 + (f9 * f11);
                    }
                    if (f10 != 0.0f) {
                        f7 = f13 + (f10 * f11);
                    }
                }
            } else {
                float H = this.f50122e0 ? H(j8, j9) : j8 / j9;
                float f14 = this.f50118a0;
                if (f14 != 0.0f) {
                    f6 = this.W + (f14 * H);
                }
                float f15 = this.f50119b0;
                if (f15 != 0.0f) {
                    f7 = this.X + (f15 * H);
                }
            }
        } else if (j8 > j9) {
            f6 = this.Y;
            f7 = this.Z;
        }
        float[] fArr = this.f50131n0;
        fArr[0] = f6;
        fArr[1] = f7;
        fArr[2] = f6 + this.f50069p;
        fArr[3] = f7 + this.f50070q;
        G(!s());
        return this.f50131n0;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float i() {
        return this.f50131n0[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float l() {
        return this.f50131n0[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void y(n nVar, float f6, float f7) {
        h(nVar, this.E.f50080a);
    }

    public void L(float f6) {
    }
}
