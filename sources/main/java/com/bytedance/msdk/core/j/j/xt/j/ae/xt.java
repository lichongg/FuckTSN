package com.bytedance.msdk.core.j.j.xt.j.ae;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.j.up.m;
import com.bytedance.msdk.j.xt.up;
import com.bytedance.msdk.xt.cw;
import com.bytedance.sdk.component.utils.vl;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends cw {

    /* renamed from: g, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f24494g;
    private oq oq;
    private com.bytedance.msdk.core.j.j.xt.j qv;

    private void up(ViewGroup viewGroup) {
        oq oqVar = this.oq;
        if (oqVar != null) {
            int oq = oqVar.oq();
            if (oq == 2) {
                xt(viewGroup);
            } else if (oq == 0 || oq == 1) {
                cw(viewGroup);
            }
        }
    }

    private Integer ve() {
        try {
            Integer num = (Integer) m.j(new Callable<Integer>() { // from class: com.bytedance.msdk.core.j.j.xt.j.ae.xt.4
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
    public boolean lx() {
        return true;
    }

    @Override // com.bytedance.msdk.xt.cw
    public Integer m() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? xj() : ve();
    }

    private void cw(ViewGroup viewGroup) {
        if (this.f24494g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40029);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50013, viewGroup);
            this.f24494g.apply(sparseArray);
        }
    }

    private int ej() {
        try {
            Integer num = (Integer) m.j(new Callable<Integer>() { // from class: com.bytedance.msdk.core.j.j.xt.j.ae.xt.1
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
        if (this.f24494g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40004);
        sparseArray.put(-99999985, String.class);
        apply = this.f24494g.apply(sparseArray);
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    private void fz() {
        if (this.f24494g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40011);
            sparseArray.put(-99999985, Void.class);
            this.f24494g.apply(sparseArray);
        }
    }

    private up id() {
        return (up) this.ae;
    }

    /* renamed from: if, reason: not valid java name */
    private void m90if() {
        if (this.f24494g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40009);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50009, this);
            this.f24494g.apply(sparseArray);
        }
    }

    private String lo() {
        try {
            return (String) m.j(new Callable<String>() { // from class: com.bytedance.msdk.core.j.j.xt.j.ae.xt.7
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return xt.this.vr();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            vl.j(th);
            return null;
        }
    }

    private double os() {
        if (this.f24494g == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? to() : ej();
    }

    private String ot() {
        try {
            String str = (String) m.j(new Callable<String>() { // from class: com.bytedance.msdk.core.j.j.xt.j.ae.xt.2
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
    public void r(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            Context context = viewGroup.getContext();
            if (context instanceof Activity) {
                ViewGroup viewGroup2 = (ViewGroup) ((Activity) context).findViewById(R.id.content);
                if (viewGroup.getParent() == null) {
                    if (viewGroup2 != null) {
                        viewGroup.setAlpha(0.0f);
                        viewGroup2.addView(viewGroup);
                    }
                    up(viewGroup);
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(viewGroup);
                        viewGroup.setAlpha(1.0f);
                        return;
                    }
                    return;
                }
            }
            up(viewGroup);
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
        if (this.f24494g == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40003);
        sparseArray.put(-99999985, Integer.class);
        apply = this.f24494g.apply(sparseArray);
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
        if (this.f24494g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40015);
        sparseArray.put(-99999985, Map.class);
        apply = this.f24494g.apply(sparseArray);
        return (!(apply instanceof Map) || (obj = ((Map) apply).get("request_id")) == null) ? "" : obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i6) {
        if (this.f24494g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40013);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50007, Integer.valueOf(i6));
            this.f24494g.apply(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer xj() {
        Object apply;
        if (this.f24494g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40010);
            sparseArray.put(-99999985, Boolean.class);
            apply = this.f24494g.apply(sparseArray);
            if (((Boolean) apply).booleanValue()) {
                return 2;
            }
        }
        return 4;
    }

    private void xt(ViewGroup viewGroup) {
        if (this.f24494g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40008);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50013, viewGroup);
            this.f24494g.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public String o() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? vr() : lo();
    }

    public xt(com.bytedance.msdk.core.j.j.xt.j jVar, Function<SparseArray<Object>, Object> function) {
        this.f24494g = function;
        this.qv = jVar;
        this.oq = jVar.xt;
        m90if();
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
        if (i6 == 60013) {
            if (id() != null) {
                id().xt(2);
                return null;
            }
            return null;
        }
        if (i6 == 60014) {
            id();
            return null;
        }
        if (i6 == 60015) {
            id();
            return null;
        }
        if (i6 == 60009) {
            if (id() != null) {
                id().up();
                return null;
            }
            return null;
        }
        if (i6 == 60004 && id() != null) {
            id().r();
            return null;
        }
        return null;
    }

    @Override // com.bytedance.msdk.xt.cw
    public void w() {
        super.w();
        fz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Map<String, Object> map) {
        if (this.f24494g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40014);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50010, map);
            this.f24494g.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void j(final ViewGroup viewGroup) {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        if (jVar != null && jVar.cw()) {
            m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.ae.xt.3
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.r(viewGroup);
                }
            });
        } else {
            r(viewGroup);
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public boolean up() {
        Object apply;
        if (this.f24494g == null) {
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40012);
        sparseArray.put(-99999985, Boolean.class);
        apply = this.f24494g.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.msdk.xt.cw
    public void j(final Map<String, Object> map) {
        oq oqVar = this.oq;
        if (oqVar == null || !oqVar.la() || map == null) {
            return;
        }
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        if (jVar != null && jVar.cw()) {
            m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.ae.xt.6
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.m((Map<String, Object>) map);
                }
            });
        } else {
            m(map);
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void xt(Map<String, Object> map) {
        oq oqVar = this.oq;
        if (oqVar != null && oqVar.la()) {
            final int t5 = (int) t();
            com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
            if (jVar != null && jVar.cw()) {
                m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.ae.xt.5
                    @Override // java.lang.Runnable
                    public void run() {
                        xt.this.x(t5);
                    }
                });
            } else {
                x(t5);
            }
        }
    }

    public void j(com.bytedance.msdk.core.j.j.xt.j.m.xt xtVar) {
        int i6;
        String str;
        if (id() != null) {
            if (xtVar != null) {
                i6 = xtVar.j();
                str = xtVar.xt();
            } else {
                i6 = 0;
                str = "";
            }
            id().j(new com.bytedance.msdk.api.j(i6, str));
        }
    }
}
