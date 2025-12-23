package com.google.android.gms.internal.mlkit_vision_mediapipe;

import android.annotation.SuppressLint;
import android.os.Build;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import kotlin.text.v0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzcs extends zzck {
    static final boolean zza;
    static final boolean zzb;
    static final boolean zzc;
    private static final AtomicReference zzd;
    private static final AtomicLong zze;
    private static final ConcurrentLinkedQueue zzf;
    private volatile zzbd zzg;

    static {
        String str = Build.FINGERPRINT;
        zza = str == null || "robolectric".equals(str);
        String str2 = Build.HARDWARE;
        zzb = "goldfish".equals(str2) || "ranchu".equals(str2);
        String str3 = Build.TYPE;
        zzc = "eng".equals(str3) || "userdebug".equals(str3);
        zzd = new AtomicReference();
        zze = new AtomicLong();
        zzf = new ConcurrentLinkedQueue();
    }

    public static zzbd zze(String str) {
        AtomicReference atomicReference = zzd;
        if (atomicReference.get() != null) {
            return ((zzcm) atomicReference.get()).zza(str);
        }
        int length = str.length();
        while (true) {
            length--;
            if (length >= 0) {
                char charAt = str.charAt(length);
                if (charAt != '$') {
                    if (charAt == '.') {
                        break;
                    }
                } else {
                    str = str.replace(v0.f47959c, '.');
                    break;
                }
            } else {
                break;
            }
        }
        zzcs zzcsVar = new zzcs(str);
        zzcq.zza.offer(zzcsVar);
        if (zzd.get() != null) {
            while (true) {
                zzcs zzcsVar2 = (zzcs) zzcq.zza.poll();
                if (zzcsVar2 == null) {
                    break;
                }
                zzcsVar2.zzg = ((zzcm) zzd.get()).zza(zzcsVar2.zza());
            }
            zzf();
        }
        return zzcsVar;
    }

    private static void zzf() {
        while (true) {
            zzcr zzcrVar = (zzcr) zzf.poll();
            if (zzcrVar == null) {
                return;
            }
            zze.getAndDecrement();
            zzbd zzb2 = zzcrVar.zzb();
            zzbb zza2 = zzcrVar.zza();
            if (zza2.zzp() || zzb2.zzd(zza2.zzk())) {
                zzb2.zzc(zza2);
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzck, com.google.android.gms.internal.mlkit_vision_mediapipe.zzbd
    public final void zzb(RuntimeException runtimeException, zzbb zzbbVar) {
        if (this.zzg != null) {
            this.zzg.zzb(runtimeException, zzbbVar);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzbd
    @SuppressLint({"LongLogTag"})
    public final void zzc(zzbb zzbbVar) {
        if (this.zzg != null) {
            this.zzg.zzc(zzbbVar);
            return;
        }
        if (zze.incrementAndGet() > 20) {
            zzf.poll();
        }
        zzf.offer(new zzcr(this, zzbbVar));
        if (this.zzg != null) {
            zzf();
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzbd
    public final boolean zzd(Level level) {
        return this.zzg == null || this.zzg.zzd(level);
    }

    private zzcs(String str) {
        super(str);
        if (!zza && !zzb) {
            if (zzc) {
                this.zzg = zzcy.zzf().zzb(false).zza(zza());
                return;
            } else {
                this.zzg = null;
                return;
            }
        }
        this.zzg = new zzcl().zza(zza());
    }
}
