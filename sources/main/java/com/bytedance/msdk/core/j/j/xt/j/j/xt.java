package com.bytedance.msdk.core.j.j.xt.j.j;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.j.up.m;
import com.bytedance.sdk.component.utils.vl;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends com.bytedance.msdk.xt.cw {

    /* renamed from: g, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f24555g;
    private volatile boolean jy = false;
    private oq oq;
    private com.bytedance.msdk.core.j.j.xt.j qv;
    private com.bytedance.msdk.api.j.xt vl;

    private Integer ve() {
        try {
            Integer num = (Integer) m.j(new Callable<Integer>() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.xt.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return xt.this.xj();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            if (num != null) {
                return num;
            }
            return 4;
        } catch (Exception e6) {
            vl.j(e6);
            return 4;
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public Integer m() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? xj() : ve();
    }

    private int ej() {
        try {
            Integer num = (Integer) m.j(new Callable<Integer>() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.xt.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(xt.this.to());
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        } catch (Exception e6) {
            vl.j(e6);
            return 0;
        }
    }

    private String fk() {
        Object apply;
        if (this.f24555g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40004);
        sparseArray.put(-99999985, String.class);
        apply = this.f24555g.apply(sparseArray);
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fz() {
        if (this.f24555g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40011);
            sparseArray.put(-99999985, Void.class);
            this.f24555g.apply(sparseArray);
        }
    }

    private com.bytedance.msdk.api.r.j.j.j id() {
        return (com.bytedance.msdk.api.r.j.j.j) this.ae;
    }

    /* renamed from: if, reason: not valid java name */
    private void m95if() {
        if (this.f24555g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40009);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50009, this);
            this.f24555g.apply(sparseArray);
        }
    }

    private View kj() {
        Object apply;
        if (this.f24555g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40035);
            sparseArray.put(-99999985, View.class);
            apply = this.f24555g.apply(sparseArray);
            if (apply instanceof View) {
                return (View) apply;
            }
        }
        return null;
    }

    private String lo() {
        try {
            return (String) m.j(new Callable<String>() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.xt.7
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return xt.this.vr();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }

    private double os() {
        if (this.f24555g == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? to() : ej();
    }

    private String ot() {
        try {
            String str = (String) m.j(new Callable<String>() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.xt.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return xt.this.so();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e6) {
            vl.j(e6);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String so() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? fk() : ot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int to() {
        Object apply;
        if (this.f24555g == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40003);
        sparseArray.put(-99999985, Integer.class);
        apply = this.f24555g.apply(sparseArray);
        int intValue = apply instanceof Integer ? ((Integer) apply).intValue() : 0;
        if (intValue == -1) {
            return 0;
        }
        return intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String vr() {
        Object apply;
        Object obj;
        if (this.f24555g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40015);
        sparseArray.put(-99999985, Map.class);
        apply = this.f24555g.apply(sparseArray);
        return (!(apply instanceof Map) || (obj = ((Map) apply).get("request_id")) == null) ? "" : obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i6) {
        if (this.f24555g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40013);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50007, Integer.valueOf(i6));
            this.f24555g.apply(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer xj() {
        Object apply;
        if (this.f24555g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40010);
            sparseArray.put(-99999985, Boolean.class);
            apply = this.f24555g.apply(sparseArray);
            if (((Boolean) apply).booleanValue()) {
                return 2;
            }
        }
        return 4;
    }

    @Override // com.bytedance.msdk.xt.cw
    public String o() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? vr() : lo();
    }

    @Override // com.bytedance.msdk.xt.cw
    public boolean up() {
        return this.jy;
    }

    @Override // com.bytedance.msdk.xt.cw
    public void xt(Map<String, Object> map) {
        oq oqVar = this.oq;
        if (oqVar != null && oqVar.la()) {
            final int t5 = (int) t();
            com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
            if (jVar == null || !jVar.cw()) {
                x(t5);
            } else {
                m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.xt.5
                    @Override // java.lang.Runnable
                    public void run() {
                        xt.this.x(t5);
                    }
                });
            }
        }
    }

    public xt(com.bytedance.msdk.core.j.j.xt.j jVar, Function<SparseArray<Object>, Object> function) {
        this.f24555g = function;
        this.qv = jVar;
        this.oq = jVar.xt;
        this.vl = jVar.f24490j;
        m95if();
        oq oqVar = this.oq;
        if (oqVar != null) {
            if (oqVar.la()) {
                j(os());
            } else if (this.oq.rn()) {
                ws(so());
            }
        }
    }

    @Override // com.bytedance.msdk.xt.cw, com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i6 == 60009) {
            if (this.ae instanceof com.bytedance.msdk.api.r.j.j.j) {
                id().xt(null);
            }
        } else if (i6 == 60006) {
            if (this.ae instanceof com.bytedance.msdk.api.r.j.j.j) {
                com.bytedance.msdk.api.j.xt xtVar = this.vl;
                if (xtVar != null) {
                    com.bytedance.msdk.core.xt.j.j(xtVar.v());
                }
                id().f_();
            }
        } else if (i6 == 60004 && (this.ae instanceof com.bytedance.msdk.api.r.j.j.j)) {
            id().j((View) null);
        }
        return null;
    }

    @Override // com.bytedance.msdk.xt.cw
    public View g() {
        return kj();
    }

    @Override // com.bytedance.msdk.xt.cw
    public void w() {
        super.w();
        this.jy = true;
        m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.xt.4
            @Override // java.lang.Runnable
            public void run() {
                xt.this.fz();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Map<String, Object> map) {
        if (this.f24555g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40014);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50010, map);
            this.f24555g.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void j(final Map<String, Object> map) {
        oq oqVar = this.oq;
        if (oqVar == null || !oqVar.la() || map == null) {
            return;
        }
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        if (jVar != null && jVar.cw()) {
            m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.xt.6
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.m((Map<String, Object>) map);
                }
            });
        } else {
            m(map);
        }
    }
}
