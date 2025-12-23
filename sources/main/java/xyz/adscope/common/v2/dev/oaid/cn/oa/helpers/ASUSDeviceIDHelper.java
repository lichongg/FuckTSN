package xyz.adscope.common.v2.dev.oaid.cn.oa.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import xyz.adscope.common.v2.dev.oaid.cn.oa.helpers.DevicesIDsHelper;
import xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces.ASUSIDInterface;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ASUSDeviceIDHelper {
    private Context mContext;
    private final String TAG = "ASUSDeviceIDHelper";
    public final LinkedBlockingQueue<IBinder> linkedBlockingQueue = new LinkedBlockingQueue<>(1);
    ServiceConnection serviceConnection = new ServiceConnection() { // from class: xyz.adscope.common.v2.dev.oaid.cn.oa.helpers.ASUSDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                ASUSDeviceIDHelper.this.linkedBlockingQueue.put(iBinder);
            } catch (Exception e6) {
                SDKLog.stack(e6);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public void getID(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        try {
            this.mContext.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0);
        } catch (Exception e6) {
            SDKLog.stack(e6);
        }
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        if (this.mContext.bindService(intent, this.serviceConnection, 1)) {
            try {
                String id = new ASUSIDInterface.ASUSID(this.linkedBlockingQueue.take()).getID();
                if (appIdsUpdater != null) {
                    appIdsUpdater.OnIdsValid(id);
                }
            } catch (Exception e7) {
                SDKLog.stack(e7);
            }
        }
    }

    public ASUSDeviceIDHelper(Context context) {
        this.mContext = context;
    }
}
