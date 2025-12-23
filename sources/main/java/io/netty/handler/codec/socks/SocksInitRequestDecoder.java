package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SocksInitRequestDecoder extends ReplayingDecoder<State> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum State {
        CHECK_PROTOCOL_VERSION,
        READ_AUTH_SCHEMES
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.socks.SocksInitRequestDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksInitRequestDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksInitRequestDecoder$State = iArr;
            try {
                iArr[State.CHECK_PROTOCOL_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksInitRequestDecoder$State[State.READ_AUTH_SCHEMES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public SocksInitRequestDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        List list2;
        int i6 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksInitRequestDecoder$State[state().ordinal()];
        if (i6 == 1) {
            if (byteBuf.readByte() != SocksProtocolVersion.SOCKS5.byteValue()) {
                list.add(SocksCommonUtils.UNKNOWN_SOCKS_REQUEST);
                channelHandlerContext.pipeline().remove(this);
            }
            checkpoint(State.READ_AUTH_SCHEMES);
        } else if (i6 != 2) {
            throw new Error();
        }
        byte readByte = byteBuf.readByte();
        if (readByte > 0) {
            list2 = new ArrayList(readByte);
            for (int i7 = 0; i7 < readByte; i7++) {
                list2.add(SocksAuthScheme.valueOf(byteBuf.readByte()));
            }
        } else {
            list2 = Collections.EMPTY_LIST;
        }
        list.add(new SocksInitRequest(list2));
        channelHandlerContext.pipeline().remove(this);
    }
}
