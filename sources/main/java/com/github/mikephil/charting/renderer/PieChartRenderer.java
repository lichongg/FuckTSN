package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class PieChartRenderer extends DataRenderer {
    protected Canvas mBitmapCanvas;
    private RectF mCenterTextLastBounds;
    private CharSequence mCenterTextLastValue;
    private StaticLayout mCenterTextLayout;
    private TextPaint mCenterTextPaint;
    protected PieChart mChart;
    protected WeakReference<Bitmap> mDrawBitmap;
    protected Path mDrawCenterTextPathBuffer;
    protected RectF mDrawHighlightedRectF;
    private Paint mEntryLabelsPaint;
    private Path mHoleCirclePath;
    protected Paint mHolePaint;
    private RectF mInnerRectBuffer;
    private Path mPathBuffer;
    private RectF[] mRectBuffer;
    protected Paint mTransparentCirclePaint;
    protected Paint mValueLinePaint;

    protected void drawDataSet(Canvas canvas, IPieDataSet iPieDataSet) {
        float f6;
        float f7;
        float f8;
        int i6;
        int i7;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        RectF rectF;
        float f15;
        int i8;
        float f16;
        float f17;
        int i9;
        float f18;
        PieChartRenderer pieChartRenderer = this;
        IPieDataSet iPieDataSet2 = iPieDataSet;
        float rotationAngle = pieChartRenderer.mChart.getRotationAngle();
        float phaseX = pieChartRenderer.mAnimator.getPhaseX();
        float phaseY = pieChartRenderer.mAnimator.getPhaseY();
        RectF circleBox = pieChartRenderer.mChart.getCircleBox();
        int entryCount = iPieDataSet2.getEntryCount();
        float[] drawAngles = pieChartRenderer.mChart.getDrawAngles();
        MPPointF centerCircleBox = pieChartRenderer.mChart.getCenterCircleBox();
        float radius = pieChartRenderer.mChart.getRadius();
        boolean z5 = pieChartRenderer.mChart.isDrawHoleEnabled() && !pieChartRenderer.mChart.isDrawSlicesUnderHoleEnabled();
        float holeRadius = z5 ? (pieChartRenderer.mChart.getHoleRadius() / 100.0f) * radius : 0.0f;
        float holeRadius2 = (radius - ((pieChartRenderer.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        RectF rectF2 = new RectF();
        boolean z6 = z5 && pieChartRenderer.mChart.isDrawRoundedSlicesEnabled();
        int i10 = 0;
        for (int i11 = 0; i11 < entryCount; i11++) {
            if (Math.abs(iPieDataSet2.getEntryForIndex(i11).getY()) > Utils.FLOAT_EPSILON) {
                i10++;
            }
        }
        float sliceSpace = i10 <= 1 ? 0.0f : pieChartRenderer.getSliceSpace(iPieDataSet2);
        int i12 = 0;
        float f19 = 0.0f;
        while (i12 < entryCount) {
            float f20 = drawAngles[i12];
            float abs = Math.abs(iPieDataSet2.getEntryForIndex(i12).getY());
            float f21 = Utils.FLOAT_EPSILON;
            if (abs > f21 && (!pieChartRenderer.mChart.needsHighlight(i12) || z6)) {
                boolean z7 = sliceSpace > 0.0f && f20 <= 180.0f;
                pieChartRenderer.mRenderPaint.setColor(iPieDataSet2.getColor(i12));
                float f22 = i10 == 1 ? 0.0f : sliceSpace / (radius * 0.017453292f);
                float f23 = rotationAngle + ((f19 + (f22 / 2.0f)) * phaseY);
                float f24 = (f20 - f22) * phaseY;
                if (f24 < 0.0f) {
                    f6 = 0.0f;
                    f8 = holeRadius;
                    f7 = 0.017453292f;
                } else {
                    f6 = f24;
                    f7 = 0.017453292f;
                    f8 = holeRadius;
                }
                pieChartRenderer.mPathBuffer.reset();
                if (z6) {
                    float f25 = radius - holeRadius2;
                    i6 = i12;
                    double d6 = f23 * f7;
                    float cos = centerCircleBox.f32565x + (((float) Math.cos(d6)) * f25);
                    float sin = centerCircleBox.f32566y + (f25 * ((float) Math.sin(d6)));
                    i7 = i10;
                    rectF2.set(cos - holeRadius2, sin - holeRadius2, cos + holeRadius2, sin + holeRadius2);
                } else {
                    i6 = i12;
                    i7 = i10;
                }
                double d7 = f23 * f7;
                float cos2 = (((float) Math.cos(d7)) * radius) + centerCircleBox.f32565x;
                float sin2 = centerCircleBox.f32566y + (((float) Math.sin(d7)) * radius);
                if (f6 < 360.0f || f6 % 360.0f > f21) {
                    f9 = cos2;
                    f10 = sin2;
                    f11 = 360.0f;
                    if (z6) {
                        pieChartRenderer.mPathBuffer.arcTo(rectF2, f23 + 180.0f, -180.0f);
                    }
                    pieChartRenderer.mPathBuffer.arcTo(circleBox, f23, f6);
                } else {
                    f11 = 360.0f;
                    f9 = cos2;
                    f10 = sin2;
                    pieChartRenderer.mPathBuffer.addCircle(centerCircleBox.f32565x, centerCircleBox.f32566y, radius, Path.Direction.CW);
                }
                RectF rectF3 = pieChartRenderer.mInnerRectBuffer;
                float f26 = centerCircleBox.f32565x;
                float f27 = centerCircleBox.f32566y;
                rectF3.set(f26 - f8, f27 - f8, f26 + f8, f27 + f8);
                if (!z5 || (f8 <= 0.0f && !z7)) {
                    pieChartRenderer = this;
                    f12 = phaseX;
                    f13 = phaseY;
                    float f28 = f6;
                    f14 = f8;
                    float f29 = f9;
                    float f30 = f10;
                    rectF = rectF2;
                    f15 = rotationAngle;
                    i8 = i7;
                    if (f28 % f11 > f21) {
                        if (z7) {
                            float calculateMinimumRadiusForSpacedSlice = pieChartRenderer.calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f20 * f13, f29, f30, f23, f28);
                            double d8 = (f23 + (f28 / 2.0f)) * f7;
                            pieChartRenderer.mPathBuffer.lineTo(centerCircleBox.f32565x + (((float) Math.cos(d8)) * calculateMinimumRadiusForSpacedSlice), centerCircleBox.f32566y + (calculateMinimumRadiusForSpacedSlice * ((float) Math.sin(d8))));
                        } else {
                            pieChartRenderer.mPathBuffer.lineTo(centerCircleBox.f32565x, centerCircleBox.f32566y);
                        }
                    }
                } else {
                    if (z7) {
                        f12 = phaseX;
                        f16 = f6;
                        f17 = f8;
                        i9 = 1;
                        rectF = rectF2;
                        f15 = rotationAngle;
                        i8 = i7;
                        pieChartRenderer = this;
                        float calculateMinimumRadiusForSpacedSlice2 = pieChartRenderer.calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f20 * phaseY, f9, f10, f23, f16);
                        if (calculateMinimumRadiusForSpacedSlice2 < 0.0f) {
                            calculateMinimumRadiusForSpacedSlice2 = -calculateMinimumRadiusForSpacedSlice2;
                        }
                        f18 = Math.max(f17, calculateMinimumRadiusForSpacedSlice2);
                    } else {
                        pieChartRenderer = this;
                        f12 = phaseX;
                        f16 = f6;
                        f17 = f8;
                        i9 = 1;
                        rectF = rectF2;
                        f15 = rotationAngle;
                        i8 = i7;
                        f18 = f17;
                    }
                    float f31 = (i8 == i9 || f18 == 0.0f) ? 0.0f : sliceSpace / (f18 * f7);
                    float f32 = f15 + ((f19 + (f31 / 2.0f)) * phaseY);
                    float f33 = (f20 - f31) * phaseY;
                    if (f33 < 0.0f) {
                        f33 = 0.0f;
                    }
                    float f34 = f32 + f33;
                    if (f6 < 360.0f || f16 % f11 > f21) {
                        if (z6) {
                            float f35 = radius - holeRadius2;
                            f13 = phaseY;
                            double d9 = f34 * f7;
                            float cos3 = centerCircleBox.f32565x + (f35 * ((float) Math.cos(d9)));
                            float sin3 = centerCircleBox.f32566y + (((float) Math.sin(d9)) * f35);
                            rectF.set(cos3 - holeRadius2, sin3 - holeRadius2, cos3 + holeRadius2, sin3 + holeRadius2);
                            pieChartRenderer.mPathBuffer.arcTo(rectF, f34, 180.0f);
                            f14 = f17;
                        } else {
                            f13 = phaseY;
                            double d10 = f34 * f7;
                            f14 = f17;
                            pieChartRenderer.mPathBuffer.lineTo(centerCircleBox.f32565x + (((float) Math.cos(d10)) * f18), centerCircleBox.f32566y + (f18 * ((float) Math.sin(d10))));
                        }
                        pieChartRenderer.mPathBuffer.arcTo(pieChartRenderer.mInnerRectBuffer, f34, -f33);
                    } else {
                        pieChartRenderer.mPathBuffer.addCircle(centerCircleBox.f32565x, centerCircleBox.f32566y, f18, Path.Direction.CCW);
                        f14 = f17;
                        f13 = phaseY;
                    }
                }
                pieChartRenderer.mPathBuffer.close();
                pieChartRenderer.mBitmapCanvas.drawPath(pieChartRenderer.mPathBuffer, pieChartRenderer.mRenderPaint);
                f19 += f20 * f12;
            } else {
                f19 += f20 * phaseX;
                rectF = rectF2;
                f14 = holeRadius;
                i6 = i12;
                f15 = rotationAngle;
                f12 = phaseX;
                f13 = phaseY;
                i8 = i10;
            }
            i12 = i6 + 1;
            iPieDataSet2 = iPieDataSet;
            i10 = i8;
            rectF2 = rectF;
            holeRadius = f14;
            rotationAngle = f15;
            phaseX = f12;
            phaseY = f13;
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    protected float calculateMinimumRadiusForSpacedSlice(MPPointF mPPointF, float f6, float f7, float f8, float f9, float f10, float f11) {
        double d6 = (f10 + f11) * 0.017453292f;
        float cos = mPPointF.f32565x + (((float) Math.cos(d6)) * f6);
        float sin = mPPointF.f32566y + (((float) Math.sin(d6)) * f6);
        double d7 = (f10 + (f11 / 2.0f)) * 0.017453292f;
        return (float) ((f6 - ((float) ((Math.sqrt(Math.pow(cos - f8, 2.0d) + Math.pow(sin - f9, 2.0d)) / 2.0d) * Math.tan(((180.0d - f7) / 2.0d) * 0.017453292519943295d)))) - Math.sqrt(Math.pow((mPPointF.f32565x + (((float) Math.cos(d7)) * f6)) - ((cos + f8) / 2.0f), 2.0d) + Math.pow((mPPointF.f32566y + (((float) Math.sin(d7)) * f6)) - ((sin + f9) / 2.0f), 2.0d)));
    }

    protected void drawCenterText(Canvas canvas) {
        CharSequence centerText = this.mChart.getCenterText();
        if (!this.mChart.isDrawCenterTextEnabled() || centerText == null) {
            return;
        }
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        MPPointF centerTextOffset = this.mChart.getCenterTextOffset();
        float f6 = centerCircleBox.f32565x + centerTextOffset.f32565x;
        float f7 = centerCircleBox.f32566y + centerTextOffset.f32566y;
        float radius = (!this.mChart.isDrawHoleEnabled() || this.mChart.isDrawSlicesUnderHoleEnabled()) ? this.mChart.getRadius() : this.mChart.getRadius() * (this.mChart.getHoleRadius() / 100.0f);
        RectF[] rectFArr = this.mRectBuffer;
        RectF rectF = rectFArr[0];
        rectF.left = f6 - radius;
        rectF.top = f7 - radius;
        rectF.right = f6 + radius;
        rectF.bottom = f7 + radius;
        RectF rectF2 = rectFArr[1];
        rectF2.set(rectF);
        float centerTextRadiusPercent = this.mChart.getCenterTextRadiusPercent() / 100.0f;
        if (centerTextRadiusPercent > 0.0d) {
            rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (rectF2.height() * centerTextRadiusPercent)) / 2.0f);
        }
        if (!centerText.equals(this.mCenterTextLastValue) || !rectF2.equals(this.mCenterTextLastBounds)) {
            this.mCenterTextLastBounds.set(rectF2);
            this.mCenterTextLastValue = centerText;
            this.mCenterTextLayout = new StaticLayout(centerText, 0, centerText.length(), this.mCenterTextPaint, (int) Math.max(Math.ceil(this.mCenterTextLastBounds.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        }
        float height = this.mCenterTextLayout.getHeight();
        canvas.save();
        Path path = this.mDrawCenterTextPathBuffer;
        path.reset();
        path.addOval(rectF, Path.Direction.CW);
        canvas.clipPath(path);
        canvas.translate(rectF2.left, rectF2.top + ((rectF2.height() - height) / 2.0f));
        this.mCenterTextLayout.draw(canvas);
        canvas.restore();
        MPPointF.recycleInstance(centerCircleBox);
        MPPointF.recycleInstance(centerTextOffset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        int chartWidth = (int) this.mViewPortHandler.getChartWidth();
        int chartHeight = (int) this.mViewPortHandler.getChartHeight();
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        Bitmap bitmap = weakReference == null ? null : weakReference.get();
        if (bitmap == null || bitmap.getWidth() != chartWidth || bitmap.getHeight() != chartHeight) {
            if (chartWidth <= 0 || chartHeight <= 0) {
                return;
            }
            bitmap = Bitmap.createBitmap(chartWidth, chartHeight, Bitmap.Config.ARGB_4444);
            this.mDrawBitmap = new WeakReference<>(bitmap);
            this.mBitmapCanvas = new Canvas(bitmap);
        }
        bitmap.eraseColor(0);
        for (IPieDataSet iPieDataSet : ((PieData) this.mChart.getData()).getDataSets()) {
            if (iPieDataSet.isVisible() && iPieDataSet.getEntryCount() > 0) {
                drawDataSet(canvas, iPieDataSet);
            }
        }
    }

    protected void drawEntryLabel(Canvas canvas, String str, float f6, float f7) {
        canvas.drawText(str, f6, f7, this.mEntryLabelsPaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        IPieDataSet dataSetByIndex;
        int i6;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        RectF rectF;
        float f12;
        float f13;
        float f14;
        Highlight[] highlightArr2 = highlightArr;
        boolean z5 = this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled();
        if (z5 && this.mChart.isDrawRoundedSlicesEnabled()) {
            return;
        }
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float rotationAngle = this.mChart.getRotationAngle();
        float[] drawAngles = this.mChart.getDrawAngles();
        float[] absoluteAngles = this.mChart.getAbsoluteAngles();
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        float holeRadius = z5 ? (this.mChart.getHoleRadius() / 100.0f) * radius : 0.0f;
        RectF rectF2 = this.mDrawHighlightedRectF;
        rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i7 = 0;
        while (i7 < highlightArr2.length) {
            int x5 = (int) highlightArr2[i7].getX();
            if (x5 < drawAngles.length && (dataSetByIndex = ((PieData) this.mChart.getData()).getDataSetByIndex(highlightArr2[i7].getDataSetIndex())) != null && dataSetByIndex.isHighlightEnabled()) {
                int entryCount = dataSetByIndex.getEntryCount();
                int i8 = 0;
                for (int i9 = 0; i9 < entryCount; i9++) {
                    if (Math.abs(dataSetByIndex.getEntryForIndex(i9).getY()) > Utils.FLOAT_EPSILON) {
                        i8++;
                    }
                }
                float f15 = x5 == 0 ? 0.0f : absoluteAngles[x5 - 1] * phaseX;
                float sliceSpace = i8 <= 1 ? 0.0f : dataSetByIndex.getSliceSpace();
                float f16 = drawAngles[x5];
                float f17 = radius;
                float selectionShift = dataSetByIndex.getSelectionShift();
                float f18 = holeRadius;
                float f19 = f17 + selectionShift;
                i6 = i7;
                rectF2.set(this.mChart.getCircleBox());
                float f20 = -selectionShift;
                rectF2.inset(f20, f20);
                boolean z6 = sliceSpace > 0.0f && f16 <= 180.0f;
                this.mRenderPaint.setColor(dataSetByIndex.getColor(x5));
                float f21 = i8 == 1 ? 0.0f : sliceSpace / (f17 * 0.017453292f);
                float f22 = i8 == 1 ? 0.0f : sliceSpace / (f19 * 0.017453292f);
                float f23 = (((f21 / 2.0f) + f15) * phaseY) + rotationAngle;
                float f24 = (f16 - f21) * phaseY;
                float f25 = f24 < 0.0f ? 0.0f : f24;
                float f26 = (((f22 / 2.0f) + f15) * phaseY) + rotationAngle;
                float f27 = (f16 - f22) * phaseY;
                if (f27 < 0.0f) {
                    f27 = 0.0f;
                }
                this.mPathBuffer.reset();
                if (f25 < 360.0f || f25 % 360.0f > Utils.FLOAT_EPSILON) {
                    f6 = f25;
                    f7 = f15;
                    f8 = sliceSpace;
                    double d6 = f26 * 0.017453292f;
                    this.mPathBuffer.moveTo(centerCircleBox.f32565x + (((float) Math.cos(d6)) * f19), centerCircleBox.f32566y + (((float) Math.sin(d6)) * f19));
                    this.mPathBuffer.arcTo(rectF2, f26, f27);
                } else {
                    f6 = f25;
                    this.mPathBuffer.addCircle(centerCircleBox.f32565x, centerCircleBox.f32566y, f19, Path.Direction.CW);
                    f7 = f15;
                    f8 = sliceSpace;
                }
                if (z6) {
                    double d7 = f23 * 0.017453292f;
                    float cos = (((float) Math.cos(d7)) * f17) + centerCircleBox.f32565x;
                    float sin = centerCircleBox.f32566y + (((float) Math.sin(d7)) * f17);
                    f9 = f17;
                    rectF = rectF2;
                    f10 = f18;
                    f11 = f23;
                    f12 = calculateMinimumRadiusForSpacedSlice(centerCircleBox, f9, f16 * phaseY, cos, sin, f11, f6);
                } else {
                    f9 = f17;
                    f10 = f18;
                    f11 = f23;
                    rectF = rectF2;
                    f12 = 0.0f;
                }
                RectF rectF3 = this.mInnerRectBuffer;
                float f28 = centerCircleBox.f32565x;
                float f29 = centerCircleBox.f32566y;
                f13 = f9;
                rectF3.set(f28 - f10, f29 - f10, f28 + f10, f29 + f10);
                if (z5 && (f10 > 0.0f || z6)) {
                    if (z6) {
                        if (f12 < 0.0f) {
                            f12 = -f12;
                        }
                        f14 = Math.max(f10, f12);
                    } else {
                        f14 = f10;
                    }
                    float f30 = (i8 == 1 || f14 == 0.0f) ? 0.0f : f8 / (f14 * 0.017453292f);
                    float f31 = ((f7 + (f30 / 2.0f)) * phaseY) + rotationAngle;
                    float f32 = (f16 - f30) * phaseY;
                    if (f32 < 0.0f) {
                        f32 = 0.0f;
                    }
                    float f33 = f31 + f32;
                    if (f25 < 360.0f || f6 % 360.0f > Utils.FLOAT_EPSILON) {
                        double d8 = f33 * 0.017453292f;
                        this.mPathBuffer.lineTo(centerCircleBox.f32565x + (((float) Math.cos(d8)) * f14), centerCircleBox.f32566y + (f14 * ((float) Math.sin(d8))));
                        this.mPathBuffer.arcTo(this.mInnerRectBuffer, f33, -f32);
                    } else {
                        this.mPathBuffer.addCircle(centerCircleBox.f32565x, centerCircleBox.f32566y, f14, Path.Direction.CCW);
                    }
                } else if (f6 % 360.0f > Utils.FLOAT_EPSILON) {
                    if (z6) {
                        double d9 = (f11 + (f6 / 2.0f)) * 0.017453292f;
                        this.mPathBuffer.lineTo(centerCircleBox.f32565x + (((float) Math.cos(d9)) * f12), centerCircleBox.f32566y + (f12 * ((float) Math.sin(d9))));
                    } else {
                        this.mPathBuffer.lineTo(centerCircleBox.f32565x, centerCircleBox.f32566y);
                    }
                }
                this.mPathBuffer.close();
                this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
            } else {
                f13 = radius;
                f10 = holeRadius;
                rectF = rectF2;
                i6 = i7;
            }
            i7 = i6 + 1;
            highlightArr2 = highlightArr;
            holeRadius = f10;
            rectF2 = rectF;
            radius = f13;
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    protected void drawHole(Canvas canvas) {
        if (!this.mChart.isDrawHoleEnabled() || this.mBitmapCanvas == null) {
            return;
        }
        float radius = this.mChart.getRadius();
        float holeRadius = (this.mChart.getHoleRadius() / 100.0f) * radius;
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        if (Color.alpha(this.mHolePaint.getColor()) > 0) {
            this.mBitmapCanvas.drawCircle(centerCircleBox.f32565x, centerCircleBox.f32566y, holeRadius, this.mHolePaint);
        }
        if (Color.alpha(this.mTransparentCirclePaint.getColor()) > 0 && this.mChart.getTransparentCircleRadius() > this.mChart.getHoleRadius()) {
            int alpha = this.mTransparentCirclePaint.getAlpha();
            float transparentCircleRadius = radius * (this.mChart.getTransparentCircleRadius() / 100.0f);
            this.mTransparentCirclePaint.setAlpha((int) (alpha * this.mAnimator.getPhaseX() * this.mAnimator.getPhaseY()));
            this.mHoleCirclePath.reset();
            this.mHoleCirclePath.addCircle(centerCircleBox.f32565x, centerCircleBox.f32566y, transparentCircleRadius, Path.Direction.CW);
            this.mHoleCirclePath.addCircle(centerCircleBox.f32565x, centerCircleBox.f32566y, holeRadius, Path.Direction.CCW);
            this.mBitmapCanvas.drawPath(this.mHoleCirclePath, this.mTransparentCirclePaint);
            this.mTransparentCirclePaint.setAlpha(alpha);
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawRoundedSlices(Canvas canvas) {
        float f6;
        float f7;
        if (this.mChart.isDrawRoundedSlicesEnabled()) {
            IPieDataSet dataSet = ((PieData) this.mChart.getData()).getDataSet();
            if (dataSet.isVisible()) {
                float phaseX = this.mAnimator.getPhaseX();
                float phaseY = this.mAnimator.getPhaseY();
                MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
                float radius = this.mChart.getRadius();
                float holeRadius = (radius - ((this.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
                float[] drawAngles = this.mChart.getDrawAngles();
                float rotationAngle = this.mChart.getRotationAngle();
                int i6 = 0;
                while (i6 < dataSet.getEntryCount()) {
                    float f8 = drawAngles[i6];
                    if (Math.abs(dataSet.getEntryForIndex(i6).getY()) > Utils.FLOAT_EPSILON) {
                        double d6 = radius - holeRadius;
                        double d7 = (rotationAngle + f8) * phaseY;
                        f6 = phaseX;
                        f7 = phaseY;
                        float cos = (float) (centerCircleBox.f32565x + (Math.cos(Math.toRadians(d7)) * d6));
                        float sin = (float) ((d6 * Math.sin(Math.toRadians(d7))) + centerCircleBox.f32566y);
                        this.mRenderPaint.setColor(dataSet.getColor(i6));
                        this.mBitmapCanvas.drawCircle(cos, sin, holeRadius, this.mRenderPaint);
                    } else {
                        f6 = phaseX;
                        f7 = phaseY;
                    }
                    rotationAngle += f8 * f6;
                    i6++;
                    phaseX = f6;
                    phaseY = f7;
                }
                MPPointF.recycleInstance(centerCircleBox);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f6, float f7, int i6) {
        this.mValuePaint.setColor(i6);
        canvas.drawText(str, f6, f7, this.mValuePaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00b3  */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void drawValues(android.graphics.Canvas r51) {
        /*
            Method dump skipped, instructions count: 958
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.PieChartRenderer.drawValues(android.graphics.Canvas):void");
    }

    public TextPaint getPaintCenterText() {
        return this.mCenterTextPaint;
    }

    public Paint getPaintEntryLabels() {
        return this.mEntryLabelsPaint;
    }

    public Paint getPaintHole() {
        return this.mHolePaint;
    }

    public Paint getPaintTransparentCircle() {
        return this.mTransparentCirclePaint;
    }

    public void releaseBitmap() {
        Canvas canvas = this.mBitmapCanvas;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.mBitmapCanvas = null;
        }
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        if (weakReference != null) {
            Bitmap bitmap = weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.mDrawBitmap.clear();
            this.mDrawBitmap = null;
        }
    }

    public PieChartRenderer(PieChart pieChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mCenterTextLastBounds = new RectF();
        this.mRectBuffer = new RectF[]{new RectF(), new RectF(), new RectF()};
        this.mPathBuffer = new Path();
        this.mInnerRectBuffer = new RectF();
        this.mHoleCirclePath = new Path();
        this.mDrawCenterTextPathBuffer = new Path();
        this.mDrawHighlightedRectF = new RectF();
        this.mChart = pieChart;
        Paint paint = new Paint(1);
        this.mHolePaint = paint;
        paint.setColor(-1);
        Paint paint2 = this.mHolePaint;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.mTransparentCirclePaint = paint3;
        paint3.setColor(-1);
        this.mTransparentCirclePaint.setStyle(style);
        this.mTransparentCirclePaint.setAlpha(105);
        TextPaint textPaint = new TextPaint(1);
        this.mCenterTextPaint = textPaint;
        textPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mCenterTextPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        this.mValuePaint.setTextSize(Utils.convertDpToPixel(13.0f));
        this.mValuePaint.setColor(-1);
        Paint paint4 = this.mValuePaint;
        Paint.Align align = Paint.Align.CENTER;
        paint4.setTextAlign(align);
        Paint paint5 = new Paint(1);
        this.mEntryLabelsPaint = paint5;
        paint5.setColor(-1);
        this.mEntryLabelsPaint.setTextAlign(align);
        this.mEntryLabelsPaint.setTextSize(Utils.convertDpToPixel(13.0f));
        Paint paint6 = new Paint(1);
        this.mValueLinePaint = paint6;
        paint6.setStyle(Paint.Style.STROKE);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
        drawHole(canvas);
        canvas.drawBitmap(this.mDrawBitmap.get(), 0.0f, 0.0f, (Paint) null);
        drawCenterText(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected float getSliceSpace(IPieDataSet iPieDataSet) {
        if (!iPieDataSet.isAutomaticallyDisableSliceSpacingEnabled()) {
            return iPieDataSet.getSliceSpace();
        }
        if (iPieDataSet.getSliceSpace() / this.mViewPortHandler.getSmallestContentExtension() > (iPieDataSet.getYMin() / ((PieData) this.mChart.getData()).getYValueSum()) * 2.0f) {
            return 0.0f;
        }
        return iPieDataSet.getSliceSpace();
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }
}
