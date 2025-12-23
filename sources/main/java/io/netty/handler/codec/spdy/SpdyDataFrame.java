package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface SpdyDataFrame extends ByteBufHolder, SpdyStreamFrame {
    @Override // io.netty.buffer.ByteBufHolder
    ByteBuf content();

    @Override // io.netty.buffer.ByteBufHolder
    SpdyDataFrame copy();

    @Override // io.netty.buffer.ByteBufHolder
    SpdyDataFrame duplicate();

    @Override // io.netty.buffer.ByteBufHolder
    SpdyDataFrame replace(ByteBuf byteBuf);

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    SpdyDataFrame retain();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    SpdyDataFrame retain(int i6);

    @Override // io.netty.buffer.ByteBufHolder
    SpdyDataFrame retainedDuplicate();

    SpdyDataFrame setLast(boolean z5);

    SpdyDataFrame setStreamId(int i6);

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    SpdyDataFrame touch();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    SpdyDataFrame touch(Object obj);
}
