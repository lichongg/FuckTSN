package com.bytedance.msdk.core.j.j.xt.j.cw;

import a1.a;
import a1.b;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.r.j.ae.tl;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.j.up.m;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.i.r;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw extends com.bytedance.msdk.xt.cw {

    /* renamed from: g, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f24502g;
    private oq oq;
    private com.bytedance.msdk.core.j.j.xt.j qv;
    private com.bytedance.msdk.api.j.xt vl;

    /* JADX INFO: Access modifiers changed from: private */
    public void ay() {
        if (this.f24502g != null) {
            this.f24502g.apply(r.j().j(40034).j(Void.class).xt());
        }
    }

    private void ch(int i6) {
        if (this.f24502g != null) {
            this.f24502g.apply(r.j().j(40007).j(50007, Integer.valueOf(i6)).j(Void.class).xt());
        }
    }

    private int ej() {
        Object apply;
        if (this.f24502g != null) {
            apply = this.f24502g.apply(r.j().j(40021).j(Integer.class).xt());
            if (apply instanceof Integer) {
                return ((Integer) apply).intValue();
            }
        }
        return 0;
    }

    private int fk() {
        try {
            Integer num = (Integer) m.j(new Callable<Integer>() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.cw.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(cw.this.ve());
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

    private String fz() {
        try {
            String str = (String) m.j(new Callable<String>() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.cw.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return cw.this.xj();
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
        if (this.f24502g != null) {
            apply = this.f24502g.apply(r.j().j(40012).j(Boolean.class).xt());
            if ((apply instanceof Boolean) && ((Boolean) apply).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private String id() {
        try {
            return (String) m.j(new Callable<String>() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.cw.6
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return cw.this.kj();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            vl.j(th);
            return null;
        }
    }

    /* renamed from: if, reason: not valid java name */
    private String m91if() {
        Object apply;
        if (this.f24502g != null) {
            apply = this.f24502g.apply(r.j().j(40033).j(String.class).xt());
            if (apply instanceof String) {
                return (String) apply;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String kj() {
        Object apply;
        Object obj;
        if (this.f24502g == null) {
            return "";
        }
        apply = this.f24502g.apply(r.j().j(40015).j(Map.class).xt());
        return (!(apply instanceof Map) || (obj = ((Map) apply).get("request_id")) == null) ? "" : obj.toString();
    }

    private String lo() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24502g;
        if (function == null) {
            return "";
        }
        apply = function.apply(r.j().j(40004).j(String.class).xt());
        if (apply instanceof String) {
            return apply.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Map<String, Object> map) {
        if (this.f24502g != null) {
            this.f24502g.apply(r.j().j(40014).j(Void.class).j(50010, map).xt());
        }
    }

    private String os() {
        Object apply;
        if (this.f24502g != null) {
            apply = this.f24502g.apply(r.j().j(40032).j(String.class).xt());
            if (apply instanceof String) {
                return (String) apply;
            }
        }
        return "";
    }

    private double ot() {
        if (this.f24502g == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? ve() : fk();
    }

    private View pm() {
        Object apply;
        if (this.f24502g != null) {
            apply = this.f24502g.apply(r.j().j(40035).j(View.class).xt());
            if (apply instanceof View) {
                return (View) apply;
            }
        }
        return null;
    }

    private void so() {
        if (this.f24502g != null) {
            this.f24502g.apply(r.j().j(40009).j(Void.class).j(50009, this).xt());
        }
    }

    private void to() {
        if (this.f24502g != null) {
            this.f24502g.apply(r.j().j(40022).j(Void.class).xt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ve() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24502g;
        if (function == null) {
            return 0;
        }
        apply = function.apply(r.j().j(40003).j(Integer.class).xt());
        if (apply instanceof Integer) {
            Integer num = (Integer) apply;
            if (num.intValue() != -1) {
                return num.intValue();
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vr() {
        if (this.f24502g != null) {
            this.f24502g.apply(r.j().j(40011).j(Void.class).xt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i6) {
        if (this.f24502g != null) {
            this.f24502g.apply(r.j().j(40013).j(Void.class).j(50007, Integer.valueOf(i6)).xt());
        }
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
            ch(ve());
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
            m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.cw.7
                @Override // java.lang.Runnable
                public void run() {
                    cw.this.ay();
                }
            });
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public boolean up() {
        Object apply;
        if (this.f24502g != null) {
            apply = this.f24502g.apply(r.j().j(40012).j(Boolean.class).xt());
            if ((apply instanceof Boolean) && ((Boolean) apply).booleanValue()) {
                return true;
            }
        }
        return false;
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
                m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.cw.4
                    @Override // java.lang.Runnable
                    public void run() {
                        cw.this.x(t5);
                    }
                });
            }
        }
    }

    public cw(com.bytedance.msdk.core.j.j.xt.j jVar, Function<SparseArray<Object>, Object> function) {
        this.f24502g = function;
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
        gq(m91if());
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
        if (i6 == 60016) {
            View view = (View) pluginValueSet.objectValue(8042, View.class);
            if (rh() == 5) {
                com.bytedance.msdk.api.r.j.cw.j jVar = this.f25337m;
                if (jVar instanceof com.bytedance.msdk.api.r.j.cw.r) {
                    ((com.bytedance.msdk.api.r.j.cw.r) jVar).j(view, "渲染失败", MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL);
                }
            } else {
                com.bytedance.msdk.api.r.j.ae.xt xtVar = this.f25334j;
                if (xtVar instanceof com.bytedance.msdk.api.r.j.ae.m) {
                    ((com.bytedance.msdk.api.r.j.ae.m) xtVar).j(view, "渲染失败", MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL);
                }
            }
        } else if (i6 == 60017) {
            int intValue = pluginValueSet.intValue(50014);
            int intValue2 = pluginValueSet.intValue(50016);
            if (rh() == 5) {
                com.bytedance.msdk.api.r.j.cw.j jVar2 = this.f25337m;
                if (jVar2 instanceof com.bytedance.msdk.api.r.j.cw.r) {
                    ((com.bytedance.msdk.api.r.j.cw.r) jVar2).j(intValue, intValue2);
                }
            } else {
                com.bytedance.msdk.api.r.j.ae.xt xtVar2 = this.f25334j;
                if (xtVar2 instanceof com.bytedance.msdk.api.r.j.ae.m) {
                    ((com.bytedance.msdk.api.r.j.ae.m) xtVar2).j(intValue, intValue2);
                }
            }
        } else if (i6 == 60009) {
            if (rh() == 5) {
                com.bytedance.msdk.api.r.j.cw.j jVar3 = this.f25337m;
                if (jVar3 != null) {
                    jVar3.j();
                }
            } else {
                com.bytedance.msdk.api.r.j.ae.xt xtVar3 = this.f25334j;
                if (xtVar3 != null) {
                    xtVar3.j();
                }
            }
        } else if (i6 == 60004) {
            if (rh() == 5) {
                com.bytedance.msdk.api.r.j.cw.j jVar4 = this.f25337m;
                if (jVar4 != null) {
                    jVar4.j(null);
                }
            } else {
                com.bytedance.msdk.api.r.j.ae.xt xtVar4 = this.f25334j;
                if (xtVar4 != null) {
                    xtVar4.j(null);
                }
            }
        } else if (i6 == 60005) {
            tl tlVar = this.xt;
            if (tlVar != null) {
                tlVar.up();
            }
        } else if (i6 == 60006) {
            com.bytedance.msdk.up.m.j(this, this.vl, "gdt信息流模板dislike接口无关闭原因");
            com.bytedance.msdk.core.xt.j.j(this.vl.v());
            if (mi() != null) {
                mi().j(-1, "gdt信息流模板dislike接口无关闭原因", false);
            }
        } else if (i6 == 60010) {
            com.bytedance.msdk.core.j.j.xt.j.m.xt xtVar5 = new com.bytedance.msdk.core.j.j.xt.j.m.xt(b.a(pluginValueSet.objectValue(50006, a.a())));
            tl tlVar2 = this.xt;
            if (tlVar2 != null) {
                tlVar2.j(new com.bytedance.msdk.api.j(xtVar5.j(), xtVar5.xt()));
            }
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
            m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.cw.3
                @Override // java.lang.Runnable
                public void run() {
                    cw.this.vr();
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
            m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.cw.5
                @Override // java.lang.Runnable
                public void run() {
                    cw.this.m((Map<String, Object>) map);
                }
            });
        } else {
            m(map);
        }
    }
}
