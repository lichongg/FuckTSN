package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.acse.ottn.l3;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ShowFirstParty
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class FastJsonResponse {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SafeParcelable.Class(creator = "FieldCreator")
    @ShowFirstParty
    @KeepForSdk
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final zaj CREATOR = new zaj();

        @SafeParcelable.Field(getter = "getTypeIn", id = 2)
        protected final int zaa;

        @SafeParcelable.Field(getter = "isTypeInArray", id = 3)
        protected final boolean zab;

        @SafeParcelable.Field(getter = "getTypeOut", id = 4)
        protected final int zac;

        @SafeParcelable.Field(getter = "isTypeOutArray", id = 5)
        protected final boolean zad;

        @NonNull
        @SafeParcelable.Field(getter = "getOutputFieldName", id = 6)
        protected final String zae;

        @SafeParcelable.Field(getter = "getSafeParcelableFieldId", id = 7)
        protected final int zaf;

        @Nullable
        protected final Class zag;

        @Nullable
        @SafeParcelable.Field(getter = "getConcreteTypeName", id = 8)
        protected final String zah;

        @SafeParcelable.VersionField(getter = "getVersionCode", id = 1)
        private final int zai;
        private zan zaj;

        @Nullable
        @SafeParcelable.Field(getter = "getWrappedConverter", id = 9, type = "com.google.android.gms.common.server.converter.ConverterWrapper")
        private final FieldConverter zak;

        @SafeParcelable.Constructor
        Field(@SafeParcelable.Param(id = 1) int i6, @SafeParcelable.Param(id = 2) int i7, @SafeParcelable.Param(id = 3) boolean z5, @SafeParcelable.Param(id = 4) int i8, @SafeParcelable.Param(id = 5) boolean z6, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) int i9, @Nullable @SafeParcelable.Param(id = 8) String str2, @Nullable @SafeParcelable.Param(id = 9) com.google.android.gms.common.server.converter.zaa zaaVar) {
            this.zai = i6;
            this.zaa = i7;
            this.zab = z5;
            this.zac = i8;
            this.zad = z6;
            this.zae = str;
            this.zaf = i9;
            if (str2 == null) {
                this.zag = null;
                this.zah = null;
            } else {
                this.zag = SafeParcelResponse.class;
                this.zah = str2;
            }
            if (zaaVar == null) {
                this.zak = null;
            } else {
                this.zak = zaaVar.zab();
            }
        }

        @NonNull
        @KeepForSdk
        public static Field<byte[], byte[]> forBase64(@NonNull String str, int i6) {
            return new Field<>(8, false, 8, false, str, i6, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Boolean, Boolean> forBoolean(@NonNull String str, int i6) {
            return new Field<>(6, false, 6, false, str, i6, null, null);
        }

        @NonNull
        @KeepForSdk
        public static <T extends FastJsonResponse> Field<T, T> forConcreteType(@NonNull String str, int i6, @NonNull Class<T> cls) {
            return new Field<>(11, false, 11, false, str, i6, cls, null);
        }

        @NonNull
        @KeepForSdk
        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(@NonNull String str, int i6, @NonNull Class<T> cls) {
            return new Field<>(11, true, 11, true, str, i6, cls, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Double, Double> forDouble(@NonNull String str, int i6) {
            return new Field<>(4, false, 4, false, str, i6, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Float, Float> forFloat(@NonNull String str, int i6) {
            return new Field<>(3, false, 3, false, str, i6, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Integer, Integer> forInteger(@NonNull String str, int i6) {
            return new Field<>(0, false, 0, false, str, i6, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Long, Long> forLong(@NonNull String str, int i6) {
            return new Field<>(2, false, 2, false, str, i6, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<String, String> forString(@NonNull String str, int i6) {
            return new Field<>(7, false, 7, false, str, i6, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<HashMap<String, String>, HashMap<String, String>> forStringMap(@NonNull String str, int i6) {
            return new Field<>(10, false, 10, false, str, i6, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<ArrayList<String>, ArrayList<String>> forStrings(@NonNull String str, int i6) {
            return new Field<>(7, true, 7, true, str, i6, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field withConverter(@NonNull String str, int i6, @NonNull FieldConverter<?, ?> fieldConverter, boolean z5) {
            fieldConverter.zaa();
            fieldConverter.zab();
            return new Field(7, z5, 0, false, str, i6, null, fieldConverter);
        }

        @KeepForSdk
        public int getSafeParcelableFieldId() {
            return this.zaf;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@NonNull Parcel parcel, int i6) {
            int i7 = this.zai;
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, i7);
            SafeParcelWriter.writeInt(parcel, 2, this.zaa);
            SafeParcelWriter.writeBoolean(parcel, 3, this.zab);
            SafeParcelWriter.writeInt(parcel, 4, this.zac);
            SafeParcelWriter.writeBoolean(parcel, 5, this.zad);
            SafeParcelWriter.writeString(parcel, 6, this.zae, false);
            SafeParcelWriter.writeInt(parcel, 7, getSafeParcelableFieldId());
            SafeParcelWriter.writeString(parcel, 8, zag(), false);
            SafeParcelWriter.writeParcelable(parcel, 9, zaa(), i6, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        @Nullable
        final com.google.android.gms.common.server.converter.zaa zaa() {
            FieldConverter fieldConverter = this.zak;
            if (fieldConverter == null) {
                return null;
            }
            return com.google.android.gms.common.server.converter.zaa.zaa(fieldConverter);
        }

        @NonNull
        public final Field zab() {
            return new Field(this.zai, this.zaa, this.zab, this.zac, this.zad, this.zae, this.zaf, this.zah, zaa());
        }

        @NonNull
        public final FastJsonResponse zad() throws InstantiationException, IllegalAccessException {
            Preconditions.checkNotNull(this.zag);
            Class cls = this.zag;
            if (cls != SafeParcelResponse.class) {
                return (FastJsonResponse) cls.newInstance();
            }
            Preconditions.checkNotNull(this.zah);
            Preconditions.checkNotNull(this.zaj, "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
            return new SafeParcelResponse(this.zaj, this.zah);
        }

        @NonNull
        public final Object zae(@Nullable Object obj) {
            Preconditions.checkNotNull(this.zak);
            return Preconditions.checkNotNull(this.zak.zac(obj));
        }

        @NonNull
        public final Object zaf(@NonNull Object obj) {
            Preconditions.checkNotNull(this.zak);
            return this.zak.zad(obj);
        }

        @Nullable
        final String zag() {
            String str = this.zah;
            if (str == null) {
                return null;
            }
            return str;
        }

        @NonNull
        public final Map zah() {
            Preconditions.checkNotNull(this.zah);
            Preconditions.checkNotNull(this.zaj);
            return (Map) Preconditions.checkNotNull(this.zaj.zab(this.zah));
        }

        public final void zai(zan zanVar) {
            this.zaj = zanVar;
        }

        public final boolean zaj() {
            return this.zak != null;
        }

        @NonNull
        public final String toString() {
            Objects.ToStringHelper add = Objects.toStringHelper(this).add("versionCode", Integer.valueOf(this.zai)).add("typeIn", Integer.valueOf(this.zaa)).add("typeInArray", Boolean.valueOf(this.zab)).add("typeOut", Integer.valueOf(this.zac)).add("typeOutArray", Boolean.valueOf(this.zad)).add("outputFieldName", this.zae).add("safeParcelFieldId", Integer.valueOf(this.zaf)).add("concreteTypeName", zag());
            Class cls = this.zag;
            if (cls != null) {
                add.add("concreteType.class", cls.getCanonicalName());
            }
            FieldConverter fieldConverter = this.zak;
            if (fieldConverter != null) {
                add.add("converterName", fieldConverter.getClass().getCanonicalName());
            }
            return add.toString();
        }

        protected Field(int i6, boolean z5, int i7, boolean z6, @NonNull String str, int i8, @Nullable Class cls, @Nullable FieldConverter fieldConverter) {
            this.zai = 1;
            this.zaa = i6;
            this.zab = z5;
            this.zac = i7;
            this.zad = z6;
            this.zae = str;
            this.zaf = i8;
            this.zag = cls;
            if (cls == null) {
                this.zah = null;
            } else {
                this.zah = cls.getCanonicalName();
            }
            this.zak = fieldConverter;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @ShowFirstParty
    public interface FieldConverter<I, O> {
        int zaa();

        int zab();

        @Nullable
        Object zac(@NonNull Object obj);

        @NonNull
        Object zad(@NonNull Object obj);
    }

    @NonNull
    @KeepForSdk
    public abstract Map<String, Field<?, ?>> getFieldMappings();

    @Nullable
    @KeepForSdk
    protected abstract Object getValueObject(@NonNull String str);

    @KeepForSdk
    protected abstract boolean isPrimitiveFieldSet(@NonNull String str);

    private final void zaE(Field field, @Nullable Object obj) {
        int i6 = field.zac;
        Object zae = field.zae(obj);
        String str = field.zae;
        switch (i6) {
            case 0:
                if (zae != null) {
                    setIntegerInternal(field, str, ((Integer) zae).intValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 1:
                zaf(field, str, (BigInteger) zae);
                return;
            case 2:
                if (zae != null) {
                    setLongInternal(field, str, ((Long) zae).longValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 3:
            default:
                throw new IllegalStateException("Unsupported type for conversion: " + i6);
            case 4:
                if (zae != null) {
                    zan(field, str, ((Double) zae).doubleValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 5:
                zab(field, str, (BigDecimal) zae);
                return;
            case 6:
                if (zae != null) {
                    setBooleanInternal(field, str, ((Boolean) zae).booleanValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 7:
                setStringInternal(field, str, (String) zae);
                return;
            case 8:
            case 9:
                if (zae != null) {
                    setDecodedBytesInternal(field, str, (byte[]) zae);
                    return;
                } else {
                    zaG(str);
                    return;
                }
        }
    }

    private static final void zaF(StringBuilder sb, Field field, Object obj) {
        int i6 = field.zaa;
        if (i6 == 11) {
            Class cls = field.zag;
            Preconditions.checkNotNull(cls);
            sb.append(((FastJsonResponse) cls.cast(obj)).toString());
        } else {
            if (i6 != 7) {
                sb.append(obj);
                return;
            }
            sb.append("\"");
            sb.append(JsonUtils.escapeString((String) obj));
            sb.append("\"");
        }
    }

    private static final void zaG(String str) {
        Log.isLoggable("FastJsonResponse", 6);
    }

    @KeepForSdk
    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(@NonNull Field field, @NonNull String str, @Nullable ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    @KeepForSdk
    public <T extends FastJsonResponse> void addConcreteTypeInternal(@NonNull Field field, @NonNull String str, @NonNull T t5) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    @Nullable
    @KeepForSdk
    protected Object getFieldValue(@NonNull Field field) {
        String str = field.zae;
        if (field.zag == null) {
            return getValueObject(str);
        }
        Preconditions.checkState(getValueObject(str) == null, "Concrete field shouldn't be value object: %s", field.zae);
        try {
            return getClass().getMethod(l3.f4736f + Character.toUpperCase(str.charAt(0)) + str.substring(1), null).invoke(this, null);
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    @KeepForSdk
    protected boolean isFieldSet(@NonNull Field field) {
        if (field.zac != 11) {
            return isPrimitiveFieldSet(field.zae);
        }
        if (field.zad) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    @KeepForSdk
    protected void setBooleanInternal(@NonNull Field<?, ?> field, @NonNull String str, boolean z5) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    @KeepForSdk
    protected void setDecodedBytesInternal(@NonNull Field<?, ?> field, @NonNull String str, @Nullable byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    @KeepForSdk
    protected void setIntegerInternal(@NonNull Field<?, ?> field, @NonNull String str, int i6) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    @KeepForSdk
    protected void setLongInternal(@NonNull Field<?, ?> field, @NonNull String str, long j6) {
        throw new UnsupportedOperationException("Long not supported");
    }

    @KeepForSdk
    protected void setStringInternal(@NonNull Field<?, ?> field, @NonNull String str, @Nullable String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    @KeepForSdk
    protected void setStringMapInternal(@NonNull Field<?, ?> field, @NonNull String str, @Nullable Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    @KeepForSdk
    protected void setStringsInternal(@NonNull Field<?, ?> field, @NonNull String str, @Nullable ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    protected void zab(@NonNull Field field, @NonNull String str, @Nullable BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    protected void zad(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    protected void zaf(@NonNull Field field, @NonNull String str, @Nullable BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    protected void zah(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    protected void zak(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    protected void zan(@NonNull Field field, @NonNull String str, double d6) {
        throw new UnsupportedOperationException("Double not supported");
    }

    protected void zap(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    protected void zar(@NonNull Field field, @NonNull String str, float f6) {
        throw new UnsupportedOperationException("Float not supported");
    }

    protected void zat(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    protected void zaw(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    protected void zaz(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    @NonNull
    protected static final Object zaD(@NonNull Field field, @Nullable Object obj) {
        if (field.zak != null) {
            return field.zaf(obj);
        }
        return obj;
    }

    @NonNull
    @KeepForSdk
    public String toString() {
        Map<String, Field<?, ?>> fieldMappings = getFieldMappings();
        StringBuilder sb = new StringBuilder(100);
        for (String str : fieldMappings.keySet()) {
            Field<?, ?> field = fieldMappings.get(str);
            if (isFieldSet(field)) {
                Object zaD = zaD(field, getFieldValue(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (zaD == null) {
                    sb.append("null");
                } else {
                    switch (field.zac) {
                        case 8:
                            sb.append("\"");
                            sb.append(Base64Utils.encode((byte[]) zaD));
                            sb.append("\"");
                            break;
                        case 9:
                            sb.append("\"");
                            sb.append(Base64Utils.encodeUrlSafe((byte[]) zaD));
                            sb.append("\"");
                            break;
                        case 10:
                            MapUtils.writeStringMapToJson(sb, (HashMap) zaD);
                            break;
                        default:
                            if (field.zab) {
                                ArrayList arrayList = (ArrayList) zaD;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i6 = 0; i6 < size; i6++) {
                                    if (i6 > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i6);
                                    if (obj != null) {
                                        zaF(sb, field, obj);
                                    }
                                }
                                sb.append("]");
                                break;
                            } else {
                                zaF(sb, field, zaD);
                                break;
                            }
                    }
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    public final void zaA(@NonNull Field field, @Nullable String str) {
        if (field.zak != null) {
            zaE(field, str);
        } else {
            setStringInternal(field, field.zae, str);
        }
    }

    public final void zaB(@NonNull Field field, @Nullable Map map) {
        if (field.zak != null) {
            zaE(field, map);
        } else {
            setStringMapInternal(field, field.zae, map);
        }
    }

    public final void zaC(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            setStringsInternal(field, field.zae, arrayList);
        }
    }

    public final void zaa(@NonNull Field field, @Nullable BigDecimal bigDecimal) {
        if (field.zak != null) {
            zaE(field, bigDecimal);
        } else {
            zab(field, field.zae, bigDecimal);
        }
    }

    public final void zac(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zad(field, field.zae, arrayList);
        }
    }

    public final void zae(@NonNull Field field, @Nullable BigInteger bigInteger) {
        if (field.zak != null) {
            zaE(field, bigInteger);
        } else {
            zaf(field, field.zae, bigInteger);
        }
    }

    public final void zag(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zah(field, field.zae, arrayList);
        }
    }

    public final void zai(@NonNull Field field, boolean z5) {
        if (field.zak != null) {
            zaE(field, Boolean.valueOf(z5));
        } else {
            setBooleanInternal(field, field.zae, z5);
        }
    }

    public final void zaj(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zak(field, field.zae, arrayList);
        }
    }

    public final void zal(@NonNull Field field, @Nullable byte[] bArr) {
        if (field.zak != null) {
            zaE(field, bArr);
        } else {
            setDecodedBytesInternal(field, field.zae, bArr);
        }
    }

    public final void zam(@NonNull Field field, double d6) {
        if (field.zak != null) {
            zaE(field, Double.valueOf(d6));
        } else {
            zan(field, field.zae, d6);
        }
    }

    public final void zao(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zap(field, field.zae, arrayList);
        }
    }

    public final void zaq(@NonNull Field field, float f6) {
        if (field.zak != null) {
            zaE(field, Float.valueOf(f6));
        } else {
            zar(field, field.zae, f6);
        }
    }

    public final void zas(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zat(field, field.zae, arrayList);
        }
    }

    public final void zau(@NonNull Field field, int i6) {
        if (field.zak != null) {
            zaE(field, Integer.valueOf(i6));
        } else {
            setIntegerInternal(field, field.zae, i6);
        }
    }

    public final void zav(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zaw(field, field.zae, arrayList);
        }
    }

    public final void zax(@NonNull Field field, long j6) {
        if (field.zak != null) {
            zaE(field, Long.valueOf(j6));
        } else {
            setLongInternal(field, field.zae, j6);
        }
    }

    public final void zay(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zaz(field, field.zae, arrayList);
        }
    }
}
