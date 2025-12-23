package io.netty.channel.unix;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class NativeInetAddress {
    private static final byte[] IPV4_MAPPED_IPV6_PREFIX = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1};
    final byte[] address;
    final int scopeId;

    public NativeInetAddress(byte[] bArr, int i6) {
        this.address = bArr;
        this.scopeId = i6;
    }

    public byte[] address() {
        return this.address;
    }

    public static InetSocketAddress address(byte[] bArr, int i6, int i7) {
        InetAddress byAddress;
        int i8 = i6 + i7;
        int decodeInt = decodeInt(bArr, i8 - 4);
        try {
            if (i7 == 8) {
                byte[] bArr2 = new byte[4];
                System.arraycopy(bArr, i6, bArr2, 0, 4);
                byAddress = InetAddress.getByAddress(bArr2);
            } else {
                if (i7 != 24) {
                    throw new Error();
                }
                byte[] bArr3 = new byte[16];
                System.arraycopy(bArr, i6, bArr3, 0, 16);
                byAddress = Inet6Address.getByAddress((String) null, bArr3, decodeInt(bArr, i8 - 8));
            }
            return new InetSocketAddress(byAddress, decodeInt);
        } catch (UnknownHostException e6) {
            throw new Error("Should never happen", e6);
        }
    }

    static int decodeInt(byte[] bArr, int i6) {
        return (bArr[i6 + 3] & 255) | ((bArr[i6] & 255) << 24) | ((bArr[i6 + 1] & 255) << 16) | ((bArr[i6 + 2] & 255) << 8);
    }

    public static byte[] ipv4MappedIpv6Address(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        byte[] bArr3 = IPV4_MAPPED_IPV6_PREFIX;
        System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
        System.arraycopy(bArr, 0, bArr2, 12, bArr.length);
        return bArr2;
    }

    public int scopeId() {
        return this.scopeId;
    }

    public static NativeInetAddress newInstance(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        if (inetAddress instanceof Inet6Address) {
            return new NativeInetAddress(address, ((Inet6Address) inetAddress).getScopeId());
        }
        return new NativeInetAddress(ipv4MappedIpv6Address(address));
    }

    public NativeInetAddress(byte[] bArr) {
        this(bArr, 0);
    }
}
