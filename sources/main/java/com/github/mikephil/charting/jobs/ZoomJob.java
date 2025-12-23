package com.github.mikephil.charting.jobs;

import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class ZoomJob extends ViewPortJob {
    private static ObjectPool<ZoomJob> pool;
    protected YAxis.AxisDependency axisDependency;
    protected Matrix mRunMatrixBuffer;
    protected float scaleX;
    protected float scaleY;

    public ZoomJob(ViewPortHandler viewPortHandler, float f6, float f7, float f8, float f9, Transformer transformer, YAxis.AxisDependency axisDependency, View view) {
        super(viewPortHandler, f8, f9, transformer, view);
        this.mRunMatrixBuffer = new Matrix();
        this.scaleX = f6;
        this.scaleY = f7;
        this.axisDependency = axisDependency;
    }

    static {
        ObjectPool<ZoomJob> create = ObjectPool.create(1, new ZoomJob(null, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null));
        pool = create;
        create.setReplenishPercentage(0.5f);
    }

    public static ZoomJob getInstance(ViewPortHandler viewPortHandler, float f6, float f7, float f8, float f9, Transformer transformer, YAxis.AxisDependency axisDependency, View view) {
        ZoomJob zoomJob = pool.get();
        zoomJob.xValue = f8;
        zoomJob.yValue = f9;
        zoomJob.scaleX = f6;
        zoomJob.scaleY = f7;
        zoomJob.mViewPortHandler = viewPortHandler;
        zoomJob.mTrans = transformer;
        zoomJob.axisDependency = axisDependency;
        zoomJob.view = view;
        return zoomJob;
    }

    public static void recycleInstance(ZoomJob zoomJob) {
        pool.recycle((ObjectPool<ZoomJob>) zoomJob);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new ZoomJob(null, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null);
    }

    @Override // java.lang.Runnable
    public void run() {
        Matrix matrix = this.mRunMatrixBuffer;
        this.mViewPortHandler.zoom(this.scaleX, this.scaleY, matrix);
        this.mViewPortHandler.refresh(matrix, this.view, false);
        float scaleY = ((BarLineChartBase) this.view).getAxis(this.axisDependency).mAxisRange / this.mViewPortHandler.getScaleY();
        float scaleX = ((BarLineChartBase) this.view).getXAxis().mAxisRange / this.mViewPortHandler.getScaleX();
        float[] fArr = this.pts;
        fArr[0] = this.xValue - (scaleX / 2.0f);
        fArr[1] = this.yValue + (scaleY / 2.0f);
        this.mTrans.pointValuesToPixel(fArr);
        this.mViewPortHandler.translate(this.pts, matrix);
        this.mViewPortHandler.refresh(matrix, this.view, false);
        ((BarLineChartBase) this.view).calculateOffsets();
        this.view.postInvalidate();
        recycleInstance(this);
    }
}
