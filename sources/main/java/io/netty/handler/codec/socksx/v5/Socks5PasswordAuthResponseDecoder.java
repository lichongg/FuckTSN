package io.netty.handler.codec.socksx.v5;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Socks5PasswordAuthResponseDecoder extends ReplayingDecoder<State> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum State {
        INIT,
        SUCCESS,
        FAILURE
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.socksx.v5.Socks5PasswordAuthResponseDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5PasswordAuthResponseDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5PasswordAuthResponseDecoder$State = iArr;
            try {
                iArr[State.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5PasswordAuthResponseDecoder$State[State.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5PasswordAuthResponseDecoder$State[State.FAILURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public Socks5PasswordAuthResponseDecoder() {
        super(State.INIT);
    }

    private void fail(List<Object> list, Exception exc) {
        if (!(exc instanceof DecoderException)) {
            exc = new DecoderException(exc);
        }
        checkpoint(State.FAILURE);
        DefaultSocks5PasswordAuthResponse defaultSocks5PasswordAuthResponse = new DefaultSocks5PasswordAuthResponse(Socks5PasswordAuthStatus.FAILURE);
        defaultSocks5PasswordAuthResponse.setDecoderResult(DecoderResult.failure(exc));
        list.add(defaultSocks5PasswordAuthResponse);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        try {
            int i6 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socksx$v5$Socks5PasswordAuthResponseDecoder$State[state().ordinal()];
            if (i6 == 1) {
                byte readByte = byteBuf.readByte();
                if (readByte != 1) {
                    throw new DecoderException("unsupported subnegotiation version: " + ((int) readByte) + " (expected: 1)");
                }
                list.add(new DefaultSocks5PasswordAuthResponse(Socks5PasswordAuthStatus.valueOf(byteBuf.readByte())));
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
