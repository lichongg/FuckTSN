package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c extends com.bumptech.glide.load.resource.drawable.b<BitmapDrawable> implements com.bumptech.glide.load.engine.q {

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f15591b;

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<BitmapDrawable> a() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return com.bumptech.glide.util.l.h(((BitmapDrawable) this.f15689a).getBitmap());
    }

    @Override // com.bumptech.glide.load.resource.drawable.b, com.bumptech.glide.load.engine.q
    public void initialize() {
        ((BitmapDrawable) this.f15689a).getBitmap().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.u
    public void recycle() {
        this.f15591b.d(((BitmapDrawable) this.f15689a).getBitmap());
    }

    public c(BitmapDrawable bitmapDrawable, com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        super(bitmapDrawable);
        this.f15591b = eVar;
    }
}
