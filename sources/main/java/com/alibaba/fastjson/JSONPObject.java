package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.JSONSerializable;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class JSONPObject implements JSONSerializable {
    private static final int BrowserSecureMask = SerializerFeature.BrowserSecure.mask;
    public static String SECURITY_PREFIX = "/**/";
    private String function;
    private final List<Object> parameters = new ArrayList();

    public JSONPObject() {
    }

    public void addParameter(Object obj) {
        this.parameters.add(obj);
    }

    public String getFunction() {
        return this.function;
    }

    public List<Object> getParameters() {
        return this.parameters;
    }

    public void setFunction(String str) {
        this.function = str;
    }

    @Override // com.alibaba.fastjson.serializer.JSONSerializable
    public void write(JSONSerializer jSONSerializer, Object obj, Type type, int i6) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        int i7 = BrowserSecureMask;
        if ((i6 & i7) != 0 || serializeWriter.isEnabled(i7)) {
            serializeWriter.write(SECURITY_PREFIX);
        }
        serializeWriter.write(this.function);
        serializeWriter.write(40);
        for (int i8 = 0; i8 < this.parameters.size(); i8++) {
            if (i8 != 0) {
                serializeWriter.write(44);
            }
            jSONSerializer.write(this.parameters.get(i8));
        }
        serializeWriter.write(41);
    }

    public JSONPObject(String str) {
        this.function = str;
    }

    public String toJSONString() {
        return toString();
    }

    public String toString() {
        return JSON.toJSONString(this);
    }
}
