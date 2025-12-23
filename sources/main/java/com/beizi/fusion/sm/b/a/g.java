package com.beizi.fusion.sm.b.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.beizi.fusion.sm.b.a.m;
import com.beizi.fusion.sm.repeackage.com.uodis.opendevice.aidl.OpenDeviceIdentifierService;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class g implements com.beizi.fusion.sm.b.c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f13514a;

    /* renamed from: b, reason: collision with root package name */
    private String f13515b;

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        Context context = this.f13514a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.f13515b = "com.huawei.hwid";
                return true;
            }
            if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.f13515b = "com.huawei.hwid.tv";
                return true;
            }
            this.f13515b = "com.huawei.hms";
            return packageManager.getPackageInfo("com.huawei.hms", 0) != null;
        } catch (Exception e6) {
            com.beizi.fusion.sm.b.e.a(e6);
            return false;
        }
    }

    public g(Context context) {
        this.f13514a = context;
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        Context context = this.f13514a;
        if (context == null || bVar == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                if (!TextUtils.isEmpty(string)) {
                    com.beizi.fusion.sm.b.e.a("Get oaid from global settings: " + string);
                    bVar.a(string);
                    return;
                }
            } catch (Exception e6) {
                com.beizi.fusion.sm.b.e.a(e6);
            }
        }
        if (TextUtils.isEmpty(this.f13515b) && !a()) {
            bVar.a(new com.beizi.fusion.sm.b.d("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.f13515b);
        m.a(this.f13514a, intent, bVar, new m.a() { // from class: com.beizi.fusion.sm.b.a.g.1
            @Override // com.beizi.fusion.sm.b.a.m.a
            public String a(IBinder iBinder) throws com.beizi.fusion.sm.b.d, RemoteException {
                OpenDeviceIdentifierService asInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
                if (!asInterface.isOaidTrackLimited()) {
                    return asInterface.getOaid();
                }
                throw new com.beizi.fusion.sm.b.d("User has disabled advertising identifier");
            }
        });
    }
}
