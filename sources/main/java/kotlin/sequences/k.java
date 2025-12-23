package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.a1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k<T> implements m<a1<? extends T>> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final m<T> f47696a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements Iterator<a1<? extends T>>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator<T> f47697a;

        /* renamed from: b, reason: collision with root package name */
        private int f47698b;

        public final int a() {
            return this.f47698b;
        }

        public final Iterator<T> c() {
            return this.f47697a;
        }

        @Override // java.util.Iterator
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public a1<T> next() {
            int i6 = this.f47698b;
            this.f47698b = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.f0.b0();
            }
            return new a1<>(i6, this.f47697a.next());
        }

        public final void f(int i6) {
            this.f47698b = i6;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f47697a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(k<T> kVar) {
            this.f47697a = ((k) kVar).f47696a.iterator();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(@NotNull m<? extends T> sequence) {
        kotlin.jvm.internal.g0.p(sequence, "sequence");
        this.f47696a = sequence;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<a1<T>> iterator() {
        return new a(this);
    }
}
