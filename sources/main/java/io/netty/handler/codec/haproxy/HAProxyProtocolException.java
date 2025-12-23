package io.netty.handler.codec.haproxy;

import io.netty.handler.codec.DecoderException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class HAProxyProtocolException extends DecoderException {
    private static final long serialVersionUID = 713710864325167351L;

    public HAProxyProtocolException() {
    }

    public HAProxyProtocolException(String str, Throwable th) {
        super(str, th);
    }

    public HAProxyProtocolException(String str) {
        super(str);
    }

    public HAProxyProtocolException(Throwable th) {
        super(th);
    }
}
