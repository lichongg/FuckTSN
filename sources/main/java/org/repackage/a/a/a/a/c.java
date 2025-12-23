package org.repackage.a.a.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.repackage.a.a.a.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public org.repackage.a.a.a.a f51578a = null;

    /* renamed from: b, reason: collision with root package name */
    public String f51579b = null;

    /* renamed from: c, reason: collision with root package name */
    public String f51580c = null;

    /* renamed from: d, reason: collision with root package name */
    public final Object f51581d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public ServiceConnection f51582e = new b(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final c f51583a = new c(null);
    }

    public boolean a(Context context) {
        long longVersionCode;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (Build.VERSION.SDK_INT < 28) {
                return packageInfo != null && packageInfo.versionCode >= 1;
            }
            if (packageInfo != null) {
                longVersionCode = packageInfo.getLongVersionCode();
                if (longVersionCode >= 1) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public final String b(Context context, String str) {
        Signature[] signatureArr;
        if (TextUtils.isEmpty(this.f51579b)) {
            this.f51579b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.f51580c)) {
            String str2 = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.f51579b, 64).signatures;
            } catch (PackageManager.NameNotFoundException e6) {
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
                } catch (NoSuchAlgorithmException e7) {
                    e7.printStackTrace();
                }
            }
            this.f51580c = str2;
        }
        String a6 = ((a.AbstractBinderC0997a.C0998a) this.f51578a).a(this.f51579b, this.f51580c, str);
        return TextUtils.isEmpty(a6) ? "" : a6;
    }

    public /* synthetic */ c(b bVar) {
    }

    public synchronized String a(Context context, String str) {
        try {
        } catch (Throwable th) {
            throw th;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (this.f51578a == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                if (context.bindService(intent, this.f51582e, 1)) {
                    synchronized (this.f51581d) {
                        try {
                            this.f51581d.wait(3000L);
                        } catch (InterruptedException e6) {
                            e6.printStackTrace();
                        }
                    }
                }
                if (this.f51578a == null) {
                    return "";
                }
                try {
                    return b(context, str);
                } catch (RemoteException e7) {
                    e7.printStackTrace();
                    return "";
                }
            }
            try {
                return b(context, str);
            } catch (RemoteException e8) {
                e8.printStackTrace();
                return "";
            }
            throw th;
        }
        throw new IllegalStateException("Cannot run on MainThread");
    }
}
