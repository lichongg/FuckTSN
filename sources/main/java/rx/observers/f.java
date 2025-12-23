package rx.observers;

import rx.internal.operators.v;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class f<T> implements rx.f<T> {

    /* renamed from: a, reason: collision with root package name */
    private final rx.f<? super T> f54408a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f54409b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f54410c;

    /* renamed from: d, reason: collision with root package name */
    private a f54411d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        Object[] f54412a;

        /* renamed from: b, reason: collision with root package name */
        int f54413b;

        public void a(Object obj) {
            int i6 = this.f54413b;
            Object[] objArr = this.f54412a;
            if (objArr == null) {
                objArr = new Object[16];
                this.f54412a = objArr;
            } else if (i6 == objArr.length) {
                Object[] objArr2 = new Object[(i6 >> 2) + i6];
                System.arraycopy(objArr, 0, objArr2, 0, i6);
                this.f54412a = objArr2;
                objArr = objArr2;
            }
            objArr[i6] = obj;
            this.f54413b = i6 + 1;
        }

        a() {
        }
    }

    @Override // rx.f
    public void onCompleted() {
        if (this.f54410c) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f54410c) {
                    return;
                }
                this.f54410c = true;
                if (!this.f54409b) {
                    this.f54409b = true;
                    this.f54408a.onCompleted();
                    return;
                }
                a aVar = this.f54411d;
                if (aVar == null) {
                    aVar = new a();
                    this.f54411d = aVar;
                }
                aVar.a(v.b());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x002f, code lost:
    
        continue;
     */
    @Override // rx.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onNext(T r7) {
        /*
            r6 = this;
            boolean r0 = r6.f54410c
            if (r0 == 0) goto L5
            return
        L5:
            monitor-enter(r6)
            boolean r0 = r6.f54410c     // Catch: java.lang.Throwable -> Lc
            if (r0 == 0) goto Le
            monitor-exit(r6)     // Catch: java.lang.Throwable -> Lc
            return
        Lc:
            r7 = move-exception
            goto L73
        Le:
            boolean r0 = r6.f54409b     // Catch: java.lang.Throwable -> Lc
            if (r0 == 0) goto L26
            rx.observers.f$a r0 = r6.f54411d     // Catch: java.lang.Throwable -> Lc
            if (r0 != 0) goto L1d
            rx.observers.f$a r0 = new rx.observers.f$a     // Catch: java.lang.Throwable -> Lc
            r0.<init>()     // Catch: java.lang.Throwable -> Lc
            r6.f54411d = r0     // Catch: java.lang.Throwable -> Lc
        L1d:
            java.lang.Object r7 = rx.internal.operators.v.j(r7)     // Catch: java.lang.Throwable -> Lc
            r0.a(r7)     // Catch: java.lang.Throwable -> Lc
            monitor-exit(r6)     // Catch: java.lang.Throwable -> Lc
            return
        L26:
            r0 = 1
            r6.f54409b = r0     // Catch: java.lang.Throwable -> Lc
            monitor-exit(r6)     // Catch: java.lang.Throwable -> Lc
            rx.f<? super T> r1 = r6.f54408a     // Catch: java.lang.Throwable -> L6a
            r1.onNext(r7)     // Catch: java.lang.Throwable -> L6a
        L2f:
            monitor-enter(r6)
            rx.observers.f$a r1 = r6.f54411d     // Catch: java.lang.Throwable -> L39
            r2 = 0
            if (r1 != 0) goto L3b
            r6.f54409b = r2     // Catch: java.lang.Throwable -> L39
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L39
            return
        L39:
            r7 = move-exception
            goto L68
        L3b:
            r3 = 0
            r6.f54411d = r3     // Catch: java.lang.Throwable -> L39
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L39
            java.lang.Object[] r1 = r1.f54412a
            int r3 = r1.length
        L42:
            if (r2 >= r3) goto L2f
            r4 = r1[r2]
            if (r4 != 0) goto L49
            goto L2f
        L49:
            rx.f<? super T> r5 = r6.f54408a     // Catch: java.lang.Throwable -> L54
            boolean r4 = rx.internal.operators.v.a(r5, r4)     // Catch: java.lang.Throwable -> L54
            if (r4 == 0) goto L56
            r6.f54410c = r0     // Catch: java.lang.Throwable -> L54
            return
        L54:
            r1 = move-exception
            goto L59
        L56:
            int r2 = r2 + 1
            goto L42
        L59:
            r6.f54410c = r0
            rx.exceptions.a.e(r1)
            rx.f<? super T> r0 = r6.f54408a
            java.lang.Throwable r7 = rx.exceptions.OnErrorThrowable.addValueAsLastCause(r1, r7)
            r0.onError(r7)
            return
        L68:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L39
            throw r7
        L6a:
            r1 = move-exception
            r6.f54410c = r0
            rx.f<? super T> r0 = r6.f54408a
            rx.exceptions.a.g(r1, r0, r7)
            return
        L73:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> Lc
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.observers.f.onNext(java.lang.Object):void");
    }

    public f(rx.f<? super T> fVar) {
        this.f54408a = fVar;
    }

    @Override // rx.f
    public void onError(Throwable th) {
        rx.exceptions.a.e(th);
        if (this.f54410c) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f54410c) {
                    return;
                }
                this.f54410c = true;
                if (this.f54409b) {
                    a aVar = this.f54411d;
                    if (aVar == null) {
                        aVar = new a();
                        this.f54411d = aVar;
                    }
                    aVar.a(v.c(th));
                    return;
                }
                this.f54409b = true;
                this.f54408a.onError(th);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
