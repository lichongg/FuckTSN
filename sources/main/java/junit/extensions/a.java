package junit.extensions;

import junit.framework.f;
import junit.framework.g;
import junit.framework.j;
import junit.framework.k;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class a extends k {

    /* renamed from: c, reason: collision with root package name */
    private volatile int f43460c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: junit.extensions.a$a, reason: collision with other inner class name */
    class C0858a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f43461a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f43462b;

        C0858a(f fVar, j jVar) {
            this.f43461a = fVar;
            this.f43462b = jVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.f43461a.a(this.f43462b);
            } finally {
                a.this.t();
            }
        }
    }

    public a() {
    }

    @Override // junit.framework.k, junit.framework.f
    public void a(j jVar) {
        this.f43460c = 0;
        super.a(jVar);
        u();
    }

    public synchronized void t() {
        this.f43460c++;
        notifyAll();
    }

    synchronized void u() {
        while (this.f43460c < q()) {
            try {
                wait();
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public a(Class<? extends g> cls) {
        super(cls);
    }

    @Override // junit.framework.k
    public void m(f fVar, j jVar) {
        new C0858a(fVar, jVar).start();
    }

    public a(String str) {
        super(str);
    }

    public a(Class<? extends g> cls, String str) {
        super(cls, str);
    }
}
