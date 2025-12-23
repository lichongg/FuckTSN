package rx.exceptions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class OnCompletedFailedException extends RuntimeException {
    private static final long serialVersionUID = 8622579378868820554L;

    public OnCompletedFailedException(Throwable th) {
        super(th == null ? new NullPointerException() : th);
    }

    public OnCompletedFailedException(String str, Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }
}
