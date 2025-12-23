package cn.bluemobi.dylan.base.utils;

import android.annotation.SuppressLint;
import com.baidu.mobads.sdk.internal.by;
import java.io.PrintStream;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"DefaultLocale"})
/* loaded from: D:\Downloads\app\classes2.dex */
public class n {
    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i6 = 0; i6 < charArray.length; i6++) {
                bArr[i6] = (byte) charArray[i6];
            }
            byte[] digest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b6 : digest) {
                int i7 = b6 & 255;
                if (i7 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i7));
            }
            String stringBuffer2 = stringBuffer.toString();
            System.out.getClass();
            return stringBuffer2;
        } catch (Exception e6) {
            PrintStream printStream = System.out;
            e6.toString();
            printStream.getClass();
            e6.printStackTrace();
            return null;
        }
    }
}
