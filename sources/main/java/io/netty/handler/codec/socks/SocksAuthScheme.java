package io.netty.handler.codec.socks;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum SocksAuthScheme {
    NO_AUTH((byte) 0),
    AUTH_GSSAPI((byte) 1),
    AUTH_PASSWORD((byte) 2),
    UNKNOWN((byte) -1);


    /* renamed from: b, reason: collision with root package name */
    private final byte f43074b;

    public static SocksAuthScheme valueOf(byte b6) {
        for (SocksAuthScheme socksAuthScheme : values()) {
            if (socksAuthScheme.f43074b == b6) {
                return socksAuthScheme;
            }
        }
        return UNKNOWN;
    }

    public byte byteValue() {
        return this.f43074b;
    }

    SocksAuthScheme(byte b6) {
        this.f43074b = b6;
    }

    @Deprecated
    public static SocksAuthScheme fromByte(byte b6) {
        return valueOf(b6);
    }
}
