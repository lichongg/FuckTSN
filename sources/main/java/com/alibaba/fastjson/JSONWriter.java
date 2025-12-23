package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class JSONWriter implements Closeable, Flushable {
    private JSONStreamContext context;
    private JSONSerializer serializer;
    private SerializeWriter writer;

    public void writeObject(String str) {
        beforeWrite();
        this.serializer.write(str);
        afterWriter();
    }

    private void afterWriter() {
        int i6;
        JSONStreamContext jSONStreamContext = this.context;
        if (jSONStreamContext == null) {
            return;
        }
        switch (jSONStreamContext.state) {
            case 1001:
            case 1003:
                i6 = 1002;
                break;
            case 1002:
                i6 = 1003;
                break;
            case 1004:
                i6 = 1005;
                break;
            default:
                i6 = -1;
                break;
        }
        if (i6 != -1) {
            jSONStreamContext.state = i6;
        }
    }

    private void beforeWrite() {
        JSONStreamContext jSONStreamContext = this.context;
        if (jSONStreamContext == null) {
            return;
        }
        int i6 = jSONStreamContext.state;
        if (i6 == 1002) {
            this.writer.write(58);
        } else if (i6 == 1003) {
            this.writer.write(44);
        } else {
            if (i6 != 1005) {
                return;
            }
            this.writer.write(44);
        }
    }

    private void beginStructure() {
        int i6 = this.context.state;
        switch (i6) {
            case 1001:
            case 1004:
                return;
            case 1002:
                this.writer.write(58);
                return;
            case 1003:
            default:
                throw new JSONException("illegal state : " + i6);
            case 1005:
                this.writer.write(44);
                return;
        }
    }

    private void endStructure() {
        JSONStreamContext jSONStreamContext = this.context.parent;
        this.context = jSONStreamContext;
        if (jSONStreamContext == null) {
            return;
        }
        int i6 = jSONStreamContext.state;
        int i7 = i6 != 1001 ? i6 != 1002 ? i6 != 1004 ? -1 : 1005 : 1003 : 1002;
        if (i7 != -1) {
            jSONStreamContext.state = i7;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.writer.close();
    }

    public void config(SerializerFeature serializerFeature, boolean z5) {
        this.writer.config(serializerFeature, z5);
    }

    public void endArray() {
        this.writer.write(93);
        endStructure();
    }

    public void endObject() {
        this.writer.write(125);
        endStructure();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.writer.flush();
    }

    public void startArray() {
        if (this.context != null) {
            beginStructure();
        }
        this.context = new JSONStreamContext(this.context, 1004);
        this.writer.write(91);
    }

    public void startObject() {
        if (this.context != null) {
            beginStructure();
        }
        this.context = new JSONStreamContext(this.context, 1001);
        this.writer.write(123);
    }

    public JSONWriter(Writer writer) {
        SerializeWriter serializeWriter = new SerializeWriter(writer);
        this.writer = serializeWriter;
        this.serializer = new JSONSerializer(serializeWriter);
    }

    @Deprecated
    public void writeEndArray() {
        endArray();
    }

    @Deprecated
    public void writeEndObject() {
        endObject();
    }

    public void writeKey(String str) {
        writeObject(str);
    }

    @Deprecated
    public void writeStartArray() {
        startArray();
    }

    @Deprecated
    public void writeStartObject() {
        startObject();
    }

    public void writeValue(Object obj) {
        writeObject(obj);
    }

    public void writeObject(Object obj) {
        beforeWrite();
        this.serializer.write(obj);
        afterWriter();
    }
}
