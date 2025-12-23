package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.memcache.AbstractMemcacheObjectDecoder;
import io.netty.handler.codec.memcache.DefaultLastMemcacheContent;
import io.netty.handler.codec.memcache.MemcacheContent;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractBinaryMemcacheDecoder<M extends BinaryMemcacheMessage> extends AbstractMemcacheObjectDecoder {
    public static final int DEFAULT_MAX_CHUNK_SIZE = 8192;
    private int alreadyReadChunkSize;
    private final int chunkSize;
    private M currentMessage;
    private State state;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum State {
        READ_HEADER,
        READ_EXTRAS,
        READ_KEY,
        READ_CONTENT,
        BAD_MESSAGE
    }

    protected AbstractBinaryMemcacheDecoder() {
        this(8192);
    }

    protected abstract M buildInvalidMessage();

    protected abstract M decodeHeader(ByteBuf byteBuf);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State = iArr;
            try {
                iArr[State.READ_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State[State.READ_EXTRAS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State[State.READ_KEY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State[State.READ_CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State[State.BAD_MESSAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    protected AbstractBinaryMemcacheDecoder(int i6) {
        this.state = State.READ_HEADER;
        ObjectUtil.checkPositiveOrZero(i6, "chunkSize");
        this.chunkSize = i6;
    }

    private MemcacheContent invalidChunk(Exception exc) {
        this.state = State.BAD_MESSAGE;
        DefaultLastMemcacheContent defaultLastMemcacheContent = new DefaultLastMemcacheContent(Unpooled.EMPTY_BUFFER);
        defaultLastMemcacheContent.setDecoderResult(DecoderResult.failure(exc));
        return defaultLastMemcacheContent;
    }

    private M invalidMessage(Exception exc) {
        this.state = State.BAD_MESSAGE;
        M buildInvalidMessage = buildInvalidMessage();
        buildInvalidMessage.setDecoderResult(DecoderResult.failure(exc));
        return buildInvalidMessage;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e4 A[Catch: Exception -> 0x00d5, TryCatch #2 {Exception -> 0x00d5, blocks: (B:17:0x009b, B:22:0x00b8, B:25:0x00bd, B:28:0x00c4, B:30:0x00cf, B:31:0x00dc, B:33:0x00e9, B:37:0x00d7, B:38:0x00e4), top: B:16:0x009b }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007a A[Catch: Exception -> 0x008b, TryCatch #1 {Exception -> 0x008b, blocks: (B:44:0x0072, B:46:0x007a, B:50:0x0081, B:51:0x008e), top: B:43:0x0072 }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(io.netty.channel.ChannelHandlerContext r3, io.netty.buffer.ByteBuf r4, java.util.List<java.lang.Object> r5) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    protected void resetDecoder() {
        M m6 = this.currentMessage;
        if (m6 != null) {
            m6.release();
            this.currentMessage = null;
        }
        this.alreadyReadChunkSize = 0;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.channelInactive(channelHandlerContext);
        resetDecoder();
    }
}
