package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface n<Model, Data> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a<Data> {

        /* renamed from: a, reason: collision with root package name */
        public final com.bumptech.glide.load.c f15456a;

        /* renamed from: b, reason: collision with root package name */
        public final List<com.bumptech.glide.load.c> f15457b;

        /* renamed from: c, reason: collision with root package name */
        public final com.bumptech.glide.load.data.d<Data> f15458c;

        public a(@NonNull com.bumptech.glide.load.c cVar, @NonNull com.bumptech.glide.load.data.d<Data> dVar) {
            this(cVar, Collections.EMPTY_LIST, dVar);
        }

        public a(@NonNull com.bumptech.glide.load.c cVar, @NonNull List<com.bumptech.glide.load.c> list, @NonNull com.bumptech.glide.load.data.d<Data> dVar) {
            this.f15456a = (com.bumptech.glide.load.c) com.bumptech.glide.util.k.d(cVar);
            this.f15457b = (List) com.bumptech.glide.util.k.d(list);
            this.f15458c = (com.bumptech.glide.load.data.d) com.bumptech.glide.util.k.d(dVar);
        }
    }

    @Nullable
    a<Data> a(@NonNull Model model, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar);

    boolean b(@NonNull Model model);
}
