package com.kwad.sdk.liteapi.oaid.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.oaid.interfaces.ZTEIDInterface;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class ZTEDeviceIDHelper {
    private static final String TAG = "ZTEDeviceIDHelper";
    public Context mContext;
    private final LinkedBlockingQueue<IBinder> mLinkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.liteapi.oaid.helpers.ZTEDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                LiteApiLogger.i(ZTEDeviceIDHelper.TAG, "onServiceConnected");
                ZTEDeviceIDHelper.this.mLinkedBlockingQueue.put(iBinder);
            } catch (Exception e6) {
                LiteApiLogger.printStackTrace(e6);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    private void startMsaklServer(String str) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            this.mContext.startService(intent);
        } catch (Exception e6) {
            LiteApiLogger.printStackTrace(e6);
        }
    }

    public String getOAID() {
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent.setAction("com.bun.msa.action.bindto.service");
            intent.putExtra("com.bun.msa.param.pkgname", this.mContext.getPackageName());
            boolean bindService = this.mContext.bindService(intent, this.serviceConnection, 1);
            LiteApiLogger.i(TAG, "getOAID isBind=" + bindService);
            if (!bindService) {
                return "";
            }
            try {
                try {
                    str = new ZTEIDInterface.a(this.mLinkedBlockingQueue.take()).getOAID();
                    LiteApiLogger.i(TAG, "getOAID oaid:" + str);
                    return str;
                } catch (Exception e6) {
                    LiteApiLogger.printStackTrace(e6);
                    this.mContext.unbindService(this.serviceConnection);
                    return str;
                }
            } finally {
                this.mContext.unbindService(this.serviceConnection);
            }
        } catch (Exception e7) {
            LiteApiLogger.i(TAG, "getOAID hw service not found");
            LiteApiLogger.printStackTrace(e7);
            return str;
        }
    }

    public ZTEDeviceIDHelper(Context context) {
        this.mContext = context;
    }
}
