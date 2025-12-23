package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.j;
import com.bumptech.glide.request.transition.c;
import com.bumptech.glide.request.transition.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class c extends j<c, Drawable> {
    @NonNull
    public static c n(@NonNull g<Drawable> gVar) {
        return new c().g(gVar);
    }

    @NonNull
    public static c o() {
        return new c().i();
    }

    @NonNull
    public static c p(int i6) {
        return new c().k(i6);
    }

    @NonNull
    public static c q(@NonNull c.a aVar) {
        return new c().l(aVar);
    }

    @NonNull
    public static c r(@NonNull com.bumptech.glide.request.transition.c cVar) {
        return new c().m(cVar);
    }

    @NonNull
    public c i() {
        return l(new c.a());
    }

    @NonNull
    public c k(int i6) {
        return l(new c.a(i6));
    }

    @NonNull
    public c l(@NonNull c.a aVar) {
        return m(aVar.a());
    }

    @NonNull
    public c m(@NonNull com.bumptech.glide.request.transition.c cVar) {
        return g(cVar);
    }
}
