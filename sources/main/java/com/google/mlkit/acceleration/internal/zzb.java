package com.google.mlkit.acceleration.internal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzb extends zzn {
    private boolean zza;
    private int zzb;
    private float zzc;
    private int zzd;
    private byte zze;

    @Override // com.google.mlkit.acceleration.internal.zzn
    public final zzn zza(float f6) {
        this.zzc = f6;
        this.zze = (byte) (this.zze | 4);
        return this;
    }

    @Override // com.google.mlkit.acceleration.internal.zzn
    public final zzn zzb(boolean z5) {
        this.zza = z5;
        this.zze = (byte) (this.zze | 1);
        return this;
    }

    @Override // com.google.mlkit.acceleration.internal.zzn
    public final zzn zzc(int i6) {
        this.zzd = i6;
        this.zze = (byte) (this.zze | 8);
        return this;
    }

    @Override // com.google.mlkit.acceleration.internal.zzn
    public final zzn zzd(int i6) {
        this.zzb = i6;
        this.zze = (byte) (this.zze | 2);
        return this;
    }

    @Override // com.google.mlkit.acceleration.internal.zzn
    public final MiniBenchmarkResult zze() {
        if (this.zze == 15) {
            return new AutoValue_MiniBenchmarkResult(this.zza, this.zzb, this.zzc, this.zzd, null);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.zze & 1) == 0) {
            sb.append(" logged");
        }
        if ((this.zze & 2) == 0) {
            sb.append(" stabilityStatus");
        }
        if ((this.zze & 4) == 0) {
            sb.append(" correctnessScore");
        }
        if ((this.zze & 8) == 0) {
            sb.append(" runLatencyMs");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    zzb() {
    }
}
