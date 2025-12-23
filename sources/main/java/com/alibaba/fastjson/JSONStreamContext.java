package com.alibaba.fastjson;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class JSONStreamContext {
    static final int ArrayValue = 1005;
    static final int PropertyKey = 1002;
    static final int PropertyValue = 1003;
    static final int StartArray = 1004;
    static final int StartObject = 1001;
    protected final JSONStreamContext parent;
    protected int state;

    public JSONStreamContext(JSONStreamContext jSONStreamContext, int i6) {
        this.parent = jSONStreamContext;
        this.state = i6;
    }
}
