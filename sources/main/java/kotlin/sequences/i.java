package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i<T, R, E> implements m<E> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final m<T> f47679a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Function1<T, R> f47680b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Function1<R, Iterator<E>> f47681c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements Iterator<E>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator<T> f47686a;

        /* renamed from: b, reason: collision with root package name */
        private Iterator<? extends E> f47687b;

        /* renamed from: c, reason: collision with root package name */
        private int f47688c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ i<T, R, E> f47689d;

        b(i<T, R, E> iVar) {
            this.f47689d = iVar;
            this.f47686a = ((i) iVar).f47679a.iterator();
        }

        private final boolean a() {
            Iterator<? extends E> it = this.f47687b;
            if (it != null && it.hasNext()) {
                this.f47688c = 1;
                return true;
            }
            while (this.f47686a.hasNext()) {
                Iterator<? extends E> it2 = (Iterator) ((i) this.f47689d).f47681c.invoke(((i) this.f47689d).f47680b.invoke(this.f47686a.next()));
                if (it2.hasNext()) {
                    this.f47687b = it2;
                    this.f47688c = 1;
                    return true;
                }
            }
            this.f47688c = 2;
            this.f47687b = null;
            return false;
        }

        public final Iterator<E> c() {
            return this.f47687b;
        }

        public final Iterator<T> e() {
            return this.f47686a;
        }

        public final int f() {
            return this.f47688c;
        }

        public final void g(Iterator<? extends E> it) {
            this.f47687b = it;
        }

        public final void h(int i6) {
            this.f47688c = i6;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i6 = this.f47688c;
            if (i6 == 1) {
                return true;
            }
            if (i6 == 2) {
                return false;
            }
            return a();
        }

        @Override // java.util.Iterator
        public E next() {
            int i6 = this.f47688c;
            if (i6 == 2) {
                throw new NoSuchElementException();
            }
            if (i6 == 0 && !a()) {
                throw new NoSuchElementException();
            }
            this.f47688c = 0;
            Iterator<? extends E> it = this.f47687b;
            kotlin.jvm.internal.g0.m(it);
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f47682a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final int f47683b = 0;

        /* renamed from: c, reason: collision with root package name */
        public static final int f47684c = 1;

        /* renamed from: d, reason: collision with root package name */
        public static final int f47685d = 2;

        private a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(@NotNull m<? extends T> sequence, @NotNull Function1<? super T, ? extends R> transformer, @NotNull Function1<? super R, ? extends Iterator<? extends E>> iterator) {
        kotlin.jvm.internal.g0.p(sequence, "sequence");
        kotlin.jvm.internal.g0.p(transformer, "transformer");
        kotlin.jvm.internal.g0.p(iterator, "iterator");
        this.f47679a = sequence;
        this.f47680b = transformer;
        this.f47681c = iterator;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<E> iterator() {
        return new b(this);
    }
}
