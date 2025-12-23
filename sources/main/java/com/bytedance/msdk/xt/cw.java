package com.bytedance.msdk.xt;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.gromore.R;
import com.bytedance.msdk.api.r.j.ae.g;
import com.bytedance.msdk.api.r.j.ae.oq;
import com.bytedance.msdk.api.r.j.ae.tl;
import com.bytedance.msdk.j.xt.m;
import com.bytedance.msdk.tl.tj;
import com.bytedance.sdk.openadsdk.core.wq.r;
import com.bytedance.sdk.openadsdk.i.cw.xt.ae;
import com.bytedance.sdk.openadsdk.i.cw.xt.up;
import com.bytedance.sdk.openadsdk.i.cw.xt.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class cw extends r implements Comparable<cw> {

    /* renamed from: a, reason: collision with root package name */
    private String f25325a;
    protected m ae;
    private int av;
    private int az;

    /* renamed from: b, reason: collision with root package name */
    private int f25326b;

    /* renamed from: c, reason: collision with root package name */
    private double f25327c;
    private int ch;
    protected com.bytedance.msdk.api.r.j.xt cw;

    /* renamed from: d, reason: collision with root package name */
    private String f25328d;

    /* renamed from: e, reason: collision with root package name */
    private String f25329e;
    private Map<String, Object> ed;

    /* renamed from: f, reason: collision with root package name */
    private double f25330f;
    private com.bytedance.sdk.openadsdk.kt.j.xt.j.j fx;

    /* renamed from: g, reason: collision with root package name */
    private String f25331g;
    private String gq;
    private double gx;

    /* renamed from: h, reason: collision with root package name */
    private String f25332h;
    private int hl;

    /* renamed from: i, reason: collision with root package name */
    private String f25333i;
    private String ik;
    private int im;

    /* renamed from: j, reason: collision with root package name */
    protected com.bytedance.msdk.api.r.j.ae.xt f25334j;
    private int jy;
    private String ka;
    private int ki;

    /* renamed from: l, reason: collision with root package name */
    private boolean f25336l;
    private long la;
    private long ll;
    private boolean ln;

    /* renamed from: m, reason: collision with root package name */
    protected com.bytedance.msdk.api.r.j.cw.j f25337m;
    private double mi;

    /* renamed from: n, reason: collision with root package name */
    private int f25338n;
    private int nt;
    private String oq;
    private String oy;

    /* renamed from: p, reason: collision with root package name */
    private String f25339p;
    private String px;
    private int pz;

    /* renamed from: q, reason: collision with root package name */
    private String f25340q;
    private int qa;
    private String qb;
    private volatile boolean qo;
    private String qv;

    /* renamed from: r, reason: collision with root package name */
    protected com.bytedance.msdk.api.r.j.r f25341r;
    private String ri;
    private String rn;

    /* renamed from: s, reason: collision with root package name */
    private boolean f25342s;
    private boolean sm;
    private int st;
    private String tj;
    protected m tl;

    /* renamed from: u, reason: collision with root package name */
    private boolean f25344u;
    private String uc;
    private Map<String, String> uf;
    protected g up;
    private String uq;

    /* renamed from: v, reason: collision with root package name */
    private int f25345v;
    private String vl;

    /* renamed from: w, reason: collision with root package name */
    private String f25346w;
    private String wf;
    private j wi;
    private volatile boolean wo;
    private String wq;
    private int ws;
    private String xp;
    private int xq;
    protected tl xt;
    private String xw;

    /* renamed from: y, reason: collision with root package name */
    private int f25348y;
    private String ya;
    private String yl;

    /* renamed from: z, reason: collision with root package name */
    private String f25349z;
    private List<String> kt = new ArrayList();

    /* renamed from: x, reason: collision with root package name */
    private int f25347x = -1;
    private int nd = 1;
    private int rh = 1;
    private int ol = 1;
    private int hh = 1;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f25335k = false;
    private volatile boolean ff = false;
    private volatile boolean ry = false;
    private volatile boolean zz = false;
    private final Map<String, Object> kc = new tj();
    private boolean aq = false;
    private boolean rr = false;

    /* renamed from: t, reason: collision with root package name */
    private String f25343t = "1";
    private Map<String, Object> qe = new HashMap();
    private Map<String, Object> tk = new ConcurrentHashMap();

    public interface j {
        void j();

        void j(cw cwVar);
    }

    public boolean a() {
        return this.rr;
    }

    public String ae() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        return null;
    }

    public void av() {
    }

    public void az(String str) {
        this.f25343t = str;
    }

    public up by() {
        return null;
    }

    public int ch() {
        return this.pz;
    }

    public void cw() {
    }

    public boolean f() {
        return this.ln;
    }

    public int fs() {
        return 0;
    }

    public View g() {
        return null;
    }

    public boolean gq() {
        if (this.ry) {
            return true;
        }
        this.ry = true;
        return false;
    }

    public boolean h() {
        if (this.f25335k) {
            return true;
        }
        this.f25335k = true;
        return false;
    }

    public void i() {
    }

    public ae j(Activity activity) {
        return null;
    }

    public Bitmap ja() {
        return null;
    }

    public void jy(String str) {
        this.yl = str;
    }

    public com.bytedance.sdk.openadsdk.i.cw.xt.r kk() {
        return null;
    }

    public boolean kt() {
        return false;
    }

    public boolean l() {
        return this.aq;
    }

    public boolean la() {
        if (this.ff) {
            return true;
        }
        this.ff = true;
        return false;
    }

    public boolean lx() {
        return false;
    }

    public void m(String str) {
        this.f25340q = str;
    }

    public void mi(String str) {
        this.uc = str;
    }

    public boolean nd() {
        return false;
    }

    public String o() {
        return null;
    }

    public View oq() {
        return null;
    }

    public Map<String, Object> p() {
        return this.kc;
    }

    public void qv() {
    }

    public int r() {
        return -1;
    }

    public boolean rn() {
        if (this.zz) {
            return true;
        }
        this.zz = true;
        return false;
    }

    public int s() {
        return this.st;
    }

    public String tj() {
        return this.xp;
    }

    public com.bytedance.msdk.api.r.j.ae.up tl() {
        return null;
    }

    public void uf(String str) {
    }

    public void up(String str) {
        this.f25329e = str;
    }

    public abstract boolean up();

    public void v(int i6) {
    }

    public void vl(String str) {
        this.px = str;
    }

    public void w(String str) {
        this.uq = str;
    }

    public int wq() {
        return this.xq;
    }

    public void ws(String str) {
        this.oy = str;
    }

    public int x() {
        return this.qa;
    }

    public ae xt(Dialog dialog, Integer[] numArr) {
        return null;
    }

    public vl zk() {
        return null;
    }

    public void a(String str) {
        this.qv = str;
    }

    public void ae(String str) {
        this.f25349z = str;
    }

    public boolean aq() {
        return this.f25342s;
    }

    public void av(String str) {
        this.ik = str;
    }

    public void az(int i6) {
        this.nt = i6;
    }

    public final Map<String, Object> b() {
        return this.qe;
    }

    public String c() {
        return this.ya;
    }

    public void ch(String str) {
        this.rn = str;
    }

    public void cw(int i6) {
        this.st = i6;
    }

    public int d() {
        return this.im;
    }

    public boolean dj() {
        return (this instanceof com.bytedance.msdk.api.r.j.xt.xt) || (this instanceof com.bytedance.msdk.cw.j.j.cw);
    }

    public String e() {
        return this.yl;
    }

    public String ed() {
        return this.qb;
    }

    public int el() {
        return this.az;
    }

    public int et() {
        return this.ws;
    }

    public void f(String str) {
        this.f25339p = str;
    }

    public String ff() {
        return this.ik;
    }

    public boolean fp() {
        return this.f25344u;
    }

    public String fx() {
        return this.qv;
    }

    public void g(int i6) {
        this.nd = i6;
    }

    public int gr() {
        return this.jy;
    }

    public String gx() {
        return this.f25329e;
    }

    public String hh() {
        return this.xw;
    }

    public String hl() {
        return this.px;
    }

    public int hu() {
        return this.av;
    }

    public double hw() {
        return 0.0d;
    }

    public void i(String str) {
        this.ka = str;
    }

    public long ig() {
        return 0L;
    }

    public double ik() {
        return this.f25327c;
    }

    public long im() {
        return this.la;
    }

    public void j() {
    }

    public String jl() {
        return this.tj;
    }

    public void jy(int i6) {
        this.ki = i6;
    }

    public String k() {
        return this.f25343t;
    }

    public double ka() {
        return this.gx;
    }

    public String kc() {
        return this.uq;
    }

    public Map<String, Object> ki() {
        return this.ed;
    }

    public void kt(String str) {
        this.ri = str;
    }

    public void l(String str) {
        this.vl = str;
    }

    public boolean ll() {
        int i6 = this.nt;
        return i6 == 0 || i6 == 100;
    }

    public String ln() {
        return this.f25339p;
    }

    public void m(int i6) {
        this.hl = i6;
    }

    public void mi(int i6) {
        this.ws = i6;
    }

    public String n() {
        return this.f25340q;
    }

    public String na() {
        return this.vl;
    }

    public String nt() {
        return this.rn;
    }

    public int nu() {
        return this.f25338n;
    }

    public int ol() {
        return this.hl;
    }

    public int om() {
        return this.ch;
    }

    public void oq(boolean z5) {
    }

    public String ov() {
        return this.f25333i;
    }

    public boolean oy() {
        return this.nt == 1;
    }

    public void p(String str) {
        this.f25333i = str;
    }

    public boolean px() {
        return this.nt == 100;
    }

    public int pz() {
        return this.ki;
    }

    public String q() {
        return this.oy;
    }

    public String qa() {
        return this.ri;
    }

    public boolean qb() {
        return this.wo;
    }

    public boolean qe() {
        return this.nt == 0;
    }

    public String qg() {
        return this.oq;
    }

    public boolean qo() {
        return this.nt == 2;
    }

    public void qv(String str) {
        this.f25328d = str;
    }

    public void r(int i6) {
        this.xq = i6;
    }

    public int rh() {
        return this.f25326b;
    }

    public Map<String, String> ri() {
        return this.uf;
    }

    public int rr() {
        return this.f25347x;
    }

    public double rs() {
        return this.mi;
    }

    public String ry() {
        return this.ka;
    }

    public void s(String str) {
        this.wq = str;
    }

    public final long sm() {
        return this.ll;
    }

    public int st() {
        return this.f25345v;
    }

    public void tj(String str) {
        this.f25325a = str;
    }

    public List<String> tk() {
        return this.kt;
    }

    public void tl(int i6) {
        this.hh = i6;
    }

    public String uc() {
        return this.wq;
    }

    public boolean uf() {
        return this.sm;
    }

    public void up(int i6) {
        this.f25326b = i6;
    }

    public String v() {
        return this.wf;
    }

    public void vl(int i6) {
        this.f25347x = i6;
    }

    public void w(int i6) {
        this.jy = i6;
    }

    public boolean wf() {
        if (!TextUtils.isEmpty(this.f25339p) || !TextUtils.isEmpty(this.f25332h) || this.la > 0 || !TextUtils.isEmpty(this.gq)) {
            return true;
        }
        Map<String, String> map = this.uf;
        return ((map == null || map.size() <= 0) && TextUtils.isEmpty(this.rn) && TextUtils.isEmpty(this.wq) && TextUtils.isEmpty(this.px)) ? false : true;
    }

    public int wi() {
        return this.f25348y;
    }

    public final boolean wq(String str) {
        Integer m6 = m();
        return m6.intValue() == 1 ? !com.bytedance.msdk.core.up.j.j.j().j(str, this) : m6.intValue() == 2;
    }

    public void ws(int i6) {
        this.ch = i6;
    }

    public void x(String str) {
        this.gq = str;
    }

    public String xp() {
        return this.f25332h;
    }

    public Map<String, Object> xq() {
        return this.tk;
    }

    public void xt() {
    }

    public int xw() {
        return this.nt;
    }

    public String y() {
        return this.gq;
    }

    public boolean ya() {
        return this.qo;
    }

    public long yb() {
        return 0L;
    }

    public boolean yl() {
        return this.nt == 3;
    }

    public m ym() {
        return this.ae;
    }

    public j yu() {
        return this.wi;
    }

    public String z() {
        return this.f25328d;
    }

    public String zs() {
        return this.f25331g;
    }

    public String zz() {
        return TextUtils.isEmpty(this.ik) ? this.ka : this.ik;
    }

    public void ae(int i6) {
        this.ol = i6;
    }

    public void av(int i6) {
        this.im = i6;
    }

    public com.bytedance.msdk.api.r.j.cw.j az() {
        return this.f25337m;
    }

    public void cw(boolean z5) {
        this.aq = z5;
    }

    public void f(int i6) {
        this.av = i6;
    }

    public int g(String str) {
        if (TextUtils.equals(str, this.f25349z)) {
            return this.hh;
        }
        return this.rh;
    }

    public void gq(String str) {
        this.oq = str;
    }

    public void h(String str) {
        this.f25346w = str;
    }

    public void i(int i6) {
        this.f25348y = i6;
    }

    public void j(Activity activity, Object obj, String str) {
    }

    public tl jy() {
        return this.xt;
    }

    public void kt(int i6) {
        this.f25338n = i6;
    }

    public void la(String str) {
        this.f25331g = str;
    }

    public void m(boolean z5) {
        this.qo = z5;
    }

    public com.bytedance.sdk.openadsdk.kt.j.xt.j.j mi() {
        return this.fx;
    }

    public void oq(int i6) {
        this.rh = i6;
    }

    public void qv(int i6) {
        this.f25345v = i6;
    }

    public void r(boolean z5) {
        this.sm = z5;
    }

    public void rn(String str) {
        this.tj = str;
    }

    public double t() {
        try {
        } catch (NumberFormatException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        if (qo()) {
            if (ik() < 0.0d) {
                return 0.0d;
            }
            return ik();
        }
        if (oy() || yl()) {
            return this.f25330f * Double.valueOf(this.f25343t).doubleValue();
        }
        return this.f25330f;
    }

    public void tj(int i6) {
        this.az = i6;
    }

    public int tl(String str) {
        if (TextUtils.equals(str, this.f25349z)) {
            return this.ol;
        }
        return this.nd;
    }

    public String u() {
        if (qo()) {
            if (ik() < 0.0d) {
                return "-1";
            }
            return String.valueOf(ik());
        }
        return String.valueOf(t());
    }

    public void up(boolean z5) {
        this.wo = z5;
    }

    public double uq() {
        if (qo()) {
            if (ik() < 0.0d) {
                return 0.0d;
            }
            return ik();
        }
        return this.f25330f;
    }

    public void v(String str) {
        this.f25332h = str;
    }

    public com.bytedance.msdk.api.r.j.ae.xt vl() {
        return this.f25334j;
    }

    public void w() {
        this.f25334j = null;
        this.xt = null;
        this.cw = null;
    }

    public String wo() {
        if (qo()) {
            if (ka() < 0.0d) {
                return "-1";
            }
            return String.valueOf(ka());
        }
        return String.valueOf(t());
    }

    public com.bytedance.msdk.api.r.j.xt ws() {
        return this.cw;
    }

    public void xt(Activity activity) {
    }

    public void ae(boolean z5) {
        this.f25342s = z5;
    }

    public void cw(Map<String, Object> map) {
        if (map != null) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "setMediaExtraInfo ".concat(String.valueOf(map)));
            this.kc.putAll(map);
        }
    }

    public void j(Dialog dialog, Integer[] numArr) {
    }

    public Integer m() {
        return 1;
    }

    public void oq(String str) {
        this.xw = str;
    }

    public void r(String str) {
        this.ya = str;
    }

    public void up(Map<String, String> map) {
        this.uf = map;
    }

    public void xt(Map<String, Object> map) {
    }

    public void j(Bitmap bitmap, int i6) {
    }

    public void r(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.qe.putAll(map);
    }

    public void xt(String str) {
        this.wf = str;
    }

    public void cw(String str) {
        this.qb = str;
    }

    public void g(boolean z5) {
        this.f25344u = z5;
    }

    public void j(ViewGroup viewGroup) {
    }

    public void tl(boolean z5) {
        this.f25336l = z5;
    }

    public void xt(int i6) {
        this.pz = i6;
    }

    public void cw(double d6) {
        this.gx = d6;
    }

    public void j(ViewGroup viewGroup, Activity activity) {
    }

    public void r(double d6) {
        this.mi = d6;
    }

    public void xt(boolean z5) {
        this.rr = z5;
    }

    public void j(com.bytedance.sdk.openadsdk.f.j.xt.j.j jVar) {
    }

    public void xt(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.tk.put(str, obj);
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
    }

    public void xt(long j6) {
        this.la = j6;
    }

    public void j(com.bytedance.sdk.openadsdk.s.j.xt.j.cw cwVar) {
    }

    public void xt(double d6) {
        this.f25327c = d6;
    }

    public void j(Object obj) {
    }

    public void xt(View view) {
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) parent).removeView(view);
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
        }
    }

    public void j(Map<String, Object> map) {
    }

    public void j(String str) {
        this.xp = str;
    }

    public void j(boolean z5) {
        this.ln = z5;
    }

    private void xt(@NonNull ViewGroup viewGroup) {
        try {
            if (viewGroup.getChildCount() == 0) {
                return;
            }
            int i6 = 0;
            if (pz() != 3 && (viewGroup.getChildAt(0) instanceof ViewGroup)) {
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
                if (MediationConstant.TT_GDT_NATIVE_ROOT_VIEW_TAG.equals(viewGroup2.getTag(R.id.tt_mediation_gdt_developer_view_root_tag_key))) {
                    viewGroup.removeView(viewGroup2);
                    int i7 = 0;
                    while (i7 < viewGroup2.getChildCount()) {
                        View childAt = viewGroup2.getChildAt(i7);
                        if (childAt != null) {
                            Object tag = childAt.getTag(R.id.tt_mediation_gdt_developer_view_tag_key);
                            if ((tag instanceof String) && tag.equals(MediationConstant.TT_GDT_NATIVE_VIEW_TAG)) {
                                viewGroup2.removeView(childAt);
                                viewGroup.addView(childAt, childAt.getLayoutParams());
                            }
                        }
                        i7++;
                    }
                }
            }
            if (pz() == 2 || !(viewGroup.getChildAt(0) instanceof ViewGroup)) {
                return;
            }
            ViewGroup viewGroup3 = (ViewGroup) viewGroup.getChildAt(0);
            if (MediationConstant.TT_ADMOB_NATIVE_VIEW_ROOT_TAG.equals(viewGroup3.getTag(R.id.tt_mediation_admob_developer_view_root_tag_key))) {
                viewGroup.removeView(viewGroup3);
                while (i6 < viewGroup3.getChildCount()) {
                    View childAt2 = viewGroup3.getChildAt(i6);
                    if (childAt2 != null) {
                        Object tag2 = childAt2.getTag(R.id.tt_mediation_admob_developer_view_tag_key);
                        if ((tag2 instanceof String) && tag2.equals(MediationConstant.TT_ADMOB_NATIVE_VIEW_TAG)) {
                            viewGroup3.removeView(childAt2);
                            viewGroup.addView(childAt2, childAt2.getLayoutParams());
                        }
                    }
                    i6++;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public void j(int i6) {
        this.qa = i6;
    }

    public void j(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.qe.put(str, obj);
    }

    public final void j(long j6) {
        if (this.ll == 0) {
            this.ll = j6;
        }
    }

    public void sf() {
    }

    public void j(double d6) {
        this.f25330f = d6;
    }

    public void j(List<String> list) {
        if (list != null) {
            this.kt.addAll(list);
        }
    }

    private void j(ViewGroup viewGroup, oq oqVar) {
        xt(viewGroup);
        View findViewById = viewGroup.findViewById(R.id.tt_mediation_mtg_ad_choice);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        if (oqVar != null) {
            j(viewGroup.findViewById(oqVar.vl));
        }
    }

    public void j(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
        j(viewGroup, (oq) null);
    }

    public void j(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, oq oqVar, List<View> list4) {
        if (list3 != null) {
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            list2.addAll(list3);
        }
        j(viewGroup, oqVar);
    }

    public void j(View view) {
        if (view != null) {
            view.setVisibility(0);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).removeAllViews();
            } else if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(null);
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public int compareTo(cw cwVar) {
        if (cwVar == null || this.f25348y > cwVar.wi()) {
            return 1;
        }
        if (this.f25348y < cwVar.wi()) {
            return -1;
        }
        if (this.im > cwVar.d()) {
            return 1;
        }
        return this.im < cwVar.d() ? -1 : 0;
    }

    public void xt(m mVar) {
        this.tl = mVar;
    }

    public void j(g gVar) {
        this.up = gVar;
    }

    public void j(com.bytedance.msdk.api.r.j.r rVar) {
        this.f25341r = rVar;
    }

    public void j(com.bytedance.msdk.api.r.j.ae.xt xtVar) {
        this.f25334j = xtVar;
    }

    public void j(tl tlVar) {
        this.xt = tlVar;
    }

    public void j(final com.bytedance.msdk.api.r.j.xt xtVar) {
        if (xtVar != null) {
            this.cw = new com.bytedance.msdk.api.r.j.xt() { // from class: com.bytedance.msdk.xt.cw.1
                @Override // com.bytedance.msdk.api.r.j.xt
                public void j() {
                    com.bytedance.msdk.j.up.m.cw(new Runnable() { // from class: com.bytedance.msdk.xt.cw.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            xtVar.j();
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void xt() {
                    com.bytedance.msdk.j.up.m.cw(new Runnable() { // from class: com.bytedance.msdk.xt.cw.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            xtVar.xt();
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void j(final long j6, final long j7, final int i6, final int i7, @Nullable final String str, @Nullable final String str2) {
                    com.bytedance.msdk.j.up.m.cw(new Runnable() { // from class: com.bytedance.msdk.xt.cw.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            xtVar.j(j6, j7, i6, i7, str, str2);
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void xt(final long j6, final long j7, @Nullable final String str, @Nullable final String str2) {
                    com.bytedance.msdk.j.up.m.cw(new Runnable() { // from class: com.bytedance.msdk.xt.cw.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            xtVar.xt(j6, j7, str, str2);
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void j(final long j6, final long j7, @Nullable final String str, @Nullable final String str2) {
                    com.bytedance.msdk.j.up.m.cw(new Runnable() { // from class: com.bytedance.msdk.xt.cw.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            xtVar.j(j6, j7, str, str2);
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void j(final long j6, @Nullable final String str, @Nullable final String str2) {
                    com.bytedance.msdk.j.up.m.cw(new Runnable() { // from class: com.bytedance.msdk.xt.cw.1.6
                        @Override // java.lang.Runnable
                        public void run() {
                            xtVar.j(j6, str, str2);
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void j(@Nullable final String str, @Nullable final String str2) {
                    com.bytedance.msdk.j.up.m.cw(new Runnable() { // from class: com.bytedance.msdk.xt.cw.1.7
                        @Override // java.lang.Runnable
                        public void run() {
                            xtVar.j(str, str2);
                        }
                    });
                }
            };
        }
    }

    public void j(com.bytedance.msdk.api.r.j.cw.j jVar) {
        this.f25337m = jVar;
    }

    public void j(m mVar) {
        this.ae = mVar;
    }

    public void j(Activity activity, com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
        this.fx = jVar;
    }

    public void j(j jVar) {
        this.wi = jVar;
    }
}
