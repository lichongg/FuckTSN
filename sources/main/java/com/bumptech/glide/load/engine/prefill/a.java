package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.engine.cache.j;
import com.bumptech.glide.load.resource.bitmap.g;
import com.bumptech.glide.util.l;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class a implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    @VisibleForTesting
    static final String f15321i = "PreFillRunner";

    /* renamed from: k, reason: collision with root package name */
    static final long f15323k = 32;

    /* renamed from: l, reason: collision with root package name */
    static final long f15324l = 40;

    /* renamed from: m, reason: collision with root package name */
    static final int f15325m = 4;

    /* renamed from: a, reason: collision with root package name */
    private final e f15327a;

    /* renamed from: b, reason: collision with root package name */
    private final j f15328b;

    /* renamed from: c, reason: collision with root package name */
    private final c f15329c;

    /* renamed from: d, reason: collision with root package name */
    private final C0160a f15330d;

    /* renamed from: e, reason: collision with root package name */
    private final Set<d> f15331e;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f15332f;

    /* renamed from: g, reason: collision with root package name */
    private long f15333g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f15334h;

    /* renamed from: j, reason: collision with root package name */
    private static final C0160a f15322j = new C0160a();

    /* renamed from: n, reason: collision with root package name */
    static final long f15326n = TimeUnit.SECONDS.toMillis(1);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b implements com.bumptech.glide.load.c {
        @Override // com.bumptech.glide.load.c
        public void b(@NonNull MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }

        b() {
        }
    }

    public a(e eVar, j jVar, c cVar) {
        this(eVar, jVar, cVar, f15322j, new Handler(Looper.getMainLooper()));
    }

    public void b() {
        this.f15334h = true;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.prefill.a$a, reason: collision with other inner class name */
    static class C0160a {
        C0160a() {
        }

        long a() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    private long c() {
        return this.f15328b.getMaxSize() - this.f15328b.getCurrentSize();
    }

    private long d() {
        long j6 = this.f15333g;
        this.f15333g = Math.min(4 * j6, f15326n);
        return j6;
    }

    private boolean e(long j6) {
        return this.f15330d.a() - j6 >= 32;
    }

    @VisibleForTesting
    boolean a() {
        Bitmap createBitmap;
        long a6 = this.f15330d.a();
        while (!this.f15329c.b() && !e(a6)) {
            d c6 = this.f15329c.c();
            if (this.f15331e.contains(c6)) {
                createBitmap = Bitmap.createBitmap(c6.d(), c6.b(), c6.a());
            } else {
                this.f15331e.add(c6);
                createBitmap = this.f15327a.f(c6.d(), c6.b(), c6.a());
            }
            if (c() >= l.h(createBitmap)) {
                this.f15328b.d(new b(), g.c(createBitmap, this.f15327a));
            } else {
                this.f15327a.d(createBitmap);
            }
            if (Log.isLoggable(f15321i, 3)) {
                c6.d();
                c6.b();
                Objects.toString(c6.a());
            }
        }
        return (this.f15334h || this.f15329c.b()) ? false : true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a()) {
            this.f15332f.postDelayed(this, d());
        }
    }

    @VisibleForTesting
    a(e eVar, j jVar, c cVar, C0160a c0160a, Handler handler) {
        this.f15331e = new HashSet();
        this.f15333g = f15324l;
        this.f15327a = eVar;
        this.f15328b = jVar;
        this.f15329c = cVar;
        this.f15330d = c0160a;
        this.f15332f = handler;
    }
}
