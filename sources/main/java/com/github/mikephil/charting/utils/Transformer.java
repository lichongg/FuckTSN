package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class Transformer {
    protected ViewPortHandler mViewPortHandler;
    protected Matrix mMatrixValueToPx = new Matrix();
    protected Matrix mMatrixOffset = new Matrix();
    protected float[] valuePointsForGenerateTransformedValuesScatter = new float[1];
    protected float[] valuePointsForGenerateTransformedValuesBubble = new float[1];
    protected float[] valuePointsForGenerateTransformedValuesLine = new float[1];
    protected float[] valuePointsForGenerateTransformedValuesCandle = new float[1];
    protected Matrix mPixelToValueMatrixBuffer = new Matrix();
    float[] ptsBuffer = new float[2];
    private Matrix mMBuffer1 = new Matrix();
    private Matrix mMBuffer2 = new Matrix();

    /* JADX WARN: Type inference failed for: r2v2, types: [com.github.mikephil.charting.data.BaseEntry, com.github.mikephil.charting.data.Entry] */
    public float[] generateTransformedValuesBubble(IBubbleDataSet iBubbleDataSet, float f6, int i6, int i7) {
        int i8 = ((i7 - i6) + 1) * 2;
        if (this.valuePointsForGenerateTransformedValuesBubble.length != i8) {
            this.valuePointsForGenerateTransformedValuesBubble = new float[i8];
        }
        float[] fArr = this.valuePointsForGenerateTransformedValuesBubble;
        for (int i9 = 0; i9 < i8; i9 += 2) {
            ?? entryForIndex = iBubbleDataSet.getEntryForIndex((i9 / 2) + i6);
            if (entryForIndex != 0) {
                fArr[i9] = entryForIndex.getX();
                fArr[i9 + 1] = entryForIndex.getY() * f6;
            } else {
                fArr[i9] = 0.0f;
                fArr[i9 + 1] = 0.0f;
            }
        }
        getValueToPixelMatrix().mapPoints(fArr);
        return fArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float[] generateTransformedValuesCandle(ICandleDataSet iCandleDataSet, float f6, float f7, int i6, int i7) {
        int i8 = ((int) (((i7 - i6) * f6) + 1.0f)) * 2;
        if (this.valuePointsForGenerateTransformedValuesCandle.length != i8) {
            this.valuePointsForGenerateTransformedValuesCandle = new float[i8];
        }
        float[] fArr = this.valuePointsForGenerateTransformedValuesCandle;
        for (int i9 = 0; i9 < i8; i9 += 2) {
            CandleEntry candleEntry = (CandleEntry) iCandleDataSet.getEntryForIndex((i9 / 2) + i6);
            if (candleEntry != null) {
                fArr[i9] = candleEntry.getX();
                fArr[i9 + 1] = candleEntry.getHigh() * f7;
            } else {
                fArr[i9] = 0.0f;
                fArr[i9 + 1] = 0.0f;
            }
        }
        getValueToPixelMatrix().mapPoints(fArr);
        return fArr;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.github.mikephil.charting.data.BaseEntry, com.github.mikephil.charting.data.Entry] */
    public float[] generateTransformedValuesLine(ILineDataSet iLineDataSet, float f6, float f7, int i6, int i7) {
        int i8 = (((int) ((i7 - i6) * f6)) + 1) * 2;
        if (this.valuePointsForGenerateTransformedValuesLine.length != i8) {
            this.valuePointsForGenerateTransformedValuesLine = new float[i8];
        }
        float[] fArr = this.valuePointsForGenerateTransformedValuesLine;
        for (int i9 = 0; i9 < i8; i9 += 2) {
            ?? entryForIndex = iLineDataSet.getEntryForIndex((i9 / 2) + i6);
            if (entryForIndex != 0) {
                fArr[i9] = entryForIndex.getX();
                fArr[i9 + 1] = entryForIndex.getY() * f7;
            } else {
                fArr[i9] = 0.0f;
                fArr[i9 + 1] = 0.0f;
            }
        }
        getValueToPixelMatrix().mapPoints(fArr);
        return fArr;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.github.mikephil.charting.data.BaseEntry, com.github.mikephil.charting.data.Entry] */
    public float[] generateTransformedValuesScatter(IScatterDataSet iScatterDataSet, float f6, float f7, int i6, int i7) {
        int i8 = ((int) (((i7 - i6) * f6) + 1.0f)) * 2;
        if (this.valuePointsForGenerateTransformedValuesScatter.length != i8) {
            this.valuePointsForGenerateTransformedValuesScatter = new float[i8];
        }
        float[] fArr = this.valuePointsForGenerateTransformedValuesScatter;
        for (int i9 = 0; i9 < i8; i9 += 2) {
            ?? entryForIndex = iScatterDataSet.getEntryForIndex((i9 / 2) + i6);
            if (entryForIndex != 0) {
                fArr[i9] = entryForIndex.getX();
                fArr[i9 + 1] = entryForIndex.getY() * f7;
            } else {
                fArr[i9] = 0.0f;
                fArr[i9 + 1] = 0.0f;
            }
        }
        getValueToPixelMatrix().mapPoints(fArr);
        return fArr;
    }

    public MPPointD getValuesByTouchPoint(float f6, float f7) {
        MPPointD mPPointD = MPPointD.getInstance(0.0d, 0.0d);
        getValuesByTouchPoint(f6, f7, mPPointD);
        return mPPointD;
    }

    public void pathValuesToPixel(List<Path> list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            pathValueToPixel(list.get(i6));
        }
    }

    public void rectValueToPixelHorizontal(RectF rectF) {
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }

    public Matrix getOffsetMatrix() {
        return this.mMatrixOffset;
    }

    public MPPointD getPixelForValues(float f6, float f7) {
        float[] fArr = this.ptsBuffer;
        fArr[0] = f6;
        fArr[1] = f7;
        pointValuesToPixel(fArr);
        float[] fArr2 = this.ptsBuffer;
        return MPPointD.getInstance(fArr2[0], fArr2[1]);
    }

    public Matrix getValueMatrix() {
        return this.mMatrixValueToPx;
    }

    public Matrix getValueToPixelMatrix() {
        this.mMBuffer1.set(this.mMatrixValueToPx);
        this.mMBuffer1.postConcat(this.mViewPortHandler.mMatrixTouch);
        this.mMBuffer1.postConcat(this.mMatrixOffset);
        return this.mMBuffer1;
    }

    public void pathValueToPixel(Path path) {
        path.transform(this.mMatrixValueToPx);
        path.transform(this.mViewPortHandler.getMatrixTouch());
        path.transform(this.mMatrixOffset);
    }

    public void pixelsToValue(float[] fArr) {
        Matrix matrix = this.mPixelToValueMatrixBuffer;
        matrix.reset();
        this.mMatrixOffset.invert(matrix);
        matrix.mapPoints(fArr);
        this.mViewPortHandler.getMatrixTouch().invert(matrix);
        matrix.mapPoints(fArr);
        this.mMatrixValueToPx.invert(matrix);
        matrix.mapPoints(fArr);
    }

    public void pointValuesToPixel(float[] fArr) {
        this.mMatrixValueToPx.mapPoints(fArr);
        this.mViewPortHandler.getMatrixTouch().mapPoints(fArr);
        this.mMatrixOffset.mapPoints(fArr);
    }

    public void prepareMatrixOffset(boolean z5) {
        this.mMatrixOffset.reset();
        if (!z5) {
            this.mMatrixOffset.postTranslate(this.mViewPortHandler.offsetLeft(), this.mViewPortHandler.getChartHeight() - this.mViewPortHandler.offsetBottom());
        } else {
            this.mMatrixOffset.setTranslate(this.mViewPortHandler.offsetLeft(), -this.mViewPortHandler.offsetTop());
            this.mMatrixOffset.postScale(1.0f, -1.0f);
        }
    }

    public void prepareMatrixValuePx(float f6, float f7, float f8, float f9) {
        float contentWidth = this.mViewPortHandler.contentWidth() / f7;
        float contentHeight = this.mViewPortHandler.contentHeight() / f8;
        if (Float.isInfinite(contentWidth)) {
            contentWidth = 0.0f;
        }
        if (Float.isInfinite(contentHeight)) {
            contentHeight = 0.0f;
        }
        this.mMatrixValueToPx.reset();
        this.mMatrixValueToPx.postTranslate(-f6, -f9);
        this.mMatrixValueToPx.postScale(contentWidth, -contentHeight);
    }

    public void rectToPixelPhase(RectF rectF, float f6) {
        rectF.top *= f6;
        rectF.bottom *= f6;
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }

    public void rectToPixelPhaseHorizontal(RectF rectF, float f6) {
        rectF.left *= f6;
        rectF.right *= f6;
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }

    public void rectValueToPixel(RectF rectF) {
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }

    public Transformer(ViewPortHandler viewPortHandler) {
        this.mViewPortHandler = viewPortHandler;
    }

    public Matrix getPixelToValueMatrix() {
        getValueToPixelMatrix().invert(this.mMBuffer2);
        return this.mMBuffer2;
    }

    public void getValuesByTouchPoint(float f6, float f7, MPPointD mPPointD) {
        float[] fArr = this.ptsBuffer;
        fArr[0] = f6;
        fArr[1] = f7;
        pixelsToValue(fArr);
        float[] fArr2 = this.ptsBuffer;
        mPPointD.f32563x = fArr2[0];
        mPPointD.f32564y = fArr2[1];
    }

    public void rectValuesToPixel(List<RectF> list) {
        Matrix valueToPixelMatrix = getValueToPixelMatrix();
        for (int i6 = 0; i6 < list.size(); i6++) {
            valueToPixelMatrix.mapRect(list.get(i6));
        }
    }

    public void rectValueToPixelHorizontal(RectF rectF, float f6) {
        rectF.left *= f6;
        rectF.right *= f6;
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }
}
