package rx.internal.operators;

import java.util.Arrays;
import rx.exceptions.CompositeException;
import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class v4<T, Resource> implements i.t<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.o<Resource> f53639a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.p<? super Resource, ? extends rx.i<? extends T>> f53640b;

    /* renamed from: c, reason: collision with root package name */
    final rx.functions.b<? super Resource> f53641c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f53642d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.k<T> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f53643b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.k f53644c;

        a(Object obj, rx.k kVar) {
            this.f53643b = obj;
            this.f53644c = kVar;
        }

        @Override // rx.k
        public void d(T t5) {
            v4 v4Var = v4.this;
            if (v4Var.f53642d) {
                try {
                    v4Var.f53641c.call((Object) this.f53643b);
                } catch (Throwable th) {
                    rx.exceptions.a.e(th);
                    this.f53644c.onError(th);
                    return;
                }
            }
            this.f53644c.d(t5);
            v4 v4Var2 = v4.this;
            if (v4Var2.f53642d) {
                return;
            }
            try {
                v4Var2.f53641c.call((Object) this.f53643b);
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                rx.plugins.c.I(th2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.k
        public void onError(Throwable th) {
            v4.this.a(this.f53644c, this.f53643b, th);
        }
    }

    @Override // rx.functions.b
    public void call(rx.k<? super T> kVar) {
        try {
            Resource call = this.f53639a.call();
            try {
                rx.i<? extends T> call2 = this.f53640b.call(call);
                if (call2 == null) {
                    a(kVar, call, new NullPointerException("The single"));
                    return;
                }
                a aVar = new a(call, kVar);
                kVar.b(aVar);
                call2.j0(aVar);
            } catch (Throwable th) {
                a(kVar, call, th);
            }
        } catch (Throwable th2) {
            rx.exceptions.a.e(th2);
            kVar.onError(th2);
        }
    }

    public v4(rx.functions.o<Resource> oVar, rx.functions.p<? super Resource, ? extends rx.i<? extends T>> pVar, rx.functions.b<? super Resource> bVar, boolean z5) {
        this.f53639a = oVar;
        this.f53640b = pVar;
        this.f53641c = bVar;
        this.f53642d = z5;
    }

    void a(rx.k<? super T> kVar, Resource resource, Throwable th) {
        rx.exceptions.a.e(th);
        if (this.f53642d) {
            try {
                this.f53641c.call(resource);
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                th = new CompositeException(Arrays.asList(th, th2));
            }
        }
        kVar.onError(th);
        if (!this.f53642d) {
            try {
                this.f53641c.call(resource);
            } catch (Throwable th3) {
                rx.exceptions.a.e(th3);
                rx.plugins.c.I(th3);
            }
        }
    }
}
