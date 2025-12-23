package io.netty.handler.codec.socksx;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum SocksVersion {
    SOCKS4a((byte) 4),
    SOCKS5((byte) 5),
    UNKNOWN((byte) -1);


    /* renamed from: b, reason: collision with root package name */
    private final byte f43080b;

    public static SocksVersion valueOf(byte b6) {
        SocksVersion socksVersion = SOCKS4a;
        if (b6 == socksVersion.byteValue()) {
            return socksVersion;
        }
        SocksVersion socksVersion2 = SOCKS5;
        return b6 == socksVersion2.byteValue() ? socksVersion2 : UNKNOWN;
    }

    public byte byteValue() {
        return this.f43080b;
    }

    SocksVersion(byte b6) {
        this.f43080b = b6;
    }
}
