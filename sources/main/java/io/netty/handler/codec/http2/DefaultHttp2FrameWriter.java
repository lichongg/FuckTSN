package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http2.Http2CodecUtil;
import io.netty.handler.codec.http2.Http2FrameWriter;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.util.collection.CharObjectMap;
import io.netty.util.internal.ObjectUtil;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultHttp2FrameWriter implements Http2FrameWriter, Http2FrameSizePolicy, Http2FrameWriter.Configuration {
    private static final String STREAM_DEPENDENCY = "Stream Dependency";
    private static final String STREAM_ID = "Stream ID";
    private static final ByteBuf ZERO_BUFFER = Unpooled.unreleasableBuffer(Unpooled.directBuffer(255).writeZero(255)).asReadOnly();
    private final Http2HeadersEncoder headersEncoder;
    private int maxFrameSize;

    public DefaultHttp2FrameWriter() {
        this(new DefaultHttp2HeadersEncoder());
    }

    private static void verifyWeight(short s5) {
        if (s5 < 1 || s5 > 256) {
            throw new IllegalArgumentException("Invalid weight: " + ((int) s5));
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameSizePolicy
    public void maxFrameSize(int i6) throws Http2Exception {
        if (!Http2CodecUtil.isMaxFrameSizeValid(i6)) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Invalid MAX_FRAME_SIZE specified in sent settings: %d", Integer.valueOf(i6));
        }
        this.maxFrameSize = i6;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, boolean z5, ChannelPromise channelPromise) {
        return writeHeadersInternal(channelHandlerContext, i6, http2Headers, i7, z5, false, 0, (short) 0, false, channelPromise);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00cd, code lost:
    
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c3, code lost:
    
        r1.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c1, code lost:
    
        if (r1 != null) goto L33;
     */
    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.netty.channel.ChannelFuture writePushPromise(io.netty.channel.ChannelHandlerContext r7, int r8, int r9, io.netty.handler.codec.http2.Http2Headers r10, int r11, io.netty.channel.ChannelPromise r12) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.DefaultHttp2FrameWriter.writePushPromise(io.netty.channel.ChannelHandlerContext, int, int, io.netty.handler.codec.http2.Http2Headers, int, io.netty.channel.ChannelPromise):io.netty.channel.ChannelFuture");
    }

    public DefaultHttp2FrameWriter(Http2HeadersEncoder.SensitivityDetector sensitivityDetector) {
        this(new DefaultHttp2HeadersEncoder(sensitivityDetector));
    }

    private static int paddingBytes(int i6) {
        return i6 - 1;
    }

    private static void verifyErrorCode(long j6) {
        if (j6 < 0 || j6 > 4294967295L) {
            throw new IllegalArgumentException("Invalid errorCode: " + j6);
        }
    }

    private static void verifyPingPayload(ByteBuf byteBuf) {
        if (byteBuf == null || byteBuf.readableBytes() != 8) {
            throw new IllegalArgumentException("Opaque data must be 8 bytes");
        }
    }

    private static void verifyStreamId(int i6, String str) {
        ObjectUtil.checkPositive(i6, "streamId");
    }

    private static void verifyStreamOrConnectionId(int i6, String str) {
        ObjectUtil.checkPositiveOrZero(i6, "streamId");
    }

    private static void verifyWindowSizeIncrement(int i6) {
        ObjectUtil.checkPositiveOrZero(i6, "windowSizeIncrement");
    }

    private ChannelFuture writeContinuationFrames(ChannelHandlerContext channelHandlerContext, int i6, ByteBuf byteBuf, int i7, Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator) {
        Http2Flags paddingPresent = new Http2Flags().paddingPresent(i7 > 0);
        int i8 = this.maxFrameSize - i7;
        if (i8 <= 0) {
            return simpleChannelPromiseAggregator.setFailure((Throwable) new IllegalArgumentException("Padding [" + i7 + "] is too large for max frame size [" + this.maxFrameSize + "]"));
        }
        if (byteBuf.isReadable()) {
            int min = Math.min(byteBuf.readableBytes(), i8) + i7;
            ByteBuf buffer = channelHandlerContext.alloc().buffer(10);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, min, (byte) 9, paddingPresent, i6);
            writePaddingLength(buffer, i7);
            do {
                int min2 = Math.min(byteBuf.readableBytes(), i8);
                ByteBuf readRetainedSlice = byteBuf.readRetainedSlice(min2);
                int i9 = min2 + i7;
                if (byteBuf.isReadable()) {
                    channelHandlerContext.write(buffer.retain(), simpleChannelPromiseAggregator.newPromise());
                } else {
                    paddingPresent = paddingPresent.endOfHeaders(true);
                    buffer.release();
                    buffer = channelHandlerContext.alloc().buffer(10);
                    Http2CodecUtil.writeFrameHeaderInternal(buffer, i9, (byte) 9, paddingPresent, i6);
                    writePaddingLength(buffer, i7);
                    channelHandlerContext.write(buffer, simpleChannelPromiseAggregator.newPromise());
                }
                channelHandlerContext.write(readRetainedSlice, simpleChannelPromiseAggregator.newPromise());
                if (paddingBytes(i7) > 0) {
                    channelHandlerContext.write(ZERO_BUFFER.slice(0, paddingBytes(i7)), simpleChannelPromiseAggregator.newPromise());
                }
            } while (byteBuf.isReadable());
        }
        return simpleChannelPromiseAggregator;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0100, code lost:
    
        if (r6 == null) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private io.netty.channel.ChannelFuture writeHeadersInternal(io.netty.channel.ChannelHandlerContext r15, int r16, io.netty.handler.codec.http2.Http2Headers r17, int r18, boolean r19, boolean r20, int r21, short r22, boolean r23, io.netty.channel.ChannelPromise r24) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.DefaultHttp2FrameWriter.writeHeadersInternal(io.netty.channel.ChannelHandlerContext, int, io.netty.handler.codec.http2.Http2Headers, int, boolean, boolean, int, short, boolean, io.netty.channel.ChannelPromise):io.netty.channel.ChannelFuture");
    }

    private static void writePaddingLength(ByteBuf byteBuf, int i6) {
        if (i6 > 0) {
            byteBuf.writeByte(i6 - 1);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter.Configuration
    public Http2HeadersEncoder.Configuration headersConfiguration() {
        return this.headersEncoder.configuration();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x016e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014d A[Catch: all -> 0x0138, TRY_LEAVE, TryCatch #5 {all -> 0x0138, blocks: (B:27:0x00e1, B:32:0x0109, B:35:0x0110, B:38:0x0126, B:57:0x013c, B:58:0x0147, B:60:0x014d), top: B:26:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010f  */
    @Override // io.netty.handler.codec.http2.Http2DataWriter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.netty.channel.ChannelFuture writeData(io.netty.channel.ChannelHandlerContext r17, int r18, io.netty.buffer.ByteBuf r19, int r20, boolean r21, io.netty.channel.ChannelPromise r22) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.DefaultHttp2FrameWriter.writeData(io.netty.channel.ChannelHandlerContext, int, io.netty.buffer.ByteBuf, int, boolean, io.netty.channel.ChannelPromise):io.netty.channel.ChannelFuture");
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeFrame(ChannelHandlerContext channelHandlerContext, byte b6, int i6, Http2Flags http2Flags, ByteBuf byteBuf, ChannelPromise channelPromise) {
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        try {
            verifyStreamOrConnectionId(i6, STREAM_ID);
            ByteBuf buffer = channelHandlerContext.alloc().buffer(9);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, byteBuf.readableBytes(), b6, http2Flags, i6);
            channelHandlerContext.write(buffer, simpleChannelPromiseAggregator.newPromise());
            try {
                channelHandlerContext.write(byteBuf, simpleChannelPromiseAggregator.newPromise());
            } catch (Throwable th) {
                simpleChannelPromiseAggregator.setFailure(th);
            }
            return simpleChannelPromiseAggregator.doneAllocatingPromises();
        } catch (Throwable th2) {
            try {
                byteBuf.release();
                return simpleChannelPromiseAggregator;
            } finally {
                simpleChannelPromiseAggregator.setFailure(th2);
                simpleChannelPromiseAggregator.doneAllocatingPromises();
            }
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeGoAway(ChannelHandlerContext channelHandlerContext, int i6, long j6, ByteBuf byteBuf, ChannelPromise channelPromise) {
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        try {
            verifyStreamOrConnectionId(i6, "Last Stream ID");
            verifyErrorCode(j6);
            int readableBytes = byteBuf.readableBytes() + 8;
            ByteBuf buffer = channelHandlerContext.alloc().buffer(17);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, readableBytes, (byte) 7, new Http2Flags(), 0);
            buffer.writeInt(i6);
            buffer.writeInt((int) j6);
            channelHandlerContext.write(buffer, simpleChannelPromiseAggregator.newPromise());
            try {
                channelHandlerContext.write(byteBuf, simpleChannelPromiseAggregator.newPromise());
            } catch (Throwable th) {
                simpleChannelPromiseAggregator.setFailure(th);
            }
            return simpleChannelPromiseAggregator.doneAllocatingPromises();
        } catch (Throwable th2) {
            try {
                byteBuf.release();
                return simpleChannelPromiseAggregator;
            } finally {
                simpleChannelPromiseAggregator.setFailure(th2);
                simpleChannelPromiseAggregator.doneAllocatingPromises();
            }
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, short s5, boolean z5, int i8, boolean z6, ChannelPromise channelPromise) {
        return writeHeadersInternal(channelHandlerContext, i6, http2Headers, i8, z6, true, i7, s5, z5, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePing(ChannelHandlerContext channelHandlerContext, boolean z5, long j6, ChannelPromise channelPromise) {
        Http2Flags ack = z5 ? new Http2Flags().ack(true) : new Http2Flags();
        ByteBuf buffer = channelHandlerContext.alloc().buffer(17);
        Http2CodecUtil.writeFrameHeaderInternal(buffer, 8, (byte) 6, ack, 0);
        buffer.writeLong(j6);
        return channelHandlerContext.write(buffer, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePriority(ChannelHandlerContext channelHandlerContext, int i6, int i7, short s5, boolean z5, ChannelPromise channelPromise) {
        try {
            verifyStreamId(i6, STREAM_ID);
            verifyStreamId(i7, STREAM_DEPENDENCY);
            verifyWeight(s5);
            ByteBuf buffer = channelHandlerContext.alloc().buffer(14);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, 5, (byte) 2, new Http2Flags(), i6);
            if (z5) {
                i7 = (int) (i7 | IjkMediaMeta.AV_CH_WIDE_LEFT);
            }
            buffer.writeInt(i7);
            buffer.writeByte(s5 - 1);
            return channelHandlerContext.write(buffer, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i6, long j6, ChannelPromise channelPromise) {
        try {
            verifyStreamId(i6, STREAM_ID);
            verifyErrorCode(j6);
            ByteBuf buffer = channelHandlerContext.alloc().buffer(13);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, 4, (byte) 3, new Http2Flags(), i6);
            buffer.writeInt((int) j6);
            return channelHandlerContext.write(buffer, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettings(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings, ChannelPromise channelPromise) {
        try {
            ObjectUtil.checkNotNull(http2Settings, "settings");
            int size = http2Settings.size() * 6;
            ByteBuf buffer = channelHandlerContext.alloc().buffer((http2Settings.size() * 6) + 9);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, size, (byte) 4, new Http2Flags(), 0);
            for (CharObjectMap.PrimitiveEntry<Long> primitiveEntry : http2Settings.entries()) {
                buffer.writeChar(primitiveEntry.key());
                buffer.writeInt(primitiveEntry.value().intValue());
            }
            return channelHandlerContext.write(buffer, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeWindowUpdate(ChannelHandlerContext channelHandlerContext, int i6, int i7, ChannelPromise channelPromise) {
        try {
            verifyStreamOrConnectionId(i6, STREAM_ID);
            verifyWindowSizeIncrement(i7);
            ByteBuf buffer = channelHandlerContext.alloc().buffer(13);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, 4, (byte) 8, new Http2Flags(), i6);
            buffer.writeInt(i7);
            return channelHandlerContext.write(buffer, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    public DefaultHttp2FrameWriter(Http2HeadersEncoder.SensitivityDetector sensitivityDetector, boolean z5) {
        this(new DefaultHttp2HeadersEncoder(sensitivityDetector, z5));
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettingsAck(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        try {
            ByteBuf buffer = channelHandlerContext.alloc().buffer(9);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, 0, (byte) 4, new Http2Flags().ack(true), 0);
            return channelHandlerContext.write(buffer, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    public DefaultHttp2FrameWriter(Http2HeadersEncoder http2HeadersEncoder) {
        this.headersEncoder = http2HeadersEncoder;
        this.maxFrameSize = 16384;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameSizePolicy
    public int maxFrameSize() {
        return this.maxFrameSize;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public Http2FrameWriter.Configuration configuration() {
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter.Configuration
    public Http2FrameSizePolicy frameSizePolicy() {
        return this;
    }
}
