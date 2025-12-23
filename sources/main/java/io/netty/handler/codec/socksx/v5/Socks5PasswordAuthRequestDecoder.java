package io.netty.handler.codec.socksx.v5;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.CharsetUtil;
import java.nio.charset.Charset;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Socks5PasswordAuthRequestDecoder extends ReplayingDecoder<State> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum State {
        INIT,
        SUCCESS,
        FAILURE
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.socksx.v5.Socks5PasswordAuthRequestDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5PasswordAuthRequestDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5PasswordAuthRequestDecoder$State = iArr;
            try {
                iArr[State.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5PasswordAuthRequestDecoder$State[State.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5PasswordAuthRequestDecoder$State[State.FAILURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public Socks5PasswordAuthRequestDecoder() {
        super(State.INIT);
    }

    private void fail(List<Object> list, Exception exc) {
        if (!(exc instanceof DecoderException)) {
            exc = new DecoderException(exc);
        }
        checkpoint(State.FAILURE);
        DefaultSocks5PasswordAuthRequest defaultSocks5PasswordAuthRequest = new DefaultSocks5PasswordAuthRequest("", "");
        defaultSocks5PasswordAuthRequest.setDecoderResult(DecoderResult.failure(exc));
        list.add(defaultSocks5PasswordAuthRequest);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        try {
            int i6 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socksx$v5$Socks5PasswordAuthRequestDecoder$State[state().ordinal()];
            if (i6 == 1) {
                int readerIndex = byteBuf.readerIndex();
                byte b6 = byteBuf.getByte(readerIndex);
                if (b6 != 1) {
                    throw new DecoderException("unsupported subnegotiation version: " + ((int) b6) + " (expected: 1)");
                }
                short unsignedByte = byteBuf.getUnsignedByte(readerIndex + 1);
                int i7 = readerIndex + 2;
                short unsignedByte2 = byteBuf.getUnsignedByte(i7 + unsignedByte);
                byteBuf.skipBytes(unsignedByte + unsignedByte2 + 3);
                Charset charset = CharsetUtil.US_ASCII;
                list.add(new DefaultSocks5PasswordAuthRequest(byteBuf.toString(i7, unsignedByte, charset), byteBuf.toString(readerIndex + 3 + unsignedByte, unsignedByte2, charset)));
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
