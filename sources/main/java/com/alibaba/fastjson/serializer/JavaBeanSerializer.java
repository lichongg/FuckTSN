package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
    protected SerializeBeanInfo beanInfo;
    protected final FieldSerializer[] getters;
    protected final FieldSerializer[] sortedGetters;

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (Map<String, String>) null);
    }

    public FieldSerializer getFieldSerializer(String str) {
        if (str == null) {
            return null;
        }
        int length = this.sortedGetters.length - 1;
        int i6 = 0;
        while (i6 <= length) {
            int i7 = (i6 + length) >>> 1;
            int compareTo = this.sortedGetters[i7].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i6 = i7 + 1;
            } else {
                if (compareTo <= 0) {
                    return this.sortedGetters[i7];
                }
                length = i7 - 1;
            }
        }
        return null;
    }

    protected boolean isWriteAsArray(JSONSerializer jSONSerializer) {
        return isWriteAsArray(jSONSerializer, 0);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        write(jSONSerializer, obj, obj2, type, i6, false);
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, createAliasMap(strArr));
    }

    static Map<String, String> createAliasMap(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    protected boolean applyLabel(JSONSerializer jSONSerializer, String str) {
        List<LabelFilter> list = jSONSerializer.labelFilters;
        if (list != null) {
            Iterator<LabelFilter> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(str)) {
                    return false;
                }
            }
        }
        List<LabelFilter> list2 = this.labelFilters;
        if (list2 == null) {
            return true;
        }
        Iterator<LabelFilter> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (!it2.next().apply(str)) {
                return false;
            }
        }
        return true;
    }

    protected BeanContext getBeanContext(int i6) {
        return this.sortedGetters[i6].fieldContext;
    }

    protected Type getFieldType(int i6) {
        return this.sortedGetters[i6].fieldInfo.fieldType;
    }

    public Object getFieldValue(Object obj, String str) {
        FieldSerializer fieldSerializer = getFieldSerializer(str);
        if (fieldSerializer == null) {
            throw new JSONException("field not found. " + str);
        }
        try {
            return fieldSerializer.getPropertyValue(obj);
        } catch (IllegalAccessException e6) {
            throw new JSONException("getFieldValue error." + str, e6);
        } catch (InvocationTargetException e7) {
            throw new JSONException("getFieldValue error." + str, e7);
        }
    }

    public List<Object> getFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            arrayList.add(fieldSerializer.getPropertyValue(obj));
        }
        return arrayList;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
        }
        return linkedHashMap;
    }

    public List<Object> getObjectFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            Class<?> cls = fieldSerializer.fieldInfo.fieldClass;
            if (!cls.isPrimitive() && !cls.getName().startsWith("java.lang.")) {
                arrayList.add(fieldSerializer.getPropertyValue(obj));
            }
        }
        return arrayList;
    }

    public int getSize(Object obj) throws Exception {
        int i6 = 0;
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                i6++;
            }
        }
        return i6;
    }

    protected boolean isWriteAsArray(JSONSerializer jSONSerializer, int i6) {
        int i7 = SerializerFeature.BeanToArray.mask;
        return ((this.beanInfo.features & i7) == 0 && !jSONSerializer.out.beanToArray && (i6 & i7) == 0) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:171:0x024d, code lost:
    
        r0 = r9.features;
        r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty.mask;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0254, code lost:
    
        if ((r0 & r6) != 0) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0259, code lost:
    
        if ((r6.features & r6) == 0) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x025c, code lost:
    
        r9.writeNull();
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0260, code lost:
    
        r9.writeString("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c5, code lost:
    
        if (r15.fieldTransient != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x014d, code lost:
    
        if ((r27.beanInfo.features & r3) == 0) goto L150;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void write(com.alibaba.fastjson.serializer.JSONSerializer r28, java.lang.Object r29, java.lang.Object r30, java.lang.reflect.Type r31, int r32, boolean r33) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 802
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }

    protected char writeAfter(JSONSerializer jSONSerializer, Object obj, char c6) {
        List<AfterFilter> list = jSONSerializer.afterFilters;
        if (list != null) {
            Iterator<AfterFilter> it = list.iterator();
            while (it.hasNext()) {
                c6 = it.next().writeAfter(jSONSerializer, obj, c6);
            }
        }
        List<AfterFilter> list2 = this.afterFilters;
        if (list2 != null) {
            Iterator<AfterFilter> it2 = list2.iterator();
            while (it2.hasNext()) {
                c6 = it2.next().writeAfter(jSONSerializer, obj, c6);
            }
        }
        return c6;
    }

    protected char writeBefore(JSONSerializer jSONSerializer, Object obj, char c6) {
        List<BeforeFilter> list = jSONSerializer.beforeFilters;
        if (list != null) {
            Iterator<BeforeFilter> it = list.iterator();
            while (it.hasNext()) {
                c6 = it.next().writeBefore(jSONSerializer, obj, c6);
            }
        }
        List<BeforeFilter> list2 = this.beforeFilters;
        if (list2 != null) {
            Iterator<BeforeFilter> it2 = list2.iterator();
            while (it2.hasNext()) {
                c6 = it2.next().writeBefore(jSONSerializer, obj, c6);
            }
        }
        return c6;
    }

    protected void writeClassName(JSONSerializer jSONSerializer, String str, Object obj) {
        if (str == null) {
            str = jSONSerializer.config.typeKey;
        }
        jSONSerializer.out.writeFieldName(str, false);
        String str2 = this.beanInfo.typeName;
        if (str2 == null) {
            Class<?> cls = obj.getClass();
            if (TypeUtils.isProxy(cls)) {
                cls = cls.getSuperclass();
            }
            str2 = cls.getName();
        }
        jSONSerializer.write(str2);
    }

    public boolean writeReference(JSONSerializer jSONSerializer, Object obj, int i6) {
        IdentityHashMap<Object, SerialContext> identityHashMap;
        SerialContext serialContext = jSONSerializer.context;
        int i7 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (serialContext == null || (serialContext.features & i7) != 0 || (i6 & i7) != 0 || (identityHashMap = jSONSerializer.references) == null || !identityHashMap.containsKey(obj)) {
            return false;
        }
        jSONSerializer.writeReference(obj);
        return true;
    }

    public JavaBeanSerializer(Class<?> cls, Map<String, String> map) {
        this(TypeUtils.buildBeanInfo(cls, map, null));
    }

    public void writeAsArray(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        write(jSONSerializer, obj, obj2, type, i6);
    }

    public void writeAsArrayNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        write(jSONSerializer, obj, obj2, type, i6);
    }

    public void writeDirectNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        write(jSONSerializer, obj, obj2, type, i6);
    }

    public JavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        FieldSerializer[] fieldSerializerArr;
        this.beanInfo = serializeBeanInfo;
        this.sortedGetters = new FieldSerializer[serializeBeanInfo.sortedFields.length];
        int i6 = 0;
        int i7 = 0;
        while (true) {
            fieldSerializerArr = this.sortedGetters;
            if (i7 >= fieldSerializerArr.length) {
                break;
            }
            fieldSerializerArr[i7] = new FieldSerializer(serializeBeanInfo.beanType, serializeBeanInfo.sortedFields[i7]);
            i7++;
        }
        FieldInfo[] fieldInfoArr = serializeBeanInfo.fields;
        if (fieldInfoArr == serializeBeanInfo.sortedFields) {
            this.getters = fieldSerializerArr;
            return;
        }
        this.getters = new FieldSerializer[fieldInfoArr.length];
        while (true) {
            FieldSerializer[] fieldSerializerArr2 = this.getters;
            if (i6 >= fieldSerializerArr2.length) {
                return;
            }
            fieldSerializerArr2[i6] = getFieldSerializer(serializeBeanInfo.fields[i6].name);
            i6++;
        }
    }
}
