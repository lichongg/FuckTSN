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
public class r extends com.bytedance.msdk.xt.cw {

    /* renamed from: g, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f24547g;
    private oq oq;
    private com.bytedance.msdk.core.j.j.xt.j qv;
    private com.bytedance.msdk.api.j.xt vl;

    /* JADX INFO: Access modifiers changed from: private */
    public void ay() {
        if (this.f24547g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40034);
            sparseArray.put(-99999985, Boolean.class);
            this.f24547g.apply(sparseArray);
        }
    }

    private void ch(int i6) {
        if (this.f24547g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40007);
            sparseArray.put(-99999985, Boolean.class);
            sparseArray.put(50007, Integer.valueOf(i6));
            this.f24547g.apply(sparseArray);
        }
    }

    private int ej() {
        Object apply;
        if (this.f24547g == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40021);
        sparseArray.put(-99999985, Integer.class);
        apply = this.f24547g.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fk() {
        Object apply;
        if (this.f24547g == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40003);
        sparseArray.put(-99999985, Integer.class);
        apply = this.f24547g.apply(sparseArray);
        if (apply instanceof Integer) {
            Integer num = (Integer) apply;
            if (num.intValue() != -1) {
                return num.intValue();
            }
        }
        return 0;
    }

    private String fz() {
        try {
            String str = (String) m.j(new Callable<String>() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.r.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return r.this.xj();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e6) {
            vl.j(e6);
            return "";
        }
    }

    private boolean hk() {
        Object apply;
        if (this.f24547g == null) {
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40012);
        sparseArray.put(-99999985, Boolean.class);
        apply = this.f24547g.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    private String id() {
        try {
            return (String) m.j(new Callable<String>() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.r.6
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return r.this.kj();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            vl.j(th);
            return null;
        }
    }

    /* renamed from: if, reason: not valid java name */
    private String m94if() {
        Object apply;
        if (this.f24547g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40033);
        sparseArray.put(-99999985, String.class);
        apply = this.f24547g.apply(sparseArray);
        return (String) apply;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String kj() {
        Object apply;
        Object obj;
        if (this.f24547g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40015);
        sparseArray.put(-99999985, Map.class);
        apply = this.f24547g.apply(sparseArray);
        return (!(apply instanceof Map) || (obj = ((Map) apply).get("request_id")) == null) ? "" : obj.toString();
    }

    private String lo() {
        Object apply;
        if (this.f24547g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40004);
        sparseArray.put(-99999985, String.class);
        apply = this.f24547g.apply(sparseArray);
        return (String) apply;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Map<String, Object> map) {
        if (this.f24547g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40014);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50010, map);
            this.f24547g.apply(sparseArray);
        }
    }

    private String os() {
        Object apply;
        if (this.f24547g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40032);
        sparseArray.put(-99999985, String.class);
        apply = this.f24547g.apply(sparseArray);
        return (String) apply;
    }

    private double ot() {
        if (this.f24547g == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? fk() : ve();
    }

    private View pm() {
        Object apply;
        if (this.f24547g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40035);
            sparseArray.put(-99999985, View.class);
            apply = this.f24547g.apply(sparseArray);
            if (apply != null) {
                return (View) apply;
            }
        }
        return null;
    }

    private void so() {
        if (this.f24547g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40009);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50009, this);
            this.f24547g.apply(sparseArray);
        }
    }

    private void to() {
        if (this.f24547g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40022);
            sparseArray.put(-99999985, Void.class);
            this.f24547g.apply(sparseArray);
        }
    }

    private int ve() {
        try {
            Integer num = (Integer) m.j(new Callable<Integer>() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.r.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(r.this.fk());
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

    /* JADX INFO: Access modifiers changed from: private */
    public void vr() {
        if (this.f24547g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40011);
            sparseArray.put(-99999985, Void.class);
            this.f24547g.apply(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i6) {
        if (this.f24547g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40013);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50007, Integer.valueOf(i6));
            this.f24547g.apply(sparseArray);
        }
    }

    private com.bytedance.msdk.api.r.j.j.j xc() {
        return (com.bytedance.msdk.api.r.j.j.j) this.ae;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String xj() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? lo() : fz();
    }

    @Override // com.bytedance.msdk.xt.cw
    public View g() {
        oq oqVar = this.oq;
        if (oqVar != null && oqVar.h()) {
            ch(fk());
        }
        return pm();
    }

    @Override // com.bytedance.msdk.xt.cw
    public String o() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? kj() : id();
    }

    @Override // com.bytedance.msdk.xt.cw
    public void qv() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        if (jVar == null || !jVar.cw()) {
            ay();
        } else {
            m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.r.7
                @Override // java.lang.Runnable
                public void run() {
                    r.this.ay();
                }
            });
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public boolean up() {
        Object apply;
        if (this.f24547g == null) {
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40012);
        sparseArray.put(-99999985, Boolean.class);
        apply = this.f24547g.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
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
                m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.r.4
                    @Override // java.lang.Runnable
                    public void run() {
                        r.this.x(t5);
                    }
                });
            }
        }
    }

    public r(com.bytedance.msdk.core.j.j.xt.j jVar, Function<SparseArray<Object>, Object> function) {
        this.f24547g = function;
        this.qv = jVar;
        this.oq = jVar.xt;
        this.vl = jVar.f24490j;
        so();
        if (ej() == 2) {
            qv(5);
            to();
        } else if (ej() != 1 && ej() != 4) {
            if (ej() == 3) {
                qv(4);
            } else {
                qv(3);
            }
        } else {
            qv(3);
        }
        ae(true);
        la(os());
        gq(m94if());
        vl(3);
        oq oqVar = this.oq;
        if (oqVar != null) {
            if (oqVar.la()) {
                j(ot());
            } else if (this.oq.rn()) {
                ws(xj());
            }
        }
    }

    @Override // com.bytedance.msdk.xt.cw, com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i6 == 60009) {
            if (this.ae instanceof com.bytedance.msdk.api.r.j.j.j) {
                xc().xt(null);
            }
        } else if (i6 == 60004) {
            if (this.ae instanceof com.bytedance.msdk.api.r.j.j.j) {
                xc().j((View) null);
            }
        } else if (i6 == 60006 && (this.ae instanceof com.bytedance.msdk.api.r.j.j.j)) {
            com.bytedance.msdk.api.j.xt xtVar = this.vl;
            if (xtVar != null) {
                com.bytedance.msdk.core.xt.j.j(xtVar.v());
            }
            xc().f_();
        }
        return null;
    }

    @Override // com.bytedance.msdk.xt.cw
    public boolean lx() {
        return hk();
    }

    @Override // com.bytedance.msdk.xt.cw
    public void w() {
        super.w();
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        if (jVar != null && jVar.cw()) {
            m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.r.3
                @Override // java.lang.Runnable
                public void run() {
                    r.this.vr();
                }
            });
        } else {
            vr();
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
            m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.r.5
                @Override // java.lang.Runnable
                public void run() {
                    r.this.m((Map<String, Object>) map);
                }
            });
        } else {
            m(map);
        }
    }
}
