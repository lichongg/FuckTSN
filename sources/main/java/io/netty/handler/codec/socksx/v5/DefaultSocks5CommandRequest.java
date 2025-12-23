package io.netty.handler.codec.socksx.v5;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.NetUtil;
import io.netty.util.internal.StringUtil;
import java.net.IDN;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DefaultSocks5CommandRequest extends AbstractSocks5Message implements Socks5CommandRequest {
    private final String dstAddr;
    private final Socks5AddressType dstAddrType;
    private final int dstPort;
    private final Socks5CommandType type;

    @Override // io.netty.handler.codec.socksx.v5.Socks5CommandRequest
    public String dstAddr() {
        return this.dstAddr;
    }

    @Override // io.netty.handler.codec.socksx.v5.Socks5CommandRequest
    public Socks5AddressType dstAddrType() {
        return this.dstAddrType;
    }

    @Override // io.netty.handler.codec.socksx.v5.Socks5CommandRequest
    public int dstPort() {
        return this.dstPort;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (decoderResult.isSuccess()) {
            sb.append("(type: ");
        } else {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", type: ");
        }
        sb.append(type());
        sb.append(", dstAddrType: ");
        sb.append(dstAddrType());
        sb.append(", dstAddr: ");
        sb.append(dstAddr());
        sb.append(", dstPort: ");
        sb.append(dstPort());
        sb.append(')');
        return sb.toString();
    }

    @Override // io.netty.handler.codec.socksx.v5.Socks5CommandRequest
    public Socks5CommandType type() {
        return this.type;
    }

    public DefaultSocks5CommandRequest(Socks5CommandType socks5CommandType, Socks5AddressType socks5AddressType, String str, int i6) {
        if (socks5CommandType != null) {
            if (socks5AddressType != null) {
                if (str != null) {
                    if (socks5AddressType == Socks5AddressType.IPv4) {
                        if (!NetUtil.isValidIpV4Address(str)) {
                            throw new IllegalArgumentException("dstAddr: " + str + " (expected: a valid IPv4 address)");
                        }
                    } else if (socks5AddressType == Socks5AddressType.DOMAIN) {
                        str = IDN.toASCII(str);
                        if (str.length() > 255) {
                            throw new IllegalArgumentException("dstAddr: " + str + " (expected: less than 256 chars)");
                        }
                    } else if (socks5AddressType == Socks5AddressType.IPv6 && !NetUtil.isValidIpV6Address(str)) {
                        throw new IllegalArgumentException("dstAddr: " + str + " (expected: a valid IPv6 address");
                    }
                    if (i6 >= 0 && i6 <= 65535) {
                        this.type = socks5CommandType;
                        this.dstAddrType = socks5AddressType;
                        this.dstAddr = str;
                        this.dstPort = i6;
                        return;
                    }
                    throw new IllegalArgumentException("dstPort: " + i6 + " (expected: 0~65535)");
                }
                throw new NullPointerException("dstAddr");
            }
            throw new NullPointerException("dstAddrType");
        }
        throw new NullPointerException("type");
    }
}
