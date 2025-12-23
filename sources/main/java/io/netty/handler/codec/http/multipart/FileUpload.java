package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface FileUpload extends HttpData {
    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    FileUpload copy();

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    FileUpload duplicate();

    String getContentTransferEncoding();

    String getContentType();

    String getFilename();

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    FileUpload replace(ByteBuf byteBuf);

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.handler.codec.http.multipart.InterfaceHttpData, io.netty.util.ReferenceCounted
    FileUpload retain();

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.handler.codec.http.multipart.InterfaceHttpData, io.netty.util.ReferenceCounted
    FileUpload retain(int i6);

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    FileUpload retainedDuplicate();

    void setContentTransferEncoding(String str);

    void setContentType(String str);

    void setFilename(String str);

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.handler.codec.http.multipart.InterfaceHttpData, io.netty.util.ReferenceCounted
    FileUpload touch();

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.handler.codec.http.multipart.InterfaceHttpData, io.netty.util.ReferenceCounted
    FileUpload touch(Object obj);
}
