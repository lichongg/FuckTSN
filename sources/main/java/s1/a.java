package s1;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {
    public static void b(HttpsURLConnection httpsURLConnection, String str) {
        OutputStream outputStream;
        String str2;
        if (str == null) {
            str2 = "sendHttpBody: The Body Data is Null";
        } else {
            if (httpsURLConnection != null) {
                try {
                    outputStream = httpsURLConnection.getOutputStream();
                } catch (Throwable th) {
                    th = th;
                    outputStream = null;
                }
                try {
                    outputStream.write(str.getBytes("UTF-8"));
                    outputStream.flush();
                    IoUtils.closeSecure(outputStream);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    IoUtils.closeSecure(outputStream);
                    throw th;
                }
            }
            str2 = "sendHttpBody: HttpsURLConnection is Null";
        }
        Logger.i("URLConnectionHelper", str2);
    }

    public static HttpsURLConnection a(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        URLConnection openConnection = new URL(str).openConnection();
        if (openConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
            try {
                httpsURLConnection.setSSLSocketFactory(t1.a.b(context));
                httpsURLConnection.setHostnameVerifier(t1.a.a());
            } catch (IllegalArgumentException unused) {
                Logger.w("URLConnectionHelper", "init https ssl socket failed.");
            }
            httpsURLConnection.setConnectTimeout(10000);
            httpsURLConnection.setReadTimeout(10000);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setUseCaches(false);
            String d6 = r1.a.d(context, "NetworkKit-grs", str2);
            Logger.d("URLConnectionHelper", "request to grs server with a User-Agent header is: " + d6);
            httpsURLConnection.setRequestProperty("User-Agent", d6);
            return httpsURLConnection;
        }
        Logger.w("URLConnectionHelper", "urlConnection is not an instance of HttpsURLConnection");
        return null;
    }
}
