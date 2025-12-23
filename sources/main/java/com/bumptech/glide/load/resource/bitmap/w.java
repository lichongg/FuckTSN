package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class w implements com.bumptech.glide.load.i<Drawable> {

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.i<Bitmap> f15678c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f15679d;

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        this.f15678c.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof w) {
            return this.f15678c.equals(((w) obj).f15678c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f15678c.hashCode();
    }

    public w(com.bumptech.glide.load.i<Bitmap> iVar, boolean z5) {
        this.f15678c = iVar;
        this.f15679d = z5;
    }

    private com.bumptech.glide.load.engine.u<Drawable> d(Context context, com.bumptech.glide.load.engine.u<Bitmap> uVar) {
        return d0.c(context.getResources(), uVar);
    }

    @Override // com.bumptech.glide.load.i
    @NonNull
    public com.bumptech.glide.load.engine.u<Drawable> a(@NonNull Context context, @NonNull com.bumptech.glide.load.engine.u<Drawable> uVar, int i6, int i7) {
        com.bumptech.glide.load.engine.bitmap_recycle.e h6 = com.bumptech.glide.b.e(context).h();
        Drawable drawable = uVar.get();
        com.bumptech.glide.load.engine.u<Bitmap> a6 = v.a(h6, drawable, i6, i7);
        if (a6 == null) {
            if (!this.f15679d) {
                return uVar;
            }
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
        com.bumptech.glide.load.engine.u<Bitmap> a7 = this.f15678c.a(context, a6, i6, i7);
        if (a7.equals(a6)) {
            a7.recycle();
            return uVar;
        }
        return d(context, a7);
    }

    public com.bumptech.glide.load.i<BitmapDrawable> c() {
        return this;
    }
}
