package rx.internal.util;

import androidx.camera.view.p;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e<E> implements rx.m {

    /* renamed from: e, reason: collision with root package name */
    static final int f54139e;

    /* renamed from: a, reason: collision with root package name */
    private final a<E> f54140a = new a<>();

    /* renamed from: b, reason: collision with root package name */
    private final b f54141b = new b();

    /* renamed from: c, reason: collision with root package name */
    final AtomicInteger f54142c = new AtomicInteger();

    /* renamed from: d, reason: collision with root package name */
    final AtomicInteger f54143d = new AtomicInteger();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<E> {

        /* renamed from: a, reason: collision with root package name */
        final AtomicReferenceArray<E> f54144a = new AtomicReferenceArray<>(e.f54139e);

        /* renamed from: b, reason: collision with root package name */
        final AtomicReference<a<E>> f54145b = new AtomicReference<>();

        a<E> a() {
            if (this.f54145b.get() != null) {
                return this.f54145b.get();
            }
            a<E> aVar = new a<>();
            return p.a(this.f54145b, null, aVar) ? aVar : this.f54145b.get();
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicIntegerArray f54146a = new AtomicIntegerArray(e.f54139e);

        /* renamed from: b, reason: collision with root package name */
        private final AtomicReference<b> f54147b = new AtomicReference<>();

        public int a(int i6, int i7) {
            return this.f54146a.getAndSet(i6, i7);
        }

        b b() {
            if (this.f54147b.get() != null) {
                return this.f54147b.get();
            }
            b bVar = new b();
            return p.a(this.f54147b, null, bVar) ? bVar : this.f54147b.get();
        }

        public void c(int i6, int i7) {
            this.f54146a.set(i6, i7);
        }

        b() {
        }
    }

    private synchronized void B(int i6) {
        try {
            int andIncrement = this.f54143d.getAndIncrement();
            int i7 = f54139e;
            if (andIncrement < i7) {
                this.f54141b.c(andIncrement, i6);
            } else {
                s(andIncrement).c(andIncrement % i7, i6);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized int g() {
        int andIncrement;
        try {
            int j6 = j();
            if (j6 >= 0) {
                int i6 = f54139e;
                if (j6 < i6) {
                    andIncrement = this.f54141b.a(j6, -1);
                } else {
                    andIncrement = s(j6).a(j6 % i6, -1);
                }
                if (andIncrement == this.f54142c.get()) {
                    this.f54142c.getAndIncrement();
                }
            } else {
                andIncrement = this.f54142c.getAndIncrement();
            }
        } catch (Throwable th) {
            throw th;
        }
        return andIncrement;
    }

    private synchronized int j() {
        int i6;
        int i7;
        do {
            i6 = this.f54143d.get();
            if (i6 <= 0) {
                return -1;
            }
            i7 = i6 - 1;
        } while (!this.f54143d.compareAndSet(i6, i7));
        return i7;
    }

    public int b(rx.functions.p<? super E, Boolean> pVar) {
        return d(pVar, 0);
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return false;
    }

    public static <T> e<T> A() {
        return new e<>();
    }

    private int e(rx.functions.p<? super E, Boolean> pVar, int i6, int i7) {
        a<E> aVar;
        int i8;
        E e6;
        int i9 = this.f54142c.get();
        a<E> aVar2 = this.f54140a;
        int i10 = f54139e;
        if (i6 >= i10) {
            a<E> f6 = f(i6);
            i8 = i6;
            i6 %= i10;
            aVar = f6;
        } else {
            aVar = aVar2;
            i8 = i6;
        }
        while (aVar != null) {
            while (i6 < f54139e) {
                if (i8 >= i9 || i8 >= i7 || !((e6 = aVar.f54144a.get(i6)) == null || pVar.call(e6).booleanValue())) {
                    return i8;
                }
                i6++;
                i8++;
            }
            aVar = aVar.f54145b.get();
            i6 = 0;
        }
        return i8;
    }

    private a<E> f(int i6) {
        int i7 = f54139e;
        if (i6 < i7) {
            return this.f54140a;
        }
        int i8 = i6 / i7;
        a<E> aVar = this.f54140a;
        for (int i9 = 0; i9 < i8; i9++) {
            aVar = aVar.a();
        }
        return aVar;
    }

    private b s(int i6) {
        int i7 = f54139e;
        if (i6 < i7) {
            return this.f54141b;
        }
        int i8 = i6 / i7;
        b bVar = this.f54141b;
        for (int i9 = 0; i9 < i8; i9++) {
            bVar = bVar.b();
        }
        return bVar;
    }

    public void G() {
        int i6 = this.f54142c.get();
        int i7 = 0;
        loop0: for (a<E> aVar = this.f54140a; aVar != null; aVar = aVar.f54145b.get()) {
            int i8 = 0;
            while (i8 < f54139e) {
                if (i7 >= i6) {
                    break loop0;
                }
                aVar.f54144a.set(i8, null);
                i8++;
                i7++;
            }
        }
        this.f54142c.set(0);
        this.f54143d.set(0);
    }

    public E H(int i6) {
        E andSet;
        int i7 = f54139e;
        if (i6 < i7) {
            andSet = this.f54140a.f54144a.getAndSet(i6, null);
        } else {
            andSet = f(i6).f54144a.getAndSet(i6 % i7, null);
        }
        B(i6);
        return andSet;
    }

    public int d(rx.functions.p<? super E, Boolean> pVar, int i6) {
        int e6 = e(pVar, i6, this.f54142c.get());
        if (i6 > 0 && e6 == this.f54142c.get()) {
            return e(pVar, 0, i6);
        }
        if (e6 == this.f54142c.get()) {
            return 0;
        }
        return e6;
    }

    static {
        int i6;
        if (i.b()) {
            i6 = 8;
        } else {
            i6 = 128;
        }
        String property = System.getProperty("rx.indexed-ring-buffer.size");
        if (property != null) {
            try {
                i6 = Integer.parseInt(property);
            } catch (NumberFormatException e6) {
                PrintStream printStream = System.err;
                e6.getMessage();
                printStream.getClass();
            }
        }
        f54139e = i6;
    }

    e() {
    }

    public int a(E e6) {
        int g6 = g();
        int i6 = f54139e;
        if (g6 < i6) {
            this.f54140a.f54144a.set(g6, e6);
            return g6;
        }
        f(g6).f54144a.set(g6 % i6, e6);
        return g6;
    }

    @Override // rx.m
    public void unsubscribe() {
        G();
    }
}
