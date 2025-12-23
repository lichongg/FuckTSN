package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class zzai {
    private final String zza;
    private final Class zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final long zze;

    protected zzai(String str, Class cls, boolean z5) {
        this(str, cls, z5, true);
    }

    private zzai(String str, Class cls, boolean z5, boolean z6) {
        zzdy.zzb(str);
        this.zza = str;
        this.zzb = cls;
        this.zzc = z5;
        this.zzd = z6;
        int identityHashCode = System.identityHashCode(this);
        long j6 = 0;
        for (int i6 = 0; i6 < 5; i6++) {
            j6 |= 1 << (identityHashCode & 63);
            identityHashCode >>>= 6;
        }
        this.zze = j6;
    }

    public static zzai zzd(String str, Class cls) {
        return new zzai(str, cls, false, false);
    }

    public final String toString() {
        Class cls = this.zzb;
        return getClass().getName() + "/" + this.zza + "[" + cls.getName() + "]";
    }

    protected void zzb(Object obj, zzah zzahVar) {
        zzahVar.zza(this.zza, obj);
    }

    public final long zzc() {
        return this.zze;
    }

    public final Object zze(Object obj) {
        return this.zzb.cast(obj);
    }

    public final String zzf() {
        return this.zza;
    }

    public final void zzg(Object obj, zzah zzahVar) {
        if (!this.zzd || zzch.zza() <= 20) {
            zzb(obj, zzahVar);
        } else {
            zzahVar.zza(this.zza, obj);
        }
    }

    public final void zzh(Iterator it, zzah zzahVar) {
        if (!this.zzc) {
            throw new IllegalStateException("non repeating key");
        }
        if (!this.zzd || zzch.zza() <= 20) {
            zza(it, zzahVar);
        } else {
            while (it.hasNext()) {
                zzahVar.zza(this.zza, it.next());
            }
        }
    }

    public final boolean zzi() {
        return this.zzc;
    }

    protected void zza(Iterator it, zzah zzahVar) {
        while (it.hasNext()) {
            zzb(it.next(), zzahVar);
        }
    }
}
