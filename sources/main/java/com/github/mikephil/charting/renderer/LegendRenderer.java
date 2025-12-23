package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class LegendRenderer extends Renderer {
    protected List<LegendEntry> computedEntries;
    protected Paint.FontMetrics legendFontMetrics;
    protected Legend mLegend;
    protected Paint mLegendFormPaint;
    protected Paint mLegendLabelPaint;
    private Path mLineFormPath;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.github.mikephil.charting.renderer.LegendRenderer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment;

        static {
            int[] iArr = new int[Legend.LegendForm.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm = iArr;
            try {
                iArr[Legend.LegendForm.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.SQUARE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.LINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[Legend.LegendOrientation.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation = iArr2;
            try {
                iArr2[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[Legend.LegendOrientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[Legend.LegendVerticalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr4 = new int[Legend.LegendHorizontalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment = iArr4;
            try {
                iArr4[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    /* JADX WARN: Type inference failed for: r8v3, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    public void computeLegend(ChartData<?> chartData) {
        if (!this.mLegend.isLegendCustom()) {
            this.computedEntries.clear();
            for (int i6 = 0; i6 < chartData.getDataSetCount(); i6++) {
                ?? dataSetByIndex = chartData.getDataSetByIndex(i6);
                List<Integer> colors = dataSetByIndex.getColors();
                int entryCount = dataSetByIndex.getEntryCount();
                if (dataSetByIndex instanceof IBarDataSet) {
                    IBarDataSet iBarDataSet = (IBarDataSet) dataSetByIndex;
                    if (iBarDataSet.isStacked()) {
                        String[] stackLabels = iBarDataSet.getStackLabels();
                        for (int i7 = 0; i7 < colors.size() && i7 < iBarDataSet.getStackSize(); i7++) {
                            this.computedEntries.add(new LegendEntry(stackLabels[i7 % stackLabels.length], dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i7).intValue()));
                        }
                        if (iBarDataSet.getLabel() != null) {
                            this.computedEntries.add(new LegendEntry(dataSetByIndex.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, ColorTemplate.COLOR_NONE));
                        }
                    }
                }
                if (dataSetByIndex instanceof IPieDataSet) {
                    IPieDataSet iPieDataSet = (IPieDataSet) dataSetByIndex;
                    for (int i8 = 0; i8 < colors.size() && i8 < entryCount; i8++) {
                        this.computedEntries.add(new LegendEntry(iPieDataSet.getEntryForIndex(i8).getLabel(), dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i8).intValue()));
                    }
                    if (iPieDataSet.getLabel() != null) {
                        this.computedEntries.add(new LegendEntry(dataSetByIndex.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, ColorTemplate.COLOR_NONE));
                    }
                } else {
                    if (dataSetByIndex instanceof ICandleDataSet) {
                        ICandleDataSet iCandleDataSet = (ICandleDataSet) dataSetByIndex;
                        if (iCandleDataSet.getDecreasingColor() != 1122867) {
                            int decreasingColor = iCandleDataSet.getDecreasingColor();
                            int increasingColor = iCandleDataSet.getIncreasingColor();
                            this.computedEntries.add(new LegendEntry(null, dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), decreasingColor));
                            this.computedEntries.add(new LegendEntry(dataSetByIndex.getLabel(), dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), increasingColor));
                        }
                    }
                    int i9 = 0;
                    while (i9 < colors.size() && i9 < entryCount) {
                        this.computedEntries.add(new LegendEntry((i9 >= colors.size() + (-1) || i9 >= entryCount + (-1)) ? chartData.getDataSetByIndex(i6).getLabel() : null, dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i9).intValue()));
                        i9++;
                    }
                }
            }
            if (this.mLegend.getExtraEntries() != null) {
                Collections.addAll(this.computedEntries, this.mLegend.getExtraEntries());
            }
            this.mLegend.setEntries(this.computedEntries);
        }
        Typeface typeface = this.mLegend.getTypeface();
        if (typeface != null) {
            this.mLegendLabelPaint.setTypeface(typeface);
        }
        this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
        this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
        this.mLegend.calculateDimensions(this.mLegendLabelPaint, this.mViewPortHandler);
    }

    protected void drawForm(Canvas canvas, float f6, float f7, LegendEntry legendEntry, Legend legend) {
        Canvas canvas2;
        int i6 = legendEntry.formColor;
        if (i6 == 1122868 || i6 == 1122867 || i6 == 0) {
            return;
        }
        int save = canvas.save();
        Legend.LegendForm legendForm = legendEntry.form;
        if (legendForm == Legend.LegendForm.DEFAULT) {
            legendForm = legend.getForm();
        }
        this.mLegendFormPaint.setColor(legendEntry.formColor);
        float convertDpToPixel = Utils.convertDpToPixel(Float.isNaN(legendEntry.formSize) ? legend.getFormSize() : legendEntry.formSize);
        float f8 = convertDpToPixel / 2.0f;
        int i7 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[legendForm.ordinal()];
        if (i7 == 3 || i7 == 4) {
            canvas2 = canvas;
            this.mLegendFormPaint.setStyle(Paint.Style.FILL);
            canvas2.drawCircle(f6 + f8, f7, f8, this.mLegendFormPaint);
        } else if (i7 != 5) {
            if (i7 == 6) {
                float convertDpToPixel2 = Utils.convertDpToPixel(Float.isNaN(legendEntry.formLineWidth) ? legend.getFormLineWidth() : legendEntry.formLineWidth);
                DashPathEffect dashPathEffect = legendEntry.formLineDashEffect;
                if (dashPathEffect == null) {
                    dashPathEffect = legend.getFormLineDashEffect();
                }
                this.mLegendFormPaint.setStyle(Paint.Style.STROKE);
                this.mLegendFormPaint.setStrokeWidth(convertDpToPixel2);
                this.mLegendFormPaint.setPathEffect(dashPathEffect);
                this.mLineFormPath.reset();
                this.mLineFormPath.moveTo(f6, f7);
                this.mLineFormPath.lineTo(f6 + convertDpToPixel, f7);
                canvas.drawPath(this.mLineFormPath, this.mLegendFormPaint);
            }
            canvas2 = canvas;
        } else {
            this.mLegendFormPaint.setStyle(Paint.Style.FILL);
            canvas2 = canvas;
            canvas2.drawRect(f6, f7 - f8, f6 + convertDpToPixel, f7 + f8, this.mLegendFormPaint);
        }
        canvas2.restoreToCount(save);
    }

    protected void drawLabel(Canvas canvas, float f6, float f7, String str) {
        canvas.drawText(str, f6, f7, this.mLegendLabelPaint);
    }

    public Paint getFormPaint() {
        return this.mLegendFormPaint;
    }

    public Paint getLabelPaint() {
        return this.mLegendLabelPaint;
    }

    public void renderLegend(Canvas canvas) {
        float f6;
        float f7;
        List<FSize> list;
        boolean z5;
        List<FSize> list2;
        List<Boolean> list3;
        int i6;
        Canvas canvas2;
        float f8;
        float contentTop;
        int i7;
        float f9;
        Canvas canvas3;
        float f10;
        float f11;
        double d6;
        double d7;
        if (this.mLegend.isEnabled()) {
            Typeface typeface = this.mLegend.getTypeface();
            if (typeface != null) {
                this.mLegendLabelPaint.setTypeface(typeface);
            }
            this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
            this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
            float lineHeight = Utils.getLineHeight(this.mLegendLabelPaint, this.legendFontMetrics);
            float lineSpacing = Utils.getLineSpacing(this.mLegendLabelPaint, this.legendFontMetrics) + Utils.convertDpToPixel(this.mLegend.getYEntrySpace());
            float calcTextHeight = lineHeight - (Utils.calcTextHeight(this.mLegendLabelPaint, "ABC") / 2.0f);
            LegendEntry[] entries = this.mLegend.getEntries();
            float convertDpToPixel = Utils.convertDpToPixel(this.mLegend.getFormToTextSpace());
            float convertDpToPixel2 = Utils.convertDpToPixel(this.mLegend.getXEntrySpace());
            Legend.LegendOrientation orientation = this.mLegend.getOrientation();
            Legend.LegendHorizontalAlignment horizontalAlignment = this.mLegend.getHorizontalAlignment();
            Legend.LegendVerticalAlignment verticalAlignment = this.mLegend.getVerticalAlignment();
            Legend.LegendDirection direction = this.mLegend.getDirection();
            float convertDpToPixel3 = Utils.convertDpToPixel(this.mLegend.getFormSize());
            float convertDpToPixel4 = Utils.convertDpToPixel(this.mLegend.getStackSpace());
            float yOffset = this.mLegend.getYOffset();
            float xOffset = this.mLegend.getXOffset();
            int i8 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[horizontalAlignment.ordinal()];
            if (i8 == 1) {
                f6 = convertDpToPixel4;
                if (orientation != Legend.LegendOrientation.VERTICAL) {
                    xOffset += this.mViewPortHandler.contentLeft();
                }
                f7 = direction == Legend.LegendDirection.RIGHT_TO_LEFT ? xOffset + this.mLegend.mNeededWidth : xOffset;
            } else if (i8 == 2) {
                f6 = convertDpToPixel4;
                f7 = (orientation == Legend.LegendOrientation.VERTICAL ? this.mViewPortHandler.getChartWidth() : this.mViewPortHandler.contentRight()) - xOffset;
                if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                    f7 -= this.mLegend.mNeededWidth;
                }
            } else if (i8 != 3) {
                f6 = convertDpToPixel4;
                f7 = 0.0f;
            } else {
                Legend.LegendOrientation legendOrientation = Legend.LegendOrientation.VERTICAL;
                float chartWidth = orientation == legendOrientation ? this.mViewPortHandler.getChartWidth() / 2.0f : this.mViewPortHandler.contentLeft() + (this.mViewPortHandler.contentWidth() / 2.0f);
                Legend.LegendDirection legendDirection = Legend.LegendDirection.LEFT_TO_RIGHT;
                f6 = convertDpToPixel4;
                f7 = chartWidth + (direction == legendDirection ? xOffset : -xOffset);
                if (orientation == legendOrientation) {
                    double d8 = f7;
                    if (direction == legendDirection) {
                        d6 = d8;
                        d7 = ((-this.mLegend.mNeededWidth) / 2.0d) + xOffset;
                    } else {
                        d6 = d8;
                        d7 = (this.mLegend.mNeededWidth / 2.0d) - xOffset;
                    }
                    f7 = (float) (d6 + d7);
                }
            }
            int i9 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[orientation.ordinal()];
            if (i9 != 1) {
                if (i9 != 2) {
                    return;
                }
                int i10 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[verticalAlignment.ordinal()];
                if (i10 == 1) {
                    contentTop = (horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER ? 0.0f : this.mViewPortHandler.contentTop()) + yOffset;
                } else if (i10 == 2) {
                    contentTop = (horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER ? this.mViewPortHandler.getChartHeight() : this.mViewPortHandler.contentBottom()) - (this.mLegend.mNeededHeight + yOffset);
                } else if (i10 != 3) {
                    contentTop = 0.0f;
                } else {
                    float chartHeight = this.mViewPortHandler.getChartHeight() / 2.0f;
                    Legend legend = this.mLegend;
                    contentTop = (chartHeight - (legend.mNeededHeight / 2.0f)) + legend.getYOffset();
                }
                float f12 = contentTop;
                int i11 = 0;
                boolean z6 = false;
                float f13 = 0.0f;
                while (i11 < entries.length) {
                    LegendEntry legendEntry = entries[i11];
                    boolean z7 = legendEntry.form != Legend.LegendForm.NONE;
                    float convertDpToPixel5 = Float.isNaN(legendEntry.formSize) ? convertDpToPixel3 : Utils.convertDpToPixel(legendEntry.formSize);
                    if (z7) {
                        Legend.LegendDirection legendDirection2 = Legend.LegendDirection.LEFT_TO_RIGHT;
                        float f14 = direction == legendDirection2 ? f7 + f13 : f7 - (convertDpToPixel5 - f13);
                        f9 = f6;
                        f10 = lineSpacing;
                        i7 = i11;
                        canvas3 = canvas;
                        drawForm(canvas3, f14, f12 + calcTextHeight, legendEntry, this.mLegend);
                        f11 = direction == legendDirection2 ? f14 + convertDpToPixel5 : f14;
                    } else {
                        i7 = i11;
                        f9 = f6;
                        canvas3 = canvas;
                        f10 = lineSpacing;
                        f11 = f7;
                    }
                    if (legendEntry.label != null) {
                        if (z7 && !z6) {
                            f11 += direction == Legend.LegendDirection.LEFT_TO_RIGHT ? convertDpToPixel : -convertDpToPixel;
                        } else if (z6) {
                            f11 = f7;
                        }
                        if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f11 -= Utils.calcTextWidth(this.mLegendLabelPaint, r2);
                        }
                        if (z6) {
                            f12 += lineHeight + f10;
                            drawLabel(canvas3, f11, f12 + lineHeight, legendEntry.label);
                        } else {
                            drawLabel(canvas3, f11, f12 + lineHeight, legendEntry.label);
                        }
                        f12 += lineHeight + f10;
                        f13 = 0.0f;
                    } else {
                        f13 += convertDpToPixel5 + f9;
                        z6 = true;
                    }
                    i11 = i7 + 1;
                    lineSpacing = f10;
                    f6 = f9;
                }
                return;
            }
            float f15 = f6;
            List<FSize> calculatedLineSizes = this.mLegend.getCalculatedLineSizes();
            List<FSize> calculatedLabelSizes = this.mLegend.getCalculatedLabelSizes();
            List<Boolean> calculatedLabelBreakPoints = this.mLegend.getCalculatedLabelBreakPoints();
            int i12 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[verticalAlignment.ordinal()];
            float f16 = f7;
            if (i12 != 1) {
                yOffset = i12 != 2 ? i12 != 3 ? 0.0f : yOffset + ((this.mViewPortHandler.getChartHeight() - this.mLegend.mNeededHeight) / 2.0f) : (this.mViewPortHandler.getChartHeight() - yOffset) - this.mLegend.mNeededHeight;
            }
            int length = entries.length;
            float f17 = f16;
            int i13 = 0;
            int i14 = 0;
            while (i14 < length) {
                float f18 = yOffset;
                LegendEntry legendEntry2 = entries[i14];
                List<FSize> list4 = calculatedLabelSizes;
                int i15 = length;
                boolean z8 = legendEntry2.form != Legend.LegendForm.NONE;
                float convertDpToPixel6 = Float.isNaN(legendEntry2.formSize) ? convertDpToPixel3 : Utils.convertDpToPixel(legendEntry2.formSize);
                if (i14 < calculatedLabelBreakPoints.size() && calculatedLabelBreakPoints.get(i14).booleanValue()) {
                    f18 += lineHeight + lineSpacing;
                    f17 = f16;
                }
                if (f17 == f16 && horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER && i13 < calculatedLineSizes.size()) {
                    f17 += (direction == Legend.LegendDirection.RIGHT_TO_LEFT ? calculatedLineSizes.get(i13).width : -calculatedLineSizes.get(i13).width) / 2.0f;
                    i13++;
                }
                float f19 = f17;
                int i16 = i13;
                float f20 = f19;
                boolean z9 = legendEntry2.label == null;
                if (z8) {
                    if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f20 -= convertDpToPixel6;
                    }
                    float f21 = f20;
                    z5 = z8;
                    i6 = i14;
                    list = calculatedLineSizes;
                    list2 = list4;
                    list3 = calculatedLabelBreakPoints;
                    drawForm(canvas, f21, f18 + calcTextHeight, legendEntry2, this.mLegend);
                    canvas2 = canvas;
                    f20 = direction == Legend.LegendDirection.LEFT_TO_RIGHT ? f21 + convertDpToPixel6 : f21;
                } else {
                    list = calculatedLineSizes;
                    z5 = z8;
                    list2 = list4;
                    list3 = calculatedLabelBreakPoints;
                    i6 = i14;
                    canvas2 = canvas;
                }
                if (z9) {
                    f8 = direction == Legend.LegendDirection.RIGHT_TO_LEFT ? -f15 : f15;
                } else {
                    if (z5) {
                        f20 += direction == Legend.LegendDirection.RIGHT_TO_LEFT ? -convertDpToPixel : convertDpToPixel;
                    }
                    Legend.LegendDirection legendDirection3 = Legend.LegendDirection.RIGHT_TO_LEFT;
                    if (direction == legendDirection3) {
                        f20 -= list2.get(i6).width;
                    }
                    drawLabel(canvas2, f20, f18 + lineHeight, legendEntry2.label);
                    if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                        f20 += list2.get(i6).width;
                    }
                    f8 = direction == legendDirection3 ? -convertDpToPixel2 : convertDpToPixel2;
                }
                i14 = i6 + 1;
                f17 = f20 + f8;
                i13 = i16;
                calculatedLabelSizes = list2;
                yOffset = f18;
                calculatedLabelBreakPoints = list3;
                length = i15;
                calculatedLineSizes = list;
            }
        }
    }

    public LegendRenderer(ViewPortHandler viewPortHandler, Legend legend) {
        super(viewPortHandler);
        this.computedEntries = new ArrayList(16);
        this.legendFontMetrics = new Paint.FontMetrics();
        this.mLineFormPath = new Path();
        this.mLegend = legend;
        Paint paint = new Paint(1);
        this.mLegendLabelPaint = paint;
        paint.setTextSize(Utils.convertDpToPixel(9.0f));
        this.mLegendLabelPaint.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.mLegendFormPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }
}
