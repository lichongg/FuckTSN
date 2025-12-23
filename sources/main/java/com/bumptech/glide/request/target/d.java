package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class d extends q<Bitmap> {
    public d(ImageView imageView) {
        super(imageView);
    }

    @Deprecated
    public d(ImageView imageView, boolean z5) {
        super(imageView, z5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.q
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public Drawable w(Bitmap bitmap) {
        return new BitmapDrawable(((ImageView) this.f16264b).getResources(), bitmap);
    }
}
