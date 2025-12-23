package com.google.android.odml.image;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzb extends zzh {
    private Integer zza;
    private Integer zzb;

    @Override // com.google.android.odml.image.zzh
    final ImageProperties zzc() {
        Integer num = this.zza;
        if (num != null && this.zzb != null) {
            return new zzc(num.intValue(), this.zzb.intValue(), null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" imageFormat");
        }
        if (this.zzb == null) {
            sb.append(" storageType");
        }
        String valueOf = String.valueOf(sb);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 28);
        sb2.append("Missing required properties:");
        sb2.append(valueOf);
        throw new IllegalStateException(sb2.toString());
    }

    zzb() {
    }

    @Override // com.google.android.odml.image.zzh
    final zzh zza(int i6) {
        this.zza = Integer.valueOf(i6);
        return this;
    }

    @Override // com.google.android.odml.image.zzh
    final zzh zzb(int i6) {
        this.zzb = Integer.valueOf(i6);
        return this;
    }
}
