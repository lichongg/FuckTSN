package kotlin.reflect.jvm.internal.impl.utils;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class j<E> extends AbstractList<E> implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private int f47487a;

    /* renamed from: b, reason: collision with root package name */
    private Object f47488b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        private static final b f47489a = new b();

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        public static <T> b<T> a() {
            return f47489a;
        }

        @Override // java.util.Iterator
        public T next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }

        private b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c extends d<E> {

        /* renamed from: b, reason: collision with root package name */
        private final int f47490b;

        public c() {
            super();
            this.f47490b = ((AbstractList) j.this).modCount;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.j.d
        protected void a() {
            if (((AbstractList) j.this).modCount == this.f47490b) {
                return;
            }
            throw new ConcurrentModificationException("ModCount: " + ((AbstractList) j.this).modCount + "; expected: " + this.f47490b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.j.d
        protected E b() {
            return (E) j.this.f47488b;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            j.this.clear();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class d<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        private boolean f47492a;

        private d() {
        }

        protected abstract void a();

        protected abstract T b();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.f47492a;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (this.f47492a) {
                throw new NoSuchElementException();
            }
            this.f47492a = true;
            a();
            return b();
        }
    }

    private static /* synthetic */ void a(int i6) {
        String str = (i6 == 2 || i6 == 3 || i6 == 5 || i6 == 6 || i6 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 2 || i6 == 3 || i6 == 5 || i6 == 6 || i6 == 7) ? 2 : 3];
        switch (i6) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = "a";
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        if (i6 == 2 || i6 == 3) {
            objArr[1] = "iterator";
        } else if (i6 == 5 || i6 == 6 || i6 == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i6) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i6 != 2 && i6 != 3 && i6 != 5 && i6 != 6 && i6 != 7) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e6) {
        int i6 = this.f47487a;
        if (i6 == 0) {
            this.f47488b = e6;
        } else if (i6 == 1) {
            this.f47488b = new Object[]{this.f47488b, e6};
        } else {
            Object[] objArr = (Object[]) this.f47488b;
            int length = objArr.length;
            if (i6 >= length) {
                int i7 = ((length * 3) / 2) + 1;
                int i8 = i6 + 1;
                if (i7 < i8) {
                    i7 = i8;
                }
                Object[] objArr2 = new Object[i7];
                this.f47488b = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.f47487a] = e6;
        }
        this.f47487a++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f47488b = null;
        this.f47487a = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i6) {
        int i7;
        if (i6 >= 0 && i6 < (i7 = this.f47487a)) {
            return i7 == 1 ? (E) this.f47488b : (E) ((Object[]) this.f47488b)[i6];
        }
        throw new IndexOutOfBoundsException("Index: " + i6 + ", Size: " + this.f47487a);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<E> iterator() {
        int i6 = this.f47487a;
        if (i6 == 0) {
            b a6 = b.a();
            if (a6 == null) {
                a(2);
            }
            return a6;
        }
        if (i6 == 1) {
            return new c();
        }
        Iterator<E> it = super.iterator();
        if (it == null) {
            a(3);
        }
        return it;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i6) {
        int i7;
        E e6;
        if (i6 < 0 || i6 >= (i7 = this.f47487a)) {
            throw new IndexOutOfBoundsException("Index: " + i6 + ", Size: " + this.f47487a);
        }
        if (i7 == 1) {
            e6 = (E) this.f47488b;
            this.f47488b = null;
        } else {
            Object[] objArr = (Object[]) this.f47488b;
            Object obj = objArr[i6];
            if (i7 == 2) {
                this.f47488b = objArr[1 - i6];
            } else {
                int i8 = (i7 - i6) - 1;
                if (i8 > 0) {
                    System.arraycopy(objArr, i6 + 1, objArr, i6, i8);
                }
                objArr[this.f47487a - 1] = null;
            }
            e6 = (E) obj;
        }
        this.f47487a--;
        ((AbstractList) this).modCount++;
        return e6;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i6, E e6) {
        int i7;
        if (i6 < 0 || i6 >= (i7 = this.f47487a)) {
            throw new IndexOutOfBoundsException("Index: " + i6 + ", Size: " + this.f47487a);
        }
        if (i7 == 1) {
            E e7 = (E) this.f47488b;
            this.f47488b = e6;
            return e7;
        }
        Object[] objArr = (Object[]) this.f47488b;
        E e8 = (E) objArr[i6];
        objArr[i6] = e6;
        return e8;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f47487a;
    }

    @Override // java.util.List
    public void sort(Comparator<? super E> comparator) {
        int i6 = this.f47487a;
        if (i6 >= 2) {
            Arrays.sort((Object[]) this.f47488b, 0, i6, comparator);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        if (tArr == 0) {
            a(4);
        }
        int length = tArr.length;
        int i6 = this.f47487a;
        if (i6 == 1) {
            if (length == 0) {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
                tArr2[0] = this.f47488b;
                return tArr2;
            }
            tArr[0] = this.f47488b;
        } else {
            if (length < i6) {
                T[] tArr3 = (T[]) Arrays.copyOf((Object[]) this.f47488b, i6, tArr.getClass());
                if (tArr3 == null) {
                    a(6);
                }
                return tArr3;
            }
            if (i6 != 0) {
                System.arraycopy(this.f47488b, 0, tArr, 0, i6);
            }
        }
        int i7 = this.f47487a;
        if (length > i7) {
            tArr[i7] = 0;
        }
        return tArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i6, E e6) {
        int i7;
        if (i6 >= 0 && i6 <= (i7 = this.f47487a)) {
            if (i7 == 0) {
                this.f47488b = e6;
            } else if (i7 == 1 && i6 == 0) {
                this.f47488b = new Object[]{e6, this.f47488b};
            } else {
                Object[] objArr = new Object[i7 + 1];
                if (i7 == 1) {
                    objArr[0] = this.f47488b;
                } else {
                    Object[] objArr2 = (Object[]) this.f47488b;
                    System.arraycopy(objArr2, 0, objArr, 0, i6);
                    System.arraycopy(objArr2, i6, objArr, i6 + 1, this.f47487a - i6);
                }
                objArr[i6] = e6;
                this.f47488b = objArr;
            }
            this.f47487a++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("Index: " + i6 + ", Size: " + this.f47487a);
    }
}
