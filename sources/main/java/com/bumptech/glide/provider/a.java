package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final List<C0167a<?>> f15833a = new ArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bumptech.glide.provider.a$a, reason: collision with other inner class name */
    private static final class C0167a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f15834a;

        /* renamed from: b, reason: collision with root package name */
        final com.bumptech.glide.load.a<T> f15835b;

        boolean a(@NonNull Class<?> cls) {
            return this.f15834a.isAssignableFrom(cls);
        }

        C0167a(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.a<T> aVar) {
            this.f15834a = cls;
            this.f15835b = aVar;
        }
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.a<T> aVar) {
        this.f15833a.add(new C0167a<>(cls, aVar));
    }

    @Nullable
    public synchronized <T> com.bumptech.glide.load.a<T> b(@NonNull Class<T> cls) {
        for (C0167a<?> c0167a : this.f15833a) {
            if (c0167a.a(cls)) {
                return (com.bumptech.glide.load.a<T>) c0167a.f15835b;
            }
        }
        return null;
    }

    public synchronized <T> void c(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.a<T> aVar) {
        this.f15833a.add(0, new C0167a<>(cls, aVar));
    }
}
