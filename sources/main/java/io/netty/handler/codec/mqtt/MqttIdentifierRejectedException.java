package io.netty.handler.codec.mqtt;

import io.netty.handler.codec.DecoderException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class MqttIdentifierRejectedException extends DecoderException {
    private static final long serialVersionUID = -1323503322689614981L;

    public MqttIdentifierRejectedException() {
    }

    public MqttIdentifierRejectedException(String str, Throwable th) {
        super(str, th);
    }

    public MqttIdentifierRejectedException(String str) {
        super(str);
    }

    public MqttIdentifierRejectedException(Throwable th) {
        super(th);
    }
}
