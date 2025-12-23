package com.bumptech.glide;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.b;
import com.bumptech.glide.e;
import com.bumptech.glide.load.engine.cache.a;
import com.bumptech.glide.load.engine.cache.l;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.manager.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    private k f14705c;

    /* renamed from: d, reason: collision with root package name */
    private com.bumptech.glide.load.engine.bitmap_recycle.e f14706d;

    /* renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.load.engine.bitmap_recycle.b f14707e;

    /* renamed from: f, reason: collision with root package name */
    private com.bumptech.glide.load.engine.cache.j f14708f;

    /* renamed from: g, reason: collision with root package name */
    private com.bumptech.glide.load.engine.executor.a f14709g;

    /* renamed from: h, reason: collision with root package name */
    private com.bumptech.glide.load.engine.executor.a f14710h;

    /* renamed from: i, reason: collision with root package name */
    private a.InterfaceC0153a f14711i;

    /* renamed from: j, reason: collision with root package name */
    private l f14712j;

    /* renamed from: k, reason: collision with root package name */
    private com.bumptech.glide.manager.d f14713k;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    private q.b f14716n;

    /* renamed from: o, reason: collision with root package name */
    private com.bumptech.glide.load.engine.executor.a f14717o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f14718p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    private List<com.bumptech.glide.request.g<Object>> f14719q;

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, j<?, ?>> f14703a = new ArrayMap();

    /* renamed from: b, reason: collision with root package name */
    private final e.a f14704b = new e.a();

    /* renamed from: l, reason: collision with root package name */
    private int f14714l = 4;

    /* renamed from: m, reason: collision with root package name */
    private b.a f14715m = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements b.a {
        a() {
        }

        @Override // com.bumptech.glide.b.a
        @NonNull
        public com.bumptech.glide.request.h build() {
            return new com.bumptech.glide.request.h();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.request.h f14721a;

        b(com.bumptech.glide.request.h hVar) {
            this.f14721a = hVar;
        }

        @Override // com.bumptech.glide.b.a
        @NonNull
        public com.bumptech.glide.request.h build() {
            com.bumptech.glide.request.h hVar = this.f14721a;
            return hVar != null ? hVar : new com.bumptech.glide.request.h();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d implements e.b {
    }

    @NonNull
    public c o(int i6) {
        if (i6 < 2 || i6 > 6) {
            throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
        }
        this.f14714l = i6;
        return this;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bumptech.glide.c$c, reason: collision with other inner class name */
    static final class C0148c implements e.b {
        C0148c() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e implements e.b {

        /* renamed from: a, reason: collision with root package name */
        final int f14723a;

        e(int i6) {
            this.f14723a = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class f implements e.b {
        private f() {
        }
    }

    @NonNull
    public c a(@NonNull com.bumptech.glide.request.g<Object> gVar) {
        if (this.f14719q == null) {
            this.f14719q = new ArrayList();
        }
        this.f14719q.add(gVar);
        return this;
    }

    @NonNull
    com.bumptech.glide.b b(@NonNull Context context) {
        if (this.f14709g == null) {
            this.f14709g = com.bumptech.glide.load.engine.executor.a.j();
        }
        if (this.f14710h == null) {
            this.f14710h = com.bumptech.glide.load.engine.executor.a.f();
        }
        if (this.f14717o == null) {
            this.f14717o = com.bumptech.glide.load.engine.executor.a.c();
        }
        if (this.f14712j == null) {
            this.f14712j = new l.a(context).a();
        }
        if (this.f14713k == null) {
            this.f14713k = new com.bumptech.glide.manager.f();
        }
        if (this.f14706d == null) {
            int b6 = this.f14712j.b();
            if (b6 > 0) {
                this.f14706d = new com.bumptech.glide.load.engine.bitmap_recycle.l(b6);
            } else {
                this.f14706d = new com.bumptech.glide.load.engine.bitmap_recycle.f();
            }
        }
        if (this.f14707e == null) {
            this.f14707e = new com.bumptech.glide.load.engine.bitmap_recycle.j(this.f14712j.a());
        }
        if (this.f14708f == null) {
            this.f14708f = new com.bumptech.glide.load.engine.cache.i(this.f14712j.d());
        }
        if (this.f14711i == null) {
            this.f14711i = new com.bumptech.glide.load.engine.cache.h(context);
        }
        if (this.f14705c == null) {
            this.f14705c = new k(this.f14708f, this.f14711i, this.f14710h, this.f14709g, com.bumptech.glide.load.engine.executor.a.m(), this.f14717o, this.f14718p);
        }
        List<com.bumptech.glide.request.g<Object>> list = this.f14719q;
        if (list == null) {
            this.f14719q = Collections.EMPTY_LIST;
        } else {
            this.f14719q = Collections.unmodifiableList(list);
        }
        com.bumptech.glide.e c6 = this.f14704b.c();
        return new com.bumptech.glide.b(context, this.f14705c, this.f14708f, this.f14706d, this.f14707e, new q(this.f14716n, c6), this.f14713k, this.f14714l, this.f14715m, this.f14703a, this.f14719q, c6);
    }

    @NonNull
    public c c(@Nullable com.bumptech.glide.load.engine.executor.a aVar) {
        this.f14717o = aVar;
        return this;
    }

    @NonNull
    public c d(@Nullable com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f14707e = bVar;
        return this;
    }

    @NonNull
    public c e(@Nullable com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        this.f14706d = eVar;
        return this;
    }

    @NonNull
    public c f(@Nullable com.bumptech.glide.manager.d dVar) {
        this.f14713k = dVar;
        return this;
    }

    @NonNull
    public c h(@Nullable com.bumptech.glide.request.h hVar) {
        return g(new b(hVar));
    }

    @NonNull
    public <T> c i(@NonNull Class<T> cls, @Nullable j<?, T> jVar) {
        this.f14703a.put(cls, jVar);
        return this;
    }

    @NonNull
    public c j(@Nullable a.InterfaceC0153a interfaceC0153a) {
        this.f14711i = interfaceC0153a;
        return this;
    }

    @NonNull
    public c k(@Nullable com.bumptech.glide.load.engine.executor.a aVar) {
        this.f14710h = aVar;
        return this;
    }

    c l(k kVar) {
        this.f14705c = kVar;
        return this;
    }

    public c m(boolean z5) {
        this.f14704b.update(new C0148c(), z5 && Build.VERSION.SDK_INT >= 29);
        return this;
    }

    @NonNull
    public c n(boolean z5) {
        this.f14718p = z5;
        return this;
    }

    public c p(boolean z5) {
        this.f14704b.update(new d(), z5);
        return this;
    }

    @NonNull
    public c q(@Nullable com.bumptech.glide.load.engine.cache.j jVar) {
        this.f14708f = jVar;
        return this;
    }

    @NonNull
    public c s(@Nullable l lVar) {
        this.f14712j = lVar;
        return this;
    }

    void t(@Nullable q.b bVar) {
        this.f14716n = bVar;
    }

    @NonNull
    public c v(@Nullable com.bumptech.glide.load.engine.executor.a aVar) {
        this.f14709g = aVar;
        return this;
    }

    @NonNull
    public c g(@NonNull b.a aVar) {
        this.f14715m = (b.a) com.bumptech.glide.util.k.d(aVar);
        return this;
    }

    @NonNull
    public c r(@NonNull l.a aVar) {
        return s(aVar.a());
    }

    @Deprecated
    public c u(@Nullable com.bumptech.glide.load.engine.executor.a aVar) {
        return v(aVar);
    }
}
