package io.netty.handler.codec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class PrematureChannelClosureException extends CodecException {
    private static final long serialVersionUID = 4907642202594703094L;

    public PrematureChannelClosureException() {
    }

    public PrematureChannelClosureException(String str, Throwable th) {
        super(str, th);
    }

    public PrematureChannelClosureException(String str) {
        super(str);
    }

    public PrematureChannelClosureException(Throwable th) {
        super(th);
    }
}
