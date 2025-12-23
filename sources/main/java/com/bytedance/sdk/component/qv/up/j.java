package com.bytedance.sdk.component.qv.up;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f26746j;
    private static Map<String, Map<String, Object>> xt = new HashMap();

    public static j j() {
        if (f26746j != null) {
            return f26746j;
        }
        synchronized (j.class) {
            try {
                if (f26746j != null) {
                    return f26746j;
                }
                j jVar = new j();
                f26746j = jVar;
                return jVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private j() {
    }

    public Map<String, Object> j(String str) {
        Map<String, Object> map = xt.get(str);
        if (map != null) {
            return map;
        }
        HashMap hashMap = new HashMap();
        xt.put(str, hashMap);
        return hashMap;
    }
}
