package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface e {
    void a(int i6);

    void b();

    void c(float f6);

    void d(Bitmap bitmap);

    @NonNull
    Bitmap e(int i6, int i7, Bitmap.Config config);

    @NonNull
    Bitmap f(int i6, int i7, Bitmap.Config config);

    long getMaxSize();
}
