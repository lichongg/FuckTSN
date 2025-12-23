package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.room.TypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class Data {

    @SuppressLint({"MinMaxConstant"})
    public static final int MAX_DATA_BYTES = 10240;
    Map<String, Object> mValues;
    private static final String TAG = Logger.tagWithPrefix("Data");
    public static final Data EMPTY = new Builder().build();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder {
        private Map<String, Object> mValues = new HashMap();

        @NonNull
        public Builder putAll(@NonNull Data data) {
            putAll(data.mValues);
            return this;
        }

        @NonNull
        public Data build() {
            Data data = new Data((Map<String, ?>) this.mValues);
            Data.toByteArrayInternal(data);
            return data;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder put(@NonNull String key, @Nullable Object value) {
            if (value == null) {
                this.mValues.put(key, null);
                return this;
            }
            Class<?> cls = value.getClass();
            if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                this.mValues.put(key, value);
                return this;
            }
            if (cls == boolean[].class) {
                this.mValues.put(key, Data.convertPrimitiveBooleanArray((boolean[]) value));
                return this;
            }
            if (cls == byte[].class) {
                this.mValues.put(key, Data.convertPrimitiveByteArray((byte[]) value));
                return this;
            }
            if (cls == int[].class) {
                this.mValues.put(key, Data.convertPrimitiveIntArray((int[]) value));
                return this;
            }
            if (cls == long[].class) {
                this.mValues.put(key, Data.convertPrimitiveLongArray((long[]) value));
                return this;
            }
            if (cls == float[].class) {
                this.mValues.put(key, Data.convertPrimitiveFloatArray((float[]) value));
                return this;
            }
            if (cls != double[].class) {
                throw new IllegalArgumentException(String.format("Key %s has invalid type %s", key, cls));
            }
            this.mValues.put(key, Data.convertPrimitiveDoubleArray((double[]) value));
            return this;
        }

        @NonNull
        public Builder putAll(@NonNull Map<String, Object> values) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        @NonNull
        public Builder putBoolean(@NonNull String key, boolean value) {
            this.mValues.put(key, Boolean.valueOf(value));
            return this;
        }

        @NonNull
        public Builder putBooleanArray(@NonNull String key, @NonNull boolean[] value) {
            this.mValues.put(key, Data.convertPrimitiveBooleanArray(value));
            return this;
        }

        @NonNull
        public Builder putByte(@NonNull String key, byte value) {
            this.mValues.put(key, Byte.valueOf(value));
            return this;
        }

        @NonNull
        public Builder putByteArray(@NonNull String key, @NonNull byte[] value) {
            this.mValues.put(key, Data.convertPrimitiveByteArray(value));
            return this;
        }

        @NonNull
        public Builder putDouble(@NonNull String key, double value) {
            this.mValues.put(key, Double.valueOf(value));
            return this;
        }

        @NonNull
        public Builder putDoubleArray(@NonNull String key, @NonNull double[] value) {
            this.mValues.put(key, Data.convertPrimitiveDoubleArray(value));
            return this;
        }

        @NonNull
        public Builder putFloat(@NonNull String key, float value) {
            this.mValues.put(key, Float.valueOf(value));
            return this;
        }

        @NonNull
        public Builder putFloatArray(@NonNull String key, @NonNull float[] value) {
            this.mValues.put(key, Data.convertPrimitiveFloatArray(value));
            return this;
        }

        @NonNull
        public Builder putInt(@NonNull String key, int value) {
            this.mValues.put(key, Integer.valueOf(value));
            return this;
        }

        @NonNull
        public Builder putIntArray(@NonNull String key, @NonNull int[] value) {
            this.mValues.put(key, Data.convertPrimitiveIntArray(value));
            return this;
        }

        @NonNull
        public Builder putLong(@NonNull String key, long value) {
            this.mValues.put(key, Long.valueOf(value));
            return this;
        }

        @NonNull
        public Builder putLongArray(@NonNull String key, @NonNull long[] value) {
            this.mValues.put(key, Data.convertPrimitiveLongArray(value));
            return this;
        }

        @NonNull
        public Builder putString(@NonNull String key, @Nullable String value) {
            this.mValues.put(key, value);
            return this;
        }

        @NonNull
        public Builder putStringArray(@NonNull String key, @NonNull String[] value) {
            this.mValues.put(key, value);
            return this;
        }
    }

    Data() {
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Boolean[] convertPrimitiveBooleanArray(@NonNull boolean[] value) {
        Boolean[] boolArr = new Boolean[value.length];
        for (int i6 = 0; i6 < value.length; i6++) {
            boolArr[i6] = Boolean.valueOf(value[i6]);
        }
        return boolArr;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Byte[] convertPrimitiveByteArray(@NonNull byte[] value) {
        Byte[] bArr = new Byte[value.length];
        for (int i6 = 0; i6 < value.length; i6++) {
            bArr[i6] = Byte.valueOf(value[i6]);
        }
        return bArr;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Double[] convertPrimitiveDoubleArray(@NonNull double[] value) {
        Double[] dArr = new Double[value.length];
        for (int i6 = 0; i6 < value.length; i6++) {
            dArr[i6] = Double.valueOf(value[i6]);
        }
        return dArr;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Float[] convertPrimitiveFloatArray(@NonNull float[] value) {
        Float[] fArr = new Float[value.length];
        for (int i6 = 0; i6 < value.length; i6++) {
            fArr[i6] = Float.valueOf(value[i6]);
        }
        return fArr;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Integer[] convertPrimitiveIntArray(@NonNull int[] value) {
        Integer[] numArr = new Integer[value.length];
        for (int i6 = 0; i6 < value.length; i6++) {
            numArr[i6] = Integer.valueOf(value[i6]);
        }
        return numArr;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Long[] convertPrimitiveLongArray(@NonNull long[] value) {
        Long[] lArr = new Long[value.length];
        for (int i6 = 0; i6 < value.length; i6++) {
            lArr[i6] = Long.valueOf(value[i6]);
        }
        return lArr;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean[] convertToPrimitiveArray(@NonNull Boolean[] array) {
        boolean[] zArr = new boolean[array.length];
        for (int i6 = 0; i6 < array.length; i6++) {
            zArr[i6] = array[i6].booleanValue();
        }
        return zArr;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:19:0x0031
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @androidx.annotation.NonNull
    @androidx.room.TypeConverter
    public static androidx.work.Data fromByteArray(@androidx.annotation.NonNull byte[] r5) {
        /*
            int r0 = r5.length
            r1 = 10240(0x2800, float:1.4349E-41)
            if (r0 > r1) goto L50
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r5)
            r5 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L35 java.lang.Throwable -> L39
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L35 java.lang.Throwable -> L39
            int r5 = r2.readInt()     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L2b
        L19:
            if (r5 <= 0) goto L2e
            java.lang.String r3 = r2.readUTF()     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L2b
            java.lang.Object r4 = r2.readObject()     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L2b
            r0.put(r3, r4)     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L2b
            int r5 = r5 + (-1)
            goto L19
        L29:
            r5 = move-exception
            goto L3b
        L2b:
            r5 = r2
            goto L44
        L2e:
            r2.close()     // Catch: java.io.IOException -> L31
        L31:
            r1.close()     // Catch: java.io.IOException -> L4a
            goto L4a
        L35:
            r0 = move-exception
            r2 = r5
            r5 = r0
            goto L3b
        L39:
            goto L44
        L3b:
            if (r2 == 0) goto L40
            r2.close()     // Catch: java.io.IOException -> L40
        L40:
            r1.close()     // Catch: java.io.IOException -> L43
        L43:
            throw r5
        L44:
            if (r5 == 0) goto L31
            r5.close()     // Catch: java.io.IOException -> L31
            goto L31
        L4a:
            androidx.work.Data r5 = new androidx.work.Data
            r5.<init>(r0)
            return r5
        L50:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.fromByteArray(byte[]):androidx.work.Data");
    }

    public boolean equals(Object o5) {
        if (this == o5) {
            return true;
        }
        if (o5 == null || Data.class != o5.getClass()) {
            return false;
        }
        Data data = (Data) o5;
        Set<String> keySet = this.mValues.keySet();
        if (!keySet.equals(data.mValues.keySet())) {
            return false;
        }
        for (String str : keySet) {
            Object obj = this.mValues.get(str);
            Object obj2 = data.mValues.get(str);
            if (!((obj == null || obj2 == null) ? obj == obj2 : ((obj instanceof Object[]) && (obj2 instanceof Object[])) ? Arrays.deepEquals((Object[]) obj, (Object[]) obj2) : obj.equals(obj2))) {
                return false;
            }
        }
        return true;
    }

    public Data(@NonNull Data other) {
        this.mValues = new HashMap(other.mValues);
    }

    @NonNull
    @TypeConverter
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static byte[] toByteArrayInternal(@NonNull Data data) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeInt(data.size());
                    for (Map.Entry<String, Object> entry : data.mValues.entrySet()) {
                        objectOutputStream2.writeUTF(entry.getKey());
                        objectOutputStream2.writeObject(entry.getValue());
                    }
                    try {
                        objectOutputStream2.close();
                    } catch (IOException unused) {
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused2) {
                    }
                    if (byteArrayOutputStream.size() <= 10240) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                } catch (IOException unused3) {
                    objectOutputStream = objectOutputStream2;
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused5) {
                    }
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException unused6) {
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (IOException unused7) {
                        throw th;
                    }
                }
            } catch (IOException unused8) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public boolean getBoolean(@NonNull String key, boolean defaultValue) {
        Object obj = this.mValues.get(key);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : defaultValue;
    }

    @Nullable
    public boolean[] getBooleanArray(@NonNull String key) {
        Object obj = this.mValues.get(key);
        if (obj instanceof Boolean[]) {
            return convertToPrimitiveArray((Boolean[]) obj);
        }
        return null;
    }

    public byte getByte(@NonNull String key, byte defaultValue) {
        Object obj = this.mValues.get(key);
        return obj instanceof Byte ? ((Byte) obj).byteValue() : defaultValue;
    }

    @Nullable
    public byte[] getByteArray(@NonNull String key) {
        Object obj = this.mValues.get(key);
        if (obj instanceof Byte[]) {
            return convertToPrimitiveArray((Byte[]) obj);
        }
        return null;
    }

    public double getDouble(@NonNull String key, double defaultValue) {
        Object obj = this.mValues.get(key);
        return obj instanceof Double ? ((Double) obj).doubleValue() : defaultValue;
    }

    @Nullable
    public double[] getDoubleArray(@NonNull String key) {
        Object obj = this.mValues.get(key);
        if (obj instanceof Double[]) {
            return convertToPrimitiveArray((Double[]) obj);
        }
        return null;
    }

    public float getFloat(@NonNull String key, float defaultValue) {
        Object obj = this.mValues.get(key);
        return obj instanceof Float ? ((Float) obj).floatValue() : defaultValue;
    }

    @Nullable
    public float[] getFloatArray(@NonNull String key) {
        Object obj = this.mValues.get(key);
        if (obj instanceof Float[]) {
            return convertToPrimitiveArray((Float[]) obj);
        }
        return null;
    }

    public int getInt(@NonNull String key, int defaultValue) {
        Object obj = this.mValues.get(key);
        return obj instanceof Integer ? ((Integer) obj).intValue() : defaultValue;
    }

    @Nullable
    public int[] getIntArray(@NonNull String key) {
        Object obj = this.mValues.get(key);
        if (obj instanceof Integer[]) {
            return convertToPrimitiveArray((Integer[]) obj);
        }
        return null;
    }

    @NonNull
    public Map<String, Object> getKeyValueMap() {
        return Collections.unmodifiableMap(this.mValues);
    }

    public long getLong(@NonNull String key, long defaultValue) {
        Object obj = this.mValues.get(key);
        return obj instanceof Long ? ((Long) obj).longValue() : defaultValue;
    }

    @Nullable
    public long[] getLongArray(@NonNull String key) {
        Object obj = this.mValues.get(key);
        if (obj instanceof Long[]) {
            return convertToPrimitiveArray((Long[]) obj);
        }
        return null;
    }

    @Nullable
    public String getString(@NonNull String key) {
        Object obj = this.mValues.get(key);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    @Nullable
    public String[] getStringArray(@NonNull String key) {
        Object obj = this.mValues.get(key);
        if (obj instanceof String[]) {
            return (String[]) obj;
        }
        return null;
    }

    public <T> boolean hasKeyWithValueOfType(@NonNull String key, @NonNull Class<T> klass) {
        Object obj = this.mValues.get(key);
        return obj != null && klass.isAssignableFrom(obj.getClass());
    }

    public int hashCode() {
        return this.mValues.hashCode() * 31;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public int size() {
        return this.mValues.size();
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        if (!this.mValues.isEmpty()) {
            for (String str : this.mValues.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = this.mValues.get(str);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @NonNull
    public byte[] toByteArray() {
        return toByteArrayInternal(this);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Data(@NonNull Map<String, ?> values) {
        this.mValues = new HashMap(values);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static byte[] convertToPrimitiveArray(@NonNull Byte[] array) {
        byte[] bArr = new byte[array.length];
        for (int i6 = 0; i6 < array.length; i6++) {
            bArr[i6] = array[i6].byteValue();
        }
        return bArr;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int[] convertToPrimitiveArray(@NonNull Integer[] array) {
        int[] iArr = new int[array.length];
        for (int i6 = 0; i6 < array.length; i6++) {
            iArr[i6] = array[i6].intValue();
        }
        return iArr;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static long[] convertToPrimitiveArray(@NonNull Long[] array) {
        long[] jArr = new long[array.length];
        for (int i6 = 0; i6 < array.length; i6++) {
            jArr[i6] = array[i6].longValue();
        }
        return jArr;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static float[] convertToPrimitiveArray(@NonNull Float[] array) {
        float[] fArr = new float[array.length];
        for (int i6 = 0; i6 < array.length; i6++) {
            fArr[i6] = array[i6].floatValue();
        }
        return fArr;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static double[] convertToPrimitiveArray(@NonNull Double[] array) {
        double[] dArr = new double[array.length];
        for (int i6 = 0; i6 < array.length; i6++) {
            dArr[i6] = array[i6].doubleValue();
        }
        return dArr;
    }
}
