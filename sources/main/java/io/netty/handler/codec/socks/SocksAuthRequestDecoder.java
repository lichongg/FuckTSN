package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SocksAuthRequestDecoder extends ReplayingDecoder<State> {
    private String username;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum State {
        CHECK_PROTOCOL_VERSION,
        READ_USERNAME,
        READ_PASSWORD
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.socks.SocksAuthRequestDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksAuthRequestDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksAuthRequestDecoder$State = iArr;
            try {
                iArr[State.CHECK_PROTOCOL_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAuthRequestDecoder$State[State.READ_USERNAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAuthRequestDecoder$State[State.READ_PASSWORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public SocksAuthRequestDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i6 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAuthRequestDecoder$State[state().ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    throw new Error();
                }
                list.add(new SocksAuthRequest(this.username, SocksCommonUtils.readUsAscii(byteBuf, byteBuf.readByte())));
                channelHandlerContext.pipeline().remove(this);
            }
        } else {
            if (byteBuf.readByte() != SocksSubnegotiationVersion.AUTH_PASSWORD.byteValue()) {
                list.add(SocksCommonUtils.UNKNOWN_SOCKS_REQUEST);
                channelHandlerContext.pipeline().remove(this);
            }
            checkpoint(State.READ_USERNAME);
        }
        this.username = SocksCommonUtils.readUsAscii(byteBuf, byteBuf.readByte());
        checkpoint(State.READ_PASSWORD);
        list.add(new SocksAuthRequest(this.username, SocksCommonUtils.readUsAscii(byteBuf, byteBuf.readByte())));
        channelHandlerContext.pipeline().remove(this);
    }
}
