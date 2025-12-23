package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class d extends b<Drawable> {
    @Nullable
    static u<Drawable> c(@Nullable Drawable drawable) {
        if (drawable != null) {
            return new d(drawable);
        }
        return null;
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<Drawable> a() {
        return this.f15689a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return Math.max(1, this.f15689a.getIntrinsicWidth() * this.f15689a.getIntrinsicHeight() * 4);
    }

    private d(Drawable drawable) {
        super(drawable);
    }

    @Override // com.bumptech.glide.load.engine.u
    public void recycle() {
    }
}
