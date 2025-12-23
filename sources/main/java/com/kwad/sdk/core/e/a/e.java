package com.kwad.sdk.core.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.b.e;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> mLinkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.core.e.a.e.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                com.kwad.sdk.core.d.c.i("LenovoDeviceIDHelper", "onServiceConnected");
                e.this.mLinkedBlockingQueue.put(iBinder);
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public final String getOAID() {
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (!this.mContext.bindService(intent, this.serviceConnection, 1)) {
                return "";
            }
            try {
                try {
                    str = new e.a(this.mLinkedBlockingQueue.take()).getOaid();
                    com.kwad.sdk.core.d.c.i("LenovoDeviceIDHelper", "getOAID oaid:" + str);
                    return str;
                } catch (Exception e6) {
                    com.kwad.sdk.core.d.c.printStackTrace(e6);
                    this.mContext.unbindService(this.serviceConnection);
                    return str;
                }
            } finally {
                this.mContext.unbindService(this.serviceConnection);
            }
        } catch (Exception e7) {
            com.kwad.sdk.core.d.c.i("LenovoDeviceIDHelper", "getOAID Lenovo service not found");
            com.kwad.sdk.core.d.c.printStackTrace(e7);
            return str;
        }
    }

    public e(Context context) {
        this.mContext = context;
    }
}
