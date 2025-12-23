package com.bytedance.adsdk.lottie;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class j<E> implements Collection<E>, Set<E> {
    private static Object[] ae;

    /* renamed from: m, reason: collision with root package name */
    private static int f23235m;
    private static int tl;
    private static Object[] up;

    /* renamed from: g, reason: collision with root package name */
    private int[] f23237g;

    /* renamed from: j, reason: collision with root package name */
    Object[] f23238j;
    private az<E, E> oq;
    int xt;
    private static final int[] cw = new int[0];

    /* renamed from: r, reason: collision with root package name */
    private static final Object[] f23236r = new Object[0];

    public j() {
        this(0);
    }

    private int j(Object obj, int i6) {
        int i7 = this.xt;
        if (i7 == 0) {
            return -1;
        }
        int j6 = xt.j(this.f23237g, i7, i6);
        if (j6 < 0 || obj.equals(this.f23238j[j6])) {
            return j6;
        }
        int i8 = j6 + 1;
        while (i8 < i7 && this.f23237g[i8] == i6) {
            if (obj.equals(this.f23238j[i8])) {
                return i8;
            }
            i8++;
        }
        for (int i9 = j6 - 1; i9 >= 0 && this.f23237g[i9] == i6; i9--) {
            if (obj.equals(this.f23238j[i9])) {
                return i9;
            }
        }
        return ~i8;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e6) {
        int i6;
        int j6;
        if (e6 == null) {
            j6 = j();
            i6 = 0;
        } else {
            int hashCode = e6.hashCode();
            i6 = hashCode;
            j6 = j(e6, hashCode);
        }
        if (j6 >= 0) {
            return false;
        }
        int i7 = ~j6;
        int i8 = this.xt;
        int[] iArr = this.f23237g;
        if (i8 >= iArr.length) {
            int i9 = 8;
            if (i8 >= 8) {
                i9 = (i8 >> 1) + i8;
            } else if (i8 < 4) {
                i9 = 4;
            }
            Object[] objArr = this.f23238j;
            r(i9);
            int[] iArr2 = this.f23237g;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f23238j, 0, objArr.length);
            }
            j(iArr, objArr, this.xt);
        }
        int i10 = this.xt;
        if (i7 < i10) {
            int[] iArr3 = this.f23237g;
            int i11 = i7 + 1;
            System.arraycopy(iArr3, i7, iArr3, i11, i10 - i7);
            Object[] objArr2 = this.f23238j;
            System.arraycopy(objArr2, i7, objArr2, i11, this.xt - i7);
        }
        this.f23237g[i7] = i6;
        this.f23238j[i7] = e6;
        this.xt++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i6 = 0; i6 < this.xt; i6++) {
                try {
                    if (!set.contains(xt(i6))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i6 = this.xt;
        Object[] objArr = new Object[i6];
        System.arraycopy(this.f23238j, 0, objArr, 0, i6);
        return objArr;
    }

    public E xt(int i6) {
        return (E) this.f23238j[i6];
    }

    public j(int i6) {
        if (i6 == 0) {
            this.f23237g = cw;
            this.f23238j = f23236r;
        } else {
            r(i6);
        }
        this.xt = 0;
    }

    private void r(int i6) {
        if (i6 == 8) {
            synchronized (j.class) {
                try {
                    Object[] objArr = ae;
                    if (objArr != null) {
                        this.f23238j = objArr;
                        ae = (Object[]) objArr[0];
                        this.f23237g = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        tl--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i6 == 4) {
            synchronized (j.class) {
                try {
                    Object[] objArr2 = up;
                    if (objArr2 != null) {
                        this.f23238j = objArr2;
                        up = (Object[]) objArr2[0];
                        this.f23237g = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f23235m--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f23237g = new int[i6];
        this.f23238j = new Object[i6];
    }

    private az<E, E> xt() {
        if (this.oq == null) {
            this.oq = new az<E, E>() { // from class: com.bytedance.adsdk.lottie.j.1
                @Override // com.bytedance.adsdk.lottie.az
                protected int j() {
                    return j.this.xt;
                }

                @Override // com.bytedance.adsdk.lottie.az
                protected void cw() {
                    j.this.clear();
                }

                @Override // com.bytedance.adsdk.lottie.az
                protected Object j(int i6, int i7) {
                    return j.this.f23238j[i6];
                }

                @Override // com.bytedance.adsdk.lottie.az
                protected Map<E, E> xt() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // com.bytedance.adsdk.lottie.az
                protected int j(Object obj) {
                    return j.this.j(obj);
                }

                @Override // com.bytedance.adsdk.lottie.az
                protected void j(int i6) {
                    j.this.cw(i6);
                }
            };
        }
        return this.oq;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        j(this.xt + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            z5 |= add(it.next());
        }
        return z5;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i6 = this.xt;
        if (i6 != 0) {
            j(this.f23237g, this.f23238j, i6);
            this.f23237g = cw;
            this.f23238j = f23236r;
            this.xt = 0;
        }
    }

    public E cw(int i6) {
        Object[] objArr = this.f23238j;
        E e6 = (E) objArr[i6];
        int i7 = this.xt;
        if (i7 <= 1) {
            j(this.f23237g, objArr, i7);
            this.f23237g = cw;
            this.f23238j = f23236r;
            this.xt = 0;
            return e6;
        }
        int[] iArr = this.f23237g;
        if (iArr.length <= 8 || i7 >= iArr.length / 3) {
            int i8 = i7 - 1;
            this.xt = i8;
            if (i6 < i8) {
                int i9 = i6 + 1;
                System.arraycopy(iArr, i9, iArr, i6, i8 - i6);
                Object[] objArr2 = this.f23238j;
                System.arraycopy(objArr2, i9, objArr2, i6, this.xt - i6);
            }
            this.f23238j[this.xt] = null;
            return e6;
        }
        r(i7 > 8 ? i7 + (i7 >> 1) : 8);
        this.xt--;
        if (i6 > 0) {
            System.arraycopy(iArr, 0, this.f23237g, 0, i6);
            System.arraycopy(objArr, 0, this.f23238j, 0, i6);
        }
        int i10 = this.xt;
        if (i6 < i10) {
            int i11 = i6 + 1;
            System.arraycopy(iArr, i11, this.f23237g, i6, i10 - i6);
            System.arraycopy(objArr, i11, this.f23238j, i6, this.xt - i6);
        }
        return e6;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f23237g;
        int i6 = this.xt;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            i7 += iArr[i8];
        }
        return i7;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.xt <= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z5 = false;
        for (int i6 = this.xt - 1; i6 >= 0; i6--) {
            if (!collection.contains(this.f23238j[i6])) {
                cw(i6);
                z5 = true;
            }
        }
        return z5;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.xt;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (j(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return xt().r().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int j6 = j(obj);
        if (j6 >= 0) {
            cw(j6);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            z5 |= remove(it.next());
        }
        return z5;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.xt) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.xt));
        }
        System.arraycopy(this.f23238j, 0, tArr, 0, this.xt);
        int length = tArr.length;
        int i6 = this.xt;
        if (length > i6) {
            tArr[i6] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.xt * 14);
        sb.append('{');
        for (int i6 = 0; i6 < this.xt; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            E xt = xt(i6);
            if (xt != this) {
                sb.append(xt);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    private int j() {
        int i6 = this.xt;
        if (i6 == 0) {
            return -1;
        }
        int j6 = xt.j(this.f23237g, i6, 0);
        if (j6 < 0 || this.f23238j[j6] == null) {
            return j6;
        }
        int i7 = j6 + 1;
        while (i7 < i6 && this.f23237g[i7] == 0) {
            if (this.f23238j[i7] == null) {
                return i7;
            }
            i7++;
        }
        for (int i8 = j6 - 1; i8 >= 0 && this.f23237g[i8] == 0; i8--) {
            if (this.f23238j[i8] == null) {
                return i8;
            }
        }
        return ~i7;
    }

    private static void j(int[] iArr, Object[] objArr, int i6) {
        if (iArr.length == 8) {
            synchronized (j.class) {
                try {
                    if (tl < 10) {
                        objArr[0] = ae;
                        objArr[1] = iArr;
                        for (int i7 = i6 - 1; i7 >= 2; i7--) {
                            objArr[i7] = null;
                        }
                        ae = objArr;
                        tl++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (j.class) {
                try {
                    if (f23235m < 10) {
                        objArr[0] = up;
                        objArr[1] = iArr;
                        for (int i8 = i6 - 1; i8 >= 2; i8--) {
                            objArr[i8] = null;
                        }
                        up = objArr;
                        f23235m++;
                    }
                } finally {
                }
            }
        }
    }

    public void j(int i6) {
        int[] iArr = this.f23237g;
        if (iArr.length < i6) {
            Object[] objArr = this.f23238j;
            r(i6);
            int i7 = this.xt;
            if (i7 > 0) {
                System.arraycopy(iArr, 0, this.f23237g, 0, i7);
                System.arraycopy(objArr, 0, this.f23238j, 0, this.xt);
            }
            j(iArr, objArr, this.xt);
        }
    }

    public int j(Object obj) {
        return obj == null ? j() : j(obj, obj.hashCode());
    }
}
