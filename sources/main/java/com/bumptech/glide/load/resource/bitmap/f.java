package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 28)
/* loaded from: D:\Downloads\app\classes3.dex */
public final class f extends com.bumptech.glide.load.resource.k<Bitmap> {

    /* renamed from: d, reason: collision with root package name */
    private static final String f15601d = "BitmapImageDecoder";

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f15602c = new com.bumptech.glide.load.engine.bitmap_recycle.f();

    @Override // com.bumptech.glide.load.resource.k
    protected com.bumptech.glide.load.engine.u<Bitmap> c(ImageDecoder.Source source, int i6, int i7, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        Bitmap decodeBitmap;
        decodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable(f15601d, 2)) {
            decodeBitmap.getWidth();
            decodeBitmap.getHeight();
        }
        return new g(decodeBitmap, this.f15602c);
    }
}
