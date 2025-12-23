package io.netty.handler.codec.mqtt;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum MqttQoS {
    AT_MOST_ONCE(0),
    AT_LEAST_ONCE(1),
    EXACTLY_ONCE(2),
    FAILURE(128);

    private final int value;

    public static MqttQoS valueOf(int i6) {
        for (MqttQoS mqttQoS : values()) {
            if (mqttQoS.value == i6) {
                return mqttQoS;
            }
        }
        throw new IllegalArgumentException("invalid QoS: " + i6);
    }

    public int value() {
        return this.value;
    }

    MqttQoS(int i6) {
        this.value = i6;
    }
}
