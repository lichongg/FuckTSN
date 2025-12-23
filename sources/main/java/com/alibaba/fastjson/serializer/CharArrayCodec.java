package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CharArrayCodec implements ObjectDeserializer {
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T deserialze(DefaultJSONParser defaultJSONParser) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            return (T) stringVal.toCharArray();
        }
        if (jSONLexer.token() == 2) {
            Number integerValue = jSONLexer.integerValue();
            jSONLexer.nextToken(16);
            return (T) integerValue.toString().toCharArray();
        }
        Object parse = defaultJSONParser.parse();
        if (parse instanceof String) {
            return (T) ((String) parse).toCharArray();
        }
        if (!(parse instanceof Collection)) {
            if (parse == null) {
                return null;
            }
            return (T) JSON.toJSONString(parse).toCharArray();
        }
        Collection collection = (Collection) parse;
        for (Object obj : collection) {
            if ((obj instanceof String) && ((String) obj).length() != 1) {
                throw new JSONException("can not cast to char[]");
            }
        }
        char[] cArr = new char[collection.size()];
        Iterator it = collection.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            cArr[i6] = ((String) it.next()).charAt(0);
            i6++;
        }
        return cArr;
    }
}
