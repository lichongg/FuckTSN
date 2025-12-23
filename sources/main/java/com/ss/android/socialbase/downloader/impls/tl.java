package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.CSJDownloadService;

/* loaded from: D:\Downloads\app\classes6.dex */
public class tl extends com.ss.android.socialbase.downloader.downloader.j {
    private static final String up = "tl";

    @Override // com.ss.android.socialbase.downloader.downloader.j, com.ss.android.socialbase.downloader.downloader.i
    public void cw() {
        if (com.ss.android.socialbase.downloader.az.j.j(262144)) {
            this.xt = true;
            this.f38755r = false;
            if (com.ss.android.socialbase.downloader.m.j.j()) {
                com.ss.android.socialbase.downloader.m.j.xt(up, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, (Class<?>) CSJDownloadService.class));
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void stopService(Context context, ServiceConnection serviceConnection) {
        context.stopService(new Intent(context, (Class<?>) CSJDownloadService.class));
        this.xt = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j, com.ss.android.socialbase.downloader.downloader.i
    public void j(Intent intent, int i6, int i7) {
        if (com.ss.android.socialbase.downloader.m.j.j()) {
            com.ss.android.socialbase.downloader.m.j.xt(up, "onStartCommand");
        }
        if (!com.ss.android.socialbase.downloader.az.j.j(262144)) {
            this.xt = true;
        }
        up();
    }
}
