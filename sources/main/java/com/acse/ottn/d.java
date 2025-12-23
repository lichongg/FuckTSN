package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.h4;
import com.acse.ottn.io.reactivex.annotations.NonNull;
import com.acse.ottn.l2;
import com.acse.ottn.m0;
import com.acse.ottn.m1;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.model.AdPackageModel;
import com.acse.ottn.model.PageSettingTypeModel;
import com.acse.ottn.s0;
import com.acse.ottn.service.CircleFlowService;
import com.acse.ottn.service.ExcessiveService;
import com.acse.ottn.service.a;
import com.acse.ottn.util.HelpShopAppUtil;
import com.baidu.mobads.sdk.internal.bn;
import com.umeng.socialize.common.SocializeConstants;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class d implements a.u0 {
    public static g2 A = null;
    public static String B = "acse_ShopHelperService";

    /* renamed from: x, reason: collision with root package name */
    public static d f4326x;

    /* renamed from: y, reason: collision with root package name */
    public static TimerTask f4327y;

    /* renamed from: z, reason: collision with root package name */
    public static TimerTask f4328z;

    /* renamed from: e, reason: collision with root package name */
    public String f4333e;

    /* renamed from: f, reason: collision with root package name */
    public String f4334f;

    /* renamed from: g, reason: collision with root package name */
    public List<String> f4335g;

    /* renamed from: h, reason: collision with root package name */
    public List<String> f4336h;

    /* renamed from: j, reason: collision with root package name */
    public AccessibilityService f4338j;

    /* renamed from: l, reason: collision with root package name */
    public Intent f4340l;

    /* renamed from: t, reason: collision with root package name */
    public String f4348t;

    /* renamed from: v, reason: collision with root package name */
    public AccessibilityNodeInfo f4350v;

    /* renamed from: w, reason: collision with root package name */
    public List f4351w;

    /* renamed from: a, reason: collision with root package name */
    public int f4329a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f4330b = 10069;

    /* renamed from: c, reason: collision with root package name */
    public int f4331c = 10067;

    /* renamed from: d, reason: collision with root package name */
    public int f4332d = 10065;

    /* renamed from: i, reason: collision with root package name */
    public int f4337i = 0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f4339k = true;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4341m = false;

    /* renamed from: n, reason: collision with root package name */
    public String f4342n = "";

    /* renamed from: o, reason: collision with root package name */
    public String f4343o = "";

    /* renamed from: p, reason: collision with root package name */
    public boolean f4344p = false;

    /* renamed from: q, reason: collision with root package name */
    public int f4345q = 0;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4346r = false;

    /* renamed from: s, reason: collision with root package name */
    public String f4347s = "";

    /* renamed from: u, reason: collision with root package name */
    public Handler f4349u = new h(Looper.getMainLooper());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements m0.d {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.acse.ottn.d$a$a, reason: collision with other inner class name */
        public class RunnableC0071a implements Runnable {

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.acse.ottn.d$a$a$a, reason: collision with other inner class name */
            public class C0072a implements l2.c {
                public C0072a() {
                }

                @Override // com.acse.ottn.l2.c
                public void a() {
                    com.acse.ottn.e.c().b();
                }
            }

            public RunnableC0071a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (r0.d().c(r0.d().a()) + (HelpShopAppUtil.getInstance().createRandomNumber().longValue() * 1000) > System.currentTimeMillis()) {
                    TimerTask timerTask = d.f4328z;
                    if (timerTask != null) {
                        timerTask.cancel();
                        d.f4328z = null;
                        return;
                    }
                    return;
                }
                j4.r();
                l2.b().b("heart_beat", null, new C0072a());
                if (!j3.a().a("accessiblity_lists")) {
                    com.acse.ottn.b.c().b();
                    j3.a().a("accessiblity_lists", Boolean.TRUE);
                }
                c2.b(d.B, "心跳 倒计时设置位false");
                j0.a(HelpShopAppUtil.getContext());
            }
        }

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            try {
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0071a(), 2000L);
            } catch (Throwable th) {
                c2.a(d.B, th.getMessage());
            }
        }

        public a() {
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            c2.a(d.B, "结束了");
            TimerTask timerTask = d.f4328z;
            if (timerTask != null) {
                timerTask.cancel();
                d.f4328z = null;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements m1.b0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4355a;

        @Override // com.acse.ottn.m1.b0
        public void a(int i6, int i7) {
            if (i6 != 1) {
                h2.a().b(d.this.f4338j);
            } else {
                if (i7 != 1) {
                    h2.a().b(d.this.f4338j);
                    return;
                }
                h2 a6 = h2.a();
                d dVar = d.this;
                a6.a(dVar.f4338j, this.f4355a, dVar);
            }
        }

        public b(String str) {
            this.f4355a = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PageSettingTypeModel f4357a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4358b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (k0.f4671g || "1".equals(j3.a().a("read_timeout", "0"))) {
                    k0.f4671g = false;
                    if (c.this.f4357a.getPackage_name().equals(n.c().f4866t)) {
                        d.this.f4348t = "0";
                    }
                    List<String> list = d.this.f4335g;
                    if (list == null || list.size() != 0) {
                        c cVar = c.this;
                        d dVar = d.this;
                        List<String> list2 = dVar.f4335g;
                        String package_name = cVar.f4357a.getPackage_name();
                        c cVar2 = c.this;
                        dVar.a(list2, package_name, cVar2.f4358b, d.this.f4348t);
                    }
                }
            }
        }

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            try {
                d dVar = d.this;
                if (dVar.f4335g != null) {
                    c2.a(d.B, d.this.f4335g.toString());
                } else {
                    dVar.f4337i = 0;
                    dVar.f4335g = new ArrayList();
                }
                if (!s0.a().a(d.this.f4335g, this.f4357a.getRead_length())) {
                    if (!this.f4357a.getPackage_name().equals(n.c().f4866t) || !"1".equals(j3.a().e("ocr_screen_state")) || (TextUtils.isEmpty(d.d().f4342n) && TextUtils.isEmpty(d.d().f4343o))) {
                        c2.a("samon", "开始截屏3");
                        d.this.d(this.f4357a.getPackage_name());
                        d dVar2 = d.this;
                        dVar2.a(dVar2.f4338j, this.f4357a);
                        return;
                    }
                    if (d.f4327y != null) {
                        c2.a("samon", "结束读屏3");
                        d.f4327y.cancel();
                        d.f4327y = null;
                    }
                    d.this.a(this.f4357a);
                    return;
                }
                if (this.f4357a.getPackage_name().equals(n.c().f4866t) && !s0.a().a(d.this.f4335g)) {
                    if (TextUtils.isEmpty(d.d().f4342n) && TextUtils.isEmpty(d.d().f4343o) && "1".equals(j3.a().e("ocr_screen_state"))) {
                        c2.a("samon", "开始截屏2");
                        d.this.d(this.f4357a.getPackage_name());
                        d dVar3 = d.this;
                        dVar3.a(dVar3.f4338j, this.f4357a);
                        return;
                    }
                    if (d.f4327y != null) {
                        c2.a("samon", "结束读屏2");
                        d.f4327y.cancel();
                        d.f4327y = null;
                    }
                    d.this.a(this.f4357a);
                    return;
                }
                if (d.f4327y != null) {
                    c2.a("samon", "结束读屏1");
                    d.f4327y.cancel();
                    d.f4327y = null;
                }
                d.this.a(this.f4357a);
            } catch (Throwable th) {
                c2.a(d.B, "gainContent=" + th.getMessage());
            }
        }

        public c(PageSettingTypeModel pageSettingTypeModel, String str) {
            this.f4357a = pageSettingTypeModel;
            this.f4358b = str;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            TimerTask timerTask = d.f4327y;
            if (timerTask != null) {
                timerTask.cancel();
                d.f4327y = null;
            }
            c2.a(d.B, "gainContent finish");
            List<String> list = d.this.f4335g;
            if (list == null || list.size() < 6) {
                return;
            }
            d.this.f4348t = "";
            c2.a(d.B, "model.getPackage_name() =" + this.f4357a.getPackage_name() + "   model.getIs_click_jd_title()=" + this.f4357a.getIs_click_jd_title());
            if (this.f4357a.getPackage_name().equals(n.c().f4869w) && this.f4357a.getIs_click_jd_title().equals("0")) {
                d dVar = d.this;
                dVar.f4348t = dVar.c(dVar.f4338j);
                if (!TextUtils.isEmpty(d.this.f4348t)) {
                    d dVar2 = d.this;
                    dVar2.f4335g.add(dVar2.f4348t);
                }
            }
            c2.a(d.B, d.this.f4335g.toString());
            new Handler(Looper.getMainLooper()).postDelayed(new a(), 0L);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.acse.ottn.d$d, reason: collision with other inner class name */
    public class C0073d implements m1.a0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4361a;

        @Override // com.acse.ottn.m1.a0
        public void a(AccessiblityModel accessiblityModel) {
            d.this.a(accessiblityModel, this.f4361a);
            List<String> list = d.this.f4335g;
            if (list != null) {
                list.removeAll(list);
                d.this.f4335g = new ArrayList();
                d.this.f4337i = 0;
            }
        }

        public C0073d(String str) {
            this.f4361a = str;
        }

        @Override // com.acse.ottn.m1.a0
        public void a(String str) {
            List<String> list = d.this.f4335g;
            if (list != null) {
                list.removeAll(list);
                d.this.f4335g = new ArrayList();
                d.this.f4337i = 0;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e implements h4.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4363a;

        public e(AccessibilityService accessibilityService) {
            this.f4363a = accessibilityService;
        }

        @Override // com.acse.ottn.h4.b
        public void a(AccessiblityModel accessiblityModel) {
            d.this.b(this.f4363a, accessiblityModel);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4365a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f4366b;

        public f(AccessibilityService accessibilityService, AccessiblityModel accessiblityModel) {
            this.f4365a = accessibilityService;
            this.f4366b = accessiblityModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            z1.a().b(this.f4365a);
            h0.d().a(this.f4365a);
            h0.d().b(this.f4365a, this.f4366b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4368a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f4369b;

        public g(AccessibilityService accessibilityService, AccessiblityModel accessiblityModel) {
            this.f4368a = accessibilityService;
            this.f4369b = accessiblityModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k0.f4670f) {
                if (d.this.f4340l != null) {
                    c2.a(d.B, "showFloatWindow stop floatIntent");
                    this.f4368a.stopService(d.this.f4340l);
                    d.this.f4340l = null;
                }
                d.this.f4340l = new Intent(this.f4368a, (Class<?>) CircleFlowService.class);
                d.this.f4340l.putExtra(bn.f10753i, this.f4369b);
                this.f4368a.startService(d.this.f4340l);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class h extends Handler {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f4372a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f4373b;

            public a(String str, String str2) {
                this.f4372a = str;
                this.f4373b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Message message = new Message();
                message.what = 10072;
                Bundle bundle = new Bundle();
                bundle.putString("coupon_packagename", this.f4372a);
                bundle.putString("genuine_packagename", this.f4373b);
                message.setData(bundle);
                d.this.f4349u.sendMessageDelayed(message, 0L);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PageSettingTypeModel f4375a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f4376b;

            public b(PageSettingTypeModel pageSettingTypeModel, String str) {
                this.f4375a = pageSettingTypeModel;
                this.f4376b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                dVar.b(dVar.f4338j);
                Message message = new Message();
                message.what = 10073;
                Bundle bundle = new Bundle();
                bundle.putString("coupon_packagename", this.f4375a.getPackage_name());
                bundle.putString("genuine_packagename", this.f4376b);
                message.setData(bundle);
                d.this.f4349u.sendMessageDelayed(message, 500L);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PageSettingTypeModel f4378a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f4379b;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            public class a implements Runnable {

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                /* renamed from: com.acse.ottn.d$h$c$a$a, reason: collision with other inner class name */
                public class C0074a implements s0.a {

                    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                    /* renamed from: com.acse.ottn.d$h$c$a$a$a, reason: collision with other inner class name */
                    public class RunnableC0075a implements Runnable {
                        public RunnableC0075a() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Message message = new Message();
                            message.what = 10072;
                            Bundle bundle = new Bundle();
                            bundle.putString("coupon_packagename", c.this.f4378a.getPackage_name());
                            bundle.putString("genuine_packagename", c.this.f4379b);
                            message.setData(bundle);
                            d.this.f4349u.sendMessageDelayed(message, 0L);
                        }
                    }

                    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                    /* renamed from: com.acse.ottn.d$h$c$a$a$b */
                    public class b implements Runnable {

                        /* renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ AccessibilityNodeInfo f4384a;

                        /* renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ int f4385b;

                        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                        /* renamed from: com.acse.ottn.d$h$c$a$a$b$a, reason: collision with other inner class name */
                        public class RunnableC0076a implements Runnable {
                            public RunnableC0076a() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Message message = new Message();
                                message.what = 10072;
                                Bundle bundle = new Bundle();
                                bundle.putString("coupon_packagename", c.this.f4378a.getPackage_name());
                                bundle.putString("genuine_packagename", c.this.f4379b);
                                message.setData(bundle);
                                d.this.f4349u.sendMessageDelayed(message, 0L);
                            }
                        }

                        public b(AccessibilityNodeInfo accessibilityNodeInfo, int i6) {
                            this.f4384a = accessibilityNodeInfo;
                            this.f4385b = i6;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            w2.d().b(this.f4384a, this.f4385b);
                            new Handler().postDelayed(new RunnableC0076a(), 200L);
                        }
                    }

                    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                    /* renamed from: com.acse.ottn.d$h$c$a$a$c, reason: collision with other inner class name */
                    public class RunnableC0077c implements Runnable {
                        public RunnableC0077c() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Message message = new Message();
                            message.what = 10072;
                            Bundle bundle = new Bundle();
                            bundle.putString("coupon_packagename", c.this.f4378a.getPackage_name());
                            bundle.putString("genuine_packagename", c.this.f4379b);
                            message.setData(bundle);
                            d.this.f4349u.sendMessageDelayed(message, 0L);
                        }
                    }

                    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                    /* renamed from: com.acse.ottn.d$h$c$a$a$d, reason: collision with other inner class name */
                    public class RunnableC0078d implements Runnable {
                        public RunnableC0078d() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Message message = new Message();
                            message.what = 10072;
                            Bundle bundle = new Bundle();
                            bundle.putString("coupon_packagename", c.this.f4378a.getPackage_name());
                            bundle.putString("genuine_packagename", c.this.f4379b);
                            message.setData(bundle);
                            d.this.f4349u.sendMessageDelayed(message, 0L);
                        }
                    }

                    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                    /* renamed from: com.acse.ottn.d$h$c$a$a$e */
                    public class e implements Runnable {
                        public e() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Message message = new Message();
                            message.what = 10072;
                            Bundle bundle = new Bundle();
                            bundle.putString("coupon_packagename", c.this.f4378a.getPackage_name());
                            bundle.putString("genuine_packagename", c.this.f4379b);
                            message.setData(bundle);
                            d.this.f4349u.sendMessageDelayed(message, 0L);
                        }
                    }

                    public C0074a() {
                    }

                    @Override // com.acse.ottn.s0.a
                    public void a(String str, int i6, String str2, String str3) {
                        if (str.equals("0")) {
                            w2.d().a(d.this.f4338j.getRootInActiveWindow(), i6);
                            new Handler().postDelayed(new RunnableC0075a(), 200L);
                            return;
                        }
                        if (str.equals("1")) {
                            AccessibilityNodeInfo j6 = com.acse.ottn.b.c().j(d.this.f4338j, str2);
                            if (j6 == null) {
                                return;
                            }
                            w2.d().a(d.this.f4338j);
                            new Handler().postDelayed(new b(j6, i6), 100L);
                            return;
                        }
                        if (str.equals("2")) {
                            w2.d().a(d.this.f4338j);
                            w2.d().a();
                            new Handler().postDelayed(new RunnableC0077c(), 200L);
                            return;
                        }
                        if (str.equals("3")) {
                            AccessibilityNodeInfo j7 = com.acse.ottn.b.c().j(d.this.f4338j, str2);
                            AccessibilityNodeInfo j8 = com.acse.ottn.b.c().j(d.this.f4338j, str3);
                            if (j7 == null || j8 == null) {
                                return;
                            }
                            w2.d().a(d.this.f4338j);
                            w2.d().a(d.this.f4338j.getRootInActiveWindow(), i6);
                            new Handler().postDelayed(new RunnableC0078d(), 200L);
                            return;
                        }
                        if (str.equals("4")) {
                            if (s0.a().a(d.this.f4336h, str2, str3)) {
                                w2.d().a(d.this.f4338j);
                                w2.d().a();
                                new Handler().postDelayed(new e(), 200L);
                                return;
                            }
                            return;
                        }
                        if (str.equals("5")) {
                            Message message = new Message();
                            message.what = 10073;
                            Bundle bundle = new Bundle();
                            bundle.putString("coupon_packagename", c.this.f4378a.getPackage_name());
                            bundle.putString("genuine_packagename", c.this.f4379b);
                            message.setData(bundle);
                            d.this.f4349u.sendMessageDelayed(message, 0L);
                        }
                    }
                }

                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    List<String> list = d.this.f4336h;
                    if (list != null) {
                        c2.a("samon-->", list.toString());
                    }
                    s0 a6 = s0.a();
                    c cVar = c.this;
                    a6.a(d.this.f4336h, cVar.f4378a.getContainsTextList(), new C0074a());
                }
            }

            public c(PageSettingTypeModel pageSettingTypeModel, String str) {
                this.f4378a = pageSettingTypeModel;
                this.f4379b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                dVar.b(dVar.f4338j);
                new Handler().postDelayed(new a(), 100L);
            }
        }

        public h(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            String str = "com.alipay.mobile.nebulax.xriver.activity.XRiverActivity";
            super.handleMessage(message);
            d.this.f4339k = true;
            try {
                if (message.what == d.this.f4331c) {
                    k0.f4669e = true;
                    String string = message.getData().getString("coupon_packagename");
                    String string2 = message.getData().getString("genuine_packagename");
                    if (!n.c().H.equals(string)) {
                        d.this.a((List<String>) null, string, string2, "");
                        return;
                    }
                    d dVar = d.this;
                    dVar.f4350v = null;
                    dVar.b(dVar.f4338j, "/");
                    w2.d().a(d.this.f4338j);
                    if (d.this.f4350v != null) {
                        w2.d().b(d.this.f4350v, 0);
                        new Handler().postDelayed(new a(string, string2), 500L);
                        return;
                    }
                    return;
                }
                if (message.what != d.this.f4332d) {
                    if (message.what == d.this.f4330b) {
                        c2.c(d.B, "开始获取页面信息");
                        String string3 = message.getData().getString("coupon_packagename");
                        String string4 = message.getData().getString("genuine_packagename");
                        k0.f4671g = true;
                        k0.f4669e = true;
                        d.this.b(string3, string4);
                        return;
                    }
                    int i6 = message.what;
                    if (i6 == 10072) {
                        k0.f4669e = true;
                        if (TextUtils.isEmpty(d.d().f4342n)) {
                            return;
                        }
                        String string5 = message.getData().getString("coupon_packagename");
                        String string6 = message.getData().getString("genuine_packagename");
                        d dVar2 = d.this;
                        dVar2.a(dVar2.f4336h, string5, string6, "");
                        return;
                    }
                    if (i6 == 10073) {
                        k0.f4669e = true;
                        String string7 = message.getData().getString("coupon_packagename");
                        String string8 = message.getData().getString("genuine_packagename");
                        d dVar3 = d.this;
                        dVar3.a(dVar3.f4336h, string7, string8, "");
                        return;
                    }
                    if (i6 == 10017) {
                        k0.f4669e = true;
                        if (n.c().f4866t.equals(message.getData().getString("coupon_packagename")) && "1".equals(j3.a().e("ocr_screen_state"))) {
                            d.this.c();
                            return;
                        }
                        return;
                    }
                    return;
                }
                c2.a(d.B, "当前状态 =adRequestCode");
                String string9 = message.getData().getString("coupon_packagename");
                String string10 = message.getData().getString("genuine_packagename");
                if (string9.contains("com.tencent.mm.plugin.appbrand.ui.AppBrandUI")) {
                    d.this.f4344p = true;
                    str = "com.tencent.mm.plugin.appbrand.ui.AppBrandUI";
                } else if (!string9.contains("com.alipay.mobile.nebulax.xriver.activity.XRiverActivity")) {
                    str = string9;
                }
                c2.a(d.B, "当前状态samon =activityName=" + str + "  genuinePackagename=" + string10);
                PageSettingTypeModel d6 = s0.a().d(str);
                if (d6 == null) {
                    c2.a(d.B, "model 当前状态 is null");
                    return;
                }
                k0.f4669e = true;
                c2.a(d.B, "model 当前状态 =" + d6.toString());
                if (d6.getRead_type().equals("0")) {
                    d.this.a((List<String>) null, d6.getPackage_name(), string10, "");
                    return;
                }
                if (d6.getRead_type().equals("1")) {
                    if (d.this.b(str) && d.this.e(string10)) {
                        d.d().f(d.this.f4338j);
                        k0.f4671g = true;
                        d.this.a(d6, string10);
                        return;
                    }
                    return;
                }
                if (d6.getRead_type().equals("2")) {
                    new Handler().postDelayed(new b(d6, string10), d6.getRead_time());
                } else if (d6.getRead_type().equals("999")) {
                    w2.d().a(d.this.f4338j);
                    new Handler().postDelayed(new c(d6, string10), d6.getRead_time());
                }
            } catch (Throwable th) {
                c2.a(d.B, "mHandler =" + th.getMessage());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!j3.a().a("battery_white_accessiblity")) {
                c2.a(d.B, "没有打开");
                l2.b().a("system_open_accessiblity");
                return;
            }
            c2.a(d.B, "开始发送 user_open_accessiblity");
            l2.b().a("user_open_accessiblity");
            if (j3.a() != null) {
                j3.a().a("battery_white_accessiblity", Boolean.FALSE);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class j implements m0.d {
        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
        }

        public j() {
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            c2.a("samon-->", "设置时间2=" + (System.currentTimeMillis() / 1000));
            d.this.f4346r = false;
        }
    }

    public void f(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        c2.a(B, "initReadPageInfo=" + System.currentTimeMillis());
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.flags = 90;
        accessibilityServiceInfo.notificationTimeout = 100L;
        accessibilityServiceInfo.feedbackType = -1;
        accessibilityServiceInfo.eventTypes = -1;
        accessibilityService.setServiceInfo(accessibilityServiceInfo);
    }

    public final Object g() throws ObjectStreamException {
        return f4326x;
    }

    public final void h() {
        if (f4328z != null) {
            return;
        }
        if (r0.d().a().equals(j3.a() != null ? j3.a().e("appHeartbeat") : "")) {
            return;
        }
        f4328z = m0.a().b(20000, 10000, new a());
    }

    public static d d() {
        if (f4326x == null) {
            synchronized (d.class) {
                try {
                    if (f4326x == null) {
                        f4326x = new d();
                    }
                } finally {
                }
            }
        }
        return f4326x;
    }

    public final boolean e(String str) {
        if (!r0.d().a().equals(j3.a().e("samon_" + str))) {
            return true;
        }
        c2.a(B, "the day not requst packageName =" + str);
        return false;
    }

    public void g(AccessibilityService accessibilityService) {
        c2.a(B, "onStopService");
        Intent intent = this.f4340l;
        if (intent != null) {
            accessibilityService.stopService(intent);
            this.f4340l = null;
        }
    }

    public final void c(String str, String str2, int i6, int i7) {
        try {
            Message message = new Message();
            message.what = i6;
            Bundle bundle = new Bundle();
            bundle.putString("coupon_packagename", str);
            bundle.putString("genuine_packagename", str2);
            message.setData(bundle);
            this.f4349u.sendMessageDelayed(message, i7);
        } catch (Throwable th) {
            c2.a(B, "sendMessage =" + th.getMessage());
        }
    }

    public final boolean b(String str, int i6) {
        if (i6 == 0) {
            i6 = 500;
        }
        long d6 = j3.a().d("coupon_" + str);
        c2.a(B, "controlCouponShow appPageName =" + str + "-----" + (System.currentTimeMillis() - d6));
        if (System.currentTimeMillis() - d6 < i6) {
            c2.a(B, "controlCouponShow return false ");
            return false;
        }
        j3.a().a("coupon_" + str, System.currentTimeMillis());
        c2.a(B, "controlCouponShow return true");
        return true;
    }

    public void e(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        c2.a(B, "initOpenPermission=" + System.currentTimeMillis());
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.flags = 80;
        accessibilityServiceInfo.notificationTimeout = 100L;
        accessibilityServiceInfo.feedbackType = -1;
        accessibilityServiceInfo.eventTypes = -1;
        accessibilityService.setServiceInfo(accessibilityServiceInfo);
    }

    public void d(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        c2.a(B, "initDemoPermission =" + System.currentTimeMillis());
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.flags = 88;
        accessibilityServiceInfo.notificationTimeout = 300L;
        accessibilityServiceInfo.feedbackType = -1;
        accessibilityServiceInfo.eventTypes = -1;
        accessibilityService.setServiceInfo(accessibilityServiceInfo);
    }

    public final void f() {
        m0.a().b(3000, 1000, new j());
    }

    public void h(AccessibilityService accessibilityService) {
        w2.d().a(accessibilityService);
        this.f4338j = accessibilityService;
    }

    public final boolean b(String str) {
        return b(str, 0);
    }

    public void b(String str, String str2, int i6, int i7) {
        c2.a(B, "onSelectActivity");
        this.f4333e = str2;
        this.f4334f = str;
        c(str, str2, i6, i7);
    }

    public final void c() {
        AccessibilityNodeInfo h6;
        String[] f6 = j3.a().f("key_content");
        if (f6 == null) {
            f6 = new String[]{"送礼", "立即领取", "人已买", "回头客", "人感兴趣", "可再享:", "直降", "跨境进口", "跨境直邮", "淘金币已抵", "天价保", "官方立减", "活动价便宜", "大促价保", "全网低价"};
        }
        String[] f7 = j3.a().f("find_type");
        if (f7 == null) {
            f7 = new String[]{"3", "3", "1", "1", "1", "3", "1", "1", "1", "1", "1", "1", "1", "3", "3"};
        }
        String[] f8 = j3.a().f("location_type");
        if (f8 == null) {
            f8 = new String[]{"1", "3", "5", "5", "5", "2", "4", "5", "5", "4", "5", "4", "5", "5", "5"};
        }
        for (int i6 = 0; i6 < f6.length; i6++) {
            if (f7[i6].equals("3")) {
                h6 = com.acse.ottn.b.c().j(this.f4338j, f6[i6].trim());
            } else {
                h6 = f7[i6].equals("1") ? com.acse.ottn.b.c().h(this.f4338j, f6[i6].trim()) : null;
            }
            if (h6 != null) {
                c2.a("samon,", "当前字段==》" + f6[i6]);
                w2.d().a(h6, f8[i6]);
                return;
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:466:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x011c A[Catch: all -> 0x0099, TryCatch #0 {all -> 0x0099, blocks: (B:21:0x0069, B:24:0x0090, B:25:0x0129, B:28:0x0135, B:30:0x013d, B:32:0x014b, B:33:0x0182, B:37:0x01c1, B:38:0x01c8, B:43:0x04bc, B:46:0x0b14, B:48:0x0b1a, B:52:0x04c8, B:55:0x04d4, B:57:0x04e2, B:61:0x04fb, B:63:0x0514, B:64:0x052f, B:65:0x0536, B:67:0x0540, B:68:0x054e, B:70:0x0559, B:71:0x055f, B:72:0x056a, B:74:0x0570, B:76:0x0578, B:77:0x0591, B:79:0x0597, B:81:0x059f, B:82:0x05b8, B:84:0x05be, B:86:0x05c6, B:87:0x05de, B:89:0x05e4, B:91:0x05ec, B:92:0x0604, B:94:0x060a, B:96:0x0612, B:97:0x062b, B:99:0x0631, B:101:0x0639, B:102:0x0651, B:104:0x0657, B:106:0x065f, B:107:0x0678, B:109:0x067e, B:111:0x0686, B:112:0x069f, B:114:0x06a5, B:116:0x06ad, B:117:0x06c5, B:119:0x06cb, B:121:0x06d3, B:122:0x06eb, B:124:0x06f1, B:126:0x06f9, B:127:0x070b, B:129:0x0711, B:131:0x0719, B:132:0x0731, B:134:0x0737, B:136:0x073f, B:137:0x0757, B:139:0x075d, B:141:0x0765, B:143:0x0771, B:146:0x079c, B:147:0x07a1, B:149:0x07a7, B:151:0x07af, B:152:0x07c7, B:154:0x07cd, B:156:0x07d5, B:157:0x07ed, B:159:0x07f9, B:161:0x07ff, B:163:0x0807, B:164:0x081d, B:166:0x0823, B:168:0x082b, B:169:0x0844, B:171:0x084a, B:173:0x0852, B:174:0x0868, B:176:0x086e, B:178:0x0876, B:179:0x0887, B:181:0x088d, B:183:0x0895, B:184:0x08ad, B:186:0x08b3, B:188:0x08bb, B:189:0x08d3, B:191:0x08d9, B:193:0x08e1, B:194:0x08f9, B:196:0x08ff, B:198:0x0907, B:199:0x0928, B:201:0x092e, B:203:0x0936, B:204:0x094f, B:206:0x0955, B:208:0x095d, B:209:0x0975, B:211:0x097b, B:213:0x0983, B:214:0x099b, B:216:0x09a1, B:218:0x09a9, B:219:0x09c1, B:221:0x09c7, B:223:0x09cf, B:224:0x09e8, B:226:0x09ee, B:228:0x09f6, B:229:0x0a0e, B:231:0x0a14, B:233:0x0a1c, B:234:0x0a34, B:236:0x0a51, B:238:0x0a59, B:239:0x0a74, B:241:0x0a7a, B:243:0x0a82, B:246:0x0aad, B:248:0x0ab1, B:250:0x0ae0, B:252:0x0ae8, B:255:0x0b08, B:257:0x0b0c, B:258:0x01cd, B:261:0x01d9, B:264:0x01e4, B:267:0x01f0, B:270:0x01fc, B:273:0x0208, B:276:0x0214, B:279:0x021f, B:282:0x022b, B:285:0x0237, B:288:0x0243, B:291:0x024f, B:294:0x025b, B:297:0x0267, B:300:0x0273, B:303:0x027f, B:306:0x028a, B:309:0x0296, B:312:0x02a2, B:315:0x02ae, B:318:0x02ba, B:321:0x02c6, B:324:0x02d2, B:327:0x02de, B:330:0x02ea, B:333:0x02f6, B:336:0x0302, B:339:0x030e, B:342:0x0319, B:345:0x0325, B:348:0x0331, B:351:0x033d, B:354:0x0349, B:357:0x0355, B:360:0x0361, B:363:0x036d, B:366:0x0379, B:369:0x0385, B:372:0x0390, B:375:0x039c, B:378:0x03a8, B:381:0x03b4, B:384:0x03c0, B:387:0x03cc, B:390:0x03d8, B:393:0x03e4, B:396:0x03f0, B:399:0x03fc, B:402:0x0407, B:405:0x0412, B:408:0x041e, B:411:0x042a, B:414:0x0436, B:417:0x0442, B:420:0x044e, B:423:0x0458, B:426:0x0463, B:429:0x046e, B:432:0x0479, B:435:0x0484, B:438:0x048f, B:441:0x049a, B:444:0x04a5, B:447:0x0168, B:448:0x0170, B:450:0x0178, B:452:0x0180, B:453:0x009c, B:455:0x00a8, B:457:0x00b4, B:459:0x00c0, B:461:0x00c8, B:463:0x00dd, B:464:0x0103, B:468:0x011c, B:470:0x0122, B:471:0x00e0, B:473:0x00ea), top: B:20:0x0069 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.accessibilityservice.AccessibilityService r14, android.view.accessibility.AccessibilityEvent r15) {
        /*
            Method dump skipped, instructions count: 3244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.d.a(android.accessibilityservice.AccessibilityService, android.view.accessibility.AccessibilityEvent):void");
    }

    public void e() {
        this.f4351w = new ArrayList();
        try {
            a(this.f4338j.getRootInActiveWindow());
        } catch (Throwable th) {
            c2.a(B, th.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0075, code lost:
    
        if (r0 == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.accessibilityservice.AccessibilityService r9, com.acse.ottn.model.AccessiblityModel r10) {
        /*
            Method dump skipped, instructions count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.d.b(android.accessibilityservice.AccessibilityService, com.acse.ottn.model.AccessiblityModel):void");
    }

    public final void d(String str) {
        Message message = new Message();
        message.what = 10017;
        Bundle bundle = new Bundle();
        bundle.putString("coupon_packagename", str);
        message.setData(bundle);
        this.f4349u.sendMessageDelayed(message, 200L);
    }

    public final String c(AccessibilityService accessibilityService) {
        String e6 = j3.a().e("jd_view_id");
        if (TextUtils.isEmpty(e6)) {
            return "";
        }
        c2.a(B, "getJDtitle jd id is " + e6);
        AccessibilityNodeInfo f6 = com.acse.ottn.b.c().f(accessibilityService, e6);
        if (f6 != null && !TextUtils.isEmpty(f6.getText())) {
            c2.a(B, "nodeInfo.getText()!=null ");
            String trim = f6.getText().toString().trim();
            if (trim.length() > 10) {
                if (b("click_jd_title", 1000)) {
                    com.acse.ottn.b.c().g(f6);
                }
                AccessibilityNodeInfo f7 = com.acse.ottn.b.c().f(accessibilityService, e6);
                if (f7 != null && f7.getText() != null) {
                    String trim2 = f7.getText().toString().trim();
                    if (trim.contains(trim2) || trim2.contains(trim)) {
                        return trim.length() > trim2.length() ? trim : trim2;
                    }
                    c2.a(B, "getJDtitle jd id is error=" + e6);
                    j3.a().b("jd_view_id", "");
                }
            }
        }
        return "";
    }

    public final boolean c(String str) {
        str.getClass();
        switch (str) {
            case "com.miui.home.launcher.Launcher":
            case "com.bbk.launcher2.Launcher":
            case "com.huawei.android.launcher.unihome.UniHomeLauncher":
            case "com.android.launcher.Launcher":
            case "com.hihonor.android.launcher.unihome.UniHomeLauncher":
                return true;
            default:
                return false;
        }
    }

    public final void b(String str, String str2) {
        AdPackageModel b6 = s0.a().b();
        c2.a(B, "AdPackageModel.toString() =" + b6.toString());
        PageSettingTypeModel pageSettingTypeModel = new PageSettingTypeModel();
        pageSettingTypeModel.setPackage_name(str);
        pageSettingTypeModel.setIs_click_jd_title(b6.getIs_click_jd_title());
        pageSettingTypeModel.setRead_time(b6.getReadpage_time());
        pageSettingTypeModel.setRead_description(b6.getRead_description());
        if (n.c().f4866t.equals(str)) {
            pageSettingTypeModel.setRead_length(b6.getTb_readpage_size());
            pageSettingTypeModel.setRead_type(b6.getTb_readpage_type());
        } else if (n.c().f4869w.equals(str)) {
            pageSettingTypeModel.setRead_type(b6.getJd_readpage_type());
            pageSettingTypeModel.setRead_length(b6.getJd_readpage_size());
        } else if (n.c().f4867u.equals(str)) {
            pageSettingTypeModel.setRead_length(b6.getTb_readpage_size());
            pageSettingTypeModel.setRead_type(b6.getTb_readpage_type());
        }
        a(pageSettingTypeModel, str2);
    }

    @SuppressLint({"NewApi"})
    public final void b(AccessibilityService accessibilityService, String str) {
        try {
            b(accessibilityService.getRootInActiveWindow(), str);
        } catch (Throwable unused) {
        }
    }

    public void b(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() == 0) {
            if (!TextUtils.isEmpty(accessibilityNodeInfo.getText())) {
                a(accessibilityNodeInfo, str);
                return;
            } else {
                if (TextUtils.isEmpty(accessibilityNodeInfo.getContentDescription())) {
                    return;
                }
                a(accessibilityNodeInfo, str);
                return;
            }
        }
        if (accessibilityNodeInfo != null) {
            for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
                try {
                    if (accessibilityNodeInfo.getChild(i6) != null) {
                        b(accessibilityNodeInfo.getChild(i6), str);
                    }
                } catch (Throwable th) {
                    c2.a(B, th.getMessage());
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void b(AccessibilityService accessibilityService) {
        List<String> list = this.f4336h;
        if (list != null) {
            list.removeAll(list);
            this.f4336h = null;
        }
        try {
            this.f4336h = new ArrayList();
            b(accessibilityService.getRootInActiveWindow());
        } catch (Throwable th) {
            List<String> list2 = this.f4336h;
            if (list2 != null) {
                list2.removeAll(list2);
                this.f4336h.clear();
                c2.a(B, th.getMessage());
            }
        }
    }

    public void b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            c2.a("samon-->aa", accessibilityNodeInfo.toString());
        }
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() == 0) {
            if (!TextUtils.isEmpty(accessibilityNodeInfo.getText())) {
                this.f4336h.add(accessibilityNodeInfo.getText().toString().trim());
                return;
            } else {
                if (TextUtils.isEmpty(accessibilityNodeInfo.getContentDescription())) {
                    return;
                }
                this.f4336h.add(accessibilityNodeInfo.getContentDescription().toString());
                return;
            }
        }
        if (accessibilityNodeInfo != null) {
            for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
                try {
                    if (accessibilityNodeInfo.getChild(i6) != null) {
                        b(accessibilityNodeInfo.getChild(i6));
                    }
                } catch (Throwable th) {
                    c2.a(B, th.getMessage());
                }
            }
        }
    }

    public final void b(AccessiblityModel accessiblityModel, String str) {
        if ("1".equals(accessiblityModel.getToast_status())) {
            j3.a().b("samon_" + accessiblityModel.getGenuine_packagename(), r0.d().a());
        } else if ("0".equals(accessiblityModel.getToast_status())) {
            j3.a().b("samon_" + str, r0.d().a());
        }
        if (!TextUtils.isEmpty(accessiblityModel.getData().getFirst_price())) {
            j3.a().b("ocr_screen_state", accessiblityModel.getData().getFirst_price());
        }
        if (!TextUtils.isEmpty(accessiblityModel.getData().getKey_content())) {
            j3.a().b("key_content", accessiblityModel.getData().getKey_content());
        }
        if (!TextUtils.isEmpty(accessiblityModel.getData().getFind_type())) {
            j3.a().b("find_type", accessiblityModel.getData().getFind_type());
        }
        if (!TextUtils.isEmpty(accessiblityModel.getData().getLocation_type())) {
            j3.a().b("location_type", accessiblityModel.getData().getLocation_type());
        }
        if (AcseHelpManager.mIsDebug) {
            j3.a().b("ocr_screen_state", "1");
        }
        if ("1".equals(accessiblityModel.getReset_heartbeat())) {
            j3.a().b("appHeartbeat", "");
        }
        l4.a().b(5, "倒计时", " model.getIs_l()=" + accessiblityModel.getIs_l());
        if (accessiblityModel.getIs_l() == 0) {
            b2.a().c();
        }
        if (accessiblityModel.getIs_xp() == 0) {
            y4.d();
        }
        if ("1".equals(accessiblityModel.getReset_tag())) {
            m1.c().e();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0169 A[Catch: all -> 0x0069, TryCatch #0 {all -> 0x0069, blocks: (B:5:0x0019, B:10:0x003c, B:12:0x0064, B:16:0x006c, B:18:0x0074, B:69:0x0081, B:71:0x0087, B:73:0x008d, B:28:0x010f, B:30:0x0169, B:31:0x0173, B:34:0x017a, B:36:0x0196, B:38:0x019d, B:40:0x01b0, B:42:0x01b7, B:44:0x01bf, B:46:0x01c6, B:48:0x01ca, B:49:0x01e5, B:51:0x0209, B:52:0x0263, B:54:0x0218, B:21:0x00b5, B:23:0x00bb, B:25:0x00dd, B:27:0x00e9, B:61:0x00f0, B:63:0x00f6, B:65:0x0102, B:66:0x0109, B:59:0x0269), top: B:4:0x0019, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x017a A[Catch: all -> 0x0069, TRY_ENTER, TryCatch #0 {all -> 0x0069, blocks: (B:5:0x0019, B:10:0x003c, B:12:0x0064, B:16:0x006c, B:18:0x0074, B:69:0x0081, B:71:0x0087, B:73:0x008d, B:28:0x010f, B:30:0x0169, B:31:0x0173, B:34:0x017a, B:36:0x0196, B:38:0x019d, B:40:0x01b0, B:42:0x01b7, B:44:0x01bf, B:46:0x01c6, B:48:0x01ca, B:49:0x01e5, B:51:0x0209, B:52:0x0263, B:54:0x0218, B:21:0x00b5, B:23:0x00bb, B:25:0x00dd, B:27:0x00e9, B:61:0x00f0, B:63:0x00f6, B:65:0x0102, B:66:0x0109, B:59:0x0269), top: B:4:0x0019, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0196 A[Catch: all -> 0x0069, TryCatch #0 {all -> 0x0069, blocks: (B:5:0x0019, B:10:0x003c, B:12:0x0064, B:16:0x006c, B:18:0x0074, B:69:0x0081, B:71:0x0087, B:73:0x008d, B:28:0x010f, B:30:0x0169, B:31:0x0173, B:34:0x017a, B:36:0x0196, B:38:0x019d, B:40:0x01b0, B:42:0x01b7, B:44:0x01bf, B:46:0x01c6, B:48:0x01ca, B:49:0x01e5, B:51:0x0209, B:52:0x0263, B:54:0x0218, B:21:0x00b5, B:23:0x00bb, B:25:0x00dd, B:27:0x00e9, B:61:0x00f0, B:63:0x00f6, B:65:0x0102, B:66:0x0109, B:59:0x0269), top: B:4:0x0019, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x019d A[Catch: all -> 0x0069, TryCatch #0 {all -> 0x0069, blocks: (B:5:0x0019, B:10:0x003c, B:12:0x0064, B:16:0x006c, B:18:0x0074, B:69:0x0081, B:71:0x0087, B:73:0x008d, B:28:0x010f, B:30:0x0169, B:31:0x0173, B:34:0x017a, B:36:0x0196, B:38:0x019d, B:40:0x01b0, B:42:0x01b7, B:44:0x01bf, B:46:0x01c6, B:48:0x01ca, B:49:0x01e5, B:51:0x0209, B:52:0x0263, B:54:0x0218, B:21:0x00b5, B:23:0x00bb, B:25:0x00dd, B:27:0x00e9, B:61:0x00f0, B:63:0x00f6, B:65:0x0102, B:66:0x0109, B:59:0x0269), top: B:4:0x0019, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0172  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.accessibilityservice.AccessibilityService r10, android.view.accessibility.AccessibilityEvent r11) {
        /*
            Method dump skipped, instructions count: 651
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.d.b(android.accessibilityservice.AccessibilityService, android.view.accessibility.AccessibilityEvent):void");
    }

    public final boolean a(String str, int i6) {
        return b(str, i6);
    }

    public void a(String str, String str2, int i6, int i7) {
        c2.a(B, "onAdCallBack");
        this.f4333e = str2;
        if (this.f4339k) {
            this.f4339k = false;
            this.f4334f = "";
            c(str, str2, i6, i7);
        }
    }

    public void a(String str, String str2) {
        c2.a(B, "onNoSelectActivity");
        if (str.toLowerCase().contains("android.widget")) {
            return;
        }
        this.f4333e = str2;
        this.f4334f = "";
    }

    @SuppressLint({"NewApi"})
    public final void a(AccessibilityService accessibilityService, PageSettingTypeModel pageSettingTypeModel) {
        List<String> list = this.f4335g;
        if (list != null) {
            list.removeAll(list);
            this.f4335g = null;
        }
        try {
            this.f4335g = new ArrayList();
            this.f4337i = 0;
            a(accessibilityService.getRootInActiveWindow(), pageSettingTypeModel);
        } catch (Throwable th) {
            List<String> list2 = this.f4335g;
            if (list2 != null) {
                list2.removeAll(list2);
                this.f4335g.clear();
                this.f4337i = 0;
                c2.a(B, th.getMessage());
            }
        }
    }

    public void a(AccessibilityNodeInfo accessibilityNodeInfo, PageSettingTypeModel pageSettingTypeModel) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
                    try {
                        if (accessibilityNodeInfo.getChild(i6) != null) {
                            a(accessibilityNodeInfo.getChild(i6), pageSettingTypeModel);
                        }
                    } catch (Throwable th) {
                        c2.a(B, th.getMessage());
                    }
                }
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(accessibilityNodeInfo.getText())) {
            String trim = accessibilityNodeInfo.getText().toString().trim();
            this.f4337i = s0.a().a(trim, this.f4337i);
            if (s0.a().a(this.f4337i) && this.f4335g.size() < 300) {
                c2.c("samon-->12", "getText = " + trim);
                this.f4335g.add(trim);
                return;
            }
            List<String> list = this.f4335g;
            if (list != null) {
                list.removeAll(list);
                this.f4335g.clear();
                this.f4337i = 0;
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(accessibilityNodeInfo.getContentDescription())) {
            return;
        }
        String charSequence = accessibilityNodeInfo.getContentDescription().toString();
        if ("1".equals(pageSettingTypeModel.getRead_description())) {
            this.f4337i = s0.a().a(charSequence, this.f4337i);
            if (s0.a().a(this.f4337i) && this.f4335g.size() < 300) {
                this.f4335g.add(charSequence);
                c2.c("samon-->12", "getContentDescription = " + charSequence);
                return;
            }
            List<String> list2 = this.f4335g;
            if (list2 != null) {
                list2.removeAll(list2);
                this.f4335g.clear();
                this.f4337i = 0;
                return;
            }
            return;
        }
        if (charSequence.contains("月销") || charSequence.contains("已售") || charSequence.matches("[1-9]\\d*\\.?\\d*") || charSequence.contains("￥") || charSequence.contains("¥")) {
            this.f4337i = s0.a().a(charSequence, this.f4337i);
            if (!TextUtils.isEmpty(charSequence) && s0.a().a(this.f4337i) && this.f4335g.size() < 300) {
                this.f4335g.add(charSequence);
                return;
            }
            List<String> list3 = this.f4335g;
            if (list3 != null) {
                list3.removeAll(list3);
                this.f4335g.clear();
                this.f4337i = 0;
            }
        }
    }

    public final void a(PageSettingTypeModel pageSettingTypeModel, String str) {
        TimerTask timerTask = f4327y;
        if (timerTask != null) {
            timerTask.cancel();
            f4327y = null;
        }
        w2.d().b();
        this.f4341m = false;
        List<String> list = this.f4335g;
        if (list != null) {
            list.removeAll(list);
            this.f4335g.clear();
        }
        this.f4337i = 0;
        this.f4335g = new ArrayList();
        f4327y = m0.a().b(pageSettingTypeModel.getRead_time(), 400, new c(pageSettingTypeModel, str));
    }

    public final void a(PageSettingTypeModel pageSettingTypeModel) {
        TimerTask timerTask = f4327y;
        if (timerTask != null) {
            timerTask.cancel();
            f4327y = null;
        }
        if (a(SocializeConstants.TIME, 1500)) {
            if (pageSettingTypeModel.getPackage_name().equals(n.c().f4869w) && pageSettingTypeModel.getIs_click_jd_title().equals("0")) {
                String c6 = c(this.f4338j);
                this.f4348t = c6;
                if (!TextUtils.isEmpty(c6)) {
                    this.f4335g.add(this.f4348t);
                }
            }
            k0.f4671g = false;
            List<String> list = this.f4335g;
            if (list == null || list.size() != 0) {
                a(this.f4335g, pageSettingTypeModel.getPackage_name(), this.f4333e, this.f4348t);
            }
        }
    }

    public final void a(List<String> list, String str, String str2, String str3) {
        if (this.f4346r) {
            c2.a("samon-->", "设置时间3=" + (System.currentTimeMillis() / 1000));
            f();
            return;
        }
        m1.c().a(list, str, str2, str3, new C0073d(str));
    }

    public void a(AccessibilityService accessibilityService, AccessiblityModel accessiblityModel) {
        h4.c().a(accessibilityService, accessiblityModel, this.f4333e, new e(accessibilityService));
    }

    public void a(AccessibilityService accessibilityService) {
        g2 g2Var = new g2(accessibilityService);
        A = g2Var;
        g2Var.a();
        try {
            if (j3.a() == null) {
                return;
            }
            if (TextUtils.isEmpty(j3.a().e("sessionID"))) {
                accessibilityService.startService(new Intent(accessibilityService, (Class<?>) ExcessiveService.class));
            }
            new Handler().postDelayed(new i(), 3000L);
            if (!j3.a().a("battery_white_accessiblity")) {
                c2.a(B, "没有打开");
                return;
            }
            com.acse.ottn.b.c().e(accessibilityService);
            com.acse.ottn.b.c().a(100L);
            com.acse.ottn.b.c().e(accessibilityService);
            com.acse.ottn.b.c().a(400L);
            AccessibilityNodeInfo j6 = com.acse.ottn.b.c().j(accessibilityService, "已下载的应用");
            AccessibilityNodeInfo j7 = com.acse.ottn.b.c().j(accessibilityService, "已安装的服务");
            AccessibilityNodeInfo j8 = com.acse.ottn.b.c().j(accessibilityService, "已下载的服务");
            AccessibilityNodeInfo j9 = com.acse.ottn.b.c().j(accessibilityService, "已安装的应用程序");
            if (j6 == null && j7 == null && j8 == null && j9 == null) {
                c2.a(B, "都没有找到");
                return;
            }
            com.acse.ottn.b.c().a(100L);
            com.acse.ottn.b.c().e(accessibilityService);
            c2.a(B, "找到");
        } catch (Throwable unused) {
        }
    }

    public void a(AccessibilityService accessibilityService, String str) {
        if (str.length() < 10) {
            return;
        }
        c2.a(B, "getJDTitleId = " + str);
        try {
            AccessibilityNodeInfo a6 = com.acse.ottn.b.c().a(accessibilityService, str, true);
            if (a6 != null) {
                String viewIdResourceName = a6.getViewIdResourceName();
                c2.a(B, "getJDTitleId jd id is " + viewIdResourceName);
                if (TextUtils.isEmpty(viewIdResourceName)) {
                    return;
                }
                j3.a().b("jd_view_id", viewIdResourceName);
                return;
            }
            c2.a(B, "nodeInfo = null");
        } catch (Throwable th) {
            c2.a(B, "getViewId Throwable e =" + th.getMessage());
        }
    }

    public void a(AccessiblityModel accessiblityModel, String str) {
        w2.d().b();
        if (1 == accessiblityModel.getR()) {
            if (str.equals(n.c().f4858l)) {
                accessiblityModel.getData().setPackage_name(n.c().f4858l);
            }
            b(accessiblityModel, str);
            a(this.f4338j, accessiblityModel);
            return;
        }
        if (accessiblityModel.getR() == 0) {
            if ("1".equals(accessiblityModel.getScrolled_screen())) {
                j3.a().b("scroll_state", accessiblityModel.getScrolled_screen());
                j3.a().b("goods_info", accessiblityModel.getProduct_info());
            }
            b(accessiblityModel, str);
            if (accessiblityModel.getData() != null && !TextUtils.isEmpty(accessiblityModel.getData().getSpop_describe())) {
                d().a(this.f4338j, accessiblityModel.getData().getSpop_describe());
            }
            if (AcseHelpManager.mIsDebug) {
                return;
            }
            j3.a().a("debug_state", Boolean.valueOf(accessiblityModel.getData().getDebug_state().equals("1")));
        }
    }

    public final void a(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getText() != null) {
            String trim = accessibilityNodeInfo.getText().toString().trim();
            if (trim.contains(str)) {
                if (trim.length() == 3 || trim.length() == 5) {
                    this.f4350v = accessibilityNodeInfo;
                }
            }
        }
    }

    public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
                    try {
                        if (accessibilityNodeInfo.getChild(i6) != null) {
                            a(accessibilityNodeInfo.getChild(i6));
                        }
                    } catch (Throwable th) {
                        c2.a(B, th.getMessage());
                    }
                }
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(accessibilityNodeInfo.getText())) {
            String trim = accessibilityNodeInfo.getText().toString().trim();
            if (trim.length() < 40) {
                this.f4351w.add(trim);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(accessibilityNodeInfo.getContentDescription())) {
            return;
        }
        String charSequence = accessibilityNodeInfo.getContentDescription().toString();
        if (charSequence.length() < 40) {
            this.f4351w.add(charSequence);
        }
    }

    @Override // com.acse.ottn.service.a.u0
    public void a() {
        h2.a().b(this.f4338j);
    }

    @Override // com.acse.ottn.service.a.u0
    public void a(String str) {
        m1.c().a(str, new b(str));
    }
}
