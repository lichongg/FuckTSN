package com.bytedance.sdk.component.ae.j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    public Map<String, Object> j(Map<String, Object> map, com.bytedance.sdk.component.r.j.j jVar, boolean z5) {
        if (jVar == null) {
            return map;
        }
        Map<String, Object> concurrentHashMap = z5 ? new ConcurrentHashMap<>() : map;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (z5) {
                key = (String) jVar.xt(key);
            }
            concurrentHashMap.put(key, jVar.xt(value.toString()));
        }
        return concurrentHashMap;
    }

    public Map<String, Object> xt(Map<String, Object> map, com.bytedance.sdk.component.r.j.j jVar, boolean z5) {
        if (jVar == null) {
            return map;
        }
        Map<String, Object> concurrentHashMap = z5 ? new ConcurrentHashMap<>() : map;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (z5) {
                key = jVar.j(key);
            }
            concurrentHashMap.put(key, jVar.j(value.toString()));
        }
        return concurrentHashMap;
    }
}
