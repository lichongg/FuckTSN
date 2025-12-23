package io.netty.handler.codec.socks;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum SocksSubnegotiationVersion {
    AUTH_PASSWORD((byte) 1),
    UNKNOWN((byte) -1);


    /* renamed from: b, reason: collision with root package name */
    private final byte f43079b;

    public static SocksSubnegotiationVersion valueOf(byte b6) {
        for (SocksSubnegotiationVersion socksSubnegotiationVersion : values()) {
            if (socksSubnegotiationVersion.f43079b == b6) {
                return socksSubnegotiationVersion;
            }
        }
        return UNKNOWN;
    }

    public byte byteValue() {
        return this.f43079b;
    }

    SocksSubnegotiationVersion(byte b6) {
        this.f43079b = b6;
    }

    @Deprecated
    public static SocksSubnegotiationVersion fromByte(byte b6) {
        return valueOf(b6);
    }
}
