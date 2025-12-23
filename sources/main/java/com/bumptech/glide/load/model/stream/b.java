package com.bumptech.glide.load.model.stream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.data.j;
import com.bumptech.glide.load.model.m;
import com.bumptech.glide.load.model.n;
import com.bumptech.glide.load.model.o;
import com.bumptech.glide.load.model.r;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b implements n<com.bumptech.glide.load.model.g, InputStream> {

    /* renamed from: b, reason: collision with root package name */
    public static final com.bumptech.glide.load.e<Integer> f15490b = com.bumptech.glide.load.e.g("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final m<com.bumptech.glide.load.model.g, com.bumptech.glide.load.model.g> f15491a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements o<com.bumptech.glide.load.model.g, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final m<com.bumptech.glide.load.model.g, com.bumptech.glide.load.model.g> f15492a = new m<>(500);

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<com.bumptech.glide.load.model.g, InputStream> c(r rVar) {
            return new b(this.f15492a);
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    public b() {
        this(null);
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@NonNull com.bumptech.glide.load.model.g gVar) {
        return true;
    }

    public b(@Nullable m<com.bumptech.glide.load.model.g, com.bumptech.glide.load.model.g> mVar) {
        this.f15491a = mVar;
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> a(@NonNull com.bumptech.glide.load.model.g gVar, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        m<com.bumptech.glide.load.model.g, com.bumptech.glide.load.model.g> mVar = this.f15491a;
        if (mVar != null) {
            com.bumptech.glide.load.model.g b6 = mVar.b(gVar, 0, 0);
            if (b6 == null) {
                this.f15491a.c(gVar, 0, 0, gVar);
            } else {
                gVar = b6;
            }
        }
        return new n.a<>(gVar, new j(gVar, ((Integer) fVar.c(f15490b)).intValue()));
    }
}
