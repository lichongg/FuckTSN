package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class l implements e {

    /* renamed from: k, reason: collision with root package name */
    private static final String f15034k = "LruBitmapPool";

    /* renamed from: l, reason: collision with root package name */
    private static final Bitmap.Config f15035l = Bitmap.Config.ARGB_8888;

    /* renamed from: a, reason: collision with root package name */
    private final m f15036a;

    /* renamed from: b, reason: collision with root package name */
    private final Set<Bitmap.Config> f15037b;

    /* renamed from: c, reason: collision with root package name */
    private final long f15038c;

    /* renamed from: d, reason: collision with root package name */
    private final a f15039d;

    /* renamed from: e, reason: collision with root package name */
    private long f15040e;

    /* renamed from: f, reason: collision with root package name */
    private long f15041f;

    /* renamed from: g, reason: collision with root package name */
    private int f15042g;

    /* renamed from: h, reason: collision with root package name */
    private int f15043h;

    /* renamed from: i, reason: collision with root package name */
    private int f15044i;

    /* renamed from: j, reason: collision with root package name */
    private int f15045j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c implements a {

        /* renamed from: a, reason: collision with root package name */
        private final Set<Bitmap> f15046a = Collections.synchronizedSet(new HashSet());

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.l.a
        public void a(Bitmap bitmap) {
            if (!this.f15046a.contains(bitmap)) {
                this.f15046a.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.l.a
        public void b(Bitmap bitmap) {
            if (!this.f15046a.contains(bitmap)) {
                throw new IllegalStateException("Cannot remove bitmap not in tracker");
            }
            this.f15046a.remove(bitmap);
        }

        private c() {
        }
    }

    l(long j6, m mVar, Set<Bitmap.Config> set) {
        this.f15038c = j6;
        this.f15040e = j6;
        this.f15036a = mVar;
        this.f15037b = set;
        this.f15039d = new b();
    }

    @Nullable
    private synchronized Bitmap p(int i6, int i7, @Nullable Bitmap.Config config) {
        Bitmap e6;
        try {
            g(config);
            e6 = this.f15036a.e(i6, i7, config != null ? config : f15035l);
            if (e6 == null) {
                if (Log.isLoggable(f15034k, 3)) {
                    this.f15036a.a(i6, i7, config);
                }
                this.f15043h++;
            } else {
                this.f15042g++;
                this.f15041f -= this.f15036a.b(e6);
                this.f15039d.b(e6);
                t(e6);
            }
            if (Log.isLoggable(f15034k, 2)) {
                this.f15036a.a(i6, i7, config);
            }
            i();
        } catch (Throwable th) {
            throw th;
        }
        return e6;
    }

    @TargetApi(19)
    private static void r(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    private static void t(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        r(bitmap);
    }

    private synchronized void u(long j6) {
        while (this.f15041f > j6) {
            try {
                Bitmap removeLast = this.f15036a.removeLast();
                if (removeLast == null) {
                    if (Log.isLoggable(f15034k, 5)) {
                        j();
                    }
                    this.f15041f = 0L;
                    return;
                } else {
                    this.f15039d.b(removeLast);
                    this.f15041f -= this.f15036a.b(removeLast);
                    this.f15045j++;
                    if (Log.isLoggable(f15034k, 3)) {
                        this.f15036a.c(removeLast);
                    }
                    i();
                    removeLast.recycle();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public synchronized void c(float f6) {
        this.f15040e = Math.round(this.f15038c * f6);
        k();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public synchronized void d(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.f15036a.b(bitmap) <= this.f15040e && this.f15037b.contains(bitmap.getConfig())) {
                int b6 = this.f15036a.b(bitmap);
                this.f15036a.d(bitmap);
                this.f15039d.a(bitmap);
                this.f15044i++;
                this.f15041f += b6;
                if (Log.isLoggable(f15034k, 2)) {
                    this.f15036a.c(bitmap);
                }
                i();
                k();
                return;
            }
            if (Log.isLoggable(f15034k, 2)) {
                this.f15036a.c(bitmap);
                bitmap.isMutable();
                this.f15037b.contains(bitmap.getConfig());
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b implements a {
        b() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.l.a
        public void a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.l.a
        public void b(Bitmap bitmap) {
        }
    }

    @TargetApi(26)
    private static void g(Bitmap.Config config) {
        Bitmap.Config config2;
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        config2 = Bitmap.Config.HARDWARE;
        if (config != config2) {
            return;
        }
        throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
    }

    @NonNull
    private static Bitmap h(int i6, int i7, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f15035l;
        }
        return Bitmap.createBitmap(i6, i7, config);
    }

    private void i() {
        if (Log.isLoggable(f15034k, 2)) {
            j();
        }
    }

    private void j() {
        Objects.toString(this.f15036a);
    }

    private void k() {
        u(this.f15040e);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> n() {
        Bitmap.Config config;
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i6 = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i6 >= 26) {
            config = Bitmap.Config.HARDWARE;
            hashSet.remove(config);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static m o() {
        return new q();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    @SuppressLint({"InlinedApi"})
    public void a(int i6) {
        Log.isLoggable(f15034k, 3);
        if (i6 >= 40 || (Build.VERSION.SDK_INT >= 23 && i6 >= 20)) {
            b();
        } else if (i6 >= 20 || i6 == 15) {
            u(getMaxSize() / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public void b() {
        Log.isLoggable(f15034k, 3);
        u(0L);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public long getMaxSize() {
        return this.f15040e;
    }

    public long l() {
        return this.f15045j;
    }

    public long m() {
        return this.f15041f;
    }

    public long q() {
        return this.f15042g;
    }

    public long s() {
        return this.f15043h;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    @NonNull
    public Bitmap e(int i6, int i7, Bitmap.Config config) {
        Bitmap p5 = p(i6, i7, config);
        if (p5 != null) {
            p5.eraseColor(0);
            return p5;
        }
        return h(i6, i7, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    @NonNull
    public Bitmap f(int i6, int i7, Bitmap.Config config) {
        Bitmap p5 = p(i6, i7, config);
        if (p5 == null) {
            return h(i6, i7, config);
        }
        return p5;
    }

    public l(long j6) {
        this(j6, o(), n());
    }

    public l(long j6, Set<Bitmap.Config> set) {
        this(j6, o(), set);
    }
}
