package io.netty.handler.codec.socksx.v5;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.socksx.SocksVersion;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Socks5InitialRequestDecoder extends ReplayingDecoder<State> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum State {
        INIT,
        SUCCESS,
        FAILURE
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.socksx.v5.Socks5InitialRequestDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5InitialRequestDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5InitialRequestDecoder$State = iArr;
            try {
                iArr[State.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5InitialRequestDecoder$State[State.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5InitialRequestDecoder$State[State.FAILURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public Socks5InitialRequestDecoder() {
        super(State.INIT);
    }

    private void fail(List<Object> list, Exception exc) {
        if (!(exc instanceof DecoderException)) {
            exc = new DecoderException(exc);
        }
        checkpoint(State.FAILURE);
        DefaultSocks5InitialRequest defaultSocks5InitialRequest = new DefaultSocks5InitialRequest(Socks5AuthMethod.NO_AUTH);
        defaultSocks5InitialRequest.setDecoderResult(DecoderResult.failure(exc));
        list.add(defaultSocks5InitialRequest);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        try {
            int i6 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socksx$v5$Socks5InitialRequestDecoder$State[state().ordinal()];
            if (i6 == 1) {
                byte readByte = byteBuf.readByte();
                SocksVersion socksVersion = SocksVersion.SOCKS5;
                if (readByte != socksVersion.byteValue()) {
                    throw new DecoderException("unsupported version: " + ((int) readByte) + " (expected: " + ((int) socksVersion.byteValue()) + ')');
                }
                int readUnsignedByte = byteBuf.readUnsignedByte();
                if (actualReadableBytes() < readUnsignedByte) {
                    return;
                }
                Socks5AuthMethod[] socks5AuthMethodArr = new Socks5AuthMethod[readUnsignedByte];
                for (int i7 = 0; i7 < readUnsignedByte; i7++) {
                    socks5AuthMethodArr[i7] = Socks5AuthMethod.valueOf(byteBuf.readByte());
                }
                list.add(new DefaultSocks5InitialRequest(socks5AuthMethodArr));
                checkpoint(State.SUCCESS);
            } else if (i6 != 2) {
                if (i6 != 3) {
                    return;
                }
                byteBuf.skipBytes(actualReadableBytes());
                return;
            }
            int actualReadableBytes = actualReadableBytes();
            if (actualReadableBytes > 0) {
                list.add(byteBuf.readRetainedSlice(actualReadableBytes));
            }
        } catch (Exception e6) {
            fail(list, e6);
        }
    }
}
