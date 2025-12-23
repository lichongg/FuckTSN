package com.jmolsmobile.landscapevideocapture.configuration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class PredefinedCaptureConfigurations {
    public static final int A = 28000000;
    public static final int B = 40000000;
    public static final int C = 2160;
    public static final int D = 3840;
    public static final int E = 30;
    public static final int F = 20;
    public static final int G = 24;
    public static final int H = 60;

    /* renamed from: a, reason: collision with root package name */
    public static final int f35634a = 300000;

    /* renamed from: b, reason: collision with root package name */
    public static final int f35635b = 700000;

    /* renamed from: c, reason: collision with root package name */
    public static final int f35636c = 1000000;

    /* renamed from: d, reason: collision with root package name */
    public static final int f35637d = 360;

    /* renamed from: e, reason: collision with root package name */
    public static final int f35638e = 640;

    /* renamed from: f, reason: collision with root package name */
    public static final int f35639f = 750000;

    /* renamed from: g, reason: collision with root package name */
    public static final int f35640g = 1750000;

    /* renamed from: h, reason: collision with root package name */
    public static final int f35641h = 2500000;

    /* renamed from: i, reason: collision with root package name */
    public static final int f35642i = 480;

    /* renamed from: j, reason: collision with root package name */
    public static final int f35643j = 640;

    /* renamed from: k, reason: collision with root package name */
    public static final int f35644k = 1500000;

    /* renamed from: l, reason: collision with root package name */
    public static final int f35645l = 3500000;

    /* renamed from: m, reason: collision with root package name */
    public static final int f35646m = 5000000;

    /* renamed from: n, reason: collision with root package name */
    public static final int f35647n = 720;

    /* renamed from: o, reason: collision with root package name */
    public static final int f35648o = 1280;

    /* renamed from: p, reason: collision with root package name */
    public static final int f35649p = 2400000;

    /* renamed from: q, reason: collision with root package name */
    public static final int f35650q = 5600000;

    /* renamed from: r, reason: collision with root package name */
    public static final int f35651r = 8000000;

    /* renamed from: s, reason: collision with root package name */
    public static final int f35652s = 1080;

    /* renamed from: t, reason: collision with root package name */
    public static final int f35653t = 1920;

    /* renamed from: u, reason: collision with root package name */
    public static final int f35654u = 3000000;

    /* renamed from: v, reason: collision with root package name */
    public static final int f35655v = 7000000;

    /* renamed from: w, reason: collision with root package name */
    public static final int f35656w = 10000000;

    /* renamed from: x, reason: collision with root package name */
    public static final int f35657x = 1440;

    /* renamed from: y, reason: collision with root package name */
    public static final int f35658y = 2560;

    /* renamed from: z, reason: collision with root package name */
    public static final int f35659z = 12000000;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum CaptureQuality {
        LOW,
        MEDIUM,
        HIGH
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum CaptureResolution {
        RES_360P(640, 360, 1000000, PredefinedCaptureConfigurations.f35635b, PredefinedCaptureConfigurations.f35634a),
        RES_480P(640, 480, PredefinedCaptureConfigurations.f35641h, PredefinedCaptureConfigurations.f35640g, PredefinedCaptureConfigurations.f35639f),
        RES_720P(PredefinedCaptureConfigurations.f35648o, PredefinedCaptureConfigurations.f35647n, 5000000, PredefinedCaptureConfigurations.f35645l, PredefinedCaptureConfigurations.f35644k),
        RES_1080P(PredefinedCaptureConfigurations.f35653t, PredefinedCaptureConfigurations.f35652s, 8000000, PredefinedCaptureConfigurations.f35650q, PredefinedCaptureConfigurations.f35649p),
        RES_1440P(PredefinedCaptureConfigurations.f35658y, PredefinedCaptureConfigurations.f35657x, 10000000, 7000000, PredefinedCaptureConfigurations.f35654u),
        RES_2160P(PredefinedCaptureConfigurations.D, PredefinedCaptureConfigurations.C, PredefinedCaptureConfigurations.B, PredefinedCaptureConfigurations.A, PredefinedCaptureConfigurations.f35659z);

        public int height;
        private final int highBitrate;
        private final int lowBitrate;
        private final int medBitrate;
        public int width;

        public int getBitrate(CaptureQuality captureQuality) {
            int i6 = this.highBitrate;
            int i7 = a.f35660a[captureQuality.ordinal()];
            return i7 != 1 ? i7 != 2 ? i7 != 3 ? i6 : this.lowBitrate : this.medBitrate : this.highBitrate;
        }

        CaptureResolution(int i6, int i7, int i8, int i9, int i10) {
            this.width = i6;
            this.height = i7;
            this.highBitrate = i8;
            this.medBitrate = i9;
            this.lowBitrate = i10;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35660a;

        static {
            int[] iArr = new int[CaptureQuality.values().length];
            f35660a = iArr;
            try {
                iArr[CaptureQuality.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35660a[CaptureQuality.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35660a[CaptureQuality.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
