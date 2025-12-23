package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f<T> implements m<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final m<T> f47663a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Function1<T, Boolean> f47664b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements Iterator<T>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator<T> f47665a;

        /* renamed from: b, reason: collision with root package name */
        private int f47666b = -1;

        /* renamed from: c, reason: collision with root package name */
        private T f47667c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f<T> f47668d;

        a(f<T> fVar) {
            this.f47668d = fVar;
            this.f47665a = ((f) fVar).f47663a.iterator();
        }

        private final void a() {
            while (this.f47665a.hasNext()) {
                T next = this.f47665a.next();
                if (!((Boolean) ((f) this.f47668d).f47664b.invoke(next)).booleanValue()) {
                    this.f47667c = next;
                    this.f47666b = 1;
                    return;
                }
            }
            this.f47666b = 0;
        }

        public final int c() {
            return this.f47666b;
        }

        public final Iterator<T> e() {
            return this.f47665a;
        }

        public final T f() {
            return this.f47667c;
        }

        public final void g(int i6) {
            this.f47666b = i6;
        }

        public final void h(T t5) {
            this.f47667c = t5;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f47666b == -1) {
                a();
            }
            return this.f47666b == 1 || this.f47665a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f47666b == -1) {
                a();
            }
            if (this.f47666b != 1) {
                return this.f47665a.next();
            }
            T t5 = this.f47667c;
            this.f47667c = null;
            this.f47666b = 0;
            return t5;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@NotNull m<? extends T> sequence, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sequence, "sequence");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        this.f47663a = sequence;
        this.f47664b = predicate;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}
