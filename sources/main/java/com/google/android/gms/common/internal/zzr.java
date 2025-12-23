package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzr implements Handler.Callback {
    final /* synthetic */ zzs zza;

    /* synthetic */ zzr(zzs zzsVar, zzq zzqVar) {
        this.zza = zzsVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        HashMap hashMap4;
        HashMap hashMap5;
        int i6 = message.what;
        if (i6 == 0) {
            hashMap = this.zza.zzb;
            synchronized (hashMap) {
                try {
                    zzo zzoVar = (zzo) message.obj;
                    hashMap2 = this.zza.zzb;
                    zzp zzpVar = (zzp) hashMap2.get(zzoVar);
                    if (zzpVar != null && zzpVar.zzi()) {
                        if (zzpVar.zzj()) {
                            zzpVar.zzg("GmsClientSupervisor");
                        }
                        hashMap3 = this.zza.zzb;
                        hashMap3.remove(zzoVar);
                    }
                } finally {
                }
            }
            return true;
        }
        if (i6 != 1) {
            return false;
        }
        hashMap4 = this.zza.zzb;
        synchronized (hashMap4) {
            try {
                zzo zzoVar2 = (zzo) message.obj;
                hashMap5 = this.zza.zzb;
                zzp zzpVar2 = (zzp) hashMap5.get(zzoVar2);
                if (zzpVar2 != null && zzpVar2.zza() == 3) {
                    String.valueOf(zzoVar2);
                    new Exception();
                    ComponentName zzb = zzpVar2.zzb();
                    if (zzb == null) {
                        zzb = zzoVar2.zza();
                    }
                    if (zzb == null) {
                        String zzc = zzoVar2.zzc();
                        Preconditions.checkNotNull(zzc);
                        zzb = new ComponentName(zzc, "unknown");
                    }
                    zzpVar2.onServiceDisconnected(zzb);
                }
            } finally {
            }
        }
        return true;
    }
}
