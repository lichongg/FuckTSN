package ms.bz.bd.c.Pgl;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pbla {
    public static byte[] a(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i6 = 0; i6 < length; i6 += 2) {
            bArr[i6 / 2] = (byte) (Character.digit(str.charAt(i6 + 1), 16) + (Character.digit(str.charAt(i6), 16) << 4));
        }
        return bArr;
    }
}
