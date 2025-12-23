package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class g extends j<Drawable> {
    public g(ImageView imageView) {
        super(imageView);
    }

    @Deprecated
    public g(ImageView imageView, boolean z5) {
        super(imageView, z5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.j
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void u(@Nullable Drawable drawable) {
        ((ImageView) this.f16264b).setImageDrawable(drawable);
    }
}
