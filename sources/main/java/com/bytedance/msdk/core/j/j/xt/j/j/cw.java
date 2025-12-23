package com.bytedance.msdk.core.j.j.xt.j.j;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.gromore.R;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.j.up.m;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw extends com.bytedance.msdk.xt.cw {

    /* renamed from: g, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f24529g;
    private oq oq;
    private com.bytedance.msdk.core.j.j.xt.j qv;
    private com.bytedance.msdk.api.j.xt vl;

    private Integer gs() {
        try {
            Integer num = (Integer) m.j(new Callable<Integer>() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.cw.9
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return cw.this.lv();
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

    private double ag() {
        if (this.f24529g == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? qf() : vm();
    }

    private String ay() {
        Object apply;
        if (this.f24529g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40041);
        sparseArray.put(-99999985, String.class);
        apply = this.f24529g.apply(sparseArray);
        return (String) apply;
    }

    private void cb() {
        if (this.f24529g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40060);
            sparseArray.put(-99999985, Void.class);
            this.f24529g.apply(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(int i6) {
        if (this.f24529g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40013);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50007, Integer.valueOf(i6));
            this.f24529g.apply(sparseArray);
        }
    }

    private boolean cw(View view) {
        Object apply;
        if (this.f24529g == null) {
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40055);
        sparseArray.put(-99999985, Boolean.class);
        sparseArray.put(50013, view);
        apply = this.f24529g.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    private double ej() {
        Object apply;
        if (this.f24529g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40051);
            sparseArray.put(-99999985, Integer.class);
            apply = this.f24529g.apply(sparseArray);
            if (apply instanceof Integer) {
                return ((Double) apply).doubleValue();
            }
        }
        return 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fj() {
        if (this.f24529g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40062);
            sparseArray.put(-99999985, Void.class);
            this.f24529g.apply(sparseArray);
        }
    }

    private int fk() {
        Object apply;
        if (this.f24529g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40048);
            sparseArray.put(-99999985, Integer.class);
            apply = this.f24529g.apply(sparseArray);
            if (apply instanceof Integer) {
                return ((Integer) apply).intValue();
            }
        }
        return 0;
    }

    private String fz() {
        Object apply;
        if (this.f24529g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40045);
        sparseArray.put(-99999985, String.class);
        apply = this.f24529g.apply(sparseArray);
        return (String) apply;
    }

    private String hk() {
        Object apply;
        if (this.f24529g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40042);
        sparseArray.put(-99999985, String.class);
        apply = this.f24529g.apply(sparseArray);
        return (String) apply;
    }

    private String id() {
        Object apply;
        if (this.f24529g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40044);
        sparseArray.put(-99999985, String.class);
        apply = this.f24529g.apply(sparseArray);
        return (String) apply;
    }

    /* renamed from: if, reason: not valid java name */
    private int m93if() {
        try {
            Integer num = (Integer) m.j(new Callable<Integer>() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.cw.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(cw.this.os());
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            if (num != null) {
                return num.intValue();
            }
            return 1;
        } catch (Exception e6) {
            vl.j(e6);
            return 1;
        }
    }

    private FrameLayout.LayoutParams ij() {
        com.bytedance.msdk.api.j.xt xtVar = this.vl;
        if (xtVar == null || xtVar.c() == null) {
            return null;
        }
        Object obj = this.vl.c().get(MediationConstant.KEY_GDT_NATIVE_LOGO_PARAMS);
        if (obj instanceof FrameLayout.LayoutParams) {
            return (FrameLayout.LayoutParams) obj;
        }
        return null;
    }

    private String kj() {
        Object apply;
        if (this.f24529g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40043);
        sparseArray.put(-99999985, String.class);
        apply = this.f24529g.apply(sparseArray);
        return (String) apply;
    }

    private String lc() {
        Object apply;
        if (this.f24529g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40038);
        sparseArray.put(-99999985, String.class);
        apply = this.f24529g.apply(sparseArray);
        return (String) apply;
    }

    private void lg() {
        if (this.f24529g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40009);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50009, this);
            this.f24529g.apply(sparseArray);
        }
    }

    private String lo() {
        Object apply;
        if (this.f24529g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40033);
        sparseArray.put(-99999985, String.class);
        apply = this.f24529g.apply(sparseArray);
        return (String) apply;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer lv() {
        Object apply;
        if (this.f24529g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40010);
            sparseArray.put(-99999985, Boolean.class);
            apply = this.f24529g.apply(sparseArray);
            if (((Boolean) apply).booleanValue()) {
                return 2;
            }
        }
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String mm() {
        Object apply;
        Object obj;
        if (this.f24529g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40015);
        sparseArray.put(-99999985, Map.class);
        apply = this.f24529g.apply(sparseArray);
        return (!(apply instanceof Map) || (obj = ((Map) apply).get("request_id")) == null) ? "" : obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String mp() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? sh() : mz();
    }

    private String mz() {
        try {
            String str = (String) m.j(new Callable<String>() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.cw.7
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return cw.this.mp();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e6) {
            vl.j(e6);
            return "";
        }
    }

    private com.bytedance.msdk.api.r.j.j.j nv() {
        return (com.bytedance.msdk.api.r.j.j.j) this.ae;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int os() {
        Object apply;
        if (this.f24529g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40053);
            sparseArray.put(-99999985, Integer.class);
            apply = this.f24529g.apply(sparseArray);
            int intValue = apply instanceof Integer ? ((Integer) apply).intValue() : -1;
            if (intValue == 0) {
                return 0;
            }
            if (intValue == 1) {
                return 6;
            }
            if (intValue == 2) {
                return 8;
            }
            if (intValue == 4) {
                return 2;
            }
            if (intValue == 8) {
                return 5;
            }
            if (intValue == 16) {
                return 4;
            }
            if (intValue == 32) {
                return 3;
            }
            if (intValue == 64) {
                return 7;
            }
        }
        return 1;
    }

    private int ot() {
        Object apply;
        if (this.f24529g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40049);
            sparseArray.put(-99999985, Integer.class);
            apply = this.f24529g.apply(sparseArray);
            if (apply instanceof Integer) {
                return ((Integer) apply).intValue();
            }
        }
        return 0;
    }

    private long pm() {
        Object apply;
        if (this.f24529g == null) {
            return 0L;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40040);
        sparseArray.put(-99999985, Long.class);
        apply = this.f24529g.apply(sparseArray);
        return ((Long) apply).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int qf() {
        Object apply;
        if (this.f24529g == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40003);
        sparseArray.put(-99999985, Integer.class);
        apply = this.f24529g.apply(sparseArray);
        int intValue = ((Integer) apply).intValue();
        if (intValue == -1) {
            return 0;
        }
        return intValue;
    }

    private String sh() {
        Object apply;
        if (this.f24529g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40004);
        sparseArray.put(-99999985, String.class);
        apply = this.f24529g.apply(sparseArray);
        return (String) apply;
    }

    private List<String> so() {
        Object apply;
        if (this.f24529g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40050);
            sparseArray.put(-99999985, List.class);
            apply = this.f24529g.apply(sparseArray);
            if (apply instanceof List) {
                return (List) apply;
            }
        }
        return null;
    }

    private boolean to() {
        Object apply;
        if (this.f24529g == null) {
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40052);
        sparseArray.put(-99999985, Boolean.class);
        apply = this.f24529g.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    private String ua() {
        try {
            return (String) m.j(new Callable<String>() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.cw.13
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return cw.this.mm();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            vl.j(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh() {
        if (this.f24529g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40011);
            sparseArray.put(-99999985, Void.class);
            this.f24529g.apply(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uo() {
        if (this.f24529g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40064);
            sparseArray.put(-99999985, Void.class);
            this.f24529g.apply(sparseArray);
        }
    }

    private String ve() {
        Object apply;
        if (this.f24529g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40047);
        sparseArray.put(-99999985, String.class);
        apply = this.f24529g.apply(sparseArray);
        return (String) apply;
    }

    private int vm() {
        try {
            Integer num = (Integer) m.j(new Callable<Integer>() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.cw.6
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(cw.this.qf());
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

    private String vr() {
        Object apply;
        if (this.f24529g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40032);
        sparseArray.put(-99999985, String.class);
        apply = this.f24529g.apply(sparseArray);
        return (String) apply;
    }

    private int vu() {
        Object apply;
        if (this.f24529g == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40021);
        sparseArray.put(-99999985, Integer.class);
        apply = this.f24529g.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    private void x(int i6) {
        if (this.f24529g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40007);
            sparseArray.put(-99999985, Boolean.class);
            sparseArray.put(50007, Integer.valueOf(i6));
            this.f24529g.apply(sparseArray);
        }
    }

    private String xc() {
        Object apply;
        if (this.f24529g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40039);
        sparseArray.put(-99999985, String.class);
        apply = this.f24529g.apply(sparseArray);
        return (String) apply;
    }

    private String xj() {
        Object apply;
        if (this.f24529g == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40046);
        sparseArray.put(-99999985, String.class);
        apply = this.f24529g.apply(sparseArray);
        return (String) apply;
    }

    private void xt(List<View> list) {
        if (this.f24529g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40059);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50021, list);
            this.f24529g.apply(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zi() {
        if (this.f24529g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40061);
            sparseArray.put(-99999985, Void.class);
            this.f24529g.apply(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zw() {
        if (this.f24529g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40063);
            sparseArray.put(-99999985, Void.class);
            this.f24529g.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void av() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        if (jVar == null || !jVar.cw()) {
            fj();
        } else {
            m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.cw.3
                @Override // java.lang.Runnable
                public void run() {
                    cw.this.fj();
                }
            });
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void i() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        if (jVar == null || !jVar.cw()) {
            zi();
        } else {
            m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.cw.2
                @Override // java.lang.Runnable
                public void run() {
                    cw.this.zi();
                }
            });
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public Integer m() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? lv() : gs();
    }

    @Override // com.bytedance.msdk.xt.cw
    public String o() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? mm() : ua();
    }

    @Override // com.bytedance.msdk.xt.cw
    public int r() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? os() : m93if();
    }

    @Override // com.bytedance.msdk.xt.cw
    public boolean up() {
        Object apply;
        if (this.f24529g == null) {
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40012);
        sparseArray.put(-99999985, Boolean.class);
        apply = this.f24529g.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    public cw(com.bytedance.msdk.core.j.j.xt.j jVar, Function<SparseArray<Object>, Object> function) {
        this.f24529g = function;
        this.qv = jVar;
        this.oq = jVar.xt;
        this.vl = jVar.f24490j;
        lg();
        f(lc());
        v(xc());
        xt(pm());
        kt((int) pm());
        x(ay());
        ch(hk());
        s(kj());
        vl(id());
        la(vr());
        gq(lo());
        p(fz());
        a(xj());
        l(ve());
        w(fk());
        w(ot());
        j(so());
        r(ej());
        rn(vr());
        tl(to());
        oq oqVar = this.oq;
        if (oqVar != null) {
            if (oqVar.la()) {
                j(ag());
            } else if (this.oq.rn()) {
                ws(mp());
            }
        }
        if (vu() == 2) {
            qv(5);
        } else if (vu() != 1 && vu() != 4) {
            if (vu() == 3) {
                qv(4);
            } else {
                qv(3);
            }
        } else {
            qv(3);
        }
        if (to()) {
            vl(4);
        } else {
            vl(3);
        }
        ae(false);
    }

    @Override // com.bytedance.msdk.xt.cw, com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i6 == 60004) {
            if (this.ae instanceof com.bytedance.msdk.api.r.j.j.j) {
                nv().j((View) null);
            }
        } else if (i6 == 60009 && (this.ae instanceof com.bytedance.msdk.api.r.j.j.j)) {
            nv().xt(null);
        }
        return null;
    }

    @Override // com.bytedance.msdk.xt.cw
    public void w() {
        super.w();
        m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.cw.10
            @Override // java.lang.Runnable
            public void run() {
                cw.this.uh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Map<String, Object> map) {
        if (this.f24529g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40014);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50010, map);
            this.f24529g.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void j(@NonNull final Activity activity, @NonNull final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final com.bytedance.msdk.api.r.j.ae.oq oqVar, List<View> list4) {
        super.j(activity, viewGroup, list, list2, list3, oqVar, list4);
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        if (jVar != null && jVar.cw()) {
            m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.cw.8
                @Override // java.lang.Runnable
                public void run() {
                    cw.this.j(activity, viewGroup, (List<View>) list, (List<View>) list2, (List<View>) list3, oqVar);
                }
            });
        } else {
            j(activity, viewGroup, list, list2, list3, oqVar);
        }
    }

    private ViewGroup xt(Context context) {
        Object apply;
        if (this.f24529g == null || context == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40055);
        sparseArray.put(-99999985, ViewGroup.class);
        sparseArray.put(10000, context);
        apply = this.f24529g.apply(sparseArray);
        return (ViewGroup) apply;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Context context, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.r.j.ae.oq oqVar) {
        ViewGroup xt;
        FrameLayout j6;
        Object tag;
        if (list3 != null) {
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            list2.addAll(list3);
        }
        List<View> list4 = list2;
        oq oqVar2 = this.oq;
        if (oqVar2 != null && oqVar2.h()) {
            x(qf());
        }
        if (context == null) {
            context = viewGroup.getContext();
        }
        Context context2 = context;
        int i6 = 0;
        if (viewGroup.getChildCount() != 0 && cw(viewGroup.getChildAt(0))) {
            xt = (ViewGroup) viewGroup.getChildAt(0);
            while (i6 < xt.getChildCount()) {
                View childAt = xt.getChildAt(i6);
                if (childAt == null || ((tag = childAt.getTag(R.id.tt_mediation_gdt_developer_view_tag_key)) != null && (tag instanceof String) && ((String) tag).equals(MediationConstant.TT_GDT_NATIVE_VIEW_TAG))) {
                    i6++;
                } else {
                    xt.removeView(childAt);
                }
            }
        } else {
            xt = xt(context2);
            if (xt != null) {
                xt.setTag(R.id.tt_mediation_gdt_developer_view_root_tag_key, MediationConstant.TT_GDT_NATIVE_ROOT_VIEW_TAG);
                while (viewGroup.getChildCount() > 0) {
                    View childAt2 = viewGroup.getChildAt(0);
                    childAt2.setTag(R.id.tt_mediation_gdt_developer_view_tag_key, MediationConstant.TT_GDT_NATIVE_VIEW_TAG);
                    viewGroup.removeViewInLayout(childAt2);
                    xt.addView(childAt2, childAt2.getLayoutParams());
                }
                viewGroup.removeAllViews();
                viewGroup.addView(xt, -1, -1);
            }
        }
        ViewGroup viewGroup2 = xt;
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(oqVar.ae);
        j(context2, viewGroup2, ij(), list, list4);
        if (frameLayout != null && st() == 5 && (j6 = j(context2)) != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(j6, -1, -1);
            j(j6);
        }
        if (!TextUtils.isEmpty(fz())) {
            View findViewById = viewGroup.findViewById(oqVar.f24358r);
            ArrayList arrayList = new ArrayList();
            arrayList.add(findViewById);
            xt(arrayList);
        }
        cb();
    }

    @Override // com.bytedance.msdk.xt.cw
    public void xt(Map<String, Object> map) {
        oq oqVar = this.oq;
        if (oqVar != null && oqVar.la()) {
            final int t5 = (int) t();
            com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
            if (jVar != null && jVar.cw()) {
                m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.cw.11
                    @Override // java.lang.Runnable
                    public void run() {
                        cw.this.ch(t5);
                    }
                });
            } else {
                ch(t5);
            }
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void xt() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        if (jVar != null && jVar.cw()) {
            m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.cw.5
                @Override // java.lang.Runnable
                public void run() {
                    cw.this.uo();
                }
            });
        } else {
            uo();
        }
    }

    private void j(FrameLayout frameLayout) {
        Object obj;
        if (this.f24529g != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 40058);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50013, frameLayout);
            com.bytedance.msdk.api.j.xt xtVar = this.vl;
            if (xtVar != null && xtVar.c() != null && (obj = this.vl.c().get(MediationConstant.KEY_GDT_VIDEO_OPTION)) != null) {
                sparseArray.put(50020, obj);
            }
            this.f24529g.apply(sparseArray);
        }
    }

    private FrameLayout j(Context context) {
        Object apply;
        if (this.f24529g == null || context == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40057);
        sparseArray.put(-99999985, FrameLayout.class);
        sparseArray.put(10000, context);
        apply = this.f24529g.apply(sparseArray);
        return (FrameLayout) apply;
    }

    private void j(Context context, ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        if (this.f24529g == null || context == null) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40056);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(10000, context);
        sparseArray.put(50013, viewGroup);
        sparseArray.put(50017, layoutParams);
        sparseArray.put(50018, list);
        sparseArray.put(50019, list2);
        this.f24529g.apply(sparseArray);
    }

    @Override // com.bytedance.msdk.xt.cw
    public void j(final Map<String, Object> map) {
        oq oqVar = this.oq;
        if (oqVar == null || !oqVar.la() || map == null) {
            return;
        }
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        if (jVar != null && jVar.cw()) {
            m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.cw.12
                @Override // java.lang.Runnable
                public void run() {
                    cw.this.m((Map<String, Object>) map);
                }
            });
        } else {
            m(map);
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void j() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        if (jVar != null && jVar.cw()) {
            m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.cw.4
                @Override // java.lang.Runnable
                public void run() {
                    cw.this.zw();
                }
            });
        } else {
            zw();
        }
    }
}
