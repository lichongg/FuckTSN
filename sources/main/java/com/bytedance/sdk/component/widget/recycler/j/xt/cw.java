package com.bytedance.sdk.component.widget.recycler.j.xt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw<E> implements Cloneable {

    /* renamed from: j, reason: collision with root package name */
    private static final Object f27081j = new Object();
    private long[] cw;

    /* renamed from: r, reason: collision with root package name */
    private Object[] f27082r;
    private int up;
    private boolean xt;

    public cw() {
        this(10);
    }

    public E cw(int i6) {
        if (this.xt) {
            r();
        }
        return (E) this.f27082r[i6];
    }

    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public cw<E> clone() {
        try {
            cw<E> cwVar = (cw) super.clone();
            cwVar.cw = (long[]) this.cw.clone();
            cwVar.f27082r = (Object[]) this.f27082r.clone();
            return cwVar;
        } catch (CloneNotSupportedException e6) {
            throw new AssertionError(e6);
        }
    }

    public void xt(long j6, E e6) {
        int j7 = xt.j(this.cw, this.up, j6);
        if (j7 >= 0) {
            this.f27082r[j7] = e6;
            return;
        }
        int i6 = ~j7;
        int i7 = this.up;
        if (i6 < i7) {
            Object[] objArr = this.f27082r;
            if (objArr[i6] == f27081j) {
                this.cw[i6] = j6;
                objArr[i6] = e6;
                return;
            }
        }
        if (this.xt && i7 >= this.cw.length) {
            r();
            i6 = ~xt.j(this.cw, this.up, j6);
        }
        int i8 = this.up;
        if (i8 >= this.cw.length) {
            int j8 = xt.j(i8 + 1);
            long[] jArr = new long[j8];
            Object[] objArr2 = new Object[j8];
            long[] jArr2 = this.cw;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f27082r;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.cw = jArr;
            this.f27082r = objArr2;
        }
        int i9 = this.up;
        if (i9 - i6 != 0) {
            long[] jArr3 = this.cw;
            int i10 = i6 + 1;
            System.arraycopy(jArr3, i6, jArr3, i10, i9 - i6);
            Object[] objArr4 = this.f27082r;
            System.arraycopy(objArr4, i6, objArr4, i10, this.up - i6);
        }
        this.cw[i6] = j6;
        this.f27082r[i6] = e6;
        this.up++;
    }

    public cw(int i6) {
        this.xt = false;
        if (i6 == 0) {
            this.cw = xt.xt;
            this.f27082r = xt.cw;
        } else {
            int j6 = xt.j(i6);
            this.cw = new long[j6];
            this.f27082r = new Object[j6];
        }
        this.up = 0;
    }

    private void r() {
        int i6 = this.up;
        long[] jArr = this.cw;
        Object[] objArr = this.f27082r;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            Object obj = objArr[i8];
            if (obj != f27081j) {
                if (i8 != i7) {
                    jArr[i7] = jArr[i8];
                    objArr[i7] = obj;
                    objArr[i8] = null;
                }
                i7++;
            }
        }
        this.xt = false;
        this.up = i7;
    }

    public void delete(long j6) {
        int j7 = xt.j(this.cw, this.up, j6);
        if (j7 >= 0) {
            Object[] objArr = this.f27082r;
            Object obj = objArr[j7];
            Object obj2 = f27081j;
            if (obj != obj2) {
                objArr[j7] = obj2;
                this.xt = true;
            }
        }
    }

    public String toString() {
        if (xt() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.up * 28);
        sb.append('{');
        for (int i6 = 0; i6 < this.up; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(xt(i6));
            sb.append('=');
            E cw = cw(i6);
            if (cw != this) {
                sb.append(cw);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public void cw() {
        int i6 = this.up;
        Object[] objArr = this.f27082r;
        for (int i7 = 0; i7 < i6; i7++) {
            objArr[i7] = null;
        }
        this.up = 0;
        this.xt = false;
    }

    public E j(long j6) {
        return j(j6, null);
    }

    public E j(long j6, E e6) {
        E e7;
        int j7 = xt.j(this.cw, this.up, j6);
        return (j7 < 0 || (e7 = (E) this.f27082r[j7]) == f27081j) ? e6 : e7;
    }

    public void j(int i6) {
        Object[] objArr = this.f27082r;
        Object obj = objArr[i6];
        Object obj2 = f27081j;
        if (obj != obj2) {
            objArr[i6] = obj2;
            this.xt = true;
        }
    }

    public int xt() {
        if (this.xt) {
            r();
        }
        return this.up;
    }

    public long xt(int i6) {
        if (this.xt) {
            r();
        }
        return this.cw[i6];
    }
}
