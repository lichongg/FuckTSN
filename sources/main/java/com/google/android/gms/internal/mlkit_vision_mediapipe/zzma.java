package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzma implements zzmi {
    private final zzlw zza;
    private final zzmw zzb;
    private final boolean zzc;
    private final zzkc zzd;

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzmi
    public final int zza(Object obj) {
        int zzb = ((zzkr) obj).zzc.zzb();
        return this.zzc ? zzb + ((zzkn) obj).zzb.zzc() : zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzmi
    public final int zzb(Object obj) {
        int hashCode = ((zzkr) obj).zzc.hashCode();
        return this.zzc ? (hashCode * 53) + ((zzkn) obj).zzb.zza.hashCode() : hashCode;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008b A[EDGE_INSN: B:24:0x008b->B:25:0x008b BREAK  A[LOOP:1: B:10:0x004e->B:18:0x004e], SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzmi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh(java.lang.Object r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.mlkit_vision_mediapipe.zzjd r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr r0 = (com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr) r0
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzmx r1 = r0.zzc
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzmx r2 = com.google.android.gms.internal.mlkit_vision_mediapipe.zzmx.zzc()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzmx r1 = com.google.android.gms.internal.mlkit_vision_mediapipe.zzmx.zzf()
            r0.zzc = r1
        L11:
            r6 = r1
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzkn r10 = (com.google.android.gms.internal.mlkit_vision_mediapipe.zzkn) r10
            r10.zzc()
            r10 = 0
            r0 = r10
        L19:
            if (r12 >= r13) goto L98
            int r4 = com.google.android.gms.internal.mlkit_vision_mediapipe.zzje.zzh(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r1 = 2
            if (r2 == r12) goto L49
            r12 = r2 & 7
            if (r12 != r1) goto L41
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzkb r12 = r14.zzd
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzlw r0 = r9.zza
            int r1 = r2 >>> 3
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzkp r0 = r12.zzb(r0, r1)
            if (r0 != 0) goto L3e
            r3 = r11
            r5 = r13
            r7 = r14
            int r12 = com.google.android.gms.internal.mlkit_vision_mediapipe.zzje.zzg(r2, r3, r4, r5, r6, r7)
            goto L19
        L3e:
            int r11 = com.google.android.gms.internal.mlkit_vision_mediapipe.zzmf.zza
            throw r10
        L41:
            r3 = r11
            r5 = r13
            r7 = r14
            int r12 = com.google.android.gms.internal.mlkit_vision_mediapipe.zzje.zzn(r2, r3, r4, r5, r7)
            goto L19
        L49:
            r3 = r11
            r5 = r13
            r7 = r14
            r11 = 0
            r12 = r10
        L4e:
            if (r4 >= r5) goto L8a
            int r13 = com.google.android.gms.internal.mlkit_vision_mediapipe.zzje.zzh(r3, r4, r7)
            int r14 = r7.zza
            int r2 = r14 >>> 3
            r4 = r14 & 7
            if (r2 == r1) goto L70
            r8 = 3
            if (r2 == r8) goto L60
            goto L81
        L60:
            if (r0 != 0) goto L6d
            if (r4 != r1) goto L81
            int r4 = com.google.android.gms.internal.mlkit_vision_mediapipe.zzje.zza(r3, r13, r7)
            java.lang.Object r12 = r7.zzc
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzjo r12 = (com.google.android.gms.internal.mlkit_vision_mediapipe.zzjo) r12
            goto L4e
        L6d:
            int r11 = com.google.android.gms.internal.mlkit_vision_mediapipe.zzmf.zza
            throw r10
        L70:
            if (r4 != 0) goto L81
            int r4 = com.google.android.gms.internal.mlkit_vision_mediapipe.zzje.zzh(r3, r13, r7)
            int r11 = r7.zza
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzkb r13 = r7.zzd
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzlw r14 = r9.zza
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzkp r0 = r13.zzb(r14, r11)
            goto L4e
        L81:
            r2 = 12
            if (r14 == r2) goto L8b
            int r4 = com.google.android.gms.internal.mlkit_vision_mediapipe.zzje.zzn(r14, r3, r13, r5, r7)
            goto L4e
        L8a:
            r13 = r4
        L8b:
            if (r12 == 0) goto L93
            int r11 = r11 << 3
            r11 = r11 | r1
            r6.zzj(r11, r12)
        L93:
            r12 = r13
            r11 = r3
            r13 = r5
            r14 = r7
            goto L19
        L98:
            r5 = r13
            if (r12 != r5) goto L9c
            return
        L9c:
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzlb r10 = new com.google.android.gms.internal.mlkit_vision_mediapipe.zzlb
            java.lang.String r11 = "Failed to parse the message."
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_mediapipe.zzma.zzh(java.lang.Object, byte[], int, int, com.google.android.gms.internal.mlkit_vision_mediapipe.zzjd):void");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzmi
    public final void zzi(Object obj, zznj zznjVar) throws IOException {
        Iterator zzg = ((zzkn) obj).zzb.zzg();
        while (zzg.hasNext()) {
            Map.Entry entry = (Map.Entry) zzg.next();
            zzkf zzkfVar = (zzkf) entry.getKey();
            if (zzkfVar.zze() != zzni.MESSAGE || zzkfVar.zzg() || zzkfVar.zzf()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzle) {
                zznjVar.zzw(zzkfVar.zza(), ((zzle) entry).zza().zzb());
            } else {
                zznjVar.zzw(zzkfVar.zza(), entry.getValue());
            }
        }
        ((zzkr) obj).zzc.zzk(zznjVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzmi
    public final boolean zzj(Object obj, Object obj2) {
        if (!((zzkr) obj).zzc.equals(((zzkr) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzkn) obj).zzb.equals(((zzkn) obj2).zzb);
        }
        return true;
    }

    static zzma zzc(zzmw zzmwVar, zzkc zzkcVar, zzlw zzlwVar) {
        return new zzma(zzmwVar, zzkcVar, zzlwVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzmi
    public final Object zze() {
        zzlw zzlwVar = this.zza;
        return zzlwVar instanceof zzkr ? ((zzkr) zzlwVar).zzt() : zzlwVar.zzJ().zzl();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzmi
    public final void zzf(Object obj) {
        this.zzb.zza(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzmi
    public final void zzg(Object obj, Object obj2) {
        zzmk.zzp(this.zzb, obj, obj2);
        if (this.zzc) {
            zzmk.zzo(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzmi
    public final boolean zzk(Object obj) {
        return ((zzkn) obj).zzb.zzl();
    }

    private zzma(zzmw zzmwVar, zzkc zzkcVar, zzlw zzlwVar) {
        this.zzb = zzmwVar;
        this.zzc = zzlwVar instanceof zzkn;
        this.zzd = zzkcVar;
        this.zza = zzlwVar;
    }
}
