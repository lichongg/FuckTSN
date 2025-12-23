package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class MixedAttribute implements Attribute {
    private Attribute attribute;
    private final long limitSize;
    private long maxSize;

    public MixedAttribute(String str, long j6) {
        this(str, j6, HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString() throws IOException {
        return this.attribute.getString();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.attribute.release();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(ByteBuf byteBuf) throws IOException {
        checkSize(byteBuf.readableBytes());
        if (byteBuf.readableBytes() > this.limitSize && (this.attribute instanceof MemoryAttribute)) {
            DiskAttribute diskAttribute = new DiskAttribute(this.attribute.getName(), this.attribute.definedLength());
            this.attribute = diskAttribute;
            diskAttribute.setMaxSize(this.maxSize);
        }
        this.attribute.setContent(byteBuf);
    }

    public MixedAttribute(String str, long j6, long j7) {
        this(str, j6, j7, HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void addContent(ByteBuf byteBuf, boolean z5) throws IOException {
        Attribute attribute = this.attribute;
        if (attribute instanceof MemoryAttribute) {
            checkSize(attribute.length() + byteBuf.readableBytes());
            if (this.attribute.length() + byteBuf.readableBytes() > this.limitSize) {
                DiskAttribute diskAttribute = new DiskAttribute(this.attribute.getName(), this.attribute.definedLength());
                diskAttribute.setMaxSize(this.maxSize);
                if (((MemoryAttribute) this.attribute).getByteBuf() != null) {
                    diskAttribute.addContent(((MemoryAttribute) this.attribute).getByteBuf(), false);
                }
                this.attribute = diskAttribute;
            }
        }
        this.attribute.addContent(byteBuf, z5);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void checkSize(long j6) throws IOException {
        long j7 = this.maxSize;
        if (j7 >= 0 && j6 > j7) {
            throw new IOException("Size exceed allowed maximum capacity");
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(InterfaceHttpData interfaceHttpData) {
        return this.attribute.compareTo(interfaceHttpData);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        return this.attribute.content();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public long definedLength() {
        return this.attribute.definedLength();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void delete() {
        this.attribute.delete();
    }

    public boolean equals(Object obj) {
        return this.attribute.equals(obj);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public byte[] get() throws IOException {
        return this.attribute.get();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getByteBuf() throws IOException {
        return this.attribute.getByteBuf();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public Charset getCharset() {
        return this.attribute.getCharset();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getChunk(int i6) throws IOException {
        return this.attribute.getChunk(i6);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public File getFile() throws IOException {
        return this.attribute.getFile();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData
    public InterfaceHttpData.HttpDataType getHttpDataType() {
        return this.attribute.getHttpDataType();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public long getMaxSize() {
        return this.maxSize;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData
    public String getName() {
        return this.attribute.getName();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString(Charset charset) throws IOException {
        return this.attribute.getString(charset);
    }

    @Override // io.netty.handler.codec.http.multipart.Attribute
    public String getValue() throws IOException {
        return this.attribute.getValue();
    }

    public int hashCode() {
        return this.attribute.hashCode();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean isCompleted() {
        return this.attribute.isCompleted();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean isInMemory() {
        return this.attribute.isInMemory();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public long length() {
        return this.attribute.length();
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.attribute.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i6) {
        return this.attribute.release(i6);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean renameTo(File file) throws IOException {
        return this.attribute.renameTo(file);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setCharset(Charset charset) {
        this.attribute.setCharset(charset);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setMaxSize(long j6) {
        this.maxSize = j6;
        this.attribute.setMaxSize(j6);
    }

    @Override // io.netty.handler.codec.http.multipart.Attribute
    public void setValue(String str) throws IOException {
        if (str != null) {
            checkSize(str.getBytes().length);
        }
        this.attribute.setValue(str);
    }

    public String toString() {
        return "Mixed: " + this.attribute;
    }

    public MixedAttribute(String str, long j6, Charset charset) {
        this.maxSize = -1L;
        this.limitSize = j6;
        this.attribute = new MemoryAttribute(str, charset);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public Attribute copy() {
        return this.attribute.copy();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public Attribute duplicate() {
        return this.attribute.duplicate();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public Attribute replace(ByteBuf byteBuf) {
        return this.attribute.replace(byteBuf);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public Attribute retainedDuplicate() {
        return this.attribute.retainedDuplicate();
    }

    public MixedAttribute(String str, long j6, long j7, Charset charset) {
        this.maxSize = -1L;
        this.limitSize = j7;
        this.attribute = new MemoryAttribute(str, j6, charset);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(File file) throws IOException {
        checkSize(file.length());
        if (file.length() > this.limitSize && (this.attribute instanceof MemoryAttribute)) {
            DiskAttribute diskAttribute = new DiskAttribute(this.attribute.getName(), this.attribute.definedLength());
            this.attribute = diskAttribute;
            diskAttribute.setMaxSize(this.maxSize);
        }
        this.attribute.setContent(file);
    }

    @Override // io.netty.util.ReferenceCounted
    public Attribute retain() {
        this.attribute.retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public Attribute touch() {
        this.attribute.touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public Attribute retain(int i6) {
        this.attribute.retain(i6);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public Attribute touch(Object obj) {
        this.attribute.touch(obj);
        return this;
    }

    public MixedAttribute(String str, String str2, long j6) {
        this(str, str2, j6, HttpConstants.DEFAULT_CHARSET);
    }

    public MixedAttribute(String str, String str2, long j6, Charset charset) {
        this.maxSize = -1L;
        this.limitSize = j6;
        if (str2.length() > j6) {
            try {
                this.attribute = new DiskAttribute(str, str2, charset);
                return;
            } catch (IOException e6) {
                try {
                    this.attribute = new MemoryAttribute(str, str2, charset);
                    return;
                } catch (IOException unused) {
                    throw new IllegalArgumentException(e6);
                }
            }
        }
        try {
            this.attribute = new MemoryAttribute(str, str2, charset);
        } catch (IOException e7) {
            throw new IllegalArgumentException(e7);
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(InputStream inputStream) throws IOException {
        if (this.attribute instanceof MemoryAttribute) {
            DiskAttribute diskAttribute = new DiskAttribute(this.attribute.getName(), this.attribute.definedLength());
            this.attribute = diskAttribute;
            diskAttribute.setMaxSize(this.maxSize);
        }
        this.attribute.setContent(inputStream);
    }
}
