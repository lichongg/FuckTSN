package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class z extends h {

    /* renamed from: g, reason: collision with root package name */
    private static final String f15682g = "com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners";

    /* renamed from: h, reason: collision with root package name */
    private static final byte[] f15683h = f15682g.getBytes(com.bumptech.glide.load.c.f14919b);

    /* renamed from: c, reason: collision with root package name */
    private final float f15684c;

    /* renamed from: d, reason: collision with root package name */
    private final float f15685d;

    /* renamed from: e, reason: collision with root package name */
    private final float f15686e;

    /* renamed from: f, reason: collision with root package name */
    private final float f15687f;

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f15683h);
        messageDigest.update(ByteBuffer.allocate(16).putFloat(this.f15684c).putFloat(this.f15685d).putFloat(this.f15686e).putFloat(this.f15687f).array());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.h
    protected Bitmap c(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i6, int i7) {
        return k0.p(eVar, bitmap, this.f15684c, this.f15685d, this.f15686e, this.f15687f);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof z) {
            z zVar = (z) obj;
            if (this.f15684c == zVar.f15684c && this.f15685d == zVar.f15685d && this.f15686e == zVar.f15686e && this.f15687f == zVar.f15687f) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return com.bumptech.glide.util.l.n(this.f15687f, com.bumptech.glide.util.l.n(this.f15686e, com.bumptech.glide.util.l.n(this.f15685d, com.bumptech.glide.util.l.p(-2013597734, com.bumptech.glide.util.l.m(this.f15684c)))));
    }

    public z(float f6, float f7, float f8, float f9) {
        this.f15684c = f6;
        this.f15685d = f7;
        this.f15686e = f8;
        this.f15687f = f9;
    }
}
