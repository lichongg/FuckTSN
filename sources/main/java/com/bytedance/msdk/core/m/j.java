package com.bytedance.msdk.core.m;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.j.up.r;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private final Map<String, com.bytedance.msdk.api.r.j.xt.m.j> f24622j = new ConcurrentHashMap();

    public Map<String, com.bytedance.msdk.api.r.j.xt.m.j> j() {
        return this.f24622j;
    }

    public Map<String, Object> xt(Context context, Map<String, Object> map, String str) {
        r.j(context);
        com.bytedance.msdk.api.r.j.xt.m.j j6 = j(str);
        if (j6 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("buyerId", j6.j(context, map));
            hashMap.put("sdkInfo", j6.xt(context, map));
            return hashMap;
        }
        com.bytedance.msdk.j.j.r xt = xt(str);
        if (xt == null) {
            return null;
        }
        return xt.xt(context, map);
    }

    public void j(String str, com.bytedance.msdk.api.r.j.xt.m.j jVar) {
        this.f24622j.put(str, jVar);
    }

    public com.bytedance.msdk.api.r.j.xt.m.j j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f24622j.get(str);
    }

    public String j(Context context, Map<String, Object> map, String str) {
        r.j(context);
        com.bytedance.msdk.api.r.j.xt.m.j j6 = j(str);
        if (j6 != null) {
            return j6.j(null, null);
        }
        com.bytedance.msdk.j.j.r xt = xt(str);
        if (xt == null) {
            return null;
        }
        return xt.j(context, map);
    }

    public com.bytedance.msdk.j.j.r xt(String str) {
        return com.bytedance.msdk.m.xt.xt.j().j(str);
    }
}
