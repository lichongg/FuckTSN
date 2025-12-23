package com.alibaba.fastjson.parser;

import java.lang.reflect.Type;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ParseContext {
    public final Object fieldName;
    public Object object;
    public final ParseContext parent;
    private transient String path;
    public Type type;

    public String toString() {
        if (this.path == null) {
            if (this.parent == null) {
                this.path = "$";
            } else if (this.fieldName instanceof Integer) {
                this.path = this.parent.toString() + "[" + this.fieldName + "]";
            } else {
                this.path = this.parent.toString() + "." + this.fieldName;
            }
        }
        return this.path;
    }

    public ParseContext(ParseContext parseContext, Object obj, Object obj2) {
        this.parent = parseContext;
        this.object = obj;
        this.fieldName = obj2;
    }
}
