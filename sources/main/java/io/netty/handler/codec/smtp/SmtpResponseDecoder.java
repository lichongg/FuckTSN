package io.netty.handler.codec.smtp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.util.CharsetUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class SmtpResponseDecoder extends LineBasedFrameDecoder {
    private List<CharSequence> details;

    private static int parseNumber(byte b6) {
        return Character.digit((char) b6, 10);
    }

    private static DecoderException newDecoderException(ByteBuf byteBuf, int i6, int i7) {
        return new DecoderException("Received invalid line: '" + byteBuf.toString(i6, i7, CharsetUtil.US_ASCII) + '\'');
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.LineBasedFrameDecoder
    public SmtpResponse decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        ByteBuf byteBuf2 = (ByteBuf) super.decode(channelHandlerContext, byteBuf);
        if (byteBuf2 == null) {
            return null;
        }
        try {
            int readableBytes = byteBuf2.readableBytes();
            int readerIndex = byteBuf2.readerIndex();
            if (readableBytes < 3) {
                throw newDecoderException(byteBuf, readerIndex, readableBytes);
            }
            int parseCode = parseCode(byteBuf2);
            byte readByte = byteBuf2.readByte();
            String byteBuf3 = byteBuf2.isReadable() ? byteBuf2.toString(CharsetUtil.US_ASCII) : null;
            List list = this.details;
            if (readByte == 32) {
                this.details = null;
                if (list == null) {
                    list = byteBuf3 == null ? Collections.EMPTY_LIST : Collections.singletonList(byteBuf3);
                } else if (byteBuf3 != null) {
                    list.add(byteBuf3);
                }
                DefaultSmtpResponse defaultSmtpResponse = new DefaultSmtpResponse(parseCode, (List<CharSequence>) list);
                byteBuf2.release();
                return defaultSmtpResponse;
            }
            if (readByte != 45) {
                throw newDecoderException(byteBuf, readerIndex, readableBytes);
            }
            if (byteBuf3 != null) {
                if (list == null) {
                    list = new ArrayList(4);
                    this.details = list;
                }
                list.add(byteBuf3);
            }
            byteBuf2.release();
            return null;
        } catch (Throwable th) {
            byteBuf2.release();
            throw th;
        }
    }

    public SmtpResponseDecoder(int i6) {
        super(i6);
    }

    private static int parseCode(ByteBuf byteBuf) {
        return (parseNumber(byteBuf.readByte()) * 100) + (parseNumber(byteBuf.readByte()) * 10) + parseNumber(byteBuf.readByte());
    }
}
