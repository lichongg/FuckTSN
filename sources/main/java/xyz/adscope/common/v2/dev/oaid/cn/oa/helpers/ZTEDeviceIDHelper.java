package xyz.adscope.common.v2.dev.oaid.cn.oa.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import xyz.adscope.common.v2.dev.oaid.cn.oa.helpers.DevicesIDsHelper;
import xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces.ZTEIDInterface;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ZTEDeviceIDHelper {
    private static final String TAG = "ZTEDeviceIDHelper";
    Context mContext;
    String idPkgName = "com.mdid.msa";
    public final LinkedBlockingQueue<IBinder> linkedBlockingQueue = new LinkedBlockingQueue<>(1);
    ServiceConnection serviceConnection = new ServiceConnection() { // from class: xyz.adscope.common.v2.dev.oaid.cn.oa.helpers.ZTEDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                ZTEDeviceIDHelper.this.linkedBlockingQueue.put(iBinder);
            } catch (Exception e6) {
                SDKLog.stack(e6);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    private int checkService() {
        try {
            this.mContext.getPackageManager().getPackageInfo(this.idPkgName, 0);
            return 1;
        } catch (Exception e6) {
            SDKLog.stack(e6);
            return 0;
        }
    }

    public void getID(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        try {
            this.mContext.getPackageManager().getPackageInfo(this.idPkgName, 0);
        } catch (Exception e6) {
            SDKLog.stack(e6);
        }
        String packageName = this.mContext.getPackageName();
        startMsaklServer(packageName);
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", packageName);
        if (this.mContext.bindService(intent, this.serviceConnection, 1)) {
            try {
                String oaid = new ZTEIDInterface.up.down(this.linkedBlockingQueue.take()).getOAID();
                if (appIdsUpdater != null) {
                    appIdsUpdater.OnIdsValid(oaid);
                }
                this.mContext.unbindService(this.serviceConnection);
            } catch (Exception e7) {
                SDKLog.stack(e7);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ZTEDeviceIDHelper(Context context) {
        this.mContext = context;
    }

    private void startMsaklServer(String str) {
        checkService();
        Intent intent = new Intent();
        intent.setClassName(this.idPkgName, "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            this.mContext.startService(intent);
        } catch (Exception e6) {
            SDKLog.stack(e6);
        }
    }
}
