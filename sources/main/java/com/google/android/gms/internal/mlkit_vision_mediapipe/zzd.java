package com.google.android.gms.internal.mlkit_vision_mediapipe;

import com.google.android.gms.internal.mlkit_vision_mediapipe.zzaf;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzd<API extends zzaf<API>> {
    private final zzbd zza;

    public abstract zzaf zza(Level level);

    private static void zzg(String str, zzbb zzbbVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(new Date(TimeUnit.NANOSECONDS.toMillis(zzbbVar.zze()))));
        sb.append(": logging error [");
        zzbc.zza(1, zzbbVar.zzf(), sb);
        sb.append("]: ");
        sb.append(str);
        System.err.getClass();
        System.err.flush();
    }

    public final zzaf zzb() {
        return zza(Level.INFO);
    }

    public final zzaf zzc() {
        return zza(Level.SEVERE);
    }

    protected final String zzd() {
        return this.zza.zza();
    }

    protected final boolean zzf(Level level) {
        return this.zza.zzd(level);
    }

    protected zzd(zzbd zzbdVar) {
        this.zza = zzbdVar;
    }

    final void zze(zzbb zzbbVar) {
        try {
            zzea zzc = zzea.zzc();
            try {
                if (zzc.zzb() <= 100) {
                    this.zza.zzc(zzbbVar);
                } else {
                    zzg("unbounded recursion in log statement", zzbbVar);
                }
                zzc.close();
            } finally {
            }
        } catch (RuntimeException e6) {
            try {
                this.zza.zzb(e6, zzbbVar);
            } catch (zzbe e7) {
                throw e7;
            } catch (RuntimeException e8) {
                zzg(e8.getClass().getName() + ": " + e8.getMessage(), zzbbVar);
                try {
                    e8.printStackTrace(System.err);
                } catch (RuntimeException unused) {
                }
            }
        }
    }
}
