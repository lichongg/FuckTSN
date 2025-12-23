package xyz.adscope.common.v2.dev.oaid.cn.oa.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import xyz.adscope.common.v2.dev.oaid.cn.oa.helpers.DevicesIDsHelper;
import xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces.HWIDInterface;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class HWDeviceIDHelper {
    private static final String TAG = "HWDeviceIDHelper";
    private Context mContext;
    public final LinkedBlockingQueue<IBinder> linkedBlockingQueue = new LinkedBlockingQueue<>(1);
    ServiceConnection serviceConnection = new ServiceConnection() { // from class: xyz.adscope.common.v2.dev.oaid.cn.oa.helpers.HWDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                HWDeviceIDHelper.this.linkedBlockingQueue.put(iBinder);
            } catch (Exception e6) {
                SDKLog.stack(e6);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public void getHWID(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        try {
            this.mContext.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
        } catch (Exception e6) {
            SDKLog.stack(e6);
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            if (this.mContext.bindService(intent, this.serviceConnection, 1)) {
                try {
                    HWIDInterface.HWID hwid = new HWIDInterface.HWID(this.linkedBlockingQueue.take());
                    String iDs = hwid.getIDs();
                    hwid.getBoos();
                    if (appIdsUpdater != null) {
                        appIdsUpdater.OnIdsValid(iDs);
                    }
                } catch (Exception e7) {
                    SDKLog.stack(e7);
                }
            }
        } finally {
            this.mContext.unbindService(this.serviceConnection);
        }
    }

    public HWDeviceIDHelper(Context context) {
        this.mContext = context;
    }
}
