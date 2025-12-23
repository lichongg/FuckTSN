package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.CombinedChannelDuplexHandler;
import io.netty.handler.codec.PrematureChannelClosureException;
import io.netty.handler.codec.memcache.LastMemcacheContent;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class BinaryMemcacheClientCodec extends CombinedChannelDuplexHandler<BinaryMemcacheResponseDecoder, BinaryMemcacheRequestEncoder> {
    private final boolean failOnMissingResponse;
    private final AtomicLong requestResponseCounter;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.memcache.binary.BinaryMemcacheClientCodec$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class Decoder extends BinaryMemcacheResponseDecoder {
        Decoder(int i6) {
            super(i6);
        }

        @Override // io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder, io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
            super.channelInactive(channelHandlerContext);
            if (BinaryMemcacheClientCodec.this.failOnMissingResponse) {
                long j6 = BinaryMemcacheClientCodec.this.requestResponseCounter.get();
                if (j6 > 0) {
                    channelHandlerContext.fireExceptionCaught((Throwable) new PrematureChannelClosureException("channel gone inactive with " + j6 + " missing response(s)"));
                }
            }
        }

        @Override // io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder, io.netty.handler.codec.ByteToMessageDecoder
        protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            super.decode(channelHandlerContext, byteBuf, list);
            if (BinaryMemcacheClientCodec.this.failOnMissingResponse) {
                int size = list.size();
                for (int size2 = list.size(); size2 < size; size2++) {
                    if (list.get(size2) instanceof LastMemcacheContent) {
                        BinaryMemcacheClientCodec.this.requestResponseCounter.decrementAndGet();
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class Encoder extends BinaryMemcacheRequestEncoder {
        private Encoder() {
        }

        /* synthetic */ Encoder(BinaryMemcacheClientCodec binaryMemcacheClientCodec, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // io.netty.handler.codec.memcache.AbstractMemcacheObjectEncoder, io.netty.handler.codec.MessageToMessageEncoder
        protected void encode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
            super.encode(channelHandlerContext, obj, list);
            if (BinaryMemcacheClientCodec.this.failOnMissingResponse && (obj instanceof LastMemcacheContent)) {
                BinaryMemcacheClientCodec.this.requestResponseCounter.incrementAndGet();
            }
        }
    }

    public BinaryMemcacheClientCodec() {
        this(8192);
    }

    public BinaryMemcacheClientCodec(int i6) {
        this(i6, false);
    }

    public BinaryMemcacheClientCodec(int i6, boolean z5) {
        this.requestResponseCounter = new AtomicLong();
        this.failOnMissingResponse = z5;
        init(new Decoder(i6), new Encoder(this, null));
    }
}
