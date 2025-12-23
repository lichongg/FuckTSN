package com.ss.android.socialbase.downloader.ws;

import android.util.SparseArray;
import com.bytedance.sdk.component.utils.vl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes6.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private static ExecutorService f39013j = new com.bytedance.sdk.component.oq.r.r(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new j("Download_OP_Thread"));
    private int cw = 0;
    private volatile SparseArray<cw> xt = new SparseArray<>();

    private void xt() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i6 = 0; i6 < this.xt.size(); i6++) {
                int keyAt = this.xt.keyAt(i6);
                if (!this.xt.get(keyAt).r()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
            }
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                try {
                    Integer num = (Integer) arrayList.get(i7);
                    if (num != null) {
                        this.xt.remove(num.intValue());
                    }
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
        } catch (Throwable th2) {
            vl.j(th2);
        }
    }

    public void cw(int i6) {
        synchronized (r.class) {
            try {
                xt();
                cw cwVar = this.xt.get(i6);
                if (cwVar != null) {
                    cwVar.j();
                    cw(cwVar);
                    this.xt.remove(i6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j(cw cwVar) {
        cwVar.m();
        synchronized (r.class) {
            try {
                int i6 = this.cw;
                if (i6 >= 500) {
                    xt();
                    this.cw = 0;
                } else {
                    this.cw = i6 + 1;
                }
                this.xt.put(cwVar.up(), cwVar);
            } finally {
            }
        }
        com.ss.android.socialbase.downloader.ae.r cw = cwVar.cw();
        try {
            ExecutorService az = com.ss.android.socialbase.downloader.downloader.cw.az();
            if (cw != null && cw.j() != null) {
                if ("mime_type_plg".equals(cw.j().xw()) && com.ss.android.socialbase.downloader.jy.j.cw().j("divide_plugin", 1) == 1) {
                    cw.j().j("executor_group", (Object) 3);
                }
                int mp = cw.j().mp();
                if (mp == 3) {
                    az = com.ss.android.socialbase.downloader.downloader.cw.jy();
                } else if (mp == 4) {
                    az = com.ss.android.socialbase.downloader.downloader.cw.ws();
                }
            }
            if (az == null) {
                com.ss.android.socialbase.downloader.tl.j.j(cw.up(), cw.j(), new com.ss.android.socialbase.downloader.up.j(1003, "execute failed cpu thread executor service is null"), cw.j() != null ? cw.j().i() : 0);
            } else if (com.ss.android.socialbase.downloader.jy.j.j(cwVar.up()).xt("pause_with_interrupt", false)) {
                cwVar.j(az.submit(cwVar));
            } else {
                az.execute(cwVar);
            }
        } catch (Exception e6) {
            if (cw != null) {
                com.ss.android.socialbase.downloader.tl.j.j(cw.up(), cw.j(), new com.ss.android.socialbase.downloader.up.j(1003, com.ss.android.socialbase.downloader.az.m.xt(e6, "DownloadThreadPoolExecute")), cw.j() != null ? cw.j().i() : 0);
            }
            vl.j(e6);
        } catch (OutOfMemoryError e7) {
            if (cw != null) {
                com.ss.android.socialbase.downloader.tl.j.j(cw.up(), cw.j(), new com.ss.android.socialbase.downloader.up.j(1003, "execute OOM"), cw.j() != null ? cw.j().i() : 0);
            }
            vl.j(e7);
        }
    }

    private void cw(cw cwVar) {
        Future ae;
        if (cwVar == null) {
            return;
        }
        try {
            ExecutorService az = com.ss.android.socialbase.downloader.downloader.cw.az();
            com.ss.android.socialbase.downloader.ae.r cw = cwVar.cw();
            if (cw != null && cw.j() != null) {
                int mp = cw.j().mp();
                if (mp == 3) {
                    az = com.ss.android.socialbase.downloader.downloader.cw.jy();
                } else if (mp == 4) {
                    az = com.ss.android.socialbase.downloader.downloader.cw.ws();
                }
            }
            if (az == null || !(az instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) az).remove(cwVar);
            if (!com.ss.android.socialbase.downloader.jy.j.j(cwVar.up()).xt("pause_with_interrupt", false) || (ae = cwVar.ae()) == null) {
                return;
            }
            ae.cancel(true);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public void xt(cw cwVar) {
        if (cwVar == null) {
            return;
        }
        synchronized (r.class) {
            try {
                if (com.ss.android.socialbase.downloader.az.j.j(524288)) {
                    int indexOfValue = this.xt.indexOfValue(cwVar);
                    if (indexOfValue >= 0) {
                        this.xt.removeAt(indexOfValue);
                    }
                } else {
                    this.xt.remove(cwVar.up());
                }
            } finally {
            }
        }
    }

    public cw xt(int i6) {
        synchronized (r.class) {
            try {
                xt();
                cw cwVar = this.xt.get(i6);
                if (cwVar == null) {
                    return null;
                }
                cwVar.xt();
                cw(cwVar);
                this.xt.remove(i6);
                return cwVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean j(int i6) {
        synchronized (r.class) {
            try {
                boolean z5 = false;
                if (this.xt != null && this.xt.size() > 0) {
                    cw cwVar = this.xt.get(i6);
                    if (cwVar != null && cwVar.r()) {
                        z5 = true;
                    }
                    return z5;
                }
                return false;
            } finally {
            }
        }
    }

    public List<Integer> j() {
        ArrayList arrayList;
        synchronized (r.class) {
            try {
                xt();
                arrayList = new ArrayList();
                for (int i6 = 0; i6 < this.xt.size(); i6++) {
                    cw cwVar = this.xt.get(this.xt.keyAt(i6));
                    if (cwVar != null) {
                        arrayList.add(Integer.valueOf(cwVar.up()));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public void j(int i6, long j6) {
        this.xt.get(i6);
    }
}
