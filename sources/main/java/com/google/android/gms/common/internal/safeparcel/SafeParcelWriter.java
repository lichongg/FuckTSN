package com.google.android.gms.common.internal.safeparcel;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class SafeParcelWriter {
    public static void writeBigDecimalArray(@NonNull Parcel parcel, int i6, @NonNull BigDecimal[] bigDecimalArr, boolean z5) {
        if (bigDecimalArr == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i7 = 0; i7 < length; i7++) {
            parcel.writeByteArray(bigDecimalArr[i7].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i7].scale());
        }
        zzb(parcel, zza);
    }

    public static void writeBigIntegerArray(@NonNull Parcel parcel, int i6, @NonNull BigInteger[] bigIntegerArr, boolean z5) {
        if (bigIntegerArr == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        parcel.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        zzb(parcel, zza);
    }

    public static void writeBoolean(@NonNull Parcel parcel, int i6, boolean z5) {
        zzc(parcel, i6, 4);
        parcel.writeInt(z5 ? 1 : 0);
    }

    public static void writeBooleanList(@NonNull Parcel parcel, int i6, @NonNull List<Boolean> list, boolean z5) {
        if (list == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        int size = list.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            parcel.writeInt(list.get(i7).booleanValue() ? 1 : 0);
        }
        zzb(parcel, zza);
    }

    public static void writeByte(@NonNull Parcel parcel, int i6, byte b6) {
        zzc(parcel, i6, 4);
        parcel.writeInt(b6);
    }

    public static void writeByteArrayArray(@NonNull Parcel parcel, int i6, @NonNull byte[][] bArr, boolean z5) {
        if (bArr == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        zzb(parcel, zza);
    }

    public static void writeByteArraySparseArray(@NonNull Parcel parcel, int i6, @NonNull SparseArray<byte[]> sparseArray, boolean z5) {
        if (sparseArray == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            parcel.writeInt(sparseArray.keyAt(i7));
            parcel.writeByteArray(sparseArray.valueAt(i7));
        }
        zzb(parcel, zza);
    }

    public static void writeChar(@NonNull Parcel parcel, int i6, char c6) {
        zzc(parcel, i6, 4);
        parcel.writeInt(c6);
    }

    public static void writeDoubleList(@NonNull Parcel parcel, int i6, @NonNull List<Double> list, boolean z5) {
        if (list == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        int size = list.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            parcel.writeDouble(list.get(i7).doubleValue());
        }
        zzb(parcel, zza);
    }

    public static void writeDoubleSparseArray(@NonNull Parcel parcel, int i6, @NonNull SparseArray<Double> sparseArray, boolean z5) {
        if (sparseArray == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            parcel.writeInt(sparseArray.keyAt(i7));
            parcel.writeDouble(sparseArray.valueAt(i7).doubleValue());
        }
        zzb(parcel, zza);
    }

    public static void writeFloat(@NonNull Parcel parcel, int i6, float f6) {
        zzc(parcel, i6, 4);
        parcel.writeFloat(f6);
    }

    public static void writeFloatList(@NonNull Parcel parcel, int i6, @NonNull List<Float> list, boolean z5) {
        if (list == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        int size = list.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            parcel.writeFloat(list.get(i7).floatValue());
        }
        zzb(parcel, zza);
    }

    public static void writeFloatSparseArray(@NonNull Parcel parcel, int i6, @NonNull SparseArray<Float> sparseArray, boolean z5) {
        if (sparseArray == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            parcel.writeInt(sparseArray.keyAt(i7));
            parcel.writeFloat(sparseArray.valueAt(i7).floatValue());
        }
        zzb(parcel, zza);
    }

    public static void writeIBinderSparseArray(@NonNull Parcel parcel, int i6, @NonNull SparseArray<IBinder> sparseArray, boolean z5) {
        if (sparseArray == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            parcel.writeInt(sparseArray.keyAt(i7));
            parcel.writeStrongBinder(sparseArray.valueAt(i7));
        }
        zzb(parcel, zza);
    }

    public static void writeInt(@NonNull Parcel parcel, int i6, int i7) {
        zzc(parcel, i6, 4);
        parcel.writeInt(i7);
    }

    public static void writeIntegerList(@NonNull Parcel parcel, int i6, @NonNull List<Integer> list, boolean z5) {
        if (list == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        int size = list.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            parcel.writeInt(list.get(i7).intValue());
        }
        zzb(parcel, zza);
    }

    public static void writeLongList(@NonNull Parcel parcel, int i6, @NonNull List<Long> list, boolean z5) {
        if (list == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        int size = list.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            parcel.writeLong(list.get(i7).longValue());
        }
        zzb(parcel, zza);
    }

    public static void writeParcel(@NonNull Parcel parcel, int i6, @NonNull Parcel parcel2, boolean z5) {
        if (parcel2 == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            zzb(parcel, zza);
        }
    }

    public static void writeParcelArray(@NonNull Parcel parcel, int i6, @NonNull Parcel[] parcelArr, boolean z5) {
        if (parcelArr == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        parcel.writeInt(parcelArr.length);
        for (Parcel parcel2 : parcelArr) {
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzb(parcel, zza);
    }

    public static void writeParcelList(@NonNull Parcel parcel, int i6, @NonNull List<Parcel> list, boolean z5) {
        if (list == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        int size = list.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            Parcel parcel2 = list.get(i7);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzb(parcel, zza);
    }

    public static void writeParcelSparseArray(@NonNull Parcel parcel, int i6, @NonNull SparseArray<Parcel> sparseArray, boolean z5) {
        if (sparseArray == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            parcel.writeInt(sparseArray.keyAt(i7));
            Parcel valueAt = sparseArray.valueAt(i7);
            if (valueAt != null) {
                parcel.writeInt(valueAt.dataSize());
                parcel.appendFrom(valueAt, 0, valueAt.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzb(parcel, zza);
    }

    public static void writeShort(@NonNull Parcel parcel, int i6, short s5) {
        zzc(parcel, i6, 4);
        parcel.writeInt(s5);
    }

    public static void writeSparseIntArray(@NonNull Parcel parcel, int i6, @NonNull SparseIntArray sparseIntArray, boolean z5) {
        if (sparseIntArray == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        int size = sparseIntArray.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            parcel.writeInt(sparseIntArray.keyAt(i7));
            parcel.writeInt(sparseIntArray.valueAt(i7));
        }
        zzb(parcel, zza);
    }

    public static void writeSparseLongArray(@NonNull Parcel parcel, int i6, @NonNull SparseLongArray sparseLongArray, boolean z5) {
        if (sparseLongArray == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        int size = sparseLongArray.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            parcel.writeInt(sparseLongArray.keyAt(i7));
            parcel.writeLong(sparseLongArray.valueAt(i7));
        }
        zzb(parcel, zza);
    }

    public static void writeStringSparseArray(@NonNull Parcel parcel, int i6, @NonNull SparseArray<String> sparseArray, boolean z5) {
        if (sparseArray == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            parcel.writeInt(sparseArray.keyAt(i7));
            parcel.writeString(sparseArray.valueAt(i7));
        }
        zzb(parcel, zza);
    }

    public static <T extends Parcelable> void writeTypedArray(@NonNull Parcel parcel, int i6, @NonNull T[] tArr, int i7, boolean z5) {
        if (tArr == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        parcel.writeInt(tArr.length);
        for (T t5 : tArr) {
            if (t5 == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, t5, i7);
            }
        }
        zzb(parcel, zza);
    }

    public static <T extends Parcelable> void writeTypedList(@NonNull Parcel parcel, int i6, @NonNull List<T> list, boolean z5) {
        if (list == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        int size = list.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            T t5 = list.get(i7);
            if (t5 == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, t5, 0);
            }
        }
        zzb(parcel, zza);
    }

    public static <T extends Parcelable> void writeTypedSparseArray(@NonNull Parcel parcel, int i6, @NonNull SparseArray<T> sparseArray, boolean z5) {
        if (sparseArray == null) {
            if (z5) {
                zzc(parcel, i6, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i6);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            parcel.writeInt(sparseArray.keyAt(i7));
            T valueAt = sparseArray.valueAt(i7);
            if (valueAt == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, valueAt, 0);
            }
        }
        zzb(parcel, zza);
    }

    public static int beginObjectHeader(@NonNull Parcel parcel) {
        return zza(parcel, 20293);
    }

    public static void writeBigDecimal(@NonNull Parcel parcel, int i6, @NonNull BigDecimal bigDecimal, boolean z5) {
        if (bigDecimal == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            zzb(parcel, zza);
        }
    }

    public static void writeBigInteger(@NonNull Parcel parcel, int i6, @NonNull BigInteger bigInteger, boolean z5) {
        if (bigInteger == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            parcel.writeByteArray(bigInteger.toByteArray());
            zzb(parcel, zza);
        }
    }

    public static void writeBooleanArray(@NonNull Parcel parcel, int i6, @NonNull boolean[] zArr, boolean z5) {
        if (zArr == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            parcel.writeBooleanArray(zArr);
            zzb(parcel, zza);
        }
    }

    public static void writeBooleanObject(@NonNull Parcel parcel, int i6, @NonNull Boolean bool, boolean z5) {
        if (bool != null) {
            zzc(parcel, i6, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z5) {
            zzc(parcel, i6, 0);
        }
    }

    public static void writeBundle(@NonNull Parcel parcel, int i6, @NonNull Bundle bundle, boolean z5) {
        if (bundle == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            parcel.writeBundle(bundle);
            zzb(parcel, zza);
        }
    }

    public static void writeByteArray(@NonNull Parcel parcel, int i6, @NonNull byte[] bArr, boolean z5) {
        if (bArr == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            parcel.writeByteArray(bArr);
            zzb(parcel, zza);
        }
    }

    public static void writeCharArray(@NonNull Parcel parcel, int i6, @NonNull char[] cArr, boolean z5) {
        if (cArr == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            parcel.writeCharArray(cArr);
            zzb(parcel, zza);
        }
    }

    public static void writeDouble(@NonNull Parcel parcel, int i6, double d6) {
        zzc(parcel, i6, 8);
        parcel.writeDouble(d6);
    }

    public static void writeDoubleArray(@NonNull Parcel parcel, int i6, @NonNull double[] dArr, boolean z5) {
        if (dArr == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            parcel.writeDoubleArray(dArr);
            zzb(parcel, zza);
        }
    }

    public static void writeDoubleObject(@NonNull Parcel parcel, int i6, @NonNull Double d6, boolean z5) {
        if (d6 != null) {
            zzc(parcel, i6, 8);
            parcel.writeDouble(d6.doubleValue());
        } else if (z5) {
            zzc(parcel, i6, 0);
        }
    }

    public static void writeFloatArray(@NonNull Parcel parcel, int i6, @NonNull float[] fArr, boolean z5) {
        if (fArr == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            parcel.writeFloatArray(fArr);
            zzb(parcel, zza);
        }
    }

    public static void writeFloatObject(@NonNull Parcel parcel, int i6, @NonNull Float f6, boolean z5) {
        if (f6 != null) {
            zzc(parcel, i6, 4);
            parcel.writeFloat(f6.floatValue());
        } else if (z5) {
            zzc(parcel, i6, 0);
        }
    }

    public static void writeIBinder(@NonNull Parcel parcel, int i6, @NonNull IBinder iBinder, boolean z5) {
        if (iBinder == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            parcel.writeStrongBinder(iBinder);
            zzb(parcel, zza);
        }
    }

    public static void writeIBinderArray(@NonNull Parcel parcel, int i6, @NonNull IBinder[] iBinderArr, boolean z5) {
        if (iBinderArr == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            parcel.writeBinderArray(iBinderArr);
            zzb(parcel, zza);
        }
    }

    public static void writeIBinderList(@NonNull Parcel parcel, int i6, @NonNull List<IBinder> list, boolean z5) {
        if (list == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            parcel.writeBinderList(list);
            zzb(parcel, zza);
        }
    }

    public static void writeIntArray(@NonNull Parcel parcel, int i6, @NonNull int[] iArr, boolean z5) {
        if (iArr == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            parcel.writeIntArray(iArr);
            zzb(parcel, zza);
        }
    }

    public static void writeIntegerObject(@NonNull Parcel parcel, int i6, @NonNull Integer num, boolean z5) {
        if (num != null) {
            zzc(parcel, i6, 4);
            parcel.writeInt(num.intValue());
        } else if (z5) {
            zzc(parcel, i6, 0);
        }
    }

    public static void writeList(@NonNull Parcel parcel, int i6, @NonNull List list, boolean z5) {
        if (list == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            parcel.writeList(list);
            zzb(parcel, zza);
        }
    }

    public static void writeLong(@NonNull Parcel parcel, int i6, long j6) {
        zzc(parcel, i6, 8);
        parcel.writeLong(j6);
    }

    public static void writeLongArray(@NonNull Parcel parcel, int i6, @NonNull long[] jArr, boolean z5) {
        if (jArr == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            parcel.writeLongArray(jArr);
            zzb(parcel, zza);
        }
    }

    public static void writeLongObject(@NonNull Parcel parcel, int i6, @NonNull Long l6, boolean z5) {
        if (l6 != null) {
            zzc(parcel, i6, 8);
            parcel.writeLong(l6.longValue());
        } else if (z5) {
            zzc(parcel, i6, 0);
        }
    }

    public static void writeParcelable(@NonNull Parcel parcel, int i6, @NonNull Parcelable parcelable, int i7, boolean z5) {
        if (parcelable == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            parcelable.writeToParcel(parcel, i7);
            zzb(parcel, zza);
        }
    }

    public static void writePendingIntent(@NonNull Parcel parcel, int i6, @NonNull PendingIntent pendingIntent, boolean z5) {
        if (pendingIntent == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            PendingIntent.writePendingIntentOrNullToParcel(pendingIntent, parcel);
            zzb(parcel, zza);
        }
    }

    public static void writeSparseBooleanArray(@NonNull Parcel parcel, int i6, @NonNull SparseBooleanArray sparseBooleanArray, boolean z5) {
        if (sparseBooleanArray == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            zzb(parcel, zza);
        }
    }

    public static void writeString(@NonNull Parcel parcel, int i6, @NonNull String str, boolean z5) {
        if (str == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            parcel.writeString(str);
            zzb(parcel, zza);
        }
    }

    public static void writeStringArray(@NonNull Parcel parcel, int i6, @NonNull String[] strArr, boolean z5) {
        if (strArr == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            parcel.writeStringArray(strArr);
            zzb(parcel, zza);
        }
    }

    public static void writeStringList(@NonNull Parcel parcel, int i6, @NonNull List<String> list, boolean z5) {
        if (list == null) {
            if (z5) {
                zzc(parcel, i6, 0);
            }
        } else {
            int zza = zza(parcel, i6);
            parcel.writeStringList(list);
            zzb(parcel, zza);
        }
    }

    private static int zza(Parcel parcel, int i6) {
        parcel.writeInt(i6 | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void zzc(Parcel parcel, int i6, int i7) {
        parcel.writeInt(i6 | (i7 << 16));
    }

    private SafeParcelWriter() {
    }

    public static void finishObjectHeader(@NonNull Parcel parcel, int i6) {
        zzb(parcel, i6);
    }

    private static void zzb(Parcel parcel, int i6) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i6 - 4);
        parcel.writeInt(dataPosition - i6);
        parcel.setDataPosition(dataPosition);
    }

    private static void zzd(Parcel parcel, Parcelable parcelable, int i6) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i6);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
