package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l3<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final int f53154a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        int f53155a;

        /* renamed from: b, reason: collision with root package name */
        boolean f53156b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.l f53157c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.l3$a$a, reason: collision with other inner class name */
        class C1041a implements rx.g {

            /* renamed from: a, reason: collision with root package name */
            final AtomicLong f53159a = new AtomicLong(0);

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ rx.g f53160b;

            C1041a(rx.g gVar) {
                this.f53160b = gVar;
            }

            @Override // rx.g
            public void request(long j6) {
                long j7;
                long min;
                if (j6 <= 0 || a.this.f53156b) {
                    return;
                }
                do {
                    j7 = this.f53159a.get();
                    min = Math.min(j6, l3.this.f53154a - j7);
                    if (min == 0) {
                        return;
                    }
                } while (!this.f53159a.compareAndSet(j7, j7 + min));
                this.f53160b.request(min);
            }
        }

        a(rx.l lVar) {
            this.f53157c = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f53156b) {
                return;
            }
            this.f53156b = true;
            this.f53157c.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53156b) {
                rx.plugins.c.I(th);
                return;
            }
            this.f53156b = true;
            try {
                this.f53157c.onError(th);
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f53157c.setProducer(new C1041a(gVar));
        }

        @Override // rx.f
        public void onNext(T t5) {
            boolean z5;
            if (!isUnsubscribed()) {
                int i6 = this.f53155a;
                int i7 = i6 + 1;
                this.f53155a = i7;
                int i8 = l3.this.f53154a;
                if (i6 < i8) {
                    if (i7 == i8) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    this.f53157c.onNext(t5);
                    if (z5 && !this.f53156b) {
                        this.f53156b = true;
                        try {
                            this.f53157c.onCompleted();
                        } finally {
                            unsubscribe();
                        }
                    }
                }
            }
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        a aVar = new a(lVar);
        if (this.f53154a == 0) {
            lVar.onCompleted();
            aVar.unsubscribe();
        }
        lVar.add(aVar);
        return aVar;
    }

    public l3(int i6) {
        if (i6 >= 0) {
            this.f53154a = i6;
            return;
        }
        throw new IllegalArgumentException("limit >= 0 required but it was " + i6);
    }
}
