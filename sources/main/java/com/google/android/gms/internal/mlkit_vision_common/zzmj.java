package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzmj {

    @Nullable
    private static zzp zza;
    private static final zzr zzb = zzr.zzc("optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID);
    private final String zzc;
    private final String zzd;
    private final zzmc zze;
    private final SharedPrefManager zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    @NonNull
    private static synchronized zzp zzd() {
        synchronized (zzmj.class) {
            try {
                zzp zzpVar = zza;
                if (zzpVar != null) {
                    return zzpVar;
                }
                LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
                zzm zzmVar = new zzm();
                for (int i6 = 0; i6 < locales.size(); i6++) {
                    zzmVar.zzb(CommonUtils.languageTagFromLocale(locales.get(i6)));
                }
                zzp zzc = zzmVar.zzc();
                zza = zzc;
                return zzc;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public zzmj(Context context, final SharedPrefManager sharedPrefManager, zzmc zzmcVar, String str) {
        int i6;
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzmcVar;
        zzmw.zza();
        this.zzi = str;
        this.zzg = MLTaskExecutor.getInstance().scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_common.zzmg
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzmj.this.zza();
            }
        });
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzh = mLTaskExecutor.scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_common.zzmh
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SharedPrefManager.this.getMlSdkInstanceId();
            }
        });
        zzr zzrVar = zzb;
        if (zzrVar.containsKey(str)) {
            i6 = DynamiteModule.getRemoteVersion(context, (String) zzrVar.get(str));
        } else {
            i6 = -1;
        }
        this.zzj = i6;
    }

    final /* synthetic */ String zza() throws Exception {
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    final /* synthetic */ void zzb(zzmb zzmbVar, zziv zzivVar, String str) {
        String mlSdkInstanceId;
        zzmbVar.zza(zzivVar);
        String zzc = zzmbVar.zzc();
        zzky zzkyVar = new zzky();
        zzkyVar.zzb(this.zzc);
        zzkyVar.zzc(this.zzd);
        zzkyVar.zzh(zzd());
        zzkyVar.zzg(Boolean.TRUE);
        zzkyVar.zzl(zzc);
        zzkyVar.zzj(str);
        if (this.zzh.isSuccessful()) {
            mlSdkInstanceId = (String) this.zzh.getResult();
        } else {
            mlSdkInstanceId = this.zzf.getMlSdkInstanceId();
        }
        zzkyVar.zzi(mlSdkInstanceId);
        zzkyVar.zzd(10);
        zzkyVar.zzk(Integer.valueOf(this.zzj));
        zzmbVar.zzb(zzkyVar);
        this.zze.zza(zzmbVar);
    }

    @WorkerThread
    public final void zzc(zzmt zzmtVar, final zziv zzivVar) {
        zzii zziiVar;
        zzio zzioVar;
        final String version;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzk.get(zzivVar) != null && elapsedRealtime - ((Long) this.zzk.get(zzivVar)).longValue() <= TimeUnit.SECONDS.toMillis(30L)) {
            return;
        }
        this.zzk.put(zzivVar, Long.valueOf(elapsedRealtime));
        int i6 = zzmtVar.zza;
        int i7 = zzmtVar.zzb;
        int i8 = zzmtVar.zzc;
        int i9 = zzmtVar.zzd;
        int i10 = zzmtVar.zze;
        long j6 = zzmtVar.zzf;
        int i11 = zzmtVar.zzg;
        zzin zzinVar = new zzin();
        if (i6 != -1) {
            if (i6 != 35) {
                if (i6 != 842094169) {
                    if (i6 != 16) {
                        if (i6 != 17) {
                            zziiVar = zzii.UNKNOWN_FORMAT;
                        } else {
                            zziiVar = zzii.NV21;
                        }
                    } else {
                        zziiVar = zzii.NV16;
                    }
                } else {
                    zziiVar = zzii.YV12;
                }
            } else {
                zziiVar = zzii.YUV_420_888;
            }
        } else {
            zziiVar = zzii.BITMAP;
        }
        zzinVar.zzd(zziiVar);
        if (i7 != 1) {
            if (i7 != 2) {
                if (i7 != 3) {
                    if (i7 != 4) {
                        zzioVar = zzio.ANDROID_MEDIA_IMAGE;
                    } else {
                        zzioVar = zzio.FILEPATH;
                    }
                } else {
                    zzioVar = zzio.BYTEBUFFER;
                }
            } else {
                zzioVar = zzio.BYTEARRAY;
            }
        } else {
            zzioVar = zzio.BITMAP;
        }
        zzinVar.zzf(zzioVar);
        zzinVar.zzc(Integer.valueOf(i8));
        zzinVar.zze(Integer.valueOf(i9));
        zzinVar.zzg(Integer.valueOf(i10));
        zzinVar.zzb(Long.valueOf(j6));
        zzinVar.zzh(Integer.valueOf(i11));
        zziq zzj = zzinVar.zzj();
        zziw zziwVar = new zziw();
        zziwVar.zzd(zzj);
        final zzmb zze = zzmk.zze(zziwVar);
        if (this.zzg.isSuccessful()) {
            version = (String) this.zzg.getResult();
        } else {
            version = LibraryVersion.getInstance().getVersion(this.zzi);
        }
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_common.zzmi
            @Override // java.lang.Runnable
            public final void run() {
                zzmj.this.zzb(zze, zzivVar, version);
            }
        });
    }
}
