package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class h implements com.bumptech.glide.load.i<Bitmap> {
    protected abstract Bitmap c(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i6, int i7);

    @Override // com.bumptech.glide.load.i
    @NonNull
    public final com.bumptech.glide.load.engine.u<Bitmap> a(@NonNull Context context, @NonNull com.bumptech.glide.load.engine.u<Bitmap> uVar, int i6, int i7) {
        if (com.bumptech.glide.util.l.w(i6, i7)) {
            com.bumptech.glide.load.engine.bitmap_recycle.e h6 = com.bumptech.glide.b.e(context).h();
            Bitmap bitmap = uVar.get();
            if (i6 == Integer.MIN_VALUE) {
                i6 = bitmap.getWidth();
            }
            if (i7 == Integer.MIN_VALUE) {
                i7 = bitmap.getHeight();
            }
            Bitmap c6 = c(h6, bitmap, i6, i7);
            if (bitmap.equals(c6)) {
                return uVar;
            }
            return g.c(c6, h6);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i6 + " or height: " + i7 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
