package com.beizi.ad.internal.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DrawTextImageView extends AppCompatImageView {

    /* renamed from: a, reason: collision with root package name */
    private String f12610a;

    /* renamed from: b, reason: collision with root package name */
    private float f12611b;

    /* renamed from: c, reason: collision with root package name */
    private float f12612c;

    /* renamed from: d, reason: collision with root package name */
    private float f12613d;

    /* renamed from: e, reason: collision with root package name */
    private int f12614e;

    /* renamed from: f, reason: collision with root package name */
    private int f12615f;

    public DrawTextImageView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f12610a = "";
        this.f12611b = 30.0f;
        this.f12612c = -1000.0f;
        this.f12613d = -1000.0f;
        this.f12614e = 0;
        this.f12615f = 3;
    }

    public void setDrawLocalXY(float f6, float f7) {
        this.f12612c = f6;
        this.f12613d = f7;
        drawableStateChanged();
    }

    public void setDrawText(String str) {
        this.f12610a = str;
        drawableStateChanged();
    }

    public void setDrawTextColorResourse(int i6) {
        this.f12614e = i6;
        drawableStateChanged();
    }

    public void setDrawTextSize(float f6) {
        this.f12611b = f6;
        drawableStateChanged();
    }

    public void setDrawTextStrokeWidth(int i6) {
        this.f12615f = i6;
        drawableStateChanged();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f12610a.equals("")) {
            Paint paint = new Paint();
            paint.setColor(getResources().getColor(this.f12614e));
            paint.setStrokeWidth(this.f12615f);
            paint.setStyle(Paint.Style.FILL);
            paint.setTextSize(this.f12611b);
            String str = this.f12610a;
            float f6 = this.f12612c;
            if (f6 == -1000.0f) {
                f6 = canvas.getWidth() - (this.f12611b * this.f12610a.length());
            }
            float f7 = this.f12613d;
            if (f7 == -1000.0f) {
                f7 = canvas.getHeight() - 50;
            }
            canvas.drawText(str, f6, f7, paint);
        }
    }

    public DrawTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12610a = "";
        this.f12611b = 30.0f;
        this.f12612c = -1000.0f;
        this.f12613d = -1000.0f;
        this.f12614e = 0;
        this.f12615f = 3;
    }

    public DrawTextImageView(Context context) {
        super(context);
        this.f12610a = "";
        this.f12611b = 30.0f;
        this.f12612c = -1000.0f;
        this.f12613d = -1000.0f;
        this.f12614e = 0;
        this.f12615f = 3;
    }
}
