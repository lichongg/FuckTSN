package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class zza extends zzc {
    public final int zza;

    @Nullable
    public final Bundle zzb;
    final /* synthetic */ BaseGmsClient zzc;

    protected abstract void zzb(ConnectionResult connectionResult);

    protected abstract boolean zzd();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    protected zza(BaseGmsClient baseGmsClient, @Nullable int i6, Bundle bundle) {
        super(baseGmsClient, Boolean.TRUE);
        this.zzc = baseGmsClient;
        this.zza = i6;
        this.zzb = bundle;
    }

    @Override // com.google.android.gms.common.internal.zzc
    protected final /* bridge */ /* synthetic */ void zza(Object obj) {
        if (this.zza != 0) {
            this.zzc.zzp(1, null);
            Bundle bundle = this.zzb;
            zzb(new ConnectionResult(this.zza, bundle != null ? (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT) : null));
        } else {
            if (zzd()) {
                return;
            }
            this.zzc.zzp(1, null);
            zzb(new ConnectionResult(8, null));
        }
    }

    @Override // com.google.android.gms.common.internal.zzc
    protected final void zzc() {
    }
}
