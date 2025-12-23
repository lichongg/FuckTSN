package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.PieHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.PieChartRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class PieChart extends PieRadarChartBase<PieData> {
    private float[] mAbsoluteAngles;
    private CharSequence mCenterText;
    private MPPointF mCenterTextOffset;
    private float mCenterTextRadiusPercent;
    private RectF mCircleBox;
    private float[] mDrawAngles;
    private boolean mDrawCenterText;
    private boolean mDrawEntryLabels;
    private boolean mDrawHole;
    private boolean mDrawRoundedSlices;
    private boolean mDrawSlicesUnderHole;
    private float mHoleRadiusPercent;
    protected float mMaxAngle;
    private float mMinAngleForSlices;
    protected float mTransparentCircleRadiusPercent;
    private boolean mUsePercentValues;

    public PieChart(Context context) {
        super(context);
        this.mCircleBox = new RectF();
        this.mDrawEntryLabels = true;
        this.mDrawAngles = new float[1];
        this.mAbsoluteAngles = new float[1];
        this.mDrawHole = true;
        this.mDrawSlicesUnderHole = false;
        this.mUsePercentValues = false;
        this.mDrawRoundedSlices = false;
        this.mCenterText = "";
        this.mCenterTextOffset = MPPointF.getInstance(0.0f, 0.0f);
        this.mHoleRadiusPercent = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.mDrawCenterText = true;
        this.mCenterTextRadiusPercent = 100.0f;
        this.mMaxAngle = 360.0f;
        this.mMinAngleForSlices = 0.0f;
    }

    private float calcAngle(float f6) {
        return calcAngle(f6, ((PieData) this.mData).getYValueSum());
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredBaseOffset() {
        return 0.0f;
    }

    private float calcAngle(float f6, float f7) {
        return (f6 / f7) * this.mMaxAngle;
    }

    private void calcAngles() {
        int entryCount = ((PieData) this.mData).getEntryCount();
        if (this.mDrawAngles.length != entryCount) {
            this.mDrawAngles = new float[entryCount];
        } else {
            for (int i6 = 0; i6 < entryCount; i6++) {
                this.mDrawAngles[i6] = 0.0f;
            }
        }
        if (this.mAbsoluteAngles.length != entryCount) {
            this.mAbsoluteAngles = new float[entryCount];
        } else {
            for (int i7 = 0; i7 < entryCount; i7++) {
                this.mAbsoluteAngles[i7] = 0.0f;
            }
        }
        float yValueSum = ((PieData) this.mData).getYValueSum();
        List<IPieDataSet> dataSets = ((PieData) this.mData).getDataSets();
        float f6 = this.mMinAngleForSlices;
        boolean z5 = f6 != 0.0f && ((float) entryCount) * f6 <= this.mMaxAngle;
        float[] fArr = new float[entryCount];
        float f7 = 0.0f;
        float f8 = 0.0f;
        int i8 = 0;
        for (int i9 = 0; i9 < ((PieData) this.mData).getDataSetCount(); i9++) {
            IPieDataSet iPieDataSet = dataSets.get(i9);
            for (int i10 = 0; i10 < iPieDataSet.getEntryCount(); i10++) {
                float calcAngle = calcAngle(Math.abs(iPieDataSet.getEntryForIndex(i10).getY()), yValueSum);
                if (z5) {
                    float f9 = this.mMinAngleForSlices;
                    float f10 = calcAngle - f9;
                    if (f10 <= 0.0f) {
                        fArr[i8] = f9;
                        f7 += -f10;
                    } else {
                        fArr[i8] = calcAngle;
                        f8 += f10;
                    }
                }
                this.mDrawAngles[i8] = calcAngle;
                if (i8 == 0) {
                    this.mAbsoluteAngles[i8] = calcAngle;
                } else {
                    float[] fArr2 = this.mAbsoluteAngles;
                    fArr2[i8] = fArr2[i8 - 1] + calcAngle;
                }
                i8++;
            }
        }
        if (z5) {
            for (int i11 = 0; i11 < entryCount; i11++) {
                float f11 = fArr[i11];
                float f12 = f11 - (((f11 - this.mMinAngleForSlices) / f8) * f7);
                fArr[i11] = f12;
                if (i11 == 0) {
                    this.mAbsoluteAngles[0] = fArr[0];
                } else {
                    float[] fArr3 = this.mAbsoluteAngles;
                    fArr3[i11] = fArr3[i11 - 1] + f12;
                }
            }
            this.mDrawAngles = fArr;
        }
    }

    public float[] getAbsoluteAngles() {
        return this.mAbsoluteAngles;
    }

    public MPPointF getCenterCircleBox() {
        return MPPointF.getInstance(this.mCircleBox.centerX(), this.mCircleBox.centerY());
    }

    public CharSequence getCenterText() {
        return this.mCenterText;
    }

    public MPPointF getCenterTextOffset() {
        MPPointF mPPointF = this.mCenterTextOffset;
        return MPPointF.getInstance(mPPointF.f32565x, mPPointF.f32566y);
    }

    public float getCenterTextRadiusPercent() {
        return this.mCenterTextRadiusPercent;
    }

    public RectF getCircleBox() {
        return this.mCircleBox;
    }

    public int getDataSetIndexForIndex(int i6) {
        List<IPieDataSet> dataSets = ((PieData) this.mData).getDataSets();
        for (int i7 = 0; i7 < dataSets.size(); i7++) {
            if (dataSets.get(i7).getEntryForXValue(i6, Float.NaN) != null) {
                return i7;
            }
        }
        return -1;
    }

    public float[] getDrawAngles() {
        return this.mDrawAngles;
    }

    public float getHoleRadius() {
        return this.mHoleRadiusPercent;
    }

    public float getMaxAngle() {
        return this.mMaxAngle;
    }

    public float getMinAngleForSlices() {
        return this.mMinAngleForSlices;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF rectF = this.mCircleBox;
        if (rectF == null) {
            return 0.0f;
        }
        return Math.min(rectF.width() / 2.0f, this.mCircleBox.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredLegendOffset() {
        return this.mLegendRenderer.getLabelPaint().getTextSize() * 2.0f;
    }

    public float getTransparentCircleRadius() {
        return this.mTransparentCircleRadiusPercent;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    @Deprecated
    public XAxis getXAxis() {
        throw new RuntimeException("PieChart has no XAxis");
    }

    public boolean isDrawCenterTextEnabled() {
        return this.mDrawCenterText;
    }

    public boolean isDrawEntryLabelsEnabled() {
        return this.mDrawEntryLabels;
    }

    public boolean isDrawHoleEnabled() {
        return this.mDrawHole;
    }

    public boolean isDrawRoundedSlicesEnabled() {
        return this.mDrawRoundedSlices;
    }

    public boolean isDrawSlicesUnderHoleEnabled() {
        return this.mDrawSlicesUnderHole;
    }

    public boolean isUsePercentValuesEnabled() {
        return this.mUsePercentValues;
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        DataRenderer dataRenderer = this.mRenderer;
        if (dataRenderer != null && (dataRenderer instanceof PieChartRenderer)) {
            ((PieChartRenderer) dataRenderer).releaseBitmap();
        }
        super.onDetachedFromWindow();
    }

    public void setCenterText(CharSequence charSequence) {
        if (charSequence == null) {
            this.mCenterText = "";
        } else {
            this.mCenterText = charSequence;
        }
    }

    public void setCenterTextColor(int i6) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setColor(i6);
    }

    public void setCenterTextOffset(float f6, float f7) {
        this.mCenterTextOffset.f32565x = Utils.convertDpToPixel(f6);
        this.mCenterTextOffset.f32566y = Utils.convertDpToPixel(f7);
    }

    public void setCenterTextRadiusPercent(float f6) {
        this.mCenterTextRadiusPercent = f6;
    }

    public void setCenterTextSize(float f6) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTextSize(Utils.convertDpToPixel(f6));
    }

    public void setCenterTextSizePixels(float f6) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTextSize(f6);
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTypeface(typeface);
    }

    public void setDrawCenterText(boolean z5) {
        this.mDrawCenterText = z5;
    }

    public void setDrawEntryLabels(boolean z5) {
        this.mDrawEntryLabels = z5;
    }

    public void setDrawHoleEnabled(boolean z5) {
        this.mDrawHole = z5;
    }

    public void setDrawRoundedSlices(boolean z5) {
        this.mDrawRoundedSlices = z5;
    }

    @Deprecated
    public void setDrawSliceText(boolean z5) {
        this.mDrawEntryLabels = z5;
    }

    public void setDrawSlicesUnderHole(boolean z5) {
        this.mDrawSlicesUnderHole = z5;
    }

    public void setEntryLabelColor(int i6) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setColor(i6);
    }

    public void setEntryLabelTextSize(float f6) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setTextSize(Utils.convertDpToPixel(f6));
    }

    public void setEntryLabelTypeface(Typeface typeface) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setTypeface(typeface);
    }

    public void setHoleColor(int i6) {
        ((PieChartRenderer) this.mRenderer).getPaintHole().setColor(i6);
    }

    public void setHoleRadius(float f6) {
        this.mHoleRadiusPercent = f6;
    }

    public void setMaxAngle(float f6) {
        if (f6 > 360.0f) {
            f6 = 360.0f;
        }
        if (f6 < 90.0f) {
            f6 = 90.0f;
        }
        this.mMaxAngle = f6;
    }

    public void setMinAngleForSlices(float f6) {
        float f7 = this.mMaxAngle;
        if (f6 > f7 / 2.0f) {
            f6 = f7 / 2.0f;
        } else if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        this.mMinAngleForSlices = f6;
    }

    public void setTransparentCircleAlpha(int i6) {
        ((PieChartRenderer) this.mRenderer).getPaintTransparentCircle().setAlpha(i6);
    }

    public void setTransparentCircleColor(int i6) {
        Paint paintTransparentCircle = ((PieChartRenderer) this.mRenderer).getPaintTransparentCircle();
        int alpha = paintTransparentCircle.getAlpha();
        paintTransparentCircle.setColor(i6);
        paintTransparentCircle.setAlpha(alpha);
    }

    public void setTransparentCircleRadius(float f6) {
        this.mTransparentCircleRadiusPercent = f6;
    }

    public void setUsePercentValues(boolean z5) {
        this.mUsePercentValues = z5;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void calcMinMax() {
        calcAngles();
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void calculateOffsets() {
        super.calculateOffsets();
        if (this.mData == 0) {
            return;
        }
        float diameter = getDiameter() / 2.0f;
        MPPointF centerOffsets = getCenterOffsets();
        float selectionShift = ((PieData) this.mData).getDataSet().getSelectionShift();
        RectF rectF = this.mCircleBox;
        float f6 = centerOffsets.f32565x;
        float f7 = centerOffsets.f32566y;
        rectF.set((f6 - diameter) + selectionShift, (f7 - diameter) + selectionShift, (f6 + diameter) - selectionShift, (f7 + diameter) - selectionShift);
        MPPointF.recycleInstance(centerOffsets);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public int getIndexForAngle(float f6) {
        float normalizedAngle = Utils.getNormalizedAngle(f6 - getRotationAngle());
        int i6 = 0;
        while (true) {
            float[] fArr = this.mAbsoluteAngles;
            if (i6 < fArr.length) {
                if (fArr[i6] > normalizedAngle) {
                    return i6;
                }
                i6++;
            } else {
                return -1;
            }
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected float[] getMarkerPosition(Highlight highlight) {
        MPPointF centerCircleBox = getCenterCircleBox();
        float radius = getRadius();
        float f6 = (radius / 10.0f) * 3.6f;
        if (isDrawHoleEnabled()) {
            f6 = (radius - ((radius / 100.0f) * getHoleRadius())) / 2.0f;
        }
        float f7 = radius - f6;
        float rotationAngle = getRotationAngle();
        float f8 = this.mDrawAngles[(int) highlight.getX()] / 2.0f;
        double d6 = f7;
        float cos = (float) ((Math.cos(Math.toRadians(((this.mAbsoluteAngles[r11] + rotationAngle) - f8) * this.mAnimator.getPhaseY())) * d6) + centerCircleBox.f32565x);
        float sin = (float) ((d6 * Math.sin(Math.toRadians(((rotationAngle + this.mAbsoluteAngles[r11]) - f8) * this.mAnimator.getPhaseY()))) + centerCircleBox.f32566y);
        MPPointF.recycleInstance(centerCircleBox);
        return new float[]{cos, sin};
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mRenderer = new PieChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mXAxis = null;
        this.mHighlighter = new PieHighlighter(this);
    }

    public boolean needsHighlight(int i6) {
        if (!valuesToHighlight()) {
            return false;
        }
        int i7 = 0;
        while (true) {
            Highlight[] highlightArr = this.mIndicesToHighlight;
            if (i7 >= highlightArr.length) {
                return false;
            }
            if (((int) highlightArr[i7].getX()) == i6) {
                return true;
            }
            i7++;
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mData == 0) {
            return;
        }
        this.mRenderer.drawData(canvas);
        if (valuesToHighlight()) {
            this.mRenderer.drawHighlighted(canvas, this.mIndicesToHighlight);
        }
        this.mRenderer.drawExtras(canvas);
        this.mRenderer.drawValues(canvas);
        this.mLegendRenderer.renderLegend(canvas);
        drawDescription(canvas);
        drawMarkers(canvas);
    }

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCircleBox = new RectF();
        this.mDrawEntryLabels = true;
        this.mDrawAngles = new float[1];
        this.mAbsoluteAngles = new float[1];
        this.mDrawHole = true;
        this.mDrawSlicesUnderHole = false;
        this.mUsePercentValues = false;
        this.mDrawRoundedSlices = false;
        this.mCenterText = "";
        this.mCenterTextOffset = MPPointF.getInstance(0.0f, 0.0f);
        this.mHoleRadiusPercent = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.mDrawCenterText = true;
        this.mCenterTextRadiusPercent = 100.0f;
        this.mMaxAngle = 360.0f;
        this.mMinAngleForSlices = 0.0f;
    }

    public PieChart(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mCircleBox = new RectF();
        this.mDrawEntryLabels = true;
        this.mDrawAngles = new float[1];
        this.mAbsoluteAngles = new float[1];
        this.mDrawHole = true;
        this.mDrawSlicesUnderHole = false;
        this.mUsePercentValues = false;
        this.mDrawRoundedSlices = false;
        this.mCenterText = "";
        this.mCenterTextOffset = MPPointF.getInstance(0.0f, 0.0f);
        this.mHoleRadiusPercent = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.mDrawCenterText = true;
        this.mCenterTextRadiusPercent = 100.0f;
        this.mMaxAngle = 360.0f;
        this.mMinAngleForSlices = 0.0f;
    }
}
