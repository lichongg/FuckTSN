package com.bytedance.msdk.core.j.j.xt.j.m;

import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.j.up.m;
import com.bytedance.sdk.component.utils.vl;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw extends com.bytedance.msdk.xt.cw {

    /* renamed from: g, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f24563g;
    private oq oq;
    private com.bytedance.msdk.core.j.j.xt.j qv;
    private com.bytedance.msdk.api.j.xt vl;

    private Integer ve() {
        try {
            Integer num = (Integer) m.j(new Callable<Integer>() { // from class: com.bytedance.msdk.core.j.j.xt.j.m.cw.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return cw.this.xj();
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
        return (jVar == null || !jVar.cw()) ? xj() : ve();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(int i6) {
        if (this.f24563g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40013);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50007, Integer.valueOf(i6));
            this.f24563g.apply(sparseArray);
        }
    }

    private void cw(Activity activity) {
        if (this.f24563g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40008);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50008, activity);
            this.f24563g.apply(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ej() {
        Object apply;
        if (this.f24563g == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40003);
        sparseArray.put(-99999985, Integer.class);
        apply = this.f24563g.apply(sparseArray);
        int intValue = apply instanceof Integer ? ((Integer) apply).intValue() : 0;
        if (intValue == -1) {
            return 0;
        }
        return intValue;
    }

    private String fk() {
        Object apply;
        if (this.f24563g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40004);
        sparseArray.put(-99999985, String.class);
        apply = this.f24563g.apply(sparseArray);
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    private String fz() {
        try {
            return (String) m.j(new Callable<String>() { // from class: com.bytedance.msdk.core.j.j.xt.j.m.cw.7
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return cw.this.lo();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            vl.j(th);
            return null;
        }
    }

    /* renamed from: if, reason: not valid java name */
    private void m96if() {
        if (this.f24563g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40009);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50009, this);
            this.f24563g.apply(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String lo() {
        Object apply;
        Object obj;
        if (this.f24563g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40015);
        sparseArray.put(-99999985, Map.class);
        apply = this.f24563g.apply(sparseArray);
        return (!(apply instanceof Map) || (obj = ((Map) apply).get("request_id")) == null) ? "" : obj.toString();
    }

    private double os() {
        if (this.f24563g == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? ej() : to();
    }

    private String ot() {
        try {
            String str = (String) m.j(new Callable<String>() { // from class: com.bytedance.msdk.core.j.j.xt.j.m.cw.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return cw.this.so();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e6) {
            vl.j(e6);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Activity activity) {
        oq oqVar = this.oq;
        if (oqVar != null && oqVar.h()) {
            x(ej());
        }
        cw(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String so() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? fk() : ot();
    }

    private int to() {
        try {
            Integer num = (Integer) m.j(new Callable<Integer>() { // from class: com.bytedance.msdk.core.j.j.xt.j.m.cw.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(cw.this.ej());
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

    private com.bytedance.msdk.api.r.j.tl.j vr() {
        return (com.bytedance.msdk.api.r.j.tl.j) this.ae;
    }

    private void x(int i6) {
        if (this.f24563g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40007);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50007, Integer.valueOf(i6));
            this.f24563g.apply(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer xj() {
        Object apply;
        if (this.f24563g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40010);
            sparseArray.put(-99999985, Boolean.class);
            apply = this.f24563g.apply(sparseArray);
            if (((Boolean) apply).booleanValue()) {
                return 2;
            }
        }
        return 4;
    }

    @Override // com.bytedance.msdk.xt.cw
    public String o() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? lo() : fz();
    }

    @Override // com.bytedance.msdk.xt.cw
    public boolean up() {
        Object apply;
        if (this.f24563g == null) {
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40012);
        sparseArray.put(-99999985, Boolean.class);
        apply = this.f24563g.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.msdk.xt.cw
    public void xt(Map<String, Object> map) {
        oq oqVar = this.oq;
        if (oqVar != null && oqVar.la()) {
            final int t5 = (int) t();
            com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
            if (jVar == null || !jVar.cw()) {
                ch(t5);
            } else {
                m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.m.cw.5
                    @Override // java.lang.Runnable
                    public void run() {
                        cw.this.ch(t5);
                    }
                });
            }
        }
    }

    public cw(com.bytedance.msdk.core.j.j.xt.j jVar, Function<SparseArray<Object>, Object> function) {
        this.f24563g = function;
        this.qv = jVar;
        this.oq = jVar.xt;
        this.vl = jVar.f24490j;
        m96if();
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
        if (i6 == 60002) {
            if (this.ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                vr().i_();
                return null;
            }
            return null;
        }
        if (i6 == 60004) {
            if (this.ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                vr().j_();
                return null;
            }
            return null;
        }
        if (i6 == 60005) {
            if (this.ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                vr().r();
                return null;
            }
            return null;
        }
        if (i6 == 60006) {
            if (this.ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                vr().cw();
                return null;
            }
            return null;
        }
        if (i6 == 60007) {
            Map map = (Map) pluginValueSet.objectValue(50010, Map.class);
            if (this.ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                final HashMap hashMap = new HashMap();
                if (map != null) {
                    hashMap.putAll(map);
                }
                vr().j(new com.bytedance.msdk.api.cw.j() { // from class: com.bytedance.msdk.core.j.j.xt.j.m.cw.8
                    @Override // com.bytedance.msdk.api.cw.j
                    public boolean j() {
                        return true;
                    }

                    @Override // com.bytedance.msdk.api.cw.j
                    public String cw() {
                        return cw.this.vl != null ? cw.this.vl.p() : "";
                    }

                    @Override // com.bytedance.msdk.api.cw.j
                    public Map<String, Object> r() {
                        return hashMap;
                    }

                    @Override // com.bytedance.msdk.api.cw.j
                    public float xt() {
                        if (cw.this.vl != null) {
                            return cw.this.vl.h();
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
        if (this.f24563g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40011);
            sparseArray.put(-99999985, Void.class);
            this.f24563g.apply(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Map<String, Object> map) {
        if (this.f24563g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40014);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50010, map);
            this.f24563g.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void j(final Activity activity, Object obj, String str) {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        if (jVar != null && jVar.cw()) {
            m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.m.cw.3
                @Override // java.lang.Runnable
                public void run() {
                    cw.this.r(activity);
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
            m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.m.cw.6
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
