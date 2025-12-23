package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.TypeUtils;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class ListSerializer implements ObjectSerializer {
    public static final ListSerializer instance = new ListSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        SerialContext serialContext;
        Type type2;
        JSONSerializer jSONSerializer2;
        SerialContext serialContext2;
        Object obj3;
        Type type3;
        JSONSerializer jSONSerializer3 = jSONSerializer;
        boolean isEnabled = jSONSerializer3.out.isEnabled(SerializerFeature.WriteClassName);
        SerializeWriter serializeWriter = jSONSerializer3.out;
        Type collectionItemType = isEnabled ? TypeUtils.getCollectionItemType(type) : null;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        List list = (List) obj;
        if (list.size() == 0) {
            serializeWriter.append((CharSequence) "[]");
            return;
        }
        SerialContext serialContext3 = jSONSerializer3.context;
        Object obj4 = obj2;
        jSONSerializer3.setContext(serialContext3, obj, obj4, 0);
        try {
            try {
                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                    try {
                        serializeWriter.append('[');
                        jSONSerializer3.incrementIndent();
                        int i7 = 0;
                        for (Object obj5 : list) {
                            if (i7 != 0) {
                                serializeWriter.append(StringUtil.COMMA);
                            }
                            jSONSerializer3.println();
                            if (obj5 == null) {
                                type2 = collectionItemType;
                                jSONSerializer2 = jSONSerializer3;
                                serialContext = serialContext3;
                                jSONSerializer2.out.writeNull();
                            } else if (jSONSerializer3.containsReference(obj5)) {
                                jSONSerializer3.writeReference(obj5);
                                type2 = collectionItemType;
                                jSONSerializer2 = jSONSerializer3;
                                serialContext = serialContext3;
                            } else {
                                ObjectSerializer objectWriter = jSONSerializer3.getObjectWriter(obj5.getClass());
                                serialContext = serialContext3;
                                try {
                                    jSONSerializer3.context = new SerialContext(serialContext3, obj, obj4, 0, 0);
                                    Type type4 = collectionItemType;
                                    objectWriter.write(jSONSerializer3, obj5, Integer.valueOf(i7), type4, 0);
                                    jSONSerializer2 = jSONSerializer3;
                                    type2 = type4;
                                } catch (Throwable th) {
                                    th = th;
                                }
                            }
                            i7++;
                            obj4 = obj2;
                            jSONSerializer3 = jSONSerializer2;
                            collectionItemType = type2;
                            serialContext3 = serialContext;
                        }
                        JSONSerializer jSONSerializer4 = jSONSerializer3;
                        SerialContext serialContext4 = serialContext3;
                        jSONSerializer4.decrementIdent();
                        jSONSerializer4.println();
                        serializeWriter.append(']');
                        jSONSerializer4.context = serialContext4;
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        serialContext = serialContext3;
                        jSONSerializer3.context = serialContext;
                        throw th;
                    }
                }
                Type type5 = collectionItemType;
                JSONSerializer jSONSerializer5 = jSONSerializer3;
                serialContext = serialContext3;
                serializeWriter.append('[');
                int size = list.size();
                int i8 = 0;
                while (i8 < size) {
                    Object obj6 = list.get(i8);
                    if (i8 != 0) {
                        serializeWriter.append(StringUtil.COMMA);
                    }
                    if (obj6 == null) {
                        serializeWriter.append((CharSequence) "null");
                    } else {
                        Class<?> cls = obj6.getClass();
                        if (cls == Integer.class) {
                            serializeWriter.writeInt(((Integer) obj6).intValue());
                        } else if (cls == Long.class) {
                            long longValue = ((Long) obj6).longValue();
                            if (isEnabled) {
                                serializeWriter.writeLong(longValue);
                                serializeWriter.write(76);
                            } else {
                                serializeWriter.writeLong(longValue);
                            }
                        } else {
                            if (serializeWriter.disableCircularReferenceDetect) {
                                serialContext2 = serialContext;
                                obj3 = obj6;
                            } else {
                                try {
                                    serialContext2 = serialContext;
                                    obj3 = obj6;
                                } catch (Throwable th3) {
                                    th = th3;
                                    jSONSerializer3 = jSONSerializer5;
                                    jSONSerializer3.context = serialContext;
                                    throw th;
                                }
                                try {
                                    jSONSerializer5.context = new SerialContext(serialContext2, obj, obj2, 0, 0);
                                } catch (Throwable th4) {
                                    th = th4;
                                    serialContext = serialContext2;
                                    jSONSerializer3 = jSONSerializer5;
                                    jSONSerializer3.context = serialContext;
                                    throw th;
                                }
                            }
                            if (jSONSerializer5.containsReference(obj3)) {
                                jSONSerializer5.writeReference(obj3);
                                serialContext = serialContext2;
                            } else {
                                ObjectSerializer objectWriter2 = jSONSerializer5.getObjectWriter(obj3.getClass());
                                type3 = type5;
                                Object obj7 = obj3;
                                serialContext = serialContext2;
                                jSONSerializer3 = jSONSerializer5;
                                try {
                                    objectWriter2.write(jSONSerializer3, obj7, Integer.valueOf(i8), type3, 0);
                                    i8++;
                                    jSONSerializer5 = jSONSerializer3;
                                    type5 = type3;
                                } catch (Throwable th5) {
                                    th = th5;
                                }
                            }
                        }
                    }
                    jSONSerializer3 = jSONSerializer5;
                    type3 = type5;
                    i8++;
                    jSONSerializer5 = jSONSerializer3;
                    type5 = type3;
                }
                jSONSerializer3 = jSONSerializer5;
                serializeWriter.append(']');
                jSONSerializer3.context = serialContext;
                return;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
        }
        jSONSerializer3.context = serialContext;
        throw th;
    }
}
