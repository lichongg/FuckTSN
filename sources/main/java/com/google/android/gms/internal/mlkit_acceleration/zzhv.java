package com.google.android.gms.internal.mlkit_acceleration;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzhv extends zzbk {
    public final int zzf() {
        int zza = zza(4);
        if (zza != 0) {
            return zzc(zza);
        }
        return 0;
    }

    public static zzhv zzg(ByteBuffer byteBuffer) {
        zzhv zzhvVar = new zzhv();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        zzhvVar.zze(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
        return zzhvVar;
    }

    public final zzhx zzh(int i6) {
        zzhx zzhxVar = new zzhx();
        int zza = zza(4);
        if (zza == 0) {
            return null;
        }
        int zzb = zzb(zza) + (i6 * 4);
        zzhxVar.zze(zzb + this.zzb.getInt(zzb), this.zzb);
        return zzhxVar;
    }
}
