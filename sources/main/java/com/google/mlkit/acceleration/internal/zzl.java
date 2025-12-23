package com.google.mlkit.acceleration.internal;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.multiprocess.RemoteListenableWorker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzl {
    private final Context zza;
    private final PipelineId zzb;
    private final zzm zzc;
    private final WorkManager zzd;
    private final Class zze;
    private final float zzf;
    private final AccelerationLogger zzg;
    private final Executor zzh;
    private final boolean zzi;
    private final int zzj;

    zzl(Context context, PipelineId pipelineId, MiniBenchmarkConfig miniBenchmarkConfig, AccelerationLogger accelerationLogger) {
        zzm zzmVar = new zzm(context, pipelineId, accelerationLogger);
        WorkManager workManager = WorkManager.getInstance(context);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.zza = context;
        this.zzb = pipelineId;
        this.zzc = zzmVar;
        this.zze = miniBenchmarkConfig.getWorkerClass();
        this.zzf = miniBenchmarkConfig.getCorrectnessScoreThreshold();
        this.zzi = miniBenchmarkConfig.requireDeviceIdle();
        this.zzj = miniBenchmarkConfig.getMaxRetryCount();
        this.zzg = accelerationLogger;
        this.zzd = workManager;
        this.zzh = newSingleThreadExecutor;
    }

    private static void zzf(String str, String str2) {
        Log.isLoggable("MiniBenchmarkManager", 3);
    }

    final /* synthetic */ void zzb(List list) {
        zze(list, this.zzj);
    }

    final /* synthetic */ void zzc(int i6, List list) {
        this.zzc.zze();
        if (i6 > 0) {
            zzf("MiniBenchmarkManager", "Rerun FAILED mini-benchmark. Remaining retry = " + i6);
            zze(list, i6 + (-1));
        }
    }

    final /* synthetic */ void zzd(List list, final int i6, final List list2, WorkInfo workInfo) {
        if (workInfo == null) {
            zzf("MiniBenchmarkManager", "workInfo is null");
            return;
        }
        zzf("MiniBenchmarkManager", "workInfo for " + list.toString() + ": " + String.valueOf(workInfo.getState()));
        if (workInfo.getState() == WorkInfo.State.FAILED) {
            this.zzh.execute(new Runnable() { // from class: com.google.mlkit.acceleration.internal.zzg
                @Override // java.lang.Runnable
                public final void run() {
                    zzl.this.zzc(i6, list2);
                }
            });
        }
    }

    final List zza(final List list) {
        boolean z5;
        MiniBenchmarkResult zzc;
        if (list.isEmpty()) {
            return list;
        }
        this.zzh.execute(new Runnable() { // from class: com.google.mlkit.acceleration.internal.zzh
            @Override // java.lang.Runnable
            public final void run() {
                zzl.this.zzb(list);
            }
        });
        List<RunConfig> zzb = this.zzc.zzb(list);
        for (RunConfig runConfig : zzb) {
            MiniBenchmarkResult zzc2 = runConfig.zzc();
            if (zzc2 != null && !zzc2.zza() && zzc2.getStabilityStatus() != 0) {
                this.zzg.logBenchmarkResult(runConfig.zzb(), zzc2);
            }
        }
        this.zzc.zzd(zzb);
        Iterator it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (((RunConfig) it.next()).zzf()) {
                    z5 = true;
                    break;
                }
            } else {
                z5 = false;
                break;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (RunConfig runConfig2 : zzb) {
            zzf("MiniBenchmarkManager", "Check isApplicableRunConfig: ".concat(String.valueOf(runConfig2)));
            if (!runConfig2.zzg() || ((zzc = runConfig2.zzc()) != null && zzc.getStabilityStatus() == 1 && zzc.getCorrectnessScore() >= this.zzf && ((!z5 && zzc.getRunLatencyMs() < 100) || zzc.getRunLatencyMs() < 40))) {
                arrayList.add(runConfig2);
            }
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.google.mlkit.acceleration.internal.zzi
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                MiniBenchmarkResult zzc3 = ((RunConfig) obj).zzc();
                MiniBenchmarkResult zzc4 = ((RunConfig) obj2).zzc();
                if (zzc3 == null) {
                    return 1;
                }
                if (zzc4 == null) {
                    return -1;
                }
                return zzc3.getRunLatencyMs() - zzc4.getRunLatencyMs();
            }
        });
        return arrayList;
    }

    @VisibleForTesting
    final void zze(final List list, final int i6) {
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                RunConfig runConfig = (RunConfig) it.next();
                if (runConfig.zzg()) {
                    arrayList.add(runConfig.zze());
                }
            }
            AcceleratableDetectorOptions zza = ((RunConfig) list.get(0)).zza();
            final List zza2 = this.zzc.zza(zza, arrayList);
            zzf("MiniBenchmarkManager", "Get " + zza2.size() + " run configs needing mini-benchmark");
            if (!zza2.isEmpty()) {
                ComponentName componentName = new ComponentName(this.zza.getPackageName(), MlKitRemoteWorkerService.class.getName());
                String encode = zza.encode();
                OneTimeWorkRequest.Builder inputData = new OneTimeWorkRequest.Builder(this.zze).setInputData(new Data.Builder().putString(RemoteListenableWorker.ARGUMENT_PACKAGE_NAME, componentName.getPackageName()).putString(RemoteListenableWorker.ARGUMENT_CLASS_NAME, componentName.getClassName()).putString("mlkit_base_options_key", encode).putStringArray("mlkit_run_config_name_array_key", (String[]) zza2.toArray(new String[0])).build());
                if (Build.VERSION.SDK_INT >= 23) {
                    inputData.setConstraints(new Constraints.Builder().setRequiresDeviceIdle(this.zzi).build());
                }
                OneTimeWorkRequest build = inputData.build();
                String str = String.valueOf(this.zzb) + ":" + encode;
                this.zzd.beginUniqueWork(str, ExistingWorkPolicy.KEEP, build).enqueue();
                zzf("MiniBenchmarkManager", "mini-benchmark scheduled for ".concat(zza2.toString()));
                zzf("MiniBenchmarkManager", "uniqueWorkName: ".concat(str));
                final LiveData<WorkInfo> workInfoByIdLiveData = this.zzd.getWorkInfoByIdLiveData(build.getId());
                new com.google.android.gms.internal.mlkit_acceleration.zza(this.zza.getMainLooper()).post(new Runnable() { // from class: com.google.mlkit.acceleration.internal.zzj
                    @Override // java.lang.Runnable
                    public final void run() {
                        LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.get();
                        final zzl zzlVar = zzl.this;
                        final List list2 = zza2;
                        final int i7 = i6;
                        final List list3 = list;
                        workInfoByIdLiveData.observe(lifecycleOwner, new Observer() { // from class: com.google.mlkit.acceleration.internal.zzk
                            @Override // androidx.lifecycle.Observer
                            public final void onChanged(Object obj) {
                                zzl.this.zzd(list2, i7, list3, (WorkInfo) obj);
                            }
                        });
                    }
                });
            }
        }
    }
}
