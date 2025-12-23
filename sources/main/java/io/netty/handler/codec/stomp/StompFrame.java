package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface StompFrame extends StompHeadersSubframe, LastStompContentSubframe {
    @Override // io.netty.handler.codec.stomp.LastStompContentSubframe, io.netty.handler.codec.stomp.StompContentSubframe, io.netty.buffer.ByteBufHolder
    StompFrame copy();

    @Override // io.netty.handler.codec.stomp.LastStompContentSubframe, io.netty.handler.codec.stomp.StompContentSubframe, io.netty.buffer.ByteBufHolder
    StompFrame duplicate();

    @Override // io.netty.handler.codec.stomp.LastStompContentSubframe, io.netty.handler.codec.stomp.StompContentSubframe, io.netty.buffer.ByteBufHolder
    StompFrame replace(ByteBuf byteBuf);

    @Override // io.netty.handler.codec.stomp.LastStompContentSubframe, io.netty.handler.codec.stomp.StompContentSubframe, io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    StompFrame retain();

    @Override // io.netty.handler.codec.stomp.LastStompContentSubframe, io.netty.handler.codec.stomp.StompContentSubframe, io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    StompFrame retain(int i6);

    @Override // io.netty.handler.codec.stomp.LastStompContentSubframe, io.netty.handler.codec.stomp.StompContentSubframe, io.netty.buffer.ByteBufHolder
    StompFrame retainedDuplicate();

    @Override // io.netty.handler.codec.stomp.LastStompContentSubframe, io.netty.handler.codec.stomp.StompContentSubframe, io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    StompFrame touch();

    @Override // io.netty.handler.codec.stomp.LastStompContentSubframe, io.netty.handler.codec.stomp.StompContentSubframe, io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    StompFrame touch(Object obj);
}
