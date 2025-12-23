package com.google.mlkit.acceleration.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.acceleration.internal.AcceleratableDetectorOptions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class RunConfig<OptionsT extends AcceleratableDetectorOptions<OptionsT>> {
    private final PipelineId zza;
    private final AcceleratableDetectorOptions zzb;
    private final String zzc;
    private final boolean zzd;

    @Nullable
    private final MiniBenchmarkResult zze;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public static class Builder<OptionsT extends AcceleratableDetectorOptions<OptionsT>> {
        private PipelineId zza;
        private AcceleratableDetectorOptions zzb;
        private String zzc;
        private boolean zzd;

        @Nullable
        private MiniBenchmarkResult zze;

        @NonNull
        @KeepForSdk
        public RunConfig<OptionsT> build() {
            return new RunConfig<>(this, null);
        }

        @NonNull
        @KeepForSdk
        public Builder<OptionsT> setBaseOptions(@NonNull OptionsT optionst) {
            this.zzb = optionst;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<OptionsT> setConfigName(@NonNull String str) {
            this.zzc = str;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<OptionsT> setMiniBenchmarkRequired(boolean z5) {
            this.zzd = z5;
            return this;
        }

        @NonNull
        @KeepForSdk
        Builder<OptionsT> setMiniBenchmarkResult(@Nullable MiniBenchmarkResult miniBenchmarkResult) {
            this.zze = miniBenchmarkResult;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<OptionsT> setPipelineId(@NonNull PipelineId pipelineId) {
            this.zza = pipelineId;
            return this;
        }
    }

    @NonNull
    public final String toString() {
        com.google.android.gms.internal.mlkit_acceleration.zzt zza = com.google.android.gms.internal.mlkit_acceleration.zzu.zza("RunConfig");
        zza.zza("configName", this.zzc);
        zza.zza("miniBenchmarkResult", this.zze);
        return zza.toString();
    }

    @NonNull
    public final AcceleratableDetectorOptions zza() {
        return this.zzb;
    }

    @NonNull
    public final AcceleratableDetectorOptions zzb() {
        return (AcceleratableDetectorOptions) this.zzb.cloneWithRunConfigAssigned(this.zzc, false);
    }

    @Nullable
    public final MiniBenchmarkResult zzc() {
        return this.zze;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public final Builder zzd() {
        Builder builder = new Builder();
        builder.setPipelineId(this.zza);
        builder.setBaseOptions(this.zzb);
        builder.setConfigName(this.zzc);
        builder.setMiniBenchmarkRequired(this.zzd);
        builder.setMiniBenchmarkResult(this.zze);
        return builder;
    }

    @NonNull
    public final String zze() {
        return this.zzc;
    }

    public final boolean zzf() {
        return "default_config".equals(this.zzc);
    }

    public final boolean zzg() {
        return this.zzd;
    }

    /* synthetic */ RunConfig(Builder builder, zzv zzvVar) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = builder.zzc;
        this.zzd = builder.zzd;
        this.zze = builder.zze;
    }
}
