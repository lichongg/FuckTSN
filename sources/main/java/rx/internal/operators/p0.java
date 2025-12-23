package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p0<TLeft, TRight, TLeftDuration, TRightDuration, R> implements e.a<R> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<TLeft> f53318a;

    /* renamed from: b, reason: collision with root package name */
    final rx.e<TRight> f53319b;

    /* renamed from: c, reason: collision with root package name */
    final rx.functions.p<TLeft, rx.e<TLeftDuration>> f53320c;

    /* renamed from: d, reason: collision with root package name */
    final rx.functions.p<TRight, rx.e<TRightDuration>> f53321d;

    /* renamed from: e, reason: collision with root package name */
    final rx.functions.q<TLeft, TRight, R> f53322e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends HashMap<Integer, TLeft> {
        private static final long serialVersionUID = 3491669543549085380L;

        /* renamed from: b, reason: collision with root package name */
        final rx.l<? super R> f53324b;

        /* renamed from: c, reason: collision with root package name */
        boolean f53325c;

        /* renamed from: d, reason: collision with root package name */
        int f53326d;

        /* renamed from: e, reason: collision with root package name */
        boolean f53327e;

        /* renamed from: f, reason: collision with root package name */
        int f53328f;

        /* renamed from: a, reason: collision with root package name */
        final rx.subscriptions.b f53323a = new rx.subscriptions.b();

        /* renamed from: g, reason: collision with root package name */
        final Map<Integer, TRight> f53329g = new HashMap();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.p0$a$a, reason: collision with other inner class name */
        final class C1044a extends rx.l<TLeft> {

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: rx.internal.operators.p0$a$a$a, reason: collision with other inner class name */
            final class C1045a extends rx.l<TLeftDuration> {

                /* renamed from: a, reason: collision with root package name */
                final int f53332a;

                /* renamed from: b, reason: collision with root package name */
                boolean f53333b = true;

                public C1045a(int i6) {
                    this.f53332a = i6;
                }

                @Override // rx.f
                public void onCompleted() {
                    if (this.f53333b) {
                        this.f53333b = false;
                        C1044a.this.g(this.f53332a, this);
                    }
                }

                @Override // rx.f
                public void onError(Throwable th) {
                    C1044a.this.onError(th);
                }

                @Override // rx.f
                public void onNext(TLeftDuration tleftduration) {
                    onCompleted();
                }
            }

            C1044a() {
            }

            protected void g(int i6, rx.m mVar) {
                boolean z5;
                synchronized (a.this) {
                    try {
                        z5 = a.this.a().remove(Integer.valueOf(i6)) != null && a.this.a().isEmpty() && a.this.f53325c;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (!z5) {
                    a.this.f53323a.f(mVar);
                } else {
                    a.this.f53324b.onCompleted();
                    a.this.f53324b.unsubscribe();
                }
            }

            @Override // rx.f
            public void onCompleted() {
                boolean z5;
                synchronized (a.this) {
                    try {
                        a aVar = a.this;
                        z5 = true;
                        aVar.f53325c = true;
                        if (!aVar.f53327e && !aVar.a().isEmpty()) {
                            z5 = false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (!z5) {
                    a.this.f53323a.f(this);
                } else {
                    a.this.f53324b.onCompleted();
                    a.this.f53324b.unsubscribe();
                }
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.f53324b.onError(th);
                a.this.f53324b.unsubscribe();
            }

            @Override // rx.f
            public void onNext(TLeft tleft) {
                int i6;
                a aVar;
                int i7;
                synchronized (a.this) {
                    a aVar2 = a.this;
                    i6 = aVar2.f53326d;
                    aVar2.f53326d = i6 + 1;
                    aVar2.a().put(Integer.valueOf(i6), tleft);
                    aVar = a.this;
                    i7 = aVar.f53328f;
                }
                try {
                    rx.e<TLeftDuration> call = p0.this.f53320c.call(tleft);
                    C1045a c1045a = new C1045a(i6);
                    a.this.f53323a.a(c1045a);
                    call.J6(c1045a);
                    ArrayList arrayList = new ArrayList();
                    synchronized (a.this) {
                        try {
                            for (Map.Entry<Integer, TRight> entry : a.this.f53329g.entrySet()) {
                                if (entry.getKey().intValue() < i7) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        a.this.f53324b.onNext(p0.this.f53322e.call(tleft, it.next()));
                    }
                } catch (Throwable th2) {
                    rx.exceptions.a.f(th2, this);
                }
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class b extends rx.l<TRight> {

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: rx.internal.operators.p0$a$b$a, reason: collision with other inner class name */
            final class C1046a extends rx.l<TRightDuration> {

                /* renamed from: a, reason: collision with root package name */
                final int f53336a;

                /* renamed from: b, reason: collision with root package name */
                boolean f53337b = true;

                public C1046a(int i6) {
                    this.f53336a = i6;
                }

                @Override // rx.f
                public void onCompleted() {
                    if (this.f53337b) {
                        this.f53337b = false;
                        b.this.g(this.f53336a, this);
                    }
                }

                @Override // rx.f
                public void onError(Throwable th) {
                    b.this.onError(th);
                }

                @Override // rx.f
                public void onNext(TRightDuration trightduration) {
                    onCompleted();
                }
            }

            b() {
            }

            void g(int i6, rx.m mVar) {
                boolean z5;
                synchronized (a.this) {
                    try {
                        z5 = a.this.f53329g.remove(Integer.valueOf(i6)) != null && a.this.f53329g.isEmpty() && a.this.f53327e;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (!z5) {
                    a.this.f53323a.f(mVar);
                } else {
                    a.this.f53324b.onCompleted();
                    a.this.f53324b.unsubscribe();
                }
            }

            @Override // rx.f
            public void onCompleted() {
                boolean z5;
                synchronized (a.this) {
                    try {
                        a aVar = a.this;
                        z5 = true;
                        aVar.f53327e = true;
                        if (!aVar.f53325c && !aVar.f53329g.isEmpty()) {
                            z5 = false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (!z5) {
                    a.this.f53323a.f(this);
                } else {
                    a.this.f53324b.onCompleted();
                    a.this.f53324b.unsubscribe();
                }
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.f53324b.onError(th);
                a.this.f53324b.unsubscribe();
            }

            @Override // rx.f
            public void onNext(TRight tright) {
                int i6;
                int i7;
                synchronized (a.this) {
                    a aVar = a.this;
                    i6 = aVar.f53328f;
                    aVar.f53328f = i6 + 1;
                    aVar.f53329g.put(Integer.valueOf(i6), tright);
                    i7 = a.this.f53326d;
                }
                a.this.f53323a.a(new rx.subscriptions.e());
                try {
                    rx.e<TRightDuration> call = p0.this.f53321d.call(tright);
                    C1046a c1046a = new C1046a(i6);
                    a.this.f53323a.a(c1046a);
                    call.J6(c1046a);
                    ArrayList arrayList = new ArrayList();
                    synchronized (a.this) {
                        try {
                            for (Map.Entry<Integer, TLeft> entry : a.this.a().entrySet()) {
                                if (entry.getKey().intValue() < i7) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        a.this.f53324b.onNext(p0.this.f53322e.call(it.next(), tright));
                    }
                } catch (Throwable th2) {
                    rx.exceptions.a.f(th2, this);
                }
            }
        }

        public a(rx.l<? super R> lVar) {
            this.f53324b = lVar;
        }

        public void b() {
            this.f53324b.add(this.f53323a);
            C1044a c1044a = new C1044a();
            b bVar = new b();
            this.f53323a.a(c1044a);
            this.f53323a.a(bVar);
            p0.this.f53318a.J6(c1044a);
            p0.this.f53319b.J6(bVar);
        }

        HashMap<Integer, TLeft> a() {
            return this;
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super R> lVar) {
        new a(new rx.observers.g(lVar)).b();
    }

    public p0(rx.e<TLeft> eVar, rx.e<TRight> eVar2, rx.functions.p<TLeft, rx.e<TLeftDuration>> pVar, rx.functions.p<TRight, rx.e<TRightDuration>> pVar2, rx.functions.q<TLeft, TRight, R> qVar) {
        this.f53318a = eVar;
        this.f53319b = eVar2;
        this.f53320c = pVar;
        this.f53321d = pVar2;
        this.f53322e = qVar;
    }
}
