package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private static final int f16342a = 31;

    /* renamed from: b, reason: collision with root package name */
    private static final int f16343b = 17;

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f16344c = "0123456789abcdef".toCharArray();

    /* renamed from: d, reason: collision with root package name */
    private static final char[] f16345d = new char[64];

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private static volatile Handler f16346e;

    @NonNull
    private static String e(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i6 = 0; i6 < bArr.length; i6++) {
            byte b6 = bArr[i6];
            int i7 = i6 * 2;
            char[] cArr2 = f16344c;
            cArr[i7] = cArr2[(b6 & 255) >>> 4];
            cArr[i7 + 1] = cArr2[b6 & 15];
        }
        return new String(cArr);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16347a;

        static {
            Bitmap.Config config;
            int[] iArr = new int[Bitmap.Config.values().length];
            f16347a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16347a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16347a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr2 = f16347a;
                config = Bitmap.Config.RGBA_F16;
                iArr2[config.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16347a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static boolean c(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj instanceof com.bumptech.glide.load.model.l ? ((com.bumptech.glide.load.model.l) obj).a(obj2) : obj.equals(obj2);
    }

    public static boolean d(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @NonNull
    public static <T> Queue<T> f(int i6) {
        return new ArrayDeque(i6);
    }

    public static int g(int i6, int i7, @Nullable Bitmap.Config config) {
        return i6 * i7 * i(config);
    }

    private static int i(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i6 = a.f16347a[config.ordinal()];
        int i7 = 1;
        if (i6 != 1) {
            i7 = 2;
            if (i6 != 2 && i6 != 3) {
                return i6 != 4 ? 4 : 8;
            }
        }
        return i7;
    }

    @NonNull
    public static <T> List<T> k(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t5 : collection) {
            if (t5 != null) {
                arrayList.add(t5);
            }
        }
        return arrayList;
    }

    private static Handler l() {
        if (f16346e == null) {
            synchronized (l.class) {
                try {
                    if (f16346e == null) {
                        f16346e = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return f16346e;
    }

    public static int m(float f6) {
        return n(f6, 17);
    }

    public static int o(int i6) {
        return p(i6, 17);
    }

    public static int p(int i6, int i7) {
        return (i7 * 31) + i6;
    }

    public static int q(@Nullable Object obj, int i6) {
        return p(obj == null ? 0 : obj.hashCode(), i6);
    }

    public static int r(boolean z5) {
        return s(z5, 17);
    }

    private static boolean v(int i6) {
        return i6 > 0 || i6 == Integer.MIN_VALUE;
    }

    @NonNull
    public static String z(@NonNull byte[] bArr) {
        String e6;
        char[] cArr = f16345d;
        synchronized (cArr) {
            e6 = e(bArr, cArr);
        }
        return e6;
    }

    private l() {
    }

    public static void a() {
        if (t()) {
        } else {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static void b() {
        if (u()) {
        } else {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    @TargetApi(19)
    public static int h(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    @Deprecated
    public static int j(@NonNull Bitmap bitmap) {
        return h(bitmap);
    }

    public static int n(float f6, int i6) {
        return p(Float.floatToIntBits(f6), i6);
    }

    public static int s(boolean z5, int i6) {
        return p(z5 ? 1 : 0, i6);
    }

    public static boolean t() {
        return !u();
    }

    public static boolean u() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    public static boolean w(int i6, int i7) {
        if (v(i6) && v(i7)) {
            return true;
        }
        return false;
    }

    public static void x(Runnable runnable) {
        l().post(runnable);
    }

    public static void y(Runnable runnable) {
        l().removeCallbacks(runnable);
    }
}
