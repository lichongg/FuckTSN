package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CollectionCodec implements ObjectSerializer, ObjectDeserializer {
    public static final CollectionCodec instance = new CollectionCodec();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, com.alibaba.fastjson.JSONArray, java.util.Collection] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (defaultJSONParser.lexer.token() == 8) {
            defaultJSONParser.lexer.nextToken(16);
            return null;
        }
        if (type == JSONArray.class) {
            ?? r42 = (T) new JSONArray();
            defaultJSONParser.parseArray((Collection) r42);
            return r42;
        }
        ?? r02 = (T) TypeUtils.createCollection(type);
        defaultJSONParser.parseArray(TypeUtils.getCollectionItemType(type), r02, obj);
        return r02;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 14;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        JSONSerializer jSONSerializer2;
        Throwable th;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        SerializerFeature serializerFeature = SerializerFeature.WriteClassName;
        Type collectionItemType = serializeWriter.isEnabled(serializerFeature) ? TypeUtils.getCollectionItemType(type) : null;
        Collection collection = (Collection) obj;
        SerialContext serialContext = jSONSerializer.context;
        int i7 = 0;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        if (serializeWriter.isEnabled(serializerFeature)) {
            if (HashSet.class == collection.getClass()) {
                serializeWriter.append((CharSequence) "Set");
            } else if (TreeSet.class == collection.getClass()) {
                serializeWriter.append((CharSequence) "TreeSet");
            }
        }
        try {
            serializeWriter.append('[');
            for (Object obj3 : collection) {
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
                if (obj3 == null) {
                    serializeWriter.writeNull();
                } else {
                    Class<?> cls = obj3.getClass();
                    if (cls == Integer.class) {
                        serializeWriter.writeInt(((Integer) obj3).intValue());
                    } else if (cls == Long.class) {
                        serializeWriter.writeLong(((Long) obj3).longValue());
                        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
                            serializeWriter.write(76);
                        }
                    } else {
                        jSONSerializer2 = jSONSerializer;
                        try {
                            jSONSerializer.getObjectWriter(cls).write(jSONSerializer2, obj3, Integer.valueOf(i7), collectionItemType, 0);
                            i7 = i8;
                            jSONSerializer = jSONSerializer2;
                        } catch (Throwable th3) {
                            th = th3;
                            th = th;
                            jSONSerializer2.context = serialContext;
                            throw th;
                        }
                    }
                }
                jSONSerializer2 = jSONSerializer;
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
