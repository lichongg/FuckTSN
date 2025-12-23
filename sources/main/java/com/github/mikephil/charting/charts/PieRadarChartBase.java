package com.github.mikephil.charting.charts;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.PieRadarChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class PieRadarChartBase<T extends ChartData<? extends IDataSet<? extends Entry>>> extends Chart<T> {
    protected float mMinOffset;
    private float mRawRotationAngle;
    protected boolean mRotateEnabled;
    private float mRotationAngle;

    public PieRadarChartBase(Context context) {
        super(context);
        this.mRotationAngle = 270.0f;
        this.mRawRotationAngle = 270.0f;
        this.mRotateEnabled = true;
        this.mMinOffset = 0.0f;
    }

    public abstract int getIndexForAngle(float f6);

    public MPPointF getPosition(MPPointF mPPointF, float f6, float f7) {
        MPPointF mPPointF2 = MPPointF.getInstance(0.0f, 0.0f);
        getPosition(mPPointF, f6, f7, mPPointF2);
        return mPPointF2;
    }

    public abstract float getRadius();

    protected abstract float getRequiredBaseOffset();

    protected abstract float getRequiredLegendOffset();

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMax() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMin() {
        return 0.0f;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.github.mikephil.charting.charts.PieRadarChartBase$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment;

        static {
            int[] iArr = new int[Legend.LegendOrientation.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation = iArr;
            try {
                iArr[Legend.LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Legend.LegendHorizontalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment = iArr2;
            try {
                iArr2[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x007d, code lost:
    
        if (r2 != 2) goto L19;
     */
    @Override // com.github.mikephil.charting.charts.Chart
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void calculateOffsets() {
        /*
            Method dump skipped, instructions count: 490
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.PieRadarChartBase.calculateOffsets():void");
    }

    @Override // android.view.View
    public void computeScroll() {
        ChartTouchListener chartTouchListener = this.mChartTouchListener;
        if (chartTouchListener instanceof PieRadarChartTouchListener) {
            ((PieRadarChartTouchListener) chartTouchListener).computeScroll();
        }
    }

    public float getDiameter() {
        RectF contentRect = this.mViewPortHandler.getContentRect();
        contentRect.left += getExtraLeftOffset();
        contentRect.top += getExtraTopOffset();
        contentRect.right -= getExtraRightOffset();
        contentRect.bottom -= getExtraBottomOffset();
        return Math.min(contentRect.width(), contentRect.height());
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public int getMaxVisibleCount() {
        return this.mData.getEntryCount();
    }

    public float getMinOffset() {
        return this.mMinOffset;
    }

    public float getRawRotationAngle() {
        return this.mRawRotationAngle;
    }

    public float getRotationAngle() {
        return this.mRotationAngle;
    }

    public boolean isRotationEnabled() {
        return this.mRotateEnabled;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void notifyDataSetChanged() {
        if (this.mData == null) {
            return;
        }
        calcMinMax();
        if (this.mLegend != null) {
            this.mLegendRenderer.computeLegend(this.mData);
        }
        calculateOffsets();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ChartTouchListener chartTouchListener;
        return (!this.mTouchEnabled || (chartTouchListener = this.mChartTouchListener) == null) ? super.onTouchEvent(motionEvent) : chartTouchListener.onTouch(this, motionEvent);
    }

    public void setMinOffset(float f6) {
        this.mMinOffset = f6;
    }

    public void setRotationAngle(float f6) {
        this.mRawRotationAngle = f6;
        this.mRotationAngle = Utils.getNormalizedAngle(f6);
    }

    public void setRotationEnabled(boolean z5) {
        this.mRotateEnabled = z5;
    }

    public float distanceToCenter(float f6, float f7) {
        float f8;
        float f9;
        MPPointF centerOffsets = getCenterOffsets();
        float f10 = centerOffsets.f32565x;
        if (f6 > f10) {
            f8 = f6 - f10;
        } else {
            f8 = f10 - f6;
        }
        float f11 = centerOffsets.f32566y;
        if (f7 > f11) {
            f9 = f7 - f11;
        } else {
            f9 = f11 - f7;
        }
        float sqrt = (float) Math.sqrt(Math.pow(f8, 2.0d) + Math.pow(f9, 2.0d));
        MPPointF.recycleInstance(centerOffsets);
        return sqrt;
    }

    public float getAngleForPoint(float f6, float f7) {
        MPPointF centerOffsets = getCenterOffsets();
        double d6 = f6 - centerOffsets.f32565x;
        double d7 = f7 - centerOffsets.f32566y;
        float degrees = (float) Math.toDegrees(Math.acos(d7 / Math.sqrt((d6 * d6) + (d7 * d7))));
        if (f6 > centerOffsets.f32565x) {
            degrees = 360.0f - degrees;
        }
        float f8 = degrees + 90.0f;
        if (f8 > 360.0f) {
            f8 -= 360.0f;
        }
        MPPointF.recycleInstance(centerOffsets);
        return f8;
    }

    public void getPosition(MPPointF mPPointF, float f6, float f7, MPPointF mPPointF2) {
        double d6 = f6;
        double d7 = f7;
        mPPointF2.f32565x = (float) (mPPointF.f32565x + (Math.cos(Math.toRadians(d7)) * d6));
        mPPointF2.f32566y = (float) (mPPointF.f32566y + (d6 * Math.sin(Math.toRadians(d7))));
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mChartTouchListener = new PieRadarChartTouchListener(this);
    }

    @SuppressLint({"NewApi"})
    public void spin(int i6, float f6, float f7, Easing.EasingFunction easingFunction) {
        setRotationAngle(f6);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rotationAngle", f6, f7);
        ofFloat.setDuration(i6);
        ofFloat.setInterpolator(easingFunction);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.mikephil.charting.charts.PieRadarChartBase.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PieRadarChartBase.this.postInvalidate();
            }
        });
        ofFloat.start();
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRotationAngle = 270.0f;
        this.mRawRotationAngle = 270.0f;
        this.mRotateEnabled = true;
        this.mMinOffset = 0.0f;
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mRotationAngle = 270.0f;
        this.mRawRotationAngle = 270.0f;
        this.mRotateEnabled = true;
        this.mMinOffset = 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void calcMinMax() {
    }
}
