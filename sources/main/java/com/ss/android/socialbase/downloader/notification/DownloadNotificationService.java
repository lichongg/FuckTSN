package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.vl;
import com.kuaishou.weapon.p0.g;
import com.ss.android.socialbase.downloader.az.m;
import com.ss.android.socialbase.downloader.downloader.az;
import com.ss.android.socialbase.downloader.downloader.cw;
import com.ss.android.socialbase.downloader.downloader.r;
import com.ss.android.socialbase.downloader.ws.ae;
import com.ss.android.socialbase.downloader.xt.up;
import com.stub.StubApp;
import java.util.ArrayList;

/* loaded from: D:\Downloads\app\classes6.dex */
public class DownloadNotificationService extends Service {
    private static volatile long ae = 0;
    private static int cw = -1;

    /* renamed from: g, reason: collision with root package name */
    private static long f38886g = 900;

    /* renamed from: j, reason: collision with root package name */
    private static final String f38887j = "DownloadNotificationService";

    /* renamed from: m, reason: collision with root package name */
    private static volatile long f38888m = 0;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f38889r = true;
    private static boolean tl = false;
    private static boolean up = false;
    private static int xt = -1;
    private ae oq;
    private final SparseArray<Notification> qv = new SparseArray<>(2);

    static {
        StubApp.interface11(41717);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void r() {
        if (this.oq == null) {
            ae aeVar = new ae("DownloaderNotifyThread");
            this.oq = aeVar;
            aeVar.j();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        r();
        cw.j(this);
        com.ss.android.socialbase.downloader.jy.j cw2 = com.ss.android.socialbase.downloader.jy.j.cw();
        int j6 = cw2.j("download_service_foreground", 0);
        if ((j6 == 1 || j6 == 3) && xt == -1) {
            xt = 0;
        }
        if ((j6 == 2 || j6 == 3) && cw == -1) {
            cw = 0;
        }
        up = cw2.xt("non_going_notification_foreground", false);
        tl = cw2.xt("notify_too_fast", false);
        long j7 = cw2.j("notification_time_window", 900L);
        f38886g = j7;
        if (j7 >= 0 && j7 <= 1200) {
            return;
        }
        f38886g = 900L;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ae aeVar = this.oq;
        if (aeVar != null) {
            try {
                aeVar.xt();
            } catch (Throwable unused) {
            }
            this.oq = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        j(intent);
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0026, code lost:
    
        if (com.ss.android.socialbase.downloader.notification.DownloadNotificationService.cw == 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void xt(android.app.NotificationManager r6, int r7, android.app.Notification r8) {
        /*
            r5 = this;
            boolean r0 = r5.j(r7, r8)
            if (r0 == 0) goto L76
            com.ss.android.socialbase.downloader.downloader.r r0 = com.ss.android.socialbase.downloader.downloader.r.j()     // Catch: java.lang.Throwable -> L18
            int r0 = r0.j(r7)     // Catch: java.lang.Throwable -> L18
            r1 = 1
            if (r0 != r1) goto L1a
            boolean r0 = com.ss.android.socialbase.downloader.az.m.cw()     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L1a
            goto L1b
        L18:
            r0 = move-exception
            goto L72
        L1a:
            r1 = 0
        L1b:
            if (r1 != 0) goto L22
            int r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.xt     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L22
            goto L28
        L22:
            if (r1 == 0) goto L8b
            int r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.cw     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L8b
        L28:
            com.ss.android.socialbase.downloader.downloader.r r0 = com.ss.android.socialbase.downloader.downloader.r.j()     // Catch: java.lang.Throwable -> L18
            com.ss.android.socialbase.downloader.downloader.az r0 = r0.cw(r7)     // Catch: java.lang.Throwable -> L18
            boolean r2 = r0.ae()     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L62
            boolean r2 = r0.xt()     // Catch: java.lang.Throwable -> L18
            if (r2 != 0) goto L62
            java.lang.String r2 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.f38887j     // Catch: java.lang.Throwable -> L18
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L18
            java.lang.String r4 = "doNotify, startForeground, ======== id = "
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L18
            r3.append(r7)     // Catch: java.lang.Throwable -> L18
            java.lang.String r4 = ", isIndependentProcess = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L18
            r3.append(r1)     // Catch: java.lang.Throwable -> L18
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L18
            com.ss.android.socialbase.downloader.m.j.cw(r2, r3)     // Catch: java.lang.Throwable -> L18
            if (r1 == 0) goto L5c
            com.ss.android.socialbase.downloader.notification.DownloadNotificationService.cw = r7     // Catch: java.lang.Throwable -> L18
            goto L5e
        L5c:
            com.ss.android.socialbase.downloader.notification.DownloadNotificationService.xt = r7     // Catch: java.lang.Throwable -> L18
        L5e:
            r0.j(r7, r8)     // Catch: java.lang.Throwable -> L18
            goto L8b
        L62:
            java.lang.String r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.f38887j     // Catch: java.lang.Throwable -> L18
            java.lang.String r2 = "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L18
            java.lang.String r1 = r2.concat(r1)     // Catch: java.lang.Throwable -> L18
            com.ss.android.socialbase.downloader.m.j.cw(r0, r1)     // Catch: java.lang.Throwable -> L18
            goto L8b
        L72:
            com.bytedance.sdk.component.utils.vl.j(r0)
            goto L8b
        L76:
            int r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.xt
            if (r0 == r7) goto L7e
            int r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.cw
            if (r0 != r7) goto L8b
        L7e:
            boolean r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.up
            if (r0 == 0) goto L8b
            int r0 = r8.flags
            r0 = r0 & 2
            if (r0 != 0) goto L8b
            r5.xt(r6, r7)
        L8b:
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L9a
            long r2 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.f38888m     // Catch: java.lang.Throwable -> L9a
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 >= 0) goto L97
            com.ss.android.socialbase.downloader.notification.DownloadNotificationService.f38888m = r0     // Catch: java.lang.Throwable -> L9a
        L97:
            r6.notify(r7, r8)     // Catch: java.lang.Throwable -> L9a
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.xt(android.app.NotificationManager, int, android.app.Notification):void");
    }

    private void j(final Intent intent) {
        ae aeVar;
        if (intent == null) {
            return;
        }
        final String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (aeVar = this.oq) == null) {
            return;
        }
        aeVar.j(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1
            @Override // java.lang.Runnable
            public void run() {
                ConnectivityManager connectivityManager;
                NetworkInfo activeNetworkInfo;
                final NotificationManager notificationManager = (NotificationManager) DownloadNotificationService.this.getSystemService("notification");
                final int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
                if (!action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY")) {
                    if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                        if (intExtra != 0) {
                            DownloadNotificationService.this.xt(notificationManager, intExtra);
                            return;
                        }
                        return;
                    }
                    if (!action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                            try {
                                com.ss.android.socialbase.downloader.downloader.ae.xt(DownloadNotificationService.this).j();
                                return;
                            } catch (Exception e6) {
                                vl.j(e6);
                                return;
                            }
                        }
                        return;
                    }
                    try {
                        if (m.j((Context) DownloadNotificationService.this, g.f36042b) && (connectivityManager = (ConnectivityManager) StubApp.getOrigApplicationContext(DownloadNotificationService.this.getApplicationContext()).getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                            ArrayList arrayList = new ArrayList();
                            if (!TextUtils.isEmpty(up.f39040j)) {
                                arrayList.add(up.f39040j);
                            }
                            arrayList.add("mime_type_plg");
                            Context origApplicationContext = StubApp.getOrigApplicationContext(DownloadNotificationService.this.getApplicationContext());
                            if (origApplicationContext != null) {
                                com.ss.android.socialbase.downloader.downloader.ae.xt(origApplicationContext).j(arrayList);
                                com.ss.android.socialbase.downloader.downloader.ae.xt(origApplicationContext).xt(arrayList);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Exception e7) {
                        vl.j(e7);
                        return;
                    }
                }
                final Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
                int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
                if (intExtra == 0 || notification == null || notificationManager == null) {
                    return;
                }
                if (intExtra2 != 4) {
                    if (intExtra2 != -2 && intExtra2 != -3) {
                        if (DownloadNotificationService.tl) {
                            DownloadNotificationService.this.j(notificationManager, intExtra, notification);
                            return;
                        } else {
                            DownloadNotificationService.this.xt(notificationManager, intExtra, notification);
                            return;
                        }
                    }
                    if (DownloadNotificationService.tl) {
                        DownloadNotificationService.this.j(notificationManager, intExtra, notification);
                        return;
                    } else {
                        if (DownloadNotificationService.this.oq != null) {
                            DownloadNotificationService.this.oq.j(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    DownloadNotificationService.this.xt(notificationManager, intExtra, notification);
                                }
                            }, intExtra2 == -2 ? 50L : 200L);
                            return;
                        }
                        return;
                    }
                }
                if (com.ss.android.socialbase.downloader.downloader.ae.xt(cw.nd()).ae(intExtra)) {
                    com.ss.android.socialbase.downloader.ae.cw tl2 = com.ss.android.socialbase.downloader.downloader.ae.xt(cw.nd()).tl(intExtra);
                    if (!DownloadNotificationService.tl) {
                        if (tl2 == null || !tl2.j()) {
                            return;
                        }
                        DownloadNotificationService.this.xt(notificationManager, intExtra, notification);
                        tl2.xt();
                        return;
                    }
                    if (tl2 == null || !tl2.j() || System.currentTimeMillis() - DownloadNotificationService.ae <= DownloadNotificationService.f38886g) {
                        return;
                    }
                    DownloadNotificationService.this.xt(notificationManager, intExtra, notification);
                    tl2.xt();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final NotificationManager notificationManager, final int i6, Notification notification) {
        synchronized (this.qv) {
            try {
                int indexOfKey = this.qv.indexOfKey(i6);
                if (indexOfKey >= 0 && indexOfKey < this.qv.size()) {
                    this.qv.setValueAt(indexOfKey, notification);
                    return;
                }
                long currentTimeMillis = f38886g - (System.currentTimeMillis() - f38888m);
                if (currentTimeMillis <= 0) {
                    currentTimeMillis = 0;
                }
                if (currentTimeMillis > 20000) {
                    currentTimeMillis = 20000;
                }
                long currentTimeMillis2 = System.currentTimeMillis() + currentTimeMillis;
                ae = currentTimeMillis2;
                f38888m = currentTimeMillis2;
                if (currentTimeMillis <= 0) {
                    xt(notificationManager, i6, notification);
                } else if (this.oq != null) {
                    synchronized (this.qv) {
                        this.qv.put(i6, notification);
                    }
                    this.oq.j(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DownloadNotificationService.this.j(notificationManager, i6);
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
        synchronized (this.qv) {
            notification = this.qv.get(i6);
            this.qv.remove(i6);
        }
        if (notification != null) {
            xt(notificationManager, i6, notification);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(NotificationManager notificationManager, int i6) {
        boolean z5;
        j jVar;
        int j6;
        int i7 = xt;
        if (i7 != i6 && cw != i6) {
            try {
                notificationManager.cancel(i6);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        boolean z6 = true;
        if (i7 == i6) {
            xt = 0;
            z5 = false;
        } else {
            cw = 0;
            z5 = true;
        }
        try {
            az cw2 = r.j().cw(i6);
            if (!cw2.xt()) {
                f38889r = false;
                com.ss.android.socialbase.downloader.m.j.r(f38887j, "try to stopForeground when is not Foreground, id = " + i6 + ", isIndependentProcess = " + z5);
            }
            com.ss.android.socialbase.downloader.m.j.cw(f38887j, "doCancel, ========== stopForeground id = " + i6 + ", isIndependentProcess = " + z5);
            cw2.j(false, true);
        } catch (Throwable th) {
            vl.j(th);
        }
        try {
            notificationManager.cancel(i6);
        } catch (Throwable unused2) {
        }
        if (f38889r) {
            try {
                SparseArray<j> xt2 = xt.j().xt();
                if (xt2 != null) {
                    for (int size = xt2.size() - 1; size >= 0; size--) {
                        jVar = xt2.valueAt(size);
                        if (jVar != null && (j6 = jVar.j()) != i6 && j6 != xt && j6 != cw && jVar.tl()) {
                            if ((r.j().j(jVar.j()) == 1 && !m.cw()) == z5) {
                                break;
                            }
                        }
                    }
                }
                jVar = null;
                if (jVar != null) {
                    int j7 = jVar.j();
                    try {
                        notificationManager.cancel(j7);
                    } catch (Throwable th2) {
                        vl.j(th2);
                    }
                    if (com.ss.android.socialbase.downloader.downloader.ae.xt(this).m(j7) != 1) {
                        z6 = false;
                    }
                    com.ss.android.socialbase.downloader.m.j.cw(f38887j, "doCancel, updateNotification id = ".concat(String.valueOf(j7)));
                    jVar.j((com.ss.android.socialbase.downloader.up.j) null, z6);
                }
            } catch (Throwable th3) {
                vl.j(th3);
            }
        }
    }

    private boolean j(int i6, Notification notification) {
        int i7;
        int i8;
        String channelId;
        if (!f38889r || (i7 = xt) == i6 || (i8 = cw) == i6) {
            return false;
        }
        if (i7 != 0 && i8 != 0) {
            return false;
        }
        if (up && (notification.flags & 2) == 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        channelId = notification.getChannelId();
        return !TextUtils.isEmpty(channelId);
    }
}
