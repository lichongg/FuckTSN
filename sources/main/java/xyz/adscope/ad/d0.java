package xyz.adscope.ad;

import android.content.Context;
import com.stub.StubApp;
import xyz.adscope.ad.d5;
import xyz.adscope.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import xyz.adscope.ad.publish.ASNPInitConfig;
import xyz.adscope.common.analyse.model.IBaseEventReportModel;
import xyz.adscope.common.analyse.model.IStringEventEnum;
import xyz.adscope.common.v2.dev.DeviceObtainManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class d0 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Context f54940a;

        /* renamed from: b, reason: collision with root package name */
        private d5.f f54941b;

        /* renamed from: c, reason: collision with root package name */
        private d5.b f54942c;

        /* renamed from: d, reason: collision with root package name */
        private d5.i f54943d;

        /* renamed from: e, reason: collision with root package name */
        private d5.d f54944e;

        /* renamed from: f, reason: collision with root package name */
        private d5.g f54945f;

        /* renamed from: g, reason: collision with root package name */
        private d5.a f54946g;

        /* renamed from: h, reason: collision with root package name */
        private d5.h f54947h;

        /* renamed from: i, reason: collision with root package name */
        private d5.e f54948i;

        /* renamed from: j, reason: collision with root package name */
        private d5.c f54949j;

        /* synthetic */ b(Context context, a aVar) {
            this(context);
        }

        private b(Context context) {
            this.f54940a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            a();
        }

        private b b() {
            this.f54942c = new d5.b(this.f54940a);
            return this;
        }

        private b c() {
            this.f54944e = new d5.d(this.f54940a);
            return this;
        }

        private b d() {
            this.f54941b = new d5.f(DeviceObtainManager.getInstance().getOrCreateImplement(this.f54940a));
            return this;
        }

        private b e() {
            ConfigResponseModel a6;
            e orCreateImplement = f.a().getOrCreateImplement(this.f54940a);
            if (orCreateImplement != null && (a6 = orCreateImplement.a(true)) != null) {
                this.f54945f = new d5.g(a6);
            }
            return this;
        }

        private b f() {
            ASNPInitConfig a6;
            e orCreateImplement = f.a().getOrCreateImplement(this.f54940a);
            if (orCreateImplement != null && (a6 = orCreateImplement.a()) != null) {
                this.f54943d = new d5.i(a6);
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b a(j4 j4Var) {
            this.f54947h = new d5.h(j4Var.f(), j4Var.e() + "");
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b a(m1 m1Var) {
            this.f54948i = new d5.e(m1Var);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b a(b1 b1Var) {
            this.f54946g = new d5.a(b1Var);
            return this;
        }

        private b a() {
            c();
            e();
            f();
            b();
            d();
            j4 b6 = f.a().getOrCreateImplement(this.f54940a).b();
            if (b6 != null) {
                a(b6);
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b a(String str) {
            this.f54949j = new d5.c(str);
            return this;
        }

        public IBaseEventReportModel a(IStringEventEnum iStringEventEnum) {
            d5 d5Var = new d5(iStringEventEnum);
            d5Var.a(this.f54946g);
            d5Var.a(this.f54942c);
            d5Var.a(this.f54944e);
            d5Var.a(this.f54948i);
            d5Var.a(this.f54941b);
            d5Var.a(this.f54945f);
            d5Var.a(this.f54943d);
            d5Var.a(this.f54947h);
            d5Var.a(this.f54949j);
            return d5Var;
        }
    }

    public static IBaseEventReportModel a(Context context, IStringEventEnum iStringEventEnum, j4 j4Var) {
        return new b(context, null).a(j4Var).a(iStringEventEnum);
    }

    public static IBaseEventReportModel a(Context context, IStringEventEnum iStringEventEnum, b1 b1Var) {
        return new b(context, null).a(b1Var).a(iStringEventEnum);
    }

    public static IBaseEventReportModel a(Context context, IStringEventEnum iStringEventEnum, m1 m1Var) {
        return new b(context, null).a(m1Var).a(iStringEventEnum);
    }

    public static IBaseEventReportModel a(Context context, IStringEventEnum iStringEventEnum, String str) {
        return new b(context, null).a(str).a(iStringEventEnum);
    }
}
