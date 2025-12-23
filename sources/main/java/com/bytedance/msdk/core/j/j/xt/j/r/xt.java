package com.bytedance.msdk.core.j.j.xt.j.r;

import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.j.up.m;
import com.bytedance.msdk.xt.cw;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.i.r;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends cw {

    /* renamed from: g, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f24577g;
    private oq oq;
    private com.bytedance.msdk.core.j.j.xt.j qv;
    private com.bytedance.msdk.api.j.xt vl;

    private Integer lo() {
        try {
            Integer num = (Integer) m.j(new Callable<Integer>() { // from class: com.bytedance.msdk.core.j.j.xt.j.r.xt.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return xt.this.vr();
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
    public boolean lx() {
        return true;
    }

    private com.bytedance.msdk.api.r.j.r.j ay() {
        return (com.bytedance.msdk.api.r.j.r.j) this.ae;
    }

    private void cw(Activity activity) {
        Function<SparseArray<Object>, Object> function = this.f24577g;
        if (function != null) {
            function.apply(r.j().j(40008).j(50008, activity).j(String.class).xt());
        }
    }

    private void ej() {
        if (this.f24577g != null) {
            this.f24577g.apply(r.j().j(40009).j(50009, this).j(Void.class).xt());
        }
    }

    private int fk() {
        try {
            Integer num = (Integer) m.j(new Callable<Integer>() { // from class: com.bytedance.msdk.core.j.j.xt.j.r.xt.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(xt.this.ot());
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
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24577g;
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
    public String hk() {
        Object apply;
        Object obj;
        if (this.f24577g == null) {
            return "";
        }
        apply = this.f24577g.apply(r.j().j(40015).j(Map.class).xt());
        return (!(apply instanceof Map) || (obj = ((Map) apply).get("request_id")) == null) ? "" : obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void id() {
        if (this.f24577g != null) {
            this.f24577g.apply(r.j().j(40011).j(Void.class).xt());
        }
    }

    /* renamed from: if, reason: not valid java name */
    private void m97if() {
        if (this.f24577g != null) {
            this.f24577g.apply(r.j().j(40023).j(Void.class).xt());
        }
    }

    private String kj() {
        try {
            return (String) m.j(new Callable<String>() { // from class: com.bytedance.msdk.core.j.j.xt.j.r.xt.8
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return xt.this.hk();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            vl.j(th);
            return null;
        }
    }

    private void os() {
        if (this.f24577g != null) {
            this.f24577g.apply(r.j().j(40022).j(Void.class).xt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ot() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24577g;
        if (function == null) {
            return 0;
        }
        apply = function.apply(r.j().j(40003).j(Integer.class).xt());
        int intValue = apply instanceof Integer ? ((Integer) apply).intValue() : 0;
        if (intValue == -1) {
            return 0;
        }
        return intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Activity activity) {
        cw(activity);
    }

    private double so() {
        if (this.f24577g == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? ot() : fk();
    }

    private int to() {
        Object apply;
        if (this.f24577g != null) {
            apply = this.f24577g.apply(r.j().j(40021).j(Void.class).xt());
            if (apply instanceof Integer) {
                return ((Integer) apply).intValue();
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ve() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? fz() : xj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer vr() {
        Object apply;
        if (this.f24577g != null) {
            apply = this.f24577g.apply(r.j().j(40010).j(Boolean.class).xt());
            if ((apply instanceof Boolean) && ((Boolean) apply).booleanValue()) {
                return 2;
            }
        }
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i6) {
        if (this.f24577g != null) {
            this.f24577g.apply(r.j().j(40013).j(Void.class).j(50007, Integer.valueOf(i6)).xt());
        }
    }

    private String xj() {
        try {
            String str = (String) m.j(new Callable<String>() { // from class: com.bytedance.msdk.core.j.j.xt.j.r.xt.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return xt.this.ve();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e6) {
            vl.j(e6);
            return "";
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public Integer m() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? vr() : lo();
    }

    @Override // com.bytedance.msdk.xt.cw
    public String o() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? hk() : kj();
    }

    @Override // com.bytedance.msdk.xt.cw
    public boolean up() {
        Object apply;
        if (this.f24577g != null) {
            apply = this.f24577g.apply(r.j().j(40012).j(Boolean.class).xt());
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
                m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.r.xt.6
                    @Override // java.lang.Runnable
                    public void run() {
                        xt.this.x(t5);
                    }
                });
            }
        }
    }

    public xt(com.bytedance.msdk.core.j.j.xt.j jVar, Function<SparseArray<Object>, Object> function) {
        this.f24577g = function;
        this.qv = jVar;
        this.oq = jVar.xt;
        this.vl = jVar.f24490j;
        ej();
        oq oqVar = this.oq;
        if (oqVar != null) {
            if (oqVar.la()) {
                j(so());
            } else if (this.oq.rn()) {
                ws(ve());
            }
        }
        if (to() == 2) {
            qv(5);
            os();
            m97if();
        }
    }

    @Override // com.bytedance.msdk.xt.cw, com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        return (T) call(i6, pluginValueSet, cls);
    }

    public <T> T call(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i6 == 60009) {
            if (ay() != null) {
                ay().g_();
                return null;
            }
            return null;
        }
        if (i6 == 60004) {
            if (ay() != null) {
                ay().h_();
                return null;
            }
            return null;
        }
        if (i6 == 60005) {
            if (ay() != null) {
                ay().r();
                return null;
            }
            return null;
        }
        if (i6 == 60006) {
            if (ay() != null) {
                ay().cw();
                return null;
            }
            return null;
        }
        if (i6 == 60010) {
            if (ay() != null) {
                ay().up();
                return null;
            }
            return null;
        }
        if (i6 == 60007) {
            Map map = (Map) pluginValueSet.objectValue(50010, Map.class);
            if (ay() != null) {
                final HashMap hashMap = new HashMap();
                if (map != null) {
                    hashMap.putAll(map);
                }
                ay().j(new com.bytedance.msdk.api.cw.j() { // from class: com.bytedance.msdk.core.j.j.xt.j.r.xt.9
                    @Override // com.bytedance.msdk.api.cw.j
                    public boolean j() {
                        return true;
                    }

                    @Override // com.bytedance.msdk.api.cw.j
                    public String cw() {
                        return xt.this.vl != null ? xt.this.vl.p() : "";
                    }

                    @Override // com.bytedance.msdk.api.cw.j
                    public Map<String, Object> r() {
                        return hashMap;
                    }

                    @Override // com.bytedance.msdk.api.cw.j
                    public float xt() {
                        if (xt.this.vl != null) {
                            return xt.this.vl.h();
                        }
                        return 0.0f;
                    }
                });
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // com.bytedance.msdk.xt.cw
    public void w() {
        super.w();
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        if (jVar != null && jVar.cw()) {
            m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.r.xt.5
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.id();
                }
            });
        } else {
            id();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Map<String, Object> map) {
        if (this.f24577g != null) {
            this.f24577g.apply(r.j().j(40014).j(Void.class).j(50010, map).xt());
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void j(final Activity activity, Object obj, String str) {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        if (jVar != null && jVar.cw()) {
            m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.r.xt.3
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.r(activity);
                }
            });
        } else {
            r(activity);
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
            m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.r.xt.7
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
