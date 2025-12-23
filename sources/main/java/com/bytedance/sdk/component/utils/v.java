package com.bytedance.sdk.component.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class v {

    /* renamed from: j, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Runnable>> f26902j = new ConcurrentHashMap<>();

    public void j(int i6, int i7, Runnable runnable) {
        if (i6 <= 0 || i7 <= 0) {
            return;
        }
        ConcurrentHashMap<Integer, Runnable> concurrentHashMap = this.f26902j.get(Integer.valueOf(i6));
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.f26902j.put(Integer.valueOf(i6), concurrentHashMap);
        }
        concurrentHashMap.put(Integer.valueOf(i7), runnable);
    }

    public abstract boolean j(int i6);

    public void cw(int i6) {
        Runnable value;
        ConcurrentHashMap<Integer, Runnable> remove = this.f26902j.remove(Integer.valueOf(i6));
        if (remove != null) {
            for (Map.Entry<Integer, Runnable> entry : remove.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.run();
                }
            }
        }
    }

    public void xt(int i6) {
        this.f26902j.remove(Integer.valueOf(i6));
    }

    public void j(int i6, int i7) {
        ConcurrentHashMap<Integer, Runnable> concurrentHashMap;
        if (i6 <= 0 || i7 <= 0 || (concurrentHashMap = this.f26902j.get(Integer.valueOf(i6))) == null) {
            return;
        }
        concurrentHashMap.remove(Integer.valueOf(i7));
    }
}
