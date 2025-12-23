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
class c implements f, d.a<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final List<com.bumptech.glide.load.c> f15066a;

    /* renamed from: b, reason: collision with root package name */
    private final g<?> f15067b;

    /* renamed from: c, reason: collision with root package name */
    private final f.a f15068c;

    /* renamed from: d, reason: collision with root package name */
    private int f15069d;

    /* renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.load.c f15070e;

    /* renamed from: f, reason: collision with root package name */
    private List<com.bumptech.glide.load.model.n<File, ?>> f15071f;

    /* renamed from: g, reason: collision with root package name */
    private int f15072g;

    /* renamed from: h, reason: collision with root package name */
    private volatile n.a<?> f15073h;

    /* renamed from: i, reason: collision with root package name */
    private File f15074i;

    c(g<?> gVar, f.a aVar) {
        this(gVar.c(), gVar, aVar);
    }

    c(List<com.bumptech.glide.load.c> list, g<?> gVar, f.a aVar) {
        this.f15069d = -1;
        this.f15066a = list;
        this.f15067b = gVar;
        this.f15068c = aVar;
    }

    private boolean b() {
        return this.f15072g < this.f15071f.size();
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean a() {
        while (true) {
            boolean z5 = false;
            if (this.f15071f != null && b()) {
                this.f15073h = null;
                while (!z5 && b()) {
                    List<com.bumptech.glide.load.model.n<File, ?>> list = this.f15071f;
                    int i6 = this.f15072g;
                    this.f15072g = i6 + 1;
                    this.f15073h = list.get(i6).a(this.f15074i, this.f15067b.s(), this.f15067b.f(), this.f15067b.k());
                    if (this.f15073h != null && this.f15067b.t(this.f15073h.f15458c.a())) {
                        this.f15073h.f15458c.c(this.f15067b.l(), this);
                        z5 = true;
                    }
                }
                return z5;
            }
            int i7 = this.f15069d + 1;
            this.f15069d = i7;
            if (i7 >= this.f15066a.size()) {
                return false;
            }
            com.bumptech.glide.load.c cVar = this.f15066a.get(this.f15069d);
            File b6 = this.f15067b.d().b(new d(cVar, this.f15067b.o()));
            this.f15074i = b6;
            if (b6 != null) {
                this.f15070e = cVar;
                this.f15071f = this.f15067b.j(b6);
                this.f15072g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        n.a<?> aVar = this.f15073h;
        if (aVar != null) {
            aVar.f15458c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void d(Object obj) {
        this.f15068c.d(this.f15070e, obj, this.f15073h.f15458c, DataSource.DATA_DISK_CACHE, this.f15070e);
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void e(@NonNull Exception exc) {
        this.f15068c.b(this.f15070e, exc, this.f15073h.f15458c, DataSource.DATA_DISK_CACHE);
    }
}
