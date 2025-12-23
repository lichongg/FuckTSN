package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final List<a<?>> f15847a = new ArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f15848a;

        /* renamed from: b, reason: collision with root package name */
        final h<T> f15849b;

        boolean a(@NonNull Class<?> cls) {
            return this.f15848a.isAssignableFrom(cls);
        }

        a(@NonNull Class<T> cls, @NonNull h<T> hVar) {
            this.f15848a = cls;
            this.f15849b = hVar;
        }
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull h<Z> hVar) {
        this.f15847a.add(new a<>(cls, hVar));
    }

    @Nullable
    public synchronized <Z> h<Z> b(@NonNull Class<Z> cls) {
        int size = this.f15847a.size();
        for (int i6 = 0; i6 < size; i6++) {
            a<?> aVar = this.f15847a.get(i6);
            if (aVar.a(cls)) {
                return (h<Z>) aVar.f15849b;
            }
        }
        return null;
    }

    public synchronized <Z> void c(@NonNull Class<Z> cls, @NonNull h<Z> hVar) {
        this.f15847a.add(0, new a<>(cls, hVar));
    }
}
