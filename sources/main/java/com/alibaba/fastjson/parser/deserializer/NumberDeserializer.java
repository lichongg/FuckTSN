package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class NumberDeserializer implements ObjectDeserializer {
    public static final NumberDeserializer instance = new NumberDeserializer();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Number, java.lang.Object, java.math.BigDecimal] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i6 = jSONLexer.token();
        Class cls = Byte.TYPE;
        Class cls2 = Short.TYPE;
        Class cls3 = Double.TYPE;
        if (i6 != 2) {
            if (jSONLexer.token() != 3) {
                Object parse = defaultJSONParser.parse();
                if (parse == null) {
                    return null;
                }
                return (type == cls3 || type == Double.class) ? (T) TypeUtils.castToDouble(parse) : (type == cls2 || type == Short.class) ? (T) TypeUtils.castToShort(parse) : (type == cls || type == Byte.class) ? (T) TypeUtils.castToByte(parse) : (T) TypeUtils.castToBigDecimal(parse);
            }
            if (type == cls3 || type == Double.class) {
                String numberString = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Double.valueOf(Double.parseDouble(numberString));
            }
            ?? r12 = (T) jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            if (type != cls2 && type != Short.class) {
                return (type == cls || type == Byte.class) ? (T) Byte.valueOf(r12.byteValue()) : r12;
            }
            if (r12.compareTo(BigDecimal.valueOf(32767L)) <= 0 && r12.compareTo(BigDecimal.valueOf(-32768L)) >= 0) {
                return (T) Short.valueOf(r12.shortValue());
            }
            throw new JSONException("short overflow : " + ((Object) r12));
        }
        if (type == cls3 || type == Double.class) {
            String numberString2 = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return (T) Double.valueOf(Double.parseDouble(numberString2));
        }
        long longValue = jSONLexer.longValue();
        jSONLexer.nextToken(16);
        if (type == cls2 || type == Short.class) {
            if (longValue <= 32767 && longValue >= -32768) {
                return (T) Short.valueOf((short) longValue);
            }
            throw new JSONException("short overflow : " + longValue);
        }
        if (type != cls && type != Byte.class) {
            return (longValue < -2147483648L || longValue > 2147483647L) ? (T) Long.valueOf(longValue) : (T) Integer.valueOf((int) longValue);
        }
        if (longValue <= 127 && longValue >= -128) {
            return (T) Byte.valueOf((byte) longValue);
        }
        throw new JSONException("short overflow : " + longValue);
    }
}
