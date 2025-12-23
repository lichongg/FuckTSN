package com.google.android.gms.internal.mlkit_vision_pose_common;

import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.acceleration.internal.AcceleratableDetectorOptions;
import com.google.mlkit.acceleration.internal.AccelerationInfraException;
import com.google.mlkit.acceleration.internal.AccelerationLogger;
import com.google.mlkit.acceleration.internal.MiniBenchmarkResult;
import com.google.mlkit.acceleration.internal.PipelineId;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.pose.PoseDetectorOptionsBase;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzvi implements AccelerationLogger {
    private static final Object zza = new Object();

    @GuardedBy("gpuInfoLock")
    private static zzud zzb;
    private final zzwk zzc = zzwv.zzb("acceleration");
    private final zzua zzd;
    private final zzup zze;

    private final synchronized zzur zzb() {
        zzur zzurVar;
        zzud zzudVar;
        zzurVar = new zzur();
        zzurVar.zzo(Long.valueOf(SystemClock.elapsedRealtimeNanos() / 1000));
        zzurVar.zzj(this.zzd);
        synchronized (zza) {
            if (zzb == null) {
                try {
                    zzf zza2 = zzg.zza();
                    zzub zzubVar = new zzub();
                    zzubVar.zzb(zza2.zzd());
                    zzubVar.zza(zza2.zzc());
                    zzubVar.zzc(zza2.zze());
                    zzb = zzubVar.zzd();
                } catch (zzd | RuntimeException e6) {
                    zzb = new zzub().zzd();
                    zzc("MlKitAccLogger", "Failed to get GpuInfo", e6);
                    int zza3 = e6 instanceof zzd ? ((zzd) e6).zza() : -1;
                    zzur zzb2 = zzb();
                    zzb2.zzh(zzuq.CANNOT_GET_SYSTEM_INFO);
                    zzue zzueVar = new zzue();
                    zzueVar.zzb(zzuf.OPEN_GL);
                    zzueVar.zza(Integer.valueOf(zza3));
                    zzb2.zzi(zzbd.zzh(zzueVar.zzd()));
                    zzd(null, zzbd.zzh(zzb2.zzr()));
                }
            }
            zzudVar = zzb;
        }
        zzurVar.zzl(zzudVar);
        zzurVar.zzm(this.zze);
        return zzurVar;
    }

    private zzvi(PipelineId pipelineId, com.google.mlkit.vision.pose.internal.zza zzaVar) {
        zzty zztyVar = new zzty();
        zztyVar.zzh(Integer.valueOf(Build.VERSION.SDK_INT));
        zztyVar.zzf(Build.ID);
        zztyVar.zza(Build.BRAND);
        zztyVar.zzb(Build.DEVICE);
        zztyVar.zzc(Build.HARDWARE);
        zztyVar.zzd(Build.MANUFACTURER);
        zztyVar.zze(Build.MODEL);
        zztyVar.zzg(Build.PRODUCT);
        this.zzd = zztyVar.zzi();
        zzun zzunVar = new zzun();
        zzunVar.zzd(pipelineId.getNamespace());
        zzunVar.zzc(pipelineId.getName());
        zzunVar.zza(pipelineId.getClientLibraryName());
        zzunVar.zzb(pipelineId.getClientLibraryVersion());
        this.zze = zzunVar.zze();
    }

    public static zzvi zza(PipelineId pipelineId, com.google.mlkit.vision.pose.internal.zza zzaVar) {
        return new zzvi(pipelineId, zzaVar);
    }

    private static void zzc(String str, String str2, @Nullable Throwable th) {
        Log.isLoggable("MlKitAccLogger", 3);
    }

    private final void zzd(@Nullable AcceleratableDetectorOptions acceleratableDetectorOptions, zzbd zzbdVar) {
        zzpq zzpqVar = new zzpq();
        if (acceleratableDetectorOptions != null) {
            zzsb zzsbVar = new zzsb();
            zzsbVar.zzc(((PoseDetectorOptionsBase) acceleratableDetectorOptions).zzb());
            zzpqVar.zzh(zzsbVar.zzi());
        }
        zzpqVar.zzi(zzbdVar);
        this.zzc.zzd(zzwn.zzf(zzpqVar), zzpp.PIPELINE_ACCELERATION_ANALYTICS);
    }

    @Override // com.google.mlkit.acceleration.internal.AccelerationLogger
    public final void logAccelerationInfraError(AccelerationInfraException accelerationInfraException) {
        zzc("MlKitAccLogger", "logAccelerationInfraError", accelerationInfraException);
        if (accelerationInfraException.getErrorType() == 1) {
            zzur zzb2 = zzb();
            zzb2.zzh(zzuq.CANNOT_ACCESS_STORAGE);
            zzd(null, zzbd.zzh(zzb2.zzr()));
        } else if (accelerationInfraException.getErrorType() == 2) {
            zzur zzb3 = zzb();
            zzb3.zzh(zzuq.CANNOT_GET_SYSTEM_INFO);
            zzue zzueVar = new zzue();
            zzueVar.zzb(zzuf.OPEN_GL);
            zzueVar.zza(Integer.valueOf(accelerationInfraException.getErrorCode()));
            zzb3.zzi(zzbd.zzh(zzueVar.zzd()));
            zzd(null, zzbd.zzh(zzb3.zzr()));
        }
    }

    @Override // com.google.mlkit.acceleration.internal.AccelerationLogger
    public final void logBenchmarkPipelineError(AcceleratableDetectorOptions acceleratableDetectorOptions, @Nullable Throwable th) {
        int i6;
        zzc("MlKitAccLogger", "logBenchmarkPipelineError for options: ".concat(String.valueOf(acceleratableDetectorOptions)), th);
        String str = (String) Preconditions.checkNotNull(acceleratableDetectorOptions.getRunConfigName());
        while (true) {
            if (th != null) {
                if (th instanceof MlKitException) {
                    i6 = ((MlKitException) th).getErrorCode();
                    break;
                } else {
                    if (th instanceof TimeoutException) {
                        i6 = -2;
                        break;
                    }
                    th = th.getCause();
                }
            } else {
                i6 = -1;
                break;
            }
        }
        zzur zzb2 = zzb();
        zzuk zzukVar = new zzuk();
        zzukVar.zza(str);
        zzb2.zzg(zzukVar.zzb());
        zzb2.zzh(zzuq.PIPELINE_ERROR);
        zzue zzueVar = new zzue();
        zzueVar.zzb(zzuf.MLKIT);
        zzueVar.zza(Integer.valueOf(i6));
        zzb2.zzi(zzbd.zzh(zzueVar.zzd()));
        zzd(acceleratableDetectorOptions, zzbd.zzh(zzb2.zzr()));
    }

    @Override // com.google.mlkit.acceleration.internal.AccelerationLogger
    public final void logBenchmarkResult(AcceleratableDetectorOptions acceleratableDetectorOptions, MiniBenchmarkResult miniBenchmarkResult) {
        zzc("MlKitAccLogger", "logBenchmarkResult for options: " + String.valueOf(acceleratableDetectorOptions) + ". Result=" + String.valueOf(miniBenchmarkResult), null);
        String str = (String) Preconditions.checkNotNull(acceleratableDetectorOptions.getRunConfigName());
        int stabilityStatus = miniBenchmarkResult.getStabilityStatus();
        if (stabilityStatus == 0) {
            return;
        }
        zzur zzb2 = zzb();
        zzuk zzukVar = new zzuk();
        zzukVar.zza(str);
        zzb2.zzg(zzukVar.zzb());
        if (stabilityStatus == 1) {
            zzb2.zzn(zzus.COMPLETED_EVENT);
            zzb2.zzh(zzuq.SUCCESS);
            zzva zzvaVar = new zzva();
            zzvb zzvbVar = new zzvb();
            zzuw zzuwVar = new zzuw();
            zzuwVar.zza(zzux.MEAN_ABSOLUTE_ERROR);
            zzuwVar.zzb(Float.valueOf(miniBenchmarkResult.getCorrectnessScore()));
            zzvbVar.zzb(zzbd.zzh(zzuwVar.zzd()));
            zzvaVar.zzb(zzbd.zzh(zzvbVar.zzc()));
            zzb2.zzp(zzvaVar.zzc());
            zzb2.zzk(Integer.valueOf(miniBenchmarkResult.getRunLatencyMs() * 1000));
        } else if (stabilityStatus == 2) {
            zzb2.zzn(zzus.MISSING_END_EVENT);
        }
        zzd(acceleratableDetectorOptions, zzbd.zzh(zzb2.zzr()));
    }
}
