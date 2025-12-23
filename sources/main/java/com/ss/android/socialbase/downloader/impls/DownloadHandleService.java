package com.ss.android.socialbase.downloader.impls;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes6.dex */
public class DownloadHandleService extends Service {

    /* renamed from: j, reason: collision with root package name */
    private static final String f38829j = "DownloadHandleService";

    static {
        StubApp.interface11(41667);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void j(Intent intent) {
        final int intExtra;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (intExtra = intent.getIntExtra("extra_download_id", 0)) == 0) {
            return;
        }
        if (action.equals("com.ss.android.downloader.action.DOWNLOAD_WAKEUP")) {
            com.ss.android.socialbase.downloader.downloader.cw.qv().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.DownloadHandleService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.ss.android.socialbase.downloader.downloader.r.j().jy(intExtra);
                    } catch (Exception e6) {
                        com.bytedance.sdk.component.utils.vl.j(e6);
                    }
                }
            });
        } else if (action.equals("com.ss.android.downloader.action.PROCESS_NOTIFY")) {
            com.ss.android.socialbase.downloader.downloader.r.j().ws(intExtra);
        } else if (action.equals("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY")) {
            com.ss.android.socialbase.downloader.downloader.cw.j();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.cw.j(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        super.onStartCommand(intent, i6, i7);
        j(intent);
        return 2;
    }
}
