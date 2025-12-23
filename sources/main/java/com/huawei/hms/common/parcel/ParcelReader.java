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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ParcelReader {

    /* renamed from: c, reason: collision with root package name */
    public static final int f33097c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final int f33098d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f33099e = 65262;

    /* renamed from: a, reason: collision with root package name */
    public HashMap<Integer, Integer[]> f33100a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public Parcel f33101b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            super(str);
        }
    }

    private int a(int i6) {
        if (i6 < 0) {
            return 0;
        }
        if (i6 > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return i6;
    }

    private void b() {
        int readInt = this.f33101b.readInt();
        int i6 = readInt & 65535;
        int readInt2 = (readInt & SupportMenu.CATEGORY_MASK) != -65536 ? (readInt >> 16) & 65535 : this.f33101b.readInt();
        if (i6 != 65262) {
            throw new ParseException("Parse header error, not 65262. Got 0x" + Integer.toHexString(i6), this.f33101b);
        }
        int dataPosition = this.f33101b.dataPosition();
        int i7 = readInt2 + dataPosition;
        if (i7 < dataPosition || i7 > this.f33101b.dataSize()) {
            throw new ParseException("invalid size, start=" + dataPosition + " end=" + i7, this.f33101b);
        }
        while (this.f33101b.dataPosition() < i7) {
            int readInt3 = this.f33101b.readInt();
            int i8 = readInt3 & 65535;
            int readInt4 = (readInt3 & SupportMenu.CATEGORY_MASK) != -65536 ? (readInt3 >> 16) & 65535 : this.f33101b.readInt();
            int dataPosition2 = this.f33101b.dataPosition();
            this.f33100a.put(Integer.valueOf(i8), new Integer[]{Integer.valueOf(dataPosition2), Integer.valueOf(readInt4)});
            this.f33101b.setDataPosition(dataPosition2 + readInt4);
        }
        if (this.f33101b.dataPosition() == i7) {
            return;
        }
        throw new ParseException("the dataPosition is not" + i7, this.f33101b);
    }

    private void c(int i6, int i7) {
        Integer[] numArr = this.f33100a.get(Integer.valueOf(i6));
        if (numArr == null) {
            throw new ParseException("Field is null:" + numArr, this.f33101b);
        }
        int intValue = numArr[1].intValue();
        if (intValue == i7) {
            return;
        }
        throw new ParseException("the field size is not " + i7 + " got " + intValue + " (0x" + Integer.toHexString(intValue) + ")", this.f33101b);
    }

    private int d(int i6) {
        Integer[] numArr = this.f33100a.get(Integer.valueOf(i6));
        if (numArr != null) {
            this.f33101b.setDataPosition(numArr[0].intValue());
            return numArr[1].intValue();
        }
        throw new ParseException("Field is null:" + numArr, this.f33101b);
    }

    private int e(int i6, int i7) {
        Integer[] numArr = this.f33100a.get(Integer.valueOf(i6));
        if (numArr != null) {
            this.f33101b.setDataPosition(numArr[0].intValue());
            c(i6, i7);
            return i7;
        }
        throw new ParseException("Field is null:" + numArr, this.f33101b);
    }

    public BigDecimal createBigDecimal(int i6, BigDecimal bigDecimal) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return bigDecimal;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        byte[] createByteArray = this.f33101b.createByteArray();
        int readInt = this.f33101b.readInt();
        this.f33101b.setDataPosition(dataPosition + d6);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public BigDecimal[] createBigDecimalArray(int i6, BigDecimal[] bigDecimalArr) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return bigDecimalArr;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        int a6 = a(this.f33101b.readInt());
        BigDecimal[] bigDecimalArr2 = new BigDecimal[a6];
        for (int i7 = 0; i7 < a6; i7++) {
            byte[] createByteArray = this.f33101b.createByteArray();
            bigDecimalArr2[i7] = new BigDecimal(new BigInteger(createByteArray), this.f33101b.readInt());
        }
        this.f33101b.setDataPosition(dataPosition + d6);
        return bigDecimalArr2;
    }

    public BigInteger createBigInteger(int i6, BigInteger bigInteger) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return bigInteger;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        byte[] createByteArray = this.f33101b.createByteArray();
        this.f33101b.setDataPosition(dataPosition + d6);
        return new BigInteger(createByteArray);
    }

    public BigInteger[] createBigIntegerArray(int i6, BigInteger[] bigIntegerArr) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return bigIntegerArr;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        int a6 = a(this.f33101b.readInt());
        BigInteger[] bigIntegerArr2 = new BigInteger[a6];
        for (int i7 = 0; i7 < a6; i7++) {
            bigIntegerArr2[i7] = new BigInteger(this.f33101b.createByteArray());
        }
        this.f33101b.setDataPosition(dataPosition + d6);
        return bigIntegerArr2;
    }

    public boolean[] createBooleanArray(int i6, boolean[] zArr) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return zArr;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        boolean[] createBooleanArray = this.f33101b.createBooleanArray();
        this.f33101b.setDataPosition(dataPosition + d6);
        return createBooleanArray;
    }

    public ArrayList<Boolean> createBooleanList(int i6, ArrayList<Boolean> arrayList) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return arrayList;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        ArrayList<Boolean> arrayList2 = new ArrayList<>();
        int a6 = a(this.f33101b.readInt());
        for (int i7 = 0; i7 < a6; i7++) {
            arrayList2.add(Boolean.valueOf(this.f33101b.readInt() != 0));
        }
        this.f33101b.setDataPosition(dataPosition + d6);
        return arrayList2;
    }

    public byte[] createByteArray(int i6, byte[] bArr) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return bArr;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        byte[] createByteArray = this.f33101b.createByteArray();
        this.f33101b.setDataPosition(dataPosition + d6);
        return createByteArray;
    }

    public byte[][] createByteArrayArray(int i6, byte[][] bArr) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return bArr;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        int a6 = a(this.f33101b.readInt());
        byte[][] bArr2 = new byte[a6][];
        for (int i7 = 0; i7 < a6; i7++) {
            bArr2[i7] = this.f33101b.createByteArray();
        }
        this.f33101b.setDataPosition(dataPosition + d6);
        return bArr2;
    }

    public SparseArray<byte[]> createByteArraySparseArray(int i6, SparseArray<byte[]> sparseArray) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return sparseArray;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        int a6 = a(this.f33101b.readInt());
        SparseArray<byte[]> sparseArray2 = new SparseArray<>(a6);
        for (int i7 = 0; i7 < a6; i7++) {
            sparseArray2.append(this.f33101b.readInt(), this.f33101b.createByteArray());
        }
        this.f33101b.setDataPosition(dataPosition + d6);
        return sparseArray2;
    }

    public char[] createCharArray(int i6, char[] cArr) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return cArr;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        char[] createCharArray = this.f33101b.createCharArray();
        this.f33101b.setDataPosition(dataPosition + d6);
        return createCharArray;
    }

    public double[] createDoubleArray(int i6, double[] dArr) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return dArr;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        double[] createDoubleArray = this.f33101b.createDoubleArray();
        this.f33101b.setDataPosition(dataPosition + d6);
        return createDoubleArray;
    }

    public ArrayList<Double> createDoubleList(int i6, ArrayList<Double> arrayList) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return arrayList;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        ArrayList<Double> arrayList2 = new ArrayList<>();
        int a6 = a(this.f33101b.readInt());
        for (int i7 = 0; i7 < a6; i7++) {
            arrayList2.add(Double.valueOf(this.f33101b.readDouble()));
        }
        this.f33101b.setDataPosition(dataPosition + d6);
        return arrayList2;
    }

    public SparseArray<Double> createDoubleSparseArray(int i6, SparseArray<Double> sparseArray) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return sparseArray;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        SparseArray<Double> sparseArray2 = new SparseArray<>();
        int a6 = a(this.f33101b.readInt());
        for (int i7 = 0; i7 < a6; i7++) {
            sparseArray2.append(this.f33101b.readInt(), Double.valueOf(this.f33101b.readDouble()));
        }
        this.f33101b.setDataPosition(dataPosition + d6);
        return sparseArray2;
    }

    public float[] createFloatArray(int i6, float[] fArr) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return fArr;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        float[] createFloatArray = this.f33101b.createFloatArray();
        this.f33101b.setDataPosition(dataPosition + d6);
        return createFloatArray;
    }

    public ArrayList<Float> createFloatList(int i6, ArrayList<Float> arrayList) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return arrayList;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        ArrayList<Float> arrayList2 = new ArrayList<>();
        int a6 = a(this.f33101b.readInt());
        for (int i7 = 0; i7 < a6; i7++) {
            arrayList2.add(Float.valueOf(this.f33101b.readFloat()));
        }
        this.f33101b.setDataPosition(dataPosition + d6);
        return arrayList2;
    }

    public SparseArray<Float> createFloatSparseArray(int i6, SparseArray<Float> sparseArray) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return sparseArray;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        SparseArray<Float> sparseArray2 = new SparseArray<>();
        int a6 = a(this.f33101b.readInt());
        for (int i7 = 0; i7 < a6; i7++) {
            sparseArray2.append(this.f33101b.readInt(), Float.valueOf(this.f33101b.readFloat()));
        }
        this.f33101b.setDataPosition(dataPosition + d6);
        return sparseArray2;
    }

    public IBinder[] createIBinderArray(int i6, IBinder[] iBinderArr) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return iBinderArr;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        IBinder[] createBinderArray = this.f33101b.createBinderArray();
        this.f33101b.setDataPosition(dataPosition + d6);
        return createBinderArray;
    }

    public ArrayList<IBinder> createIBinderList(int i6, ArrayList<IBinder> arrayList) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return arrayList;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        ArrayList<IBinder> createBinderArrayList = this.f33101b.createBinderArrayList();
        this.f33101b.setDataPosition(dataPosition + d6);
        return createBinderArrayList;
    }

    public SparseArray<IBinder> createIBinderSparseArray(int i6, SparseArray<IBinder> sparseArray) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return sparseArray;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        int a6 = a(this.f33101b.readInt());
        SparseArray<IBinder> sparseArray2 = new SparseArray<>(a6);
        for (int i7 = 0; i7 < a6; i7++) {
            sparseArray2.append(this.f33101b.readInt(), this.f33101b.readStrongBinder());
        }
        this.f33101b.setDataPosition(dataPosition + d6);
        return sparseArray2;
    }

    public int[] createIntArray(int i6, int[] iArr) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return iArr;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        int[] createIntArray = this.f33101b.createIntArray();
        this.f33101b.setDataPosition(dataPosition + d6);
        return createIntArray;
    }

    public ArrayList<Integer> createIntegerList(int i6, ArrayList<Integer> arrayList) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return arrayList;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int a6 = a(this.f33101b.readInt());
        for (int i7 = 0; i7 < a6; i7++) {
            arrayList2.add(Integer.valueOf(this.f33101b.readInt()));
        }
        this.f33101b.setDataPosition(dataPosition + d6);
        return arrayList2;
    }

    public long[] createLongArray(int i6, long[] jArr) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return jArr;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        long[] createLongArray = this.f33101b.createLongArray();
        this.f33101b.setDataPosition(dataPosition + d6);
        return createLongArray;
    }

    public ArrayList<Long> createLongList(int i6, ArrayList<Long> arrayList) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return arrayList;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        ArrayList<Long> arrayList2 = new ArrayList<>();
        int a6 = a(this.f33101b.readInt());
        for (int i7 = 0; i7 < a6; i7++) {
            arrayList2.add(Long.valueOf(this.f33101b.readLong()));
        }
        this.f33101b.setDataPosition(dataPosition + d6);
        return arrayList2;
    }

    public Parcel createParcel(int i6, Parcel parcel) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return parcel;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(this.f33101b, dataPosition, d6);
        this.f33101b.setDataPosition(dataPosition + d6);
        return obtain;
    }

    public Parcel[] createParcelArray(int i6, Parcel[] parcelArr) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return parcelArr;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        int a6 = a(this.f33101b.readInt());
        Parcel[] parcelArr2 = new Parcel[a6];
        for (int i7 = 0; i7 < a6; i7++) {
            int readInt = this.f33101b.readInt();
            if (readInt != 0) {
                int dataPosition2 = this.f33101b.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(this.f33101b, dataPosition2, readInt);
                parcelArr2[i7] = obtain;
                this.f33101b.setDataPosition(dataPosition2 + readInt);
            } else {
                parcelArr2[i7] = null;
            }
        }
        this.f33101b.setDataPosition(dataPosition + d6);
        return parcelArr2;
    }

    public ArrayList<Parcel> createParcelList(int i6, ArrayList<Parcel> arrayList) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return arrayList;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        int a6 = a(this.f33101b.readInt());
        ArrayList<Parcel> arrayList2 = new ArrayList<>();
        for (int i7 = 0; i7 < a6; i7++) {
            int readInt = this.f33101b.readInt();
            if (readInt != 0) {
                int dataPosition2 = this.f33101b.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(this.f33101b, dataPosition2, readInt);
                arrayList2.add(obtain);
                this.f33101b.setDataPosition(dataPosition2 + readInt);
            } else {
                arrayList2.add(null);
            }
        }
        this.f33101b.setDataPosition(dataPosition + d6);
        return arrayList2;
    }

    public SparseArray<Parcel> createParcelSparseArray(int i6, SparseArray<Parcel> sparseArray) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return sparseArray;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        int a6 = a(this.f33101b.readInt());
        SparseArray<Parcel> sparseArray2 = new SparseArray<>();
        for (int i7 = 0; i7 < a6; i7++) {
            int readInt = this.f33101b.readInt();
            int readInt2 = this.f33101b.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = this.f33101b.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(this.f33101b, dataPosition2, readInt2);
                sparseArray2.append(readInt, obtain);
                this.f33101b.setDataPosition(dataPosition2 + readInt2);
            } else {
                sparseArray2.append(readInt, null);
            }
        }
        this.f33101b.setDataPosition(dataPosition + d6);
        return sparseArray2;
    }

    public SparseBooleanArray createSparseBooleanArray(int i6, SparseBooleanArray sparseBooleanArray) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return sparseBooleanArray;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        SparseBooleanArray readSparseBooleanArray = this.f33101b.readSparseBooleanArray();
        this.f33101b.setDataPosition(dataPosition + d6);
        return readSparseBooleanArray;
    }

    public SparseIntArray createSparseIntArray(int i6, SparseIntArray sparseIntArray) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return sparseIntArray;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        int a6 = a(this.f33101b.readInt());
        for (int i7 = 0; i7 < a6; i7++) {
            sparseIntArray2.append(this.f33101b.readInt(), this.f33101b.readInt());
        }
        this.f33101b.setDataPosition(dataPosition + d6);
        return sparseIntArray2;
    }

    public SparseLongArray createSparseLongArray(int i6, SparseLongArray sparseLongArray) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return sparseLongArray;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        SparseLongArray sparseLongArray2 = new SparseLongArray();
        int a6 = a(this.f33101b.readInt());
        for (int i7 = 0; i7 < a6; i7++) {
            sparseLongArray2.append(this.f33101b.readInt(), this.f33101b.readLong());
        }
        this.f33101b.setDataPosition(dataPosition + d6);
        return sparseLongArray2;
    }

    public String createString(int i6, String str) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return str;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        String readString = this.f33101b.readString();
        this.f33101b.setDataPosition(dataPosition + d6);
        return readString;
    }

    public String[] createStringArray(int i6, String[] strArr) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return strArr;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        String[] createStringArray = this.f33101b.createStringArray();
        this.f33101b.setDataPosition(dataPosition + d6);
        return createStringArray;
    }

    public ArrayList<String> createStringList(int i6, ArrayList<String> arrayList) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return arrayList;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        ArrayList<String> createStringArrayList = this.f33101b.createStringArrayList();
        this.f33101b.setDataPosition(dataPosition + d6);
        return createStringArrayList;
    }

    public SparseArray<String> createStringSparseArray(int i6, SparseArray<String> sparseArray) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return sparseArray;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        int a6 = a(this.f33101b.readInt());
        for (int i7 = 0; i7 < a6; i7++) {
            sparseArray2.append(this.f33101b.readInt(), this.f33101b.readString());
        }
        this.f33101b.setDataPosition(dataPosition + d6);
        return sparseArray2;
    }

    public <T> T[] createTypedArray(int i6, Parcelable.Creator<T> creator, T[] tArr) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return tArr;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        T[] tArr2 = (T[]) this.f33101b.createTypedArray(creator);
        this.f33101b.setDataPosition(dataPosition + d6);
        return tArr2;
    }

    public <T> ArrayList<T> createTypedList(int i6, Parcelable.Creator<T> creator, ArrayList<T> arrayList) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return arrayList;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        ArrayList<T> createTypedArrayList = this.f33101b.createTypedArrayList(creator);
        this.f33101b.setDataPosition(dataPosition + d6);
        return createTypedArrayList;
    }

    public <T> SparseArray<T> createTypedSparseArray(int i6, Parcelable.Creator<T> creator, SparseArray<T> sparseArray) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return sparseArray;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        int a6 = a(this.f33101b.readInt());
        SparseArray<T> sparseArray2 = new SparseArray<>();
        for (int i7 = 0; i7 < a6; i7++) {
            sparseArray2.append(this.f33101b.readInt(), this.f33101b.readInt() != 0 ? creator.createFromParcel(this.f33101b) : null);
        }
        this.f33101b.setDataPosition(dataPosition + d6);
        return sparseArray2;
    }

    public boolean readBoolean(int i6, boolean z5) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return z5;
        }
        e(i6, 4);
        return this.f33101b.readInt() != 0;
    }

    public Boolean readBooleanObject(int i6, Boolean bool) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return bool;
        }
        if (d(i6) == 0) {
            return null;
        }
        c(i6, 4);
        int readInt = this.f33101b.readInt();
        if (readInt == 0) {
            return Boolean.FALSE;
        }
        if (readInt != 1) {
            return null;
        }
        return Boolean.TRUE;
    }

    public Bundle readBundle(int i6, Bundle bundle) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return bundle;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        Bundle readBundle = this.f33101b.readBundle();
        this.f33101b.setDataPosition(dataPosition + d6);
        return readBundle;
    }

    public byte readByte(int i6, byte b6) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return b6;
        }
        e(i6, 4);
        return (byte) this.f33101b.readInt();
    }

    public char readChar(int i6, char c6) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return c6;
        }
        e(i6, 4);
        return (char) this.f33101b.readInt();
    }

    public double readDouble(int i6, double d6) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return d6;
        }
        e(i6, 8);
        return this.f33101b.readDouble();
    }

    public Double readDoubleObject(int i6, Double d6) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return d6;
        }
        int d7 = d(i6);
        if (d7 == 0) {
            return null;
        }
        c(d7, 8);
        return Double.valueOf(this.f33101b.readDouble());
    }

    public float readFloat(int i6, float f6) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return f6;
        }
        e(i6, 4);
        return this.f33101b.readFloat();
    }

    public Float readFloatObject(int i6, Float f6) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return f6;
        }
        if (d(i6) == 0) {
            return null;
        }
        c(i6, 4);
        return Float.valueOf(this.f33101b.readFloat());
    }

    public IBinder readIBinder(int i6, IBinder iBinder) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return iBinder;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        IBinder readStrongBinder = this.f33101b.readStrongBinder();
        this.f33101b.setDataPosition(dataPosition + d6);
        return readStrongBinder;
    }

    public int readInt(int i6, int i7) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return i7;
        }
        e(i6, 4);
        return this.f33101b.readInt();
    }

    public Integer readIntegerObject(int i6, Integer num) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return num;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        c(d6, 4);
        return Integer.valueOf(this.f33101b.readInt());
    }

    public void readList(int i6, List list, ClassLoader classLoader) {
        if (this.f33100a.containsKey(Integer.valueOf(i6))) {
            int d6 = d(i6);
            int dataPosition = this.f33101b.dataPosition();
            if (d6 != 0) {
                this.f33101b.readList(list, classLoader);
                this.f33101b.setDataPosition(dataPosition + d6);
            }
        }
    }

    public long readLong(int i6, long j6) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return j6;
        }
        e(i6, 8);
        return this.f33101b.readLong();
    }

    public Long readLongObject(int i6, Long l6) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return l6;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        c(d6, 8);
        return Long.valueOf(this.f33101b.readLong());
    }

    public <T extends Parcelable> T readParcelable(int i6, Parcelable.Creator<T> creator, T t5) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return t5;
        }
        int d6 = d(i6);
        if (d6 == 0) {
            return null;
        }
        int dataPosition = this.f33101b.dataPosition();
        T createFromParcel = creator.createFromParcel(this.f33101b);
        this.f33101b.setDataPosition(dataPosition + d6);
        return createFromParcel;
    }

    public short readShort(int i6, short s5) {
        if (!this.f33100a.containsKey(Integer.valueOf(i6))) {
            return s5;
        }
        e(i6, 4);
        return (short) this.f33101b.readInt();
    }

    public ParcelReader(Parcel parcel) {
        this.f33101b = parcel;
        b();
    }
}
