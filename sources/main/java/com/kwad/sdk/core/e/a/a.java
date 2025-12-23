package com.kwad.sdk.core.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.b.a;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> linkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.core.e.a.a.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a.this.linkedBlockingQueue.put(iBinder);
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
            intent.setAction("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            try {
                if (!this.mContext.bindService(intent, this.serviceConnection, 1)) {
                    return "";
                }
                try {
                    str = new a.C0686a(this.linkedBlockingQueue.take()).getID();
                    com.kwad.sdk.core.d.c.i("ASUSDeviceIDHelper", "getOAID oaid:" + str);
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
            com.kwad.sdk.core.d.c.i("ASUSDeviceIDHelper", "getOAID asus service not found;");
            com.kwad.sdk.core.d.c.printStackTrace(e7);
        }
    }

    public a(Context context) {
        this.mContext = context;
    }
}
