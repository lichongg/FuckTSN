package io.netty.util.internal.logging;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class FormattingTuple {
    private final String message;
    private final Throwable throwable;

    public String getMessage() {
        return this.message;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    FormattingTuple(String str, Throwable th) {
        this.message = str;
        this.throwable = th;
    }
}
