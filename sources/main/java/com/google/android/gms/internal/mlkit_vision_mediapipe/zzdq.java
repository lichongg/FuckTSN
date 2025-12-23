package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzdq extends zzdo {
    private static final Map zza;
    private final zzax zzb;

    static {
        EnumMap enumMap = new EnumMap(zzax.class);
        for (zzax zzaxVar : zzax.values()) {
            zzdq[] zzdqVarArr = new zzdq[10];
            for (int i6 = 0; i6 < 10; i6++) {
                zzdqVarArr[i6] = new zzdq(i6, zzaxVar, zzay.zzf());
            }
            enumMap.put((EnumMap) zzaxVar, (zzax) zzdqVarArr);
        }
        zza = Collections.unmodifiableMap(enumMap);
    }

    public static zzdq zza(int i6, zzax zzaxVar, zzay zzayVar) {
        return (i6 >= 10 || !zzayVar.zzj()) ? new zzdq(i6, zzaxVar, zzayVar) : ((zzdq[]) zza.get(zzaxVar))[i6];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzdo
    protected final void zzb(zzdp zzdpVar, Object obj) {
        zzdpVar.zzd(obj, this.zzb, zzd());
    }

    private zzdq(int i6, zzax zzaxVar, zzay zzayVar) {
        super(zzayVar, i6);
        zzdy.zza(zzaxVar, "format char");
        this.zzb = zzaxVar;
        if (!zzayVar.zzj()) {
            int zza2 = zzaxVar.zza();
            zza2 = zzayVar.zzk() ? zza2 & 65503 : zza2;
            StringBuilder sb = new StringBuilder("%");
            zzayVar.zzh(sb);
            sb.append((char) zza2);
            return;
        }
        zzaxVar.zze();
    }
}
