package rx.internal.operators;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class w4<T, R> implements rx.functions.p<T, R> {

    /* renamed from: a, reason: collision with root package name */
    final Class<R> f53771a;

    @Override // rx.functions.p
    public R call(T t5) {
        return this.f53771a.cast(t5);
    }

    public w4(Class<R> cls) {
        this.f53771a = cls;
    }
}
