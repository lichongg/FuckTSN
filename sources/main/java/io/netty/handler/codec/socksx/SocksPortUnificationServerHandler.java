package io.netty.handler.codec.socksx;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.socksx.v4.Socks4ServerDecoder;
import io.netty.handler.codec.socksx.v4.Socks4ServerEncoder;
import io.netty.handler.codec.socksx.v5.Socks5InitialRequestDecoder;
import io.netty.handler.codec.socksx.v5.Socks5ServerEncoder;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SocksPortUnificationServerHandler extends ByteToMessageDecoder {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SocksPortUnificationServerHandler.class);
    private final Socks5ServerEncoder socks5encoder;

    public SocksPortUnificationServerHandler() {
        this(Socks5ServerEncoder.DEFAULT);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.socksx.SocksPortUnificationServerHandler$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socksx$SocksVersion;

        static {
            int[] iArr = new int[SocksVersion.values().length];
            $SwitchMap$io$netty$handler$codec$socksx$SocksVersion = iArr;
            try {
                iArr[SocksVersion.SOCKS4a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socksx$SocksVersion[SocksVersion.SOCKS5.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public SocksPortUnificationServerHandler(Socks5ServerEncoder socks5ServerEncoder) {
        if (socks5ServerEncoder == null) {
            throw new NullPointerException("socks5encoder");
        }
        this.socks5encoder = socks5ServerEncoder;
    }

    private static void logKnownVersion(ChannelHandlerContext channelHandlerContext, SocksVersion socksVersion) {
        logger.debug("{} Protocol version: {}({})", channelHandlerContext.channel(), socksVersion);
    }

    private static void logUnknownVersion(ChannelHandlerContext channelHandlerContext, byte b6) {
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("{} Unknown protocol version: {}", channelHandlerContext.channel(), Integer.valueOf(b6 & 255));
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int readerIndex = byteBuf.readerIndex();
        if (byteBuf.writerIndex() == readerIndex) {
            return;
        }
        ChannelPipeline pipeline = channelHandlerContext.pipeline();
        byte b6 = byteBuf.getByte(readerIndex);
        SocksVersion valueOf = SocksVersion.valueOf(b6);
        int i6 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socksx$SocksVersion[valueOf.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                logUnknownVersion(channelHandlerContext, b6);
                byteBuf.skipBytes(byteBuf.readableBytes());
                channelHandlerContext.close();
                return;
            } else {
                logKnownVersion(channelHandlerContext, valueOf);
                pipeline.addAfter(channelHandlerContext.name(), null, this.socks5encoder);
                pipeline.addAfter(channelHandlerContext.name(), null, new Socks5InitialRequestDecoder());
            }
        } else {
            logKnownVersion(channelHandlerContext, valueOf);
            pipeline.addAfter(channelHandlerContext.name(), null, Socks4ServerEncoder.INSTANCE);
            pipeline.addAfter(channelHandlerContext.name(), null, new Socks4ServerDecoder());
        }
        pipeline.remove(this);
    }
}
