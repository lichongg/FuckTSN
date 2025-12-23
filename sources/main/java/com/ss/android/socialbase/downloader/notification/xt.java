package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.downloader.ae;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes6.dex */
public class xt {
    private static volatile xt cw;
    private static final Object up = new Object();

    /* renamed from: j, reason: collision with root package name */
    private final long f38898j = 1000;
    private final Map<Integer, Long> xt = new HashMap();

    /* renamed from: r, reason: collision with root package name */
    private final Set<String> f38900r = new HashSet();

    /* renamed from: m, reason: collision with root package name */
    private final SparseArray<j> f38899m = new SparseArray<>();

    static boolean cw(cw cwVar) {
        return cwVar.hw() && xt(cwVar.qo());
    }

    public static xt j() {
        if (cw == null) {
            synchronized (xt.class) {
                try {
                    if (cw == null) {
                        cw = new xt();
                    }
                } finally {
                }
            }
        }
        return cw;
    }

    static boolean xt(int i6) {
        return i6 == 1 || i6 == 3;
    }

    public void cw(int i6) {
        Context nd = com.ss.android.socialbase.downloader.downloader.cw.nd();
        if (nd == null || i6 == 0) {
            return;
        }
        Intent intent = new Intent(nd, (Class<?>) DownloadNotificationService.class);
        try {
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i6);
            if (com.ss.android.socialbase.downloader.jy.j.cw().xt("enable_target_34") > 0) {
                com.ss.android.socialbase.downloader.vl.j.j().j(intent);
            } else {
                nd.startService(intent);
            }
        } catch (Throwable th) {
            vl.j(th);
            if (com.ss.android.socialbase.downloader.jy.j.cw().xt("enable_target_34") > 0) {
                com.ss.android.socialbase.downloader.vl.j.j().j(intent);
            }
        }
    }

    public j r(int i6) {
        j jVar;
        if (i6 == 0) {
            return null;
        }
        synchronized (this.f38899m) {
            try {
                jVar = this.f38899m.get(i6);
                if (jVar != null) {
                    this.f38899m.remove(i6);
                    com.ss.android.socialbase.downloader.m.j.j("removeNotificationId ".concat(String.valueOf(i6)));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return jVar;
    }

    public j up(int i6) {
        j jVar;
        if (i6 == 0) {
            return null;
        }
        synchronized (this.f38899m) {
            jVar = this.f38899m.get(i6);
        }
        return jVar;
    }

    void xt(cw cwVar) {
        if (cw(cwVar)) {
            m(cwVar.ae());
        }
    }

    private xt() {
    }

    public void m(int i6) {
        r(i6);
        if (i6 != 0) {
            j().cw(i6);
        }
    }

    SparseArray<j> xt() {
        SparseArray<j> sparseArray;
        synchronized (this.f38899m) {
            sparseArray = this.f38899m;
        }
        return sparseArray;
    }

    public void j(int i6) {
        cw tl = ae.xt(com.ss.android.socialbase.downloader.downloader.cw.nd()).tl(i6);
        if (tl == null) {
            return;
        }
        j(tl);
        xt(tl);
    }

    void j(cw cwVar) {
        com.ss.android.socialbase.downloader.downloader.vl x5 = com.ss.android.socialbase.downloader.downloader.cw.x();
        if (x5 != null && cwVar.hw()) {
            cwVar.m(3);
            try {
                x5.j(cwVar);
            } catch (SQLiteException e6) {
                vl.j(e6);
            }
        }
    }

    public void j(int i6, int i7, Notification notification) {
        Context nd = com.ss.android.socialbase.downloader.downloader.cw.nd();
        if (nd == null || i6 == 0 || notification == null) {
            return;
        }
        if (i7 == 4) {
            synchronized (this.xt) {
                try {
                    Long l6 = this.xt.get(Integer.valueOf(i6));
                    long currentTimeMillis = System.currentTimeMillis();
                    if (l6 != null && Math.abs(currentTimeMillis - l6.longValue()) < 1000) {
                        return;
                    } else {
                        this.xt.put(Integer.valueOf(i6), Long.valueOf(currentTimeMillis));
                    }
                } finally {
                }
            }
        }
        Intent intent = new Intent(nd, (Class<?>) DownloadNotificationService.class);
        try {
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
            intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i7);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i6);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
            if (com.ss.android.socialbase.downloader.jy.j.cw().xt("enable_target_34") > 0) {
                com.ss.android.socialbase.downloader.vl.j.j().j(intent);
            } else {
                nd.startService(intent);
            }
        } catch (Throwable th) {
            vl.j(th);
            if (com.ss.android.socialbase.downloader.jy.j.cw().xt("enable_target_34") > 0) {
                com.ss.android.socialbase.downloader.vl.j.j().j(intent);
            }
        }
    }

    public void j(j jVar) {
        if (jVar == null) {
            return;
        }
        synchronized (this.f38899m) {
            this.f38899m.put(jVar.j(), jVar);
        }
    }
}
