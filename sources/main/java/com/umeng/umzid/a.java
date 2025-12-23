package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {
    public static SharedPreferences a(Context context) {
        if (context != null) {
            return context.getSharedPreferences("umzid_general_config", 0);
        }
        return null;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i6 = 0; i6 < bArr.length; i6++) {
                bArr[i6] = (byte) ((bArr[i6] ^ bArr2[i6 % bArr2.length]) ^ (i6 & 255));
            }
        }
        return bArr;
    }

    public static synchronized String a(String str, String str2) {
        byte[] bArr;
        synchronized (a.class) {
            try {
                String host = Uri.parse(str).getHost();
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                httpsURLConnection.setHostnameVerifier(new b(host));
                SSLContext sSLContext = SSLContext.getInstance(org.apache.commons.net.imap.b.Q);
                sSLContext.init(null, null, new SecureRandom());
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                httpsURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                httpsURLConnection.setConnectTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
                httpsURLConnection.setReadTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);
                OutputStream outputStream = httpsURLConnection.getOutputStream();
                byte[] bytes = str2.getBytes();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(bytes);
                    gZIPOutputStream.close();
                    bArr = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                } catch (Exception e6) {
                    e6.printStackTrace();
                    bArr = null;
                }
                outputStream.write(a(bArr, "7EC2papS9acZxgIb".getBytes()));
                outputStream.flush();
                outputStream.close();
                if (httpsURLConnection.getResponseCode() == 200) {
                    InputStream inputStream = httpsURLConnection.getInputStream();
                    byte[] bArr2 = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read == -1) {
                            return new String(a(byteArrayOutputStream2.toByteArray(), "7EC2papS9acZxgIb".getBytes()));
                        }
                        byteArrayOutputStream2.write(bArr2, 0, read);
                    }
                }
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            return null;
        }
    }
}
