package pl.droidsonroids.gif;

import java.lang.Thread;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final e f51861a;

    abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f51861a.v()) {
                return;
            }
            a();
        } catch (Throwable th) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
            throw th;
        }
    }

    s(e eVar) {
        this.f51861a = eVar;
    }
}
