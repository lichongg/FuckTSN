package com.github.mikephil.charting.data;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import com.github.mikephil.charting.formatter.DefaultFillFormatter;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.net.ftp.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class LineDataSet extends LineRadarDataSet<Entry> implements ILineDataSet {
    private List<Integer> mCircleColors;
    private int mCircleHoleColor;
    private float mCircleHoleRadius;
    private float mCircleRadius;
    private float mCubicIntensity;
    private DashPathEffect mDashPathEffect;
    private boolean mDrawCircleHole;
    private boolean mDrawCircles;
    private IFillFormatter mFillFormatter;
    private Mode mMode;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Mode {
        LINEAR,
        STEPPED,
        CUBIC_BEZIER,
        HORIZONTAL_BEZIER
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<Entry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < this.mValues.size(); i6++) {
            arrayList.add(((Entry) this.mValues.get(i6)).copy());
        }
        LineDataSet lineDataSet = new LineDataSet(arrayList, getLabel());
        copy(lineDataSet);
        return lineDataSet;
    }

    public void disableDashedLine() {
        this.mDashPathEffect = null;
    }

    public void setCircleColors(List<Integer> list) {
        this.mCircleColors = list;
    }

    public void enableDashedLine(float f6, float f7, float f8) {
        this.mDashPathEffect = new DashPathEffect(new float[]{f6, f7}, f8);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public int getCircleColor(int i6) {
        return this.mCircleColors.get(i6).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public int getCircleColorCount() {
        return this.mCircleColors.size();
    }

    public List<Integer> getCircleColors() {
        return this.mCircleColors;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public int getCircleHoleColor() {
        return this.mCircleHoleColor;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public float getCircleHoleRadius() {
        return this.mCircleHoleRadius;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public float getCircleRadius() {
        return this.mCircleRadius;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public float getCubicIntensity() {
        return this.mCubicIntensity;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public DashPathEffect getDashPathEffect() {
        return this.mDashPathEffect;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public IFillFormatter getFillFormatter() {
        return this.mFillFormatter;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public Mode getMode() {
        return this.mMode;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public boolean isDashedLineEnabled() {
        return this.mDashPathEffect != null;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public boolean isDrawCircleHoleEnabled() {
        return this.mDrawCircleHole;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public boolean isDrawCirclesEnabled() {
        return this.mDrawCircles;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    @Deprecated
    public boolean isDrawCubicEnabled() {
        return this.mMode == Mode.CUBIC_BEZIER;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    @Deprecated
    public boolean isDrawSteppedEnabled() {
        return this.mMode == Mode.STEPPED;
    }

    public void resetCircleColors() {
        if (this.mCircleColors == null) {
            this.mCircleColors = new ArrayList();
        }
        this.mCircleColors.clear();
    }

    public void setCircleColors(int... iArr) {
        this.mCircleColors = ColorTemplate.createColors(iArr);
    }

    public void setCircleHoleColor(int i6) {
        this.mCircleHoleColor = i6;
    }

    public void setCircleHoleRadius(float f6) {
        if (f6 >= 0.5f) {
            this.mCircleHoleRadius = Utils.convertDpToPixel(f6);
        }
    }

    public void setCircleRadius(float f6) {
        if (f6 >= 1.0f) {
            this.mCircleRadius = Utils.convertDpToPixel(f6);
        }
    }

    public void setCubicIntensity(float f6) {
        if (f6 > 1.0f) {
            f6 = 1.0f;
        }
        if (f6 < 0.05f) {
            f6 = 0.05f;
        }
        this.mCubicIntensity = f6;
    }

    public void setDrawCircleHole(boolean z5) {
        this.mDrawCircleHole = z5;
    }

    public void setDrawCircles(boolean z5) {
        this.mDrawCircles = z5;
    }

    public void setFillFormatter(IFillFormatter iFillFormatter) {
        if (iFillFormatter == null) {
            this.mFillFormatter = new DefaultFillFormatter();
        } else {
            this.mFillFormatter = iFillFormatter;
        }
    }

    public void setMode(Mode mode) {
        this.mMode = mode;
    }

    public LineDataSet(List<Entry> list, String str) {
        super(list, str);
        this.mMode = Mode.LINEAR;
        this.mCircleColors = null;
        this.mCircleHoleColor = -1;
        this.mCircleRadius = 8.0f;
        this.mCircleHoleRadius = 4.0f;
        this.mCubicIntensity = 0.2f;
        this.mDashPathEffect = null;
        this.mFillFormatter = new DefaultFillFormatter();
        this.mDrawCircles = true;
        this.mDrawCircleHole = true;
        if (this.mCircleColors == null) {
            this.mCircleColors = new ArrayList();
        }
        this.mCircleColors.clear();
        this.mCircleColors.add(Integer.valueOf(Color.rgb(140, l.O, 255)));
    }

    @Deprecated
    public float getCircleSize() {
        return getCircleRadius();
    }

    public void setCircleColor(int i6) {
        resetCircleColors();
        this.mCircleColors.add(Integer.valueOf(i6));
    }

    public void setCircleColors(int[] iArr, Context context) {
        List<Integer> list = this.mCircleColors;
        if (list == null) {
            list = new ArrayList<>();
        }
        list.clear();
        for (int i6 : iArr) {
            list.add(Integer.valueOf(context.getResources().getColor(i6)));
        }
        this.mCircleColors = list;
    }

    @Deprecated
    public void setCircleSize(float f6) {
        setCircleRadius(f6);
    }

    protected void copy(LineDataSet lineDataSet) {
        super.copy((LineRadarDataSet) lineDataSet);
        lineDataSet.mCircleColors = this.mCircleColors;
        lineDataSet.mCircleHoleColor = this.mCircleHoleColor;
        lineDataSet.mCircleHoleRadius = this.mCircleHoleRadius;
        lineDataSet.mCircleRadius = this.mCircleRadius;
        lineDataSet.mCubicIntensity = this.mCubicIntensity;
        lineDataSet.mDashPathEffect = this.mDashPathEffect;
        lineDataSet.mDrawCircleHole = this.mDrawCircleHole;
        lineDataSet.mDrawCircles = this.mDrawCircleHole;
        lineDataSet.mFillFormatter = this.mFillFormatter;
        lineDataSet.mMode = this.mMode;
    }
}
