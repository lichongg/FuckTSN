package com.github.mikephil.charting.jobs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"NewApi"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class AnimatedZoomJob extends AnimatedViewPortJob implements Animator.AnimatorListener {
    private static ObjectPool<AnimatedZoomJob> pool = ObjectPool.create(8, new AnimatedZoomJob(null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0));
    protected Matrix mOnAnimationUpdateMatrixBuffer;
    protected float xAxisRange;
    protected YAxis yAxis;
    protected float zoomCenterX;
    protected float zoomCenterY;
    protected float zoomOriginX;
    protected float zoomOriginY;

    @SuppressLint({"NewApi"})
    public AnimatedZoomJob(ViewPortHandler viewPortHandler, View view, Transformer transformer, YAxis yAxis, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, long j6) {
        super(viewPortHandler, f7, f8, transformer, view, f9, f10, j6);
        this.mOnAnimationUpdateMatrixBuffer = new Matrix();
        this.zoomCenterX = f11;
        this.zoomCenterY = f12;
        this.zoomOriginX = f13;
        this.zoomOriginY = f14;
        this.animator.addListener(this);
        this.yAxis = yAxis;
        this.xAxisRange = f6;
    }

    public static AnimatedZoomJob getInstance(ViewPortHandler viewPortHandler, View view, Transformer transformer, YAxis yAxis, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, long j6) {
        AnimatedZoomJob animatedZoomJob = pool.get();
        animatedZoomJob.mViewPortHandler = viewPortHandler;
        animatedZoomJob.xValue = f7;
        animatedZoomJob.yValue = f8;
        animatedZoomJob.mTrans = transformer;
        animatedZoomJob.view = view;
        animatedZoomJob.xOrigin = f9;
        animatedZoomJob.yOrigin = f10;
        animatedZoomJob.yAxis = yAxis;
        animatedZoomJob.xAxisRange = f6;
        animatedZoomJob.resetAnimator();
        animatedZoomJob.animator.setDuration(j6);
        return animatedZoomJob;
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new AnimatedZoomJob(null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L);
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ((BarLineChartBase) this.view).calculateOffsets();
        this.view.postInvalidate();
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f6 = this.xOrigin;
        float f7 = this.xValue - f6;
        float f8 = this.phase;
        float f9 = f6 + (f7 * f8);
        float f10 = this.yOrigin;
        float f11 = f10 + ((this.yValue - f10) * f8);
        Matrix matrix = this.mOnAnimationUpdateMatrixBuffer;
        this.mViewPortHandler.setZoom(f9, f11, matrix);
        this.mViewPortHandler.refresh(matrix, this.view, false);
        float scaleY = this.yAxis.mAxisRange / this.mViewPortHandler.getScaleY();
        float scaleX = this.xAxisRange / this.mViewPortHandler.getScaleX();
        float[] fArr = this.pts;
        float f12 = this.zoomOriginX;
        float f13 = (this.zoomCenterX - (scaleX / 2.0f)) - f12;
        float f14 = this.phase;
        fArr[0] = f12 + (f13 * f14);
        float f15 = this.zoomOriginY;
        fArr[1] = f15 + (((this.zoomCenterY + (scaleY / 2.0f)) - f15) * f14);
        this.mTrans.pointValuesToPixel(fArr);
        this.mViewPortHandler.translate(this.pts, matrix);
        this.mViewPortHandler.refresh(matrix, this.view, true);
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob
    public void recycleSelf() {
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
