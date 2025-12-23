package com.uyumao;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class k {
    public static synchronized String a(Context context, String str, String str2) {
        byte[] bArr;
        synchronized (k.class) {
            try {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                httpsURLConnection.setHostnameVerifier(new a());
                SSLContext sSLContext = SSLContext.getInstance(org.apache.commons.net.imap.b.Q);
                sSLContext.init(null, null, new SecureRandom());
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                httpsURLConnection.setRequestProperty("appkey", UMUtils.getAppkey(context));
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
                outputStream.write(a(bArr, UMUtils.getAppkey(context).getBytes()));
                outputStream.flush();
                outputStream.close();
                if (httpsURLConnection.getResponseCode() == 200) {
                    InputStream inputStream = httpsURLConnection.getInputStream();
                    byte[] bArr2 = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr2, 0, read);
                    }
                    return "none".equals(httpsURLConnection.getContentEncoding()) ? new String(byteArrayOutputStream2.toByteArray()) : new String(a(byteArrayOutputStream2.toByteArray(), UMUtils.getAppkey(context).getBytes()));
                }
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            if (!TextUtils.isEmpty(str)) {
                if ("yumao.puata.info".equalsIgnoreCase(str) || "preulogs.umeng.com".equalsIgnoreCase(str)) {
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i6 = 0; i6 < bArr.length; i6++) {
                bArr[i6] = (byte) ((bArr[i6] ^ bArr2[i6 % bArr2.length]) ^ (i6 & 255));
            }
        }
        return bArr;
    }
}
