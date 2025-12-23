package io.netty.handler.codec.haproxy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum HAProxyProtocolVersion {
    V1((byte) 16),
    V2((byte) 32);

    private static final byte VERSION_MASK = -16;
    private final byte byteValue;

    public static HAProxyProtocolVersion valueOf(byte b6) {
        int i6 = b6 & VERSION_MASK;
        byte b7 = (byte) i6;
        if (b7 == 16) {
            return V1;
        }
        if (b7 == 32) {
            return V2;
        }
        throw new IllegalArgumentException("unknown version: " + i6);
    }

    public byte byteValue() {
        return this.byteValue;
    }

    HAProxyProtocolVersion(byte b6) {
        this.byteValue = b6;
    }
}
