package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class RoundAngleImageView extends ImageView {
    private float[] aGe;
    private Path mPath;
    private RectF mRectF;

    public RoundAngleImageView(Context context) {
        this(context, null);
    }

    public void setRadius(float f6) {
        this.aGe = new float[8];
        int i6 = 0;
        while (true) {
            float[] fArr = this.aGe;
            if (i6 >= fArr.length) {
                return;
            }
            fArr[i6] = f6;
            i6++;
        }
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        float[] fArr = this.aGe;
        if (fArr == null || fArr.length != 8) {
            super.onDraw(canvas);
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float[] fArr2 = this.aGe;
        float f6 = fArr2[0] + fArr2[3];
        float f7 = fArr2[1] + fArr2[7];
        this.mPath.rewind();
        float f8 = measuredWidth;
        if (f8 >= f6) {
            float f9 = measuredHeight;
            if (f9 > f7) {
                this.mRectF.set(0.0f, 0.0f, f8, f9);
                this.mPath.addRoundRect(this.mRectF, this.aGe, Path.Direction.CW);
                canvas.clipPath(this.mPath);
            }
        }
        super.onDraw(canvas);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mPath = new Path();
        this.mRectF = new RectF();
    }

    public void setRadius(float[] fArr) {
        this.aGe = new float[8];
        int i6 = 0;
        while (true) {
            float[] fArr2 = this.aGe;
            if (i6 >= fArr2.length) {
                return;
            }
            fArr2[i6] = fArr[i6];
            i6++;
        }
    }
}
