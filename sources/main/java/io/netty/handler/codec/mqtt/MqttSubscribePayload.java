package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class MqttSubscribePayload {
    private final List<MqttTopicSubscription> topicSubscriptions;

    public String toString() {
        StringBuilder sb = new StringBuilder(StringUtil.simpleClassName(this));
        sb.append('[');
        for (int i6 = 0; i6 < this.topicSubscriptions.size(); i6++) {
            sb.append(this.topicSubscriptions.get(i6));
            sb.append(", ");
        }
        if (!this.topicSubscriptions.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(']');
        return sb.toString();
    }

    public List<MqttTopicSubscription> topicSubscriptions() {
        return this.topicSubscriptions;
    }

    public MqttSubscribePayload(List<MqttTopicSubscription> list) {
        this.topicSubscriptions = Collections.unmodifiableList(list);
    }
}
