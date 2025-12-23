package io.netty.handler.codec.http2;

import com.google.common.net.HttpHeaders;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.handler.codec.http2.StreamByteDistributor;
import io.netty.handler.ssl.ApplicationProtocolNames;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.EventExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class Http2CodecUtil {
    public static final int CONNECTION_STREAM_ID = 0;
    public static final int CONTINUATION_FRAME_HEADER_LENGTH = 10;
    public static final int DATA_FRAME_HEADER_LENGTH = 10;
    public static final long DEFAULT_HEADER_LIST_SIZE = 8192;
    public static final int DEFAULT_HEADER_TABLE_SIZE = 4096;
    public static final int DEFAULT_MAX_FRAME_SIZE = 16384;
    static final int DEFAULT_MAX_RESERVED_STREAMS = 100;
    static final int DEFAULT_MIN_ALLOCATION_CHUNK = 1024;
    public static final short DEFAULT_PRIORITY_WEIGHT = 16;
    public static final int DEFAULT_WINDOW_SIZE = 65535;
    public static final int FRAME_HEADER_LENGTH = 9;
    public static final int GO_AWAY_FRAME_HEADER_LENGTH = 17;
    public static final int HEADERS_FRAME_HEADER_LENGTH = 15;
    public static final int HTTP_UPGRADE_STREAM_ID = 1;
    public static final int INT_FIELD_LENGTH = 4;
    public static final long MAX_CONCURRENT_STREAMS = 4294967295L;
    public static final int MAX_FRAME_SIZE_LOWER_BOUND = 16384;
    public static final int MAX_FRAME_SIZE_UPPER_BOUND = 16777215;
    public static final long MAX_HEADER_LIST_SIZE = 4294967295L;
    public static final long MAX_HEADER_TABLE_SIZE = 4294967295L;
    public static final int MAX_INITIAL_WINDOW_SIZE = Integer.MAX_VALUE;
    public static final int MAX_PADDING = 256;
    private static final int MAX_PADDING_LENGTH_LENGTH = 1;
    public static final short MAX_UNSIGNED_BYTE = 255;
    public static final long MAX_UNSIGNED_INT = 4294967295L;
    public static final short MAX_WEIGHT = 256;
    public static final long MIN_CONCURRENT_STREAMS = 0;
    public static final long MIN_HEADER_LIST_SIZE = 0;
    public static final long MIN_HEADER_TABLE_SIZE = 0;
    public static final int MIN_INITIAL_WINDOW_SIZE = 0;
    public static final short MIN_WEIGHT = 1;
    public static final int NUM_STANDARD_SETTINGS = 6;
    public static final int PING_FRAME_PAYLOAD_LENGTH = 8;
    public static final int PRIORITY_ENTRY_LENGTH = 5;
    public static final int PRIORITY_FRAME_LENGTH = 14;
    public static final int PUSH_PROMISE_FRAME_HEADER_LENGTH = 14;
    public static final int RST_STREAM_FRAME_LENGTH = 13;
    public static final char SETTINGS_ENABLE_PUSH = 2;
    public static final char SETTINGS_HEADER_TABLE_SIZE = 1;
    public static final char SETTINGS_INITIAL_WINDOW_SIZE = 4;
    public static final char SETTINGS_MAX_CONCURRENT_STREAMS = 3;
    public static final char SETTINGS_MAX_FRAME_SIZE = 5;
    public static final char SETTINGS_MAX_HEADER_LIST_SIZE = 6;
    public static final int SETTING_ENTRY_LENGTH = 6;
    public static final int SMALLEST_MAX_CONCURRENT_STREAMS = 100;
    public static final int WINDOW_UPDATE_FRAME_LENGTH = 13;
    public static final CharSequence HTTP_UPGRADE_SETTINGS_HEADER = AsciiString.cached(HttpHeaders.HTTP2_SETTINGS);
    public static final CharSequence HTTP_UPGRADE_PROTOCOL_NAME = "h2c";
    public static final CharSequence TLS_UPGRADE_PROTOCOL_NAME = ApplicationProtocolNames.HTTP_2;
    private static final ByteBuf CONNECTION_PREFACE = Unpooled.unreleasableBuffer(Unpooled.directBuffer(24).writeBytes("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n".getBytes(CharsetUtil.UTF_8))).asReadOnly();
    public static final long DEFAULT_GRACEFUL_SHUTDOWN_TIMEOUT_MILLIS = TimeUnit.MILLISECONDS.convert(30, TimeUnit.SECONDS);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SimpleChannelPromiseAggregator extends DefaultChannelPromise {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean doneAllocating;
        private int doneCount;
        private int expectedCount;
        private Throwable lastFailure;
        private final ChannelPromise promise;

        private boolean allPromisesDone() {
            return this.doneCount == this.expectedCount && this.doneAllocating;
        }

        private boolean awaitingPromises() {
            return this.doneCount < this.expectedCount;
        }

        private ChannelPromise setPromise() {
            Throwable th = this.lastFailure;
            if (th == null) {
                this.promise.setSuccess();
                return super.setSuccess((Void) null);
            }
            this.promise.setFailure(th);
            return super.setFailure(this.lastFailure);
        }

        private boolean tryPromise() {
            Throwable th = this.lastFailure;
            if (th == null) {
                this.promise.trySuccess();
                return super.trySuccess((SimpleChannelPromiseAggregator) null);
            }
            this.promise.tryFailure(th);
            return super.tryFailure(this.lastFailure);
        }

        public ChannelPromise doneAllocatingPromises() {
            if (!this.doneAllocating) {
                this.doneAllocating = true;
                int i6 = this.doneCount;
                int i7 = this.expectedCount;
                if (i6 == i7 || i7 == 0) {
                    return setPromise();
                }
            }
            return this;
        }

        public ChannelPromise newPromise() {
            this.expectedCount++;
            return this;
        }

        @Override // io.netty.channel.DefaultChannelPromise, io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
        public ChannelPromise setFailure(Throwable th) {
            if (allowFailure()) {
                this.doneCount++;
                this.lastFailure = th;
                if (allPromisesDone()) {
                    return setPromise();
                }
            }
            return this;
        }

        @Override // io.netty.channel.DefaultChannelPromise, io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.ProgressivePromise
        public ChannelPromise setSuccess(Void r12) {
            if (awaitingPromises()) {
                this.doneCount++;
                if (allPromisesDone()) {
                    setPromise();
                }
            }
            return this;
        }

        @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
        public boolean trySuccess(Void r22) {
            if (!awaitingPromises()) {
                return false;
            }
            this.doneCount++;
            if (allPromisesDone()) {
                return tryPromise();
            }
            return true;
        }

        SimpleChannelPromiseAggregator(ChannelPromise channelPromise, Channel channel, EventExecutor eventExecutor) {
            super(channel, eventExecutor);
            this.promise = channelPromise;
        }

        private boolean allowFailure() {
            if (!awaitingPromises() && this.expectedCount != 0) {
                return false;
            }
            return true;
        }

        @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
        public boolean tryFailure(Throwable th) {
            if (allowFailure()) {
                this.doneCount++;
                this.lastFailure = th;
                if (!allPromisesDone()) {
                    return true;
                }
                return tryPromise();
            }
            return false;
        }
    }

    public static long calculateMaxHeaderListSizeGoAway(long j6) {
        return j6 + (j6 >>> 2);
    }

    public static void headerListSizeExceeded(int i6, long j6, boolean z5) throws Http2Exception {
        throw Http2Exception.headerListSizeError(i6, Http2Error.PROTOCOL_ERROR, z5, "Header size exceeded max allowed size (%d)", Long.valueOf(j6));
    }

    public static boolean isStreamIdValid(int i6) {
        return i6 >= 0;
    }

    public static ByteBuf connectionPrefaceBuf() {
        return CONNECTION_PREFACE.retainedDuplicate();
    }

    public static Http2Exception getEmbeddedHttp2Exception(Throwable th) {
        while (th != null) {
            if (th instanceof Http2Exception) {
                return (Http2Exception) th;
            }
            th = th.getCause();
        }
        return null;
    }

    public static boolean isMaxFrameSizeValid(int i6) {
        return i6 >= 16384 && i6 <= 16777215;
    }

    public static boolean isOutboundStream(boolean z5, int i6) {
        return i6 > 0 && z5 == ((i6 & 1) == 0);
    }

    static boolean isStreamIdValid(int i6, boolean z5) {
        if (isStreamIdValid(i6)) {
            if (z5 == ((i6 & 1) == 0)) {
                return true;
            }
        }
        return false;
    }

    public static ByteBuf toByteBuf(ChannelHandlerContext channelHandlerContext, Throwable th) {
        return (th == null || th.getMessage() == null) ? Unpooled.EMPTY_BUFFER : ByteBufUtil.writeUtf8(channelHandlerContext.alloc(), th.getMessage());
    }

    public static void verifyPadding(int i6) {
        if (i6 < 0 || i6 > 256) {
            throw new IllegalArgumentException(String.format("Invalid padding '%d'. Padding must be between 0 and %d (inclusive).", Integer.valueOf(i6), 256));
        }
    }

    public static void writeFrameHeader(ByteBuf byteBuf, int i6, byte b6, Http2Flags http2Flags, int i7) {
        byteBuf.ensureWritable(i6 + 9);
        writeFrameHeaderInternal(byteBuf, i6, b6, http2Flags, i7);
    }

    private Http2CodecUtil() {
    }

    public static int readUnsignedInt(ByteBuf byteBuf) {
        return byteBuf.readInt() & Integer.MAX_VALUE;
    }

    public static int streamableBytes(StreamByteDistributor.StreamState streamState) {
        return Math.max(0, (int) Math.min(streamState.pendingBytes(), streamState.windowSize()));
    }

    static void writeFrameHeaderInternal(ByteBuf byteBuf, int i6, byte b6, Http2Flags http2Flags, int i7) {
        byteBuf.writeMedium(i6);
        byteBuf.writeByte(b6);
        byteBuf.writeByte(http2Flags.value());
        byteBuf.writeInt(i7);
    }

    public static void headerListSizeExceeded(long j6) throws Http2Exception {
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header size exceeded max allowed size (%d)", Long.valueOf(j6));
    }
}
