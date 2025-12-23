package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.sdk.component.utils.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class WriggleGuideView extends View {
    private boolean ae;
    private Bitmap cw;

    /* renamed from: g, reason: collision with root package name */
    private j f26005g;

    /* renamed from: j, reason: collision with root package name */
    private int f26006j;

    /* renamed from: m, reason: collision with root package name */
    private int f26007m;

    /* renamed from: r, reason: collision with root package name */
    private Bitmap f26008r;
    private boolean tl;
    private Paint up;
    private int xt;

    public interface j {
    }

    private Bitmap cw(int i6, int i7) {
        Bitmap createBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawCircle(i6 / 2, 10.0f, this.f26007m, paint);
        return createBitmap;
    }

    private Bitmap j(int i6, int i7) {
        Bitmap createBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Bitmap decodeResource = BitmapFactory.decodeResource(getContext().getResources(), kt.up(getContext(), "tt_wriggle_union"));
        if (decodeResource != null) {
            canvas.drawBitmap(decodeResource, (Rect) null, new RectF(0.0f, 0.0f, i6, i7), this.up);
        }
        return createBitmap;
    }

    private Bitmap xt(int i6, int i7) {
        Bitmap createBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        Bitmap decodeResource = BitmapFactory.decodeResource(getContext().getResources(), kt.up(getContext(), "tt_wriggle_union_white"));
        if (decodeResource != null) {
            canvas.drawBitmap(decodeResource, (Rect) null, new RectF(0.0f, 0.0f, i6, i7), paint);
        }
        return createBitmap;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f26005g != null) {
            this.f26005g = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ae) {
            this.f26006j = getWidth();
            int height = getHeight();
            this.xt = height;
            this.cw = j(this.f26006j, height);
            this.f26008r = xt(this.f26006j, this.xt);
            this.ae = false;
        }
        Bitmap bitmap = this.cw;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.up);
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        Bitmap bitmap2 = this.f26008r;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, this.up);
        }
        this.up.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(cw(this.f26006j, this.xt), 0.0f, 0.0f, this.up);
        this.up.setXfermode(null);
        canvas.restoreToCount(saveLayer);
        if (this.tl) {
            this.f26007m += 5;
            invalidate();
            if (this.f26007m >= this.f26006j) {
                this.tl = false;
            }
        }
    }
}
