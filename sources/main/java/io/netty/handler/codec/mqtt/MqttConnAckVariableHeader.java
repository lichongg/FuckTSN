package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class MqttConnAckVariableHeader {
    private final MqttConnectReturnCode connectReturnCode;
    private final boolean sessionPresent;

    public MqttConnectReturnCode connectReturnCode() {
        return this.connectReturnCode;
    }

    public boolean isSessionPresent() {
        return this.sessionPresent;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[connectReturnCode=" + this.connectReturnCode + ", sessionPresent=" + this.sessionPresent + ']';
    }

    public MqttConnAckVariableHeader(MqttConnectReturnCode mqttConnectReturnCode, boolean z5) {
        this.connectReturnCode = mqttConnectReturnCode;
        this.sessionPresent = z5;
    }
}
