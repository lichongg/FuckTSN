package com.umeng.socialize.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f42211a = "NetClient";

    public static JSONObject a(JSONObject jSONObject, String str, String str2, boolean z5) throws Exception {
        char c6;
        char c7;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        URL url = new URL(str);
        try {
            c7 = 6;
            try {
                c6 = 5;
            } catch (Throwable th) {
                th = th;
                c6 = 5;
            }
        } catch (Throwable th2) {
            th = th2;
            c6 = 5;
            c7 = 6;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(a(jSONObject.toString(), (HttpURLConnection) url.openConnection(), str2));
            if (m.a() && (z5 || a.f42199c)) {
                m.a(f42211a, "req: ", url, com.snail.antifake.deviceid.e.f37542d, jSONObject, "\nresp:\n", jSONObject2, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            return jSONObject2;
        } catch (Throwable th3) {
            th = th3;
            if (m.a() && (z5 || a.f42199c)) {
                Long valueOf = Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime);
                Object[] objArr = new Object[8];
                objArr[0] = "req: ";
                objArr[1] = url;
                objArr[2] = com.snail.antifake.deviceid.e.f37542d;
                objArr[3] = jSONObject;
                objArr[4] = "\nresp:\n";
                objArr[c6] = null;
                objArr[c7] = "\nconsume:";
                objArr[7] = valueOf;
                m.a(f42211a, objArr);
            }
            throw th;
        }
    }

    private static String a(String str, HttpURLConnection httpURLConnection, String str2) throws Exception {
        OutputStream outputStream;
        InputStream inputStream;
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        l.a(str.getBytes(), byteArrayOutputStream);
        byte[] a6 = i.a(byteArrayOutputStream.toByteArray(), bytes);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setReadTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
        httpURLConnection.setConnectTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
        httpURLConnection.addRequestProperty("Content-Type", "application/octet-stream");
        httpURLConnection.addRequestProperty("Content-Encoding", "xgzip");
        httpURLConnection.addRequestProperty("appkey", str2);
        httpURLConnection.setFixedLengthStreamingMode(a6.length);
        httpURLConnection.setDoOutput(true);
        try {
            outputStream = httpURLConnection.getOutputStream();
        } catch (Throwable th) {
            th = th;
            outputStream = null;
        }
        try {
            outputStream.write(a6);
            c.a(outputStream);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 400) {
                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }
            byteArrayOutputStream.reset();
            if (inputStream != null) {
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } finally {
                        c.a(inputStream);
                    }
                }
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
            if (responseCode == 200 && TextUtils.equals("xgzip", httpURLConnection.getHeaderField("Content-Encoding"))) {
                byte[] a7 = i.a(byteArrayOutputStream.toByteArray(), bytes);
                byteArrayOutputStream.reset();
                l.b(a7, byteArrayOutputStream);
            }
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            if (responseCode == 200) {
                return byteArrayOutputStream2;
            }
            throw new IOException("code:" + responseCode + " msg:" + byteArrayOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(org.json.JSONObject r19, java.lang.String r20, java.lang.String r21) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.a.d.a(org.json.JSONObject, java.lang.String, java.lang.String):void");
    }
}
