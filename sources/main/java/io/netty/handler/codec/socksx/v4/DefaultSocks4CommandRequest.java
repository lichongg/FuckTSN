package io.netty.handler.codec.socksx.v4;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.StringUtil;
import java.net.IDN;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultSocks4CommandRequest extends AbstractSocks4Message implements Socks4CommandRequest {
    private final String dstAddr;
    private final int dstPort;
    private final Socks4CommandType type;
    private final String userId;

    public DefaultSocks4CommandRequest(Socks4CommandType socks4CommandType, String str, int i6) {
        this(socks4CommandType, str, i6, "");
    }

    public DefaultSocks4CommandRequest(Socks4CommandType socks4CommandType, String str, int i6, String str2) {
        if (socks4CommandType == null) {
            throw new NullPointerException("type");
        }
        if (str == null) {
            throw new NullPointerException("dstAddr");
        }
        if (i6 <= 0 || i6 >= 65536) {
            throw new IllegalArgumentException("dstPort: " + i6 + " (expected: 1~65535)");
        }
        if (str2 == null) {
            throw new NullPointerException("userId");
        }
        this.userId = str2;
        this.type = socks4CommandType;
        this.dstAddr = IDN.toASCII(str);
        this.dstPort = i6;
    }

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandRequest
    public String dstAddr() {
        return this.dstAddr;
    }

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandRequest
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
        sb.append(", dstAddr: ");
        sb.append(dstAddr());
        sb.append(", dstPort: ");
        sb.append(dstPort());
        sb.append(", userId: ");
        sb.append(userId());
        sb.append(')');
        return sb.toString();
    }

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandRequest
    public Socks4CommandType type() {
        return this.type;
    }

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandRequest
    public String userId() {
        return this.userId;
    }
}
