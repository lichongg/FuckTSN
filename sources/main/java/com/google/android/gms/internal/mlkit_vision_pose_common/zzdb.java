package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzdb extends zzcv {
    private final Object zza;

    public zzdb(Boolean bool) {
        Objects.requireNonNull(bool);
        this.zza = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzdb.class != obj.getClass()) {
            return false;
        }
        zzdb zzdbVar = (zzdb) obj;
        if (this.zza == null) {
            return zzdbVar.zza == null;
        }
        if (zzk(this) && zzk(zzdbVar)) {
            return ((this.zza instanceof BigInteger) || (zzdbVar.zza instanceof BigInteger)) ? zzg().equals(zzdbVar.zzg()) : zzd().longValue() == zzdbVar.zzd().longValue();
        }
        Object obj2 = this.zza;
        if (obj2 instanceof Number) {
            Object obj3 = zzdbVar.zza;
            if (obj3 instanceof Number) {
                if ((obj2 instanceof BigDecimal) && (obj3 instanceof BigDecimal)) {
                    return zzf().compareTo(zzdbVar.zzf()) == 0;
                }
                double zza = zza();
                double zza2 = zzdbVar.zza();
                if (zza != zza2) {
                    return Double.isNaN(zza) && Double.isNaN(zza2);
                }
                return true;
            }
        }
        return obj2.equals(zzdbVar.zza);
    }

    public zzdb(Number number) {
        Objects.requireNonNull(number);
        this.zza = number;
    }

    private static boolean zzk(zzdb zzdbVar) {
        Object obj = zzdbVar.zza;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public final int hashCode() {
        long doubleToLongBits;
        if (this.zza == null) {
            return 31;
        }
        if (zzk(this)) {
            doubleToLongBits = zzd().longValue();
        } else {
            Object obj = this.zza;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(zzd().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public final double zza() {
        return this.zza instanceof Number ? zzd().doubleValue() : Double.parseDouble(zze());
    }

    public final long zzc() {
        return this.zza instanceof Number ? zzd().longValue() : Long.parseLong(zze());
    }

    public final Number zzd() {
        Object obj = this.zza;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new zzdg((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public final String zze() {
        Object obj = this.zza;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Number) {
            return zzd().toString();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        }
        throw new AssertionError("Unexpected value type: ".concat(String.valueOf(obj.getClass())));
    }

    public final BigDecimal zzf() {
        Object obj = this.zza;
        return obj instanceof BigDecimal ? (BigDecimal) obj : zzdp.zza(zze());
    }

    public final BigInteger zzg() {
        Object obj = this.zza;
        return obj instanceof BigInteger ? (BigInteger) obj : zzk(this) ? BigInteger.valueOf(zzd().longValue()) : zzdp.zzb(zze());
    }

    public final boolean zzh() {
        Object obj = this.zza;
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(zze());
    }

    public final boolean zzi() {
        return this.zza instanceof Boolean;
    }

    public final boolean zzj() {
        return this.zza instanceof Number;
    }

    public zzdb(String str) {
        Objects.requireNonNull(str);
        this.zza = str;
    }
}
