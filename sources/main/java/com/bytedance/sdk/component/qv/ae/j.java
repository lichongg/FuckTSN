package com.bytedance.sdk.component.qv.ae;

import com.bytedance.sdk.component.qv.j.j.cw;
import com.bytedance.sdk.component.qv.j.xt;
import com.bytedance.sdk.component.qv.r.r;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private static volatile j xt;

    /* renamed from: j, reason: collision with root package name */
    private Map<String, com.bytedance.sdk.component.qv.j.j.j> f26724j = new HashMap();

    public static j j() {
        if (xt != null) {
            return xt;
        }
        synchronized (j.class) {
            try {
                if (xt != null) {
                    return xt;
                }
                j jVar = new j();
                xt = jVar;
                return jVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private j() {
    }

    public void j(String str, com.bytedance.sdk.component.qv.j.j.j jVar) {
        this.f26724j.put(str, jVar);
    }

    public void j(String str, com.bytedance.sdk.component.qv.j.j jVar, com.bytedance.sdk.component.qv.r.j jVar2) {
        com.bytedance.sdk.component.qv.j.j.j jVar3 = this.f26724j.get(str);
        if (jVar3 == null || jVar == null) {
            return;
        }
        Map<String, Object> j6 = jVar.j();
        r up = jVar.up();
        if (up instanceof xt) {
            Map<String, Object> j7 = com.bytedance.sdk.component.qv.up.j.j().j(String.valueOf(up.hashCode()));
            j6.putAll(j7);
            j7.clear();
            com.bytedance.sdk.component.qv.m.j j8 = com.bytedance.sdk.component.qv.m.j.j();
            jVar3 = j8.j(jVar3);
            HashMap hashMap = new HashMap();
            hashMap.putAll(jVar.xt());
            hashMap.putAll(j6);
            j8.j(jVar3, hashMap);
        }
        if (jVar3 instanceof cw) {
            ((cw) jVar3).j(jVar.xt(), jVar.j(), jVar);
        } else if (jVar3 instanceof com.bytedance.sdk.component.qv.j.j.xt) {
            ((com.bytedance.sdk.component.qv.j.j.xt) jVar3).j(jVar.xt(), jVar.j(), jVar);
        }
    }
}
