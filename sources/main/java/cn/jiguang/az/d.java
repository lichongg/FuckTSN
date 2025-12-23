package cn.jiguang.az;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final SimpleDateFormat f1844a = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);

    private static File a(String str, byte[] bArr) {
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
            return file;
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String a(Context context, String str, int i6, String str2) {
        try {
            boolean b6 = f.b(context);
            cn.jiguang.ay.b.e("HttpUtils", " https sdk continueBusiness=" + b6);
            if (!b6) {
                cn.jiguang.ay.b.e("HttpUtils", " https sdk limit");
                return null;
            }
            HttpURLConnection a6 = a(str);
            a6.setRequestProperty("Content-Type", "application/json");
            a6.setConnectTimeout(i6);
            a6.setReadTimeout(i6);
            a6.setRequestMethod("POST");
            a6.setDoOutput(true);
            a6.setDoInput(true);
            a6.getOutputStream().write(str2.getBytes());
            int responseCode = a6.getResponseCode();
            byte[] a7 = a(a6.getInputStream());
            f.a(context, str, r8.length, a7 != null ? a7.length : 0);
            cn.jiguang.ay.b.e("HttpUtils", "httpPost:" + str + " responseCode:" + responseCode);
            if (200 == responseCode && a7 != null) {
                return new String(a7, "UTF-8");
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.ay.b.a("HttpUtils", "httpPost:" + str + " fail.", th);
            return null;
        }
    }

    public static File b(Context context, String str, int i6, String str2) {
        try {
            boolean b6 = f.b(context);
            cn.jiguang.ay.b.e("HttpUtils", " https download continueBusiness=" + b6);
            if (!b6) {
                cn.jiguang.ay.b.e("HttpUtils", " https sdk limit");
                return null;
            }
            HttpURLConnection a6 = a(str);
            a6.setConnectTimeout(i6);
            a6.setReadTimeout(i6);
            int responseCode = a6.getResponseCode();
            byte[] a7 = a(a6.getInputStream());
            f.a(context, str, 0L, a7 != null ? a7.length : 0);
            cn.jiguang.ay.b.e("HttpUtils", "download:" + str + " responseCode:" + responseCode);
            if (200 != responseCode) {
                return null;
            }
            return a(str2, a7);
        } catch (Throwable th) {
            cn.jiguang.ay.b.a("HttpUtils", "download:" + str + " fail." + th.getMessage(), th);
            return null;
        }
    }

    public static HttpURLConnection a(String str) {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    inputStream.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                cn.jiguang.ay.b.a("HttpUtils", " readInputStream failed , error is : " + th.getMessage());
                return null;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
            }
        }
    }
}
