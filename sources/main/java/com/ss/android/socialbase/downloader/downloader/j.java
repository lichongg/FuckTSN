package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class j implements i {
    private static final String up = "j";
    protected volatile boolean cw;

    /* renamed from: m, reason: collision with root package name */
    private WeakReference<Service> f38754m;

    /* renamed from: j, reason: collision with root package name */
    protected final SparseArray<List<com.ss.android.socialbase.downloader.ae.r>> f38753j = new SparseArray<>();
    protected volatile boolean xt = false;

    /* renamed from: r, reason: collision with root package name */
    protected volatile boolean f38755r = false;
    private Handler ae = new Handler(Looper.getMainLooper());
    private Runnable tl = new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.j.1
        @Override // java.lang.Runnable
        public void run() {
            if (com.ss.android.socialbase.downloader.m.j.j()) {
                com.ss.android.socialbase.downloader.m.j.xt(j.up, "tryDownload: 2 try");
            }
            if (!j.this.xt) {
                if (com.ss.android.socialbase.downloader.m.j.j()) {
                    com.ss.android.socialbase.downloader.m.j.xt(j.up, "tryDownload: 2 error");
                }
                j.this.startService(cw.nd(), null);
            }
        }
    };

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void cw() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void j(Intent intent, int i6, int i7) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void r() {
        this.xt = false;
    }

    protected void startService(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean xt() {
        com.ss.android.socialbase.downloader.m.j.cw(up, "isServiceForeground = " + this.cw);
        return this.cw;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void cw(com.ss.android.socialbase.downloader.ae.r rVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void j(av avVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void startService() {
        if (this.xt) {
            return;
        }
        if (com.ss.android.socialbase.downloader.m.j.j()) {
            com.ss.android.socialbase.downloader.m.j.xt(up, "startService");
        }
        startService(cw.nd(), null);
    }

    protected void up() {
        SparseArray<List<com.ss.android.socialbase.downloader.ae.r>> clone;
        synchronized (this.f38753j) {
            com.ss.android.socialbase.downloader.m.j.xt(up, "resumePendingTask pendingTasks.size:" + this.f38753j.size());
            clone = this.f38753j.clone();
            this.f38753j.clear();
        }
        com.ss.android.socialbase.downloader.impls.j p5 = cw.p();
        if (p5 != null) {
            for (int i6 = 0; i6 < clone.size(); i6++) {
                List<com.ss.android.socialbase.downloader.ae.r> list = clone.get(clone.keyAt(i6));
                if (list != null) {
                    for (com.ss.android.socialbase.downloader.ae.r rVar : list) {
                        com.ss.android.socialbase.downloader.m.j.xt(up, "resumePendingTask key:" + rVar.i());
                        p5.j(rVar);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void j(WeakReference weakReference) {
        this.f38754m = weakReference;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void xt(com.ss.android.socialbase.downloader.ae.r rVar) {
        if (rVar == null) {
            return;
        }
        if (!this.xt) {
            if (com.ss.android.socialbase.downloader.m.j.j()) {
                com.ss.android.socialbase.downloader.m.j.xt(up, "tryDownload but service is not alive");
            }
            if (com.ss.android.socialbase.downloader.az.j.j(262144)) {
                j(rVar);
                if (!this.f38755r) {
                    if (com.ss.android.socialbase.downloader.m.j.j()) {
                        com.ss.android.socialbase.downloader.m.j.xt(up, "tryDownload: 1");
                    }
                    startService(cw.nd(), null);
                    this.f38755r = true;
                    return;
                }
                this.ae.removeCallbacks(this.tl);
                this.ae.postDelayed(this.tl, 10L);
                return;
            }
            j(rVar);
            startService(cw.nd(), null);
            return;
        }
        String str = up;
        com.ss.android.socialbase.downloader.m.j.xt(str, "tryDownload when isServiceAlive");
        up();
        com.ss.android.socialbase.downloader.impls.j p5 = cw.p();
        if (p5 != null) {
            com.ss.android.socialbase.downloader.m.j.xt(str, "tryDownload current task: " + rVar.i());
            p5.j(rVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean j() {
        return this.xt;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public IBinder j(Intent intent) {
        com.ss.android.socialbase.downloader.m.j.xt(up, "onBind Abs");
        return new Binder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void j(int i6, Notification notification) {
        WeakReference<Service> weakReference = this.f38754m;
        if (weakReference != null && weakReference.get() != null) {
            com.ss.android.socialbase.downloader.m.j.cw(up, "startForeground  id = " + i6 + ", service = " + this.f38754m.get() + ",  isServiceAlive = " + this.xt);
            try {
                this.f38754m.get().startForeground(i6, notification);
                this.cw = true;
                return;
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
                return;
            }
        }
        com.ss.android.socialbase.downloader.m.j.r(up, "startForeground: downloadService is null, do nothing!");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void j(boolean z5) {
        WeakReference<Service> weakReference = this.f38754m;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        com.ss.android.socialbase.downloader.m.j.cw(up, "stopForeground  service = " + this.f38754m.get() + ",  isServiceAlive = " + this.xt);
        try {
            this.cw = false;
            this.f38754m.get().stopForeground(z5);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    public void j(com.ss.android.socialbase.downloader.ae.r rVar) {
        if (rVar == null) {
            return;
        }
        int i6 = rVar.i();
        synchronized (this.f38753j) {
            try {
                String str = up;
                com.ss.android.socialbase.downloader.m.j.xt(str, "pendDownloadTask pendingTasks.size:" + this.f38753j.size() + " downloadId:" + i6);
                List<com.ss.android.socialbase.downloader.ae.r> list = this.f38753j.get(i6);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f38753j.put(i6, list);
                }
                com.ss.android.socialbase.downloader.m.j.xt(str, "before pendDownloadTask taskArray.size:" + list.size());
                list.add(rVar);
                com.ss.android.socialbase.downloader.m.j.xt(str, "after pendDownloadTask pendingTasks.size:" + this.f38753j.size());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void j(int i6) {
        com.ss.android.socialbase.downloader.m.j.j(i6);
    }

    protected void stopService(Context context, ServiceConnection serviceConnection) {
    }
}
