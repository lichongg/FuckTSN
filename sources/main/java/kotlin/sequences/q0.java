package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/TakeSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,731:1\n1#2:732\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q0<T> implements m<T>, e<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final m<T> f47783a;

    /* renamed from: b, reason: collision with root package name */
    private final int f47784b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements Iterator<T>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        private int f47785a;

        /* renamed from: b, reason: collision with root package name */
        private final Iterator<T> f47786b;

        public final Iterator<T> a() {
            return this.f47786b;
        }

        public final int c() {
            return this.f47785a;
        }

        public final void e(int i6) {
            this.f47785a = i6;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f47785a > 0 && this.f47786b.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            int i6 = this.f47785a;
            if (i6 == 0) {
                throw new NoSuchElementException();
            }
            this.f47785a = i6 - 1;
            return this.f47786b.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(q0<T> q0Var) {
            this.f47785a = ((q0) q0Var).f47784b;
            this.f47786b = ((q0) q0Var).f47783a.iterator();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q0(@NotNull m<? extends T> sequence, int i6) {
        kotlin.jvm.internal.g0.p(sequence, "sequence");
        this.f47783a = sequence;
        this.f47784b = i6;
        if (i6 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i6 + '.').toString());
    }

    @Override // kotlin.sequences.e
    @NotNull
    public m<T> a(int i6) {
        int i7 = this.f47784b;
        return i6 >= i7 ? x.l() : new p0(this.f47783a, i6, i7);
    }

    @Override // kotlin.sequences.e
    @NotNull
    public m<T> b(int i6) {
        return i6 >= this.f47784b ? this : new q0(this.f47783a, i6);
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}
