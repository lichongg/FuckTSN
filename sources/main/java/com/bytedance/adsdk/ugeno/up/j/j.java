package com.bytedance.adsdk.ugeno.up.j;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private volatile Map<String, cw> f23756j = new HashMap();

    public cw j(String str) {
        if (this.f23756j.containsKey(str) && this.f23756j.get(str) != null) {
            return this.f23756j.get(str);
        }
        xt xtVar = new xt();
        this.f23756j.put(str, xtVar);
        return xtVar;
    }

    public void j(String str, cw cwVar) {
        if (!this.f23756j.containsKey(str) || this.f23756j.get(str) == null) {
            this.f23756j.put(str, cwVar);
        }
    }
}
