package cn.jiguang.bx;

/* loaded from: D:\Downloads\app\classes2.dex */
public class f {
    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b6 : bArr) {
            a(stringBuffer, b6);
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

    private static void a(StringBuffer stringBuffer, byte b6) {
        stringBuffer.append("0123456789ABCDEF".charAt((b6 >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b6 & 15));
    }
}
