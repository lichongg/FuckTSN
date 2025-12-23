package com.bytedance.sdk.openadsdk.core.live;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    public static String j(Uri uri, String str) {
        return (uri == null || !uri.isHierarchical() || str == null) ? "" : uri.getQueryParameter(str);
    }

    public static Uri j(Uri uri, Map<String, String> map) {
        if (uri != null && map != null && map.size() > 0) {
            try {
                Uri.Builder buildUpon = uri.buildUpon();
                for (String str : map.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        buildUpon.appendQueryParameter(str, map.get(str));
                    }
                }
                return buildUpon.build();
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
        return uri;
    }
}
