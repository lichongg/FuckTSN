package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface Http2DataFrame extends Http2StreamFrame, ByteBufHolder {
    @Override // io.netty.buffer.ByteBufHolder
    ByteBuf content();

    @Override // io.netty.buffer.ByteBufHolder
    Http2DataFrame copy();

    @Override // io.netty.buffer.ByteBufHolder
    Http2DataFrame duplicate();

    int initialFlowControlledBytes();

    boolean isEndStream();

    int padding();

    @Override // io.netty.buffer.ByteBufHolder
    Http2DataFrame replace(ByteBuf byteBuf);

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    Http2DataFrame retain();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    Http2DataFrame retain(int i6);

    @Override // io.netty.buffer.ByteBufHolder
    Http2DataFrame retainedDuplicate();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    Http2DataFrame touch();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    Http2DataFrame touch(Object obj);
}
