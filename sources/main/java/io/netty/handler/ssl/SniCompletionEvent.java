package io.netty.handler.ssl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class SniCompletionEvent extends SslCompletionEvent {
    private final String hostname;

    SniCompletionEvent(String str) {
        this.hostname = str;
    }

    public String hostname() {
        return this.hostname;
    }

    SniCompletionEvent(String str, Throwable th) {
        super(th);
        this.hostname = str;
    }

    @Override // io.netty.handler.ssl.SslCompletionEvent
    public String toString() {
        Throwable cause = cause();
        if (cause == null) {
            return SniCompletionEvent.class.getSimpleName() + "(SUCCESS='" + this.hostname + "'\")";
        }
        return SniCompletionEvent.class.getSimpleName() + '(' + cause + ')';
    }

    SniCompletionEvent(Throwable th) {
        this(null, th);
    }
}
