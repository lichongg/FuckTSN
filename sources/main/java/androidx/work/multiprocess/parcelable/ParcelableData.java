package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.work.Data;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class ParcelableData implements Parcelable {
    public static final Parcelable.Creator<ParcelableData> CREATOR = new Parcelable.Creator<ParcelableData>() { // from class: androidx.work.multiprocess.parcelable.ParcelableData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableData createFromParcel(@NonNull Parcel parcel) {
            return new ParcelableData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableData[] newArray(int i6) {
            return new ParcelableData[i6];
        }
    };
    private static final byte TYPE_BOOLEAN = 1;
    private static final byte TYPE_BOOLEAN_ARRAY = 8;
    private static final byte TYPE_BYTE = 2;
    private static final byte TYPE_BYTE_ARRAY = 9;
    private static final byte TYPE_DOUBLE = 6;
    private static final byte TYPE_DOUBLE_ARRAY = 13;
    private static final byte TYPE_FLOAT = 5;
    private static final byte TYPE_FLOAT_ARRAY = 12;
    private static final byte TYPE_INTEGER = 3;
    private static final byte TYPE_INTEGER_ARRAY = 10;
    private static final byte TYPE_LONG = 4;
    private static final byte TYPE_LONG_ARRAY = 11;
    private static final byte TYPE_NULL = 0;
    private static final byte TYPE_STRING = 7;
    private static final byte TYPE_STRING_ARRAY = 14;
    private final Data mData;

    public ParcelableData(@NonNull Data data) {
        this.mData = data;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i6) {
        Map<String, Object> keyValueMap = this.mData.getKeyValueMap();
        parcel.writeInt(keyValueMap.size());
        for (Map.Entry<String, Object> entry : keyValueMap.entrySet()) {
            writeToParcel(parcel, entry.getKey(), entry.getValue());
        }
    }

    @NonNull
    public Data getData() {
        return this.mData;
    }

    protected ParcelableData(@NonNull Parcel parcel) {
        HashMap hashMap = new HashMap();
        int readInt = parcel.readInt();
        for (int i6 = 0; i6 < readInt; i6++) {
            addEntry(parcel, hashMap);
        }
        this.mData = new Data(hashMap);
    }

    private void addEntry(@NonNull Parcel parcel, @NonNull Map<String, Object> map) {
        Object obj;
        byte readByte = parcel.readByte();
        switch (readByte) {
            case 0:
                obj = null;
                break;
            case 1:
                obj = Boolean.valueOf(ParcelUtils.readBooleanValue(parcel));
                break;
            case 2:
                obj = Byte.valueOf(parcel.readByte());
                break;
            case 3:
                obj = Integer.valueOf(parcel.readInt());
                break;
            case 4:
                obj = Long.valueOf(parcel.readLong());
                break;
            case 5:
                obj = Float.valueOf(parcel.readFloat());
                break;
            case 6:
                obj = Double.valueOf(parcel.readDouble());
                break;
            case 7:
                obj = parcel.readString();
                break;
            case 8:
                obj = Data.convertPrimitiveBooleanArray(parcel.createBooleanArray());
                break;
            case 9:
                obj = Data.convertPrimitiveByteArray(parcel.createByteArray());
                break;
            case 10:
                obj = Data.convertPrimitiveIntArray(parcel.createIntArray());
                break;
            case 11:
                obj = Data.convertPrimitiveLongArray(parcel.createLongArray());
                break;
            case 12:
                obj = Data.convertPrimitiveFloatArray(parcel.createFloatArray());
                break;
            case 13:
                obj = Data.convertPrimitiveDoubleArray(parcel.createDoubleArray());
                break;
            case 14:
                obj = parcel.createStringArray();
                break;
            default:
                throw new IllegalStateException(String.format("Unsupported type %s", Integer.valueOf(readByte)));
        }
        map.put(parcel.readString(), obj);
    }

    private void writeToParcel(@NonNull Parcel parcel, @NonNull String str, @Nullable Object obj) {
        if (obj == null) {
            parcel.writeByte((byte) 0);
        } else {
            Class<?> cls = obj.getClass();
            if (cls == Boolean.class) {
                parcel.writeByte((byte) 1);
                ParcelUtils.writeBooleanValue(parcel, ((Boolean) obj).booleanValue());
            } else if (cls == Byte.class) {
                parcel.writeByte((byte) 2);
                parcel.writeByte(((Byte) obj).byteValue());
            } else if (cls == Integer.class) {
                parcel.writeByte((byte) 3);
                parcel.writeInt(((Integer) obj).intValue());
            } else if (cls == Long.class) {
                parcel.writeByte((byte) 4);
                parcel.writeLong(((Long) obj).longValue());
            } else if (cls == Float.class) {
                parcel.writeByte((byte) 5);
                parcel.writeFloat(((Float) obj).floatValue());
            } else if (cls == Double.class) {
                parcel.writeByte((byte) 6);
                parcel.writeDouble(((Double) obj).doubleValue());
            } else if (cls == String.class) {
                parcel.writeByte((byte) 7);
                parcel.writeString((String) obj);
            } else if (cls == Boolean[].class) {
                parcel.writeByte((byte) 8);
                parcel.writeBooleanArray(Data.convertToPrimitiveArray((Boolean[]) obj));
            } else if (cls == Byte[].class) {
                parcel.writeByte((byte) 9);
                parcel.writeByteArray(Data.convertToPrimitiveArray((Byte[]) obj));
            } else if (cls == Integer[].class) {
                parcel.writeByte((byte) 10);
                parcel.writeIntArray(Data.convertToPrimitiveArray((Integer[]) obj));
            } else if (cls == Long[].class) {
                parcel.writeByte((byte) 11);
                parcel.writeLongArray(Data.convertToPrimitiveArray((Long[]) obj));
            } else if (cls == Float[].class) {
                parcel.writeByte((byte) 12);
                parcel.writeFloatArray(Data.convertToPrimitiveArray((Float[]) obj));
            } else if (cls == Double[].class) {
                parcel.writeByte((byte) 13);
                parcel.writeDoubleArray(Data.convertToPrimitiveArray((Double[]) obj));
            } else if (cls == String[].class) {
                parcel.writeByte((byte) 14);
                parcel.writeStringArray((String[]) obj);
            } else {
                throw new IllegalArgumentException(String.format("Unsupported value type %s", cls.getName()));
            }
        }
        parcel.writeString(str);
    }
}
