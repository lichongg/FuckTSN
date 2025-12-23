package com.bumptech.glide.load.resource.transcode;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final List<a<?, ?>> f15777a = new ArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a<Z, R> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<Z> f15778a;

        /* renamed from: b, reason: collision with root package name */
        private final Class<R> f15779b;

        /* renamed from: c, reason: collision with root package name */
        final e<Z, R> f15780c;

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f15778a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f15779b);
        }

        a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
            this.f15778a = cls;
            this.f15779b = cls2;
            this.f15780c = eVar;
        }
    }

    @NonNull
    public synchronized <Z, R> e<Z, R> a(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.b();
        }
        for (a<?, ?> aVar : this.f15777a) {
            if (aVar.a(cls, cls2)) {
                return (e<Z, R>) aVar.f15780c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> b(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        Iterator<a<?, ?>> it = this.f15777a.iterator();
        while (it.hasNext()) {
            if (it.next().a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void c(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
        this.f15777a.add(new a<>(cls, cls2, eVar));
    }
}
