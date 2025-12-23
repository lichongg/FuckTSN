package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzhr {
    private final long zza;
    private final zzhp zzb;

    private final native byte[][] zzb(long j6);

    public final List zza() {
        synchronized (this.zzb) {
            try {
                zzb.zzc(this.zzb.zza() != 0, "Invalid context, tearDown() might have been called already.");
                byte[][] zzb = zzb(this.zza);
                ArrayList arrayList = new ArrayList();
                if (zzb == null) {
                    return arrayList;
                }
                for (byte[] bArr : zzb) {
                    try {
                        arrayList.add(zzfw.zzc(bArr));
                    } catch (zzlb e6) {
                        throw new RuntimeException(e6);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    zzhr(long j6, zzhp zzhpVar) {
        boolean z5;
        if (j6 != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        zzb.zzc(z5, "Invalid profiler, tearDown() might have been called already.");
        this.zza = j6;
        this.zzb = zzhpVar;
    }
}
