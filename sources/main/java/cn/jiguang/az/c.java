package cn.jiguang.az;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f1843a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(Context context) {
        return context.getFilesDir() + File.separator + "p_an";
    }

    public static String a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getFilesDir());
            String str2 = File.separator;
            sb.append(str2);
            sb.append("p_an");
            sb.append(str2);
            sb.append(str);
            return a(new File(sb.toString()));
        } catch (Throwable th) {
            cn.jiguang.ay.b.g("FU", "[readFromFileDir] error:" + th.getMessage());
            return null;
        }
    }

    public static String a(File file) {
        if (!file.exists()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        bufferedReader.close();
                        return sb.toString().trim();
                    }
                    sb.append(readLine);
                    sb.append(System.lineSeparator());
                } finally {
                }
            }
        } catch (IOException e6) {
            cn.jiguang.ay.b.g("FU", "[readFile] error: " + e6.getMessage());
            return null;
        }
    }

    public static String a(String str) {
        String str2;
        String str3 = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                File file = new File(str);
                if (file.exists()) {
                    str2 = str + "---- f exists = true, length = " + file.length();
                } else {
                    str2 = str + "---- f exists = false";
                }
                cn.jiguang.ay.b.b("FU", str2);
                MessageDigest messageDigest = MessageDigest.getInstance(i.f1869c);
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                str3 = a(messageDigest.digest());
                fileInputStream.close();
            } finally {
            }
        } catch (Exception unused) {
        }
        cn.jiguang.ay.b.b("FU", str + "---- MD5 = " + str3);
        return str3;
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i6 = 0; i6 < bArr.length; i6++) {
            char[] cArr = f1843a;
            sb.append(cArr[(bArr[i6] & 240) >>> 4]);
            sb.append(cArr[bArr[i6] & 15]);
        }
        return sb.toString();
    }

    public static void a(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getFilesDir());
            String str3 = File.separator;
            sb.append(str3);
            sb.append("p_an");
            sb.append(str3);
            sb.append(str);
            a(new File(sb.toString()), str2);
        } catch (Throwable th) {
            cn.jiguang.ay.b.g("FU", "saveToFileDir error:" + th.getMessage());
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(File file, String str) {
        BufferedWriter bufferedWriter = null;
        try {
            if (file.exists() && TextUtils.isEmpty(str)) {
                file.delete();
                return;
            }
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            try {
                bufferedWriter2.write(str);
                bufferedWriter2.flush();
                a(bufferedWriter2);
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                try {
                    cn.jiguang.ay.b.g("FU", "[saveToFile] error:" + th.getMessage());
                } finally {
                    a(bufferedWriter);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
