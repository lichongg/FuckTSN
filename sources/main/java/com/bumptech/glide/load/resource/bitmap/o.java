package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class o extends h {

    /* renamed from: c, reason: collision with root package name */
    private static final int f15643c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final String f15644d = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1";

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f15645e = f15644d.getBytes(com.bumptech.glide.load.c.f14919b);

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f15645e);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        return obj instanceof o;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.h
    protected Bitmap c(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i6, int i7) {
        return k0.d(eVar, bitmap, i6, i7);
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return 1101716364;
    }
}
