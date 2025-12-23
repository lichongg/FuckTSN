package com.google.android.gms.internal.mlkit_acceleration;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzhh extends zzdv implements zzfb {
    private static final zzhh zzb;
    private zzea zzd = zzdv.zzE();

    static {
        zzhh zzhhVar = new zzhh();
        zzb = zzhhVar;
        zzdv.zzK(zzhh.class, zzhhVar);
    }

    public static zzhh zzb() {
        return zzb;
    }

    public static zzhh zzc(InputStream inputStream, zzdi zzdiVar) throws IOException {
        return (zzhh) zzdv.zzC(zzb, inputStream, zzdiVar);
    }

    public final List zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdv
    protected final Object zzo(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return (byte) 1;
        }
        if (i7 == 2) {
            return zzdv.zzH(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzhk.class});
        }
        if (i7 == 3) {
            return new zzhh();
        }
        zzhf zzhfVar = null;
        if (i7 == 4) {
            return new zzhg(zzhfVar);
        }
        if (i7 != 5) {
            return null;
        }
        return zzb;
    }

    private zzhh() {
    }
}
