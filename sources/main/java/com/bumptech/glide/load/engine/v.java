package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.f;
import com.bumptech.glide.load.model.n;
import java.io.File;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class v implements f, d.a<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final f.a f15363a;

    /* renamed from: b, reason: collision with root package name */
    private final g<?> f15364b;

    /* renamed from: c, reason: collision with root package name */
    private int f15365c;

    /* renamed from: d, reason: collision with root package name */
    private int f15366d = -1;

    /* renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.load.c f15367e;

    /* renamed from: f, reason: collision with root package name */
    private List<com.bumptech.glide.load.model.n<File, ?>> f15368f;

    /* renamed from: g, reason: collision with root package name */
    private int f15369g;

    /* renamed from: h, reason: collision with root package name */
    private volatile n.a<?> f15370h;

    /* renamed from: i, reason: collision with root package name */
    private File f15371i;

    /* renamed from: j, reason: collision with root package name */
    private w f15372j;

    private boolean b() {
        return this.f15369g < this.f15368f.size();
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean a() {
        List<com.bumptech.glide.load.c> c6 = this.f15364b.c();
        boolean z5 = false;
        if (c6.isEmpty()) {
            return false;
        }
        List<Class<?>> m6 = this.f15364b.m();
        if (m6.isEmpty()) {
            if (File.class.equals(this.f15364b.q())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f15364b.i() + " to " + this.f15364b.q());
        }
        while (true) {
            if (this.f15368f != null && b()) {
                this.f15370h = null;
                while (!z5 && b()) {
                    List<com.bumptech.glide.load.model.n<File, ?>> list = this.f15368f;
                    int i6 = this.f15369g;
                    this.f15369g = i6 + 1;
                    this.f15370h = list.get(i6).a(this.f15371i, this.f15364b.s(), this.f15364b.f(), this.f15364b.k());
                    if (this.f15370h != null && this.f15364b.t(this.f15370h.f15458c.a())) {
                        this.f15370h.f15458c.c(this.f15364b.l(), this);
                        z5 = true;
                    }
                }
                return z5;
            }
            int i7 = this.f15366d + 1;
            this.f15366d = i7;
            if (i7 >= m6.size()) {
                int i8 = this.f15365c + 1;
                this.f15365c = i8;
                if (i8 >= c6.size()) {
                    return false;
                }
                this.f15366d = 0;
            }
            com.bumptech.glide.load.c cVar = c6.get(this.f15365c);
            Class<?> cls = m6.get(this.f15366d);
            this.f15372j = new w(this.f15364b.b(), cVar, this.f15364b.o(), this.f15364b.s(), this.f15364b.f(), this.f15364b.r(cls), cls, this.f15364b.k());
            File b6 = this.f15364b.d().b(this.f15372j);
            this.f15371i = b6;
            if (b6 != null) {
                this.f15367e = cVar;
                this.f15368f = this.f15364b.j(b6);
                this.f15369g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        n.a<?> aVar = this.f15370h;
        if (aVar != null) {
            aVar.f15458c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void d(Object obj) {
        this.f15363a.d(this.f15367e, obj, this.f15370h.f15458c, DataSource.RESOURCE_DISK_CACHE, this.f15372j);
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void e(@NonNull Exception exc) {
        this.f15363a.b(this.f15372j, exc, this.f15370h.f15458c, DataSource.RESOURCE_DISK_CACHE);
    }

    v(g<?> gVar, f.a aVar) {
        this.f15364b = gVar;
        this.f15363a = aVar;
    }
}
