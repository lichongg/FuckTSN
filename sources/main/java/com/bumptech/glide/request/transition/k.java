package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.request.transition.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class k<R> implements f<R> {

    /* renamed from: a, reason: collision with root package name */
    private final a f16297a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface a {
        Animation a(Context context);
    }

    k(a aVar) {
        this.f16297a = aVar;
    }

    @Override // com.bumptech.glide.request.transition.f
    public boolean a(R r5, f.a aVar) {
        View view = aVar.getView();
        if (view != null) {
            view.clearAnimation();
            view.startAnimation(this.f16297a.a(view.getContext()));
            return false;
        }
        return false;
    }
}
