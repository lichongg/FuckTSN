package xyz.adscope.common.v2.dev.oaid.cn.oa.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import xyz.adscope.common.v2.dev.oaid.cn.oa.helpers.DevicesIDsHelper;
import xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces.LenovoIDInterface;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class LenovoDeviceIDHelper {
    LenovoIDInterface lenovoIDInterface;
    private Context mContext;
    ServiceConnection serviceConnection = new ServiceConnection() { // from class: xyz.adscope.common.v2.dev.oaid.cn.oa.helpers.LenovoDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LenovoDeviceIDHelper.this.lenovoIDInterface = new LenovoIDInterface.len_up.len_down(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public void getIdRun(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        LenovoIDInterface lenovoIDInterface;
        this.mContext.getPackageName();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (!this.mContext.bindService(intent, this.serviceConnection, 1) || (lenovoIDInterface = this.lenovoIDInterface) == null) {
            return;
        }
        String a6 = lenovoIDInterface.a();
        if (appIdsUpdater != null) {
            appIdsUpdater.OnIdsValid(a6);
        }
    }

    public LenovoDeviceIDHelper(Context context) {
        this.mContext = context;
    }
}
