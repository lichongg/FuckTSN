package io.netty.handler.codec.mqtt;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class MqttConnectMessage extends MqttMessage {
    @Override // io.netty.handler.codec.mqtt.MqttMessage
    public MqttConnectPayload payload() {
        return (MqttConnectPayload) super.payload();
    }

    @Override // io.netty.handler.codec.mqtt.MqttMessage
    public MqttConnectVariableHeader variableHeader() {
        return (MqttConnectVariableHeader) super.variableHeader();
    }

    public MqttConnectMessage(MqttFixedHeader mqttFixedHeader, MqttConnectVariableHeader mqttConnectVariableHeader, MqttConnectPayload mqttConnectPayload) {
        super(mqttFixedHeader, mqttConnectVariableHeader, mqttConnectPayload);
    }
}
