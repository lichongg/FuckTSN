package xyz.adscope.common.v2.dev.oaid.sm.oaid.impl;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.stub.StubApp;
import java.security.MessageDigest;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDException;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDLog;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.impl.OAIDService;
import xyz.adscope.common.v2.dev.oaid.sm.repeackage.com.heytap.openid.IOpenID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class OppoImpl implements IOAID {
    private final Context context;
    private String sign;

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"PackageManagerGetSignatures"})
    public String realGetOUID(IBinder iBinder) {
        String packageName = this.context.getPackageName();
        String str = this.sign;
        if (str != null) {
            return getSerId(iBinder, packageName, str);
        }
        byte[] digest = MessageDigest.getInstance("SHA1").digest(this.context.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b6 : digest) {
            sb.append(Integer.toHexString((b6 & 255) | 256).substring(1, 3));
        }
        String sb2 = sb.toString();
        this.sign = sb2;
        return getSerId(iBinder, packageName, sb2);
    }

    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: xyz.adscope.common.v2.dev.oaid.sm.oaid.impl.OppoImpl.1
            @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) {
                try {
                    return OppoImpl.this.realGetOUID(iBinder);
                } catch (RemoteException e6) {
                    throw e6;
                } catch (OAIDException e7) {
                    throw e7;
                } catch (Exception e8) {
                    throw new OAIDException(e8);
                }
            }
        });
    }

    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID
    public boolean supported() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e6) {
            OAIDLog.print(e6);
            return false;
        }
    }

    public OppoImpl(Context context) {
        if (context instanceof Application) {
            this.context = context;
        } else {
            this.context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    private String getSerId(IBinder iBinder, String str, String str2) {
        IOpenID asInterface = IOpenID.Stub.asInterface(iBinder);
        if (asInterface != null) {
            return asInterface.getSerID(str, str2, "OUID");
        }
        throw new OAIDException("IOpenID is null");
    }
}
