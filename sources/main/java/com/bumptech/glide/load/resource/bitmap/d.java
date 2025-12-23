package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes3.dex */
public class d implements com.bumptech.glide.load.i<BitmapDrawable> {

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.i<Drawable> f15593c;

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        this.f15593c.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f15593c.equals(((d) obj).f15593c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f15593c.hashCode();
    }

    public d(com.bumptech.glide.load.i<Bitmap> iVar) {
        this.f15593c = (com.bumptech.glide.load.i) com.bumptech.glide.util.k.d(new w(iVar, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static com.bumptech.glide.load.engine.u<BitmapDrawable> c(com.bumptech.glide.load.engine.u<Drawable> uVar) {
        if (uVar.get() instanceof BitmapDrawable) {
            return uVar;
        }
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + uVar.get());
    }

    @Override // com.bumptech.glide.load.i
    @NonNull
    public com.bumptech.glide.load.engine.u<BitmapDrawable> a(@NonNull Context context, @NonNull com.bumptech.glide.load.engine.u<BitmapDrawable> uVar, int i6, int i7) {
        return c(this.f15593c.a(context, d(uVar), i6, i7));
    }

    private static com.bumptech.glide.load.engine.u<Drawable> d(com.bumptech.glide.load.engine.u<BitmapDrawable> uVar) {
        return uVar;
    }
}
