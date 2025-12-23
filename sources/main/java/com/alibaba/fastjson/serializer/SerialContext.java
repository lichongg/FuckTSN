package com.alibaba.fastjson.serializer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SerialContext {
    public final int features;
    public final Object fieldName;
    public final Object object;
    public final SerialContext parent;

    public Object getFieldName() {
        return this.fieldName;
    }

    public Object getObject() {
        return this.object;
    }

    public SerialContext getParent() {
        return this.parent;
    }

    public String toString() {
        if (this.parent == null) {
            return "$";
        }
        if (!(this.fieldName instanceof Integer)) {
            return this.parent.toString() + "." + this.fieldName;
        }
        return this.parent.toString() + "[" + this.fieldName + "]";
    }

    public SerialContext(SerialContext serialContext, Object obj, Object obj2, int i6, int i7) {
        this.parent = serialContext;
        this.object = obj;
        this.fieldName = obj2;
        this.features = i6;
    }

    public String getPath() {
        return toString();
    }
}
