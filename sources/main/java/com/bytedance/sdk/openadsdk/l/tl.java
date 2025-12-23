package com.bytedance.sdk.openadsdk.l;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl {

    public static class j {

        /* renamed from: j, reason: collision with root package name */
        public String f31563j;
        public Map<String, String> xt;
    }

    public static j j(String str) {
        j jVar = new j();
        if (str != null) {
            String trim = str.trim();
            if (!trim.equals("")) {
                String[] split = trim.split("\\?");
                jVar.f31563j = split[0];
                if (split.length != 1) {
                    String[] split2 = split[1].split(ContainerUtils.FIELD_DELIMITER);
                    jVar.xt = new HashMap();
                    for (String str2 : split2) {
                        String[] split3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                        if (split3.length >= 2) {
                            jVar.xt.put(split3[0], split3[1]);
                        }
                    }
                }
            }
        }
        return jVar;
    }

    public static String xt(String str) {
        j j6 = j(str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<String, String> map = j6.xt;
        if (map != null) {
            if (map.containsKey("v")) {
                linkedHashMap.put("v", j6.xt.get("v"));
                j6.xt.remove("v");
            }
            for (Map.Entry<String, String> entry : j6.xt.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return j(j6.f31563j, linkedHashMap);
    }

    private static String j(String str, LinkedHashMap<String, String> linkedHashMap) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            return sb.toString();
        }
        sb.append(str);
        boolean z5 = str.contains("?") || str.contains(ContainerUtils.FIELD_DELIMITER);
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            for (String str2 : linkedHashMap.keySet()) {
                if (!z5) {
                    sb.append("?");
                    z5 = true;
                } else {
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                }
                sb.append(str2);
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(linkedHashMap.get(str2));
            }
        }
        return sb.toString();
    }
}
