package com.alibaba.fastjson.support.spring;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class MappingFastJsonValue {
    private String jsonpFunction;
    private Object value;

    public String getJsonpFunction() {
        return this.jsonpFunction;
    }

    public Object getValue() {
        return this.value;
    }

    public void setJsonpFunction(String str) {
        this.jsonpFunction = str;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    public MappingFastJsonValue(Object obj) {
        this.value = obj;
    }
}
