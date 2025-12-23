package com.bytedance.sdk.openadsdk.core.la;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f29447j = new ConcurrentHashMap<>();

    private String xt(String str, String str2) {
        return (str == null || !this.f29447j.containsKey(str)) ? str2 : (String) this.f29447j.get(str);
    }

    public void j(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f29447j.put(str, str2);
    }

    public String j(String str) {
        return xt(str, "");
    }

    public void j(String str, int i6) {
        if (str != null) {
            this.f29447j.put(str, Integer.valueOf(i6));
        }
    }

    public int xt(String str) {
        return xt(str, 0);
    }

    private int xt(String str, int i6) {
        return (str == null || !this.f29447j.containsKey(str)) ? i6 : ((Integer) this.f29447j.get(str)).intValue();
    }
}
