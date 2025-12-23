package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzjj extends zzjn {
    private final int zzc;

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzjn
    protected final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzjn, com.google.android.gms.internal.mlkit_vision_mediapipe.zzjo
    public final byte zza(int i6) {
        int i7 = this.zzc;
        if (((i7 - (i6 + 1)) | i6) >= 0) {
            return ((zzjn) this).zza[i6];
        }
        if (i6 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i6);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i6 + ", " + i7);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzjn, com.google.android.gms.internal.mlkit_vision_mediapipe.zzjo
    final byte zzb(int i6) {
        return ((zzjn) this).zza[i6];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzjn, com.google.android.gms.internal.mlkit_vision_mediapipe.zzjo
    public final int zzd() {
        return this.zzc;
    }

    zzjj(byte[] bArr, int i6, int i7) {
        super(bArr);
        zzjo.zzh(0, i7, bArr.length);
        this.zzc = i7;
    }
}
