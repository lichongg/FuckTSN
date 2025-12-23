package com.beizi.fusion.sm.b.a;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.beizi.fusion.sm.b.a.m;
import com.beizi.fusion.sm.repeackage.com.heytap.openid.IOpenID;
import com.stub.StubApp;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class n implements com.beizi.fusion.sm.b.c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f13527a;

    /* renamed from: b, reason: collision with root package name */
    private String f13528b;

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        Context context = this.f13527a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e6) {
            com.beizi.fusion.sm.b.e.a(e6);
            return false;
        }
    }

    public n(Context context) {
        if (context instanceof Application) {
            this.f13527a = context;
        } else {
            this.f13527a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f13527a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        m.a(this.f13527a, intent, bVar, new m.a() { // from class: com.beizi.fusion.sm.b.a.n.1
            @Override // com.beizi.fusion.sm.b.a.m.a
            public String a(IBinder iBinder) throws com.beizi.fusion.sm.b.d, RemoteException {
                try {
                    return n.this.a(iBinder);
                } catch (RemoteException e6) {
                    throw e6;
                } catch (com.beizi.fusion.sm.b.d e7) {
                    throw e7;
                } catch (Exception e8) {
                    throw new com.beizi.fusion.sm.b.d(e8);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"PackageManagerGetSignatures"})
    public String a(IBinder iBinder) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException, com.beizi.fusion.sm.b.d {
        String packageName = this.f13527a.getPackageName();
        String str = this.f13528b;
        if (str == null) {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(this.f13527a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b6 : digest) {
                sb.append(Integer.toHexString((b6 & 255) | 256).substring(1, 3));
            }
            String sb2 = sb.toString();
            this.f13528b = sb2;
            return a(iBinder, packageName, sb2);
        }
        return a(iBinder, packageName, str);
    }

    private String a(IBinder iBinder, String str, String str2) throws RemoteException, com.beizi.fusion.sm.b.d {
        IOpenID asInterface = IOpenID.Stub.asInterface(iBinder);
        if (asInterface != null) {
            return asInterface.getSerID(str, str2, "OUID");
        }
        throw new com.beizi.fusion.sm.b.d("IOpenID is null");
    }
}
