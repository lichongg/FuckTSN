package rx.internal.producers;

import java.util.ArrayList;
import java.util.List;
import rx.f;
import rx.g;
import rx.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b<T> implements g, f<T> {

    /* renamed from: j, reason: collision with root package name */
    static final g f53951j = new a();

    /* renamed from: a, reason: collision with root package name */
    final l<? super T> f53952a;

    /* renamed from: b, reason: collision with root package name */
    boolean f53953b;

    /* renamed from: c, reason: collision with root package name */
    List<T> f53954c;

    /* renamed from: d, reason: collision with root package name */
    g f53955d;

    /* renamed from: e, reason: collision with root package name */
    long f53956e;

    /* renamed from: f, reason: collision with root package name */
    long f53957f;

    /* renamed from: g, reason: collision with root package name */
    g f53958g;

    /* renamed from: h, reason: collision with root package name */
    Object f53959h;

    /* renamed from: i, reason: collision with root package name */
    volatile boolean f53960i;

    @Override // rx.f
    public void onCompleted() {
        synchronized (this) {
            try {
                if (this.f53953b) {
                    this.f53959h = Boolean.TRUE;
                } else {
                    this.f53953b = true;
                    this.f53952a.onCompleted();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // rx.f
    public void onError(Throwable th) {
        boolean z5;
        synchronized (this) {
            try {
                if (this.f53953b) {
                    this.f53959h = th;
                    z5 = false;
                } else {
                    this.f53953b = true;
                    z5 = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z5) {
            this.f53952a.onError(th);
        } else {
            this.f53960i = true;
        }
    }

    @Override // rx.f
    public void onNext(T t5) {
        synchronized (this) {
            try {
                if (this.f53953b) {
                    List list = this.f53954c;
                    if (list == null) {
                        list = new ArrayList(4);
                        this.f53954c = list;
                    }
                    list.add(t5);
                    return;
                }
                this.f53953b = true;
                try {
                    this.f53952a.onNext(t5);
                    long j6 = this.f53956e;
                    if (j6 != Long.MAX_VALUE) {
                        this.f53956e = j6 - 1;
                    }
                    d();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f53953b = false;
                        throw th;
                    }
                }
            } finally {
            }
        }
    }

    public void setProducer(g gVar) {
        synchronized (this) {
            try {
                if (this.f53953b) {
                    if (gVar == null) {
                        gVar = f53951j;
                    }
                    this.f53958g = gVar;
                    return;
                }
                this.f53953b = true;
                this.f53955d = gVar;
                long j6 = this.f53956e;
                try {
                    d();
                    if (gVar == null || j6 == 0) {
                        return;
                    }
                    gVar.request(j6);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f53953b = false;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements g {
        a() {
        }

        @Override // rx.g
        public void request(long j6) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0009, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void d() {
        /*
            Method dump skipped, instructions count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.b.d():void");
    }

    @Override // rx.g
    public void request(long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j6 == 0) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f53953b) {
                    this.f53957f += j6;
                    return;
                }
                this.f53953b = true;
                g gVar = this.f53955d;
                try {
                    long j7 = this.f53956e + j6;
                    if (j7 < 0) {
                        j7 = Long.MAX_VALUE;
                    }
                    this.f53956e = j7;
                    d();
                    if (gVar != null) {
                        gVar.request(j6);
                    }
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f53953b = false;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public b(l<? super T> lVar) {
        this.f53952a = lVar;
    }
}
