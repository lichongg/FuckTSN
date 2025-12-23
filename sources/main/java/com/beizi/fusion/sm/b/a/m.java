package com.beizi.fusion.sm.b.a;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class m implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private final Context f13524a;

    /* renamed from: b, reason: collision with root package name */
    private final com.beizi.fusion.sm.b.b f13525b;

    /* renamed from: c, reason: collision with root package name */
    private final a f13526c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder) throws com.beizi.fusion.sm.b.d, RemoteException;
    }

    public static void a(Context context, Intent intent, com.beizi.fusion.sm.b.b bVar, a aVar) {
        new m(context, bVar, aVar).a(intent);
    }

    private void a(Intent intent) {
        try {
            if (!this.f13524a.bindService(intent, this, 1)) {
                throw new com.beizi.fusion.sm.b.d("Service binding failed");
            }
            com.beizi.fusion.sm.b.e.a("Service has been bound: " + intent);
        } catch (Exception e6) {
            this.f13525b.a(e6);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.beizi.fusion.sm.b.e.a("Service has been connected: " + componentName.getClassName());
        try {
            try {
                try {
                    String a6 = this.f13526c.a(iBinder);
                    if (a6 == null || a6.length() == 0) {
                        throw new com.beizi.fusion.sm.b.d("OAID acquire failed");
                    }
                    com.beizi.fusion.sm.b.e.a("OAID acquire success: " + a6);
                    this.f13525b.a(a6);
                    this.f13524a.unbindService(this);
                    com.beizi.fusion.sm.b.e.a("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e6) {
                    com.beizi.fusion.sm.b.e.a(e6);
                    this.f13525b.a(e6);
                    this.f13524a.unbindService(this);
                    com.beizi.fusion.sm.b.e.a("Service has been unbound: " + componentName.getClassName());
                }
            } catch (Throwable th) {
                try {
                    this.f13524a.unbindService(this);
                    com.beizi.fusion.sm.b.e.a("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e7) {
                    com.beizi.fusion.sm.b.e.a(e7);
                }
                throw th;
            }
        } catch (Exception e8) {
            com.beizi.fusion.sm.b.e.a(e8);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.beizi.fusion.sm.b.e.a("Service has been disconnected: " + componentName.getClassName());
    }

    private m(Context context, com.beizi.fusion.sm.b.b bVar, a aVar) {
        if (context instanceof Application) {
            this.f13524a = context;
        } else {
            this.f13524a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        this.f13525b = bVar;
        this.f13526c = aVar;
    }
}
