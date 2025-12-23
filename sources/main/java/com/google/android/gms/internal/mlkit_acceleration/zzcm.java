package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzcm extends zzcp {
    private final int zzc;

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcp
    protected final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcp, com.google.android.gms.internal.mlkit_acceleration.zzcs
    public final byte zza(int i6) {
        int i7 = this.zzc;
        if (((i7 - (i6 + 1)) | i6) >= 0) {
            return this.zza[i6];
        }
        if (i6 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i6);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i6 + ", " + i7);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcp, com.google.android.gms.internal.mlkit_acceleration.zzcs
    final byte zzb(int i6) {
        return this.zza[i6];
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcp, com.google.android.gms.internal.mlkit_acceleration.zzcs
    public final int zzd() {
        return this.zzc;
    }

    zzcm(byte[] bArr, int i6, int i7) {
        super(bArr);
        zzcs.zzj(0, i7, bArr.length);
        this.zzc = i7;
    }
}
