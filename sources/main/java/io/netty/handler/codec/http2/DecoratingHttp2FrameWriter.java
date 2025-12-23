package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http2.Http2FrameWriter;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DecoratingHttp2FrameWriter implements Http2FrameWriter {
    private final Http2FrameWriter delegate;

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, boolean z5, ChannelPromise channelPromise) {
        return this.delegate.writeHeaders(channelHandlerContext, i6, http2Headers, i7, z5, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public Http2FrameWriter.Configuration configuration() {
        return this.delegate.configuration();
    }

    @Override // io.netty.handler.codec.http2.Http2DataWriter
    public ChannelFuture writeData(ChannelHandlerContext channelHandlerContext, int i6, ByteBuf byteBuf, int i7, boolean z5, ChannelPromise channelPromise) {
        return this.delegate.writeData(channelHandlerContext, i6, byteBuf, i7, z5, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeFrame(ChannelHandlerContext channelHandlerContext, byte b6, int i6, Http2Flags http2Flags, ByteBuf byteBuf, ChannelPromise channelPromise) {
        return this.delegate.writeFrame(channelHandlerContext, b6, i6, http2Flags, byteBuf, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeGoAway(ChannelHandlerContext channelHandlerContext, int i6, long j6, ByteBuf byteBuf, ChannelPromise channelPromise) {
        return this.delegate.writeGoAway(channelHandlerContext, i6, j6, byteBuf, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, short s5, boolean z5, int i8, boolean z6, ChannelPromise channelPromise) {
        return this.delegate.writeHeaders(channelHandlerContext, i6, http2Headers, i7, s5, z5, i8, z6, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePing(ChannelHandlerContext channelHandlerContext, boolean z5, long j6, ChannelPromise channelPromise) {
        return this.delegate.writePing(channelHandlerContext, z5, j6, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePriority(ChannelHandlerContext channelHandlerContext, int i6, int i7, short s5, boolean z5, ChannelPromise channelPromise) {
        return this.delegate.writePriority(channelHandlerContext, i6, i7, s5, z5, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePushPromise(ChannelHandlerContext channelHandlerContext, int i6, int i7, Http2Headers http2Headers, int i8, ChannelPromise channelPromise) {
        return this.delegate.writePushPromise(channelHandlerContext, i6, i7, http2Headers, i8, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i6, long j6, ChannelPromise channelPromise) {
        return this.delegate.writeRstStream(channelHandlerContext, i6, j6, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettings(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings, ChannelPromise channelPromise) {
        return this.delegate.writeSettings(channelHandlerContext, http2Settings, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettingsAck(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        return this.delegate.writeSettingsAck(channelHandlerContext, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeWindowUpdate(ChannelHandlerContext channelHandlerContext, int i6, int i7, ChannelPromise channelPromise) {
        return this.delegate.writeWindowUpdate(channelHandlerContext, i6, i7, channelPromise);
    }

    public DecoratingHttp2FrameWriter(Http2FrameWriter http2FrameWriter) {
        this.delegate = (Http2FrameWriter) ObjectUtil.checkNotNull(http2FrameWriter, "delegate");
    }
}
