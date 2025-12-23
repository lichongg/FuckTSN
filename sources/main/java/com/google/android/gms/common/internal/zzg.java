package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzg extends zza {
    final /* synthetic */ BaseGmsClient zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public zzg(BaseGmsClient baseGmsClient, @Nullable int i6, Bundle bundle) {
        super(baseGmsClient, i6, null);
        this.zze = baseGmsClient;
    }

    @Override // com.google.android.gms.common.internal.zza
    protected final void zzb(ConnectionResult connectionResult) {
        if (this.zze.enableLocalFallback() && BaseGmsClient.zzo(this.zze)) {
            BaseGmsClient.zzk(this.zze, 16);
        } else {
            this.zze.zzc.onReportServiceBinding(connectionResult);
            this.zze.onConnectionFailed(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.internal.zza
    protected final boolean zzd() {
        this.zze.zzc.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
        return true;
    }
}
