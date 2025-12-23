package com.github.mikephil.charting.jobs;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"NewApi"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class AnimatedMoveViewJob extends AnimatedViewPortJob {
    private static ObjectPool<AnimatedMoveViewJob> pool;

    static {
        ObjectPool<AnimatedMoveViewJob> create = ObjectPool.create(4, new AnimatedMoveViewJob(null, 0.0f, 0.0f, null, null, 0.0f, 0.0f, 0L));
        pool = create;
        create.setReplenishPercentage(0.5f);
    }

    public static AnimatedMoveViewJob getInstance(ViewPortHandler viewPortHandler, float f6, float f7, Transformer transformer, View view, float f8, float f9, long j6) {
        AnimatedMoveViewJob animatedMoveViewJob = pool.get();
        animatedMoveViewJob.mViewPortHandler = viewPortHandler;
        animatedMoveViewJob.xValue = f6;
        animatedMoveViewJob.yValue = f7;
        animatedMoveViewJob.mTrans = transformer;
        animatedMoveViewJob.view = view;
        animatedMoveViewJob.xOrigin = f8;
        animatedMoveViewJob.yOrigin = f9;
        animatedMoveViewJob.animator.setDuration(j6);
        return animatedMoveViewJob;
    }

    public static void recycleInstance(AnimatedMoveViewJob animatedMoveViewJob) {
        pool.recycle((ObjectPool<AnimatedMoveViewJob>) animatedMoveViewJob);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new AnimatedMoveViewJob(null, 0.0f, 0.0f, null, null, 0.0f, 0.0f, 0L);
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float[] fArr = this.pts;
        float f6 = this.xOrigin;
        float f7 = this.xValue - f6;
        float f8 = this.phase;
        fArr[0] = f6 + (f7 * f8);
        float f9 = this.yOrigin;
        fArr[1] = f9 + ((this.yValue - f9) * f8);
        this.mTrans.pointValuesToPixel(fArr);
        this.mViewPortHandler.centerViewPort(this.pts, this.view);
    }

    public AnimatedMoveViewJob(ViewPortHandler viewPortHandler, float f6, float f7, Transformer transformer, View view, float f8, float f9, long j6) {
        super(viewPortHandler, f6, f7, transformer, view, f8, f9, j6);
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob
    public void recycleSelf() {
        recycleInstance(this);
    }
}
