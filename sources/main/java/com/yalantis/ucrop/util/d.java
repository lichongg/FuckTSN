package com.yalantis.ucrop.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d extends Drawable {

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f42786b;

    /* renamed from: d, reason: collision with root package name */
    private int f42788d;

    /* renamed from: e, reason: collision with root package name */
    private int f42789e;

    /* renamed from: a, reason: collision with root package name */
    private final Paint f42785a = new Paint(2);

    /* renamed from: c, reason: collision with root package name */
    private int f42787c = 255;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public Bitmap a() {
        return this.f42786b;
    }

    public void b(Bitmap bitmap) {
        this.f42786b = bitmap;
        if (bitmap != null) {
            this.f42788d = bitmap.getWidth();
            this.f42789e = this.f42786b.getHeight();
        } else {
            this.f42789e = 0;
            this.f42788d = 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f42786b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.f42786b, (Rect) null, getBounds(), this.f42785a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f42787c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f42789e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f42788d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f42789e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f42788d;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        this.f42787c = i6;
        this.f42785a.setAlpha(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f42785a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z5) {
        this.f42785a.setFilterBitmap(z5);
    }

    public d(Bitmap bitmap) {
        b(bitmap);
    }
}
