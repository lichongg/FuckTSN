package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes6.dex */
public class SqlDownloadCacheService extends Service {

    /* renamed from: j, reason: collision with root package name */
    private static final String f38731j = "SqlDownloadCacheService";

    static {
        StubApp.interface11(41600);
    }

    public static void j(Context context, ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, (Class<?>) SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.xt(f38731j, "startServiceAndBind fail", th);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        tj tjVar;
        vl x5 = cw.x();
        if (x5 instanceof com.ss.android.socialbase.downloader.impls.r) {
            tjVar = ((com.ss.android.socialbase.downloader.impls.r) x5).m();
        } else if (x5 instanceof tj) {
            tjVar = (tj) x5;
        } else {
            tjVar = null;
        }
        if (tjVar instanceof IBinder) {
            return (IBinder) tjVar;
        }
        return new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        cw.j(StubApp.getOrigApplicationContext(getApplicationContext()));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        int onStartCommand = super.onStartCommand(intent, i6, i7);
        if (cw.g()) {
            return 2;
        }
        return onStartCommand;
    }
}
