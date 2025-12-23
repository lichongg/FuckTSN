package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {
    private boolean zaa;
    private ArrayList zab;

    private final void zab() {
        synchronized (this) {
            try {
                if (!this.zaa) {
                    int count = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getCount();
                    ArrayList arrayList = new ArrayList();
                    this.zab = arrayList;
                    if (count > 0) {
                        arrayList.add(0);
                        String primaryDataMarkerColumn = getPrimaryDataMarkerColumn();
                        String string = this.mDataHolder.getString(primaryDataMarkerColumn, 0, this.mDataHolder.getWindowIndex(0));
                        for (int i6 = 1; i6 < count; i6++) {
                            int windowIndex = this.mDataHolder.getWindowIndex(i6);
                            String string2 = this.mDataHolder.getString(primaryDataMarkerColumn, i6, windowIndex);
                            if (string2 == null) {
                                throw new NullPointerException("Missing value for markerColumn: " + primaryDataMarkerColumn + ", at row: " + i6 + ", for window: " + windowIndex);
                            }
                            if (!string2.equals(string)) {
                                this.zab.add(Integer.valueOf(i6));
                                string = string2;
                            }
                        }
                    }
                    this.zaa = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    @KeepForSdk
    protected String getChildDataMarkerColumn() {
        return null;
    }

    @NonNull
    @KeepForSdk
    protected abstract T getEntry(int i6, int i7);

    @NonNull
    @KeepForSdk
    protected abstract String getPrimaryDataMarkerColumn();

    final int zaa(int i6) {
        if (i6 >= 0 && i6 < this.zab.size()) {
            return ((Integer) this.zab.get(i6)).intValue();
        }
        throw new IllegalArgumentException("Position " + i6 + " is out of bounds for this buffer");
    }

    @KeepForSdk
    protected EntityBuffer(@NonNull DataHolder dataHolder) {
        super(dataHolder);
        this.zaa = false;
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public final T get(int i6) {
        int intValue;
        int intValue2;
        zab();
        int zaa = zaa(i6);
        int i7 = 0;
        if (i6 >= 0 && i6 != this.zab.size()) {
            if (i6 == this.zab.size() - 1) {
                intValue = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getCount();
                intValue2 = ((Integer) this.zab.get(i6)).intValue();
            } else {
                intValue = ((Integer) this.zab.get(i6 + 1)).intValue();
                intValue2 = ((Integer) this.zab.get(i6)).intValue();
            }
            int i8 = intValue - intValue2;
            if (i8 == 1) {
                int zaa2 = zaa(i6);
                int windowIndex = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getWindowIndex(zaa2);
                String childDataMarkerColumn = getChildDataMarkerColumn();
                if (childDataMarkerColumn == null || this.mDataHolder.getString(childDataMarkerColumn, zaa2, windowIndex) != null) {
                    i7 = 1;
                }
            } else {
                i7 = i8;
            }
        }
        return getEntry(zaa, i7);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @KeepForSdk
    public int getCount() {
        zab();
        return this.zab.size();
    }
}
