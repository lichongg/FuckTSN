package com.bytedance.sdk.component.widget.recycler.j.xt;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up<K, V> {
    static Object[] cw;

    /* renamed from: j, reason: collision with root package name */
    static Object[] f27084j;

    /* renamed from: r, reason: collision with root package name */
    static int f27085r;
    static int xt;
    int[] up = xt.f27087j;

    /* renamed from: m, reason: collision with root package name */
    Object[] f27086m = xt.cw;
    int ae = 0;

    private static int j(int[] iArr, int i6, int i7) {
        try {
            return xt.j(iArr, i6, i7);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof up) {
            up upVar = (up) obj;
            if (size() != upVar.size()) {
                return false;
            }
            for (int i6 = 0; i6 < this.ae; i6++) {
                try {
                    K j6 = j(i6);
                    V xt2 = xt(i6);
                    Object obj2 = upVar.get(j6);
                    if (xt2 == null) {
                        if (obj2 != null || !upVar.containsKey(j6)) {
                            return false;
                        }
                    } else if (!xt2.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        for (int i7 = 0; i7 < this.ae; i7++) {
            try {
                K j7 = j(i7);
                V xt3 = xt(i7);
                Object obj3 = map.get(j7);
                if (xt3 == null) {
                    if (obj3 != null || !map.containsKey(j7)) {
                        return false;
                    }
                } else if (!xt3.equals(obj3)) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException unused2) {
                return false;
            }
        }
        return true;
    }

    int xt(Object obj) {
        int i6 = this.ae * 2;
        Object[] objArr = this.f27086m;
        if (obj == null) {
            for (int i7 = 1; i7 < i6; i7 += 2) {
                if (objArr[i7] == null) {
                    return i7 >> 1;
                }
            }
            return -1;
        }
        for (int i8 = 1; i8 < i6; i8 += 2) {
            if (obj.equals(objArr[i8])) {
                return i8 >> 1;
            }
        }
        return -1;
    }

    private void r(int i6) {
        if (i6 == 8) {
            synchronized (j.class) {
                try {
                    Object[] objArr = cw;
                    if (objArr != null) {
                        this.f27086m = objArr;
                        cw = (Object[]) objArr[0];
                        this.up = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f27085r--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i6 == 4) {
            synchronized (j.class) {
                try {
                    Object[] objArr2 = f27084j;
                    if (objArr2 != null) {
                        this.f27086m = objArr2;
                        f27084j = (Object[]) objArr2[0];
                        this.up = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        xt--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.up = new int[i6];
        this.f27086m = new Object[i6 << 1];
    }

    public void clear() {
        int i6 = this.ae;
        if (i6 > 0) {
            int[] iArr = this.up;
            Object[] objArr = this.f27086m;
            this.up = xt.f27087j;
            this.f27086m = xt.cw;
            this.ae = 0;
            j(iArr, objArr, i6);
        }
        if (this.ae > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public V cw(int i6) {
        Object[] objArr = this.f27086m;
        int i7 = i6 << 1;
        V v5 = (V) objArr[i7 + 1];
        int i8 = this.ae;
        int i9 = 0;
        if (i8 <= 1) {
            j(this.up, objArr, i8);
            this.up = xt.f27087j;
            this.f27086m = xt.cw;
        } else {
            int i10 = i8 - 1;
            int[] iArr = this.up;
            if (iArr.length <= 8 || i8 >= iArr.length / 3) {
                if (i6 < i10) {
                    int i11 = i6 + 1;
                    int i12 = i10 - i6;
                    System.arraycopy(iArr, i11, iArr, i6, i12);
                    Object[] objArr2 = this.f27086m;
                    System.arraycopy(objArr2, i11 << 1, objArr2, i7, i12 << 1);
                }
                Object[] objArr3 = this.f27086m;
                int i13 = i10 << 1;
                objArr3[i13] = null;
                objArr3[i13 + 1] = null;
            } else {
                r(i8 > 8 ? i8 + (i8 >> 1) : 8);
                if (i8 != this.ae) {
                    throw new ConcurrentModificationException();
                }
                if (i6 > 0) {
                    System.arraycopy(iArr, 0, this.up, 0, i6);
                    System.arraycopy(objArr, 0, this.f27086m, 0, i7);
                }
                if (i6 < i10) {
                    int i14 = i6 + 1;
                    int i15 = i10 - i6;
                    System.arraycopy(iArr, i14, this.up, i6, i15);
                    System.arraycopy(objArr, i14 << 1, this.f27086m, i7, i15 << 1);
                }
            }
            i9 = i10;
        }
        if (i8 != this.ae) {
            throw new ConcurrentModificationException();
        }
        this.ae = i9;
        return v5;
    }

    public int hashCode() {
        int[] iArr = this.up;
        Object[] objArr = this.f27086m;
        int i6 = this.ae;
        int i7 = 1;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i6) {
            Object obj = objArr[i7];
            i9 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i8];
            i8++;
            i7 += 2;
        }
        return i9;
    }

    public boolean isEmpty() {
        return this.ae <= 0;
    }

    public V put(K k6, V v5) {
        int i6;
        int j6;
        int i7 = this.ae;
        if (k6 == null) {
            j6 = j();
            i6 = 0;
        } else {
            int hashCode = k6.hashCode();
            i6 = hashCode;
            j6 = j(k6, hashCode);
        }
        if (j6 >= 0) {
            int i8 = (j6 << 1) + 1;
            Object[] objArr = this.f27086m;
            V v6 = (V) objArr[i8];
            objArr[i8] = v5;
            return v6;
        }
        int i9 = ~j6;
        int[] iArr = this.up;
        if (i7 >= iArr.length) {
            int i10 = 8;
            if (i7 >= 8) {
                i10 = (i7 >> 1) + i7;
            } else if (i7 < 4) {
                i10 = 4;
            }
            Object[] objArr2 = this.f27086m;
            r(i10);
            if (i7 != this.ae) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.up;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f27086m, 0, objArr2.length);
            }
            j(iArr, objArr2, i7);
        }
        if (i9 < i7) {
            int[] iArr3 = this.up;
            int i11 = i9 + 1;
            System.arraycopy(iArr3, i9, iArr3, i11, i7 - i9);
            Object[] objArr3 = this.f27086m;
            System.arraycopy(objArr3, i9 << 1, objArr3, i11 << 1, (this.ae - i9) << 1);
        }
        int i12 = this.ae;
        if (i7 == i12) {
            int[] iArr4 = this.up;
            if (i9 < iArr4.length) {
                iArr4[i9] = i6;
                Object[] objArr4 = this.f27086m;
                int i13 = i9 << 1;
                objArr4[i13] = k6;
                objArr4[i13 + 1] = v5;
                this.ae = i12 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public int size() {
        return this.ae;
    }

    public boolean containsKey(Object obj) {
        if (j(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        if (xt(obj) >= 0) {
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        int j6 = j(obj);
        if (j6 >= 0) {
            return (V) this.f27086m[(j6 << 1) + 1];
        }
        return null;
    }

    int j(Object obj, int i6) {
        int i7 = this.ae;
        if (i7 == 0) {
            return -1;
        }
        int j6 = j(this.up, i7, i6);
        if (j6 < 0 || obj.equals(this.f27086m[j6 << 1])) {
            return j6;
        }
        int i8 = j6 + 1;
        while (i8 < i7 && this.up[i8] == i6) {
            if (obj.equals(this.f27086m[i8 << 1])) {
                return i8;
            }
            i8++;
        }
        for (int i9 = j6 - 1; i9 >= 0 && this.up[i9] == i6; i9--) {
            if (obj.equals(this.f27086m[i9 << 1])) {
                return i9;
            }
        }
        return ~i8;
    }

    public V remove(Object obj) {
        int j6 = j(obj);
        if (j6 >= 0) {
            return cw(j6);
        }
        return null;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.ae * 28);
        sb.append('{');
        for (int i6 = 0; i6 < this.ae; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            K j6 = j(i6);
            if (j6 != this) {
                sb.append(j6);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V xt2 = xt(i6);
            if (xt2 != this) {
                sb.append(xt2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public V xt(int i6) {
        return (V) this.f27086m[(i6 << 1) + 1];
    }

    int j() {
        int i6 = this.ae;
        if (i6 == 0) {
            return -1;
        }
        int j6 = j(this.up, i6, 0);
        if (j6 < 0 || this.f27086m[j6 << 1] == null) {
            return j6;
        }
        int i7 = j6 + 1;
        while (i7 < i6 && this.up[i7] == 0) {
            if (this.f27086m[i7 << 1] == null) {
                return i7;
            }
            i7++;
        }
        for (int i8 = j6 - 1; i8 >= 0 && this.up[i8] == 0; i8--) {
            if (this.f27086m[i8 << 1] == null) {
                return i8;
            }
        }
        return ~i7;
    }

    private static void j(int[] iArr, Object[] objArr, int i6) {
        if (iArr.length == 8) {
            synchronized (j.class) {
                try {
                    if (f27085r < 10) {
                        objArr[0] = cw;
                        objArr[1] = iArr;
                        for (int i7 = (i6 << 1) - 1; i7 >= 2; i7--) {
                            objArr[i7] = null;
                        }
                        cw = objArr;
                        f27085r++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (j.class) {
                try {
                    if (xt < 10) {
                        objArr[0] = f27084j;
                        objArr[1] = iArr;
                        for (int i8 = (i6 << 1) - 1; i8 >= 2; i8--) {
                            objArr[i8] = null;
                        }
                        f27084j = objArr;
                        xt++;
                    }
                } finally {
                }
            }
        }
    }

    public int j(Object obj) {
        return obj == null ? j() : j(obj, obj.hashCode());
    }

    public K j(int i6) {
        return (K) this.f27086m[i6 << 1];
    }
}
