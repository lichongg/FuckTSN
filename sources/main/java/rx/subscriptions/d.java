package rx.subscriptions;

import androidx.camera.view.p;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class d implements m {

    /* renamed from: c, reason: collision with root package name */
    static final b f54588c = new b(false, 0);

    /* renamed from: a, reason: collision with root package name */
    private final m f54589a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference<b> f54590b = new AtomicReference<>(f54588c);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        final boolean f54592a;

        /* renamed from: b, reason: collision with root package name */
        final int f54593b;

        b a() {
            return new b(this.f54592a, this.f54593b + 1);
        }

        b b() {
            return new b(this.f54592a, this.f54593b - 1);
        }

        b c() {
            return new b(true, this.f54593b);
        }

        b(boolean z5, int i6) {
            this.f54592a = z5;
            this.f54593b = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends AtomicInteger implements m {
        private static final long serialVersionUID = 7005765588239987643L;

        /* renamed from: a, reason: collision with root package name */
        final d f54591a;

        @Override // rx.m
        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.f54591a.b();
            }
        }

        public a(d dVar) {
            this.f54591a = dVar;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            if (get() != 0) {
                return true;
            }
            return false;
        }
    }

    private void d(b bVar) {
        if (bVar.f54592a && bVar.f54593b == 0) {
            this.f54589a.unsubscribe();
        }
    }

    public m a() {
        b bVar;
        AtomicReference<b> atomicReference = this.f54590b;
        do {
            bVar = atomicReference.get();
            if (bVar.f54592a) {
                return f.e();
            }
        } while (!p.a(atomicReference, bVar, bVar.a()));
        return new a(this);
    }

    void b() {
        b bVar;
        b b6;
        AtomicReference<b> atomicReference = this.f54590b;
        do {
            bVar = atomicReference.get();
            b6 = bVar.b();
        } while (!p.a(atomicReference, bVar, b6));
        d(b6);
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f54590b.get().f54592a;
    }

    @Override // rx.m
    public void unsubscribe() {
        b bVar;
        b c6;
        AtomicReference<b> atomicReference = this.f54590b;
        do {
            bVar = atomicReference.get();
            if (bVar.f54592a) {
                return;
            } else {
                c6 = bVar.c();
            }
        } while (!p.a(atomicReference, bVar, c6));
        d(c6);
    }

    public d(m mVar) {
        if (mVar != null) {
            this.f54589a = mVar;
            return;
        }
        throw new IllegalArgumentException("s");
    }
}
