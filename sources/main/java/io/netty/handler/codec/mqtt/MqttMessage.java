package io.netty.handler.codec.mqtt;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class MqttMessage {
    private final DecoderResult decoderResult;
    private final MqttFixedHeader mqttFixedHeader;
    private final Object payload;
    private final Object variableHeader;

    public MqttMessage(MqttFixedHeader mqttFixedHeader) {
        this(mqttFixedHeader, null, null);
    }

    public MqttMessage(MqttFixedHeader mqttFixedHeader, Object obj) {
        this(mqttFixedHeader, obj, null);
    }

    public DecoderResult decoderResult() {
        return this.decoderResult;
    }

    public MqttFixedHeader fixedHeader() {
        return this.mqttFixedHeader;
    }

    public Object payload() {
        return this.payload;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(StringUtil.simpleClassName(this));
        sb.append('[');
        sb.append("fixedHeader=");
        sb.append(fixedHeader() != null ? fixedHeader().toString() : "");
        sb.append(", variableHeader=");
        sb.append(variableHeader() != null ? this.variableHeader.toString() : "");
        sb.append(", payload=");
        sb.append(payload() != null ? this.payload.toString() : "");
        sb.append(']');
        return sb.toString();
    }

    public Object variableHeader() {
        return this.variableHeader;
    }

    public MqttMessage(MqttFixedHeader mqttFixedHeader, Object obj, Object obj2) {
        this(mqttFixedHeader, obj, obj2, DecoderResult.SUCCESS);
    }

    public MqttMessage(MqttFixedHeader mqttFixedHeader, Object obj, Object obj2, DecoderResult decoderResult) {
        this.mqttFixedHeader = mqttFixedHeader;
        this.variableHeader = obj;
        this.payload = obj2;
        this.decoderResult = decoderResult;
    }
}
