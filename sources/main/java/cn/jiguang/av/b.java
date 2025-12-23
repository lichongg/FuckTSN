package cn.jiguang.av;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.az.g;
import cn.jiguang.az.j;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1778a = cn.jiguang.ax.a.b(new byte[]{87, 84, 99});

    /* renamed from: b, reason: collision with root package name */
    private static final String f1779b = cn.jiguang.ax.a.b(new byte[]{73, 83, 66, Ascii.US, 99, 91, 75, 57, 65, 123, 99, 74, 61, 70, 112, 84, 68, 112, 102, 113});

    public static File a(Context context, File file, int i6, int i7, String str) {
        try {
            String d6 = j.d(g.a(context));
            if (TextUtils.isEmpty(d6)) {
                a(context, i6, i7, "process name to md5 failed");
                return null;
            }
            String d7 = j.d(d6 + file.getName());
            if (TextUtils.isEmpty(d7)) {
                a(context, i6, i7, "process + fileName to md5 failed");
                return null;
            }
            File file2 = new File(file.getParentFile(), d6 + File.separator + d7 + ".d");
            if (file2.exists()) {
                file2.delete();
            }
            file2.getParentFile().mkdirs();
            file2.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[32];
                    if (fileInputStream.read(bArr) != 32) {
                        a(context, i6, i7, "failed to read MD5 bytes");
                    } else {
                        Charset charset = StandardCharsets.UTF_8;
                        String str2 = new String(bArr, charset);
                        cn.jiguang.ay.b.b("PIU", "Read MD5: " + str2);
                        Cipher cipher = Cipher.getInstance(f1779b);
                        cipher.init(2, new SecretKeySpec(str2.getBytes(charset), f1778a), new IvParameterSpec(str.getBytes(charset)));
                        CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, cipher);
                        try {
                            byte[] bArr2 = new byte[8192];
                            while (true) {
                                int read = fileInputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                cipherOutputStream.write(bArr2, 0, read);
                            }
                            cipherOutputStream.flush();
                            cipherOutputStream.close();
                            String a6 = cn.jiguang.az.c.a(file2.getAbsolutePath());
                            cn.jiguang.ay.b.b("PIU", "Calculated file hash: " + a6);
                            if (str2.equals(a6)) {
                                cn.jiguang.ay.b.b("PIU", "Decryption successful");
                                if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                                    file2.setReadOnly();
                                }
                                fileInputStream.close();
                                fileOutputStream.close();
                                return file2;
                            }
                            a(context, i6, i7, "file MD5 not match");
                        } finally {
                        }
                    }
                    fileInputStream.close();
                    fileOutputStream.close();
                    return null;
                } finally {
                }
            } finally {
            }
        } catch (Exception e6) {
            cn.jiguang.ay.b.e("PIU", "Decode failed: " + e6.getMessage());
            a(context, i6, i7, "decode failed " + e6.getMessage());
            return null;
        }
    }

    public static File a(Context context, String str, int i6, int i7) {
        return new File(context.getFilesDir() + File.separator + ".p", a(str, i6 + "", i7));
    }

    public static File b(Context context, String str, int i6, int i7) {
        if (context == null) {
            return null;
        }
        String a6 = a(str, i6 + "", i7);
        File file = new File(context.getFilesDir() + File.separator + ".p", a6 + "o");
        cn.jiguang.ay.b.b("PIU", "getLibPath mkdirs:" + file.mkdirs());
        return file;
    }

    public static File c(Context context, String str, int i6, int i7) {
        String a6 = a(str, i6 + "", i7);
        File file = new File(context.getFilesDir() + File.separator + ".p", a6 + "ox");
        cn.jiguang.ay.b.b("PIU", "getOptimizedDexPath mkdirs:" + file.mkdirs());
        return file;
    }

    private static String a(String str, String str2, int i6) {
        if (TextUtils.isEmpty(str)) {
            str = str2 + i6;
        }
        return "." + str;
    }

    private static void a(Context context, int i6, int i7, String str) {
        cn.jiguang.ay.b.g("PIU", str);
        cn.jiguang.dy.c.a().a(context, i6, i7, cn.jiguang.aw.a.f1793d, 2, str);
    }

    public static boolean a(File file, cn.jiguang.aw.c cVar, boolean z5) {
        if (!file.exists() || !file.canRead()) {
            cn.jiguang.ay.b.b("PIU", "p :" + file.getAbsolutePath() + " not.");
            return false;
        }
        if (!z5) {
            return true;
        }
        if (TextUtils.isEmpty(cVar.f1831s)) {
            cn.jiguang.ay.b.g("PIU", "p M error.");
            return false;
        }
        String a6 = cn.jiguang.az.c.a(file.getAbsolutePath());
        if (TextUtils.isEmpty(a6)) {
            cn.jiguang.ay.b.g("PIU", "g p M f.");
            return false;
        }
        if (cVar.f1831s.equalsIgnoreCase(a6)) {
            return true;
        }
        file.delete();
        cn.jiguang.ay.b.g("PIU", "p M not m, c m: " + cVar.f1831s + ", b f m:" + a6);
        return false;
    }
}
