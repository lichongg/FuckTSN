package com.github.mikephil.charting.data;

import com.github.mikephil.charting.data.Entry;
import com.snail.antifake.deviceid.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class DataSet<T extends Entry> extends BaseDataSet<T> {
    protected List<T> mValues;
    protected float mXMax;
    protected float mXMin;
    protected float mYMax;
    protected float mYMin;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Rounding {
        UP,
        DOWN,
        CLOSEST
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void calcMinMax() {
        List<T> list = this.mValues;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        Iterator<T> it = this.mValues.iterator();
        while (it.hasNext()) {
            calcMinMax(it.next());
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void calcMinMaxY(float f6, float f7) {
        List<T> list = this.mValues;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        int entryIndex = getEntryIndex(f7, Float.NaN, Rounding.UP);
        for (int entryIndex2 = getEntryIndex(f6, Float.NaN, Rounding.DOWN); entryIndex2 <= entryIndex; entryIndex2++) {
            calcMinMaxY(this.mValues.get(entryIndex2));
        }
    }

    public abstract DataSet<T> copy();

    protected void copy(DataSet dataSet) {
        super.copy((BaseDataSet) dataSet);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public T getEntryForXValue(float f6, float f7, Rounding rounding) {
        int entryIndex = getEntryIndex(f6, f7, rounding);
        if (entryIndex > -1) {
            return this.mValues.get(entryIndex);
        }
        return null;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getEntryIndex(Entry entry) {
        return this.mValues.indexOf(entry);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean removeEntry(T t5) {
        List<T> list;
        if (t5 == null || (list = this.mValues) == null) {
            return false;
        }
        boolean remove = list.remove(t5);
        if (remove) {
            calcMinMax();
        }
        return remove;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean addEntry(T t5) {
        if (t5 == null) {
            return false;
        }
        List<T> values = getValues();
        if (values == null) {
            values = new ArrayList<>();
        }
        calcMinMax(t5);
        return values.add(t5);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void addEntryOrdered(T t5) {
        if (t5 == null) {
            return;
        }
        if (this.mValues == null) {
            this.mValues = new ArrayList();
        }
        calcMinMax(t5);
        if (this.mValues.size() > 0) {
            if (this.mValues.get(r0.size() - 1).getX() > t5.getX()) {
                this.mValues.add(getEntryIndex(t5.getX(), t5.getY(), Rounding.UP), t5);
                return;
            }
        }
        this.mValues.add(t5);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void clear() {
        this.mValues.clear();
        notifyDataSetChanged();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public List<T> getEntriesForXValue(float f6) {
        ArrayList arrayList = new ArrayList();
        int size = this.mValues.size() - 1;
        int i6 = 0;
        while (true) {
            if (i6 > size) {
                break;
            }
            int i7 = (size + i6) / 2;
            T t5 = this.mValues.get(i7);
            if (f6 == t5.getX()) {
                while (i7 > 0 && this.mValues.get(i7 - 1).getX() == f6) {
                    i7--;
                }
                int size2 = this.mValues.size();
                while (i7 < size2) {
                    T t6 = this.mValues.get(i7);
                    if (t6.getX() != f6) {
                        break;
                    }
                    arrayList.add(t6);
                    i7++;
                }
            } else if (f6 > t5.getX()) {
                i6 = i7 + 1;
            } else {
                size = i7 - 1;
            }
        }
        return arrayList;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getEntryCount() {
        return this.mValues.size();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public T getEntryForIndex(int i6) {
        return this.mValues.get(i6);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getEntryIndex(float f6, float f7, Rounding rounding) {
        int i6;
        T t5;
        List<T> list = this.mValues;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int size = this.mValues.size() - 1;
        int i7 = 0;
        while (i7 < size) {
            int i8 = (i7 + size) / 2;
            float x5 = this.mValues.get(i8).getX() - f6;
            int i9 = i8 + 1;
            float x6 = this.mValues.get(i9).getX() - f6;
            float abs = Math.abs(x5);
            float abs2 = Math.abs(x6);
            if (abs2 >= abs) {
                if (abs >= abs2) {
                    double d6 = x5;
                    if (d6 < 0.0d) {
                        if (d6 < 0.0d) {
                        }
                    }
                }
                size = i8;
            }
            i7 = i9;
        }
        if (size != -1) {
            float x7 = this.mValues.get(size).getX();
            if (rounding == Rounding.UP) {
                if (x7 < f6 && size < this.mValues.size() - 1) {
                    size++;
                }
            } else if (rounding == Rounding.DOWN && x7 > f6 && size > 0) {
                size--;
            }
            if (!Float.isNaN(f7)) {
                while (size > 0 && this.mValues.get(size - 1).getX() == x7) {
                    size--;
                }
                float y5 = this.mValues.get(size).getY();
                loop2: while (true) {
                    i6 = size;
                    do {
                        size++;
                        if (size >= this.mValues.size()) {
                            break loop2;
                        }
                        t5 = this.mValues.get(size);
                        if (t5.getX() != x7) {
                            break loop2;
                        }
                    } while (Math.abs(t5.getY() - f7) >= Math.abs(y5 - f7));
                    y5 = f7;
                }
                return i6;
            }
        }
        return size;
    }

    public List<T> getValues() {
        return this.mValues;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getXMax() {
        return this.mXMax;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getXMin() {
        return this.mXMin;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getYMax() {
        return this.mYMax;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getYMin() {
        return this.mYMin;
    }

    public void setValues(List<T> list) {
        this.mValues = list;
        notifyDataSetChanged();
    }

    public String toSimpleString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        sb.append("DataSet, label: ");
        sb.append(getLabel() == null ? "" : getLabel());
        sb.append(", entries: ");
        sb.append(this.mValues.size());
        sb.append(e.f37542d);
        stringBuffer.append(sb.toString());
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(toSimpleString());
        for (int i6 = 0; i6 < this.mValues.size(); i6++) {
            stringBuffer.append(this.mValues.get(i6).toString() + " ");
        }
        return stringBuffer.toString();
    }

    public DataSet(List<T> list, String str) {
        super(str);
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mValues = list;
        if (list == null) {
            this.mValues = new ArrayList();
        }
        calcMinMax();
    }

    protected void calcMinMaxX(T t5) {
        if (t5.getX() < this.mXMin) {
            this.mXMin = t5.getX();
        }
        if (t5.getX() > this.mXMax) {
            this.mXMax = t5.getX();
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public T getEntryForXValue(float f6, float f7) {
        return getEntryForXValue(f6, f7, Rounding.CLOSEST);
    }

    protected void calcMinMaxY(T t5) {
        if (t5.getY() < this.mYMin) {
            this.mYMin = t5.getY();
        }
        if (t5.getY() > this.mYMax) {
            this.mYMax = t5.getY();
        }
    }

    protected void calcMinMax(T t5) {
        if (t5 == null) {
            return;
        }
        calcMinMaxX(t5);
        calcMinMaxY(t5);
    }
}
