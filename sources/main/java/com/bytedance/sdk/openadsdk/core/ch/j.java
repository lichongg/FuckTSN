package com.bytedance.sdk.openadsdk.core.ch;

import com.bytedance.sdk.openadsdk.core.rn.h;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f28010j;
    private Map<String, xt> xt = new HashMap();

    public static j j() {
        if (f28010j == null) {
            synchronized (j.class) {
                try {
                    if (f28010j == null) {
                        f28010j = new j();
                    }
                } finally {
                }
            }
        }
        return f28010j;
    }

    private j() {
        j(com.bytedance.sdk.openadsdk.core.ch.cw.j.cw());
        j(com.bytedance.sdk.openadsdk.core.ch.j.j.xt());
        j(com.bytedance.sdk.openadsdk.core.ch.r.j.cw());
        j(com.bytedance.sdk.openadsdk.core.ch.up.j.xt());
    }

    private void j(xt xtVar) {
        this.xt.put(xtVar.j(), xtVar);
    }

    public String j(String str, String str2) {
        if (this.xt.containsKey(str)) {
            return this.xt.get(str).j(str2);
        }
        return h.j(str).xt(str2, "");
    }

    public void j(String str, String str2, String str3) {
        if (this.xt.containsKey(str)) {
            this.xt.get(str).j(str2, str3);
        } else {
            h.j(str).j(str2, str3);
        }
    }
}
