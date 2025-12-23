package io.netty.handler.codec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class CorruptedFrameException extends DecoderException {
    private static final long serialVersionUID = 3918052232492988408L;

    public CorruptedFrameException() {
    }

    public CorruptedFrameException(String str, Throwable th) {
        super(str, th);
    }

    public CorruptedFrameException(String str) {
        super(str);
    }

    public CorruptedFrameException(Throwable th) {
        super(th);
    }
}
