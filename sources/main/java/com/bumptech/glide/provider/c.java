package com.bumptech.glide.provider;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.resource.transcode.g;
import com.bumptech.glide.util.j;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static final s<?, ?, ?> f15837c = new s<>(Object.class, Object.class, Object.class, Collections.singletonList(new i(Object.class, Object.class, Object.class, Collections.EMPTY_LIST, new g(), null)), null);

    /* renamed from: a, reason: collision with root package name */
    private final ArrayMap<j, s<?, ?, ?>> f15838a = new ArrayMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference<j> f15839b = new AtomicReference<>();

    private j b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        j andSet = this.f15839b.getAndSet(null);
        if (andSet == null) {
            andSet = new j();
        }
        andSet.b(cls, cls2, cls3);
        return andSet;
    }

    public boolean c(@Nullable s<?, ?, ?> sVar) {
        return f15837c.equals(sVar);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable s<?, ?, ?> sVar) {
        synchronized (this.f15838a) {
            ArrayMap<j, s<?, ?, ?>> arrayMap = this.f15838a;
            j jVar = new j(cls, cls2, cls3);
            if (sVar == null) {
                sVar = f15837c;
            }
            arrayMap.put(jVar, sVar);
        }
    }

    @Nullable
    public <Data, TResource, Transcode> s<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        s<Data, TResource, Transcode> sVar;
        j b6 = b(cls, cls2, cls3);
        synchronized (this.f15838a) {
            sVar = (s) this.f15838a.get(b6);
        }
        this.f15839b.set(b6);
        return sVar;
    }
}
