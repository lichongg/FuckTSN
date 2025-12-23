package io.netty.handler.codec.socks;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum SocksCmdType {
    CONNECT((byte) 1),
    BIND((byte) 2),
    UDP((byte) 3),
    UNKNOWN((byte) -1);


    /* renamed from: b, reason: collision with root package name */
    private final byte f43077b;

    public static SocksCmdType valueOf(byte b6) {
        for (SocksCmdType socksCmdType : values()) {
            if (socksCmdType.f43077b == b6) {
                return socksCmdType;
            }
        }
        return UNKNOWN;
    }

    public byte byteValue() {
        return this.f43077b;
    }

    SocksCmdType(byte b6) {
        this.f43077b = b6;
    }

    @Deprecated
    public static SocksCmdType fromByte(byte b6) {
        return valueOf(b6);
    }
}
