package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SerializeBeanInfo {
    protected final Class<?> beanType;
    protected int features;
    protected final FieldInfo[] fields;
    protected final JSONType jsonType;
    protected final FieldInfo[] sortedFields;
    protected final String typeKey;
    protected final String typeName;

    public SerializeBeanInfo(Class<?> cls, JSONType jSONType, String str, String str2, int i6, FieldInfo[] fieldInfoArr, FieldInfo[] fieldInfoArr2) {
        this.beanType = cls;
        this.jsonType = jSONType;
        this.typeName = str;
        this.typeKey = str2;
        this.features = i6;
        this.fields = fieldInfoArr;
        this.sortedFields = fieldInfoArr2;
    }
}
