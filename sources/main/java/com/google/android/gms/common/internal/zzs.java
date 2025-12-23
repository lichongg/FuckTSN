package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzs extends GmsClientSupervisor {

    @GuardedBy("connectionStatus")
    private final HashMap zzb = new HashMap();
    private final Context zzc;
    private volatile Handler zzd;
    private final zzr zze;
    private final ConnectionTracker zzf;
    private final long zzg;
    private final long zzh;

    @Nullable
    private volatile Executor zzi;

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    protected final void zza(zzo zzoVar, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzb) {
            try {
                zzp zzpVar = (zzp) this.zzb.get(zzoVar);
                if (zzpVar == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: " + zzoVar.toString());
                }
                if (!zzpVar.zzh(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + zzoVar.toString());
                }
                zzpVar.zzf(serviceConnection, str);
                if (zzpVar.zzi()) {
                    this.zzd.sendMessageDelayed(this.zzd.obtainMessage(0, zzoVar), this.zzg);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    protected final boolean zzc(zzo zzoVar, ServiceConnection serviceConnection, String str, @Nullable Executor executor) {
        boolean zzj;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzb) {
            try {
                zzp zzpVar = (zzp) this.zzb.get(zzoVar);
                if (executor == null) {
                    executor = this.zzi;
                }
                if (zzpVar == null) {
                    zzpVar = new zzp(this, zzoVar);
                    zzpVar.zzd(serviceConnection, serviceConnection, str);
                    zzpVar.zze(str, executor);
                    this.zzb.put(zzoVar, zzpVar);
                } else {
                    this.zzd.removeMessages(0, zzoVar);
                    if (zzpVar.zzh(serviceConnection)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + zzoVar.toString());
                    }
                    zzpVar.zzd(serviceConnection, serviceConnection, str);
                    int zza = zzpVar.zza();
                    if (zza == 1) {
                        serviceConnection.onServiceConnected(zzpVar.zzb(), zzpVar.zzc());
                    } else if (zza == 2) {
                        zzpVar.zze(str, executor);
                    }
                }
                zzj = zzpVar.zzj();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzj;
    }

    final void zzi(@Nullable Executor executor) {
        synchronized (this.zzb) {
            this.zzi = executor;
        }
    }

    final void zzj(Looper looper) {
        synchronized (this.zzb) {
            this.zzd = new com.google.android.gms.internal.common.zzi(looper, this.zze);
        }
    }

    zzs(Context context, Looper looper, @Nullable Executor executor) {
        zzr zzrVar = new zzr(this, null);
        this.zze = zzrVar;
        this.zzc = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.zzd = new com.google.android.gms.internal.common.zzi(looper, zzrVar);
        this.zzf = ConnectionTracker.getInstance();
        this.zzg = 5000L;
        this.zzh = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        this.zzi = executor;
    }
}
