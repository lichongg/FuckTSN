package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class q<Model, Data> implements n<Model, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final List<n<Model, Data>> f15463a;

    /* renamed from: b, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f15464b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a<Data> implements com.bumptech.glide.load.data.d<Data>, d.a<Data> {

        /* renamed from: a, reason: collision with root package name */
        private final List<com.bumptech.glide.load.data.d<Data>> f15465a;

        /* renamed from: b, reason: collision with root package name */
        private final Pools.Pool<List<Throwable>> f15466b;

        /* renamed from: c, reason: collision with root package name */
        private int f15467c;

        /* renamed from: d, reason: collision with root package name */
        private Priority f15468d;

        /* renamed from: e, reason: collision with root package name */
        private d.a<? super Data> f15469e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        private List<Throwable> f15470f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f15471g;

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.f15471g = true;
            Iterator<com.bumptech.glide.load.data.d<Data>> it = this.f15465a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        private void f() {
            if (this.f15471g) {
                return;
            }
            if (this.f15467c < this.f15465a.size() - 1) {
                this.f15467c++;
                c(this.f15468d, this.f15469e);
            } else {
                com.bumptech.glide.util.k.d(this.f15470f);
                this.f15469e.e(new GlideException("Fetch failed", new ArrayList(this.f15470f)));
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Data> a() {
            return this.f15465a.get(0).a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            List<Throwable> list = this.f15470f;
            if (list != null) {
                this.f15466b.release(list);
            }
            this.f15470f = null;
            Iterator<com.bumptech.glide.load.data.d<Data>> it = this.f15465a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void c(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            this.f15468d = priority;
            this.f15469e = aVar;
            this.f15470f = this.f15466b.acquire();
            this.f15465a.get(this.f15467c).c(priority, this);
            if (this.f15471g) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void d(@Nullable Data data) {
            if (data != null) {
                this.f15469e.d(data);
            } else {
                f();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void e(@NonNull Exception exc) {
            ((List) com.bumptech.glide.util.k.d(this.f15470f)).add(exc);
            f();
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource getDataSource() {
            return this.f15465a.get(0).getDataSource();
        }

        a(@NonNull List<com.bumptech.glide.load.data.d<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.f15466b = pool;
            com.bumptech.glide.util.k.c(list);
            this.f15465a = list;
            this.f15467c = 0;
        }
    }

    @Override // com.bumptech.glide.load.model.n
    public n.a<Data> a(@NonNull Model model, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        n.a<Data> a6;
        int size = this.f15463a.size();
        ArrayList arrayList = new ArrayList(size);
        com.bumptech.glide.load.c cVar = null;
        for (int i8 = 0; i8 < size; i8++) {
            n<Model, Data> nVar = this.f15463a.get(i8);
            if (nVar.b(model) && (a6 = nVar.a(model, i6, i7, fVar)) != null) {
                cVar = a6.f15456a;
                arrayList.add(a6.f15458c);
            }
        }
        if (arrayList.isEmpty() || cVar == null) {
            return null;
        }
        return new n.a<>(cVar, new a(arrayList, this.f15464b));
    }

    @Override // com.bumptech.glide.load.model.n
    public boolean b(@NonNull Model model) {
        Iterator<n<Model, Data>> it = this.f15463a.iterator();
        while (it.hasNext()) {
            if (it.next().b(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f15463a.toArray()) + '}';
    }

    q(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.f15463a = list;
        this.f15464b = pool;
    }
}
