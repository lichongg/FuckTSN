package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface StompContentSubframe extends ByteBufHolder, StompSubframe {
    @Override // io.netty.buffer.ByteBufHolder
    StompContentSubframe copy();

    @Override // io.netty.buffer.ByteBufHolder
    StompContentSubframe duplicate();

    @Override // io.netty.buffer.ByteBufHolder
    StompContentSubframe replace(ByteBuf byteBuf);

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    StompContentSubframe retain();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    StompContentSubframe retain(int i6);

    @Override // io.netty.buffer.ByteBufHolder
    StompContentSubframe retainedDuplicate();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    StompContentSubframe touch();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    StompContentSubframe touch(Object obj);
}
