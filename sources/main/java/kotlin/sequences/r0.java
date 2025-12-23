package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class r0<T> implements m<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final m<T> f47787a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Function1<T, Boolean> f47788b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements Iterator<T>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator<T> f47789a;

        /* renamed from: b, reason: collision with root package name */
        private int f47790b = -1;

        /* renamed from: c, reason: collision with root package name */
        private T f47791c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ r0<T> f47792d;

        a(r0<T> r0Var) {
            this.f47792d = r0Var;
            this.f47789a = ((r0) r0Var).f47787a.iterator();
        }

        private final void a() {
            if (this.f47789a.hasNext()) {
                T next = this.f47789a.next();
                if (((Boolean) ((r0) this.f47792d).f47788b.invoke(next)).booleanValue()) {
                    this.f47790b = 1;
                    this.f47791c = next;
                    return;
                }
            }
            this.f47790b = 0;
        }

        public final Iterator<T> c() {
            return this.f47789a;
        }

        public final T e() {
            return this.f47791c;
        }

        public final int f() {
            return this.f47790b;
        }

        public final void g(T t5) {
            this.f47791c = t5;
        }

        public final void h(int i6) {
            this.f47790b = i6;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f47790b == -1) {
                a();
            }
            return this.f47790b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f47790b == -1) {
                a();
            }
            if (this.f47790b == 0) {
                throw new NoSuchElementException();
            }
            T t5 = this.f47791c;
            this.f47791c = null;
            this.f47790b = -1;
            return t5;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r0(@NotNull m<? extends T> sequence, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sequence, "sequence");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        this.f47787a = sequence;
        this.f47788b = predicate;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}
