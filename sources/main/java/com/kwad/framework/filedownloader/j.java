package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j {
    static int alZ = 10;
    static int ama = 5;
    private final Executor alV;
    private final LinkedBlockingQueue<t> alW;
    private final Object alX;
    private final ArrayList<t> alY;
    private final Handler handler;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {
        private static final j amd = new j(0);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements Handler.Callback {
        private b() {
        }

        /* synthetic */ b(byte b6) {
            this();
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i6 = message.what;
            if (i6 == 1) {
                ((t) message.obj).xv();
            } else if (i6 == 2) {
                a((ArrayList) message.obj);
                j.xr().push();
            }
            return true;
        }

        private static void a(ArrayList<t> arrayList) {
            Iterator<t> it = arrayList.iterator();
            while (it.hasNext()) {
                t next = it.next();
                if (next != null) {
                    next.xv();
                }
            }
            arrayList.clear();
        }
    }

    /* synthetic */ j(byte b6) {
        this();
    }

    private j() {
        this.alV = com.kwad.framework.filedownloader.f.b.r(5, "BlockCompleted");
        this.alX = new Object();
        this.alY = new ArrayList<>();
        this.handler = new Handler(Looper.getMainLooper(), new b((byte) 0));
        this.alW = new LinkedBlockingQueue<>();
    }

    private void b(t tVar) {
        Handler handler = this.handler;
        handler.sendMessage(handler.obtainMessage(1, tVar));
    }

    private void c(t tVar) {
        synchronized (this.alX) {
            this.alW.offer(tVar);
        }
        push();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void push() {
        synchronized (this.alX) {
            try {
                if (this.alY.isEmpty()) {
                    if (this.alW.isEmpty()) {
                        return;
                    }
                    int i6 = 0;
                    if (xs()) {
                        int i7 = alZ;
                        int min = Math.min(this.alW.size(), ama);
                        while (i6 < min) {
                            this.alY.add(this.alW.remove());
                            i6++;
                        }
                        i6 = i7;
                    } else {
                        this.alW.drainTo(this.alY);
                    }
                    Handler handler = this.handler;
                    handler.sendMessageDelayed(handler.obtainMessage(2, this.alY), i6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean xs() {
        return alZ > 0;
    }

    final void a(t tVar) {
        a(tVar, false);
    }

    private void a(final t tVar, boolean z5) {
        if (tVar.xw()) {
            tVar.xv();
            return;
        }
        if (tVar.xx()) {
            this.alV.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.j.1
                @Override // java.lang.Runnable
                public final void run() {
                    tVar.xv();
                }
            });
            return;
        }
        if (!xs() && !this.alW.isEmpty()) {
            synchronized (this.alX) {
                try {
                    if (!this.alW.isEmpty()) {
                        Iterator<t> it = this.alW.iterator();
                        while (it.hasNext()) {
                            b(it.next());
                        }
                    }
                    this.alW.clear();
                } finally {
                }
            }
        }
        if (!xs()) {
            b(tVar);
        } else {
            c(tVar);
        }
    }

    public static j xr() {
        return a.amd;
    }
}
