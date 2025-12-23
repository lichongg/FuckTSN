package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.concurrent.locks.Lock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class v {

    /* renamed from: a, reason: collision with root package name */
    private static final String f15676a = "DrawableToBitmap";

    /* renamed from: b, reason: collision with root package name */
    private static final com.bumptech.glide.load.engine.bitmap_recycle.e f15677b = new a();

    @Nullable
    private static Bitmap b(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Drawable drawable, int i6, int i7) {
        if (i6 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable(f15676a, 5)) {
                drawable.toString();
            }
            return null;
        }
        if (i7 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable(f15676a, 5)) {
                drawable.toString();
            }
            return null;
        }
        if (drawable.getIntrinsicWidth() > 0) {
            i6 = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            i7 = drawable.getIntrinsicHeight();
        }
        Lock i8 = k0.i();
        i8.lock();
        Bitmap e6 = eVar.e(i6, i7, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(e6);
            drawable.setBounds(0, 0, i6, i7);
            drawable.draw(canvas);
            canvas.setBitmap(null);
            return e6;
        } finally {
            i8.unlock();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends com.bumptech.glide.load.engine.bitmap_recycle.f {
        a() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.f, com.bumptech.glide.load.engine.bitmap_recycle.e
        public void d(Bitmap bitmap) {
        }
    }

    private v() {
    }

    @Nullable
    static com.bumptech.glide.load.engine.u<Bitmap> a(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Drawable drawable, int i6, int i7) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z5 = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            bitmap = b(eVar, current, i6, i7);
            z5 = true;
        } else {
            bitmap = null;
        }
        if (!z5) {
            eVar = f15677b;
        }
        return g.c(bitmap, eVar);
    }
}
