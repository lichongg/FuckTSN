package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class ParcelableSparseBooleanArray extends SparseBooleanArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseBooleanArray> CREATOR = new Parcelable.Creator<ParcelableSparseBooleanArray>() { // from class: com.google.android.material.internal.ParcelableSparseBooleanArray.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public ParcelableSparseBooleanArray createFromParcel(@NonNull Parcel parcel) {
            int readInt = parcel.readInt();
            ParcelableSparseBooleanArray parcelableSparseBooleanArray = new ParcelableSparseBooleanArray(readInt);
            int[] iArr = new int[readInt];
            boolean[] zArr = new boolean[readInt];
            parcel.readIntArray(iArr);
            parcel.readBooleanArray(zArr);
            for (int i6 = 0; i6 < readInt; i6++) {
                parcelableSparseBooleanArray.put(iArr[i6], zArr[i6]);
            }
            return parcelableSparseBooleanArray;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public ParcelableSparseBooleanArray[] newArray(int i6) {
            return new ParcelableSparseBooleanArray[i6];
        }
    };

    public ParcelableSparseBooleanArray() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ParcelableSparseBooleanArray(int i6) {
        super(i6);
    }

    public ParcelableSparseBooleanArray(@NonNull SparseBooleanArray sparseBooleanArray) {
        super(sparseBooleanArray.size());
        for (int i6 = 0; i6 < sparseBooleanArray.size(); i6++) {
            put(sparseBooleanArray.keyAt(i6), sparseBooleanArray.valueAt(i6));
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i6) {
        int[] iArr = new int[size()];
        boolean[] zArr = new boolean[size()];
        for (int i7 = 0; i7 < size(); i7++) {
            iArr[i7] = keyAt(i7);
            zArr[i7] = valueAt(i7);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeBooleanArray(zArr);
    }
}
