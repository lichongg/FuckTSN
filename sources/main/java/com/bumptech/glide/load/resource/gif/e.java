package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.util.k;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class e implements com.bumptech.glide.load.i<GifDrawable> {

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.i<Bitmap> f15725c;

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        this.f15725c.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f15725c.equals(((e) obj).f15725c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f15725c.hashCode();
    }

    public e(com.bumptech.glide.load.i<Bitmap> iVar) {
        this.f15725c = (com.bumptech.glide.load.i) k.d(iVar);
    }

    @Override // com.bumptech.glide.load.i
    @NonNull
    public u<GifDrawable> a(@NonNull Context context, @NonNull u<GifDrawable> uVar, int i6, int i7) {
        GifDrawable gifDrawable = uVar.get();
        u<Bitmap> gVar = new com.bumptech.glide.load.resource.bitmap.g(gifDrawable.e(), com.bumptech.glide.b.e(context).h());
        u<Bitmap> a6 = this.f15725c.a(context, gVar, i6, i7);
        if (!gVar.equals(a6)) {
            gVar.recycle();
        }
        gifDrawable.o(this.f15725c, a6.get());
        return uVar;
    }
}
