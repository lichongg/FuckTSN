package com.kwad.framework.filedownloader.services;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.kwad.framework.filedownloader.c.b;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.message.e;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d extends b.a implements e.b, i {
    private final RemoteCallbackList<com.kwad.framework.filedownloader.c.a> app = new RemoteCallbackList<>();
    private final g apq;
    private final WeakReference<FileDownloadServiceProxy> apr;

    private synchronized int v(MessageSnapshot messageSnapshot) {
        int beginBroadcast;
        try {
            beginBroadcast = this.app.beginBroadcast();
            for (int i6 = 0; i6 < beginBroadcast; i6++) {
                try {
                    try {
                        this.app.getBroadcastItem(i6).q(messageSnapshot);
                    } catch (RemoteException e6) {
                        com.kwad.framework.filedownloader.f.d.a(this, e6, "callback error", new Object[0]);
                    }
                } catch (Throwable th) {
                    this.app.finishBroadcast();
                    throw th;
                }
            }
            this.app.finishBroadcast();
        } catch (Throwable th2) {
            throw th2;
        }
        return beginBroadcast;
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void b(com.kwad.framework.filedownloader.c.a aVar) {
        this.app.unregister(aVar);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void a(com.kwad.framework.filedownloader.c.a aVar) {
        this.app.register(aVar);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void b(String str, String str2, boolean z5, int i6, int i7, int i8, boolean z6, com.kwad.framework.filedownloader.d.b bVar, boolean z7) {
        this.apq.b(str, str2, z5, i6, i7, i8, z6, bVar, z7);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean bQ(int i6) {
        return this.apq.bQ(i6);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final long bR(int i6) {
        return this.apq.cc(i6);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final long bS(int i6) {
        return this.apq.bS(i6);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean bw(int i6) {
        return this.apq.bw(i6);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final byte bx(int i6) {
        return this.apq.bx(i6);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean by(int i6) {
        return this.apq.by(i6);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean isIdle() {
        return this.apq.isIdle();
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void pauseAllTasks() {
        this.apq.zs();
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void startForeground(int i6, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.apr;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.apr.get().context.startForeground(i6, notification);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void stopForeground(boolean z5) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.apr;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.apr.get().context.stopForeground(z5);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean x(String str, String str2) {
        return this.apq.z(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void yJ() {
        this.apq.yJ();
    }

    d(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
        this.apr = weakReference;
        this.apq = gVar;
        com.kwad.framework.filedownloader.message.e.yT().a(this);
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final void onDestroy() {
        com.kwad.framework.filedownloader.message.e.yT().a(null);
    }

    @Override // com.kwad.framework.filedownloader.message.e.b
    public final void r(MessageSnapshot messageSnapshot) {
        v(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final void zp() {
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final IBinder zq() {
        return this;
    }
}
