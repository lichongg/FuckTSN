package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class i<DataType, ResourceType, Transcode> {

    /* renamed from: f, reason: collision with root package name */
    private static final String f15233f = "DecodePath";

    /* renamed from: a, reason: collision with root package name */
    private final Class<DataType> f15234a;

    /* renamed from: b, reason: collision with root package name */
    private final List<? extends com.bumptech.glide.load.g<DataType, ResourceType>> f15235b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.resource.transcode.e<ResourceType, Transcode> f15236c;

    /* renamed from: d, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f15237d;

    /* renamed from: e, reason: collision with root package name */
    private final String f15238e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface a<ResourceType> {
        @NonNull
        u<ResourceType> a(@NonNull u<ResourceType> uVar);
    }

    @NonNull
    private u<ResourceType> b(com.bumptech.glide.load.data.e<DataType> eVar, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) throws GlideException {
        List<Throwable> list = (List) com.bumptech.glide.util.k.d(this.f15237d.acquire());
        try {
            return c(eVar, i6, i7, fVar, list);
        } finally {
            this.f15237d.release(list);
        }
    }

    @NonNull
    private u<ResourceType> c(com.bumptech.glide.load.data.e<DataType> eVar, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar, List<Throwable> list) throws GlideException {
        int size = this.f15235b.size();
        u<ResourceType> uVar = null;
        for (int i8 = 0; i8 < size; i8++) {
            com.bumptech.glide.load.g<DataType, ResourceType> gVar = this.f15235b.get(i8);
            try {
                if (gVar.a(eVar.a(), fVar)) {
                    uVar = gVar.b(eVar.a(), i6, i7, fVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e6) {
                if (Log.isLoggable(f15233f, 2)) {
                    Objects.toString(gVar);
                }
                list.add(e6);
            }
            if (uVar != null) {
                break;
            }
        }
        if (uVar != null) {
            return uVar;
        }
        throw new GlideException(this.f15238e, new ArrayList(list));
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f15234a + ", decoders=" + this.f15235b + ", transcoder=" + this.f15236c + '}';
    }

    public i(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.bumptech.glide.load.g<DataType, ResourceType>> list, com.bumptech.glide.load.resource.transcode.e<ResourceType, Transcode> eVar, Pools.Pool<List<Throwable>> pool) {
        this.f15234a = cls;
        this.f15235b = list;
        this.f15236c = eVar;
        this.f15237d = pool;
        this.f15238e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public u<Transcode> a(com.bumptech.glide.load.data.e<DataType> eVar, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar, a<ResourceType> aVar) throws GlideException {
        return this.f15236c.a(aVar.a(b(eVar, i6, i7, fVar)), fVar);
    }
}
