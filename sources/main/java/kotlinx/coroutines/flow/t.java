package kotlinx.coroutines.flow;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface t<T> extends h0<T>, s<T> {
    boolean compareAndSet(T t5, T t6);

    @Override // kotlinx.coroutines.flow.h0
    T getValue();

    void setValue(T t5);
}
