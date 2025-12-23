package com.google.android.gms.internal.mlkit_acceleration;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzhx extends zzbk {
    public final byte zzf() {
        int zza = zza(6);
        if (zza != 0) {
            return this.zzb.get(zza + this.zza);
        }
        return (byte) 0;
    }

    public final String zzh() {
        int zza = zza(4);
        if (zza != 0) {
            return zzd(zza + this.zza);
        }
        return null;
    }

    public final int zzg() {
        int zza = zza(8);
        if (zza != 0) {
            return zzc(zza);
        }
        return 0;
    }

    public final zzhw zzi(int i6) {
        zzhw zzhwVar = new zzhw();
        int zza = zza(8);
        if (zza == 0) {
            return null;
        }
        int zzb = zzb(zza) + (i6 * 4);
        zzhwVar.zze(zzb + this.zzb.getInt(zzb), this.zzb);
        return zzhwVar;
    }

    public final zzhw zzj(String str) {
        int i6;
        int zza = zza(8);
        if (zza == 0) {
            return null;
        }
        int zzb = zzb(zza);
        ByteBuffer byteBuffer = this.zzb;
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        int i7 = byteBuffer.getInt(zzb - 4);
        int i8 = 0;
        while (i7 != 0) {
            int i9 = i7 / 2;
            int i10 = ((i8 + i9) * 4) + zzb;
            int i11 = i10 + byteBuffer.getInt(i10);
            int capacity = byteBuffer.capacity() - (byteBuffer.capacity() - i11);
            int i12 = byteBuffer.getShort((capacity + 4) - byteBuffer.getInt(capacity)) + capacity;
            int i13 = i12 + byteBuffer.getInt(i12);
            int i14 = byteBuffer.getInt(i13);
            int length = bytes.length;
            int min = Math.min(i14, length);
            int i15 = 0;
            while (true) {
                if (i15 >= min) {
                    i6 = i14 - length;
                    break;
                }
                int i16 = i13 + 4 + i15;
                if (byteBuffer.get(i16) != bytes[i15]) {
                    i6 = byteBuffer.get(i16) - bytes[i15];
                    break;
                }
                i15++;
            }
            if (i6 > 0) {
                i7 = i9;
            } else {
                if (i6 >= 0) {
                    zzhw zzhwVar = new zzhw();
                    zzhwVar.zze(i11, byteBuffer);
                    return zzhwVar;
                }
                int i17 = i9 + 1;
                i8 += i17;
                i7 -= i17;
            }
        }
        return null;
    }
}
