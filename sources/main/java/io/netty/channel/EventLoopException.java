package io.netty.channel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class EventLoopException extends ChannelException {
    private static final long serialVersionUID = -8969100344583703616L;

    public EventLoopException() {
    }

    public EventLoopException(String str, Throwable th) {
        super(str, th);
    }

    public EventLoopException(String str) {
        super(str);
    }

    public EventLoopException(Throwable th) {
        super(th);
    }
}
