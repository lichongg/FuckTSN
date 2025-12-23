package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.request.transition.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class d implements f<Drawable> {

    /* renamed from: a, reason: collision with root package name */
    private final int f16286a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f16287b;

    public d(int i6, boolean z5) {
        this.f16286a = i6;
        this.f16287b = z5;
    }

    @Override // com.bumptech.glide.request.transition.f
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(Drawable drawable, f.a aVar) {
        Drawable a6 = aVar.a();
        if (a6 == null) {
            a6 = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{a6, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f16287b);
        transitionDrawable.startTransition(this.f16286a);
        aVar.c(transitionDrawable);
        return true;
    }
}
