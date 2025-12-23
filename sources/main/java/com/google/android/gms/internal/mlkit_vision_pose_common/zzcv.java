package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.io.IOException;
import java.io.StringWriter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class zzcv {
    public final String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            zzdw zzdwVar = new zzdw(stringWriter);
            zzdwVar.zzj(zzdd.LENIENT);
            zzds.zza.zzb(zzdwVar, this);
            return stringWriter.toString();
        } catch (IOException e6) {
            throw new AssertionError(e6);
        }
    }

    public final zzcy zzb() {
        if (this instanceof zzcy) {
            return (zzcy) this;
        }
        throw new IllegalStateException("Not a JSON Object: ".concat(toString()));
    }

    @Deprecated
    public zzcv() {
    }
}
