package com.github.mikephil.charting.data;

import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.scatter.ChevronDownShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.ChevronUpShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.CircleShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.CrossShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.SquareShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.TriangleShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.XShapeRenderer;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class ScatterDataSet extends LineScatterCandleRadarDataSet<Entry> implements IScatterDataSet {
    private int mScatterShapeHoleColor;
    private float mScatterShapeHoleRadius;
    protected IShapeRenderer mShapeRenderer;
    private float mShapeSize;

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<Entry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < this.mValues.size(); i6++) {
            arrayList.add(((Entry) this.mValues.get(i6)).copy());
        }
        ScatterDataSet scatterDataSet = new ScatterDataSet(arrayList, getLabel());
        copy(scatterDataSet);
        return scatterDataSet;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.github.mikephil.charting.data.ScatterDataSet$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape;

        static {
            int[] iArr = new int[ScatterChart.ScatterShape.values().length];
            $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape = iArr;
            try {
                iArr[ScatterChart.ScatterShape.SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[ScatterChart.ScatterShape.CIRCLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[ScatterChart.ScatterShape.TRIANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[ScatterChart.ScatterShape.CROSS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[ScatterChart.ScatterShape.X.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[ScatterChart.ScatterShape.CHEVRON_UP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[ScatterChart.ScatterShape.CHEVRON_DOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static IShapeRenderer getRendererForShape(ScatterChart.ScatterShape scatterShape) {
        switch (AnonymousClass1.$SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[scatterShape.ordinal()]) {
            case 1:
                return new SquareShapeRenderer();
            case 2:
                return new CircleShapeRenderer();
            case 3:
                return new TriangleShapeRenderer();
            case 4:
                return new CrossShapeRenderer();
            case 5:
                return new XShapeRenderer();
            case 6:
                return new ChevronUpShapeRenderer();
            case 7:
                return new ChevronDownShapeRenderer();
            default:
                return null;
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
    public int getScatterShapeHoleColor() {
        return this.mScatterShapeHoleColor;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
    public float getScatterShapeHoleRadius() {
        return this.mScatterShapeHoleRadius;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
    public float getScatterShapeSize() {
        return this.mShapeSize;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
    public IShapeRenderer getShapeRenderer() {
        return this.mShapeRenderer;
    }

    public void setScatterShapeHoleColor(int i6) {
        this.mScatterShapeHoleColor = i6;
    }

    public void setScatterShapeHoleRadius(float f6) {
        this.mScatterShapeHoleRadius = f6;
    }

    public void setScatterShapeSize(float f6) {
        this.mShapeSize = f6;
    }

    public void setShapeRenderer(IShapeRenderer iShapeRenderer) {
        this.mShapeRenderer = iShapeRenderer;
    }

    public ScatterDataSet(List<Entry> list, String str) {
        super(list, str);
        this.mShapeSize = 15.0f;
        this.mShapeRenderer = new SquareShapeRenderer();
        this.mScatterShapeHoleRadius = 0.0f;
        this.mScatterShapeHoleColor = ColorTemplate.COLOR_NONE;
    }

    public void setScatterShape(ScatterChart.ScatterShape scatterShape) {
        this.mShapeRenderer = getRendererForShape(scatterShape);
    }

    protected void copy(ScatterDataSet scatterDataSet) {
        super.copy((LineScatterCandleRadarDataSet) scatterDataSet);
        scatterDataSet.mShapeSize = this.mShapeSize;
        scatterDataSet.mShapeRenderer = this.mShapeRenderer;
        scatterDataSet.mScatterShapeHoleRadius = this.mScatterShapeHoleRadius;
        scatterDataSet.mScatterShapeHoleColor = this.mScatterShapeHoleColor;
    }
}
