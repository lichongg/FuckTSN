package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class s<Data, ResourceType, Transcode> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<Data> f15354a;

    /* renamed from: b, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f15355b;

    /* renamed from: c, reason: collision with root package name */
    private final List<? extends i<Data, ResourceType, Transcode>> f15356c;

    /* renamed from: d, reason: collision with root package name */
    private final String f15357d;

    private u<Transcode> c(com.bumptech.glide.load.data.e<Data> eVar, @NonNull com.bumptech.glide.load.f fVar, int i6, int i7, i.a<ResourceType> aVar, List<Throwable> list) throws GlideException {
        int size = this.f15356c.size();
        u<Transcode> uVar = null;
        for (int i8 = 0; i8 < size; i8++) {
            try {
                uVar = this.f15356c.get(i8).a(eVar, i6, i7, fVar, aVar);
            } catch (GlideException e6) {
                list.add(e6);
            }
            if (uVar != null) {
                break;
            }
        }
        if (uVar != null) {
            return uVar;
        }
        throw new GlideException(this.f15357d, new ArrayList(list));
    }

    public Class<Data> a() {
        return this.f15354a;
    }

    public u<Transcode> b(com.bumptech.glide.load.data.e<Data> eVar, @NonNull com.bumptech.glide.load.f fVar, int i6, int i7, i.a<ResourceType> aVar) throws GlideException {
        List<Throwable> list = (List) com.bumptech.glide.util.k.d(this.f15355b.acquire());
        try {
            return c(eVar, fVar, i6, i7, aVar, list);
        } finally {
            this.f15355b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f15356c.toArray()) + '}';
    }

    public s(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<i<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f15354a = cls;
        this.f15355b = pool;
        this.f15356c = (List) com.bumptech.glide.util.k.c(list);
        this.f15357d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }
}
