package io.netty.handler.codec.socks;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum SocksProtocolVersion {
    SOCKS4a((byte) 4),
    SOCKS5((byte) 5),
    UNKNOWN((byte) -1);


    /* renamed from: b, reason: collision with root package name */
    private final byte f43078b;

    public static SocksProtocolVersion valueOf(byte b6) {
        for (SocksProtocolVersion socksProtocolVersion : values()) {
            if (socksProtocolVersion.f43078b == b6) {
                return socksProtocolVersion;
            }
        }
        return UNKNOWN;
    }

    public byte byteValue() {
        return this.f43078b;
    }

    SocksProtocolVersion(byte b6) {
        this.f43078b = b6;
    }

    @Deprecated
    public static SocksProtocolVersion fromByte(byte b6) {
        return valueOf(b6);
    }
}
