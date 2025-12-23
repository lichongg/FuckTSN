package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.CSJDownloadService;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes6.dex */
public interface i<T extends CSJDownloadService> {
    void cw();

    void cw(com.ss.android.socialbase.downloader.ae.r rVar);

    IBinder j(Intent intent);

    void j(int i6);

    void j(int i6, Notification notification);

    void j(Intent intent, int i6, int i7);

    void j(av avVar);

    void j(WeakReference<T> weakReference);

    void j(boolean z5);

    boolean j();

    void r();

    void startService();

    void xt(com.ss.android.socialbase.downloader.ae.r rVar);

    boolean xt();
}
