package io.netty.handler.codec.mqtt;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class MqttFixedHeader {
    private final boolean isDup;
    private final boolean isRetain;
    private final MqttMessageType messageType;
    private final MqttQoS qosLevel;
    private final int remainingLength;

    public boolean isDup() {
        return this.isDup;
    }

    public boolean isRetain() {
        return this.isRetain;
    }

    public MqttMessageType messageType() {
        return this.messageType;
    }

    public MqttQoS qosLevel() {
        return this.qosLevel;
    }

    public int remainingLength() {
        return this.remainingLength;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[messageType=" + this.messageType + ", isDup=" + this.isDup + ", qosLevel=" + this.qosLevel + ", isRetain=" + this.isRetain + ", remainingLength=" + this.remainingLength + ']';
    }

    public MqttFixedHeader(MqttMessageType mqttMessageType, boolean z5, MqttQoS mqttQoS, boolean z6, int i6) {
        this.messageType = (MqttMessageType) ObjectUtil.checkNotNull(mqttMessageType, "messageType");
        this.isDup = z5;
        this.qosLevel = (MqttQoS) ObjectUtil.checkNotNull(mqttQoS, "qosLevel");
        this.isRetain = z6;
        this.remainingLength = i6;
    }
}
