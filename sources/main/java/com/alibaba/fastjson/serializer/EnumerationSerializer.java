package com.alibaba.fastjson.serializer;

import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class EnumerationSerializer implements ObjectSerializer {
    public static EnumerationSerializer instance = new EnumerationSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        JSONSerializer jSONSerializer2;
        Throwable th;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        int i7 = 0;
        Type type2 = (serializeWriter.isEnabled(SerializerFeature.WriteClassName) && (type instanceof ParameterizedType)) ? ((ParameterizedType) type).getActualTypeArguments()[0] : null;
        Enumeration enumeration = (Enumeration) obj;
        SerialContext serialContext = jSONSerializer.context;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            serializeWriter.append('[');
            while (enumeration.hasMoreElements()) {
                Object nextElement = enumeration.nextElement();
                int i8 = i7 + 1;
                if (i7 != 0) {
                    try {
                        serializeWriter.append(StringUtil.COMMA);
                    } catch (Throwable th2) {
                        th = th2;
                        jSONSerializer2 = jSONSerializer;
                        jSONSerializer2.context = serialContext;
                        throw th;
                    }
                }
                if (nextElement == null) {
                    serializeWriter.writeNull();
                    jSONSerializer2 = jSONSerializer;
                } else {
                    jSONSerializer2 = jSONSerializer;
                    try {
                        jSONSerializer.getObjectWriter(nextElement.getClass()).write(jSONSerializer2, nextElement, Integer.valueOf(i7), type2, 0);
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        jSONSerializer2.context = serialContext;
                        throw th;
                    }
                }
                i7 = i8;
                jSONSerializer = jSONSerializer2;
            }
            jSONSerializer2 = jSONSerializer;
            serializeWriter.append(']');
            jSONSerializer2.context = serialContext;
        } catch (Throwable th4) {
            th = th4;
            jSONSerializer2 = jSONSerializer;
        }
    }
}
