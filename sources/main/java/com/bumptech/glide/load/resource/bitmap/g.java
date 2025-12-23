package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class g implements com.bumptech.glide.load.engine.u<Bitmap>, com.bumptech.glide.load.engine.q {

    /* renamed from: a, reason: collision with root package name */
    private final Bitmap f15609a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f15610b;

    @Nullable
    public static g c(@Nullable Bitmap bitmap, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new g(bitmap, eVar);
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<Bitmap> a() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.f15609a;
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return com.bumptech.glide.util.l.h(this.f15609a);
    }

    @Override // com.bumptech.glide.load.engine.q
    public void initialize() {
        this.f15609a.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.u
    public void recycle() {
        this.f15610b.d(this.f15609a);
    }

    public g(@NonNull Bitmap bitmap, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        this.f15609a = (Bitmap) com.bumptech.glide.util.k.e(bitmap, "Bitmap must not be null");
        this.f15610b = (com.bumptech.glide.load.engine.bitmap_recycle.e) com.bumptech.glide.util.k.e(eVar, "BitmapPool must not be null");
    }
}
