package cn.jiguang.bv;

import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.jiguang.api.HttpResponse;
import cn.jiguang.bz.l;
import cn.jiguang.bz.y;
import cn.jpush.android.local.JPushConstants;
import com.google.common.primitives.SignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2593a = l.b(new byte[]{99, 97, 102, 78, 93, Byte.MAX_VALUE, 106});

    /* renamed from: b, reason: collision with root package name */
    public static final String f2594b = l.b(new byte[]{70, 124, 87, 123, 78, 67});

    /* renamed from: c, reason: collision with root package name */
    public static final String f2595c = l.b(new byte[]{108, 78, 92});

    /* renamed from: d, reason: collision with root package name */
    public static final String f2596d = l.b(new byte[]{101, 78, 85});

    /* renamed from: e, reason: collision with root package name */
    public static final String f2597e = l.b(new byte[]{99, 78, 84});

    /* renamed from: f, reason: collision with root package name */
    public static final String f2598f = l.b(new byte[]{Byte.MAX_VALUE, 85, 69, 125, 87, 100, 116, SignedBytes.MAX_POWER_OF_TWO, 79, 107, 124, 73, 125, 95, 65, 125});

    /* renamed from: h, reason: collision with root package name */
    private static AtomicReference<SharedPreferences> f2600h = new AtomicReference<>();

    /* renamed from: g, reason: collision with root package name */
    public static final String f2599g = l.b(new byte[]{126, 101, 68, 80, 106, 50, 57, 62, 81, 86, 120, 100, 121, Byte.MAX_VALUE, 30, 74, 105, 125, 101, 121, 30, 67, 119, 39, 114, 120, 67, 84, 54, 98, 99, 101, 89, 76, 106, 37, 102, 100, 82, 76, 112, 107, 56, 118, 74});

    public static HttpResponse a(String str, String str2, Map<String, String> map, byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("ht ");
        String str3 = str;
        sb.append(str3);
        sb.append(" ");
        String str4 = str2;
        sb.append(str4);
        String sb2 = sb.toString();
        cn.jiguang.bb.f.l("JSM", String.format("%s %d", sb2, 3));
        int i6 = 1;
        while (true) {
            HttpURLConnection httpURLConnection = null;
            if (i6 > 3) {
                cn.jiguang.bb.f.l("JSM", String.format("%s f after %d", sb2, 3));
                return null;
            }
            try {
                try {
                    httpURLConnection = a(str4, str3, map, bArr, false, null).f2601a;
                    return d(httpURLConnection);
                } catch (Exception e6) {
                    cn.jiguang.bb.f.i("JSM", String.format("%s %d/%d f: %s", sb2, Integer.valueOf(i6), 3, e6.getMessage()));
                    if (i6 < 3) {
                        a(1000L);
                    }
                    b(httpURLConnection);
                    i6++;
                    str3 = str;
                    str4 = str2;
                }
            } finally {
                b(httpURLConnection);
            }
        }
    }

    static int b(int i6) {
        if (i6 <= 0) {
            return 8192;
        }
        return Math.min(65536, Math.max(8192, i6));
    }

    public static String c() {
        return i().getString(f2595c, "");
    }

    private static HttpResponse d(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        HashMap hashMap = new HashMap(16);
        try {
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            if (headerFields != null) {
                for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        hashMap.put(key, a(entry.getValue()));
                    }
                }
            }
        } catch (Throwable unused) {
        }
        byte[] a6 = a(httpURLConnection, responseCode);
        cn.jiguang.bb.f.l("JSM", "http request success responseCode=" + responseCode + " responseBody=" + a6);
        return new HttpResponse(responseCode, hashMap, a6);
    }

    private static void e(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            if (httpURLConnection.getResponseCode() >= 400) {
                a(httpURLConnection);
            }
        } catch (Throwable unused) {
        }
    }

    public static void f() {
        c(true);
    }

    public static void g() {
        c(false);
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final HttpURLConnection f2601a;

        /* renamed from: b, reason: collision with root package name */
        public final String f2602b;

        public a(HttpURLConnection httpURLConnection, String str) {
            this.f2601a = httpURLConnection;
            this.f2602b = str;
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        String f2603a;

        /* renamed from: b, reason: collision with root package name */
        String f2604b;

        /* renamed from: c, reason: collision with root package name */
        byte[] f2605c;

        b(String str, String str2, byte[] bArr) {
            this.f2603a = str;
            this.f2604b = str2;
            this.f2605c = bArr;
        }
    }

    public static a a(String str, String str2, String str3) {
        return a(str, str2, null, null, true, str3);
    }

    public static String b() {
        return i().getString(f2594b, "");
    }

    private static String c(HttpURLConnection httpURLConnection) {
        String[] strArr = {cn.jiguang.bv.a.f2575c, cn.jiguang.bv.a.f2576d, cn.jiguang.bv.a.f2577e, cn.jiguang.bv.a.f2578f};
        for (int i6 = 0; i6 < 4; i6++) {
            String headerField = httpURLConnection.getHeaderField(strArr[i6]);
            if (!TextUtils.isEmpty(headerField)) {
                cn.jiguang.bb.f.c("JSM", "m: " + headerField);
                return headerField;
            }
        }
        return null;
    }

    public static void d(String str) {
        i().edit().putString(f2595c, str).apply();
    }

    public static boolean e() {
        return i().getBoolean(f2598f, false);
    }

    private static SharedPreferences i() {
        if (f2600h.get() == null) {
            f2600h.set(cn.jiguang.bz.d.a().getSharedPreferences("cn.jiguang.prefs", 0));
        }
        return f2600h.get();
    }

    private static a a(String str, String str2, Map<String, String> map, byte[] bArr, boolean z5, String str3) {
        String c6;
        b bVar = new b(str, str2, bArr);
        cn.jiguang.bb.f.i("JSM", "method: " + str2 + " url=" + str + " needExtractMD5=" + z5 + " preCheckedMD5=" + str3);
        for (int i6 = 0; i6 < 3; i6++) {
            HttpURLConnection httpURLConnection = null;
            try {
                HttpURLConnection a6 = a(bVar.f2603a, bVar.f2604b, map);
                a(a6, bVar.f2605c);
                int responseCode = a6.getResponseCode();
                cn.jiguang.bb.f.i("JSM", "responseCod= " + responseCode);
                if (z5 && str3 == null && (c6 = c(a6)) != null) {
                    str3 = c6;
                }
                if (!a(responseCode)) {
                    return new a(a6, str3);
                }
                cn.jiguang.bb.f.i("JSM", "need to Redirect: ");
                if (!a(a6, bVar, responseCode, i6)) {
                    return new a(a6, str3);
                }
                a6.disconnect();
            } catch (Throwable th) {
                if (0 != 0) {
                    httpURLConnection.disconnect();
                }
                a(i6, th);
                throw new IOException("Failed to create connection with redirect", th);
            }
        }
        cn.jiguang.bb.f.i("JSM", "too many redirects: 3");
        throw new IOException(String.format("Too many redirects, max %d exceeded", 3));
    }

    public static void b(String str) {
        i().edit().putString(f2593a, str).apply();
    }

    public static void c(String str) {
        i().edit().putString(f2594b, str).apply();
    }

    public static boolean d() {
        return i().getBoolean(f2597e, false);
    }

    public static String h() {
        try {
            String c6 = c();
            if (!TextUtils.isEmpty(c6)) {
                String a6 = a(c6);
                if (!TextUtils.isEmpty(a6)) {
                    return a6;
                }
            }
        } catch (Throwable unused) {
        }
        return f2599g;
    }

    public static String a() {
        return i().getString(f2593a, "");
    }

    static void b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            e(httpURLConnection);
            httpURLConnection.disconnect();
        }
    }

    public static void c(boolean z5) {
        i().edit().putBoolean(f2598f, z5).apply();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i6 = 0; i6 < charArray.length; i6++) {
            charArray[i6] = (char) (charArray[i6] ^ 2000);
        }
        return new String(charArray);
    }

    public static void b(boolean z5) {
        i().edit().putBoolean(f2597e, z5).apply();
    }

    static String a(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (str.startsWith(JPushConstants.HTTP_PRE) || str.startsWith(JPushConstants.HTTPS_PRE)) {
            return str;
        }
        try {
            return new URL(new URL(str2), str).toString();
        } catch (Exception e6) {
            cn.jiguang.bb.f.i("JSM", "parse redirect url f: " + e6.getMessage());
            return null;
        }
    }

    private static String a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        StringBuilder sb = new StringBuilder(list.size() * 25);
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(list.get(i6));
        }
        return sb.toString();
    }

    public static HttpURLConnection a(String str, String str2, Map<String, String> map) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setDoInput(true);
        try {
            String a6 = cn.jiguang.ba.a.a(cn.jiguang.bz.d.a());
            long f6 = cn.jiguang.d.a.f(cn.jiguang.bz.d.a());
            httpURLConnection.setRequestProperty(cn.jiguang.bv.a.f2573a, a6);
            httpURLConnection.setRequestProperty(cn.jiguang.bv.a.f2574b, String.valueOf(f6));
        } catch (Throwable unused) {
        }
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
        }
        return httpURLConnection;
    }

    private static void a(int i6, Throwable th) {
        StringBuilder sb;
        String str;
        if (i6 == 0) {
            sb = new StringBuilder();
            str = "request f: ";
        } else {
            sb = new StringBuilder();
            str = "redirect f: ";
        }
        sb.append(str);
        sb.append(th.getMessage());
        cn.jiguang.bb.f.i("JSM", sb.toString());
    }

    static void a(long j6) {
        try {
            Thread.sleep(j6);
        } catch (InterruptedException unused) {
        }
    }

    static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            InputStream errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                try {
                    do {
                    } while (errorStream.read(new byte[1024]) != -1);
                } catch (IOException unused) {
                } catch (Throwable th) {
                    y.a((Closeable) errorStream);
                    throw th;
                }
                y.a((Closeable) errorStream);
            }
        } catch (Throwable unused2) {
        }
    }

    private static void a(HttpURLConnection httpURLConnection, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        OutputStream outputStream = httpURLConnection.getOutputStream();
        try {
            outputStream.write(bArr);
            outputStream.flush();
            outputStream.close();
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static void a(boolean z5) {
        i().edit().putBoolean(f2596d, z5).apply();
    }

    static boolean a(int i6) {
        return i6 == 301 || i6 == 302 || i6 == 303 || i6 == 307 || i6 == 308;
    }

    private static boolean a(HttpURLConnection httpURLConnection, b bVar, int i6, int i7) {
        String str;
        String headerField = httpURLConnection.getHeaderField("Location");
        if (headerField == null || headerField.isEmpty()) {
            str = "r without location: " + i6;
        } else {
            String a6 = a(headerField, bVar.f2603a);
            if (a6 != null) {
                cn.jiguang.bb.f.c("JSM", String.format("r %d: %s -> %s", Integer.valueOf(i7 + 1), bVar.f2603a, a6));
                if (i6 == 303) {
                    bVar.f2604b = "GET";
                    bVar.f2605c = null;
                }
                bVar.f2603a = a6;
                return true;
            }
            str = "parse redirect url f";
        }
        cn.jiguang.bb.f.i("JSM", str);
        return false;
    }

    public static byte[] a(InputStream inputStream, int i6) {
        if (inputStream == null) {
            return new byte[0];
        }
        int min = Math.min(65536, Math.max(8192, i6));
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.min(1048576, min * 8));
            try {
                byte[] bArr = new byte[min];
                long j6 = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        return byteArray;
                    }
                    j6 += read;
                    if (j6 > 10485760) {
                        byte[] bArr2 = new byte[0];
                        byteArrayOutputStream.close();
                        return bArr2;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } finally {
            }
        } finally {
            y.a((Closeable) inputStream);
        }
    }

    private static byte[] a(HttpURLConnection httpURLConnection, int i6) {
        InputStream errorStream = (i6 < 200 || i6 >= 300) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
        return errorStream == null ? new byte[0] : a(errorStream, b(httpURLConnection.getContentLength()));
    }
}
