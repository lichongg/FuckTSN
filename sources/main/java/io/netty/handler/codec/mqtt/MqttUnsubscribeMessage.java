package io.netty.handler.codec.mqtt;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class MqttUnsubscribeMessage extends MqttMessage {
    @Override // io.netty.handler.codec.mqtt.MqttMessage
    public MqttUnsubscribePayload payload() {
        return (MqttUnsubscribePayload) super.payload();
    }

    @Override // io.netty.handler.codec.mqtt.MqttMessage
    public MqttMessageIdVariableHeader variableHeader() {
        return (MqttMessageIdVariableHeader) super.variableHeader();
    }

    public MqttUnsubscribeMessage(MqttFixedHeader mqttFixedHeader, MqttMessageIdVariableHeader mqttMessageIdVariableHeader, MqttUnsubscribePayload mqttUnsubscribePayload) {
        super(mqttFixedHeader, mqttMessageIdVariableHeader, mqttUnsubscribePayload);
    }
}
