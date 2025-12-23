package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class zzhu extends RuntimeException {
    public zzhu(int i6, String str) {
        super(zzht.values()[i6].zza() + ": " + str);
        zzht zzhtVar = zzht.values()[i6];
    }

    zzhu(int i6, byte[] bArr) {
        this(i6, new String(bArr, zza.zza));
    }
}
