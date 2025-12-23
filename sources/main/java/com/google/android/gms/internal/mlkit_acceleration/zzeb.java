package com.google.android.gms.internal.mlkit_acceleration;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.commons.net.ftp.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzeb {
    static final Charset zza = Charset.forName("US-ASCII");
    static final Charset zzb = Charset.forName("UTF-8");
    static final Charset zzc = Charset.forName(b.T);
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zzcy zzf;

    static int zzb(int i6, byte[] bArr, int i7, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            i6 = (i6 * 31) + bArr[i9];
        }
        return i6;
    }

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        int i6 = zzcy.zzd;
        zzf = zzcy.zzH(bArr, 0, 0, false);
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

    public static String zzd(byte[] bArr) {
        return new String(bArr, zzb);
    }
}
