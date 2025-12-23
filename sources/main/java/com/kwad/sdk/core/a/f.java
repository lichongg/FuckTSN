package com.kwad.sdk.core.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.kwad.sdk.liteapi.encrypt.LiteKsSig1Util;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Arrays;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f {
    private static String dW(String str) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                String doSign = com.kwad.sdk.core.f.c.doSign(context, str);
                return doSign == null ? "" : doSign;
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        return "";
    }

    private static String emptyIfNull(String str) {
        return str == null ? "" : str;
    }

    public static void a(String str, Map<String, String> map, String str2) {
        map.put(LiteKsSig1Util.PARAM_SIGNATURE, dW(generateInputString(str, str2)));
    }

    private static String generateInputString(String str, String str2) {
        Uri parse = Uri.parse(str);
        return parse.getPath() + ContainerUtils.FIELD_DELIMITER + getSortedQuery(parse.getQuery()) + ContainerUtils.FIELD_DELIMITER + str2;
    }

    private static String getSortedQuery(String str) {
        if (TextUtils.isEmpty(str)) {
            return emptyIfNull(str);
        }
        String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
        Arrays.sort(split);
        return TextUtils.join(ContainerUtils.FIELD_DELIMITER, split);
    }
}
