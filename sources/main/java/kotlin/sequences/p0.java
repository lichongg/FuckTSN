package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SubSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,731:1\n1#2:732\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p0<T> implements m<T>, e<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final m<T> f47770a;

    /* renamed from: b, reason: collision with root package name */
    private final int f47771b;

    /* renamed from: c, reason: collision with root package name */
    private final int f47772c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements Iterator<T>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator<T> f47773a;

        /* renamed from: b, reason: collision with root package name */
        private int f47774b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ p0<T> f47775c;

        a(p0<T> p0Var) {
            this.f47775c = p0Var;
            this.f47773a = ((p0) p0Var).f47770a.iterator();
        }

        private final void a() {
            while (this.f47774b < ((p0) this.f47775c).f47771b && this.f47773a.hasNext()) {
                this.f47773a.next();
                this.f47774b++;
            }
        }

        public final Iterator<T> c() {
            return this.f47773a;
        }

        public final int e() {
            return this.f47774b;
        }

        public final void f(int i6) {
            this.f47774b = i6;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            if (this.f47774b < ((p0) this.f47775c).f47772c && this.f47773a.hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (this.f47774b < ((p0) this.f47775c).f47772c) {
                this.f47774b++;
                return this.f47773a.next();
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p0(@NotNull m<? extends T> sequence, int i6, int i7) {
        kotlin.jvm.internal.g0.p(sequence, "sequence");
        this.f47770a = sequence;
        this.f47771b = i6;
        this.f47772c = i7;
        if (i6 < 0) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i6).toString());
        }
        if (i7 < 0) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i7).toString());
        }
        if (i7 >= i6) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i7 + " < " + i6).toString());
    }

    private final int f() {
        return this.f47772c - this.f47771b;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }

    @Override // kotlin.sequences.e
    @NotNull
    public m<T> a(int i6) {
        if (i6 >= f()) {
            return x.l();
        }
        return new p0(this.f47770a, this.f47771b + i6, this.f47772c);
    }

    @Override // kotlin.sequences.e
    @NotNull
    public m<T> b(int i6) {
        if (i6 >= f()) {
            return this;
        }
        m<T> mVar = this.f47770a;
        int i7 = this.f47771b;
        return new p0(mVar, i7, i6 + i7);
    }
}
