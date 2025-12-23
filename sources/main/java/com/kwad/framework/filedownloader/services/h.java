package com.kwad.framework.filedownloader.services;

import android.util.SparseArray;
import com.kwad.framework.filedownloader.download.DownloadLaunchRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class h {
    private ThreadPoolExecutor apu;
    private int apw;
    private SparseArray<DownloadLaunchRunnable> apt = new SparseArray<>();
    private final String apv = "Network";
    private int apx = 0;

    private synchronized void zt() {
        try {
            SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
            int size = this.apt.size();
            for (int i6 = 0; i6 < size; i6++) {
                int keyAt = this.apt.keyAt(i6);
                DownloadLaunchRunnable downloadLaunchRunnable = this.apt.get(keyAt);
                if (downloadLaunchRunnable.isAlive()) {
                    sparseArray.put(keyAt, downloadLaunchRunnable);
                }
            }
            this.apt = sparseArray;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean bQ(int i6) {
        if (zu() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int ce = com.kwad.framework.filedownloader.f.e.ce(i6);
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.apw), Integer.valueOf(ce));
        }
        List<Runnable> shutdownNow = this.apu.shutdownNow();
        this.apu = com.kwad.framework.filedownloader.f.b.r(ce, "Network");
        if (shutdownNow.size() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
        }
        this.apw = ce;
        return true;
    }

    public final int o(String str, int i6) {
        if (str == null) {
            return 0;
        }
        int size = this.apt.size();
        for (int i7 = 0; i7 < size; i7++) {
            DownloadLaunchRunnable valueAt = this.apt.valueAt(i7);
            if (valueAt != null && valueAt.isAlive() && valueAt.getId() != i6 && str.equals(valueAt.yr())) {
                return valueAt.getId();
            }
        }
        return 0;
    }

    public final synchronized int zu() {
        zt();
        return this.apt.size();
    }

    public final synchronized List<Integer> zv() {
        ArrayList arrayList;
        zt();
        arrayList = new ArrayList();
        for (int i6 = 0; i6 < this.apt.size(); i6++) {
            SparseArray<DownloadLaunchRunnable> sparseArray = this.apt;
            arrayList.add(Integer.valueOf(sparseArray.get(sparseArray.keyAt(i6)).getId()));
        }
        return arrayList;
    }

    public final boolean cd(int i6) {
        DownloadLaunchRunnable downloadLaunchRunnable = this.apt.get(i6);
        return downloadLaunchRunnable != null && downloadLaunchRunnable.isAlive();
    }

    h(int i6) {
        this.apu = com.kwad.framework.filedownloader.f.b.r(i6, "Network");
        this.apw = i6;
    }

    public final void a(DownloadLaunchRunnable downloadLaunchRunnable) {
        downloadLaunchRunnable.ym();
        synchronized (this) {
            this.apt.put(downloadLaunchRunnable.getId(), downloadLaunchRunnable);
        }
        this.apu.execute(downloadLaunchRunnable);
        int i6 = this.apx;
        if (i6 >= 600) {
            zt();
            this.apx = 0;
        } else {
            this.apx = i6 + 1;
        }
    }

    public final void cancel(int i6) {
        zt();
        synchronized (this) {
            try {
                DownloadLaunchRunnable downloadLaunchRunnable = this.apt.get(i6);
                if (downloadLaunchRunnable != null) {
                    downloadLaunchRunnable.pause();
                    boolean remove = this.apu.remove(downloadLaunchRunnable);
                    if (com.kwad.framework.filedownloader.f.d.apD) {
                        com.kwad.framework.filedownloader.f.d.c(this, "successful cancel %d %B", Integer.valueOf(i6), Boolean.valueOf(remove));
                    }
                }
                this.apt.remove(i6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
