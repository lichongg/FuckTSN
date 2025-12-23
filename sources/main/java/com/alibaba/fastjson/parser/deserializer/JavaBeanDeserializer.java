package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import io.netty.util.internal.StringUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class JavaBeanDeserializer implements ObjectDeserializer {
    private final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    public final JavaBeanInfo beanInfo;
    protected final Class<?> clazz;
    private ConcurrentMap<String, Object> extraFieldDeserializers;
    private final FieldDeserializer[] fieldDeserializers;
    protected final FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls) {
        this(parserConfig, cls, cls);
    }

    static boolean isSetFlag(int i6, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        int i7 = i6 / 32;
        int i8 = i6 % 32;
        if (i7 < iArr.length) {
            if (((1 << i8) & iArr[i7]) != 0) {
                return true;
            }
        }
        return false;
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        Object newInstance;
        if ((type instanceof Class) && this.clazz.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject());
        }
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        Constructor<?> constructor = javaBeanInfo.defaultConstructor;
        Object obj = null;
        if (constructor == null && javaBeanInfo.factoryMethod == null) {
            return null;
        }
        Method method = javaBeanInfo.factoryMethod;
        if (method != null && javaBeanInfo.defaultConstructorParameterSize > 0) {
            return null;
        }
        try {
            if (javaBeanInfo.defaultConstructorParameterSize == 0) {
                newInstance = constructor != null ? constructor.newInstance(null) : method.invoke(null, null);
            } else {
                ParseContext context = defaultJSONParser.getContext();
                if (context == null || context.object == null) {
                    throw new JSONException("can't create non-static inner class instance.");
                }
                if (!(type instanceof Class)) {
                    throw new JSONException("can't create non-static inner class instance.");
                }
                String name = ((Class) type).getName();
                String substring = name.substring(0, name.lastIndexOf(36));
                Object obj2 = context.object;
                String name2 = obj2.getClass().getName();
                if (!name2.equals(substring)) {
                    ParseContext parseContext = context.parent;
                    if (parseContext != null && parseContext.object != null && (("java.util.ArrayList".equals(name2) || "java.util.List".equals(name2) || "java.util.Collection".equals(name2) || "java.util.Map".equals(name2) || "java.util.HashMap".equals(name2)) && parseContext.object.getClass().getName().equals(substring))) {
                        obj = parseContext.object;
                    }
                    obj2 = obj;
                }
                if (obj2 == null) {
                    throw new JSONException("can't create non-static inner class instance.");
                }
                newInstance = constructor.newInstance(obj2);
            }
            if (defaultJSONParser != null && defaultJSONParser.lexer.isEnabled(Feature.InitStringFieldAsEmpty)) {
                for (FieldInfo fieldInfo : this.beanInfo.fields) {
                    if (fieldInfo.fieldClass == String.class) {
                        try {
                            fieldInfo.set(newInstance, "");
                        } catch (Exception e6) {
                            throw new JSONException("create instance error, class " + this.clazz.getName(), e6);
                        }
                    }
                }
            }
            return newInstance;
        } catch (JSONException e7) {
            throw e7;
        } catch (Exception e8) {
            throw new JSONException("create instance error, class " + this.clazz.getName(), e8);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, 0);
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        return getFieldDeserializer(str, null);
    }

    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        return parseField(defaultJSONParser, str, obj, type, map, null);
    }

    protected Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i6) {
        return parseRest(defaultJSONParser, type, obj, obj2, i6, new int[0]);
    }

    protected Enum<?> scanEnum(JSONLexer jSONLexer, char c6) {
        throw new JSONException("illegal enum. " + jSONLexer.info());
    }

    public FieldDeserializer smartMatch(String str) {
        return smartMatch(str, null);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, JavaBeanInfo.build(cls, type, parserConfig.propertyNamingStrategy, parserConfig.fieldBased, parserConfig.compatibleWithJavaBean));
    }

    protected static void parseArray(Collection collection, ObjectDeserializer objectDeserializer, DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
        int i6 = jSONLexerBase.token();
        if (i6 == 8) {
            jSONLexerBase.nextToken(16);
            jSONLexerBase.token();
            return;
        }
        if (i6 != 14) {
            defaultJSONParser.throwException(i6);
        }
        if (jSONLexerBase.getCurrent() == '[') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(14);
        } else {
            jSONLexerBase.nextToken(14);
        }
        if (jSONLexerBase.token() == 15) {
            jSONLexerBase.nextToken();
            return;
        }
        int i7 = 0;
        while (true) {
            collection.add(objectDeserializer.deserialze(defaultJSONParser, type, Integer.valueOf(i7)));
            i7++;
            if (jSONLexerBase.token() != 16) {
                break;
            }
            if (jSONLexerBase.getCurrent() == '[') {
                jSONLexerBase.next();
                jSONLexerBase.setToken(14);
            } else {
                jSONLexerBase.nextToken(14);
            }
        }
        int i8 = jSONLexerBase.token();
        if (i8 != 15) {
            defaultJSONParser.throwException(i8);
        }
        if (jSONLexerBase.getCurrent() != ',') {
            jSONLexerBase.nextToken(16);
        } else {
            jSONLexerBase.next();
            jSONLexerBase.setToken(16);
        }
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, int i6) {
        return (T) deserialze(defaultJSONParser, type, obj, null, i6, null);
    }

    public <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() != 14) {
            throw new JSONException("error");
        }
        T t5 = (T) createInstance(defaultJSONParser, type);
        int length = this.sortedFieldDeserializers.length;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                jSONLexer.nextToken(16);
                return t5;
            }
            char c6 = i6 == length + (-1) ? ']' : StringUtil.COMMA;
            FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i6];
            Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
            if (cls == Integer.TYPE) {
                fieldDeserializer.setValue((Object) t5, jSONLexer.scanInt(c6));
            } else if (cls == String.class) {
                fieldDeserializer.setValue((Object) t5, jSONLexer.scanString(c6));
            } else if (cls == Long.TYPE) {
                fieldDeserializer.setValue(t5, jSONLexer.scanLong(c6));
            } else if (cls.isEnum()) {
                char current = jSONLexer.getCurrent();
                fieldDeserializer.setValue(t5, (current == '\"' || current == 'n') ? jSONLexer.scanEnum(cls, defaultJSONParser.getSymbolTable(), c6) : (current < '0' || current > '9') ? scanEnum(jSONLexer, c6) : ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.getConfig())).valueOf(jSONLexer.scanInt(c6)));
            } else if (cls == Boolean.TYPE) {
                fieldDeserializer.setValue(t5, jSONLexer.scanBoolean(c6));
            } else if (cls == Float.TYPE) {
                fieldDeserializer.setValue(t5, Float.valueOf(jSONLexer.scanFloat(c6)));
            } else if (cls == Double.TYPE) {
                fieldDeserializer.setValue(t5, Double.valueOf(jSONLexer.scanDouble(c6)));
            } else if (cls == Date.class && jSONLexer.getCurrent() == '1') {
                fieldDeserializer.setValue(t5, new Date(jSONLexer.scanLong(c6)));
            } else {
                jSONLexer.nextToken(14);
                fieldDeserializer.setValue(t5, defaultJSONParser.parseObject(fieldDeserializer.fieldInfo.fieldType));
                check(jSONLexer, c6 == ']' ? 15 : 16);
            }
            i6++;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    public FieldDeserializer getFieldDeserializer(String str, int[] iArr) {
        if (str == null) {
            return null;
        }
        int length = this.sortedFieldDeserializers.length - 1;
        int i6 = 0;
        while (i6 <= length) {
            int i7 = (i6 + length) >>> 1;
            int compareTo = this.sortedFieldDeserializers[i7].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i6 = i7 + 1;
            } else {
                if (compareTo <= 0) {
                    if (isSetFlag(i7, iArr)) {
                        return null;
                    }
                    return this.sortedFieldDeserializers[i7];
                }
                length = i7 - 1;
            }
        }
        return null;
    }

    public Type getFieldType(int i6) {
        return this.sortedFieldDeserializers[i6].fieldInfo.fieldType;
    }

    protected JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        JSONType jSONType = javaBeanInfo.jsonType;
        if (jSONType == null) {
            return null;
        }
        for (Class<?> cls : jSONType.seeAlso()) {
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            if (deserializer instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bb  */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r17v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean parseField(com.alibaba.fastjson.parser.DefaultJSONParser r20, java.lang.String r21, java.lang.Object r22, java.lang.reflect.Type r23, java.util.Map<java.lang.String, java.lang.Object> r24, int[] r25) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.parseField(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.String, java.lang.Object, java.lang.reflect.Type, java.util.Map, int[]):boolean");
    }

    protected Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i6, int[] iArr) {
        return deserialze(defaultJSONParser, type, obj, obj2, i6, iArr);
    }

    protected Enum scanEnum(JSONLexerBase jSONLexerBase, char[] cArr, ObjectDeserializer objectDeserializer) {
        EnumDeserializer enumDeserializer = objectDeserializer instanceof EnumDeserializer ? (EnumDeserializer) objectDeserializer : null;
        if (enumDeserializer == null) {
            jSONLexerBase.matchStat = -1;
            return null;
        }
        long scanFieldSymbol = jSONLexerBase.scanFieldSymbol(cArr);
        if (jSONLexerBase.matchStat > 0) {
            return enumDeserializer.getEnumByHashCode(scanFieldSymbol);
        }
        return null;
    }

    public FieldDeserializer smartMatch(String str, int[] iArr) {
        Map<String, FieldDeserializer> map;
        boolean z5;
        String str2 = null;
        if (str == null) {
            return null;
        }
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str, iArr);
        int i6 = 0;
        if (fieldDeserializer == null) {
            boolean startsWith = str.startsWith("is");
            for (int i7 = 0; i7 < this.sortedFieldDeserializers.length; i7++) {
                if (!isSetFlag(i7, iArr)) {
                    FieldDeserializer fieldDeserializer2 = this.sortedFieldDeserializers[i7];
                    FieldInfo fieldInfo = fieldDeserializer2.fieldInfo;
                    if ((fieldInfo.parserFeatures & Feature.DisableFieldSmartMatch.mask) != 0) {
                        return null;
                    }
                    Class<?> cls = fieldInfo.fieldClass;
                    String str3 = fieldInfo.name;
                    if (str3.equalsIgnoreCase(str) || (startsWith && ((cls == Boolean.TYPE || cls == Boolean.class) && str3.equalsIgnoreCase(str.substring(2))))) {
                        fieldDeserializer = fieldDeserializer2;
                        break;
                    }
                }
            }
        }
        if (fieldDeserializer == null) {
            int i8 = 0;
            while (true) {
                if (i8 >= str.length()) {
                    z5 = false;
                    break;
                }
                char charAt = str.charAt(i8);
                z5 = true;
                if (charAt == '_') {
                    str2 = str.replaceAll("_", "");
                    break;
                }
                if (charAt == '-') {
                    str2 = str.replaceAll("-", "");
                    break;
                }
                i8++;
            }
            if (z5 && (fieldDeserializer = getFieldDeserializer(str2, iArr)) == null) {
                while (true) {
                    if (i6 >= this.sortedFieldDeserializers.length) {
                        break;
                    }
                    if (!isSetFlag(i6, iArr)) {
                        FieldDeserializer fieldDeserializer3 = this.sortedFieldDeserializers[i6];
                        if (fieldDeserializer3.fieldInfo.name.equalsIgnoreCase(str2)) {
                            fieldDeserializer = fieldDeserializer3;
                            break;
                        }
                    }
                    i6++;
                }
            }
        }
        return (fieldDeserializer != null || (map = this.alterNameFieldDeserializers) == null) ? fieldDeserializer : map.get(str);
    }

    protected void check(JSONLexer jSONLexer, int i6) {
        if (jSONLexer.token() == i6) {
        } else {
            throw new JSONException("syntax error");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:149:0x036f, code lost:
    
        r4 = r27.getConfig();
        r5 = r1.getSeeAlso(r4, r1.beanInfo, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0379, code lost:
    
        if (r5 != null) goto L261;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x037b, code lost:
    
        r10 = r4.checkAutoType(r3, com.alibaba.fastjson.util.TypeUtils.getClass(r28));
        r5 = r27.getConfig().getDeserializer(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x038d, code lost:
    
        r0 = (T) r5.deserialze(r27, r10, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0393, code lost:
    
        if ((r5 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0395, code lost:
    
        r5 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0397, code lost:
    
        if (r15 == null) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0399, code lost:
    
        r5.getFieldDeserializer(r15).setValue((java.lang.Object) r0, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x03a0, code lost:
    
        if (r7 == null) goto L269;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x03a2, code lost:
    
        r7.object = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x03a6, code lost:
    
        r27.setContext(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x03a9, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x038c, code lost:
    
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x03bc, code lost:
    
        r14 = r5;
        r4 = (T) r9;
        r10 = r18;
        r13 = r24;
        r9 = r6;
        r6 = r16;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x04ee, code lost:
    
        if (r4 != null) goto L395;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x04f0, code lost:
    
        if (r6 != null) goto L357;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x04f2, code lost:
    
        r3 = (T) createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r27, r28);
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x04f6, code lost:
    
        if (r7 != null) goto L351;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x04f8, code lost:
    
        r7 = r27.setContext(r11, r3, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x04fc, code lost:
    
        if (r7 == null) goto L353;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x04fe, code lost:
    
        r7.object = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0500, code lost:
    
        r27.setContext(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0503, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0507, code lost:
    
        r0 = r1.beanInfo.fields;
        r3 = r0.length;
        r5 = new java.lang.Object[r3];
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x050f, code lost:
    
        if (r8 >= r3) goto L463;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0511, code lost:
    
        r15 = r0[r8];
        r16 = r0;
        r0 = r6.get(r15.name);
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x051b, code lost:
    
        if (r0 != null) goto L377;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x051d, code lost:
    
        r15 = r15.fieldType;
        r28 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0523, code lost:
    
        if (r15 != java.lang.Byte.TYPE) goto L364;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0525, code lost:
    
        r0 = (byte) 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x055d, code lost:
    
        r5[r8] = r0;
        r8 = r8 + 1;
        r0 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x052c, code lost:
    
        if (r15 != java.lang.Short.TYPE) goto L367;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x052e, code lost:
    
        r0 = (short) 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0533, code lost:
    
        if (r15 != r14) goto L369;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0535, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x053a, code lost:
    
        if (r15 != r9) goto L371;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x053c, code lost:
    
        r0 = 0L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0543, code lost:
    
        if (r15 != r12) goto L373;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0545, code lost:
    
        r0 = java.lang.Float.valueOf(0.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x054b, code lost:
    
        if (r15 != r13) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x054d, code lost:
    
        r0 = java.lang.Double.valueOf(0.0d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x0554, code lost:
    
        if (r15 != r10) goto L378;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0556, code lost:
    
        r0 = java.lang.Boolean.FALSE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x055b, code lost:
    
        r0 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0559, code lost:
    
        r28 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0564, code lost:
    
        r0 = r1.beanInfo;
        r3 = r0.creatorConstructor;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x0568, code lost:
    
        if (r3 == null) goto L387;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0590, code lost:
    
        r0 = r0.factoryMethod;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0592, code lost:
    
        if (r0 == null) goto L395;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0595, code lost:
    
        r0 = r0.invoke(null, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x056e, code lost:
    
        r4 = (T) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x059a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x05b9, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create factory method error, " + r1.beanInfo.factoryMethod.toString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x056a, code lost:
    
        r0 = r3.newInstance(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0570, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x058f, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error, " + r1.beanInfo.creatorConstructor.toGenericString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x05ba, code lost:
    
        r0 = r1.beanInfo.buildMethod;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x05be, code lost:
    
        if (r0 != null) goto L401;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x05c0, code lost:
    
        if (r7 == null) goto L399;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x05c2, code lost:
    
        r7.object = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x05c4, code lost:
    
        r27.setContext(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x05c7, code lost:
    
        return (T) r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x05c9, code lost:
    
        r0 = (T) r0.invoke(r4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x05cd, code lost:
    
        if (r7 == null) goto L405;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x05cf, code lost:
    
        r7.object = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x05d1, code lost:
    
        r27.setContext(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x05d4, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x05d5, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x05dd, code lost:
    
        throw new com.alibaba.fastjson.JSONException("build object error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0504, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x04ec, code lost:
    
        r7 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:445:0x0253, code lost:
    
        if (r4 == (-2)) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0289, code lost:
    
        if (r8.isEnabled(com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas) != false) goto L94;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:261:0x03f3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x04e1 A[Catch: all -> 0x04c3, TryCatch #2 {all -> 0x04c3, blocks: (B:90:0x05f2, B:275:0x04d7, B:280:0x04e1, B:292:0x04e9, B:283:0x05df, B:285:0x05e7, B:288:0x0604, B:289:0x0622, B:321:0x04b1, B:323:0x04b7, B:327:0x04bf, B:328:0x04cf, B:331:0x0623, B:332:0x062a), top: B:89:0x05f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0473 A[Catch: all -> 0x0443, TryCatch #1 {all -> 0x0443, blocks: (B:273:0x042f, B:299:0x044e, B:302:0x0473, B:303:0x0483, B:318:0x0468, B:319:0x046c), top: B:272:0x042f }] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0488 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0635  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.alibaba.fastjson.parser.ParseContext] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r27v0, types: [com.alibaba.fastjson.parser.DefaultJSONParser] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.alibaba.fastjson.parser.ParseContext] */
    /* JADX WARN: Type inference failed for: r7v11, types: [com.alibaba.fastjson.parser.ParseContext] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r27, java.lang.reflect.Type r28, java.lang.Object r29, java.lang.Object r30, int r31, int[] r32) {
        /*
            Method dump skipped, instructions count: 1600
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object, int, int[]):java.lang.Object");
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) {
        this.clazz = javaBeanInfo.clazz;
        this.beanInfo = javaBeanInfo;
        FieldInfo[] fieldInfoArr = javaBeanInfo.sortedFields;
        this.sortedFieldDeserializers = new FieldDeserializer[fieldInfoArr.length];
        int length = fieldInfoArr.length;
        HashMap hashMap = null;
        for (int i6 = 0; i6 < length; i6++) {
            FieldInfo fieldInfo = javaBeanInfo.sortedFields[i6];
            FieldDeserializer createFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, javaBeanInfo, fieldInfo);
            this.sortedFieldDeserializers[i6] = createFieldDeserializer;
            for (String str : fieldInfo.alternateNames) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(str, createFieldDeserializer);
            }
        }
        this.alterNameFieldDeserializers = hashMap;
        FieldInfo[] fieldInfoArr2 = javaBeanInfo.fields;
        this.fieldDeserializers = new FieldDeserializer[fieldInfoArr2.length];
        int length2 = fieldInfoArr2.length;
        for (int i7 = 0; i7 < length2; i7++) {
            this.fieldDeserializers[i7] = getFieldDeserializer(javaBeanInfo.fields[i7].name);
        }
    }

    public Object createInstance(Map<String, Object> map, ParserConfig parserConfig) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        if (javaBeanInfo.creatorConstructor == null && javaBeanInfo.factoryMethod == null) {
            Object createInstance = createInstance((DefaultJSONParser) null, this.clazz);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                FieldDeserializer smartMatch = smartMatch(key);
                if (smartMatch != null) {
                    smartMatch.setValue(createInstance, TypeUtils.cast(value, smartMatch.fieldInfo.fieldType, parserConfig));
                }
            }
            Method method = this.beanInfo.buildMethod;
            if (method == null) {
                return createInstance;
            }
            try {
                return method.invoke(createInstance, null);
            } catch (Exception e6) {
                throw new JSONException("build object error", e6);
            }
        }
        FieldInfo[] fieldInfoArr = javaBeanInfo.fields;
        int length = fieldInfoArr.length;
        Object[] objArr = new Object[length];
        for (int i6 = 0; i6 < length; i6++) {
            objArr[i6] = map.get(fieldInfoArr[i6].name);
        }
        JavaBeanInfo javaBeanInfo2 = this.beanInfo;
        Constructor<?> constructor = javaBeanInfo2.creatorConstructor;
        if (constructor != null) {
            try {
                return constructor.newInstance(objArr);
            } catch (Exception e7) {
                throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e7);
            }
        }
        Method method2 = javaBeanInfo2.factoryMethod;
        if (method2 == null) {
            return null;
        }
        try {
            return method2.invoke(null, objArr);
        } catch (Exception e8) {
            throw new JSONException("create factory method error, " + this.beanInfo.factoryMethod.toString(), e8);
        }
    }
}
