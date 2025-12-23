package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.load.resource.bitmap.n;
import com.bumptech.glide.load.resource.bitmap.o;
import com.bumptech.glide.load.resource.bitmap.o0;
import com.bumptech.glide.load.resource.bitmap.u;
import com.bumptech.glide.load.resource.bitmap.w;
import com.bumptech.glide.load.resource.bitmap.y;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.a;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.l;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class a<T extends a<T>> implements Cloneable {
    private static final int A = -1;
    private static final int B = 2;
    private static final int C = 4;
    private static final int D = 8;
    private static final int E = 16;
    private static final int F = 32;
    private static final int G = 64;
    private static final int H = 128;
    private static final int I = 256;
    private static final int J = 512;
    private static final int K = 1024;
    private static final int L = 2048;
    private static final int M = 4096;
    private static final int N = 8192;
    private static final int O = 16384;
    private static final int P = 32768;
    private static final int Q = 65536;
    private static final int R = 131072;
    private static final int S = 262144;
    private static final int T = 524288;
    private static final int U = 1048576;

    /* renamed from: a, reason: collision with root package name */
    private int f16129a;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private Drawable f16133e;

    /* renamed from: f, reason: collision with root package name */
    private int f16134f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private Drawable f16135g;

    /* renamed from: h, reason: collision with root package name */
    private int f16136h;

    /* renamed from: m, reason: collision with root package name */
    private boolean f16141m;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private Drawable f16143o;

    /* renamed from: p, reason: collision with root package name */
    private int f16144p;

    /* renamed from: t, reason: collision with root package name */
    private boolean f16148t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    private Resources.Theme f16149u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f16150v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f16151w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f16152x;

    /* renamed from: z, reason: collision with root package name */
    private boolean f16154z;

    /* renamed from: b, reason: collision with root package name */
    private float f16130b = 1.0f;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private com.bumptech.glide.load.engine.j f16131c = com.bumptech.glide.load.engine.j.f15243e;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private Priority f16132d = Priority.NORMAL;

    /* renamed from: i, reason: collision with root package name */
    private boolean f16137i = true;

    /* renamed from: j, reason: collision with root package name */
    private int f16138j = -1;

    /* renamed from: k, reason: collision with root package name */
    private int f16139k = -1;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    private com.bumptech.glide.load.c f16140l = com.bumptech.glide.signature.c.c();

    /* renamed from: n, reason: collision with root package name */
    private boolean f16142n = true;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    private com.bumptech.glide.load.f f16145q = new com.bumptech.glide.load.f();

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    private Map<Class<?>, com.bumptech.glide.load.i<?>> f16146r = new CachedHashCodeArrayMap();

    /* renamed from: s, reason: collision with root package name */
    @NonNull
    private Class<?> f16147s = Object.class;

    /* renamed from: y, reason: collision with root package name */
    private boolean f16153y = true;

    @NonNull
    private T B0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        return C0(downsampleStrategy, iVar, true);
    }

    private static boolean g0(int i6, int i7) {
        return (i6 & i7) != 0;
    }

    @NonNull
    private T s0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        return C0(downsampleStrategy, iVar, false);
    }

    @NonNull
    @CheckResult
    public T L0(@NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        return M0(iVar, true);
    }

    @NonNull
    @CheckResult
    public <Y> T O0(@NonNull Class<Y> cls, @NonNull com.bumptech.glide.load.i<Y> iVar) {
        return P0(cls, iVar, true);
    }

    @NonNull
    @CheckResult
    public T Q0(@NonNull com.bumptech.glide.load.i<Bitmap>... iVarArr) {
        return iVarArr.length > 1 ? M0(new com.bumptech.glide.load.d(iVarArr), true) : iVarArr.length == 1 ? L0(iVarArr[0]) : E0();
    }

    public final boolean a0() {
        return f0(4);
    }

    @NonNull
    public T m0() {
        this.f16148t = true;
        return D0();
    }

    @NonNull
    @CheckResult
    public T t0(@NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        return M0(iVar, false);
    }

    @NonNull
    @CheckResult
    public <Y> T v0(@NonNull Class<Y> cls, @NonNull com.bumptech.glide.load.i<Y> iVar) {
        return P0(cls, iVar, false);
    }

    @NonNull
    private T C0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.bumptech.glide.load.i<Bitmap> iVar, boolean z5) {
        T N0 = z5 ? N0(downsampleStrategy, iVar) : u0(downsampleStrategy, iVar);
        N0.f16153y = true;
        return N0;
    }

    private boolean f0(int i6) {
        return g0(this.f16129a, i6);
    }

    @NonNull
    @CheckResult
    public T A(@Nullable Drawable drawable) {
        if (this.f16150v) {
            return (T) q().A(drawable);
        }
        this.f16133e = drawable;
        int i6 = this.f16129a | 16;
        this.f16134f = 0;
        this.f16129a = i6 & (-33);
        return E0();
    }

    @NonNull
    @CheckResult
    public T A0(@NonNull Priority priority) {
        if (this.f16150v) {
            return (T) q().A0(priority);
        }
        this.f16132d = (Priority) com.bumptech.glide.util.k.d(priority);
        this.f16129a |= 8;
        return E0();
    }

    @NonNull
    @CheckResult
    public T B(@DrawableRes int i6) {
        if (this.f16150v) {
            return (T) q().B(i6);
        }
        this.f16144p = i6;
        int i7 = this.f16129a | 16384;
        this.f16143o = null;
        this.f16129a = i7 & (-8193);
        return E0();
    }

    @NonNull
    @CheckResult
    public T C(@Nullable Drawable drawable) {
        if (this.f16150v) {
            return (T) q().C(drawable);
        }
        this.f16143o = drawable;
        int i6 = this.f16129a | 8192;
        this.f16144p = 0;
        this.f16129a = i6 & (-16385);
        return E0();
    }

    @NonNull
    @CheckResult
    public T D() {
        return B0(DownsampleStrategy.f15556c, new y());
    }

    @NonNull
    protected final T E0() {
        if (this.f16148t) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return D0();
    }

    @NonNull
    @CheckResult
    public T F(@IntRange(from = 0) long j6) {
        return F0(o0.f15649g, Long.valueOf(j6));
    }

    @NonNull
    @CheckResult
    public <Y> T F0(@NonNull com.bumptech.glide.load.e<Y> eVar, @NonNull Y y5) {
        if (this.f16150v) {
            return (T) q().F0(eVar, y5);
        }
        com.bumptech.glide.util.k.d(eVar);
        com.bumptech.glide.util.k.d(y5);
        this.f16145q.e(eVar, y5);
        return E0();
    }

    @NonNull
    public final com.bumptech.glide.load.engine.j G() {
        return this.f16131c;
    }

    @NonNull
    @CheckResult
    public T G0(@NonNull com.bumptech.glide.load.c cVar) {
        if (this.f16150v) {
            return (T) q().G0(cVar);
        }
        this.f16140l = (com.bumptech.glide.load.c) com.bumptech.glide.util.k.d(cVar);
        this.f16129a |= 1024;
        return E0();
    }

    public final int H() {
        return this.f16134f;
    }

    @NonNull
    @CheckResult
    public T H0(@FloatRange(from = 0.0d, to = 1.0d) float f6) {
        if (this.f16150v) {
            return (T) q().H0(f6);
        }
        if (f6 < 0.0f || f6 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f16130b = f6;
        this.f16129a |= 2;
        return E0();
    }

    @Nullable
    public final Drawable I() {
        return this.f16133e;
    }

    @NonNull
    @CheckResult
    public T I0(boolean z5) {
        if (this.f16150v) {
            return (T) q().I0(true);
        }
        this.f16137i = !z5;
        this.f16129a |= 256;
        return E0();
    }

    @Nullable
    public final Drawable J() {
        return this.f16143o;
    }

    @NonNull
    @CheckResult
    public T J0(@Nullable Resources.Theme theme) {
        if (this.f16150v) {
            return (T) q().J0(theme);
        }
        this.f16149u = theme;
        this.f16129a |= 32768;
        return E0();
    }

    public final int K() {
        return this.f16144p;
    }

    @NonNull
    @CheckResult
    public T K0(@IntRange(from = 0) int i6) {
        return F0(com.bumptech.glide.load.model.stream.b.f15490b, Integer.valueOf(i6));
    }

    public final boolean L() {
        return this.f16152x;
    }

    @NonNull
    public final com.bumptech.glide.load.f M() {
        return this.f16145q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    T M0(@NonNull com.bumptech.glide.load.i<Bitmap> iVar, boolean z5) {
        if (this.f16150v) {
            return (T) q().M0(iVar, z5);
        }
        w wVar = new w(iVar, z5);
        P0(Bitmap.class, iVar, z5);
        P0(Drawable.class, wVar, z5);
        P0(BitmapDrawable.class, wVar.c(), z5);
        P0(GifDrawable.class, new com.bumptech.glide.load.resource.gif.e(iVar), z5);
        return E0();
    }

    public final int N() {
        return this.f16138j;
    }

    @NonNull
    @CheckResult
    final T N0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        if (this.f16150v) {
            return (T) q().N0(downsampleStrategy, iVar);
        }
        w(downsampleStrategy);
        return L0(iVar);
    }

    public final int O() {
        return this.f16139k;
    }

    @Nullable
    public final Drawable P() {
        return this.f16135g;
    }

    @NonNull
    <Y> T P0(@NonNull Class<Y> cls, @NonNull com.bumptech.glide.load.i<Y> iVar, boolean z5) {
        if (this.f16150v) {
            return (T) q().P0(cls, iVar, z5);
        }
        com.bumptech.glide.util.k.d(cls);
        com.bumptech.glide.util.k.d(iVar);
        this.f16146r.put(cls, iVar);
        int i6 = this.f16129a;
        this.f16142n = true;
        this.f16129a = 67584 | i6;
        this.f16153y = false;
        if (z5) {
            this.f16129a = i6 | 198656;
            this.f16141m = true;
        }
        return E0();
    }

    public final int Q() {
        return this.f16136h;
    }

    @NonNull
    public final Priority R() {
        return this.f16132d;
    }

    @NonNull
    @CheckResult
    @Deprecated
    public T R0(@NonNull com.bumptech.glide.load.i<Bitmap>... iVarArr) {
        return M0(new com.bumptech.glide.load.d(iVarArr), true);
    }

    @NonNull
    public final Class<?> S() {
        return this.f16147s;
    }

    @NonNull
    @CheckResult
    public T S0(boolean z5) {
        if (this.f16150v) {
            return (T) q().S0(z5);
        }
        this.f16154z = z5;
        this.f16129a |= 1048576;
        return E0();
    }

    @NonNull
    public final com.bumptech.glide.load.c T() {
        return this.f16140l;
    }

    @NonNull
    @CheckResult
    public T T0(boolean z5) {
        if (this.f16150v) {
            return (T) q().T0(z5);
        }
        this.f16151w = z5;
        this.f16129a |= 262144;
        return E0();
    }

    public final float U() {
        return this.f16130b;
    }

    @Nullable
    public final Resources.Theme V() {
        return this.f16149u;
    }

    @NonNull
    public final Map<Class<?>, com.bumptech.glide.load.i<?>> W() {
        return this.f16146r;
    }

    public final boolean X() {
        return this.f16154z;
    }

    public final boolean Y() {
        return this.f16151w;
    }

    protected final boolean Z() {
        return this.f16150v;
    }

    @NonNull
    @CheckResult
    public T b(@NonNull a<?> aVar) {
        if (this.f16150v) {
            return (T) q().b(aVar);
        }
        if (g0(aVar.f16129a, 2)) {
            this.f16130b = aVar.f16130b;
        }
        if (g0(aVar.f16129a, 262144)) {
            this.f16151w = aVar.f16151w;
        }
        if (g0(aVar.f16129a, 1048576)) {
            this.f16154z = aVar.f16154z;
        }
        if (g0(aVar.f16129a, 4)) {
            this.f16131c = aVar.f16131c;
        }
        if (g0(aVar.f16129a, 8)) {
            this.f16132d = aVar.f16132d;
        }
        if (g0(aVar.f16129a, 16)) {
            this.f16133e = aVar.f16133e;
            this.f16134f = 0;
            this.f16129a &= -33;
        }
        if (g0(aVar.f16129a, 32)) {
            this.f16134f = aVar.f16134f;
            this.f16133e = null;
            this.f16129a &= -17;
        }
        if (g0(aVar.f16129a, 64)) {
            this.f16135g = aVar.f16135g;
            this.f16136h = 0;
            this.f16129a &= -129;
        }
        if (g0(aVar.f16129a, 128)) {
            this.f16136h = aVar.f16136h;
            this.f16135g = null;
            this.f16129a &= -65;
        }
        if (g0(aVar.f16129a, 256)) {
            this.f16137i = aVar.f16137i;
        }
        if (g0(aVar.f16129a, 512)) {
            this.f16139k = aVar.f16139k;
            this.f16138j = aVar.f16138j;
        }
        if (g0(aVar.f16129a, 1024)) {
            this.f16140l = aVar.f16140l;
        }
        if (g0(aVar.f16129a, 4096)) {
            this.f16147s = aVar.f16147s;
        }
        if (g0(aVar.f16129a, 8192)) {
            this.f16143o = aVar.f16143o;
            this.f16144p = 0;
            this.f16129a &= -16385;
        }
        if (g0(aVar.f16129a, 16384)) {
            this.f16144p = aVar.f16144p;
            this.f16143o = null;
            this.f16129a &= -8193;
        }
        if (g0(aVar.f16129a, 32768)) {
            this.f16149u = aVar.f16149u;
        }
        if (g0(aVar.f16129a, 65536)) {
            this.f16142n = aVar.f16142n;
        }
        if (g0(aVar.f16129a, 131072)) {
            this.f16141m = aVar.f16141m;
        }
        if (g0(aVar.f16129a, 2048)) {
            this.f16146r.putAll(aVar.f16146r);
            this.f16153y = aVar.f16153y;
        }
        if (g0(aVar.f16129a, 524288)) {
            this.f16152x = aVar.f16152x;
        }
        if (!this.f16142n) {
            this.f16146r.clear();
            int i6 = this.f16129a;
            this.f16141m = false;
            this.f16129a = i6 & (-133121);
            this.f16153y = true;
        }
        this.f16129a |= aVar.f16129a;
        this.f16145q.d(aVar.f16145q);
        return E0();
    }

    public final boolean b0() {
        return this.f16148t;
    }

    public final boolean c0() {
        return this.f16137i;
    }

    public final boolean d0() {
        return f0(8);
    }

    boolean e0() {
        return this.f16153y;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (Float.compare(aVar.f16130b, this.f16130b) == 0 && this.f16134f == aVar.f16134f && l.d(this.f16133e, aVar.f16133e) && this.f16136h == aVar.f16136h && l.d(this.f16135g, aVar.f16135g) && this.f16144p == aVar.f16144p && l.d(this.f16143o, aVar.f16143o) && this.f16137i == aVar.f16137i && this.f16138j == aVar.f16138j && this.f16139k == aVar.f16139k && this.f16141m == aVar.f16141m && this.f16142n == aVar.f16142n && this.f16151w == aVar.f16151w && this.f16152x == aVar.f16152x && this.f16131c.equals(aVar.f16131c) && this.f16132d == aVar.f16132d && this.f16145q.equals(aVar.f16145q) && this.f16146r.equals(aVar.f16146r) && this.f16147s.equals(aVar.f16147s) && l.d(this.f16140l, aVar.f16140l) && l.d(this.f16149u, aVar.f16149u)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public T g() {
        if (this.f16148t && !this.f16150v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.f16150v = true;
        return m0();
    }

    @NonNull
    @CheckResult
    public T h() {
        return N0(DownsampleStrategy.f15558e, new m());
    }

    public final boolean h0() {
        return f0(256);
    }

    public int hashCode() {
        return l.q(this.f16149u, l.q(this.f16140l, l.q(this.f16147s, l.q(this.f16146r, l.q(this.f16145q, l.q(this.f16132d, l.q(this.f16131c, l.s(this.f16152x, l.s(this.f16151w, l.s(this.f16142n, l.s(this.f16141m, l.p(this.f16139k, l.p(this.f16138j, l.s(this.f16137i, l.q(this.f16143o, l.p(this.f16144p, l.q(this.f16135g, l.p(this.f16136h, l.q(this.f16133e, l.p(this.f16134f, l.m(this.f16130b)))))))))))))))))))));
    }

    public final boolean i0() {
        return this.f16142n;
    }

    public final boolean j0() {
        return this.f16141m;
    }

    public final boolean k0() {
        return f0(2048);
    }

    public final boolean l0() {
        return l.w(this.f16139k, this.f16138j);
    }

    @NonNull
    @CheckResult
    public T n() {
        return B0(DownsampleStrategy.f15557d, new n());
    }

    @NonNull
    @CheckResult
    public T n0(boolean z5) {
        if (this.f16150v) {
            return (T) q().n0(z5);
        }
        this.f16152x = z5;
        this.f16129a |= 524288;
        return E0();
    }

    @NonNull
    @CheckResult
    public T o() {
        return N0(DownsampleStrategy.f15557d, new o());
    }

    @NonNull
    @CheckResult
    public T o0() {
        return u0(DownsampleStrategy.f15558e, new m());
    }

    @NonNull
    @CheckResult
    public T p0() {
        return s0(DownsampleStrategy.f15557d, new n());
    }

    @NonNull
    @CheckResult
    public T q0() {
        return u0(DownsampleStrategy.f15558e, new o());
    }

    @NonNull
    @CheckResult
    public T r(@NonNull Class<?> cls) {
        if (this.f16150v) {
            return (T) q().r(cls);
        }
        this.f16147s = (Class) com.bumptech.glide.util.k.d(cls);
        this.f16129a |= 4096;
        return E0();
    }

    @NonNull
    @CheckResult
    public T r0() {
        return s0(DownsampleStrategy.f15556c, new y());
    }

    @NonNull
    @CheckResult
    public T s() {
        return F0(u.f15664k, Boolean.FALSE);
    }

    @NonNull
    @CheckResult
    public T t(@NonNull com.bumptech.glide.load.engine.j jVar) {
        if (this.f16150v) {
            return (T) q().t(jVar);
        }
        this.f16131c = (com.bumptech.glide.load.engine.j) com.bumptech.glide.util.k.d(jVar);
        this.f16129a |= 4;
        return E0();
    }

    @NonNull
    @CheckResult
    public T u() {
        return F0(com.bumptech.glide.load.resource.gif.h.f15754b, Boolean.TRUE);
    }

    @NonNull
    final T u0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        if (this.f16150v) {
            return (T) q().u0(downsampleStrategy, iVar);
        }
        w(downsampleStrategy);
        return M0(iVar, false);
    }

    @NonNull
    @CheckResult
    public T v() {
        if (this.f16150v) {
            return (T) q().v();
        }
        this.f16146r.clear();
        int i6 = this.f16129a;
        this.f16141m = false;
        this.f16142n = false;
        this.f16129a = (i6 & (-133121)) | 65536;
        this.f16153y = true;
        return E0();
    }

    @NonNull
    @CheckResult
    public T w(@NonNull DownsampleStrategy downsampleStrategy) {
        return F0(DownsampleStrategy.f15561h, com.bumptech.glide.util.k.d(downsampleStrategy));
    }

    @NonNull
    @CheckResult
    public T x(@NonNull Bitmap.CompressFormat compressFormat) {
        return F0(com.bumptech.glide.load.resource.bitmap.e.f15597c, com.bumptech.glide.util.k.d(compressFormat));
    }

    @NonNull
    @CheckResult
    public T x0(int i6, int i7) {
        if (this.f16150v) {
            return (T) q().x0(i6, i7);
        }
        this.f16139k = i6;
        this.f16138j = i7;
        this.f16129a |= 512;
        return E0();
    }

    @NonNull
    @CheckResult
    public T y(@IntRange(from = 0, to = 100) int i6) {
        return F0(com.bumptech.glide.load.resource.bitmap.e.f15596b, Integer.valueOf(i6));
    }

    @NonNull
    @CheckResult
    public T y0(@DrawableRes int i6) {
        if (this.f16150v) {
            return (T) q().y0(i6);
        }
        this.f16136h = i6;
        int i7 = this.f16129a | 128;
        this.f16135g = null;
        this.f16129a = i7 & (-65);
        return E0();
    }

    @NonNull
    @CheckResult
    public T z(@DrawableRes int i6) {
        if (this.f16150v) {
            return (T) q().z(i6);
        }
        this.f16134f = i6;
        int i7 = this.f16129a | 32;
        this.f16133e = null;
        this.f16129a = i7 & (-17);
        return E0();
    }

    @NonNull
    @CheckResult
    public T z0(@Nullable Drawable drawable) {
        if (this.f16150v) {
            return (T) q().z0(drawable);
        }
        this.f16135g = drawable;
        int i6 = this.f16129a | 64;
        this.f16136h = 0;
        this.f16129a = i6 & (-129);
        return E0();
    }

    @NonNull
    @CheckResult
    public T E(@NonNull DecodeFormat decodeFormat) {
        com.bumptech.glide.util.k.d(decodeFormat);
        return (T) F0(u.f15660g, decodeFormat).F0(com.bumptech.glide.load.resource.gif.h.f15753a, decodeFormat);
    }

    @Override // 
    @CheckResult
    public T q() {
        try {
            T t5 = (T) super.clone();
            com.bumptech.glide.load.f fVar = new com.bumptech.glide.load.f();
            t5.f16145q = fVar;
            fVar.d(this.f16145q);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t5.f16146r = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.f16146r);
            t5.f16148t = false;
            t5.f16150v = false;
            return t5;
        } catch (CloneNotSupportedException e6) {
            throw new RuntimeException(e6);
        }
    }

    @NonNull
    @CheckResult
    public T w0(int i6) {
        return x0(i6, i6);
    }

    private T D0() {
        return this;
    }
}
