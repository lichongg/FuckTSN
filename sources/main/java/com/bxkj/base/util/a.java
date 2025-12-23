package com.bxkj.base.util;

import androidx.annotation.NonNull;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f16569a = "AES/ECB/PKCS5Padding";

    /* renamed from: b, reason: collision with root package name */
    private static int f16570b = 24;

    public static String a(String str, @NonNull String str2) throws Exception {
        try {
            int length = str2.length();
            if (length != 16 && length != 24 && length != 32) {
                com.orhanobut.logger.j.c("长度必须为16/24/32");
                return null;
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), "AES");
            Cipher cipher = Cipher.getInstance(f16569a);
            cipher.init(2, secretKeySpec);
            try {
                return new String(cipher.doFinal(cn.bluemobi.dylan.base.utils.b.a(str)), "utf-8");
            } catch (Exception e6) {
                com.orhanobut.logger.j.c(e6.toString());
                return null;
            }
        } catch (Exception e7) {
            com.orhanobut.logger.j.c(e7.toString());
            return null;
        }
    }

    public static String c(int i6) {
        if (i6 != 16 && i6 != 24 && i6 != 32) {
            com.orhanobut.logger.j.c("长度必须为16/24/32");
            return null;
        }
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < i6; i7++) {
            sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(62)));
        }
        return sb.toString();
    }

    public static void d(String[] strArr) {
        String c6 = c(f16570b);
        com.orhanobut.logger.j.c("随机生成的key：" + c6);
        try {
            String b6 = b("{'fig':1,'message':'登录成功'}", c6);
            com.orhanobut.logger.j.c("加密后的数据：" + b6);
            com.orhanobut.logger.j.c("解密后的数据：" + a(b6, c6));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static String b(String str, @NonNull String str2) throws Exception {
        int length = str2.length();
        if (length != 16 && length != 24 && length != 32) {
            com.orhanobut.logger.j.c("长度必须为16/24/32");
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), "AES");
        Cipher cipher = Cipher.getInstance(f16569a);
        cipher.init(1, secretKeySpec);
        return cn.bluemobi.dylan.base.utils.b.b(cipher.doFinal(str.getBytes("utf-8")));
    }
}
