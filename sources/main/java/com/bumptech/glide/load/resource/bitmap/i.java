package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.request.transition.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class i extends com.bumptech.glide.j<i, Bitmap> {
    @NonNull
    public static i o(@NonNull com.bumptech.glide.request.transition.g<Bitmap> gVar) {
        return new i().g(gVar);
    }

    @NonNull
    public static i p() {
        return new i().i();
    }

    @NonNull
    public static i q(int i6) {
        return new i().k(i6);
    }

    @NonNull
    public static i r(@NonNull c.a aVar) {
        return new i().l(aVar);
    }

    @NonNull
    public static i s(@NonNull com.bumptech.glide.request.transition.c cVar) {
        return new i().m(cVar);
    }

    @NonNull
    public static i t(@NonNull com.bumptech.glide.request.transition.g<Drawable> gVar) {
        return new i().n(gVar);
    }

    @NonNull
    public i i() {
        return l(new c.a());
    }

    @NonNull
    public i k(int i6) {
        return l(new c.a(i6));
    }

    @NonNull
    public i n(@NonNull com.bumptech.glide.request.transition.g<Drawable> gVar) {
        return g(new com.bumptech.glide.request.transition.b(gVar));
    }

    @NonNull
    public i l(@NonNull c.a aVar) {
        return n(aVar.a());
    }

    @NonNull
    public i m(@NonNull com.bumptech.glide.request.transition.c cVar) {
        return n(cVar);
    }
}
