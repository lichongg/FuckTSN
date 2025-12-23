package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.exceptions.MissingBackpressureException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class OnSubscribePublishMulticast<T> extends AtomicInteger implements e.a<T>, rx.f<T>, rx.m {
    static final b<?>[] EMPTY = new b[0];
    static final b<?>[] TERMINATED = new b[0];
    private static final long serialVersionUID = -3741892510772238743L;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final a<T> parent;
    final int prefetch;
    volatile rx.g producer;
    final Queue<T> queue;
    volatile b<T>[] subscribers;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final OnSubscribePublishMulticast<T> f52482a;

        @Override // rx.f
        public void onCompleted() {
            this.f52482a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52482a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f52482a.onNext(t5);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f52482a.setProducer(gVar);
        }

        public a(OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.f52482a = onSubscribePublishMulticast;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> extends AtomicLong implements rx.g, rx.m {
        private static final long serialVersionUID = 960704844171597367L;

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f52483a;

        /* renamed from: b, reason: collision with root package name */
        final OnSubscribePublishMulticast<T> f52484b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicBoolean f52485c = new AtomicBoolean();

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f52485c.get();
        }

        @Override // rx.g
        public void request(long j6) {
            if (j6 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j6);
            }
            if (j6 != 0) {
                rx.internal.operators.a.b(this, j6);
                this.f52484b.drain();
            }
        }

        @Override // rx.m
        public void unsubscribe() {
            if (this.f52485c.compareAndSet(false, true)) {
                this.f52484b.remove(this);
            }
        }

        public b(rx.l<? super T> lVar, OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.f52483a = lVar;
            this.f52484b = onSubscribePublishMulticast;
        }
    }

    boolean checkTerminated(boolean z5, boolean z6) {
        int i6 = 0;
        if (z5) {
            if (!this.delayError) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    b<T>[] terminate = terminate();
                    int length = terminate.length;
                    while (i6 < length) {
                        terminate[i6].f52483a.onError(th);
                        i6++;
                    }
                    return true;
                }
                if (z6) {
                    b<T>[] terminate2 = terminate();
                    int length2 = terminate2.length;
                    while (i6 < length2) {
                        terminate2[i6].f52483a.onCompleted();
                        i6++;
                    }
                    return true;
                }
            } else if (z6) {
                b<T>[] terminate3 = terminate();
                Throwable th2 = this.error;
                if (th2 != null) {
                    int length3 = terminate3.length;
                    while (i6 < length3) {
                        terminate3[i6].f52483a.onError(th2);
                        i6++;
                    }
                } else {
                    int length4 = terminate3.length;
                    while (i6 < length4) {
                        terminate3[i6].f52483a.onCompleted();
                        i6++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // rx.f
    public void onCompleted() {
        this.done = true;
        drain();
    }

    boolean add(b<T> bVar) {
        b<T>[] bVarArr = this.subscribers;
        b<?>[] bVarArr2 = TERMINATED;
        if (bVarArr == bVarArr2) {
            return false;
        }
        synchronized (this) {
            try {
                b<T>[] bVarArr3 = this.subscribers;
                if (bVarArr3 == bVarArr2) {
                    return false;
                }
                int length = bVarArr3.length;
                b<T>[] bVarArr4 = new b[length + 1];
                System.arraycopy(bVarArr3, 0, bVarArr4, 0, length);
                bVarArr4[length] = bVar;
                this.subscribers = bVarArr4;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        b<T> bVar = new b<>(lVar, this);
        lVar.add(bVar);
        lVar.setProducer(bVar);
        if (add(bVar)) {
            if (bVar.isUnsubscribed()) {
                remove(bVar);
                return;
            } else {
                drain();
                return;
            }
        }
        Throwable th = this.error;
        if (th != null) {
            lVar.onError(th);
        } else {
            lVar.onCompleted();
        }
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.parent.isUnsubscribed();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // rx.f
    public void onNext(T t5) {
        if (!this.queue.offer(t5)) {
            this.parent.unsubscribe();
            this.error = new MissingBackpressureException("Queue full?!");
            this.done = true;
        }
        drain();
    }

    void remove(b<T> bVar) {
        b<?>[] bVarArr;
        b[] bVarArr2;
        b<T>[] bVarArr3 = this.subscribers;
        b<?>[] bVarArr4 = TERMINATED;
        if (bVarArr3 == bVarArr4 || bVarArr3 == (bVarArr = EMPTY)) {
            return;
        }
        synchronized (this) {
            try {
                b<T>[] bVarArr5 = this.subscribers;
                if (bVarArr5 != bVarArr4 && bVarArr5 != bVarArr) {
                    int length = bVarArr5.length;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length) {
                            i6 = -1;
                            break;
                        } else if (bVarArr5[i6] != bVar) {
                            i6++;
                        }
                    }
                    if (i6 < 0) {
                        return;
                    }
                    if (length == 1) {
                        bVarArr2 = EMPTY;
                    } else {
                        b[] bVarArr6 = new b[length - 1];
                        System.arraycopy(bVarArr5, 0, bVarArr6, 0, i6);
                        System.arraycopy(bVarArr5, i6 + 1, bVarArr6, i6, (length - i6) - 1);
                        bVarArr2 = bVarArr6;
                    }
                    this.subscribers = bVarArr2;
                }
            } finally {
            }
        }
    }

    void setProducer(rx.g gVar) {
        this.producer = gVar;
        gVar.request(this.prefetch);
    }

    public rx.l<T> subscriber() {
        return this.parent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    b<T>[] terminate() {
        b<T>[] bVarArr;
        b<T>[] bVarArr2 = this.subscribers;
        b<T>[] bVarArr3 = (b<T>[]) TERMINATED;
        if (bVarArr2 == bVarArr3) {
            return bVarArr2;
        }
        synchronized (this) {
            try {
                bVarArr = this.subscribers;
                if (bVarArr != bVarArr3) {
                    this.subscribers = bVarArr3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVarArr;
    }

    @Override // rx.m
    public void unsubscribe() {
        this.parent.unsubscribe();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OnSubscribePublishMulticast(int i6, boolean z5) {
        if (i6 > 0) {
            this.prefetch = i6;
            this.delayError = z5;
            if (rx.internal.util.unsafe.n0.f()) {
                this.queue = new rx.internal.util.unsafe.z(i6);
            } else {
                this.queue = new rx.internal.util.atomic.d(i6);
            }
            this.subscribers = (b<T>[]) EMPTY;
            this.parent = new a<>(this);
            return;
        }
        throw new IllegalArgumentException("prefetch > 0 required but it was " + i6);
    }

    void drain() {
        boolean z5;
        if (getAndIncrement() == 0) {
            Queue<T> queue = this.queue;
            int i6 = 0;
            do {
                b<T>[] bVarArr = this.subscribers;
                int length = bVarArr.length;
                long j6 = Long.MAX_VALUE;
                for (b<T> bVar : bVarArr) {
                    j6 = Math.min(j6, bVar.get());
                }
                if (length != 0) {
                    long j7 = 0;
                    while (j7 != j6) {
                        boolean z6 = this.done;
                        T poll = queue.poll();
                        if (poll == null) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (!checkTerminated(z6, z5)) {
                            if (z5) {
                                break;
                            }
                            for (b<T> bVar2 : bVarArr) {
                                bVar2.f52483a.onNext(poll);
                            }
                            j7++;
                        } else {
                            return;
                        }
                    }
                    if (j7 != j6 || !checkTerminated(this.done, queue.isEmpty())) {
                        if (j7 != 0) {
                            rx.g gVar = this.producer;
                            if (gVar != null) {
                                gVar.request(j7);
                            }
                            for (b<T> bVar3 : bVarArr) {
                                rx.internal.operators.a.i(bVar3, j7);
                            }
                        }
                    } else {
                        return;
                    }
                }
                i6 = addAndGet(-i6);
            } while (i6 != 0);
        }
    }
}
