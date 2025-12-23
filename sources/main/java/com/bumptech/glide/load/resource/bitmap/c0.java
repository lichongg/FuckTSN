package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 28)
/* loaded from: D:\Downloads\app\classes3.dex */
public final class c0 implements com.bumptech.glide.load.g<InputStream, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final f f15592a = new f();

    @Override // com.bumptech.glide.load.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return true;
    }

    @Override // com.bumptech.glide.load.g
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.u<Bitmap> b(@NonNull InputStream inputStream, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        ImageDecoder.Source createSource;
        createSource = ImageDecoder.createSource(com.bumptech.glide.util.a.b(inputStream));
        return this.f15592a.d(createSource, i6, i7, fVar);
    }
}
