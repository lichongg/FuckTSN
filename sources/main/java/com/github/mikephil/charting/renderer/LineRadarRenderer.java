package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class LineRadarRenderer extends LineScatterCandleRadarRenderer {
    protected void drawFilledPath(Canvas canvas, Path path, Drawable drawable) {
        if (!clipPathSupported()) {
            throw new RuntimeException("Fill-drawables not (yet) supported below API level 18, this code was run on API level " + Utils.getSDKInt() + ".");
        }
        int save = canvas.save();
        canvas.clipPath(path);
        drawable.setBounds((int) this.mViewPortHandler.contentLeft(), (int) this.mViewPortHandler.contentTop(), (int) this.mViewPortHandler.contentRight(), (int) this.mViewPortHandler.contentBottom());
        drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    public LineRadarRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
    }

    private boolean clipPathSupported() {
        if (Utils.getSDKInt() >= 18) {
            return true;
        }
        return false;
    }

    protected void drawFilledPath(Canvas canvas, Path path, int i6, int i7) {
        int i8 = (i6 & 16777215) | (i7 << 24);
        if (clipPathSupported()) {
            int save = canvas.save();
            canvas.clipPath(path);
            canvas.drawColor(i8);
            canvas.restoreToCount(save);
            return;
        }
        Paint.Style style = this.mRenderPaint.getStyle();
        int color = this.mRenderPaint.getColor();
        this.mRenderPaint.setStyle(Paint.Style.FILL);
        this.mRenderPaint.setColor(i8);
        canvas.drawPath(path, this.mRenderPaint);
        this.mRenderPaint.setColor(color);
        this.mRenderPaint.setStyle(style);
    }
}
