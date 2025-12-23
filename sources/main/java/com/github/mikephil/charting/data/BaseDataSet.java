package com.github.mikephil.charting.data;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.net.ftp.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class BaseDataSet<T extends Entry> implements IDataSet<T> {
    protected YAxis.AxisDependency mAxisDependency;
    protected List<Integer> mColors;
    protected boolean mDrawIcons;
    protected boolean mDrawValues;
    private Legend.LegendForm mForm;
    private DashPathEffect mFormLineDashEffect;
    private float mFormLineWidth;
    private float mFormSize;
    protected GradientColor mGradientColor;
    protected List<GradientColor> mGradientColors;
    protected boolean mHighlightEnabled;
    protected MPPointF mIconsOffset;
    private String mLabel;
    protected List<Integer> mValueColors;
    protected transient ValueFormatter mValueFormatter;
    protected float mValueTextSize;
    protected Typeface mValueTypeface;
    protected boolean mVisible;

    public BaseDataSet() {
        this.mColors = null;
        this.mGradientColor = null;
        this.mGradientColors = null;
        this.mValueColors = null;
        this.mLabel = "DataSet";
        this.mAxisDependency = YAxis.AxisDependency.LEFT;
        this.mHighlightEnabled = true;
        this.mForm = Legend.LegendForm.DEFAULT;
        this.mFormSize = Float.NaN;
        this.mFormLineWidth = Float.NaN;
        this.mFormLineDashEffect = null;
        this.mDrawValues = true;
        this.mDrawIcons = true;
        this.mIconsOffset = new MPPointF();
        this.mValueTextSize = 17.0f;
        this.mVisible = true;
        this.mColors = new ArrayList();
        this.mValueColors = new ArrayList();
        this.mColors.add(Integer.valueOf(Color.rgb(140, l.O, 255)));
        this.mValueColors.add(Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean contains(T t5) {
        for (int i6 = 0; i6 < getEntryCount(); i6++) {
            if (getEntryForIndex(i6).equals(t5)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getColor() {
        return this.mColors.get(0).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public GradientColor getGradientColor() {
        return this.mGradientColor;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getIndexInEntries(int i6) {
        for (int i7 = 0; i7 < getEntryCount(); i7++) {
            if (i6 == getEntryForIndex(i7).getX()) {
                return i7;
            }
        }
        return -1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getValueTextColor() {
        return this.mValueColors.get(0).intValue();
    }

    public void setColor(int i6) {
        resetColors();
        this.mColors.add(Integer.valueOf(i6));
    }

    public void setColors(List<Integer> list) {
        this.mColors = list;
    }

    public void addColor(int i6) {
        if (this.mColors == null) {
            this.mColors = new ArrayList();
        }
        this.mColors.add(Integer.valueOf(i6));
    }

    protected void copy(BaseDataSet baseDataSet) {
        baseDataSet.mAxisDependency = this.mAxisDependency;
        baseDataSet.mColors = this.mColors;
        baseDataSet.mDrawIcons = this.mDrawIcons;
        baseDataSet.mDrawValues = this.mDrawValues;
        baseDataSet.mForm = this.mForm;
        baseDataSet.mFormLineDashEffect = this.mFormLineDashEffect;
        baseDataSet.mFormLineWidth = this.mFormLineWidth;
        baseDataSet.mFormSize = this.mFormSize;
        baseDataSet.mGradientColor = this.mGradientColor;
        baseDataSet.mGradientColors = this.mGradientColors;
        baseDataSet.mHighlightEnabled = this.mHighlightEnabled;
        baseDataSet.mIconsOffset = this.mIconsOffset;
        baseDataSet.mValueColors = this.mValueColors;
        baseDataSet.mValueFormatter = this.mValueFormatter;
        baseDataSet.mValueColors = this.mValueColors;
        baseDataSet.mValueTextSize = this.mValueTextSize;
        baseDataSet.mVisible = this.mVisible;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public YAxis.AxisDependency getAxisDependency() {
        return this.mAxisDependency;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getColor(int i6) {
        List<Integer> list = this.mColors;
        return list.get(i6 % list.size()).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public List<Integer> getColors() {
        return this.mColors;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public Legend.LegendForm getForm() {
        return this.mForm;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public DashPathEffect getFormLineDashEffect() {
        return this.mFormLineDashEffect;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getFormLineWidth() {
        return this.mFormLineWidth;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getFormSize() {
        return this.mFormSize;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public GradientColor getGradientColor(int i6) {
        List<GradientColor> list = this.mGradientColors;
        return list.get(i6 % list.size());
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public List<GradientColor> getGradientColors() {
        return this.mGradientColors;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public MPPointF getIconsOffset() {
        return this.mIconsOffset;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public String getLabel() {
        return this.mLabel;
    }

    public List<Integer> getValueColors() {
        return this.mValueColors;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getValueTextColor(int i6) {
        List<Integer> list = this.mValueColors;
        return list.get(i6 % list.size()).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getValueTextSize() {
        return this.mValueTextSize;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public Typeface getValueTypeface() {
        return this.mValueTypeface;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean isDrawIconsEnabled() {
        return this.mDrawIcons;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean isDrawValuesEnabled() {
        return this.mDrawValues;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean isHighlightEnabled() {
        return this.mHighlightEnabled;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean isVisible() {
        return this.mVisible;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean needsFormatter() {
        return this.mValueFormatter == null;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean removeEntryByXValue(float f6) {
        return removeEntry((BaseDataSet<T>) getEntryForXValue(f6, Float.NaN));
    }

    public void resetColors() {
        if (this.mColors == null) {
            this.mColors = new ArrayList();
        }
        this.mColors.clear();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setAxisDependency(YAxis.AxisDependency axisDependency) {
        this.mAxisDependency = axisDependency;
    }

    public void setColors(int... iArr) {
        this.mColors = ColorTemplate.createColors(iArr);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setDrawIcons(boolean z5) {
        this.mDrawIcons = z5;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setDrawValues(boolean z5) {
        this.mDrawValues = z5;
    }

    public void setForm(Legend.LegendForm legendForm) {
        this.mForm = legendForm;
    }

    public void setFormLineDashEffect(DashPathEffect dashPathEffect) {
        this.mFormLineDashEffect = dashPathEffect;
    }

    public void setFormLineWidth(float f6) {
        this.mFormLineWidth = f6;
    }

    public void setFormSize(float f6) {
        this.mFormSize = f6;
    }

    public void setGradientColor(int i6, int i7) {
        this.mGradientColor = new GradientColor(i6, i7);
    }

    public void setGradientColors(List<GradientColor> list) {
        this.mGradientColors = list;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setHighlightEnabled(boolean z5) {
        this.mHighlightEnabled = z5;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setIconsOffset(MPPointF mPPointF) {
        MPPointF mPPointF2 = this.mIconsOffset;
        mPPointF2.f32565x = mPPointF.f32565x;
        mPPointF2.f32566y = mPPointF.f32566y;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setLabel(String str) {
        this.mLabel = str;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setValueFormatter(ValueFormatter valueFormatter) {
        if (valueFormatter == null) {
            return;
        }
        this.mValueFormatter = valueFormatter;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setValueTextColor(int i6) {
        this.mValueColors.clear();
        this.mValueColors.add(Integer.valueOf(i6));
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setValueTextColors(List<Integer> list) {
        this.mValueColors = list;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setValueTypeface(Typeface typeface) {
        this.mValueTypeface = typeface;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setVisible(boolean z5) {
        this.mVisible = z5;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public ValueFormatter getValueFormatter() {
        if (needsFormatter()) {
            return Utils.getDefaultValueFormatter();
        }
        return this.mValueFormatter;
    }

    public void notifyDataSetChanged() {
        calcMinMax();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean removeEntry(int i6) {
        return removeEntry((BaseDataSet<T>) getEntryForIndex(i6));
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean removeFirst() {
        if (getEntryCount() <= 0) {
            return false;
        }
        return removeEntry((BaseDataSet<T>) getEntryForIndex(0));
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean removeLast() {
        if (getEntryCount() > 0) {
            return removeEntry((BaseDataSet<T>) getEntryForIndex(getEntryCount() - 1));
        }
        return false;
    }

    public void setColor(int i6, int i7) {
        setColor(Color.argb(i7, Color.red(i6), Color.green(i6), Color.blue(i6)));
    }

    public void setColors(int[] iArr, Context context) {
        if (this.mColors == null) {
            this.mColors = new ArrayList();
        }
        this.mColors.clear();
        for (int i6 : iArr) {
            this.mColors.add(Integer.valueOf(context.getResources().getColor(i6)));
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setValueTextSize(float f6) {
        this.mValueTextSize = Utils.convertDpToPixel(f6);
    }

    public void setColors(int[] iArr, int i6) {
        resetColors();
        for (int i7 : iArr) {
            addColor(Color.argb(i6, Color.red(i7), Color.green(i7), Color.blue(i7)));
        }
    }

    public BaseDataSet(String str) {
        this();
        this.mLabel = str;
    }
}
