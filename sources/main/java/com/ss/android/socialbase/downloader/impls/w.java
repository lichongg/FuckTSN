package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.mi;
import com.ss.android.socialbase.downloader.j.j;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class w implements Handler.Callback, j.InterfaceC0786j {

    /* renamed from: g, reason: collision with root package name */
    private static xt f38863g;

    /* renamed from: j, reason: collision with root package name */
    private static volatile w f38864j;

    /* renamed from: m, reason: collision with root package name */
    private long f38865m;
    private ConnectivityManager tl;
    private final boolean up;
    private final Handler cw = new Handler(Looper.getMainLooper(), this);

    /* renamed from: r, reason: collision with root package name */
    private final SparseArray<j> f38866r = new SparseArray<>();
    private int ae = 0;
    private final Context xt = com.ss.android.socialbase.downloader.downloader.cw.nd();

    private static class j {
        final int[] ae;
        final int cw;

        /* renamed from: g, reason: collision with root package name */
        private int f38871g;

        /* renamed from: j, reason: collision with root package name */
        final int f38872j;

        /* renamed from: m, reason: collision with root package name */
        final boolean f38873m;
        private boolean oq;
        private long qv;

        /* renamed from: r, reason: collision with root package name */
        final int f38874r;
        private int tl;
        final int up;
        private boolean vl;
        final int xt;

        void cw() {
            this.tl = this.f38874r;
        }

        int r() {
            return this.tl;
        }

        j(int i6, int i7, int i8, int i9, int i10, boolean z5, int[] iArr) {
            i9 = i9 < 3000 ? 3000 : i9;
            i10 = i10 < 5000 ? 5000 : i10;
            this.f38872j = i6;
            this.xt = i7;
            this.cw = i8;
            this.f38874r = i9;
            this.up = i10;
            this.f38873m = z5;
            this.ae = iArr;
            this.tl = i9;
        }

        boolean j(long j6, int i6, int i7, boolean z5) {
            if (!this.vl) {
                com.ss.android.socialbase.downloader.m.j.cw("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            }
            if (this.xt < i6 || this.f38871g >= this.cw) {
                return false;
            }
            if (!this.oq || i7 == 2) {
                return z5 || j6 - this.qv >= ((long) this.f38874r);
            }
            return false;
        }

        synchronized void xt() {
            this.f38871g++;
        }

        synchronized void j() {
            this.tl += this.up;
        }

        synchronized void j(long j6) {
            this.qv = j6;
        }
    }

    public interface xt {
        void j(com.ss.android.socialbase.downloader.ae.cw cwVar, long j6, boolean z5, int i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ae() {
        try {
            if (this.tl == null) {
                this.tl = (ConnectivityManager) StubApp.getOrigApplicationContext(this.xt.getApplicationContext()).getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.tl.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 ? 2 : 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private void cw(int i6) {
        synchronized (this.f38866r) {
            this.f38866r.remove(i6);
        }
    }

    private j r(int i6) {
        int[] iArr;
        int i7;
        int i8;
        boolean z5;
        com.ss.android.socialbase.downloader.jy.j j6 = com.ss.android.socialbase.downloader.jy.j.j(i6);
        boolean z6 = false;
        int j7 = j6.j("retry_schedule", 0);
        JSONObject r5 = j6.r("retry_schedule_config");
        int i9 = 60;
        if (r5 != null) {
            int optInt = r5.optInt("max_count", 60);
            int optInt2 = r5.optInt("interval_sec", 60);
            int optInt3 = r5.optInt("interval_sec_acceleration", 60);
            if (f38863g != null && r5.optInt("use_job_scheduler", 0) == 1) {
                z6 = true;
            }
            iArr = j(r5.optString("allow_error_code"));
            i7 = optInt3;
            z5 = z6;
            i8 = optInt;
            i9 = optInt2;
        } else {
            iArr = null;
            i7 = 60;
            i8 = 60;
            z5 = false;
        }
        return new j(i6, j7, i8, i9 * 1000, i7 * 1000, z5, iArr);
    }

    private void xt(final int i6, final boolean z5) {
        com.ss.android.socialbase.downloader.downloader.cw.qv().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.w.2
            @Override // java.lang.Runnable
            public void run() {
                int ae;
                try {
                    if (w.this.ae > 0 && (ae = w.this.ae()) != 0) {
                        com.ss.android.socialbase.downloader.m.j.cw("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + w.this.ae);
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        synchronized (w.this.f38866r) {
                            for (int i7 = 0; i7 < w.this.f38866r.size(); i7++) {
                                try {
                                    j jVar = (j) w.this.f38866r.valueAt(i7);
                                    if (jVar != null && jVar.j(currentTimeMillis, i6, ae, z5)) {
                                        if (z5) {
                                            jVar.cw();
                                        }
                                        arrayList.add(jVar);
                                    }
                                } finally {
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                w.this.j(((j) it.next()).f38872j, ae, false);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            xt(message.arg1, message.arg2 == 1);
        } else {
            com.ss.android.socialbase.downloader.m.j.cw("RetryScheduler", "handleMessage, doSchedulerRetry, id = " + message.what);
            j(message.what);
        }
        return true;
    }

    public void up() {
        j(5, false);
    }

    private w() {
        m();
        this.up = com.ss.android.socialbase.downloader.az.m.cw();
        com.ss.android.socialbase.downloader.j.j.j().j(this);
    }

    private void m() {
        if (com.ss.android.socialbase.downloader.jy.j.cw().j("use_network_callback", 0) != 1) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.cw.qv().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.w.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (w.this.xt != null) {
                        w wVar = w.this;
                        wVar.tl = (ConnectivityManager) StubApp.getOrigApplicationContext(wVar.xt.getApplicationContext()).getSystemService("connectivity");
                        w.this.tl.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.ss.android.socialbase.downloader.impls.w.1.1
                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public void onAvailable(Network network) {
                                com.ss.android.socialbase.downloader.m.j.xt("RetryScheduler", "network onAvailable: ");
                                w.this.j(1, true);
                            }
                        });
                    }
                } catch (Exception e6) {
                    com.bytedance.sdk.component.utils.vl.j(e6);
                }
            }
        });
    }

    private j xt(int i6) {
        j jVar;
        j jVar2 = this.f38866r.get(i6);
        if (jVar2 != null) {
            return jVar2;
        }
        synchronized (this.f38866r) {
            try {
                jVar = this.f38866r.get(i6);
                if (jVar == null) {
                    jVar = r(i6);
                }
                this.f38866r.put(i6, jVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return jVar;
    }

    public static w j() {
        if (f38864j == null) {
            synchronized (w.class) {
                try {
                    if (f38864j == null) {
                        f38864j = new w();
                    }
                } finally {
                }
            }
        }
        return f38864j;
    }

    @Override // com.ss.android.socialbase.downloader.j.j.InterfaceC0786j
    public void cw() {
        j(3, false);
    }

    @Override // com.ss.android.socialbase.downloader.j.j.InterfaceC0786j
    public void xt() {
        j(4, false);
    }

    public static void j(xt xtVar) {
        f38863g = xtVar;
    }

    public void j(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (cwVar == null || TextUtils.isEmpty(com.ss.android.socialbase.downloader.xt.up.f39040j) || !com.ss.android.socialbase.downloader.xt.up.f39040j.equals(cwVar.xw())) {
            return;
        }
        j(cwVar, cwVar.x() || cwVar.qb(), ae());
    }

    public void r() {
        j(2, true);
    }

    private void j(com.ss.android.socialbase.downloader.ae.cw cwVar, boolean z5, int i6) {
        com.ss.android.socialbase.downloader.up.j hk = cwVar.hk();
        if (hk == null) {
            return;
        }
        j xt2 = xt(cwVar.ae());
        if (xt2.f38871g > xt2.cw) {
            com.ss.android.socialbase.downloader.m.j.r("RetryScheduler", "tryStartScheduleRetry, id = " + xt2.f38872j + ", mRetryCount = " + xt2.f38871g + ", maxCount = " + xt2.cw);
            return;
        }
        int j6 = hk.j();
        if (!com.ss.android.socialbase.downloader.az.m.tl(hk) && !com.ss.android.socialbase.downloader.az.m.g(hk) && (!cwVar.sm() || !cwVar.qb())) {
            if (!j(xt2, j6)) {
                return;
            }
            com.ss.android.socialbase.downloader.m.j.cw("RetryScheduler", "allow error code, id = " + xt2.f38872j + ", error code = " + j6);
        }
        xt2.oq = z5;
        synchronized (this.f38866r) {
            try {
                if (!xt2.vl) {
                    xt2.vl = true;
                    this.ae++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int r5 = xt2.r();
        com.ss.android.socialbase.downloader.m.j.cw("RetryScheduler", "tryStartScheduleRetry: id = " + xt2.f38872j + ", delayTimeMills = " + r5 + ", mWaitingRetryTasks = " + this.ae);
        if (!xt2.f38873m) {
            if (z5) {
                return;
            }
            this.cw.removeMessages(cwVar.ae());
            this.cw.sendEmptyMessageDelayed(cwVar.ae(), r5);
            return;
        }
        if (i6 == 0) {
            xt2.cw();
        }
        xt xtVar = f38863g;
        if (xtVar != null) {
            xtVar.j(cwVar, r5, z5, i6);
        }
        if (this.up) {
            xt2.j(System.currentTimeMillis());
            xt2.xt();
            xt2.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, boolean z5) {
        if (this.ae <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z5) {
                try {
                    if (currentTimeMillis - this.f38865m < 10000) {
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f38865m = currentTimeMillis;
            com.ss.android.socialbase.downloader.m.j.cw("RetryScheduler", "scheduleAllTaskRetry, level = [" + i6 + "], force = [" + z5 + "]");
            if (z5) {
                this.cw.removeMessages(0);
            }
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.arg1 = i6;
            obtain.arg2 = z5 ? 1 : 0;
            this.cw.sendMessageDelayed(obtain, 2000L);
        }
    }

    public void j(final int i6) {
        com.ss.android.socialbase.downloader.downloader.cw.qv().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.w.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    w wVar = w.this;
                    wVar.j(i6, wVar.ae(), true);
                } catch (Exception e6) {
                    com.bytedance.sdk.component.utils.vl.j(e6);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, int i7, boolean z5) {
        mi xt2;
        boolean z6;
        Context context = this.xt;
        if (context == null) {
            return;
        }
        synchronized (this.f38866r) {
            try {
                j jVar = this.f38866r.get(i6);
                if (jVar == null) {
                    return;
                }
                boolean z7 = true;
                if (jVar.vl) {
                    jVar.vl = false;
                    int i8 = this.ae - 1;
                    this.ae = i8;
                    if (i8 < 0) {
                        this.ae = 0;
                    }
                }
                com.ss.android.socialbase.downloader.m.j.cw("RetryScheduler", "doSchedulerRetryInSubThread: downloadId = " + i6 + ", retryCount = " + jVar.f38871g + ", mWaitingRetryTasksCount = " + this.ae);
                com.ss.android.socialbase.downloader.ae.cw tl = com.ss.android.socialbase.downloader.downloader.ae.xt(context).tl(i6);
                if (tl == null) {
                    cw(i6);
                    return;
                }
                com.ss.android.socialbase.downloader.m.j.up("RetryScheduler", "doSchedulerRetryInSubThread，id:".concat(String.valueOf(i6)));
                int v5 = tl.v();
                if (v5 != -3 && v5 != -4) {
                    if (v5 == -5 || (v5 == -2 && tl.qb())) {
                        if (v5 == -2 && (xt2 = com.ss.android.socialbase.downloader.downloader.ae.xt(com.ss.android.socialbase.downloader.downloader.cw.nd()).xt()) != null) {
                            xt2.j(tl, 4, 3);
                        }
                        com.ss.android.socialbase.downloader.downloader.ws v6 = com.ss.android.socialbase.downloader.downloader.cw.v();
                        if (v6 != null) {
                            v6.j(Collections.singletonList(tl), 3);
                        }
                        cw(i6);
                        return;
                    }
                    if (v5 != -1) {
                        return;
                    }
                    if (i7 != 0) {
                        z6 = true;
                    } else if (!jVar.f38873m) {
                        return;
                    } else {
                        z6 = false;
                    }
                    com.ss.android.socialbase.downloader.up.j hk = tl.hk();
                    if (z6 && com.ss.android.socialbase.downloader.az.m.tl(hk)) {
                        z6 = j(tl, hk);
                    }
                    jVar.xt();
                    if (z6) {
                        com.ss.android.socialbase.downloader.m.j.cw("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + jVar.f38872j);
                        jVar.j(System.currentTimeMillis());
                        if (z5) {
                            jVar.j();
                        }
                        tl.xt(jVar.f38871g);
                        if (tl.i() == -1) {
                            com.ss.android.socialbase.downloader.downloader.ae.xt(context).up(tl.ae());
                            return;
                        }
                        return;
                    }
                    if (z5) {
                        jVar.j();
                    }
                    if (!tl.x() && !tl.qb()) {
                        z7 = false;
                    }
                    j(tl, z7, i7);
                    return;
                }
                cw(i6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean j(j jVar, int i6) {
        int[] iArr = jVar.ae;
        if (iArr != null && iArr.length != 0) {
            for (int i7 : iArr) {
                if (i7 == i6) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[] j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split.length <= 0) {
                return null;
            }
            int[] iArr = new int[split.length];
            for (int i6 = 0; i6 < split.length; i6++) {
                iArr[i6] = Integer.parseInt(split[i6]);
            }
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean j(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar) {
        long j6;
        long ka;
        try {
            j6 = com.ss.android.socialbase.downloader.az.m.r(cwVar.vl());
        } catch (com.ss.android.socialbase.downloader.up.j e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            j6 = 0;
        }
        if (jVar instanceof com.ss.android.socialbase.downloader.up.up) {
            ka = ((com.ss.android.socialbase.downloader.up.up) jVar).up();
        } else {
            ka = cwVar.ka() - cwVar.uq();
        }
        if (j6 < ka) {
            com.ss.android.socialbase.downloader.jy.j j7 = com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae());
            if (j7.j("space_fill_part_download", 0) == 1) {
                if (j6 > 0) {
                    int j8 = j7.j("space_fill_min_keep_mb", 100);
                    if (j8 > 0) {
                        long j9 = j6 - (j8 * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
                        com.ss.android.socialbase.downloader.m.j.cw("RetryScheduler", "retry schedule: available = " + com.ss.android.socialbase.downloader.az.m.j(j6) + "MB, minKeep = " + j8 + "MB, canDownload = " + com.ss.android.socialbase.downloader.az.m.j(j9) + "MB");
                        if (j9 <= 0) {
                            com.ss.android.socialbase.downloader.m.j.r("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                            return false;
                        }
                    }
                } else if (j7.j("download_when_space_negative", 0) != 1) {
                }
            }
            return false;
        }
        return true;
    }
}
