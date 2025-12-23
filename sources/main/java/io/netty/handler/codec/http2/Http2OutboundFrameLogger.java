package io.netty.handler.codec.http2;

import com.baidu.mobads.sdk.internal.bu;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http2.Http2FrameLogger;
import io.netty.handler.codec.http2.Http2FrameWriter;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Http2OutboundFrameLogger implements Http2FrameWriter {
    private final Http2FrameLogger logger;
    private final Http2FrameWriter writer;

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, boolean z5, ChannelPromise channelPromise) {
        this.logger.logHeaders(Http2FrameLogger.Direction.OUTBOUND, channelHandlerContext, i6, http2Headers, i7, z5);
        return this.writer.writeHeaders(channelHandlerContext, i6, http2Headers, i7, z5, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.writer.close();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public Http2FrameWriter.Configuration configuration() {
        return this.writer.configuration();
    }

    @Override // io.netty.handler.codec.http2.Http2DataWriter
    public ChannelFuture writeData(ChannelHandlerContext channelHandlerContext, int i6, ByteBuf byteBuf, int i7, boolean z5, ChannelPromise channelPromise) {
        this.logger.logData(Http2FrameLogger.Direction.OUTBOUND, channelHandlerContext, i6, byteBuf, i7, z5);
        return this.writer.writeData(channelHandlerContext, i6, byteBuf, i7, z5, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeFrame(ChannelHandlerContext channelHandlerContext, byte b6, int i6, Http2Flags http2Flags, ByteBuf byteBuf, ChannelPromise channelPromise) {
        this.logger.logUnknownFrame(Http2FrameLogger.Direction.OUTBOUND, channelHandlerContext, b6, i6, http2Flags, byteBuf);
        return this.writer.writeFrame(channelHandlerContext, b6, i6, http2Flags, byteBuf, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeGoAway(ChannelHandlerContext channelHandlerContext, int i6, long j6, ByteBuf byteBuf, ChannelPromise channelPromise) {
        this.logger.logGoAway(Http2FrameLogger.Direction.OUTBOUND, channelHandlerContext, i6, j6, byteBuf);
        return this.writer.writeGoAway(channelHandlerContext, i6, j6, byteBuf, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePing(ChannelHandlerContext channelHandlerContext, boolean z5, long j6, ChannelPromise channelPromise) {
        if (z5) {
            this.logger.logPingAck(Http2FrameLogger.Direction.OUTBOUND, channelHandlerContext, j6);
        } else {
            this.logger.logPing(Http2FrameLogger.Direction.OUTBOUND, channelHandlerContext, j6);
        }
        return this.writer.writePing(channelHandlerContext, z5, j6, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePriority(ChannelHandlerContext channelHandlerContext, int i6, int i7, short s5, boolean z5, ChannelPromise channelPromise) {
        this.logger.logPriority(Http2FrameLogger.Direction.OUTBOUND, channelHandlerContext, i6, i7, s5, z5);
        return this.writer.writePriority(channelHandlerContext, i6, i7, s5, z5, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePushPromise(ChannelHandlerContext channelHandlerContext, int i6, int i7, Http2Headers http2Headers, int i8, ChannelPromise channelPromise) {
        this.logger.logPushPromise(Http2FrameLogger.Direction.OUTBOUND, channelHandlerContext, i6, i7, http2Headers, i8);
        return this.writer.writePushPromise(channelHandlerContext, i6, i7, http2Headers, i8, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i6, long j6, ChannelPromise channelPromise) {
        this.logger.logRstStream(Http2FrameLogger.Direction.OUTBOUND, channelHandlerContext, i6, j6);
        return this.writer.writeRstStream(channelHandlerContext, i6, j6, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettings(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings, ChannelPromise channelPromise) {
        this.logger.logSettings(Http2FrameLogger.Direction.OUTBOUND, channelHandlerContext, http2Settings);
        return this.writer.writeSettings(channelHandlerContext, http2Settings, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettingsAck(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        this.logger.logSettingsAck(Http2FrameLogger.Direction.OUTBOUND, channelHandlerContext);
        return this.writer.writeSettingsAck(channelHandlerContext, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeWindowUpdate(ChannelHandlerContext channelHandlerContext, int i6, int i7, ChannelPromise channelPromise) {
        this.logger.logWindowsUpdate(Http2FrameLogger.Direction.OUTBOUND, channelHandlerContext, i6, i7);
        return this.writer.writeWindowUpdate(channelHandlerContext, i6, i7, channelPromise);
    }

    public Http2OutboundFrameLogger(Http2FrameWriter http2FrameWriter, Http2FrameLogger http2FrameLogger) {
        this.writer = (Http2FrameWriter) ObjectUtil.checkNotNull(http2FrameWriter, "writer");
        this.logger = (Http2FrameLogger) ObjectUtil.checkNotNull(http2FrameLogger, bu.f10800a);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, short s5, boolean z5, int i8, boolean z6, ChannelPromise channelPromise) {
        this.logger.logHeaders(Http2FrameLogger.Direction.OUTBOUND, channelHandlerContext, i6, http2Headers, i7, s5, z5, i8, z6);
        return this.writer.writeHeaders(channelHandlerContext, i6, http2Headers, i7, s5, z5, i8, z6, channelPromise);
    }
}
