package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class c implements e<Drawable, byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f15774a;

    /* renamed from: b, reason: collision with root package name */
    private final e<Bitmap, byte[]> f15775b;

    /* renamed from: c, reason: collision with root package name */
    private final e<GifDrawable, byte[]> f15776c;

    public c(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull e<Bitmap, byte[]> eVar2, @NonNull e<GifDrawable, byte[]> eVar3) {
        this.f15774a = eVar;
        this.f15775b = eVar2;
        this.f15776c = eVar3;
    }

    @Override // com.bumptech.glide.load.resource.transcode.e
    @Nullable
    public u<byte[]> a(@NonNull u<Drawable> uVar, @NonNull com.bumptech.glide.load.f fVar) {
        Drawable drawable = uVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f15775b.a(com.bumptech.glide.load.resource.bitmap.g.c(((BitmapDrawable) drawable).getBitmap(), this.f15774a), fVar);
        }
        if (drawable instanceof GifDrawable) {
            return this.f15776c.a(b(uVar), fVar);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    private static u<GifDrawable> b(@NonNull u<Drawable> uVar) {
        return uVar;
    }
}
