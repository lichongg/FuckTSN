package com.alibaba.fastjson;

import com.acse.ottn.l3;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class JSONObject extends JSON implements Map<String, Object>, Cloneable, Serializable, InvocationHandler {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final long serialVersionUID = 1;
    private final Map<String, Object> map;

    public JSONObject() {
        this(16, false);
    }

    public <T> T getObject(String str, Class<T> cls) {
        return (T) TypeUtils.castToJavaBean(this.map.get(str), cls);
    }

    public JSONObject(Map<String, Object> map) {
        this.map = map;
    }

    @Override // java.util.Map
    public void clear() {
        this.map.clear();
    }

    public Object clone() {
        return new JSONObject((Map<String, Object>) (this.map instanceof LinkedHashMap ? new LinkedHashMap(this.map) : new HashMap(this.map)));
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this.map.equals(obj);
    }

    public JSONObject fluentClear() {
        this.map.clear();
        return this;
    }

    public JSONObject fluentPut(String str, Object obj) {
        this.map.put(str, obj);
        return this;
    }

    public JSONObject fluentPutAll(Map<? extends String, ? extends Object> map) {
        this.map.putAll(map);
        return this;
    }

    public JSONObject fluentRemove(Object obj) {
        this.map.remove(obj);
        return this;
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.map.get(obj);
    }

    public JSONArray getJSONArray(String str) {
        Object obj = this.map.get(str);
        return obj instanceof JSONArray ? (JSONArray) obj : obj instanceof String ? (JSONArray) JSON.parse((String) obj) : (JSONArray) JSON.toJSON(obj);
    }

    public JSONObject getJSONObject(String str) {
        Object obj = this.map.get(str);
        return obj instanceof JSONObject ? (JSONObject) obj : obj instanceof String ? JSON.parseObject((String) obj) : (JSONObject) JSON.toJSON(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.map.keySet();
    }

    @Override // java.util.Map
    public Object put(String str, Object obj) {
        return this.map.put(str, obj);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        this.map.putAll(map);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.map.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size();
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this.map.values();
    }

    public BigDecimal getBigDecimal(String str) {
        return TypeUtils.castToBigDecimal(get(str));
    }

    public BigInteger getBigInteger(String str) {
        return TypeUtils.castToBigInteger(get(str));
    }

    public Boolean getBoolean(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return TypeUtils.castToBoolean(obj);
    }

    public boolean getBooleanValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return false;
        }
        return TypeUtils.castToBoolean(obj).booleanValue();
    }

    public Byte getByte(String str) {
        return TypeUtils.castToByte(get(str));
    }

    public byte getByteValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return (byte) 0;
        }
        return TypeUtils.castToByte(obj).byteValue();
    }

    public byte[] getBytes(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return TypeUtils.castToBytes(obj);
    }

    public Date getDate(String str) {
        return TypeUtils.castToDate(get(str));
    }

    public Double getDouble(String str) {
        return TypeUtils.castToDouble(get(str));
    }

    public double getDoubleValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0.0d;
        }
        return TypeUtils.castToDouble(obj).doubleValue();
    }

    public Float getFloat(String str) {
        return TypeUtils.castToFloat(get(str));
    }

    public float getFloatValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0.0f;
        }
        return TypeUtils.castToFloat(obj).floatValue();
    }

    public int getIntValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0;
        }
        return TypeUtils.castToInt(obj).intValue();
    }

    public Integer getInteger(String str) {
        return TypeUtils.castToInt(get(str));
    }

    public Long getLong(String str) {
        return TypeUtils.castToLong(get(str));
    }

    public long getLongValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0L;
        }
        return TypeUtils.castToLong(obj).longValue();
    }

    public <T> T getObject(String str, Type type) {
        return (T) TypeUtils.cast(this.map.get(str), type, ParserConfig.getGlobalInstance());
    }

    public Short getShort(String str) {
        return TypeUtils.castToShort(get(str));
    }

    public short getShortValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return (short) 0;
        }
        return TypeUtils.castToShort(obj).shortValue();
    }

    public java.sql.Date getSqlDate(String str) {
        return TypeUtils.castToSqlDate(get(str));
    }

    public String getString(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public Timestamp getTimestamp(String str) {
        return TypeUtils.castToTimestamp(get(str));
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        String str;
        Class<?>[] parameterTypes = method.getParameterTypes();
        int length = parameterTypes.length;
        Class<?> cls = Void.TYPE;
        String str2 = null;
        if (length == 1) {
            if (method.getName().equals("equals")) {
                return Boolean.valueOf(equals(objArr[0]));
            }
            if (method.getReturnType() == cls) {
                JSONField jSONField = (JSONField) method.getAnnotation(JSONField.class);
                if (jSONField != null && jSONField.name().length() != 0) {
                    str = jSONField.name();
                } else {
                    str = null;
                }
                if (str == null) {
                    String name = method.getName();
                    if (name.startsWith(l3.f4738h)) {
                        String substring = name.substring(3);
                        if (substring.length() != 0) {
                            str = Character.toLowerCase(substring.charAt(0)) + substring.substring(1);
                        } else {
                            throw new JSONException("illegal setter");
                        }
                    } else {
                        throw new JSONException("illegal setter");
                    }
                }
                this.map.put(str, objArr[0]);
                return null;
            }
            throw new JSONException("illegal setter");
        }
        if (parameterTypes.length == 0) {
            if (method.getReturnType() != cls) {
                JSONField jSONField2 = (JSONField) method.getAnnotation(JSONField.class);
                if (jSONField2 != null && jSONField2.name().length() != 0) {
                    str2 = jSONField2.name();
                }
                if (str2 == null) {
                    String name2 = method.getName();
                    if (name2.startsWith(l3.f4736f)) {
                        String substring2 = name2.substring(3);
                        if (substring2.length() != 0) {
                            str2 = Character.toLowerCase(substring2.charAt(0)) + substring2.substring(1);
                        } else {
                            throw new JSONException("illegal getter");
                        }
                    } else if (name2.startsWith("is")) {
                        String substring3 = name2.substring(2);
                        if (substring3.length() != 0) {
                            str2 = Character.toLowerCase(substring3.charAt(0)) + substring3.substring(1);
                        } else {
                            throw new JSONException("illegal getter");
                        }
                    } else {
                        if (name2.startsWith("hashCode")) {
                            return Integer.valueOf(hashCode());
                        }
                        if (name2.startsWith("toString")) {
                            return toString();
                        }
                        throw new JSONException("illegal getter");
                    }
                }
                return TypeUtils.cast(this.map.get(str2), method.getGenericReturnType(), ParserConfig.getGlobalInstance());
            }
            throw new JSONException("illegal getter");
        }
        throw new UnsupportedOperationException(method.toGenericString());
    }

    public JSONObject(boolean z5) {
        this(16, z5);
    }

    public JSONObject(int i6) {
        this(i6, false);
    }

    public <T> T getObject(String str, TypeReference typeReference) {
        T t5 = (T) this.map.get(str);
        return typeReference == null ? t5 : (T) TypeUtils.cast(t5, typeReference.getType(), ParserConfig.getGlobalInstance());
    }

    public JSONObject(int i6, boolean z5) {
        if (z5) {
            this.map = new LinkedHashMap(i6);
        } else {
            this.map = new HashMap(i6);
        }
    }
}
