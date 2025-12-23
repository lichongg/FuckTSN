package com.beizi.fusion.sm.b.a;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.beizi.fusion.sm.b.a.m;
import com.beizi.fusion.sm.repeackage.com.android.creator.IdsSupplier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class e implements com.beizi.fusion.sm.b.c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f13510a;

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        Context context = this.f13510a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e6) {
            com.beizi.fusion.sm.b.e.a(e6);
            return false;
        }
    }

    public e(Context context) {
        this.f13510a = context;
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f13510a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        m.a(this.f13510a, intent, bVar, new m.a() { // from class: com.beizi.fusion.sm.b.a.e.1
            @Override // com.beizi.fusion.sm.b.a.m.a
            public String a(IBinder iBinder) throws com.beizi.fusion.sm.b.d, RemoteException {
                IdsSupplier asInterface = IdsSupplier.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    return asInterface.getOAID();
                }
                throw new com.beizi.fusion.sm.b.d("IdsSupplier is null");
            }
        });
    }
}
