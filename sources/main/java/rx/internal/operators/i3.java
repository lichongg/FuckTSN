package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i3<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.q<? super T, Integer, Boolean> f52972a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        boolean f52973a;

        /* renamed from: b, reason: collision with root package name */
        int f52974b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.l f52975c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f52975c = lVar2;
            this.f52973a = true;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f52975c.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52975c.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (!this.f52973a) {
                this.f52975c.onNext(t5);
                return;
            }
            try {
                rx.functions.q<? super T, Integer, Boolean> qVar = i3.this.f52972a;
                int i6 = this.f52974b;
                this.f52974b = i6 + 1;
                if (qVar.call(t5, Integer.valueOf(i6)).booleanValue()) {
                    request(1L);
                } else {
                    this.f52973a = false;
                    this.f52975c.onNext(t5);
                }
            } catch (Throwable th) {
                rx.exceptions.a.g(th, this.f52975c, t5);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements rx.functions.q<T, Integer, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.p f52977a;

        @Override // rx.functions.q
        public /* bridge */ /* synthetic */ Boolean call(Object obj, Integer num) {
            return call2((b) obj, num);
        }

        b(rx.functions.p pVar) {
            this.f52977a = pVar;
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public Boolean call2(T t5, Integer num) {
            return (Boolean) this.f52977a.call(t5);
        }
    }

    public static <T> rx.functions.q<T, Integer, Boolean> a(rx.functions.p<? super T, Boolean> pVar) {
        return new b(pVar);
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        return new a(lVar, lVar);
    }

    public i3(rx.functions.q<? super T, Integer, Boolean> qVar) {
        this.f52972a = qVar;
    }
}
