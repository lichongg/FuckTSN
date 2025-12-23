package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class s1<T> extends d<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<T> f43684a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements ListIterator<T>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        private final ListIterator<T> f43685a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ s1<T> f43686b;

        /* JADX WARN: Multi-variable type inference failed */
        a(s1<? extends T> s1Var, int i6) {
            int g12;
            this.f43686b = s1Var;
            List list = ((s1) s1Var).f43684a;
            g12 = n0.g1(s1Var, i6);
            this.f43685a = list.listIterator(g12);
        }

        public final ListIterator<T> a() {
            return this.f43685a;
        }

        @Override // java.util.ListIterator
        public void add(T t5) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f43685a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f43685a.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            return this.f43685a.previous();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            int f12;
            f12 = n0.f1(this.f43686b, this.f43685a.previousIndex());
            return f12;
        }

        @Override // java.util.ListIterator
        public T previous() {
            return this.f43685a.next();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            int f12;
            f12 = n0.f1(this.f43686b, this.f43685a.nextIndex());
            return f12;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public void set(T t5) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // kotlin.collections.d, kotlin.collections.b, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return listIterator(0);
    }

    @Override // kotlin.collections.d, java.util.List
    @NotNull
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s1(@NotNull List<? extends T> delegate) {
        kotlin.jvm.internal.g0.p(delegate, "delegate");
        this.f43684a = delegate;
    }

    @Override // kotlin.collections.d, java.util.List
    public T get(int i6) {
        int e12;
        List<T> list = this.f43684a;
        e12 = n0.e1(this, i6);
        return list.get(e12);
    }

    @Override // kotlin.collections.d, kotlin.collections.b
    public int getSize() {
        return this.f43684a.size();
    }

    @Override // kotlin.collections.d, java.util.List
    @NotNull
    public ListIterator<T> listIterator(int i6) {
        return new a(this, i6);
    }
}
