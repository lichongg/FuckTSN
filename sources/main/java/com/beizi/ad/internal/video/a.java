package com.beizi.ad.internal.video;

import android.graphics.Matrix;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private c f12388a;

    /* renamed from: b, reason: collision with root package name */
    private c f12389b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.video.a$a, reason: collision with other inner class name */
    public enum EnumC0114a {
        LEFT_TOP,
        LEFT_CENTER,
        LEFT_BOTTOM,
        CENTER_TOP,
        CENTER,
        CENTER_BOTTOM,
        RIGHT_TOP,
        RIGHT_CENTER,
        RIGHT_BOTTOM
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum b {
        NONE,
        FIT_XY,
        FIT_START,
        FIT_CENTER,
        FIT_END,
        LEFT_TOP,
        LEFT_CENTER,
        LEFT_BOTTOM,
        CENTER_TOP,
        CENTER,
        CENTER_BOTTOM,
        RIGHT_TOP,
        RIGHT_CENTER,
        RIGHT_BOTTOM,
        LEFT_TOP_CROP,
        LEFT_CENTER_CROP,
        LEFT_BOTTOM_CROP,
        CENTER_TOP_CROP,
        CENTER_CROP,
        CENTER_BOTTOM_CROP,
        RIGHT_TOP_CROP,
        RIGHT_CENTER_CROP,
        RIGHT_BOTTOM_CROP,
        START_INSIDE,
        CENTER_INSIDE,
        END_INSIDE
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private int f12428a;

        /* renamed from: b, reason: collision with root package name */
        private int f12429b;

        public int a() {
            return this.f12428a;
        }

        public int b() {
            return this.f12429b;
        }

        public c(int i6, int i7) {
            this.f12428a = i6;
            this.f12429b = i7;
        }
    }

    private Matrix b() {
        return a(1.0f, 1.0f, EnumC0114a.LEFT_TOP);
    }

    private Matrix c() {
        return a(EnumC0114a.LEFT_TOP);
    }

    public Matrix a(b bVar) {
        switch (AnonymousClass1.f12390a[bVar.ordinal()]) {
            case 1:
                return a();
            case 2:
                return b();
            case 3:
                return d();
            case 4:
                return c();
            case 5:
                return e();
            case 6:
                return b(EnumC0114a.LEFT_TOP);
            case 7:
                return b(EnumC0114a.LEFT_CENTER);
            case 8:
                return b(EnumC0114a.LEFT_BOTTOM);
            case 9:
                return b(EnumC0114a.CENTER_TOP);
            case 10:
                return b(EnumC0114a.CENTER);
            case 11:
                return b(EnumC0114a.CENTER_BOTTOM);
            case 12:
                return b(EnumC0114a.RIGHT_TOP);
            case 13:
                return b(EnumC0114a.RIGHT_CENTER);
            case 14:
                return b(EnumC0114a.RIGHT_BOTTOM);
            case 15:
                return c(EnumC0114a.LEFT_TOP);
            case 16:
                return c(EnumC0114a.LEFT_CENTER);
            case 17:
                return c(EnumC0114a.LEFT_BOTTOM);
            case 18:
                return c(EnumC0114a.CENTER_TOP);
            case 19:
                return c(EnumC0114a.CENTER);
            case 20:
                return c(EnumC0114a.CENTER_BOTTOM);
            case 21:
                return c(EnumC0114a.RIGHT_TOP);
            case 22:
                return c(EnumC0114a.RIGHT_CENTER);
            case 23:
                return c(EnumC0114a.RIGHT_BOTTOM);
            case 24:
                return f();
            case 25:
                return g();
            case 26:
                return h();
            default:
                return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.video.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12390a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f12391b;

        static {
            int[] iArr = new int[EnumC0114a.values().length];
            f12391b = iArr;
            try {
                iArr[EnumC0114a.LEFT_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12391b[EnumC0114a.LEFT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12391b[EnumC0114a.LEFT_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12391b[EnumC0114a.CENTER_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12391b[EnumC0114a.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12391b[EnumC0114a.CENTER_BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12391b[EnumC0114a.RIGHT_TOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12391b[EnumC0114a.RIGHT_CENTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12391b[EnumC0114a.RIGHT_BOTTOM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[b.values().length];
            f12390a = iArr2;
            try {
                iArr2[b.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f12390a[b.FIT_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f12390a[b.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f12390a[b.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f12390a[b.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f12390a[b.LEFT_TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f12390a[b.LEFT_CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f12390a[b.LEFT_BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f12390a[b.CENTER_TOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f12390a[b.CENTER.ordinal()] = 10;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f12390a[b.CENTER_BOTTOM.ordinal()] = 11;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f12390a[b.RIGHT_TOP.ordinal()] = 12;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f12390a[b.RIGHT_CENTER.ordinal()] = 13;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f12390a[b.RIGHT_BOTTOM.ordinal()] = 14;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f12390a[b.LEFT_TOP_CROP.ordinal()] = 15;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f12390a[b.LEFT_CENTER_CROP.ordinal()] = 16;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f12390a[b.LEFT_BOTTOM_CROP.ordinal()] = 17;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f12390a[b.CENTER_TOP_CROP.ordinal()] = 18;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f12390a[b.CENTER_CROP.ordinal()] = 19;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f12390a[b.CENTER_BOTTOM_CROP.ordinal()] = 20;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f12390a[b.RIGHT_TOP_CROP.ordinal()] = 21;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f12390a[b.RIGHT_CENTER_CROP.ordinal()] = 22;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f12390a[b.RIGHT_BOTTOM_CROP.ordinal()] = 23;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f12390a[b.START_INSIDE.ordinal()] = 24;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f12390a[b.CENTER_INSIDE.ordinal()] = 25;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f12390a[b.END_INSIDE.ordinal()] = 26;
            } catch (NoSuchFieldError unused35) {
            }
        }
    }

    private Matrix b(EnumC0114a enumC0114a) {
        return a(this.f12389b.a() / this.f12388a.a(), this.f12389b.b() / this.f12388a.b(), enumC0114a);
    }

    private Matrix c(EnumC0114a enumC0114a) {
        float a6 = this.f12388a.a() / this.f12389b.a();
        float b6 = this.f12388a.b() / this.f12389b.b();
        float max = Math.max(a6, b6);
        return a(max / a6, max / b6, enumC0114a);
    }

    private Matrix d() {
        return a(EnumC0114a.CENTER);
    }

    private Matrix e() {
        return a(EnumC0114a.RIGHT_BOTTOM);
    }

    private Matrix f() {
        return (this.f12389b.b() > this.f12388a.a() || this.f12389b.b() > this.f12388a.b()) ? c() : b(EnumC0114a.LEFT_TOP);
    }

    private Matrix g() {
        return (this.f12389b.b() > this.f12388a.a() || this.f12389b.b() > this.f12388a.b()) ? d() : b(EnumC0114a.CENTER);
    }

    private Matrix h() {
        return (this.f12389b.b() > this.f12388a.a() || this.f12389b.b() > this.f12388a.b()) ? e() : b(EnumC0114a.RIGHT_BOTTOM);
    }

    public a(c cVar, c cVar2) {
        this.f12388a = cVar;
        this.f12389b = cVar2;
    }

    private Matrix a(float f6, float f7, float f8, float f9) {
        Matrix matrix = new Matrix();
        matrix.setScale(f6, f7, f8, f9);
        return matrix;
    }

    private Matrix a(float f6, float f7, EnumC0114a enumC0114a) {
        switch (AnonymousClass1.f12391b[enumC0114a.ordinal()]) {
            case 1:
                return a(f6, f7, 0.0f, 0.0f);
            case 2:
                return a(f6, f7, 0.0f, this.f12388a.b() / 2.0f);
            case 3:
                return a(f6, f7, 0.0f, this.f12388a.b());
            case 4:
                return a(f6, f7, this.f12388a.a() / 2.0f, 0.0f);
            case 5:
                return a(f6, f7, this.f12388a.a() / 2.0f, this.f12388a.b() / 2.0f);
            case 6:
                return a(f6, f7, this.f12388a.a() / 2.0f, this.f12388a.b());
            case 7:
                return a(f6, f7, this.f12388a.a(), 0.0f);
            case 8:
                return a(f6, f7, this.f12388a.a(), this.f12388a.b() / 2.0f);
            case 9:
                return a(f6, f7, this.f12388a.a(), this.f12388a.b());
            default:
                throw new IllegalArgumentException("Illegal PivotPoint");
        }
    }

    private Matrix a() {
        return a(this.f12389b.a() / this.f12388a.a(), this.f12389b.b() / this.f12388a.b(), EnumC0114a.LEFT_TOP);
    }

    private Matrix a(EnumC0114a enumC0114a) {
        float a6 = this.f12388a.a() / this.f12389b.a();
        float b6 = this.f12388a.b() / this.f12389b.b();
        float min = Math.min(a6, b6);
        return a(min / a6, min / b6, enumC0114a);
    }
}
