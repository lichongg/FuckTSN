package rx.internal.schedulers;

import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class l implements rx.functions.a {

    /* renamed from: a, reason: collision with root package name */
    private final rx.functions.a f54071a;

    /* renamed from: b, reason: collision with root package name */
    private final h.a f54072b;

    /* renamed from: c, reason: collision with root package name */
    private final long f54073c;

    @Override // rx.functions.a
    public void call() {
        if (this.f54072b.isUnsubscribed()) {
            return;
        }
        long b6 = this.f54073c - this.f54072b.b();
        if (b6 > 0) {
            try {
                Thread.sleep(b6);
            } catch (InterruptedException e6) {
                Thread.currentThread().interrupt();
                rx.exceptions.a.c(e6);
            }
        }
        if (this.f54072b.isUnsubscribed()) {
            return;
        }
        this.f54071a.call();
    }

    public l(rx.functions.a aVar, h.a aVar2, long j6) {
        this.f54071a = aVar;
        this.f54072b = aVar2;
        this.f54073c = j6;
    }
}
