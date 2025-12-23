package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class PrimitiveArraySerializer implements ObjectSerializer {
    public static PrimitiveArraySerializer instance = new PrimitiveArraySerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        int i7 = 0;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            serializeWriter.write(91);
            while (i7 < iArr.length) {
                if (i7 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeInt(iArr[i7]);
                i7++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            serializeWriter.write(91);
            while (i7 < sArr.length) {
                if (i7 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeInt(sArr[i7]);
                i7++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            serializeWriter.write(91);
            while (i7 < jArr.length) {
                if (i7 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeLong(jArr[i7]);
                i7++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            serializeWriter.write(91);
            while (i7 < zArr.length) {
                if (i7 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.write(zArr[i7]);
                i7++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            serializeWriter.write(91);
            while (i7 < fArr.length) {
                if (i7 != 0) {
                    serializeWriter.write(44);
                }
                float f6 = fArr[i7];
                if (Float.isNaN(f6)) {
                    serializeWriter.writeNull();
                } else {
                    serializeWriter.append((CharSequence) Float.toString(f6));
                }
                i7++;
            }
            serializeWriter.write(93);
            return;
        }
        if (!(obj instanceof double[])) {
            if (obj instanceof byte[]) {
                serializeWriter.writeByteArray((byte[]) obj);
                return;
            } else {
                serializeWriter.writeString(new String((char[]) obj));
                return;
            }
        }
        double[] dArr = (double[]) obj;
        serializeWriter.write(91);
        while (i7 < dArr.length) {
            if (i7 != 0) {
                serializeWriter.write(44);
            }
            double d6 = dArr[i7];
            if (Double.isNaN(d6)) {
                serializeWriter.writeNull();
            } else {
                serializeWriter.append((CharSequence) Double.toString(d6));
            }
            i7++;
        }
        serializeWriter.write(93);
    }
}
