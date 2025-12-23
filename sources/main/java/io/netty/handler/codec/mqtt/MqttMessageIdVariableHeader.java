package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class MqttMessageIdVariableHeader {
    private final int messageId;

    public static MqttMessageIdVariableHeader from(int i6) {
        if (i6 >= 1 && i6 <= 65535) {
            return new MqttMessageIdVariableHeader(i6);
        }
        throw new IllegalArgumentException("messageId: " + i6 + " (expected: 1 ~ 65535)");
    }

    public int messageId() {
        return this.messageId;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[messageId=" + this.messageId + ']';
    }

    private MqttMessageIdVariableHeader(int i6) {
        this.messageId = i6;
    }
}
