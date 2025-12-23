package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.k;
import com.bumptech.glide.request.target.m;
import com.bumptech.glide.request.target.p;
import com.bumptech.glide.request.target.r;
import com.bumptech.glide.util.l;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class h<TranscodeType> extends com.bumptech.glide.request.a<h<TranscodeType>> implements Cloneable, g<h<TranscodeType>> {
    protected static final com.bumptech.glide.request.h J0 = new com.bumptech.glide.request.h().t(com.bumptech.glide.load.engine.j.f15241c).A0(Priority.LOW).I0(true);

    @Nullable
    private Float F0;
    private boolean G0;
    private boolean H0;
    private boolean I0;
    private final Context V;
    private final i W;
    private final Class<TranscodeType> X;
    private final b Y;
    private final d Z;

    /* renamed from: a0, reason: collision with root package name */
    @NonNull
    private j<?, ? super TranscodeType> f14883a0;

    /* renamed from: b0, reason: collision with root package name */
    @Nullable
    private Object f14884b0;

    /* renamed from: c0, reason: collision with root package name */
    @Nullable
    private List<com.bumptech.glide.request.g<TranscodeType>> f14885c0;

    /* renamed from: k0, reason: collision with root package name */
    @Nullable
    private h<TranscodeType> f14886k0;

    /* renamed from: p0, reason: collision with root package name */
    @Nullable
    private h<TranscodeType> f14887p0;

    @SuppressLint({"CheckResult"})
    protected h(@NonNull b bVar, i iVar, Class<TranscodeType> cls, Context context) {
        this.G0 = true;
        this.Y = bVar;
        this.W = iVar;
        this.X = cls;
        this.V = context;
        this.f14883a0 = iVar.E(cls);
        this.Z = bVar.j();
        h1(iVar.C());
        b(iVar.D());
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> G1(@Nullable List<h<TranscodeType>> list) {
        h<TranscodeType> hVar = null;
        if (list == null || list.isEmpty()) {
            return F1(null);
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            h<TranscodeType> hVar2 = list.get(size);
            if (hVar2 != null) {
                hVar = hVar == null ? hVar2 : hVar2.F1(hVar);
            }
        }
        return F1(hVar);
    }

    @NonNull
    public <Y extends p<TranscodeType>> Y j1(@NonNull Y y5) {
        return (Y) l1(y5, null, com.bumptech.glide.util.e.b());
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14888a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f14889b;

        static {
            int[] iArr = new int[Priority.values().length];
            f14889b = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14889b[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14889b[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14889b[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f14888a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14888a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14888a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f14888a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f14888a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f14888a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f14888a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f14888a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private com.bumptech.glide.request.e W0(p<TranscodeType> pVar, @Nullable com.bumptech.glide.request.g<TranscodeType> gVar, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        return X0(new Object(), pVar, gVar, null, this.f14883a0, aVar.R(), aVar.O(), aVar.N(), aVar, executor);
    }

    private com.bumptech.glide.request.e X0(Object obj, p<TranscodeType> pVar, @Nullable com.bumptech.glide.request.g<TranscodeType> gVar, @Nullable RequestCoordinator requestCoordinator, j<?, ? super TranscodeType> jVar, Priority priority, int i6, int i7, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        com.bumptech.glide.request.b bVar;
        RequestCoordinator requestCoordinator2;
        Object obj2;
        p<TranscodeType> pVar2;
        com.bumptech.glide.request.g<TranscodeType> gVar2;
        j<?, ? super TranscodeType> jVar2;
        Priority priority2;
        int i8;
        int i9;
        com.bumptech.glide.request.a<?> aVar2;
        Executor executor2;
        h<TranscodeType> hVar;
        if (this.f14887p0 != null) {
            bVar = new com.bumptech.glide.request.b(obj, requestCoordinator);
            requestCoordinator2 = bVar;
            hVar = this;
            obj2 = obj;
            pVar2 = pVar;
            gVar2 = gVar;
            jVar2 = jVar;
            priority2 = priority;
            i8 = i6;
            i9 = i7;
            aVar2 = aVar;
            executor2 = executor;
        } else {
            bVar = null;
            requestCoordinator2 = requestCoordinator;
            obj2 = obj;
            pVar2 = pVar;
            gVar2 = gVar;
            jVar2 = jVar;
            priority2 = priority;
            i8 = i6;
            i9 = i7;
            aVar2 = aVar;
            executor2 = executor;
            hVar = this;
        }
        com.bumptech.glide.request.e Y0 = hVar.Y0(obj2, pVar2, gVar2, requestCoordinator2, jVar2, priority2, i8, i9, aVar2, executor2);
        if (bVar == null) {
            return Y0;
        }
        int O = this.f14887p0.O();
        int N = this.f14887p0.N();
        if (l.w(i6, i7) && !this.f14887p0.l0()) {
            O = aVar.O();
            N = aVar.N();
        }
        h<TranscodeType> hVar2 = this.f14887p0;
        com.bumptech.glide.request.b bVar2 = bVar;
        bVar2.n(Y0, hVar2.X0(obj, pVar, gVar, bVar2, hVar2.f14883a0, hVar2.R(), O, N, this.f14887p0, executor));
        return bVar2;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bumptech.glide.request.a] */
    private com.bumptech.glide.request.e Y0(Object obj, p<TranscodeType> pVar, com.bumptech.glide.request.g<TranscodeType> gVar, @Nullable RequestCoordinator requestCoordinator, j<?, ? super TranscodeType> jVar, Priority priority, int i6, int i7, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        h<TranscodeType> hVar = this.f14886k0;
        if (hVar == null) {
            if (this.F0 == null) {
                return z1(obj, pVar, gVar, aVar, requestCoordinator, jVar, priority, i6, i7, executor);
            }
            k kVar = new k(obj, requestCoordinator);
            kVar.m(z1(obj, pVar, gVar, aVar, kVar, jVar, priority, i6, i7, executor), z1(obj, pVar, gVar, aVar.q().H0(this.F0.floatValue()), kVar, jVar, g1(priority), i6, i7, executor));
            return kVar;
        }
        if (this.I0) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        j<?, ? super TranscodeType> jVar2 = hVar.G0 ? jVar : hVar.f14883a0;
        Priority R = hVar.d0() ? this.f14886k0.R() : g1(priority);
        int O = this.f14886k0.O();
        int N = this.f14886k0.N();
        if (l.w(i6, i7) && !this.f14886k0.l0()) {
            O = aVar.O();
            N = aVar.N();
        }
        k kVar2 = new k(obj, requestCoordinator);
        com.bumptech.glide.request.e z12 = z1(obj, pVar, gVar, aVar, kVar2, jVar, priority, i6, i7, executor);
        this.I0 = true;
        h hVar2 = (h<TranscodeType>) this.f14886k0;
        com.bumptech.glide.request.e X0 = hVar2.X0(obj, pVar, gVar, kVar2, jVar2, R, O, N, hVar2, executor);
        this.I0 = false;
        kVar2.m(z12, X0);
        return kVar2;
    }

    @NonNull
    private Priority g1(@NonNull Priority priority) {
        int i6 = a.f14889b[priority.ordinal()];
        if (i6 == 1) {
            return Priority.NORMAL;
        }
        if (i6 == 2) {
            return Priority.HIGH;
        }
        if (i6 == 3 || i6 == 4) {
            return Priority.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + R());
    }

    private com.bumptech.glide.request.e z1(Object obj, p<TranscodeType> pVar, com.bumptech.glide.request.g<TranscodeType> gVar, com.bumptech.glide.request.a<?> aVar, RequestCoordinator requestCoordinator, j<?, ? super TranscodeType> jVar, Priority priority, int i6, int i7, Executor executor) {
        Context context = this.V;
        d dVar = this.Z;
        return com.bumptech.glide.request.j.w(context, dVar, obj, this.f14884b0, this.X, aVar, i6, i7, priority, pVar, gVar, this.f14885c0, requestCoordinator, dVar.f(), jVar.c(), executor);
    }

    @NonNull
    public p<TranscodeType> A1() {
        return B1(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    public p<TranscodeType> B1(int i6, int i7) {
        return j1(m.c(this.W, i6, i7));
    }

    @NonNull
    public com.bumptech.glide.request.d<TranscodeType> C1() {
        return D1(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    public com.bumptech.glide.request.d<TranscodeType> D1(int i6, int i7) {
        com.bumptech.glide.request.f fVar = new com.bumptech.glide.request.f(i6, i7);
        return (com.bumptech.glide.request.d) l1(fVar, fVar, com.bumptech.glide.util.e.a());
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> H1(@Nullable h<TranscodeType>... hVarArr) {
        return (hVarArr == null || hVarArr.length == 0) ? F1(null) : G1(Arrays.asList(hVarArr));
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> e1(Object obj) {
        return obj == null ? d1(null) : d1(a1().i(obj));
    }

    @NonNull
    @CheckResult
    protected h<File> f1() {
        return new h(File.class, this).b(J0);
    }

    private h<TranscodeType> a1() {
        return clone().d1(null).F1(null);
    }

    @SuppressLint({"CheckResult"})
    private void h1(List<com.bumptech.glide.request.g<Object>> list) {
        Iterator<com.bumptech.glide.request.g<Object>> it = list.iterator();
        while (it.hasNext()) {
            U0((com.bumptech.glide.request.g) it.next());
        }
    }

    private <Y extends p<TranscodeType>> Y k1(@NonNull Y y5, @Nullable com.bumptech.glide.request.g<TranscodeType> gVar, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        com.bumptech.glide.util.k.d(y5);
        if (this.H0) {
            com.bumptech.glide.request.e W0 = W0(y5, gVar, aVar, executor);
            com.bumptech.glide.request.e d6 = y5.d();
            if (W0.f(d6) && !n1(aVar, d6)) {
                if (!((com.bumptech.glide.request.e) com.bumptech.glide.util.k.d(d6)).isRunning()) {
                    d6.h();
                }
                return y5;
            }
            this.W.z(y5);
            y5.n(W0);
            this.W.Y(y5, W0);
            return y5;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    private boolean n1(com.bumptech.glide.request.a<?> aVar, com.bumptech.glide.request.e eVar) {
        if (!aVar.c0() && eVar.isComplete()) {
            return true;
        }
        return false;
    }

    @NonNull
    private h<TranscodeType> y1(@Nullable Object obj) {
        if (Z()) {
            return clone().y1(obj);
        }
        this.f14884b0 = obj;
        this.H0 = true;
        return E0();
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> E1(float f6) {
        if (Z()) {
            return clone().E1(f6);
        }
        if (f6 >= 0.0f && f6 <= 1.0f) {
            this.F0 = Float.valueOf(f6);
            return E0();
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> F1(@Nullable h<TranscodeType> hVar) {
        if (Z()) {
            return clone().F1(hVar);
        }
        this.f14886k0 = hVar;
        return E0();
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> I1(@NonNull j<?, ? super TranscodeType> jVar) {
        if (Z()) {
            return clone().I1(jVar);
        }
        this.f14883a0 = (j) com.bumptech.glide.util.k.d(jVar);
        this.G0 = false;
        return E0();
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> U0(@Nullable com.bumptech.glide.request.g<TranscodeType> gVar) {
        if (Z()) {
            return clone().U0(gVar);
        }
        if (gVar != null) {
            if (this.f14885c0 == null) {
                this.f14885c0 = new ArrayList();
            }
            this.f14885c0.add(gVar);
        }
        return E0();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> b(@NonNull com.bumptech.glide.request.a<?> aVar) {
        com.bumptech.glide.util.k.d(aVar);
        return (h) super.b(aVar);
    }

    @Override // com.bumptech.glide.request.a
    @CheckResult
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public h<TranscodeType> q() {
        h<TranscodeType> hVar = (h) super.q();
        hVar.f14883a0 = (j<?, ? super TranscodeType>) hVar.f14883a0.clone();
        if (hVar.f14885c0 != null) {
            hVar.f14885c0 = new ArrayList(hVar.f14885c0);
        }
        h<TranscodeType> hVar2 = hVar.f14886k0;
        if (hVar2 != null) {
            hVar.f14886k0 = hVar2.clone();
        }
        h<TranscodeType> hVar3 = hVar.f14887p0;
        if (hVar3 != null) {
            hVar.f14887p0 = hVar3.clone();
        }
        return hVar;
    }

    @CheckResult
    @Deprecated
    public com.bumptech.glide.request.d<File> b1(int i6, int i7) {
        return f1().D1(i6, i7);
    }

    @CheckResult
    @Deprecated
    public <Y extends p<File>> Y c1(@NonNull Y y5) {
        return (Y) f1().j1(y5);
    }

    @NonNull
    public h<TranscodeType> d1(@Nullable h<TranscodeType> hVar) {
        if (Z()) {
            return clone().d1(hVar);
        }
        this.f14887p0 = hVar;
        return E0();
    }

    @Deprecated
    public com.bumptech.glide.request.d<TranscodeType> i1(int i6, int i7) {
        return D1(i6, i7);
    }

    @NonNull
    <Y extends p<TranscodeType>> Y l1(@NonNull Y y5, @Nullable com.bumptech.glide.request.g<TranscodeType> gVar, Executor executor) {
        return (Y) k1(y5, gVar, this, executor);
    }

    @NonNull
    public r<ImageView, TranscodeType> m1(@NonNull ImageView imageView) {
        h<TranscodeType> hVar;
        l.b();
        com.bumptech.glide.util.k.d(imageView);
        if (!k0() && i0() && imageView.getScaleType() != null) {
            switch (a.f14888a[imageView.getScaleType().ordinal()]) {
                case 1:
                    hVar = q().o0();
                    break;
                case 2:
                    hVar = q().p0();
                    break;
                case 3:
                case 4:
                case 5:
                    hVar = q().r0();
                    break;
                case 6:
                    hVar = q().p0();
                    break;
            }
            return (r) k1(this.Z.a(imageView, this.X), null, hVar, com.bumptech.glide.util.e.b());
        }
        hVar = this;
        return (r) k1(this.Z.a(imageView, this.X), null, hVar, com.bumptech.glide.util.e.b());
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> o1(@Nullable com.bumptech.glide.request.g<TranscodeType> gVar) {
        if (Z()) {
            return clone().o1(gVar);
        }
        this.f14885c0 = null;
        return U0(gVar);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> m(@Nullable Bitmap bitmap) {
        return y1(bitmap).b(com.bumptech.glide.request.h.Z0(com.bumptech.glide.load.engine.j.f15240b));
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    /* renamed from: q1, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> f(@Nullable Drawable drawable) {
        return y1(drawable).b(com.bumptech.glide.request.h.Z0(com.bumptech.glide.load.engine.j.f15240b));
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    /* renamed from: r1, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> k(@Nullable Uri uri) {
        return y1(uri);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    /* renamed from: s1, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> e(@Nullable File file) {
        return y1(file);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    /* renamed from: t1, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> p(@Nullable @DrawableRes @RawRes Integer num) {
        return y1(num).b(com.bumptech.glide.request.h.q1(com.bumptech.glide.signature.a.c(this.V)));
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    /* renamed from: u1, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> i(@Nullable Object obj) {
        return y1(obj);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    /* renamed from: v1, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> a(@Nullable String str) {
        return y1(str);
    }

    @Override // com.bumptech.glide.g
    @CheckResult
    @Deprecated
    /* renamed from: w1, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> c(@Nullable URL url) {
        return y1(url);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    /* renamed from: x1, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> l(@Nullable byte[] bArr) {
        h<TranscodeType> y12 = y1(bArr);
        if (!y12.a0()) {
            y12 = y12.b(com.bumptech.glide.request.h.Z0(com.bumptech.glide.load.engine.j.f15240b));
        }
        if (!y12.h0()) {
            return y12.b(com.bumptech.glide.request.h.s1(true));
        }
        return y12;
    }

    @SuppressLint({"CheckResult"})
    protected h(Class<TranscodeType> cls, h<?> hVar) {
        this(hVar.Y, hVar.W, cls, hVar.V);
        this.f14884b0 = hVar.f14884b0;
        this.H0 = hVar.H0;
        b(hVar);
    }
}
