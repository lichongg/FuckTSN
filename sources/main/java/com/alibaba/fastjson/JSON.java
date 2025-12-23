package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class JSON implements JSONStreamAware, JSONAware {
    public static int DEFAULT_GENERATE_FEATURE = 0;
    public static final String VERSION = "1.2.33";
    private static final ThreadLocal<byte[]> bytesLocal;
    private static final ThreadLocal<char[]> charsLocal;
    public static TimeZone defaultTimeZone = TimeZone.getDefault();
    public static Locale defaultLocale = Locale.getDefault();
    public static String DEFAULT_TYPE_KEY = "@type";
    static final SerializeFilter[] emptyFilters = new SerializeFilter[0];
    public static String DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static int DEFAULT_PARSER_FEATURE = ((((((Feature.AutoCloseSource.getMask() | Feature.InternFieldNames.getMask()) | Feature.UseBigDecimal.getMask()) | Feature.AllowUnQuotedFieldNames.getMask()) | Feature.AllowSingleQuotes.getMask()) | Feature.AllowArbitraryCommas.getMask()) | Feature.SortFeidFastMatch.getMask()) | Feature.IgnoreNotMatch.getMask();

    public static Object parse(String str) {
        return parse(str, DEFAULT_PARSER_FEATURE);
    }

    public static JSONArray parseArray(String str) {
        JSONArray jSONArray = null;
        if (str == null) {
            return null;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, ParserConfig.getGlobalInstance());
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
        } else if (jSONLexer.token() != 20) {
            jSONArray = new JSONArray();
            defaultJSONParser.parseArray(jSONArray);
            defaultJSONParser.handleResovleTask(jSONArray);
        }
        defaultJSONParser.close();
        return jSONArray;
    }

    public static JSONObject parseObject(String str, Feature... featureArr) {
        return (JSONObject) parse(str, featureArr);
    }

    public static Object toJSON(Object obj) {
        return toJSON(obj, SerializeConfig.globalInstance);
    }

    public static byte[] toJSONBytes(Object obj, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj) {
        return toJSONString(obj, emptyFilters, new SerializerFeature[0]);
    }

    public static <T> T toJavaObject(JSON json, Class<T> cls) {
        return (T) TypeUtils.cast((Object) json, (Class) cls, ParserConfig.getGlobalInstance());
    }

    public static void writeJSONString(Writer writer, Object obj, SerializerFeature... serializerFeatureArr) {
        writeJSONString(writer, obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    private static byte[] allocateBytes(int i6) {
        ThreadLocal<byte[]> threadLocal = bytesLocal;
        byte[] bArr = threadLocal.get();
        if (bArr != null) {
            return bArr.length < i6 ? new byte[i6] : bArr;
        }
        if (i6 > 65536) {
            return new byte[i6];
        }
        byte[] bArr2 = new byte[65536];
        threadLocal.set(bArr2);
        return bArr2;
    }

    private static char[] allocateChars(int i6) {
        ThreadLocal<char[]> threadLocal = charsLocal;
        char[] cArr = threadLocal.get();
        if (cArr != null) {
            return cArr.length < i6 ? new char[i6] : cArr;
        }
        if (i6 > 65536) {
            return new char[i6];
        }
        char[] cArr2 = new char[65536];
        threadLocal.set(cArr2);
        return cArr2;
    }

    public static Object parse(String str, int i6) {
        if (str == null) {
            return null;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, ParserConfig.getGlobalInstance(), i6);
        Object parse = defaultJSONParser.parse();
        defaultJSONParser.handleResovleTask(parse);
        defaultJSONParser.close();
        return parse;
    }

    public static JSONObject parseObject(String str) {
        Object parse = parse(str);
        return parse instanceof JSONObject ? (JSONObject) parse : (JSONObject) toJSON(parse);
    }

    public static void setDefaultTypeKey(String str) {
        DEFAULT_TYPE_KEY = str;
        ParserConfig.global.symbolTable.addSymbol(str, 0, str.length(), str.hashCode());
    }

    public static Object toJSON(Object obj, ParserConfig parserConfig) {
        return toJSON(obj, SerializeConfig.globalInstance);
    }

    public static byte[] toJSONBytes(Object obj, int i6, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, SerializeConfig.globalInstance, i6, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONStringWithDateFormat(Object obj, String str, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, SerializeConfig.globalInstance, null, str, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONStringZ(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, emptyFilters, null, 0, serializerFeatureArr);
    }

    public static void writeJSONString(Writer writer, Object obj, int i6, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter(writer, i6, serializerFeatureArr);
        try {
            new JSONSerializer(serializeWriter).write(obj);
        } finally {
            serializeWriter.close();
        }
    }

    public <T> T toJavaObject(Class<T> cls) {
        return (T) TypeUtils.cast((Object) this, (Class) cls, ParserConfig.getGlobalInstance());
    }

    static {
        int mask = SerializerFeature.QuoteFieldNames.getMask() | SerializerFeature.SkipTransientField.getMask() | SerializerFeature.WriteEnumUsingName.getMask() | SerializerFeature.SortField.getMask();
        String stringProperty = IOUtils.getStringProperty("fastjson.serializerFeatures.MapSortField");
        int mask2 = SerializerFeature.MapSortField.getMask();
        if ("true".equals(stringProperty)) {
            mask |= mask2;
        } else if ("false".equals(stringProperty)) {
            mask &= ~mask2;
        }
        DEFAULT_GENERATE_FEATURE = mask;
        bytesLocal = new ThreadLocal<>();
        charsLocal = new ThreadLocal<>();
    }

    public static <T> void handleResovleTask(DefaultJSONParser defaultJSONParser, T t5) {
        defaultJSONParser.handleResovleTask(t5);
    }

    public static Object toJSON(Object obj, SerializeConfig serializeConfig) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof JSON) {
            return obj;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            JSONObject jSONObject = new JSONObject(map.size());
            for (Map.Entry entry : map.entrySet()) {
                jSONObject.put(TypeUtils.castToString(entry.getKey()), toJSON(entry.getValue()));
            }
            return jSONObject;
        }
        if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            JSONArray jSONArray = new JSONArray(collection.size());
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                jSONArray.add(toJSON(it.next()));
            }
            return jSONArray;
        }
        Class<?> cls = obj.getClass();
        if (cls.isEnum()) {
            return ((Enum) obj).name();
        }
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            JSONArray jSONArray2 = new JSONArray(length);
            for (int i6 = 0; i6 < length; i6++) {
                jSONArray2.add(toJSON(Array.get(obj, i6)));
            }
            return jSONArray2;
        }
        if (ParserConfig.isPrimitive2(cls)) {
            return obj;
        }
        ObjectSerializer objectWriter = serializeConfig.getObjectWriter(cls);
        if (objectWriter instanceof JavaBeanSerializer) {
            JavaBeanSerializer javaBeanSerializer = (JavaBeanSerializer) objectWriter;
            JSONObject jSONObject2 = new JSONObject();
            try {
                for (Map.Entry<String, Object> entry2 : javaBeanSerializer.getFieldValuesMap(obj).entrySet()) {
                    jSONObject2.put(entry2.getKey(), toJSON(entry2.getValue()));
                }
                return jSONObject2;
            } catch (Exception e6) {
                throw new JSONException("toJSON error", e6);
            }
        }
        return parse(toJSONString(obj));
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, serializeConfig, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, int i6, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter(null, i6, serializerFeatureArr);
        try {
            new JSONSerializer(serializeWriter).write(obj);
            return serializeWriter.toString();
        } finally {
            serializeWriter.close();
        }
    }

    public static void writeJSONStringTo(Object obj, Writer writer, SerializerFeature... serializerFeatureArr) {
        writeJSONString(writer, obj, serializerFeatureArr);
    }

    public <T> T toJavaObject(Type type) {
        return (T) TypeUtils.cast(this, type, ParserConfig.getGlobalInstance());
    }

    public String toString() {
        return toJSONString();
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, int i6, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter(null, i6, serializerFeatureArr);
        try {
            new JSONSerializer(serializeWriter, serializeConfig).write(obj);
            return serializeWriter.toBytes(IOUtils.UTF8);
        } finally {
            serializeWriter.close();
        }
    }

    public <T> T toJavaObject(TypeReference typeReference) {
        return (T) TypeUtils.cast(this, typeReference != null ? typeReference.getType() : null, ParserConfig.getGlobalInstance());
    }

    public static Object parse(byte[] bArr, Feature... featureArr) {
        char[] allocateChars = allocateChars(bArr.length);
        return parse(new String(allocateChars, 0, IOUtils.decodeUTF8(bArr, 0, bArr.length, allocateChars)), featureArr);
    }

    public static <T> T parseObject(String str, TypeReference<T> typeReference, Feature... featureArr) {
        return (T) parseObject(str, typeReference.type, ParserConfig.global, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Object obj, SerializerFeature... serializerFeatureArr) throws IOException {
        return writeJSONString(outputStream, obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static <T> T parseObject(String str, Class<T> cls, Feature... featureArr) {
        return (T) parseObject(str, cls, ParserConfig.global, (ParseProcess) null, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Object obj, int i6, SerializerFeature... serializerFeatureArr) throws IOException {
        return writeJSONString(outputStream, IOUtils.UTF8, obj, SerializeConfig.globalInstance, null, null, i6, serializerFeatureArr);
    }

    public static <T> T parseObject(String str, Class<T> cls, ParseProcess parseProcess, Feature... featureArr) {
        return (T) parseObject(str, cls, ParserConfig.global, parseProcess, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static String toJSONString(Object obj, SerializeFilter serializeFilter, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, SerializeConfig.globalInstance, new SerializeFilter[]{serializeFilter}, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Charset charset, Object obj, SerializerFeature... serializerFeatureArr) throws IOException {
        return writeJSONString(outputStream, charset, obj, SerializeConfig.globalInstance, null, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static Object parse(byte[] bArr, int i6, int i7, CharsetDecoder charsetDecoder, Feature... featureArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int i8 = DEFAULT_PARSER_FEATURE;
        for (Feature feature : featureArr) {
            i8 = Feature.config(i8, feature, true);
        }
        return parse(bArr, i6, i7, charsetDecoder, i8);
    }

    public static <T> T parseObject(String str, Type type, Feature... featureArr) {
        return (T) parseObject(str, type, ParserConfig.global, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static String toJSONString(Object obj, SerializeFilter[] serializeFilterArr, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, SerializeConfig.globalInstance, serializeFilterArr, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Charset charset, Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i6, SerializerFeature... serializerFeatureArr) throws IOException {
        SerializeWriter serializeWriter = new SerializeWriter(null, i6, serializerFeatureArr);
        try {
            JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter, serializeConfig);
            if (str != null && str.length() != 0) {
                jSONSerializer.setDateFormat(str);
                jSONSerializer.config(SerializerFeature.WriteDateUseDateFormat, true);
            }
            if (serializeFilterArr != null) {
                for (SerializeFilter serializeFilter : serializeFilterArr) {
                    jSONSerializer.addFilter(serializeFilter);
                }
            }
            jSONSerializer.write(obj);
            int writeToEx = serializeWriter.writeToEx(outputStream, charset);
            serializeWriter.close();
            return writeToEx;
        } catch (Throwable th) {
            serializeWriter.close();
            throw th;
        }
    }

    public static <T> List<T> parseArray(String str, Class<T> cls) {
        ArrayList arrayList = null;
        if (str == null) {
            return null;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, ParserConfig.getGlobalInstance());
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i6 = jSONLexer.token();
        if (i6 == 8) {
            jSONLexer.nextToken();
        } else if (i6 != 20 || !jSONLexer.isBlankInput()) {
            arrayList = new ArrayList();
            defaultJSONParser.parseArray((Class<?>) cls, (Collection) arrayList);
            defaultJSONParser.handleResovleTask(arrayList);
        }
        defaultJSONParser.close();
        return arrayList;
    }

    public static <T> T parseObject(String str, Type type, ParseProcess parseProcess, Feature... featureArr) {
        return (T) parseObject(str, type, ParserConfig.global, parseProcess, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, (SerializeFilter) null, serializerFeatureArr);
    }

    public static <T> T parseObject(String str, Type type, int i6, Feature... featureArr) {
        if (str == null) {
            return null;
        }
        for (Feature feature : featureArr) {
            i6 = Feature.config(i6, feature, true);
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, ParserConfig.getGlobalInstance(), i6);
        T t5 = (T) defaultJSONParser.parseObject(type);
        defaultJSONParser.handleResovleTask(t5);
        defaultJSONParser.close();
        return t5;
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, SerializeFilter serializeFilter, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, new SerializeFilter[]{serializeFilter}, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, serializeFilterArr, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i6, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter(null, i6, serializerFeatureArr);
        try {
            JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter, serializeConfig);
            if (str != null && str.length() != 0) {
                jSONSerializer.setDateFormat(str);
                jSONSerializer.config(SerializerFeature.WriteDateUseDateFormat, true);
            }
            if (serializeFilterArr != null) {
                for (SerializeFilter serializeFilter : serializeFilterArr) {
                    jSONSerializer.addFilter(serializeFilter);
                }
            }
            jSONSerializer.write(obj);
            String serializeWriter2 = serializeWriter.toString();
            serializeWriter.close();
            return serializeWriter2;
        } catch (Throwable th) {
            serializeWriter.close();
            throw th;
        }
    }

    public static Object parse(byte[] bArr, int i6, int i7, CharsetDecoder charsetDecoder, int i8) {
        charsetDecoder.reset();
        char[] allocateChars = allocateChars((int) (i7 * charsetDecoder.maxCharsPerByte()));
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i6, i7);
        CharBuffer wrap2 = CharBuffer.wrap(allocateChars);
        IOUtils.decode(charsetDecoder, wrap, wrap2);
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(allocateChars, wrap2.position(), ParserConfig.getGlobalInstance(), i8);
        Object parse = defaultJSONParser.parse();
        defaultJSONParser.handleResovleTask(parse);
        defaultJSONParser.close();
        return parse;
    }

    public static <T> T parseObject(String str, Type type, ParserConfig parserConfig, Feature... featureArr) {
        return (T) parseObject(str, type, parserConfig, (ParseProcess) null, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(String str, Type type, ParserConfig parserConfig, int i6, Feature... featureArr) {
        return (T) parseObject(str, type, parserConfig, (ParseProcess) null, i6, featureArr);
    }

    public static List<Object> parseArray(String str, Type[] typeArr) {
        if (str == null) {
            return null;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, ParserConfig.getGlobalInstance());
        Object[] parseArray = defaultJSONParser.parseArray(typeArr);
        List<Object> asList = parseArray != null ? Arrays.asList(parseArray) : null;
        defaultJSONParser.handleResovleTask(asList);
        defaultJSONParser.close();
        return asList;
    }

    public static <T> T parseObject(String str, Type type, ParserConfig parserConfig, ParseProcess parseProcess, int i6, Feature... featureArr) {
        if (str == null) {
            return null;
        }
        if (featureArr != null) {
            for (Feature feature : featureArr) {
                i6 |= feature.mask;
            }
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig, i6);
        if (parseProcess != null) {
            if (parseProcess instanceof ExtraTypeProvider) {
                defaultJSONParser.getExtraTypeProviders().add((ExtraTypeProvider) parseProcess);
            }
            if (parseProcess instanceof ExtraProcessor) {
                defaultJSONParser.getExtraProcessors().add((ExtraProcessor) parseProcess);
            }
            if (parseProcess instanceof FieldTypeResolver) {
                defaultJSONParser.setFieldTypeResolver((FieldTypeResolver) parseProcess);
            }
        }
        T t5 = (T) defaultJSONParser.parseObject(type, (Object) null);
        defaultJSONParser.handleResovleTask(t5);
        defaultJSONParser.close();
        return t5;
    }

    @Override // com.alibaba.fastjson.JSONStreamAware
    public void writeJSONString(Appendable appendable) {
        SerializeWriter serializeWriter = new SerializeWriter();
        try {
            try {
                new JSONSerializer(serializeWriter).write(this);
                appendable.append(serializeWriter.toString());
            } catch (IOException e6) {
                throw new JSONException(e6.getMessage(), e6);
            }
        } finally {
            serializeWriter.close();
        }
    }

    public static String toJSONString(Object obj, boolean z5) {
        return !z5 ? toJSONString(obj) : toJSONString(obj, SerializerFeature.PrettyFormat);
    }

    public static Object parse(String str, Feature... featureArr) {
        int i6 = DEFAULT_PARSER_FEATURE;
        for (Feature feature : featureArr) {
            i6 = Feature.config(i6, feature, true);
        }
        return parse(str, i6);
    }

    @Override // com.alibaba.fastjson.JSONAware
    public String toJSONString() {
        SerializeWriter serializeWriter = new SerializeWriter();
        try {
            new JSONSerializer(serializeWriter).write(this);
            return serializeWriter.toString();
        } finally {
            serializeWriter.close();
        }
    }

    public static <T> T parseObject(byte[] bArr, Type type, Feature... featureArr) {
        return (T) parseObject(bArr, 0, bArr.length, IOUtils.UTF8, type, featureArr);
    }

    public static <T> T parseObject(byte[] bArr, int i6, int i7, Charset charset, Type type, Feature... featureArr) {
        String str;
        if (charset == null) {
            charset = IOUtils.UTF8;
        }
        if (charset == IOUtils.UTF8) {
            char[] allocateChars = allocateChars(bArr.length);
            str = new String(allocateChars, 0, IOUtils.decodeUTF8(bArr, i6, i7, allocateChars));
        } else {
            str = new String(bArr, i6, i7, charset);
        }
        return (T) parseObject(str, type, featureArr);
    }

    public static <T> T parseObject(byte[] bArr, int i6, int i7, CharsetDecoder charsetDecoder, Type type, Feature... featureArr) {
        charsetDecoder.reset();
        char[] allocateChars = allocateChars((int) (i7 * charsetDecoder.maxCharsPerByte()));
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i6, i7);
        CharBuffer wrap2 = CharBuffer.wrap(allocateChars);
        IOUtils.decode(charsetDecoder, wrap, wrap2);
        return (T) parseObject(allocateChars, wrap2.position(), type, featureArr);
    }

    public static <T> T parseObject(char[] cArr, int i6, Type type, Feature... featureArr) {
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        int i7 = DEFAULT_PARSER_FEATURE;
        for (Feature feature : featureArr) {
            i7 = Feature.config(i7, feature, true);
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(cArr, i6, ParserConfig.getGlobalInstance(), i7);
        T t5 = (T) defaultJSONParser.parseObject(type);
        defaultJSONParser.handleResovleTask(t5);
        defaultJSONParser.close();
        return t5;
    }

    public static <T> T parseObject(InputStream inputStream, Type type, Feature... featureArr) throws IOException {
        return (T) parseObject(inputStream, IOUtils.UTF8, type, featureArr);
    }

    public static <T> T parseObject(InputStream inputStream, Charset charset, Type type, Feature... featureArr) throws IOException {
        if (charset == null) {
            charset = IOUtils.UTF8;
        }
        Charset charset2 = charset;
        byte[] allocateBytes = allocateBytes(65536);
        int i6 = 0;
        while (true) {
            int read = inputStream.read(allocateBytes, i6, allocateBytes.length - i6);
            if (read == -1) {
                return (T) parseObject(allocateBytes, 0, i6, charset2, type, featureArr);
            }
            Type type2 = type;
            Feature[] featureArr2 = featureArr;
            i6 += read;
            if (i6 == allocateBytes.length) {
                byte[] bArr = new byte[(allocateBytes.length * 3) / 2];
                System.arraycopy(allocateBytes, 0, bArr, 0, allocateBytes.length);
                allocateBytes = bArr;
            }
            type = type2;
            featureArr = featureArr2;
        }
    }

    public static <T> T parseObject(String str, Class<T> cls) {
        return (T) parseObject(str, (Class) cls, new Feature[0]);
    }
}
