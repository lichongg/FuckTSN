package cn.jiguang.bv;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bv.c;
import cn.jiguang.bv.d;
import cn.jiguang.bz.j;
import cn.jiguang.bz.w;
import cn.jiguang.bz.y;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2580a;

    public c.a a(String str, String str2, String str3) {
        cn.jiguang.bw.a a6 = cn.jiguang.bw.a.a();
        a6.h(3070);
        cn.jiguang.bb.f.c("JSM", "s d: " + str);
        String str4 = "Download with version " + str2;
        for (int i6 = 1; i6 <= 3; i6++) {
            try {
                return b(str, str2, str3);
            } catch (Exception e6) {
                cn.jiguang.bb.f.i("JSM", String.format("%s %d/%d f: %s", str4, Integer.valueOf(i6), 3, e6.getMessage()));
                if (i6 < 3) {
                    d.a(1000L);
                }
            }
        }
        a6.h(3075);
        cn.jiguang.bb.f.l("JSM", String.format("%s f after %d", str4, 3));
        return new c.a(false, null, null);
    }

    private c.a a(HttpURLConnection httpURLConnection, String str) {
        cn.jiguang.bw.a a6 = cn.jiguang.bw.a.a();
        InputStream inputStream = httpURLConnection.getInputStream();
        if (inputStream == null) {
            a6.h(3096);
            throw new IOException("Input stream is null");
        }
        try {
            byte[] a7 = d.a(inputStream, d.b(httpURLConnection.getContentLength()));
            if (a7.length == 0) {
                a6.h(3095);
                throw new IOException("File size exceeds maximum allowed size");
            }
            String c6 = w.c(a7);
            if (!TextUtils.equals(c6, str)) {
                a6.h(3086);
                cn.jiguang.bb.f.l("JSM", "m f: " + str + " vs " + c6);
                throw new RuntimeException("MD5 validation failed");
            }
            a6.h(3087);
            cn.jiguang.bb.f.c("JSM", "m ok");
            try {
                byte[] b6 = y.b(a7);
                a6.h(3089);
                String a8 = f.a(b6);
                if (a8 != null) {
                    cn.jiguang.bb.f.c("JSM", "v info: " + a8);
                }
                return new c.a(true, a8, b6);
            } catch (Exception e6) {
                a6.h(3088);
                cn.jiguang.bb.f.l("JSM", "decompress err: " + e6.getMessage());
                throw e6;
            }
        } catch (IOException e7) {
            a6.h(3097);
            throw e7;
        }
    }

    public b(Context context) {
        this.f2580a = context;
    }

    private c.a b(String str, String str2, String str3) {
        String str4;
        cn.jiguang.bw.a a6 = cn.jiguang.bw.a.a();
        HttpURLConnection httpURLConnection = null;
        try {
            d.a a7 = d.a(str, "GET", str3);
            HttpURLConnection httpURLConnection2 = a7.f2601a;
            try {
                a(httpURLConnection2);
                c.a a8 = a(httpURLConnection2, a7.f2602b);
                a(str2, a8.f2591c);
                if (str3 == null && (str4 = a7.f2602b) != null) {
                    d.b(str4);
                    cn.jiguang.bb.f.c("JSM", "c m: " + a7.f2602b);
                }
                a6.h(3072);
                a8.f2591c = null;
                cn.jiguang.bb.f.l("JSM", "download so success");
                d.b(httpURLConnection2);
                return a8;
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                try {
                    throw th;
                } catch (Throwable th2) {
                    d.b(httpURLConnection);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public String a(String str) {
        HttpURLConnection httpURLConnection;
        d.a a6;
        String str2;
        cn.jiguang.bw.a a7 = cn.jiguang.bw.a.a();
        a7.h(3077);
        HttpURLConnection httpURLConnection2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i6 = 1; i6 <= 3; i6++) {
            try {
                a6 = d.a(str, "HEAD", (String) null);
                httpURLConnection = a6.f2601a;
            } catch (Exception e6) {
                e = e6;
                httpURLConnection = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    str2 = a6.f2602b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("m check: ");
                    sb.append(str2 != null ? "has value" : "none");
                    cn.jiguang.bb.f.c("JSM", sb.toString());
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    d.b(httpURLConnection2);
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                cn.jiguang.bb.f.i("JSM", String.format("%s %d/%d f: %s", "Pre-check MD5", Integer.valueOf(i6), 3, e.getMessage()));
                if (i6 < 3) {
                    d.a(1000L);
                }
                d.b(httpURLConnection);
            }
            if (!TextUtils.isEmpty(str2)) {
                a7.h(3078);
                d.b(str2);
                d.b(httpURLConnection);
                return str2;
            }
            a7.h(3079);
            d.b(httpURLConnection);
        }
        cn.jiguang.bw.a.a().h(3080);
        cn.jiguang.bb.f.l("JSM", String.format("%s f after %d", "Pre-check MD5", 3));
        return null;
    }

    private void a(String str, byte[] bArr) {
        cn.jiguang.bw.a a6 = cn.jiguang.bw.a.a();
        if (bArr == null || bArr.length == 0) {
            a6.h(3090);
            throw new IOException("Downloaded data is null or empty");
        }
        if (!a(bArr)) {
            a6.h(3091);
            cn.jiguang.bb.f.l("JSM", "d invalid");
            throw new IOException("Downloaded data validation failed");
        }
        String c6 = w.c(bArr);
        if (!j.a(new File(a.a(this.f2580a, str)), bArr)) {
            a6.h(3092);
            throw new IOException("Failed to save file atomically");
        }
        if (!a(str, bArr.length, c6)) {
            a6.h(3094);
            throw new IOException("Saved file integrity verification failed");
        }
        a6.h(3093);
        cn.jiguang.bb.f.c("JSM", "s ok:  " + bArr.length);
        if (TextUtils.isEmpty(c6)) {
            return;
        }
        d.c(c6);
        cn.jiguang.bb.f.c("JSM", "c m: " + c6);
    }

    private void a(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            return;
        }
        cn.jiguang.bw.a.a().h(3085);
        throw new IOException("Download failed with response code: " + responseCode);
    }

    private boolean a(String str, long j6, String str2) {
        try {
            String a6 = a.a(this.f2580a, str);
            File file = new File(a6);
            if (file.exists() && file.length() == j6) {
                if (TextUtils.equals(j.g(a6), str2)) {
                    return true;
                }
                cn.jiguang.bb.f.l("JSM", "s verify f");
                return false;
            }
            cn.jiguang.bb.f.l("JSM", "s mismatch");
            return false;
        } catch (Exception e6) {
            cn.jiguang.bb.f.l("JSM", "s verify err: " + e6.getMessage());
            return false;
        }
    }

    private boolean a(byte[] bArr) {
        return bArr != null && bArr.length >= 4 && bArr[0] == Byte.MAX_VALUE && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70;
    }
}
