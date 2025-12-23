package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class l {

    /* renamed from: e, reason: collision with root package name */
    private static final String f15105e = "MemorySizeCalculator";

    /* renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    static final int f15106f = 4;

    /* renamed from: g, reason: collision with root package name */
    private static final int f15107g = 2;

    /* renamed from: a, reason: collision with root package name */
    private final int f15108a;

    /* renamed from: b, reason: collision with root package name */
    private final int f15109b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f15110c;

    /* renamed from: d, reason: collision with root package name */
    private final int f15111d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: i, reason: collision with root package name */
        @VisibleForTesting
        static final int f15112i = 2;

        /* renamed from: j, reason: collision with root package name */
        static final int f15113j;

        /* renamed from: k, reason: collision with root package name */
        static final float f15114k = 0.4f;

        /* renamed from: l, reason: collision with root package name */
        static final float f15115l = 0.33f;

        /* renamed from: m, reason: collision with root package name */
        static final int f15116m = 4194304;

        /* renamed from: a, reason: collision with root package name */
        final Context f15117a;

        /* renamed from: b, reason: collision with root package name */
        ActivityManager f15118b;

        /* renamed from: c, reason: collision with root package name */
        c f15119c;

        /* renamed from: e, reason: collision with root package name */
        float f15121e;

        /* renamed from: d, reason: collision with root package name */
        float f15120d = 2.0f;

        /* renamed from: f, reason: collision with root package name */
        float f15122f = 0.4f;

        /* renamed from: g, reason: collision with root package name */
        float f15123g = 0.33f;

        /* renamed from: h, reason: collision with root package name */
        int f15124h = 4194304;

        public a d(float f6) {
            com.bumptech.glide.util.k.a(f6 >= 0.0f, "Bitmap pool screens must be greater than or equal to 0");
            this.f15121e = f6;
            return this;
        }

        public a e(float f6) {
            com.bumptech.glide.util.k.a(f6 >= 0.0f && f6 <= 1.0f, "Low memory max size multiplier must be between 0 and 1");
            this.f15123g = f6;
            return this;
        }

        public a f(float f6) {
            com.bumptech.glide.util.k.a(f6 >= 0.0f && f6 <= 1.0f, "Size multiplier must be between 0 and 1");
            this.f15122f = f6;
            return this;
        }

        public a g(float f6) {
            com.bumptech.glide.util.k.a(f6 >= 0.0f, "Memory cache screens must be greater than or equal to 0");
            this.f15120d = f6;
            return this;
        }

        static {
            f15113j = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public l a() {
            return new l(this);
        }

        @VisibleForTesting
        a b(ActivityManager activityManager) {
            this.f15118b = activityManager;
            return this;
        }

        public a c(int i6) {
            this.f15124h = i6;
            return this;
        }

        @VisibleForTesting
        a h(c cVar) {
            this.f15119c = cVar;
            return this;
        }

        public a(Context context) {
            this.f15121e = f15113j;
            this.f15117a = context;
            this.f15118b = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            this.f15119c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && l.e(this.f15118b)) {
                this.f15121e = 0.0f;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private final DisplayMetrics f15125a;

        @Override // com.bumptech.glide.load.engine.cache.l.c
        public int a() {
            return this.f15125a.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.cache.l.c
        public int b() {
            return this.f15125a.widthPixels;
        }

        b(DisplayMetrics displayMetrics) {
            this.f15125a = displayMetrics;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface c {
        int a();

        int b();
    }

    private String f(int i6) {
        return Formatter.formatFileSize(this.f15110c, i6);
    }

    public int a() {
        return this.f15111d;
    }

    public int b() {
        return this.f15108a;
    }

    public int d() {
        return this.f15109b;
    }

    l(a aVar) {
        int i6;
        this.f15110c = aVar.f15117a;
        if (e(aVar.f15118b)) {
            i6 = aVar.f15124h / 2;
        } else {
            i6 = aVar.f15124h;
        }
        this.f15111d = i6;
        int c6 = c(aVar.f15118b, aVar.f15122f, aVar.f15123g);
        float b6 = aVar.f15119c.b() * aVar.f15119c.a() * 4;
        int round = Math.round(aVar.f15121e * b6);
        int round2 = Math.round(b6 * aVar.f15120d);
        int i7 = c6 - i6;
        if (round2 + round <= i7) {
            this.f15109b = round2;
            this.f15108a = round;
        } else {
            float f6 = i7;
            float f7 = aVar.f15121e;
            float f8 = aVar.f15120d;
            float f9 = f6 / (f7 + f8);
            this.f15109b = Math.round(f8 * f9);
            this.f15108a = Math.round(f9 * aVar.f15121e);
        }
        if (Log.isLoggable(f15105e, 3)) {
            f(this.f15109b);
            f(this.f15108a);
            f(i6);
            f(c6);
            aVar.f15118b.getMemoryClass();
            e(aVar.f15118b);
        }
    }

    private static int c(ActivityManager activityManager, float f6, float f7) {
        float memoryClass = activityManager.getMemoryClass() * 1048576;
        if (e(activityManager)) {
            f6 = f7;
        }
        return Math.round(memoryClass * f6);
    }

    @TargetApi(19)
    static boolean e(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
