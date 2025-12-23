package xyz.adscope.ad.download.service;

import android.app.DownloadManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import com.stub.StubApp;
import com.umeng.analytics.pro.bm;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import xyz.adscope.ad.c0;
import xyz.adscope.ad.download.service.a;
import xyz.adscope.ad.n4;
import xyz.adscope.ad.y1;
import xyz.adscope.common.v2.encrypt.impl.MD5Util;
import xyz.adscope.common.v2.tool.io.FileVerify;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DownloadService extends Service implements xyz.adscope.ad.download.service.a {

    /* renamed from: a, reason: collision with root package name */
    private b f55086a;

    /* renamed from: b, reason: collision with root package name */
    private d f55087b;

    /* renamed from: c, reason: collision with root package name */
    private c f55088c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, Long> f55089d;

    /* renamed from: e, reason: collision with root package name */
    private Map<Long, a.C1087a> f55090e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements a.b {
        a() {
        }

        @Override // xyz.adscope.ad.download.service.a.b
        public void a(a.C1087a c1087a) {
            DownloadService.this.a(c1087a, y1.a.DOWNLOAD_FAILED);
        }

        @Override // xyz.adscope.ad.download.service.a.b
        public void b(a.C1087a c1087a) {
            DownloadService.this.a(c1087a, y1.a.DOWNLOAD_CONTINUE);
        }

        @Override // xyz.adscope.ad.download.service.a.b
        public void c(a.C1087a c1087a) {
            DownloadService.this.a(c1087a, y1.a.DOWNLOAD_PAUSE);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b extends Binder {
        public b() {
        }

        public xyz.adscope.ad.download.service.a a() {
            return DownloadService.this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c extends ContentObserver {
        public c(Handler handler) {
            super(handler);
        }

        private long[] a(Map<Long, a.C1087a> map) {
            if (map == null || map.isEmpty()) {
                return null;
            }
            Set<Long> keySet = map.keySet();
            long[] jArr = new long[keySet.size()];
            Iterator<Long> it = keySet.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                jArr[i6] = it.next().longValue();
                i6++;
            }
            return jArr;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z5) {
            a.C1087a c1087a;
            super.onChange(z5);
            DownloadManager downloadManager = (DownloadManager) StubApp.getOrigApplicationContext(DownloadService.this.getApplicationContext()).getSystemService("download");
            Cursor cursor = null;
            try {
                long[] a6 = a(DownloadService.this.f55090e);
                if (a6 != null && a6.length > 0) {
                    DownloadManager.Query query = new DownloadManager.Query();
                    query.setFilterById(a6);
                    cursor = downloadManager.query(query);
                    while (cursor.moveToNext()) {
                        long j6 = cursor.getLong(cursor.getColumnIndexOrThrow(bm.f41039d));
                        int i6 = cursor.getInt(cursor.getColumnIndexOrThrow(NotificationCompat.CATEGORY_STATUS));
                        if (DownloadService.this.f55090e != null && DownloadService.this.f55090e.containsKey(Long.valueOf(j6)) && (c1087a = (a.C1087a) DownloadService.this.f55090e.get(Long.valueOf(j6))) != null) {
                            c1087a.a(i6);
                        }
                    }
                }
                if (cursor == null) {
                    return;
                }
            } catch (IllegalArgumentException unused) {
                if (cursor == null) {
                    return;
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            cursor.close();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class d extends BroadcastReceiver {
        private d() {
        }

        private boolean a(Context context, Uri uri) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.addFlags(1);
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
            return n4.c(context, intent);
        }

        /* synthetic */ d(DownloadService downloadService, a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            a.C1087a a6;
            Uri a7;
            if (intent != null) {
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                if (longExtra <= 0 || (a7 = a(context, longExtra, (a6 = a(longExtra)))) == null) {
                    return;
                }
                DownloadService.this.a(a6, y1.a.DOWNLOAD_COMPLETE);
                if (a(context, a7)) {
                    DownloadService.this.a(a6, y1.a.INSTALL_START);
                }
            }
        }

        private a.C1087a a(long j6) {
            if (DownloadService.this.f55090e == null || !DownloadService.this.f55090e.containsKey(Long.valueOf(j6))) {
                return null;
            }
            return (a.C1087a) DownloadService.this.f55090e.get(Long.valueOf(j6));
        }

        private Uri a(Context context, long j6, a.C1087a c1087a) {
            DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
            int i6 = Build.VERSION.SDK_INT;
            if (i6 < 23) {
                return downloadManager.getUriForDownloadedFile(j6);
            }
            if (i6 < 24) {
                return a(downloadManager, j6);
            }
            if (c1087a == null) {
                return null;
            }
            File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), StringUtil.getFileNameFromURL(c1087a.b()));
            String a6 = c1087a.a();
            if (!file.exists() || !a(file, a6)) {
                return null;
            }
            try {
                return FileProvider.getUriForFile(context, String.format("%s.fileprovider", context.getPackageName()), file);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private boolean a(File file, String str) {
            if (file != null) {
                return TextUtils.isEmpty(str) || str.equalsIgnoreCase(FileVerify.getFileMD5(file));
            }
            return false;
        }

        private Uri a(DownloadManager downloadManager, long j6) {
            int columnIndexOrThrow;
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(j6);
            query.setFilterByStatus(8);
            try {
                Cursor query2 = downloadManager.query(query);
                if (query2 != null) {
                    try {
                        if (query2.moveToFirst() && (columnIndexOrThrow = query2.getColumnIndexOrThrow("local_uri")) >= 0) {
                            String string = query2.getString(columnIndexOrThrow);
                            if (!TextUtils.isEmpty(string)) {
                                Uri parse = Uri.parse(string);
                                query2.close();
                                return parse;
                            }
                        }
                    } finally {
                    }
                }
                if (query2 == null) {
                    return null;
                }
                query2.close();
                return null;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class e extends Handler {
        /* synthetic */ e(Looper looper, a aVar) {
            this(looper);
        }

        private e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        return 2;
    }

    private void b() {
        ContentResolver contentResolver;
        if (this.f55087b != null) {
            StubApp.getOrigApplicationContext(getApplicationContext()).unregisterReceiver(this.f55087b);
        }
        if (this.f55088c == null || (contentResolver = StubApp.getOrigApplicationContext(getApplicationContext()).getContentResolver()) == null) {
            return;
        }
        contentResolver.unregisterContentObserver(this.f55088c);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return this.f55086a;
    }

    private void a() {
        a aVar = null;
        this.f55087b = new d(this, aVar);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
        if (Build.VERSION.SDK_INT > 32) {
            StubApp.getOrigApplicationContext(getApplicationContext()).registerReceiver(this.f55087b, intentFilter, 4);
        } else {
            StubApp.getOrigApplicationContext(getApplicationContext()).registerReceiver(this.f55087b, intentFilter);
        }
        this.f55088c = new c(new e(getMainLooper(), aVar));
        ContentResolver contentResolver = StubApp.getOrigApplicationContext(getApplicationContext()).getContentResolver();
        if (contentResolver != null) {
            contentResolver.registerContentObserver(Uri.parse("content://downloads/my_downloads"), true, this.f55088c);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f55089d = new HashMap();
        this.f55090e = new HashMap();
        this.f55086a = new b();
        a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        b();
    }

    @Override // xyz.adscope.ad.download.service.a
    public void a(a.C1087a c1087a) {
        if (c1087a == null || a(c1087a.b())) {
            return;
        }
        c1087a.a(new a());
        long a6 = a(c1087a.b(), c1087a.c());
        if (a6 > 0) {
            a(c1087a, y1.a.DOWNLOAD_START);
            c1087a.a(a6);
            this.f55089d.put(MD5Util.md5(c1087a.b()), Long.valueOf(a6));
            this.f55090e.put(Long.valueOf(a6), c1087a);
        }
    }

    private boolean a(String str) {
        Long l6;
        String md5 = MD5Util.md5(str);
        return this.f55089d.containsKey(md5) && (l6 = this.f55089d.get(md5)) != null && l6.longValue() > 0;
    }

    private long a(String str, String str2) {
        DownloadManager downloadManager = (DownloadManager) StubApp.getOrigApplicationContext(getApplicationContext()).getSystemService("download");
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        if (TextUtils.isEmpty(str2)) {
            str2 = StringUtil.getFileNameFromURL(str);
        }
        request.setTitle(str2);
        request.setVisibleInDownloadsUi(true);
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        request.setDestinationInExternalFilesDir(StubApp.getOrigApplicationContext(getApplicationContext()), Environment.DIRECTORY_DOWNLOADS, StringUtil.getFileNameFromURL(str));
        return downloadManager.enqueue(request);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C1087a c1087a, y1.a aVar) {
        if (c1087a != null) {
            c0.a().getOrCreateImplement(StubApp.getOrigApplicationContext(getApplicationContext())).a(aVar, c1087a.d(), c1087a.e());
        }
    }
}
