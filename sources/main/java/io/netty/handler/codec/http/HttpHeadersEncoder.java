package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class HttpHeadersEncoder {
    private static final int COLON_AND_SPACE_SHORT = 14880;

    private static void writeAscii(ByteBuf byteBuf, int i6, CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            ByteBufUtil.copy((AsciiString) charSequence, 0, byteBuf, i6, charSequence.length());
        } else {
            byteBuf.setCharSequence(i6, charSequence, CharsetUtil.US_ASCII);
        }
    }

    private HttpHeadersEncoder() {
    }

    static void encoderHeader(CharSequence charSequence, CharSequence charSequence2, ByteBuf byteBuf) {
        int length = charSequence.length();
        int length2 = charSequence2.length();
        byteBuf.ensureWritable(length + length2 + 4);
        int writerIndex = byteBuf.writerIndex();
        writeAscii(byteBuf, writerIndex, charSequence);
        int i6 = writerIndex + length;
        ByteBufUtil.setShortBE(byteBuf, i6, COLON_AND_SPACE_SHORT);
        int i7 = i6 + 2;
        writeAscii(byteBuf, i7, charSequence2);
        int i8 = i7 + length2;
        ByteBufUtil.setShortBE(byteBuf, i8, 3338);
        byteBuf.writerIndex(i8 + 2);
    }
}
