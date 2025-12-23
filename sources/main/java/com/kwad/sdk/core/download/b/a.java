package com.kwad.sdk.core.download.b;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.jiguang.bz.c0;
import cn.jpush.android.f.g;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.api.push.KsNotificationCompat;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.t;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements d {
    private static c aDy;
    private boolean aDA = false;
    private boolean aDB = false;
    private int aDC = 0;
    private static HashMap<String, WeakReference<Bitmap>> aDx = new HashMap<>();
    private static final Handler aDz = new HandlerC0683a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.core.download.b.a$a, reason: collision with other inner class name */
    static class HandlerC0683a extends Handler {
        private final SparseArray<Long> aDD;

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z5 = message.arg1 == 1;
            int i6 = message.arg2;
            boolean z6 = i6 == 1;
            boolean z7 = i6 == 2;
            Long l6 = this.aDD.get(message.what);
            NotificationManager notificationManager = (NotificationManager) com.kwad.sdk.c.AA().getContext().getSystemService("notification");
            if (notificationManager == null) {
                return;
            }
            if (com.kwad.sdk.c.AA().cl(message.what) == null && !z7) {
                removeMessages(message.what);
                notificationManager.cancel(message.what);
            } else {
                if (!z5 && l6 != null && System.currentTimeMillis() - l6.longValue() < 110) {
                    sendMessageDelayed(Message.obtain(message), (l6.longValue() + 110) - System.currentTimeMillis());
                    return;
                }
                if (z6) {
                    notificationManager.cancel(message.what);
                }
                a.a(message.what, (Notification) message.obj);
                this.aDD.put(message.what, Long.valueOf(System.currentTimeMillis()));
            }
        }

        HandlerC0683a() {
            super(Looper.getMainLooper());
            this.aDD = new SparseArray<>();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b {
        private static String aDE = "ksad_notification_default_icon";
        private String aDF;
        private String aDG;
        private String aDI;
        private String ahn;
        private String name;
        private int progress;
        private File aDH = null;
        private boolean aDJ = false;

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(DownloadTask downloadTask, String str, String str2, boolean z5, int i6) {
            b bVar = new b();
            Object tag = downloadTask.getTag();
            if (tag instanceof DownloadParams) {
                DownloadParams downloadParams = (DownloadParams) tag;
                File cf = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).cf(downloadParams.mAppIcon);
                if (cf != null && cf.exists()) {
                    bVar.aDH = cf;
                }
                bVar.name = downloadParams.mAppName;
            }
            bVar.aDJ = downloadTask.isPaused();
            bVar.ahn = str;
            bVar.aDI = str2;
            bVar.aDG = a.ax(downloadTask.getSmallFileTotalBytes());
            int a6 = t.a(downloadTask.getSmallFileSoFarBytes(), downloadTask.getSmallFileTotalBytes(), z5, i6);
            bVar.progress = a6;
            bVar.aDF = a.ax((long) (downloadTask.getSmallFileTotalBytes() * ((a6 * 1.0d) / 100.0d))) + " / " + a.ax(downloadTask.getSmallFileTotalBytes());
            return bVar;
        }

        public static String GX() {
            return aDE;
        }

        public final String GY() {
            return this.aDF;
        }

        public final String GZ() {
            return this.aDG;
        }

        public final String Ha() {
            return this.ahn;
        }

        public final File Hb() {
            return this.aDH;
        }

        public final String Hc() {
            return "正在下载 " + this.progress + "%";
        }

        public final String Hd() {
            return this.aDI;
        }

        public final String getName() {
            String str = this.name;
            return str == null ? "" : str;
        }

        public final int getProgress() {
            return this.progress;
        }

        public final boolean isPaused() {
            return this.aDJ;
        }

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(DownloadParams downloadParams, String str, String str2) {
            File cf;
            b bVar = new b();
            bVar.name = downloadParams.mAppName;
            if (!TextUtils.isEmpty(downloadParams.mAppIcon) && (cf = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).cf(downloadParams.mAppIcon)) != null && cf.exists()) {
                bVar.aDH = cf;
            }
            bVar.ahn = str;
            bVar.aDG = a.ax(downloadParams.mAppSize);
            bVar.aDI = str2;
            return bVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            String action = intent.getAction();
            if ("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN".equals(action)) {
                e(intent);
            } else if ("com.ksad.action.ACTION_NOTIFICATION_REMOVED".equals(action)) {
                f(intent);
            }
        }

        private static void e(@NonNull Intent intent) {
            DownloadTask g6 = g(intent);
            if (g6 == null) {
                return;
            }
            com.kwad.sdk.c.AA().cn(g6.getId());
        }

        private static void f(@NonNull Intent intent) {
            DownloadTask g6 = g(intent);
            if (g6 == null) {
                return;
            }
            g6.setNotificationRemoved(true);
        }

        @Nullable
        private static DownloadTask g(Intent intent) {
            int i6 = intent.getExtras().getInt("taskId", 0);
            if (i6 == 0) {
                return null;
            }
            return com.kwad.sdk.c.AA().cl(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(int i6, Notification notification) {
        GW();
        NotificationManager notificationManager = (NotificationManager) ServiceProvider.Pp().getSystemService("notification");
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                g.a();
                NotificationChannel a6 = c0.a("download_channel", "ksad", 3);
                a6.enableLights(false);
                a6.enableVibration(false);
                a6.setSound(null, null);
                a6.setShowBadge(false);
                notificationManager.createNotificationChannel(a6);
            }
            notificationManager.notify(i6, notification);
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DefaultLocale"})
    public static String ax(long j6) {
        return String.format("%.2fMB", Float.valueOf((j6 / 1000.0f) / 1000.0f));
    }

    private static Bitmap G(Context context, String str) {
        WeakReference<Bitmap> weakReference = aDx.get(str);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(ba.dn(context), ba.aw(context, str));
        aDx.put(str, new WeakReference<>(decodeResource));
        return decodeResource;
    }

    private static void GW() {
        if (aDy != null) {
            return;
        }
        aDy = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN");
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
        if (Build.VERSION.SDK_INT >= 33) {
            ServiceProvider.Pp().registerReceiver(aDy, intentFilter, 2);
        } else {
            ServiceProvider.Pp().registerReceiver(aDy, intentFilter);
        }
    }

    private static DownloadParams m(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        Object tag = downloadTask.getTag();
        DownloadParams downloadParams = tag instanceof DownloadParams ? (DownloadParams) tag : new DownloadParams();
        downloadParams.mAppSize = downloadTask.getSmallFileTotalBytes();
        downloadParams.mTaskId = downloadTask.getId();
        downloadParams.filePath = downloadTask.getTargetFilePath();
        return downloadParams;
    }

    private static Bitmap q(File file) {
        Bitmap bitmap;
        String absolutePath = file.getAbsolutePath();
        WeakReference<Bitmap> weakReference = aDx.get(absolutePath);
        if (weakReference != null) {
            bitmap = weakReference.get();
        } else {
            bitmap = null;
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap decodeFile = BitmapFactory.decodeFile(absolutePath);
        aDx.put(absolutePath, new WeakReference<>(decodeFile));
        return decodeFile;
    }

    @Override // com.kwad.sdk.d
    public final void cd(String str) {
        Context Pp = ServiceProvider.Pp();
        DownloadParams di = com.kwad.sdk.core.a.Em().di(str);
        com.kwad.sdk.core.a.Em().dj(str);
        if (Pp != null && di != null) {
            com.kwad.sdk.core.a.Em().dj(di.filePath);
            b a6 = b.a(di, "安装完成", "立刻打开");
            com.kwad.sdk.core.download.b.b by = com.kwad.sdk.core.download.b.b.by(Pp);
            if (by != null) {
                a(Pp, by, a6);
                a(Pp, by.build(), false, false, at.d(Pp, di.mPkgname, di.mTaskId), di.mTaskId, 1, 2);
            }
        }
    }

    @Override // com.kwad.sdk.d
    public final void co(int i6) {
        Context Pp = ServiceProvider.Pp();
        if (Pp == null) {
            return;
        }
        ((NotificationManager) Pp.getSystemService("notification")).cancel(i6);
    }

    @Override // com.kwad.sdk.d
    public final void g(File file) {
        Context Pp = ServiceProvider.Pp();
        if (Pp != null) {
            DownloadParams di = com.kwad.sdk.core.a.Em().di(file.getAbsolutePath());
            com.kwad.sdk.core.a.Em().dj(file.getAbsolutePath());
            if (di != null) {
                AdTemplate dk = com.kwad.sdk.core.a.Em().dk(di.mDownloadid);
                if (dk != null) {
                    dk.installFrom = "recall";
                }
                b a6 = b.a(di, "下载完成", "立即安装");
                com.kwad.sdk.core.download.b.b by = com.kwad.sdk.core.download.b.b.by(Pp);
                if (by == null) {
                    return;
                }
                a(Pp, by, a6);
                a(Pp, by.build(), false, false, at.a(Pp, file, di.mTaskId, di.requestInstallPermission), di.mTaskId, 1, 2);
            }
        }
    }

    @Override // com.kwad.sdk.d
    public final void i(DownloadTask downloadTask) {
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            String str = ((DownloadParams) tag).mAppIcon;
            if (!TextUtils.isEmpty(str)) {
                File cf = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).cf(str);
                if (cf == null || !cf.exists()) {
                    ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).a(true, str, "", "");
                }
            }
        }
    }

    @Override // com.kwad.sdk.d
    public final void j(DownloadTask downloadTask) {
        String str;
        Context Pp = ServiceProvider.Pp();
        if (Pp != null && !downloadTask.isNotificationRemoved()) {
            if (downloadTask.getSmallFileSoFarBytes() > 0 && downloadTask.getSmallFileTotalBytes() > 0) {
                str = "正在下载";
            } else {
                str = "准备下载";
            }
            if (!this.aDA) {
                this.aDA = true;
                this.aDB = ((h) ServiceProvider.get(h.class)).BX();
                this.aDC = ((h) ServiceProvider.get(h.class)).BY();
            }
            com.kwad.sdk.core.d.c.d("AdDownloadNotificationPerformer", "DownloadProgressTransformUtil in notifyDownloadError");
            b a6 = b.a(downloadTask, str, null, this.aDB, this.aDC);
            com.kwad.sdk.core.download.b.c a7 = com.kwad.sdk.core.download.b.c.a(Pp, downloadTask.getId(), downloadTask.downloadEnablePause);
            if (a7 == null) {
                return;
            }
            a(Pp, a7, a6);
            a(Pp, a7.build(), false, true, null, downloadTask.getId(), 1, downloadTask.isCompleted() ? 1 : 0);
        }
    }

    @Override // com.kwad.sdk.d
    public final void k(DownloadTask downloadTask) {
        DownloadParams m6;
        com.kwad.sdk.core.download.b.b by;
        Context Pp = ServiceProvider.Pp();
        if (Pp == null || (m6 = m(downloadTask)) == null || (by = com.kwad.sdk.core.download.b.b.by(Pp)) == null) {
            return;
        }
        if (!this.aDA) {
            this.aDA = true;
            this.aDB = ((h) ServiceProvider.get(h.class)).BX();
            this.aDC = ((h) ServiceProvider.get(h.class)).BY();
        }
        com.kwad.sdk.core.d.c.d("AdDownloadNotificationPerformer", "DownloadProgressTransformUtil in notifyDownloadCompleted");
        a(Pp, by, b.a(downloadTask, "下载完成", "立即安装", this.aDB, this.aDC));
        com.kwad.sdk.core.a.Em().a(downloadTask.getTargetFilePath(), m6);
        com.kwad.sdk.core.a.Em().a(m6.mPkgname, m6);
        a(Pp, by.build(), false, false, at.a(Pp, new File(downloadTask.getTargetFilePath()), m6.mTaskId, m6.requestInstallPermission), downloadTask.getId(), 1, 1);
    }

    @Override // com.kwad.sdk.d
    public final void a(DownloadTask downloadTask, boolean z5) {
        com.kwad.sdk.core.download.b.c a6;
        Context Pp = ServiceProvider.Pp();
        if (Pp == null || downloadTask.isNotificationRemoved() || (a6 = com.kwad.sdk.core.download.b.c.a(Pp, downloadTask.getId(), downloadTask.downloadEnablePause)) == null) {
            return;
        }
        if (!this.aDA) {
            this.aDA = true;
            this.aDB = ((h) ServiceProvider.get(h.class)).BX();
            this.aDC = ((h) ServiceProvider.get(h.class)).BY();
        }
        com.kwad.sdk.core.d.c.d("AdDownloadNotificationPerformer", "DownloadProgressTransformUtil in notifyDownloadProgress");
        a(Pp, a6, b.a(downloadTask, "正在下载", null, this.aDB, this.aDC));
        a(Pp, a6.build(), false, true, null, downloadTask.getId(), z5 ? 1 : 0, downloadTask.isCompleted() ? 1 : 0);
    }

    private boolean a(com.kwad.sdk.core.download.b.c cVar, File file) {
        try {
            cVar.setIcon(q(file));
            return true;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            com.kwad.sdk.service.d.gatherException(e6);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.c cVar, String str) {
        try {
            cVar.setIcon(G(context, str));
            return true;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            com.kwad.sdk.service.d.gatherException(e6);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.b.b bVar, File file) {
        try {
            bVar.setIcon(q(file));
            return true;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            com.kwad.sdk.service.d.gatherException(e6);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.b bVar, String str) {
        try {
            bVar.setIcon(G(context, str));
            return true;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            com.kwad.sdk.service.d.gatherException(e6);
            return false;
        }
    }

    private void a(Context context, RemoteViews remoteViews, boolean z5, boolean z6, @Nullable PendingIntent pendingIntent, int i6, int i7, int i8) {
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(false).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(pendingIntent).setSmallIcon(ba.getAppIconId(context));
        a(builder, remoteViews);
        if (z6) {
            Intent intent = new Intent("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
            intent.putExtra("taskId", i6);
            builder.setDeleteIntent(at.a(context, i6, intent));
        }
        Handler handler = aDz;
        handler.removeMessages(i6);
        handler.obtainMessage(i6, i7, i8, builder.build()).sendToTarget();
    }

    private static void a(KsNotificationCompat.Builder builder, RemoteViews remoteViews) {
        try {
            builder.setDecoratedCustomStyle().setCustomBigContentView(remoteViews).setCustomContentView(remoteViews);
        } catch (Throwable unused) {
            builder.setContent(remoteViews);
        }
    }

    private void a(Context context, com.kwad.sdk.core.download.b.c cVar, b bVar) {
        cVar.setName(bVar.getName());
        File Hb = bVar.Hb();
        if (!((Hb == null || !Hb.exists()) ? false : a(cVar, Hb))) {
            a(context, cVar, b.GX());
        }
        cVar.setStatus(bVar.Ha());
        cVar.setSize(bVar.GY());
        cVar.setPercentNum(bVar.Hc());
        cVar.setProgress(100, bVar.getProgress(), false);
        cVar.setControlBtnPaused(bVar.isPaused());
    }

    private void a(Context context, com.kwad.sdk.core.download.b.b bVar, b bVar2) {
        bVar.setName(bVar2.getName());
        File Hb = bVar2.Hb();
        if (!((Hb == null || !Hb.exists()) ? false : a(bVar, Hb))) {
            a(context, bVar, b.GX());
        }
        bVar.setStatus(bVar2.Ha());
        bVar.setSize(bVar2.GZ());
        bVar.setInstallText(bVar2.Hd());
    }
}
