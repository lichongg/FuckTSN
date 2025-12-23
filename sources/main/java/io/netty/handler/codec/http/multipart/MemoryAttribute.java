package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelException;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class MemoryAttribute extends AbstractMemoryHttpData implements Attribute {
    public MemoryAttribute(String str) {
        this(str, HttpConstants.DEFAULT_CHARSET);
    }

    public MemoryAttribute(String str, long j6) {
        this(str, j6, HttpConstants.DEFAULT_CHARSET);
    }

    @Override // java.lang.Comparable
    public int compareTo(InterfaceHttpData interfaceHttpData) {
        if (interfaceHttpData instanceof Attribute) {
            return compareTo((Attribute) interfaceHttpData);
        }
        throw new ClassCastException("Cannot compare " + getHttpDataType() + " with " + interfaceHttpData.getHttpDataType());
    }

    public boolean equals(Object obj) {
        if (obj instanceof Attribute) {
            return getName().equalsIgnoreCase(((Attribute) obj).getName());
        }
        return false;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData
    public InterfaceHttpData.HttpDataType getHttpDataType() {
        return InterfaceHttpData.HttpDataType.Attribute;
    }

    @Override // io.netty.handler.codec.http.multipart.Attribute
    public void setValue(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("value");
        }
        byte[] bytes = str.getBytes(getCharset());
        checkSize(bytes.length);
        ByteBuf wrappedBuffer = Unpooled.wrappedBuffer(bytes);
        if (this.definedSize > 0) {
            this.definedSize = wrappedBuffer.readableBytes();
        }
        setContent(wrappedBuffer);
    }

    public String toString() {
        return getName() + '=' + getValue();
    }

    public MemoryAttribute(String str, Charset charset) {
        super(str, charset, 0L);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMemoryHttpData, io.netty.handler.codec.http.multipart.HttpData
    public void addContent(ByteBuf byteBuf, boolean z5) throws IOException {
        long readableBytes = byteBuf.readableBytes();
        checkSize(this.size + readableBytes);
        long j6 = this.definedSize;
        if (j6 > 0) {
            long j7 = this.size;
            if (j6 < j7 + readableBytes) {
                this.definedSize = j7 + readableBytes;
            }
        }
        super.addContent(byteBuf, z5);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public Attribute copy() {
        ByteBuf content = content();
        return replace(content != null ? content.copy() : null);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public Attribute duplicate() {
        ByteBuf content = content();
        return replace(content != null ? content.duplicate() : null);
    }

    @Override // io.netty.handler.codec.http.multipart.Attribute
    public String getValue() {
        return getByteBuf().toString(getCharset());
    }

    public int hashCode() {
        return getName().hashCode();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public Attribute replace(ByteBuf byteBuf) {
        MemoryAttribute memoryAttribute = new MemoryAttribute(getName());
        memoryAttribute.setCharset(getCharset());
        if (byteBuf == null) {
            return memoryAttribute;
        }
        try {
            memoryAttribute.setContent(byteBuf);
            return memoryAttribute;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public Attribute retainedDuplicate() {
        ByteBuf content = content();
        if (content != null) {
            ByteBuf retainedDuplicate = content.retainedDuplicate();
            try {
                return replace(retainedDuplicate);
            } catch (Throwable th) {
                retainedDuplicate.release();
                throw th;
            }
        }
        return replace((ByteBuf) null);
    }

    public MemoryAttribute(String str, long j6, Charset charset) {
        super(str, charset, j6);
    }

    public MemoryAttribute(String str, String str2) throws IOException {
        this(str, str2, HttpConstants.DEFAULT_CHARSET);
    }

    public MemoryAttribute(String str, String str2, Charset charset) throws IOException {
        super(str, charset, 0L);
        setValue(str2);
    }

    public int compareTo(Attribute attribute) {
        return getName().compareToIgnoreCase(attribute.getName());
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public Attribute retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMemoryHttpData, io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public Attribute touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public Attribute retain(int i6) {
        super.retain(i6);
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMemoryHttpData, io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.ReferenceCounted
    public Attribute touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
