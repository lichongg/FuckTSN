package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.commons.net.ftp.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzkz {
    static final Charset zza;
    public static final byte[] zzb;

    static int zzb(int i6, byte[] bArr, int i7, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            i6 = (i6 * 31) + bArr[i9];
        }
        return i6;
    }

    static {
        Charset.forName("US-ASCII");
        zza = Charset.forName("UTF-8");
        Charset.forName(b.T);
        byte[] bArr = new byte[0];
        zzb = bArr;
        ByteBuffer.wrap(bArr);
        int i6 = zzjs.zza;
        try {
            new zzjq(bArr, 0, 0, false, null).zza(0);
        } catch (zzlb e6) {
            throw new IllegalArgumentException(e6);
        }
    }

    public static int zza(boolean z5) {
        return z5 ? 1231 : 1237;
    }

    static Object zzc(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("messageType");
    }
}
