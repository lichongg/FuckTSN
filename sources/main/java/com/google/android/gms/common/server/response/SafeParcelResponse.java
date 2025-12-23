package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
@SafeParcelable.Class(creator = "SafeParcelResponseCreator")
/* loaded from: D:\Downloads\app\classes5.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {

    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new zaq();

    @SafeParcelable.VersionField(getter = "getVersionCode", id = 1)
    private final int zaa;

    @SafeParcelable.Field(getter = "getParcel", id = 2)
    private final Parcel zab;
    private final int zac;

    @SafeParcelable.Field(getter = "getFieldMappingDictionary", id = 3)
    private final zan zad;

    @Nullable
    private final String zae;
    private int zaf;
    private int zag;

    @SafeParcelable.Constructor
    SafeParcelResponse(@SafeParcelable.Param(id = 1) int i6, @SafeParcelable.Param(id = 2) Parcel parcel, @SafeParcelable.Param(id = 3) zan zanVar) {
        this.zaa = i6;
        this.zab = (Parcel) Preconditions.checkNotNull(parcel);
        this.zac = 2;
        this.zad = zanVar;
        this.zae = zanVar == null ? null : zanVar.zaa();
        this.zaf = 2;
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, zan zanVar, String str) {
        this.zaa = 1;
        Parcel obtain = Parcel.obtain();
        this.zab = obtain;
        safeParcelable.writeToParcel(obtain, 0);
        this.zac = 1;
        this.zad = (zan) Preconditions.checkNotNull(zanVar);
        this.zae = (String) Preconditions.checkNotNull(str);
        this.zaf = 2;
    }

    private final void zaG(FastJsonResponse.Field field) {
        if (field.zaf == -1) {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        }
        Parcel parcel = this.zab;
        if (parcel == null) {
            throw new IllegalStateException("Internal Parcel object is null.");
        }
        int i6 = this.zaf;
        if (i6 != 0) {
            if (i6 != 1) {
                throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
            }
        } else {
            this.zag = SafeParcelWriter.beginObjectHeader(parcel);
            this.zaf = 1;
        }
    }

    private final void zaH(StringBuilder sb, Map map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((FastJsonResponse.Field) entry.getValue()).getSafeParcelableFieldId(), entry);
        }
        sb.append('{');
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z5 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(SafeParcelReader.getFieldId(readHeader));
            if (entry2 != null) {
                if (z5) {
                    sb.append(",");
                }
                String str = (String) entry2.getKey();
                FastJsonResponse.Field field = (FastJsonResponse.Field) entry2.getValue();
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (field.zaj()) {
                    int i6 = field.zac;
                    switch (i6) {
                        case 0:
                            zaJ(sb, field, FastJsonResponse.zaD(field, Integer.valueOf(SafeParcelReader.readInt(parcel, readHeader))));
                            break;
                        case 1:
                            zaJ(sb, field, FastJsonResponse.zaD(field, SafeParcelReader.createBigInteger(parcel, readHeader)));
                            break;
                        case 2:
                            zaJ(sb, field, FastJsonResponse.zaD(field, Long.valueOf(SafeParcelReader.readLong(parcel, readHeader))));
                            break;
                        case 3:
                            zaJ(sb, field, FastJsonResponse.zaD(field, Float.valueOf(SafeParcelReader.readFloat(parcel, readHeader))));
                            break;
                        case 4:
                            zaJ(sb, field, FastJsonResponse.zaD(field, Double.valueOf(SafeParcelReader.readDouble(parcel, readHeader))));
                            break;
                        case 5:
                            zaJ(sb, field, FastJsonResponse.zaD(field, SafeParcelReader.createBigDecimal(parcel, readHeader)));
                            break;
                        case 6:
                            zaJ(sb, field, FastJsonResponse.zaD(field, Boolean.valueOf(SafeParcelReader.readBoolean(parcel, readHeader))));
                            break;
                        case 7:
                            zaJ(sb, field, FastJsonResponse.zaD(field, SafeParcelReader.createString(parcel, readHeader)));
                            break;
                        case 8:
                        case 9:
                            zaJ(sb, field, FastJsonResponse.zaD(field, SafeParcelReader.createByteArray(parcel, readHeader)));
                            break;
                        case 10:
                            Bundle createBundle = SafeParcelReader.createBundle(parcel, readHeader);
                            HashMap hashMap = new HashMap();
                            for (String str2 : createBundle.keySet()) {
                                hashMap.put(str2, (String) Preconditions.checkNotNull(createBundle.getString(str2)));
                            }
                            zaJ(sb, field, FastJsonResponse.zaD(field, hashMap));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException("Unknown field out type = " + i6);
                    }
                } else if (field.zad) {
                    sb.append("[");
                    switch (field.zac) {
                        case 0:
                            ArrayUtils.writeArray(sb, SafeParcelReader.createIntArray(parcel, readHeader));
                            break;
                        case 1:
                            ArrayUtils.writeArray(sb, SafeParcelReader.createBigIntegerArray(parcel, readHeader));
                            break;
                        case 2:
                            ArrayUtils.writeArray(sb, SafeParcelReader.createLongArray(parcel, readHeader));
                            break;
                        case 3:
                            ArrayUtils.writeArray(sb, SafeParcelReader.createFloatArray(parcel, readHeader));
                            break;
                        case 4:
                            ArrayUtils.writeArray(sb, SafeParcelReader.createDoubleArray(parcel, readHeader));
                            break;
                        case 5:
                            ArrayUtils.writeArray(sb, SafeParcelReader.createBigDecimalArray(parcel, readHeader));
                            break;
                        case 6:
                            ArrayUtils.writeArray(sb, SafeParcelReader.createBooleanArray(parcel, readHeader));
                            break;
                        case 7:
                            ArrayUtils.writeStringArray(sb, SafeParcelReader.createStringArray(parcel, readHeader));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] createParcelArray = SafeParcelReader.createParcelArray(parcel, readHeader);
                            int length = createParcelArray.length;
                            for (int i7 = 0; i7 < length; i7++) {
                                if (i7 > 0) {
                                    sb.append(",");
                                }
                                createParcelArray[i7].setDataPosition(0);
                                zaH(sb, field.zah(), createParcelArray[i7]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb.append("]");
                } else {
                    switch (field.zac) {
                        case 0:
                            sb.append(SafeParcelReader.readInt(parcel, readHeader));
                            break;
                        case 1:
                            sb.append(SafeParcelReader.createBigInteger(parcel, readHeader));
                            break;
                        case 2:
                            sb.append(SafeParcelReader.readLong(parcel, readHeader));
                            break;
                        case 3:
                            sb.append(SafeParcelReader.readFloat(parcel, readHeader));
                            break;
                        case 4:
                            sb.append(SafeParcelReader.readDouble(parcel, readHeader));
                            break;
                        case 5:
                            sb.append(SafeParcelReader.createBigDecimal(parcel, readHeader));
                            break;
                        case 6:
                            sb.append(SafeParcelReader.readBoolean(parcel, readHeader));
                            break;
                        case 7:
                            String createString = SafeParcelReader.createString(parcel, readHeader);
                            sb.append("\"");
                            sb.append(JsonUtils.escapeString(createString));
                            sb.append("\"");
                            break;
                        case 8:
                            byte[] createByteArray = SafeParcelReader.createByteArray(parcel, readHeader);
                            sb.append("\"");
                            sb.append(Base64Utils.encode(createByteArray));
                            sb.append("\"");
                            break;
                        case 9:
                            byte[] createByteArray2 = SafeParcelReader.createByteArray(parcel, readHeader);
                            sb.append("\"");
                            sb.append(Base64Utils.encodeUrlSafe(createByteArray2));
                            sb.append("\"");
                            break;
                        case 10:
                            Bundle createBundle2 = SafeParcelReader.createBundle(parcel, readHeader);
                            Set<String> keySet = createBundle2.keySet();
                            sb.append("{");
                            boolean z6 = true;
                            for (String str3 : keySet) {
                                if (!z6) {
                                    sb.append(",");
                                }
                                sb.append("\"");
                                sb.append(str3);
                                sb.append("\":\"");
                                sb.append(JsonUtils.escapeString(createBundle2.getString(str3)));
                                sb.append("\"");
                                z6 = false;
                            }
                            sb.append("}");
                            break;
                        case 11:
                            Parcel createParcel = SafeParcelReader.createParcel(parcel, readHeader);
                            createParcel.setDataPosition(0);
                            zaH(sb, field.zah(), createParcel);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z5 = true;
            }
        }
        if (parcel.dataPosition() == validateObjectHeader) {
            sb.append('}');
            return;
        }
        throw new SafeParcelReader.ParseException("Overread allowed size end=" + validateObjectHeader, parcel);
    }

    private static final void zaI(StringBuilder sb, int i6, @Nullable Object obj) {
        switch (i6) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(JsonUtils.escapeString(Preconditions.checkNotNull(obj).toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(Base64Utils.encode((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(Base64Utils.encodeUrlSafe((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                MapUtils.writeStringMapToJson(sb, (HashMap) Preconditions.checkNotNull(obj));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i6);
        }
    }

    private static final void zaJ(StringBuilder sb, FastJsonResponse.Field field, Object obj) {
        if (!field.zab) {
            zaI(sb, field.zaa, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb.append("[");
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (i6 != 0) {
                sb.append(",");
            }
            zaI(sb, field.zaa, arrayList.get(i6));
        }
        sb.append("]");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    @Nullable
    public final Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        zan zanVar = this.zad;
        if (zanVar == null) {
            return null;
        }
        return zanVar.zab((String) Preconditions.checkNotNull(this.zae));
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    @NonNull
    public final Object getValueObject(@NonNull String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean isPrimitiveFieldSet(@NonNull String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    @NonNull
    public final String toString() {
        Preconditions.checkNotNull(this.zad, "Cannot convert to JSON on client side.");
        Parcel zaE = zaE();
        zaE.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        zaH(sb, (Map) Preconditions.checkNotNull(this.zad.zab((String) Preconditions.checkNotNull(this.zae))), zaE);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i6) {
        int i7 = this.zaa;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i7);
        SafeParcelWriter.writeParcel(parcel, 2, zaE(), false);
        int i8 = this.zac;
        SafeParcelWriter.writeParcelable(parcel, 3, i8 != 0 ? i8 != 1 ? this.zad : this.zad : null, i6, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final Parcel zaE() {
        int i6 = this.zaf;
        if (i6 == 0) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(this.zab);
            this.zag = beginObjectHeader;
            SafeParcelWriter.finishObjectHeader(this.zab, beginObjectHeader);
            this.zaf = 2;
        } else if (i6 == 1) {
            SafeParcelWriter.finishObjectHeader(this.zab, this.zag);
            this.zaf = 2;
        }
        return this.zab;
    }

    @NonNull
    @KeepForSdk
    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse from(@NonNull T t5) {
        String str = (String) Preconditions.checkNotNull(t5.getClass().getCanonicalName());
        zan zanVar = new zan(t5.getClass());
        zaF(zanVar, t5);
        zanVar.zac();
        zanVar.zad();
        return new SafeParcelResponse(t5, zanVar, str);
    }

    private static void zaF(zan zanVar, FastJsonResponse fastJsonResponse) {
        Class<?> cls = fastJsonResponse.getClass();
        if (!zanVar.zaf(cls)) {
            Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
            zanVar.zae(cls, fieldMappings);
            Iterator<String> it = fieldMappings.keySet().iterator();
            while (it.hasNext()) {
                FastJsonResponse.Field<?, ?> field = fieldMappings.get(it.next());
                Class cls2 = field.zag;
                if (cls2 != null) {
                    try {
                        zaF(zanVar, (FastJsonResponse) cls2.newInstance());
                    } catch (IllegalAccessException e6) {
                        throw new IllegalStateException("Could not access object of type ".concat(String.valueOf(((Class) Preconditions.checkNotNull(field.zag)).getCanonicalName())), e6);
                    } catch (InstantiationException e7) {
                        throw new IllegalStateException("Could not instantiate an object of type ".concat(String.valueOf(((Class) Preconditions.checkNotNull(field.zag)).getCanonicalName())), e7);
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final <T extends FastJsonResponse> void addConcreteTypeArrayInternal(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable ArrayList<T> arrayList) {
        zaG(field);
        ArrayList arrayList2 = new ArrayList();
        ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            arrayList2.add(((SafeParcelResponse) arrayList.get(i6)).zaE());
        }
        SafeParcelWriter.writeParcelList(this.zab, field.getSafeParcelableFieldId(), arrayList2, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final <T extends FastJsonResponse> void addConcreteTypeInternal(@NonNull FastJsonResponse.Field field, @NonNull String str, @NonNull T t5) {
        zaG(field);
        SafeParcelWriter.writeParcel(this.zab, field.getSafeParcelableFieldId(), ((SafeParcelResponse) t5).zaE(), true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setBooleanInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, boolean z5) {
        zaG(field);
        SafeParcelWriter.writeBoolean(this.zab, field.getSafeParcelableFieldId(), z5);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setDecodedBytesInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable byte[] bArr) {
        zaG(field);
        SafeParcelWriter.writeByteArray(this.zab, field.getSafeParcelableFieldId(), bArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setIntegerInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, int i6) {
        zaG(field);
        SafeParcelWriter.writeInt(this.zab, field.getSafeParcelableFieldId(), i6);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setLongInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, long j6) {
        zaG(field);
        SafeParcelWriter.writeLong(this.zab, field.getSafeParcelableFieldId(), j6);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setStringInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable String str2) {
        zaG(field);
        SafeParcelWriter.writeString(this.zab, field.getSafeParcelableFieldId(), str2, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setStringMapInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable Map<String, String> map) {
        zaG(field);
        Bundle bundle = new Bundle();
        for (String str2 : ((Map) Preconditions.checkNotNull(map)).keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        SafeParcelWriter.writeBundle(this.zab, field.getSafeParcelableFieldId(), bundle, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setStringsInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable ArrayList<String> arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        String[] strArr = new String[size];
        for (int i6 = 0; i6 < size; i6++) {
            strArr[i6] = arrayList.get(i6);
        }
        SafeParcelWriter.writeStringArray(this.zab, field.getSafeParcelableFieldId(), strArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zab(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable BigDecimal bigDecimal) {
        zaG(field);
        SafeParcelWriter.writeBigDecimal(this.zab, field.getSafeParcelableFieldId(), bigDecimal, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zad(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i6 = 0; i6 < size; i6++) {
            bigDecimalArr[i6] = (BigDecimal) arrayList.get(i6);
        }
        SafeParcelWriter.writeBigDecimalArray(this.zab, field.getSafeParcelableFieldId(), bigDecimalArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zaf(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable BigInteger bigInteger) {
        zaG(field);
        SafeParcelWriter.writeBigInteger(this.zab, field.getSafeParcelableFieldId(), bigInteger, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zah(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i6 = 0; i6 < size; i6++) {
            bigIntegerArr[i6] = (BigInteger) arrayList.get(i6);
        }
        SafeParcelWriter.writeBigIntegerArray(this.zab, field.getSafeParcelableFieldId(), bigIntegerArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zak(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        boolean[] zArr = new boolean[size];
        for (int i6 = 0; i6 < size; i6++) {
            zArr[i6] = ((Boolean) arrayList.get(i6)).booleanValue();
        }
        SafeParcelWriter.writeBooleanArray(this.zab, field.getSafeParcelableFieldId(), zArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zan(@NonNull FastJsonResponse.Field field, @NonNull String str, double d6) {
        zaG(field);
        SafeParcelWriter.writeDouble(this.zab, field.getSafeParcelableFieldId(), d6);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zap(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        double[] dArr = new double[size];
        for (int i6 = 0; i6 < size; i6++) {
            dArr[i6] = ((Double) arrayList.get(i6)).doubleValue();
        }
        SafeParcelWriter.writeDoubleArray(this.zab, field.getSafeParcelableFieldId(), dArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zar(@NonNull FastJsonResponse.Field field, @NonNull String str, float f6) {
        zaG(field);
        SafeParcelWriter.writeFloat(this.zab, field.getSafeParcelableFieldId(), f6);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zat(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        float[] fArr = new float[size];
        for (int i6 = 0; i6 < size; i6++) {
            fArr[i6] = ((Float) arrayList.get(i6)).floatValue();
        }
        SafeParcelWriter.writeFloatArray(this.zab, field.getSafeParcelableFieldId(), fArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zaw(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        int[] iArr = new int[size];
        for (int i6 = 0; i6 < size; i6++) {
            iArr[i6] = ((Integer) arrayList.get(i6)).intValue();
        }
        SafeParcelWriter.writeIntArray(this.zab, field.getSafeParcelableFieldId(), iArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zaz(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        long[] jArr = new long[size];
        for (int i6 = 0; i6 < size; i6++) {
            jArr[i6] = ((Long) arrayList.get(i6)).longValue();
        }
        SafeParcelWriter.writeLongArray(this.zab, field.getSafeParcelableFieldId(), jArr, true);
    }

    public SafeParcelResponse(zan zanVar, String str) {
        this.zaa = 1;
        this.zab = Parcel.obtain();
        this.zac = 0;
        this.zad = (zan) Preconditions.checkNotNull(zanVar);
        this.zae = (String) Preconditions.checkNotNull(str);
        this.zaf = 0;
    }
}
