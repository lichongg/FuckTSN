package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SocksInitResponseDecoder extends ReplayingDecoder<State> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum State {
        CHECK_PROTOCOL_VERSION,
        READ_PREFERRED_AUTH_TYPE
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.socks.SocksInitResponseDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksInitResponseDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksInitResponseDecoder$State = iArr;
            try {
                iArr[State.CHECK_PROTOCOL_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksInitResponseDecoder$State[State.READ_PREFERRED_AUTH_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public SocksInitResponseDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i6 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksInitResponseDecoder$State[state().ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                throw new Error();
            }
        } else {
            if (byteBuf.readByte() != SocksProtocolVersion.SOCKS5.byteValue()) {
                list.add(SocksCommonUtils.UNKNOWN_SOCKS_RESPONSE);
                channelHandlerContext.pipeline().remove(this);
            }
            checkpoint(State.READ_PREFERRED_AUTH_TYPE);
        }
        list.add(new SocksInitResponse(SocksAuthScheme.valueOf(byteBuf.readByte())));
        channelHandlerContext.pipeline().remove(this);
    }
}
