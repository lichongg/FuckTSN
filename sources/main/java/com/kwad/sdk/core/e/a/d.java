package com.kwad.sdk.core.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.b.d;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> mLinkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.core.e.a.d.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                com.kwad.sdk.core.d.c.i("HWDeviceIDHelper", "onServiceConnected");
                d.this.mLinkedBlockingQueue.put(iBinder);
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
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            try {
                if (!this.mContext.bindService(intent, this.serviceConnection, 1)) {
                    return "";
                }
                try {
                    d.a aVar = new d.a(this.mLinkedBlockingQueue.take());
                    str = aVar.getIDs();
                    com.kwad.sdk.core.d.c.i("HWDeviceIDHelper", "getOAID oaid:" + str + "--boos:" + aVar.getBoos());
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
            com.kwad.sdk.core.d.c.i("HWDeviceIDHelper", "getOAID hw service not found");
            com.kwad.sdk.core.d.c.printStackTraceOnly(e7);
        }
    }

    public d(Context context) {
        this.mContext = context;
    }
}
