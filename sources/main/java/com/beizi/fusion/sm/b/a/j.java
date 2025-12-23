package com.beizi.fusion.sm.b.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import com.beizi.fusion.sm.b.a.m;
import com.beizi.fusion.sm.repeackage.com.bun.lib.MsaIdInterface;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class j implements com.beizi.fusion.sm.b.c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f13520a;

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        Context context = this.f13520a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception e6) {
            com.beizi.fusion.sm.b.e.a(e6);
            return false;
        }
    }

    private void b() {
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.f13520a.getPackageName());
            if (Build.VERSION.SDK_INT < 26) {
                this.f13520a.startService(intent);
            } else {
                this.f13520a.startForegroundService(intent);
            }
        } catch (Exception e6) {
            com.beizi.fusion.sm.b.e.a(e6);
        }
    }

    public j(Context context) {
        this.f13520a = context;
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f13520a == null || bVar == null) {
            return;
        }
        b();
        Intent intent = new Intent("com.bun.msa.action.bindto.service");
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra("com.bun.msa.param.pkgname", this.f13520a.getPackageName());
        m.a(this.f13520a, intent, bVar, new m.a() { // from class: com.beizi.fusion.sm.b.a.j.1
            @Override // com.beizi.fusion.sm.b.a.m.a
            public String a(IBinder iBinder) throws com.beizi.fusion.sm.b.d, RemoteException {
                MsaIdInterface asInterface = MsaIdInterface.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    if (asInterface.isSupported()) {
                        return asInterface.getOAID();
                    }
                    throw new com.beizi.fusion.sm.b.d("MsaIdInterface#isSupported return false");
                }
                throw new com.beizi.fusion.sm.b.d("MsaIdInterface is null");
            }
        });
    }
}
