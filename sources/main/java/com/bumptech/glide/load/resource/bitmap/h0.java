package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class h0 extends h {

    /* renamed from: d, reason: collision with root package name */
    private static final String f15613d = "com.bumptech.glide.load.resource.bitmap.Rotate";

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f15614e = f15613d.getBytes(com.bumptech.glide.load.c.f14919b);

    /* renamed from: c, reason: collision with root package name */
    private final int f15615c;

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f15614e);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f15615c).array());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.h
    protected Bitmap c(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i6, int i7) {
        return k0.n(bitmap, this.f15615c);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        return (obj instanceof h0) && this.f15615c == ((h0) obj).f15615c;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return com.bumptech.glide.util.l.p(-950519196, com.bumptech.glide.util.l.o(this.f15615c));
    }

    public h0(int i6) {
        this.f15615c = i6;
    }
}
