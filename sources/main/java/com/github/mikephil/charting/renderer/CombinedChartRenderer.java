package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class CombinedChartRenderer extends DataRenderer {
    protected WeakReference<Chart> mChart;
    protected List<Highlight> mHighlightBuffer;
    protected List<DataRenderer> mRenderers;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.github.mikephil.charting.renderer.CombinedChartRenderer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder;

        static {
            int[] iArr = new int[CombinedChart.DrawOrder.values().length];
            $SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder = iArr;
            try {
                iArr[CombinedChart.DrawOrder.BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder[CombinedChart.DrawOrder.BUBBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder[CombinedChart.DrawOrder.LINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder[CombinedChart.DrawOrder.CANDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder[CombinedChart.DrawOrder.SCATTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public void createRenderers() {
        this.mRenderers.clear();
        CombinedChart combinedChart = (CombinedChart) this.mChart.get();
        if (combinedChart == null) {
            return;
        }
        for (CombinedChart.DrawOrder drawOrder : combinedChart.getDrawOrder()) {
            int i6 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder[drawOrder.ordinal()];
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        if (i6 != 4) {
                            if (i6 == 5 && combinedChart.getScatterData() != null) {
                                this.mRenderers.add(new ScatterChartRenderer(combinedChart, this.mAnimator, this.mViewPortHandler));
                            }
                        } else if (combinedChart.getCandleData() != null) {
                            this.mRenderers.add(new CandleStickChartRenderer(combinedChart, this.mAnimator, this.mViewPortHandler));
                        }
                    } else if (combinedChart.getLineData() != null) {
                        this.mRenderers.add(new LineChartRenderer(combinedChart, this.mAnimator, this.mViewPortHandler));
                    }
                } else if (combinedChart.getBubbleData() != null) {
                    this.mRenderers.add(new BubbleChartRenderer(combinedChart, this.mAnimator, this.mViewPortHandler));
                }
            } else if (combinedChart.getBarData() != null) {
                this.mRenderers.add(new BarChartRenderer(combinedChart, this.mAnimator, this.mViewPortHandler));
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        Iterator<DataRenderer> it = this.mRenderers.iterator();
        while (it.hasNext()) {
            it.next().drawData(canvas);
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
        Iterator<DataRenderer> it = this.mRenderers.iterator();
        while (it.hasNext()) {
            it.next().drawExtras(canvas);
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        Chart chart = this.mChart.get();
        if (chart == null) {
            return;
        }
        for (DataRenderer dataRenderer : this.mRenderers) {
            Object barData = dataRenderer instanceof BarChartRenderer ? ((BarChartRenderer) dataRenderer).mChart.getBarData() : dataRenderer instanceof LineChartRenderer ? ((LineChartRenderer) dataRenderer).mChart.getLineData() : dataRenderer instanceof CandleStickChartRenderer ? ((CandleStickChartRenderer) dataRenderer).mChart.getCandleData() : dataRenderer instanceof ScatterChartRenderer ? ((ScatterChartRenderer) dataRenderer).mChart.getScatterData() : dataRenderer instanceof BubbleChartRenderer ? ((BubbleChartRenderer) dataRenderer).mChart.getBubbleData() : null;
            int indexOf = barData == null ? -1 : ((CombinedData) chart.getData()).getAllData().indexOf(barData);
            this.mHighlightBuffer.clear();
            for (Highlight highlight : highlightArr) {
                if (highlight.getDataIndex() == indexOf || highlight.getDataIndex() == -1) {
                    this.mHighlightBuffer.add(highlight);
                }
            }
            List<Highlight> list = this.mHighlightBuffer;
            dataRenderer.drawHighlighted(canvas, (Highlight[]) list.toArray(new Highlight[list.size()]));
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        Iterator<DataRenderer> it = this.mRenderers.iterator();
        while (it.hasNext()) {
            it.next().drawValues(canvas);
        }
    }

    public DataRenderer getSubRenderer(int i6) {
        if (i6 >= this.mRenderers.size() || i6 < 0) {
            return null;
        }
        return this.mRenderers.get(i6);
    }

    public List<DataRenderer> getSubRenderers() {
        return this.mRenderers;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        Iterator<DataRenderer> it = this.mRenderers.iterator();
        while (it.hasNext()) {
            it.next().initBuffers();
        }
    }

    public void setSubRenderers(List<DataRenderer> list) {
        this.mRenderers = list;
    }

    public CombinedChartRenderer(CombinedChart combinedChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mRenderers = new ArrayList(5);
        this.mHighlightBuffer = new ArrayList();
        this.mChart = new WeakReference<>(combinedChart);
        createRenderers();
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f6, float f7, int i6) {
    }
}
