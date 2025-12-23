package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class j implements com.bumptech.glide.load.g<ByteBuffer, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final u f15619a;

    @Override // com.bumptech.glide.load.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.f fVar) {
        return this.f15619a.q(byteBuffer);
    }

    public j(u uVar) {
        this.f15619a = uVar;
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.u<Bitmap> b(@NonNull ByteBuffer byteBuffer, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return this.f15619a.f(com.bumptech.glide.util.a.f(byteBuffer), i6, i7, fVar);
    }
}
