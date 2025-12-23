package com.beizi.fusion.sm.b.a;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.beizi.fusion.sm.b.a.m;
import com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b implements com.beizi.fusion.sm.b.c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f13506a;

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        Context context = this.f13506a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e6) {
            com.beizi.fusion.sm.b.e.a(e6);
            return false;
        }
    }

    public b(Context context) {
        if (context instanceof Application) {
            this.f13506a = context;
        } else {
            this.f13506a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f13506a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        m.a(this.f13506a, intent, bVar, new m.a() { // from class: com.beizi.fusion.sm.b.a.b.1
            @Override // com.beizi.fusion.sm.b.a.m.a
            public String a(IBinder iBinder) throws com.beizi.fusion.sm.b.d, RemoteException {
                IDeviceIdManager asInterface = IDeviceIdManager.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    return asInterface.getOAID(b.this.f13506a.getPackageName());
                }
                throw new com.beizi.fusion.sm.b.d("IDeviceIdManager is null");
            }
        });
    }
}
