package com.beizi.ad;

import android.app.DownloadManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import com.beizi.ad.internal.h.b;
import com.beizi.ad.lance.ApkBean;
import com.stub.StubApp;
import java.io.File;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class DownloadService extends Service {

    /* renamed from: f, reason: collision with root package name */
    private static b.a f11253f;

    /* renamed from: a, reason: collision with root package name */
    private long f11254a;

    /* renamed from: b, reason: collision with root package name */
    private String f11255b;

    /* renamed from: c, reason: collision with root package name */
    private DownloadManager f11256c;

    /* renamed from: d, reason: collision with root package name */
    private a f11257d;

    /* renamed from: e, reason: collision with root package name */
    private b f11258e;

    /* renamed from: g, reason: collision with root package name */
    private HashMap<String, ApkBean> f11259g;

    /* renamed from: h, reason: collision with root package name */
    private HashMap<String, Boolean> f11260h;

    /* renamed from: i, reason: collision with root package name */
    private HashMap<Long, String> f11261i;

    /* renamed from: j, reason: collision with root package name */
    private ApkBean f11262j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a extends ContentObserver {
        a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z5) {
            super.onChange(z5);
            int[] iArr = {0, 0, 0};
            Cursor cursor = null;
            try {
                try {
                    cursor = DownloadService.this.f11256c.query(new DownloadManager.Query().setFilterById(DownloadService.this.f11254a));
                    if (cursor != null && cursor.moveToFirst()) {
                        int i6 = cursor.getInt(cursor.getColumnIndex(NotificationCompat.CATEGORY_STATUS));
                        com.beizi.ad.lance.a.m.a("DownloadService", "onChange status：" + i6);
                        if (i6 == 1) {
                            DownloadService downloadService = DownloadService.this;
                            downloadService.c(downloadService.f11262j);
                        }
                        iArr[0] = cursor.getInt(cursor.getColumnIndexOrThrow("bytes_so_far"));
                        iArr[1] = cursor.getInt(cursor.getColumnIndexOrThrow("total_size"));
                        iArr[2] = cursor.getInt(cursor.getColumnIndex(NotificationCompat.CATEGORY_STATUS));
                        com.beizi.ad.lance.a.m.a("DownloadService", "progress：" + iArr[0] + "/" + iArr[1] + "");
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean canRequestPackageInstalls;
            try {
                com.beizi.ad.lance.a.m.a("DownloadService", "onReceived...download finish...begin install！");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                if (DownloadService.this.f11261i != null && DownloadService.this.f11259g != null) {
                    String str = (String) DownloadService.this.f11261i.get(Long.valueOf(longExtra));
                    if (DownloadService.this.f11260h != null) {
                        DownloadService.this.f11260h.put(str, Boolean.FALSE);
                    }
                    ApkBean apkBean = (ApkBean) DownloadService.this.f11259g.get(str);
                    if (apkBean != null) {
                        if (apkBean.getmFollowTrackExt() != null) {
                            com.beizi.ad.internal.h.l.a(apkBean.getmFollowTrackExt().c());
                        }
                        if (Build.VERSION.SDK_INT < 26) {
                            DownloadService.this.a(context, Long.valueOf(longExtra), apkBean);
                            return;
                        }
                        canRequestPackageInstalls = context.getPackageManager().canRequestPackageInstalls();
                        if (canRequestPackageInstalls) {
                            DownloadService.this.a(context, Long.valueOf(longExtra), apkBean);
                        } else {
                            DownloadService.this.a(context, Long.valueOf(longExtra), apkBean);
                        }
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void b() {
        getContentResolver().unregisterContentObserver(this.f11257d);
        unregisterReceiver(this.f11258e);
        com.beizi.ad.lance.a.m.a("DownloadService", "unregister()");
    }

    private void c() {
        b.a aVar = f11253f;
        if (aVar != null) {
            aVar.a();
        }
        if (this.f11260h != null) {
            this.f11260h = null;
        }
        if (this.f11259g != null) {
            this.f11259g = null;
        }
        if (this.f11261i != null) {
            this.f11261i = null;
        }
        com.beizi.ad.lance.a.m.a("DownloadService", "releaseResources()");
    }

    private void d(ApkBean apkBean) {
        com.beizi.ad.lance.a.m.a("DownloadService", "BEGIN_INSTALL!");
        if (apkBean.getmFollowTrackExt() != null) {
            com.beizi.ad.internal.h.l.a(apkBean.getmFollowTrackExt().d());
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        Bundle bundleExtra;
        if (intent == null) {
            return 2;
        }
        com.beizi.ad.lance.a.m.a("DownloadService", "DownloadService onStartCommand()");
        if (intent != null) {
            try {
                if (intent.getExtras() != null && (bundleExtra = intent.getBundleExtra("data")) != null && bundleExtra.containsKey("apkBean")) {
                    this.f11262j = (ApkBean) bundleExtra.getSerializable("apkBean");
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        a(this.f11262j);
        return 2;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.beizi.ad.lance.a.m.a("DownloadService", "DownloadService onCreate()");
        this.f11256c = (DownloadManager) getSystemService("download");
        this.f11257d = new a(new Handler());
        this.f11258e = new b();
        this.f11259g = new HashMap<>();
        this.f11260h = new HashMap<>();
        this.f11261i = new HashMap<>();
        a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        com.beizi.ad.lance.a.m.a("DownloadService", "DownloadService onDestroy()");
        b();
        c();
    }

    private void a() {
        getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads"), true, this.f11257d);
        registerReceiver(this.f11258e, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
    }

    private synchronized void b(ApkBean apkBean) {
        Uri uriForFile;
        HashMap<String, Boolean> hashMap = this.f11260h;
        if (hashMap != null && hashMap.get(apkBean.getPkgName()) != null && this.f11260h.get(apkBean.getPkgName()).booleanValue()) {
            com.beizi.ad.lance.a.m.a("DownloadService", "downloading..." + apkBean.getPkgName() + "...please not repeat click");
            Toast.makeText(this, "正在下载…请勿重复点击", 0).show();
            return;
        }
        File file = new File(apkBean.getDownloadPath(), apkBean.getPkgName() + ".zip");
        if (file.exists()) {
            file.delete();
            com.beizi.ad.lance.a.m.a("DownloadService", "apkCacheFile......remove:" + file.exists());
        }
        File file2 = new File(apkBean.getDownloadPath(), apkBean.getApkName());
        if (file2.exists()) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setAction("android.intent.action.VIEW");
                if (Build.VERSION.SDK_INT < 24) {
                    uriForFile = Uri.fromFile(file2);
                } else {
                    uriForFile = FileProvider.getUriForFile(this, apkBean.getAuthorities(), file2);
                    intent.addFlags(3);
                }
                if (uriForFile != null) {
                    intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
                    startActivity(intent);
                    d(apkBean);
                }
            } catch (Exception e6) {
                e6.toString();
            }
        }
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(apkBean.getApkUrl()));
            request.setTitle(apkBean.getApkTittleName());
            request.setDescription(apkBean.getApkDesc());
            request.setNotificationVisibility(1);
            request.setDestinationUri(Uri.fromFile(file));
            request.setMimeType("application/vnd.android.package-archive");
            this.f11254a = this.f11256c.enqueue(request);
            com.beizi.ad.lance.a.m.b("DownloadService", "mReqId:" + this.f11254a);
            HashMap<Long, String> hashMap2 = this.f11261i;
            if (hashMap2 != null) {
                hashMap2.put(Long.valueOf(this.f11254a), apkBean.getPkgName());
            }
            HashMap<String, Boolean> hashMap3 = this.f11260h;
            if (hashMap3 != null) {
                hashMap3.put(apkBean.getPkgName(), Boolean.TRUE);
            }
            Toast.makeText(this, "已开始下载…", 0).show();
            com.beizi.ad.lance.a.m.a("DownloadService", "BEGIN_DOWNLOAD!");
            if (apkBean.getmFollowTrackExt() != null) {
                com.beizi.ad.internal.h.l.a(apkBean.getmFollowTrackExt().b());
            }
        } catch (Exception e7) {
            e7.toString();
            try {
                if (!TextUtils.isEmpty(apkBean.getApkUrl()) && apkBean.getApkUrl().contains(master.flame.danmaku.danmaku.parser.b.f50154a)) {
                    HashMap<String, Boolean> hashMap4 = this.f11260h;
                    if (hashMap4 != null) {
                        hashMap4.put(apkBean.getPkgName(), Boolean.TRUE);
                    }
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(apkBean.getApkUrl()));
                    intent2.setFlags(268435456);
                    startActivity(intent2);
                }
            } catch (Exception e8) {
                e8.toString();
            }
        }
    }

    private void a(ApkBean apkBean) {
        if (apkBean == null) {
            return;
        }
        HashMap<String, ApkBean> hashMap = this.f11259g;
        if (hashMap != null) {
            hashMap.put(apkBean.getPkgName(), apkBean);
        }
        HashMap<String, Boolean> hashMap2 = this.f11260h;
        if (hashMap2 != null && hashMap2.get(apkBean.getPkgName()) == null) {
            com.beizi.ad.lance.a.m.a("DownloadService", "not have package status...");
            this.f11260h.put(apkBean.getPkgName(), Boolean.FALSE);
        }
        if (TextUtils.isEmpty(apkBean.getAuthorities())) {
            this.f11255b = getPackageName() + ".fileprovider";
        } else {
            this.f11255b = apkBean.getAuthorities();
        }
        com.beizi.ad.lance.a.h.a(apkBean.getDownloadPath());
        b(apkBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ApkBean apkBean) {
        if (apkBean == null) {
            return;
        }
        com.beizi.ad.lance.a.m.a("DownloadService", "--appUpdate downloadApk start--");
        b.a a6 = com.beizi.ad.internal.h.b.a();
        f11253f = a6;
        a6.a(new b.InterfaceC0110b() { // from class: com.beizi.ad.DownloadService.1
            @Override // com.beizi.ad.internal.h.b.InterfaceC0110b
            public void a(long j6, long j7) {
            }

            @Override // com.beizi.ad.internal.h.b.InterfaceC0110b
            public boolean a(File file) {
                return true;
            }

            @Override // com.beizi.ad.internal.h.b.InterfaceC0110b
            public void b(File file) {
                com.beizi.ad.lance.a.m.a("DownloadService", "--appUpdate downloadApk onSuccess--");
                if (DownloadService.this.f11260h != null) {
                    DownloadService.this.f11260h.put(apkBean.getPkgName(), Boolean.FALSE);
                }
                DownloadService.this.a(StubApp.getOrigApplicationContext(DownloadService.this.getApplicationContext()), -1L, apkBean);
            }

            @Override // com.beizi.ad.internal.h.b.InterfaceC0110b
            public void a(int i6) {
                com.beizi.ad.lance.a.m.a("DownloadService", "--appUpdate downloadApk onFail--");
                try {
                    String apkUrl = apkBean.getApkUrl();
                    if (TextUtils.isEmpty(apkUrl) || !apkUrl.contains(master.flame.danmaku.danmaku.parser.b.f50154a)) {
                        return;
                    }
                    if (DownloadService.this.f11260h != null) {
                        DownloadService.this.f11260h.put(apkBean.getPkgName(), Boolean.TRUE);
                    }
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(apkUrl));
                    intent.setFlags(268435456);
                    DownloadService.this.startActivity(intent);
                } catch (Exception e6) {
                    com.beizi.ad.lance.a.m.a("DownloadService", "skip browser fail:" + e6);
                }
            }
        });
        f11253f.a(new b.d(apkBean.getApkUrl(), apkBean.getDownloadPath(), apkBean.getApkName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Long l6, ApkBean apkBean) {
        Uri uriForFile;
        try {
            File file = new File(apkBean.getDownloadPath(), apkBean.getPkgName() + ".zip");
            if (file.exists()) {
                String fileMD5 = apkBean.getFileMD5();
                String a6 = com.beizi.ad.lance.a.i.a(file.getAbsolutePath());
                if (TextUtils.isEmpty(fileMD5) || fileMD5.equals(a6)) {
                    if (file.exists()) {
                        File file2 = new File(apkBean.getDownloadPath(), apkBean.getApkName());
                        file.renameTo(file2);
                        com.beizi.ad.lance.a.m.a("DownloadService", "apkFile......raName:" + file2.exists());
                    }
                    Intent intent = new Intent();
                    intent.addFlags(268435456);
                    intent.setAction("android.intent.action.VIEW");
                    int i6 = Build.VERSION.SDK_INT;
                    if (i6 < 23) {
                        uriForFile = this.f11256c.getUriForDownloadedFile(l6.longValue());
                        if (uriForFile != null) {
                            uriForFile = Uri.parse(uriForFile.toString().replace(".zip", ".apk"));
                            com.beizi.ad.lance.a.m.a("DownloadService", "uri......" + uriForFile);
                        }
                    } else if (i6 < 24) {
                        File a7 = a(context, l6.longValue());
                        if (a7 != null) {
                            uriForFile = Uri.fromFile(a7);
                            if (uriForFile != null) {
                                uriForFile = Uri.parse(uriForFile.toString().replace(".zip", ".apk"));
                                com.beizi.ad.lance.a.m.a("DownloadService", "uri......" + uriForFile);
                            }
                        } else {
                            uriForFile = null;
                        }
                    } else {
                        uriForFile = FileProvider.getUriForFile(context, this.f11255b, new File(apkBean.getDownloadPath(), apkBean.getApkName()));
                        intent.addFlags(3);
                    }
                    if (uriForFile != null) {
                        intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
                        context.startActivity(intent);
                        d(apkBean);
                    }
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private static File a(Context context, long j6) {
        Cursor query;
        String path;
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        File file = null;
        if (j6 != -1) {
            DownloadManager.Query query2 = new DownloadManager.Query();
            query2.setFilterById(j6);
            query2.setFilterByStatus(8);
            if (downloadManager != null && (query = downloadManager.query(query2)) != null) {
                if (query.moveToFirst()) {
                    String string = query.getString(query.getColumnIndex("local_uri"));
                    if (!TextUtils.isEmpty(string) && (path = Uri.parse(string).getPath()) != null) {
                        file = new File(path);
                    }
                }
                query.close();
            }
        }
        return file;
    }
}
