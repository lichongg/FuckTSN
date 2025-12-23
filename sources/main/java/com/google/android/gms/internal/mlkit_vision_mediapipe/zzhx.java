package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.nio.ByteBuffer;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class zzhx {
    protected final zzhp zza;

    private final native long zza(long j6, boolean z5);

    private final native long zzh(long j6, float f6);

    private final native long zzi(long j6, int i6);

    private final native long zzj(long j6, zzib zzibVar);

    private final native long zzk(long j6, ByteBuffer byteBuffer, int i6, int i7);

    private final native long zzl(long j6, String str);

    private void zzm(long j6, zzie zzieVar) {
        zzieVar.zzf(new zzhq(j6));
    }

    public final zzhv zzb(boolean z5) {
        return zzhv.zzd(zza(this.zza.zza(), z5));
    }

    public final zzhv zzc(float f6) {
        return zzhv.zzd(zzh(this.zza.zza(), f6));
    }

    public final zzhv zzd(int i6) {
        return zzhv.zzd(zzi(this.zza.zza(), i6));
    }

    public final zzhv zze(zzlw zzlwVar) {
        zzib zzibVar = new zzib();
        String zza = zzic.zza.zza(zzlwVar.getClass());
        zzibVar.zza = zza;
        if (zza != null) {
            zzlwVar.zzk();
            return zzhv.zzd(zzj(this.zza.zza(), zzibVar));
        }
        throw new NoSuchElementException("Cannot determine the protobuf type name for class: " + String.valueOf(zzlwVar.getClass()) + ". Have you called ProtoUtil.registerTypeName?");
    }

    public final zzhv zzf(ByteBuffer byteBuffer, int i6, int i7) {
        int i8 = (((i6 * 3) + 3) / 4) * 4 * i7;
        if (i8 == byteBuffer.capacity()) {
            return zzhv.zzd(zzk(this.zza.zza(), byteBuffer, i6, i7));
        }
        throw new IllegalArgumentException("The size of the buffer should be: " + i8 + " but is " + byteBuffer.capacity());
    }

    public final zzhv zzg(String str) {
        return zzhv.zzd(zzl(this.zza.zza(), str));
    }

    public zzhx(zzhp zzhpVar) {
        this.zza = zzhpVar;
    }
}
