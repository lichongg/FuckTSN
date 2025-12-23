package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzaf {
    private final zzp zza;
    private final boolean zzb;
    private final zzae zzc;

    private zzaf(zzae zzaeVar, boolean z5, zzp zzpVar, int i6) {
        this.zzc = zzaeVar;
        this.zzb = z5;
        this.zza = zzpVar;
    }

    private zzaf(zzae zzaeVar) {
        this(zzaeVar, false, zzn.zza, Integer.MAX_VALUE);
    }

    public final zzac zzb(String str) {
        return new zzac(this, zzd(" == "), null);
    }

    public final zzaf zzc() {
        return new zzaf(this.zzc, true, this.zza, Integer.MAX_VALUE);
    }

    public static zzaf zzd(String str) {
        if (str.length() != 0) {
            if (str.length() == 1) {
                return new zzaf(new zzx(new zzl(str.charAt(0))));
            }
            return new zzaf(new zzz(str));
        }
        throw new IllegalArgumentException("The separator may not be the empty string.");
    }

    public final zzaf zze(zzp zzpVar) {
        zzpVar.getClass();
        return new zzaf(this.zzc, this.zzb, zzpVar, Integer.MAX_VALUE);
    }

    public final Iterable zzf(CharSequence charSequence) {
        charSequence.getClass();
        return new zzaa(this, charSequence);
    }
}
