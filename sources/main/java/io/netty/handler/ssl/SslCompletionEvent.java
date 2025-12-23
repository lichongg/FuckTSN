package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class SslCompletionEvent {
    private final Throwable cause;

    SslCompletionEvent() {
        this.cause = null;
    }

    public final Throwable cause() {
        return this.cause;
    }

    public final boolean isSuccess() {
        return this.cause == null;
    }

    SslCompletionEvent(Throwable th) {
        this.cause = (Throwable) ObjectUtil.checkNotNull(th, "cause");
    }

    public String toString() {
        Throwable cause = cause();
        if (cause == null) {
            return getClass().getSimpleName() + "(SUCCESS)";
        }
        return getClass().getSimpleName() + '(' + cause + ')';
    }
}
