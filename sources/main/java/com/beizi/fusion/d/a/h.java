package com.beizi.fusion.d.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import com.beizi.fusion.d.a.b;
import com.beizi.fusion.d.b.e;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class h {

    /* renamed from: b, reason: collision with root package name */
    com.beizi.fusion.d.b.e f13392b;

    /* renamed from: d, reason: collision with root package name */
    private Context f13394d;

    /* renamed from: e, reason: collision with root package name */
    private String f13395e;

    /* renamed from: a, reason: collision with root package name */
    public String f13391a = "OUID";

    /* renamed from: c, reason: collision with root package name */
    ServiceConnection f13393c = new ServiceConnection() { // from class: com.beizi.fusion.d.a.h.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            h.this.f13392b = e.a.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            h.this.f13392b = null;
        }
    };

    public String a(b.a aVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot run on MainThread");
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        if (this.f13394d.bindService(intent, this.f13393c, 1)) {
            try {
                SystemClock.sleep(3000L);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            if (this.f13392b != null) {
                String a6 = a("OUID");
                if (aVar == null) {
                    return a6;
                }
                aVar.a(a6);
                return a6;
            }
        }
        return null;
    }

    public h(Context context) {
        this.f13394d = context;
    }

    private String a(String str) {
        Signature[] signatureArr;
        String packageName = this.f13394d.getPackageName();
        if (this.f13395e == null) {
            String str2 = null;
            try {
                signatureArr = this.f13394d.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception e6) {
                e6.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b6 : digest) {
                            sb.append(Integer.toHexString((b6 & 255) | 256).substring(1, 3));
                        }
                        str2 = sb.toString();
                    }
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
            this.f13395e = str2;
        }
        return ((e.a.C0132a) this.f13392b).a(packageName, this.f13395e, str);
    }
}
