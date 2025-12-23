package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class MqttTopicSubscription {
    private final MqttQoS qualityOfService;
    private final String topicFilter;

    public MqttQoS qualityOfService() {
        return this.qualityOfService;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[topicFilter=" + this.topicFilter + ", qualityOfService=" + this.qualityOfService + ']';
    }

    public String topicName() {
        return this.topicFilter;
    }

    public MqttTopicSubscription(String str, MqttQoS mqttQoS) {
        this.topicFilter = str;
        this.qualityOfService = mqttQoS;
    }
}
