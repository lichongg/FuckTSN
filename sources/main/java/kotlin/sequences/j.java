package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class j<T> implements m<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Function0<T> f47691a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Function1<T, T> f47692b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements Iterator<T>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        private T f47693a;

        /* renamed from: b, reason: collision with root package name */
        private int f47694b = -2;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ j<T> f47695c;

        a(j<T> jVar) {
            this.f47695c = jVar;
        }

        private final void a() {
            T t5;
            if (this.f47694b == -2) {
                t5 = (T) ((j) this.f47695c).f47691a.invoke();
            } else {
                Function1 function1 = ((j) this.f47695c).f47692b;
                T t6 = this.f47693a;
                kotlin.jvm.internal.g0.m(t6);
                t5 = (T) function1.invoke(t6);
            }
            this.f47693a = t5;
            this.f47694b = t5 == null ? 0 : 1;
        }

        public final T c() {
            return this.f47693a;
        }

        public final int e() {
            return this.f47694b;
        }

        public final void f(T t5) {
            this.f47693a = t5;
        }

        public final void g(int i6) {
            this.f47694b = i6;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f47694b < 0) {
                a();
            }
            return this.f47694b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f47694b < 0) {
                a();
            }
            if (this.f47694b == 0) {
                throw new NoSuchElementException();
            }
            T t5 = this.f47693a;
            kotlin.jvm.internal.g0.n(t5, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f47694b = -1;
            return t5;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(@NotNull Function0<? extends T> getInitialValue, @NotNull Function1<? super T, ? extends T> getNextValue) {
        kotlin.jvm.internal.g0.p(getInitialValue, "getInitialValue");
        kotlin.jvm.internal.g0.p(getNextValue, "getNextValue");
        this.f47691a = getInitialValue;
        this.f47692b = getNextValue;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}
