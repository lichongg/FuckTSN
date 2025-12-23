package io.netty.handler.codec.http2;

import com.baidu.mobads.sdk.internal.bu;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2FrameLogger;
import io.netty.handler.codec.http2.Http2FrameReader;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Http2InboundFrameLogger implements Http2FrameReader {
    private final Http2FrameLogger logger;
    private final Http2FrameReader reader;

    @Override // io.netty.handler.codec.http2.Http2FrameReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.reader.close();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader
    public Http2FrameReader.Configuration configuration() {
        return this.reader.configuration();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader
    public void readFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, final Http2FrameListener http2FrameListener) throws Http2Exception {
        this.reader.readFrame(channelHandlerContext, byteBuf, new Http2FrameListener() { // from class: io.netty.handler.codec.http2.Http2InboundFrameLogger.1
            @Override // io.netty.handler.codec.http2.Http2FrameListener
            public void onHeadersRead(ChannelHandlerContext channelHandlerContext2, int i6, Http2Headers http2Headers, int i7, boolean z5) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logHeaders(Http2FrameLogger.Direction.INBOUND, channelHandlerContext2, i6, http2Headers, i7, z5);
                http2FrameListener.onHeadersRead(channelHandlerContext2, i6, http2Headers, i7, z5);
            }

            @Override // io.netty.handler.codec.http2.Http2FrameListener
            public int onDataRead(ChannelHandlerContext channelHandlerContext2, int i6, ByteBuf byteBuf2, int i7, boolean z5) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logData(Http2FrameLogger.Direction.INBOUND, channelHandlerContext2, i6, byteBuf2, i7, z5);
                return http2FrameListener.onDataRead(channelHandlerContext2, i6, byteBuf2, i7, z5);
            }

            @Override // io.netty.handler.codec.http2.Http2FrameListener
            public void onGoAwayRead(ChannelHandlerContext channelHandlerContext2, int i6, long j6, ByteBuf byteBuf2) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logGoAway(Http2FrameLogger.Direction.INBOUND, channelHandlerContext2, i6, j6, byteBuf2);
                http2FrameListener.onGoAwayRead(channelHandlerContext2, i6, j6, byteBuf2);
            }

            @Override // io.netty.handler.codec.http2.Http2FrameListener
            public void onPingAckRead(ChannelHandlerContext channelHandlerContext2, long j6) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logPingAck(Http2FrameLogger.Direction.INBOUND, channelHandlerContext2, j6);
                http2FrameListener.onPingAckRead(channelHandlerContext2, j6);
            }

            @Override // io.netty.handler.codec.http2.Http2FrameListener
            public void onPingRead(ChannelHandlerContext channelHandlerContext2, long j6) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logPing(Http2FrameLogger.Direction.INBOUND, channelHandlerContext2, j6);
                http2FrameListener.onPingRead(channelHandlerContext2, j6);
            }

            @Override // io.netty.handler.codec.http2.Http2FrameListener
            public void onPriorityRead(ChannelHandlerContext channelHandlerContext2, int i6, int i7, short s5, boolean z5) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logPriority(Http2FrameLogger.Direction.INBOUND, channelHandlerContext2, i6, i7, s5, z5);
                http2FrameListener.onPriorityRead(channelHandlerContext2, i6, i7, s5, z5);
            }

            @Override // io.netty.handler.codec.http2.Http2FrameListener
            public void onPushPromiseRead(ChannelHandlerContext channelHandlerContext2, int i6, int i7, Http2Headers http2Headers, int i8) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logPushPromise(Http2FrameLogger.Direction.INBOUND, channelHandlerContext2, i6, i7, http2Headers, i8);
                http2FrameListener.onPushPromiseRead(channelHandlerContext2, i6, i7, http2Headers, i8);
            }

            @Override // io.netty.handler.codec.http2.Http2FrameListener
            public void onRstStreamRead(ChannelHandlerContext channelHandlerContext2, int i6, long j6) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logRstStream(Http2FrameLogger.Direction.INBOUND, channelHandlerContext2, i6, j6);
                http2FrameListener.onRstStreamRead(channelHandlerContext2, i6, j6);
            }

            @Override // io.netty.handler.codec.http2.Http2FrameListener
            public void onSettingsAckRead(ChannelHandlerContext channelHandlerContext2) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logSettingsAck(Http2FrameLogger.Direction.INBOUND, channelHandlerContext2);
                http2FrameListener.onSettingsAckRead(channelHandlerContext2);
            }

            @Override // io.netty.handler.codec.http2.Http2FrameListener
            public void onSettingsRead(ChannelHandlerContext channelHandlerContext2, Http2Settings http2Settings) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logSettings(Http2FrameLogger.Direction.INBOUND, channelHandlerContext2, http2Settings);
                http2FrameListener.onSettingsRead(channelHandlerContext2, http2Settings);
            }

            @Override // io.netty.handler.codec.http2.Http2FrameListener
            public void onUnknownFrame(ChannelHandlerContext channelHandlerContext2, byte b6, int i6, Http2Flags http2Flags, ByteBuf byteBuf2) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logUnknownFrame(Http2FrameLogger.Direction.INBOUND, channelHandlerContext2, b6, i6, http2Flags, byteBuf2);
                http2FrameListener.onUnknownFrame(channelHandlerContext2, b6, i6, http2Flags, byteBuf2);
            }

            @Override // io.netty.handler.codec.http2.Http2FrameListener
            public void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext2, int i6, int i7) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logWindowsUpdate(Http2FrameLogger.Direction.INBOUND, channelHandlerContext2, i6, i7);
                http2FrameListener.onWindowUpdateRead(channelHandlerContext2, i6, i7);
            }

            @Override // io.netty.handler.codec.http2.Http2FrameListener
            public void onHeadersRead(ChannelHandlerContext channelHandlerContext2, int i6, Http2Headers http2Headers, int i7, short s5, boolean z5, int i8, boolean z6) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logHeaders(Http2FrameLogger.Direction.INBOUND, channelHandlerContext2, i6, http2Headers, i7, s5, z5, i8, z6);
                http2FrameListener.onHeadersRead(channelHandlerContext2, i6, http2Headers, i7, s5, z5, i8, z6);
            }
        });
    }

    public Http2InboundFrameLogger(Http2FrameReader http2FrameReader, Http2FrameLogger http2FrameLogger) {
        this.reader = (Http2FrameReader) ObjectUtil.checkNotNull(http2FrameReader, "reader");
        this.logger = (Http2FrameLogger) ObjectUtil.checkNotNull(http2FrameLogger, bu.f10800a);
    }
}
