package com.alibaba.fastjson.serializer;

import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ArraySerializer implements ObjectSerializer {
    private final ObjectSerializer compObjectSerializer;
    private final Class<?> componentType;

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        JSONSerializer jSONSerializer2;
        Throwable th;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        Object[] objArr = (Object[]) obj;
        int length = objArr.length;
        SerialContext serialContext = jSONSerializer.context;
        int i7 = 0;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            serializeWriter.append('[');
            while (i7 < length) {
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
                Object obj3 = objArr[i7];
                if (obj3 == null) {
                    if (serializeWriter.isEnabled(SerializerFeature.WriteNullStringAsEmpty) && (obj instanceof String[])) {
                        serializeWriter.writeString("");
                    } else {
                        serializeWriter.append((CharSequence) "null");
                    }
                    jSONSerializer2 = jSONSerializer;
                } else if (obj3.getClass() == this.componentType) {
                    jSONSerializer2 = jSONSerializer;
                    try {
                        this.compObjectSerializer.write(jSONSerializer2, obj3, Integer.valueOf(i7), null, 0);
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        jSONSerializer2.context = serialContext;
                        throw th;
                    }
                } else {
                    jSONSerializer2 = jSONSerializer;
                    jSONSerializer2.getObjectWriter(obj3.getClass()).write(jSONSerializer2, obj3, Integer.valueOf(i7), null, 0);
                }
                i7++;
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

    public ArraySerializer(Class<?> cls, ObjectSerializer objectSerializer) {
        this.componentType = cls;
        this.compObjectSerializer = objectSerializer;
    }
}
