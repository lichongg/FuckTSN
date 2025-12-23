package com.bumptech.glide;

import androidx.annotation.NonNull;
import com.bumptech.glide.j;
import com.bumptech.glide.request.transition.j;
import com.bumptech.glide.util.k;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j<CHILD extends j<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private com.bumptech.glide.request.transition.g<? super TranscodeType> f14907a = com.bumptech.glide.request.transition.e.c();

    final com.bumptech.glide.request.transition.g<? super TranscodeType> c() {
        return this.f14907a;
    }

    @NonNull
    public final CHILD f(int i6) {
        return g(new com.bumptech.glide.request.transition.h(i6));
    }

    @NonNull
    public final CHILD h(@NonNull j.a aVar) {
        return g(new com.bumptech.glide.request.transition.i(aVar));
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e6) {
            throw new RuntimeException(e6);
        }
    }

    @NonNull
    public final CHILD b() {
        return g(com.bumptech.glide.request.transition.e.c());
    }

    @NonNull
    public final CHILD g(@NonNull com.bumptech.glide.request.transition.g<? super TranscodeType> gVar) {
        this.f14907a = (com.bumptech.glide.request.transition.g) k.d(gVar);
        return e();
    }

    private CHILD e() {
        return this;
    }
}
