package com.ss.android.socialbase.downloader.vl;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.vl;
import com.kuaishou.weapon.p0.g;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.az.m;
import com.ss.android.socialbase.downloader.ws.ae;
import com.ss.android.socialbase.downloader.xt.up;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes6.dex */
public class j {
    private static volatile j ae;

    /* renamed from: j, reason: collision with root package name */
    private volatile long f38986j;

    /* renamed from: r, reason: collision with root package name */
    private volatile ae f38988r;
    private volatile long xt;
    private long cw = 1000;
    private final SparseArray<Notification> up = new SparseArray<>(2);

    /* renamed from: m, reason: collision with root package name */
    private AtomicBoolean f38987m = new AtomicBoolean(false);

    public void xt() {
        if (this.f38987m.compareAndSet(false, true)) {
            this.f38988r = new ae("DownloaderNotifyThread");
            this.f38988r.j();
            long j6 = com.ss.android.socialbase.downloader.jy.j.cw().j("notification_time_window", 1000L);
            this.cw = j6;
            if (j6 < 0 || j6 > 1200) {
                this.cw = 1000L;
            }
        }
    }

    public static j j() {
        if (ae == null) {
            synchronized (j.class) {
                try {
                    if (ae == null) {
                        ae = new j();
                    }
                } finally {
                }
            }
        }
        return ae;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(Intent intent) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        cw tl;
        Context nd = com.ss.android.socialbase.downloader.downloader.cw.nd();
        if (nd == null) {
            return;
        }
        String action = intent.getAction();
        NotificationManager notificationManager = (NotificationManager) nd.getSystemService("notification");
        int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
        if ("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY".equals(action)) {
            Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
            int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
            if (intExtra == 0 || notification == null || notificationManager == null) {
                return;
            }
            if (intExtra2 != 4) {
                if (intExtra2 != -2 && intExtra2 != -3) {
                    j(notificationManager, intExtra, notification);
                    return;
                } else {
                    j(notificationManager, intExtra, notification);
                    return;
                }
            }
            if (com.ss.android.socialbase.downloader.downloader.ae.xt(com.ss.android.socialbase.downloader.downloader.cw.nd()).ae(intExtra) && (tl = com.ss.android.socialbase.downloader.downloader.ae.xt(com.ss.android.socialbase.downloader.downloader.cw.nd()).tl(intExtra)) != null && tl.j() && System.currentTimeMillis() - this.xt > this.cw) {
                xt(notificationManager, intExtra, notification);
                tl.xt();
                return;
            }
            return;
        }
        if ("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL".equals(action)) {
            if (intExtra != 0) {
                xt(notificationManager, intExtra);
                return;
            }
            return;
        }
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            try {
                if (m.j(nd, g.f36042b) && (connectivityManager = (ConnectivityManager) nd.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                    ArrayList arrayList = new ArrayList();
                    if (!TextUtils.isEmpty(up.f39040j)) {
                        arrayList.add(up.f39040j);
                    }
                    arrayList.add("mime_type_plg");
                    com.ss.android.socialbase.downloader.downloader.ae.xt(nd).j(arrayList);
                    com.ss.android.socialbase.downloader.downloader.ae.xt(nd).xt(arrayList);
                    return;
                }
                return;
            } catch (Exception e6) {
                vl.j(e6);
                return;
            }
        }
        if ("android.intent.action.MEDIA_UNMOUNTED".equals(action) || "android.intent.action.MEDIA_REMOVED".equals(action) || "android.intent.action.MEDIA_BAD_REMOVAL".equals(action) || "android.intent.action.MEDIA_EJECT".equals(action)) {
            try {
                com.ss.android.socialbase.downloader.downloader.ae.xt(com.ss.android.socialbase.downloader.downloader.cw.nd()).j();
            } catch (Exception e7) {
                vl.j(e7);
            }
        }
    }

    public void j(final Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return;
        }
        xt();
        if (this.f38988r == null) {
            return;
        }
        this.f38988r.j(new Runnable() { // from class: com.ss.android.socialbase.downloader.vl.j.1
            @Override // java.lang.Runnable
            public void run() {
                j.this.xt(intent);
            }
        });
    }

    private void j(final NotificationManager notificationManager, final int i6, Notification notification) {
        synchronized (this.up) {
            try {
                int indexOfKey = this.up.indexOfKey(i6);
                if (indexOfKey >= 0 && indexOfKey < this.up.size()) {
                    this.up.setValueAt(indexOfKey, notification);
                    return;
                }
                long currentTimeMillis = this.cw - (System.currentTimeMillis() - this.f38986j);
                if (currentTimeMillis <= 0) {
                    currentTimeMillis = 0;
                }
                if (currentTimeMillis > 20000) {
                    currentTimeMillis = 20000;
                }
                long currentTimeMillis2 = System.currentTimeMillis() + currentTimeMillis;
                this.xt = currentTimeMillis2;
                this.f38986j = currentTimeMillis2;
                if (currentTimeMillis <= 0) {
                    xt(notificationManager, i6, notification);
                } else if (this.f38988r != null) {
                    synchronized (this.up) {
                        this.up.put(i6, notification);
                    }
                    this.f38988r.j(new Runnable() { // from class: com.ss.android.socialbase.downloader.vl.j.2
                        @Override // java.lang.Runnable
                        public void run() {
                            j.this.j(notificationManager, i6);
                        }
                    }, currentTimeMillis);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(NotificationManager notificationManager, int i6) {
        Notification notification;
        synchronized (this.up) {
            notification = this.up.get(i6);
            this.up.remove(i6);
        }
        if (notification != null) {
            xt(notificationManager, i6, notification);
        }
    }

    private void xt(NotificationManager notificationManager, int i6, Notification notification) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f38986j < currentTimeMillis) {
                this.f38986j = currentTimeMillis;
            }
            notificationManager.notify(i6, notification);
        } catch (Throwable unused) {
        }
    }

    private void xt(NotificationManager notificationManager, int i6) {
        try {
            notificationManager.cancel(i6);
        } catch (Throwable unused) {
        }
    }
}
