package com.bytedance.msdk.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.r.m;
import com.bytedance.msdk.api.r.ws;
import com.bytedance.msdk.m.xt.up;
import com.bytedance.msdk.tl.ch;
import com.bytedance.msdk.tl.l;
import com.bytedance.msdk.tl.rn;
import com.bytedance.msdk.tl.tj;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.i.r;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    private static final j rh = new j();

    /* renamed from: a, reason: collision with root package name */
    private boolean f24468a;

    /* renamed from: c, reason: collision with root package name */
    private Object f24469c;
    private boolean ch;
    private String cw;
    private com.bytedance.msdk.j.cw.cw ed;

    /* renamed from: g, reason: collision with root package name */
    private boolean f24471g;
    private com.bytedance.msdk.api.r.j.g.j gq;
    private long gx;

    /* renamed from: h, reason: collision with root package name */
    private boolean f24472h;
    private ws hh;
    private String jy;

    /* renamed from: l, reason: collision with root package name */
    private String f24475l;
    private String la;
    private m mi;

    /* renamed from: n, reason: collision with root package name */
    private final Map<String, Integer> f24477n;
    private final Map<String, Float> nd;
    private int[] ol;
    private String oq;

    /* renamed from: p, reason: collision with root package name */
    private boolean f24478p;
    private Map<String, String> qv;

    /* renamed from: r, reason: collision with root package name */
    private String f24479r;
    private boolean rn;

    /* renamed from: s, reason: collision with root package name */
    private JSONObject f24480s;
    private String tl;

    /* renamed from: v, reason: collision with root package name */
    private List<String> f24481v;
    private String vl;
    private PluginValueSet wq;

    /* renamed from: x, reason: collision with root package name */
    private boolean f24483x;
    private String[] xt;

    /* renamed from: j, reason: collision with root package name */
    private int f24474j = 0;
    private boolean up = true;

    /* renamed from: m, reason: collision with root package name */
    private boolean f24476m = false;
    private boolean ae = false;
    private Set<String> ws = new HashSet();
    private Map<String, Map<String, String>> az = new HashMap();
    private Map<String, Map<String, String>> av = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    private boolean f24473i = false;

    /* renamed from: w, reason: collision with root package name */
    private final Map<String, Object> f24482w = new tj();
    private long kt = -1;
    private Map<String, Object> tj = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    private Map<String, Object> f24470f = new ConcurrentHashMap();
    private int uf = -1;

    public static j qv() {
        return rh;
    }

    public boolean ae() {
        return this.f24471g;
    }

    public long cw() {
        long j6 = this.kt;
        if (j6 != -1) {
            return j6;
        }
        long xt = com.bytedance.msdk.ae.xt.j.j().xt();
        this.kt = xt;
        return xt;
    }

    public boolean g() {
        return "com.bytedance.mediation_demo_csj".equals(xt.getContext().getPackageName()) && oq();
    }

    public void j(boolean z5) {
        this.f24473i = z5;
    }

    public String m() {
        return this.la;
    }

    public boolean oq() {
        String path = com.bytedance.sdk.openadsdk.api.plugin.xt.cw(xt.getContext()).getPath();
        if (this.uf < 0) {
            if (new File(path + "/e2e.text").exists()) {
                this.uf = 1;
            } else {
                this.uf = 0;
            }
        }
        return this.uf > 0;
    }

    public Map<String, Integer> r() {
        return this.f24477n;
    }

    public String tl() {
        if ((!"com.union_test.toutiao".equals(xt.getContext().getPackageName()) || !"5001121".equals(this.cw)) && (!"com.bytedance.mediation_demo".equals(xt.getContext().getPackageName()) || !"5001121".equals(this.cw))) {
            return null;
        }
        try {
            return l.j("tt_mediation_ppe_info", xt.getContext()).xt("tt_ppe_content");
        } catch (Exception unused) {
            return null;
        }
    }

    public long up() {
        return this.gx;
    }

    public com.bytedance.msdk.j.cw.cw xt() {
        if (this.ed == null) {
            r j6 = r.j();
            up.j(j6);
            this.ed = com.bytedance.msdk.j.cw.cw.j(j6.xt());
        }
        return this.ed;
    }

    private static void g(String str) {
        ch.j(str, "appid不能为空");
    }

    public String a() {
        return this.vl;
    }

    public void ae(String str) {
        this.vl = str;
    }

    public String av() {
        return this.oq;
    }

    public boolean az() {
        return this.ae;
    }

    public boolean c() {
        return this.f24468a;
    }

    public boolean ch() {
        try {
            if ("com.union_test.toutiao".equals(xt.getContext().getPackageName()) && "5001121".equals(this.cw)) {
                return true;
            }
            if ("com.pangolin_demo.toutiao".equals(xt.getContext().getPackageName()) && "5001121".equals(this.cw)) {
                return true;
            }
            if ("com.bytedance.mediation_demo".equals(xt.getContext().getPackageName()) && "5001121".equals(this.cw)) {
                return true;
            }
            if ("com.msdk.qa.monkey".equals(xt.getContext().getPackageName()) && "5001121".equals(this.cw)) {
                return true;
            }
            if (xt.getContext().getPackageName().contains("com.bytedance.mediation_demo_csj")) {
                return "5001121".equals(this.cw);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public JSONObject ed() {
        return this.f24480s;
    }

    public int f() {
        return this.f24474j;
    }

    public Map<String, Object> gq() {
        return this.f24470f;
    }

    public String gx() {
        return this.f24475l;
    }

    public com.bytedance.msdk.api.r.j.g.j hh() {
        return this.gq;
    }

    public Map<String, String> i() {
        return this.qv;
    }

    public boolean j() {
        return this.f24473i;
    }

    public boolean jy() {
        return this.rn;
    }

    public boolean kt() {
        return this.f24476m;
    }

    public m l() {
        return this.mi;
    }

    public Map<String, Object> la() {
        return this.tj;
    }

    public void m(boolean z5) {
        this.f24476m = z5;
    }

    public int[] mi() {
        return this.ol;
    }

    public boolean n() {
        return this.f24478p;
    }

    public boolean nd() {
        return this.f24472h;
    }

    public PluginValueSet ol() {
        PluginValueSet pluginValueSet = this.wq;
        return pluginValueSet != null ? pluginValueSet : e.a().k();
    }

    public ws p() {
        if (this.hh == null) {
            this.hh = ws.j(qv().xt());
        }
        return this.hh;
    }

    public void qv(boolean z5) {
        this.f24472h = z5;
    }

    public void r(boolean z5) {
        this.ae = z5;
    }

    public Map<String, Object> rh() {
        this.f24482w.put(MediationConstant.KEY_GM_USB, com.bytedance.msdk.core.g.up.up());
        return this.f24482w;
    }

    public List<String> rn() {
        return this.f24481v;
    }

    public String tj() {
        return this.f24479r;
    }

    public boolean uf() {
        return this.ch;
    }

    public void up(String str) {
        this.oq = str;
    }

    public String[] v() {
        return this.xt;
    }

    public String vl() {
        return this.cw;
    }

    public String w() {
        return this.tl;
    }

    public boolean wq() {
        return this.f24483x;
    }

    public boolean ws() {
        return this.up;
    }

    public String x() {
        if (!TextUtils.isEmpty(this.jy)) {
            return this.jy;
        }
        String j6 = l.j((String) null, xt.getContext()).j();
        this.jy = j6;
        if (!TextUtils.isEmpty(j6)) {
            return this.jy;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        l.j((String) null, xt.getContext()).j(valueOf);
        this.jy = valueOf;
        return valueOf;
    }

    public Object z() {
        return this.f24469c;
    }

    private j() {
        HashMap hashMap = new HashMap();
        this.f24477n = hashMap;
        this.nd = new ConcurrentHashMap();
        if (xt.xt().ed()) {
            hashMap.put(MediationConstant.KEY_USE_POLICY_AD_GAP, 1);
            hashMap.put(MediationConstant.KEY_USE_POLICY_AD_LOAD, 1);
            hashMap.put(MediationConstant.KEY_USE_POLICY_SECTION_ID, 1);
            hashMap.put(MediationConstant.KEY_USE_POLICY_PAGE_ID, 1);
            hashMap.put("custom", 1);
        }
    }

    public void ae(boolean z5) {
        this.f24483x = z5;
    }

    public void cw(String str) {
        g(str);
        this.cw = str;
    }

    public void g(boolean z5) {
        this.f24468a = z5;
    }

    public void h() {
        this.hh = ws.j(qv().xt());
    }

    public void j(String str, float f6) {
        this.nd.put(str, Float.valueOf(f6));
    }

    public void m(String str) {
        if (TextUtils.isEmpty(str)) {
            str = j(xt.getContext());
        }
        this.f24479r = str;
    }

    public void r(String str) {
        this.tl = str;
    }

    public boolean s() {
        String j6 = rn.j();
        if (!"com.union_test.toutiao".equals(j6) && !"com.bytedance.mediation_demo".equals(j6) && !"com.msdk.qa.monkey".equals(j6)) {
            return false;
        }
        return true;
    }

    public void up(boolean z5) {
        this.up = z5;
    }

    public float j(String str) {
        return this.nd.get(str).floatValue();
    }

    public void tl(boolean z5) {
        this.ch = z5;
        if (z5) {
            try {
                Class.forName("com.bykv.vk.openvk.TTVfSdk");
            } catch (ClassNotFoundException e6) {
                this.ch = false;
                vl.j(e6);
            }
        }
    }

    public void cw(boolean z5) {
        this.rn = z5;
    }

    public void j(long j6) {
        com.bytedance.msdk.ae.xt.j.j().j(j6);
    }

    public void cw(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.f24470f.putAll(map);
    }

    public void j(Map<String, String> map) {
        this.qv = map;
    }

    public void xt(long j6) {
        this.gx = j6;
    }

    public void j(int... iArr) {
        this.ol = iArr;
    }

    public void xt(String str) {
        this.la = str;
    }

    public static String j(Context context) {
        CharSequence charSequence;
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getApplicationInfo().packageName, 0);
            if (applicationInfo == null) {
                charSequence = "";
            } else {
                charSequence = packageManager.getApplicationLabel(applicationInfo);
            }
            return (String) charSequence;
        } catch (Throwable th) {
            vl.j(th);
            return "";
        }
    }

    public void oq(boolean z5) {
        this.f24478p = z5;
    }

    public void tl(String str) {
        this.f24475l = str;
    }

    public void xt(boolean z5) {
        this.f24471g = z5;
    }

    public void xt(Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        this.tj.putAll(map);
    }

    public void j(int i6) {
        this.f24474j = i6;
    }

    public void j(String[] strArr) {
        this.xt = strArr;
    }

    public void j(m mVar, boolean z5) {
        boolean equals;
        if (!z5) {
            m mVar2 = this.mi;
            if (mVar2 == null && mVar == null) {
                equals = true;
            } else {
                equals = (mVar2 == null || mVar == null) ? false : mVar2.equals(mVar);
            }
            this.mi = mVar;
            if (equals) {
                return;
            }
            com.bytedance.msdk.core.ws.xt.j(xt.xt()).j().j(3);
            return;
        }
        this.mi = mVar;
    }

    public void j(List<String> list) {
        this.f24481v = list;
    }

    public void j(JSONObject jSONObject) {
        this.f24480s = jSONObject;
    }

    public void j(PluginValueSet pluginValueSet) {
        this.wq = pluginValueSet;
    }

    public void j(com.bytedance.msdk.api.r.j.g.j jVar) {
        this.gq = jVar;
    }

    public void j(Object obj) {
        this.f24469c = obj;
    }
}
