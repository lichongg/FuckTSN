package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class a implements m {

    /* renamed from: b, reason: collision with root package name */
    static final rx.functions.a f54583b = new C1080a();

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference<rx.functions.a> f54584a;

    public a() {
        this.f54584a = new AtomicReference<>();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: rx.subscriptions.a$a, reason: collision with other inner class name */
    static class C1080a implements rx.functions.a {
        C1080a() {
        }

        @Override // rx.functions.a
        public void call() {
        }
    }

    public static a a() {
        return new a();
    }

    public static a b(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f54584a.get() == f54583b;
    }

    @Override // rx.m
    public void unsubscribe() {
        rx.functions.a andSet;
        rx.functions.a aVar = this.f54584a.get();
        rx.functions.a aVar2 = f54583b;
        if (aVar == aVar2 || (andSet = this.f54584a.getAndSet(aVar2)) == null || andSet == aVar2) {
            return;
        }
        andSet.call();
    }

    private a(rx.functions.a aVar) {
        this.f54584a = new AtomicReference<>(aVar);
    }
}
