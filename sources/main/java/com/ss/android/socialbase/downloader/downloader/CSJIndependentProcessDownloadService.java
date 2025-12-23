package com.ss.android.socialbase.downloader.downloader;

import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes6.dex */
public class CSJIndependentProcessDownloadService extends CSJDownloadService {
    @Override // com.ss.android.socialbase.downloader.downloader.CSJDownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        cw.j(this);
        if (cw.b() == null) {
            cw.j(new v());
        }
        i s5 = cw.s();
        this.f38725j = s5;
        s5.j(new WeakReference(this));
    }
}
