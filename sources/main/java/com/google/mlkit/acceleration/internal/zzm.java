package com.google.mlkit.acceleration.internal;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.mlkit_acceleration.zzdi;
import com.google.android.gms.internal.mlkit_acceleration.zzed;
import com.google.mlkit.acceleration.internal.RunConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzm {
    private static final Object zza = new Object();

    @GuardedBy("gpuVersionLock")
    private static String zzb;
    private final PipelineId zzc;
    private final AccelerationLogger zzd;
    private final zzf zze;

    @VisibleForTesting
    static final String zzg() throws AccelerationInfraException {
        String str;
        synchronized (zza) {
            if (zzb == null) {
                try {
                    com.google.android.gms.internal.mlkit_acceleration.zzg zza2 = com.google.android.gms.internal.mlkit_acceleration.zzh.zza();
                    zzb = zza2.zzd() + ";" + zza2.zzc() + ";" + zza2.zze();
                } catch (com.google.android.gms.internal.mlkit_acceleration.zze | RuntimeException e6) {
                    zzb = "";
                    throw AccelerationInfraException.zza(e6);
                }
            }
            str = zzb;
        }
        return str;
    }

    @Nullable
    private final zzt zzi() {
        File zza2 = this.zze.zza();
        if (zza2 == null) {
            this.zzd.logAccelerationInfraError(new AccelerationInfraException(1, null));
            return null;
        }
        zzl("MiniBenchPersistence", "Reading benchmark result from file: ".concat(zza2.toString()));
        if (!zza2.exists()) {
            zzl("MiniBenchPersistence", "Results file hasn't been created");
            return zzt.zzd();
        }
        byte[] zze = this.zze.zze();
        if (zze == null) {
            return null;
        }
        try {
            zzt zze2 = zzt.zze(zze, zzdi.zza());
            try {
                if (this.zzc.getClientLibraryName().equals(zze2.zzf()) && this.zzc.getClientLibraryVersion().equals(zze2.zzg()) && Build.VERSION.SDK_INT == zze2.zza() && Build.HARDWARE.equals(zze2.zzh()) && Build.FINGERPRINT.equals(zze2.zzj())) {
                    if (zzg().equals(zze2.zzi())) {
                        zzl("MiniBenchPersistence", "Succeeded reading valid benchmark results from file: ".concat(zza2.toString()));
                        return zze2;
                    }
                }
            } catch (AccelerationInfraException e6) {
                this.zzd.logAccelerationInfraError(e6);
            }
            zzl("MiniBenchPersistence", "Existing results are not valid any more");
            return zzt.zzd();
        } catch (zzed unused) {
            "Failed to parse proto from file: ".concat(zza2.toString());
            return zzt.zzd();
        }
    }

    private static String zzk(String str, String str2) {
        return str + "_" + str2;
    }

    private static void zzl(String str, String str2) {
        Log.isLoggable("MiniBenchPersistence", 3);
    }

    private static final Map zzn(zzt zztVar) {
        HashMap hashMap = new HashMap();
        for (zzq zzqVar : zztVar.zzk()) {
            if (zzqVar.zzc() != 0) {
                zzb zzbVar = new zzb();
                zzbVar.zzb(zzqVar.zzn());
                zzbVar.zzd(zzqVar.zzc());
                zzbVar.zza(zzqVar.zza());
                zzbVar.zzc(zzqVar.zzb());
                hashMap.put(zzj(zzqVar), zzbVar.zze());
            }
        }
        zzl("MiniBenchPersistence", "getResultIdToCompletedResultMap: ".concat(hashMap.toString()));
        return hashMap;
    }

    final List zza(AcceleratableDetectorOptions acceleratableDetectorOptions, List list) {
        zzl("MiniBenchPersistence", "getRunConfigsNeedingMiniBenchmark");
        zzt zzi = zzi();
        if (zzi == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Map zzn = zzn(zzi);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!zzn.containsKey(zzk(str, ((AcceleratableDetectorOptions) acceleratableDetectorOptions.cloneWithRunConfigAssigned(str, true)).encode()))) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    final List zzb(List list) {
        zzl("MiniBenchPersistence", "readMiniBenchmarkResults");
        ArrayList arrayList = new ArrayList();
        zzt zzi = zzi();
        if (zzi == null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((RunConfig) it.next()).zzd().build());
            }
        } else {
            Map zzn = zzn(zzi);
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                RunConfig runConfig = (RunConfig) it2.next();
                String zzm = zzm(runConfig);
                RunConfig.Builder zzd = runConfig.zzd();
                zzd.setMiniBenchmarkResult((MiniBenchmarkResult) zzn.get(zzm));
                arrayList.add(zzd.build());
            }
        }
        return arrayList;
    }

    final void zzc() {
        zzs zzh;
        this.zze.zzb();
        try {
            zzl("MiniBenchPersistence", "clearResultsWithUnknownStability");
            zzt zzi = zzi();
            if (zzi != null && (zzh = zzh()) != null) {
                for (zzq zzqVar : zzi.zzk()) {
                    if (zzqVar.zzc() == 0) {
                        zzl("MiniBenchPersistence", "Benchmark result cleared for ".concat(String.valueOf(zzqVar.zzg())));
                    } else {
                        zzh.zzb(zzqVar);
                    }
                }
                this.zze.zzc(((zzt) zzh.zzl()).zzv());
            }
        } finally {
            this.zze.zzd();
        }
    }

    final void zzd(List list) {
        zzt zzi;
        zzs zzh;
        this.zze.zzb();
        try {
            zzl("MiniBenchPersistence", "markMiniBenchmarkResultsAsLogged");
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                RunConfig runConfig = (RunConfig) it.next();
                MiniBenchmarkResult zzc = runConfig.zzc();
                if (zzc != null && !zzc.zza()) {
                    hashSet.add(zzm(runConfig));
                }
            }
            if (!hashSet.isEmpty() && (zzi = zzi()) != null && (zzh = zzh()) != null) {
                for (zzq zzqVar : zzi.zzk()) {
                    if (hashSet.contains(zzj(zzqVar))) {
                        zzp zzpVar = (zzp) zzqVar.zzz();
                        zzpVar.zzb(true);
                        zzh.zza(zzpVar);
                    } else {
                        zzh.zzb(zzqVar);
                    }
                }
                this.zze.zzc(((zzt) zzh.zzl()).zzv());
            }
        } finally {
            this.zze.zzd();
        }
    }

    final void zze() {
        zzs zzh;
        this.zze.zzb();
        try {
            zzl("MiniBenchPersistence", "markUnknownResultsAsUnstable");
            zzt zzi = zzi();
            if (zzi != null && (zzh = zzh()) != null) {
                for (zzq zzqVar : zzi.zzk()) {
                    if (zzqVar.zzc() == 0) {
                        zzp zzpVar = (zzp) zzqVar.zzz();
                        zzpVar.zzf(2);
                        zzh.zza(zzpVar);
                        zzl("MiniBenchPersistence", "Mark UNKNOWN result as UNSTABLE: ".concat(String.valueOf(zzqVar.zzg())));
                    } else {
                        zzh.zzb(zzqVar);
                    }
                }
                this.zze.zzc(((zzt) zzh.zzl()).zzv());
            }
        } finally {
            this.zze.zzd();
        }
    }

    final void zzf(String str, AcceleratableDetectorOptions acceleratableDetectorOptions, MiniBenchmarkResult miniBenchmarkResult) {
        this.zze.zzb();
        try {
            zzl("MiniBenchPersistence", "saveMiniBenchmarkResult");
            zzt zzi = zzi();
            if (zzi != null) {
                zzp zzd = zzq.zzd();
                zzd.zzb(miniBenchmarkResult.zza());
                zzd.zzd(str);
                zzd.zzc(acceleratableDetectorOptions.encode());
                zzd.zzf(miniBenchmarkResult.getStabilityStatus());
                zzd.zza(miniBenchmarkResult.getCorrectnessScore());
                zzd.zze(miniBenchmarkResult.getRunLatencyMs());
                zzq zzqVar = (zzq) zzd.zzl();
                String zzj = zzj(zzqVar);
                zzs zzh = zzh();
                if (zzh != null) {
                    boolean z5 = false;
                    for (zzq zzqVar2 : zzi.zzk()) {
                        if (zzj.equals(zzj(zzqVar2))) {
                            zzh.zzb(zzqVar);
                            z5 = true;
                        } else {
                            zzh.zzb(zzqVar2);
                        }
                    }
                    if (!z5) {
                        zzh.zzb(zzqVar);
                    }
                    this.zze.zzc(((zzt) zzh.zzl()).zzv());
                }
            }
        } finally {
            this.zze.zzd();
        }
    }

    zzm(Context context, PipelineId pipelineId, AccelerationLogger accelerationLogger) {
        this.zzc = pipelineId;
        this.zzd = accelerationLogger;
        this.zze = new zzf(context, String.format("com.google.mlkit.MiniBenchmarkPersistence.%s.%s", pipelineId.getNamespace(), pipelineId.getName()));
    }

    @Nullable
    private final zzs zzh() {
        try {
            zzs zzb2 = zzt.zzb();
            zzb2.zzd(this.zzc.getClientLibraryName());
            zzb2.zze(this.zzc.getClientLibraryVersion());
            zzb2.zzc(Build.VERSION.SDK_INT);
            zzb2.zzf(Build.HARDWARE);
            zzb2.zzh(Build.FINGERPRINT);
            zzb2.zzg(zzg());
            return zzb2;
        } catch (AccelerationInfraException e6) {
            this.zzd.logAccelerationInfraError(e6);
            return null;
        }
    }

    private static String zzj(zzq zzqVar) {
        return zzk(zzqVar.zzg(), zzqVar.zzf());
    }

    private static final String zzm(RunConfig runConfig) {
        return zzk(runConfig.zze(), runConfig.zzb().encode());
    }
}
