package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a0 {

    /* renamed from: g, reason: collision with root package name */
    private static final String f15565g = "HardwareConfig";

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f15566h;

    /* renamed from: i, reason: collision with root package name */
    public static final boolean f15567i;

    /* renamed from: j, reason: collision with root package name */
    @VisibleForTesting
    static final int f15568j = 128;

    /* renamed from: k, reason: collision with root package name */
    private static final int f15569k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static final File f15570l;

    /* renamed from: m, reason: collision with root package name */
    private static final int f15571m = 50;

    /* renamed from: n, reason: collision with root package name */
    private static final int f15572n = 700;

    /* renamed from: o, reason: collision with root package name */
    private static final int f15573o = 20000;

    /* renamed from: p, reason: collision with root package name */
    public static final int f15574p = -1;

    /* renamed from: q, reason: collision with root package name */
    private static volatile a0 f15575q;

    /* renamed from: r, reason: collision with root package name */
    private static volatile int f15576r;

    /* renamed from: b, reason: collision with root package name */
    private final int f15578b;

    /* renamed from: c, reason: collision with root package name */
    private final int f15579c;

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    private int f15580d;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f15581e = true;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f15582f = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    private final boolean f15577a = h();

    private synchronized boolean f() {
        try {
            boolean z5 = true;
            int i6 = this.f15580d + 1;
            this.f15580d = i6;
            if (i6 >= 50) {
                this.f15580d = 0;
                if (f15570l.list().length >= e()) {
                    z5 = false;
                }
                this.f15581e = z5;
                if (!z5) {
                    Log.isLoggable("Downsampler", 5);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f15581e;
    }

    public boolean g(int i6, int i7, boolean z5, boolean z6) {
        if (!z5) {
            Log.isLoggable(f15565g, 2);
            return false;
        }
        if (!this.f15577a) {
            Log.isLoggable(f15565g, 2);
            return false;
        }
        if (!f15567i) {
            Log.isLoggable(f15565g, 2);
            return false;
        }
        if (b()) {
            Log.isLoggable(f15565g, 2);
            return false;
        }
        if (z6) {
            Log.isLoggable(f15565g, 2);
            return false;
        }
        int i8 = this.f15579c;
        if (i6 < i8) {
            Log.isLoggable(f15565g, 2);
            return false;
        }
        if (i7 < i8) {
            Log.isLoggable(f15565g, 2);
            return false;
        }
        if (f()) {
            return true;
        }
        Log.isLoggable(f15565g, 2);
        return false;
    }

    static {
        int i6 = Build.VERSION.SDK_INT;
        f15566h = i6 < 29;
        f15567i = i6 >= 26;
        f15570l = new File("/proc/self/fd");
        f15576r = -1;
    }

    private boolean b() {
        return f15566h && !this.f15582f.get();
    }

    public static a0 d() {
        if (f15575q == null) {
            synchronized (a0.class) {
                try {
                    if (f15575q == null) {
                        f15575q = new a0();
                    }
                } finally {
                }
            }
        }
        return f15575q;
    }

    private int e() {
        return f15576r != -1 ? f15576r : this.f15578b;
    }

    private static boolean i() {
        if (Build.VERSION.SDK_INT != 26) {
            return false;
        }
        Iterator it = Arrays.asList("SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play").iterator();
        while (it.hasNext()) {
            if (Build.MODEL.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean j() {
        if (Build.VERSION.SDK_INT != 27) {
            return false;
        }
        return Arrays.asList("LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM").contains(Build.MODEL);
    }

    @VisibleForTesting
    a0() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f15578b = 20000;
            this.f15579c = 0;
        } else {
            this.f15578b = 700;
            this.f15579c = 128;
        }
    }

    private static boolean h() {
        if (!i() && !j()) {
            return true;
        }
        return false;
    }

    public boolean a() {
        com.bumptech.glide.util.l.b();
        return !this.f15582f.get();
    }

    public void c() {
        com.bumptech.glide.util.l.b();
        this.f15582f.set(false);
    }

    @TargetApi(26)
    boolean k(int i6, int i7, BitmapFactory.Options options, boolean z5, boolean z6) {
        Bitmap.Config config;
        boolean g6 = g(i6, i7, z5, z6);
        if (g6) {
            config = Bitmap.Config.HARDWARE;
            options.inPreferredConfig = config;
            options.inMutable = false;
        }
        return g6;
    }

    public void l() {
        com.bumptech.glide.util.l.b();
        this.f15582f.set(true);
    }
}
