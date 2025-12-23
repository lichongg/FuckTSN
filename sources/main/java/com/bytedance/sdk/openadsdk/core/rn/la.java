package com.bytedance.sdk.openadsdk.core.rn;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class la<K, V> extends HashMap<K, V> {
    /* JADX WARN: Multi-variable type inference failed */
    public la<String, Object> j(K k6, V v5) {
        put(k6, v5);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public la<String, Object> j(Map<? extends K, ? extends V> map) {
        putAll(map);
        return this;
    }
}
