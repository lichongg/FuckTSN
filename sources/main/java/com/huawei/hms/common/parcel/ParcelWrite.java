package com.huawei.hms.common.parcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.core.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ParcelWrite {

    /* renamed from: b, reason: collision with root package name */
    public static final int f33103b = 65262;

    /* renamed from: a, reason: collision with root package name */
    public Parcel f33104a;

    public void writeBigDecimalArray(int i6, BigDecimal[] bigDecimalArr, boolean z5) {
        if (bigDecimalArr == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        int length = bigDecimalArr.length;
        this.f33104a.writeInt(length);
        for (int i7 = 0; i7 < length; i7++) {
            this.f33104a.writeByteArray(bigDecimalArr[i7].unscaledValue().toByteArray());
            this.f33104a.writeInt(bigDecimalArr[i7].scale());
        }
        d(a6);
    }

    public void writeBigIntegerArray(int i6, BigInteger[] bigIntegerArr, boolean z5) {
        if (bigIntegerArr == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        this.f33104a.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            this.f33104a.writeByteArray(bigInteger.toByteArray());
        }
        d(a6);
    }

    public void writeBoolean(int i6, boolean z5) {
        b(i6, 4);
        this.f33104a.writeInt(z5 ? 1 : 0);
    }

    public void writeBooleanList(int i6, List<Boolean> list, boolean z5) {
        if (list == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        int size = list.size();
        this.f33104a.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            this.f33104a.writeInt(list.get(i7).booleanValue() ? 1 : 0);
        }
        d(a6);
    }

    public void writeBooleanObject(int i6, Boolean bool) {
        writeBooleanObject(i6, bool, false);
    }

    public void writeByte(int i6, byte b6) {
        b(i6, 4);
        this.f33104a.writeInt(b6);
    }

    public void writeByteArrayArray(int i6, byte[][] bArr, boolean z5) {
        if (bArr == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        this.f33104a.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            this.f33104a.writeByteArray(bArr2);
        }
        d(a6);
    }

    public void writeByteArraySparseArray(int i6, SparseArray<byte[]> sparseArray, boolean z5) {
        if (sparseArray == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        int size = sparseArray.size();
        this.f33104a.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            this.f33104a.writeInt(sparseArray.keyAt(i7));
            this.f33104a.writeByteArray(sparseArray.valueAt(i7));
        }
        d(a6);
    }

    public void writeChar(int i6, char c6) {
        b(i6, 4);
        this.f33104a.writeInt(c6);
    }

    public void writeDoubleList(int i6, List<Double> list, boolean z5) {
        if (list == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        int size = list.size();
        this.f33104a.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            this.f33104a.writeDouble(list.get(i7).doubleValue());
        }
        d(a6);
    }

    public void writeDoubleSparseArray(int i6, SparseArray<Double> sparseArray, boolean z5) {
        if (sparseArray == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        int size = sparseArray.size();
        this.f33104a.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            this.f33104a.writeInt(sparseArray.keyAt(i7));
            this.f33104a.writeDouble(sparseArray.valueAt(i7).doubleValue());
        }
        d(a6);
    }

    public void writeFloat(int i6, float f6) {
        b(i6, 4);
        this.f33104a.writeFloat(f6);
    }

    public void writeFloatList(int i6, List<Float> list, boolean z5) {
        if (list == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        int size = list.size();
        this.f33104a.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            this.f33104a.writeFloat(list.get(i7).floatValue());
        }
        d(a6);
    }

    public void writeFloatSparseArray(int i6, SparseArray<Float> sparseArray, boolean z5) {
        if (sparseArray == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        int size = sparseArray.size();
        this.f33104a.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            this.f33104a.writeInt(sparseArray.keyAt(i7));
            this.f33104a.writeFloat(sparseArray.valueAt(i7).floatValue());
        }
        d(a6);
    }

    public void writeIBinderSparseArray(int i6, SparseArray<IBinder> sparseArray, boolean z5) {
        if (sparseArray == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        int size = sparseArray.size();
        this.f33104a.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            this.f33104a.writeInt(sparseArray.keyAt(i7));
            this.f33104a.writeStrongBinder(sparseArray.valueAt(i7));
        }
        d(a6);
    }

    public void writeInt(int i6, int i7) {
        b(i6, 4);
        this.f33104a.writeInt(i7);
    }

    public void writeIntegerList(int i6, List<Integer> list, boolean z5) {
        if (list == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        int size = list.size();
        this.f33104a.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            this.f33104a.writeInt(list.get(i7).intValue());
        }
        d(a6);
    }

    public void writeLongList(int i6, List<Long> list, boolean z5) {
        if (list == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        int size = list.size();
        this.f33104a.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            this.f33104a.writeLong(list.get(i7).longValue());
        }
        d(a6);
    }

    public void writeParcel(int i6, Parcel parcel, boolean z5) {
        if (parcel == null) {
            if (z5) {
                b(i6, 0);
            }
        } else {
            int a6 = a(i6);
            this.f33104a.appendFrom(parcel, 0, parcel.dataSize());
            d(a6);
        }
    }

    public void writeParcelArray(int i6, Parcel[] parcelArr, boolean z5) {
        if (parcelArr == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        this.f33104a.writeInt(parcelArr.length);
        for (Parcel parcel : parcelArr) {
            if (parcel != null) {
                this.f33104a.writeInt(parcel.dataSize());
                this.f33104a.appendFrom(parcel, 0, parcel.dataSize());
            } else {
                this.f33104a.writeInt(0);
            }
        }
        d(a6);
    }

    public void writeParcelList(int i6, List<Parcel> list, boolean z5) {
        if (list == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        int size = list.size();
        this.f33104a.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            Parcel parcel = list.get(i7);
            if (parcel != null) {
                this.f33104a.writeInt(parcel.dataSize());
                this.f33104a.appendFrom(parcel, 0, parcel.dataSize());
            } else {
                this.f33104a.writeInt(0);
            }
        }
        d(a6);
    }

    public void writeParcelSparseArray(int i6, SparseArray<Parcel> sparseArray, boolean z5) {
        if (sparseArray == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        int size = sparseArray.size();
        this.f33104a.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            this.f33104a.writeInt(sparseArray.keyAt(i7));
            Parcel valueAt = sparseArray.valueAt(i7);
            if (valueAt != null) {
                this.f33104a.writeInt(valueAt.dataSize());
                this.f33104a.appendFrom(valueAt, 0, valueAt.dataSize());
            } else {
                this.f33104a.writeInt(0);
            }
        }
        d(a6);
    }

    public void writeShort(int i6, short s5) {
        b(i6, 4);
        this.f33104a.writeInt(s5);
    }

    public void writeSparseIntArray(int i6, SparseIntArray sparseIntArray, boolean z5) {
        if (sparseIntArray == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        int size = sparseIntArray.size();
        this.f33104a.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            this.f33104a.writeInt(sparseIntArray.keyAt(i7));
            this.f33104a.writeInt(sparseIntArray.valueAt(i7));
        }
        d(a6);
    }

    public void writeSparseLongArray(int i6, SparseLongArray sparseLongArray, boolean z5) {
        if (sparseLongArray == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        int size = sparseLongArray.size();
        this.f33104a.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            this.f33104a.writeInt(sparseLongArray.keyAt(i7));
            this.f33104a.writeLong(sparseLongArray.valueAt(i7));
        }
        d(a6);
    }

    public void writeStringSparseArray(int i6, SparseArray<String> sparseArray, boolean z5) {
        if (sparseArray == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        int size = sparseArray.size();
        this.f33104a.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            this.f33104a.writeInt(sparseArray.keyAt(i7));
            this.f33104a.writeString(sparseArray.valueAt(i7));
        }
        d(a6);
    }

    public <T extends Parcelable> void writeTypedArray(int i6, T[] tArr, int i7, boolean z5) {
        if (tArr == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        this.f33104a.writeInt(tArr.length);
        for (T t5 : tArr) {
            if (t5 == null) {
                this.f33104a.writeInt(0);
            } else {
                c(t5, i7);
            }
        }
        d(a6);
    }

    public <T extends Parcelable> void writeTypedList(int i6, List<T> list, boolean z5) {
        if (list == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        int size = list.size();
        this.f33104a.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            T t5 = list.get(i7);
            if (t5 == null) {
                this.f33104a.writeInt(0);
            } else {
                c(t5, 0);
            }
        }
        d(a6);
    }

    public <T extends Parcelable> void writeTypedSparseArray(int i6, SparseArray<T> sparseArray, boolean z5) {
        if (sparseArray == null) {
            if (z5) {
                b(i6, 0);
                return;
            }
            return;
        }
        int a6 = a(i6);
        int size = sparseArray.size();
        this.f33104a.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            this.f33104a.writeInt(sparseArray.keyAt(i7));
            T valueAt = sparseArray.valueAt(i7);
            if (valueAt == null) {
                this.f33104a.writeInt(0);
            } else {
                c(valueAt, 0);
            }
        }
        d(a6);
    }

    private int a(int i6) {
        this.f33104a.writeInt(i6 | SupportMenu.CATEGORY_MASK);
        this.f33104a.writeInt(0);
        return this.f33104a.dataPosition();
    }

    private <T extends Parcelable> void c(T t5, int i6) {
        int dataPosition = this.f33104a.dataPosition();
        this.f33104a.writeInt(1);
        int dataPosition2 = this.f33104a.dataPosition();
        t5.writeToParcel(this.f33104a, i6);
        int dataPosition3 = this.f33104a.dataPosition();
        this.f33104a.setDataPosition(dataPosition);
        this.f33104a.writeInt(dataPosition3 - dataPosition2);
        this.f33104a.setDataPosition(dataPosition3);
    }

    private void d(int i6) {
        int dataPosition = this.f33104a.dataPosition();
        this.f33104a.setDataPosition(i6 - 4);
        this.f33104a.writeInt(dataPosition - i6);
        this.f33104a.setDataPosition(dataPosition);
    }

    public void writeBigDecimal(int i6, BigDecimal bigDecimal, boolean z5) {
        if (bigDecimal == null) {
            if (z5) {
                b(i6, 0);
            }
        } else {
            int a6 = a(i6);
            this.f33104a.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            this.f33104a.writeInt(bigDecimal.scale());
            d(a6);
        }
    }

    public void writeBigInteger(int i6, BigInteger bigInteger, boolean z5) {
        if (bigInteger == null) {
            if (z5) {
                b(i6, 0);
            }
        } else {
            int a6 = a(i6);
            this.f33104a.writeByteArray(bigInteger.toByteArray());
            d(a6);
        }
    }

    public void writeBooleanArray(int i6, boolean[] zArr, boolean z5) {
        if (zArr == null) {
            if (z5) {
                b(i6, 0);
            }
        } else {
            int a6 = a(i6);
            this.f33104a.writeBooleanArray(zArr);
            d(a6);
        }
    }

    public void writeBooleanObject(int i6, Boolean bool, boolean z5) {
        if (bool != null) {
            b(i6, 4);
            this.f33104a.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z5) {
            b(i6, 0);
        }
    }

    public void writeBundle(int i6, Bundle bundle, boolean z5) {
        if (bundle == null) {
            if (z5) {
                b(i6, 0);
            }
        } else {
            int a6 = a(i6);
            this.f33104a.writeBundle(bundle);
            d(a6);
        }
    }

    public void writeByteArray(int i6, byte[] bArr, boolean z5) {
        if (bArr == null) {
            if (z5) {
                b(i6, 0);
            }
        } else {
            int a6 = a(i6);
            this.f33104a.writeByteArray(bArr);
            d(a6);
        }
    }

    public void writeCharArray(int i6, char[] cArr, boolean z5) {
        if (cArr == null) {
            if (z5) {
                b(i6, 0);
            }
        } else {
            int a6 = a(i6);
            this.f33104a.writeCharArray(cArr);
            d(a6);
        }
    }

    public void writeDouble(int i6, double d6) {
        b(i6, 8);
        this.f33104a.writeDouble(d6);
    }

    public void writeDoubleArray(int i6, double[] dArr, boolean z5) {
        if (dArr == null) {
            if (z5) {
                b(i6, 0);
            }
        } else {
            int a6 = a(i6);
            this.f33104a.writeDoubleArray(dArr);
            d(a6);
        }
    }

    public void writeDoubleObject(int i6, Double d6, boolean z5) {
        if (d6 != null) {
            b(i6, 8);
            this.f33104a.writeDouble(d6.doubleValue());
        } else if (z5) {
            b(i6, 0);
        }
    }

    public void writeFloatArray(int i6, float[] fArr, boolean z5) {
        if (fArr == null) {
            if (z5) {
                b(i6, 0);
            }
        } else {
            int a6 = a(i6);
            this.f33104a.writeFloatArray(fArr);
            d(a6);
        }
    }

    public void writeFloatObject(int i6, Float f6, boolean z5) {
        if (f6 != null) {
            b(i6, 4);
            this.f33104a.writeFloat(f6.floatValue());
        } else if (z5) {
            b(i6, 0);
        }
    }

    public void writeIBinder(int i6, IBinder iBinder, boolean z5) {
        if (iBinder == null) {
            if (z5) {
                b(i6, 0);
            }
        } else {
            int a6 = a(i6);
            this.f33104a.writeStrongBinder(iBinder);
            d(a6);
        }
    }

    public void writeIBinderArray(int i6, IBinder[] iBinderArr, boolean z5) {
        if (iBinderArr == null) {
            if (z5) {
                b(i6, 0);
            }
        } else {
            int a6 = a(i6);
            this.f33104a.writeBinderArray(iBinderArr);
            d(a6);
        }
    }

    public void writeIBinderList(int i6, List<IBinder> list, boolean z5) {
        if (list == null) {
            if (z5) {
                b(i6, 0);
            }
        } else {
            int a6 = a(i6);
            this.f33104a.writeBinderList(list);
            d(a6);
        }
    }

    public void writeIntArray(int i6, int[] iArr, boolean z5) {
        if (iArr == null) {
            if (z5) {
                b(i6, 0);
            }
        } else {
            int a6 = a(i6);
            this.f33104a.writeIntArray(iArr);
            d(a6);
        }
    }

    public void writeIntegerObject(int i6, Integer num, boolean z5) {
        if (num != null) {
            b(i6, 4);
            this.f33104a.writeInt(num.intValue());
        } else if (z5) {
            b(i6, 0);
        }
    }

    public void writeList(int i6, List list, boolean z5) {
        if (list == null) {
            if (z5) {
                b(i6, 0);
            }
        } else {
            int a6 = a(i6);
            this.f33104a.writeList(list);
            d(a6);
        }
    }

    public void writeLong(int i6, long j6) {
        b(i6, 8);
        this.f33104a.writeLong(j6);
    }

    public void writeLongArray(int i6, long[] jArr, boolean z5) {
        if (jArr == null) {
            if (z5) {
                b(i6, 0);
            }
        } else {
            int a6 = a(i6);
            this.f33104a.writeLongArray(jArr);
            d(a6);
        }
    }

    public void writeLongObject(int i6, Long l6, boolean z5) {
        if (l6 != null) {
            b(i6, 8);
            this.f33104a.writeLong(l6.longValue());
        } else if (z5) {
            b(i6, 0);
        }
    }

    public void writeParcelable(int i6, Parcelable parcelable, int i7, boolean z5) {
        if (parcelable == null) {
            if (z5) {
                b(i6, 0);
            }
        } else {
            int a6 = a(i6);
            parcelable.writeToParcel(this.f33104a, i7);
            d(a6);
        }
    }

    public void writeSparseBooleanArray(int i6, SparseBooleanArray sparseBooleanArray, boolean z5) {
        if (sparseBooleanArray == null) {
            if (z5) {
                b(i6, 0);
            }
        } else {
            int a6 = a(i6);
            this.f33104a.writeSparseBooleanArray(sparseBooleanArray);
            d(a6);
        }
    }

    public void writeString(int i6, String str, boolean z5) {
        if (str == null) {
            if (z5) {
                b(i6, 0);
            }
        } else {
            int a6 = a(i6);
            this.f33104a.writeString(str);
            d(a6);
        }
    }

    public void writeStringArray(int i6, String[] strArr, boolean z5) {
        if (strArr == null) {
            if (z5) {
                b(i6, 0);
            }
        } else {
            int a6 = a(i6);
            this.f33104a.writeStringArray(strArr);
            d(a6);
        }
    }

    public void writeStringList(int i6, List<String> list, boolean z5) {
        if (list == null) {
            if (z5) {
                b(i6, 0);
            }
        } else {
            int a6 = a(i6);
            this.f33104a.writeStringList(list);
            d(a6);
        }
    }

    public ParcelWrite(Parcel parcel) {
        this.f33104a = parcel;
    }

    private void b(int i6, int i7) {
        if (i7 >= 65535) {
            this.f33104a.writeInt(i6 | SupportMenu.CATEGORY_MASK);
            this.f33104a.writeInt(i7);
        } else {
            this.f33104a.writeInt(i6 | (i7 << 16));
        }
    }

    public int beginObjectHeader() {
        return a(65262);
    }

    public void finishObjectHeader(int i6) {
        d(i6);
    }
}
