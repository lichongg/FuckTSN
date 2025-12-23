package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzds extends zzdw {
    private static final zzdw zza = new zzds();

    public static zzdw zzb() {
        return zza;
    }

    private zzds() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzdw
    public final int zza(zzdt zzdtVar, int i6, String str, int i7, int i8, int i9) throws zzdv {
        boolean z5;
        zzdo zza2;
        char charAt = str.charAt(i9);
        if ((charAt & ' ') == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        zzay zzg = zzay.zzg(str, i8, i9, z5);
        zzax zzc = zzax.zzc(charAt);
        int i10 = i9 + 1;
        if (zzc != null) {
            if (zzg.zzi(zzc)) {
                zza2 = zzdq.zza(i6, zzc, zzg);
            } else {
                throw zzdv.zzc("invalid format specifier", str, i7, i10);
            }
        } else if (charAt != 't' && charAt != 'T') {
            if (charAt != 'h' && charAt != 'H') {
                throw zzdv.zzc("invalid format specification", str, i7, i10);
            }
            if (zzg.zzl(160, false)) {
                zza2 = new zzdr(zzg, i6, zzg);
            } else {
                throw zzdv.zzc("invalid format specification", str, i7, i10);
            }
        } else if (zzg.zzl(160, false)) {
            int i11 = i9 + 2;
            if (i11 <= str.length()) {
                zzdm zzb = zzdm.zzb(str.charAt(i10));
                if (zzb != null) {
                    zza2 = zzdn.zza(zzb, zzg, i6);
                    i10 = i11;
                } else {
                    throw zzdv.zza("illegal date/time conversion", str, i10);
                }
            } else {
                throw zzdv.zza("truncated format specifier", str, i7);
            }
        } else {
            throw zzdv.zzc("invalid format specification", str, i7, i10);
        }
        zzdtVar.zzl(i7, i10, zza2);
        return i10;
    }
}
