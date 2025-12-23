package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/DropSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,731:1\n1#2:732\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d<T> implements m<T>, e<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final m<T> f47659a;

    /* renamed from: b, reason: collision with root package name */
    private final int f47660b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements Iterator<T>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator<T> f47661a;

        /* renamed from: b, reason: collision with root package name */
        private int f47662b;

        private final void a() {
            while (this.f47662b > 0 && this.f47661a.hasNext()) {
                this.f47661a.next();
                this.f47662b--;
            }
        }

        public final Iterator<T> c() {
            return this.f47661a;
        }

        public final int e() {
            return this.f47662b;
        }

        public final void f(int i6) {
            this.f47662b = i6;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(d<T> dVar) {
            this.f47661a = ((d) dVar).f47659a.iterator();
            this.f47662b = ((d) dVar).f47660b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f47661a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            return this.f47661a.next();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull m<? extends T> sequence, int i6) {
        kotlin.jvm.internal.g0.p(sequence, "sequence");
        this.f47659a = sequence;
        this.f47660b = i6;
        if (i6 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i6 + '.').toString());
    }

    @Override // kotlin.sequences.e
    @NotNull
    public m<T> a(int i6) {
        int i7 = this.f47660b + i6;
        return i7 < 0 ? new d(this, i6) : new d(this.f47659a, i7);
    }

    @Override // kotlin.sequences.e
    @NotNull
    public m<T> b(int i6) {
        int i7 = this.f47660b;
        int i8 = i7 + i6;
        return i8 < 0 ? new q0(this, i6) : new p0(this.f47659a, i7, i8);
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}
