package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class SocksCommonUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final SocksRequest UNKNOWN_SOCKS_REQUEST = new UnknownSocksRequest();
    public static final SocksResponse UNKNOWN_SOCKS_RESPONSE = new UnknownSocksResponse();
    private static final char ipv6hextetSeparator = ':';

    public static String ipv6toStr(byte[] bArr) {
        StringBuilder sb = new StringBuilder(39);
        ipv6toStr(sb, bArr, 0, 8);
        return sb.toString();
    }

    private static void appendHextet(StringBuilder sb, byte[] bArr, int i6) {
        StringUtil.toHexString(sb, bArr, i6 << 1, 2);
    }

    private SocksCommonUtils() {
    }

    static String readUsAscii(ByteBuf byteBuf, int i6) {
        String byteBuf2 = byteBuf.toString(byteBuf.readerIndex(), i6, CharsetUtil.US_ASCII);
        byteBuf.skipBytes(i6);
        return byteBuf2;
    }

    private static void ipv6toStr(StringBuilder sb, byte[] bArr, int i6, int i7) {
        int i8 = i7 - 1;
        while (i6 < i8) {
            appendHextet(sb, bArr, i6);
            sb.append(ipv6hextetSeparator);
            i6++;
        }
        appendHextet(sb, bArr, i6);
    }
}
