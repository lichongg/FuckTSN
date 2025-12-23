package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class MqttPublishVariableHeader {
    private final int packetId;
    private final String topicName;

    @Deprecated
    public int messageId() {
        return this.packetId;
    }

    public int packetId() {
        return this.packetId;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[topicName=" + this.topicName + ", packetId=" + this.packetId + ']';
    }

    public String topicName() {
        return this.topicName;
    }

    public MqttPublishVariableHeader(String str, int i6) {
        this.topicName = str;
        this.packetId = i6;
    }
}
