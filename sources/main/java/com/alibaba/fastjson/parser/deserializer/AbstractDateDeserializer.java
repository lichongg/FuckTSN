package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class AbstractDateDeserializer extends ContextObjectDeserializer implements ObjectDeserializer {
    protected abstract <T> T cast(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2);

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null, 0);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str, int i6) {
        Object parse;
        SimpleDateFormat simpleDateFormat;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 2) {
            parse = Long.valueOf(jSONLexer.longValue());
            jSONLexer.nextToken(16);
        } else {
            Date date = null;
            if (jSONLexer.token() == 4) {
                String stringVal = jSONLexer.stringVal();
                if (str != null) {
                    try {
                        simpleDateFormat = new SimpleDateFormat(str, JSON.defaultLocale);
                    } catch (IllegalArgumentException unused) {
                        if (str.equals("yyyy-MM-ddTHH:mm:ss.SSS")) {
                            str = "yyyy-MM-dd'T'HH:mm:ss.SSS";
                            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
                        } else if (str.equals("yyyy-MM-ddTHH:mm:ss")) {
                            str = "yyyy-MM-dd'T'HH:mm:ss";
                            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                        } else {
                            simpleDateFormat = null;
                        }
                    }
                    try {
                        date = simpleDateFormat.parse(stringVal);
                    } catch (ParseException unused2) {
                        if (str.equals("yyyy-MM-dd'T'HH:mm:ss.SSS") && stringVal.length() == 19) {
                            try {
                                date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(stringVal);
                            } catch (ParseException unused3) {
                            }
                        }
                    }
                }
                if (date == null) {
                    jSONLexer.nextToken(16);
                    Object obj2 = stringVal;
                    if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                        JSONScanner jSONScanner = new JSONScanner(stringVal);
                        Object obj3 = stringVal;
                        if (jSONScanner.scanISO8601DateIfMatch()) {
                            obj3 = jSONScanner.getCalendar().getTime();
                        }
                        jSONScanner.close();
                        obj2 = obj3;
                    }
                    parse = obj2;
                }
                parse = date;
            } else if (jSONLexer.token() == 8) {
                jSONLexer.nextToken();
                parse = date;
            } else if (jSONLexer.token() == 12) {
                jSONLexer.nextToken();
                if (jSONLexer.token() != 4) {
                    throw new JSONException("syntax error");
                }
                if (JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal())) {
                    jSONLexer.nextToken();
                    defaultJSONParser.accept(17);
                    Class<?> checkAutoType = defaultJSONParser.getConfig().checkAutoType(jSONLexer.stringVal(), null);
                    if (checkAutoType != null) {
                        type = checkAutoType;
                    }
                    defaultJSONParser.accept(4);
                    defaultJSONParser.accept(16);
                }
                jSONLexer.nextTokenWithColon(2);
                if (jSONLexer.token() != 2) {
                    throw new JSONException("syntax error : " + jSONLexer.tokenName());
                }
                long longValue = jSONLexer.longValue();
                jSONLexer.nextToken();
                parse = Long.valueOf(longValue);
                defaultJSONParser.accept(13);
            } else if (defaultJSONParser.getResolveStatus() == 2) {
                defaultJSONParser.setResolveStatus(0);
                defaultJSONParser.accept(16);
                if (jSONLexer.token() != 4) {
                    throw new JSONException("syntax error");
                }
                if (!"val".equals(jSONLexer.stringVal())) {
                    throw new JSONException("syntax error");
                }
                jSONLexer.nextToken();
                defaultJSONParser.accept(17);
                parse = defaultJSONParser.parse();
                defaultJSONParser.accept(13);
            } else {
                parse = defaultJSONParser.parse();
            }
        }
        return (T) cast(defaultJSONParser, type, obj, parse);
    }
}
