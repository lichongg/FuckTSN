package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import java.lang.reflect.Type;
import java.sql.Time;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TimeDeserializer implements ObjectDeserializer {
    public static final TimeDeserializer instance = new TimeDeserializer();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        long parseLong;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 16) {
            jSONLexer.nextToken(4);
            if (jSONLexer.token() != 4) {
                throw new JSONException("syntax error");
            }
            jSONLexer.nextTokenWithColon(2);
            if (jSONLexer.token() != 2) {
                throw new JSONException("syntax error");
            }
            long longValue = jSONLexer.longValue();
            jSONLexer.nextToken(13);
            if (jSONLexer.token() != 13) {
                throw new JSONException("syntax error");
            }
            jSONLexer.nextToken(16);
            return (T) new Time(longValue);
        }
        T t5 = (T) defaultJSONParser.parse();
        if (t5 == 0) {
            return null;
        }
        if (t5 instanceof Time) {
            return t5;
        }
        if (t5 instanceof Number) {
            return (T) new Time(((Number) t5).longValue());
        }
        if (!(t5 instanceof String)) {
            throw new JSONException("parse error");
        }
        String str = (String) t5;
        if (str.length() == 0) {
            return null;
        }
        JSONScanner jSONScanner = new JSONScanner(str);
        if (jSONScanner.scanISO8601DateIfMatch()) {
            parseLong = jSONScanner.getCalendar().getTimeInMillis();
        } else {
            for (int i6 = 0; i6 < str.length(); i6++) {
                char charAt = str.charAt(i6);
                if (charAt < '0' || charAt > '9') {
                    jSONScanner.close();
                    return (T) Time.valueOf(str);
                }
            }
            parseLong = Long.parseLong(str);
        }
        jSONScanner.close();
        return (T) new Time(parseLong);
    }
}
