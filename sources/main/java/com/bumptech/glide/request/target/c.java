package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c extends j<Bitmap> {
    public c(ImageView imageView) {
        super(imageView);
    }

    @Deprecated
    public c(ImageView imageView, boolean z5) {
        super(imageView, z5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.j
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void u(Bitmap bitmap) {
        ((ImageView) this.f16264b).setImageBitmap(bitmap);
    }
}
