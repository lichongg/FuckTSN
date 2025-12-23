package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class AxisRenderer extends Renderer {
    protected AxisBase mAxis;
    protected Paint mAxisLabelPaint;
    protected Paint mAxisLinePaint;
    protected Paint mGridPaint;
    protected Paint mLimitLinePaint;
    protected Transformer mTrans;

    public abstract void renderAxisLabels(Canvas canvas);

    public abstract void renderAxisLine(Canvas canvas);

    public abstract void renderGridLines(Canvas canvas);

    public abstract void renderLimitLines(Canvas canvas);

    public void computeAxis(float f6, float f7, boolean z5) {
        float f8;
        double d6;
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        if (viewPortHandler != null && viewPortHandler.contentWidth() > 10.0f && !this.mViewPortHandler.isFullyZoomedOutY()) {
            MPPointD valuesByTouchPoint = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
            MPPointD valuesByTouchPoint2 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom());
            if (z5) {
                f8 = (float) valuesByTouchPoint.f32564y;
                d6 = valuesByTouchPoint2.f32564y;
            } else {
                f8 = (float) valuesByTouchPoint2.f32564y;
                d6 = valuesByTouchPoint.f32564y;
            }
            float f9 = (float) d6;
            MPPointD.recycleInstance(valuesByTouchPoint);
            MPPointD.recycleInstance(valuesByTouchPoint2);
            f6 = f8;
            f7 = f9;
        }
        computeAxisValues(f6, f7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7, types: [int] */
    /* JADX WARN: Type inference failed for: r7v9 */
    protected void computeAxisValues(float f6, float f7) {
        float f8 = f6;
        int labelCount = this.mAxis.getLabelCount();
        double abs = Math.abs(f7 - f8);
        if (labelCount == 0 || abs <= 0.0d || Double.isInfinite(abs)) {
            AxisBase axisBase = this.mAxis;
            axisBase.mEntries = new float[0];
            axisBase.mCenteredEntries = new float[0];
            axisBase.mEntryCount = 0;
            return;
        }
        double roundToNextSignificant = Utils.roundToNextSignificant(abs / labelCount);
        if (this.mAxis.isGranularityEnabled() && roundToNextSignificant < this.mAxis.getGranularity()) {
            roundToNextSignificant = this.mAxis.getGranularity();
        }
        double roundToNextSignificant2 = Utils.roundToNextSignificant(Math.pow(10.0d, (int) Math.log10(roundToNextSignificant)));
        if (((int) (roundToNextSignificant / roundToNextSignificant2)) > 5) {
            roundToNextSignificant = Math.floor(roundToNextSignificant2 * 10.0d);
        }
        ?? isCenterAxisLabelsEnabled = this.mAxis.isCenterAxisLabelsEnabled();
        if (this.mAxis.isForceLabelsEnabled()) {
            roundToNextSignificant = ((float) abs) / (labelCount - 1);
            AxisBase axisBase2 = this.mAxis;
            axisBase2.mEntryCount = labelCount;
            if (axisBase2.mEntries.length < labelCount) {
                axisBase2.mEntries = new float[labelCount];
            }
            for (int i6 = 0; i6 < labelCount; i6++) {
                this.mAxis.mEntries[i6] = f8;
                f8 = (float) (f8 + roundToNextSignificant);
            }
        } else {
            double ceil = roundToNextSignificant == 0.0d ? 0.0d : Math.ceil(f8 / roundToNextSignificant) * roundToNextSignificant;
            if (this.mAxis.isCenterAxisLabelsEnabled()) {
                ceil -= roundToNextSignificant;
            }
            double nextUp = roundToNextSignificant == 0.0d ? 0.0d : Utils.nextUp(Math.floor(f7 / roundToNextSignificant) * roundToNextSignificant);
            if (roundToNextSignificant != 0.0d) {
                double d6 = ceil;
                isCenterAxisLabelsEnabled = isCenterAxisLabelsEnabled;
                while (d6 <= nextUp) {
                    d6 += roundToNextSignificant;
                    isCenterAxisLabelsEnabled++;
                }
            }
            labelCount = isCenterAxisLabelsEnabled;
            AxisBase axisBase3 = this.mAxis;
            axisBase3.mEntryCount = labelCount;
            if (axisBase3.mEntries.length < labelCount) {
                axisBase3.mEntries = new float[labelCount];
            }
            for (int i7 = 0; i7 < labelCount; i7++) {
                if (ceil == 0.0d) {
                    ceil = 0.0d;
                }
                this.mAxis.mEntries[i7] = (float) ceil;
                ceil += roundToNextSignificant;
            }
        }
        if (roundToNextSignificant < 1.0d) {
            this.mAxis.mDecimals = (int) Math.ceil(-Math.log10(roundToNextSignificant));
        } else {
            this.mAxis.mDecimals = 0;
        }
        if (this.mAxis.isCenterAxisLabelsEnabled()) {
            AxisBase axisBase4 = this.mAxis;
            if (axisBase4.mCenteredEntries.length < labelCount) {
                axisBase4.mCenteredEntries = new float[labelCount];
            }
            float f9 = ((float) roundToNextSignificant) / 2.0f;
            for (int i8 = 0; i8 < labelCount; i8++) {
                AxisBase axisBase5 = this.mAxis;
                axisBase5.mCenteredEntries[i8] = axisBase5.mEntries[i8] + f9;
            }
        }
    }

    public Paint getPaintAxisLabels() {
        return this.mAxisLabelPaint;
    }

    public Paint getPaintAxisLine() {
        return this.mAxisLinePaint;
    }

    public Paint getPaintGrid() {
        return this.mGridPaint;
    }

    public Transformer getTransformer() {
        return this.mTrans;
    }

    public AxisRenderer(ViewPortHandler viewPortHandler, Transformer transformer, AxisBase axisBase) {
        super(viewPortHandler);
        this.mTrans = transformer;
        this.mAxis = axisBase;
        if (this.mViewPortHandler != null) {
            this.mAxisLabelPaint = new Paint(1);
            Paint paint = new Paint();
            this.mGridPaint = paint;
            paint.setColor(-7829368);
            this.mGridPaint.setStrokeWidth(1.0f);
            Paint paint2 = this.mGridPaint;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            this.mGridPaint.setAlpha(90);
            Paint paint3 = new Paint();
            this.mAxisLinePaint = paint3;
            paint3.setColor(ViewCompat.MEASURED_STATE_MASK);
            this.mAxisLinePaint.setStrokeWidth(1.0f);
            this.mAxisLinePaint.setStyle(style);
            Paint paint4 = new Paint(1);
            this.mLimitLinePaint = paint4;
            paint4.setStyle(style);
        }
    }
}
