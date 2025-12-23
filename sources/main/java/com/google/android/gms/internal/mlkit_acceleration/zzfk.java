package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzfk implements zzex {
    private final zzfa zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzex
    public final zzfa zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzex
    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzex
    public final int zzc() {
        int i6 = this.zzd;
        if ((i6 & 1) != 0) {
            return 1;
        }
        return (i6 & 4) == 4 ? 3 : 2;
    }

    final String zzd() {
        return this.zzb;
    }

    final Object[] zze() {
        return this.zzc;
    }

    zzfk(zzfa zzfaVar, String str, Object[] objArr) {
        this.zza = zzfaVar;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        int i6 = charAt & 8191;
        int i7 = 1;
        int i8 = 13;
        while (true) {
            int i9 = i7 + 1;
            char charAt2 = str.charAt(i7);
            if (charAt2 >= 55296) {
                i6 |= (charAt2 & 8191) << i8;
                i8 += 13;
                i7 = i9;
            } else {
                this.zzd = i6 | (charAt2 << i8);
                return;
            }
        }
    }
}
