package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f extends rx.h {

    /* renamed from: a, reason: collision with root package name */
    public static final f f54026a = new f();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends h.a implements rx.m {

        /* renamed from: a, reason: collision with root package name */
        final rx.subscriptions.a f54027a = new rx.subscriptions.a();

        a() {
        }

        @Override // rx.h.a
        public rx.m e(rx.functions.a aVar, long j6, TimeUnit timeUnit) {
            return d(new l(aVar, this, f.this.b() + timeUnit.toMillis(j6)));
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f54027a.isUnsubscribed();
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f54027a.unsubscribe();
        }

        @Override // rx.h.a
        public rx.m d(rx.functions.a aVar) {
            aVar.call();
            return rx.subscriptions.f.e();
        }
    }

    @Override // rx.h
    public h.a a() {
        return new a();
    }

    private f() {
    }
}
