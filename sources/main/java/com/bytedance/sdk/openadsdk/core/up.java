package com.bytedance.sdk.openadsdk.core;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.rn.j;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up implements j.xt {

    /* renamed from: j, reason: collision with root package name */
    private final Map<Integer, WeakReference<j.xt>> f30845j = new HashMap();

    public void j(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return;
        }
        function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(9).j(Boolean.class).j(0, new com.bytedance.sdk.openadsdk.core.wq.j() { // from class: com.bytedance.sdk.openadsdk.core.up.1
            @Override // com.bytedance.sdk.openadsdk.core.wq.j
            public void j() {
                up.this.xt();
            }

            @Override // com.bytedance.sdk.openadsdk.core.wq.j
            public void xt() {
                up.this.j();
            }
        }).xt());
    }

    @Override // com.bytedance.sdk.openadsdk.core.rn.j.xt
    public void xt() {
        Iterator<Map.Entry<Integer, WeakReference<j.xt>>> it = this.f30845j.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<j.xt> value = it.next().getValue();
            if (value != null) {
                j.xt xtVar = value.get();
                if (xtVar != null) {
                    xtVar.xt();
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }

    up() {
    }

    public void j(j.xt xtVar) {
        if (xtVar == null) {
            return;
        }
        this.f30845j.put(Integer.valueOf(xtVar.hashCode()), new WeakReference<>(xtVar));
    }

    @Override // com.bytedance.sdk.openadsdk.core.rn.j.xt
    public void j() {
        Iterator<Map.Entry<Integer, WeakReference<j.xt>>> it = this.f30845j.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<j.xt> value = it.next().getValue();
            if (value != null) {
                j.xt xtVar = value.get();
                if (xtVar != null) {
                    xtVar.j();
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }
}
