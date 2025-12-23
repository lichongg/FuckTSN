package com.google.android.gms.internal.mlkit_acceleration;

import java.io.IOException;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzaa implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzaf zzb;

    zzaa(zzaf zzafVar, CharSequence charSequence) {
        this.zza = charSequence;
        this.zzb = zzafVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Iterator zza;
        zza = r0.zzc.zza(this.zzb, this.zza);
        return zza;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator it = iterator();
        try {
            if (it.hasNext()) {
                sb.append(zzq.zza(it.next(), ", "));
                while (it.hasNext()) {
                    sb.append((CharSequence) ", ");
                    sb.append(zzq.zza(it.next(), ", "));
                }
            }
            sb.append(']');
            return sb.toString();
        } catch (IOException e6) {
            throw new AssertionError(e6);
        }
    }
}
