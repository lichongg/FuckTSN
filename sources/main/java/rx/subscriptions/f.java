package rx.subscriptions;

import java.util.concurrent.Future;
import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final b f54595a = new b();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a implements m {

        /* renamed from: a, reason: collision with root package name */
        final Future<?> f54596a;

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f54596a.isCancelled();
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f54596a.cancel(true);
        }

        public a(Future<?> future) {
            this.f54596a = future;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b implements m {
        @Override // rx.m
        public boolean isUnsubscribed() {
            return true;
        }

        b() {
        }

        @Override // rx.m
        public void unsubscribe() {
        }
    }

    public static m c(Future<?> future) {
        return new a(future);
    }

    public static rx.subscriptions.b d(m... mVarArr) {
        return new rx.subscriptions.b(mVarArr);
    }

    public static m e() {
        return f54595a;
    }

    private f() {
        throw new IllegalStateException("No instances!");
    }

    public static m a(rx.functions.a aVar) {
        return rx.subscriptions.a.b(aVar);
    }

    public static m b() {
        return rx.subscriptions.a.a();
    }
}
