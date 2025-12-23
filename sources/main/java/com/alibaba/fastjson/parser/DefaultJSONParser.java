package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    private static final Set<Class<?>> primitiveClasses = new HashSet();
    private String[] autoTypeAccept;
    private boolean autoTypeEnable;
    protected ParserConfig config;
    protected ParseContext context;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private List<ExtraProcessor> extraProcessors;
    private List<ExtraTypeProvider> extraTypeProviders;
    protected FieldTypeResolver fieldTypeResolver;
    public final Object input;
    protected transient BeanContext lastBeanContext;
    public final JSONLexer lexer;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
    }

    public final void accept(int i6) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i6) {
            jSONLexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i6) + ", actual " + JSONToken.name(jSONLexer.token()));
    }

    public Object getObject(String str) {
        for (int i6 = 0; i6 < this.contextArrayIndex; i6++) {
            if (str.equals(this.contextArray[i6].toString())) {
                return this.contextArray[i6].object;
            }
        }
        return null;
    }

    public Object parse() {
        return parse(null);
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x020b, code lost:
    
        r4.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0216, code lost:
    
        if (r4.token() != 13) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0218, code lost:
    
        r4.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x021b, code lost:
    
        r0 = r17.config.getDeserializer(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0223, code lost:
    
        if ((r0 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0225, code lost:
    
        r14 = ((com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r0).createInstance(r17, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x022f, code lost:
    
        if (r14 != null) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0233, code lost:
    
        if (r7 != java.lang.Cloneable.class) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0235, code lost:
    
        r14 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0241, code lost:
    
        if ("java.util.Collections$EmptyMap".equals(r6) == false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0243, code lost:
    
        r14 = java.util.Collections.EMPTY_MAP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0246, code lost:
    
        r14 = r7.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x024d, code lost:
    
        return r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x022d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0255, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0256, code lost:
    
        setResolveStatus(2);
        r3 = r17.context;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x025c, code lost:
    
        if (r3 == null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0260, code lost:
    
        if ((r19 instanceof java.lang.Integer) != false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0266, code lost:
    
        if ((r3.fieldName instanceof java.lang.Integer) != false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0268, code lost:
    
        popContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x026f, code lost:
    
        if (r18.size() <= 0) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0271, code lost:
    
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r18, (java.lang.Class<java.lang.Object>) r7, r17.config);
        parseObject(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x027d, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x028b, code lost:
    
        return r17.config.getDeserializer(r7).deserialze(r17, r7, r19);
     */
    /* JADX WARN: Removed duplicated region for block: B:126:0x034b A[Catch: all -> 0x007c, TryCatch #2 {all -> 0x007c, blocks: (B:18:0x005e, B:21:0x0071, B:25:0x008e, B:29:0x01d5, B:30:0x01db, B:32:0x01e6, B:34:0x01ee, B:36:0x01ff, B:40:0x020b, B:42:0x0218, B:44:0x021b, B:46:0x0225, B:50:0x0235, B:51:0x023b, B:53:0x0243, B:54:0x0246, B:59:0x024e, B:60:0x0255, B:61:0x0256, B:63:0x025e, B:65:0x0262, B:67:0x0268, B:68:0x026b, B:70:0x0271, B:73:0x027e, B:80:0x0293, B:83:0x029b, B:85:0x02a5, B:87:0x02b6, B:89:0x02ba, B:91:0x02c0, B:94:0x02c5, B:96:0x02c9, B:97:0x0313, B:99:0x031b, B:102:0x0324, B:103:0x0329, B:106:0x02cc, B:108:0x02d4, B:110:0x02da, B:111:0x02e6, B:114:0x02ef, B:118:0x02f5, B:121:0x02fb, B:122:0x0307, B:123:0x032a, B:124:0x0348, B:126:0x034b, B:128:0x034f, B:130:0x0353, B:133:0x0359, B:137:0x0361, B:143:0x036f, B:146:0x0378, B:148:0x0387, B:150:0x0392, B:151:0x039a, B:152:0x039d, B:153:0x03c9, B:155:0x03d2, B:162:0x03dd, B:165:0x03ed, B:166:0x040d, B:171:0x03ad, B:173:0x03b7, B:174:0x03c6, B:175:0x03bc, B:180:0x0412, B:182:0x041c, B:184:0x0424, B:185:0x0427, B:187:0x0432, B:188:0x0436, B:197:0x0441, B:190:0x0448, B:194:0x0451, B:195:0x0456, B:202:0x045b, B:204:0x0460, B:207:0x046b, B:209:0x0478, B:210:0x047e, B:213:0x0484, B:214:0x048a, B:216:0x0492, B:218:0x04a4, B:221:0x04ac, B:222:0x04ae, B:224:0x04bb, B:226:0x04c8, B:227:0x04cb, B:238:0x04d3, B:229:0x04dd, B:232:0x04e7, B:233:0x04ec, B:235:0x04f1, B:236:0x050b, B:241:0x04c3, B:246:0x050c, B:248:0x0519, B:249:0x051d, B:257:0x0528, B:251:0x052f, B:254:0x0539, B:255:0x0559, B:261:0x00a0, B:262:0x00be, B:325:0x00c1, B:327:0x00cc, B:329:0x00d0, B:331:0x00d4, B:334:0x00da, B:266:0x00e9, B:268:0x00f1, B:272:0x0101, B:273:0x0119, B:275:0x011a, B:276:0x011f, B:284:0x0132, B:286:0x0138, B:288:0x013f, B:289:0x0148, B:293:0x0150, B:294:0x0168, B:295:0x0144, B:297:0x0169, B:298:0x0181, B:306:0x018b, B:308:0x0193, B:312:0x01a4, B:313:0x01c4, B:315:0x01c5, B:316:0x01ca, B:317:0x01cb, B:319:0x055a, B:320:0x055f, B:322:0x0560, B:323:0x0565), top: B:17:0x005e, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0378 A[Catch: all -> 0x007c, TryCatch #2 {all -> 0x007c, blocks: (B:18:0x005e, B:21:0x0071, B:25:0x008e, B:29:0x01d5, B:30:0x01db, B:32:0x01e6, B:34:0x01ee, B:36:0x01ff, B:40:0x020b, B:42:0x0218, B:44:0x021b, B:46:0x0225, B:50:0x0235, B:51:0x023b, B:53:0x0243, B:54:0x0246, B:59:0x024e, B:60:0x0255, B:61:0x0256, B:63:0x025e, B:65:0x0262, B:67:0x0268, B:68:0x026b, B:70:0x0271, B:73:0x027e, B:80:0x0293, B:83:0x029b, B:85:0x02a5, B:87:0x02b6, B:89:0x02ba, B:91:0x02c0, B:94:0x02c5, B:96:0x02c9, B:97:0x0313, B:99:0x031b, B:102:0x0324, B:103:0x0329, B:106:0x02cc, B:108:0x02d4, B:110:0x02da, B:111:0x02e6, B:114:0x02ef, B:118:0x02f5, B:121:0x02fb, B:122:0x0307, B:123:0x032a, B:124:0x0348, B:126:0x034b, B:128:0x034f, B:130:0x0353, B:133:0x0359, B:137:0x0361, B:143:0x036f, B:146:0x0378, B:148:0x0387, B:150:0x0392, B:151:0x039a, B:152:0x039d, B:153:0x03c9, B:155:0x03d2, B:162:0x03dd, B:165:0x03ed, B:166:0x040d, B:171:0x03ad, B:173:0x03b7, B:174:0x03c6, B:175:0x03bc, B:180:0x0412, B:182:0x041c, B:184:0x0424, B:185:0x0427, B:187:0x0432, B:188:0x0436, B:197:0x0441, B:190:0x0448, B:194:0x0451, B:195:0x0456, B:202:0x045b, B:204:0x0460, B:207:0x046b, B:209:0x0478, B:210:0x047e, B:213:0x0484, B:214:0x048a, B:216:0x0492, B:218:0x04a4, B:221:0x04ac, B:222:0x04ae, B:224:0x04bb, B:226:0x04c8, B:227:0x04cb, B:238:0x04d3, B:229:0x04dd, B:232:0x04e7, B:233:0x04ec, B:235:0x04f1, B:236:0x050b, B:241:0x04c3, B:246:0x050c, B:248:0x0519, B:249:0x051d, B:257:0x0528, B:251:0x052f, B:254:0x0539, B:255:0x0559, B:261:0x00a0, B:262:0x00be, B:325:0x00c1, B:327:0x00cc, B:329:0x00d0, B:331:0x00d4, B:334:0x00da, B:266:0x00e9, B:268:0x00f1, B:272:0x0101, B:273:0x0119, B:275:0x011a, B:276:0x011f, B:284:0x0132, B:286:0x0138, B:288:0x013f, B:289:0x0148, B:293:0x0150, B:294:0x0168, B:295:0x0144, B:297:0x0169, B:298:0x0181, B:306:0x018b, B:308:0x0193, B:312:0x01a4, B:313:0x01c4, B:315:0x01c5, B:316:0x01ca, B:317:0x01cb, B:319:0x055a, B:320:0x055f, B:322:0x0560, B:323:0x0565), top: B:17:0x005e, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03d2 A[Catch: all -> 0x007c, TryCatch #2 {all -> 0x007c, blocks: (B:18:0x005e, B:21:0x0071, B:25:0x008e, B:29:0x01d5, B:30:0x01db, B:32:0x01e6, B:34:0x01ee, B:36:0x01ff, B:40:0x020b, B:42:0x0218, B:44:0x021b, B:46:0x0225, B:50:0x0235, B:51:0x023b, B:53:0x0243, B:54:0x0246, B:59:0x024e, B:60:0x0255, B:61:0x0256, B:63:0x025e, B:65:0x0262, B:67:0x0268, B:68:0x026b, B:70:0x0271, B:73:0x027e, B:80:0x0293, B:83:0x029b, B:85:0x02a5, B:87:0x02b6, B:89:0x02ba, B:91:0x02c0, B:94:0x02c5, B:96:0x02c9, B:97:0x0313, B:99:0x031b, B:102:0x0324, B:103:0x0329, B:106:0x02cc, B:108:0x02d4, B:110:0x02da, B:111:0x02e6, B:114:0x02ef, B:118:0x02f5, B:121:0x02fb, B:122:0x0307, B:123:0x032a, B:124:0x0348, B:126:0x034b, B:128:0x034f, B:130:0x0353, B:133:0x0359, B:137:0x0361, B:143:0x036f, B:146:0x0378, B:148:0x0387, B:150:0x0392, B:151:0x039a, B:152:0x039d, B:153:0x03c9, B:155:0x03d2, B:162:0x03dd, B:165:0x03ed, B:166:0x040d, B:171:0x03ad, B:173:0x03b7, B:174:0x03c6, B:175:0x03bc, B:180:0x0412, B:182:0x041c, B:184:0x0424, B:185:0x0427, B:187:0x0432, B:188:0x0436, B:197:0x0441, B:190:0x0448, B:194:0x0451, B:195:0x0456, B:202:0x045b, B:204:0x0460, B:207:0x046b, B:209:0x0478, B:210:0x047e, B:213:0x0484, B:214:0x048a, B:216:0x0492, B:218:0x04a4, B:221:0x04ac, B:222:0x04ae, B:224:0x04bb, B:226:0x04c8, B:227:0x04cb, B:238:0x04d3, B:229:0x04dd, B:232:0x04e7, B:233:0x04ec, B:235:0x04f1, B:236:0x050b, B:241:0x04c3, B:246:0x050c, B:248:0x0519, B:249:0x051d, B:257:0x0528, B:251:0x052f, B:254:0x0539, B:255:0x0559, B:261:0x00a0, B:262:0x00be, B:325:0x00c1, B:327:0x00cc, B:329:0x00d0, B:331:0x00d4, B:334:0x00da, B:266:0x00e9, B:268:0x00f1, B:272:0x0101, B:273:0x0119, B:275:0x011a, B:276:0x011f, B:284:0x0132, B:286:0x0138, B:288:0x013f, B:289:0x0148, B:293:0x0150, B:294:0x0168, B:295:0x0144, B:297:0x0169, B:298:0x0181, B:306:0x018b, B:308:0x0193, B:312:0x01a4, B:313:0x01c4, B:315:0x01c5, B:316:0x01ca, B:317:0x01cb, B:319:0x055a, B:320:0x055f, B:322:0x0560, B:323:0x0565), top: B:17:0x005e, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03db A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x04a4 A[Catch: all -> 0x007c, TryCatch #2 {all -> 0x007c, blocks: (B:18:0x005e, B:21:0x0071, B:25:0x008e, B:29:0x01d5, B:30:0x01db, B:32:0x01e6, B:34:0x01ee, B:36:0x01ff, B:40:0x020b, B:42:0x0218, B:44:0x021b, B:46:0x0225, B:50:0x0235, B:51:0x023b, B:53:0x0243, B:54:0x0246, B:59:0x024e, B:60:0x0255, B:61:0x0256, B:63:0x025e, B:65:0x0262, B:67:0x0268, B:68:0x026b, B:70:0x0271, B:73:0x027e, B:80:0x0293, B:83:0x029b, B:85:0x02a5, B:87:0x02b6, B:89:0x02ba, B:91:0x02c0, B:94:0x02c5, B:96:0x02c9, B:97:0x0313, B:99:0x031b, B:102:0x0324, B:103:0x0329, B:106:0x02cc, B:108:0x02d4, B:110:0x02da, B:111:0x02e6, B:114:0x02ef, B:118:0x02f5, B:121:0x02fb, B:122:0x0307, B:123:0x032a, B:124:0x0348, B:126:0x034b, B:128:0x034f, B:130:0x0353, B:133:0x0359, B:137:0x0361, B:143:0x036f, B:146:0x0378, B:148:0x0387, B:150:0x0392, B:151:0x039a, B:152:0x039d, B:153:0x03c9, B:155:0x03d2, B:162:0x03dd, B:165:0x03ed, B:166:0x040d, B:171:0x03ad, B:173:0x03b7, B:174:0x03c6, B:175:0x03bc, B:180:0x0412, B:182:0x041c, B:184:0x0424, B:185:0x0427, B:187:0x0432, B:188:0x0436, B:197:0x0441, B:190:0x0448, B:194:0x0451, B:195:0x0456, B:202:0x045b, B:204:0x0460, B:207:0x046b, B:209:0x0478, B:210:0x047e, B:213:0x0484, B:214:0x048a, B:216:0x0492, B:218:0x04a4, B:221:0x04ac, B:222:0x04ae, B:224:0x04bb, B:226:0x04c8, B:227:0x04cb, B:238:0x04d3, B:229:0x04dd, B:232:0x04e7, B:233:0x04ec, B:235:0x04f1, B:236:0x050b, B:241:0x04c3, B:246:0x050c, B:248:0x0519, B:249:0x051d, B:257:0x0528, B:251:0x052f, B:254:0x0539, B:255:0x0559, B:261:0x00a0, B:262:0x00be, B:325:0x00c1, B:327:0x00cc, B:329:0x00d0, B:331:0x00d4, B:334:0x00da, B:266:0x00e9, B:268:0x00f1, B:272:0x0101, B:273:0x0119, B:275:0x011a, B:276:0x011f, B:284:0x0132, B:286:0x0138, B:288:0x013f, B:289:0x0148, B:293:0x0150, B:294:0x0168, B:295:0x0144, B:297:0x0169, B:298:0x0181, B:306:0x018b, B:308:0x0193, B:312:0x01a4, B:313:0x01c4, B:315:0x01c5, B:316:0x01ca, B:317:0x01cb, B:319:0x055a, B:320:0x055f, B:322:0x0560, B:323:0x0565), top: B:17:0x005e, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x04bb A[Catch: all -> 0x007c, TryCatch #2 {all -> 0x007c, blocks: (B:18:0x005e, B:21:0x0071, B:25:0x008e, B:29:0x01d5, B:30:0x01db, B:32:0x01e6, B:34:0x01ee, B:36:0x01ff, B:40:0x020b, B:42:0x0218, B:44:0x021b, B:46:0x0225, B:50:0x0235, B:51:0x023b, B:53:0x0243, B:54:0x0246, B:59:0x024e, B:60:0x0255, B:61:0x0256, B:63:0x025e, B:65:0x0262, B:67:0x0268, B:68:0x026b, B:70:0x0271, B:73:0x027e, B:80:0x0293, B:83:0x029b, B:85:0x02a5, B:87:0x02b6, B:89:0x02ba, B:91:0x02c0, B:94:0x02c5, B:96:0x02c9, B:97:0x0313, B:99:0x031b, B:102:0x0324, B:103:0x0329, B:106:0x02cc, B:108:0x02d4, B:110:0x02da, B:111:0x02e6, B:114:0x02ef, B:118:0x02f5, B:121:0x02fb, B:122:0x0307, B:123:0x032a, B:124:0x0348, B:126:0x034b, B:128:0x034f, B:130:0x0353, B:133:0x0359, B:137:0x0361, B:143:0x036f, B:146:0x0378, B:148:0x0387, B:150:0x0392, B:151:0x039a, B:152:0x039d, B:153:0x03c9, B:155:0x03d2, B:162:0x03dd, B:165:0x03ed, B:166:0x040d, B:171:0x03ad, B:173:0x03b7, B:174:0x03c6, B:175:0x03bc, B:180:0x0412, B:182:0x041c, B:184:0x0424, B:185:0x0427, B:187:0x0432, B:188:0x0436, B:197:0x0441, B:190:0x0448, B:194:0x0451, B:195:0x0456, B:202:0x045b, B:204:0x0460, B:207:0x046b, B:209:0x0478, B:210:0x047e, B:213:0x0484, B:214:0x048a, B:216:0x0492, B:218:0x04a4, B:221:0x04ac, B:222:0x04ae, B:224:0x04bb, B:226:0x04c8, B:227:0x04cb, B:238:0x04d3, B:229:0x04dd, B:232:0x04e7, B:233:0x04ec, B:235:0x04f1, B:236:0x050b, B:241:0x04c3, B:246:0x050c, B:248:0x0519, B:249:0x051d, B:257:0x0528, B:251:0x052f, B:254:0x0539, B:255:0x0559, B:261:0x00a0, B:262:0x00be, B:325:0x00c1, B:327:0x00cc, B:329:0x00d0, B:331:0x00d4, B:334:0x00da, B:266:0x00e9, B:268:0x00f1, B:272:0x0101, B:273:0x0119, B:275:0x011a, B:276:0x011f, B:284:0x0132, B:286:0x0138, B:288:0x013f, B:289:0x0148, B:293:0x0150, B:294:0x0168, B:295:0x0144, B:297:0x0169, B:298:0x0181, B:306:0x018b, B:308:0x0193, B:312:0x01a4, B:313:0x01c4, B:315:0x01c5, B:316:0x01ca, B:317:0x01cb, B:319:0x055a, B:320:0x055f, B:322:0x0560, B:323:0x0565), top: B:17:0x005e, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x04c8 A[Catch: all -> 0x007c, TryCatch #2 {all -> 0x007c, blocks: (B:18:0x005e, B:21:0x0071, B:25:0x008e, B:29:0x01d5, B:30:0x01db, B:32:0x01e6, B:34:0x01ee, B:36:0x01ff, B:40:0x020b, B:42:0x0218, B:44:0x021b, B:46:0x0225, B:50:0x0235, B:51:0x023b, B:53:0x0243, B:54:0x0246, B:59:0x024e, B:60:0x0255, B:61:0x0256, B:63:0x025e, B:65:0x0262, B:67:0x0268, B:68:0x026b, B:70:0x0271, B:73:0x027e, B:80:0x0293, B:83:0x029b, B:85:0x02a5, B:87:0x02b6, B:89:0x02ba, B:91:0x02c0, B:94:0x02c5, B:96:0x02c9, B:97:0x0313, B:99:0x031b, B:102:0x0324, B:103:0x0329, B:106:0x02cc, B:108:0x02d4, B:110:0x02da, B:111:0x02e6, B:114:0x02ef, B:118:0x02f5, B:121:0x02fb, B:122:0x0307, B:123:0x032a, B:124:0x0348, B:126:0x034b, B:128:0x034f, B:130:0x0353, B:133:0x0359, B:137:0x0361, B:143:0x036f, B:146:0x0378, B:148:0x0387, B:150:0x0392, B:151:0x039a, B:152:0x039d, B:153:0x03c9, B:155:0x03d2, B:162:0x03dd, B:165:0x03ed, B:166:0x040d, B:171:0x03ad, B:173:0x03b7, B:174:0x03c6, B:175:0x03bc, B:180:0x0412, B:182:0x041c, B:184:0x0424, B:185:0x0427, B:187:0x0432, B:188:0x0436, B:197:0x0441, B:190:0x0448, B:194:0x0451, B:195:0x0456, B:202:0x045b, B:204:0x0460, B:207:0x046b, B:209:0x0478, B:210:0x047e, B:213:0x0484, B:214:0x048a, B:216:0x0492, B:218:0x04a4, B:221:0x04ac, B:222:0x04ae, B:224:0x04bb, B:226:0x04c8, B:227:0x04cb, B:238:0x04d3, B:229:0x04dd, B:232:0x04e7, B:233:0x04ec, B:235:0x04f1, B:236:0x050b, B:241:0x04c3, B:246:0x050c, B:248:0x0519, B:249:0x051d, B:257:0x0528, B:251:0x052f, B:254:0x0539, B:255:0x0559, B:261:0x00a0, B:262:0x00be, B:325:0x00c1, B:327:0x00cc, B:329:0x00d0, B:331:0x00d4, B:334:0x00da, B:266:0x00e9, B:268:0x00f1, B:272:0x0101, B:273:0x0119, B:275:0x011a, B:276:0x011f, B:284:0x0132, B:286:0x0138, B:288:0x013f, B:289:0x0148, B:293:0x0150, B:294:0x0168, B:295:0x0144, B:297:0x0169, B:298:0x0181, B:306:0x018b, B:308:0x0193, B:312:0x01a4, B:313:0x01c4, B:315:0x01c5, B:316:0x01ca, B:317:0x01cb, B:319:0x055a, B:320:0x055f, B:322:0x0560, B:323:0x0565), top: B:17:0x005e, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x04dd A[Catch: all -> 0x007c, TRY_ENTER, TryCatch #2 {all -> 0x007c, blocks: (B:18:0x005e, B:21:0x0071, B:25:0x008e, B:29:0x01d5, B:30:0x01db, B:32:0x01e6, B:34:0x01ee, B:36:0x01ff, B:40:0x020b, B:42:0x0218, B:44:0x021b, B:46:0x0225, B:50:0x0235, B:51:0x023b, B:53:0x0243, B:54:0x0246, B:59:0x024e, B:60:0x0255, B:61:0x0256, B:63:0x025e, B:65:0x0262, B:67:0x0268, B:68:0x026b, B:70:0x0271, B:73:0x027e, B:80:0x0293, B:83:0x029b, B:85:0x02a5, B:87:0x02b6, B:89:0x02ba, B:91:0x02c0, B:94:0x02c5, B:96:0x02c9, B:97:0x0313, B:99:0x031b, B:102:0x0324, B:103:0x0329, B:106:0x02cc, B:108:0x02d4, B:110:0x02da, B:111:0x02e6, B:114:0x02ef, B:118:0x02f5, B:121:0x02fb, B:122:0x0307, B:123:0x032a, B:124:0x0348, B:126:0x034b, B:128:0x034f, B:130:0x0353, B:133:0x0359, B:137:0x0361, B:143:0x036f, B:146:0x0378, B:148:0x0387, B:150:0x0392, B:151:0x039a, B:152:0x039d, B:153:0x03c9, B:155:0x03d2, B:162:0x03dd, B:165:0x03ed, B:166:0x040d, B:171:0x03ad, B:173:0x03b7, B:174:0x03c6, B:175:0x03bc, B:180:0x0412, B:182:0x041c, B:184:0x0424, B:185:0x0427, B:187:0x0432, B:188:0x0436, B:197:0x0441, B:190:0x0448, B:194:0x0451, B:195:0x0456, B:202:0x045b, B:204:0x0460, B:207:0x046b, B:209:0x0478, B:210:0x047e, B:213:0x0484, B:214:0x048a, B:216:0x0492, B:218:0x04a4, B:221:0x04ac, B:222:0x04ae, B:224:0x04bb, B:226:0x04c8, B:227:0x04cb, B:238:0x04d3, B:229:0x04dd, B:232:0x04e7, B:233:0x04ec, B:235:0x04f1, B:236:0x050b, B:241:0x04c3, B:246:0x050c, B:248:0x0519, B:249:0x051d, B:257:0x0528, B:251:0x052f, B:254:0x0539, B:255:0x0559, B:261:0x00a0, B:262:0x00be, B:325:0x00c1, B:327:0x00cc, B:329:0x00d0, B:331:0x00d4, B:334:0x00da, B:266:0x00e9, B:268:0x00f1, B:272:0x0101, B:273:0x0119, B:275:0x011a, B:276:0x011f, B:284:0x0132, B:286:0x0138, B:288:0x013f, B:289:0x0148, B:293:0x0150, B:294:0x0168, B:295:0x0144, B:297:0x0169, B:298:0x0181, B:306:0x018b, B:308:0x0193, B:312:0x01a4, B:313:0x01c4, B:315:0x01c5, B:316:0x01ca, B:317:0x01cb, B:319:0x055a, B:320:0x055f, B:322:0x0560, B:323:0x0565), top: B:17:0x005e, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x04d3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x04c3 A[Catch: all -> 0x007c, TryCatch #2 {all -> 0x007c, blocks: (B:18:0x005e, B:21:0x0071, B:25:0x008e, B:29:0x01d5, B:30:0x01db, B:32:0x01e6, B:34:0x01ee, B:36:0x01ff, B:40:0x020b, B:42:0x0218, B:44:0x021b, B:46:0x0225, B:50:0x0235, B:51:0x023b, B:53:0x0243, B:54:0x0246, B:59:0x024e, B:60:0x0255, B:61:0x0256, B:63:0x025e, B:65:0x0262, B:67:0x0268, B:68:0x026b, B:70:0x0271, B:73:0x027e, B:80:0x0293, B:83:0x029b, B:85:0x02a5, B:87:0x02b6, B:89:0x02ba, B:91:0x02c0, B:94:0x02c5, B:96:0x02c9, B:97:0x0313, B:99:0x031b, B:102:0x0324, B:103:0x0329, B:106:0x02cc, B:108:0x02d4, B:110:0x02da, B:111:0x02e6, B:114:0x02ef, B:118:0x02f5, B:121:0x02fb, B:122:0x0307, B:123:0x032a, B:124:0x0348, B:126:0x034b, B:128:0x034f, B:130:0x0353, B:133:0x0359, B:137:0x0361, B:143:0x036f, B:146:0x0378, B:148:0x0387, B:150:0x0392, B:151:0x039a, B:152:0x039d, B:153:0x03c9, B:155:0x03d2, B:162:0x03dd, B:165:0x03ed, B:166:0x040d, B:171:0x03ad, B:173:0x03b7, B:174:0x03c6, B:175:0x03bc, B:180:0x0412, B:182:0x041c, B:184:0x0424, B:185:0x0427, B:187:0x0432, B:188:0x0436, B:197:0x0441, B:190:0x0448, B:194:0x0451, B:195:0x0456, B:202:0x045b, B:204:0x0460, B:207:0x046b, B:209:0x0478, B:210:0x047e, B:213:0x0484, B:214:0x048a, B:216:0x0492, B:218:0x04a4, B:221:0x04ac, B:222:0x04ae, B:224:0x04bb, B:226:0x04c8, B:227:0x04cb, B:238:0x04d3, B:229:0x04dd, B:232:0x04e7, B:233:0x04ec, B:235:0x04f1, B:236:0x050b, B:241:0x04c3, B:246:0x050c, B:248:0x0519, B:249:0x051d, B:257:0x0528, B:251:0x052f, B:254:0x0539, B:255:0x0559, B:261:0x00a0, B:262:0x00be, B:325:0x00c1, B:327:0x00cc, B:329:0x00d0, B:331:0x00d4, B:334:0x00da, B:266:0x00e9, B:268:0x00f1, B:272:0x0101, B:273:0x0119, B:275:0x011a, B:276:0x011f, B:284:0x0132, B:286:0x0138, B:288:0x013f, B:289:0x0148, B:293:0x0150, B:294:0x0168, B:295:0x0144, B:297:0x0169, B:298:0x0181, B:306:0x018b, B:308:0x0193, B:312:0x01a4, B:313:0x01c4, B:315:0x01c5, B:316:0x01ca, B:317:0x01cb, B:319:0x055a, B:320:0x055f, B:322:0x0560, B:323:0x0565), top: B:17:0x005e, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01d5 A[Catch: all -> 0x007c, TryCatch #2 {all -> 0x007c, blocks: (B:18:0x005e, B:21:0x0071, B:25:0x008e, B:29:0x01d5, B:30:0x01db, B:32:0x01e6, B:34:0x01ee, B:36:0x01ff, B:40:0x020b, B:42:0x0218, B:44:0x021b, B:46:0x0225, B:50:0x0235, B:51:0x023b, B:53:0x0243, B:54:0x0246, B:59:0x024e, B:60:0x0255, B:61:0x0256, B:63:0x025e, B:65:0x0262, B:67:0x0268, B:68:0x026b, B:70:0x0271, B:73:0x027e, B:80:0x0293, B:83:0x029b, B:85:0x02a5, B:87:0x02b6, B:89:0x02ba, B:91:0x02c0, B:94:0x02c5, B:96:0x02c9, B:97:0x0313, B:99:0x031b, B:102:0x0324, B:103:0x0329, B:106:0x02cc, B:108:0x02d4, B:110:0x02da, B:111:0x02e6, B:114:0x02ef, B:118:0x02f5, B:121:0x02fb, B:122:0x0307, B:123:0x032a, B:124:0x0348, B:126:0x034b, B:128:0x034f, B:130:0x0353, B:133:0x0359, B:137:0x0361, B:143:0x036f, B:146:0x0378, B:148:0x0387, B:150:0x0392, B:151:0x039a, B:152:0x039d, B:153:0x03c9, B:155:0x03d2, B:162:0x03dd, B:165:0x03ed, B:166:0x040d, B:171:0x03ad, B:173:0x03b7, B:174:0x03c6, B:175:0x03bc, B:180:0x0412, B:182:0x041c, B:184:0x0424, B:185:0x0427, B:187:0x0432, B:188:0x0436, B:197:0x0441, B:190:0x0448, B:194:0x0451, B:195:0x0456, B:202:0x045b, B:204:0x0460, B:207:0x046b, B:209:0x0478, B:210:0x047e, B:213:0x0484, B:214:0x048a, B:216:0x0492, B:218:0x04a4, B:221:0x04ac, B:222:0x04ae, B:224:0x04bb, B:226:0x04c8, B:227:0x04cb, B:238:0x04d3, B:229:0x04dd, B:232:0x04e7, B:233:0x04ec, B:235:0x04f1, B:236:0x050b, B:241:0x04c3, B:246:0x050c, B:248:0x0519, B:249:0x051d, B:257:0x0528, B:251:0x052f, B:254:0x0539, B:255:0x0559, B:261:0x00a0, B:262:0x00be, B:325:0x00c1, B:327:0x00cc, B:329:0x00d0, B:331:0x00d4, B:334:0x00da, B:266:0x00e9, B:268:0x00f1, B:272:0x0101, B:273:0x0119, B:275:0x011a, B:276:0x011f, B:284:0x0132, B:286:0x0138, B:288:0x013f, B:289:0x0148, B:293:0x0150, B:294:0x0168, B:295:0x0144, B:297:0x0169, B:298:0x0181, B:306:0x018b, B:308:0x0193, B:312:0x01a4, B:313:0x01c4, B:315:0x01c5, B:316:0x01ca, B:317:0x01cb, B:319:0x055a, B:320:0x055f, B:322:0x0560, B:323:0x0565), top: B:17:0x005e, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object parseObject(java.util.Map r18, java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 1386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public void setContext(ParseContext parseContext) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = parseContext;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ResolveTask {
        public final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        public final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    static {
        Class<?>[] clsArr = {Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class};
        for (int i6 = 0; i6 < 17; i6++) {
            primitiveClasses.add(clsArr[i6]);
        }
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(str, new JSONScanner(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    private void addContext(ParseContext parseContext) {
        int i6 = this.contextArrayIndex;
        this.contextArrayIndex = i6 + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new ParseContext[8];
        } else if (i6 >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[(parseContextArr.length * 3) / 2];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        this.contextArray[i6] = parseContext;
    }

    public void acceptType(String str) {
        JSONLexer jSONLexer = this.lexer;
        jSONLexer.nextTokenWithColon();
        if (jSONLexer.token() != 4) {
            throw new JSONException("type not match error");
        }
        if (!str.equals(jSONLexer.stringVal())) {
            throw new JSONException("type not match error");
        }
        jSONLexer.nextToken();
        if (jSONLexer.token() == 16) {
            jSONLexer.nextToken();
        }
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public void checkListResolve(Collection collection) {
        if (this.resolveStatus == 1) {
            if (!(collection instanceof List)) {
                ResolveTask lastResolveTask = getLastResolveTask();
                lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(collection);
                lastResolveTask.ownerContext = this.context;
                setResolveStatus(0);
                return;
            }
            int size = collection.size() - 1;
            ResolveTask lastResolveTask2 = getLastResolveTask();
            lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, size);
            lastResolveTask2.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    public void checkMapResolve(Map map, Object obj) {
        if (this.resolveStatus == 1) {
            ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
            lastResolveTask.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        JSONLexer jSONLexer = this.lexer;
        try {
            if (jSONLexer.isEnabled(Feature.AutoCloseSource) && jSONLexer.token() != 20) {
                throw new JSONException("not close json text, token : " + JSONToken.name(jSONLexer.token()));
            }
        } finally {
            jSONLexer.close();
        }
    }

    public void config(Feature feature, boolean z5) {
        this.lexer.config(feature, z5);
    }

    public ParserConfig getConfig() {
        return this.config;
    }

    public ParseContext getContext() {
        return this.context;
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.getLocale());
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.getTimeZone());
        }
        return this.dateFormat;
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public FieldTypeResolver getFieldTypeResolver() {
        return this.fieldTypeResolver;
    }

    public String getInput() {
        Object obj = this.input;
        return obj instanceof char[] ? new String((char[]) obj) : obj.toString();
    }

    public ResolveTask getLastResolveTask() {
        return this.resolveTaskList.get(r0.size() - 1);
    }

    public JSONLexer getLexer() {
        return this.lexer;
    }

    public int getResolveStatus() {
        return this.resolveStatus;
    }

    public List<ResolveTask> getResolveTaskList() {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        return this.resolveTaskList;
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public void handleResovleTask(Object obj) {
        FieldInfo fieldInfo;
        List<ResolveTask> list = this.resolveTaskList;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            ResolveTask resolveTask = this.resolveTaskList.get(i6);
            String str = resolveTask.referenceValue;
            ParseContext parseContext = resolveTask.ownerContext;
            Object obj2 = parseContext != null ? parseContext.object : null;
            Object object = str.startsWith("$") ? getObject(str) : resolveTask.context.object;
            FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
            if (fieldDeserializer != null) {
                if (object != null && object.getClass() == JSONObject.class && (fieldInfo = fieldDeserializer.fieldInfo) != null && !Map.class.isAssignableFrom(fieldInfo.fieldClass)) {
                    object = JSONPath.eval(this.contextArray[0].object, str);
                }
                fieldDeserializer.setValue(obj2, object);
            }
        }
    }

    public boolean isEnabled(Feature feature) {
        return this.lexer.isEnabled(feature);
    }

    public Object parse(Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i6 = jSONLexer.token();
        if (i6 == 2) {
            Number integerValue = jSONLexer.integerValue();
            jSONLexer.nextToken();
            return integerValue;
        }
        if (i6 == 3) {
            Number decimalValue = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
            jSONLexer.nextToken();
            return decimalValue;
        }
        if (i6 == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if (!jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                return stringVal;
            }
            JSONScanner jSONScanner = new JSONScanner(stringVal);
            try {
                return jSONScanner.scanISO8601DateIfMatch() ? jSONScanner.getCalendar().getTime() : stringVal;
            } finally {
                jSONScanner.close();
            }
        }
        if (i6 == 12) {
            return parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), obj);
        }
        if (i6 == 14) {
            JSONArray jSONArray = new JSONArray();
            parseArray(jSONArray, obj);
            return jSONLexer.isEnabled(Feature.UseObjectArray) ? jSONArray.toArray() : jSONArray;
        }
        if (i6 == 26) {
            byte[] bytesValue = jSONLexer.bytesValue();
            jSONLexer.nextToken();
            return bytesValue;
        }
        switch (i6) {
            case 6:
                jSONLexer.nextToken();
                return Boolean.TRUE;
            case 7:
                jSONLexer.nextToken();
                return Boolean.FALSE;
            case 8:
                jSONLexer.nextToken();
                return null;
            case 9:
                jSONLexer.nextToken(18);
                if (jSONLexer.token() != 18) {
                    throw new JSONException("syntax error");
                }
                jSONLexer.nextToken(10);
                accept(10);
                long longValue = jSONLexer.integerValue().longValue();
                accept(2);
                accept(11);
                return new Date(longValue);
            default:
                switch (i6) {
                    case 20:
                        if (jSONLexer.isBlankInput()) {
                            return null;
                        }
                        throw new JSONException("unterminated json string, " + jSONLexer.info());
                    case 21:
                        jSONLexer.nextToken();
                        HashSet hashSet = new HashSet();
                        parseArray(hashSet, obj);
                        return hashSet;
                    case 22:
                        jSONLexer.nextToken();
                        TreeSet treeSet = new TreeSet();
                        parseArray(treeSet, obj);
                        return treeSet;
                    case 23:
                        jSONLexer.nextToken();
                        return null;
                    default:
                        throw new JSONException("syntax error, " + jSONLexer.info());
                }
        }
    }

    public Object parseArrayWithType(Type type) {
        if (this.lexer.token() == 8) {
            this.lexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length != 1) {
            throw new JSONException("not support type " + type);
        }
        Type type2 = actualTypeArguments[0];
        if (type2 instanceof Class) {
            ArrayList arrayList = new ArrayList();
            parseArray((Class<?>) type2, (Collection) arrayList);
            return arrayList;
        }
        if (type2 instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type2;
            Type type3 = wildcardType.getUpperBounds()[0];
            if (!Object.class.equals(type3)) {
                ArrayList arrayList2 = new ArrayList();
                parseArray((Class<?>) type3, (Collection) arrayList2);
                return arrayList2;
            }
            if (wildcardType.getLowerBounds().length == 0) {
                return parse();
            }
            throw new JSONException("not support type : " + type);
        }
        if (type2 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type2;
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length != 1) {
                throw new JSONException("not support : " + typeVariable);
            }
            Type type4 = bounds[0];
            if (type4 instanceof Class) {
                ArrayList arrayList3 = new ArrayList();
                parseArray((Class<?>) type4, (Collection) arrayList3);
                return arrayList3;
            }
        }
        if (type2 instanceof ParameterizedType) {
            ArrayList arrayList4 = new ArrayList();
            parseArray((ParameterizedType) type2, arrayList4);
            return arrayList4;
        }
        throw new JSONException("TODO : " + type);
    }

    public void parseExtra(Object obj, String str) {
        this.lexer.nextTokenWithColon();
        List<ExtraTypeProvider> list = this.extraTypeProviders;
        Type type = null;
        if (list != null) {
            Iterator<ExtraTypeProvider> it = list.iterator();
            while (it.hasNext()) {
                type = it.next().getExtraType(obj, str);
            }
        }
        Object parse = type == null ? parse() : parseObject(type);
        if (obj instanceof ExtraProcessable) {
            ((ExtraProcessable) obj).processExtra(str, parse);
            return;
        }
        List<ExtraProcessor> list2 = this.extraProcessors;
        if (list2 != null) {
            Iterator<ExtraProcessor> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().processExtra(obj, str, parse);
            }
        }
        if (this.resolveStatus == 1) {
            this.resolveStatus = 0;
        }
    }

    public Object parseKey() {
        if (this.lexer.token() != 18) {
            return parse(null);
        }
        String stringVal = this.lexer.stringVal();
        this.lexer.nextToken(16);
        return stringVal;
    }

    public void popContext() {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = this.context.parent;
        int i6 = this.contextArrayIndex;
        if (i6 <= 0) {
            return;
        }
        int i7 = i6 - 1;
        this.contextArrayIndex = i7;
        this.contextArray[i7] = null;
    }

    public void setConfig(ParserConfig parserConfig) {
        this.config = parserConfig;
    }

    public void setDateFomrat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public void setFieldTypeResolver(FieldTypeResolver fieldTypeResolver) {
        this.fieldTypeResolver = fieldTypeResolver;
    }

    public void setResolveStatus(int i6) {
        this.resolveStatus = i6;
    }

    public void throwException(int i6) {
        throw new JSONException("syntax error, expect " + JSONToken.name(i6) + ", actual " + JSONToken.name(this.lexer.token()));
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i6) {
        this(str, new JSONScanner(str, i6), parserConfig);
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public ParseContext setContext(Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return setContext(this.context, obj, obj2);
    }

    public DefaultJSONParser(char[] cArr, int i6, ParserConfig parserConfig, int i7) {
        this(cArr, new JSONScanner(cArr, i6, i7), parserConfig);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.getGlobalInstance());
    }

    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer deserializer;
        int i6 = this.lexer.token();
        if (i6 == 21 || i6 == 22) {
            this.lexer.nextToken();
            i6 = this.lexer.token();
        }
        if (i6 == 14) {
            Class cls = Integer.TYPE;
            if (cls != type) {
                if (String.class == type) {
                    deserializer = StringCodec.instance;
                    this.lexer.nextToken(4);
                } else {
                    deserializer = this.config.getDeserializer(type);
                    this.lexer.nextToken(deserializer.getFastMatchToken());
                }
            } else {
                deserializer = IntegerCodec.instance;
                this.lexer.nextToken(2);
            }
            ParseContext parseContext = this.context;
            setContext(collection, obj);
            int i7 = 0;
            while (true) {
                try {
                    if (this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (this.lexer.token() == 16) {
                            this.lexer.nextToken();
                        }
                    }
                    if (this.lexer.token() == 15) {
                        setContext(parseContext);
                        this.lexer.nextToken(16);
                        return;
                    }
                    Object obj2 = null;
                    if (cls != type) {
                        if (String.class == type) {
                            if (this.lexer.token() == 4) {
                                obj2 = this.lexer.stringVal();
                                this.lexer.nextToken(16);
                            } else {
                                Object parse = parse();
                                if (parse != null) {
                                    obj2 = parse.toString();
                                }
                            }
                            collection.add(obj2);
                        } else {
                            if (this.lexer.token() == 8) {
                                this.lexer.nextToken();
                            } else {
                                obj2 = deserializer.deserialze(this, type, Integer.valueOf(i7));
                            }
                            collection.add(obj2);
                            checkListResolve(collection);
                        }
                    } else {
                        collection.add(IntegerCodec.instance.deserialze(this, null, null));
                    }
                    if (this.lexer.token() == 16) {
                        this.lexer.nextToken(deserializer.getFastMatchToken());
                    }
                    i7++;
                } catch (Throwable th) {
                    setContext(parseContext);
                    throw th;
                }
            }
        } else {
            throw new JSONException("exepct '[', but " + JSONToken.name(i6) + ", " + this.lexer.info());
        }
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        ParseContext parseContext2 = new ParseContext(parseContext, obj, obj2);
        this.context = parseContext2;
        addContext(parseContext2);
        return this.context;
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this((Object) null, jSONLexer, parserConfig);
    }

    public final void accept(int i6, int i7) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i6) {
            jSONLexer.nextToken(i7);
        } else {
            throwException(i6);
        }
    }

    public DefaultJSONParser(Object obj, JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.autoTypeAccept = null;
        this.lexer = jSONLexer;
        this.input = obj;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char current = jSONLexer.getCurrent();
        if (current == '{') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 12;
        } else if (current == '[') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 14;
        } else {
            jSONLexer.nextToken();
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        Object cast;
        Class<?> cls;
        boolean z5;
        int i6 = 8;
        if (this.lexer.token() == 8) {
            this.lexer.nextToken(16);
            return null;
        }
        int i7 = 14;
        if (this.lexer.token() == 14) {
            Object[] objArr = new Object[typeArr.length];
            if (typeArr.length == 0) {
                this.lexer.nextToken(15);
                if (this.lexer.token() == 15) {
                    this.lexer.nextToken(16);
                    return new Object[0];
                }
                throw new JSONException("syntax error");
            }
            this.lexer.nextToken(2);
            int i8 = 0;
            while (i8 < typeArr.length) {
                if (this.lexer.token() == i6) {
                    this.lexer.nextToken(16);
                    cast = null;
                } else {
                    Type type = typeArr[i8];
                    if (type != Integer.TYPE && type != Integer.class) {
                        if (type == String.class) {
                            if (this.lexer.token() == 4) {
                                cast = this.lexer.stringVal();
                                this.lexer.nextToken(16);
                            } else {
                                cast = TypeUtils.cast(parse(), type, this.config);
                            }
                        } else {
                            if (i8 == typeArr.length - 1 && (type instanceof Class)) {
                                Class cls2 = (Class) type;
                                z5 = cls2.isArray();
                                cls = cls2.getComponentType();
                            } else {
                                cls = null;
                                z5 = false;
                            }
                            if (z5 && this.lexer.token() != i7) {
                                ArrayList arrayList = new ArrayList();
                                ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                                int fastMatchToken = deserializer.getFastMatchToken();
                                if (this.lexer.token() != 15) {
                                    while (true) {
                                        arrayList.add(deserializer.deserialze(this, type, null));
                                        if (this.lexer.token() != 16) {
                                            break;
                                        }
                                        this.lexer.nextToken(fastMatchToken);
                                    }
                                    if (this.lexer.token() != 15) {
                                        throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                                    }
                                }
                                cast = TypeUtils.cast(arrayList, type, this.config);
                            } else {
                                cast = this.config.getDeserializer(type).deserialze(this, type, null);
                            }
                        }
                    } else if (this.lexer.token() == 2) {
                        cast = Integer.valueOf(this.lexer.intValue());
                        this.lexer.nextToken(16);
                    } else {
                        cast = TypeUtils.cast(parse(), type, this.config);
                    }
                }
                objArr[i8] = cast;
                if (this.lexer.token() == 15) {
                    break;
                }
                if (this.lexer.token() == 16) {
                    if (i8 == typeArr.length - 1) {
                        this.lexer.nextToken(15);
                    } else {
                        this.lexer.nextToken(2);
                    }
                    i8++;
                    i6 = 8;
                    i7 = 14;
                } else {
                    throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                }
            }
            if (this.lexer.token() == 15) {
                this.lexer.nextToken(16);
                return objArr;
            }
            throw new JSONException("syntax error");
        }
        throw new JSONException("syntax error : " + this.lexer.tokenName());
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    public final void parseArray(Collection collection, Object obj) {
        Object obj2;
        Number decimalValue;
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 21 || jSONLexer.token() == 22) {
            jSONLexer.nextToken();
        }
        if (jSONLexer.token() == 14) {
            jSONLexer.nextToken(4);
            ParseContext parseContext = this.context;
            setContext(collection, obj);
            int i6 = 0;
            while (true) {
                try {
                    if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (jSONLexer.token() == 16) {
                            jSONLexer.nextToken();
                        }
                    }
                    int i7 = jSONLexer.token();
                    if (i7 == 2) {
                        Number integerValue = jSONLexer.integerValue();
                        jSONLexer.nextToken(16);
                        obj2 = integerValue;
                    } else if (i7 == 3) {
                        if (jSONLexer.isEnabled(Feature.UseBigDecimal)) {
                            decimalValue = jSONLexer.decimalValue(true);
                        } else {
                            decimalValue = jSONLexer.decimalValue(false);
                        }
                        obj2 = decimalValue;
                        jSONLexer.nextToken(16);
                    } else if (i7 == 4) {
                        String stringVal = jSONLexer.stringVal();
                        jSONLexer.nextToken(16);
                        obj2 = stringVal;
                        if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                            JSONScanner jSONScanner = new JSONScanner(stringVal);
                            Object obj3 = stringVal;
                            if (jSONScanner.scanISO8601DateIfMatch()) {
                                obj3 = jSONScanner.getCalendar().getTime();
                            }
                            jSONScanner.close();
                            obj2 = obj3;
                        }
                    } else if (i7 == 6) {
                        Boolean bool = Boolean.TRUE;
                        jSONLexer.nextToken(16);
                        obj2 = bool;
                    } else if (i7 != 7) {
                        obj2 = null;
                        obj2 = null;
                        if (i7 == 8) {
                            jSONLexer.nextToken(4);
                        } else if (i7 == 12) {
                            obj2 = parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), Integer.valueOf(i6));
                        } else {
                            if (i7 == 20) {
                                throw new JSONException("unclosed jsonArray");
                            }
                            if (i7 == 23) {
                                jSONLexer.nextToken(4);
                            } else if (i7 == 14) {
                                JSONArray jSONArray = new JSONArray();
                                parseArray(jSONArray, Integer.valueOf(i6));
                                obj2 = jSONArray;
                                if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                                    obj2 = jSONArray.toArray();
                                }
                            } else if (i7 != 15) {
                                obj2 = parse();
                            } else {
                                jSONLexer.nextToken(16);
                                setContext(parseContext);
                                return;
                            }
                        }
                    } else {
                        Boolean bool2 = Boolean.FALSE;
                        jSONLexer.nextToken(16);
                        obj2 = bool2;
                    }
                    collection.add(obj2);
                    checkListResolve(collection);
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(4);
                    }
                    i6++;
                } catch (Throwable th) {
                    setContext(parseContext);
                    throw th;
                }
            }
        } else {
            throw new JSONException("syntax error, expect [, actual " + JSONToken.name(jSONLexer.token()) + ", pos " + jSONLexer.pos());
        }
    }

    public <T> T parseObject(Class<T> cls) {
        return (T) parseObject(cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return (T) parseObject(type, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T parseObject(Type type, Object obj) {
        int i6 = this.lexer.token();
        if (i6 == 8) {
            this.lexer.nextToken();
            return null;
        }
        if (i6 == 4) {
            if (type == byte[].class) {
                T t5 = (T) this.lexer.bytesValue();
                this.lexer.nextToken();
                return t5;
            }
            if (type == char[].class) {
                String stringVal = this.lexer.stringVal();
                this.lexer.nextToken();
                return (T) stringVal.toCharArray();
            }
        }
        try {
            return (T) this.config.getDeserializer(type).deserialze(this, type, obj);
        } catch (JSONException e6) {
            throw e6;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    public void parseObject(Object obj) {
        Object deserialze;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (this.lexer.token() != 12 && this.lexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + this.lexer.tokenName());
        }
        while (true) {
            String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
            if (scanSymbol == null) {
                if (this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                } else if (this.lexer.token() == 16 && this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                }
            }
            FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(scanSymbol) : null;
            if (fieldDeserializer == null) {
                if (this.lexer.isEnabled(Feature.IgnoreNotMatch)) {
                    this.lexer.nextTokenWithColon();
                    parse();
                    if (this.lexer.token() == 13) {
                        this.lexer.nextToken();
                        return;
                    }
                } else {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + scanSymbol);
                }
            } else {
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                Class<?> cls2 = fieldInfo.fieldClass;
                Type type = fieldInfo.fieldType;
                if (cls2 == Integer.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    deserialze = IntegerCodec.instance.deserialze(this, type, null);
                } else if (cls2 == String.class) {
                    this.lexer.nextTokenWithColon(4);
                    deserialze = StringCodec.deserialze(this);
                } else if (cls2 == Long.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    deserialze = LongCodec.instance.deserialze(this, type, null);
                } else {
                    ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                    this.lexer.nextTokenWithColon(deserializer2.getFastMatchToken());
                    deserialze = deserializer2.deserialze(this, type, null);
                }
                fieldDeserializer.setValue(obj, deserialze);
                if (this.lexer.token() != 16 && this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                }
            }
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    public JSONObject parseObject() {
        return (JSONObject) parseObject((Map) new JSONObject(this.lexer.isEnabled(Feature.OrderedField)));
    }
}
