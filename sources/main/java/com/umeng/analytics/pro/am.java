package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class am {

    /* renamed from: a, reason: collision with root package name */
    private static HostnameVerifier f40865a;

    private static HostnameVerifier a() {
        if (f40865a == null) {
            f40865a = new HostnameVerifier() { // from class: com.umeng.analytics.pro.am.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    if (!TextUtils.isEmpty(str)) {
                        if ("pre-ucc.umeng.com".equalsIgnoreCase(str) || "ucc.umeng.com".equalsIgnoreCase(str) || "aspect-upush.umeng.com".equalsIgnoreCase(str) || "pre-msg.umengcloud.com".equalsIgnoreCase(str)) {
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
            };
        }
        return f40865a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        r0.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(java.lang.String r2, byte[] r3) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L32
            r1.<init>()     // Catch: java.lang.Throwable -> L32
            com.umeng.analytics.pro.at.a(r3, r1)     // Catch: java.lang.Throwable -> L18
            byte[] r3 = r1.toByteArray()     // Catch: java.lang.Throwable -> L18
            java.lang.String r1 = com.umeng.commonsdk.UMConfigure.sAppkey     // Catch: java.lang.Throwable -> L18
            byte[] r1 = r1.getBytes()     // Catch: java.lang.Throwable -> L18
            byte[] r3 = com.umeng.analytics.pro.at.a(r3, r1)     // Catch: java.lang.Throwable -> L18
            goto L19
        L18:
            r3 = r0
        L19:
            java.lang.String r1 = "appkey"
            javax.net.ssl.HttpsURLConnection r0 = a(r2, r1, r3)     // Catch: java.lang.Throwable -> L32
            if (r0 == 0) goto L34
            int r2 = r0.getResponseCode()     // Catch: java.lang.Throwable -> L32
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 == r3) goto L2a
            goto L34
        L2a:
            java.lang.String r2 = "MobclickRT"
            java.lang.String r3 = "SC event report successful."
            com.umeng.commonsdk.debug.UMRTLog.i(r2, r3)     // Catch: java.lang.Throwable -> L32
            goto L34
        L32:
            r2 = move-exception
            goto L3a
        L34:
            if (r0 == 0) goto L40
        L36:
            r0.disconnect()     // Catch: java.lang.Throwable -> L40
            goto L40
        L3a:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L40
            goto L36
        L40:
            return
        L41:
            r2 = move-exception
            if (r0 == 0) goto L47
            r0.disconnect()     // Catch: java.lang.Throwable -> L47
        L47:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.am.b(java.lang.String, byte[]):void");
    }

    public static byte[] a(String str, String str2) {
        return a(str, str2.getBytes());
    }

    public static byte[] a(String str, byte[] bArr) {
        byte[] bArr2 = null;
        try {
            HttpsURLConnection a6 = a(str, SocializeProtocolConstants.PROTOCOL_KEY_AK, at.a(bArr, UMConfigure.sAppkey.getBytes()));
            if (a6 != null && a6.getResponseCode() == 200) {
                InputStream inputStream = a6.getInputStream();
                try {
                    byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                    try {
                        String headerField = a6.getHeaderField(SocializeProtocolConstants.PROTOCOL_KEY_AK);
                        if (!TextUtils.isEmpty(headerField)) {
                            bArr2 = at.a(readStreamToByteArray, headerField.getBytes());
                        } else {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "ccg 应答不包含ak!");
                        }
                        HelperUtils.safeClose(inputStream);
                        return bArr2;
                    } catch (Throwable th) {
                        th = th;
                        HelperUtils.safeClose(inputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static HttpsURLConnection a(String str, String str2, byte[] bArr) {
        HttpsURLConnection httpsURLConnection = null;
        try {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
            try {
                SSLContext sSLContext = SSLContext.getInstance(org.apache.commons.net.imap.b.Q);
                sSLContext.init(null, null, new SecureRandom());
                httpsURLConnection2.setSSLSocketFactory(sSLContext.getSocketFactory());
                httpsURLConnection2.setHostnameVerifier(a());
                httpsURLConnection2.setRequestMethod("POST");
                httpsURLConnection2.setConnectTimeout(15000);
                httpsURLConnection2.setDoOutput(true);
                httpsURLConnection2.setDoInput(true);
                httpsURLConnection2.setReadTimeout(15000);
                httpsURLConnection2.addRequestProperty("Content-Type", "application/octet-stream");
                httpsURLConnection2.addRequestProperty(str2, UMConfigure.sAppkey);
                httpsURLConnection2.setRequestProperty("User-Agent", DeviceConfig.getCustomAgt());
                httpsURLConnection2.connect();
                OutputStream outputStream = httpsURLConnection2.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
                return httpsURLConnection2;
            } catch (Exception e6) {
                e = e6;
                httpsURLConnection = httpsURLConnection2;
                e.printStackTrace();
                return httpsURLConnection;
            }
        } catch (Exception e7) {
            e = e7;
        }
    }
}
