package io.netty.handler.codec.compression;

import io.netty.handler.codec.DecoderException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DecompressionException extends DecoderException {
    private static final long serialVersionUID = 3546272712208105199L;

    public DecompressionException() {
    }

    public DecompressionException(String str, Throwable th) {
        super(str, th);
    }

    public DecompressionException(String str) {
        super(str);
    }

    public DecompressionException(Throwable th) {
        super(th);
    }
}
