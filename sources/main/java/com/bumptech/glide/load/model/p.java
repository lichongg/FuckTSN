package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private final r f15459a;

    /* renamed from: b, reason: collision with root package name */
    private final a f15460b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Map<Class<?>, C0164a<?>> f15461a = new HashMap();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bumptech.glide.load.model.p$a$a, reason: collision with other inner class name */
        private static class C0164a<Model> {

            /* renamed from: a, reason: collision with root package name */
            final List<n<Model, ?>> f15462a;

            public C0164a(List<n<Model, ?>> list) {
                this.f15462a = list;
            }
        }

        public void a() {
            this.f15461a.clear();
        }

        @Nullable
        public <Model> List<n<Model, ?>> b(Class<Model> cls) {
            C0164a<?> c0164a = this.f15461a.get(cls);
            if (c0164a == null) {
                return null;
            }
            return (List<n<Model, ?>>) c0164a.f15462a;
        }

        public <Model> void c(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.f15461a.put(cls, new C0164a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }

        a() {
        }
    }

    public p(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new r(pool));
    }

    @NonNull
    private synchronized <A> List<n<A, ?>> f(@NonNull Class<A> cls) {
        List<n<A, ?>> b6;
        b6 = this.f15460b.b(cls);
        if (b6 == null) {
            b6 = Collections.unmodifiableList(this.f15459a.e(cls));
            this.f15460b.c(cls, b6);
        }
        return b6;
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.f15459a.b(cls, cls2, oVar);
        this.f15460b.a();
    }

    public synchronized <Model, Data> n<Model, Data> b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        return this.f15459a.d(cls, cls2);
    }

    @NonNull
    public synchronized List<Class<?>> d(@NonNull Class<?> cls) {
        return this.f15459a.g(cls);
    }

    public synchronized <Model, Data> void g(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.f15459a.i(cls, cls2, oVar);
        this.f15460b.a();
    }

    public synchronized <Model, Data> void h(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        j(this.f15459a.j(cls, cls2));
        this.f15460b.a();
    }

    public synchronized <Model, Data> void i(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        j(this.f15459a.k(cls, cls2, oVar));
        this.f15460b.a();
    }

    private p(@NonNull r rVar) {
        this.f15460b = new a();
        this.f15459a = rVar;
    }

    @NonNull
    private static <A> Class<A> c(@NonNull A a6) {
        return (Class<A>) a6.getClass();
    }

    private <Model, Data> void j(@NonNull List<o<? extends Model, ? extends Data>> list) {
        Iterator<o<? extends Model, ? extends Data>> it = list.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    @NonNull
    public <A> List<n<A, ?>> e(@NonNull A a6) {
        List<n<A, ?>> f6 = f(c(a6));
        if (!f6.isEmpty()) {
            int size = f6.size();
            List<n<A, ?>> list = Collections.EMPTY_LIST;
            boolean z5 = true;
            for (int i6 = 0; i6 < size; i6++) {
                n<A, ?> nVar = f6.get(i6);
                if (nVar.b(a6)) {
                    if (z5) {
                        list = new ArrayList<>(size - i6);
                        z5 = false;
                    }
                    list.add(nVar);
                }
            }
            if (!list.isEmpty()) {
                return list;
            }
            throw new Registry.NoModelLoaderAvailableException(a6, f6);
        }
        throw new Registry.NoModelLoaderAvailableException(a6);
    }
}
