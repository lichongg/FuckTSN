package com.ss.android.socialbase.downloader.g.j;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import androidx.work.PeriodicWorkRequest;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.downloader.ae.up;
import com.ss.android.socialbase.downloader.az.m;
import com.ss.android.socialbase.downloader.g.qv;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes6.dex */
public class xt {
    private static final HandlerThread cw;

    /* renamed from: j, reason: collision with root package name */
    static long f38812j;

    /* renamed from: r, reason: collision with root package name */
    private static final Handler f38813r;
    static long xt;

    private static void xt() {
        f38812j = com.ss.android.socialbase.downloader.jy.j.cw().j("preconnect_connection_outdate_time", PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        xt = com.ss.android.socialbase.downloader.jy.j.cw().j("preconnect_head_info_outdate_time", PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        j.j().j(com.ss.android.socialbase.downloader.jy.j.cw().j("preconnect_max_cache_size", 3));
    }

    static {
        HandlerThread handlerThread = new HandlerThread("Downloader-preconnecter");
        cw = handlerThread;
        xt();
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        f38813r = handler;
        handler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.g.j.xt.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static Looper j() {
        return cw.getLooper();
    }

    public static void j(final String str, final qv qvVar) {
        f38813r.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.g.j.xt.2
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    qv qvVar2 = qvVar;
                    if (qvVar2 != null) {
                        qvVar2.j(null);
                        return;
                    }
                    return;
                }
                try {
                    try {
                        List<up> xt2 = xt.xt(0L, null, null);
                        r1 = j.j().j(str) ? j.j().j(str, xt2) : null;
                        if (r1 == null) {
                            cw cwVar = new cw(str, xt2, 0L);
                            try {
                                cwVar.j();
                                if (cwVar.up()) {
                                    j.j().j(str, cwVar);
                                }
                                r1 = cwVar;
                            } catch (Exception e6) {
                                e = e6;
                                r1 = cwVar;
                                vl.j(e);
                                try {
                                    r1.cw();
                                    return;
                                } catch (Throwable unused) {
                                    return;
                                }
                            } catch (Throwable th) {
                                th = th;
                                r1 = cwVar;
                                try {
                                    r1.cw();
                                } catch (Throwable unused2) {
                                }
                                throw th;
                            }
                        }
                        Map<String, String> g6 = r1.g();
                        qv qvVar3 = qvVar;
                        if (qvVar3 != null) {
                            qvVar3.j(g6);
                        }
                        try {
                            r1.cw();
                        } catch (Throwable unused3) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e7) {
                    e = e7;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<up> xt(long j6, com.ss.android.socialbase.downloader.ae.cw cwVar, List<up> list) {
        return m.j(list, cwVar == null ? null : cwVar.u(), j6, 0L);
    }
}
