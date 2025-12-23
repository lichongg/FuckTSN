package io.netty.handler.codec.haproxy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum HAProxyCommand {
    LOCAL((byte) 0),
    PROXY((byte) 1);

    private static final byte COMMAND_MASK = 15;
    private final byte byteValue;

    public static HAProxyCommand valueOf(byte b6) {
        int i6 = b6 & 15;
        byte b7 = (byte) i6;
        if (b7 == 0) {
            return LOCAL;
        }
        if (b7 == 1) {
            return PROXY;
        }
        throw new IllegalArgumentException("unknown command: " + i6);
    }

    public byte byteValue() {
        return this.byteValue;
    }

    HAProxyCommand(byte b6) {
        this.byteValue = b6;
    }
}
