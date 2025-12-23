package com.github.mikephil.charting.listener;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class BarLineChartTouchListener extends ChartTouchListener<BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>>> {
    private IDataSet mClosestDataSetToTouch;
    private MPPointF mDecelerationCurrentPoint;
    private long mDecelerationLastTime;
    private MPPointF mDecelerationVelocity;
    private float mDragTriggerDist;
    private Matrix mMatrix;
    private float mMinScalePointerDistance;
    private float mSavedDist;
    private Matrix mSavedMatrix;
    private float mSavedXDist;
    private float mSavedYDist;
    private MPPointF mTouchPointCenter;
    private MPPointF mTouchStartPoint;
    private VelocityTracker mVelocityTracker;

    private static float getXDist(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
    }

    private static float getYDist(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
    }

    private static void midPoint(MPPointF mPPointF, MotionEvent motionEvent) {
        float x5 = motionEvent.getX(0) + motionEvent.getX(1);
        float y5 = motionEvent.getY(0) + motionEvent.getY(1);
        mPPointF.f32565x = x5 / 2.0f;
        mPPointF.f32566y = y5 / 2.0f;
    }

    private static float spacing(MotionEvent motionEvent) {
        float x5 = motionEvent.getX(0) - motionEvent.getX(1);
        float y5 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x5 * x5) + (y5 * y5));
    }

    private boolean inverted() {
        if (this.mClosestDataSetToTouch == null && ((BarLineChartBase) this.mChart).isAnyAxisInverted()) {
            return true;
        }
        IDataSet iDataSet = this.mClosestDataSetToTouch;
        return iDataSet != null && ((BarLineChartBase) this.mChart).isInverted(iDataSet.getAxisDependency());
    }

    private void performDrag(MotionEvent motionEvent, float f6, float f7) {
        this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
        this.mMatrix.set(this.mSavedMatrix);
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (inverted()) {
            if (this.mChart instanceof HorizontalBarChart) {
                f6 = -f6;
            } else {
                f7 = -f7;
            }
        }
        this.mMatrix.postTranslate(f6, f7);
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartTranslate(motionEvent, f6, f7);
        }
    }

    private void performHighlightDrag(MotionEvent motionEvent) {
        Highlight highlightByTouchPoint = ((BarLineChartBase) this.mChart).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY());
        if (highlightByTouchPoint == null || highlightByTouchPoint.equalTo(this.mLastHighlighted)) {
            return;
        }
        this.mLastHighlighted = highlightByTouchPoint;
        ((BarLineChartBase) this.mChart).highlightValue(highlightByTouchPoint, true);
    }

    private void saveTouchStart(MotionEvent motionEvent) {
        this.mSavedMatrix.set(this.mMatrix);
        this.mTouchStartPoint.f32565x = motionEvent.getX();
        this.mTouchStartPoint.f32566y = motionEvent.getY();
        this.mClosestDataSetToTouch = ((BarLineChartBase) this.mChart).getDataSetByTouchPoint(motionEvent.getX(), motionEvent.getY());
    }

    public void computeScroll() {
        MPPointF mPPointF = this.mDecelerationVelocity;
        if (mPPointF.f32565x == 0.0f && mPPointF.f32566y == 0.0f) {
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.mDecelerationVelocity.f32565x *= ((BarLineChartBase) this.mChart).getDragDecelerationFrictionCoef();
        this.mDecelerationVelocity.f32566y *= ((BarLineChartBase) this.mChart).getDragDecelerationFrictionCoef();
        float f6 = (currentAnimationTimeMillis - this.mDecelerationLastTime) / 1000.0f;
        MPPointF mPPointF2 = this.mDecelerationVelocity;
        float f7 = mPPointF2.f32565x * f6;
        float f8 = mPPointF2.f32566y * f6;
        MPPointF mPPointF3 = this.mDecelerationCurrentPoint;
        float f9 = mPPointF3.f32565x + f7;
        mPPointF3.f32565x = f9;
        float f10 = mPPointF3.f32566y + f8;
        mPPointF3.f32566y = f10;
        MotionEvent obtain = MotionEvent.obtain(currentAnimationTimeMillis, currentAnimationTimeMillis, 2, f9, f10, 0);
        performDrag(obtain, ((BarLineChartBase) this.mChart).isDragXEnabled() ? this.mDecelerationCurrentPoint.f32565x - this.mTouchStartPoint.f32565x : 0.0f, ((BarLineChartBase) this.mChart).isDragYEnabled() ? this.mDecelerationCurrentPoint.f32566y - this.mTouchStartPoint.f32566y : 0.0f);
        obtain.recycle();
        this.mMatrix = ((BarLineChartBase) this.mChart).getViewPortHandler().refresh(this.mMatrix, this.mChart, false);
        this.mDecelerationLastTime = currentAnimationTimeMillis;
        if (Math.abs(this.mDecelerationVelocity.f32565x) >= 0.01d || Math.abs(this.mDecelerationVelocity.f32566y) >= 0.01d) {
            Utils.postInvalidateOnAnimation(this.mChart);
            return;
        }
        ((BarLineChartBase) this.mChart).calculateOffsets();
        ((BarLineChartBase) this.mChart).postInvalidate();
        stopDeceleration();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public MPPointF getTrans(float f6, float f7) {
        ViewPortHandler viewPortHandler = ((BarLineChartBase) this.mChart).getViewPortHandler();
        return MPPointF.getInstance(f6 - viewPortHandler.offsetLeft(), inverted() ? -(f7 - viewPortHandler.offsetTop()) : -((((BarLineChartBase) this.mChart).getMeasuredHeight() - f7) - viewPortHandler.offsetBottom()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.DOUBLE_TAP;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartDoubleTapped(motionEvent);
        }
        if (((BarLineChartBase) this.mChart).isDoubleTapToZoomEnabled() && ((BarLineScatterCandleBubbleData) ((BarLineChartBase) this.mChart).getData()).getEntryCount() > 0) {
            MPPointF trans = getTrans(motionEvent.getX(), motionEvent.getY());
            T t5 = this.mChart;
            ((BarLineChartBase) t5).zoom(((BarLineChartBase) t5).isScaleXEnabled() ? 1.4f : 1.0f, ((BarLineChartBase) this.mChart).isScaleYEnabled() ? 1.4f : 1.0f, trans.f32565x, trans.f32566y);
            ((BarLineChartBase) this.mChart).isLogEnabled();
            MPPointF.recycleInstance(trans);
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
        this.mLastGesture = ChartTouchListener.ChartGesture.FLING;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartFling(motionEvent, motionEvent2, f6, f7);
        }
        return super.onFling(motionEvent, motionEvent2, f6, f7);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.LONG_PRESS;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartLongPressed(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.SINGLE_TAP;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartSingleTapped(motionEvent);
        }
        if (!((BarLineChartBase) this.mChart).isHighlightPerTapEnabled()) {
            return false;
        }
        performHighlight(((BarLineChartBase) this.mChart).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return super.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (motionEvent.getActionMasked() == 3 && (velocityTracker = this.mVelocityTracker) != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        if (this.mTouchMode == 0) {
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        if (!((BarLineChartBase) this.mChart).isDragEnabled() && !((BarLineChartBase) this.mChart).isScaleXEnabled() && !((BarLineChartBase) this.mChart).isScaleYEnabled()) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            startAction(motionEvent);
            stopDeceleration();
            saveTouchStart(motionEvent);
        } else if (action == 1) {
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            int pointerId = motionEvent.getPointerId(0);
            velocityTracker2.computeCurrentVelocity(1000, Utils.getMaximumFlingVelocity());
            float yVelocity = velocityTracker2.getYVelocity(pointerId);
            float xVelocity = velocityTracker2.getXVelocity(pointerId);
            if ((Math.abs(xVelocity) > Utils.getMinimumFlingVelocity() || Math.abs(yVelocity) > Utils.getMinimumFlingVelocity()) && this.mTouchMode == 1 && ((BarLineChartBase) this.mChart).isDragDecelerationEnabled()) {
                stopDeceleration();
                this.mDecelerationLastTime = AnimationUtils.currentAnimationTimeMillis();
                this.mDecelerationCurrentPoint.f32565x = motionEvent.getX();
                this.mDecelerationCurrentPoint.f32566y = motionEvent.getY();
                MPPointF mPPointF = this.mDecelerationVelocity;
                mPPointF.f32565x = xVelocity;
                mPPointF.f32566y = yVelocity;
                Utils.postInvalidateOnAnimation(this.mChart);
            }
            int i6 = this.mTouchMode;
            if (i6 == 2 || i6 == 3 || i6 == 4 || i6 == 5) {
                ((BarLineChartBase) this.mChart).calculateOffsets();
                ((BarLineChartBase) this.mChart).postInvalidate();
            }
            this.mTouchMode = 0;
            ((BarLineChartBase) this.mChart).enableScroll();
            VelocityTracker velocityTracker3 = this.mVelocityTracker;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.mVelocityTracker = null;
            }
            endAction(motionEvent);
        } else if (action == 2) {
            int i7 = this.mTouchMode;
            if (i7 == 1) {
                ((BarLineChartBase) this.mChart).disableScroll();
                performDrag(motionEvent, ((BarLineChartBase) this.mChart).isDragXEnabled() ? motionEvent.getX() - this.mTouchStartPoint.f32565x : 0.0f, ((BarLineChartBase) this.mChart).isDragYEnabled() ? motionEvent.getY() - this.mTouchStartPoint.f32566y : 0.0f);
            } else if (i7 == 2 || i7 == 3 || i7 == 4) {
                ((BarLineChartBase) this.mChart).disableScroll();
                if (((BarLineChartBase) this.mChart).isScaleXEnabled() || ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                    performZoom(motionEvent);
                }
            } else if (i7 == 0 && Math.abs(ChartTouchListener.distance(motionEvent.getX(), this.mTouchStartPoint.f32565x, motionEvent.getY(), this.mTouchStartPoint.f32566y)) > this.mDragTriggerDist && ((BarLineChartBase) this.mChart).isDragEnabled()) {
                if (!((BarLineChartBase) this.mChart).isFullyZoomedOut() || !((BarLineChartBase) this.mChart).hasNoDragOffset()) {
                    float abs = Math.abs(motionEvent.getX() - this.mTouchStartPoint.f32565x);
                    float abs2 = Math.abs(motionEvent.getY() - this.mTouchStartPoint.f32566y);
                    if ((((BarLineChartBase) this.mChart).isDragXEnabled() || abs2 >= abs) && (((BarLineChartBase) this.mChart).isDragYEnabled() || abs2 <= abs)) {
                        this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
                        this.mTouchMode = 1;
                    }
                } else if (((BarLineChartBase) this.mChart).isHighlightPerDragEnabled()) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
                    if (((BarLineChartBase) this.mChart).isHighlightPerDragEnabled()) {
                        performHighlightDrag(motionEvent);
                    }
                }
            }
        } else if (action == 3) {
            this.mTouchMode = 0;
            endAction(motionEvent);
        } else if (action != 5) {
            if (action == 6) {
                Utils.velocityTrackerPointerUpCleanUpIfNecessary(motionEvent, this.mVelocityTracker);
                this.mTouchMode = 5;
            }
        } else if (motionEvent.getPointerCount() >= 2) {
            ((BarLineChartBase) this.mChart).disableScroll();
            saveTouchStart(motionEvent);
            this.mSavedXDist = getXDist(motionEvent);
            this.mSavedYDist = getYDist(motionEvent);
            float spacing = spacing(motionEvent);
            this.mSavedDist = spacing;
            if (spacing > 10.0f) {
                if (((BarLineChartBase) this.mChart).isPinchZoomEnabled()) {
                    this.mTouchMode = 4;
                } else if (((BarLineChartBase) this.mChart).isScaleXEnabled() != ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                    this.mTouchMode = ((BarLineChartBase) this.mChart).isScaleXEnabled() ? 2 : 3;
                } else {
                    this.mTouchMode = this.mSavedXDist > this.mSavedYDist ? 2 : 3;
                }
            }
            midPoint(this.mTouchPointCenter, motionEvent);
        }
        this.mMatrix = ((BarLineChartBase) this.mChart).getViewPortHandler().refresh(this.mMatrix, this.mChart, true);
        return true;
    }

    public void stopDeceleration() {
        MPPointF mPPointF = this.mDecelerationVelocity;
        mPPointF.f32565x = 0.0f;
        mPPointF.f32566y = 0.0f;
    }

    public BarLineChartTouchListener(BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> barLineChartBase, Matrix matrix, float f6) {
        super(barLineChartBase);
        this.mMatrix = new Matrix();
        this.mSavedMatrix = new Matrix();
        this.mTouchStartPoint = MPPointF.getInstance(0.0f, 0.0f);
        this.mTouchPointCenter = MPPointF.getInstance(0.0f, 0.0f);
        this.mSavedXDist = 1.0f;
        this.mSavedYDist = 1.0f;
        this.mSavedDist = 1.0f;
        this.mDecelerationLastTime = 0L;
        this.mDecelerationCurrentPoint = MPPointF.getInstance(0.0f, 0.0f);
        this.mDecelerationVelocity = MPPointF.getInstance(0.0f, 0.0f);
        this.mMatrix = matrix;
        this.mDragTriggerDist = Utils.convertDpToPixel(f6);
        this.mMinScalePointerDistance = Utils.convertDpToPixel(3.5f);
    }

    private void performZoom(MotionEvent motionEvent) {
        boolean canZoomInMoreY;
        boolean canZoomInMoreX;
        boolean canZoomInMoreX2;
        boolean canZoomInMoreY2;
        float f6;
        if (motionEvent.getPointerCount() >= 2) {
            OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
            float spacing = spacing(motionEvent);
            if (spacing > this.mMinScalePointerDistance) {
                MPPointF mPPointF = this.mTouchPointCenter;
                MPPointF trans = getTrans(mPPointF.f32565x, mPPointF.f32566y);
                ViewPortHandler viewPortHandler = ((BarLineChartBase) this.mChart).getViewPortHandler();
                int i6 = this.mTouchMode;
                boolean z5 = false;
                float f7 = 1.0f;
                if (i6 == 4) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.PINCH_ZOOM;
                    float f8 = spacing / this.mSavedDist;
                    if (f8 < 1.0f) {
                        z5 = true;
                    }
                    if (z5) {
                        canZoomInMoreX2 = viewPortHandler.canZoomOutMoreX();
                    } else {
                        canZoomInMoreX2 = viewPortHandler.canZoomInMoreX();
                    }
                    if (z5) {
                        canZoomInMoreY2 = viewPortHandler.canZoomOutMoreY();
                    } else {
                        canZoomInMoreY2 = viewPortHandler.canZoomInMoreY();
                    }
                    if (((BarLineChartBase) this.mChart).isScaleXEnabled()) {
                        f6 = f8;
                    } else {
                        f6 = 1.0f;
                    }
                    if (((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                        f7 = f8;
                    }
                    if (canZoomInMoreY2 || canZoomInMoreX2) {
                        this.mMatrix.set(this.mSavedMatrix);
                        this.mMatrix.postScale(f6, f7, trans.f32565x, trans.f32566y);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.onChartScale(motionEvent, f6, f7);
                        }
                    }
                } else if (i6 == 2 && ((BarLineChartBase) this.mChart).isScaleXEnabled()) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.X_ZOOM;
                    float xDist = getXDist(motionEvent) / this.mSavedXDist;
                    if (xDist < 1.0f) {
                        canZoomInMoreX = viewPortHandler.canZoomOutMoreX();
                    } else {
                        canZoomInMoreX = viewPortHandler.canZoomInMoreX();
                    }
                    if (canZoomInMoreX) {
                        this.mMatrix.set(this.mSavedMatrix);
                        this.mMatrix.postScale(xDist, 1.0f, trans.f32565x, trans.f32566y);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.onChartScale(motionEvent, xDist, 1.0f);
                        }
                    }
                } else if (this.mTouchMode == 3 && ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.Y_ZOOM;
                    float yDist = getYDist(motionEvent) / this.mSavedYDist;
                    if (yDist < 1.0f) {
                        z5 = true;
                    }
                    if (z5) {
                        canZoomInMoreY = viewPortHandler.canZoomOutMoreY();
                    } else {
                        canZoomInMoreY = viewPortHandler.canZoomInMoreY();
                    }
                    if (canZoomInMoreY) {
                        this.mMatrix.set(this.mSavedMatrix);
                        this.mMatrix.postScale(1.0f, yDist, trans.f32565x, trans.f32566y);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.onChartScale(motionEvent, 1.0f, yDist);
                        }
                    }
                }
                MPPointF.recycleInstance(trans);
            }
        }
    }

    public void setDragTriggerDist(float f6) {
        this.mDragTriggerDist = Utils.convertDpToPixel(f6);
    }
}
