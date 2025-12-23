package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class r1<T> extends h<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<T> f43680a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements ListIterator<T>, m3.f {

        /* renamed from: a, reason: collision with root package name */
        private final ListIterator<T> f43681a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ r1<T> f43682b;

        a(r1<T> r1Var, int i6) {
            int g12;
            this.f43682b = r1Var;
            List list = ((r1) r1Var).f43680a;
            g12 = n0.g1(r1Var, i6);
            this.f43681a = list.listIterator(g12);
        }

        public final ListIterator<T> a() {
            return this.f43681a;
        }

        @Override // java.util.ListIterator
        public void add(T t5) {
            this.f43681a.add(t5);
            this.f43681a.previous();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f43681a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f43681a.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            return this.f43681a.previous();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            int f12;
            f12 = n0.f1(this.f43682b, this.f43681a.previousIndex());
            return f12;
        }

        @Override // java.util.ListIterator
        public T previous() {
            return this.f43681a.next();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            int f12;
            f12 = n0.f1(this.f43682b, this.f43681a.nextIndex());
            return f12;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.f43681a.remove();
        }

        @Override // java.util.ListIterator
        public void set(T t5) {
            this.f43681a.set(t5);
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<T> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    public r1(@NotNull List<T> delegate) {
        kotlin.jvm.internal.g0.p(delegate, "delegate");
        this.f43680a = delegate;
    }

    @Override // kotlin.collections.h, java.util.AbstractList, java.util.List
    public void add(int i6, T t5) {
        int g12;
        List<T> list = this.f43680a;
        g12 = n0.g1(this, i6);
        list.add(g12, t5);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f43680a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i6) {
        int e12;
        List<T> list = this.f43680a;
        e12 = n0.e1(this, i6);
        return list.get(e12);
    }

    @Override // kotlin.collections.h
    public int getSize() {
        return this.f43680a.size();
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<T> listIterator(int i6) {
        return new a(this, i6);
    }

    @Override // kotlin.collections.h
    public T removeAt(int i6) {
        int e12;
        List<T> list = this.f43680a;
        e12 = n0.e1(this, i6);
        return list.remove(e12);
    }

    @Override // kotlin.collections.h, java.util.AbstractList, java.util.List
    public T set(int i6, T t5) {
        int e12;
        List<T> list = this.f43680a;
        e12 = n0.e1(this, i6);
        return list.set(e12, t5);
    }
}
