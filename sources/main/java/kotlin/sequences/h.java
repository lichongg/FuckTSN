package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h<T> implements m<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final m<T> f47671a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f47672b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Function1<T, Boolean> f47673c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements Iterator<T>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator<T> f47674a;

        /* renamed from: b, reason: collision with root package name */
        private int f47675b = -1;

        /* renamed from: c, reason: collision with root package name */
        private T f47676c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ h<T> f47677d;

        a(h<T> hVar) {
            this.f47677d = hVar;
            this.f47674a = ((h) hVar).f47671a.iterator();
        }

        private final void a() {
            while (this.f47674a.hasNext()) {
                T next = this.f47674a.next();
                if (((Boolean) ((h) this.f47677d).f47673c.invoke(next)).booleanValue() == ((h) this.f47677d).f47672b) {
                    this.f47676c = next;
                    this.f47675b = 1;
                    return;
                }
            }
            this.f47675b = 0;
        }

        public final Iterator<T> c() {
            return this.f47674a;
        }

        public final T e() {
            return this.f47676c;
        }

        public final int f() {
            return this.f47675b;
        }

        public final void g(T t5) {
            this.f47676c = t5;
        }

        public final void h(int i6) {
            this.f47675b = i6;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f47675b == -1) {
                a();
            }
            return this.f47675b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f47675b == -1) {
                a();
            }
            if (this.f47675b == 0) {
                throw new NoSuchElementException();
            }
            T t5 = this.f47676c;
            this.f47676c = null;
            this.f47675b = -1;
            return t5;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(@NotNull m<? extends T> sequence, boolean z5, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sequence, "sequence");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        this.f47671a = sequence;
        this.f47672b = z5;
        this.f47673c = predicate;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }

    public /* synthetic */ h(m mVar, boolean z5, Function1 function1, int i6, kotlin.jvm.internal.v vVar) {
        this(mVar, (i6 & 2) != 0 ? true : z5, function1);
    }
}
