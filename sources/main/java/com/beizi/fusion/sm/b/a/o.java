package com.beizi.fusion.sm.b.a;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.beizi.fusion.sm.b.a.m;
import com.beizi.fusion.sm.repeackage.com.samsung.android.deviceidservice.IDeviceIdService;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class o implements com.beizi.fusion.sm.b.c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f13530a;

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        Context context = this.f13530a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception e6) {
            com.beizi.fusion.sm.b.e.a(e6);
            return false;
        }
    }

    public o(Context context) {
        this.f13530a = context;
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f13530a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        m.a(this.f13530a, intent, bVar, new m.a() { // from class: com.beizi.fusion.sm.b.a.o.1
            @Override // com.beizi.fusion.sm.b.a.m.a
            public String a(IBinder iBinder) throws com.beizi.fusion.sm.b.d, RemoteException {
                IDeviceIdService asInterface = IDeviceIdService.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    return asInterface.getOAID();
                }
                throw new com.beizi.fusion.sm.b.d("IDeviceIdService is null");
            }
        });
    }
}
