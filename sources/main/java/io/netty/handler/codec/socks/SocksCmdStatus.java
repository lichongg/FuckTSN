package io.netty.handler.codec.socks;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum SocksCmdStatus {
    SUCCESS((byte) 0),
    FAILURE((byte) 1),
    FORBIDDEN((byte) 2),
    NETWORK_UNREACHABLE((byte) 3),
    HOST_UNREACHABLE((byte) 4),
    REFUSED((byte) 5),
    TTL_EXPIRED((byte) 6),
    COMMAND_NOT_SUPPORTED((byte) 7),
    ADDRESS_NOT_SUPPORTED((byte) 8),
    UNASSIGNED((byte) -1);


    /* renamed from: b, reason: collision with root package name */
    private final byte f43076b;

    public static SocksCmdStatus valueOf(byte b6) {
        for (SocksCmdStatus socksCmdStatus : values()) {
            if (socksCmdStatus.f43076b == b6) {
                return socksCmdStatus;
            }
        }
        return UNASSIGNED;
    }

    public byte byteValue() {
        return this.f43076b;
    }

    SocksCmdStatus(byte b6) {
        this.f43076b = b6;
    }

    @Deprecated
    public static SocksCmdStatus fromByte(byte b6) {
        return valueOf(b6);
    }
}
