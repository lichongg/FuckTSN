package com.bumptech.glide.load.resource.bitmap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class DownsampleStrategy {

    /* renamed from: a, reason: collision with root package name */
    public static final DownsampleStrategy f15554a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final DownsampleStrategy f15555b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final DownsampleStrategy f15556c = new e();

    /* renamed from: d, reason: collision with root package name */
    public static final DownsampleStrategy f15557d = new c();

    /* renamed from: e, reason: collision with root package name */
    public static final DownsampleStrategy f15558e;

    /* renamed from: f, reason: collision with root package name */
    public static final DownsampleStrategy f15559f;

    /* renamed from: g, reason: collision with root package name */
    public static final DownsampleStrategy f15560g;

    /* renamed from: h, reason: collision with root package name */
    public static final com.bumptech.glide.load.e<DownsampleStrategy> f15561h;

    /* renamed from: i, reason: collision with root package name */
    static final boolean f15562i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i6, int i7, int i8, int i9) {
            if (Math.min(i7 / i9, i6 / i8) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r1);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i6, int i7, int i8, int i9) {
            return SampleSizeRounding.QUALITY;
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i6, int i7, int i8, int i9) {
            int ceil = (int) Math.ceil(Math.max(i7 / i9, i6 / i8));
            return 1.0f / (r2 << (Math.max(1, Integer.highestOneBit(ceil)) >= ceil ? 0 : 1));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i6, int i7, int i8, int i9) {
            return SampleSizeRounding.MEMORY;
        }

        b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i6, int i7, int i8, int i9) {
            return Math.min(1.0f, DownsampleStrategy.f15556c.b(i6, i7, i8, i9));
        }

        c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i6, int i7, int i8, int i9) {
            if (b(i6, i7, i8, i9) == 1.0f) {
                return SampleSizeRounding.QUALITY;
            }
            return DownsampleStrategy.f15556c.a(i6, i7, i8, i9);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class d extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i6, int i7, int i8, int i9) {
            return Math.max(i8 / i6, i9 / i7);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i6, int i7, int i8, int i9) {
            return SampleSizeRounding.QUALITY;
        }

        d() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class e extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i6, int i7, int i8, int i9) {
            return DownsampleStrategy.f15562i ? SampleSizeRounding.QUALITY : SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i6, int i7, int i8, int i9) {
            if (DownsampleStrategy.f15562i) {
                return Math.min(i8 / i6, i9 / i7);
            }
            if (Math.max(i7 / i9, i6 / i8) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }

        e() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class f extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i6, int i7, int i8, int i9) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i6, int i7, int i8, int i9) {
            return 1.0f;
        }

        f() {
        }
    }

    public abstract SampleSizeRounding a(int i6, int i7, int i8, int i9);

    public abstract float b(int i6, int i7, int i8, int i9);

    static {
        d dVar = new d();
        f15558e = dVar;
        f15559f = new f();
        f15560g = dVar;
        f15561h = com.bumptech.glide.load.e.g("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
        f15562i = true;
    }
}
