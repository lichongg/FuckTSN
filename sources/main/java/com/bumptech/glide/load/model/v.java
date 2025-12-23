package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.model.n;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class v<Model> implements n<Model, Model> {

    /* renamed from: a, reason: collision with root package name */
    private static final v<?> f15518a = new v<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a<Model> implements o<Model, Model> {

        /* renamed from: a, reason: collision with root package name */
        private static final a<?> f15519a = new a<>();

        public static <T> a<T> a() {
            return (a<T>) f15519a;
        }

        @Deprecated
        public a() {
        }

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<Model, Model> c(r rVar) {
            return v.c();
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b<Model> implements com.bumptech.glide.load.data.d<Model> {

        /* renamed from: a, reason: collision with root package name */
        private final Model f15520a;

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Model> a() {
            return (Class<Model>) this.f15520a.getClass();
        }

        @Override // com.bumptech.glide.load.data.d
        public void c(@NonNull Priority priority, @NonNull d.a<? super Model> aVar) {
            aVar.d(this.f15520a);
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        b(Model model) {
            this.f15520a = model;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }

    @Override // com.bumptech.glide.load.model.n
    public boolean b(@NonNull Model model) {
        return true;
    }

    public static <T> v<T> c() {
        return (v<T>) f15518a;
    }

    @Override // com.bumptech.glide.load.model.n
    public n.a<Model> a(@NonNull Model model, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.signature.e(model), new b(model));
    }

    @Deprecated
    public v() {
    }
}
