package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.errorprone.annotations.CheckReturnValue;
import com.stub.StubApp;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@CheckReturnValue
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzn {
    private static volatile zzag zze;
    private static Context zzg;
    static final zzl zza = new zzf(zzj.zze("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
    static final zzl zzb = new zzg(zzj.zze("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
    static final zzl zzc = new zzh(zzj.zze("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
    static final zzl zzd = new zzi(zzj.zze("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
    private static final Object zzf = new Object();

    static zzx zzb(String str, boolean z5, boolean z6, boolean z7) {
        return zzi(str, z5, false, false, true);
    }

    static zzx zzc(String str, boolean z5, boolean z6, boolean z7) {
        return zzi(str, z5, false, false, false);
    }

    static /* synthetic */ String zzd(boolean z5, String str, zzj zzjVar) throws Exception {
        String str2 = (z5 || !zzh(str, zzjVar, true, false).zza) ? "not allowed" : "debug cert rejected";
        MessageDigest zza2 = AndroidUtilsLight.zza("SHA-256");
        Preconditions.checkNotNull(zza2);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, Hex.bytesToStringLowercase(zza2.digest(zzjVar.zzf())), Boolean.valueOf(z5), "12451000.false");
    }

    static synchronized void zze(Context context) {
        synchronized (zzn.class) {
            if (zzg == null) {
                if (context != null) {
                    zzg = StubApp.getOrigApplicationContext(context.getApplicationContext());
                }
            }
        }
    }

    private static void zzj() throws DynamiteModule.LoadingException {
        if (zze != null) {
            return;
        }
        Preconditions.checkNotNull(zzg);
        synchronized (zzf) {
            try {
                if (zze == null) {
                    zze = zzaf.zzb(DynamiteModule.load(zzg, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static zzx zza(String str, zzj zzjVar, boolean z5, boolean z6) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return zzh(str, zzjVar, z5, z6);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    static boolean zzf() {
        boolean z5;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            zzj();
            z5 = zze.zzg();
        } catch (RemoteException | DynamiteModule.LoadingException unused) {
            z5 = false;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return z5;
    }

    static boolean zzg() {
        boolean z5;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            zzj();
            z5 = zze.zzi();
        } catch (RemoteException | DynamiteModule.LoadingException unused) {
            z5 = false;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return z5;
    }

    private static zzx zzh(final String str, final zzj zzjVar, final boolean z5, boolean z6) {
        try {
            zzj();
            Preconditions.checkNotNull(zzg);
            try {
                if (zze.zzh(new zzs(str, zzjVar, z5, z6), ObjectWrapper.wrap(zzg.getPackageManager()))) {
                    return zzx.zzb();
                }
                return new zzv(new Callable() { // from class: com.google.android.gms.common.zze
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzn.zzd(z5, str, zzjVar);
                    }
                }, null);
            } catch (RemoteException e6) {
                return zzx.zzd("module call", e6);
            }
        } catch (DynamiteModule.LoadingException e7) {
            return zzx.zzd("module init: ".concat(String.valueOf(e7.getMessage())), e7);
        }
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [android.os.IBinder, com.google.android.gms.dynamic.IObjectWrapper] */
    private static zzx zzi(String str, boolean z5, boolean z6, boolean z7, boolean z8) {
        zzx zzd2;
        zzq zzf2;
        PackageManager.NameNotFoundException nameNotFoundException;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.checkNotNull(zzg);
            try {
                zzj();
                zzo zzoVar = new zzo(str, z5, false, ObjectWrapper.wrap(zzg), false, true);
                try {
                    if (z8) {
                        zzf2 = zze.zze(zzoVar);
                    } else {
                        zzf2 = zze.zzf(zzoVar);
                    }
                    if (zzf2.zzb()) {
                        zzd2 = zzx.zzf(zzf2.zzc());
                    } else {
                        String zza2 = zzf2.zza();
                        if (zzf2.zzd() == 4) {
                            nameNotFoundException = new PackageManager.NameNotFoundException();
                        } else {
                            nameNotFoundException = null;
                        }
                        if (zza2 == null) {
                            zza2 = "error checking package certificate";
                        }
                        zzd2 = zzx.zzg(zzf2.zzc(), zzf2.zzd(), zza2, nameNotFoundException);
                    }
                } catch (RemoteException e6) {
                    zzd2 = zzx.zzd("module call", e6);
                }
            } catch (DynamiteModule.LoadingException e7) {
                zzd2 = zzx.zzd("module init: ".concat(String.valueOf(e7.getMessage())), e7);
            }
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return zzd2;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }
}
