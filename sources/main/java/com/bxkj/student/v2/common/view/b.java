package com.bxkj.student.v2.common.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b extends BarLineScatterCandleBubbleRenderer {

    /* renamed from: a, reason: collision with root package name */
    protected BarDataProvider f21082a;

    /* renamed from: b, reason: collision with root package name */
    protected RectF f21083b;

    /* renamed from: c, reason: collision with root package name */
    protected BarBuffer[] f21084c;

    /* renamed from: d, reason: collision with root package name */
    protected Paint f21085d;

    /* renamed from: e, reason: collision with root package name */
    protected Paint f21086e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f21087f;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas c6) {
        BarData barData = this.f21082a.getBarData();
        for (int i6 = 0; i6 < barData.getDataSetCount(); i6++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i6);
            if (iBarDataSet.isVisible()) {
                drawDataSet(c6, iBarDataSet, i6);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawDataSet(Canvas c6, IBarDataSet dataSet, int index) {
        Canvas canvas = c6;
        Transformer transformer = this.f21082a.getTransformer(dataSet.getAxisDependency());
        this.f21086e.setColor(dataSet.getBarBorderColor());
        this.f21086e.setStrokeWidth(Utils.convertDpToPixel(dataSet.getBarBorderWidth()));
        boolean z5 = dataSet.getBarBorderWidth() > 0.0f;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        if (this.f21082a.isDrawBarShadowEnabled()) {
            this.f21085d.setColor(dataSet.getBarShadowColor());
            float barWidth = this.f21082a.getBarData().getBarWidth() / 2.0f;
            int min = Math.min((int) Math.ceil(dataSet.getEntryCount() * phaseX), dataSet.getEntryCount());
            for (int i6 = 0; i6 < min; i6++) {
                float x5 = ((BarEntry) dataSet.getEntryForIndex(i6)).getX();
                RectF rectF = this.f21087f;
                rectF.left = x5 - barWidth;
                rectF.right = x5 + barWidth;
                transformer.rectValueToPixel(rectF);
                if (this.mViewPortHandler.isInBoundsLeft(this.f21087f.right)) {
                    if (!this.mViewPortHandler.isInBoundsRight(this.f21087f.left)) {
                        break;
                    }
                    this.f21087f.top = this.mViewPortHandler.contentTop();
                    this.f21087f.bottom = this.mViewPortHandler.contentBottom();
                    canvas.drawRect(this.f21087f, this.f21085d);
                }
            }
        }
        BarBuffer barBuffer = this.f21084c[index];
        barBuffer.setPhases(phaseX, phaseY);
        barBuffer.setDataSet(index);
        barBuffer.setInverted(this.f21082a.isInverted(dataSet.getAxisDependency()));
        barBuffer.setBarWidth(this.f21082a.getBarData().getBarWidth());
        barBuffer.feed(dataSet);
        transformer.pointValuesToPixel(barBuffer.buffer);
        boolean z6 = dataSet.getColors().size() == 1;
        if (z6) {
            this.mRenderPaint.setColor(dataSet.getColor());
        }
        int i7 = 0;
        while (i7 < barBuffer.size()) {
            int i8 = i7 + 2;
            if (this.mViewPortHandler.isInBoundsLeft(barBuffer.buffer[i8])) {
                if (!this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[i7])) {
                    return;
                }
                if (!z6) {
                    this.mRenderPaint.setColor(dataSet.getColor(i7 / 4));
                }
                if (dataSet.getGradientColor() != null) {
                    GradientColor gradientColor = dataSet.getGradientColor();
                    Paint paint = this.mRenderPaint;
                    float[] fArr = barBuffer.buffer;
                    float f6 = fArr[i7];
                    paint.setShader(new LinearGradient(f6, fArr[i7 + 3], f6, fArr[i7 + 1], gradientColor.getStartColor(), gradientColor.getEndColor(), Shader.TileMode.MIRROR));
                }
                if (dataSet.getGradientColors() != null) {
                    Paint paint2 = this.mRenderPaint;
                    float[] fArr2 = barBuffer.buffer;
                    float f7 = fArr2[i7];
                    float f8 = fArr2[i7 + 3];
                    float f9 = fArr2[i7 + 1];
                    int i9 = i7 / 4;
                    paint2.setShader(new LinearGradient(f7, f8, f7, f9, dataSet.getGradientColor(i9).getStartColor(), dataSet.getGradientColor(i9).getEndColor(), Shader.TileMode.MIRROR));
                }
                float[] fArr3 = barBuffer.buffer;
                int i10 = i7 + 1;
                int i11 = i7 + 3;
                RectF rectF2 = new RectF(fArr3[i7], fArr3[i10], fArr3[i8], fArr3[i11]);
                new Path();
                canvas.drawRoundRect(rectF2, 20.0f, 20.0f, this.mRenderPaint);
                if (z5) {
                    float[] fArr4 = barBuffer.buffer;
                    canvas.drawRect(fArr4[i7], fArr4[i10], fArr4[i8], fArr4[i11], this.f21086e);
                }
            }
            i7 += 4;
            canvas = c6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas c6, Highlight[] indices) {
        float y5;
        float f6;
        BarData barData = this.f21082a.getBarData();
        for (Highlight highlight : indices) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iBarDataSet != null && iBarDataSet.isHighlightEnabled()) {
                BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(barEntry, iBarDataSet)) {
                    Transformer transformer = this.f21082a.getTransformer(iBarDataSet.getAxisDependency());
                    this.mHighlightPaint.setColor(iBarDataSet.getHighLightColor());
                    this.mHighlightPaint.setAlpha(iBarDataSet.getHighLightAlpha());
                    if (highlight.getStackIndex() < 0 || !barEntry.isStacked()) {
                        y5 = barEntry.getY();
                        f6 = 0.0f;
                    } else if (this.f21082a.isHighlightFullBarEnabled()) {
                        y5 = barEntry.getPositiveSum();
                        f6 = -barEntry.getNegativeSum();
                    } else {
                        Range range = barEntry.getRanges()[highlight.getStackIndex()];
                        float f7 = range.from;
                        f6 = range.to;
                        y5 = f7;
                    }
                    prepareBarHighlight(barEntry.getX(), y5, f6, barData.getBarWidth() / 2.0f, transformer);
                    setHighlightDrawPos(highlight, this.f21083b);
                    c6.drawRect(this.f21083b, this.mHighlightPaint);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas c6, String valueText, float x5, float y5, int color) {
        this.mValuePaint.setColor(color);
        c6.drawText(valueText, x5, y5, this.mValuePaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas c6) {
        List list;
        MPPointF mPPointF;
        int i6;
        boolean z5;
        int i7;
        float[] fArr;
        float f6;
        Transformer transformer;
        int i8;
        float f7;
        int i9;
        float f8;
        float f9;
        BarEntry barEntry;
        float f10;
        float f11;
        boolean z6;
        int i10;
        ValueFormatter valueFormatter;
        List list2;
        MPPointF mPPointF2;
        BarEntry barEntry2;
        b bVar = this;
        if (bVar.isDrawingValuesAllowed(bVar.f21082a)) {
            List dataSets = bVar.f21082a.getBarData().getDataSets();
            float convertDpToPixel = Utils.convertDpToPixel(4.5f);
            boolean isDrawValueAboveBarEnabled = bVar.f21082a.isDrawValueAboveBarEnabled();
            int i11 = 0;
            while (i11 < bVar.f21082a.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i11);
                if (bVar.shouldDrawValues(iBarDataSet)) {
                    bVar.applyValueTextStyle(iBarDataSet);
                    boolean isInverted = bVar.f21082a.isInverted(iBarDataSet.getAxisDependency());
                    float calcTextHeight = Utils.calcTextHeight(bVar.mValuePaint, "8");
                    float f12 = isDrawValueAboveBarEnabled ? -convertDpToPixel : calcTextHeight + convertDpToPixel;
                    float f13 = isDrawValueAboveBarEnabled ? calcTextHeight + convertDpToPixel : -convertDpToPixel;
                    if (isInverted) {
                        f12 = (-f12) - calcTextHeight;
                        f13 = (-f13) - calcTextHeight;
                    }
                    float f14 = f12;
                    float f15 = f13;
                    BarBuffer barBuffer = bVar.f21084c[i11];
                    float phaseY = bVar.mAnimator.getPhaseY();
                    ValueFormatter valueFormatter2 = iBarDataSet.getValueFormatter();
                    MPPointF mPPointF3 = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    mPPointF3.f32565x = Utils.convertDpToPixel(mPPointF3.f32565x);
                    mPPointF3.f32566y = Utils.convertDpToPixel(mPPointF3.f32566y);
                    if (iBarDataSet.isStacked()) {
                        list = dataSets;
                        mPPointF = mPPointF3;
                        Transformer transformer2 = bVar.f21082a.getTransformer(iBarDataSet.getAxisDependency());
                        int i12 = 0;
                        int i13 = 0;
                        while (i12 < iBarDataSet.getEntryCount() * bVar.mAnimator.getPhaseX()) {
                            BarEntry barEntry3 = (BarEntry) iBarDataSet.getEntryForIndex(i12);
                            float[] yVals = barEntry3.getYVals();
                            float[] fArr2 = barBuffer.buffer;
                            float f16 = (fArr2[i13] + fArr2[i13 + 2]) / 2.0f;
                            int valueTextColor = iBarDataSet.getValueTextColor(i12);
                            if (yVals == null) {
                                Transformer transformer3 = transformer2;
                                if (!bVar.mViewPortHandler.isInBoundsRight(f16)) {
                                    break;
                                }
                                i6 = i12;
                                int i14 = i13 + 1;
                                if (bVar.mViewPortHandler.isInBoundsY(barBuffer.buffer[i14]) && bVar.mViewPortHandler.isInBoundsLeft(f16)) {
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        String barLabel = valueFormatter2.getBarLabel(barEntry3);
                                        float f17 = barBuffer.buffer[i14] + (barEntry3.getY() >= 0.0f ? f14 : f15);
                                        barEntry = barEntry3;
                                        f10 = f16;
                                        f6 = convertDpToPixel;
                                        transformer = transformer3;
                                        z5 = isDrawValueAboveBarEnabled;
                                        fArr = yVals;
                                        bVar.drawValue(c6, barLabel, f10, f17, valueTextColor);
                                    } else {
                                        f6 = convertDpToPixel;
                                        z5 = isDrawValueAboveBarEnabled;
                                        transformer = transformer3;
                                        barEntry = barEntry3;
                                        fArr = yVals;
                                        f10 = f16;
                                    }
                                    if (barEntry.getIcon() == null || !iBarDataSet.isDrawIconsEnabled()) {
                                        i7 = i11;
                                    } else {
                                        Drawable icon = barEntry.getIcon();
                                        float f18 = barBuffer.buffer[i14] + (barEntry.getY() >= 0.0f ? f14 : f15);
                                        i7 = i11;
                                        Utils.drawImage(c6, icon, (int) (f10 + mPPointF.f32565x), (int) (f18 + mPPointF.f32566y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                    }
                                } else {
                                    z5 = isDrawValueAboveBarEnabled;
                                    i7 = i11;
                                    transformer2 = transformer3;
                                    bVar = bVar;
                                    convertDpToPixel = convertDpToPixel;
                                    i12 = i6;
                                    i11 = i7;
                                    isDrawValueAboveBarEnabled = z5;
                                }
                            } else {
                                i6 = i12;
                                BarEntry barEntry4 = barEntry3;
                                float f19 = f16;
                                z5 = isDrawValueAboveBarEnabled;
                                i7 = i11;
                                int i15 = valueTextColor;
                                b bVar2 = bVar;
                                fArr = yVals;
                                f6 = convertDpToPixel;
                                transformer = transformer2;
                                int length = fArr.length * 2;
                                float[] fArr3 = new float[length];
                                float f20 = -barEntry4.getNegativeSum();
                                int i16 = 0;
                                int i17 = 0;
                                float f21 = 0.0f;
                                while (i16 < length) {
                                    float f22 = fArr[i17];
                                    if (f22 == 0.0f && (f21 == 0.0f || f20 == 0.0f)) {
                                        f9 = f20;
                                        f20 = f22;
                                    } else if (f22 >= 0.0f) {
                                        f21 += f22;
                                        f9 = f20;
                                        f20 = f21;
                                    } else {
                                        f9 = f20 - f22;
                                    }
                                    fArr3[i16 + 1] = f20 * phaseY;
                                    i16 += 2;
                                    i17++;
                                    f20 = f9;
                                }
                                transformer.pointValuesToPixel(fArr3);
                                int i18 = 0;
                                while (i18 < length) {
                                    float f23 = fArr[i18 / 2];
                                    int i19 = length;
                                    float f24 = fArr3[i18 + 1] + (((f23 > 0.0f ? 1 : (f23 == 0.0f ? 0 : -1)) == 0 && (f20 > 0.0f ? 1 : (f20 == 0.0f ? 0 : -1)) == 0 && (f21 > 0.0f ? 1 : (f21 == 0.0f ? 0 : -1)) > 0) || (f23 > 0.0f ? 1 : (f23 == 0.0f ? 0 : -1)) < 0 ? f15 : f14);
                                    float[] fArr4 = fArr3;
                                    if (!bVar2.mViewPortHandler.isInBoundsRight(f19)) {
                                        break;
                                    }
                                    if (bVar2.mViewPortHandler.isInBoundsY(f24) && bVar2.mViewPortHandler.isInBoundsLeft(f19)) {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            BarEntry barEntry5 = barEntry4;
                                            String barStackedLabel = valueFormatter2.getBarStackedLabel(f23, barEntry5);
                                            f8 = f24;
                                            b bVar3 = bVar2;
                                            i8 = i18;
                                            barEntry4 = barEntry5;
                                            bVar3.drawValue(c6, barStackedLabel, f19, f8, i15);
                                        } else {
                                            f8 = f24;
                                            i8 = i18;
                                        }
                                        f7 = f19;
                                        i9 = i15;
                                        if (barEntry4.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon2 = barEntry4.getIcon();
                                            Utils.drawImage(c6, icon2, (int) (f7 + mPPointF.f32565x), (int) (mPPointF.f32566y + f8), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                        }
                                    } else {
                                        i8 = i18;
                                        f7 = f19;
                                        i9 = i15;
                                    }
                                    i18 = i8 + 2;
                                    bVar2 = this;
                                    fArr3 = fArr4;
                                    f19 = f7;
                                    length = i19;
                                    i15 = i9;
                                }
                            }
                            i13 = fArr == null ? i13 + 4 : i13 + (fArr.length * 4);
                            i12 = i6 + 1;
                            bVar = this;
                            transformer2 = transformer;
                            convertDpToPixel = f6;
                            i11 = i7;
                            isDrawValueAboveBarEnabled = z5;
                        }
                    } else {
                        int i20 = 0;
                        while (i20 < barBuffer.buffer.length * bVar.mAnimator.getPhaseX()) {
                            float[] fArr5 = barBuffer.buffer;
                            float f25 = (fArr5[i20] + fArr5[i20 + 2]) / 2.0f;
                            if (!bVar.mViewPortHandler.isInBoundsRight(f25)) {
                                break;
                            }
                            int i21 = i20 + 1;
                            if (bVar.mViewPortHandler.isInBoundsY(barBuffer.buffer[i21]) && bVar.mViewPortHandler.isInBoundsLeft(f25)) {
                                int i22 = i20 / 4;
                                BarEntry barEntry6 = (BarEntry) iBarDataSet.getEntryForIndex(i22);
                                float y5 = barEntry6.getY();
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    MPPointF mPPointF4 = mPPointF3;
                                    String barLabel2 = valueFormatter2.getBarLabel(barEntry6);
                                    float f26 = y5 >= 0.0f ? barBuffer.buffer[i21] + f14 : barBuffer.buffer[i20 + 3] + f15;
                                    int valueTextColor2 = iBarDataSet.getValueTextColor(i22);
                                    list2 = dataSets;
                                    mPPointF2 = mPPointF4;
                                    barEntry2 = barEntry6;
                                    float f27 = f26;
                                    valueFormatter = valueFormatter2;
                                    bVar.drawValue(c6, barLabel2, f25, f27, valueTextColor2);
                                } else {
                                    valueFormatter = valueFormatter2;
                                    barEntry2 = barEntry6;
                                    list2 = dataSets;
                                    mPPointF2 = mPPointF3;
                                }
                                if (barEntry2.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon3 = barEntry2.getIcon();
                                    Utils.drawImage(c6, icon3, (int) (f25 + mPPointF2.f32565x), (int) ((y5 >= 0.0f ? barBuffer.buffer[i21] + f14 : barBuffer.buffer[i20 + 3] + f15) + mPPointF2.f32566y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                }
                            } else {
                                valueFormatter = valueFormatter2;
                                list2 = dataSets;
                                mPPointF2 = mPPointF3;
                            }
                            i20 += 4;
                            mPPointF3 = mPPointF2;
                            valueFormatter2 = valueFormatter;
                            dataSets = list2;
                        }
                        list = dataSets;
                        mPPointF = mPPointF3;
                    }
                    f11 = convertDpToPixel;
                    z6 = isDrawValueAboveBarEnabled;
                    i10 = i11;
                    MPPointF.recycleInstance(mPPointF);
                } else {
                    list = dataSets;
                    f11 = convertDpToPixel;
                    z6 = isDrawValueAboveBarEnabled;
                    i10 = i11;
                }
                i11 = i10 + 1;
                bVar = this;
                convertDpToPixel = f11;
                dataSets = list;
                isDrawValueAboveBarEnabled = z6;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData barData = this.f21082a.getBarData();
        this.f21084c = new BarBuffer[barData.getDataSetCount()];
        for (int i6 = 0; i6 < this.f21084c.length; i6++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i6);
            this.f21084c[i6] = new BarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    protected void prepareBarHighlight(float x5, float y12, float y22, float barWidthHalf, Transformer trans) {
        this.f21083b.set(x5 - barWidthHalf, y12, x5 + barWidthHalf, y22);
        trans.rectToPixelPhase(this.f21083b, this.mAnimator.getPhaseY());
    }

    public b(BarDataProvider chart, ChartAnimator animator, ViewPortHandler viewPortHandler) {
        super(animator, viewPortHandler);
        this.f21083b = new RectF();
        this.f21087f = new RectF();
        this.f21082a = chart;
        Paint paint = new Paint(1);
        this.mHighlightPaint = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.mHighlightPaint.setColor(Color.rgb(0, 0, 0));
        this.mHighlightPaint.setAlpha(120);
        Paint paint2 = new Paint(1);
        this.f21085d = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.f21086e = paint3;
        paint3.setStyle(Paint.Style.STROKE);
    }

    protected void setHighlightDrawPos(Highlight high, RectF bar) {
        high.setDraw(bar.centerX(), bar.top);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas c6) {
    }
}
