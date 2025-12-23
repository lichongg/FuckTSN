package xyz.adscope.common.v2.dev.oaid.sm.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDException;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDLog;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.impl.OAIDService;
import xyz.adscope.common.v2.dev.oaid.sm.repeackage.com.uodis.opendevice.aidl.OpenDeviceIdentifierService;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class HuaweiImpl implements IOAID {
    private final Context context;
    private String packageName;

    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        Context context = this.context;
        if (context == null || iGetter == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                if (!TextUtils.isEmpty(string)) {
                    OAIDLog.print("Get oaid from global settings: " + string);
                    iGetter.onOAIDGetComplete(string);
                    return;
                }
            } catch (Exception e6) {
                OAIDLog.print(e6);
            }
        }
        if (TextUtils.isEmpty(this.packageName) && !supported()) {
            iGetter.onOAIDGetError(new OAIDException("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.packageName);
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: xyz.adscope.common.v2.dev.oaid.sm.oaid.impl.HuaweiImpl.1
            @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) {
                OpenDeviceIdentifierService asInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
                if (!asInterface.isOaidTrackLimited()) {
                    return asInterface.getOaid();
                }
                throw new OAIDException("User has disabled advertising identifier");
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
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.packageName = "com.huawei.hwid";
            } else {
                if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
                    this.packageName = "com.huawei.hms";
                    return packageManager.getPackageInfo("com.huawei.hms", 0) != null;
                }
                this.packageName = "com.huawei.hwid.tv";
            }
            return true;
        } catch (Exception e6) {
            OAIDLog.print(e6);
            return false;
        }
    }

    public HuaweiImpl(Context context) {
        this.context = context;
    }
}
