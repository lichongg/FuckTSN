package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.VisibleForTesting;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@VisibleForTesting
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zze implements ServiceConnection {
    final /* synthetic */ BaseGmsClient zza;
    private final int zzb;

    public zze(BaseGmsClient baseGmsClient, int i6) {
        this.zza = baseGmsClient;
        this.zzb = i6;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object obj;
        BaseGmsClient baseGmsClient = this.zza;
        if (iBinder == null) {
            BaseGmsClient.zzk(baseGmsClient, 16);
            return;
        }
        obj = baseGmsClient.zzq;
        synchronized (obj) {
            try {
                BaseGmsClient baseGmsClient2 = this.zza;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                baseGmsClient2.zzr = (queryLocalInterface == null || !(queryLocalInterface instanceof IGmsServiceBroker)) ? new zzad(iBinder) : (IGmsServiceBroker) queryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.zza.zzl(0, null, this.zzb);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Object obj;
        obj = this.zza.zzq;
        synchronized (obj) {
            this.zza.zzr = null;
        }
        BaseGmsClient baseGmsClient = this.zza;
        int i6 = this.zzb;
        Handler handler = baseGmsClient.zzb;
        handler.sendMessage(handler.obtainMessage(6, i6, 1));
    }
}
