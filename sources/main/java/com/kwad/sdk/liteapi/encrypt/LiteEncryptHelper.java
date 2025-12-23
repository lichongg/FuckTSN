package com.kwad.sdk.liteapi.encrypt;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwad.sdk.liteapi.LiteApiLogger;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class LiteEncryptHelper {
    public static final String UTF_8 = "UTF-8";

    public static String encrypt(String str, String str2) {
        try {
            return new String(KsBase64.getEncoder().encode(LiteAESUtil.encrypt(str.getBytes("UTF-8"), LiteAESUtil.compress(str2.getBytes()))), "UTF-8");
        } catch (Exception e6) {
            LiteApiLogger.printStackTraceOnly(e6);
            return str2;
        }
    }

    public static void addHeaderParams(Context context, @NonNull Map<String, String> map) {
        LiteRequestSigUtil.addHeaderParams(context, map);
    }

    public static String decrypt(String str, String str2) {
        try {
            return new String(LiteAESUtil.decompress(LiteAESUtil.decrypt(str, KsBase64.getDecoder().decode(str2.getBytes()))), "UTF-8");
        } catch (Exception e6) {
            LiteApiLogger.printStackTrace(e6);
            return str2;
        }
    }

    public static String getRequestMessage(Context context, String str) {
        return LiteRequestSigUtil.getRequestMessage(context, str);
    }

    public static void sigRequest(Context context, String str, Map<String, String> map, String str2) {
        LiteRequestSigUtil.sigRequest(context, str, map, str2);
    }
}
