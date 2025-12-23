package cn.jiguang.al;

import android.content.Context;
import cn.jiguang.bz.q;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class g extends cn.jiguang.m.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f1614a;

    /* renamed from: cn.jiguang.al.g$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a extends cn.jiguang.by.b {

        /* renamed from: b, reason: collision with root package name */
        private Context f1616b;

        public a(Context context) {
            this.f1616b = context;
            this.f2653h = "JLocationv2#RequestConfigAction";
        }

        @Override // cn.jiguang.by.b
        public void a() {
            boolean d6 = f.a().d(this.f1616b);
            cn.jiguang.m.b.e(this.f1616b, "JLocationv2_cfg");
            if (d6) {
                g.this.c(this.f1616b, "JLocationv2");
            }
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final g f1617a = new g(null);
    }

    private g() {
    }

    public static g a() {
        return b.f1617a;
    }

    public void b(Context context, int i6) {
        try {
            cn.jiguang.be.b.a(new a(context), i6);
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JLocationv2", "[requestConfig failed] " + th.getMessage());
        }
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
        if (!cn.jiguang.g.a.a().a(1500)) {
            cn.jiguang.an.a.a(context, "loc_info_v2", -3);
            return;
        }
        if (!b(context)) {
            cn.jiguang.an.a.a(context, "loc_info_v2", -5);
            return;
        }
        cn.jiguang.bb.f.c("JLocationv2", " doBusiness , gpsEnanble:" + e.f1592b + ",wifiEnanble :" + e.f1591a + ",cellEnanble:" + e.f1593c);
        if (!e.f1592b || !cn.jiguang.g.a.a().e(AVMDLDataLoader.KeyIsIsTestSpeedVersion)) {
            cn.jiguang.an.a.a(context, "loc_info_v2", "g", !e.f1592b ? 1 : -3);
        } else if (cn.jiguang.m.b.b(context, "JLocationv2_g")) {
            h.a(context).b();
            h.a(context).c();
            cn.jiguang.m.b.e(context, "JLocationv2_g");
        }
        if (!e.f1591a || !cn.jiguang.g.a.a().e(AVMDLDataLoader.KeyIsIsEncryptVersion)) {
            cn.jiguang.an.a.a(context, "loc_info_v2", IAdInterListener.AdReqParam.WIDTH, !e.f1591a ? 1 : -3);
        } else if (cn.jiguang.m.b.b(context, "JLocationv2_w")) {
            h.a(context).a();
            cn.jiguang.m.b.e(context, "JLocationv2_w");
        }
        if (!e.f1593c || !cn.jiguang.g.a.a().e(1501)) {
            cn.jiguang.an.a.a(context, "loc_info_v2", "c", e.f1593c ? -3 : 1);
        } else if (cn.jiguang.m.b.b(context, "JLocationv2_c")) {
            h.a(context).d();
            cn.jiguang.m.b.e(context, "JLocationv2_c");
        }
    }

    /* synthetic */ g(AnonymousClass1 anonymousClass1) {
        this();
    }

    private boolean b(Context context) {
        return (q.a(context, com.kuaishou.weapon.p0.g.f36048h) || q.a(context, com.kuaishou.weapon.p0.g.f36047g)) && cn.jiguang.d.a.p(context);
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f1614a = context;
        if (!cn.jiguang.g.a.a().a(1500)) {
            return "JLocationv2";
        }
        try {
            f.a(context);
            if (System.currentTimeMillis() - cn.jiguang.m.b.f(context, "JLocationv2_cfg") > 86400000) {
                b(context, cn.jiguang.aj.a.a().b(true));
            }
        } catch (Throwable unused) {
        }
        return "JLocationv2";
    }

    @Override // cn.jiguang.m.a
    protected boolean a_() {
        return cn.jiguang.m.b.k(this.f1614a, "JLocationv2");
    }

    @Override // cn.jiguang.m.a
    protected boolean c() {
        return cn.jiguang.g.a.a().a(1500);
    }

    @Override // cn.jiguang.m.a
    protected boolean a(Context context, String str) {
        return cn.jiguang.g.a.a().a(1500);
    }

    @Override // cn.jiguang.m.a
    protected boolean b(Context context, String str) {
        if (cn.jiguang.g.a.a().a(1500)) {
            return cn.jiguang.m.b.d(context, str);
        }
        return false;
    }

    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
        if (!cn.jiguang.g.a.a().a(1500) || !b(context)) {
            return;
        }
        JSONObject e6 = h.a(context).e();
        if (e6 == null) {
            cn.jiguang.bb.f.c("JLocationv2", "there are no data to report");
            return;
        }
        cn.jiguang.be.b.a(context, e6, "loc_info_v2");
        cn.jiguang.bb.f.c("JLocationv2", "clean cache");
        h.a(context).f();
        super.d(context, str);
    }
}
