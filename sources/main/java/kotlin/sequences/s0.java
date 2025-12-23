package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s0<T, R> implements m<R> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final m<T> f47794a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Function2<Integer, T, R> f47795b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements Iterator<R>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator<T> f47796a;

        /* renamed from: b, reason: collision with root package name */
        private int f47797b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ s0<T, R> f47798c;

        a(s0<T, R> s0Var) {
            this.f47798c = s0Var;
            this.f47796a = ((s0) s0Var).f47794a.iterator();
        }

        public final int a() {
            return this.f47797b;
        }

        public final Iterator<T> c() {
            return this.f47796a;
        }

        public final void e(int i6) {
            this.f47797b = i6;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f47796a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            Function2 function2 = ((s0) this.f47798c).f47795b;
            int i6 = this.f47797b;
            this.f47797b = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.f0.b0();
            }
            return (R) function2.invoke(Integer.valueOf(i6), this.f47796a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s0(@NotNull m<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, ? extends R> transformer) {
        kotlin.jvm.internal.g0.p(sequence, "sequence");
        kotlin.jvm.internal.g0.p(transformer, "transformer");
        this.f47794a = sequence;
        this.f47795b = transformer;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<R> iterator() {
        return new a(this);
    }
}
