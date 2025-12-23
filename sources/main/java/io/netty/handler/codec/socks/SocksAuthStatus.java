package io.netty.handler.codec.socks;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum SocksAuthStatus {
    SUCCESS((byte) 0),
    FAILURE((byte) -1);


    /* renamed from: b, reason: collision with root package name */
    private final byte f43075b;

    public static SocksAuthStatus valueOf(byte b6) {
        for (SocksAuthStatus socksAuthStatus : values()) {
            if (socksAuthStatus.f43075b == b6) {
                return socksAuthStatus;
            }
        }
        return FAILURE;
    }

    public byte byteValue() {
        return this.f43075b;
    }

    SocksAuthStatus(byte b6) {
        this.f43075b = b6;
    }

    @Deprecated
    public static SocksAuthStatus fromByte(byte b6) {
        return valueOf(b6);
    }
}
