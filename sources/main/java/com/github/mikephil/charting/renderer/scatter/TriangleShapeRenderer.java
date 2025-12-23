package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class TriangleShapeRenderer implements IShapeRenderer {
    protected Path mTrianglePathBuffer = new Path();

    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public void renderShape(Canvas canvas, IScatterDataSet iScatterDataSet, ViewPortHandler viewPortHandler, float f6, float f7, Paint paint) {
        float scatterShapeSize = iScatterDataSet.getScatterShapeSize();
        float f8 = scatterShapeSize / 2.0f;
        float convertDpToPixel = (scatterShapeSize - (Utils.convertDpToPixel(iScatterDataSet.getScatterShapeHoleRadius()) * 2.0f)) / 2.0f;
        int scatterShapeHoleColor = iScatterDataSet.getScatterShapeHoleColor();
        paint.setStyle(Paint.Style.FILL);
        Path path = this.mTrianglePathBuffer;
        path.reset();
        float f9 = f7 - f8;
        path.moveTo(f6, f9);
        float f10 = f6 + f8;
        float f11 = f7 + f8;
        path.lineTo(f10, f11);
        float f12 = f6 - f8;
        path.lineTo(f12, f11);
        double d6 = scatterShapeSize;
        if (d6 > 0.0d) {
            path.lineTo(f6, f9);
            float f13 = f12 + convertDpToPixel;
            float f14 = f11 - convertDpToPixel;
            path.moveTo(f13, f14);
            path.lineTo(f10 - convertDpToPixel, f14);
            path.lineTo(f6, f9 + convertDpToPixel);
            path.lineTo(f13, f14);
        }
        path.close();
        canvas.drawPath(path, paint);
        path.reset();
        if (d6 > 0.0d && scatterShapeHoleColor != 1122867) {
            paint.setColor(scatterShapeHoleColor);
            path.moveTo(f6, f9 + convertDpToPixel);
            float f15 = f11 - convertDpToPixel;
            path.lineTo(f10 - convertDpToPixel, f15);
            path.lineTo(f12 + convertDpToPixel, f15);
            path.close();
            canvas.drawPath(path, paint);
            path.reset();
        }
    }
}
