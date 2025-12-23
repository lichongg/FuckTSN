package com.kwad.framework.filedownloader.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.kwad.framework.filedownloader.b.a;
import com.kwad.framework.filedownloader.f.f;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c implements a {
    private volatile Thread amO;
    private Handler handler;
    private volatile List<Integer> amM = new CopyOnWriteArrayList();
    private AtomicInteger amN = new AtomicInteger();
    private final b amJ = new b();
    private final d amK = new d();
    private final long amL = com.kwad.framework.filedownloader.f.e.zB().apF;

    static /* synthetic */ Thread a(c cVar, Thread thread) {
        cVar.amO = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(int i6) {
        this.amK.b(this.amJ.bD(i6));
        List<com.kwad.framework.filedownloader.d.a> bE = this.amJ.bE(i6);
        this.amK.bF(i6);
        Iterator<com.kwad.framework.filedownloader.d.a> it = bE.iterator();
        while (it.hasNext()) {
            this.amK.a(it.next());
        }
    }

    private boolean bJ(int i6) {
        return !this.amM.contains(Integer.valueOf(i6));
    }

    private void bK(int i6) {
        this.handler.removeMessages(i6);
        if (this.amN.get() != i6) {
            bI(i6);
            return;
        }
        this.amO = Thread.currentThread();
        this.handler.sendEmptyMessage(0);
        LockSupport.park();
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i6, long j6) {
        this.amJ.b(i6, j6);
        if (bJ(i6)) {
            return;
        }
        this.amK.b(i6, j6);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bC(int i6) {
        this.handler.sendEmptyMessageDelayed(i6, this.amL);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bD(int i6) {
        return this.amJ.bD(i6);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> bE(int i6) {
        return this.amJ.bE(i6);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bF(int i6) {
        this.amJ.bF(i6);
        if (bJ(i6)) {
            return;
        }
        this.amK.bF(i6);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bG(int i6) {
        this.amK.bG(i6);
        return this.amJ.bG(i6);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bH(int i6) {
        this.amJ.bH(i6);
        if (bJ(i6)) {
            return;
        }
        this.amK.bH(i6);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i6, long j6) {
        this.amJ.c(i6, j6);
        if (bJ(i6)) {
            this.handler.removeMessages(i6);
            if (this.amN.get() == i6) {
                this.amO = Thread.currentThread();
                this.handler.sendEmptyMessage(0);
                LockSupport.park();
            }
            this.amM.remove(Integer.valueOf(i6));
        }
        this.amK.c(i6, j6);
        this.amM.remove(Integer.valueOf(i6));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        this.amJ.clear();
        this.amK.clear();
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i6, long j6) {
        this.amJ.d(i6, j6);
        if (bJ(i6)) {
            bK(i6);
        }
        this.amK.d(i6, j6);
        this.amM.remove(Integer.valueOf(i6));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void t(int i6, int i7) {
        this.amJ.t(i6, i7);
        if (bJ(i6)) {
            return;
        }
        this.amK.t(i6, i7);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0654a xT() {
        d dVar = this.amK;
        b bVar = this.amJ;
        return dVar.a(bVar.amG, bVar.amH);
    }

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.bG("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.kwad.framework.filedownloader.b.c.1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                int i6 = message.what;
                if (i6 == 0) {
                    if (c.this.amO != null) {
                        LockSupport.unpark(c.this.amO);
                        c.a(c.this, (Thread) null);
                    }
                    return false;
                }
                try {
                    c.this.amN.set(i6);
                    c.this.bI(i6);
                    c.this.amM.add(Integer.valueOf(i6));
                    return false;
                } finally {
                    c.this.amN.set(0);
                    if (c.this.amO != null) {
                        LockSupport.unpark(c.this.amO);
                        c.a(c.this, (Thread) null);
                    }
                }
            }
        });
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        this.amJ.a(aVar);
        if (bJ(aVar.getId())) {
            return;
        }
        this.amK.a(aVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        this.amJ.b(cVar);
        if (bJ(cVar.getId())) {
            return;
        }
        this.amK.b(cVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i6, int i7, long j6) {
        this.amJ.a(i6, i7, j6);
        if (bJ(i6)) {
            return;
        }
        this.amK.a(i6, i7, j6);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i6, String str, long j6, long j7, int i7) {
        this.amJ.a(i6, str, j6, j7, i7);
        if (bJ(i6)) {
            return;
        }
        this.amK.a(i6, str, j6, j7, i7);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i6, long j6, String str, String str2) {
        this.amJ.a(i6, j6, str, str2);
        if (bJ(i6)) {
            return;
        }
        this.amK.a(i6, j6, str, str2);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i6, Throwable th) {
        this.amJ.a(i6, th);
        if (bJ(i6)) {
            return;
        }
        this.amK.a(i6, th);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i6, Throwable th, long j6) {
        this.amJ.a(i6, th, j6);
        if (bJ(i6)) {
            bK(i6);
        }
        this.amK.a(i6, th, j6);
        this.amM.remove(Integer.valueOf(i6));
    }
}
