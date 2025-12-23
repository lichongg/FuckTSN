package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class wq {
    private Function<SparseArray<Object>, Object> tl;

    /* renamed from: r, reason: collision with root package name */
    private static final wq f31286r = new wq();
    private static int ae = -1;

    /* renamed from: g, reason: collision with root package name */
    private static String f31285g = "ext_plugin";

    /* renamed from: j, reason: collision with root package name */
    private volatile Function<SparseArray<Object>, Object> f31287j = null;
    private volatile Function<SparseArray<Object>, Object> xt = null;
    private volatile Function<SparseArray<Object>, Object> cw = null;
    private AtomicBoolean up = new AtomicBoolean(false);

    /* renamed from: m, reason: collision with root package name */
    private AtomicBoolean f31288m = new AtomicBoolean(false);

    public static wq j() {
        return f31286r;
    }

    private Function<SparseArray<Object>, Object> jy() {
        Object apply;
        try {
            if (this.tl == null) {
                apply = oq.i().qb().apply(com.bytedance.sdk.openadsdk.i.r.j().j(4).j(ClassLoader.class).j(0, "com.byted.csj.ext").xt());
                ClassLoader classLoader = (ClassLoader) apply;
                if (classLoader != null) {
                    this.tl = a1.b.a(classLoader.loadClass("com.byted.csj.ext_impl.ServiceManager").getConstructor(null).newInstance(null));
                }
            }
            return this.tl;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.r(f31285g, "getServiceManager:" + th.getMessage());
            return null;
        }
    }

    public static int xt() {
        if (ae == -1) {
            ae = j().m().intValue();
        }
        return ae;
    }

    private Function<SparseArray<Object>, Object> ae() {
        Object apply;
        com.bytedance.sdk.openadsdk.core.ch.cw cwVar = (com.bytedance.sdk.openadsdk.core.ch.cw) AutoService.j(com.bytedance.sdk.openadsdk.core.ch.cw.class);
        if (cwVar == null || !cwVar.cw()) {
            com.bytedance.sdk.component.utils.vl.r(f31285g, "can use pitaya false");
            return null;
        }
        if (!r() || m().intValue() < 1100) {
            return null;
        }
        if (this.cw == null) {
            synchronized (wq.class) {
                try {
                    if (this.cw == null) {
                        Function<SparseArray<Object>, Object> jy = jy();
                        if (jy != null) {
                            apply = jy.apply(com.bytedance.sdk.openadsdk.i.r.j().j(10003).j(a1.a.a()).xt());
                            if (com.bykv.j.j.j.j.f.a(apply)) {
                                this.cw = a1.b.a(apply);
                            }
                        }
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.vl.r(f31285g, "getBridge:" + th.getMessage());
                } finally {
                }
            }
        }
        return this.cw;
    }

    public static void cw() {
        if (h.xt < 5001) {
            return;
        }
        if (!v.xt().ch()) {
            JSONObject rn = oq.i().rn();
            if (rn != null) {
                rn.remove("com.byted.csj.ext");
                return;
            }
            return;
        }
        Bundle bundle = new Bundle();
        Bundle j6 = j(oq.i().f());
        if (j6 != null) {
            bundle.putBundle("com.byted.csj.ext", j6);
        }
        oq.i().j(bundle);
    }

    private static String oq() {
        Object apply;
        try {
            Function<SparseArray<Object>, Object> qb = oq.i().qb();
            JSONObject optJSONObject = oq.i().rn().optJSONObject("com.byted.csj.ext");
            apply = qb.apply(com.bytedance.sdk.openadsdk.i.r.j().j(6).j(Boolean.class).j(0, "com.byted.csj.ext").xt());
            if (!(apply != null ? ((Boolean) apply).booleanValue() : false)) {
                return optJSONObject == null ? "0.0.0.0" : (String) optJSONObject.opt(PluginConstants.KEY_PLUGIN_VERSION);
            }
            if (j().r()) {
                return qv();
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.r(f31285g, "ignore:" + th.getMessage());
            com.bytedance.sdk.component.utils.vl.j(th);
            return "0.0.0.0";
        }
    }

    private static String tl() {
        int i6 = h.xt;
        return (i6 == 5001 || i6 == 5002) ? oq() : g();
    }

    private static String vl() {
        return h.xt >= 5003 ? xt(h.f29118r) : j(v.getContext());
    }

    public Function<SparseArray<Object>, Object> j(int i6) {
        try {
            if (h.j() && i6 == 10003) {
                return ae();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
        return null;
    }

    public boolean r() {
        Object apply;
        Object apply2;
        try {
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.r(f31285g, "pit_ext_error:" + th.getMessage());
        }
        if (h.xt < 5001 || !v.xt().ch()) {
            return false;
        }
        if (this.up.get()) {
            return true;
        }
        if (this.f31288m.compareAndSet(false, true)) {
            final Function<SparseArray<Object>, Object> qb = oq.i().qb();
            apply = qb.apply(com.bytedance.sdk.openadsdk.i.r.j().j(6).j(Boolean.class).j(0, "com.byted.csj.ext").xt());
            if (apply != null ? ((Boolean) apply).booleanValue() : false) {
                apply2 = qb.apply(com.bytedance.sdk.openadsdk.i.r.j().j(7).j(Boolean.class).j(0, "com.byted.csj.ext").xt());
                if (apply2 != null ? ((Boolean) apply2).booleanValue() : false) {
                    this.up.set(true);
                    this.f31288m.set(false);
                } else {
                    com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wq.1
                        @Override // java.lang.Runnable
                        public void run() {
                            wq.this.j(qb, true);
                        }
                    });
                }
            } else {
                this.f31288m.set(false);
            }
        }
        return false;
    }

    public s0.a up() {
        if (h.xt >= 5001 && com.bytedance.sdk.openadsdk.core.mi.xt.j(v.xt().la()) && r()) {
            return (s0.a) AutoService.j(s0.a.class);
        }
        return null;
    }

    private wq() {
    }

    private static String g() {
        Object apply;
        apply = oq.i().qb().apply(com.bytedance.sdk.openadsdk.i.r.j().j(8).j(String.class).j(0, "com.byted.csj.ext").xt());
        return (String) apply;
    }

    private Integer m() {
        Object apply;
        Function<SparseArray<Object>, Object> jy = jy();
        if (jy != null) {
            apply = jy.apply(com.bytedance.sdk.openadsdk.i.r.j().j(1004).j(Integer.class).xt());
            if (apply instanceof Integer) {
                return (Integer) apply;
            }
        }
        return -1;
    }

    private static String qv() {
        try {
            Integer m6 = j().m();
            if (m6.intValue() != -1) {
                return xt(m6.intValue());
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            return null;
        }
    }

    public static String xt(int i6) {
        char[] charArray = String.valueOf(i6).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < charArray.length; i7++) {
            sb.append(charArray[i7]);
            if (i7 < charArray.length - 1) {
                sb.append(".");
            }
        }
        String sb2 = sb.toString();
        if (i6 < 100 || i6 >= 1000) {
            return sb2;
        }
        return "0." + sb2;
    }

    private static Bundle j(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", str);
            String tl = tl();
            if (TextUtils.isEmpty(tl)) {
                return null;
            }
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, tl);
            bundle.putString("sdk_version", vl());
            return bundle;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.r(f31285g, "error:" + th.getMessage());
            com.bytedance.sdk.component.utils.vl.j(th);
            return null;
        }
    }

    private static String j(Context context) {
        try {
            String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("ZEUS_PLUGIN_com.byted.csj.ext");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return xt(new JSONObject(string).optInt("apiVersionCode"));
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            return null;
        }
    }

    public boolean j(Function<SparseArray<Object>, Object> function, boolean z5) {
        Object apply;
        try {
            if (this.up.get()) {
                return true;
            }
            if (!z5) {
                this.f31288m.set(true);
            }
            apply = function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(5).j(Boolean.class).j(0, "com.byted.csj.ext").xt());
            boolean booleanValue = apply != null ? ((Boolean) apply).booleanValue() : false;
            this.up.set(booleanValue);
            this.f31288m.set(false);
            return booleanValue;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.r(f31285g, ":" + th.getMessage());
            return false;
        }
    }
}
