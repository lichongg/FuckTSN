package xyz.adscope.common.v2.dev.oaid.cn.oa.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import java.security.MessageDigest;
import xyz.adscope.common.v2.dev.oaid.cn.oa.helpers.DevicesIDsHelper;
import xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces.OppoIDInterface;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class OppoDeviceIDHelper {
    private static final String TAG = "OppoDeviceIDHelper";
    private Context mContext;
    OppoIDInterface oppoIDInterface;
    private String sign;
    public String oaid = "OUID";
    ServiceConnection serviceConnection = new ServiceConnection() { // from class: xyz.adscope.common.v2.dev.oaid.cn.oa.helpers.OppoDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            OppoDeviceIDHelper.this.oppoIDInterface = OppoIDInterface.up.genInterface(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            OppoDeviceIDHelper.this.oppoIDInterface = null;
        }
    };

    private boolean isSupportOppo() {
        try {
            PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (packageInfo == null) {
                return false;
            }
            return (Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode) >= 1;
        } catch (Exception e6) {
            SDKLog.stack(e6);
            return true;
        }
    }

    private String realoGetIds(String str) {
        Signature[] signatureArr;
        String packageName = this.mContext.getPackageName();
        if (this.sign == null) {
            String str2 = null;
            try {
                signatureArr = this.mContext.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception e6) {
                SDKLog.stack(e6);
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
                    SDKLog.stack(e7);
                }
            }
            this.sign = str2;
        }
        return ((OppoIDInterface.up.down) this.oppoIDInterface).getSerID(packageName, this.sign, str);
    }

    public OppoDeviceIDHelper(Context context) {
        this.mContext = context;
    }

    public String getID(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (this.mContext.bindService(intent, this.serviceConnection, 1)) {
                try {
                    SystemClock.sleep(3000L);
                } catch (Exception e6) {
                    SDKLog.stack(e6);
                }
                if (this.oppoIDInterface != null) {
                    String realoGetIds = realoGetIds("OUID");
                    if (appIdsUpdater != null) {
                        appIdsUpdater.OnIdsValid(realoGetIds);
                        return realoGetIds;
                    }
                    return realoGetIds;
                }
            }
            return null;
        }
        throw new IllegalStateException("Cannot run on MainThread");
    }
}
