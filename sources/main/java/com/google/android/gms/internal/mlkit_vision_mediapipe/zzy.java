package com.google.android.gms.internal.mlkit_vision_mediapipe;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzy extends zzz {
    private final String zzc;
    private final int zzd;
    private int zzf = 0;
    private final String zzb = "com/google/mediapipe/framework/Graph";

    @NullableDecl
    private final String zze = "Graph.java";

    public final boolean equals(Object obj) {
        if (obj instanceof zzy) {
            zzy zzyVar = (zzy) obj;
            if (this.zzc.equals(zzyVar.zzc) && this.zzd == zzyVar.zzd && zzb().equals(zzyVar.zzb())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i6 = this.zzf;
        if (i6 != 0) {
            return i6;
        }
        int hashCode = ((this.zzc.hashCode() + 4867) * 31) + this.zzd;
        this.zzf = hashCode;
        return hashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzz
    public final int zza() {
        return (char) this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzz
    public final String zzb() {
        return this.zzb.replace('/', '.');
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzz
    @NullableDecl
    public final String zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzz
    public final String zzd() {
        return this.zzc;
    }

    /* synthetic */ zzy(String str, String str2, int i6, String str3, zzx zzxVar) {
        this.zzc = str2;
        this.zzd = i6;
    }
}
