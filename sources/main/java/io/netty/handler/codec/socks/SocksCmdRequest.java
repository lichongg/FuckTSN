package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import java.net.IDN;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class SocksCmdRequest extends SocksRequest {
    private final SocksAddressType addressType;
    private final SocksCmdType cmdType;
    private final String host;
    private final int port;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.socks.SocksCmdRequest$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksAddressType;

        static {
            int[] iArr = new int[SocksAddressType.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksAddressType = iArr;
            try {
                iArr[SocksAddressType.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.DOMAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.IPv6.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public SocksCmdRequest(SocksCmdType socksCmdType, SocksAddressType socksAddressType, String str, int i6) {
        super(SocksRequestType.CMD);
        if (socksCmdType == null) {
            throw new NullPointerException("cmdType");
        }
        if (socksAddressType == null) {
            throw new NullPointerException("addressType");
        }
        if (str == null) {
            throw new NullPointerException("host");
        }
        int i7 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[socksAddressType.ordinal()];
        if (i7 != 1) {
            if (i7 == 2) {
                String ascii = IDN.toASCII(str);
                if (ascii.length() > 255) {
                    throw new IllegalArgumentException(str + " IDN: " + ascii + " exceeds 255 char limit");
                }
                str = ascii;
            } else if (i7 == 3 && !NetUtil.isValidIpV6Address(str)) {
                throw new IllegalArgumentException(str + " is not a valid IPv6 address");
            }
        } else if (!NetUtil.isValidIpV4Address(str)) {
            throw new IllegalArgumentException(str + " is not a valid IPv4 address");
        }
        if (i6 <= 0 || i6 >= 65536) {
            throw new IllegalArgumentException(i6 + " is not in bounds 0 < x < 65536");
        }
        this.cmdType = socksCmdType;
        this.addressType = socksAddressType;
        this.host = str;
        this.port = i6;
    }

    public SocksAddressType addressType() {
        return this.addressType;
    }

    public SocksCmdType cmdType() {
        return this.cmdType;
    }

    public String host() {
        return this.addressType == SocksAddressType.DOMAIN ? IDN.toUnicode(this.host) : this.host;
    }

    public int port() {
        return this.port;
    }

    @Override // io.netty.handler.codec.socks.SocksMessage
    public void encodeAsByteBuf(ByteBuf byteBuf) {
        byteBuf.writeByte(protocolVersion().byteValue());
        byteBuf.writeByte(this.cmdType.byteValue());
        byteBuf.writeByte(0);
        byteBuf.writeByte(this.addressType.byteValue());
        int i6 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[this.addressType.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    return;
                }
                byteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(this.host));
                byteBuf.writeShort(this.port);
                return;
            }
            byteBuf.writeByte(this.host.length());
            byteBuf.writeCharSequence(this.host, CharsetUtil.US_ASCII);
            byteBuf.writeShort(this.port);
            return;
        }
        byteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(this.host));
        byteBuf.writeShort(this.port);
    }
}
