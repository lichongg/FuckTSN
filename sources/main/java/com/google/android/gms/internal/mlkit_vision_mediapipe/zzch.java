package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzch {
    private static String zza = "com.google.android.gms.internal.mlkit_vision_mediapipe.zzcn";
    private static String zzb = "com.google.common.flogger.backend.google.GooglePlatform";
    private static String zzc = "com.google.common.flogger.backend.system.DefaultPlatform";
    private static final String[] zzd = {"com.google.android.gms.internal.mlkit_vision_mediapipe.zzcn", "com.google.common.flogger.backend.google.GooglePlatform", "com.google.common.flogger.backend.system.DefaultPlatform"};

    protected abstract zzbd zze(String str);

    protected abstract zzcg zzh();

    protected abstract String zzm();

    protected long zzc() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }

    public static int zza() {
        return zzea.zza();
    }

    public static long zzb() {
        zzch zzchVar;
        zzchVar = zzcf.zza;
        return zzchVar.zzc();
    }

    public static zzbd zzd(String str) {
        zzch zzchVar;
        zzchVar = zzcf.zza;
        return zzchVar.zze(str);
    }

    public static zzbh zzf() {
        return zzi().zza();
    }

    public static zzcg zzg() {
        zzch zzchVar;
        zzchVar = zzcf.zza;
        return zzchVar.zzh();
    }

    public static zzcz zzi() {
        zzch zzchVar;
        zzchVar = zzcf.zza;
        return zzchVar.zzj();
    }

    public static zzdl zzk() {
        return zzi().zzc();
    }

    public static String zzl() {
        zzch zzchVar;
        zzchVar = zzcf.zza;
        return zzchVar.zzm();
    }

    public static boolean zzn(String str, Level level, boolean z5) {
        zzi().zzd(str, level, z5);
        return false;
    }

    protected zzcz zzj() {
        return zzcz.zze();
    }
}
