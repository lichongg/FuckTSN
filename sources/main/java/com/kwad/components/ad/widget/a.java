package com.kwad.components.ad.widget;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class a implements ValueAnimator.AnimatorUpdateListener {
    private WeakReference<View> Mt;

    public abstract void a(ViewGroup.LayoutParams layoutParams, Object obj);

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        WeakReference<View> weakReference = this.Mt;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = this.Mt.get();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        a(layoutParams, valueAnimator.getAnimatedValue());
        view.setLayoutParams(layoutParams);
    }

    public a(View view) {
        this.Mt = new WeakReference<>(view);
    }
}
