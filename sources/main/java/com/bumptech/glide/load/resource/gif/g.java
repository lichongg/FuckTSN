package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.u;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class g implements com.bumptech.glide.load.g<GifDecoder, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f15752a;

    @Override // com.bumptech.glide.load.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull GifDecoder gifDecoder, @NonNull com.bumptech.glide.load.f fVar) {
        return true;
    }

    public g(com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        this.f15752a = eVar;
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public u<Bitmap> b(@NonNull GifDecoder gifDecoder, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        return com.bumptech.glide.load.resource.bitmap.g.c(gifDecoder.h(), this.f15752a);
    }
}
