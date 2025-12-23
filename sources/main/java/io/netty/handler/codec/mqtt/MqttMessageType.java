package io.netty.handler.codec.mqtt;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum MqttMessageType {
    CONNECT(1),
    CONNACK(2),
    PUBLISH(3),
    PUBACK(4),
    PUBREC(5),
    PUBREL(6),
    PUBCOMP(7),
    SUBSCRIBE(8),
    SUBACK(9),
    UNSUBSCRIBE(10),
    UNSUBACK(11),
    PINGREQ(12),
    PINGRESP(13),
    DISCONNECT(14);

    private final int value;

    public static MqttMessageType valueOf(int i6) {
        for (MqttMessageType mqttMessageType : values()) {
            if (mqttMessageType.value == i6) {
                return mqttMessageType;
            }
        }
        throw new IllegalArgumentException("unknown message type: " + i6);
    }

    public int value() {
        return this.value;
    }

    MqttMessageType(int i6) {
        this.value = i6;
    }
}
