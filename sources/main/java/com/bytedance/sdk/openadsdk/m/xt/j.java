package com.bytedance.sdk.openadsdk.m.xt;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private int xt = 0;

    /* renamed from: j, reason: collision with root package name */
    public Map<Integer, Long> f31610j = new ConcurrentHashMap();

    public void j() {
        this.xt = 0;
        try {
            this.f31610j.clear();
        } catch (Exception unused) {
        }
    }

    public boolean r(int i6) {
        return i6 == this.xt;
    }

    public void cw(int i6) {
        if (!j(i6)) {
            this.xt |= i6;
            try {
                this.f31610j.put(Integer.valueOf(i6), Long.valueOf(System.currentTimeMillis()));
            } catch (Exception unused) {
            }
        }
    }

    public boolean j(int i6) {
        return (this.xt & i6) == i6;
    }

    public Long xt(int i6) {
        try {
            if (j(i6)) {
                return this.f31610j.get(Integer.valueOf(i6));
            }
        } catch (Exception unused) {
        }
        return -1L;
    }
}
