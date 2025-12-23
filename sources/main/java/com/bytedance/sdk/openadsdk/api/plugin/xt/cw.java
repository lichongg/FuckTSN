package com.bytedance.sdk.openadsdk.api.plugin.xt;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bytedance.sdk.openadsdk.api.m;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.commons.net.imap.b;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.xt.cw$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class j {

        /* renamed from: j, reason: collision with root package name */
        private static final cw f27597j = new cw(null);
    }

    /* synthetic */ cw(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static cw j() {
        return j.f27597j;
    }

    private cw() {
    }

    public void j(String str, String str2, String str3, EventListener eventListener) {
        r rVar;
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                URL url = new URL(str);
                HttpsURLConnection.setDefaultSSLSocketFactory(j(xt()));
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                try {
                    httpsURLConnection2.setConnectTimeout(5000);
                    httpsURLConnection2.setHostnameVerifier(com.bytedance.sdk.openadsdk.api.plugin.xt.j.f27598j);
                    httpsURLConnection2.setRequestMethod("GET");
                    if (httpsURLConnection2.getResponseCode() == 200 && j(httpsURLConnection2.getInputStream(), str2, str3, eventListener)) {
                        eventListener.onEvent(0, new r(str2 + "/" + str3));
                    }
                    try {
                        httpsURLConnection2.disconnect();
                    } catch (Exception e6) {
                        rVar = new r(e6.getMessage());
                        eventListener.onEvent(2, rVar);
                    }
                } catch (Exception e7) {
                    e = e7;
                    httpsURLConnection = httpsURLConnection2;
                    m.j(e);
                    eventListener.onEvent(1, new r(e.getMessage()));
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.disconnect();
                        } catch (Exception e8) {
                            rVar = new r(e8.getMessage());
                            eventListener.onEvent(2, rVar);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    httpsURLConnection = httpsURLConnection2;
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.disconnect();
                        } catch (Exception e9) {
                            eventListener.onEvent(2, new r(e9.getMessage()));
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e10) {
            e = e10;
        }
    }

    private X509TrustManager xt() throws IOException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e6) {
            throw new IOException("No System TLS", e6);
        }
    }

    public boolean j(InputStream inputStream, String str, String str2, EventListener eventListener) {
        if (inputStream == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists() && !file.mkdirs()) {
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, str2));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            inputStream.close();
                            try {
                                inputStream.close();
                                return true;
                            } catch (Exception unused2) {
                                return true;
                            }
                        }
                    }
                } catch (Exception e6) {
                    e = e6;
                    fileOutputStream = fileOutputStream2;
                    eventListener.onEvent(3, new r(e.getMessage()));
                    m.xt("NetApi", "save error: ", e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    try {
                        inputStream.close();
                    } catch (Exception unused4) {
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                    try {
                        inputStream.close();
                        throw th;
                    } catch (Exception unused6) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e7) {
            e = e7;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
    
        if (r5 == null) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String j(boolean r4, java.lang.String r5, byte[] r6) {
        /*
            r3 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            javax.net.ssl.X509TrustManager r5 = r3.xt()     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            javax.net.ssl.SSLSocketFactory r5 = r3.j(r5)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(r5)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            java.net.URLConnection r5 = r1.openConnection()     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            r1 = 5000(0x1388, float:7.006E-42)
            r5.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            com.bytedance.sdk.openadsdk.api.plugin.xt.j r1 = com.bytedance.sdk.openadsdk.api.plugin.xt.j.f27598j     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r5.setHostnameVerifier(r1)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            if (r4 == 0) goto L4d
            if (r6 == 0) goto L4d
            int r4 = r6.length     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            if (r4 == 0) goto L4d
            r4 = 1
            r5.setDoOutput(r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            int r4 = r6.length     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r5.setFixedLengthStreamingMode(r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            java.io.OutputStream r1 = r5.getOutputStream()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r4.write(r6)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r4.flush()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r4.close()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            java.lang.String r4 = "POST"
            r5.setRequestMethod(r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            goto L52
        L48:
            r4 = move-exception
            r0 = r5
            goto L8c
        L4b:
            r4 = move-exception
            goto L85
        L4d:
            java.lang.String r4 = "GET"
            r5.setRequestMethod(r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
        L52:
            int r4 = r5.getResponseCode()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r6 = 200(0xc8, float:2.8E-43)
            if (r4 < r6) goto L7d
            r6 = 300(0x12c, float:4.2E-43)
            if (r4 >= r6) goto L7d
            java.lang.String r4 = "Content-Type"
            java.lang.String r4 = r5.getHeaderField(r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            java.lang.String r6 = "utf-8"
            java.lang.String r4 = j(r4, r6)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            java.io.InputStream r1 = r5.getInputStream()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r1 = j(r1, r2)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r6.<init>(r1, r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r5.disconnect()     // Catch: java.lang.Exception -> L7c
        L7c:
            return r6
        L7d:
            r5.disconnect()     // Catch: java.lang.Exception -> L8b
            goto L8b
        L81:
            r4 = move-exception
            goto L8c
        L83:
            r4 = move-exception
            r5 = r0
        L85:
            com.bytedance.sdk.openadsdk.api.m.j(r4)     // Catch: java.lang.Throwable -> L48
            if (r5 == 0) goto L8b
            goto L7d
        L8b:
            return r0
        L8c:
            if (r0 == 0) goto L91
            r0.disconnect()     // Catch: java.lang.Exception -> L91
        L91:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.xt.cw.j(boolean, java.lang.String, byte[]):java.lang.String");
    }

    private static byte[] j(InputStream inputStream, int i6) throws IOException {
        if (inputStream == null) {
            return null;
        }
        if (i6 <= 0) {
            i6 = 1;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[i6];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private static String j(String str, String str2) {
        if (str != null) {
            String[] split = str.split(";", 0);
            for (int i6 = 1; i6 < split.length; i6++) {
                String[] split2 = split[i6].trim().split(ContainerUtils.KEY_VALUE_DELIMITER, 0);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str2;
    }

    private SSLSocketFactory j(X509TrustManager x509TrustManager) throws IOException {
        try {
            SSLContext sSLContext = SSLContext.getInstance(b.Q);
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e6) {
            throw new IOException("No System TLS", e6);
        }
    }
}
