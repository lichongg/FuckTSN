package com.bytedance.adsdk.lottie;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes3.dex */
abstract class az<K, V> {
    az<K, V>.xt xt;

    final class j<T> implements Iterator<T> {
        int cw;

        /* renamed from: j, reason: collision with root package name */
        final int f23217j;

        /* renamed from: r, reason: collision with root package name */
        boolean f23218r = false;
        int xt;

        j(int i6) {
            this.f23217j = i6;
            this.xt = az.this.j();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cw < this.xt;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f23218r) {
                throw new IllegalStateException();
            }
            int i6 = this.cw - 1;
            this.cw = i6;
            this.xt--;
            this.f23218r = false;
            az.this.j(i6);
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T t5 = (T) az.this.j(this.cw, this.f23217j);
                this.cw++;
                this.f23218r = true;
                return t5;
            }
            throw new NoSuchElementException();
        }
    }

    final class xt implements Set<K> {
        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return az.this.xt(0);
        }

        xt() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k6) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            az.this.cw();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return az.this.j(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return az.j(az.this.xt(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i6 = 0;
            for (int j6 = az.this.j() - 1; j6 >= 0; j6--) {
                Object j7 = az.this.j(j6, 0);
                i6 += j7 == null ? 0 : j7.hashCode();
            }
            return i6;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return az.this.j() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new j(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int j6 = az.this.j(obj);
            if (j6 < 0) {
                return false;
            }
            az.this.j(j6);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return az.xt(az.this.xt(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return az.cw(az.this.xt(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return az.this.j();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) az.this.j(tArr, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return az.j(this, obj);
        }
    }

    public static <K, V> boolean cw(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean xt(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    protected abstract void cw();

    protected abstract int j();

    protected abstract int j(Object obj);

    protected abstract Object j(int i6, int i7);

    protected abstract void j(int i6);

    protected abstract Map<K, V> xt();

    public Set<K> r() {
        if (this.xt == null) {
            this.xt = new xt();
        }
        return this.xt;
    }

    az() {
    }

    public <T> T[] j(T[] tArr, int i6) {
        int j6 = j();
        if (tArr.length < j6) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), j6));
        }
        for (int i7 = 0; i7 < j6; i7++) {
            tArr[i7] = j(i7, i6);
        }
        if (tArr.length > j6) {
            tArr[j6] = null;
        }
        return tArr;
    }

    public Object[] xt(int i6) {
        int j6 = j();
        Object[] objArr = new Object[j6];
        for (int i7 = 0; i7 < j6; i7++) {
            objArr[i7] = j(i7, i6);
        }
        return objArr;
    }

    public static <T> boolean j(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }
}
