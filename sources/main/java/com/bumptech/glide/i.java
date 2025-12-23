package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.c;
import com.bumptech.glide.manager.l;
import com.bumptech.glide.manager.m;
import com.bumptech.glide.manager.r;
import com.bumptech.glide.manager.s;
import com.bumptech.glide.manager.t;
import com.bumptech.glide.request.target.p;
import com.stub.StubApp;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class i implements ComponentCallbacks2, m, g<h<Drawable>> {

    /* renamed from: l, reason: collision with root package name */
    private static final com.bumptech.glide.request.h f14890l = com.bumptech.glide.request.h.Y0(Bitmap.class).m0();

    /* renamed from: m, reason: collision with root package name */
    private static final com.bumptech.glide.request.h f14891m = com.bumptech.glide.request.h.Y0(GifDrawable.class).m0();

    /* renamed from: n, reason: collision with root package name */
    private static final com.bumptech.glide.request.h f14892n = com.bumptech.glide.request.h.Z0(com.bumptech.glide.load.engine.j.f15241c).A0(Priority.LOW).I0(true);

    /* renamed from: a, reason: collision with root package name */
    protected final com.bumptech.glide.b f14893a;

    /* renamed from: b, reason: collision with root package name */
    protected final Context f14894b;

    /* renamed from: c, reason: collision with root package name */
    final l f14895c;

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    private final s f14896d;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    private final r f14897e;

    /* renamed from: f, reason: collision with root package name */
    @GuardedBy("this")
    private final t f14898f;

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f14899g;

    /* renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.manager.c f14900h;

    /* renamed from: i, reason: collision with root package name */
    private final CopyOnWriteArrayList<com.bumptech.glide.request.g<Object>> f14901i;

    /* renamed from: j, reason: collision with root package name */
    @GuardedBy("this")
    private com.bumptech.glide.request.h f14902j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f14903k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar = i.this;
            iVar.f14895c.b(iVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements c.a {

        /* renamed from: a, reason: collision with root package name */
        @GuardedBy("RequestManager.this")
        private final s f14905a;

        c(@NonNull s sVar) {
            this.f14905a = sVar;
        }

        @Override // com.bumptech.glide.manager.c.a
        public void a(boolean z5) {
            if (z5) {
                synchronized (i.this) {
                    this.f14905a.g();
                }
            }
        }
    }

    public i(@NonNull com.bumptech.glide.b bVar, @NonNull l lVar, @NonNull r rVar, @NonNull Context context) {
        this(bVar, lVar, rVar, new s(), bVar.i(), context);
    }

    private synchronized void b0(@NonNull com.bumptech.glide.request.h hVar) {
        this.f14902j = this.f14902j.b(hVar);
    }

    synchronized com.bumptech.glide.request.h D() {
        return this.f14902j;
    }

    public synchronized boolean F() {
        return this.f14896d.d();
    }

    public synchronized void P() {
        this.f14896d.e();
    }

    public synchronized void Q() {
        P();
        Iterator<i> it = this.f14897e.a().iterator();
        while (it.hasNext()) {
            it.next().P();
        }
    }

    public synchronized void R() {
        this.f14896d.f();
    }

    public synchronized void S() {
        R();
        Iterator<i> it = this.f14897e.a().iterator();
        while (it.hasNext()) {
            it.next().R();
        }
    }

    public synchronized void T() {
        this.f14896d.h();
    }

    public synchronized void U() {
        com.bumptech.glide.util.l.b();
        T();
        Iterator<i> it = this.f14897e.a().iterator();
        while (it.hasNext()) {
            it.next().T();
        }
    }

    @NonNull
    public synchronized i V(@NonNull com.bumptech.glide.request.h hVar) {
        X(hVar);
        return this;
    }

    protected synchronized void X(@NonNull com.bumptech.glide.request.h hVar) {
        this.f14902j = hVar.q().g();
    }

    synchronized void Y(@NonNull p<?> pVar, @NonNull com.bumptech.glide.request.e eVar) {
        this.f14898f.e(pVar);
        this.f14896d.i(eVar);
    }

    synchronized boolean Z(@NonNull p<?> pVar) {
        com.bumptech.glide.request.e d6 = pVar.d();
        if (d6 == null) {
            return true;
        }
        if (!this.f14896d.b(d6)) {
            return false;
        }
        this.f14898f.f(pVar);
        pVar.n(null);
        return true;
    }

    @Override // com.bumptech.glide.manager.m
    public synchronized void onDestroy() {
        try {
            this.f14898f.onDestroy();
            Iterator<p<?>> it = this.f14898f.c().iterator();
            while (it.hasNext()) {
                z(it.next());
            }
            this.f14898f.a();
            this.f14896d.c();
            this.f14895c.a(this);
            this.f14895c.a(this.f14900h);
            com.bumptech.glide.util.l.y(this.f14899g);
            this.f14893a.A(this);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.manager.m
    public synchronized void onStart() {
        T();
        this.f14898f.onStart();
    }

    @Override // com.bumptech.glide.manager.m
    public synchronized void onStop() {
        R();
        this.f14898f.onStop();
    }

    @NonNull
    public synchronized i s(@NonNull com.bumptech.glide.request.h hVar) {
        b0(hVar);
        return this;
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f14896d + ", treeNode=" + this.f14897e + "}";
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b extends com.bumptech.glide.request.target.f<View, Object> {
        b(@NonNull View view) {
            super(view);
        }

        @Override // com.bumptech.glide.request.target.f
        protected void k(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.p
        public void o(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.p
        public void h(@NonNull Object obj, @Nullable com.bumptech.glide.request.transition.f<? super Object> fVar) {
        }
    }

    @NonNull
    @CheckResult
    public h<File> B() {
        return t(File.class).b(f14892n);
    }

    List<com.bumptech.glide.request.g<Object>> C() {
        return this.f14901i;
    }

    @NonNull
    <T> j<?, T> E(Class<T> cls) {
        return this.f14893a.j().e(cls);
    }

    public void W(boolean z5) {
        this.f14903k = z5;
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i6) {
        if (i6 == 60 && this.f14903k) {
            Q();
        }
    }

    public i r(com.bumptech.glide.request.g<Object> gVar) {
        this.f14901i.add(gVar);
        return this;
    }

    @NonNull
    @CheckResult
    public <ResourceType> h<ResourceType> t(@NonNull Class<ResourceType> cls) {
        return new h<>(this.f14893a, this, cls, this.f14894b);
    }

    @NonNull
    @CheckResult
    public h<Bitmap> u() {
        return t(Bitmap.class).b(f14890l);
    }

    @NonNull
    @CheckResult
    public h<Drawable> v() {
        return t(Drawable.class);
    }

    @NonNull
    @CheckResult
    public h<File> w() {
        return t(File.class).b(com.bumptech.glide.request.h.s1(true));
    }

    @NonNull
    @CheckResult
    public h<GifDrawable> x() {
        return t(GifDrawable.class).b(f14891m);
    }

    public void y(@NonNull View view) {
        z(new b(view));
    }

    public void z(@Nullable p<?> pVar) {
        if (pVar == null) {
            return;
        }
        a0(pVar);
    }

    private void a0(@NonNull p<?> pVar) {
        boolean Z = Z(pVar);
        com.bumptech.glide.request.e d6 = pVar.d();
        if (!Z && !this.f14893a.v(pVar) && d6 != null) {
            pVar.n(null);
            d6.clear();
        }
    }

    @NonNull
    @CheckResult
    public h<File> A(@Nullable Object obj) {
        return B().i(obj);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public h<Drawable> m(@Nullable Bitmap bitmap) {
        return v().m(bitmap);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public h<Drawable> f(@Nullable Drawable drawable) {
        return v().f(drawable);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public h<Drawable> k(@Nullable Uri uri) {
        return v().k(uri);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public h<Drawable> e(@Nullable File file) {
        return v().e(file);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public h<Drawable> p(@Nullable @DrawableRes @RawRes Integer num) {
        return v().p(num);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public h<Drawable> i(@Nullable Object obj) {
        return v().i(obj);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public h<Drawable> a(@Nullable String str) {
        return v().a(str);
    }

    @Override // com.bumptech.glide.g
    @CheckResult
    @Deprecated
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public h<Drawable> c(@Nullable URL url) {
        return v().c(url);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public h<Drawable> l(@Nullable byte[] bArr) {
        return v().l(bArr);
    }

    i(com.bumptech.glide.b bVar, l lVar, r rVar, s sVar, com.bumptech.glide.manager.d dVar, Context context) {
        this.f14898f = new t();
        a aVar = new a();
        this.f14899g = aVar;
        this.f14893a = bVar;
        this.f14895c = lVar;
        this.f14897e = rVar;
        this.f14896d = sVar;
        this.f14894b = context;
        com.bumptech.glide.manager.c a6 = dVar.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), new c(sVar));
        this.f14900h = a6;
        if (com.bumptech.glide.util.l.t()) {
            com.bumptech.glide.util.l.x(aVar);
        } else {
            lVar.b(this);
        }
        lVar.b(a6);
        this.f14901i = new CopyOnWriteArrayList<>(bVar.j().c());
        X(bVar.j().d());
        bVar.u(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }
}
