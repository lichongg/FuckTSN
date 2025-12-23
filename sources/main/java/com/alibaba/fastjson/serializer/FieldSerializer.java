package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FieldSerializer implements Comparable<FieldSerializer> {
    private final String double_quoted_fieldPrefix;
    protected int features;
    protected BeanContext fieldContext;
    public final FieldInfo fieldInfo;
    private String format;
    protected boolean persistenceOneToMany;
    private RuntimeSerializerInfo runtimeInfo;
    protected boolean serializeUsing = false;
    private String single_quoted_fieldPrefix;
    private String un_quoted_fieldPrefix;
    protected boolean writeEnumUsingName;
    protected boolean writeEnumUsingToString;
    protected final boolean writeNull;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class RuntimeSerializerInfo {
        final ObjectSerializer fieldSerializer;
        final Class<?> runtimeFieldClass;

        public RuntimeSerializerInfo(ObjectSerializer objectSerializer, Class<?> cls) {
            this.fieldSerializer = objectSerializer;
            this.runtimeFieldClass = cls;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(FieldSerializer fieldSerializer) {
        return this.fieldInfo.compareTo(fieldSerializer.fieldInfo);
    }

    public Object getPropertyValue(Object obj) throws InvocationTargetException, IllegalAccessException {
        Object obj2 = this.fieldInfo.get(obj);
        if (this.format == null || obj2 == null || this.fieldInfo.fieldClass != Date.class) {
            return obj2;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.format);
        simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
        return simpleDateFormat.format(obj2);
    }

    public Object getPropertyValueDirect(Object obj) throws InvocationTargetException, IllegalAccessException {
        Object obj2 = this.fieldInfo.get(obj);
        if (this.persistenceOneToMany && TypeUtils.isHibernateInitialized(obj2)) {
            return null;
        }
        return obj2;
    }

    public void writePrefix(JSONSerializer jSONSerializer) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (!serializeWriter.quoteFieldNames) {
            if (this.un_quoted_fieldPrefix == null) {
                this.un_quoted_fieldPrefix = this.fieldInfo.name + ":";
            }
            serializeWriter.write(this.un_quoted_fieldPrefix);
            return;
        }
        if (!serializeWriter.useSingleQuotes) {
            serializeWriter.write(this.double_quoted_fieldPrefix);
            return;
        }
        if (this.single_quoted_fieldPrefix == null) {
            this.single_quoted_fieldPrefix = '\'' + this.fieldInfo.name + "':";
        }
        serializeWriter.write(this.single_quoted_fieldPrefix);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeValue(com.alibaba.fastjson.serializer.JSONSerializer r10, java.lang.Object r11) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.FieldSerializer.writeValue(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object):void");
    }

    public FieldSerializer(Class<?> cls, FieldInfo fieldInfo) {
        boolean z5;
        JSONType jSONType;
        boolean z6 = false;
        this.writeEnumUsingToString = false;
        this.writeEnumUsingName = false;
        this.persistenceOneToMany = false;
        this.fieldInfo = fieldInfo;
        this.fieldContext = new BeanContext(cls, fieldInfo);
        if (cls != null && fieldInfo.isEnum && (jSONType = (JSONType) cls.getAnnotation(JSONType.class)) != null) {
            for (SerializerFeature serializerFeature : jSONType.serialzeFeatures()) {
                if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
                    this.writeEnumUsingToString = true;
                } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                    this.writeEnumUsingName = true;
                }
            }
        }
        fieldInfo.setAccessible();
        this.double_quoted_fieldPrefix = '\"' + fieldInfo.name + "\":";
        JSONField annotation = fieldInfo.getAnnotation();
        if (annotation != null) {
            SerializerFeature[] serialzeFeatures = annotation.serialzeFeatures();
            int length = serialzeFeatures.length;
            int i6 = 0;
            while (true) {
                if (i6 < length) {
                    if ((serialzeFeatures[i6].getMask() & SerializerFeature.WRITE_MAP_NULL_FEATURES) != 0) {
                        z5 = true;
                        break;
                    }
                    i6++;
                } else {
                    z5 = false;
                    break;
                }
            }
            String format = annotation.format();
            this.format = format;
            if (format.trim().length() == 0) {
                this.format = null;
            }
            for (SerializerFeature serializerFeature2 : annotation.serialzeFeatures()) {
                if (serializerFeature2 == SerializerFeature.WriteEnumUsingToString) {
                    this.writeEnumUsingToString = true;
                } else if (serializerFeature2 == SerializerFeature.WriteEnumUsingName) {
                    this.writeEnumUsingName = true;
                }
            }
            this.features = SerializerFeature.of(annotation.serialzeFeatures());
            z6 = z5;
        }
        this.writeNull = z6;
        this.persistenceOneToMany = TypeUtils.isAnnotationPresentOneToMany(fieldInfo.method);
    }
}
