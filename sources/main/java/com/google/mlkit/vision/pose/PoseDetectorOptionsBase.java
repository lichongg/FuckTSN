package com.google.mlkit.vision.pose;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzba;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzn;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzo;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzse;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzsf;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzsg;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzsh;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzsi;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzsk;
import com.google.mlkit.acceleration.internal.AcceleratableDetectorOptions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class PoseDetectorOptionsBase implements AcceleratableDetectorOptions<PoseDetectorOptionsBase> {
    public static final int CPU = 1;
    public static final int CPU_GPU = 2;
    public static final int SINGLE_IMAGE_MODE = 2;
    public static final int STREAM_MODE = 1;
    private final int zza;

    @Nullable
    private final Executor zzb;
    private final boolean zzc;
    private final String zzd;
    private final String zze;

    @HardwareConfig
    private final int[] zzf;

    @Nullable
    private final String zzg;
    private final boolean zzh;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public static abstract class Builder<B extends Builder<B>> {

        @Nullable
        protected String zza;
        protected boolean zzb;

        @Nullable
        private Executor zzd;
        private boolean zze;
        private String zzf;
        private String zzg;

        @DetectorMode
        private int zzc = 1;

        @HardwareConfig
        private int[] zzh = {1, 2};

        @NonNull
        @KeepForSdk
        protected abstract PoseDetectorOptionsBase build();

        @NonNull
        @KeepForSdk
        public B setDetectorMode(@DetectorMode int i6) {
            this.zzc = i6;
            return this;
        }

        @NonNull
        @KeepForSdk
        public B setExecutor(@NonNull Executor executor) {
            this.zzd = executor;
            return this;
        }

        @NonNull
        @KeepForSdk
        public B setModelInfo(boolean z5, @NonNull String str, @NonNull String str2) {
            this.zze = z5;
            this.zzf = (String) Preconditions.checkNotNull(str, "personModelPath cannot be null");
            this.zzg = (String) Preconditions.checkNotNull(str2, "landmarkModelPath cannot be null");
            return this;
        }

        @NonNull
        @KeepForSdk
        public B setPreferredHardwareConfigs(@HardwareConfig int i6, @NonNull @HardwareConfig int... iArr) {
            Preconditions.checkArgument(iArr != null, "moreConfigs cannot be null");
            int length = iArr.length;
            int[] copyOf = Arrays.copyOf(iArr, length + 1);
            this.zzh = copyOf;
            copyOf[length] = i6;
            return this;
        }

        protected Builder() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.CLASS)
    public @interface DetectorMode {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.CLASS)
    public @interface HardwareConfig {
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PoseDetectorOptionsBase)) {
            return false;
        }
        PoseDetectorOptionsBase poseDetectorOptionsBase = (PoseDetectorOptionsBase) obj;
        return getClass().equals(poseDetectorOptionsBase.getClass()) && this.zza == poseDetectorOptionsBase.zza && this.zzc == poseDetectorOptionsBase.zzc && Objects.equal(this.zzd, poseDetectorOptionsBase.zzd) && Objects.equal(this.zze, poseDetectorOptionsBase.zze) && Arrays.equals(this.zzf, poseDetectorOptionsBase.zzf) && Objects.equal(this.zzg, poseDetectorOptionsBase.zzg) && this.zzh == poseDetectorOptionsBase.zzh && Objects.equal(this.zzb, poseDetectorOptionsBase.zzb);
    }

    private final zza zzh() {
        zza zzaVar = new zza();
        zzaVar.zza = this.zzg;
        zzaVar.zzb = this.zzh;
        zzaVar.setDetectorMode(this.zza);
        zzaVar.setModelInfo(this.zzc, this.zzd, this.zze);
        Executor executor = this.zzb;
        if (executor != null) {
            zzaVar.setExecutor(executor);
        }
        int[] iArr = this.zzf;
        int length = iArr.length;
        int i6 = length - 1;
        int i7 = iArr[i6];
        if (length == 1) {
            zzaVar.setPreferredHardwareConfigs(i7, new int[0]);
            return zzaVar;
        }
        zzaVar.setPreferredHardwareConfigs(i7, Arrays.copyOf(iArr, i6));
        return zzaVar;
    }

    @Nullable
    @KeepForSdk
    public Executor getExecutor() {
        return this.zzb;
    }

    @Override // com.google.mlkit.acceleration.internal.AcceleratableDetectorOptions
    @NonNull
    @HardwareConfig
    public final int[] getPreferredHardwareConfigs() {
        return this.zzf;
    }

    @Override // com.google.mlkit.acceleration.internal.AcceleratableDetectorOptions
    @Nullable
    public final String getRunConfigName() {
        return this.zzg;
    }

    @Override // com.google.mlkit.acceleration.internal.AcceleratableDetectorOptions
    public final boolean isForBenchmark() {
        return this.zzh;
    }

    @NonNull
    public String toString() {
        zzn zza = zzo.zza("PoseDetectorOptionsBase");
        zza.zza("detectorMode", this.zza);
        zza.zzc("areFastModels", this.zzc);
        zza.zzb("personModelPath", this.zzd);
        zza.zzb("landmarkModelPath", this.zze);
        zza.zzb("executor", this.zzb);
        return zza.toString();
    }

    @DetectorMode
    @VisibleForTesting
    public final int zza() {
        return this.zza;
    }

    public final zzsk zzb() {
        zzse zzseVar = new zzse();
        if (this.zza == 1) {
            zzseVar.zzb(zzsf.STREAM);
        } else {
            zzseVar.zzb(zzsf.SINGLE_IMAGE);
        }
        if (this.zzc) {
            zzsh zzshVar = zzsh.FAST;
            zzseVar.zzd(zzshVar);
            zzseVar.zzc(zzshVar);
        } else {
            zzsh zzshVar2 = zzsh.ACCURATE;
            zzseVar.zzd(zzshVar2);
            zzseVar.zzc(zzshVar2);
        }
        zzba zzbaVar = new zzba();
        for (int i6 : this.zzf) {
            zzbaVar.zzb(zzsg.zzb(i6));
        }
        zzseVar.zze(zzbaVar.zzc());
        String str = this.zzg;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 337549753) {
                if (hashCode == 1693142784 && str.equals("default_config")) {
                    zzseVar.zzf(zzsi.RUN_CONFIG_DEFAULT);
                }
                zzseVar.zzf(zzsi.RUN_CONFIG_UNKNOWN);
            } else {
                if (str.equals("cpu-gpu-opencl")) {
                    zzseVar.zzf(zzsi.RUN_CONFIG_CPU_GPU_OPENCL);
                }
                zzseVar.zzf(zzsi.RUN_CONFIG_UNKNOWN);
            }
        }
        return zzseVar.zzk();
    }

    @NonNull
    public final String zze() {
        return this.zze;
    }

    @NonNull
    public final String zzf() {
        return this.zzd;
    }

    public final boolean zzg() {
        return this.zzc;
    }

    @KeepForSdk
    protected PoseDetectorOptionsBase(@NonNull Builder<?> builder) {
        this.zza = ((Builder) builder).zzc;
        this.zzb = ((Builder) builder).zzd;
        this.zzc = ((Builder) builder).zze;
        this.zzd = ((Builder) builder).zzf;
        this.zze = ((Builder) builder).zzg;
        this.zzf = ((Builder) builder).zzh;
        this.zzg = builder.zza;
        this.zzh = builder.zzb;
    }

    @Override // com.google.mlkit.acceleration.internal.AcceleratableDetectorOptions
    @NonNull
    public final /* bridge */ /* synthetic */ PoseDetectorOptionsBase decode(@NonNull String str) {
        AcceleratableDetectorOptions.KeyValueDecoder newInstance = AcceleratableDetectorOptions.KeyValueDecoder.newInstance(str);
        zza zzaVar = new zza();
        zzaVar.setDetectorMode(((Integer) Preconditions.checkNotNull(newInstance.getInt("detector_mode"))).intValue());
        zzaVar.setModelInfo(((Boolean) Preconditions.checkNotNull(newInstance.getBoolean("are_fast_models"))).booleanValue(), (String) Preconditions.checkNotNull(newInstance.getString("person_model_path")), (String) Preconditions.checkNotNull(newInstance.getString("landmark_model_path")));
        zzaVar.zza = newInstance.getString("run_config_name");
        zzaVar.zzb = true;
        return new PoseDetectorOptionsBase(zzaVar);
    }

    @Override // com.google.mlkit.acceleration.internal.AcceleratableDetectorOptions
    @NonNull
    public final String encode() {
        return AcceleratableDetectorOptions.KeyValueEncoder.newInstance().addInt("detector_mode", this.zza).addBoolean("are_fast_models", this.zzc).addString("person_model_path", this.zzd).addString("landmark_model_path", this.zze).addString("run_config_name", this.zzg).encode();
    }

    public int hashCode() {
        return Objects.hashCode(getClass(), Integer.valueOf(this.zza), Boolean.valueOf(this.zzc), this.zzd, this.zze, Integer.valueOf(Arrays.hashCode(this.zzf)), this.zzg, Boolean.valueOf(this.zzh), this.zzb);
    }

    @NonNull
    public final PoseDetectorOptionsBase zzc() {
        zza zzh = zzh();
        zzh.setDetectorMode(2);
        return new PoseDetectorOptionsBase(zzh);
    }

    @Override // com.google.mlkit.acceleration.internal.AcceleratableDetectorOptions
    @NonNull
    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final PoseDetectorOptionsBase cloneWithRunConfigAssigned(@NonNull String str, boolean z5) {
        zza zzh = zzh();
        zzh.zza = str;
        zzh.zzb = z5;
        return new PoseDetectorOptionsBase(zzh);
    }
}
