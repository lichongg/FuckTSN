package com.kwad.components.offline.api.core.utils;

import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class LiveRequestDataUtils {
    public static String appendUrl(@NonNull String str, Map<String, String> map) {
        String str2;
        if (map == null || map.size() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            str2 = ContainerUtils.FIELD_DELIMITER;
            if (!hasNext) {
                break;
            }
            String next = it.next();
            if (map.get(next) != null) {
                sb.append(next);
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(map.get(next));
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
        }
        String substring = sb.toString().substring(0, r6.length() - 1);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (!str.contains("?")) {
            str2 = "?";
        }
        sb2.append(str2);
        return sb2.toString() + substring;
    }
}
