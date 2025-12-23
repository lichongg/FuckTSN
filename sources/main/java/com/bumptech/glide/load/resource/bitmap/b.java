package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b implements com.bumptech.glide.load.h<BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f15583a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.h<Bitmap> f15584b;

    @Override // com.bumptech.glide.load.h
    @NonNull
    public EncodeStrategy b(@NonNull com.bumptech.glide.load.f fVar) {
        return this.f15584b.b(fVar);
    }

    @Override // com.bumptech.glide.load.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull com.bumptech.glide.load.engine.u<BitmapDrawable> uVar, @NonNull File file, @NonNull com.bumptech.glide.load.f fVar) {
        return this.f15584b.a(new g(uVar.get().getBitmap(), this.f15583a), file, fVar);
    }

    public b(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, com.bumptech.glide.load.h<Bitmap> hVar) {
        this.f15583a = eVar;
        this.f15584b = hVar;
    }
}
