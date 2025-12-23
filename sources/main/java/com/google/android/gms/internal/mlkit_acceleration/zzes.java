package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzes implements zzfn {
    private static final zzey zza = new zzeq();
    private final zzey zzb;

    public zzes() {
        zzey zzeyVar;
        zzdq zza2 = zzdq.zza();
        try {
            zzeyVar = (zzey) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            zzeyVar = zza;
        }
        zzer zzerVar = new zzer(zza2, zzeyVar);
        byte[] bArr = zzeb.zzd;
        this.zzb = zzerVar;
    }

    private static boolean zzb(zzex zzexVar) {
        if (zzexVar.zzc() - 1 != 1) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfn
    public final zzfm zza(Class cls) {
        zzfo.zzr(cls);
        zzex zzb = this.zzb.zzb(cls);
        if (zzb.zzb()) {
            if (zzdv.class.isAssignableFrom(cls)) {
                return zzfe.zzc(zzfo.zzn(), zzdl.zzb(), zzb.zza());
            }
            return zzfe.zzc(zzfo.zzm(), zzdl.zza(), zzb.zza());
        }
        if (zzdv.class.isAssignableFrom(cls)) {
            if (zzb(zzb)) {
                return zzfd.zzm(cls, zzb, zzfg.zzb(), zzeo.zze(), zzfo.zzn(), zzdl.zzb(), zzew.zzb());
            }
            return zzfd.zzm(cls, zzb, zzfg.zzb(), zzeo.zze(), zzfo.zzn(), null, zzew.zzb());
        }
        if (zzb(zzb)) {
            return zzfd.zzm(cls, zzb, zzfg.zza(), zzeo.zzd(), zzfo.zzm(), zzdl.zza(), zzew.zza());
        }
        return zzfd.zzm(cls, zzb, zzfg.zza(), zzeo.zzd(), zzfo.zzm(), null, zzew.zza());
    }
}
