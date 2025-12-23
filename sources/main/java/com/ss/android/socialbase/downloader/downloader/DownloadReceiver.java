package com.ss.android.socialbase.downloader.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationService;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes6.dex */
public class DownloadReceiver extends BroadcastReceiver {

    /* renamed from: j, reason: collision with root package name */
    private static final String f38728j = "DownloadReceiver";

    private void xt(final Context context, final String str) {
        cw.j(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                    intent.setAction(str);
                    if (com.ss.android.socialbase.downloader.jy.j.cw().xt("enable_target_34") > 0) {
                        com.ss.android.socialbase.downloader.vl.j.j().j(intent);
                    } else {
                        context.startService(intent);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.vl.j(th);
                }
            }
        });
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            if (com.ss.android.socialbase.downloader.m.j.j()) {
                com.ss.android.socialbase.downloader.m.j.j(f38728j, "Received broadcast intent for android.net.conn.CONNECTIVITY_CHANGE");
            }
            j(context, action);
        } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
            xt(context, action);
        }
    }

    private void j(final Context context, final String str) {
        if (!cw.rn()) {
            return;
        }
        cw.j(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                    intent.setAction(str);
                    if (com.ss.android.socialbase.downloader.jy.j.cw().xt("enable_target_34") > 0) {
                        com.ss.android.socialbase.downloader.vl.j.j().j(intent);
                    } else {
                        context.startService(intent);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.vl.j(th);
                }
            }
        }, 2000L, TimeUnit.MILLISECONDS);
    }
}
