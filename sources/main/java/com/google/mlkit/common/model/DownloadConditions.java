package com.google.mlkit.common.model;

import android.annotation.TargetApi;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.internal.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class DownloadConditions {
    private final boolean zza;
    private final boolean zzb;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {
        private boolean zza = false;
        private boolean zzb = false;

        @NonNull
        @RequiresApi(24)
        @TargetApi(24)
        public Builder requireCharging() {
            this.zza = true;
            return this;
        }

        @NonNull
        public Builder requireWifi() {
            this.zzb = true;
            return this;
        }

        @NonNull
        public DownloadConditions build() {
            return new DownloadConditions(this.zza, this.zzb, null);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DownloadConditions)) {
            return false;
        }
        DownloadConditions downloadConditions = (DownloadConditions) obj;
        return this.zza == downloadConditions.zza && this.zzb == downloadConditions.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zza), Boolean.valueOf(this.zzb));
    }

    public boolean isChargingRequired() {
        return this.zza;
    }

    public boolean isWifiRequired() {
        return this.zzb;
    }

    /* synthetic */ DownloadConditions(boolean z5, boolean z6, zzb zzbVar) {
        this.zza = z5;
        this.zzb = z6;
    }
}
