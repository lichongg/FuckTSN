package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzsh {

    @Nullable
    private static zzaf zza;
    private static final zzai zzb = zzai.zzc("optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID);
    private final String zzc;
    private final String zzd;
    private final zzrz zze;
    private final SharedPrefManager zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;

    @NonNull
    private static synchronized zzaf zzh() {
        synchronized (zzsh.class) {
            try {
                zzaf zzafVar = zza;
                if (zzafVar != null) {
                    return zzafVar;
                }
                LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
                zzac zzacVar = new zzac();
                for (int i6 = 0; i6 < locales.size(); i6++) {
                    zzacVar.zzb(CommonUtils.languageTagFromLocale(locales.get(i6)));
                }
                zzaf zzc = zzacVar.zzc();
                zza = zzc;
                return zzc;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final zzqt zzi(String str, String str2) {
        zzqt zzqtVar = new zzqt();
        zzqtVar.zzb(this.zzc);
        zzqtVar.zzc(this.zzd);
        zzqtVar.zzh(zzh());
        zzqtVar.zzg(Boolean.TRUE);
        zzqtVar.zzl(str);
        zzqtVar.zzj(str2);
        zzqtVar.zzi(this.zzh.isSuccessful() ? (String) this.zzh.getResult() : this.zzf.getMlSdkInstanceId());
        zzqtVar.zzd(10);
        zzqtVar.zzk(Integer.valueOf(this.zzj));
        return zzqtVar;
    }

    @WorkerThread
    private final String zzj() {
        if (this.zzg.isSuccessful()) {
            return (String) this.zzg.getResult();
        }
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    final /* synthetic */ void zzc(zzry zzryVar, zzsj zzsjVar, RemoteModel remoteModel) {
        zzryVar.zza(zzmv.MODEL_DOWNLOAD);
        zzryVar.zzc(zzi(zzsjVar.zze(), zzj()));
        zzryVar.zzb(zzst.zza(remoteModel, this.zzf, zzsjVar));
        this.zze.zza(zzryVar);
    }

    public zzsh(Context context, final SharedPrefManager sharedPrefManager, zzrz zzrzVar, String str) {
        int i6;
        new HashMap();
        new HashMap();
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzrzVar;
        zzsv.zza();
        this.zzi = str;
        this.zzg = MLTaskExecutor.getInstance().scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzse
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzsh.this.zza();
            }
        });
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        Objects.requireNonNull(sharedPrefManager);
        this.zzh = mLTaskExecutor.scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzsf
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SharedPrefManager.this.getMlSdkInstanceId();
            }
        });
        zzai zzaiVar = zzb;
        if (zzaiVar.containsKey(str)) {
            i6 = DynamiteModule.getRemoteVersion(context, (String) zzaiVar.get(str));
        } else {
            i6 = -1;
        }
        this.zzj = i6;
    }

    final /* synthetic */ String zza() throws Exception {
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    final /* synthetic */ void zzb(zzry zzryVar, zzmv zzmvVar, String str) {
        zzryVar.zza(zzmvVar);
        zzryVar.zzc(zzi(zzryVar.zzd(), str));
        this.zze.zza(zzryVar);
    }

    public final void zzd(final zzry zzryVar, final zzmv zzmvVar) {
        final String zzj = zzj();
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_common.zzsd
            @Override // java.lang.Runnable
            public final void run() {
                zzsh.this.zzb(zzryVar, zzmvVar, zzj);
            }
        });
    }

    public final void zze(zzry zzryVar, RemoteModel remoteModel, boolean z5, int i6) {
        zzsi zzh = zzsj.zzh();
        zzh.zzf(false);
        zzh.zzd(remoteModel.getModelType());
        zzh.zza(zzna.FAILED);
        zzh.zzb(zzmu.DOWNLOAD_FAILED);
        zzh.zzc(i6);
        zzg(zzryVar, remoteModel, zzh.zzh());
    }

    public final void zzf(zzry zzryVar, RemoteModel remoteModel, zzmu zzmuVar, boolean z5, ModelType modelType, zzna zznaVar) {
        zzsi zzh = zzsj.zzh();
        zzh.zzf(z5);
        zzh.zzd(modelType);
        zzh.zzb(zzmuVar);
        zzh.zza(zznaVar);
        zzg(zzryVar, remoteModel, zzh.zzh());
    }

    public final void zzg(final zzry zzryVar, final RemoteModel remoteModel, final zzsj zzsjVar) {
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_common.zzsg
            @Override // java.lang.Runnable
            public final void run() {
                zzsh.this.zzc(zzryVar, zzsjVar, remoteModel);
            }
        });
    }
}
