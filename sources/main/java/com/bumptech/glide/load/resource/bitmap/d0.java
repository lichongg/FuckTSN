package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class d0 implements com.bumptech.glide.load.engine.u<BitmapDrawable>, com.bumptech.glide.load.engine.q {

    /* renamed from: a, reason: collision with root package name */
    private final Resources f15594a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.u<Bitmap> f15595b;

    @Nullable
    public static com.bumptech.glide.load.engine.u<BitmapDrawable> c(@NonNull Resources resources, @Nullable com.bumptech.glide.load.engine.u<Bitmap> uVar) {
        if (uVar == null) {
            return null;
        }
        return new d0(resources, uVar);
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<BitmapDrawable> a() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f15594a, this.f15595b.get());
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return this.f15595b.getSize();
    }

    @Override // com.bumptech.glide.load.engine.q
    public void initialize() {
        com.bumptech.glide.load.engine.u<Bitmap> uVar = this.f15595b;
        if (uVar instanceof com.bumptech.glide.load.engine.q) {
            ((com.bumptech.glide.load.engine.q) uVar).initialize();
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    public void recycle() {
        this.f15595b.recycle();
    }

    private d0(@NonNull Resources resources, @NonNull com.bumptech.glide.load.engine.u<Bitmap> uVar) {
        this.f15594a = (Resources) com.bumptech.glide.util.k.d(resources);
        this.f15595b = (com.bumptech.glide.load.engine.u) com.bumptech.glide.util.k.d(uVar);
    }

    @Deprecated
    public static d0 d(Context context, Bitmap bitmap) {
        return (d0) c(context.getResources(), g.c(bitmap, com.bumptech.glide.b.e(context).h()));
    }

    @Deprecated
    public static d0 e(Resources resources, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) {
        return (d0) c(resources, g.c(bitmap, eVar));
    }
}
