package com.bytedance.msdk.core.j.j.xt.j.cw;

import a1.a;
import a1.b;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.gromore.R;
import com.bytedance.msdk.api.r.j.ae.tl;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.j.up.m;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.i.r;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends com.bytedance.msdk.xt.cw {

    /* renamed from: g, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f24512g;
    private Context jy;
    private oq oq;
    private com.bytedance.msdk.core.j.j.xt.j qv;
    private com.bytedance.msdk.api.j.xt vl;

    private Integer gs() {
        try {
            Integer num = (Integer) m.j(new Callable<Integer>() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.xt.11
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return xt.this.lv();
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
        if (this.f24512g == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? qf() : vm();
    }

    private String ay() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function == null) {
            return "";
        }
        apply = function.apply(r.j().j(40041).j(String.class).xt());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    private void cb() {
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function != null) {
            function.apply(r.j().j(40060).j(Void.class).xt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(int i6) {
        if (this.f24512g != null) {
            this.f24512g.apply(r.j().j(40013).j(Void.class).j(50007, Integer.valueOf(i6)).xt());
        }
    }

    private void cw(List<View> list) {
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function != null) {
            function.apply(r.j().j(40059).j(50021, list).j(Void.class).xt());
        }
    }

    private double ej() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function != null) {
            apply = function.apply(r.j().j(40051).j(Integer.class).xt());
            if (apply instanceof Integer) {
                return ((Double) apply).doubleValue();
            }
        }
        return 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fj() {
        if (this.f24512g != null) {
            this.f24512g.apply(r.j().j(40062).j(Void.class).xt());
        }
    }

    private int fk() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function != null) {
            apply = function.apply(r.j().j(40048).j(Integer.class).xt());
            if (apply instanceof Integer) {
                return ((Integer) apply).intValue();
            }
        }
        return 0;
    }

    private String fz() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function == null) {
            return "";
        }
        apply = function.apply(r.j().j(40045).j(String.class).xt());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    private String hk() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function == null) {
            return "";
        }
        apply = function.apply(r.j().j(40042).j(String.class).xt());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    private String id() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function == null) {
            return "";
        }
        apply = function.apply(r.j().j(40044).j(String.class).xt());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    /* renamed from: if, reason: not valid java name */
    private int m92if() {
        try {
            Integer num = (Integer) m.j(new Callable<Integer>() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.xt.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(xt.this.os());
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
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function == null) {
            return "";
        }
        apply = function.apply(r.j().j(40043).j(String.class).xt());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    private String lc() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function == null) {
            return "";
        }
        apply = function.apply(r.j().j(40038).j(Long.class).xt());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    private void lg() {
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function != null) {
            function.apply(r.j().j(40009).j(50009, this).j(Integer.class).xt());
        }
    }

    private String lo() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function == null) {
            return "";
        }
        apply = function.apply(r.j().j(40033).j(String.class).xt());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer lv() {
        Object apply;
        if (this.f24512g != null) {
            apply = this.f24512g.apply(r.j().j(40010).j(Boolean.class).xt());
            if ((apply instanceof Boolean) && ((Boolean) apply).booleanValue()) {
                return 2;
            }
        }
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String mm() {
        Object apply;
        Object obj;
        if (this.f24512g == null) {
            return "";
        }
        apply = this.f24512g.apply(r.j().j(40015).j(Map.class).xt());
        return (!(apply instanceof Map) || (obj = ((Map) apply).get("request_id")) == null) ? "" : obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String mp() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? sh() : mz();
    }

    private String mz() {
        try {
            String str = (String) m.j(new Callable<String>() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.xt.8
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return xt.this.mp();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e6) {
            vl.j(e6);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int os() {
        Object apply;
        if (this.f24512g != null) {
            apply = this.f24512g.apply(r.j().j(40053).j(Void.class).xt());
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
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function != null) {
            apply = function.apply(r.j().j(40049).j(Integer.class).xt());
            if (apply instanceof Integer) {
                return ((Integer) apply).intValue();
            }
        }
        return 0;
    }

    private long pm() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function != null) {
            apply = function.apply(r.j().j(40040).j(Long.class).xt());
            if (apply instanceof Long) {
                return ((Long) apply).longValue();
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int qf() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24512g;
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

    private String sh() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function == null) {
            return "";
        }
        apply = function.apply(r.j().j(40004).j(String.class).xt());
        if (apply instanceof String) {
            return apply.toString();
        }
        return null;
    }

    private List<String> so() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function != null) {
            apply = function.apply(r.j().j(40050).j(List.class).xt());
            if (apply instanceof List) {
                return (List) apply;
            }
        }
        return null;
    }

    private boolean to() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function != null) {
            apply = function.apply(r.j().j(40052).j(Boolean.class).xt());
            if ((apply instanceof Boolean) && ((Boolean) apply).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private String ua() {
        try {
            return (String) m.j(new Callable<String>() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.xt.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return xt.this.mm();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            vl.j(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh() {
        if (this.f24512g != null) {
            this.f24512g.apply(r.j().j(40011).j(Void.class).xt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uo() {
        if (this.f24512g != null) {
            this.f24512g.apply(r.j().j(40064).j(Void.class).xt());
        }
    }

    private String ve() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function == null) {
            return "";
        }
        apply = function.apply(r.j().j(40047).j(String.class).xt());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    private int vm() {
        try {
            Integer num = (Integer) m.j(new Callable<Integer>() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.xt.7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(xt.this.qf());
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
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function == null) {
            return "";
        }
        apply = function.apply(r.j().j(40032).j(String.class).xt());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    private int vu() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function != null) {
            apply = function.apply(r.j().j(40021).j(Integer.class).xt());
            if (apply instanceof Integer) {
                return ((Integer) apply).intValue();
            }
        }
        return 0;
    }

    private void x(int i6) {
        if (this.f24512g != null) {
            this.f24512g.apply(r.j().j(40007).j(50007, Integer.valueOf(i6)).j(Void.class).xt());
        }
    }

    private String xc() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function == null) {
            return "";
        }
        apply = function.apply(r.j().j(40039).j(Long.class).xt());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    private String xj() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function == null) {
            return "";
        }
        apply = function.apply(r.j().j(40046).j(String.class).xt());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    private void xt(List<View> list) {
        if (TextUtils.isEmpty(fz())) {
            return;
        }
        cw(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zi() {
        if (this.f24512g != null) {
            this.f24512g.apply(r.j().j(40061).j(Void.class).xt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zw() {
        if (this.f24512g != null) {
            this.f24512g.apply(r.j().j(40063).j(Void.class).xt());
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void av() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        if (jVar == null || !jVar.cw()) {
            fj();
        } else {
            m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.xt.4
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.fj();
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
            m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.xt.3
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.zi();
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
    public View oq() {
        if (!(com.bytedance.msdk.j.up.j.j(this.jy) instanceof Context)) {
            return null;
        }
        final FrameLayout j6 = j(this.jy);
        if (j6 != null) {
            j6.removeAllViews();
            j6.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            if (j6.getViewTreeObserver() != null) {
                j6.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.xt.10
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (j6.getVisibility() == 0) {
                            xt.this.j(j6);
                            if (j6.getViewTreeObserver() != null) {
                                j6.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                        }
                    }
                });
            }
        }
        return j6;
    }

    @Override // com.bytedance.msdk.xt.cw
    public int r() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        return (jVar == null || !jVar.cw()) ? os() : m92if();
    }

    @Override // com.bytedance.msdk.xt.cw
    public boolean up() {
        Object apply;
        if (this.f24512g != null) {
            apply = this.f24512g.apply(r.j().j(40012).j(Boolean.class).xt());
            if ((apply instanceof Boolean) && ((Boolean) apply).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public xt(Context context, com.bytedance.msdk.core.j.j.xt.j jVar, Function<SparseArray<Object>, Object> function) {
        this.jy = context;
        this.f24512g = function;
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
        if (i6 == 60018) {
            tl tlVar = this.xt;
            if (tlVar != null) {
                tlVar.xt();
            }
        } else if (i6 == 60019) {
            tl tlVar2 = this.xt;
            if (tlVar2 != null) {
                tlVar2.cw();
            }
        } else if (i6 == 60020) {
            tl tlVar3 = this.xt;
            if (tlVar3 != null) {
                tlVar3.r();
            }
        } else if (i6 == 60005) {
            tl tlVar4 = this.xt;
            if (tlVar4 != null) {
                tlVar4.up();
            }
        } else if (i6 == 60010) {
            com.bytedance.msdk.core.j.j.xt.j.m.xt xtVar = new com.bytedance.msdk.core.j.j.xt.j.m.xt(b.a(pluginValueSet.objectValue(50006, a.a())));
            tl tlVar5 = this.xt;
            if (tlVar5 != null) {
                tlVar5.j(new com.bytedance.msdk.api.j(xtVar.j(), xtVar.xt()));
            }
        } else if (i6 == 60004) {
            if (rh() == 5) {
                com.bytedance.msdk.api.r.j.cw.j jVar = this.f25337m;
                if (jVar != null) {
                    jVar.j(null);
                }
            } else {
                com.bytedance.msdk.api.r.j.ae.xt xtVar2 = this.f25334j;
                if (xtVar2 != null) {
                    xtVar2.j(null);
                }
            }
        } else if (i6 == 60009) {
            if (rh() == 5) {
                com.bytedance.msdk.api.r.j.cw.j jVar2 = this.f25337m;
                if (jVar2 != null) {
                    jVar2.j();
                }
            } else {
                com.bytedance.msdk.api.r.j.ae.xt xtVar3 = this.f25334j;
                if (xtVar3 != null) {
                    xtVar3.j();
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.msdk.xt.cw
    public void w() {
        super.w();
        m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.xt.12
            @Override // java.lang.Runnable
            public void run() {
                xt.this.uh();
            }
        });
    }

    private ViewGroup xt(Context context) {
        Object apply;
        if (this.f24512g != null && context != null) {
            apply = this.f24512g.apply(r.j().j(40055).j(10000, context).j(ViewGroup.class).xt());
            if (apply instanceof ViewGroup) {
                return (ViewGroup) apply;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Map<String, Object> map) {
        if (this.f24512g != null) {
            this.f24512g.apply(r.j().j(40014).j(Void.class).j(50010, map).xt());
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void j(@NonNull final Activity activity, @NonNull final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final com.bytedance.msdk.api.r.j.ae.oq oqVar, List<View> list4) {
        super.j(activity, viewGroup, list, list2, list3, oqVar, list4);
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        if (jVar != null && jVar.cw()) {
            m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.xt.9
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.j(activity, viewGroup, (List<View>) list, (List<View>) list2, (List<View>) list3, oqVar);
                }
            });
        } else {
            j(activity, viewGroup, list, list2, list3, oqVar);
        }
    }

    private boolean cw(View view) {
        Object apply;
        if (this.f24512g != null) {
            apply = this.f24512g.apply(r.j().j(40054).j(50013, view).j(Boolean.class).xt());
            if ((apply instanceof Boolean) && ((Boolean) apply).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Context context, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.r.j.ae.oq oqVar) {
        ViewGroup xt;
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
        j(context2, xt, ij(), list, list4);
        if (oqVar != null) {
            j(context2, viewGroup, oqVar);
        } else {
            xt(list4);
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
                m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.xt.13
                    @Override // java.lang.Runnable
                    public void run() {
                        xt.this.ch(t5);
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
            m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.xt.6
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.uo();
                }
            });
        } else {
            uo();
        }
    }

    private void j(Context context, ViewGroup viewGroup, com.bytedance.msdk.api.r.j.ae.oq oqVar) {
        FrameLayout j6;
        if (viewGroup == null || oqVar == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(oqVar.ae);
        if (frameLayout != null && st() == 5 && (j6 = j(context)) != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(j6, -1, -1);
            j(j6);
        }
        if (TextUtils.isEmpty(fz())) {
            return;
        }
        View findViewById = viewGroup.findViewById(oqVar.f24358r);
        ArrayList arrayList = new ArrayList();
        arrayList.add(findViewById);
        cw(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(FrameLayout frameLayout) {
        Object obj;
        if (this.f24512g != null) {
            r j6 = r.j().j(40058).j(50013, frameLayout).j(Void.class);
            com.bytedance.msdk.api.j.xt xtVar = this.vl;
            if (xtVar != null && xtVar.c() != null && (obj = this.vl.c().get(MediationConstant.KEY_GDT_VIDEO_OPTION)) != null) {
                j6.j(50020, obj);
            }
            this.f24512g.apply(j6.xt());
        }
    }

    private FrameLayout j(Context context) {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.f24512g;
        if (function != null && context != null) {
            apply = function.apply(r.j().j(40057).j(10000, context).j(FrameLayout.class).xt());
            if (apply instanceof FrameLayout) {
                return (FrameLayout) apply;
            }
        }
        return null;
    }

    private void j(Context context, ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        if (this.f24512g == null || context == null) {
            return;
        }
        r.j().j(40056).j(Void.class).j(10000, context).j(50013, viewGroup).j(50017, layoutParams).j(50018, list).j(50019, list2);
    }

    @Override // com.bytedance.msdk.xt.cw
    public void j(final Map<String, Object> map) {
        oq oqVar = this.oq;
        if (oqVar == null || !oqVar.la() || map == null) {
            return;
        }
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        if (jVar != null && jVar.cw()) {
            m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.xt.14
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
    public void j() {
        com.bytedance.msdk.core.j.j.xt.j jVar = this.qv;
        if (jVar != null && jVar.cw()) {
            m.cw(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.cw.xt.5
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.zw();
                }
            });
        } else {
            zw();
        }
    }
}
