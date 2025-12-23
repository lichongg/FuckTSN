package io.netty.handler.codec.mqtt;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum MqttVersion {
    MQTT_3_1("MQIsdp", (byte) 3),
    MQTT_3_1_1("MQTT", (byte) 4);

    private final byte level;
    private final String name;

    public byte protocolLevel() {
        return this.level;
    }

    public String protocolName() {
        return this.name;
    }

    public byte[] protocolNameBytes() {
        return this.name.getBytes(CharsetUtil.UTF_8);
    }

    MqttVersion(String str, byte b6) {
        this.name = (String) ObjectUtil.checkNotNull(str, "protocolName");
        this.level = b6;
    }

    public static MqttVersion fromProtocolNameAndLevel(String str, byte b6) {
        for (MqttVersion mqttVersion : values()) {
            if (mqttVersion.name.equals(str)) {
                if (mqttVersion.level == b6) {
                    return mqttVersion;
                }
                throw new MqttUnacceptableProtocolVersionException(str + " and " + ((int) b6) + " are not match");
            }
        }
        throw new MqttUnacceptableProtocolVersionException(str + "is unknown protocol name");
    }
}
