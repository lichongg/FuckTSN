package kotlin.reflect.jvm.internal.impl.storage;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class l<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f47125a;

    /* renamed from: b, reason: collision with root package name */
    private final Thread f47126b = Thread.currentThread();

    public boolean b() {
        return this.f47126b == Thread.currentThread();
    }

    l(T t5) {
        this.f47125a = t5;
    }

    public T a() {
        if (b()) {
            return this.f47125a;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }
}
