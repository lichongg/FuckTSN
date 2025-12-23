package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
interface m {
    String a(int i6, int i7, Bitmap.Config config);

    int b(Bitmap bitmap);

    String c(Bitmap bitmap);

    void d(Bitmap bitmap);

    @Nullable
    Bitmap e(int i6, int i7, Bitmap.Config config);

    @Nullable
    Bitmap removeLast();
}
