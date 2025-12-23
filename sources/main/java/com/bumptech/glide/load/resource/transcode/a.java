package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;
import java.io.ByteArrayOutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a implements e<Bitmap, byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final Bitmap.CompressFormat f15771a;

    /* renamed from: b, reason: collision with root package name */
    private final int f15772b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    public a(@NonNull Bitmap.CompressFormat compressFormat, int i6) {
        this.f15771a = compressFormat;
        this.f15772b = i6;
    }

    @Override // com.bumptech.glide.load.resource.transcode.e
    @Nullable
    public u<byte[]> a(@NonNull u<Bitmap> uVar, @NonNull com.bumptech.glide.load.f fVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        uVar.get().compress(this.f15771a, this.f15772b, byteArrayOutputStream);
        uVar.recycle();
        return new v.b(byteArrayOutputStream.toByteArray());
    }
}
