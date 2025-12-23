package com.bytedance.sdk.openadsdk.core.rn;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class c {
    private static URL cw(String str) {
        if (str != null && str.length() != 0 && str.contains("://")) {
            try {
                return new URL(master.flame.danmaku.danmaku.parser.b.f50154a + str.substring(str.indexOf("://")));
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
        }
        return null;
    }

    public static Map<String, String> j(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        URL cw = cw(str);
        if (cw != null) {
            try {
                String query = cw.getQuery();
                if (query != null) {
                    if (query.contains("url=")) {
                        int indexOf = query.indexOf("url=");
                        linkedHashMap.put("url", URLDecoder.decode(query.substring(indexOf + 4), "UTF-8"));
                        query = query.substring(0, indexOf);
                    }
                    if (query.length() > 0) {
                        for (String str2 : query.split(ContainerUtils.FIELD_DELIMITER)) {
                            int indexOf2 = str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
                            if (indexOf2 > 0 && indexOf2 < str2.length() - 1) {
                                String substring = str2.substring(0, indexOf2);
                                int i6 = indexOf2 + 1;
                                String substring2 = str2.substring(i6);
                                if (!"live_short_touch_params".equals(substring) && !"extra_pangle_scheme_params".equals(substring)) {
                                    linkedHashMap.put(substring, substring2);
                                }
                                linkedHashMap.put(URLDecoder.decode(str2.substring(0, indexOf2), "UTF-8"), URLDecoder.decode(str2.substring(i6), "UTF-8"));
                            }
                        }
                    }
                }
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
                return linkedHashMap;
            }
        }
        return linkedHashMap;
    }

    public static String xt(String str) {
        return str.contains("?") ? str.substring(0, str.indexOf("?")) : str;
    }

    public static String j(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null && map.size() > 0) {
            StringBuilder sb = new StringBuilder(xt(str));
            sb.append("?");
            try {
                Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    String key = next.getKey();
                    String value = next.getValue();
                    if (it.hasNext()) {
                        if (!"live_short_touch_params".equals(key) && !"extra_pangle_scheme_params".equals(key)) {
                            sb.append(key + ContainerUtils.KEY_VALUE_DELIMITER + value + ContainerUtils.FIELD_DELIMITER);
                        }
                        sb.append(URLEncoder.encode(next.getKey(), "UTF-8") + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(next.getValue(), "UTF-8") + ContainerUtils.FIELD_DELIMITER);
                    } else {
                        if (!"live_short_touch_params".equals(key) && !"extra_pangle_scheme_params".equals(key)) {
                            sb.append(key + ContainerUtils.KEY_VALUE_DELIMITER + value);
                        }
                        sb.append(URLEncoder.encode(next.getKey(), "UTF-8") + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(next.getValue(), "UTF-8"));
                    }
                }
            } catch (Exception unused) {
            }
            return sb.toString();
        }
        return "";
    }
}
