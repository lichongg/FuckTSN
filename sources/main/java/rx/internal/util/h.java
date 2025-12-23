package rx.internal.util;

import defpackage.H5BaseWebChromeClient;
import java.util.Arrays;
import rx.internal.util.unsafe.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h<T> {

    /* renamed from: f, reason: collision with root package name */
    private static final int f54154f = -1640531527;

    /* renamed from: a, reason: collision with root package name */
    final float f54155a;

    /* renamed from: b, reason: collision with root package name */
    int f54156b;

    /* renamed from: c, reason: collision with root package name */
    int f54157c;

    /* renamed from: d, reason: collision with root package name */
    int f54158d;

    /* renamed from: e, reason: collision with root package name */
    T[] f54159e;

    public h() {
        this(16, 0.75f);
    }

    public void h() {
        this.f54157c = 0;
        this.f54159e = (T[]) new Object[0];
    }

    public h(int i6) {
        this(i6, 0.75f);
    }

    public boolean a(T t5) {
        T t6;
        T[] tArr = this.f54159e;
        int i6 = this.f54156b;
        int d6 = d(t5.hashCode()) & i6;
        T t7 = tArr[d6];
        if (t7 != null) {
            if (t7.equals(t5)) {
                return false;
            }
            do {
                d6 = (d6 + 1) & i6;
                t6 = tArr[d6];
                if (t6 == null) {
                }
            } while (!t6.equals(t5));
            return false;
        }
        tArr[d6] = t5;
        int i7 = this.f54157c + 1;
        this.f54157c = i7;
        if (i7 >= this.f54158d) {
            e();
        }
        return true;
    }

    public void b(rx.functions.b<? super T> bVar) {
        if (this.f54157c == 0) {
            return;
        }
        T[] tArr = this.f54159e;
        for (H5BaseWebChromeClient h5BaseWebChromeClient : tArr) {
            if (h5BaseWebChromeClient != null) {
                bVar.call(h5BaseWebChromeClient);
            }
        }
        Arrays.fill(tArr, (Object) null);
        this.f54157c = 0;
    }

    public boolean c() {
        return this.f54157c == 0;
    }

    void e() {
        T t5;
        T[] tArr = this.f54159e;
        int length = tArr.length;
        int i6 = length << 1;
        int i7 = i6 - 1;
        T[] tArr2 = (T[]) new Object[i6];
        int i8 = this.f54157c;
        while (true) {
            int i9 = i8 - 1;
            if (i8 == 0) {
                this.f54156b = i7;
                this.f54158d = (int) (i6 * this.f54155a);
                this.f54159e = tArr2;
                return;
            }
            do {
                length--;
                t5 = tArr[length];
            } while (t5 == null);
            int d6 = d(t5.hashCode()) & i7;
            if (tArr2[d6] != null) {
                do {
                    d6 = (d6 + 1) & i7;
                } while (tArr2[d6] != null);
            }
            tArr2[d6] = tArr[length];
            i8 = i9;
        }
    }

    public boolean f(T t5) {
        T t6;
        T[] tArr = this.f54159e;
        int i6 = this.f54156b;
        int d6 = d(t5.hashCode()) & i6;
        T t7 = tArr[d6];
        if (t7 == null) {
            return false;
        }
        if (t7.equals(t5)) {
            return g(d6, tArr, i6);
        }
        do {
            d6 = (d6 + 1) & i6;
            t6 = tArr[d6];
            if (t6 == null) {
                return false;
            }
        } while (!t6.equals(t5));
        return g(d6, tArr, i6);
    }

    boolean g(int i6, T[] tArr, int i7) {
        int i8;
        T t5;
        this.f54157c--;
        while (true) {
            int i9 = i6 + 1;
            while (true) {
                i8 = i9 & i7;
                t5 = tArr[i8];
                if (t5 == null) {
                    tArr[i6] = null;
                    return true;
                }
                int d6 = d(t5.hashCode()) & i7;
                if (i6 > i8) {
                    if (i6 >= d6 && d6 > i8) {
                        break;
                    }
                    i9 = i8 + 1;
                } else if (i6 < d6 && d6 <= i8) {
                    i9 = i8 + 1;
                }
            }
            tArr[i6] = t5;
            i6 = i8;
        }
    }

    public T[] i() {
        return this.f54159e;
    }

    public h(int i6, float f6) {
        this.f54155a = f6;
        int b6 = p.b(i6);
        this.f54156b = b6 - 1;
        this.f54158d = (int) (f6 * b6);
        this.f54159e = (T[]) new Object[b6];
    }

    static int d(int i6) {
        int i7 = i6 * f54154f;
        return i7 ^ (i7 >>> 16);
    }
}
