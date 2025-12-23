package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzdl {
    private static final Comparator zza = new zzde();
    private static final zzdl zzb = new zzdl(new zzdj(Collections.EMPTY_LIST));
    private final zzdj zzc;

    public static zzdl zza() {
        return zzb;
    }

    public final boolean equals(@NullableDecl Object obj) {
        return (obj instanceof zzdl) && ((zzdl) obj).zzc.equals(this.zzc);
    }

    public final int hashCode() {
        return ~this.zzc.hashCode();
    }

    public final String toString() {
        return this.zzc.toString();
    }

    public final zzdl zzb(zzdl zzdlVar) {
        return !zzdlVar.zzc.isEmpty() ? this.zzc.isEmpty() ? zzdlVar : new zzdl(new zzdj(this.zzc, zzdlVar.zzc)) : this;
    }

    public final Map zzd() {
        return this.zzc;
    }

    public final boolean zze() {
        return this.zzc.isEmpty();
    }

    private zzdl(zzdj zzdjVar) {
        this.zzc = zzdjVar;
    }
}
