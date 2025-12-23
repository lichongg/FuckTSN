package com.ss.android.socialbase.downloader.impls;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\Downloads\app\classes6.dex */
public class up extends j {
    private static com.ss.android.socialbase.downloader.ws.r xt;

    public static void cw(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService av = com.ss.android.socialbase.downloader.downloader.cw.av();
        if (av != null) {
            av.invokeAll(list);
        }
    }

    public static Runnable up(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                ExecutorService av = com.ss.android.socialbase.downloader.downloader.cw.av();
                if ((av instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) av).getQueue()) != null && !queue.isEmpty()) {
                    Iterator<Future> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            runnable = null;
                            break;
                        }
                        Future next = it.next();
                        if ((next instanceof Runnable) && queue.remove(next)) {
                            runnable = (Runnable) next;
                            break;
                        }
                    }
                    if (runnable != null) {
                        list.remove(runnable);
                        return runnable;
                    }
                }
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.m.j.r("DefaultDownloadEngine", "getUnstartedTask() error: " + th.toString());
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.impls.j
    public boolean j(int i6) {
        com.ss.android.socialbase.downloader.ae.cw r5;
        com.ss.android.socialbase.downloader.ws.r rVar = xt;
        if (rVar == null || !rVar.j(i6) || (r5 = r(i6)) == null) {
            return false;
        }
        if (com.ss.android.socialbase.downloader.xt.m.xt(r5.i())) {
            return true;
        }
        xt(i6);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.j
    public void xt(int i6) {
        com.ss.android.socialbase.downloader.ws.r rVar = xt;
        if (rVar == null) {
            return;
        }
        rVar.cw(i6);
    }

    public up() {
        xt = new com.ss.android.socialbase.downloader.ws.r();
    }

    public static List<Future> r(List<Runnable> list) {
        ExecutorService av = com.ss.android.socialbase.downloader.downloader.cw.av();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(av.submit(it.next()));
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.impls.j
    protected com.ss.android.socialbase.downloader.ws.cw cw(int i6) {
        com.ss.android.socialbase.downloader.ws.r rVar = xt;
        if (rVar == null) {
            return null;
        }
        return rVar.xt(i6);
    }

    @Override // com.ss.android.socialbase.downloader.impls.j
    public void j(com.ss.android.socialbase.downloader.ws.cw cwVar) {
        com.ss.android.socialbase.downloader.ws.r rVar = xt;
        if (rVar == null) {
            return;
        }
        rVar.xt(cwVar);
    }

    @Override // com.ss.android.socialbase.downloader.impls.j
    public void j(int i6, com.ss.android.socialbase.downloader.ae.r rVar) {
        if (rVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.m.j.xt("DownloadTask", "start doDownload for task : ".concat(String.valueOf(i6)));
        xt.j(new com.ss.android.socialbase.downloader.ws.cw(rVar, this.f38842j));
    }

    @Override // com.ss.android.socialbase.downloader.impls.j
    public List<Integer> j() {
        return xt.j();
    }

    @Override // com.ss.android.socialbase.downloader.impls.j
    public void j(int i6, long j6) {
        com.ss.android.socialbase.downloader.ws.r rVar = xt;
        if (rVar == null) {
            return;
        }
        rVar.j(i6, j6);
    }
}
