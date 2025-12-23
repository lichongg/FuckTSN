package com.google.android.gms.internal.mlkit_vision_mediapipe;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzz implements zzaa {
    public static final zzz zza = new zzw();

    public abstract int zza();

    public abstract String zzb();

    @NullableDecl
    public abstract String zzc();

    public abstract String zzd();

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LogSite{ class=");
        sb.append(zzb());
        sb.append(", method=");
        sb.append(zzd());
        sb.append(", line=");
        sb.append(zza());
        if (zzc() != null) {
            sb.append(", file=");
            sb.append(zzc());
        }
        sb.append(" }");
        return sb.toString();
    }
}
