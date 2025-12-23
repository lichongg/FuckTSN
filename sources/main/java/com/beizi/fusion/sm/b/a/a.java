package com.beizi.fusion.sm.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.beizi.fusion.sm.b.a.m;
import com.beizi.fusion.sm.repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class a implements com.beizi.fusion.sm.b.c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f13504a;

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        Context context = this.f13504a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception e6) {
            com.beizi.fusion.sm.b.e.a(e6);
            return false;
        }
    }

    public a(Context context) {
        this.f13504a = context;
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f13504a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        m.a(this.f13504a, intent, bVar, new m.a() { // from class: com.beizi.fusion.sm.b.a.a.1
            @Override // com.beizi.fusion.sm.b.a.m.a
            public String a(IBinder iBinder) throws com.beizi.fusion.sm.b.d, RemoteException {
                IDidAidlInterface asInterface = IDidAidlInterface.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    if (asInterface.isSupport()) {
                        return asInterface.getOAID();
                    }
                    throw new com.beizi.fusion.sm.b.d("IDidAidlInterface#isSupport return false");
                }
                throw new com.beizi.fusion.sm.b.d("IDidAidlInterface is null");
            }
        });
    }
}
