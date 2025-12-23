package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUNovelAd;
import com.baidu.mobads.sdk.api.CPUWebAdRequestParam;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class cy extends bj {
    public static final String A = "pre_chapter_adstart_countdown";
    public static final String B = "try_get_cuid";
    private static final String J = "cy";

    /* renamed from: a, reason: collision with root package name */
    public static final String f10976a = "enter_refresh_bookstore";

    /* renamed from: t, reason: collision with root package name */
    public static final String f10977t = "enter_reader";

    /* renamed from: u, reason: collision with root package name */
    public static final String f10978u = "notify_impression";

    /* renamed from: v, reason: collision with root package name */
    public static final String f10979v = "request_int_ad_view";

    /* renamed from: w, reason: collision with root package name */
    public static final String f10980w = "request_banner_ad_view";

    /* renamed from: x, reason: collision with root package name */
    public static final String f10981x = "request_bookstore_bottom_view";

    /* renamed from: y, reason: collision with root package name */
    public static final String f10982y = "request_shelf_ad_view";

    /* renamed from: z, reason: collision with root package name */
    public static final String f10983z = "reader_background_status_change";
    public HashMap<String, Object> C;
    public String D;
    public int E;
    public int F;
    public int G;
    public int H;
    public String I;
    private CPUNovelAd.CpuNovelListener K;
    private SoftReference<RelativeLayout> L;

    public void e() {
        ao.a(this.E);
        ao.b(this.F);
        ao.a(new db(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("adInnerPageInterval");
            Object obj2 = map.get("adBottomRefreshInterval");
            Object obj3 = map.get("adFrontChapterInterval");
            Object obj4 = map.get("isShowFeeds");
            Object obj5 = map.get("isAdSwitch");
            Object obj6 = map.get("showCount");
            Object obj7 = map.get("clickCount");
            Object obj8 = map.get("motivateDeeplinkAdSwitch");
            Object obj9 = map.get("motivateDeeplinkAdFrequency");
            Object obj10 = map.get("motivateDeeplinkAdExpTime");
            Object obj11 = map.get("motivateDeeplinkNoAdTime");
            Object obj12 = map.get("isStartRewardAdTimer");
            Object obj13 = map.get("temporaryAdDensitySwitch");
            Object obj14 = map.get("temporaryAdDensityTimes");
            Object obj15 = map.get("temporaryAdDensityScreen");
            if (obj != null && obj2 != null) {
                ao.a(((Integer) obj).intValue());
                ao.b(((Integer) obj2).intValue());
            }
            if ((obj3 instanceof Integer) && (obj4 instanceof Boolean)) {
                ao.a(((Integer) obj3).intValue(), ((Boolean) obj4).booleanValue());
            }
            if (obj5 instanceof Integer) {
                ao.a(((Integer) obj5).intValue() != 0);
            }
            if ((obj6 instanceof Integer) && (obj7 instanceof Integer)) {
                ao.a(((Integer) obj6).intValue(), ((Integer) obj7).intValue());
            }
            if ((obj8 instanceof Boolean) && (obj9 instanceof Integer) && (obj10 instanceof Integer) && (obj11 instanceof Integer)) {
                ao.a(((Boolean) obj8).booleanValue(), ((Integer) obj9).intValue(), ((Integer) obj10).intValue(), ((Integer) obj11).intValue());
            }
            if ((obj12 instanceof Boolean) && ((Boolean) obj12).booleanValue()) {
                ao.h();
            }
            if ((obj13 instanceof Boolean) && ((Boolean) obj13).booleanValue() && (obj14 instanceof Integer) && (obj15 instanceof Integer)) {
                ao.b(((Integer) obj14).intValue(), ((Integer) obj15).intValue());
            } else {
                ao.b(0, 0);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void h(IOAdEvent iOAdEvent) {
        CPUNovelAd.CpuNovelListener cpuNovelListener = this.K;
        if (cpuNovelListener != null) {
            cpuNovelListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public View w() {
        View a6 = ao.a(this.f10729i);
        if (a6 instanceof FrameLayout) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f10729i);
            this.L = new SoftReference<>(relativeLayout);
            relativeLayout.setId(33);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, bb.a(this.f10729i, 53.0f));
            layoutParams.gravity = 80;
            ((FrameLayout) a6).addView(relativeLayout, layoutParams);
            if (bn.a((Context) null).a() >= 18) {
                relativeLayout.getViewTreeObserver().addOnWindowFocusChangeListener(new dc(this, relativeLayout));
            }
        }
        return a6;
    }

    public cy(Context context, String str, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        this.E = 5;
        this.F = 60;
        this.G = 0;
        this.H = 10006;
        this.I = "";
        this.D = str;
        this.C = (HashMap) cPUWebAdRequestParam.getParameters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        ao.b();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        e();
        if (this.f10733m == null) {
            this.f10734n = false;
            return;
        }
        this.f10734n = true;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "novel");
            this.f10733m.createProdHandler(jSONObject);
            m();
            this.f10733m.addEventListener("Update_fbReader_Setting", new cz(this));
            this.f10733m.addEventListener("closeInterstitialAd", new da(this));
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(this.D)) {
                jSONObject2.put("appid", this.D);
            }
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, "novel");
            this.f10733m.loadAd(jSONObject2, m.a(this.C));
        } catch (Throwable th) {
            this.f10731k.c(J, th);
        }
    }

    public Activity f() {
        return ao.c();
    }

    public boolean g() {
        return ao.d();
    }

    public boolean x() {
        return ao.e();
    }

    public void y() {
        ao.g();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void e(IOAdEvent iOAdEvent) {
        CPUNovelAd.CpuNovelListener cpuNovelListener = this.K;
        if (cpuNovelListener != null) {
            cpuNovelListener.onAdImpression();
        }
    }

    public void a(CPUNovelAd.CpuNovelListener cpuNovelListener) {
        this.K = cpuNovelListener;
    }
}
