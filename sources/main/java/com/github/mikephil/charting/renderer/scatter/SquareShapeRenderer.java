package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class SquareShapeRenderer implements IShapeRenderer {
    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public void renderShape(Canvas canvas, IScatterDataSet iScatterDataSet, ViewPortHandler viewPortHandler, float f6, float f7, Paint paint) {
        float scatterShapeSize = iScatterDataSet.getScatterShapeSize();
        float f8 = scatterShapeSize / 2.0f;
        float convertDpToPixel = Utils.convertDpToPixel(iScatterDataSet.getScatterShapeHoleRadius());
        float f9 = (scatterShapeSize - (convertDpToPixel * 2.0f)) / 2.0f;
        float f10 = f9 / 2.0f;
        int scatterShapeHoleColor = iScatterDataSet.getScatterShapeHoleColor();
        if (scatterShapeSize <= 0.0d) {
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(f6 - f8, f7 - f8, f6 + f8, f7 + f8, paint);
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f9);
        float f11 = f6 - convertDpToPixel;
        float f12 = f7 - convertDpToPixel;
        float f13 = f6 + convertDpToPixel;
        float f14 = f7 + convertDpToPixel;
        canvas.drawRect(f11 - f10, f12 - f10, f13 + f10, f14 + f10, paint);
        if (scatterShapeHoleColor != 1122867) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(scatterShapeHoleColor);
            canvas.drawRect(f11, f12, f13, f14, paint);
        }
    }
}
