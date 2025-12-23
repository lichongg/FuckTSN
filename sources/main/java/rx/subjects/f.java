package rx.subjects;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class f<T, R> extends rx.e<R> implements rx.f<T> {
    public abstract boolean w7();

    protected f(e.a<R> aVar) {
        super(aVar);
    }

    public final e<T, R> x7() {
        if (getClass() == e.class) {
            return (e) this;
        }
        return new e<>(this);
    }
}
