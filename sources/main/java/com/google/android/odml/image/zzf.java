package com.google.android.odml.image;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzf implements zzg {
    private final ByteBuffer zza;
    private final ImageProperties zzb;

    public final ByteBuffer zza() {
        return this.zza;
    }

    @Override // com.google.android.odml.image.zzg
    public final ImageProperties zzb() {
        return this.zzb;
    }

    public zzf(ByteBuffer byteBuffer, int i6) {
        this.zza = byteBuffer;
        zzb zzbVar = new zzb();
        zzbVar.zzb(2);
        zzbVar.zza(i6);
        this.zzb = zzbVar.zzc();
    }

    @Override // com.google.android.odml.image.zzg
    public final void zzc() {
    }
}
