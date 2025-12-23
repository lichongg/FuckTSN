package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzjq extends zzjs {
    private int zzb;
    private int zzc;
    private int zzd;

    /* synthetic */ zzjq(byte[] bArr, int i6, int i7, boolean z5, zzjp zzjpVar) {
        super(null);
        this.zzd = Integer.MAX_VALUE;
        this.zzb = 0;
    }

    public final int zza(int i6) throws zzlb {
        int i7 = this.zzd;
        this.zzd = 0;
        int i8 = this.zzb + this.zzc;
        this.zzb = i8;
        if (i8 <= 0) {
            this.zzc = 0;
            return i7;
        }
        this.zzc = i8;
        this.zzb = 0;
        return i7;
    }
}
