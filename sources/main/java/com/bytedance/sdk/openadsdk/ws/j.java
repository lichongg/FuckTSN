package com.bytedance.sdk.openadsdk.ws;

import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.l.r;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.commons.net.g;
import org.apache.commons.net.imap.b;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: com.bytedance.sdk.openadsdk.ws.j$j, reason: collision with other inner class name */
    public interface InterfaceC0509j {
        void j(int i6, String str);

        void j(String str);
    }

    private static SSLSocketFactory j(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance(b.Q);
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (Throwable th) {
            throw new RuntimeException("No System TLS", th);
        }
    }

    private static X509TrustManager j() {
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
        } catch (Throwable th) {
            vl.xt("Https", th);
            return null;
        }
    }

    public void j(String str, File file, Map<String, String> map, InterfaceC0509j interfaceC0509j, Map<String, String> map2) {
        DataOutputStream dataOutputStream;
        HttpsURLConnection httpsURLConnection = null;
        try {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
            try {
                httpsURLConnection2.setRequestMethod("POST");
                httpsURLConnection2.setReadTimeout(20000);
                httpsURLConnection2.setConnectTimeout(10000);
                httpsURLConnection2.setDoOutput(true);
                httpsURLConnection2.setDoInput(true);
                httpsURLConnection2.setUseCaches(false);
                String uuid = UUID.randomUUID().toString();
                if (map2 != null) {
                    for (Map.Entry<String, String> entry : map2.entrySet()) {
                        httpsURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpsURLConnection2.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + uuid);
                httpsURLConnection2.setSSLSocketFactory(j(j()));
                httpsURLConnection2.connect();
                dataOutputStream = new DataOutputStream(httpsURLConnection2.getOutputStream());
                try {
                    dataOutputStream.writeBytes("--" + uuid + "\r\nContent-Disposition: form-data; name=\"logFile\"; filename=\"" + file.getName() + "\"\r\nContent-Type: multipart/form-data\r\nContent-Length: " + file.length() + "\r\n\r\n");
                    dataOutputStream.flush();
                    r.j(dataOutputStream, file);
                    dataOutputStream.writeBytes(g.f50795q);
                    if (map != null) {
                        for (Map.Entry<String, String> entry2 : map.entrySet()) {
                            String key = entry2.getKey();
                            String value = entry2.getValue();
                            if (value != null && key != null) {
                                j(dataOutputStream, key, value, uuid);
                            }
                        }
                    }
                    dataOutputStream.writeBytes("--" + uuid + "--\r\n");
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    j(httpsURLConnection2, interfaceC0509j);
                    httpsURLConnection2.disconnect();
                    r.j(dataOutputStream);
                } catch (Throwable th) {
                    th = th;
                    httpsURLConnection = httpsURLConnection2;
                    try {
                        vl.xt("Https", th);
                        if (interfaceC0509j != null) {
                            interfaceC0509j.j(-1, th.getMessage());
                        }
                    } finally {
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        r.j(dataOutputStream);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
        }
    }

    private void j(DataOutputStream dataOutputStream, String str, String str2, String str3) throws IOException {
        dataOutputStream.writeBytes("\r\n--" + str3 + "\r\nContent-Disposition: form-data; name=\"" + str + "\";\r\nContent-Length: " + str2.length() + "\r\n\r\n" + str2 + g.f50795q);
    }

    private void j(HttpURLConnection httpURLConnection, InterfaceC0509j interfaceC0509j) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            } else {
                sb.append(readLine);
            }
        }
        if (responseCode == 200) {
            if (interfaceC0509j != null) {
                interfaceC0509j.j(sb.toString());
            }
        } else if (interfaceC0509j != null) {
            interfaceC0509j.j(responseCode, sb.toString());
        }
    }
}
