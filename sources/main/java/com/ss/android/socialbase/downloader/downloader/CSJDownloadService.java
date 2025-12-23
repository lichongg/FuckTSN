package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\Downloads\app\classes6.dex */
public class CSJDownloadService extends Service {
    private static final String xt = "CSJDownloadService";

    /* renamed from: j, reason: collision with root package name */
    protected i f38725j;

    static {
        StubApp.interface11(41595);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String str = xt;
        StringBuilder sb = new StringBuilder("onBind downloadServiceHandler != null:");
        sb.append(this.f38725j != null);
        com.ss.android.socialbase.downloader.m.j.xt(str, sb.toString());
        i iVar = this.f38725j;
        if (iVar != null) {
            return iVar.j(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        cw.j(this);
        i ch = cw.ch();
        this.f38725j = ch;
        ch.j(new WeakReference(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (com.ss.android.socialbase.downloader.m.j.j()) {
            com.ss.android.socialbase.downloader.m.j.xt(xt, "Service onDestroy");
        }
        i iVar = this.f38725j;
        if (iVar != null) {
            iVar.r();
            this.f38725j = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i6, final int i7) {
        if (com.ss.android.socialbase.downloader.m.j.j()) {
            com.ss.android.socialbase.downloader.m.j.xt(xt, "DownloadService onStartCommand");
        }
        this.f38725j.cw();
        ExecutorService qv = cw.qv();
        if (qv != null) {
            qv.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.CSJDownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    i iVar = CSJDownloadService.this.f38725j;
                    if (iVar != null) {
                        iVar.j(intent, i6, i7);
                    }
                }
            });
        }
        if (cw.g()) {
            return 2;
        }
        return 3;
    }
}
