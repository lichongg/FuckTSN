package com.kwad.sdk.core.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import com.kwad.sdk.core.e.b.f;
import com.kwad.sdk.utils.y;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> mLinkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.core.e.a.j.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.kwad.sdk.core.d.c.i("OppoDeviceIDHelper", "onServiceConnected");
            try {
                j.this.mLinkedBlockingQueue.put(iBinder);
            } catch (InterruptedException e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    private String getSign() {
        Signature[] signatureArr;
        try {
            Context context = this.mContext;
            PackageInfo packageInfo = y.getPackageInfo(context, context.getPackageName(), 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return null;
            }
            byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b6 : digest) {
                sb.append(Integer.toHexString((b6 & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            return null;
        }
    }

    public final String getOAID() {
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            boolean bindService = this.mContext.bindService(intent, this.serviceConnection, 1);
            com.kwad.sdk.core.d.c.i("OppoDeviceIDHelper", "getOAID isBin=" + bindService);
            if (!bindService) {
                return "";
            }
            try {
                try {
                    str = new f.a(this.mLinkedBlockingQueue.take()).getSerID(this.mContext.getPackageName(), getSign(), "OUID");
                    com.kwad.sdk.core.d.c.i("OppoDeviceIDHelper", "getOAID oaid" + str);
                    return str;
                } finally {
                    this.mContext.unbindService(this.serviceConnection);
                }
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
                this.mContext.unbindService(this.serviceConnection);
                return str;
            }
        } catch (Exception e7) {
            com.kwad.sdk.core.d.c.i("OppoDeviceIDHelper", "getOAID service not found");
            com.kwad.sdk.core.d.c.printStackTraceOnly(e7);
            return str;
        }
    }

    public j(Context context) {
        this.mContext = context;
    }
}
