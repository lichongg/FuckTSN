package com.bumptech.glide.load.model.stream;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.n;
import com.bumptech.glide.load.model.o;
import com.bumptech.glide.load.model.r;
import java.io.InputStream;
import java.net.URL;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class i implements n<URL, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final n<com.bumptech.glide.load.model.g, InputStream> f15514a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements o<URL, InputStream> {
        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<URL, InputStream> c(r rVar) {
            return new i(rVar.d(com.bumptech.glide.load.model.g.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@NonNull URL url) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> a(@NonNull URL url, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        return this.f15514a.a(new com.bumptech.glide.load.model.g(url), i6, i7, fVar);
    }

    public i(n<com.bumptech.glide.load.model.g, InputStream> nVar) {
        this.f15514a = nVar;
    }
}
