package io.netty.handler.codec.mqtt;

import io.netty.handler.codec.DecoderException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class MqttUnacceptableProtocolVersionException extends DecoderException {
    private static final long serialVersionUID = 4914652213232455749L;

    public MqttUnacceptableProtocolVersionException() {
    }

    public MqttUnacceptableProtocolVersionException(String str, Throwable th) {
        super(str, th);
    }

    public MqttUnacceptableProtocolVersionException(String str) {
        super(str);
    }

    public MqttUnacceptableProtocolVersionException(Throwable th) {
        super(th);
    }
}
