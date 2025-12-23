package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.EntryResponse;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XAdEntryResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.internal.g;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class df extends bj {
    private int A;
    private RequestParameters B;
    private boolean C;
    private g.a D;
    private BaiduNativeManager.ExpressAdListener E;
    private BaiduNativeManager.EntryAdListener F;
    private g.b G;
    private int H;
    private int I;
    private int J;

    /* renamed from: a, reason: collision with root package name */
    private List<NativeResponse> f11003a;

    /* renamed from: t, reason: collision with root package name */
    private List<ExpressResponse> f11004t;

    /* renamed from: u, reason: collision with root package name */
    private List<EntryResponse> f11005u;

    /* renamed from: v, reason: collision with root package name */
    private int f11006v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f11007w;

    /* renamed from: x, reason: collision with root package name */
    private String f11008x;

    /* renamed from: y, reason: collision with root package name */
    private String f11009y;

    /* renamed from: z, reason: collision with root package name */
    private int f11010z;

    public void a(g.a aVar) {
        this.D = aVar;
    }

    public void b(Activity activity) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "bindExpressActivity");
            hashMap.put(TTDownloadField.TT_ACTIVITY, activity);
        } catch (JSONException e6) {
            bu.a().a(e6);
        }
        a(jSONObject, hashMap);
    }

    public void c(boolean z5) {
        this.C = z5;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void d() {
        g.a aVar = this.D;
        if (aVar != null) {
            aVar.a();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.E;
        if (expressAdListener != null) {
            expressAdListener.onLpClosed();
            return;
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.F;
        if (entryAdListener != null) {
            entryAdListener.onLpClosed();
        }
    }

    public String e() {
        return this.f11008x;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void f(IOAdEvent iOAdEvent) {
        if (iOAdEvent == null) {
            return;
        }
        Map<String, Object> data = iOAdEvent.getData();
        int i6 = 0;
        if (this.D != null && data != null && this.f11003a != null) {
            String str = (String) data.get("instanceInfo");
            while (i6 < this.f11003a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f11003a.get(i6);
                if (xAdNativeResponse != null && xAdNativeResponse.getUniqueId().equals(str)) {
                    this.D.a(xAdNativeResponse, Integer.parseInt((String) data.get("showState")));
                }
                i6++;
            }
            return;
        }
        if (this.F == null || data == null || this.f11005u == null) {
            return;
        }
        String str2 = (String) data.get("instanceInfo");
        while (i6 < this.f11005u.size()) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f11005u.get(i6);
            if (xAdEntryResponse != null && xAdEntryResponse.getUniqueId().equals(str2)) {
                xAdEntryResponse.onADExposureFailed(Integer.parseInt((String) data.get("showState")));
            }
            i6++;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void g(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        int i6 = 0;
        if (this.E != null && this.f11004t != null) {
            while (i6 < this.f11004t.size()) {
                br brVar = (br) this.f11004t.get(i6);
                if (TextUtils.equals(brVar.a(), str)) {
                    brVar.a(brVar);
                }
                i6++;
            }
            return;
        }
        if (this.f11003a != null) {
            while (i6 < this.f11003a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f11003a.get(i6);
                if (TextUtils.equals(xAdNativeResponse.getUniqueId(), str)) {
                    xAdNativeResponse.onAdClose(xAdNativeResponse);
                }
                i6++;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void j(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.E == null || iOAdEvent == null || this.f11004t == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        View view = (View) data.get("expressView");
        int intValue = ((Integer) data.get("error_code")).intValue();
        String str2 = (String) data.get("error_message");
        for (int i6 = 0; i6 < this.f11004t.size(); i6++) {
            br brVar = (br) this.f11004t.get(i6);
            if (TextUtils.equals(brVar.a(), str)) {
                brVar.a(view, str2, intValue);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void k(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || this.f11003a == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        String str2 = (String) data.get("type");
        for (int i6 = 0; i6 < this.f11003a.size(); i6++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f11003a.get(i6);
            if (TextUtils.equals(xAdNativeResponse.getUniqueId(), str)) {
                if (TextUtils.equals("dismiss", str2)) {
                    xAdNativeResponse.onShakeViewDismiss();
                } else if (TextUtils.equals("coupon_float_dismiss", str2)) {
                    xAdNativeResponse.onCouponFloatDismiss();
                }
            }
        }
    }

    public void a(BaiduNativeManager.ExpressAdListener expressAdListener) {
        this.E = expressAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void c(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        String str2 = (String) data.get("type");
        int i6 = 0;
        if (this.E != null && this.f11004t != null) {
            while (i6 < this.f11004t.size()) {
                br brVar = (br) this.f11004t.get(i6);
                if (TextUtils.equals(brVar.a(), str)) {
                    if (TextUtils.equals(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW, str2)) {
                        brVar.d();
                    } else if (TextUtils.equals(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK, str2)) {
                        Object obj = data.get(MediationConstant.KEY_REASON);
                        brVar.b(obj instanceof String ? (String) obj : "");
                    } else if (TextUtils.equals("close", str2)) {
                        brVar.e();
                    }
                }
                i6++;
            }
            return;
        }
        if (this.f11003a != null) {
            while (i6 < this.f11003a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f11003a.get(i6);
                if (TextUtils.equals(xAdNativeResponse.getUniqueId(), str)) {
                    if (TextUtils.equals(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW, str2)) {
                        xAdNativeResponse.onDislikeShow();
                    } else if (TextUtils.equals(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK, str2)) {
                        Object obj2 = data.get(MediationConstant.KEY_REASON);
                        xAdNativeResponse.onDislikeClick(obj2 instanceof String ? (String) obj2 : "");
                    } else if (TextUtils.equals("close", str2)) {
                        xAdNativeResponse.onDislikeClose();
                    }
                }
                i6++;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void e(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        int i6 = 0;
        if (this.D != null && !TextUtils.isEmpty(message) && this.f11003a != null) {
            while (i6 < this.f11003a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f11003a.get(i6);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.D.a(xAdNativeResponse);
                }
                i6++;
            }
            return;
        }
        if (this.E != null && !TextUtils.isEmpty(message) && this.f11004t != null) {
            while (i6 < this.f11004t.size()) {
                br brVar = (br) this.f11004t.get(i6);
                if (TextUtils.equals(message, brVar.a())) {
                    brVar.c();
                }
                i6++;
            }
            return;
        }
        if (this.F == null || TextUtils.isEmpty(message) || this.f11005u == null) {
            return;
        }
        while (i6 < this.f11005u.size()) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f11005u.get(i6);
            if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onADExposed();
            }
            i6++;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void i(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.E == null || iOAdEvent == null || this.f11004t == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        View view = (View) data.get("expressView");
        int intValue = ((Integer) data.get("viewWidth")).intValue();
        int intValue2 = ((Integer) data.get("viewHeight")).intValue();
        for (int i6 = 0; i6 < this.f11004t.size(); i6++) {
            br brVar = (br) this.f11004t.get(i6);
            if (TextUtils.equals(brVar.a(), str)) {
                brVar.a(view, intValue, intValue2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0076, code lost:
    
        if (com.baidu.mobads.sdk.internal.bv.a(r16.f10729i, r9) != false) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00aa  */
    @Override // com.baidu.mobads.sdk.internal.bj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void q() {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.df.q():void");
    }

    public df(Context context, String str, String str2, boolean z5, int i6) {
        super(context);
        this.C = false;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.f11009y = str;
        this.f11008x = str2;
        this.f11007w = z5;
        this.f11006v = i6;
        this.f11010z = 600;
        this.A = 500;
    }

    public void a(BaiduNativeManager.EntryAdListener entryAdListener) {
        this.F = entryAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void h(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        int i6 = 0;
        if (this.D != null && !TextUtils.isEmpty(message) && this.f11003a != null) {
            while (i6 < this.f11003a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f11003a.get(i6);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.D.b(xAdNativeResponse);
                }
                i6++;
            }
            return;
        }
        if (this.E != null && !TextUtils.isEmpty(message) && this.f11004t != null) {
            while (i6 < this.f11004t.size()) {
                br brVar = (br) this.f11004t.get(i6);
                if (TextUtils.equals(message, brVar.a())) {
                    brVar.b();
                }
                i6++;
            }
            return;
        }
        if (this.F != null && !TextUtils.isEmpty(message) && this.f11005u != null) {
            while (i6 < this.f11005u.size()) {
                XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f11005u.get(i6);
                if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                    xAdEntryResponse.onAdClick();
                }
                i6++;
            }
        }
    }

    public void a(g.b bVar) {
        this.G = bVar;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        IAdInterListener iAdInterListener = this.f10733m;
        if (iAdInterListener == null) {
            this.f10734n = false;
        } else {
            this.f10734n = true;
            iAdInterListener.loadAd(j(), k());
        }
    }

    public void b(ViewGroup viewGroup, a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "destroyExpressView");
            jSONObject.put("uniqueId", aVar.I());
            hashMap.put("container", viewGroup);
        } catch (JSONException e6) {
            bu.a().a(e6);
        }
        a(jSONObject, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void d(String str) {
        if (!TextUtils.isEmpty(str) && this.f11003a != null) {
            for (int i6 = 0; i6 < this.f11003a.size(); i6++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f11003a.get(i6);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdUnionClick();
                }
            }
        }
        if (!TextUtils.isEmpty(str) && this.f11004t != null) {
            for (int i7 = 0; i7 < this.f11004t.size(); i7++) {
                br brVar = (br) this.f11004t.get(i7);
                if (TextUtils.equals(str, brVar.a())) {
                    brVar.f();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f11005u == null) {
            return;
        }
        for (int i8 = 0; i8 < this.f11005u.size(); i8++) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f11005u.get(i8);
            if (TextUtils.equals(str, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onAdUnionClick();
            }
        }
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.f11010z = width;
            this.A = height;
        }
        this.B = requestParameters;
        a(requestParameters.getExtras());
        c(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject j() {
        this.f10739s = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.f11008x);
            this.f10733m.createProdHandler(jSONObject2);
            this.f10733m.setAdContainer(this.f10728h);
            m();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.f11008x);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f11009y);
            if (cr.a().b()) {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.f10737q)) {
                jSONObject.put("appid", this.f10737q);
            }
            if ("video".equals(this.f11008x)) {
                jSONObject.put("at", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
                jSONObject.put(IAdInterListener.AdReqParam.MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png");
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,NMON");
            } else {
                jSONObject.put("at", "2");
            }
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.f11010z);
            jSONObject.put("h", "" + this.A);
            jSONObject.put("msa", 143);
            jSONObject = m.a(jSONObject, b(this.f10735o));
            jSONObject.put("opt", this.H);
            if (this.H == 0) {
                jSONObject.put("optn", 1);
            }
            b(jSONObject);
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.f11006v);
            jSONObject.put("isCacheVideo", this.f11007w);
            jSONObject.put("cacheVideoOnlyWifi", this.C);
            RequestParameters requestParameters = this.B;
            jSONObject.put("appConfirmPolicy", requestParameters == null ? 1 : requestParameters.getAPPConfirmPolicy());
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    public String g() {
        return this.f11009y;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b(IOAdEvent iOAdEvent) {
        if (this.G == null || iOAdEvent == null || this.f11003a == null) {
            return;
        }
        String message = iOAdEvent.getMessage();
        for (int i6 = 0; i6 < this.f11003a.size(); i6++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f11003a.get(i6);
            if (xAdNativeResponse.getUniqueId().equals(message)) {
                this.G.a(xAdNativeResponse);
            }
        }
    }

    public void a(int i6) {
        this.H = i6;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void f(String str) {
        if (!TextUtils.isEmpty(str) && this.f11003a != null) {
            for (int i6 = 0; i6 < this.f11003a.size(); i6++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f11003a.get(i6);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADFunctionClick();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f11004t == null) {
            return;
        }
        for (int i7 = 0; i7 < this.f11004t.size(); i7++) {
            br brVar = (br) this.f11004t.get(i7);
            if (TextUtils.equals(str, brVar.a())) {
                brVar.h();
            }
        }
    }

    public void a(int i6, int i7) {
        this.I = i6;
        this.J = i7;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void e(String str) {
        if (!TextUtils.isEmpty(str) && this.f11003a != null) {
            for (int i6 = 0; i6 < this.f11003a.size(); i6++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f11003a.get(i6);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPrivacyClick();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f11004t == null) {
            return;
        }
        for (int i7 = 0; i7 < this.f11004t.size(); i7++) {
            br brVar = (br) this.f11004t.get(i7);
            if (TextUtils.equals(str, brVar.a())) {
                brVar.g();
            }
        }
    }

    public ViewGroup a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "initExpressContainer");
            jSONObject.put("uniqueId", aVar.I());
        } catch (JSONException e6) {
            bu.a().a(e6);
        }
        a(jSONObject, hashMap);
        Object obj = hashMap.get("container");
        if (obj instanceof ViewGroup) {
            return (ViewGroup) obj;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b() {
        g.a aVar = this.D;
        if (aVar != null) {
            aVar.b();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.E;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b(String str, boolean z5) {
        if (!TextUtils.isEmpty(str) && this.f11003a != null) {
            for (int i6 = 0; i6 < this.f11003a.size(); i6++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f11003a.get(i6);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdDownloadWindow(z5);
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f11004t == null) {
            return;
        }
        for (int i7 = 0; i7 < this.f11004t.size(); i7++) {
            br brVar = (br) this.f11004t.get(i7);
            if (TextUtils.equals(str, brVar.a())) {
                brVar.b(z5);
            }
        }
    }

    public RequestParameters f() {
        return this.B;
    }

    public void a(ViewGroup viewGroup, a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "renderExpressView");
            jSONObject.put("uniqueId", aVar.I());
            hashMap.put(IAdInterListener.AdReqParam.WIDTH, Integer.valueOf(this.I));
            hashMap.put("h", Integer.valueOf(this.J));
            hashMap.put("container", viewGroup);
        } catch (JSONException e6) {
            bu.a().a(e6);
        }
        a(jSONObject, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void c() {
        g.a aVar = this.D;
        if (aVar != null) {
            aVar.c();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.E;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadFailed();
        }
    }

    public void c(Map<String, String> map) {
        try {
            HashMap<String, String> a6 = m.a(map);
            if (this.f10735o == null) {
                this.f10735o = new HashMap<>();
            }
            if (a6.isEmpty()) {
                return;
            }
            for (String str : a6.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    String str2 = a6.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        this.f10735o.put(str, str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean a(View view, a aVar, int i6) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "switchTheme");
            hashMap.put("view", view);
            hashMap.put("code", Integer.valueOf(i6));
        } catch (JSONException e6) {
            bu.a().a(e6);
        }
        a(jSONObject, hashMap);
        Object obj = hashMap.get("result");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(String str, int i6, String str2) {
        if (this.D != null) {
            XAdNativeResponse xAdNativeResponse = new XAdNativeResponse(this.f10729i, this, null);
            xAdNativeResponse.setNoAdUniqueId(str2);
            this.D.b(i6, str, xAdNativeResponse);
        }
        if (this.E != null) {
            br brVar = new br(this.f10729i, this, null);
            brVar.a(str2);
            this.E.onNativeFail(i6, str, brVar);
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.F;
        if (entryAdListener != null) {
            entryAdListener.onNativeFail(i6, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(int i6, String str, String str2) {
        if (this.D != null) {
            XAdNativeResponse xAdNativeResponse = new XAdNativeResponse(this.f10729i, this, null);
            xAdNativeResponse.setNoAdUniqueId(str2);
            this.D.a(i6, str, xAdNativeResponse);
        }
        if (this.E != null) {
            br brVar = new br(this.f10729i, this, null);
            brVar.a(str2);
            this.E.onNoAd(i6, str, brVar);
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.F;
        if (entryAdListener != null) {
            entryAdListener.onNoAd(i6, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(String str, boolean z5) {
        if (!TextUtils.isEmpty(str) && this.f11003a != null) {
            for (int i6 = 0; i6 < this.f11003a.size(); i6++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f11003a.get(i6);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPermissionShow(z5);
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f11004t == null) {
            return;
        }
        for (int i7 = 0; i7 < this.f11004t.size(); i7++) {
            br brVar = (br) this.f11004t.get(i7);
            if (TextUtils.equals(str, brVar.a())) {
                brVar.a(z5);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(Map<String, String> map) {
        int length;
        if (map == null || map.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap(map);
        HashMap<String, String> hashMap2 = new HashMap<>();
        int i6 = 0;
        for (String str : ArticleInfo.PREDEFINED_KEYS) {
            if (hashMap.containsKey(str)) {
                String str2 = (String) hashMap.remove(str);
                if (!TextUtils.isEmpty(str2) && (length = str2.length() + i6) < 150) {
                    hashMap2.put(str, str2);
                    i6 = length;
                }
            }
        }
        if (!hashMap.isEmpty()) {
            for (String str3 : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = (String) hashMap.get(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        int length2 = i6 + str3.length() + str4.length();
                        if (length2 >= 150) {
                            break;
                        }
                        hashMap2.put("c_" + str3, str4);
                        i6 = length2 + 2;
                    } else {
                        continue;
                    }
                }
            }
        }
        this.f10735o = hashMap2;
    }
}
