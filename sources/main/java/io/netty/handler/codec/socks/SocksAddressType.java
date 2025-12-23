package io.netty.handler.codec.socks;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum SocksAddressType {
    IPv4((byte) 1),
    DOMAIN((byte) 3),
    IPv6((byte) 4),
    UNKNOWN((byte) -1);


    /* renamed from: b, reason: collision with root package name */
    private final byte f43073b;

    public static SocksAddressType valueOf(byte b6) {
        for (SocksAddressType socksAddressType : values()) {
            if (socksAddressType.f43073b == b6) {
                return socksAddressType;
            }
        }
        return UNKNOWN;
    }

    public byte byteValue() {
        return this.f43073b;
    }

    SocksAddressType(byte b6) {
        this.f43073b = b6;
    }

    @Deprecated
    public static SocksAddressType fromByte(byte b6) {
        return valueOf(b6);
    }
}
