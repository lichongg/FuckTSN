package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes3.dex */
public final class e0 implements com.bumptech.glide.load.g<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final u f15600a;

    @Override // com.bumptech.glide.load.g
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.u<Bitmap> b(@NonNull ParcelFileDescriptor parcelFileDescriptor, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return this.f15600a.d(parcelFileDescriptor, i6, i7, fVar);
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull com.bumptech.glide.load.f fVar) {
        return this.f15600a.o(parcelFileDescriptor);
    }

    public e0(u uVar) {
        this.f15600a = uVar;
    }
}
