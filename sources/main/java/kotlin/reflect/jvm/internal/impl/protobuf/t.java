package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class t extends AbstractList<String> implements RandomAccess, l {

    /* renamed from: a, reason: collision with root package name */
    private final l f46554a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ListIterator<String> {

        /* renamed from: a, reason: collision with root package name */
        ListIterator<String> f46555a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f46556b;

        a(int i6) {
            this.f46556b = i6;
            this.f46555a = t.this.f46554a.listIterator(i6);
        }

        @Override // java.util.ListIterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            return this.f46555a.next();
        }

        @Override // java.util.ListIterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String previous() {
            return this.f46555a.previous();
        }

        @Override // java.util.ListIterator
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f46555a.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f46555a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f46555a.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f46555a.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Iterator<String> {

        /* renamed from: a, reason: collision with root package name */
        Iterator<String> f46558a;

        b() {
            this.f46558a = t.this.f46554a.iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            return this.f46558a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f46558a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public String get(int i6) {
        return this.f46554a.get(i6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public List<?> h() {
        return this.f46554a.h();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public d i(int i6) {
        return this.f46554a.i(i6);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public void k(d dVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i6) {
        return new a(i6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f46554a.size();
    }

    public t(l lVar) {
        this.f46554a = lVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public l c() {
        return this;
    }
}
