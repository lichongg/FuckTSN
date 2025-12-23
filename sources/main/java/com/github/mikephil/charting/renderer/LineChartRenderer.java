package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class LineChartRenderer extends LineRadarRenderer {
    protected Path cubicFillPath;
    protected Path cubicPath;
    protected Canvas mBitmapCanvas;
    protected Bitmap.Config mBitmapConfig;
    protected LineDataProvider mChart;
    protected Paint mCirclePaintInner;
    private float[] mCirclesBuffer;
    protected WeakReference<Bitmap> mDrawBitmap;
    protected Path mGenerateFilledPathBuffer;
    private HashMap<IDataSet, DataSetImageCache> mImageCaches;
    private float[] mLineBuffer;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class DataSetImageCache {
        private Bitmap[] circleBitmaps;
        private Path mCirclePathBuffer;

        private DataSetImageCache() {
            this.mCirclePathBuffer = new Path();
        }

        protected Bitmap getBitmap(int i6) {
            Bitmap[] bitmapArr = this.circleBitmaps;
            return bitmapArr[i6 % bitmapArr.length];
        }

        /* synthetic */ DataSetImageCache(LineChartRenderer lineChartRenderer, AnonymousClass1 anonymousClass1) {
            this();
        }

        protected void fill(ILineDataSet iLineDataSet, boolean z5, boolean z6) {
            int circleColorCount = iLineDataSet.getCircleColorCount();
            float circleRadius = iLineDataSet.getCircleRadius();
            float circleHoleRadius = iLineDataSet.getCircleHoleRadius();
            for (int i6 = 0; i6 < circleColorCount; i6++) {
                int i7 = (int) (circleRadius * 2.1d);
                Bitmap createBitmap = Bitmap.createBitmap(i7, i7, Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(createBitmap);
                this.circleBitmaps[i6] = createBitmap;
                LineChartRenderer.this.mRenderPaint.setColor(iLineDataSet.getCircleColor(i6));
                if (z6) {
                    this.mCirclePathBuffer.reset();
                    this.mCirclePathBuffer.addCircle(circleRadius, circleRadius, circleRadius, Path.Direction.CW);
                    this.mCirclePathBuffer.addCircle(circleRadius, circleRadius, circleHoleRadius, Path.Direction.CCW);
                    canvas.drawPath(this.mCirclePathBuffer, LineChartRenderer.this.mRenderPaint);
                } else {
                    canvas.drawCircle(circleRadius, circleRadius, circleRadius, LineChartRenderer.this.mRenderPaint);
                    if (z5) {
                        canvas.drawCircle(circleRadius, circleRadius, circleHoleRadius, LineChartRenderer.this.mCirclePaintInner);
                    }
                }
            }
        }

        protected boolean init(ILineDataSet iLineDataSet) {
            int circleColorCount = iLineDataSet.getCircleColorCount();
            Bitmap[] bitmapArr = this.circleBitmaps;
            if (bitmapArr == null) {
                this.circleBitmaps = new Bitmap[circleColorCount];
                return true;
            }
            if (bitmapArr.length != circleColorCount) {
                this.circleBitmaps = new Bitmap[circleColorCount];
                return true;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.github.mikephil.charting.renderer.LineChartRenderer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode;

        static {
            int[] iArr = new int[LineDataSet.Mode.values().length];
            $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode = iArr;
            try {
                iArr[LineDataSet.Mode.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode[LineDataSet.Mode.STEPPED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode[LineDataSet.Mode.CUBIC_BEZIER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode[LineDataSet.Mode.HORIZONTAL_BEZIER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Type inference failed for: r14v2, types: [com.github.mikephil.charting.data.BaseEntry, com.github.mikephil.charting.data.Entry] */
    protected void drawCircles(Canvas canvas) {
        DataSetImageCache dataSetImageCache;
        Bitmap bitmap;
        this.mRenderPaint.setStyle(Paint.Style.FILL);
        float phaseY = this.mAnimator.getPhaseY();
        float[] fArr = this.mCirclesBuffer;
        char c6 = 0;
        float f6 = 0.0f;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        List<T> dataSets = this.mChart.getLineData().getDataSets();
        int i6 = 0;
        while (i6 < dataSets.size()) {
            ILineDataSet iLineDataSet = (ILineDataSet) dataSets.get(i6);
            if (iLineDataSet.isVisible() && iLineDataSet.isDrawCirclesEnabled() && iLineDataSet.getEntryCount() != 0) {
                this.mCirclePaintInner.setColor(iLineDataSet.getCircleHoleColor());
                Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
                this.mXBounds.set(this.mChart, iLineDataSet);
                float circleRadius = iLineDataSet.getCircleRadius();
                float circleHoleRadius = iLineDataSet.getCircleHoleRadius();
                boolean z5 = iLineDataSet.isDrawCircleHoleEnabled() && circleHoleRadius < circleRadius && circleHoleRadius > f6;
                boolean z6 = z5 && iLineDataSet.getCircleHoleColor() == 1122867;
                AnonymousClass1 anonymousClass1 = null;
                if (this.mImageCaches.containsKey(iLineDataSet)) {
                    dataSetImageCache = this.mImageCaches.get(iLineDataSet);
                } else {
                    dataSetImageCache = new DataSetImageCache(this, anonymousClass1);
                    this.mImageCaches.put(iLineDataSet, dataSetImageCache);
                }
                if (dataSetImageCache.init(iLineDataSet)) {
                    dataSetImageCache.fill(iLineDataSet, z5, z6);
                }
                BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.mXBounds;
                int i7 = xBounds.range;
                int i8 = xBounds.min;
                int i9 = i7 + i8;
                while (i8 <= i9) {
                    ?? entryForIndex = iLineDataSet.getEntryForIndex(i8);
                    if (entryForIndex == 0) {
                        break;
                    }
                    this.mCirclesBuffer[c6] = entryForIndex.getX();
                    this.mCirclesBuffer[1] = entryForIndex.getY() * phaseY;
                    transformer.pointValuesToPixel(this.mCirclesBuffer);
                    if (!this.mViewPortHandler.isInBoundsRight(this.mCirclesBuffer[c6])) {
                        break;
                    }
                    if (this.mViewPortHandler.isInBoundsLeft(this.mCirclesBuffer[c6]) && this.mViewPortHandler.isInBoundsY(this.mCirclesBuffer[1]) && (bitmap = dataSetImageCache.getBitmap(i8)) != null) {
                        float[] fArr2 = this.mCirclesBuffer;
                        canvas.drawBitmap(bitmap, fArr2[c6] - circleRadius, fArr2[1] - circleRadius, (Paint) null);
                    }
                    i8++;
                    c6 = 0;
                }
            }
            i6++;
            c6 = 0;
            f6 = 0.0f;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v5, types: [com.github.mikephil.charting.data.BaseEntry, com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.github.mikephil.charting.data.BaseEntry, com.github.mikephil.charting.data.Entry] */
    protected void drawCubicBezier(ILineDataSet iLineDataSet) {
        float phaseY = this.mAnimator.getPhaseY();
        Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
        this.mXBounds.set(this.mChart, iLineDataSet);
        float cubicIntensity = iLineDataSet.getCubicIntensity();
        this.cubicPath.reset();
        BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.mXBounds;
        if (xBounds.range >= 1) {
            int i6 = xBounds.min;
            T entryForIndex = iLineDataSet.getEntryForIndex(Math.max(i6 - 1, 0));
            ?? entryForIndex2 = iLineDataSet.getEntryForIndex(Math.max(i6, 0));
            if (entryForIndex2 != 0) {
                this.cubicPath.moveTo(entryForIndex2.getX(), entryForIndex2.getY() * phaseY);
                Entry entry = entryForIndex2;
                int i7 = this.mXBounds.min + 1;
                int i8 = -1;
                Entry entry2 = entryForIndex2;
                Entry entry3 = entryForIndex;
                while (true) {
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds2 = this.mXBounds;
                    Entry entry4 = entry2;
                    if (i7 > xBounds2.range + xBounds2.min) {
                        break;
                    }
                    if (i8 != i7) {
                        entry4 = iLineDataSet.getEntryForIndex(i7);
                    }
                    int i9 = i7 + 1;
                    if (i9 < iLineDataSet.getEntryCount()) {
                        i7 = i9;
                    }
                    ?? entryForIndex3 = iLineDataSet.getEntryForIndex(i7);
                    this.cubicPath.cubicTo(entry.getX() + ((entry4.getX() - entry3.getX()) * cubicIntensity), (entry.getY() + ((entry4.getY() - entry3.getY()) * cubicIntensity)) * phaseY, entry4.getX() - ((entryForIndex3.getX() - entry.getX()) * cubicIntensity), (entry4.getY() - ((entryForIndex3.getY() - entry.getY()) * cubicIntensity)) * phaseY, entry4.getX(), entry4.getY() * phaseY);
                    int i10 = i7;
                    i7 = i9;
                    i8 = i10;
                    entry3 = entry;
                    entry = entry4;
                    entry2 = entryForIndex3;
                }
            } else {
                return;
            }
        }
        if (iLineDataSet.isDrawFilledEnabled()) {
            this.cubicFillPath.reset();
            this.cubicFillPath.addPath(this.cubicPath);
            drawCubicFill(this.mBitmapCanvas, iLineDataSet, this.cubicFillPath, transformer, this.mXBounds);
        }
        this.mRenderPaint.setColor(iLineDataSet.getColor());
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        transformer.pathValueToPixel(this.cubicPath);
        this.mBitmapCanvas.drawPath(this.cubicPath, this.mRenderPaint);
        this.mRenderPaint.setPathEffect(null);
    }

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
            bitmap = Bitmap.createBitmap(chartWidth, chartHeight, this.mBitmapConfig);
            this.mDrawBitmap = new WeakReference<>(bitmap);
            this.mBitmapCanvas = new Canvas(bitmap);
        }
        bitmap.eraseColor(0);
        for (T t5 : this.mChart.getLineData().getDataSets()) {
            if (t5.isVisible()) {
                drawDataSet(canvas, t5);
            }
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.mRenderPaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.github.mikephil.charting.data.BaseEntry, com.github.mikephil.charting.data.Entry] */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        LineData lineData = this.mChart.getLineData();
        for (Highlight highlight : highlightArr) {
            ILineDataSet iLineDataSet = (ILineDataSet) lineData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iLineDataSet != null && iLineDataSet.isHighlightEnabled()) {
                ?? entryForXValue = iLineDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(entryForXValue, iLineDataSet)) {
                    MPPointD pixelForValues = this.mChart.getTransformer(iLineDataSet.getAxisDependency()).getPixelForValues(entryForXValue.getX(), entryForXValue.getY() * this.mAnimator.getPhaseY());
                    highlight.setDraw((float) pixelForValues.f32563x, (float) pixelForValues.f32564y);
                    drawHighlightLines(canvas, (float) pixelForValues.f32563x, (float) pixelForValues.f32564y, iLineDataSet);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [com.github.mikephil.charting.data.BaseEntry, com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.github.mikephil.charting.data.BaseEntry, com.github.mikephil.charting.data.Entry] */
    protected void drawHorizontalBezier(ILineDataSet iLineDataSet) {
        float phaseY = this.mAnimator.getPhaseY();
        Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
        this.mXBounds.set(this.mChart, iLineDataSet);
        this.cubicPath.reset();
        BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.mXBounds;
        if (xBounds.range >= 1) {
            ?? entryForIndex = iLineDataSet.getEntryForIndex(xBounds.min);
            this.cubicPath.moveTo(entryForIndex.getX(), entryForIndex.getY() * phaseY);
            int i6 = this.mXBounds.min + 1;
            Entry entry = entryForIndex;
            while (true) {
                BarLineScatterCandleBubbleRenderer.XBounds xBounds2 = this.mXBounds;
                if (i6 > xBounds2.range + xBounds2.min) {
                    break;
                }
                ?? entryForIndex2 = iLineDataSet.getEntryForIndex(i6);
                float x5 = entry.getX() + ((entryForIndex2.getX() - entry.getX()) / 2.0f);
                this.cubicPath.cubicTo(x5, entry.getY() * phaseY, x5, entryForIndex2.getY() * phaseY, entryForIndex2.getX(), entryForIndex2.getY() * phaseY);
                i6++;
                entry = entryForIndex2;
            }
        }
        if (iLineDataSet.isDrawFilledEnabled()) {
            this.cubicFillPath.reset();
            this.cubicFillPath.addPath(this.cubicPath);
            drawCubicFill(this.mBitmapCanvas, iLineDataSet, this.cubicFillPath, transformer, this.mXBounds);
        }
        this.mRenderPaint.setColor(iLineDataSet.getColor());
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        transformer.pathValueToPixel(this.cubicPath);
        this.mBitmapCanvas.drawPath(this.cubicPath, this.mRenderPaint);
        this.mRenderPaint.setPathEffect(null);
    }

    /* JADX WARN: Type inference failed for: r12v11, types: [com.github.mikephil.charting.data.BaseEntry, com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r13v5, types: [com.github.mikephil.charting.data.BaseEntry, com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r8v22, types: [com.github.mikephil.charting.data.BaseEntry, com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r8v4, types: [com.github.mikephil.charting.data.BaseEntry, com.github.mikephil.charting.data.Entry] */
    protected void drawLinear(Canvas canvas, ILineDataSet iLineDataSet) {
        int entryCount = iLineDataSet.getEntryCount();
        boolean z5 = iLineDataSet.getMode() == LineDataSet.Mode.STEPPED;
        int i6 = z5 ? 4 : 2;
        Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
        float phaseY = this.mAnimator.getPhaseY();
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        Canvas canvas2 = iLineDataSet.isDashedLineEnabled() ? this.mBitmapCanvas : canvas;
        this.mXBounds.set(this.mChart, iLineDataSet);
        if (iLineDataSet.isDrawFilledEnabled() && entryCount > 0) {
            drawLinearFill(canvas, iLineDataSet, transformer, this.mXBounds);
        }
        if (iLineDataSet.getColors().size() > 1) {
            int i7 = i6 * 2;
            if (this.mLineBuffer.length <= i7) {
                this.mLineBuffer = new float[i6 * 4];
            }
            int i8 = this.mXBounds.min;
            while (true) {
                BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.mXBounds;
                if (i8 > xBounds.range + xBounds.min) {
                    break;
                }
                ?? entryForIndex = iLineDataSet.getEntryForIndex(i8);
                if (entryForIndex != 0) {
                    this.mLineBuffer[0] = entryForIndex.getX();
                    this.mLineBuffer[1] = entryForIndex.getY() * phaseY;
                    if (i8 < this.mXBounds.max) {
                        ?? entryForIndex2 = iLineDataSet.getEntryForIndex(i8 + 1);
                        if (entryForIndex2 == 0) {
                            break;
                        }
                        if (z5) {
                            this.mLineBuffer[2] = entryForIndex2.getX();
                            float[] fArr = this.mLineBuffer;
                            float f6 = fArr[1];
                            fArr[3] = f6;
                            fArr[4] = fArr[2];
                            fArr[5] = f6;
                            fArr[6] = entryForIndex2.getX();
                            this.mLineBuffer[7] = entryForIndex2.getY() * phaseY;
                        } else {
                            this.mLineBuffer[2] = entryForIndex2.getX();
                            this.mLineBuffer[3] = entryForIndex2.getY() * phaseY;
                        }
                    } else {
                        float[] fArr2 = this.mLineBuffer;
                        fArr2[2] = fArr2[0];
                        fArr2[3] = fArr2[1];
                    }
                    transformer.pointValuesToPixel(this.mLineBuffer);
                    if (!this.mViewPortHandler.isInBoundsRight(this.mLineBuffer[0])) {
                        break;
                    }
                    if (this.mViewPortHandler.isInBoundsLeft(this.mLineBuffer[2]) && (this.mViewPortHandler.isInBoundsTop(this.mLineBuffer[1]) || this.mViewPortHandler.isInBoundsBottom(this.mLineBuffer[3]))) {
                        this.mRenderPaint.setColor(iLineDataSet.getColor(i8));
                        canvas2.drawLines(this.mLineBuffer, 0, i7, this.mRenderPaint);
                    }
                }
                i8++;
            }
        } else {
            int i9 = entryCount * i6;
            if (this.mLineBuffer.length < Math.max(i9, i6) * 2) {
                this.mLineBuffer = new float[Math.max(i9, i6) * 4];
            }
            if (iLineDataSet.getEntryForIndex(this.mXBounds.min) != 0) {
                int i10 = this.mXBounds.min;
                int i11 = 0;
                while (true) {
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds2 = this.mXBounds;
                    if (i10 > xBounds2.range + xBounds2.min) {
                        break;
                    }
                    ?? entryForIndex3 = iLineDataSet.getEntryForIndex(i10 == 0 ? 0 : i10 - 1);
                    ?? entryForIndex4 = iLineDataSet.getEntryForIndex(i10);
                    if (entryForIndex3 != 0 && entryForIndex4 != 0) {
                        this.mLineBuffer[i11] = entryForIndex3.getX();
                        int i12 = i11 + 2;
                        this.mLineBuffer[i11 + 1] = entryForIndex3.getY() * phaseY;
                        if (z5) {
                            this.mLineBuffer[i12] = entryForIndex4.getX();
                            this.mLineBuffer[i11 + 3] = entryForIndex3.getY() * phaseY;
                            this.mLineBuffer[i11 + 4] = entryForIndex4.getX();
                            i12 = i11 + 6;
                            this.mLineBuffer[i11 + 5] = entryForIndex3.getY() * phaseY;
                        }
                        this.mLineBuffer[i12] = entryForIndex4.getX();
                        this.mLineBuffer[i12 + 1] = entryForIndex4.getY() * phaseY;
                        i11 = i12 + 2;
                    }
                    i10++;
                }
                if (i11 > 0) {
                    transformer.pointValuesToPixel(this.mLineBuffer);
                    int max = Math.max((this.mXBounds.range + 1) * i6, i6) * 2;
                    this.mRenderPaint.setColor(iLineDataSet.getColor());
                    canvas2.drawLines(this.mLineBuffer, 0, max, this.mRenderPaint);
                }
            }
        }
        this.mRenderPaint.setPathEffect(null);
    }

    protected void drawLinearFill(Canvas canvas, ILineDataSet iLineDataSet, Transformer transformer, BarLineScatterCandleBubbleRenderer.XBounds xBounds) {
        int i6;
        int i7;
        Path path = this.mGenerateFilledPathBuffer;
        int i8 = xBounds.min;
        int i9 = xBounds.range + i8;
        int i10 = 0;
        do {
            i6 = (i10 * 128) + i8;
            i7 = i6 + 128;
            if (i7 > i9) {
                i7 = i9;
            }
            if (i6 <= i7) {
                generateFilledPath(iLineDataSet, i6, i7, path);
                transformer.pathValueToPixel(path);
                Drawable fillDrawable = iLineDataSet.getFillDrawable();
                if (fillDrawable != null) {
                    drawFilledPath(canvas, path, fillDrawable);
                } else {
                    drawFilledPath(canvas, path, iLineDataSet.getFillColor(), iLineDataSet.getFillAlpha());
                }
            }
            i10++;
        } while (i6 <= i7);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f6, float f7, int i6) {
        this.mValuePaint.setColor(i6);
        canvas.drawText(str, f6, f7, this.mValuePaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        Entry entry;
        LineChartRenderer lineChartRenderer = this;
        if (lineChartRenderer.isDrawingValuesAllowed(lineChartRenderer.mChart)) {
            List<T> dataSets = lineChartRenderer.mChart.getLineData().getDataSets();
            int i6 = 0;
            while (i6 < dataSets.size()) {
                ILineDataSet iLineDataSet = (ILineDataSet) dataSets.get(i6);
                if (lineChartRenderer.shouldDrawValues(iLineDataSet) && iLineDataSet.getEntryCount() >= 1) {
                    lineChartRenderer.applyValueTextStyle(iLineDataSet);
                    Transformer transformer = lineChartRenderer.mChart.getTransformer(iLineDataSet.getAxisDependency());
                    int circleRadius = (int) (iLineDataSet.getCircleRadius() * 1.75f);
                    if (!iLineDataSet.isDrawCirclesEnabled()) {
                        circleRadius /= 2;
                    }
                    int i7 = circleRadius;
                    lineChartRenderer.mXBounds.set(lineChartRenderer.mChart, iLineDataSet);
                    float phaseX = lineChartRenderer.mAnimator.getPhaseX();
                    float phaseY = lineChartRenderer.mAnimator.getPhaseY();
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = lineChartRenderer.mXBounds;
                    float[] generateTransformedValuesLine = transformer.generateTransformedValuesLine(iLineDataSet, phaseX, phaseY, xBounds.min, xBounds.max);
                    ValueFormatter valueFormatter = iLineDataSet.getValueFormatter();
                    MPPointF mPPointF = MPPointF.getInstance(iLineDataSet.getIconsOffset());
                    mPPointF.f32565x = Utils.convertDpToPixel(mPPointF.f32565x);
                    mPPointF.f32566y = Utils.convertDpToPixel(mPPointF.f32566y);
                    int i8 = 0;
                    while (i8 < generateTransformedValuesLine.length) {
                        float f6 = generateTransformedValuesLine[i8];
                        float f7 = generateTransformedValuesLine[i8 + 1];
                        if (!lineChartRenderer.mViewPortHandler.isInBoundsRight(f6)) {
                            break;
                        }
                        if (lineChartRenderer.mViewPortHandler.isInBoundsLeft(f6) && lineChartRenderer.mViewPortHandler.isInBoundsY(f7)) {
                            int i9 = i8 / 2;
                            Entry entryForIndex = iLineDataSet.getEntryForIndex(lineChartRenderer.mXBounds.min + i9);
                            if (iLineDataSet.isDrawValuesEnabled()) {
                                entry = entryForIndex;
                                lineChartRenderer.drawValue(canvas, valueFormatter.getPointLabel(entryForIndex), f6, f7 - i7, iLineDataSet.getValueTextColor(i9));
                            } else {
                                entry = entryForIndex;
                            }
                            if (entry.getIcon() != null && iLineDataSet.isDrawIconsEnabled()) {
                                Drawable icon = entry.getIcon();
                                Utils.drawImage(canvas, icon, (int) (f6 + mPPointF.f32565x), (int) (f7 + mPPointF.f32566y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                            }
                        }
                        i8 += 2;
                        lineChartRenderer = this;
                    }
                    MPPointF.recycleInstance(mPPointF);
                }
                i6++;
                lineChartRenderer = this;
            }
        }
    }

    public Bitmap.Config getBitmapConfig() {
        return this.mBitmapConfig;
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

    public void setBitmapConfig(Bitmap.Config config) {
        this.mBitmapConfig = config;
        releaseBitmap();
    }

    public LineChartRenderer(LineDataProvider lineDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mBitmapConfig = Bitmap.Config.ARGB_8888;
        this.cubicPath = new Path();
        this.cubicFillPath = new Path();
        this.mLineBuffer = new float[4];
        this.mGenerateFilledPathBuffer = new Path();
        this.mImageCaches = new HashMap<>();
        this.mCirclesBuffer = new float[2];
        this.mChart = lineDataProvider;
        Paint paint = new Paint(1);
        this.mCirclePaintInner = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mCirclePaintInner.setColor(-1);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.github.mikephil.charting.data.BaseEntry, com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.github.mikephil.charting.data.BaseEntry, com.github.mikephil.charting.data.Entry] */
    private void generateFilledPath(ILineDataSet iLineDataSet, int i6, int i7, Path path) {
        boolean z5;
        float fillLinePosition = iLineDataSet.getFillFormatter().getFillLinePosition(iLineDataSet, this.mChart);
        float phaseY = this.mAnimator.getPhaseY();
        if (iLineDataSet.getMode() == LineDataSet.Mode.STEPPED) {
            z5 = true;
        } else {
            z5 = false;
        }
        path.reset();
        ?? entryForIndex = iLineDataSet.getEntryForIndex(i6);
        path.moveTo(entryForIndex.getX(), fillLinePosition);
        path.lineTo(entryForIndex.getX(), entryForIndex.getY() * phaseY);
        int i8 = i6 + 1;
        Entry entry = null;
        BaseEntry baseEntry = entryForIndex;
        while (i8 <= i7) {
            ?? entryForIndex2 = iLineDataSet.getEntryForIndex(i8);
            if (z5) {
                path.lineTo(entryForIndex2.getX(), baseEntry.getY() * phaseY);
            }
            path.lineTo(entryForIndex2.getX(), entryForIndex2.getY() * phaseY);
            i8++;
            baseEntry = entryForIndex2;
            entry = entryForIndex2;
        }
        if (entry != null) {
            path.lineTo(entry.getX(), fillLinePosition);
        }
        path.close();
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.github.mikephil.charting.data.Entry] */
    protected void drawCubicFill(Canvas canvas, ILineDataSet iLineDataSet, Path path, Transformer transformer, BarLineScatterCandleBubbleRenderer.XBounds xBounds) {
        float fillLinePosition = iLineDataSet.getFillFormatter().getFillLinePosition(iLineDataSet, this.mChart);
        path.lineTo(iLineDataSet.getEntryForIndex(xBounds.min + xBounds.range).getX(), fillLinePosition);
        path.lineTo(iLineDataSet.getEntryForIndex(xBounds.min).getX(), fillLinePosition);
        path.close();
        transformer.pathValueToPixel(path);
        Drawable fillDrawable = iLineDataSet.getFillDrawable();
        if (fillDrawable != null) {
            drawFilledPath(canvas, path, fillDrawable);
        } else {
            drawFilledPath(canvas, path, iLineDataSet.getFillColor(), iLineDataSet.getFillAlpha());
        }
    }

    protected void drawDataSet(Canvas canvas, ILineDataSet iLineDataSet) {
        if (iLineDataSet.getEntryCount() < 1) {
            return;
        }
        this.mRenderPaint.setStrokeWidth(iLineDataSet.getLineWidth());
        this.mRenderPaint.setPathEffect(iLineDataSet.getDashPathEffect());
        int i6 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode[iLineDataSet.getMode().ordinal()];
        if (i6 != 3) {
            if (i6 != 4) {
                drawLinear(canvas, iLineDataSet);
            } else {
                drawHorizontalBezier(iLineDataSet);
            }
        } else {
            drawCubicBezier(iLineDataSet);
        }
        this.mRenderPaint.setPathEffect(null);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
        drawCircles(canvas);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }
}
