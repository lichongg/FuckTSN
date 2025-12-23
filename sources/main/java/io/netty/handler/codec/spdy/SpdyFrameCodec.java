package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.net.SocketAddress;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SpdyFrameCodec extends ByteToMessageDecoder implements SpdyFrameDecoderDelegate, ChannelOutboundHandler {
    private static final SpdyProtocolException INVALID_FRAME = new SpdyProtocolException("Received invalid frame");
    private ChannelHandlerContext ctx;
    private boolean read;
    private final SpdyFrameDecoder spdyFrameDecoder;
    private final SpdyFrameEncoder spdyFrameEncoder;
    private final SpdyHeaderBlockDecoder spdyHeaderBlockDecoder;
    private final SpdyHeaderBlockEncoder spdyHeaderBlockEncoder;
    private SpdyHeadersFrame spdyHeadersFrame;
    private SpdySettingsFrame spdySettingsFrame;
    private final boolean validateHeaders;

    public SpdyFrameCodec(SpdyVersion spdyVersion) {
        this(spdyVersion, true);
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readDataFrame(int i6, boolean z5, ByteBuf byteBuf) {
        this.read = true;
        DefaultSpdyDataFrame defaultSpdyDataFrame = new DefaultSpdyDataFrame(i6, byteBuf);
        defaultSpdyDataFrame.setLast(z5);
        this.ctx.fireChannelRead((Object) defaultSpdyDataFrame);
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readGoAwayFrame(int i6, int i7) {
        this.read = true;
        this.ctx.fireChannelRead((Object) new DefaultSpdyGoAwayFrame(i6, i7));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void readHeaderBlockEnd() {
        /*
            r4 = this;
            r0 = 0
            io.netty.handler.codec.spdy.SpdyHeaderBlockDecoder r1 = r4.spdyHeaderBlockDecoder     // Catch: java.lang.Exception -> Lf
            io.netty.handler.codec.spdy.SpdyHeadersFrame r2 = r4.spdyHeadersFrame     // Catch: java.lang.Exception -> Lf
            r1.endHeaderBlock(r2)     // Catch: java.lang.Exception -> Lf
            io.netty.handler.codec.spdy.SpdyHeadersFrame r1 = r4.spdyHeadersFrame     // Catch: java.lang.Exception -> Lf
            r4.spdyHeadersFrame = r0     // Catch: java.lang.Exception -> Ld
            goto L18
        Ld:
            r0 = move-exception
            goto L13
        Lf:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L13:
            io.netty.channel.ChannelHandlerContext r2 = r4.ctx
            r2.fireExceptionCaught(r0)
        L18:
            if (r1 == 0) goto L22
            r0 = 1
            r4.read = r0
            io.netty.channel.ChannelHandlerContext r0 = r4.ctx
            r0.fireChannelRead(r1)
        L22:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.spdy.SpdyFrameCodec.readHeaderBlockEnd():void");
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readPingFrame(int i6) {
        this.read = true;
        this.ctx.fireChannelRead((Object) new DefaultSpdyPingFrame(i6));
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readRstStreamFrame(int i6, int i7) {
        this.read = true;
        this.ctx.fireChannelRead((Object) new DefaultSpdyRstStreamFrame(i6, i7));
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readSettingsEnd() {
        this.read = true;
        SpdySettingsFrame spdySettingsFrame = this.spdySettingsFrame;
        this.spdySettingsFrame = null;
        this.ctx.fireChannelRead((Object) spdySettingsFrame);
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readSettingsFrame(boolean z5) {
        this.read = true;
        DefaultSpdySettingsFrame defaultSpdySettingsFrame = new DefaultSpdySettingsFrame();
        this.spdySettingsFrame = defaultSpdySettingsFrame;
        defaultSpdySettingsFrame.setClearPreviouslyPersistedSettings(z5);
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readWindowUpdateFrame(int i6, int i7) {
        this.read = true;
        this.ctx.fireChannelRead((Object) new DefaultSpdyWindowUpdateFrame(i6, i7));
    }

    public SpdyFrameCodec(SpdyVersion spdyVersion, boolean z5) {
        this(spdyVersion, 8192, 16384, 6, 15, 8, z5);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!this.read && !channelHandlerContext.channel().config().isAutoRead()) {
            channelHandlerContext.read();
        }
        this.read = false;
        super.channelReadComplete(channelHandlerContext);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        this.spdyFrameDecoder.decode(byteBuf);
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readFrameError(String str) {
        this.ctx.fireExceptionCaught((Throwable) INVALID_FRAME);
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readHeaderBlock(ByteBuf byteBuf) {
        try {
            this.spdyHeaderBlockDecoder.decode(this.ctx.alloc(), byteBuf, this.spdyHeadersFrame);
        } catch (Exception e6) {
            this.ctx.fireExceptionCaught((Throwable) e6);
        } finally {
            byteBuf.release();
        }
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readHeadersFrame(int i6, boolean z5) {
        DefaultSpdyHeadersFrame defaultSpdyHeadersFrame = new DefaultSpdyHeadersFrame(i6, this.validateHeaders);
        this.spdyHeadersFrame = defaultSpdyHeadersFrame;
        defaultSpdyHeadersFrame.setLast(z5);
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readSetting(int i6, int i7, boolean z5, boolean z6) {
        this.spdySettingsFrame.setValue(i6, i7, z5, z6);
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readSynReplyFrame(int i6, boolean z5) {
        DefaultSpdySynReplyFrame defaultSpdySynReplyFrame = new DefaultSpdySynReplyFrame(i6, this.validateHeaders);
        defaultSpdySynReplyFrame.setLast(z5);
        this.spdyHeadersFrame = defaultSpdySynReplyFrame;
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readSynStreamFrame(int i6, int i7, byte b6, boolean z5, boolean z6) {
        DefaultSpdySynStreamFrame defaultSpdySynStreamFrame = new DefaultSpdySynStreamFrame(i6, i7, b6, this.validateHeaders);
        defaultSpdySynStreamFrame.setLast(z5);
        defaultSpdySynStreamFrame.setUnidirectional(z6);
        this.spdyHeadersFrame = defaultSpdySynStreamFrame;
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        ByteBuf encode;
        if (obj instanceof SpdyDataFrame) {
            SpdyDataFrame spdyDataFrame = (SpdyDataFrame) obj;
            ByteBuf encodeDataFrame = this.spdyFrameEncoder.encodeDataFrame(channelHandlerContext.alloc(), spdyDataFrame.streamId(), spdyDataFrame.isLast(), spdyDataFrame.content());
            spdyDataFrame.release();
            channelHandlerContext.write(encodeDataFrame, channelPromise);
            return;
        }
        if (obj instanceof SpdySynStreamFrame) {
            SpdySynStreamFrame spdySynStreamFrame = (SpdySynStreamFrame) obj;
            encode = this.spdyHeaderBlockEncoder.encode(channelHandlerContext.alloc(), spdySynStreamFrame);
            try {
                ByteBuf encodeSynStreamFrame = this.spdyFrameEncoder.encodeSynStreamFrame(channelHandlerContext.alloc(), spdySynStreamFrame.streamId(), spdySynStreamFrame.associatedStreamId(), spdySynStreamFrame.priority(), spdySynStreamFrame.isLast(), spdySynStreamFrame.isUnidirectional(), encode);
                encode.release();
                channelHandlerContext.write(encodeSynStreamFrame, channelPromise);
                return;
            } finally {
            }
        }
        if (obj instanceof SpdySynReplyFrame) {
            SpdySynReplyFrame spdySynReplyFrame = (SpdySynReplyFrame) obj;
            encode = this.spdyHeaderBlockEncoder.encode(channelHandlerContext.alloc(), spdySynReplyFrame);
            try {
                ByteBuf encodeSynReplyFrame = this.spdyFrameEncoder.encodeSynReplyFrame(channelHandlerContext.alloc(), spdySynReplyFrame.streamId(), spdySynReplyFrame.isLast(), encode);
                encode.release();
                channelHandlerContext.write(encodeSynReplyFrame, channelPromise);
                return;
            } finally {
            }
        }
        if (obj instanceof SpdyRstStreamFrame) {
            SpdyRstStreamFrame spdyRstStreamFrame = (SpdyRstStreamFrame) obj;
            channelHandlerContext.write(this.spdyFrameEncoder.encodeRstStreamFrame(channelHandlerContext.alloc(), spdyRstStreamFrame.streamId(), spdyRstStreamFrame.status().code()), channelPromise);
            return;
        }
        if (obj instanceof SpdySettingsFrame) {
            channelHandlerContext.write(this.spdyFrameEncoder.encodeSettingsFrame(channelHandlerContext.alloc(), (SpdySettingsFrame) obj), channelPromise);
            return;
        }
        if (obj instanceof SpdyPingFrame) {
            channelHandlerContext.write(this.spdyFrameEncoder.encodePingFrame(channelHandlerContext.alloc(), ((SpdyPingFrame) obj).id()), channelPromise);
            return;
        }
        if (obj instanceof SpdyGoAwayFrame) {
            SpdyGoAwayFrame spdyGoAwayFrame = (SpdyGoAwayFrame) obj;
            channelHandlerContext.write(this.spdyFrameEncoder.encodeGoAwayFrame(channelHandlerContext.alloc(), spdyGoAwayFrame.lastGoodStreamId(), spdyGoAwayFrame.status().code()), channelPromise);
            return;
        }
        if (!(obj instanceof SpdyHeadersFrame)) {
            if (!(obj instanceof SpdyWindowUpdateFrame)) {
                throw new UnsupportedMessageTypeException(obj, (Class<?>[]) new Class[0]);
            }
            SpdyWindowUpdateFrame spdyWindowUpdateFrame = (SpdyWindowUpdateFrame) obj;
            channelHandlerContext.write(this.spdyFrameEncoder.encodeWindowUpdateFrame(channelHandlerContext.alloc(), spdyWindowUpdateFrame.streamId(), spdyWindowUpdateFrame.deltaWindowSize()), channelPromise);
            return;
        }
        SpdyHeadersFrame spdyHeadersFrame = (SpdyHeadersFrame) obj;
        encode = this.spdyHeaderBlockEncoder.encode(channelHandlerContext.alloc(), spdyHeadersFrame);
        try {
            ByteBuf encodeHeadersFrame = this.spdyFrameEncoder.encodeHeadersFrame(channelHandlerContext.alloc(), spdyHeadersFrame.streamId(), spdyHeadersFrame.isLast(), encode);
            encode.release();
            channelHandlerContext.write(encodeHeadersFrame, channelPromise);
        } finally {
        }
    }

    public SpdyFrameCodec(SpdyVersion spdyVersion, int i6, int i7, int i8, int i9, int i10) {
        this(spdyVersion, i6, i7, i8, i9, i10, true);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.bind(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.close(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.deregister(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.disconnect(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.flush();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.handlerAdded(channelHandlerContext);
        this.ctx = channelHandlerContext;
        channelHandlerContext.channel().closeFuture().addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.spdy.SpdyFrameCodec.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                SpdyFrameCodec.this.spdyHeaderBlockDecoder.end();
                SpdyFrameCodec.this.spdyHeaderBlockEncoder.end();
            }
        });
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.read();
    }

    public SpdyFrameCodec(SpdyVersion spdyVersion, int i6, int i7, int i8, int i9, int i10, boolean z5) {
        this(spdyVersion, i6, SpdyHeaderBlockDecoder.newInstance(spdyVersion, i7), SpdyHeaderBlockEncoder.newInstance(spdyVersion, i8, i9, i10), z5);
    }

    protected SpdyFrameCodec(SpdyVersion spdyVersion, int i6, SpdyHeaderBlockDecoder spdyHeaderBlockDecoder, SpdyHeaderBlockEncoder spdyHeaderBlockEncoder, boolean z5) {
        this.spdyFrameDecoder = new SpdyFrameDecoder(spdyVersion, this, i6);
        this.spdyFrameEncoder = new SpdyFrameEncoder(spdyVersion);
        this.spdyHeaderBlockDecoder = spdyHeaderBlockDecoder;
        this.spdyHeaderBlockEncoder = spdyHeaderBlockEncoder;
        this.validateHeaders = z5;
    }
}
