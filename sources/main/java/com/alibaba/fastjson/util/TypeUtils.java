package com.alibaba.fastjson.util;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.SerializeBeanInfo;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TypeUtils {
    private static Class<? extends Annotation> class_OneToMany = null;
    private static boolean class_OneToMany_error = false;
    public static boolean compatibleWithFieldName = false;
    public static boolean compatibleWithJavaBean = false;
    private static ConcurrentMap<String, Class<?>> mappings = null;
    private static Method method_HibernateIsInitialized = null;
    private static boolean method_HibernateIsInitialized_error = false;
    private static Class<?> optionalClass = null;
    private static boolean optionalClassInited = false;
    private static Method oracleDateMethod = null;
    private static boolean oracleDateMethodInited = false;
    private static Method oracleTimestampMethod = null;
    private static boolean oracleTimestampMethodInited = false;
    private static Class<?> pathClass = null;
    private static boolean pathClass_error = false;
    private static boolean setAccessibleEnable = true;
    private static Class<? extends Annotation> transientClass;
    private static boolean transientClassInited;

    public static SerializeBeanInfo buildBeanInfo(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy) {
        return buildBeanInfo(cls, map, propertyNamingStrategy, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig) {
        Object obj2;
        Class<T> cls2 = Boolean.TYPE;
        Class<T> cls3 = Double.TYPE;
        Class<T> cls4 = Float.TYPE;
        Class<T> cls5 = Byte.TYPE;
        Class<T> cls6 = Short.TYPE;
        Class<T> cls7 = Long.TYPE;
        Class<T> cls8 = Integer.TYPE;
        int i6 = 0;
        if (obj == 0) {
            if (cls == cls8) {
                return (T) 0;
            }
            if (cls == cls7) {
                return (T) 0L;
            }
            if (cls == cls6) {
                return (T) (short) 0;
            }
            if (cls == cls5) {
                return (T) (byte) 0;
            }
            if (cls == cls4) {
                return (T) Float.valueOf(0.0f);
            }
            if (cls == cls3) {
                return (T) Double.valueOf(0.0d);
            }
            if (cls == cls2) {
                return (T) Boolean.FALSE;
            }
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        }
        if (cls != obj.getClass()) {
            if (!(obj instanceof Map)) {
                if (cls.isArray()) {
                    if (obj instanceof Collection) {
                        Collection collection = (Collection) obj;
                        T t5 = (T) Array.newInstance(cls.getComponentType(), collection.size());
                        Iterator it = collection.iterator();
                        while (it.hasNext()) {
                            Array.set(t5, i6, cast(it.next(), (Class) cls.getComponentType(), parserConfig));
                            i6++;
                        }
                        return t5;
                    }
                    if (cls == byte[].class) {
                        return (T) castToBytes(obj);
                    }
                }
                if (!cls.isAssignableFrom(obj.getClass())) {
                    if (cls == cls2 || cls == Boolean.class) {
                        return (T) castToBoolean(obj);
                    }
                    if (cls == cls5 || cls == Byte.class) {
                        return (T) castToByte(obj);
                    }
                    if (cls == Character.TYPE || cls == Character.class) {
                        return (T) castToChar(obj);
                    }
                    if (cls == cls6 || cls == Short.class) {
                        return (T) castToShort(obj);
                    }
                    if (cls == cls8 || cls == Integer.class) {
                        return (T) castToInt(obj);
                    }
                    if (cls == cls7 || cls == Long.class) {
                        return (T) castToLong(obj);
                    }
                    if (cls == cls4 || cls == Float.class) {
                        return (T) castToFloat(obj);
                    }
                    if (cls == cls3 || cls == Double.class) {
                        return (T) castToDouble(obj);
                    }
                    if (cls == String.class) {
                        return (T) castToString(obj);
                    }
                    if (cls == BigDecimal.class) {
                        return (T) castToBigDecimal(obj);
                    }
                    if (cls == BigInteger.class) {
                        return (T) castToBigInteger(obj);
                    }
                    if (cls == Date.class) {
                        return (T) castToDate(obj);
                    }
                    if (cls == java.sql.Date.class) {
                        return (T) castToSqlDate(obj);
                    }
                    if (cls == Timestamp.class) {
                        return (T) castToTimestamp(obj);
                    }
                    if (cls.isEnum()) {
                        return (T) castToEnum(obj, cls, parserConfig);
                    }
                    if (Calendar.class.isAssignableFrom(cls)) {
                        Date castToDate = castToDate(obj);
                        if (cls == Calendar.class) {
                            obj2 = (T) Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                        } else {
                            try {
                                obj2 = (T) ((Calendar) cls.newInstance());
                            } catch (Exception e6) {
                                throw new JSONException("can not cast to : " + cls.getName(), e6);
                            }
                        }
                        ((Calendar) obj2).setTime(castToDate);
                        return (T) obj2;
                    }
                    if (cls.getName().equals("javax.xml.datatype.XMLGregorianCalendar")) {
                        Date castToDate2 = castToDate(obj);
                        Calendar calendar = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                        calendar.setTime(castToDate2);
                        return (T) CalendarCodec.instance.createXMLGregorianCalendar(calendar);
                    }
                    if (obj instanceof String) {
                        String str = (String) obj;
                        if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                            return null;
                        }
                        if (cls == Currency.class) {
                            return (T) Currency.getInstance(str);
                        }
                        if (cls == Locale.class) {
                            return (T) toLocale(str);
                        }
                    }
                    throw new JSONException("can not cast to : " + cls.getName());
                }
            } else if (cls != Map.class) {
                Map map = (Map) obj;
                if (cls != Object.class || map.containsKey(JSON.DEFAULT_TYPE_KEY)) {
                    return (T) castToJavaBean(map, cls, parserConfig);
                }
            }
        }
        return obj;
    }

    public static BigDecimal castToBigDecimal(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0) {
            return null;
        }
        if ((obj instanceof Map) && ((Map) obj).size() == 0) {
            return null;
        }
        return new BigDecimal(obj2);
    }

    public static BigInteger castToBigInteger(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
            return null;
        }
        return new BigInteger(obj2);
    }

    public static Boolean castToBoolean(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            return Boolean.valueOf(((Number) obj).intValue() == 1);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
            if ("Y".equalsIgnoreCase(str) || ExifInterface.GPS_DIRECTION_TRUE.equals(str)) {
                return Boolean.TRUE;
            }
            if ("F".equalsIgnoreCase(str) || "N".equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new JSONException("can not cast to boolean, value : " + obj);
    }

    public static Byte castToByte(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (!(obj instanceof String)) {
            throw new JSONException("can not cast to byte, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
            return null;
        }
        return Byte.valueOf(Byte.parseByte(str));
    }

    public static Character castToChar(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (!(obj instanceof String)) {
            throw new JSONException("can not cast to char, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0) {
            return null;
        }
        if (str.length() == 1) {
            return Character.valueOf(str.charAt(0));
        }
        throw new JSONException("can not cast to char, value : " + obj);
    }

    public static Date castToDate(Object obj) {
        long j6;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            JSONScanner jSONScanner = new JSONScanner(str);
            try {
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    return jSONScanner.getCalendar().getTime();
                }
                jSONScanner.close();
                if (str.startsWith("/Date(") && str.endsWith(")/")) {
                    str = str.substring(6, str.length() - 2);
                }
                if (str.indexOf(45) != -1) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str.length() == JSON.DEFFAULT_DATE_FORMAT.length() ? JSON.DEFFAULT_DATE_FORMAT : str.length() == 10 ? "yyyy-MM-dd" : str.length() == 19 ? "yyyy-MM-dd HH:mm:ss" : "yyyy-MM-dd HH:mm:ss.SSS", JSON.defaultLocale);
                    simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
                    try {
                        return simpleDateFormat.parse(str);
                    } catch (ParseException unused) {
                        throw new JSONException("can not cast to Date, value : " + str);
                    }
                }
                if (str.length() == 0) {
                    return null;
                }
                j6 = Long.parseLong(str);
            } finally {
                jSONScanner.close();
            }
        } else {
            j6 = -1;
        }
        if (j6 >= 0) {
            return new Date(j6);
        }
        Class<?> cls = obj.getClass();
        if ("oracle.sql.TIMESTAMP".equals(cls.getName())) {
            if (oracleTimestampMethod == null && !oracleTimestampMethodInited) {
                try {
                    oracleTimestampMethod = cls.getMethod("toJdbc", null);
                } catch (NoSuchMethodException unused2) {
                } catch (Throwable th) {
                    oracleTimestampMethodInited = true;
                    throw th;
                }
                oracleTimestampMethodInited = true;
            }
            try {
                return (Date) oracleTimestampMethod.invoke(obj, null);
            } catch (Exception e6) {
                throw new JSONException("can not cast oracle.sql.TIMESTAMP to Date", e6);
            }
        }
        if (!"oracle.sql.DATE".equals(cls.getName())) {
            throw new JSONException("can not cast to Date, value : " + obj);
        }
        if (oracleDateMethod == null && !oracleDateMethodInited) {
            try {
                oracleDateMethod = cls.getMethod("toJdbc", null);
            } catch (NoSuchMethodException unused3) {
            } catch (Throwable th2) {
                oracleDateMethodInited = true;
                throw th2;
            }
            oracleDateMethodInited = true;
        }
        try {
            return (Date) oracleDateMethod.invoke(obj, null);
        } catch (Exception e7) {
            throw new JSONException("can not cast oracle.sql.DATE to Date", e7);
        }
    }

    public static Double castToDouble(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (!(obj instanceof String)) {
            throw new JSONException("can not cast to double, value : " + obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
            return null;
        }
        if (obj2.indexOf(44) != 0) {
            obj2 = obj2.replaceAll(",", "");
        }
        return Double.valueOf(Double.parseDouble(obj2));
    }

    public static Float castToFloat(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (!(obj instanceof String)) {
            throw new JSONException("can not cast to float, value : " + obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
            return null;
        }
        if (obj2.indexOf(44) != 0) {
            obj2 = obj2.replaceAll(",", "");
        }
        return Float.valueOf(Float.parseFloat(obj2));
    }

    public static Integer castToInt(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (str.indexOf(44) != 0) {
                str = str.replaceAll(",", "");
            }
            return Integer.valueOf(Integer.parseInt(str));
        }
        if (obj instanceof Boolean) {
            return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it = map.values().iterator();
                it.next();
                return castToInt(it.next());
            }
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static <T> T castToJavaBean(Object obj, Class<T> cls) {
        return (T) cast(obj, (Class) cls, ParserConfig.getGlobalInstance());
    }

    public static Long castToLong(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (str.indexOf(44) != 0) {
                str = str.replaceAll(",", "");
            }
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                JSONScanner jSONScanner = new JSONScanner(str);
                Calendar calendar = jSONScanner.scanISO8601DateIfMatch(false) ? jSONScanner.getCalendar() : null;
                jSONScanner.close();
                if (calendar != null) {
                    return Long.valueOf(calendar.getTimeInMillis());
                }
            }
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it = map.values().iterator();
                it.next();
                return castToLong(it.next());
            }
        }
        throw new JSONException("can not cast to long, value : " + obj);
    }

    public static Short castToShort(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (!(obj instanceof String)) {
            throw new JSONException("can not cast to short, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
            return null;
        }
        return Short.valueOf(Short.parseShort(str));
    }

    public static java.sql.Date castToSqlDate(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.sql.Date) {
            return (java.sql.Date) obj;
        }
        if (obj instanceof Date) {
            return new java.sql.Date(((Date) obj).getTime());
        }
        if (obj instanceof Calendar) {
            return new java.sql.Date(((Calendar) obj).getTimeInMillis());
        }
        long longValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (isNumber(str)) {
                longValue = Long.parseLong(str);
            } else {
                JSONScanner jSONScanner = new JSONScanner(str);
                if (!jSONScanner.scanISO8601DateIfMatch(false)) {
                    throw new JSONException("can not cast to Timestamp, value : " + str);
                }
                longValue = jSONScanner.getCalendar().getTime().getTime();
            }
        }
        if (longValue > 0) {
            return new java.sql.Date(longValue);
        }
        throw new JSONException("can not cast to Date, value : " + obj);
    }

    public static Timestamp castToTimestamp(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return new Timestamp(((Calendar) obj).getTimeInMillis());
        }
        if (obj instanceof Timestamp) {
            return (Timestamp) obj;
        }
        if (obj instanceof Date) {
            return new Timestamp(((Date) obj).getTime());
        }
        long longValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (isNumber(str)) {
                longValue = Long.parseLong(str);
            } else {
                JSONScanner jSONScanner = new JSONScanner(str);
                if (!jSONScanner.scanISO8601DateIfMatch(false)) {
                    throw new JSONException("can not cast to Timestamp, value : " + str);
                }
                longValue = jSONScanner.getCalendar().getTime().getTime();
            }
        }
        if (longValue > 0) {
            return new Timestamp(longValue);
        }
        throw new JSONException("can not cast to Timestamp, value : " + obj);
    }

    public static List<FieldInfo> computeGetters(Class<?> cls, Map<String, String> map) {
        return computeGetters(cls, map, true);
    }

    public static Field getField(Class<?> cls, String str, Field[] fieldArr) {
        for (Field field : fieldArr) {
            if (str.equals(field.getName())) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        return getField(superclass, str, superclass.getDeclaredFields());
    }

    public static boolean isAnnotationPresentOneToMany(Method method) {
        if (method == null) {
            return false;
        }
        if (class_OneToMany == null && !class_OneToMany_error) {
            try {
                class_OneToMany = Class.forName("javax.persistence.OneToMany");
            } catch (Throwable unused) {
                class_OneToMany_error = true;
            }
        }
        Class<? extends Annotation> cls = class_OneToMany;
        if (cls == null) {
            return false;
        }
        return method.isAnnotationPresent(cls);
    }

    public static boolean isHibernateInitialized(Object obj) {
        if (obj == null) {
            return false;
        }
        if (method_HibernateIsInitialized == null && !method_HibernateIsInitialized_error) {
            try {
                method_HibernateIsInitialized = Class.forName("org.hibernate.Hibernate").getMethod("isInitialized", Object.class);
            } catch (Throwable unused) {
                method_HibernateIsInitialized_error = true;
            }
        }
        Method method = method_HibernateIsInitialized;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(null, obj)).booleanValue();
            } catch (Throwable unused2) {
            }
        }
        return true;
    }

    public static boolean isNumber(String str) {
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (charAt == '+' || charAt == '-') {
                if (i6 != 0) {
                    return false;
                }
            } else if (charAt < '0' || charAt > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean isTransient(Method method) {
        if (method == null) {
            return false;
        }
        if (!transientClassInited) {
            try {
                transientClass = Class.forName("java.beans.Transient");
            } catch (Exception unused) {
            } catch (Throwable th) {
                transientClassInited = true;
                throw th;
            }
            transientClassInited = true;
        }
        Class<? extends Annotation> cls = transientClass;
        return (cls == null || method.getAnnotation(cls) == null) ? false : true;
    }

    public static Class<?> loadClass(String str) {
        return loadClass(str, null);
    }

    static {
        try {
            compatibleWithJavaBean = "true".equals(IOUtils.getStringProperty(IOUtils.FASTJSON_COMPATIBLEWITHJAVABEAN));
            compatibleWithFieldName = "true".equals(IOUtils.getStringProperty(IOUtils.FASTJSON_COMPATIBLEWITHFIELDNAME));
        } catch (Throwable unused) {
        }
        mappings = new ConcurrentHashMap(16, 0.75f, 1);
        addBaseClassMappings();
        pathClass_error = false;
    }

    private static void addBaseClassMappings() {
        mappings.put("byte", Byte.TYPE);
        mappings.put("short", Short.TYPE);
        mappings.put(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, Integer.TYPE);
        mappings.put("long", Long.TYPE);
        mappings.put("float", Float.TYPE);
        mappings.put("double", Double.TYPE);
        mappings.put("boolean", Boolean.TYPE);
        mappings.put("char", Character.TYPE);
        mappings.put("[byte", byte[].class);
        mappings.put("[short", short[].class);
        mappings.put("[int", int[].class);
        mappings.put("[long", long[].class);
        mappings.put("[float", float[].class);
        mappings.put("[double", double[].class);
        mappings.put("[boolean", boolean[].class);
        mappings.put("[char", char[].class);
        mappings.put("[B", byte[].class);
        mappings.put("[S", short[].class);
        mappings.put("[I", int[].class);
        mappings.put("[J", long[].class);
        mappings.put("[F", float[].class);
        mappings.put("[D", double[].class);
        mappings.put("[C", char[].class);
        mappings.put("[Z", boolean[].class);
        Class<?>[] clsArr = {Object.class, Cloneable.class, loadClass("java.lang.AutoCloseable"), Exception.class, RuntimeException.class, IllegalAccessError.class, IllegalAccessException.class, IllegalArgumentException.class, IllegalMonitorStateException.class, IllegalStateException.class, IllegalThreadStateException.class, IndexOutOfBoundsException.class, InstantiationError.class, InstantiationException.class, InternalError.class, InterruptedException.class, LinkageError.class, NegativeArraySizeException.class, NoClassDefFoundError.class, NoSuchFieldError.class, NoSuchFieldException.class, NoSuchMethodError.class, NoSuchMethodException.class, NullPointerException.class, NumberFormatException.class, OutOfMemoryError.class, SecurityException.class, StackOverflowError.class, StringIndexOutOfBoundsException.class, TypeNotPresentException.class, VerifyError.class, StackTraceElement.class, HashMap.class, Hashtable.class, TreeMap.class, java.util.IdentityHashMap.class, WeakHashMap.class, LinkedHashMap.class, HashSet.class, LinkedHashSet.class, TreeSet.class, TimeUnit.class, ConcurrentHashMap.class, loadClass("java.util.concurrent.ConcurrentSkipListMap"), loadClass("java.util.concurrent.ConcurrentSkipListSet"), AtomicInteger.class, AtomicLong.class, Collections.EMPTY_MAP.getClass(), BitSet.class, Calendar.class, Date.class, Locale.class, UUID.class, Time.class, java.sql.Date.class, Timestamp.class, SimpleDateFormat.class, JSONObject.class};
        for (int i6 = 0; i6 < 58; i6++) {
            Class<?> cls = clsArr[i6];
            if (cls != null) {
                mappings.put(cls.getName(), cls);
            }
        }
        String[] strArr = {"java.awt.Rectangle", "java.awt.Point", "java.awt.Font", "java.awt.Color"};
        for (int i7 = 0; i7 < 4; i7++) {
            Class<?> loadClass = loadClass(strArr[i7]);
            if (loadClass == null) {
                break;
            }
            mappings.put(loadClass.getName(), loadClass);
        }
        String[] strArr2 = {"org.springframework.util.LinkedMultiValueMap", "org.springframework.util.LinkedCaseInsensitiveMap", "org.springframework.remoting.support.RemoteInvocation", "org.springframework.remoting.support.RemoteInvocationResult"};
        for (int i8 = 0; i8 < 4; i8++) {
            Class<?> loadClass2 = loadClass(strArr2[i8]);
            if (loadClass2 == null) {
                return;
            }
            mappings.put(loadClass2.getName(), loadClass2);
        }
    }

    public static SerializeBeanInfo buildBeanInfo(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy, boolean z5) {
        String[] strArr;
        String str;
        String str2;
        int i6;
        Class<?> cls2;
        Map<String, String> map2;
        PropertyNamingStrategy propertyNamingStrategy2;
        List<FieldInfo> computeGetters;
        List arrayList;
        JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
        if (jSONType != null) {
            String[] orders = jSONType.orders();
            String typeName = jSONType.typeName();
            if (typeName.length() == 0) {
                typeName = null;
            }
            int of = SerializerFeature.of(jSONType.serialzeFeatures());
            String str3 = null;
            for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                JSONType jSONType2 = (JSONType) superclass.getAnnotation(JSONType.class);
                if (jSONType2 == null) {
                    break;
                }
                str3 = jSONType2.typeKey();
                if (str3.length() != 0) {
                    break;
                }
            }
            for (Class<?> cls3 : cls.getInterfaces()) {
                JSONType jSONType3 = (JSONType) cls3.getAnnotation(JSONType.class);
                if (jSONType3 != null) {
                    str3 = jSONType3.typeKey();
                    if (str3.length() != 0) {
                        break;
                    }
                }
            }
            if (str3 == null || str3.length() != 0) {
                strArr = orders;
                i6 = of;
                str2 = str3;
                str = typeName;
            } else {
                str2 = null;
                strArr = orders;
                str = typeName;
                i6 = of;
            }
        } else {
            strArr = null;
            str = null;
            str2 = null;
            i6 = 0;
        }
        HashMap hashMap = new HashMap();
        ParserConfig.parserAllFieldToCache(cls, hashMap);
        if (z5) {
            computeGetters = computeGettersWithFieldBase(cls, map, false, propertyNamingStrategy);
            cls2 = cls;
            map2 = map;
            propertyNamingStrategy2 = propertyNamingStrategy;
        } else {
            cls2 = cls;
            map2 = map;
            propertyNamingStrategy2 = propertyNamingStrategy;
            computeGetters = computeGetters(cls2, jSONType, map2, hashMap, false, propertyNamingStrategy2);
        }
        FieldInfo[] fieldInfoArr = new FieldInfo[computeGetters.size()];
        computeGetters.toArray(fieldInfoArr);
        if (strArr == null || strArr.length == 0) {
            arrayList = new ArrayList(computeGetters);
            Collections.sort(arrayList);
        } else {
            arrayList = z5 ? computeGettersWithFieldBase(cls2, map2, true, propertyNamingStrategy2) : computeGetters(cls2, jSONType, map2, hashMap, true, propertyNamingStrategy2);
        }
        FieldInfo[] fieldInfoArr2 = new FieldInfo[arrayList.size()];
        arrayList.toArray(fieldInfoArr2);
        if (Arrays.equals(fieldInfoArr2, fieldInfoArr)) {
            fieldInfoArr2 = fieldInfoArr;
        }
        return new SerializeBeanInfo(cls2, jSONType, str, str2, i6, fieldInfoArr, fieldInfoArr2);
    }

    public static byte[] castToBytes(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return IOUtils.decodeBase64((String) obj);
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static <T> T castToEnum(Object obj, Class<T> cls, ParserConfig parserConfig) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return (T) Enum.valueOf(cls, str);
            }
            if (obj instanceof Number) {
                int intValue = ((Number) obj).intValue();
                T[] enumConstants = cls.getEnumConstants();
                if (intValue < enumConstants.length) {
                    return enumConstants[intValue];
                }
            }
            throw new JSONException("can not cast to : " + cls.getName());
        } catch (Exception e6) {
            throw new JSONException("can not cast to : " + cls.getName(), e6);
        }
    }

    public static <T> T castToJavaBean(Map<String, Object> map, Class<T> cls, ParserConfig parserConfig) {
        int i6 = 0;
        try {
            if (cls == StackTraceElement.class) {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                if (number != null) {
                    i6 = number.intValue();
                }
                return (T) new StackTraceElement(str, str2, str3, i6);
            }
            Object obj = map.get(JSON.DEFAULT_TYPE_KEY);
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (parserConfig == null) {
                    parserConfig = ParserConfig.global;
                }
                Class<?> checkAutoType = parserConfig.checkAutoType(str4, null);
                if (checkAutoType == null) {
                    throw new ClassNotFoundException(str4 + " not found");
                }
                if (!checkAutoType.equals(cls)) {
                    return (T) castToJavaBean(map, checkAutoType, parserConfig);
                }
            }
            if (cls.isInterface()) {
                JSONObject jSONObject = map instanceof JSONObject ? (JSONObject) map : new JSONObject(map);
                if (parserConfig == null) {
                    parserConfig = ParserConfig.getGlobalInstance();
                }
                return parserConfig.getDeserializers().get(cls) != null ? (T) JSON.parseObject(JSON.toJSONString(jSONObject), cls) : (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, jSONObject);
            }
            if (cls == Locale.class) {
                Object obj2 = map.get("language");
                Object obj3 = map.get("country");
                if (obj2 instanceof String) {
                    String str5 = (String) obj2;
                    if (obj3 instanceof String) {
                        return (T) new Locale(str5, (String) obj3);
                    }
                    if (obj3 == null) {
                        return (T) new Locale(str5);
                    }
                }
            }
            if (cls == String.class && (map instanceof JSONObject)) {
                return (T) map.toString();
            }
            if (parserConfig == null) {
                parserConfig = ParserConfig.getGlobalInstance();
            }
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
            if (javaBeanDeserializer != null) {
                return (T) javaBeanDeserializer.createInstance(map, parserConfig);
            }
            throw new JSONException("can not get javaBeanDeserializer. " + cls.getName());
        } catch (Exception e6) {
            throw new JSONException(e6.getMessage(), e6);
        }
    }

    public static String castToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static void clearClassMapping() {
        mappings.clear();
        addBaseClassMappings();
    }

    private static void computeFields(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy, Map<String, FieldInfo> map2, Field[] fieldArr) {
        String str;
        int i6;
        int i7;
        int i8;
        for (Field field : fieldArr) {
            if (!Modifier.isStatic(field.getModifiers())) {
                JSONField jSONField = (JSONField) field.getAnnotation(JSONField.class);
                String name = field.getName();
                if (jSONField == null) {
                    str = null;
                    i6 = 0;
                    i7 = 0;
                    i8 = 0;
                } else if (jSONField.serialize()) {
                    int ordinal = jSONField.ordinal();
                    int of = SerializerFeature.of(jSONField.serialzeFeatures());
                    int of2 = Feature.of(jSONField.parseFeatures());
                    if (jSONField.name().length() != 0) {
                        name = jSONField.name();
                    }
                    str = jSONField.label().length() != 0 ? jSONField.label() : null;
                    i6 = ordinal;
                    i7 = of;
                    i8 = of2;
                }
                if (map == null || (name = map.get(name)) != null) {
                    if (propertyNamingStrategy != null) {
                        name = propertyNamingStrategy.translate(name);
                    }
                    String str2 = name;
                    if (!map2.containsKey(str2)) {
                        map2.put(str2, new FieldInfo(str2, null, field, cls, null, i6, i7, i8, null, jSONField, str));
                    }
                }
            }
        }
    }

    public static List<FieldInfo> computeGetters(Class<?> cls, Map<String, String> map, boolean z5) {
        JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
        HashMap hashMap = new HashMap();
        ParserConfig.parserAllFieldToCache(cls, hashMap);
        return computeGetters(cls, jSONType, map, hashMap, z5, PropertyNamingStrategy.CamelCase);
    }

    public static List<FieldInfo> computeGettersWithFieldBase(Class<?> cls, Map<String, String> map, boolean z5, PropertyNamingStrategy propertyNamingStrategy) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            computeFields(cls2, map, propertyNamingStrategy, linkedHashMap, cls2.getDeclaredFields());
        }
        return getFieldInfos(cls, z5, linkedHashMap);
    }

    public static String decapitalize(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static Class<?> getClassFromMapping(String str) {
        return mappings.get(str);
    }

    public static Class<?> getCollectionItemClass(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return Object.class;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        if (!(type2 instanceof Class)) {
            throw new JSONException("can not create ASMParser");
        }
        Class<?> cls = (Class) type2;
        if (Modifier.isPublic(cls.getModifiers())) {
            return cls;
        }
        throw new JSONException("can not create ASMParser");
    }

    public static Type getCollectionItemType(Type type) {
        Type type2;
        if (type instanceof ParameterizedType) {
            type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                if (upperBounds.length == 1) {
                    type2 = upperBounds[0];
                }
            }
        } else {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (!cls.getName().startsWith("java.")) {
                    type2 = getCollectionItemType(cls.getGenericSuperclass());
                }
            }
            type2 = null;
        }
        return type2 == null ? Object.class : type2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<com.alibaba.fastjson.util.FieldInfo> getFieldInfos(java.lang.Class<?> r5, boolean r6, java.util.Map<java.lang.String, com.alibaba.fastjson.util.FieldInfo> r7) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r1 = com.alibaba.fastjson.annotation.JSONType.class
            java.lang.annotation.Annotation r5 = r5.getAnnotation(r1)
            com.alibaba.fastjson.annotation.JSONType r5 = (com.alibaba.fastjson.annotation.JSONType) r5
            r1 = 0
            if (r5 == 0) goto L31
            java.lang.String[] r5 = r5.orders()
            if (r5 == 0) goto L2f
            int r2 = r5.length
            int r3 = r7.size()
            if (r2 != r3) goto L2f
            int r2 = r5.length
            r3 = 0
        L1f:
            if (r3 >= r2) goto L2d
            r4 = r5[r3]
            boolean r4 = r7.containsKey(r4)
            if (r4 != 0) goto L2a
            goto L2f
        L2a:
            int r3 = r3 + 1
            goto L1f
        L2d:
            r2 = 1
            goto L33
        L2f:
            r2 = 0
            goto L33
        L31:
            r5 = 0
            goto L2f
        L33:
            if (r2 == 0) goto L46
            int r6 = r5.length
        L36:
            if (r1 >= r6) goto L63
            r2 = r5[r1]
            java.lang.Object r2 = r7.get(r2)
            com.alibaba.fastjson.util.FieldInfo r2 = (com.alibaba.fastjson.util.FieldInfo) r2
            r0.add(r2)
            int r1 = r1 + 1
            goto L36
        L46:
            java.util.Collection r5 = r7.values()
            java.util.Iterator r5 = r5.iterator()
        L4e:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L5e
            java.lang.Object r7 = r5.next()
            com.alibaba.fastjson.util.FieldInfo r7 = (com.alibaba.fastjson.util.FieldInfo) r7
            r0.add(r7)
            goto L4e
        L5e:
            if (r6 == 0) goto L63
            java.util.Collections.sort(r0)
        L63:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.getFieldInfos(java.lang.Class, boolean, java.util.Map):java.util.List");
    }

    public static Type getGenericParamType(Type type) {
        return type instanceof ParameterizedType ? type : type instanceof Class ? getGenericParamType(((Class) type).getGenericSuperclass()) : type;
    }

    public static int getParserFeatures(Class<?> cls) {
        JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
        if (jSONType == null) {
            return 0;
        }
        return Feature.of(jSONType.parseFeatures());
    }

    private static String getPropertyNameByCompatibleFieldName(Map<String, Field> map, String str, String str2, int i6) {
        if (compatibleWithFieldName && !map.containsKey(str2)) {
            String substring = str.substring(i6);
            if (map.containsKey(substring)) {
                return substring;
            }
        }
        return str2;
    }

    public static Class<?> getRawClass(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getRawClass(((ParameterizedType) type).getRawType());
        }
        throw new JSONException("TODO");
    }

    public static int getSerializeFeatures(Class<?> cls) {
        JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
        if (jSONType == null) {
            return 0;
        }
        return SerializerFeature.of(jSONType.serialzeFeatures());
    }

    public static boolean isGenericParamType(Type type) {
        Type genericSuperclass;
        if (type instanceof ParameterizedType) {
            return true;
        }
        if (!(type instanceof Class) || (genericSuperclass = ((Class) type).getGenericSuperclass()) == Object.class) {
            return false;
        }
        return isGenericParamType(genericSuperclass);
    }

    private static boolean isJSONTypeIgnore(Class<?> cls, String str) {
        JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
        if (jSONType != null) {
            String[] includes = jSONType.includes();
            if (includes.length > 0) {
                for (String str2 : includes) {
                    if (str.equals(str2)) {
                        return false;
                    }
                }
                return true;
            }
            for (String str3 : jSONType.ignores()) {
                if (str.equals(str3)) {
                    return true;
                }
            }
        }
        return (cls.getSuperclass() == Object.class || cls.getSuperclass() == null || !isJSONTypeIgnore(cls.getSuperclass(), str)) ? false : true;
    }

    public static boolean isPath(Class<?> cls) {
        if (pathClass == null && !pathClass_error) {
            try {
                pathClass = Class.forName("java.nio.file.Path");
            } catch (Throwable unused) {
                pathClass_error = true;
            }
        }
        Class<?> cls2 = pathClass;
        if (cls2 != null) {
            return cls2.isAssignableFrom(cls);
        }
        return false;
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader) {
        if (str == null || str.length() == 0) {
            return null;
        }
        Class<?> cls = mappings.get(str);
        if (cls != null) {
            return cls;
        }
        if (str.charAt(0) == '[') {
            return Array.newInstance(loadClass(str.substring(1), classLoader), 0).getClass();
        }
        if (str.startsWith("L") && str.endsWith(";")) {
            return loadClass(str.substring(1, str.length() - 1), classLoader);
        }
        if (classLoader != null) {
            try {
                cls = classLoader.loadClass(str);
                mappings.put(str, cls);
                return cls;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null && contextClassLoader != classLoader) {
                cls = contextClassLoader.loadClass(str);
                mappings.put(str, cls);
                return cls;
            }
        } catch (Throwable unused) {
        }
        try {
            cls = Class.forName(str);
            mappings.put(str, cls);
            return cls;
        } catch (Throwable unused2) {
            return cls;
        }
    }

    static void setAccessible(AccessibleObject accessibleObject) {
        if (setAccessibleEnable && !accessibleObject.isAccessible()) {
            try {
                accessibleObject.setAccessible(true);
            } catch (AccessControlException unused) {
                setAccessibleEnable = false;
            }
        }
    }

    public static Locale toLocale(String str) {
        String[] split = str.split("_");
        return split.length == 1 ? new Locale(split[0]) : split.length == 2 ? new Locale(split[0], split[1]) : new Locale(split[0], split[1], split[2]);
    }

    public static Type unwrapOptional(Type type) {
        if (!optionalClassInited) {
            try {
                optionalClass = Class.forName("java.util.Optional");
            } catch (Exception unused) {
            } catch (Throwable th) {
                optionalClassInited = true;
                throw th;
            }
            optionalClassInited = true;
        }
        if (!(type instanceof ParameterizedType)) {
            return type;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        return parameterizedType.getRawType() == optionalClass ? parameterizedType.getActualTypeArguments()[0] : type;
    }

    public static Collection createCollection(Type type) {
        Type type2;
        Class<?> rawClass = getRawClass(type);
        if (rawClass != AbstractCollection.class && rawClass != Collection.class) {
            if (rawClass.isAssignableFrom(HashSet.class)) {
                return new HashSet();
            }
            if (rawClass.isAssignableFrom(LinkedHashSet.class)) {
                return new LinkedHashSet();
            }
            if (rawClass.isAssignableFrom(TreeSet.class)) {
                return new TreeSet();
            }
            if (rawClass.isAssignableFrom(ArrayList.class)) {
                return new ArrayList();
            }
            if (rawClass.isAssignableFrom(EnumSet.class)) {
                if (type instanceof ParameterizedType) {
                    type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                } else {
                    type2 = Object.class;
                }
                return EnumSet.noneOf((Class) type2);
            }
            try {
                return (Collection) rawClass.newInstance();
            } catch (Exception unused) {
                throw new JSONException("create instance error, class " + rawClass.getName());
            }
        }
        return new ArrayList();
    }

    public static Class<?> getClass(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getClass(((ParameterizedType) type).getRawType());
        }
        if (type instanceof TypeVariable) {
            return (Class) ((TypeVariable) type).getBounds()[0];
        }
        return Object.class;
    }

    public static JSONField getSuperMethodAnnotation(Class<?> cls, Method method) {
        Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces.length > 0) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> cls2 : interfaces) {
                for (Method method2 : cls2.getMethods()) {
                    Class<?>[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes2.length == parameterTypes.length && method2.getName().equals(method.getName())) {
                        int i6 = 0;
                        while (true) {
                            if (i6 < parameterTypes.length) {
                                if (!parameterTypes2[i6].equals(parameterTypes[i6])) {
                                    break;
                                }
                                i6++;
                            } else {
                                JSONField jSONField = (JSONField) method2.getAnnotation(JSONField.class);
                                if (jSONField != null) {
                                    return jSONField;
                                }
                            }
                        }
                    }
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class<?>[] parameterTypes3 = method.getParameterTypes();
            for (Method method3 : superclass.getMethods()) {
                Class<?>[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i7 = 0;
                    while (true) {
                        if (i7 < parameterTypes3.length) {
                            if (!parameterTypes4[i7].equals(parameterTypes3[i7])) {
                                break;
                            }
                            i7++;
                        } else {
                            JSONField jSONField2 = (JSONField) method3.getAnnotation(JSONField.class);
                            if (jSONField2 != null) {
                                return jSONField2;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static boolean isProxy(Class<?> cls) {
        for (Class<?> cls2 : cls.getInterfaces()) {
            String name = cls2.getName();
            if (name.equals("net.sf.cglib.proxy.Factory") || name.equals("org.springframework.cglib.proxy.Factory") || name.equals("javassist.util.proxy.ProxyObject") || name.equals("org.apache.ibatis.javassist.util.proxy.ProxyObject")) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0301, code lost:
    
        if (r0 == null) goto L121;
     */
    /* JADX WARN: Removed duplicated region for block: B:146:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0341 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x021d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.alibaba.fastjson.util.FieldInfo> computeGetters(java.lang.Class<?> r25, com.alibaba.fastjson.annotation.JSONType r26, java.util.Map<java.lang.String, java.lang.String> r27, java.util.Map<java.lang.String, java.lang.reflect.Field> r28, boolean r29, com.alibaba.fastjson.PropertyNamingStrategy r30) {
        /*
            Method dump skipped, instructions count: 855
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.computeGetters(java.lang.Class, com.alibaba.fastjson.annotation.JSONType, java.util.Map, java.util.Map, boolean, com.alibaba.fastjson.PropertyNamingStrategy):java.util.List");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(Object obj, Type type, ParserConfig parserConfig) {
        if (obj == 0) {
            return null;
        }
        if (type instanceof Class) {
            return (T) cast(obj, (Class) type, parserConfig);
        }
        if (type instanceof ParameterizedType) {
            return (T) cast(obj, (ParameterizedType) type, parserConfig);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new JSONException("can not cast to : " + type);
    }

    /* JADX WARN: Type inference failed for: r8v5, types: [T, java.util.HashMap, java.util.Map] */
    public static <T> T cast(Object obj, ParameterizedType parameterizedType, ParserConfig parserConfig) {
        T t5;
        Type rawType = parameterizedType.getRawType();
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                if (rawType != Set.class && rawType != HashSet.class) {
                    if (rawType == TreeSet.class) {
                        t5 = (T) new TreeSet();
                    } else {
                        t5 = (T) new ArrayList();
                    }
                } else {
                    t5 = (T) new HashSet();
                }
                Iterator<T> it = ((Iterable) obj).iterator();
                while (it.hasNext()) {
                    ((Collection) t5).add(cast(it.next(), type, parserConfig));
                }
                return t5;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                ?? r8 = (T) new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    r8.put(cast(entry.getKey(), type2, parserConfig), cast(entry.getValue(), type3, parserConfig));
                }
                return r8;
            }
        }
        if ((obj instanceof String) && ((String) obj).length() == 0) {
            return null;
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return (T) cast(obj, rawType, parserConfig);
        }
        throw new JSONException("can not cast to : " + parameterizedType);
    }
}
