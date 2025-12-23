package io.netty.resolver.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.handler.codec.dns.DnsRawRecord;
import io.netty.handler.codec.dns.DnsRecord;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class DnsAddressDecoder {
    private static final int INADDRSZ4 = 4;
    private static final int INADDRSZ6 = 16;

    static InetAddress decodeAddress(DnsRecord dnsRecord, String str, boolean z5) {
        if (!(dnsRecord instanceof DnsRawRecord)) {
            return null;
        }
        ByteBuf content = ((ByteBufHolder) dnsRecord).content();
        int readableBytes = content.readableBytes();
        if (readableBytes != 4 && readableBytes != 16) {
            return null;
        }
        byte[] bArr = new byte[readableBytes];
        content.getBytes(content.readerIndex(), bArr);
        if (z5) {
            try {
                str = IDN.toUnicode(str);
            } catch (UnknownHostException e6) {
                throw new Error(e6);
            }
        }
        return InetAddress.getByAddress(str, bArr);
    }

    private DnsAddressDecoder() {
    }
}
