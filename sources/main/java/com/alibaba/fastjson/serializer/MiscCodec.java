package com.alibaba.fastjson.serializer;

import com.acse.ottn.l3;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import io.netty.util.internal.StringUtil;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class MiscCodec implements ObjectSerializer, ObjectDeserializer {
    private static Method method_paths_get;
    public static final MiscCodec instance = new MiscCodec();
    private static boolean method_paths_get_error = false;

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }

    /* JADX WARN: Type inference failed for: r11v34, types: [T, java.text.DateFormat, java.text.SimpleDateFormat] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object parse;
        String str;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i6 = 0;
        InetAddress inetAddress = null;
        if (type != InetSocketAddress.class) {
            if (defaultJSONParser.resolveStatus == 2) {
                defaultJSONParser.resolveStatus = 0;
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
            if (parse == null) {
                str = null;
            } else {
                if (!(parse instanceof String)) {
                    if (parse instanceof JSONObject) {
                        JSONObject jSONObject = (JSONObject) parse;
                        if (type == Currency.class) {
                            String string = jSONObject.getString("currency");
                            if (string != null) {
                                return (T) Currency.getInstance(string);
                            }
                            String string2 = jSONObject.getString("symbol");
                            if (string2 != null) {
                                return (T) Currency.getInstance(string2);
                            }
                        }
                        if (type == Map.Entry.class) {
                            return (T) jSONObject.entrySet().iterator().next();
                        }
                    }
                    throw new JSONException("expect string");
                }
                str = (String) parse;
            }
            if (str == null || str.length() == 0) {
                return null;
            }
            if (type == UUID.class) {
                return (T) UUID.fromString(str);
            }
            if (type == URI.class) {
                return (T) URI.create(str);
            }
            if (type == URL.class) {
                try {
                    return (T) new URL(str);
                } catch (MalformedURLException e6) {
                    throw new JSONException("create url error", e6);
                }
            }
            if (type == Pattern.class) {
                return (T) Pattern.compile(str);
            }
            if (type == Locale.class) {
                return (T) TypeUtils.toLocale(str);
            }
            if (type == SimpleDateFormat.class) {
                ?? r11 = (T) new SimpleDateFormat(str, jSONLexer.getLocale());
                r11.setTimeZone(jSONLexer.getTimeZone());
                return r11;
            }
            if (type == InetAddress.class || type == Inet4Address.class || type == Inet6Address.class) {
                try {
                    return (T) InetAddress.getByName(str);
                } catch (UnknownHostException e7) {
                    throw new JSONException("deserialize inet adress error", e7);
                }
            }
            if (type == File.class) {
                return (T) new File(str);
            }
            if (type == TimeZone.class) {
                return (T) TimeZone.getTimeZone(str);
            }
            if (type instanceof ParameterizedType) {
                type = ((ParameterizedType) type).getRawType();
            }
            if (type == Class.class) {
                return (T) TypeUtils.loadClass(str, defaultJSONParser.getConfig().getDefaultClassLoader());
            }
            if (type == Charset.class) {
                return (T) Charset.forName(str);
            }
            if (type == Currency.class) {
                return (T) Currency.getInstance(str);
            }
            if (type == JSONPath.class) {
                return (T) new JSONPath(str);
            }
            if (!(type instanceof Class)) {
                throw new JSONException("MiscCodec not support " + type.toString());
            }
            String name = ((Class) type).getName();
            if (name.equals("java.nio.file.Path")) {
                try {
                    if (method_paths_get == null && !method_paths_get_error) {
                        method_paths_get = TypeUtils.loadClass("java.nio.file.Paths").getMethod(l3.f4736f, String.class, String[].class);
                    }
                    Method method = method_paths_get;
                    if (method != null) {
                        return (T) method.invoke(null, str, new String[0]);
                    }
                    throw new JSONException("Path deserialize erorr");
                } catch (IllegalAccessException e8) {
                    throw new JSONException("Path deserialize erorr", e8);
                } catch (NoSuchMethodException unused) {
                    method_paths_get_error = true;
                } catch (InvocationTargetException e9) {
                    throw new JSONException("Path deserialize erorr", e9);
                }
            }
            throw new JSONException("MiscCodec not support " + name);
        }
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        }
        defaultJSONParser.accept(12);
        while (true) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(17);
            if (stringVal.equals("address")) {
                defaultJSONParser.accept(17);
                inetAddress = (InetAddress) defaultJSONParser.parseObject((Class) InetAddress.class);
            } else if (stringVal.equals("port")) {
                defaultJSONParser.accept(17);
                if (jSONLexer.token() != 2) {
                    throw new JSONException("port is not int");
                }
                int intValue = jSONLexer.intValue();
                jSONLexer.nextToken();
                i6 = intValue;
            } else {
                defaultJSONParser.accept(17);
                defaultJSONParser.parse();
            }
            if (jSONLexer.token() != 16) {
                defaultJSONParser.accept(13);
                return (T) new InetSocketAddress(inetAddress, i6);
            }
            jSONLexer.nextToken();
        }
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        String currencyCode;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls == SimpleDateFormat.class) {
            currencyCode = ((SimpleDateFormat) obj).toPattern();
            if (serializeWriter.isEnabled(SerializerFeature.WriteClassName) && obj.getClass() != type) {
                serializeWriter.write(123);
                serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
                jSONSerializer.write(obj.getClass().getName());
                serializeWriter.writeFieldValue(StringUtil.COMMA, "val", currencyCode);
                serializeWriter.write(125);
                return;
            }
        } else if (cls == Class.class) {
            currencyCode = ((Class) obj).getName();
        } else {
            if (cls == InetSocketAddress.class) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
                InetAddress address = inetSocketAddress.getAddress();
                serializeWriter.write(123);
                if (address != null) {
                    serializeWriter.writeFieldName("address");
                    jSONSerializer.write(address);
                    serializeWriter.write(44);
                }
                serializeWriter.writeFieldName("port");
                serializeWriter.writeInt(inetSocketAddress.getPort());
                serializeWriter.write(125);
                return;
            }
            if (obj instanceof File) {
                currencyCode = ((File) obj).getPath();
            } else if (obj instanceof InetAddress) {
                currencyCode = ((InetAddress) obj).getHostAddress();
            } else if (obj instanceof TimeZone) {
                currencyCode = ((TimeZone) obj).getID();
            } else {
                if (!(obj instanceof Currency)) {
                    if (obj instanceof JSONStreamAware) {
                        ((JSONStreamAware) obj).writeJSONString(serializeWriter);
                        return;
                    }
                    if (obj instanceof Iterator) {
                        writeIterator(jSONSerializer, serializeWriter, (Iterator) obj);
                        return;
                    }
                    if (obj instanceof Iterable) {
                        writeIterator(jSONSerializer, serializeWriter, ((Iterable) obj).iterator());
                        return;
                    }
                    if (!(obj instanceof Map.Entry)) {
                        if (obj.getClass().getName().equals("net.sf.json.JSONNull")) {
                            serializeWriter.writeNull();
                            return;
                        }
                        throw new JSONException("not support class : " + cls);
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if (key instanceof String) {
                        String str = (String) key;
                        if (value instanceof String) {
                            serializeWriter.writeFieldValueStringWithDoubleQuoteCheck('{', str, (String) value);
                        } else {
                            serializeWriter.write(123);
                            serializeWriter.writeFieldName(str);
                            jSONSerializer.write(value);
                        }
                    } else {
                        serializeWriter.write(123);
                        jSONSerializer.write(key);
                        serializeWriter.write(58);
                        jSONSerializer.write(value);
                    }
                    serializeWriter.write(125);
                    return;
                }
                currencyCode = ((Currency) obj).getCurrencyCode();
            }
        }
        serializeWriter.writeString(currencyCode);
    }

    protected void writeIterator(JSONSerializer jSONSerializer, SerializeWriter serializeWriter, Iterator<?> it) {
        serializeWriter.write(91);
        int i6 = 0;
        while (it.hasNext()) {
            if (i6 != 0) {
                serializeWriter.write(44);
            }
            jSONSerializer.write(it.next());
            i6++;
        }
        serializeWriter.write(93);
    }
}
