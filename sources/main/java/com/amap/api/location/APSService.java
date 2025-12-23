package com.amap.api.location;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.amap.api.col.p0003l.v3;
import com.autonavi.aps.amapapi.utils.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class APSService extends Service {

    /* renamed from: a, reason: collision with root package name */
    v3 f8887a;

    /* renamed from: b, reason: collision with root package name */
    int f8888b = 0;

    /* renamed from: c, reason: collision with root package name */
    boolean f8889c = false;

    private void a(Context context) {
        try {
            if (this.f8887a == null) {
                this.f8887a = new v3(context);
            }
            this.f8887a.b();
        } catch (Throwable th) {
            b.a(th, "APSService", "onCreate");
        }
        super.onCreate();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            return this.f8887a.a(intent);
        } catch (Throwable th) {
            b.a(th, "APSService", "onBind");
            return null;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            this.f8887a.d();
            if (this.f8889c) {
                stopForeground(true);
            }
        } catch (Throwable th) {
            b.a(th, "APSService", "onDestroy");
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        int i8;
        if (intent != null) {
            try {
                int intExtra = intent.getIntExtra("g", 0);
                if (intExtra == 1) {
                    int intExtra2 = intent.getIntExtra("i", 0);
                    Notification notification = (Notification) intent.getParcelableExtra("h");
                    if (intExtra2 != 0 && notification != null) {
                        startForeground(intExtra2, notification);
                        this.f8889c = true;
                        this.f8888b++;
                    }
                } else if (intExtra == 2) {
                    if (intent.getBooleanExtra("j", true) && (i8 = this.f8888b) > 0) {
                        this.f8888b = i8 - 1;
                    }
                    if (this.f8888b <= 0) {
                        stopForeground(true);
                        this.f8889c = false;
                    } else {
                        stopForeground(false);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        try {
            return this.f8887a.c();
        } catch (Throwable th) {
            b.a(th, "APSService", "onStartCommand");
            return super.onStartCommand(intent, i6, i7);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        a(this);
    }
}
