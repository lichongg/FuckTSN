package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzcy extends zzcv {
    private final zzdo zza = new zzdo(false);

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof zzcy) && ((zzcy) obj).zza.equals(this.zza);
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final zzcy zza(String str) {
        return (zzcy) this.zza.get("authToken");
    }

    public final zzdb zzc(String str) {
        return (zzdb) this.zza.get(str);
    }

    public final Set zzd() {
        return this.zza.entrySet();
    }

    public final void zze(String str, zzcv zzcvVar) {
        this.zza.put(str, zzcvVar);
    }
}
