package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class q<T> extends j<T> {
    public q(ImageView imageView) {
        super(imageView);
    }

    protected abstract Drawable w(T t5);

    @Deprecated
    public q(ImageView imageView, boolean z5) {
        super(imageView, z5);
    }

    @Override // com.bumptech.glide.request.target.j
    protected void u(@Nullable T t5) {
        ViewGroup.LayoutParams layoutParams = ((ImageView) this.f16264b).getLayoutParams();
        Drawable w5 = w(t5);
        if (layoutParams != null && layoutParams.width > 0 && layoutParams.height > 0) {
            w5 = new i(w5, layoutParams.width, layoutParams.height);
        }
        ((ImageView) this.f16264b).setImageDrawable(w5);
    }
}
