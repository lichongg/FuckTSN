package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.util.AbstractReferenceCounted;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class InternalAttribute extends AbstractReferenceCounted implements InterfaceHttpData {
    private final Charset charset;
    private int size;
    private final List<ByteBuf> value = new ArrayList();

    public void addValue(String str) {
        if (str == null) {
            throw new NullPointerException("value");
        }
        ByteBuf copiedBuffer = Unpooled.copiedBuffer(str, this.charset);
        this.value.add(copiedBuffer);
        this.size += copiedBuffer.readableBytes();
    }

    @Override // java.lang.Comparable
    public int compareTo(InterfaceHttpData interfaceHttpData) {
        if (interfaceHttpData instanceof InternalAttribute) {
            return compareTo((InternalAttribute) interfaceHttpData);
        }
        throw new ClassCastException("Cannot compare " + getHttpDataType() + " with " + interfaceHttpData.getHttpDataType());
    }

    public boolean equals(Object obj) {
        if (obj instanceof InternalAttribute) {
            return getName().equalsIgnoreCase(((InternalAttribute) obj).getName());
        }
        return false;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData
    public InterfaceHttpData.HttpDataType getHttpDataType() {
        return InterfaceHttpData.HttpDataType.InternalAttribute;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData
    public String getName() {
        return "InternalAttribute";
    }

    public void setValue(String str, int i6) {
        if (str == null) {
            throw new NullPointerException("value");
        }
        ByteBuf copiedBuffer = Unpooled.copiedBuffer(str, this.charset);
        ByteBuf byteBuf = this.value.set(i6, copiedBuffer);
        if (byteBuf != null) {
            this.size -= byteBuf.readableBytes();
            byteBuf.release();
        }
        this.size += copiedBuffer.readableBytes();
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<ByteBuf> it = this.value.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString(this.charset));
        }
        return sb.toString();
    }

    InternalAttribute(Charset charset) {
        this.charset = charset;
    }

    public int hashCode() {
        return getName().hashCode();
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public InterfaceHttpData retain() {
        Iterator<ByteBuf> it = this.value.iterator();
        while (it.hasNext()) {
            it.next().retain();
        }
        return this;
    }

    public ByteBuf toByteBuf() {
        return Unpooled.compositeBuffer().addComponents(this.value).writerIndex(size()).readerIndex(0);
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public InterfaceHttpData touch() {
        Iterator<ByteBuf> it = this.value.iterator();
        while (it.hasNext()) {
            it.next().touch();
        }
        return this;
    }

    public void addValue(String str, int i6) {
        if (str != null) {
            ByteBuf copiedBuffer = Unpooled.copiedBuffer(str, this.charset);
            this.value.add(i6, copiedBuffer);
            this.size += copiedBuffer.readableBytes();
            return;
        }
        throw new NullPointerException("value");
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public InterfaceHttpData retain(int i6) {
        Iterator<ByteBuf> it = this.value.iterator();
        while (it.hasNext()) {
            it.next().retain(i6);
        }
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public InterfaceHttpData touch(Object obj) {
        Iterator<ByteBuf> it = this.value.iterator();
        while (it.hasNext()) {
            it.next().touch(obj);
        }
        return this;
    }

    public int compareTo(InternalAttribute internalAttribute) {
        return getName().compareToIgnoreCase(internalAttribute.getName());
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
    }
}
