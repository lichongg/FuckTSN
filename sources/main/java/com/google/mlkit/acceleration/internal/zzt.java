package com.google.mlkit.acceleration.internal;

import com.google.android.gms.internal.mlkit_acceleration.zzdi;
import com.google.android.gms.internal.mlkit_acceleration.zzdv;
import com.google.android.gms.internal.mlkit_acceleration.zzea;
import com.google.android.gms.internal.mlkit_acceleration.zzed;
import com.google.android.gms.internal.mlkit_acceleration.zzfb;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzt extends zzdv implements zzfb {
    private static final zzt zzb;
    private int zzd;
    private int zzh;
    private zzea zze = zzdv.zzE();
    private String zzf = "";
    private String zzg = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";

    static {
        zzt zztVar = new zzt();
        zzb = zztVar;
        zzdv.zzK(zzt.class, zztVar);
    }

    public static zzs zzb() {
        return (zzs) zzb.zzy();
    }

    public static zzt zzd() {
        return zzb;
    }

    public static zzt zze(byte[] bArr, zzdi zzdiVar) throws zzed {
        return (zzt) zzdv.zzD(zzb, bArr, zzdiVar);
    }

    static /* synthetic */ void zzm(zzt zztVar, int i6) {
        zztVar.zzd |= 4;
        zztVar.zzh = i6;
    }

    public final int zza() {
        return this.zzh;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zzg;
    }

    public final String zzh() {
        return this.zzi;
    }

    public final String zzi() {
        return this.zzk;
    }

    public final String zzj() {
        return this.zzj;
    }

    public final List zzk() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdv
    protected final Object zzo(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return (byte) 1;
        }
        if (i7 == 2) {
            return zzdv.zzH(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဈ\u0001\u0004င\u0002\u0005ဈ\u0003\u0006ဈ\u0004\u0007ဈ\u0005", new Object[]{"zzd", "zze", zzq.class, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i7 == 3) {
            return new zzt();
        }
        zzr zzrVar = null;
        if (i7 == 4) {
            return new zzs(zzrVar);
        }
        if (i7 != 5) {
            return null;
        }
        return zzb;
    }

    private zzt() {
    }

    static /* synthetic */ void zzl(zzt zztVar, String str) {
        str.getClass();
        zztVar.zzd |= 2;
        zztVar.zzg = str;
    }

    static /* synthetic */ void zzn(zzt zztVar, String str) {
        str.getClass();
        zztVar.zzd |= 8;
        zztVar.zzi = str;
    }

    static /* synthetic */ void zzp(zzt zztVar, String str) {
        str.getClass();
        zztVar.zzd |= 16;
        zztVar.zzj = str;
    }

    static /* synthetic */ void zzq(zzt zztVar, zzq zzqVar) {
        int i6;
        zzqVar.getClass();
        zzea zzeaVar = zztVar.zze;
        if (!zzeaVar.zzc()) {
            int size = zzeaVar.size();
            if (size == 0) {
                i6 = 10;
            } else {
                i6 = size + size;
            }
            zztVar.zze = zzeaVar.zzd(i6);
        }
        zztVar.zze.add(zzqVar);
    }

    static /* synthetic */ void zzr(zzt zztVar, String str) {
        str.getClass();
        zztVar.zzd |= 32;
        zztVar.zzk = str;
    }

    static /* synthetic */ void zzs(zzt zztVar, String str) {
        str.getClass();
        zztVar.zzd |= 1;
        zztVar.zzf = str;
    }
}
