package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class OptionalCodec implements ObjectSerializer, ObjectDeserializer {
    public static OptionalCodec instance = new OptionalCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        boolean isPresent;
        long asLong;
        boolean isPresent2;
        int asInt;
        boolean isPresent3;
        double asDouble;
        boolean isPresent4;
        if (obj == null) {
            jSONSerializer.writeNull();
            return;
        }
        if (r0.a(obj)) {
            Optional a6 = y0.a(obj);
            isPresent4 = a6.isPresent();
            jSONSerializer.write(isPresent4 ? a6.get() : null);
            return;
        }
        if (c1.a(obj)) {
            OptionalDouble a7 = d1.a(obj);
            isPresent3 = a7.isPresent();
            if (!isPresent3) {
                jSONSerializer.writeNull();
                return;
            } else {
                asDouble = a7.getAsDouble();
                jSONSerializer.write(Double.valueOf(asDouble));
                return;
            }
        }
        if (g1.a(obj)) {
            OptionalInt a8 = h1.a(obj);
            isPresent2 = a8.isPresent();
            if (!isPresent2) {
                jSONSerializer.writeNull();
                return;
            } else {
                asInt = a8.getAsInt();
                jSONSerializer.out.writeInt(asInt);
                return;
            }
        }
        if (!u0.a(obj)) {
            throw new JSONException("not support optional : " + obj.getClass());
        }
        OptionalLong a9 = v0.a(obj);
        isPresent = a9.isPresent();
        if (!isPresent) {
            jSONSerializer.writeNull();
        } else {
            asLong = a9.getAsLong();
            jSONSerializer.out.writeLong(asLong);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object of;
        Object empty;
        Object of2;
        Object empty2;
        Object of3;
        Object empty3;
        Object of4;
        Object empty4;
        if (type == p0.a()) {
            Integer castToInt = TypeUtils.castToInt(defaultJSONParser.parseObject((Class) Integer.class));
            if (castToInt == null) {
                empty4 = OptionalInt.empty();
                return (T) empty4;
            }
            of4 = OptionalInt.of(castToInt.intValue());
            return (T) of4;
        }
        if (type == k1.a()) {
            Long castToLong = TypeUtils.castToLong(defaultJSONParser.parseObject((Class) Long.class));
            if (castToLong == null) {
                empty3 = OptionalLong.empty();
                return (T) empty3;
            }
            of3 = OptionalLong.of(castToLong.longValue());
            return (T) of3;
        }
        if (type == n1.a()) {
            Double castToDouble = TypeUtils.castToDouble(defaultJSONParser.parseObject((Class) Double.class));
            if (castToDouble == null) {
                empty2 = OptionalDouble.empty();
                return (T) empty2;
            }
            of2 = OptionalDouble.of(castToDouble.doubleValue());
            return (T) of2;
        }
        Object parseObject = defaultJSONParser.parseObject(TypeUtils.unwrapOptional(type));
        if (parseObject == null) {
            empty = Optional.empty();
            return (T) empty;
        }
        of = Optional.of(parseObject);
        return (T) of;
    }
}
