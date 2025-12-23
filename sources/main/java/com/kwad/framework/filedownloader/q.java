package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.x;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class q {
    private final b amo = new b();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final q amp = new q();

        static {
            com.kwad.framework.filedownloader.message.e.yT().a(new aa());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b {
        private ThreadPoolExecutor amq;
        private LinkedBlockingQueue<Runnable> amr;

        private void init() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.amr = linkedBlockingQueue;
            this.amq = com.kwad.framework.filedownloader.f.b.a(3, linkedBlockingQueue, "LauncherTask");
        }

        public final void b(x.b bVar) {
            this.amr.remove(bVar);
        }

        public final void c(x.b bVar) {
            this.amq.execute(new c(bVar));
        }

        b() {
            init();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c implements Runnable {
        private final x.b ams;
        private boolean amt = false;

        @Override // java.lang.Runnable
        public final void run() {
            if (this.amt) {
                return;
            }
            this.ams.start();
        }

        c(x.b bVar) {
            this.ams = bVar;
        }

        public final boolean equals(Object obj) {
            if (!super.equals(obj) && obj != this.ams) {
                return false;
            }
            return true;
        }
    }

    final synchronized void a(x.b bVar) {
        this.amo.c(bVar);
    }

    final synchronized void b(x.b bVar) {
        this.amo.b(bVar);
    }

    q() {
    }

    public static q xG() {
        return a.amp;
    }
}
