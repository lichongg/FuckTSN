package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class l0 implements com.bumptech.glide.load.g<Bitmap, Bitmap> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a implements com.bumptech.glide.load.engine.u<Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        private final Bitmap f15638a;

        @Override // com.bumptech.glide.load.engine.u
        @NonNull
        public Class<Bitmap> a() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.engine.u
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.f15638a;
        }

        @Override // com.bumptech.glide.load.engine.u
        public int getSize() {
            return com.bumptech.glide.util.l.h(this.f15638a);
        }

        a(@NonNull Bitmap bitmap) {
            this.f15638a = bitmap;
        }

        @Override // com.bumptech.glide.load.engine.u
        public void recycle() {
        }
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Bitmap bitmap, @NonNull com.bumptech.glide.load.f fVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.u<Bitmap> b(@NonNull Bitmap bitmap, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        return new a(bitmap);
    }
}
