package com.google.android.gms.internal.mlkit_acceleration;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzt {
    private final String zza;
    private final zzr zzb;
    private zzr zzc;

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzr zzrVar = this.zzb.zzc;
        String str = "";
        while (zzrVar != null) {
            Object obj = zzrVar.zzb;
            sb.append(str);
            String str2 = zzrVar.zza;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r3.length() - 1);
            }
            zzrVar = zzrVar.zzc;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzt zza(String str, @CheckForNull Object obj) {
        zzr zzrVar = new zzr();
        this.zzc.zzc = zzrVar;
        this.zzc = zzrVar;
        zzrVar.zzb = obj;
        zzrVar.zza = str;
        return this;
    }

    /* synthetic */ zzt(String str, zzs zzsVar) {
        zzr zzrVar = new zzr();
        this.zzb = zzrVar;
        this.zzc = zzrVar;
        this.zza = "RunConfig";
    }
}
