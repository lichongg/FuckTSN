package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.util.j;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<j> f15840a = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    private final ArrayMap<j, List<Class<?>>> f15841b = new ArrayMap<>();

    public void a() {
        synchronized (this.f15841b) {
            this.f15841b.clear();
        }
    }

    @Nullable
    public List<Class<?>> b(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        List<Class<?>> list;
        j andSet = this.f15840a.getAndSet(null);
        if (andSet == null) {
            andSet = new j(cls, cls2, cls3);
        } else {
            andSet.b(cls, cls2, cls3);
        }
        synchronized (this.f15841b) {
            list = this.f15841b.get(andSet);
        }
        this.f15840a.set(andSet);
        return list;
    }

    public void c(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        synchronized (this.f15841b) {
            this.f15841b.put(new j(cls, cls2, cls3), list);
        }
    }
}
