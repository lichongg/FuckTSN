package com.google.android.gms.internal.mlkit_vision_pose_common;

import android.util.Base64;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzvw {
    public static final zzvo zza;

    static {
        byte[] decode = Base64.decode("xBkDPNxUEiMRX5vPP2wqvCR4Grb8GZQqrKNyC0Y", 3);
        byte[] decode2 = Base64.decode("xJXZd/zR0io4+XWtcwbtnyYutpO4NX7DhE3xBg4", 3);
        byte[] bArr = new byte[decode.length];
        for (int i6 = 0; i6 < decode.length; i6++) {
            bArr[i6] = (byte) (decode[i6] ^ decode2[i6]);
        }
        zza = new zzvo("722550545529", Base64.encodeToString(bArr, 3), "82c62205f0ef0ea96608a8");
    }
}
