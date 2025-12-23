package com.google.android.gms.internal.mlkit_vision_mediapipe;

import com.google.android.gms.internal.mlkit_vision_mediapipe.zziu;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zziv;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zziv<MessageType extends zziv<MessageType, BuilderType>, BuilderType extends zziu<MessageType, BuilderType>> implements zzlw {
    protected int zza = 0;

    int zzi(zzmi zzmiVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzlw
    public final zzjo zzj() {
        try {
            int zzn = zzn();
            zzjo zzjoVar = zzjo.zzb;
            byte[] bArr = new byte[zzn];
            zzjt zzjtVar = new zzjt(bArr, 0, zzn);
            zzL(zzjtVar);
            zzjtVar.zzB();
            return new zzjn(bArr);
        } catch (IOException e6) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e6);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzlw
    public final byte[] zzk() {
        try {
            int zzn = zzn();
            byte[] bArr = new byte[zzn];
            zzjt zzjtVar = new zzjt(bArr, 0, zzn);
            zzL(zzjtVar);
            zzjtVar.zzB();
            return bArr;
        } catch (IOException e6) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e6);
        }
    }
}
