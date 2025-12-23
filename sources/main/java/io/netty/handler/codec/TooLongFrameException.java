package io.netty.handler.codec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class TooLongFrameException extends DecoderException {
    private static final long serialVersionUID = -1995801950698951640L;

    public TooLongFrameException() {
    }

    public TooLongFrameException(String str, Throwable th) {
        super(str, th);
    }

    public TooLongFrameException(String str) {
        super(str);
    }

    public TooLongFrameException(Throwable th) {
        super(th);
    }
}
