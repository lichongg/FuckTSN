package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.acse.ottn.activity.ExcessActivity;
import com.acse.ottn.activity.SeedingLoadingActivity;
import com.acse.ottn.m0;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.ExcessService;
import com.acse.ottn.service.WebViewService;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.TimerTask;
import xyz.adscope.amps.common.AMPSConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class h4 {

    /* renamed from: b, reason: collision with root package name */
    public static h4 f4621b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f4622c = "StartAppUtil";

    /* renamed from: a, reason: collision with root package name */
    public TimerTask f4623a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f4624a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4625b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f4626c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.acse.ottn.h4$a$a, reason: collision with other inner class name */
        public class RunnableC0080a implements Runnable {
            public RunnableC0080a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AccessiblityModel accessiblityModel = a.this.f4624a;
                if (accessiblityModel == null || accessiblityModel.getData() == null) {
                    return;
                }
                c2.a(h4.f4622c, "currenttime 2=" + System.currentTimeMillis());
                if (!k0.f4669e) {
                    c2.a(h4.f4622c, "isShowConpunInfor is false1");
                    return;
                }
                c2.a(h4.f4622c, "couponCountDown CommonUtil.isShowConpunInfor()111 =" + k0.f4669e);
                if (TextUtils.isEmpty(a.this.f4624a.getData().getDiscount())) {
                    j3.a().a("click_state", Boolean.TRUE);
                }
                c2.a(h4.f4622c, "couponCountDown couponModel.getRed_package() =" + a.this.f4624a.getRed_package());
                if (a.this.f4624a.getRed_package() != 1) {
                    a aVar = a.this;
                    b bVar = aVar.f4626c;
                    if (bVar != null) {
                        bVar.a(aVar.f4624a);
                        return;
                    }
                    return;
                }
                if (TextUtils.isEmpty(a.this.f4624a.getData().getPresent_price())) {
                    c2.a(h4.f4622c, "packageName is null");
                } else {
                    if ("0".equals(r1.a().a(a.this.f4624a.getData().getPresent_price()).getVersion())) {
                        c2.a(h4.f4622c, "current phone have not app");
                        return;
                    }
                    c2.a(h4.f4622c, "current phone have app");
                }
                if ("1".equals(a.this.f4624a.getData().getAuto_open_coupon())) {
                    h4 c6 = h4.c();
                    a aVar2 = a.this;
                    c6.b(aVar2.f4625b, aVar2.f4624a);
                    return;
                }
                if ("5".equals(a.this.f4624a.getData().getAuto_open_coupon())) {
                    n c7 = n.c();
                    a aVar3 = a.this;
                    c7.a(aVar3.f4625b, aVar3.f4624a.getData().getTkl_turn_url());
                    h4 c8 = h4.c();
                    a aVar4 = a.this;
                    c8.b(aVar4.f4625b, aVar4.f4624a);
                    return;
                }
                if ("3".equals(a.this.f4624a.getData().getAuto_open_coupon())) {
                    h4.c().b();
                    Intent intent = new Intent(a.this.f4625b, (Class<?>) ExcessService.class);
                    intent.putExtra("password", a.this.f4624a.getData().getTkl_turn_url());
                    intent.putExtra("deeplink", a.this.f4624a.getData().getSpop_deeplink());
                    intent.putExtra("link", a.this.f4624a.getData().getSpop_link());
                    intent.putExtra(CommonNetImpl.NAME, a.this.f4624a.getData().getPackage_name());
                    intent.putExtra("time", a.this.f4624a.getData().getCoupon_load_time());
                    intent.putExtra("origin_url", a.this.f4624a.getData().getOrigin_url());
                    intent.putExtra("jump_type", a.this.f4624a.getData().getJump_type());
                    intent.putExtra("dissmiss_time", a.this.f4624a.getData().getActivity_dismiss_time());
                    intent.addFlags(268435456);
                    a.this.f4625b.startService(intent);
                    return;
                }
                if ("4".equals(a.this.f4624a.getData().getAuto_open_coupon())) {
                    Intent intent2 = new Intent(a.this.f4625b, (Class<?>) WebViewService.class);
                    intent2.putExtra("url", a.this.f4624a.getData().getOrigin_url());
                    intent2.putExtra("shortLink", a.this.f4624a.getData().getTkl_turn_url());
                    a.this.f4625b.startService(intent2);
                    return;
                }
                if ("6".equals(a.this.f4624a.getData().getAuto_open_coupon())) {
                    a aVar5 = a.this;
                    b bVar2 = aVar5.f4626c;
                    if (bVar2 != null) {
                        bVar2.a(aVar5.f4624a);
                        return;
                    }
                    return;
                }
                if (AMPSConstants.ChannelName.CHANNEL_NAME_ASNP.equals(a.this.f4624a.getData().getAuto_open_coupon())) {
                    c2.a(h4.f4622c, "couponCountDown showFloatWindow 8888");
                    a.this.f4624a.getData().setPackage_name(n.c().U);
                    a aVar6 = a.this;
                    b bVar3 = aVar6.f4626c;
                    if (bVar3 != null) {
                        bVar3.a(aVar6.f4624a);
                    }
                }
            }
        }

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
        }

        public a(AccessiblityModel accessiblityModel, AccessibilityService accessibilityService, b bVar) {
            this.f4624a = accessiblityModel;
            this.f4625b = accessibilityService;
            this.f4626c = bVar;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            try {
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0080a(), 0L);
            } catch (Throwable th) {
                c2.a(h4.f4622c, "couponCountDown e =" + th.getMessage());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a(AccessiblityModel accessiblityModel);
    }

    public void b(Context context, AccessiblityModel accessiblityModel) {
        if (accessiblityModel == null || TextUtils.isEmpty(accessiblityModel.getData().getSpop_deeplink()) || TextUtils.isEmpty(accessiblityModel.getData().getSpop_link()) || TextUtils.isEmpty(accessiblityModel.getData().getPackage_name())) {
            return;
        }
        l2.b().a("clickcoupon_" + accessiblityModel.getData().getPackage_name());
        if ("1".equals(accessiblityModel.getData().getTo_loading())) {
            try {
                b();
                Intent intent = new Intent(context, (Class<?>) SeedingLoadingActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("link", accessiblityModel.getData().getSpop_link());
                intent.putExtra("packagename", accessiblityModel.getData().getPackage_name());
                intent.putExtra("tkl_turn_url", accessiblityModel.getData().getTkl_turn_url());
                intent.putExtra("origin_url", accessiblityModel.getData().getOrigin_url());
                intent.putExtra("pic_type", accessiblityModel.getData().getPic_type());
                intent.putExtra("dissmiss_time", accessiblityModel.getData().getActivity_dismiss_time());
                intent.putExtra("jump_type", accessiblityModel.getData().getJump_type());
                context.startActivity(intent);
                return;
            } catch (Exception unused) {
                a(context, accessiblityModel);
                return;
            }
        }
        if (!"2".equals(accessiblityModel.getData().getTo_loading())) {
            a(context, accessiblityModel);
            return;
        }
        b();
        Intent intent2 = new Intent(context, (Class<?>) ExcessActivity.class);
        intent2.putExtra("password", accessiblityModel.getData().getTkl_turn_url());
        intent2.putExtra("deeplink", accessiblityModel.getData().getSpop_deeplink());
        intent2.putExtra("link", accessiblityModel.getData().getSpop_link());
        intent2.putExtra("time", accessiblityModel.getData().getCoupon_load_time());
        intent2.putExtra(CommonNetImpl.NAME, accessiblityModel.getData().getPackage_name());
        intent2.putExtra("origin_url", accessiblityModel.getData().getOrigin_url());
        intent2.putExtra("dissmiss_time", accessiblityModel.getData().getActivity_dismiss_time());
        intent2.putExtra("jump_type", accessiblityModel.getData().getJump_type());
        intent2.addFlags(268435456);
        context.startActivity(intent2);
    }

    public static h4 c() {
        if (f4621b == null) {
            synchronized (h4.class) {
                try {
                    if (f4621b == null) {
                        f4621b = new h4();
                    }
                } finally {
                }
            }
        }
        return f4621b;
    }

    public void a(Context context, AccessiblityModel accessiblityModel) {
        a(context, accessiblityModel.getData().getSpop_deeplink(), accessiblityModel.getData().getSpop_link(), accessiblityModel.getData().getJump_type());
    }

    public void a(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        if (str3.equals("1")) {
            if (str == null || str2 == null) {
                return;
            }
            try {
                a(context, str, str2);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        try {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.addFlags(268435456);
                context.startActivity(intent);
            } catch (Exception unused2) {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent2.addFlags(268435456);
                context.startActivity(intent2);
            }
        } catch (Exception unused3) {
            l2.b().a("open_browser_fail");
        }
    }

    public final void a(Context context, String str, String str2) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, g0.a().a(context));
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = str2;
        req.path = str;
        req.miniprogramType = 0;
        createWXAPI.sendReq(req);
    }

    public void a(AccessibilityService accessibilityService, AccessiblityModel accessiblityModel, String str, b bVar) {
        c2.a(f4622c, "couponCountDown ");
        TimerTask timerTask = this.f4623a;
        if (timerTask != null) {
            timerTask.cancel();
            this.f4623a = null;
        }
        if (!TextUtils.isEmpty(accessiblityModel.getData().getSpop_describe())) {
            d.d().a(accessibilityService, accessiblityModel.getData().getSpop_describe());
        }
        c2.a(f4622c, "currenttime 1=" + System.currentTimeMillis());
        this.f4623a = m0.a().b(accessiblityModel.getData().getShow_coupon_time(), 200, new a(accessiblityModel, accessibilityService, bVar));
    }

    public void b() {
        List<WeakReference<Activity>> list = o.f4969m;
        for (int size = list.size() - 1; size >= 0; size--) {
            Activity activity = list.get(size).get();
            if (activity != null) {
                activity.finish();
                list.remove(size);
            }
        }
    }
}
