package com.kwad.sdk.liteapi.encrypt;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.kwad.sdk.liteapi.KsSecSDKWrapper;
import com.kwad.sdk.liteapi.LiteApiLogger;
import java.util.Arrays;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public final class LiteKsSig1Util {
    private static final boolean DEBUG = false;
    private static final String JOIN_STRING = "&";
    public static final String PARAM_SIGNATURE = "Ks-Sig1";
    private static final String TAG = "KsSig1Util";

    public static String atlasSign(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                String doSign = KsSecSDKWrapper.doSign(context, str);
                return doSign == null ? "" : doSign;
            } catch (Throwable th) {
                LiteApiLogger.printStackTraceOnly(th);
            }
        }
        return "";
    }

    private static String emptyIfNull(String str) {
        return str == null ? "" : str;
    }

    private static String generateInputString(String str, String str2) {
        Uri parse = Uri.parse(str);
        return parse.getPath() + "&" + getSortedQuery(parse.getQuery()) + "&" + str2;
    }

    private static String getSortedQuery(String str) {
        if (TextUtils.isEmpty(str)) {
            return emptyIfNull(str);
        }
        String[] split = str.split("&");
        Arrays.sort(split);
        return TextUtils.join("&", split);
    }

    public static void sigRequest(Context context, String str, Map<String, String> map, String str2) {
        map.put(PARAM_SIGNATURE, atlasSign(context, generateInputString(str, str2)));
    }
}
