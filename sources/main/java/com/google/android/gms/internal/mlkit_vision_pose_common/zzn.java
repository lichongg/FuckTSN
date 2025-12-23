package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzn {
    private final String zza;
    private final zzl zzb;
    private zzl zzc;

    private final zzn zzd(String str, Object obj) {
        zzk zzkVar = new zzk(null);
        this.zzc.zzc = zzkVar;
        this.zzc = zzkVar;
        zzkVar.zzb = obj;
        zzkVar.zza = str;
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzl zzlVar = this.zzb.zzc;
        String str = "";
        while (zzlVar != null) {
            Object obj = zzlVar.zzb;
            sb.append(str);
            String str2 = zzlVar.zza;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r3.length() - 1);
            }
            zzlVar = zzlVar.zzc;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzn zza(String str, int i6) {
        zzd("detectorMode", String.valueOf(i6));
        return this;
    }

    public final zzn zzb(String str, @CheckForNull Object obj) {
        zzl zzlVar = new zzl();
        this.zzc.zzc = zzlVar;
        this.zzc = zzlVar;
        zzlVar.zzb = obj;
        zzlVar.zza = str;
        return this;
    }

    public final zzn zzc(String str, boolean z5) {
        zzd("areFastModels", String.valueOf(z5));
        return this;
    }

    /* synthetic */ zzn(String str, zzm zzmVar) {
        zzl zzlVar = new zzl();
        this.zzb = zzlVar;
        this.zzc = zzlVar;
        this.zza = "PoseDetectorOptionsBase";
    }
}
