package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.bytedance.component.sdk.annotation.RequiresApi;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class BrushMaskView extends View {

    /* renamed from: j, reason: collision with root package name */
    private static final String f25879j = "BrushMaskView";
    private Paint ae;
    private Bitmap cw;

    /* renamed from: m, reason: collision with root package name */
    private BitmapDrawable f25880m;

    /* renamed from: r, reason: collision with root package name */
    private Canvas f25881r;
    private Paint tl;
    private Paint up;
    private Paint xt;

    private void j(int i6, int i7) {
        if (i6 <= 0 || i7 <= 0) {
            return;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
            this.cw = createBitmap;
            Canvas canvas = this.f25881r;
            if (canvas == null) {
                this.f25881r = new Canvas(this.cw);
            } else {
                canvas.setBitmap(createBitmap);
            }
            this.f25881r.drawRoundRect(new RectF(0.0f, 0.0f, i6, i7), 120.0f, 120.0f, this.xt);
            if (this.f25880m != null) {
                this.f25880m.setBounds(new Rect(0, 0, i6, i7));
                this.f25880m.draw(this.f25881r);
            }
        } catch (Exception e6) {
            vl.r(f25879j, e6.getMessage());
        }
    }

    @RequiresApi(api = 21)
    public void setWatermark(int i6) {
        if (i6 == -1) {
            this.f25880m = null;
        } else {
            this.f25880m = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), i6));
        }
    }

    public void setEraserSize(float f6) {
        this.ae.setStrokeWidth(f6);
        this.tl.setStrokeWidth(f6);
    }

    public void setMaskColor(int i6) {
        this.xt.setColor(i6);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.cw;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.up);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        setMeasuredDimension(j(i6), j(i7));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        j(i6, i7);
    }

    private int j(int i6) {
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(0, size);
        }
        return 0;
    }
}
