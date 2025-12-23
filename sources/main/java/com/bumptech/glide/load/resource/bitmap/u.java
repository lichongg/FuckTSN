package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.b0;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class u {

    /* renamed from: f, reason: collision with root package name */
    static final String f15659f = "Downsampler";

    /* renamed from: g, reason: collision with root package name */
    public static final com.bumptech.glide.load.e<DecodeFormat> f15660g = com.bumptech.glide.load.e.g("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);

    /* renamed from: h, reason: collision with root package name */
    public static final com.bumptech.glide.load.e<PreferredColorSpace> f15661h = com.bumptech.glide.load.e.g("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);

    /* renamed from: i, reason: collision with root package name */
    @Deprecated
    public static final com.bumptech.glide.load.e<DownsampleStrategy> f15662i = DownsampleStrategy.f15561h;

    /* renamed from: j, reason: collision with root package name */
    public static final com.bumptech.glide.load.e<Boolean> f15663j;

    /* renamed from: k, reason: collision with root package name */
    public static final com.bumptech.glide.load.e<Boolean> f15664k;

    /* renamed from: l, reason: collision with root package name */
    private static final String f15665l = "image/vnd.wap.wbmp";

    /* renamed from: m, reason: collision with root package name */
    private static final String f15666m = "image/x-ico";

    /* renamed from: n, reason: collision with root package name */
    private static final Set<String> f15667n;

    /* renamed from: o, reason: collision with root package name */
    private static final b f15668o;

    /* renamed from: p, reason: collision with root package name */
    private static final Set<ImageHeaderParser.ImageType> f15669p;

    /* renamed from: q, reason: collision with root package name */
    private static final Queue<BitmapFactory.Options> f15670q;

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f15671a;

    /* renamed from: b, reason: collision with root package name */
    private final DisplayMetrics f15672b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f15673c;

    /* renamed from: d, reason: collision with root package name */
    private final List<ImageHeaderParser> f15674d;

    /* renamed from: e, reason: collision with root package name */
    private final a0 f15675e = a0.d();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a();

        void b(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) throws IOException;
    }

    private static void c(ImageHeaderParser.ImageType imageType, b0 b0Var, b bVar, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, DownsampleStrategy downsampleStrategy, int i6, int i7, int i8, int i9, int i10, BitmapFactory.Options options) throws IOException {
        int i11;
        int i12;
        int i13;
        int floor;
        double floor2;
        int i14;
        if (i7 <= 0 || i8 <= 0) {
            if (Log.isLoggable(f15659f, 3)) {
                Objects.toString(imageType);
                return;
            }
            return;
        }
        if (r(i6)) {
            i12 = i7;
            i11 = i8;
        } else {
            i11 = i7;
            i12 = i8;
        }
        float b6 = downsampleStrategy.b(i11, i12, i9, i10);
        if (b6 <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + b6 + " from: " + downsampleStrategy + ", source: [" + i7 + "x" + i8 + "], target: [" + i9 + "x" + i10 + "]");
        }
        DownsampleStrategy.SampleSizeRounding a6 = downsampleStrategy.a(i11, i12, i9, i10);
        if (a6 == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f6 = i11;
        float f7 = i12;
        int x5 = i11 / x(b6 * f6);
        int x6 = i12 / x(b6 * f7);
        DownsampleStrategy.SampleSizeRounding sampleSizeRounding = DownsampleStrategy.SampleSizeRounding.MEMORY;
        int max = a6 == sampleSizeRounding ? Math.max(x5, x6) : Math.min(x5, x6);
        int i15 = Build.VERSION.SDK_INT;
        if (i15 > 23 || !f15667n.contains(options.outMimeType)) {
            int max2 = Math.max(1, Integer.highestOneBit(max));
            i13 = (a6 != sampleSizeRounding || ((float) max2) >= 1.0f / b6) ? max2 : max2 << 1;
        } else {
            i13 = 1;
        }
        options.inSampleSize = i13;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float min = Math.min(i13, 8);
            floor = (int) Math.ceil(f6 / min);
            i14 = (int) Math.ceil(f7 / min);
            int i16 = i13 / 8;
            if (i16 > 0) {
                floor /= i16;
                i14 /= i16;
            }
        } else {
            if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                float f8 = i13;
                floor = (int) Math.floor(f6 / f8);
                floor2 = Math.floor(f7 / f8);
            } else if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                if (i15 >= 24) {
                    float f9 = i13;
                    floor = Math.round(f6 / f9);
                    i14 = Math.round(f7 / f9);
                } else {
                    float f10 = i13;
                    floor = (int) Math.floor(f6 / f10);
                    floor2 = Math.floor(f7 / f10);
                }
            } else if (i11 % i13 == 0 && i12 % i13 == 0) {
                floor = i11 / i13;
                i14 = i12 / i13;
            } else {
                int[] m6 = m(b0Var, options, bVar, eVar);
                floor = m6[0];
                i14 = m6[1];
            }
            i14 = (int) floor2;
        }
        double b7 = downsampleStrategy.b(floor, i14, i9, i10);
        options.inTargetDensity = a(b7);
        options.inDensity = l(b7);
        if (s(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        Log.isLoggable(f15659f, 2);
    }

    private static int[] m(b0 b0Var, BitmapFactory.Options options, b bVar, com.bumptech.glide.load.engine.bitmap_recycle.e eVar) throws IOException {
        options.inJustDecodeBounds = true;
        i(b0Var, options, bVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private boolean z(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.u.b
        public void a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.u.b
        public void b(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) {
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        f15663j = com.bumptech.glide.load.e.g("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f15664k = com.bumptech.glide.load.e.g("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f15667n = Collections.unmodifiableSet(new HashSet(Arrays.asList(f15665l, f15666m)));
        f15668o = new a();
        f15669p = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f15670q = com.bumptech.glide.util.l.f(0);
    }

    private void b(b0 b0Var, DecodeFormat decodeFormat, boolean z5, boolean z6, BitmapFactory.Options options, int i6, int i7) {
        boolean z7;
        if (this.f15675e.k(i6, i7, options, z5, z6)) {
            return;
        }
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            z7 = b0Var.d().hasAlpha();
        } catch (IOException unused) {
            if (Log.isLoggable(f15659f, 3)) {
                Objects.toString(decodeFormat);
            }
            z7 = false;
        }
        Bitmap.Config config = z7 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    private com.bumptech.glide.load.engine.u<Bitmap> e(b0 b0Var, int i6, int i7, com.bumptech.glide.load.f fVar, b bVar) throws IOException {
        byte[] bArr = (byte[]) this.f15673c.c(65536, byte[].class);
        BitmapFactory.Options k6 = k();
        k6.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) fVar.c(f15660g);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) fVar.c(f15661h);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) fVar.c(DownsampleStrategy.f15561h);
        boolean booleanValue = ((Boolean) fVar.c(f15663j)).booleanValue();
        com.bumptech.glide.load.e<Boolean> eVar = f15664k;
        try {
            return g.c(h(b0Var, k6, downsampleStrategy, decodeFormat, preferredColorSpace, fVar.c(eVar) != null && ((Boolean) fVar.c(eVar)).booleanValue(), i6, i7, booleanValue, bVar), this.f15671a);
        } finally {
            v(k6);
            this.f15673c.put(bArr);
        }
    }

    private Bitmap h(b0 b0Var, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z5, int i6, int i7, boolean z6, b bVar) throws IOException {
        int i8;
        String str;
        ColorSpace.Named named;
        ColorSpace colorSpace;
        ColorSpace.Named named2;
        ColorSpace colorSpace2;
        ColorSpace colorSpace3;
        ColorSpace colorSpace4;
        boolean isWideGamut;
        int round;
        long b6 = com.bumptech.glide.util.g.b();
        int[] m6 = m(b0Var, options, bVar, this.f15671a);
        int i9 = m6[0];
        int i10 = m6[1];
        String str2 = options.outMimeType;
        boolean z7 = (i9 == -1 || i10 == -1) ? false : z5;
        int b7 = b0Var.b();
        int j6 = k0.j(b7);
        boolean m7 = k0.m(b7);
        int i11 = i6;
        if (i11 != Integer.MIN_VALUE) {
            i8 = i7;
        } else if (r(j6)) {
            i8 = i7;
            i11 = i10;
        } else {
            i8 = i7;
            i11 = i9;
        }
        if (i8 == Integer.MIN_VALUE) {
            i8 = r(j6) ? i9 : i10;
        }
        ImageHeaderParser.ImageType d6 = b0Var.d();
        c(d6, b0Var, bVar, this.f15671a, downsampleStrategy, j6, i9, i10, i11, i8, options);
        int i12 = i11;
        int i13 = i8;
        b(b0Var, decodeFormat, z7, m7, options, i12, i13);
        int i14 = Build.VERSION.SDK_INT;
        if (z(d6)) {
            if (i9 < 0 || i10 < 0 || !z6) {
                float f6 = s(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                float f7 = options.inSampleSize;
                int ceil = (int) Math.ceil(i9 / f7);
                int ceil2 = (int) Math.ceil(i10 / f7);
                round = Math.round(ceil * f6);
                int round2 = Math.round(ceil2 * f6);
                str = f15659f;
                Log.isLoggable(str, 2);
                i13 = round2;
            } else {
                round = i12;
                str = f15659f;
            }
            if (round > 0 && i13 > 0) {
                y(options, this.f15671a, round, i13);
            }
        } else {
            str = f15659f;
        }
        if (i14 >= 28) {
            if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3) {
                colorSpace3 = options.outColorSpace;
                if (colorSpace3 != null) {
                    colorSpace4 = options.outColorSpace;
                    isWideGamut = colorSpace4.isWideGamut();
                    if (isWideGamut) {
                        named2 = ColorSpace.Named.DISPLAY_P3;
                        colorSpace2 = ColorSpace.get(named2);
                        options.inPreferredColorSpace = colorSpace2;
                    }
                }
            }
            named2 = ColorSpace.Named.SRGB;
            colorSpace2 = ColorSpace.get(named2);
            options.inPreferredColorSpace = colorSpace2;
        } else if (i14 >= 26) {
            named = ColorSpace.Named.SRGB;
            colorSpace = ColorSpace.get(named);
            options.inPreferredColorSpace = colorSpace;
        }
        Bitmap i15 = i(b0Var, options, bVar, this.f15671a);
        bVar.b(this.f15671a, i15);
        if (Log.isLoggable(str, 2)) {
            t(i9, i10, str2, options, i15, i6, i7, b6);
        }
        if (i15 == null) {
            return null;
        }
        i15.setDensity(this.f15672b.densityDpi);
        Bitmap o5 = k0.o(this.f15671a, i15, b7);
        if (!i15.equals(o5)) {
            this.f15671a.d(i15);
        }
        return o5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap i(com.bumptech.glide.load.resource.bitmap.b0 r4, android.graphics.BitmapFactory.Options r5, com.bumptech.glide.load.resource.bitmap.u.b r6, com.bumptech.glide.load.engine.bitmap_recycle.e r7) throws java.io.IOException {
        /*
            boolean r0 = r5.inJustDecodeBounds
            if (r0 != 0) goto La
            r6.a()
            r4.a()
        La:
            int r0 = r5.outWidth
            int r1 = r5.outHeight
            java.lang.String r2 = r5.outMimeType
            java.util.concurrent.locks.Lock r3 = com.bumptech.glide.load.resource.bitmap.k0.i()
            r3.lock()
            android.graphics.Bitmap r4 = r4.c(r5)     // Catch: java.lang.IllegalArgumentException -> L23 java.lang.Throwable -> L3f
        L1b:
            java.util.concurrent.locks.Lock r5 = com.bumptech.glide.load.resource.bitmap.k0.i()
            r5.unlock()
            return r4
        L23:
            r3 = move-exception
            java.io.IOException r0 = u(r3, r0, r1, r2, r5)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r1 = "Downsampler"
            r2 = 3
            android.util.Log.isLoggable(r1, r2)     // Catch: java.lang.Throwable -> L3f
            android.graphics.Bitmap r1 = r5.inBitmap     // Catch: java.lang.Throwable -> L3f
            if (r1 == 0) goto L3e
            r7.d(r1)     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L3f
            r1 = 0
            r5.inBitmap = r1     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L3f
            android.graphics.Bitmap r4 = i(r4, r5, r6, r7)     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L3f
            goto L1b
        L3d:
            throw r0     // Catch: java.lang.Throwable -> L3f
        L3e:
            throw r0     // Catch: java.lang.Throwable -> L3f
        L3f:
            r4 = move-exception
            java.util.concurrent.locks.Lock r5 = com.bumptech.glide.load.resource.bitmap.k0.i()
            r5.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.u.i(com.bumptech.glide.load.resource.bitmap.b0, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.u$b, com.bumptech.glide.load.engine.bitmap_recycle.e):android.graphics.Bitmap");
    }

    @Nullable
    @TargetApi(19)
    private static String j(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options poll;
        synchronized (u.class) {
            Queue<BitmapFactory.Options> queue = f15670q;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                w(poll);
            }
        }
        return poll;
    }

    private static int l(double d6) {
        if (d6 > 1.0d) {
            d6 = 1.0d / d6;
        }
        return (int) Math.round(d6 * 2.147483647E9d);
    }

    private static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    private static boolean r(int i6) {
        return i6 == 90 || i6 == 270;
    }

    private static boolean s(BitmapFactory.Options options) {
        int i6;
        int i7 = options.inTargetDensity;
        return i7 > 0 && (i6 = options.inDensity) > 0 && i7 != i6;
    }

    private static IOException u(IllegalArgumentException illegalArgumentException, int i6, int i7, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i6 + ", outHeight: " + i7 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    private static int x(double d6) {
        return (int) (d6 + 0.5d);
    }

    @TargetApi(26)
    private static void y(BitmapFactory.Options options, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, int i6, int i7) {
        Bitmap.Config config;
        Bitmap.Config config2;
        if (Build.VERSION.SDK_INT >= 26) {
            Bitmap.Config config3 = options.inPreferredConfig;
            config2 = Bitmap.Config.HARDWARE;
            if (config3 == config2) {
                return;
            } else {
                config = options.outConfig;
            }
        } else {
            config = null;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = eVar.f(i6, i7, config);
    }

    @RequiresApi(21)
    public com.bumptech.glide.load.engine.u<Bitmap> d(ParcelFileDescriptor parcelFileDescriptor, int i6, int i7, com.bumptech.glide.load.f fVar) throws IOException {
        return e(new b0.b(parcelFileDescriptor, this.f15674d, this.f15673c), i6, i7, fVar, f15668o);
    }

    public com.bumptech.glide.load.engine.u<Bitmap> f(InputStream inputStream, int i6, int i7, com.bumptech.glide.load.f fVar) throws IOException {
        return g(inputStream, i6, i7, fVar, f15668o);
    }

    public com.bumptech.glide.load.engine.u<Bitmap> g(InputStream inputStream, int i6, int i7, com.bumptech.glide.load.f fVar, b bVar) throws IOException {
        return e(new b0.a(inputStream, this.f15674d, this.f15673c), i6, i7, fVar, bVar);
    }

    public u(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f15674d = list;
        this.f15672b = (DisplayMetrics) com.bumptech.glide.util.k.d(displayMetrics);
        this.f15671a = (com.bumptech.glide.load.engine.bitmap_recycle.e) com.bumptech.glide.util.k.d(eVar);
        this.f15673c = (com.bumptech.glide.load.engine.bitmap_recycle.b) com.bumptech.glide.util.k.d(bVar);
    }

    private static int a(double d6) {
        return x((d6 / (r1 / r0)) * x(l(d6) * d6));
    }

    private static void t(int i6, int i7, String str, BitmapFactory.Options options, Bitmap bitmap, int i8, int i9, long j6) {
        j(bitmap);
        n(options);
        int i10 = options.inSampleSize;
        Thread.currentThread().getName();
        com.bumptech.glide.util.g.a(j6);
    }

    private static void v(BitmapFactory.Options options) {
        w(options);
        Queue<BitmapFactory.Options> queue = f15670q;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }
}
