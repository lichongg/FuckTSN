package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.app.Service;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.model.ShowWindowModel;
import com.acse.ottn.service.a;
import com.acse.ottn.util.HelpShopAppUtil;
import com.alibaba.fastjson.JSON;
import java.io.ObjectStreamException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class h2 {

    /* renamed from: c, reason: collision with root package name */
    public static View f4592c = null;

    /* renamed from: d, reason: collision with root package name */
    public static WindowManager f4593d = null;

    /* renamed from: e, reason: collision with root package name */
    public static String f4594e = "MainService";

    /* renamed from: f, reason: collision with root package name */
    public static h2 f4595f;

    /* renamed from: a, reason: collision with root package name */
    public WindowManager.LayoutParams f4596a;

    /* renamed from: b, reason: collision with root package name */
    public AccessiblityModel f4597b;

    public static h2 a() {
        if (f4595f == null) {
            synchronized (h2.class) {
                try {
                    if (f4595f == null) {
                        f4595f = new h2();
                    }
                } finally {
                }
            }
        }
        return f4595f;
    }

    public final Object b() throws ObjectStreamException {
        return f4595f;
    }

    public final void b(Service service, AccessiblityModel accessiblityModel, a.u0 u0Var) {
        if (accessiblityModel == null || accessiblityModel.getData() == null || TextUtils.isEmpty(accessiblityModel.getData().getPackage_name())) {
            return;
        }
        if (!TextUtils.isEmpty(accessiblityModel.getData().getCoupon_type()) && "1".equals(accessiblityModel.getData().getCoupon_type())) {
            if (accessiblityModel.getData().getPackage_name().equals(n.c().f4866t) || accessiblityModel.getData().getPackage_name().equals(n.c().f4867u)) {
                if ("1".equals(accessiblityModel.getData().getPic_type())) {
                    c2.a(f4594e, "taobao礼金大图");
                    a(service, R.layout.tb_lijin_big_background);
                    com.acse.ottn.service.a.b().B(service, f4592c, accessiblityModel, u0Var);
                    this.f4596a.height = -1;
                    return;
                }
                a(accessiblityModel.getData().getPackage_name());
                c2.a(f4594e, "淘宝大图");
                a(service, R.layout.taobao_old_big_background);
                com.acse.ottn.service.a.b().z(service, f4592c, accessiblityModel, u0Var);
                this.f4596a.height = -1;
                return;
            }
            if (accessiblityModel.getData().getPackage_name().equals(n.c().f4869w)) {
                if ("1".equals(accessiblityModel.getData().getPic_type())) {
                    c2.a(f4594e, "jd礼金大图");
                    a(service, R.layout.jd_lijin_big_background);
                    com.acse.ottn.service.a.b().J(service, f4592c, accessiblityModel, u0Var);
                    this.f4596a.height = -1;
                    return;
                }
                c2.a(f4594e, "jd大图");
                a(accessiblityModel.getData().getPackage_name());
                a(service, R.layout.jd_shop_big_background);
                com.acse.ottn.service.a.b().I(service, f4592c, accessiblityModel, u0Var);
                this.f4596a.height = -1;
                return;
            }
            if (accessiblityModel.getData().getPackage_name().equals(n.c().J) || accessiblityModel.getData().getPackage_name().equals(n.c().N) || accessiblityModel.getData().getPackage_name().equals(n.c().f4858l)) {
                c2.a(f4594e, "mt大图");
                a(accessiblityModel.getData().getPackage_name());
                a(service, R.layout.meituan_big_background);
                com.acse.ottn.service.a.b().y(service, f4592c, accessiblityModel, u0Var);
                this.f4596a.height = -1;
                return;
            }
            if (accessiblityModel.getData().getPackage_name().equals(n.c().f4859m)) {
                c2.a(f4594e, "tb FZ大图");
                a(accessiblityModel.getData().getPackage_name());
                a(service, R.layout.tbfz_shop_big_background);
                com.acse.ottn.service.a.b().u(service, f4592c, accessiblityModel, u0Var);
                this.f4596a.height = -1;
                return;
            }
            if (accessiblityModel.getData().getPackage_name().equals(n.c().O) || accessiblityModel.getData().getPackage_name().equals(n.c().R)) {
                c2.a(f4594e, "eleme大图");
                a(accessiblityModel.getData().getPackage_name());
                a(service, R.layout.eleme_shop_big_background);
                com.acse.ottn.service.a.b().E(service, f4592c, accessiblityModel, u0Var);
                this.f4596a.height = -1;
                return;
            }
            if (accessiblityModel.getData().getPackage_name().equals(n.c().f4870x)) {
                c2.a(f4594e, "京东外卖大图");
                a(accessiblityModel.getData().getPackage_name());
                a(service, R.layout.jdwm_shop_big_background);
                com.acse.ottn.service.a.b().v(service, f4592c, accessiblityModel, u0Var);
                this.f4596a.height = -1;
                return;
            }
            if (accessiblityModel.getData().getPackage_name().equals(n.c().K)) {
                c2.a(f4594e, "didi大图");
                a(accessiblityModel.getData().getPackage_name());
                a(service, R.layout.didi_big_background);
                this.f4596a.height = -1;
                com.acse.ottn.service.a.b().s(service, f4592c, accessiblityModel, u0Var);
                return;
            }
            if (accessiblityModel.getData().getPackage_name().equals(n.c().U)) {
                a(service, R.layout.video_taobao_main_background);
                com.acse.ottn.service.a.b().b(service, f4592c, accessiblityModel, u0Var);
                this.f4596a.height = -1;
                return;
            }
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(n.c().f4866t) || accessiblityModel.getData().getPackage_name().equals(n.c().f4867u)) {
            if ("1".equals(accessiblityModel.getData().getPic_type())) {
                c2.a(f4594e, "taobao礼金图");
                a(service, R.layout.tb_lj_smile_background);
                com.acse.ottn.service.a.b().A(service, f4592c, accessiblityModel, u0Var);
                this.f4596a.height = -1;
                return;
            }
            c2.a(f4594e, "tb小图");
            this.f4596a.height = u0.a((Context) service, 320.0f);
            a(service, R.layout.shop_smile_background);
            com.acse.ottn.service.a.b().C(service, f4592c, accessiblityModel, u0Var);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(n.c().f4869w)) {
            c2.a(f4594e, "jd小图");
            a(service, R.layout.jd_shop_smile_background);
            com.acse.ottn.service.a.b().K(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = u0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(n.c().J) || accessiblityModel.getData().getPackage_name().equals(n.c().N) || accessiblityModel.getData().getPackage_name().equals(n.c().f4858l)) {
            c2.a(f4594e, "mt小图");
            a(service, R.layout.meituan_smile_background);
            com.acse.ottn.service.a.b().x(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = u0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(n.c().f4859m)) {
            c2.a(f4594e, "tb FZ小图");
            a(service, R.layout.tbfz_smile_background);
            com.acse.ottn.service.a.b().G(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = u0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(n.c().O) || accessiblityModel.getData().getPackage_name().equals(n.c().R)) {
            c2.a(f4594e, "eleme小图");
            a(service, R.layout.eleme_smile_background);
            com.acse.ottn.service.a.b().F(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = u0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(n.c().f4870x)) {
            c2.a(f4594e, "京东小图");
            a(service, R.layout.jdwm_smile_background);
            com.acse.ottn.service.a.b().w(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = u0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(n.c().K)) {
            c2.a(f4594e, "didi小图");
            a(service, R.layout.didi_smile_background);
            com.acse.ottn.service.a.b().t(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = u0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(n.c().f4871y)) {
            c2.a(f4594e, "美团鲜花");
            a(service, R.layout.mt_xh_smile_background);
            com.acse.ottn.service.a.b().o(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = u0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(n.c().A)) {
            c2.a(f4594e, "美团医药");
            a(service, R.layout.mt_yy_smile_background);
            com.acse.ottn.service.a.b().q(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = u0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(n.c().B)) {
            c2.a(f4594e, "美团酒店");
            a(service, R.layout.mt_hotel_smile_background);
            com.acse.ottn.service.a.b().p(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = u0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(n.c().D)) {
            c2.a(f4594e, "美团超市");
            a(service, R.layout.mt_shop_smile_background);
            com.acse.ottn.service.a.b().r(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = u0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(n.c().F)) {
            c2.a(f4594e, "咸鱼");
            a(service, R.layout.idlefish_smile_background);
            com.acse.ottn.service.a.b().d(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = u0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(n.c().G)) {
            c2.a(f4594e, "闪购");
            a(service, R.layout.shangou_smile_background);
            com.acse.ottn.service.a.b().h(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = u0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(n.c().T)) {
            c2.a(f4594e, "淘宝首页");
            a(service, R.layout.tb_home_smile_background);
            com.acse.ottn.service.a.b().i(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = u0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(n.c().W)) {
            c2.a(f4594e, "jd首页");
            a(service, R.layout.jd_home_smile_background);
            com.acse.ottn.service.a.b().e(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = u0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(n.c().f4861o) || accessiblityModel.getData().getPackage_name().equals(n.c().f4862p)) {
            c2.a(f4594e, "快手和快手极速版");
            a(service, R.layout.ks_smile_background);
            com.acse.ottn.service.a.b().g(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = u0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(n.c().f4848b0)) {
            c2.a(f4594e, "唯品会");
            a(service, R.layout.wph_smile_background);
            com.acse.ottn.service.a.b().l(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = u0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(n.c().U)) {
            a(service, R.layout.custom_smile_background);
            com.acse.ottn.service.a.b().c(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = u0.a((Context) service, 320.0f);
        }
    }

    public void c(Service service, AccessiblityModel accessiblityModel, a.u0 u0Var) {
        if (accessiblityModel == null || accessiblityModel.getData() == null || TextUtils.isEmpty(accessiblityModel.getData().getPackage_name())) {
            return;
        }
        c2.a(f4594e, "开始显示弹框=" + accessiblityModel.toString());
        if (accessiblityModel.getData().getPackage_name().equals(n.c().S)) {
            a(service, R.layout.video_aiqiyi_background);
            com.acse.ottn.service.a.b().k(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = -1;
        } else if (accessiblityModel.getData().getPackage_name().equals(n.c().M)) {
            a(service, R.layout.youku_background);
            com.acse.ottn.service.a.b().n(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = -1;
        } else if (accessiblityModel.getData().getPackage_name().equals(n.c().L)) {
            a(service, R.layout.tencent_background);
            com.acse.ottn.service.a.b().j(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = -1;
        } else if (accessiblityModel.getData().getPackage_name().equals(n.c().f4863q)) {
            a(service, R.layout.baidu_wnagpan_background);
            com.acse.ottn.service.a.b().a(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = -1;
        } else if (accessiblityModel.getData().getPackage_name().equals(n.c().f4865s)) {
            a(service, R.layout.kfc_background);
            com.acse.ottn.service.a.b().f(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = -1;
        } else if (accessiblityModel.getData().getPackage_name().equals(n.c().f4864r)) {
            a(service, R.layout.hxz_shop_big_background);
            com.acse.ottn.service.a.b().H(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = -1;
        } else if (accessiblityModel.getData().getPackage_name().equals(n.c().Q)) {
            c2.a(f4594e, "xbk大图");
            a(accessiblityModel.getData().getPackage_name());
            a(service, R.layout.xbk_background);
            com.acse.ottn.service.a.b().D(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = -1;
        } else if (accessiblityModel.getData().getPackage_name().equals(n.c().f4860n)) {
            a(service, R.layout.xhs_main_background);
            com.acse.ottn.service.a.b().m(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = -1;
        } else {
            c2.a(f4594e, "show setGoodData");
            b(service, accessiblityModel, u0Var);
        }
        c2.a(f4594e, "show view   CommonUtil.isShowConpunInfor= " + k0.f4669e);
        if (k0.f4669e) {
            try {
                c2.a(f4594e, "show view");
                f4593d.addView(f4592c, this.f4596a);
                if (accessiblityModel.getData().getPlay_audio() == 1) {
                    HelpShopAppUtil.playVideo(service);
                }
            } catch (Exception e6) {
                c2.a(f4594e, "添加失败 e=" + e6.getMessage());
            }
        }
    }

    public final void a(Service service, int i6) {
        c2.a(f4594e, "setLayoutView ");
        try {
            if (!d4.a().a(service)) {
                service = (AccessibilityService) service;
            }
            View inflate = LayoutInflater.from(service.getApplication()).inflate(i6, (ViewGroup) null);
            f4592c = inflate;
            inflate.measure(0, 0);
        } catch (Exception e6) {
            c2.a(f4594e, "setLayoutView e = " + e6.getMessage());
        }
    }

    public final void a(String str) {
        String str2;
        ShowWindowModel showWindowModel;
        String str3 = str + "pic_type";
        c2.a("ShopHelperService", "isShowBigPicture ");
        if (j3.a() != null) {
            str2 = j3.a().e(str3);
            c2.a("MainServiceShowUtil", " ---samon QuickPreference.getInstance() jsondata=" + str2);
        } else {
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2) && str2 != null) {
            showWindowModel = (ShowWindowModel) JSON.parseObject(str2, ShowWindowModel.class);
            c2.a("MainServiceShowUtil", "isShowBigPicture ---samon jsondata= " + str2);
            c2.a("MainServiceShowUtil", "isShowBigPicture ---samon label1= " + showWindowModel.toString());
        } else {
            showWindowModel = new ShowWindowModel();
            c2.a("MainServiceShowUtil", "isShowBigPicture ---samon jsondata= is null");
            c2.a("MainServiceShowUtil", "isShowBigPicture ---samon label1= " + showWindowModel.toString());
        }
        showWindowModel.setAppName(str3);
        String a6 = r0.d().a();
        c2.a("MainServiceShowUtil", "isShowBigPicture ---samon label2 = " + showWindowModel.toString());
        c2.a("MainServiceShowUtil", "isShowBigPicture ---samon date= " + a6);
        if (showWindowModel.getShowBigWindowData().equals(a6)) {
            return;
        }
        showWindowModel.setShowBigWindowData(a6);
        c2.a("MainServiceShowUtil", "isShowBigPicture ---samon label3 = " + showWindowModel.toString());
        String jSONString = JSON.toJSONString(showWindowModel);
        c2.a("MainServiceShowUtil", "isShowBigPicture ---samon  str= " + jSONString);
        if (j3.a() != null) {
            j3.a().b(str3, jSONString);
            c2.a("MainServiceShowUtil", "isShowBigPicture ---samon  jsondata= is null");
            c2.a("MainServiceShowUtil", " ---samon s= " + j3.a().e(str3));
        }
    }

    public void a(Service service) {
        this.f4596a = new WindowManager.LayoutParams();
        if (d4.a().a(service)) {
            f4593d = (WindowManager) service.getApplication().getSystemService("window");
            if (Build.VERSION.SDK_INT >= 26) {
                this.f4596a.type = 2038;
            } else {
                this.f4596a.type = 2002;
            }
            this.f4596a.flags = 8;
        } else {
            f4593d = (WindowManager) service.getSystemService("window");
            WindowManager.LayoutParams layoutParams = this.f4596a;
            layoutParams.type = 2032;
            layoutParams.flags = 800;
        }
        WindowManager.LayoutParams layoutParams2 = this.f4596a;
        layoutParams2.format = 1;
        layoutParams2.windowAnimations = android.R.style.Animation.Translucent;
        layoutParams2.gravity = 51;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
    }

    public void a(Service service, String str, a.u0 u0Var) {
        c2.c(f4594e, "noShowCoupon ");
        try {
            f4593d.removeView(f4592c);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a(service, R.layout.coupon_no_showbackground);
            com.acse.ottn.service.a.b().a(f4592c, str, true, u0Var);
            WindowManager.LayoutParams layoutParams = this.f4596a;
            layoutParams.height = -2;
            f4593d.addView(f4592c, layoutParams);
        } catch (Exception e6) {
            c2.c(f4594e, "noShowCoupon e=" + e6.getMessage());
        }
    }

    public void a(Service service, AccessiblityModel accessiblityModel, a.u0 u0Var) {
        if (accessiblityModel == null || accessiblityModel.getData() == null) {
            return;
        }
        if (!TextUtils.isEmpty(accessiblityModel.getData().getCoupon_type()) && "1".equals(accessiblityModel.getData().getCoupon_type())) {
            a(service, R.layout.video_taobao_main_background);
            com.acse.ottn.service.a.b().b(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = -1;
        } else {
            a(service, R.layout.custom_smile_background);
            com.acse.ottn.service.a.b().c(service, f4592c, accessiblityModel, u0Var);
            this.f4596a.height = u0.a((Context) service, 320.0f);
        }
        if (k0.f4669e) {
            try {
                c2.a(f4594e, "show view");
                f4593d.addView(f4592c, this.f4596a);
                if (accessiblityModel.getData().getPlay_audio() == 1) {
                    HelpShopAppUtil.playVideo(service);
                }
            } catch (Exception e6) {
                c2.a(f4594e, "添加失败 e=" + e6.getMessage());
            }
        }
    }

    public void b(Service service) {
        try {
            View view = f4592c;
            if (view != null) {
                view.setVisibility(8);
            }
            f4593d.removeView(f4592c);
            if (!d4.a().a(service)) {
                service = (AccessibilityService) service;
            }
            service.stopSelf();
        } catch (Exception e6) {
            c2.a(f4594e, "dismiss e=" + e6.getMessage());
        }
    }
}
