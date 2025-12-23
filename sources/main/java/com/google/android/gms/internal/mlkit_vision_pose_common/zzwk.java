package com.google.android.gms.internal.mlkit_vision_pose_common;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzwk {

    @Nullable
    private static zzbd zza;
    private static final zzbg zzb = zzbg.zzd("optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID);
    private final String zzc;
    private final String zzd;
    private final zzwb zze;
    private final SharedPrefManager zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    @NonNull
    private static synchronized zzbd zzj() {
        synchronized (zzwk.class) {
            try {
                zzbd zzbdVar = zza;
                if (zzbdVar != null) {
                    return zzbdVar;
                }
                LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
                zzba zzbaVar = new zzba();
                for (int i6 = 0; i6 < locales.size(); i6++) {
                    zzbaVar.zzb(CommonUtils.languageTagFromLocale(locales.get(i6)));
                }
                zzbd zzc = zzbaVar.zzc();
                zza = zzc;
                return zzc;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @WorkerThread
    private final String zzk() {
        if (this.zzg.isSuccessful()) {
            return (String) this.zzg.getResult();
        }
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    @WorkerThread
    private final boolean zzl(zzpp zzppVar, long j6, long j7) {
        return this.zzk.get(zzppVar) == null || j6 - ((Long) this.zzk.get(zzppVar)).longValue() > TimeUnit.SECONDS.toMillis(30L);
    }

    final /* synthetic */ void zzf(zzpp zzppVar, com.google.mlkit.vision.pose.internal.zzg zzgVar) {
        zzbj zzbjVar = (zzbj) this.zzl.get(zzppVar);
        if (zzbjVar != null) {
            for (Object obj : zzbjVar.zzo()) {
                ArrayList arrayList = new ArrayList(zzbjVar.zzc(obj));
                Collections.sort(arrayList);
                zzoo zzooVar = new zzoo();
                Iterator it = arrayList.iterator();
                long j6 = 0;
                while (it.hasNext()) {
                    j6 += ((Long) it.next()).longValue();
                }
                zzooVar.zza(Long.valueOf(j6 / arrayList.size()));
                zzooVar.zzc(Long.valueOf(zza(arrayList, 100.0d)));
                zzooVar.zzf(Long.valueOf(zza(arrayList, 75.0d)));
                zzooVar.zzd(Long.valueOf(zza(arrayList, 50.0d)));
                zzooVar.zzb(Long.valueOf(zza(arrayList, 25.0d)));
                zzooVar.zze(Long.valueOf(zza(arrayList, 0.0d)));
                zzoq zzg = zzooVar.zzg();
                int size = arrayList.size();
                zzpq zzpqVar = new zzpq();
                zzpqVar.zzf(zzpn.TYPE_THICK);
                zzez zzezVar = new zzez();
                zzezVar.zza(Integer.valueOf(size));
                zzezVar.zzc((zzfc) obj);
                zzezVar.zzb(zzg);
                zzpqVar.zze(zzezVar.zze());
                zze(zzwn.zzf(zzpqVar), zzppVar, zzk());
            }
            this.zzl.remove(zzppVar);
        }
    }

    final /* synthetic */ void zzg(zzpp zzppVar, Object obj, long j6, com.google.mlkit.vision.pose.internal.zzg zzgVar) {
        if (!this.zzl.containsKey(zzppVar)) {
            this.zzl.put(zzppVar, zzah.zzp());
        }
        ((zzbj) this.zzl.get(zzppVar)).zzm(obj, Long.valueOf(j6));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzl(zzppVar, elapsedRealtime, 30L)) {
            this.zzk.put(zzppVar, Long.valueOf(elapsedRealtime));
            zzi(zzppVar, zzgVar);
        }
    }

    public zzwk(Context context, final SharedPrefManager sharedPrefManager, zzwb zzwbVar, String str) {
        int i6;
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzwbVar;
        zzxq.zza();
        this.zzi = str;
        this.zzg = MLTaskExecutor.getInstance().scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_pose_common.zzwh
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzwk.this.zzb();
            }
        });
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        Objects.requireNonNull(sharedPrefManager);
        this.zzh = mLTaskExecutor.scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_pose_common.zzwi
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SharedPrefManager.this.getMlSdkInstanceId();
            }
        });
        zzbg zzbgVar = zzb;
        if (zzbgVar.containsKey(str)) {
            i6 = DynamiteModule.getRemoteVersion(context, (String) zzbgVar.get(str));
        } else {
            i6 = -1;
        }
        this.zzj = i6;
    }

    @VisibleForTesting
    static long zza(List list, double d6) {
        return ((Long) list.get(Math.max(((int) Math.ceil((d6 / 100.0d) * list.size())) - 1, 0))).longValue();
    }

    final /* synthetic */ String zzb() throws Exception {
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    final /* synthetic */ void zzc(zzwa zzwaVar, zzpp zzppVar, String str) {
        String mlSdkInstanceId;
        zzwaVar.zzb(zzppVar);
        String zzd = zzwaVar.zzd();
        zztp zztpVar = new zztp();
        zztpVar.zzb(this.zzc);
        zztpVar.zzc(this.zzd);
        zztpVar.zzh(zzj());
        zztpVar.zzg(Boolean.TRUE);
        zztpVar.zzl(zzd);
        zztpVar.zzj(str);
        if (this.zzh.isSuccessful()) {
            mlSdkInstanceId = (String) this.zzh.getResult();
        } else {
            mlSdkInstanceId = this.zzf.getMlSdkInstanceId();
        }
        zztpVar.zzi(mlSdkInstanceId);
        zztpVar.zzd(10);
        zztpVar.zzk(Integer.valueOf(this.zzj));
        zzwaVar.zzc(zztpVar);
        this.zze.zza(zzwaVar);
    }

    public final void zzd(zzwa zzwaVar, zzpp zzppVar) {
        zze(zzwaVar, zzppVar, zzk());
    }

    public final void zze(final zzwa zzwaVar, final zzpp zzppVar, final String str) {
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_pose_common.zzwf
            @Override // java.lang.Runnable
            public final void run() {
                zzwk.this.zzc(zzwaVar, zzppVar, str);
            }
        });
    }

    @WorkerThread
    public final void zzh(com.google.mlkit.vision.pose.internal.zzf zzfVar, zzpp zzppVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!zzl(zzppVar, elapsedRealtime, 30L)) {
            return;
        }
        this.zzk.put(zzppVar, Long.valueOf(elapsedRealtime));
        zze(zzfVar.zza(), zzppVar, zzk());
    }

    public final void zzi(final zzpp zzppVar, final com.google.mlkit.vision.pose.internal.zzg zzgVar) {
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_pose_common.zzwg
            @Override // java.lang.Runnable
            public final void run() {
                zzwk.this.zzf(zzppVar, zzgVar);
            }
        });
    }
}
