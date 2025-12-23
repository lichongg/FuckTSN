package com.kwad.sdk.core.network;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes6.dex */
public final class p {
    private static String aFj = "";
    private static String aFk = "";

    public static String HA() {
        String da;
        if (!TextUtils.isEmpty(aFk)) {
            return aFk;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return "";
        }
        try {
            da = ag.da(context);
            aFk = da;
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(da)) {
            return aFk;
        }
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        aFk = defaultUserAgent;
        String encode = URLEncoder.encode(defaultUserAgent, "UTF-8");
        aFk = encode;
        ag.al(context, encode);
        return aFk;
    }

    public static String Hz() {
        try {
            if (!TextUtils.isEmpty(aFj)) {
                return aFj;
            }
            String property = System.getProperty("http.agent");
            aFj = property;
            if (TextUtils.isEmpty(property)) {
                return aFj;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = aFj.length();
            for (int i6 = 0; i6 < length; i6++) {
                char charAt = aFj.charAt(i6);
                if (charAt > 31 && charAt < 127) {
                    stringBuffer.append(charAt);
                }
                stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            }
            String stringBuffer2 = stringBuffer.toString();
            aFj = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void b(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("User-Agent", getUserAgent());
        httpURLConnection.setRequestProperty("BrowserUa", HA());
        httpURLConnection.setRequestProperty("SystemUa", Hz());
    }

    private static String getDefaultUserAgent() {
        return Hz() + "-ksad-android-4.6.30.1";
    }

    public static String getUserAgent() {
        String userAgent = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getUserAgent();
        return TextUtils.isEmpty(userAgent) ? getDefaultUserAgent() : userAgent;
    }
}
