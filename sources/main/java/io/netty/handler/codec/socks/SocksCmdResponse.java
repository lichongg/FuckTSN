package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import java.net.IDN;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class SocksCmdResponse extends SocksResponse {
    private static final byte[] DOMAIN_ZEROED = {0};
    private static final byte[] IPv4_HOSTNAME_ZEROED = {0, 0, 0, 0};
    private static final byte[] IPv6_HOSTNAME_ZEROED = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private final SocksAddressType addressType;
    private final SocksCmdStatus cmdStatus;
    private final String host;
    private final int port;

    public SocksCmdResponse(SocksCmdStatus socksCmdStatus, SocksAddressType socksAddressType) {
        this(socksCmdStatus, socksAddressType, null, 0);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.socks.SocksCmdResponse$1, reason: invalid class name */
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

    public SocksCmdResponse(SocksCmdStatus socksCmdStatus, SocksAddressType socksAddressType, String str, int i6) {
        super(SocksResponseType.CMD);
        if (socksCmdStatus == null) {
            throw new NullPointerException("cmdStatus");
        }
        if (socksAddressType == null) {
            throw new NullPointerException("addressType");
        }
        if (str != null) {
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
        }
        if (i6 < 0 || i6 > 65535) {
            throw new IllegalArgumentException(i6 + " is not in bounds 0 <= x <= 65535");
        }
        this.cmdStatus = socksCmdStatus;
        this.addressType = socksAddressType;
        this.host = str;
        this.port = i6;
    }

    public SocksAddressType addressType() {
        return this.addressType;
    }

    public SocksCmdStatus cmdStatus() {
        return this.cmdStatus;
    }

    public String host() {
        String str = this.host;
        return (str == null || this.addressType != SocksAddressType.DOMAIN) ? str : IDN.toUnicode(str);
    }

    public int port() {
        return this.port;
    }

    @Override // io.netty.handler.codec.socks.SocksMessage
    public void encodeAsByteBuf(ByteBuf byteBuf) {
        byte[] createByteArrayFromIpAddressString;
        byte[] createByteArrayFromIpAddressString2;
        byteBuf.writeByte(protocolVersion().byteValue());
        byteBuf.writeByte(this.cmdStatus.byteValue());
        byteBuf.writeByte(0);
        byteBuf.writeByte(this.addressType.byteValue());
        int i6 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[this.addressType.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    return;
                }
                String str = this.host;
                if (str == null) {
                    createByteArrayFromIpAddressString2 = IPv6_HOSTNAME_ZEROED;
                } else {
                    createByteArrayFromIpAddressString2 = NetUtil.createByteArrayFromIpAddressString(str);
                }
                byteBuf.writeBytes(createByteArrayFromIpAddressString2);
                byteBuf.writeShort(this.port);
                return;
            }
            String str2 = this.host;
            if (str2 != null) {
                byteBuf.writeByte(str2.length());
                byteBuf.writeCharSequence(this.host, CharsetUtil.US_ASCII);
            } else {
                byte[] bArr = DOMAIN_ZEROED;
                byteBuf.writeByte(bArr.length);
                byteBuf.writeBytes(bArr);
            }
            byteBuf.writeShort(this.port);
            return;
        }
        String str3 = this.host;
        if (str3 == null) {
            createByteArrayFromIpAddressString = IPv4_HOSTNAME_ZEROED;
        } else {
            createByteArrayFromIpAddressString = NetUtil.createByteArrayFromIpAddressString(str3);
        }
        byteBuf.writeBytes(createByteArrayFromIpAddressString);
        byteBuf.writeShort(this.port);
    }
}
