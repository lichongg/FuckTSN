package com.umeng.socialize.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class i {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i6 = 0; i6 < bArr.length; i6++) {
                bArr[i6] = (byte) ((bArr[i6] ^ bArr2[i6 % bArr2.length]) ^ (i6 & 255));
            }
        }
        return bArr;
    }
}
