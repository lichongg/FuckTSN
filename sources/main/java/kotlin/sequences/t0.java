package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t0<T, R> implements m<R> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final m<T> f47800a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Function1<T, R> f47801b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements Iterator<R>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator<T> f47802a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ t0<T, R> f47803b;

        a(t0<T, R> t0Var) {
            this.f47803b = t0Var;
            this.f47802a = ((t0) t0Var).f47800a.iterator();
        }

        public final Iterator<T> a() {
            return this.f47802a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f47802a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) ((t0) this.f47803b).f47801b.invoke(this.f47802a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t0(@NotNull m<? extends T> sequence, @NotNull Function1<? super T, ? extends R> transformer) {
        kotlin.jvm.internal.g0.p(sequence, "sequence");
        kotlin.jvm.internal.g0.p(transformer, "transformer");
        this.f47800a = sequence;
        this.f47801b = transformer;
    }

    @NotNull
    public final <E> m<E> e(@NotNull Function1<? super R, ? extends Iterator<? extends E>> iterator) {
        kotlin.jvm.internal.g0.p(iterator, "iterator");
        return new i(this.f47800a, this.f47801b, iterator);
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<R> iterator() {
        return new a(this);
    }
}
