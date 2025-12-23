package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l<T1, T2, V> implements m<V> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final m<T1> f47755a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final m<T2> f47756b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Function2<T1, T2, V> f47757c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements Iterator<V>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator<T1> f47758a;

        /* renamed from: b, reason: collision with root package name */
        private final Iterator<T2> f47759b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ l<T1, T2, V> f47760c;

        a(l<T1, T2, V> lVar) {
            this.f47760c = lVar;
            this.f47758a = ((l) lVar).f47755a.iterator();
            this.f47759b = ((l) lVar).f47756b.iterator();
        }

        public final Iterator<T1> a() {
            return this.f47758a;
        }

        public final Iterator<T2> c() {
            return this.f47759b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f47758a.hasNext() && this.f47759b.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return (V) ((l) this.f47760c).f47757c.invoke(this.f47758a.next(), this.f47759b.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(@NotNull m<? extends T1> sequence1, @NotNull m<? extends T2> sequence2, @NotNull Function2<? super T1, ? super T2, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(sequence1, "sequence1");
        kotlin.jvm.internal.g0.p(sequence2, "sequence2");
        kotlin.jvm.internal.g0.p(transform, "transform");
        this.f47755a = sequence1;
        this.f47756b = sequence2;
        this.f47757c = transform;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<V> iterator() {
        return new a(this);
    }
}
