package com.bytedance.j.xt.ae;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.j.xt.a;
import com.bytedance.j.xt.e;
import com.bytedance.j.xt.tl.h;
import com.bytedance.j.xt.tl.i;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f24161a;

    /* renamed from: b, reason: collision with root package name */
    private static a.c f24162b;

    public static boolean h() {
        return true;
    }

    public static boolean l() {
        return true;
    }

    public enum j {
        NONE(0),
        GZIP(1),
        DEFLATER(2);


        /* renamed from: r, reason: collision with root package name */
        final int f24164r;

        j(int i6) {
            this.f24164r = i6;
        }
    }

    /* renamed from: com.bytedance.j.xt.ae.xt$xt, reason: collision with other inner class name */
    public enum EnumC0345xt {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);

        final int ae;

        EnumC0345xt(int i6) {
            this.ae = i6;
        }
    }

    private static a.e a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new a.e(203);
        }
        String str = new String(bArr, Charset.forName("utf-8"));
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.length() > 0 ? new a.e(0, jSONObject) : new a.e(204, str);
        } catch (JSONException unused) {
            return new a.e(204, str);
        }
    }

    public static a.e b(long j6, String str, byte[] bArr, j jVar, String str2, boolean z5) throws IOException {
        String str3;
        if (str == null) {
            return new a.e(201);
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        if (j.GZIP == jVar && length > 128) {
            bArr = m(bArr);
            str3 = "gzip";
        } else if (j.DEFLATER != jVar || length <= 128) {
            str3 = null;
        } else {
            bArr = j(bArr);
            str3 = "deflate";
        }
        String str4 = str3;
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return new a.e(202);
        }
        if (!z5) {
            return f(str, bArr2, str2, str4, "POST", true, false);
        }
        byte[] a6 = TTEncryptUtils.a(bArr2, bArr2.length);
        if (a6 != null) {
            if (TextUtils.isEmpty(new URL(str).getQuery())) {
                if (!str.endsWith("?")) {
                    str = str + "?";
                }
            } else if (!str.endsWith(ContainerUtils.FIELD_DELIMITER)) {
                str = str + ContainerUtils.FIELD_DELIMITER;
            }
            str = str + "encrypt=true";
            str2 = "application/octet-stream;tt-data=a";
            bArr2 = a6;
        }
        return f(str, bArr2, str2, str4, "POST", true, true);
    }

    public static a.e c(a.g gVar) {
        if (gVar == null) {
            return new a.e(201);
        }
        try {
            return b(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, gVar.b(), gVar.a(), j.GZIP, "application/json; charset=utf-8", gVar.g());
        } catch (Throwable th) {
            i.c(th);
            return new a.e(207, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.bytedance.j.xt.a.e f(java.lang.String r5, byte[] r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, boolean r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.j.xt.ae.xt.f(java.lang.String, byte[], java.lang.String, java.lang.String, java.lang.String, boolean, boolean):com.bytedance.j.xt.a$e");
    }

    private static byte[] i(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    h.a(byteArrayOutputStream);
                }
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static byte[] j(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] m(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                i.c(th);
                gZIPOutputStream.close();
                return null;
            } catch (Throwable th2) {
                gZIPOutputStream.close();
                throw th2;
            }
        }
    }

    public static a.e d(String str, String str2) {
        return e(str, str2, h());
    }

    public static a.e e(String str, String str2, boolean z5) {
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                return b(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, str, str2.getBytes(), j.GZIP, "application/json; charset=utf-8", z5);
            }
            return new a.e(201);
        } catch (Throwable th) {
            i.c(th);
            return new a.e(207, th);
        }
    }

    public static String g(Map map) {
        return e.k().f();
    }

    public static String k(Map map) {
        return e.k().a();
    }
}
