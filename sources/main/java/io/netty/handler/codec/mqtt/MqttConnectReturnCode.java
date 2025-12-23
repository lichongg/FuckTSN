package io.netty.handler.codec.mqtt;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum MqttConnectReturnCode {
    CONNECTION_ACCEPTED((byte) 0),
    CONNECTION_REFUSED_UNACCEPTABLE_PROTOCOL_VERSION((byte) 1),
    CONNECTION_REFUSED_IDENTIFIER_REJECTED((byte) 2),
    CONNECTION_REFUSED_SERVER_UNAVAILABLE((byte) 3),
    CONNECTION_REFUSED_BAD_USER_NAME_OR_PASSWORD((byte) 4),
    CONNECTION_REFUSED_NOT_AUTHORIZED((byte) 5);

    private static final Map<Byte, MqttConnectReturnCode> VALUE_TO_CODE_MAP;
    private final byte byteValue;

    static {
        HashMap hashMap = new HashMap();
        for (MqttConnectReturnCode mqttConnectReturnCode : values()) {
            hashMap.put(Byte.valueOf(mqttConnectReturnCode.byteValue), mqttConnectReturnCode);
        }
        VALUE_TO_CODE_MAP = Collections.unmodifiableMap(hashMap);
    }

    public static MqttConnectReturnCode valueOf(byte b6) {
        Map<Byte, MqttConnectReturnCode> map = VALUE_TO_CODE_MAP;
        if (map.containsKey(Byte.valueOf(b6))) {
            return map.get(Byte.valueOf(b6));
        }
        throw new IllegalArgumentException("unknown connect return code: " + (b6 & 255));
    }

    public byte byteValue() {
        return this.byteValue;
    }

    MqttConnectReturnCode(byte b6) {
        this.byteValue = b6;
    }
}
