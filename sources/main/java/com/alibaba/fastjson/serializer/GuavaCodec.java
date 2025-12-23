package com.alibaba.fastjson.serializer;

import com.google.common.collect.Multimap;
import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GuavaCodec implements ObjectSerializer {
    public static GuavaCodec instance = new GuavaCodec();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj instanceof Multimap) {
            jSONSerializer.write(((Multimap) obj).asMap());
        }
    }
}
