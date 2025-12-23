package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.model.n;
import com.bumptech.glide.load.model.o;
import com.bumptech.glide.load.model.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class Registry {

    /* renamed from: k, reason: collision with root package name */
    public static final String f14550k = "Gif";

    /* renamed from: l, reason: collision with root package name */
    public static final String f14551l = "Bitmap";

    /* renamed from: m, reason: collision with root package name */
    public static final String f14552m = "BitmapDrawable";

    /* renamed from: n, reason: collision with root package name */
    private static final String f14553n = "legacy_prepend_all";

    /* renamed from: o, reason: collision with root package name */
    private static final String f14554o = "legacy_append";

    /* renamed from: a, reason: collision with root package name */
    private final p f14555a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.provider.a f14556b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.provider.e f14557c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.provider.f f14558d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.data.f f14559e;

    /* renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.load.resource.transcode.f f14560f;

    /* renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.provider.b f14561g;

    /* renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.provider.d f14562h = new com.bumptech.glide.provider.d();

    /* renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.provider.c f14563i = new com.bumptech.glide.provider.c();

    /* renamed from: j, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f14564j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(@NonNull Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(@NonNull M m6, @NonNull List<n<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m6);
        }

        public NoModelLoaderAvailableException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(@NonNull String str) {
            super(str);
        }
    }

    @NonNull
    private <Data, TResource, Transcode> List<com.bumptech.glide.load.engine.i<Data, TResource, Transcode>> f(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f14557c.d(cls, cls2)) {
            for (Class cls5 : this.f14560f.b(cls4, cls3)) {
                arrayList.add(new com.bumptech.glide.load.engine.i(cls, cls4, cls5, this.f14557c.b(cls, cls4), this.f14560f.a(cls4, cls5), this.f14564j));
            }
        }
        return arrayList;
    }

    @NonNull
    public <Data> Registry a(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.a<Data> aVar) {
        this.f14556b.a(cls, aVar);
        return this;
    }

    @NonNull
    public <TResource> Registry b(@NonNull Class<TResource> cls, @NonNull com.bumptech.glide.load.h<TResource> hVar) {
        this.f14558d.a(cls, hVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry c(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.bumptech.glide.load.g<Data, TResource> gVar) {
        e(f14554o, cls, cls2, gVar);
        return this;
    }

    @NonNull
    public <Model, Data> Registry d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<Model, Data> oVar) {
        this.f14555a.a(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry e(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.bumptech.glide.load.g<Data, TResource> gVar) {
        this.f14557c.a(str, gVar, cls, cls2);
        return this;
    }

    @NonNull
    public List<ImageHeaderParser> g() {
        List<ImageHeaderParser> b6 = this.f14561g.b();
        if (b6.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return b6;
    }

    @Nullable
    public <Data, TResource, Transcode> s<Data, TResource, Transcode> h(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        Class<Data> cls4;
        Class<TResource> cls5;
        Class<Transcode> cls6;
        s<Data, TResource, Transcode> a6 = this.f14563i.a(cls, cls2, cls3);
        s<Data, TResource, Transcode> sVar = null;
        if (this.f14563i.c(a6)) {
            return null;
        }
        if (a6 != null) {
            return a6;
        }
        List<com.bumptech.glide.load.engine.i<Data, TResource, Transcode>> f6 = f(cls, cls2, cls3);
        if (f6.isEmpty()) {
            cls4 = cls;
            cls5 = cls2;
            cls6 = cls3;
        } else {
            cls4 = cls;
            cls5 = cls2;
            cls6 = cls3;
            sVar = new s<>(cls4, cls5, cls6, f6, this.f14564j);
        }
        this.f14563i.d(cls4, cls5, cls6, sVar);
        return sVar;
    }

    @NonNull
    public <Model> List<n<Model, ?>> i(@NonNull Model model) {
        return this.f14555a.e(model);
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> j(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> b6 = this.f14562h.b(cls, cls2, cls3);
        if (b6 == null) {
            b6 = new ArrayList<>();
            Iterator<Class<?>> it = this.f14555a.d(cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.f14557c.d(it.next(), cls2)) {
                    if (!this.f14560f.b(cls4, cls3).isEmpty() && !b6.contains(cls4)) {
                        b6.add(cls4);
                    }
                }
            }
            this.f14562h.c(cls, cls2, cls3, Collections.unmodifiableList(b6));
        }
        return b6;
    }

    @NonNull
    public <X> com.bumptech.glide.load.h<X> k(@NonNull u<X> uVar) throws NoResultEncoderAvailableException {
        com.bumptech.glide.load.h<X> b6 = this.f14558d.b(uVar.a());
        if (b6 != null) {
            return b6;
        }
        throw new NoResultEncoderAvailableException(uVar.a());
    }

    @NonNull
    public <X> com.bumptech.glide.load.data.e<X> l(@NonNull X x5) {
        return this.f14559e.a(x5);
    }

    @NonNull
    public <X> com.bumptech.glide.load.a<X> m(@NonNull X x5) throws NoSourceEncoderAvailableException {
        com.bumptech.glide.load.a<X> b6 = this.f14556b.b(x5.getClass());
        if (b6 != null) {
            return b6;
        }
        throw new NoSourceEncoderAvailableException(x5.getClass());
    }

    public boolean n(@NonNull u<?> uVar) {
        return this.f14558d.b(uVar.a()) != null;
    }

    @NonNull
    public <Data> Registry o(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.a<Data> aVar) {
        this.f14556b.c(cls, aVar);
        return this;
    }

    @NonNull
    public <TResource> Registry p(@NonNull Class<TResource> cls, @NonNull com.bumptech.glide.load.h<TResource> hVar) {
        this.f14558d.c(cls, hVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry q(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.bumptech.glide.load.g<Data, TResource> gVar) {
        s(f14553n, cls, cls2, gVar);
        return this;
    }

    @NonNull
    public <Model, Data> Registry r(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<Model, Data> oVar) {
        this.f14555a.g(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry s(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.bumptech.glide.load.g<Data, TResource> gVar) {
        this.f14557c.e(str, gVar, cls, cls2);
        return this;
    }

    @NonNull
    public Registry t(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f14561g.a(imageHeaderParser);
        return this;
    }

    @NonNull
    public Registry u(@NonNull e.a<?> aVar) {
        this.f14559e.b(aVar);
        return this;
    }

    @NonNull
    public <TResource, Transcode> Registry x(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull com.bumptech.glide.load.resource.transcode.e<TResource, Transcode> eVar) {
        this.f14560f.c(cls, cls2, eVar);
        return this;
    }

    @NonNull
    public <Model, Data> Registry y(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.f14555a.i(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public final Registry z(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add(f14553n);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        arrayList.add(f14554o);
        this.f14557c.f(arrayList);
        return this;
    }

    public Registry() {
        Pools.Pool<List<Throwable>> f6 = com.bumptech.glide.util.pool.a.f();
        this.f14564j = f6;
        this.f14555a = new p(f6);
        this.f14556b = new com.bumptech.glide.provider.a();
        this.f14557c = new com.bumptech.glide.provider.e();
        this.f14558d = new com.bumptech.glide.provider.f();
        this.f14559e = new com.bumptech.glide.load.data.f();
        this.f14560f = new com.bumptech.glide.load.resource.transcode.f();
        this.f14561g = new com.bumptech.glide.provider.b();
        z(Arrays.asList(f14550k, f14551l, f14552m));
    }

    @NonNull
    @Deprecated
    public <Data> Registry v(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.a<Data> aVar) {
        return a(cls, aVar);
    }

    @NonNull
    @Deprecated
    public <TResource> Registry w(@NonNull Class<TResource> cls, @NonNull com.bumptech.glide.load.h<TResource> hVar) {
        return b(cls, hVar);
    }
}
