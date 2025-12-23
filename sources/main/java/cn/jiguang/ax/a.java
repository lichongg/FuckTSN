package cn.jiguang.ax;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {
    public static byte[] a(byte[] bArr) {
        try {
            byte[] bArr2 = {32, 25, 8, 22, 17, 48};
            byte[] bArr3 = new byte[bArr.length];
            for (int i6 = 0; i6 < bArr.length; i6++) {
                bArr3[i6] = (byte) (bArr[i6] ^ bArr2[(bArr.length + i6) % 6]);
            }
            return bArr3;
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static String b(byte[] bArr) {
        return new String(a(bArr));
    }
}
