package com.google.android.gms.internal.mlkit_acceleration;

import com.google.android.gms.internal.mlkit_acceleration.zzcb;
import com.google.android.gms.internal.mlkit_acceleration.zzcc;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzcc<MessageType extends zzcc<MessageType, BuilderType>, BuilderType extends zzcb<MessageType, BuilderType>> implements zzfa {
    protected int zza = 0;

    int zzt(zzfm zzfmVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfa
    public final zzcs zzu() {
        try {
            int zzx = zzx();
            zzcs zzcsVar = zzcs.zzb;
            byte[] bArr = new byte[zzx];
            zzdd zzy = zzdd.zzy(bArr, 0, zzx);
            zzM(zzy);
            zzy.zzz();
            return new zzcp(bArr);
        } catch (IOException e6) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e6);
        }
    }

    public final byte[] zzv() {
        try {
            int zzx = zzx();
            byte[] bArr = new byte[zzx];
            zzdd zzy = zzdd.zzy(bArr, 0, zzx);
            zzM(zzy);
            zzy.zzz();
            return bArr;
        } catch (IOException e6) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e6);
        }
    }
}
