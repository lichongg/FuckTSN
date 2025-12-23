package com.github.mikephil.charting.listener;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class PieRadarChartTouchListener extends ChartTouchListener<PieRadarChartBase<?>> {
    private ArrayList<AngularVelocitySample> _velocitySamples;
    private float mDecelerationAngularVelocity;
    private long mDecelerationLastTime;
    private float mStartAngle;
    private MPPointF mTouchStartPoint;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class AngularVelocitySample {
        public float angle;
        public long time;

        public AngularVelocitySample(long j6, float f6) {
            this.time = j6;
            this.angle = f6;
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    public void stopDeceleration() {
        this.mDecelerationAngularVelocity = 0.0f;
    }

    private float calculateVelocity() {
        if (this._velocitySamples.isEmpty()) {
            return 0.0f;
        }
        AngularVelocitySample angularVelocitySample = this._velocitySamples.get(0);
        ArrayList<AngularVelocitySample> arrayList = this._velocitySamples;
        AngularVelocitySample angularVelocitySample2 = arrayList.get(arrayList.size() - 1);
        AngularVelocitySample angularVelocitySample3 = angularVelocitySample;
        for (int size = this._velocitySamples.size() - 1; size >= 0; size--) {
            angularVelocitySample3 = this._velocitySamples.get(size);
            if (angularVelocitySample3.angle != angularVelocitySample2.angle) {
                break;
            }
        }
        float f6 = (angularVelocitySample2.time - angularVelocitySample.time) / 1000.0f;
        if (f6 == 0.0f) {
            f6 = 0.1f;
        }
        boolean z5 = angularVelocitySample2.angle >= angularVelocitySample3.angle;
        if (Math.abs(r1 - r6) > 270.0d) {
            z5 = !z5;
        }
        float f7 = angularVelocitySample2.angle;
        float f8 = angularVelocitySample.angle;
        if (f7 - f8 > 180.0d) {
            angularVelocitySample.angle = (float) (f8 + 360.0d);
        } else if (f8 - f7 > 180.0d) {
            angularVelocitySample2.angle = (float) (f7 + 360.0d);
        }
        float abs = Math.abs((angularVelocitySample2.angle - angularVelocitySample.angle) / f6);
        return !z5 ? -abs : abs;
    }

    private void resetVelocity() {
        this._velocitySamples.clear();
    }

    public void computeScroll() {
        if (this.mDecelerationAngularVelocity == 0.0f) {
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.mDecelerationAngularVelocity *= ((PieRadarChartBase) this.mChart).getDragDecelerationFrictionCoef();
        T t5 = this.mChart;
        ((PieRadarChartBase) t5).setRotationAngle(((PieRadarChartBase) t5).getRotationAngle() + (this.mDecelerationAngularVelocity * ((currentAnimationTimeMillis - this.mDecelerationLastTime) / 1000.0f)));
        this.mDecelerationLastTime = currentAnimationTimeMillis;
        if (Math.abs(this.mDecelerationAngularVelocity) >= 0.001d) {
            Utils.postInvalidateOnAnimation(this.mChart);
        } else {
            stopDeceleration();
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.LONG_PRESS;
        OnChartGestureListener onChartGestureListener = ((PieRadarChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartLongPressed(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.SINGLE_TAP;
        OnChartGestureListener onChartGestureListener = ((PieRadarChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartSingleTapped(motionEvent);
        }
        if (!((PieRadarChartBase) this.mChart).isHighlightPerTapEnabled()) {
            return false;
        }
        performHighlight(((PieRadarChartBase) this.mChart).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return true;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.mGestureDetector.onTouchEvent(motionEvent) && ((PieRadarChartBase) this.mChart).isRotationEnabled()) {
            float x5 = motionEvent.getX();
            float y5 = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                startAction(motionEvent);
                stopDeceleration();
                resetVelocity();
                if (((PieRadarChartBase) this.mChart).isDragDecelerationEnabled()) {
                    sampleVelocity(x5, y5);
                }
                setGestureStartAngle(x5, y5);
                MPPointF mPPointF = this.mTouchStartPoint;
                mPPointF.f32565x = x5;
                mPPointF.f32566y = y5;
            } else if (action == 1) {
                if (((PieRadarChartBase) this.mChart).isDragDecelerationEnabled()) {
                    stopDeceleration();
                    sampleVelocity(x5, y5);
                    float calculateVelocity = calculateVelocity();
                    this.mDecelerationAngularVelocity = calculateVelocity;
                    if (calculateVelocity != 0.0f) {
                        this.mDecelerationLastTime = AnimationUtils.currentAnimationTimeMillis();
                        Utils.postInvalidateOnAnimation(this.mChart);
                    }
                }
                ((PieRadarChartBase) this.mChart).enableScroll();
                this.mTouchMode = 0;
                endAction(motionEvent);
            } else if (action == 2) {
                if (((PieRadarChartBase) this.mChart).isDragDecelerationEnabled()) {
                    sampleVelocity(x5, y5);
                }
                if (this.mTouchMode == 0) {
                    MPPointF mPPointF2 = this.mTouchStartPoint;
                    if (ChartTouchListener.distance(x5, mPPointF2.f32565x, y5, mPPointF2.f32566y) > Utils.convertDpToPixel(8.0f)) {
                        this.mLastGesture = ChartTouchListener.ChartGesture.ROTATE;
                        this.mTouchMode = 6;
                        ((PieRadarChartBase) this.mChart).disableScroll();
                        endAction(motionEvent);
                    }
                }
                if (this.mTouchMode == 6) {
                    updateGestureRotation(x5, y5);
                    ((PieRadarChartBase) this.mChart).invalidate();
                }
                endAction(motionEvent);
            }
        }
        return true;
    }

    public void setGestureStartAngle(float f6, float f7) {
        this.mStartAngle = ((PieRadarChartBase) this.mChart).getAngleForPoint(f6, f7) - ((PieRadarChartBase) this.mChart).getRawRotationAngle();
    }

    public void updateGestureRotation(float f6, float f7) {
        T t5 = this.mChart;
        ((PieRadarChartBase) t5).setRotationAngle(((PieRadarChartBase) t5).getAngleForPoint(f6, f7) - this.mStartAngle);
    }

    public PieRadarChartTouchListener(PieRadarChartBase<?> pieRadarChartBase) {
        super(pieRadarChartBase);
        this.mTouchStartPoint = MPPointF.getInstance(0.0f, 0.0f);
        this.mStartAngle = 0.0f;
        this._velocitySamples = new ArrayList<>();
        this.mDecelerationLastTime = 0L;
        this.mDecelerationAngularVelocity = 0.0f;
    }

    private void sampleVelocity(float f6, float f7) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this._velocitySamples.add(new AngularVelocitySample(currentAnimationTimeMillis, ((PieRadarChartBase) this.mChart).getAngleForPoint(f6, f7)));
        for (int size = this._velocitySamples.size(); size - 2 > 0 && currentAnimationTimeMillis - this._velocitySamples.get(0).time > 1000; size--) {
            this._velocitySamples.remove(0);
        }
    }
}
