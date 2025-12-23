package io.netty.handler.codec.mqtt;

import io.netty.handler.codec.DecoderException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class MqttCodecUtil {
    private static final int MAX_CLIENT_ID_LENGTH = 23;
    private static final int MIN_CLIENT_ID_LENGTH = 1;
    private static final char[] TOPIC_WILDCARDS = {'#', '+'};

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.mqtt.MqttCodecUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType;

        static {
            int[] iArr = new int[MqttMessageType.values().length];
            $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType = iArr;
            try {
                iArr[MqttMessageType.PUBREL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.SUBSCRIBE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.UNSUBSCRIBE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.CONNECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.CONNACK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBACK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBREC.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBCOMP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.SUBACK.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.UNSUBACK.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PINGREQ.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PINGRESP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.DISCONNECT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    static boolean isValidClientId(MqttVersion mqttVersion, String str) {
        if (mqttVersion == MqttVersion.MQTT_3_1) {
            return str != null && str.length() >= 1 && str.length() <= 23;
        }
        if (mqttVersion == MqttVersion.MQTT_3_1_1) {
            return str != null;
        }
        throw new IllegalArgumentException(mqttVersion + " is unknown mqtt version");
    }

    static boolean isValidMessageId(int i6) {
        return i6 != 0;
    }

    static boolean isValidPublishTopicName(String str) {
        for (char c6 : TOPIC_WILDCARDS) {
            if (str.indexOf(c6) >= 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static MqttFixedHeader resetUnusedFields(MqttFixedHeader mqttFixedHeader) {
        switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[mqttFixedHeader.messageType().ordinal()]) {
            case 1:
            case 2:
            case 3:
                if (mqttFixedHeader.isRetain()) {
                    return new MqttFixedHeader(mqttFixedHeader.messageType(), mqttFixedHeader.isDup(), mqttFixedHeader.qosLevel(), false, mqttFixedHeader.remainingLength());
                }
                return mqttFixedHeader;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                if (mqttFixedHeader.isDup() || mqttFixedHeader.qosLevel() != MqttQoS.AT_MOST_ONCE || mqttFixedHeader.isRetain()) {
                    return new MqttFixedHeader(mqttFixedHeader.messageType(), false, MqttQoS.AT_MOST_ONCE, false, mqttFixedHeader.remainingLength());
                }
                return mqttFixedHeader;
            default:
                return mqttFixedHeader;
        }
    }

    static MqttFixedHeader validateFixedHeader(MqttFixedHeader mqttFixedHeader) {
        int i6 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[mqttFixedHeader.messageType().ordinal()];
        if ((i6 != 1 && i6 != 2 && i6 != 3) || mqttFixedHeader.qosLevel() == MqttQoS.AT_LEAST_ONCE) {
            return mqttFixedHeader;
        }
        throw new DecoderException(mqttFixedHeader.messageType().name() + " message must have QoS 1");
    }

    private MqttCodecUtil() {
    }
}
