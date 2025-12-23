package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.ParserConfig;
import java.lang.reflect.Constructor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        if (java.lang.Throwable.class.isAssignableFrom(r2) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00eb, code lost:
    
        if (r2 != null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ed, code lost:
    
        r0 = (T) new java.lang.Exception(r10, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0107, code lost:
    
        if (r11 == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0109, code lost:
    
        ((java.lang.Throwable) r0).setStackTrace(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:
    
        return (T) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f7, code lost:
    
        if (java.lang.Throwable.class.isAssignableFrom(r2) == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012f, code lost:
    
        throw new com.alibaba.fastjson.JSONException("type not match, not Throwable. " + r2.getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f9, code lost:
    
        r0 = (T) createException(r10, r9, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fd, code lost:
    
        if (r0 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ff, code lost:
    
        r0 = (T) new java.lang.Exception(r10, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0105, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0114, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r17, java.lang.reflect.Type r18, java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    private Throwable createException(String str, Throwable th, Class<?> cls) throws Exception {
        Constructor<?> constructor = null;
        Constructor<?> constructor2 = null;
        Constructor<?> constructor3 = null;
        for (Constructor<?> constructor4 : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor4.getParameterTypes();
            if (parameterTypes.length == 0) {
                constructor3 = constructor4;
            } else if (parameterTypes.length == 1 && parameterTypes[0] == String.class) {
                constructor2 = constructor4;
            } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Throwable.class) {
                constructor = constructor4;
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(str, th);
        }
        if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(str);
        }
        if (constructor3 == null) {
            return null;
        }
        return (Throwable) constructor3.newInstance(null);
    }
}
