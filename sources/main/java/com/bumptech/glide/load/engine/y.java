package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.f;
import com.bumptech.glide.load.model.n;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class y implements f, f.a {

    /* renamed from: h, reason: collision with root package name */
    private static final String f15385h = "SourceGenerator";

    /* renamed from: a, reason: collision with root package name */
    private final g<?> f15386a;

    /* renamed from: b, reason: collision with root package name */
    private final f.a f15387b;

    /* renamed from: c, reason: collision with root package name */
    private int f15388c;

    /* renamed from: d, reason: collision with root package name */
    private c f15389d;

    /* renamed from: e, reason: collision with root package name */
    private Object f15390e;

    /* renamed from: f, reason: collision with root package name */
    private volatile n.a<?> f15391f;

    /* renamed from: g, reason: collision with root package name */
    private d f15392g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements d.a<Object> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.a f15393a;

        a(n.a aVar) {
            this.f15393a = aVar;
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void d(@Nullable Object obj) {
            if (y.this.g(this.f15393a)) {
                y.this.h(this.f15393a, obj);
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void e(@NonNull Exception exc) {
            if (y.this.g(this.f15393a)) {
                y.this.i(this.f15393a, exc);
            }
        }
    }

    private boolean f() {
        return this.f15388c < this.f15386a.g().size();
    }

    private void j(n.a<?> aVar) {
        this.f15391f.f15458c.c(this.f15386a.l(), new a(aVar));
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean a() {
        Object obj = this.f15390e;
        if (obj != null) {
            this.f15390e = null;
            e(obj);
        }
        c cVar = this.f15389d;
        if (cVar != null && cVar.a()) {
            return true;
        }
        this.f15389d = null;
        this.f15391f = null;
        boolean z5 = false;
        while (!z5 && f()) {
            List<n.a<?>> g6 = this.f15386a.g();
            int i6 = this.f15388c;
            this.f15388c = i6 + 1;
            this.f15391f = g6.get(i6);
            if (this.f15391f != null && (this.f15386a.e().c(this.f15391f.f15458c.getDataSource()) || this.f15386a.t(this.f15391f.f15458c.a()))) {
                j(this.f15391f);
                z5 = true;
            }
        }
        return z5;
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void b(com.bumptech.glide.load.c cVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource) {
        this.f15387b.b(cVar, exc, dVar, this.f15391f.f15458c.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void c() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        n.a<?> aVar = this.f15391f;
        if (aVar != null) {
            aVar.f15458c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void d(com.bumptech.glide.load.c cVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, com.bumptech.glide.load.c cVar2) {
        this.f15387b.d(cVar, obj, dVar, this.f15391f.f15458c.getDataSource(), cVar);
    }

    boolean g(n.a<?> aVar) {
        n.a<?> aVar2 = this.f15391f;
        return aVar2 != null && aVar2 == aVar;
    }

    void h(n.a<?> aVar, Object obj) {
        j e6 = this.f15386a.e();
        if (obj != null && e6.c(aVar.f15458c.getDataSource())) {
            this.f15390e = obj;
            this.f15387b.c();
        } else {
            f.a aVar2 = this.f15387b;
            com.bumptech.glide.load.c cVar = aVar.f15456a;
            com.bumptech.glide.load.data.d<?> dVar = aVar.f15458c;
            aVar2.d(cVar, obj, dVar, dVar.getDataSource(), this.f15392g);
        }
    }

    void i(n.a<?> aVar, @NonNull Exception exc) {
        f.a aVar2 = this.f15387b;
        d dVar = this.f15392g;
        com.bumptech.glide.load.data.d<?> dVar2 = aVar.f15458c;
        aVar2.b(dVar, exc, dVar2, dVar2.getDataSource());
    }

    y(g<?> gVar, f.a aVar) {
        this.f15386a = gVar;
        this.f15387b = aVar;
    }

    private void e(Object obj) {
        long b6 = com.bumptech.glide.util.g.b();
        try {
            com.bumptech.glide.load.a<X> p5 = this.f15386a.p(obj);
            e eVar = new e(p5, obj, this.f15386a.k());
            this.f15392g = new d(this.f15391f.f15456a, this.f15386a.o());
            this.f15386a.d().a(this.f15392g, eVar);
            if (Log.isLoggable(f15385h, 2)) {
                Objects.toString(this.f15392g);
                Objects.toString(obj);
                Objects.toString(p5);
                com.bumptech.glide.util.g.a(b6);
            }
            this.f15391f.f15458c.b();
            this.f15389d = new c(Collections.singletonList(this.f15391f.f15456a), this.f15386a, this);
        } catch (Throwable th) {
            this.f15391f.f15458c.b();
            throw th;
        }
    }
}
