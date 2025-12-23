package com.kwad.sdk.core.videocache.a;

import android.net.Uri;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import com.kwad.sdk.utils.al;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f implements c {
    private static String eR(String str) {
        if (!str.startsWith(JPushConstants.HTTP_PRE) && !str.startsWith(JPushConstants.HTTPS_PRE)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        if (parse.getHost() == null || !parse.getHost().endsWith(".yximgs.com")) {
            return str;
        }
        Uri.Builder buildUpon = parse.buildUpon();
        HashMap hashMap = new HashMap();
        if (parse.isHierarchical()) {
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            for (String str2 : queryParameterNames) {
                hashMap.put(str2, parse.getQueryParameter(str2));
            }
            buildUpon.clearQuery();
            for (String str3 : queryParameterNames) {
                if (!CommonNetImpl.TAG.equals(str3) && !"di".equals(str3) && str3 != null) {
                    buildUpon.appendQueryParameter(str3, (String) hashMap.get(str3));
                }
            }
        }
        return buildUpon.toString();
    }

    private static String getExtension(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || lastIndexOf + 6 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    @Override // com.kwad.sdk.core.videocache.a.c
    public final String generate(String str) {
        String eR = eR(str);
        String extension = getExtension(eR);
        String md5 = al.md5(eR);
        if (TextUtils.isEmpty(extension)) {
            return md5;
        }
        return md5 + "." + extension;
    }
}
