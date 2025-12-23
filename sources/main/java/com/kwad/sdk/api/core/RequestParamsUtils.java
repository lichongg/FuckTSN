package com.kwad.sdk.api.core;

import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class RequestParamsUtils {
    public static final String USER_AGENT_KEY = "User-Agent";
    private static String sUserAgent;

    public static String getUserAgent() {
        if (TextUtils.isEmpty(sUserAgent)) {
            sUserAgent = getUserAgentParams() + "ksad-android-4.6.30.1";
        }
        return sUserAgent;
    }

    private static String getUserAgentParams() {
        try {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            StringBuilder sb = new StringBuilder();
            int length = property.length();
            for (int i6 = 0; i6 < length; i6++) {
                char charAt = property.charAt(i6);
                if (charAt > 31 && charAt < 127) {
                    sb.append(charAt);
                }
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            }
            sb.append("-");
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
