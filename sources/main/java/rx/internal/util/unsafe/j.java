package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressAnimalSniffer
/* loaded from: D:\Downloads\app\classes9.dex */
public class j<E> extends k<E> {
    long F0;
    long G0;
    long H0;
    long I0;
    long J0;
    long K0;
    long L0;
    long M0;
    long N0;
    long O0;
    long P0;
    long Q0;
    long R0;
    long S0;
    long T0;

    public j(int i6) {
        super(Math.max(2, i6));
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.i
    public boolean offer(E e6) {
        long[] jArr;
        j<E> jVar = this;
        if (e6 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        long j6 = jVar.f54246q + 1;
        long[] jArr2 = jVar.f54266w;
        long j7 = Long.MAX_VALUE;
        while (true) {
            long u5 = jVar.u();
            long j8 = j6;
            long q5 = jVar.q(u5);
            long r5 = jVar.r(jArr2, q5) - u5;
            if (r5 == 0) {
                long j9 = u5 + 1;
                if (jVar.t(u5, j9)) {
                    jVar.o(jVar.a(u5), e6);
                    jVar.s(jArr2, q5, j9);
                    return true;
                }
                jArr = jArr2;
            } else {
                jArr = jArr2;
                if (r5 < 0) {
                    long j10 = u5 - j8;
                    if (j10 <= j7) {
                        long w5 = w();
                        if (j10 <= w5) {
                            return false;
                        }
                        j7 = w5;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            jArr2 = jArr;
            j6 = j8;
            jVar = this;
        }
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.i
    public E poll() {
        j<E> jVar = this;
        long[] jArr = jVar.f54266w;
        long j6 = -1;
        while (true) {
            long w5 = jVar.w();
            long j7 = j6;
            long q5 = jVar.q(w5);
            long j8 = w5 + 1;
            long r5 = jVar.r(jArr, q5) - j8;
            if (r5 == 0) {
                if (jVar.v(w5, j8)) {
                    long a6 = jVar.a(w5);
                    E e6 = jVar.e(a6);
                    jVar.o(a6, null);
                    jVar.s(jArr, q5, w5 + jVar.f54246q + 1);
                    return e6;
                }
            } else if (r5 < 0 && w5 >= j7) {
                j6 = u();
                if (w5 == j6) {
                    return null;
                }
                jVar = this;
            }
            j6 = j7;
            jVar = this;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.i
    public boolean isEmpty() {
        if (w() == u()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.i
    public E peek() {
        long w5;
        E e6;
        do {
            w5 = w();
            e6 = e(a(w5));
            if (e6 != null) {
                break;
            }
        } while (w5 != u());
        return e6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.i
    public int size() {
        long w5 = w();
        while (true) {
            long u5 = u();
            long w6 = w();
            if (w5 == w6) {
                return (int) (u5 - w6);
            }
            w5 = w6;
        }
    }
}
