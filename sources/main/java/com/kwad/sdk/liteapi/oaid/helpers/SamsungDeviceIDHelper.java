package com.kwad.sdk.liteapi.oaid.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.oaid.interfaces.SamsungIDInterface;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class SamsungDeviceIDHelper {
    private static final String TAG = "SamsungDeviceIDHelper";
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> linkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.liteapi.oaid.helpers.SamsungDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                SamsungDeviceIDHelper.this.linkedBlockingQueue.put(iBinder);
            } catch (Exception e6) {
                LiteApiLogger.printStackTrace(e6);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public String getOAID() {
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            if (!this.mContext.bindService(intent, this.serviceConnection, 1)) {
                return "";
            }
            try {
                try {
                    str = new SamsungIDInterface.a(this.linkedBlockingQueue.take()).getID();
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
            LiteApiLogger.i(TAG, "getOAID service not found");
            LiteApiLogger.printStackTrace(e7);
            return str;
        }
    }

    public SamsungDeviceIDHelper(Context context) {
        this.mContext = context;
    }
}
