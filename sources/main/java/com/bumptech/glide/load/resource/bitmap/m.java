package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class m extends h {

    /* renamed from: c, reason: collision with root package name */
    private static final String f15639c = "com.bumptech.glide.load.resource.bitmap.CenterCrop";

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f15640d = f15639c.getBytes(com.bumptech.glide.load.c.f14919b);

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f15640d);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        return obj instanceof m;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.h
    protected Bitmap c(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i6, int i7) {
        return k0.b(eVar, bitmap, i6, i7);
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return -599754482;
    }
}
