package kotlinx.coroutines.internal;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.i;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.e3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class z0<T> implements e3<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f49333a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final ThreadLocal<T> f49334b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final i.c<?> f49335c;

    @Override // kotlinx.coroutines.e3
    public T U(@NotNull kotlin.coroutines.i iVar) {
        T t5 = this.f49334b.get();
        this.f49334b.set(this.f49333a);
        return t5;
    }

    @Override // kotlin.coroutines.i.b
    @NotNull
    public i.c<?> getKey() {
        return this.f49335c;
    }

    @Override // kotlinx.coroutines.e3
    public void n(@NotNull kotlin.coroutines.i iVar, T t5) {
        this.f49334b.set(t5);
    }

    @NotNull
    public String toString() {
        return "ThreadLocal(value=" + this.f49333a + ", threadLocal = " + this.f49334b + ')';
    }

    public z0(T t5, @NotNull ThreadLocal<T> threadLocal) {
        this.f49333a = t5;
        this.f49334b = threadLocal;
        this.f49335c = new a1(threadLocal);
    }

    @Override // kotlin.coroutines.i.b, kotlin.coroutines.i
    public <R> R fold(R r5, @NotNull Function2<? super R, ? super i.b, ? extends R> function2) {
        return (R) e3.a.a(this, r5, function2);
    }

    @Override // kotlin.coroutines.i.b, kotlin.coroutines.i
    @Nullable
    public <E extends i.b> E get(@NotNull i.c<E> cVar) {
        if (kotlin.jvm.internal.g0.g(getKey(), cVar)) {
            kotlin.jvm.internal.g0.n(this, "null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
            return this;
        }
        return null;
    }

    @Override // kotlin.coroutines.i.b, kotlin.coroutines.i
    @NotNull
    public kotlin.coroutines.i minusKey(@NotNull i.c<?> cVar) {
        if (kotlin.jvm.internal.g0.g(getKey(), cVar)) {
            return EmptyCoroutineContext.INSTANCE;
        }
        return this;
    }

    @Override // kotlin.coroutines.i
    @NotNull
    public kotlin.coroutines.i plus(@NotNull kotlin.coroutines.i iVar) {
        return e3.a.d(this, iVar);
    }
}
