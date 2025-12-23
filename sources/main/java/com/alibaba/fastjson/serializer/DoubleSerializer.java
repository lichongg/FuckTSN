package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DoubleSerializer implements ObjectSerializer {
    public static final DoubleSerializer instance = new DoubleSerializer();
    private DecimalFormat decimalFormat;

    public DoubleSerializer() {
        this.decimalFormat = null;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        double doubleValue = ((Double) obj).doubleValue();
        if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
            serializeWriter.writeNull();
            return;
        }
        DecimalFormat decimalFormat = this.decimalFormat;
        if (decimalFormat == null) {
            serializeWriter.writeDouble(doubleValue, true);
        } else {
            serializeWriter.write(decimalFormat.format(doubleValue));
        }
    }

    public DoubleSerializer(DecimalFormat decimalFormat) {
        this.decimalFormat = decimalFormat;
    }

    public DoubleSerializer(String str) {
        this(new DecimalFormat(str));
    }
}
