package cn.jiguang.m;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.bb.f;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class a {

    /* renamed from: cn.jiguang.m.a$a, reason: collision with other inner class name */
    public class C0049a extends cn.jiguang.by.b {

        /* renamed from: b, reason: collision with root package name */
        private Context f3077b;

        /* renamed from: c, reason: collision with root package name */
        private String f3078c;

        /* renamed from: d, reason: collision with root package name */
        private Bundle f3079d;

        C0049a(Context context, String str, Bundle bundle) {
            this.f3077b = context;
            this.f3078c = str;
            this.f3079d = bundle;
            this.f2653h = str + "#BundleAction";
        }

        @Override // cn.jiguang.by.b
        public void a() {
            try {
                a.this.a(this.f3077b, this.f3078c, this.f3079d);
            } catch (Throwable th) {
                f.i("JCommon", "BundleAction failed:" + th.getMessage());
            }
        }
    }

    public class b extends cn.jiguang.by.b {

        /* renamed from: b, reason: collision with root package name */
        private Context f3081b;

        /* renamed from: c, reason: collision with root package name */
        private String f3082c;

        public b(Context context, String str) {
            this.f3081b = context;
            this.f3082c = str;
            this.f2653h = str + "#CommandAction";
        }

        @Override // cn.jiguang.by.b
        public void a() {
            try {
                a.this.g(this.f3081b, this.f3082c);
            } catch (Throwable th) {
                f.i("JCommon", "CommandAction-deal failed:" + th.getMessage());
            }
        }
    }

    public class c extends cn.jiguang.by.b {

        /* renamed from: b, reason: collision with root package name */
        private Context f3084b;

        /* renamed from: c, reason: collision with root package name */
        private String f3085c;

        c(Context context, String str) {
            this.f3084b = context;
            this.f3085c = str;
            this.f2653h = str + "#CommonAction";
        }

        @Override // cn.jiguang.by.b
        public void a() {
            try {
                a.this.f(this.f3084b, this.f3085c);
            } catch (Throwable th) {
                f.i("JCommon", "tag=" + this.f3085c + " dealAction failed:" + th.getMessage());
            }
        }
    }

    public class d extends cn.jiguang.by.b {

        /* renamed from: b, reason: collision with root package name */
        private Context f3087b;

        /* renamed from: c, reason: collision with root package name */
        private String f3088c;

        /* renamed from: d, reason: collision with root package name */
        private JSONObject f3089d;

        d(Context context, String str, JSONObject jSONObject) {
            this.f3087b = context;
            this.f3088c = str;
            this.f3089d = jSONObject;
            this.f2653h = str + "#JsonAction";
        }

        @Override // cn.jiguang.by.b
        public void a() {
            try {
                a.this.a(this.f3087b, this.f3088c, this.f3089d);
            } catch (Throwable th) {
                f.i("JCommon", "JsonAction-deal failed:" + th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Context context, String str) {
        boolean a6 = a(context, str);
        f.c("JCommon", str + " isBusinessEnable:" + a6);
        if (a6) {
            cn.jiguang.g.a.a().a(str);
            c(context, str);
        }
        boolean b6 = b(context, str);
        f.c("JCommon", str + " isReportEnable:" + b6);
        if (b6) {
            d(context, str);
        }
    }

    protected abstract String a(Context context);

    public void a(Context context, int i6) {
        String a6 = a(context);
        f.c("JCommon", "executeActionSingle: [" + a6 + "] from heartBeat, will delay " + i6 + "ms execute");
        boolean h6 = h(context, a6);
        boolean a7 = a(context, a6);
        boolean b6 = b(context, a6);
        f.c("JCommon", a6 + " isActionEnable:" + h6 + ", isBusinessEnable:" + a7 + ", reportEnable:" + b6);
        Integer num = cn.jiguang.g.a.f2941a.get(a6);
        if (!a7) {
            cn.jiguang.bw.a.a().a(num, 2026);
        }
        if (!b6) {
            cn.jiguang.bw.a.a().a(num, 2027);
        }
        if (h6) {
            if (a7 || b6) {
                cn.jiguang.bw.a.a().a(num, 2028);
                if (i6 > 0) {
                    cn.jiguang.be.b.a(new c(context, a6), i6);
                } else {
                    cn.jiguang.be.b.b(new c(context, a6));
                }
            }
        }
    }

    protected boolean a_() {
        return true;
    }

    public void b(Context context, JSONObject jSONObject) {
        String a6 = a(context);
        f.c("JCommon", "executeCommandActionSingle: [" + a6 + "] from cmd");
        boolean c6 = c();
        f.c("JCommon", a6 + " isActionUserEnable:" + c6);
        Integer num = cn.jiguang.g.a.f2941a.get(a6);
        if (!c6) {
            cn.jiguang.bw.a.a().a(num, 2019);
        } else {
            cn.jiguang.bw.a.a().a(num, 2025);
            cn.jiguang.be.b.b(new d(context, a6, jSONObject));
        }
    }

    public void c(Context context) {
        try {
            String a6 = a(context);
            f.c("JCommon", "executeAction: [" + a6 + "] from heartBeat");
            boolean h6 = h(context, a6);
            boolean a7 = a(context, a6);
            boolean b6 = b(context, a6);
            f.c("JCommon", a6 + " - isActionEnable:" + h6 + ", isBusinessEnable:" + a7 + ", reportEnable:" + b6);
            Integer num = cn.jiguang.g.a.f2941a.get(a6);
            if (!a7) {
                cn.jiguang.bw.a.a().a(num, 2026);
            }
            if (!b6) {
                cn.jiguang.bw.a.a().a(num, 2027);
            }
            if (h6) {
                if (a7 || b6) {
                    cn.jiguang.bw.a.a().a(num, 2028);
                    cn.jiguang.be.b.b(new c(context, a6));
                }
            }
        } catch (Throwable th) {
            f.c("JCommon", "executeAction failed, error:" + th);
        }
    }

    public void d(Context context) {
        String a6 = a(context);
        f.c("JCommon", "executeCommandAction: [" + a6 + "] from cmd");
        boolean h6 = h(context, a6);
        f.c("JCommon", a6 + " - isActionEnable:" + h6);
        Integer num = cn.jiguang.g.a.f2941a.get(a6);
        if (h6) {
            cn.jiguang.bw.a.a().a(num, 2028);
            cn.jiguang.be.b.b(new c(context, a6));
        }
    }

    public void e(Context context) {
        String a6 = a(context);
        f.c("JCommon", "executeActionSingle: [" + a6 + "] from heartBeat");
        boolean h6 = h(context, a6);
        boolean a7 = a(context, a6);
        f.c("JCommon", a6 + " isActionEnable:" + h6 + ", isBusinessEnable:" + a7);
        if (h6 && a7) {
            cn.jiguang.be.b.b(new b(context, a6));
        }
    }

    public Object g(Context context) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Context context, String str) {
        c(context, str);
        d(context, str);
    }

    private boolean h(Context context, String str) {
        Integer num = cn.jiguang.g.a.f2941a.get(str);
        boolean c6 = c();
        boolean a_ = a_();
        boolean f6 = f(context);
        boolean e6 = e(context, str);
        boolean z5 = c6 && a_ && f6 && e6;
        if (!c6) {
            cn.jiguang.bw.a.a().a(num, 2019);
        }
        if (!a_) {
            cn.jiguang.bw.a.a().a(num, 2020);
        }
        if (!f6) {
            cn.jiguang.bw.a.a().a(num, 2021);
        }
        cn.jiguang.bw.a.a().a(num, z5 ? 2023 : GLMapStaticValue.MAP_PARAMETERNAME_POLYGON_FILL_CONTROL);
        f.c("JCommon", str + " isActionEnable:" + z5 + ",actionUserEnable:" + c6 + ",actionCommandEnable:" + a_ + ",actionUidEnable:" + f6 + ",actionProtectionEnable:" + e6);
        return z5;
    }

    public void a(Context context, Bundle bundle) {
        String a6 = a(context);
        f.c("JCommon", "executeBundleAction: [" + a6 + "] from bundle");
        boolean c6 = c();
        f.c("JCommon", a6 + " isActionUserEnable:" + c6);
        Integer num = cn.jiguang.g.a.f2941a.get(a6);
        if (!c6) {
            cn.jiguang.bw.a.a().a(num, 2019);
        }
        if (c6) {
            cn.jiguang.bw.a.a().a(num, 2028);
            cn.jiguang.be.b.b(new C0049a(context, a6, bundle));
        }
    }

    protected void c(Context context, String str) {
        cn.jiguang.m.b.e(context, str);
    }

    protected void d(Context context, String str) {
        cn.jiguang.m.b.h(context, str);
    }

    protected boolean e(Context context, String str) {
        long b6 = cn.jiguang.d.b.b(context) * 1000;
        if (Math.abs(b6 - cn.jiguang.d.a.g(context)) < cn.jiguang.g.a.a().c(str)) {
            f.c("JCommon", "isProtectionTime is false");
            return false;
        }
        f.c("JCommon", "isProtectionTime is true");
        return true;
    }

    protected boolean f(Context context) {
        return cn.jiguang.d.a.f(context) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, Bundle bundle) {
        a(str, bundle);
        boolean d6 = d();
        f.c("JCommon", str + " isActionBundleEnable:" + d6);
        if (d6) {
            c(context, str);
            d(context, str);
        }
    }

    protected boolean b(Context context, String str) {
        return cn.jiguang.m.b.c(context, str);
    }

    protected boolean c() {
        return true;
    }

    protected boolean d() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, JSONObject jSONObject) {
        a(str, jSONObject);
        if (jSONObject.optInt("cmd") != 45) {
            boolean a_ = a_();
            f.c("JCommon", str + " isActionCommandEnable:" + a_);
            if (a_) {
                c(context, str);
                d(context, str);
            }
        }
    }

    public void a(Context context, JSONObject jSONObject) {
        String a6 = a(context);
        f.c("JCommon", "executeJsonAction: [" + a6 + "] from cmd");
        boolean c6 = c();
        f.c("JCommon", a6 + " isActionUserEnable:" + c6);
        Integer num = cn.jiguang.g.a.f2941a.get(a6);
        if (!c6) {
            cn.jiguang.bw.a.a().a(num, 2019);
        }
        if (c6) {
            cn.jiguang.bw.a.a().a(num, 2028);
            cn.jiguang.be.b.b(new d(context, a6, jSONObject));
        }
    }

    protected void a(String str, Bundle bundle) {
        if (bundle != null) {
            f.c("JCommon", str + " parseJson:" + bundle.toString());
        }
    }

    protected void a(String str, JSONObject jSONObject) {
    }

    protected boolean a(Context context, String str) {
        return cn.jiguang.m.b.a(context, str);
    }
}
