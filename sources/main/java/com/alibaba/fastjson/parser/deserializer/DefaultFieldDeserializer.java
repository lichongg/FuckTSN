package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DefaultFieldDeserializer extends FieldDeserializer {
    protected ObjectDeserializer fieldValueDeserilizer;

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public int getFastMatchToken() {
        ObjectDeserializer objectDeserializer = this.fieldValueDeserilizer;
        if (objectDeserializer != null) {
            return objectDeserializer.getFastMatchToken();
        }
        return 2;
    }

    public ObjectDeserializer getFieldValueDeserilizer(ParserConfig parserConfig) {
        if (this.fieldValueDeserilizer == null) {
            JSONField annotation = this.fieldInfo.getAnnotation();
            if (annotation == null || annotation.deserializeUsing() == Void.class) {
                FieldInfo fieldInfo = this.fieldInfo;
                this.fieldValueDeserilizer = parserConfig.getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
            } else {
                try {
                    this.fieldValueDeserilizer = (ObjectDeserializer) annotation.deserializeUsing().newInstance();
                } catch (Exception e6) {
                    throw new JSONException("create deserializeUsing ObjectDeserializer error", e6);
                }
            }
        }
        return this.fieldValueDeserilizer;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        DefaultJSONParser defaultJSONParser2;
        Object deserialze;
        FieldInfo fieldInfo;
        int i6;
        if (this.fieldValueDeserilizer == null) {
            getFieldValueDeserilizer(defaultJSONParser.getConfig());
        }
        ObjectDeserializer objectDeserializer = this.fieldValueDeserilizer;
        Type type2 = this.fieldInfo.fieldType;
        if (type instanceof ParameterizedType) {
            ParseContext context = defaultJSONParser.getContext();
            if (context != null) {
                context.type = type;
            }
            type2 = FieldInfo.getFieldType(this.clazz, type, type2);
            objectDeserializer = defaultJSONParser.getConfig().getDeserializer(type2);
        }
        Type type3 = type2;
        if (!(objectDeserializer instanceof JavaBeanDeserializer) || (i6 = (fieldInfo = this.fieldInfo).parserFeatures) == 0) {
            FieldInfo fieldInfo2 = this.fieldInfo;
            String str = fieldInfo2.format;
            if (str == null || !(objectDeserializer instanceof ContextObjectDeserializer)) {
                defaultJSONParser2 = defaultJSONParser;
                deserialze = objectDeserializer.deserialze(defaultJSONParser2, type3, fieldInfo2.name);
            } else {
                defaultJSONParser2 = defaultJSONParser;
                deserialze = ((ContextObjectDeserializer) objectDeserializer).deserialze(defaultJSONParser2, type3, fieldInfo2.name, str, fieldInfo2.parserFeatures);
            }
        } else {
            deserialze = ((JavaBeanDeserializer) objectDeserializer).deserialze(defaultJSONParser, type3, fieldInfo.name, i6);
            defaultJSONParser2 = defaultJSONParser;
        }
        if ((deserialze instanceof byte[]) && ("gzip".equals(this.fieldInfo.format) || "gzip,base64".equals(this.fieldInfo.format))) {
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream((byte[]) deserialze));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    byte[] bArr = new byte[1024];
                    int read = gZIPInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else if (read > 0) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                }
                deserialze = byteArrayOutputStream.toByteArray();
            } catch (IOException e6) {
                throw new JSONException("unzip bytes error.", e6);
            }
        }
        if (defaultJSONParser2.getResolveStatus() == 1) {
            DefaultJSONParser.ResolveTask lastResolveTask = defaultJSONParser2.getLastResolveTask();
            lastResolveTask.fieldDeserializer = this;
            lastResolveTask.ownerContext = defaultJSONParser2.getContext();
            defaultJSONParser2.setResolveStatus(0);
            return;
        }
        if (obj == null) {
            map.put(this.fieldInfo.name, deserialze);
        } else {
            setValue(obj, deserialze);
        }
    }

    public void parseFieldUnwrapped(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        throw new JSONException("TODO");
    }

    public DefaultFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo);
    }
}
