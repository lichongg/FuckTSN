package com.bytedance.msdk.core.j.j.xt.j.up;

import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.j.up.m;
import com.bytedance.msdk.xt.cw;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.i.r;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends cw {

    /* renamed from: g, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f24589g;
    private oq oq;
    private com.bytedance.msdk.core.j.j.xt.j qv;

    private Integer xj() {
        try {
            Integer num = (Integer) m.j(new Callable<Integer>() { // from class: com.bytedance.msdk.core.j.j.xt.j.up.xt.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return xt.this.fz();
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

    @Override // com.bytedance.msdk.xt.cw
    public Integer m() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? fz() : xj();
    }

    private void cw(Activity activity) {
        Function<SparseArray<Object>, Object> function = this.f24589g;
        if (function != null) {
            function.apply(r.j().j(40008).j(50008, activity).j(Void.class).xt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ej() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24589g;
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

    private String fk() {
        try {
            String str = (String) m.j(new Callable<String>() { // from class: com.bytedance.msdk.core.j.j.xt.j.up.xt.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return xt.this.ot();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e6) {
            vl.j(e6);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer fz() {
        Object apply;
        if (this.f24589g != null) {
            apply = this.f24589g.apply(r.j().j(40010).j(Boolean.class).xt());
            if ((apply instanceof Boolean) && ((Boolean) apply).booleanValue()) {
                return 2;
            }
        }
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String id() {
        Object apply;
        Object obj;
        if (this.f24589g == null) {
            return "";
        }
        apply = this.f24589g.apply(r.j().j(40015).j(Map.class).xt());
        return (!(apply instanceof Map) || (obj = ((Map) apply).get("request_id")) == null) ? "" : obj.toString();
    }

    /* renamed from: if, reason: not valid java name */
    private int m98if() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24589g;
        if (function != null) {
            apply = function.apply(r.j().j(40021).j(Integer.class).xt());
            if (apply instanceof Integer) {
                return ((Integer) apply).intValue();
            }
        }
        return 0;
    }

    private com.bytedance.msdk.api.r.j.up.j kj() {
        return (com.bytedance.msdk.api.r.j.up.j) this.ae;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lo() {
        if (this.f24589g != null) {
            this.f24589g.apply(r.j().j(40011).j(Void.class).xt());
        }
    }

    private void os() {
        Function<SparseArray<Object>, Object> function = this.f24589g;
        if (function != null) {
            function.apply(r.j().j(40009).j(50009, this).j(Integer.class).xt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ot() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? ve() : fk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Activity activity) {
        cw(activity);
    }

    private int so() {
        try {
            Integer num = (Integer) m.j(new Callable<Integer>() { // from class: com.bytedance.msdk.core.j.j.xt.j.up.xt.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(xt.this.ej());
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

    private double to() {
        if (this.f24589g == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? ej() : so();
    }

    private String ve() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24589g;
        if (function == null) {
            return "";
        }
        apply = function.apply(r.j().j(40004).j(String.class).xt());
        if (apply instanceof String) {
            return apply.toString();
        }
        return null;
    }

    private String vr() {
        try {
            return (String) m.j(new Callable<String>() { // from class: com.bytedance.msdk.core.j.j.xt.j.up.xt.8
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return xt.this.id();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            vl.j(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i6) {
        if (this.f24589g != null) {
            this.f24589g.apply(r.j().j(40013).j(Void.class).j(50007, Integer.valueOf(i6)).xt());
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public String o() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? id() : vr();
    }

    @Override // com.bytedance.msdk.xt.cw
    public boolean up() {
        Object apply;
        if (this.f24589g != null) {
            apply = this.f24589g.apply(r.j().j(40012).j(Boolean.class).xt());
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
                m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.up.xt.6
                    @Override // java.lang.Runnable
                    public void run() {
                        xt.this.x(t5);
                    }
                });
            }
        }
    }

    public xt(com.bytedance.msdk.core.j.j.xt.j jVar, Function<SparseArray<Object>, Object> function) {
        this.f24589g = function;
        this.qv = jVar;
        this.oq = jVar.xt;
        os();
        oq oqVar = this.oq;
        if (oqVar != null) {
            if (oqVar.la()) {
                j(to());
            } else if (this.oq.rn()) {
                ws(ot());
            }
        }
        if (m98if() == 2) {
            qv(5);
        } else {
            qv(3);
        }
    }

    @Override // com.bytedance.msdk.xt.cw, com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i6 == 60011) {
            if (kj() != null) {
                kj().r();
                return null;
            }
            return null;
        }
        if (i6 == 60009) {
            if (kj() != null) {
                kj().j();
                return null;
            }
            return null;
        }
        if (i6 == 60004) {
            if (kj() != null) {
                kj().xt();
                return null;
            }
            return null;
        }
        if (i6 == 60012) {
            if (kj() != null) {
                kj().up();
                return null;
            }
            return null;
        }
        if (i6 == 60006 && kj() != null) {
            kj().cw();
            return null;
        }
        return null;
    }

    @Override // com.bytedance.msdk.xt.cw
    public void w() {
        super.w();
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        if (jVar != null && jVar.cw()) {
            m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.up.xt.5
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.lo();
                }
            });
        } else {
            lo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Map<String, Object> map) {
        if (this.f24589g != null) {
            this.f24589g.apply(r.j().j(40014).j(Void.class).j(50010, map).xt());
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void j(final Activity activity, Object obj, String str) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        if (jVar != null && jVar.cw()) {
            m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.up.xt.3
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
            m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.up.xt.7
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
