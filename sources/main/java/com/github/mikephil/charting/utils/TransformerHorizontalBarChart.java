package com.github.mikephil.charting.utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class TransformerHorizontalBarChart extends Transformer {
    @Override // com.github.mikephil.charting.utils.Transformer
    public void prepareMatrixOffset(boolean z5) {
        this.mMatrixOffset.reset();
        if (!z5) {
            this.mMatrixOffset.postTranslate(this.mViewPortHandler.offsetLeft(), this.mViewPortHandler.getChartHeight() - this.mViewPortHandler.offsetBottom());
        } else {
            this.mMatrixOffset.setTranslate(-(this.mViewPortHandler.getChartWidth() - this.mViewPortHandler.offsetRight()), this.mViewPortHandler.getChartHeight() - this.mViewPortHandler.offsetBottom());
            this.mMatrixOffset.postScale(-1.0f, 1.0f);
        }
    }

    public TransformerHorizontalBarChart(ViewPortHandler viewPortHandler) {
        super(viewPortHandler);
    }
}
