package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory;
import com.alibaba.fastjson.parser.deserializer.ArrayListTypeFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JSONPDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.parser.deserializer.MapDeserializer;
import com.alibaba.fastjson.parser.deserializer.NumberDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.OptionalCodec;
import com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.StackTraceElementDeserializer;
import com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer;
import com.alibaba.fastjson.parser.deserializer.TimeDeserializer;
import com.alibaba.fastjson.serializer.AtomicCodec;
import com.alibaba.fastjson.serializer.AwtCodec;
import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.BigIntegerCodec;
import com.alibaba.fastjson.serializer.BooleanCodec;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.CharArrayCodec;
import com.alibaba.fastjson.serializer.CharacterCodec;
import com.alibaba.fastjson.serializer.CollectionCodec;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.FloatCodec;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.MiscCodec;
import com.alibaba.fastjson.serializer.ObjectArrayCodec;
import com.alibaba.fastjson.serializer.ReferenceCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.ServiceLoader;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.AccessControlException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.sql.DataSource;
import javax.xml.datatype.XMLGregorianCalendar;
import kotlin.text.v0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ParserConfig {
    public static final String AUTOTYPE_ACCEPT = "fastjson.parser.autoTypeAccept";
    private static final String[] AUTO_TYPE_ACCEPT_LIST;
    private static boolean awtError;
    public static ParserConfig global;
    private static boolean jdk8Error;
    private String[] acceptList;
    private boolean asmEnable;
    protected ASMDeserializerFactory asmFactory;
    private boolean autoTypeSupport;
    public boolean compatibleWithJavaBean;
    protected ClassLoader defaultClassLoader;
    private String[] denyList;
    private final IdentityHashMap<Type, ObjectDeserializer> deserializers;
    public final boolean fieldBased;
    private int maxTypeNameLength;
    public PropertyNamingStrategy propertyNamingStrategy;
    public final SymbolTable symbolTable;
    public static final String DENY_PROPERTY = "fastjson.parser.deny";
    public static final String[] DENYS = splitItemsFormProperty(IOUtils.getStringProperty(DENY_PROPERTY));
    public static final String AUTOTYPE_SUPPORT_PROPERTY = "fastjson.parser.autoTypeSupport";
    public static final boolean AUTO_SUPPORT = "true".equals(IOUtils.getStringProperty(AUTOTYPE_SUPPORT_PROPERTY));

    public ParserConfig() {
        this(false);
    }

    public ObjectDeserializer getDeserializer(Type type) {
        ObjectDeserializer objectDeserializer = this.deserializers.get(type);
        if (objectDeserializer != null) {
            return objectDeserializer;
        }
        if (type instanceof Class) {
            return getDeserializer((Class) type, type);
        }
        if (!(type instanceof ParameterizedType)) {
            return JavaObjectDeserializer.instance;
        }
        Type rawType = ((ParameterizedType) type).getRawType();
        return rawType instanceof Class ? getDeserializer((Class) rawType, type) : getDeserializer(rawType);
    }

    static {
        String[] splitItemsFormProperty = splitItemsFormProperty(IOUtils.getStringProperty(AUTOTYPE_ACCEPT));
        if (splitItemsFormProperty == null) {
            splitItemsFormProperty = new String[0];
        }
        AUTO_TYPE_ACCEPT_LIST = splitItemsFormProperty;
        global = new ParserConfig();
        awtError = false;
        jdk8Error = false;
    }

    public ParserConfig(boolean z5) {
        this(null, null, z5);
    }

    private void addItemsToAccept(String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            addAccept(str);
        }
    }

    private void addItemsToDeny(String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            addDeny(str);
        }
    }

    public static ParserConfig getGlobalInstance() {
        return global;
    }

    private static String[] splitItemsFormProperty(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(",");
    }

    public void addAccept(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        for (String str2 : this.acceptList) {
            if (str.equals(str2)) {
                return;
            }
        }
        String[] strArr = this.acceptList;
        int length = strArr.length;
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length] = str;
        this.acceptList = strArr2;
    }

    public void addDeny(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        for (String str2 : this.denyList) {
            if (str.equals(str2)) {
                return;
            }
        }
        String[] strArr = this.denyList;
        int length = strArr.length;
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length] = str;
        this.denyList = strArr2;
    }

    public Class<?> checkAutoType(String str, Class<?> cls) {
        if (str == null) {
            return null;
        }
        if (str.length() >= this.maxTypeNameLength) {
            throw new JSONException("autoType is not support. " + str);
        }
        String replace = str.replace(v0.f47959c, '.');
        int i6 = 0;
        if (this.autoTypeSupport || cls != null) {
            int i7 = 0;
            while (true) {
                String[] strArr = this.acceptList;
                if (i7 >= strArr.length) {
                    int i8 = 0;
                    while (true) {
                        String[] strArr2 = this.denyList;
                        if (i8 >= strArr2.length) {
                            break;
                        }
                        if (replace.startsWith(strArr2[i8]) && TypeUtils.getClassFromMapping(str) == null) {
                            throw new JSONException("autoType is not support. " + str);
                        }
                        i8++;
                    }
                } else {
                    if (replace.startsWith(strArr[i7])) {
                        return TypeUtils.loadClass(str, this.defaultClassLoader);
                    }
                    i7++;
                }
            }
        }
        Class<?> classFromMapping = TypeUtils.getClassFromMapping(str);
        if (classFromMapping == null) {
            classFromMapping = this.deserializers.findClass(str);
        }
        if (classFromMapping != null) {
            if (cls == null || cls.isAssignableFrom(classFromMapping)) {
                return classFromMapping;
            }
            throw new JSONException("type not match. " + str + " -> " + cls.getName());
        }
        if (!this.autoTypeSupport) {
            int i9 = 0;
            while (true) {
                String[] strArr3 = this.denyList;
                if (i9 >= strArr3.length) {
                    while (true) {
                        String[] strArr4 = this.acceptList;
                        if (i6 >= strArr4.length) {
                            break;
                        }
                        if (replace.startsWith(strArr4[i6])) {
                            Class<?> loadClass = TypeUtils.loadClass(str, this.defaultClassLoader);
                            if (cls == null || !cls.isAssignableFrom(loadClass)) {
                                return loadClass;
                            }
                            throw new JSONException("type not match. " + str + " -> " + cls.getName());
                        }
                        i6++;
                    }
                } else {
                    if (replace.startsWith(strArr3[i9])) {
                        throw new JSONException("autoType is not support. " + str);
                    }
                    i9++;
                }
            }
        }
        if (this.autoTypeSupport || cls != null) {
            classFromMapping = TypeUtils.loadClass(str, this.defaultClassLoader);
        }
        if (classFromMapping != null) {
            if (ClassLoader.class.isAssignableFrom(classFromMapping) || DataSource.class.isAssignableFrom(classFromMapping)) {
                throw new JSONException("autoType is not support. " + str);
            }
            if (cls != null) {
                if (cls.isAssignableFrom(classFromMapping)) {
                    return classFromMapping;
                }
                throw new JSONException("type not match. " + str + " -> " + cls.getName());
            }
        }
        if (this.autoTypeSupport) {
            return classFromMapping;
        }
        throw new JSONException("autoType is not support. " + str);
    }

    public void configFromPropety(Properties properties) {
        addItemsToDeny(splitItemsFormProperty(properties.getProperty(DENY_PROPERTY)));
        addItemsToAccept(splitItemsFormProperty(properties.getProperty(AUTOTYPE_ACCEPT)));
        String property = properties.getProperty(AUTOTYPE_SUPPORT_PROPERTY);
        if ("true".equals(property)) {
            this.autoTypeSupport = true;
        } else if ("false".equals(property)) {
            this.autoTypeSupport = false;
        }
    }

    public FieldDeserializer createFieldDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, FieldInfo fieldInfo) {
        Class<?> deserializeUsing;
        Class<?> cls = javaBeanInfo.clazz;
        Class<?> cls2 = fieldInfo.fieldClass;
        JSONField annotation = fieldInfo.getAnnotation();
        Class<?> cls3 = null;
        if (annotation != null && (deserializeUsing = annotation.deserializeUsing()) != Void.class) {
            cls3 = deserializeUsing;
        }
        return (cls3 == null && (cls2 == List.class || cls2 == ArrayList.class)) ? new ArrayListTypeFieldDeserializer(parserConfig, cls, fieldInfo) : new DefaultFieldDeserializer(parserConfig, cls, fieldInfo);
    }

    public ObjectDeserializer createJavaBeanDeserializer(Class<?> cls, Type type) {
        JSONField annotation;
        ASMDeserializerFactory aSMDeserializerFactory;
        boolean z5 = this.asmEnable & (!this.fieldBased);
        if (z5) {
            JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
            if (jSONType != null) {
                Class<?> deserializer = jSONType.deserializer();
                if (deserializer != Void.class) {
                    try {
                        Object newInstance = deserializer.newInstance();
                        if (newInstance instanceof ObjectDeserializer) {
                            return (ObjectDeserializer) newInstance;
                        }
                    } catch (Throwable unused) {
                    }
                }
                z5 = jSONType.asm();
            }
            if (z5) {
                Class<?> builderClass = JavaBeanInfo.getBuilderClass(jSONType);
                if (builderClass == null) {
                    builderClass = cls;
                }
                while (true) {
                    if (!Modifier.isPublic(builderClass.getModifiers())) {
                        z5 = false;
                        break;
                    }
                    builderClass = builderClass.getSuperclass();
                    if (builderClass == Object.class || builderClass == null) {
                        break;
                    }
                }
            }
        }
        if (cls.getTypeParameters().length != 0) {
            z5 = false;
        }
        if (z5 && (aSMDeserializerFactory = this.asmFactory) != null && aSMDeserializerFactory.classLoader.isExternalClass(cls)) {
            z5 = false;
        }
        if (z5) {
            z5 = ASMUtils.checkName(cls.getSimpleName());
        }
        if (z5) {
            if (cls.isInterface()) {
                z5 = false;
            }
            JavaBeanInfo build = JavaBeanInfo.build(cls, type, this.propertyNamingStrategy);
            if (z5 && build.fields.length > 200) {
                z5 = false;
            }
            Constructor<?> constructor = build.defaultConstructor;
            if (z5 && constructor == null && !cls.isInterface()) {
                z5 = false;
            }
            for (FieldInfo fieldInfo : build.fields) {
                if (!fieldInfo.getOnly) {
                    Class<?> cls2 = fieldInfo.fieldClass;
                    if (Modifier.isPublic(cls2.getModifiers()) && ((!cls2.isMemberClass() || Modifier.isStatic(cls2.getModifiers())) && ((fieldInfo.getMember() == null || ASMUtils.checkName(fieldInfo.getMember().getName())) && (((annotation = fieldInfo.getAnnotation()) == null || (ASMUtils.checkName(annotation.name()) && annotation.format().length() == 0 && annotation.deserializeUsing() == Void.class && !annotation.unwrapped())) && (!cls2.isEnum() || (getDeserializer(cls2) instanceof EnumDeserializer)))))) {
                    }
                }
                z5 = false;
                break;
            }
        }
        if (!((z5 && cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) ? false : z5)) {
            return new JavaBeanDeserializer(this, cls, type);
        }
        JavaBeanInfo build2 = JavaBeanInfo.build(cls, type, this.propertyNamingStrategy);
        try {
            return this.asmFactory.createJavaBeanDeserializer(this, build2);
        } catch (JSONException unused2) {
            return new JavaBeanDeserializer(this, build2);
        } catch (NoSuchMethodException unused3) {
            return new JavaBeanDeserializer(this, cls, type);
        } catch (Exception e6) {
            throw new JSONException("create asm deserializer error, " + cls.getName(), e6);
        }
    }

    public ClassLoader getDefaultClassLoader() {
        return this.defaultClassLoader;
    }

    public IdentityHashMap<Type, ObjectDeserializer> getDeserializers() {
        return this.deserializers;
    }

    public void initJavaBeanDeserializers(Class<?>... clsArr) {
        if (clsArr == null) {
            return;
        }
        for (Class<?> cls : clsArr) {
            if (cls != null) {
                putDeserializer(cls, createJavaBeanDeserializer(cls, cls));
            }
        }
    }

    public boolean isAsmEnable() {
        return this.asmEnable;
    }

    public boolean isAutoTypeSupport() {
        return this.autoTypeSupport;
    }

    public void putDeserializer(Type type, ObjectDeserializer objectDeserializer) {
        this.deserializers.put(type, objectDeserializer);
    }

    public void setAsmEnable(boolean z5) {
        this.asmEnable = z5;
    }

    public void setAutoTypeSupport(boolean z5) {
        this.autoTypeSupport = z5;
    }

    public void setDefaultClassLoader(ClassLoader classLoader) {
        this.defaultClassLoader = classLoader;
    }

    public ParserConfig(ClassLoader classLoader) {
        this(null, classLoader, false);
    }

    public static Field getFieldFromCache(String str, Map<String, Field> map) {
        char charAt;
        Field field = map.get(str);
        if (field == null) {
            field = map.get("_" + str);
        }
        if (field == null) {
            field = map.get("m_" + str);
        }
        if (field == null && (charAt = str.charAt(0)) >= 'a' && charAt <= 'z') {
            char[] charArray = str.toCharArray();
            charArray[0] = (char) (charArray[0] - ' ');
            return map.get(new String(charArray));
        }
        return field;
    }

    public static boolean isPrimitive2(Class<?> cls) {
        if (!cls.isPrimitive() && cls != Boolean.class && cls != Character.class && cls != Byte.class && cls != Short.class && cls != Integer.class && cls != Long.class && cls != Float.class && cls != Double.class && cls != BigInteger.class && cls != BigDecimal.class && cls != String.class && cls != Date.class && cls != java.sql.Date.class && cls != Time.class && cls != Timestamp.class && !cls.isEnum()) {
            return false;
        }
        return true;
    }

    public static void parserAllFieldToCache(Class<?> cls, Map<String, Field> map) {
        for (Field field : cls.getDeclaredFields()) {
            String name = field.getName();
            if (!map.containsKey(name)) {
                map.put(name, field);
            }
        }
        if (cls.getSuperclass() != null && cls.getSuperclass() != Object.class) {
            parserAllFieldToCache(cls.getSuperclass(), map);
        }
    }

    public boolean isPrimitive(Class<?> cls) {
        return isPrimitive2(cls);
    }

    public ParserConfig(ASMDeserializerFactory aSMDeserializerFactory) {
        this(aSMDeserializerFactory, null, false);
    }

    private ParserConfig(ASMDeserializerFactory aSMDeserializerFactory, ClassLoader classLoader, boolean z5) {
        this.deserializers = new IdentityHashMap<>();
        boolean z6 = ASMUtils.IS_ANDROID;
        this.asmEnable = !z6;
        this.symbolTable = new SymbolTable(4096);
        this.autoTypeSupport = AUTO_SUPPORT;
        this.denyList = "bsh,com.mchange,com.sun.,java.lang.Thread,java.net.Socket,java.rmi,javax.xml,org.apache.bcel,org.apache.commons.beanutils,org.apache.commons.collections.Transformer,org.apache.commons.collections.functors,org.apache.commons.collections4.comparators,org.apache.commons.fileupload,org.apache.myfaces.context.servlet,org.apache.tomcat,org.apache.wicket.util,org.codehaus.groovy.runtime,org.hibernate,org.jboss,org.mozilla.javascript,org.python.core,org.springframework".split(",");
        this.acceptList = AUTO_TYPE_ACCEPT_LIST;
        this.maxTypeNameLength = 256;
        this.compatibleWithJavaBean = TypeUtils.compatibleWithJavaBean;
        this.fieldBased = z5;
        if (aSMDeserializerFactory == null && !z6) {
            try {
                if (classLoader == null) {
                    aSMDeserializerFactory = new ASMDeserializerFactory(new ASMClassLoader());
                } else {
                    aSMDeserializerFactory = new ASMDeserializerFactory(classLoader);
                }
            } catch (ExceptionInInitializerError | NoClassDefFoundError | AccessControlException unused) {
            }
        }
        this.asmFactory = aSMDeserializerFactory;
        if (aSMDeserializerFactory == null) {
            this.asmEnable = false;
        }
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap = this.deserializers;
        MiscCodec miscCodec = MiscCodec.instance;
        identityHashMap.put(SimpleDateFormat.class, miscCodec);
        this.deserializers.put(Timestamp.class, SqlDateDeserializer.instance_timestamp);
        this.deserializers.put(java.sql.Date.class, SqlDateDeserializer.instance);
        this.deserializers.put(Time.class, TimeDeserializer.instance);
        this.deserializers.put(Date.class, DateCodec.instance);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap2 = this.deserializers;
        CalendarCodec calendarCodec = CalendarCodec.instance;
        identityHashMap2.put(Calendar.class, calendarCodec);
        this.deserializers.put(XMLGregorianCalendar.class, calendarCodec);
        this.deserializers.put(JSONObject.class, MapDeserializer.instance);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap3 = this.deserializers;
        CollectionCodec collectionCodec = CollectionCodec.instance;
        identityHashMap3.put(JSONArray.class, collectionCodec);
        this.deserializers.put(Map.class, MapDeserializer.instance);
        this.deserializers.put(HashMap.class, MapDeserializer.instance);
        this.deserializers.put(LinkedHashMap.class, MapDeserializer.instance);
        this.deserializers.put(TreeMap.class, MapDeserializer.instance);
        this.deserializers.put(ConcurrentMap.class, MapDeserializer.instance);
        this.deserializers.put(ConcurrentHashMap.class, MapDeserializer.instance);
        this.deserializers.put(Collection.class, collectionCodec);
        this.deserializers.put(List.class, collectionCodec);
        this.deserializers.put(ArrayList.class, collectionCodec);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap4 = this.deserializers;
        JavaObjectDeserializer javaObjectDeserializer = JavaObjectDeserializer.instance;
        identityHashMap4.put(Object.class, javaObjectDeserializer);
        this.deserializers.put(String.class, StringCodec.instance);
        this.deserializers.put(StringBuffer.class, StringCodec.instance);
        this.deserializers.put(StringBuilder.class, StringCodec.instance);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap5 = this.deserializers;
        CharacterCodec characterCodec = CharacterCodec.instance;
        identityHashMap5.put(Character.TYPE, characterCodec);
        this.deserializers.put(Character.class, characterCodec);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap6 = this.deserializers;
        NumberDeserializer numberDeserializer = NumberDeserializer.instance;
        identityHashMap6.put(Byte.TYPE, numberDeserializer);
        this.deserializers.put(Byte.class, numberDeserializer);
        this.deserializers.put(Short.TYPE, numberDeserializer);
        this.deserializers.put(Short.class, numberDeserializer);
        this.deserializers.put(Integer.TYPE, IntegerCodec.instance);
        this.deserializers.put(Integer.class, IntegerCodec.instance);
        this.deserializers.put(Long.TYPE, LongCodec.instance);
        this.deserializers.put(Long.class, LongCodec.instance);
        this.deserializers.put(BigInteger.class, BigIntegerCodec.instance);
        this.deserializers.put(BigDecimal.class, BigDecimalCodec.instance);
        this.deserializers.put(Float.TYPE, FloatCodec.instance);
        this.deserializers.put(Float.class, FloatCodec.instance);
        this.deserializers.put(Double.TYPE, numberDeserializer);
        this.deserializers.put(Double.class, numberDeserializer);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap7 = this.deserializers;
        BooleanCodec booleanCodec = BooleanCodec.instance;
        identityHashMap7.put(Boolean.TYPE, booleanCodec);
        this.deserializers.put(Boolean.class, booleanCodec);
        this.deserializers.put(Class.class, miscCodec);
        this.deserializers.put(char[].class, new CharArrayCodec());
        this.deserializers.put(AtomicBoolean.class, booleanCodec);
        this.deserializers.put(AtomicInteger.class, IntegerCodec.instance);
        this.deserializers.put(AtomicLong.class, LongCodec.instance);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap8 = this.deserializers;
        ReferenceCodec referenceCodec = ReferenceCodec.instance;
        identityHashMap8.put(AtomicReference.class, referenceCodec);
        this.deserializers.put(WeakReference.class, referenceCodec);
        this.deserializers.put(SoftReference.class, referenceCodec);
        this.deserializers.put(UUID.class, miscCodec);
        this.deserializers.put(TimeZone.class, miscCodec);
        this.deserializers.put(Locale.class, miscCodec);
        this.deserializers.put(Currency.class, miscCodec);
        this.deserializers.put(InetAddress.class, miscCodec);
        this.deserializers.put(Inet4Address.class, miscCodec);
        this.deserializers.put(Inet6Address.class, miscCodec);
        this.deserializers.put(InetSocketAddress.class, miscCodec);
        this.deserializers.put(File.class, miscCodec);
        this.deserializers.put(URI.class, miscCodec);
        this.deserializers.put(URL.class, miscCodec);
        this.deserializers.put(Pattern.class, miscCodec);
        this.deserializers.put(Charset.class, miscCodec);
        this.deserializers.put(JSONPath.class, miscCodec);
        this.deserializers.put(Number.class, numberDeserializer);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap9 = this.deserializers;
        AtomicCodec atomicCodec = AtomicCodec.instance;
        identityHashMap9.put(AtomicIntegerArray.class, atomicCodec);
        this.deserializers.put(AtomicLongArray.class, atomicCodec);
        this.deserializers.put(StackTraceElement.class, StackTraceElementDeserializer.instance);
        this.deserializers.put(Serializable.class, javaObjectDeserializer);
        this.deserializers.put(Cloneable.class, javaObjectDeserializer);
        this.deserializers.put(Comparable.class, javaObjectDeserializer);
        this.deserializers.put(Closeable.class, javaObjectDeserializer);
        this.deserializers.put(JSONPObject.class, new JSONPDeserializer());
        addItemsToDeny(DENYS);
        addItemsToAccept(AUTO_TYPE_ACCEPT_LIST);
    }

    public ObjectDeserializer getDeserializer(Class<?> cls, Type type) {
        ObjectDeserializer objectDeserializer;
        ObjectDeserializer objectDeserializer2;
        Class<?> mappingTo;
        ObjectDeserializer objectDeserializer3 = this.deserializers.get(type);
        if (objectDeserializer3 != null) {
            return objectDeserializer3;
        }
        if (type == null) {
            type = cls;
        }
        ObjectDeserializer objectDeserializer4 = this.deserializers.get(type);
        if (objectDeserializer4 != null) {
            return objectDeserializer4;
        }
        JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
        if (jSONType != null && (mappingTo = jSONType.mappingTo()) != Void.class) {
            return getDeserializer(mappingTo, mappingTo);
        }
        if ((type instanceof WildcardType) || (type instanceof TypeVariable) || (type instanceof ParameterizedType)) {
            objectDeserializer4 = this.deserializers.get(cls);
        }
        if (objectDeserializer4 != null) {
            return objectDeserializer4;
        }
        String replace = cls.getName().replace(v0.f47959c, '.');
        if (replace.startsWith("java.awt.") && AwtCodec.support(cls) && !awtError) {
            try {
                IdentityHashMap<Type, ObjectDeserializer> identityHashMap = this.deserializers;
                Class<?> cls2 = Class.forName("java.awt.Point");
                AwtCodec awtCodec = AwtCodec.instance;
                identityHashMap.put(cls2, awtCodec);
                this.deserializers.put(Class.forName("java.awt.Font"), awtCodec);
                this.deserializers.put(Class.forName("java.awt.Rectangle"), awtCodec);
                this.deserializers.put(Class.forName("java.awt.Color"), awtCodec);
            } catch (Throwable unused) {
                awtError = true;
            }
            objectDeserializer4 = AwtCodec.instance;
        }
        if (!jdk8Error) {
            try {
                if (replace.startsWith("java.time.")) {
                    IdentityHashMap<Type, ObjectDeserializer> identityHashMap2 = this.deserializers;
                    Class<?> cls3 = Class.forName("java.time.LocalDateTime");
                    Jdk8DateCodec jdk8DateCodec = Jdk8DateCodec.instance;
                    identityHashMap2.put(cls3, jdk8DateCodec);
                    this.deserializers.put(Class.forName("java.time.LocalDate"), jdk8DateCodec);
                    this.deserializers.put(Class.forName("java.time.LocalTime"), jdk8DateCodec);
                    this.deserializers.put(Class.forName("java.time.ZonedDateTime"), jdk8DateCodec);
                    this.deserializers.put(Class.forName("java.time.OffsetDateTime"), jdk8DateCodec);
                    this.deserializers.put(Class.forName("java.time.OffsetTime"), jdk8DateCodec);
                    this.deserializers.put(Class.forName("java.time.ZoneOffset"), jdk8DateCodec);
                    this.deserializers.put(Class.forName("java.time.ZoneRegion"), jdk8DateCodec);
                    this.deserializers.put(Class.forName("java.time.ZoneId"), jdk8DateCodec);
                    this.deserializers.put(Class.forName("java.time.Period"), jdk8DateCodec);
                    this.deserializers.put(Class.forName("java.time.Duration"), jdk8DateCodec);
                    this.deserializers.put(Class.forName("java.time.Instant"), jdk8DateCodec);
                    objectDeserializer = this.deserializers.get(cls);
                } else if (replace.startsWith("java.util.Optional")) {
                    this.deserializers.put(Class.forName("java.util.Optional"), OptionalCodec.instance);
                    this.deserializers.put(Class.forName("java.util.OptionalDouble"), OptionalCodec.instance);
                    this.deserializers.put(Class.forName("java.util.OptionalInt"), OptionalCodec.instance);
                    this.deserializers.put(Class.forName("java.util.OptionalLong"), OptionalCodec.instance);
                    objectDeserializer = this.deserializers.get(cls);
                }
                objectDeserializer4 = objectDeserializer;
            } catch (Throwable unused2) {
                jdk8Error = true;
            }
        }
        if (replace.equals("java.nio.file.Path")) {
            this.deserializers.put(cls, MiscCodec.instance);
        }
        if (cls == Map.Entry.class) {
            this.deserializers.put(cls, MiscCodec.instance);
        }
        try {
            for (AutowiredObjectDeserializer autowiredObjectDeserializer : ServiceLoader.load(AutowiredObjectDeserializer.class, Thread.currentThread().getContextClassLoader())) {
                Iterator<Type> it = autowiredObjectDeserializer.getAutowiredFor().iterator();
                while (it.hasNext()) {
                    this.deserializers.put(it.next(), autowiredObjectDeserializer);
                }
            }
        } catch (Exception unused3) {
        }
        if (objectDeserializer4 == null) {
            objectDeserializer4 = this.deserializers.get(type);
        }
        if (objectDeserializer4 != null) {
            return objectDeserializer4;
        }
        if (cls.isEnum()) {
            objectDeserializer2 = new EnumDeserializer(cls);
        } else if (cls.isArray()) {
            objectDeserializer2 = ObjectArrayCodec.instance;
        } else if (cls != Set.class && cls != HashSet.class && cls != Collection.class && cls != List.class && cls != ArrayList.class) {
            if (Collection.class.isAssignableFrom(cls)) {
                objectDeserializer2 = CollectionCodec.instance;
            } else if (Map.class.isAssignableFrom(cls)) {
                objectDeserializer2 = MapDeserializer.instance;
            } else if (Throwable.class.isAssignableFrom(cls)) {
                objectDeserializer2 = new ThrowableDeserializer(this, cls);
            } else {
                objectDeserializer2 = createJavaBeanDeserializer(cls, type);
            }
        } else {
            objectDeserializer2 = CollectionCodec.instance;
        }
        putDeserializer(type, objectDeserializer2);
        return objectDeserializer2;
    }

    public ObjectDeserializer getDeserializer(FieldInfo fieldInfo) {
        return getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
    }
}
