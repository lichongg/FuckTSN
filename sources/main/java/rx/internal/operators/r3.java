package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class r3<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.q<? super T, ? super Integer, Boolean> f53450a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.functions.q<T, Integer, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.p f53451a;

        @Override // rx.functions.q
        public /* bridge */ /* synthetic */ Boolean call(Object obj, Integer num) {
            return call2((a) obj, num);
        }

        a(rx.functions.p pVar) {
            this.f53451a = pVar;
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public Boolean call2(T t5, Integer num) {
            return (Boolean) this.f53451a.call(t5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        private int f53452a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f53453b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.l f53454c;

        @Override // rx.f
        public void onNext(T t5) {
            try {
                rx.functions.q<? super T, ? super Integer, Boolean> qVar = r3.this.f53450a;
                int i6 = this.f53452a;
                this.f53452a = i6 + 1;
                if (qVar.call(t5, Integer.valueOf(i6)).booleanValue()) {
                    this.f53454c.onNext(t5);
                    return;
                }
                this.f53453b = true;
                this.f53454c.onCompleted();
                unsubscribe();
            } catch (Throwable th) {
                this.f53453b = true;
                rx.exceptions.a.g(th, this.f53454c, t5);
                unsubscribe();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(rx.l lVar, boolean z5, rx.l lVar2) {
            super(lVar, z5);
            this.f53454c = lVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f53453b) {
                return;
            }
            this.f53454c.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53453b) {
                return;
            }
            this.f53454c.onError(th);
        }
    }

    public r3(rx.functions.p<? super T, Boolean> pVar) {
        this(new a(pVar));
    }

    public r3(rx.functions.q<? super T, ? super Integer, Boolean> qVar) {
        this.f53450a = qVar;
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        b bVar = new b(lVar, false, lVar);
        lVar.add(bVar);
        return bVar;
    }
}
