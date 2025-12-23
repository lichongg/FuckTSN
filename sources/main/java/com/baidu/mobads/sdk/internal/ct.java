package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUWebAdRequestParam;
import com.baidu.mobads.sdk.api.CpuAdView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ct extends bj {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Object> f10965a;

    /* renamed from: t, reason: collision with root package name */
    private int f10966t;

    /* renamed from: u, reason: collision with root package name */
    private RelativeLayout f10967u;

    /* renamed from: v, reason: collision with root package name */
    private CpuAdView.CpuAdViewInternalStatusListener f10968v;

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void d() {
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f10968v;
        if (cpuAdViewInternalStatusListener != null) {
            cpuAdViewInternalStatusListener.onExitLp();
        }
    }

    public Activity e() {
        return ao.c();
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
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void e(IOAdEvent iOAdEvent) {
        Map<String, Object> data = iOAdEvent.getData();
        Boolean bool = (Boolean) data.get("isImpressionFeAd");
        String str = (String) data.get("nums");
        if (this.f10968v != null && bool != null && bool.booleanValue()) {
            this.f10968v.onAdImpression(str);
            return;
        }
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f10968v;
        if (cpuAdViewInternalStatusListener == null || bool == null) {
            return;
        }
        cpuAdViewInternalStatusListener.onContentImpression(str);
    }

    public ct(Context context, RelativeLayout relativeLayout, String str, int i6, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        this.f10737q = str;
        this.f10967u = relativeLayout;
        this.f10966t = i6;
        if (cPUWebAdRequestParam == null) {
            az.c().e("内容联盟模板需要传入 CPUWebAdRequestParam配置信息");
        } else {
            this.f10965a = (HashMap) cPUWebAdRequestParam.getParameters();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        ao.b();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void d(IOAdEvent iOAdEvent) {
        if (this.f10968v == null || iOAdEvent == null) {
            return;
        }
        this.f10968v.onLpContentStatus(iOAdEvent.getData());
    }

    public boolean f() {
        return ao.d();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void h(IOAdEvent iOAdEvent) {
        Boolean bool = (Boolean) iOAdEvent.getData().get("isClickFeAd");
        if (this.f10968v != null && bool != null && bool.booleanValue()) {
            this.f10968v.onAdClick();
            return;
        }
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f10968v;
        if (cpuAdViewInternalStatusListener != null && bool != null) {
            cpuAdViewInternalStatusListener.onContentClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.f10733m == null) {
            this.f10734n = false;
            return;
        }
        this.f10734n = true;
        JSONObject jSONObject = new JSONObject();
        if (this.f10733m != null) {
            try {
                jSONObject.put("channel", this.f10966t);
                jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu_h5");
                jSONObject.put("timeout", 10000);
                if (!TextUtils.isEmpty(this.f10737q)) {
                    jSONObject.put("appid", this.f10737q);
                }
                if (this.f10967u != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(IAdInterListener.AdReqParam.PROD, "cpu_h5");
                    this.f10733m.createProdHandler(jSONObject2);
                    this.f10733m.setAdContainer(this.f10967u);
                    m();
                    this.f10733m.addEventListener("Update_fbReader_Setting", new cu(this));
                    this.f10733m.addEventListener("closeInterstitialAd", new cv(this));
                    this.f10733m.addEventListener("feOpenFbReader", new cw(this));
                    JSONObject a6 = m.a(this.f10965a);
                    a6.put("isInitNovelSDK", ao.f());
                    this.f10733m.loadAd(jSONObject, a6);
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i6, int i7, String str, int i8, int i9, String str2) {
        ao.a(i6);
        ao.b(i7);
        ao.a(new cx(this, i8, i9, str2));
        ao.a(this.f10729i, str);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(String str, int i6, String str2) {
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f10968v;
        if (cpuAdViewInternalStatusListener != null) {
            cpuAdViewInternalStatusListener.loadDataError(str);
        }
    }

    public void a(CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        this.f10968v = cpuAdViewInternalStatusListener;
    }
}
