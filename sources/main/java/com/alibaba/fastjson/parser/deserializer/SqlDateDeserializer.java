package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONScanner;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SqlDateDeserializer extends AbstractDateDeserializer implements ObjectDeserializer {
    public static final SqlDateDeserializer instance = new SqlDateDeserializer();
    public static final SqlDateDeserializer instance_timestamp = new SqlDateDeserializer(true);
    private boolean timestamp = false;

    public SqlDateDeserializer() {
    }

    protected <T> T castTimestamp(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        long parseLong;
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof Date) {
            return (T) new Timestamp(((Date) obj2).getTime());
        }
        if (obj2 instanceof Number) {
            return (T) new Timestamp(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new JSONException("parse error");
        }
        String str = (String) obj2;
        if (str.length() == 0) {
            return null;
        }
        JSONScanner jSONScanner = new JSONScanner(str);
        try {
            if (jSONScanner.scanISO8601DateIfMatch()) {
                parseLong = jSONScanner.getCalendar().getTimeInMillis();
            } else {
                try {
                    T t5 = (T) new Timestamp(defaultJSONParser.getDateFormat().parse(str).getTime());
                    jSONScanner.close();
                    return t5;
                } catch (ParseException unused) {
                    parseLong = Long.parseLong(str);
                }
            }
            jSONScanner.close();
            return (T) new Timestamp(parseLong);
        } catch (Throwable th) {
            jSONScanner.close();
            throw th;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer
    protected <T> T cast(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        long parseLong;
        if (this.timestamp) {
            return (T) castTimestamp(defaultJSONParser, type, obj, obj2);
        }
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof Date) {
            return (T) new java.sql.Date(((Date) obj2).getTime());
        }
        if (obj2 instanceof Number) {
            return (T) new java.sql.Date(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new JSONException("parse error : " + obj2);
        }
        String str = (String) obj2;
        if (str.length() == 0) {
            return null;
        }
        JSONScanner jSONScanner = new JSONScanner(str);
        try {
            if (jSONScanner.scanISO8601DateIfMatch()) {
                parseLong = jSONScanner.getCalendar().getTimeInMillis();
            } else {
                try {
                    T t5 = (T) new java.sql.Date(defaultJSONParser.getDateFormat().parse(str).getTime());
                    jSONScanner.close();
                    return t5;
                } catch (ParseException unused) {
                    parseLong = Long.parseLong(str);
                }
            }
            jSONScanner.close();
            return (T) new java.sql.Date(parseLong);
        } catch (Throwable th) {
            jSONScanner.close();
            throw th;
        }
    }

    public SqlDateDeserializer(boolean z5) {
    }
}
