package io.netty.handler.codec.http2;

import com.baidu.mobads.sdk.internal.bu;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.logging.LogLevel;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogLevel;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Http2FrameLogger extends ChannelHandlerAdapter {
    private static final int BUFFER_LENGTH_THRESHOLD = 64;
    private final InternalLogLevel level;
    private final InternalLogger logger;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Direction {
        INBOUND,
        OUTBOUND
    }

    public Http2FrameLogger(LogLevel logLevel) {
        this(logLevel.toInternalLevel(), InternalLoggerFactory.getInstance((Class<?>) Http2FrameLogger.class));
    }

    public void logHeaders(Direction direction, ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, boolean z5) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} HEADERS: streamId={} headers={} padding={} endStream={}", channelHandlerContext.channel(), direction.name(), Integer.valueOf(i6), http2Headers, Integer.valueOf(i7), Boolean.valueOf(z5));
        }
    }

    public Http2FrameLogger(LogLevel logLevel, String str) {
        this(logLevel.toInternalLevel(), InternalLoggerFactory.getInstance(str));
    }

    private String toString(ByteBuf byteBuf) {
        if (this.level == InternalLogLevel.TRACE || byteBuf.readableBytes() <= 64) {
            return ByteBufUtil.hexDump(byteBuf);
        }
        return ByteBufUtil.hexDump(byteBuf, byteBuf.readerIndex(), Math.min(byteBuf.readableBytes(), 64)) + "...";
    }

    public boolean isEnabled() {
        return this.logger.isEnabled(this.level);
    }

    public void logSettingsAck(Direction direction, ChannelHandlerContext channelHandlerContext) {
        this.logger.log(this.level, "{} {} SETTINGS: ack=true", channelHandlerContext.channel(), direction.name());
    }

    public Http2FrameLogger(LogLevel logLevel, Class<?> cls) {
        this(logLevel.toInternalLevel(), InternalLoggerFactory.getInstance(cls));
    }

    public void logData(Direction direction, ChannelHandlerContext channelHandlerContext, int i6, ByteBuf byteBuf, int i7, boolean z5) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} DATA: streamId={} padding={} endStream={} length={} bytes={}", channelHandlerContext.channel(), direction.name(), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z5), Integer.valueOf(byteBuf.readableBytes()), toString(byteBuf));
        }
    }

    public void logGoAway(Direction direction, ChannelHandlerContext channelHandlerContext, int i6, long j6, ByteBuf byteBuf) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} GO_AWAY: lastStreamId={} errorCode={} length={} bytes={}", channelHandlerContext.channel(), direction.name(), Integer.valueOf(i6), Long.valueOf(j6), Integer.valueOf(byteBuf.readableBytes()), toString(byteBuf));
        }
    }

    public void logPing(Direction direction, ChannelHandlerContext channelHandlerContext, long j6) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} PING: ack=false bytes={}", channelHandlerContext.channel(), direction.name(), Long.valueOf(j6));
        }
    }

    public void logPingAck(Direction direction, ChannelHandlerContext channelHandlerContext, long j6) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} PING: ack=true bytes={}", channelHandlerContext.channel(), direction.name(), Long.valueOf(j6));
        }
    }

    public void logPriority(Direction direction, ChannelHandlerContext channelHandlerContext, int i6, int i7, short s5, boolean z5) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} PRIORITY: streamId={} streamDependency={} weight={} exclusive={}", channelHandlerContext.channel(), direction.name(), Integer.valueOf(i6), Integer.valueOf(i7), Short.valueOf(s5), Boolean.valueOf(z5));
        }
    }

    public void logPushPromise(Direction direction, ChannelHandlerContext channelHandlerContext, int i6, int i7, Http2Headers http2Headers, int i8) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} PUSH_PROMISE: streamId={} promisedStreamId={} headers={} padding={}", channelHandlerContext.channel(), direction.name(), Integer.valueOf(i6), Integer.valueOf(i7), http2Headers, Integer.valueOf(i8));
        }
    }

    public void logRstStream(Direction direction, ChannelHandlerContext channelHandlerContext, int i6, long j6) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} RST_STREAM: streamId={} errorCode={}", channelHandlerContext.channel(), direction.name(), Integer.valueOf(i6), Long.valueOf(j6));
        }
    }

    public void logSettings(Direction direction, ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} SETTINGS: ack=false settings={}", channelHandlerContext.channel(), direction.name(), http2Settings);
        }
    }

    public void logUnknownFrame(Direction direction, ChannelHandlerContext channelHandlerContext, byte b6, int i6, Http2Flags http2Flags, ByteBuf byteBuf) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} UNKNOWN: frameType={} streamId={} flags={} length={} bytes={}", channelHandlerContext.channel(), direction.name(), Integer.valueOf(b6 & 255), Integer.valueOf(i6), Short.valueOf(http2Flags.value()), Integer.valueOf(byteBuf.readableBytes()), toString(byteBuf));
        }
    }

    public void logWindowsUpdate(Direction direction, ChannelHandlerContext channelHandlerContext, int i6, int i7) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} WINDOW_UPDATE: streamId={} windowSizeIncrement={}", channelHandlerContext.channel(), direction.name(), Integer.valueOf(i6), Integer.valueOf(i7));
        }
    }

    private Http2FrameLogger(InternalLogLevel internalLogLevel, InternalLogger internalLogger) {
        this.level = (InternalLogLevel) ObjectUtil.checkNotNull(internalLogLevel, "level");
        this.logger = (InternalLogger) ObjectUtil.checkNotNull(internalLogger, bu.f10800a);
    }

    public void logHeaders(Direction direction, ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, short s5, boolean z5, int i8, boolean z6) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} HEADERS: streamId={} headers={} streamDependency={} weight={} exclusive={} padding={} endStream={}", channelHandlerContext.channel(), direction.name(), Integer.valueOf(i6), http2Headers, Integer.valueOf(i7), Short.valueOf(s5), Boolean.valueOf(z5), Integer.valueOf(i8), Boolean.valueOf(z6));
        }
    }
}
