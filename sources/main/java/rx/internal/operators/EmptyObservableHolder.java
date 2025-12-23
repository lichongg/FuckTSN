package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public enum EmptyObservableHolder implements e.a<Object> {
    INSTANCE;

    static final rx.e<Object> EMPTY = rx.e.I6(INSTANCE);

    public static <T> rx.e<T> instance() {
        return (rx.e<T>) EMPTY;
    }

    @Override // rx.functions.b
    public void call(rx.l<? super Object> lVar) {
        lVar.onCompleted();
    }
}
