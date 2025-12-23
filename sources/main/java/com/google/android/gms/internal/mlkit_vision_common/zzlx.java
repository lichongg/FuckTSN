package com.google.android.gms.internal.mlkit_vision_common;

import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.C;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class zzlx implements Closeable {
    private static final Map zza = new HashMap();
    private final String zzb;
    private int zzc;
    private double zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;

    private zzlx(String str) {
        this.zzg = 2147483647L;
        this.zzh = -2147483648L;
        this.zzb = str;
    }

    private final void zza() {
        this.zzc = 0;
        this.zzd = 0.0d;
        this.zze = 0L;
        this.zzg = 2147483647L;
        this.zzh = -2147483648L;
    }

    /* synthetic */ zzlx(String str, zzlw zzlwVar) {
        this("unusedTag");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j6 = this.zze;
        if (j6 == 0) {
            throw new IllegalStateException("Did you forget to call start()?");
        }
        zzd(j6);
    }

    public static zzlx zze(String str) {
        zzlv zzlvVar;
        zzmw.zza();
        if (!zzmw.zzb()) {
            zzlvVar = zzlv.zza;
            return zzlvVar;
        }
        Map map = zza;
        if (map.get("detectorTaskWithResource#run") == null) {
            map.put("detectorTaskWithResource#run", new zzlx("detectorTaskWithResource#run"));
        }
        return (zzlx) map.get("detectorTaskWithResource#run");
    }

    public zzlx zzb() {
        this.zze = SystemClock.elapsedRealtimeNanos() / 1000;
        return this;
    }

    public void zzc(long j6) {
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        long j7 = this.zzf;
        if (j7 != 0 && elapsedRealtimeNanos - j7 >= C.MICROS_PER_SECOND) {
            zza();
        }
        this.zzf = elapsedRealtimeNanos;
        this.zzc++;
        this.zzd += j6;
        this.zzg = Math.min(this.zzg, j6);
        this.zzh = Math.max(this.zzh, j6);
        if (this.zzc % 50 == 0) {
            String.format(Locale.US, "[%s] cur=%dus, counts=%d, min=%dus, max=%dus, avg=%dus", this.zzb, Long.valueOf(j6), Integer.valueOf(this.zzc), Long.valueOf(this.zzg), Long.valueOf(this.zzh), Integer.valueOf((int) (this.zzd / this.zzc)));
            zzmw.zza();
        }
        if (this.zzc % 500 == 0) {
            zza();
        }
    }

    public void zzd(long j6) {
        zzc((SystemClock.elapsedRealtimeNanos() / 1000) - j6);
    }
}
