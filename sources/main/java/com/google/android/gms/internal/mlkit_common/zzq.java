package com.google.android.gms.internal.mlkit_common;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzq {
    private final String zza;
    private final zzo zzb;
    private zzo zzc;

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzo zzoVar = this.zzb.zzc;
        String str = "";
        while (zzoVar != null) {
            Object obj = zzoVar.zzb;
            sb.append(str);
            String str2 = zzoVar.zza;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r3.length() - 1);
            }
            zzoVar = zzoVar.zzc;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzq zza(String str, @CheckForNull Object obj) {
        zzo zzoVar = new zzo();
        this.zzc.zzc = zzoVar;
        this.zzc = zzoVar;
        zzoVar.zzb = obj;
        zzoVar.zza = str;
        return this;
    }

    /* synthetic */ zzq(String str, zzp zzpVar) {
        zzo zzoVar = new zzo();
        this.zzb = zzoVar;
        this.zzc = zzoVar;
        str.getClass();
        this.zza = str;
    }

    public final zzq zzb(String str, boolean z5) {
        String valueOf = String.valueOf(z5);
        zzn zznVar = new zzn(null);
        this.zzc.zzc = zznVar;
        this.zzc = zznVar;
        zznVar.zzb = valueOf;
        zznVar.zza = "isManifestFile";
        return this;
    }
}
