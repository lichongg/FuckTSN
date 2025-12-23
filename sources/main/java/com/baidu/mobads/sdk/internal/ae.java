package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.NativeCPUAdData;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ae extends bj {

    /* renamed from: a, reason: collision with root package name */
    public static final int f10561a = 17;

    /* renamed from: t, reason: collision with root package name */
    private static final String f10562t = "javascript:";
    private NativeCPUManager.CPUAdListener A;
    private NativeCPUManager B;
    private int C;
    private int D;
    private boolean E;
    private String F;

    /* renamed from: u, reason: collision with root package name */
    private int f10563u;

    /* renamed from: v, reason: collision with root package name */
    private int f10564v;

    /* renamed from: w, reason: collision with root package name */
    private int[] f10565w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f10566x;

    /* renamed from: y, reason: collision with root package name */
    private int f10567y;

    /* renamed from: z, reason: collision with root package name */
    private HashMap<String, Object> f10568z;

    public ae(Context context) {
        super(context);
        this.C = 5;
        this.D = 60;
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
    protected void d() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.A;
        if (cPUAdListener != null) {
            cPUAdListener.onExitLp();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b(IOAdEvent iOAdEvent) {
        notifyObservers(iOAdEvent);
        setChanged();
    }

    public void e() {
        ao.a(this.C);
        ao.b(this.D);
        ao.a(new aj(this));
    }

    private String j(String str) {
        IXAdContainerFactory c6;
        aa a6 = aa.a();
        if (a6 != null && (c6 = a6.c()) != null) {
            Object remoteParam = c6.getRemoteParam(str, new Object[0]);
            if (remoteParam instanceof String) {
                return (String) remoteParam;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        ao.b();
    }

    public void a(NativeCPUManager.CPUAdListener cPUAdListener) {
        this.A = cPUAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void d(IOAdEvent iOAdEvent) {
        try {
            if (this.A == null || iOAdEvent == null) {
                return;
            }
            HashMap<String, Object> hashMap = (HashMap) iOAdEvent.getData();
            this.A.onLpCustomEventCallBack(hashMap, new ah(this, hashMap.get(TTDownloadField.TT_ACTIVITY)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Activity f() {
        return ao.c();
    }

    public boolean g() {
        return ao.d();
    }

    public ae(Context context, String str, NativeCPUManager nativeCPUManager) {
        super(context);
        this.C = 5;
        this.D = 60;
        this.f10737q = str;
        this.B = nativeCPUManager;
    }

    public void a(int i6, int i7, int[] iArr, boolean z5, HashMap<String, Object> hashMap) {
        this.f10564v = i6;
        this.f10563u = i7;
        this.f10565w = iArr;
        this.f10566x = z5;
        this.f10568z = hashMap;
        this.E = ao.f();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.A;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadSuccess();
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
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, "cpu");
            this.f10733m.createProdHandler(jSONObject3);
            m();
            this.f10733m.addEventListener("Update_fbReader_Setting", new af(this));
            this.f10733m.addEventListener("closeInterstitialAd", new ag(this));
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu");
            jSONObject.put("appsid", this.f10737q);
            jSONObject.put("pageIndex", this.f10564v);
            jSONObject.put("pageSize", this.f10563u);
            jSONObject.put("channels", this.f10565w);
            jSONObject.put("showAd", this.f10566x);
            jSONObject.put("openActivitylink", this.F);
            if (!TextUtils.isEmpty(this.f10737q)) {
                jSONObject.put("appid", this.f10737q);
            }
            jSONObject2.put("timeout", this.f10567y);
            HashMap<String, Object> hashMap = this.f10568z;
            if (hashMap == null || hashMap.isEmpty()) {
                az.c().e("内容联盟元素需要传入 CPUAdRequest配置信息");
            }
            jSONObject2 = m.a(this.f10568z);
            if (jSONObject2 != null) {
                jSONObject2.put("isInitNovelSDK", this.E);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f10733m.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void c() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.A;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void c(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            Map<String, Object> data = iOAdEvent.getData();
            Integer num = (Integer) data.get("position");
            String str = (String) data.get("mislikereason");
            NativeCPUManager.CPUAdListener cPUAdListener = this.A;
            if (cPUAdListener == null || num == null || str == null) {
                return;
            }
            cPUAdListener.onDisLikeAdClick(num.intValue(), str);
        }
    }

    public void a(int i6) {
        this.f10567y = i6;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(IOAdEvent iOAdEvent) {
        if (this.A != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) iOAdEvent.getData().get("cpuAdList")).iterator();
            while (it.hasNext()) {
                NativeCPUAdData nativeCPUAdData = new NativeCPUAdData(this.f10729i, it.next(), this.f10568z);
                arrayList.add(nativeCPUAdData);
                addObserver(nativeCPUAdData);
            }
            this.A.onAdLoaded(arrayList);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(String str, int i6, String str2) {
        super.a(str, i6, str2);
        NativeCPUManager.CPUAdListener cPUAdListener = this.A;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i6);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(int i6, String str, String str2) {
        super.a(i6, str, str2);
        NativeCPUManager.CPUAdListener cPUAdListener = this.A;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i6);
        }
    }

    protected void a(WebView webView, JSONObject jSONObject) {
        bj.a(new ai(this, jSONObject, webView));
    }

    public void a(String str) {
        this.F = str;
    }
}
