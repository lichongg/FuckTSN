package com.google.android.gms.internal.mlkit_acceleration;

import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzck implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzcs zzcsVar = (zzcs) obj;
        zzcs zzcsVar2 = (zzcs) obj2;
        zzcj zzcjVar = new zzcj(zzcsVar);
        zzcj zzcjVar2 = new zzcj(zzcsVar2);
        while (zzcjVar.hasNext() && zzcjVar2.hasNext()) {
            int compareTo = Integer.valueOf(zzcjVar.zza() & 255).compareTo(Integer.valueOf(zzcjVar2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzcsVar.zzd()).compareTo(Integer.valueOf(zzcsVar2.zzd()));
    }

    zzck() {
    }
}
