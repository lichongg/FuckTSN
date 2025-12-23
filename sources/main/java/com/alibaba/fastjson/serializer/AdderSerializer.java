package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AdderSerializer implements ObjectSerializer {
    public static final AdderSerializer instance = new AdderSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        double doubleValue;
        long longValue;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (a.a(obj)) {
            longValue = b.a(obj).longValue();
            serializeWriter.writeFieldValue('{', "value", longValue);
            serializeWriter.write(125);
        } else if (d.a(obj)) {
            doubleValue = e.a(obj).doubleValue();
            serializeWriter.writeFieldValue('{', "value", doubleValue);
            serializeWriter.write(125);
        }
    }
}
