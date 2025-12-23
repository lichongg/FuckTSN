package io.netty.handler.codec.smtp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface SmtpContent extends ByteBufHolder {
    @Override // io.netty.buffer.ByteBufHolder
    SmtpContent copy();

    @Override // io.netty.buffer.ByteBufHolder
    SmtpContent duplicate();

    @Override // io.netty.buffer.ByteBufHolder
    SmtpContent replace(ByteBuf byteBuf);

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    SmtpContent retain();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    SmtpContent retain(int i6);

    @Override // io.netty.buffer.ByteBufHolder
    SmtpContent retainedDuplicate();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    SmtpContent touch();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    SmtpContent touch(Object obj);
}
