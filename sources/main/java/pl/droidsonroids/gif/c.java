package pl.droidsonroids.gif;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f51801a;

    synchronized void a() throws InterruptedException {
        while (!this.f51801a) {
            wait();
        }
    }

    synchronized void b() {
        this.f51801a = false;
    }

    synchronized void c() {
        boolean z5 = this.f51801a;
        this.f51801a = true;
        if (!z5) {
            notify();
        }
    }

    synchronized void d(boolean z5) {
        try {
            if (z5) {
                c();
            } else {
                b();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    c() {
    }
}
