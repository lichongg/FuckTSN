package com.huawei.hms.framework.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ContainerUtils {
    public static final String FIELD_DELIMITER = "&";
    public static final String KEY_VALUE_DELIMITER = "=";

    public static <K, V> boolean equals(Map<K, V> map, Map<K, V> map2) {
        if (map == map2) {
            return true;
        }
        if (map == null || map2 == null || map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (map2.get(entry.getKey()) != entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> String toString(Map<K, V> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i6 = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            int i7 = i6 + 1;
            if (i6 > 0) {
                sb.append(FIELD_DELIMITER);
            }
            sb.append(entry.getKey().toString());
            sb.append(KEY_VALUE_DELIMITER);
            sb.append(entry.getValue().toString());
            i6 = i7;
        }
        return sb.toString();
    }

    public static <K, V> int hashCode(Map<K, V> map) {
        return toString(map).hashCode();
    }

    public static <K> String toString(Set<K> set) {
        if (set == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i6 = 0;
        for (K k6 : set) {
            int i7 = i6 + 1;
            if (i6 > 0) {
                sb.append(FIELD_DELIMITER);
            }
            sb.append(k6.toString());
            i6 = i7;
        }
        return sb.toString();
    }

    public static <K> String toString(List<K> list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i6 = 0;
        for (K k6 : list) {
            int i7 = i6 + 1;
            if (i6 > 0) {
                sb.append(FIELD_DELIMITER);
            }
            sb.append(k6.toString());
            i6 = i7;
        }
        return sb.toString();
    }
}
