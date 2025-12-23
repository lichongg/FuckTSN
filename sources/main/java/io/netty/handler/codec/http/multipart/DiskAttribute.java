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
public class DiskAttribute extends AbstractDiskHttpData implements Attribute {
    public static String baseDirectory = null;
    public static boolean deleteOnExitTemporaryFile = true;
    public static final String postfix = ".att";
    public static final String prefix = "Attr_";

    public DiskAttribute(String str) {
        this(str, HttpConstants.DEFAULT_CHARSET);
    }

    public DiskAttribute(String str, long j6) {
        this(str, j6, HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData, io.netty.handler.codec.http.multipart.HttpData
    public void addContent(ByteBuf byteBuf, boolean z5) throws IOException {
        long readableBytes = this.size + byteBuf.readableBytes();
        checkSize(readableBytes);
        long j6 = this.definedSize;
        if (j6 > 0 && j6 < readableBytes) {
            this.definedSize = readableBytes;
        }
        super.addContent(byteBuf, z5);
    }

    @Override // java.lang.Comparable
    public int compareTo(InterfaceHttpData interfaceHttpData) {
        if (interfaceHttpData instanceof Attribute) {
            return compareTo((Attribute) interfaceHttpData);
        }
        throw new ClassCastException("Cannot compare " + getHttpDataType() + " with " + interfaceHttpData.getHttpDataType());
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData
    protected boolean deleteOnExit() {
        return deleteOnExitTemporaryFile;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Attribute) {
            return getName().equalsIgnoreCase(((Attribute) obj).getName());
        }
        return false;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData
    protected String getBaseDirectory() {
        return baseDirectory;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData
    protected String getDiskFilename() {
        return getName() + postfix;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData
    public InterfaceHttpData.HttpDataType getHttpDataType() {
        return InterfaceHttpData.HttpDataType.Attribute;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData
    protected String getPostfix() {
        return postfix;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData
    protected String getPrefix() {
        return prefix;
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
        try {
            return getName() + '=' + getValue();
        } catch (IOException e6) {
            return getName() + '=' + e6;
        }
    }

    public DiskAttribute(String str, Charset charset) {
        super(str, charset, 0L);
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
    public String getValue() throws IOException {
        return new String(get(), getCharset());
    }

    public int hashCode() {
        return getName().hashCode();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public Attribute replace(ByteBuf byteBuf) {
        DiskAttribute diskAttribute = new DiskAttribute(getName());
        diskAttribute.setCharset(getCharset());
        if (byteBuf == null) {
            return diskAttribute;
        }
        try {
            diskAttribute.setContent(byteBuf);
            return diskAttribute;
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

    public DiskAttribute(String str, long j6, Charset charset) {
        super(str, charset, j6);
    }

    public DiskAttribute(String str, String str2) throws IOException {
        this(str, str2, HttpConstants.DEFAULT_CHARSET);
    }

    public DiskAttribute(String str, String str2, Charset charset) throws IOException {
        super(str, charset, 0L);
        setValue(str2);
    }

    public int compareTo(Attribute attribute) {
        return getName().compareToIgnoreCase(attribute.getName());
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public Attribute retain(int i6) {
        super.retain(i6);
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData, io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public Attribute touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public Attribute retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData, io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.ReferenceCounted
    public Attribute touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
