package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface HttpData extends InterfaceHttpData, ByteBufHolder {
    void addContent(ByteBuf byteBuf, boolean z5) throws IOException;

    void checkSize(long j6) throws IOException;

    HttpData copy();

    long definedLength();

    void delete();

    HttpData duplicate();

    byte[] get() throws IOException;

    ByteBuf getByteBuf() throws IOException;

    Charset getCharset();

    ByteBuf getChunk(int i6) throws IOException;

    File getFile() throws IOException;

    long getMaxSize();

    String getString() throws IOException;

    String getString(Charset charset) throws IOException;

    boolean isCompleted();

    boolean isInMemory();

    long length();

    boolean renameTo(File file) throws IOException;

    HttpData replace(ByteBuf byteBuf);

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData, io.netty.util.ReferenceCounted
    HttpData retain();

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData, io.netty.util.ReferenceCounted
    HttpData retain(int i6);

    HttpData retainedDuplicate();

    void setCharset(Charset charset);

    void setContent(ByteBuf byteBuf) throws IOException;

    void setContent(File file) throws IOException;

    void setContent(InputStream inputStream) throws IOException;

    void setMaxSize(long j6);

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData, io.netty.util.ReferenceCounted
    HttpData touch();

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData, io.netty.util.ReferenceCounted
    HttpData touch(Object obj);
}
