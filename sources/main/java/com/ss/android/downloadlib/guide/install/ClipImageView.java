package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: D:\Downloads\app\classes6.dex */
public class ClipImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private boolean f38118a;

    /* renamed from: b, reason: collision with root package name */
    private Path f38119b;

    /* renamed from: c, reason: collision with root package name */
    private RectF f38120c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f38121d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f38122e;

    public ClipImageView(Context context) {
        super(context);
        this.f38118a = true;
        a(context);
    }

    protected void a(Context context) {
        this.f38119b = new Path();
        this.f38120c = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f38118a) {
            this.f38119b.reset();
            this.f38120c.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.f38122e;
            if (fArr != null) {
                this.f38119b.addRoundRect(this.f38120c, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.f38119b);
            Paint paint = this.f38121d;
            if (paint != null) {
                canvas.drawPath(this.f38119b, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i6) {
        Paint paint = new Paint(1);
        this.f38121d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f38121d.setColor(i6);
    }

    public void setClip(boolean z5) {
        this.f38118a = z5;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.f38122e = fArr;
    }

    public void setRoundRadius(int i6) {
        if (i6 > 0) {
            float f6 = i6;
            setRadius(new float[]{f6, f6, f6, f6, f6, f6, f6, f6});
        }
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38118a = true;
        a(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f38118a = true;
        a(context);
    }
}
