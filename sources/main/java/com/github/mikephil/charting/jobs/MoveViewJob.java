package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class MoveViewJob extends ViewPortJob {
    private static ObjectPool<MoveViewJob> pool;

    static {
        ObjectPool<MoveViewJob> create = ObjectPool.create(2, new MoveViewJob(null, 0.0f, 0.0f, null, null));
        pool = create;
        create.setReplenishPercentage(0.5f);
    }

    public static MoveViewJob getInstance(ViewPortHandler viewPortHandler, float f6, float f7, Transformer transformer, View view) {
        MoveViewJob moveViewJob = pool.get();
        moveViewJob.mViewPortHandler = viewPortHandler;
        moveViewJob.xValue = f6;
        moveViewJob.yValue = f7;
        moveViewJob.mTrans = transformer;
        moveViewJob.view = view;
        return moveViewJob;
    }

    public static void recycleInstance(MoveViewJob moveViewJob) {
        pool.recycle((ObjectPool<MoveViewJob>) moveViewJob);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new MoveViewJob(this.mViewPortHandler, this.xValue, this.yValue, this.mTrans, this.view);
    }

    @Override // java.lang.Runnable
    public void run() {
        float[] fArr = this.pts;
        fArr[0] = this.xValue;
        fArr[1] = this.yValue;
        this.mTrans.pointValuesToPixel(fArr);
        this.mViewPortHandler.centerViewPort(this.pts, this.view);
        recycleInstance(this);
    }

    public MoveViewJob(ViewPortHandler viewPortHandler, float f6, float f7, Transformer transformer, View view) {
        super(viewPortHandler, f6, f7, transformer, view);
    }
}
