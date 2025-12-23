package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONReaderScanner;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class JSONReader implements Closeable {
    private JSONStreamContext context;
    private final DefaultJSONParser parser;

    public JSONReader(Reader reader) {
        this(reader, new Feature[0]);
    }

    public <T> T readObject(TypeReference<T> typeReference) {
        return (T) readObject(typeReference.getType());
    }

    public JSONReader(Reader reader, Feature... featureArr) {
        this(new JSONReaderScanner(reader));
        for (Feature feature : featureArr) {
            config(feature, true);
        }
    }

    private void endStructure() {
        int i6;
        JSONStreamContext jSONStreamContext = this.context.parent;
        this.context = jSONStreamContext;
        if (jSONStreamContext == null) {
            return;
        }
        switch (jSONStreamContext.state) {
            case 1001:
            case 1003:
                i6 = 1002;
                break;
            case 1002:
                i6 = 1003;
                break;
            case 1004:
                i6 = 1005;
                break;
            default:
                i6 = -1;
                break;
        }
        if (i6 != -1) {
            jSONStreamContext.state = i6;
        }
    }

    private void readAfter() {
        JSONStreamContext jSONStreamContext = this.context;
        int i6 = jSONStreamContext.state;
        int i7 = 1002;
        switch (i6) {
            case 1001:
            case 1003:
                break;
            case 1002:
                i7 = 1003;
                break;
            case 1004:
                i7 = 1005;
                break;
            case 1005:
                i7 = -1;
                break;
            default:
                throw new JSONException("illegal state : " + i6);
        }
        if (i7 != -1) {
            jSONStreamContext.state = i7;
        }
    }

    private void readBefore() {
        int i6 = this.context.state;
        switch (i6) {
            case 1001:
            case 1004:
                return;
            case 1002:
                this.parser.accept(17);
                return;
            case 1003:
                this.parser.accept(16, 18);
                return;
            case 1005:
                this.parser.accept(16);
                return;
            default:
                throw new JSONException("illegal state : " + i6);
        }
    }

    private void startStructure() {
        switch (this.context.state) {
            case 1001:
            case 1004:
                return;
            case 1002:
                this.parser.accept(17);
                return;
            case 1003:
            case 1005:
                this.parser.accept(16);
                return;
            default:
                throw new JSONException("illegal state : " + this.context.state);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.parser.close();
    }

    public void config(Feature feature, boolean z5) {
        this.parser.config(feature, z5);
    }

    public void endArray() {
        this.parser.accept(15);
        endStructure();
    }

    public void endObject() {
        this.parser.accept(13);
        endStructure();
    }

    public Locale getLocal() {
        return this.parser.lexer.getLocale();
    }

    public TimeZone getTimzeZone() {
        return this.parser.lexer.getTimeZone();
    }

    public boolean hasNext() {
        if (this.context == null) {
            throw new JSONException("context is null");
        }
        int i6 = this.parser.lexer.token();
        int i7 = this.context.state;
        switch (i7) {
            case 1001:
            case 1003:
                return i6 != 13;
            case 1002:
            default:
                throw new JSONException("illegal state : " + i7);
            case 1004:
            case 1005:
                return i6 != 15;
        }
    }

    public int peek() {
        return this.parser.lexer.token();
    }

    public Integer readInteger() {
        Object parse;
        if (this.context == null) {
            parse = this.parser.parse();
        } else {
            readBefore();
            parse = this.parser.parse();
            readAfter();
        }
        return TypeUtils.castToInt(parse);
    }

    public Long readLong() {
        Object parse;
        if (this.context == null) {
            parse = this.parser.parse();
        } else {
            readBefore();
            parse = this.parser.parse();
            readAfter();
        }
        return TypeUtils.castToLong(parse);
    }

    public <T> T readObject(Type type) {
        if (this.context == null) {
            return (T) this.parser.parseObject(type);
        }
        readBefore();
        T t5 = (T) this.parser.parseObject(type);
        readAfter();
        return t5;
    }

    public String readString() {
        Object parse;
        if (this.context == null) {
            parse = this.parser.parse();
        } else {
            readBefore();
            JSONLexer jSONLexer = this.parser.lexer;
            if (this.context.state == 1001 && jSONLexer.token() == 18) {
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextToken();
                parse = stringVal;
            } else {
                parse = this.parser.parse();
            }
            readAfter();
        }
        return TypeUtils.castToString(parse);
    }

    public void setLocale(Locale locale) {
        this.parser.lexer.setLocale(locale);
    }

    public void setTimzeZone(TimeZone timeZone) {
        this.parser.lexer.setTimeZone(timeZone);
    }

    public void startArray() {
        if (this.context == null) {
            this.context = new JSONStreamContext(null, 1004);
        } else {
            startStructure();
            this.context = new JSONStreamContext(this.context, 1004);
        }
        this.parser.accept(14);
    }

    public void startObject() {
        if (this.context == null) {
            this.context = new JSONStreamContext(null, 1001);
        } else {
            startStructure();
            this.context = new JSONStreamContext(this.context, 1001);
        }
        this.parser.accept(12, 18);
    }

    public JSONReader(JSONLexer jSONLexer) {
        this(new DefaultJSONParser(jSONLexer));
    }

    public JSONReader(DefaultJSONParser defaultJSONParser) {
        this.parser = defaultJSONParser;
    }

    public <T> T readObject(Class<T> cls) {
        if (this.context == null) {
            return (T) this.parser.parseObject((Class) cls);
        }
        readBefore();
        T t5 = (T) this.parser.parseObject((Class) cls);
        readAfter();
        return t5;
    }

    public void readObject(Object obj) {
        if (this.context == null) {
            this.parser.parseObject(obj);
            return;
        }
        readBefore();
        this.parser.parseObject(obj);
        readAfter();
    }

    public Object readObject() {
        Object parseKey;
        if (this.context == null) {
            return this.parser.parse();
        }
        readBefore();
        int i6 = this.context.state;
        if (i6 != 1001 && i6 != 1003) {
            parseKey = this.parser.parse();
        } else {
            parseKey = this.parser.parseKey();
        }
        readAfter();
        return parseKey;
    }

    public Object readObject(Map map) {
        if (this.context == null) {
            return this.parser.parseObject(map);
        }
        readBefore();
        Object parseObject = this.parser.parseObject(map);
        readAfter();
        return parseObject;
    }
}
