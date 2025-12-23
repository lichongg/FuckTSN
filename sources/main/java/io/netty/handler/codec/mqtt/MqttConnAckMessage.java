package io.netty.handler.codec.mqtt;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class MqttConnAckMessage extends MqttMessage {
    @Override // io.netty.handler.codec.mqtt.MqttMessage
    public MqttConnAckVariableHeader variableHeader() {
        return (MqttConnAckVariableHeader) super.variableHeader();
    }

    public MqttConnAckMessage(MqttFixedHeader mqttFixedHeader, MqttConnAckVariableHeader mqttConnAckVariableHeader) {
        super(mqttFixedHeader, mqttConnAckVariableHeader);
    }
}
