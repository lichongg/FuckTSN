package com.github.mikephil.charting.data;

import android.graphics.Typeface;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class ChartData<T extends IDataSet<? extends Entry>> {
    protected List<T> mDataSets;
    protected float mLeftAxisMax;
    protected float mLeftAxisMin;
    protected float mRightAxisMax;
    protected float mRightAxisMin;
    protected float mXMax;
    protected float mXMin;
    protected float mYMax;
    protected float mYMin;

    public ChartData() {
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        this.mDataSets = new ArrayList();
    }

    protected void calcMinMax() {
        List<T> list = this.mDataSets;
        if (list == null) {
            return;
        }
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            calcMinMax(it.next());
        }
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        T firstLeft = getFirstLeft(this.mDataSets);
        if (firstLeft != null) {
            this.mLeftAxisMax = firstLeft.getYMax();
            this.mLeftAxisMin = firstLeft.getYMin();
            for (T t5 : this.mDataSets) {
                if (t5.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                    if (t5.getYMin() < this.mLeftAxisMin) {
                        this.mLeftAxisMin = t5.getYMin();
                    }
                    if (t5.getYMax() > this.mLeftAxisMax) {
                        this.mLeftAxisMax = t5.getYMax();
                    }
                }
            }
        }
        T firstRight = getFirstRight(this.mDataSets);
        if (firstRight != null) {
            this.mRightAxisMax = firstRight.getYMax();
            this.mRightAxisMin = firstRight.getYMin();
            for (T t6 : this.mDataSets) {
                if (t6.getAxisDependency() == YAxis.AxisDependency.RIGHT) {
                    if (t6.getYMin() < this.mRightAxisMin) {
                        this.mRightAxisMin = t6.getYMin();
                    }
                    if (t6.getYMax() > this.mRightAxisMax) {
                        this.mRightAxisMax = t6.getYMax();
                    }
                }
            }
        }
    }

    public T getDataSetForEntry(Entry entry) {
        if (entry == null) {
            return null;
        }
        for (int i6 = 0; i6 < this.mDataSets.size(); i6++) {
            T t5 = this.mDataSets.get(i6);
            for (int i7 = 0; i7 < t5.getEntryCount(); i7++) {
                if (entry.equalTo(t5.getEntryForXValue(entry.getX(), entry.getY()))) {
                    return t5;
                }
            }
        }
        return null;
    }

    protected int getDataSetIndexByLabel(List<T> list, String str, boolean z5) {
        int i6 = 0;
        if (z5) {
            while (i6 < list.size()) {
                if (str.equalsIgnoreCase(list.get(i6).getLabel())) {
                    return i6;
                }
                i6++;
            }
            return -1;
        }
        while (i6 < list.size()) {
            if (str.equals(list.get(i6).getLabel())) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    public float getYMax() {
        return this.mYMax;
    }

    public float getYMin() {
        return this.mYMin;
    }

    public boolean removeDataSet(T t5) {
        if (t5 == null) {
            return false;
        }
        boolean remove = this.mDataSets.remove(t5);
        if (remove) {
            calcMinMax();
        }
        return remove;
    }

    public boolean removeEntry(Entry entry, int i6) {
        T t5;
        if (entry == null || i6 >= this.mDataSets.size() || (t5 = this.mDataSets.get(i6)) == null) {
            return false;
        }
        boolean removeEntry = t5.removeEntry(entry);
        if (removeEntry) {
            calcMinMax();
        }
        return removeEntry;
    }

    private List<T> arrayToList(T[] tArr) {
        ArrayList arrayList = new ArrayList();
        for (T t5 : tArr) {
            arrayList.add(t5);
        }
        return arrayList;
    }

    public void addDataSet(T t5) {
        if (t5 == null) {
            return;
        }
        calcMinMax(t5);
        this.mDataSets.add(t5);
    }

    public void addEntry(Entry entry, int i6) {
        if (this.mDataSets.size() <= i6 || i6 < 0) {
            return;
        }
        T t5 = this.mDataSets.get(i6);
        if (t5.addEntry(entry)) {
            calcMinMax(entry, t5.getAxisDependency());
        }
    }

    public void calcMinMaxY(float f6, float f7) {
        Iterator<T> it = this.mDataSets.iterator();
        while (it.hasNext()) {
            it.next().calcMinMaxY(f6, f7);
        }
        calcMinMax();
    }

    public void clearValues() {
        List<T> list = this.mDataSets;
        if (list != null) {
            list.clear();
        }
        notifyDataChanged();
    }

    public boolean contains(T t5) {
        Iterator<T> it = this.mDataSets.iterator();
        while (it.hasNext()) {
            if (it.next().equals(t5)) {
                return true;
            }
        }
        return false;
    }

    public int[] getColors() {
        if (this.mDataSets == null) {
            return null;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.mDataSets.size(); i7++) {
            i6 += this.mDataSets.get(i7).getColors().size();
        }
        int[] iArr = new int[i6];
        int i8 = 0;
        for (int i9 = 0; i9 < this.mDataSets.size(); i9++) {
            Iterator<Integer> it = this.mDataSets.get(i9).getColors().iterator();
            while (it.hasNext()) {
                iArr[i8] = it.next().intValue();
                i8++;
            }
        }
        return iArr;
    }

    public T getDataSetByIndex(int i6) {
        List<T> list = this.mDataSets;
        if (list == null || i6 < 0 || i6 >= list.size()) {
            return null;
        }
        return this.mDataSets.get(i6);
    }

    public T getDataSetByLabel(String str, boolean z5) {
        int dataSetIndexByLabel = getDataSetIndexByLabel(this.mDataSets, str, z5);
        if (dataSetIndexByLabel < 0 || dataSetIndexByLabel >= this.mDataSets.size()) {
            return null;
        }
        return this.mDataSets.get(dataSetIndexByLabel);
    }

    public int getDataSetCount() {
        List<T> list = this.mDataSets;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public String[] getDataSetLabels() {
        String[] strArr = new String[this.mDataSets.size()];
        for (int i6 = 0; i6 < this.mDataSets.size(); i6++) {
            strArr[i6] = this.mDataSets.get(i6).getLabel();
        }
        return strArr;
    }

    public List<T> getDataSets() {
        return this.mDataSets;
    }

    public int getEntryCount() {
        Iterator<T> it = this.mDataSets.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 += it.next().getEntryCount();
        }
        return i6;
    }

    public int getIndexOfDataSet(T t5) {
        return this.mDataSets.indexOf(t5);
    }

    public T getMaxEntryCountSet() {
        List<T> list = this.mDataSets;
        if (list == null || list.isEmpty()) {
            return null;
        }
        T t5 = this.mDataSets.get(0);
        for (T t6 : this.mDataSets) {
            if (t6.getEntryCount() > t5.getEntryCount()) {
                t5 = t6;
            }
        }
        return t5;
    }

    public float getXMax() {
        return this.mXMax;
    }

    public float getXMin() {
        return this.mXMin;
    }

    public float getYMax(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f6 = this.mLeftAxisMax;
            return f6 == -3.4028235E38f ? this.mRightAxisMax : f6;
        }
        float f7 = this.mRightAxisMax;
        return f7 == -3.4028235E38f ? this.mLeftAxisMax : f7;
    }

    public float getYMin(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f6 = this.mLeftAxisMin;
            return f6 == Float.MAX_VALUE ? this.mRightAxisMin : f6;
        }
        float f7 = this.mRightAxisMin;
        return f7 == Float.MAX_VALUE ? this.mLeftAxisMin : f7;
    }

    public boolean isHighlightEnabled() {
        Iterator<T> it = this.mDataSets.iterator();
        while (it.hasNext()) {
            if (!it.next().isHighlightEnabled()) {
                return false;
            }
        }
        return true;
    }

    public void setDrawValues(boolean z5) {
        Iterator<T> it = this.mDataSets.iterator();
        while (it.hasNext()) {
            it.next().setDrawValues(z5);
        }
    }

    public void setHighlightEnabled(boolean z5) {
        Iterator<T> it = this.mDataSets.iterator();
        while (it.hasNext()) {
            it.next().setHighlightEnabled(z5);
        }
    }

    public void setValueFormatter(ValueFormatter valueFormatter) {
        if (valueFormatter == null) {
            return;
        }
        Iterator<T> it = this.mDataSets.iterator();
        while (it.hasNext()) {
            it.next().setValueFormatter(valueFormatter);
        }
    }

    public void setValueTextColor(int i6) {
        Iterator<T> it = this.mDataSets.iterator();
        while (it.hasNext()) {
            it.next().setValueTextColor(i6);
        }
    }

    public void setValueTextColors(List<Integer> list) {
        Iterator<T> it = this.mDataSets.iterator();
        while (it.hasNext()) {
            it.next().setValueTextColors(list);
        }
    }

    public void setValueTextSize(float f6) {
        Iterator<T> it = this.mDataSets.iterator();
        while (it.hasNext()) {
            it.next().setValueTextSize(f6);
        }
    }

    public void setValueTypeface(Typeface typeface) {
        Iterator<T> it = this.mDataSets.iterator();
        while (it.hasNext()) {
            it.next().setValueTypeface(typeface);
        }
    }

    public Entry getEntryForHighlight(Highlight highlight) {
        if (highlight.getDataSetIndex() >= this.mDataSets.size()) {
            return null;
        }
        return this.mDataSets.get(highlight.getDataSetIndex()).getEntryForXValue(highlight.getX(), highlight.getY());
    }

    protected T getFirstLeft(List<T> list) {
        for (T t5 : list) {
            if (t5.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                return t5;
            }
        }
        return null;
    }

    public T getFirstRight(List<T> list) {
        for (T t5 : list) {
            if (t5.getAxisDependency() == YAxis.AxisDependency.RIGHT) {
                return t5;
            }
        }
        return null;
    }

    public void notifyDataChanged() {
        calcMinMax();
    }

    public boolean removeDataSet(int i6) {
        if (i6 >= this.mDataSets.size() || i6 < 0) {
            return false;
        }
        return removeDataSet((ChartData<T>) this.mDataSets.get(i6));
    }

    public boolean removeEntry(float f6, int i6) {
        Entry entryForXValue;
        if (i6 < this.mDataSets.size() && (entryForXValue = this.mDataSets.get(i6).getEntryForXValue(f6, Float.NaN)) != null) {
            return removeEntry(entryForXValue, i6);
        }
        return false;
    }

    public ChartData(T... tArr) {
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        this.mDataSets = arrayToList(tArr);
        notifyDataChanged();
    }

    public ChartData(List<T> list) {
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        this.mDataSets = list;
        notifyDataChanged();
    }

    protected void calcMinMax(Entry entry, YAxis.AxisDependency axisDependency) {
        if (this.mYMax < entry.getY()) {
            this.mYMax = entry.getY();
        }
        if (this.mYMin > entry.getY()) {
            this.mYMin = entry.getY();
        }
        if (this.mXMax < entry.getX()) {
            this.mXMax = entry.getX();
        }
        if (this.mXMin > entry.getX()) {
            this.mXMin = entry.getX();
        }
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            if (this.mLeftAxisMax < entry.getY()) {
                this.mLeftAxisMax = entry.getY();
            }
            if (this.mLeftAxisMin > entry.getY()) {
                this.mLeftAxisMin = entry.getY();
                return;
            }
            return;
        }
        if (this.mRightAxisMax < entry.getY()) {
            this.mRightAxisMax = entry.getY();
        }
        if (this.mRightAxisMin > entry.getY()) {
            this.mRightAxisMin = entry.getY();
        }
    }

    protected void calcMinMax(T t5) {
        if (this.mYMax < t5.getYMax()) {
            this.mYMax = t5.getYMax();
        }
        if (this.mYMin > t5.getYMin()) {
            this.mYMin = t5.getYMin();
        }
        if (this.mXMax < t5.getXMax()) {
            this.mXMax = t5.getXMax();
        }
        if (this.mXMin > t5.getXMin()) {
            this.mXMin = t5.getXMin();
        }
        if (t5.getAxisDependency() == YAxis.AxisDependency.LEFT) {
            if (this.mLeftAxisMax < t5.getYMax()) {
                this.mLeftAxisMax = t5.getYMax();
            }
            if (this.mLeftAxisMin > t5.getYMin()) {
                this.mLeftAxisMin = t5.getYMin();
                return;
            }
            return;
        }
        if (this.mRightAxisMax < t5.getYMax()) {
            this.mRightAxisMax = t5.getYMax();
        }
        if (this.mRightAxisMin > t5.getYMin()) {
            this.mRightAxisMin = t5.getYMin();
        }
    }
}
