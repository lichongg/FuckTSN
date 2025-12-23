package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class i0 extends h {

    /* renamed from: d, reason: collision with root package name */
    private static final String f15616d = "com.bumptech.glide.load.resource.bitmap.RoundedCorners";

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f15617e = f15616d.getBytes(com.bumptech.glide.load.c.f14919b);

    /* renamed from: c, reason: collision with root package name */
    private final int f15618c;

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f15617e);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f15618c).array());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.h
    protected Bitmap c(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i6, int i7) {
        return k0.q(eVar, bitmap, this.f15618c);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        return (obj instanceof i0) && this.f15618c == ((i0) obj).f15618c;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return com.bumptech.glide.util.l.p(-569625254, com.bumptech.glide.util.l.o(this.f15618c));
    }

    public i0(int i6) {
        boolean z5;
        if (i6 > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        com.bumptech.glide.util.k.a(z5, "roundingRadius must be greater than 0.");
        this.f15618c = i6;
    }
}
