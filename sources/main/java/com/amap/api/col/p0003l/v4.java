package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.by;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class v4 {
    public static String m() {
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod.setAccessible(true);
            String obj = declaredMethod.invoke(null, "net.hostname").toString();
            return (obj == null || obj.equalsIgnoreCase("")) ? obj : f(obj);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a() {
        String str;
        str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/sys/kernel/random/boot_id"));
            String readLine = bufferedReader.readLine();
            str = readLine != null ? readLine : "";
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    private static Date c(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i6 = 0; i6 < bArr.length; i6++) {
                bArr[i6] = (byte) ((bArr[i6] ^ bArr2[i6 % bArr2.length]) ^ (i6 & 255));
            }
        }
        return bArr;
    }

    public static String e() {
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %z /data/app").getInputStream()));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split("\\.");
                Date c6 = c(split[0]);
                String str2 = split[1];
                String trim = str2 != null ? str2.split("\\+")[0].trim() : "";
                if (TextUtils.isEmpty(trim)) {
                    str = String.valueOf(c6.getTime() / 1000);
                } else {
                    str = (c6.getTime() / 1000) + "." + g(trim);
                }
            }
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    private static String f(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b6 : digest) {
                stringBuffer.append(Integer.toHexString(b6 & 255));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String h() {
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %z /data/").getInputStream()));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split("\\.");
                Date c6 = c(split[0]);
                String str2 = split[1];
                String trim = str2 != null ? str2.split("\\+")[0].trim() : "";
                if (TextUtils.isEmpty(trim)) {
                    str = String.valueOf(c6.getTime() / 1000);
                } else {
                    str = (c6.getTime() / 1000) + "." + g(trim);
                }
            }
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    public static String i() {
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %x /data/data").getInputStream()));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split("\\.");
                Date c6 = c(split[0]);
                String str2 = split[1];
                String trim = str2 != null ? str2.split("\\+")[0].trim() : "";
                if (TextUtils.isEmpty(trim)) {
                    str = String.valueOf(c6.getTime() / 1000);
                } else {
                    str = (c6.getTime() / 1000) + "." + g(trim);
                }
            }
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    public static String j() {
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %x /data/app").getInputStream()));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split("\\.");
                Date c6 = c(split[0]);
                String str2 = split[1];
                String trim = str2 != null ? str2.split("\\+")[0].trim() : "";
                if (TextUtils.isEmpty(trim)) {
                    str = String.valueOf(c6.getTime() / 1000);
                } else {
                    str = (c6.getTime() / 1000) + "." + g(trim);
                }
            }
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    public static String k() {
        String str;
        str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %i /data/data").getInputStream()));
            String readLine = bufferedReader.readLine();
            str = readLine != null ? readLine : "";
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    public static String l() {
        String str;
        str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %i /data/app").getInputStream()));
            String readLine = bufferedReader.readLine();
            str = readLine != null ? readLine : "";
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    public static String b(Context context) {
        try {
            String a6 = r4.a(context);
            try {
                if (TextUtils.isEmpty(a6)) {
                    a6 = UUID.randomUUID().toString();
                    r4.c(context, a6);
                    return a6;
                }
                return a6;
            } catch (Throwable unused) {
                return a6;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    private static int g(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Integer.parseInt(str);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
