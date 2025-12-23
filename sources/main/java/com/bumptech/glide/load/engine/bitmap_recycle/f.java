package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class f implements e {
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public long getMaxSize() {
        return 0L;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public void d(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    @NonNull
    public Bitmap e(int i6, int i7, Bitmap.Config config) {
        return Bitmap.createBitmap(i6, i7, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    @NonNull
    public Bitmap f(int i6, int i7, Bitmap.Config config) {
        return e(i6, i7, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public void a(int i6) {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public void b() {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public void c(float f6) {
    }
}
