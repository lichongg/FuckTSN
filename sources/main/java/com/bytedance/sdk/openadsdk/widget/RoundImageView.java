package com.bytedance.sdk.openadsdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class RoundImageView extends ImageView {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private int f31965j;
    private int xt;

    private Bitmap j(Bitmap bitmap, int i6) {
        int i7 = i6 * 2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = height > width ? Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width) : height < width ? Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height) : null;
        if (createBitmap != null) {
            bitmap = createBitmap;
        }
        if (bitmap.getWidth() != i7 || bitmap.getHeight() != i7) {
            bitmap = Bitmap.createScaledBitmap(bitmap, i7, i7, true);
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap2;
    }

    public RoundImageView(Context context) {
        super(context);
        this.f31965j = 0;
        this.xt = 0;
        this.cw = 0;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Drawable drawable = getDrawable();
        if (drawable != null && getWidth() != 0 && getHeight() != 0) {
            measure(0, 0);
            if (drawable.getClass() != NinePatchDrawable.class && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                try {
                    bitmap2 = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                } catch (Throwable unused) {
                    bitmap2 = null;
                }
                if (bitmap2 == null) {
                    super.onDraw(canvas);
                    return;
                }
                if (this.f31965j == 0) {
                    this.f31965j = getWidth();
                }
                if (this.xt == 0) {
                    this.xt = getHeight();
                }
                int i6 = this.f31965j;
                int i7 = this.xt;
                if (i6 >= i7) {
                    i6 = i7;
                }
                try {
                    bitmap3 = j(bitmap2, i6 / 2);
                } catch (Throwable unused2) {
                    bitmap3 = null;
                }
                if (bitmap3 == null) {
                    super.onDraw(canvas);
                } else {
                    canvas.drawBitmap(bitmap3, (this.f31965j / 2) - r2, (this.xt / 2) - r2, (Paint) null);
                }
            }
        }
    }
}
